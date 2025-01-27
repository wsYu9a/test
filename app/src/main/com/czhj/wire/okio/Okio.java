package com.czhj.wire.okio;

import android.os.Build;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.util.logging.Logger;

/* loaded from: classes2.dex */
public final class Okio {

    /* renamed from: a */
    public static final Logger f8937a = Logger.getLogger(Okio.class.getName());

    /* renamed from: com.czhj.wire.okio.Okio$1 */
    public class AnonymousClass1 implements Sink {

        /* renamed from: b */
        public final /* synthetic */ OutputStream f8939b;

        public AnonymousClass1(OutputStream outputStream) {
            outputStream = outputStream;
        }

        @Override // com.czhj.wire.okio.Sink, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            outputStream.close();
        }

        @Override // com.czhj.wire.okio.Sink, java.io.Flushable
        public void flush() throws IOException {
            outputStream.flush();
        }

        @Override // com.czhj.wire.okio.Sink
        public Timeout timeout() {
            return Timeout.this;
        }

        public String toString() {
            return "sink(" + outputStream + ")";
        }

        @Override // com.czhj.wire.okio.Sink
        public void write(Buffer buffer, long j10) throws IOException {
            Util.checkOffsetAndCount(buffer.f8900b, 0L, j10);
            while (j10 > 0) {
                Timeout.this.throwIfReached();
                Segment segment = buffer.f8899a;
                int min = (int) Math.min(j10, segment.f8952c - segment.f8951b);
                outputStream.write(segment.f8950a, segment.f8951b, min);
                int i10 = segment.f8951b + min;
                segment.f8951b = i10;
                long j11 = min;
                j10 -= j11;
                buffer.f8900b -= j11;
                if (i10 == segment.f8952c) {
                    buffer.f8899a = segment.pop();
                    SegmentPool.a(segment);
                }
            }
        }
    }

    /* renamed from: com.czhj.wire.okio.Okio$2 */
    public class AnonymousClass2 implements Source {

        /* renamed from: b */
        public final /* synthetic */ InputStream f8941b;

        public AnonymousClass2(InputStream inputStream) {
            inputStream = inputStream;
        }

        @Override // com.czhj.wire.okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            inputStream.close();
        }

        @Override // com.czhj.wire.okio.Source
        public long read(Buffer buffer, long j10) throws IOException {
            if (j10 < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j10);
            }
            if (j10 == 0) {
                return 0L;
            }
            try {
                Timeout.this.throwIfReached();
                Segment a10 = buffer.a(1);
                int read = inputStream.read(a10.f8950a, a10.f8952c, (int) Math.min(j10, 8192 - a10.f8952c));
                if (read == -1) {
                    return -1L;
                }
                a10.f8952c += read;
                long j11 = read;
                buffer.f8900b += j11;
                return j11;
            } catch (AssertionError e10) {
                if (Okio.a(e10)) {
                    throw new IOException(e10);
                }
                throw e10;
            }
        }

        @Override // com.czhj.wire.okio.Source
        public Timeout timeout() {
            return Timeout.this;
        }

        public String toString() {
            return "source(" + inputStream + ")";
        }
    }

    /* renamed from: com.czhj.wire.okio.Okio$3 */
    public class AnonymousClass3 extends AsyncTimeout {

        /* renamed from: i */
        public final /* synthetic */ Socket f8942i;

        public AnonymousClass3(Socket socket) {
            socket = socket;
        }

        @Override // com.czhj.wire.okio.AsyncTimeout
        public IOException newTimeoutException(IOException iOException) {
            SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
            if (iOException != null) {
                socketTimeoutException.initCause(iOException);
            }
            return socketTimeoutException;
        }

        @Override // com.czhj.wire.okio.AsyncTimeout
        public void timedOut() {
            try {
                socket.close();
            } catch (AssertionError e10) {
                if (!Okio.a(e10)) {
                    throw e10;
                }
            } catch (Exception unused) {
            }
        }
    }

    public static boolean a(AssertionError assertionError) {
        return (assertionError.getCause() == null || assertionError.getMessage() == null || !assertionError.getMessage().contains("getsockname failed")) ? false : true;
    }

    public static Sink appendingSink(File file) throws FileNotFoundException {
        if (file != null) {
            return sink(new FileOutputStream(file, true));
        }
        throw new IllegalArgumentException("file == null");
    }

    public static BufferedSink buffer(Sink sink) {
        if (sink != null) {
            return new RealBufferedSink(sink);
        }
        throw new IllegalArgumentException("sink == null");
    }

    public static Sink sink(File file) throws FileNotFoundException {
        if (file != null) {
            return sink(new FileOutputStream(file));
        }
        throw new IllegalArgumentException("file == null");
    }

    public static Source source(File file) throws FileNotFoundException {
        if (file != null) {
            return source(new FileInputStream(file));
        }
        throw new IllegalArgumentException("file == null");
    }

    public static Sink a(OutputStream outputStream, Timeout timeout) {
        if (outputStream == null) {
            throw new IllegalArgumentException("out == null");
        }
        if (timeout != null) {
            return new Sink() { // from class: com.czhj.wire.okio.Okio.1

                /* renamed from: b */
                public final /* synthetic */ OutputStream f8939b;

                public AnonymousClass1(OutputStream outputStream2) {
                    outputStream = outputStream2;
                }

                @Override // com.czhj.wire.okio.Sink, java.io.Closeable, java.lang.AutoCloseable
                public void close() throws IOException {
                    outputStream.close();
                }

                @Override // com.czhj.wire.okio.Sink, java.io.Flushable
                public void flush() throws IOException {
                    outputStream.flush();
                }

                @Override // com.czhj.wire.okio.Sink
                public Timeout timeout() {
                    return Timeout.this;
                }

                public String toString() {
                    return "sink(" + outputStream + ")";
                }

                @Override // com.czhj.wire.okio.Sink
                public void write(Buffer buffer, long j10) throws IOException {
                    Util.checkOffsetAndCount(buffer.f8900b, 0L, j10);
                    while (j10 > 0) {
                        Timeout.this.throwIfReached();
                        Segment segment = buffer.f8899a;
                        int min = (int) Math.min(j10, segment.f8952c - segment.f8951b);
                        outputStream.write(segment.f8950a, segment.f8951b, min);
                        int i10 = segment.f8951b + min;
                        segment.f8951b = i10;
                        long j11 = min;
                        j10 -= j11;
                        buffer.f8900b -= j11;
                        if (i10 == segment.f8952c) {
                            buffer.f8899a = segment.pop();
                            SegmentPool.a(segment);
                        }
                    }
                }
            };
        }
        throw new IllegalArgumentException("timeout == null");
    }

    public static BufferedSource buffer(Source source) {
        if (source != null) {
            return new RealBufferedSource(source);
        }
        throw new IllegalArgumentException("source == null");
    }

    public static Sink sink(OutputStream outputStream) {
        return a(outputStream, new Timeout());
    }

    public static Source source(InputStream inputStream) {
        return a(inputStream, new Timeout());
    }

    public static Source a(InputStream inputStream, Timeout timeout) {
        if (inputStream == null) {
            throw new IllegalArgumentException("in == null");
        }
        if (timeout != null) {
            return new Source() { // from class: com.czhj.wire.okio.Okio.2

                /* renamed from: b */
                public final /* synthetic */ InputStream f8941b;

                public AnonymousClass2(InputStream inputStream2) {
                    inputStream = inputStream2;
                }

                @Override // com.czhj.wire.okio.Source, java.io.Closeable, java.lang.AutoCloseable
                public void close() throws IOException {
                    inputStream.close();
                }

                @Override // com.czhj.wire.okio.Source
                public long read(Buffer buffer, long j10) throws IOException {
                    if (j10 < 0) {
                        throw new IllegalArgumentException("byteCount < 0: " + j10);
                    }
                    if (j10 == 0) {
                        return 0L;
                    }
                    try {
                        Timeout.this.throwIfReached();
                        Segment a10 = buffer.a(1);
                        int read = inputStream.read(a10.f8950a, a10.f8952c, (int) Math.min(j10, 8192 - a10.f8952c));
                        if (read == -1) {
                            return -1L;
                        }
                        a10.f8952c += read;
                        long j11 = read;
                        buffer.f8900b += j11;
                        return j11;
                    } catch (AssertionError e10) {
                        if (Okio.a(e10)) {
                            throw new IOException(e10);
                        }
                        throw e10;
                    }
                }

                @Override // com.czhj.wire.okio.Source
                public Timeout timeout() {
                    return Timeout.this;
                }

                public String toString() {
                    return "source(" + inputStream + ")";
                }
            };
        }
        throw new IllegalArgumentException("timeout == null");
    }

    public static Sink sink(Socket socket) throws IOException {
        if (socket == null) {
            throw new IllegalArgumentException("socket == null");
        }
        AsyncTimeout a10 = a(socket);
        return a10.sink(a(socket.getOutputStream(), a10));
    }

    public static Source source(Socket socket) throws IOException {
        if (socket == null) {
            throw new IllegalArgumentException("socket == null");
        }
        AsyncTimeout a10 = a(socket);
        return a10.source(a(socket.getInputStream(), a10));
    }

    public static AsyncTimeout a(Socket socket) {
        return new AsyncTimeout() { // from class: com.czhj.wire.okio.Okio.3

            /* renamed from: i */
            public final /* synthetic */ Socket f8942i;

            public AnonymousClass3(Socket socket2) {
                socket = socket2;
            }

            @Override // com.czhj.wire.okio.AsyncTimeout
            public IOException newTimeoutException(IOException iOException) {
                SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
                if (iOException != null) {
                    socketTimeoutException.initCause(iOException);
                }
                return socketTimeoutException;
            }

            @Override // com.czhj.wire.okio.AsyncTimeout
            public void timedOut() {
                try {
                    socket.close();
                } catch (AssertionError e10) {
                    if (!Okio.a(e10)) {
                        throw e10;
                    }
                } catch (Exception unused) {
                }
            }
        };
    }

    public static Sink sink(Path path, OpenOption... openOptionArr) throws IOException {
        OutputStream newOutputStream;
        if (path == null) {
            throw new IllegalArgumentException("path == null");
        }
        try {
            if (Build.VERSION.SDK_INT < 26) {
                throw new IOException("no support os version");
            }
            newOutputStream = Files.newOutputStream(path, openOptionArr);
            return sink(newOutputStream);
        } catch (Throwable th2) {
            throw new IOException(th2.getMessage());
        }
    }

    public static Source source(Path path, OpenOption... openOptionArr) throws IOException {
        InputStream newInputStream;
        if (path == null) {
            throw new IllegalArgumentException("path == null");
        }
        try {
            if (Build.VERSION.SDK_INT < 26) {
                throw new IOException("no support os version");
            }
            newInputStream = Files.newInputStream(path, openOptionArr);
            return source(newInputStream);
        } catch (Throwable th2) {
            throw new IOException(th2.getMessage());
        }
    }
}
