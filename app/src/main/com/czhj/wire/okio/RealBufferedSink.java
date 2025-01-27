package com.czhj.wire.okio;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.EOFException;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;

/* loaded from: classes2.dex */
final class RealBufferedSink implements BufferedSink {

    /* renamed from: a */
    public boolean f8944a;
    public final Buffer buffer = new Buffer();
    public final Sink sink;

    /* renamed from: com.czhj.wire.okio.RealBufferedSink$1 */
    public class AnonymousClass1 extends OutputStream {
        public AnonymousClass1() {
        }

        @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            RealBufferedSink.this.close();
        }

        @Override // java.io.OutputStream, java.io.Flushable
        public void flush() throws IOException {
            RealBufferedSink realBufferedSink = RealBufferedSink.this;
            if (realBufferedSink.f8944a) {
                return;
            }
            realBufferedSink.flush();
        }

        public String toString() {
            return RealBufferedSink.this + ".outputStream()";
        }

        @Override // java.io.OutputStream
        public void write(int i10) throws IOException {
            RealBufferedSink realBufferedSink = RealBufferedSink.this;
            if (realBufferedSink.f8944a) {
                throw new IOException("closed");
            }
            realBufferedSink.buffer.writeByte((int) ((byte) i10));
            RealBufferedSink.this.emitCompleteSegments();
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i10, int i11) throws IOException {
            RealBufferedSink realBufferedSink = RealBufferedSink.this;
            if (realBufferedSink.f8944a) {
                throw new IOException("closed");
            }
            realBufferedSink.buffer.write(bArr, i10, i11);
            RealBufferedSink.this.emitCompleteSegments();
        }
    }

    public RealBufferedSink(Sink sink) {
        if (sink == null) {
            throw new IllegalArgumentException("sink == null");
        }
        this.sink = sink;
    }

    @Override // com.czhj.wire.okio.BufferedSink
    public Buffer buffer() {
        return this.buffer;
    }

    @Override // com.czhj.wire.okio.Sink, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.f8944a) {
            return;
        }
        try {
            Buffer buffer = this.buffer;
            long j10 = buffer.f8900b;
            if (j10 > 0) {
                this.sink.write(buffer, j10);
            }
            th = null;
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            this.sink.close();
        } catch (Throwable th3) {
            if (th == null) {
                th = th3;
            }
        }
        this.f8944a = true;
        if (th != null) {
            Util.sneakyRethrow(th);
        }
    }

    @Override // com.czhj.wire.okio.BufferedSink
    public BufferedSink emit() throws IOException {
        if (this.f8944a) {
            throw new IllegalStateException("closed");
        }
        long size = this.buffer.size();
        if (size > 0) {
            this.sink.write(this.buffer, size);
        }
        return this;
    }

    @Override // com.czhj.wire.okio.BufferedSink
    public BufferedSink emitCompleteSegments() throws IOException {
        if (this.f8944a) {
            throw new IllegalStateException("closed");
        }
        long completeSegmentByteCount = this.buffer.completeSegmentByteCount();
        if (completeSegmentByteCount > 0) {
            this.sink.write(this.buffer, completeSegmentByteCount);
        }
        return this;
    }

    @Override // com.czhj.wire.okio.BufferedSink, com.czhj.wire.okio.Sink, java.io.Flushable
    public void flush() throws IOException {
        if (this.f8944a) {
            throw new IllegalStateException("closed");
        }
        Buffer buffer = this.buffer;
        long j10 = buffer.f8900b;
        if (j10 > 0) {
            this.sink.write(buffer, j10);
        }
        this.sink.flush();
    }

    @Override // com.czhj.wire.okio.BufferedSink
    public OutputStream outputStream() {
        return new OutputStream() { // from class: com.czhj.wire.okio.RealBufferedSink.1
            public AnonymousClass1() {
            }

            @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                RealBufferedSink.this.close();
            }

            @Override // java.io.OutputStream, java.io.Flushable
            public void flush() throws IOException {
                RealBufferedSink realBufferedSink = RealBufferedSink.this;
                if (realBufferedSink.f8944a) {
                    return;
                }
                realBufferedSink.flush();
            }

            public String toString() {
                return RealBufferedSink.this + ".outputStream()";
            }

            @Override // java.io.OutputStream
            public void write(int i10) throws IOException {
                RealBufferedSink realBufferedSink = RealBufferedSink.this;
                if (realBufferedSink.f8944a) {
                    throw new IOException("closed");
                }
                realBufferedSink.buffer.writeByte((int) ((byte) i10));
                RealBufferedSink.this.emitCompleteSegments();
            }

            @Override // java.io.OutputStream
            public void write(byte[] bArr, int i10, int i11) throws IOException {
                RealBufferedSink realBufferedSink = RealBufferedSink.this;
                if (realBufferedSink.f8944a) {
                    throw new IOException("closed");
                }
                realBufferedSink.buffer.write(bArr, i10, i11);
                RealBufferedSink.this.emitCompleteSegments();
            }
        };
    }

    @Override // com.czhj.wire.okio.Sink
    public Timeout timeout() {
        return this.sink.timeout();
    }

    public String toString() {
        return "buffer(" + this.sink + ")";
    }

    @Override // com.czhj.wire.okio.BufferedSink
    public BufferedSink write(ByteString byteString) throws IOException {
        if (this.f8944a) {
            throw new IllegalStateException("closed");
        }
        this.buffer.write(byteString);
        return emitCompleteSegments();
    }

    @Override // com.czhj.wire.okio.BufferedSink
    public long writeAll(Source source) throws IOException {
        if (source == null) {
            throw new IllegalArgumentException("source == null");
        }
        long j10 = 0;
        while (true) {
            long read = source.read(this.buffer, PlaybackStateCompat.ACTION_PLAY_FROM_URI);
            if (read == -1) {
                return j10;
            }
            j10 += read;
            emitCompleteSegments();
        }
    }

    @Override // com.czhj.wire.okio.BufferedSink
    public BufferedSink writeByte(int i10) throws IOException {
        if (this.f8944a) {
            throw new IllegalStateException("closed");
        }
        this.buffer.writeByte(i10);
        return emitCompleteSegments();
    }

    @Override // com.czhj.wire.okio.BufferedSink
    public BufferedSink writeDecimalLong(long j10) throws IOException {
        if (this.f8944a) {
            throw new IllegalStateException("closed");
        }
        this.buffer.writeDecimalLong(j10);
        return emitCompleteSegments();
    }

    @Override // com.czhj.wire.okio.BufferedSink
    public BufferedSink writeHexadecimalUnsignedLong(long j10) throws IOException {
        if (this.f8944a) {
            throw new IllegalStateException("closed");
        }
        this.buffer.writeHexadecimalUnsignedLong(j10);
        return emitCompleteSegments();
    }

    @Override // com.czhj.wire.okio.BufferedSink
    public BufferedSink writeInt(int i10) throws IOException {
        if (this.f8944a) {
            throw new IllegalStateException("closed");
        }
        this.buffer.writeInt(i10);
        return emitCompleteSegments();
    }

    @Override // com.czhj.wire.okio.BufferedSink
    public BufferedSink writeIntLe(int i10) throws IOException {
        if (this.f8944a) {
            throw new IllegalStateException("closed");
        }
        this.buffer.writeIntLe(i10);
        return emitCompleteSegments();
    }

    @Override // com.czhj.wire.okio.BufferedSink
    public BufferedSink writeLong(long j10) throws IOException {
        if (this.f8944a) {
            throw new IllegalStateException("closed");
        }
        this.buffer.writeLong(j10);
        return emitCompleteSegments();
    }

    @Override // com.czhj.wire.okio.BufferedSink
    public BufferedSink writeLongLe(long j10) throws IOException {
        if (this.f8944a) {
            throw new IllegalStateException("closed");
        }
        this.buffer.writeLongLe(j10);
        return emitCompleteSegments();
    }

    @Override // com.czhj.wire.okio.BufferedSink
    public BufferedSink writeShort(int i10) throws IOException {
        if (this.f8944a) {
            throw new IllegalStateException("closed");
        }
        this.buffer.writeShort(i10);
        return emitCompleteSegments();
    }

    @Override // com.czhj.wire.okio.BufferedSink
    public BufferedSink writeShortLe(int i10) throws IOException {
        if (this.f8944a) {
            throw new IllegalStateException("closed");
        }
        this.buffer.writeShortLe(i10);
        return emitCompleteSegments();
    }

    @Override // com.czhj.wire.okio.BufferedSink
    public BufferedSink writeString(String str, int i10, int i11, Charset charset) throws IOException {
        if (this.f8944a) {
            throw new IllegalStateException("closed");
        }
        this.buffer.writeString(str, i10, i11, charset);
        return emitCompleteSegments();
    }

    @Override // com.czhj.wire.okio.BufferedSink
    public BufferedSink writeUtf8(String str) throws IOException {
        if (this.f8944a) {
            throw new IllegalStateException("closed");
        }
        this.buffer.writeUtf8(str);
        return emitCompleteSegments();
    }

    @Override // com.czhj.wire.okio.BufferedSink
    public BufferedSink writeUtf8CodePoint(int i10) throws IOException {
        if (this.f8944a) {
            throw new IllegalStateException("closed");
        }
        this.buffer.writeUtf8CodePoint(i10);
        return emitCompleteSegments();
    }

    @Override // com.czhj.wire.okio.BufferedSink
    public BufferedSink write(Source source, long j10) throws IOException {
        while (j10 > 0) {
            long read = source.read(this.buffer, j10);
            if (read == -1) {
                throw new EOFException();
            }
            j10 -= read;
            emitCompleteSegments();
        }
        return this;
    }

    @Override // com.czhj.wire.okio.BufferedSink
    public BufferedSink writeString(String str, Charset charset) throws IOException {
        if (this.f8944a) {
            throw new IllegalStateException("closed");
        }
        this.buffer.writeString(str, charset);
        return emitCompleteSegments();
    }

    @Override // com.czhj.wire.okio.BufferedSink
    public BufferedSink writeUtf8(String str, int i10, int i11) throws IOException {
        if (this.f8944a) {
            throw new IllegalStateException("closed");
        }
        this.buffer.writeUtf8(str, i10, i11);
        return emitCompleteSegments();
    }

    @Override // com.czhj.wire.okio.BufferedSink
    public BufferedSink write(byte[] bArr) throws IOException {
        if (this.f8944a) {
            throw new IllegalStateException("closed");
        }
        this.buffer.write(bArr);
        return emitCompleteSegments();
    }

    @Override // com.czhj.wire.okio.BufferedSink
    public BufferedSink write(byte[] bArr, int i10, int i11) throws IOException {
        if (this.f8944a) {
            throw new IllegalStateException("closed");
        }
        this.buffer.write(bArr, i10, i11);
        return emitCompleteSegments();
    }

    @Override // com.czhj.wire.okio.Sink
    public void write(Buffer buffer, long j10) throws IOException {
        if (this.f8944a) {
            throw new IllegalStateException("closed");
        }
        this.buffer.write(buffer, j10);
        emitCompleteSegments();
    }
}
