package okhttp3.internal.http2;

import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import okhttp3.internal.Util;
import okhttp3.internal.http2.Hpack;
import okio.Buffer;
import okio.BufferedSink;

/* loaded from: classes5.dex */
final class Http2Writer implements Closeable {
    private static final Logger logger = Logger.getLogger(Http2.class.getName());
    private final boolean client;
    private boolean closed;
    private final Buffer hpackBuffer;
    final Hpack.Writer hpackWriter;
    private int maxFrameSize;
    private final BufferedSink sink;

    Http2Writer(BufferedSink bufferedSink, boolean z) {
        this.sink = bufferedSink;
        this.client = z;
        Buffer buffer = new Buffer();
        this.hpackBuffer = buffer;
        this.hpackWriter = new Hpack.Writer(buffer);
        this.maxFrameSize = 16384;
    }

    private void writeContinuationFrames(int i2, long j2) throws IOException {
        while (j2 > 0) {
            int min = (int) Math.min(this.maxFrameSize, j2);
            long j3 = min;
            j2 -= j3;
            frameHeader(i2, min, (byte) 9, j2 == 0 ? (byte) 4 : (byte) 0);
            this.sink.write(this.hpackBuffer, j3);
        }
    }

    private static void writeMedium(BufferedSink bufferedSink, int i2) throws IOException {
        bufferedSink.writeByte((i2 >>> 16) & 255);
        bufferedSink.writeByte((i2 >>> 8) & 255);
        bufferedSink.writeByte(i2 & 255);
    }

    public synchronized void applyAndAckSettings(Settings settings) throws IOException {
        if (this.closed) {
            throw new IOException("closed");
        }
        this.maxFrameSize = settings.getMaxFrameSize(this.maxFrameSize);
        if (settings.getHeaderTableSize() != -1) {
            this.hpackWriter.setHeaderTableSizeSetting(settings.getHeaderTableSize());
        }
        frameHeader(0, 0, (byte) 4, (byte) 1);
        this.sink.flush();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        this.closed = true;
        this.sink.close();
    }

    public synchronized void connectionPreface() throws IOException {
        if (this.closed) {
            throw new IOException("closed");
        }
        if (this.client) {
            Logger logger2 = logger;
            if (logger2.isLoggable(Level.FINE)) {
                logger2.fine(Util.format(">> CONNECTION %s", Http2.CONNECTION_PREFACE.hex()));
            }
            this.sink.write(Http2.CONNECTION_PREFACE.toByteArray());
            this.sink.flush();
        }
    }

    public synchronized void data(boolean z, int i2, Buffer buffer, int i3) throws IOException {
        if (this.closed) {
            throw new IOException("closed");
        }
        dataFrame(i2, z ? (byte) 1 : (byte) 0, buffer, i3);
    }

    void dataFrame(int i2, byte b2, Buffer buffer, int i3) throws IOException {
        frameHeader(i2, i3, (byte) 0, b2);
        if (i3 > 0) {
            this.sink.write(buffer, i3);
        }
    }

    public synchronized void flush() throws IOException {
        if (this.closed) {
            throw new IOException("closed");
        }
        this.sink.flush();
    }

    public void frameHeader(int i2, int i3, byte b2, byte b3) throws IOException {
        Logger logger2 = logger;
        if (logger2.isLoggable(Level.FINE)) {
            logger2.fine(Http2.frameLog(false, i2, i3, b2, b3));
        }
        int i4 = this.maxFrameSize;
        if (i3 > i4) {
            throw Http2.illegalArgument("FRAME_SIZE_ERROR length > %d: %d", Integer.valueOf(i4), Integer.valueOf(i3));
        }
        if ((Integer.MIN_VALUE & i2) != 0) {
            throw Http2.illegalArgument("reserved bit set: %s", Integer.valueOf(i2));
        }
        writeMedium(this.sink, i3);
        this.sink.writeByte(b2 & 255);
        this.sink.writeByte(b3 & 255);
        this.sink.writeInt(i2 & Integer.MAX_VALUE);
    }

    public synchronized void goAway(int i2, ErrorCode errorCode, byte[] bArr) throws IOException {
        if (this.closed) {
            throw new IOException("closed");
        }
        if (errorCode.httpCode == -1) {
            throw Http2.illegalArgument("errorCode.httpCode == -1", new Object[0]);
        }
        frameHeader(0, bArr.length + 8, (byte) 7, (byte) 0);
        this.sink.writeInt(i2);
        this.sink.writeInt(errorCode.httpCode);
        if (bArr.length > 0) {
            this.sink.write(bArr);
        }
        this.sink.flush();
    }

    public synchronized void headers(int i2, List<Header> list) throws IOException {
        if (this.closed) {
            throw new IOException("closed");
        }
        headers(false, i2, list);
    }

    public int maxDataLength() {
        return this.maxFrameSize;
    }

    public synchronized void ping(boolean z, int i2, int i3) throws IOException {
        if (this.closed) {
            throw new IOException("closed");
        }
        frameHeader(0, 8, (byte) 6, z ? (byte) 1 : (byte) 0);
        this.sink.writeInt(i2);
        this.sink.writeInt(i3);
        this.sink.flush();
    }

    public synchronized void pushPromise(int i2, int i3, List<Header> list) throws IOException {
        if (this.closed) {
            throw new IOException("closed");
        }
        this.hpackWriter.writeHeaders(list);
        long size = this.hpackBuffer.size();
        int min = (int) Math.min(this.maxFrameSize - 4, size);
        long j2 = min;
        frameHeader(i2, min + 4, (byte) 5, size == j2 ? (byte) 4 : (byte) 0);
        this.sink.writeInt(i3 & Integer.MAX_VALUE);
        this.sink.write(this.hpackBuffer, j2);
        if (size > j2) {
            writeContinuationFrames(i2, size - j2);
        }
    }

    public synchronized void rstStream(int i2, ErrorCode errorCode) throws IOException {
        if (this.closed) {
            throw new IOException("closed");
        }
        if (errorCode.httpCode == -1) {
            throw new IllegalArgumentException();
        }
        frameHeader(i2, 4, (byte) 3, (byte) 0);
        this.sink.writeInt(errorCode.httpCode);
        this.sink.flush();
    }

    public synchronized void settings(Settings settings) throws IOException {
        if (this.closed) {
            throw new IOException("closed");
        }
        int i2 = 0;
        frameHeader(0, settings.size() * 6, (byte) 4, (byte) 0);
        while (i2 < 10) {
            if (settings.isSet(i2)) {
                this.sink.writeShort(i2 == 4 ? 3 : i2 == 7 ? 4 : i2);
                this.sink.writeInt(settings.get(i2));
            }
            i2++;
        }
        this.sink.flush();
    }

    public synchronized void synReply(boolean z, int i2, List<Header> list) throws IOException {
        if (this.closed) {
            throw new IOException("closed");
        }
        headers(z, i2, list);
    }

    public synchronized void synStream(boolean z, int i2, int i3, List<Header> list) throws IOException {
        if (this.closed) {
            throw new IOException("closed");
        }
        headers(z, i2, list);
    }

    public synchronized void windowUpdate(int i2, long j2) throws IOException {
        if (this.closed) {
            throw new IOException("closed");
        }
        if (j2 == 0 || j2 > 2147483647L) {
            throw Http2.illegalArgument("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: %s", Long.valueOf(j2));
        }
        frameHeader(i2, 4, (byte) 8, (byte) 0);
        this.sink.writeInt((int) j2);
        this.sink.flush();
    }

    void headers(boolean z, int i2, List<Header> list) throws IOException {
        if (!this.closed) {
            this.hpackWriter.writeHeaders(list);
            long size = this.hpackBuffer.size();
            int min = (int) Math.min(this.maxFrameSize, size);
            long j2 = min;
            byte b2 = size == j2 ? (byte) 4 : (byte) 0;
            if (z) {
                b2 = (byte) (b2 | 1);
            }
            frameHeader(i2, min, (byte) 1, b2);
            this.sink.write(this.hpackBuffer, j2);
            if (size > j2) {
                writeContinuationFrames(i2, size - j2);
                return;
            }
            return;
        }
        throw new IOException("closed");
    }
}
