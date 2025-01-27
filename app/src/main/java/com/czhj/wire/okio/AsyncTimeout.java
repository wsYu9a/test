package com.czhj.wire.okio;

import androidx.media3.common.C;
import java.io.IOException;
import java.io.InterruptedIOException;

/* loaded from: classes2.dex */
public class AsyncTimeout extends Timeout {

    /* renamed from: g */
    public static final int f8886g = 65536;

    /* renamed from: h */
    public static AsyncTimeout f8887h;

    /* renamed from: d */
    public boolean f8888d;

    /* renamed from: e */
    public AsyncTimeout f8889e;

    /* renamed from: f */
    public long f8890f;

    /* renamed from: com.czhj.wire.okio.AsyncTimeout$1 */
    public class AnonymousClass1 implements Sink {

        /* renamed from: a */
        public final /* synthetic */ Sink f8891a;

        public AnonymousClass1(Sink sink) {
            sink = sink;
        }

        @Override // com.czhj.wire.okio.Sink, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            AsyncTimeout.this.enter();
            try {
                try {
                    sink.close();
                    AsyncTimeout.this.a(true);
                } catch (IOException e10) {
                    throw AsyncTimeout.this.a(e10);
                }
            } catch (Throwable th2) {
                AsyncTimeout.this.a(false);
                throw th2;
            }
        }

        @Override // com.czhj.wire.okio.Sink, java.io.Flushable
        public void flush() throws IOException {
            AsyncTimeout.this.enter();
            try {
                try {
                    sink.flush();
                    AsyncTimeout.this.a(true);
                } catch (IOException e10) {
                    throw AsyncTimeout.this.a(e10);
                }
            } catch (Throwable th2) {
                AsyncTimeout.this.a(false);
                throw th2;
            }
        }

        @Override // com.czhj.wire.okio.Sink
        public Timeout timeout() {
            return AsyncTimeout.this;
        }

        public String toString() {
            return "AsyncTimeout.sink(" + sink + ")";
        }

        @Override // com.czhj.wire.okio.Sink
        public void write(Buffer buffer, long j10) throws IOException {
            Util.checkOffsetAndCount(buffer.f8900b, 0L, j10);
            while (true) {
                long j11 = 0;
                if (j10 <= 0) {
                    return;
                }
                Segment segment = buffer.f8899a;
                while (true) {
                    if (j11 >= 65536) {
                        break;
                    }
                    Segment segment2 = buffer.f8899a;
                    j11 += segment2.f8952c - segment2.f8951b;
                    if (j11 >= j10) {
                        j11 = j10;
                        break;
                    }
                    segment = segment.f8955f;
                }
                AsyncTimeout.this.enter();
                try {
                    try {
                        sink.write(buffer, j11);
                        j10 -= j11;
                        AsyncTimeout.this.a(true);
                    } catch (IOException e10) {
                        throw AsyncTimeout.this.a(e10);
                    }
                } catch (Throwable th2) {
                    AsyncTimeout.this.a(false);
                    throw th2;
                }
            }
        }
    }

    /* renamed from: com.czhj.wire.okio.AsyncTimeout$2 */
    public class AnonymousClass2 implements Source {

        /* renamed from: a */
        public final /* synthetic */ Source f8893a;

        public AnonymousClass2(Source source) {
            source = source;
        }

        @Override // com.czhj.wire.okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            try {
                try {
                    source.close();
                    AsyncTimeout.this.a(true);
                } catch (IOException e10) {
                    throw AsyncTimeout.this.a(e10);
                }
            } catch (Throwable th2) {
                AsyncTimeout.this.a(false);
                throw th2;
            }
        }

        @Override // com.czhj.wire.okio.Source
        public long read(Buffer buffer, long j10) throws IOException {
            AsyncTimeout.this.enter();
            try {
                try {
                    long read = source.read(buffer, j10);
                    AsyncTimeout.this.a(true);
                    return read;
                } catch (IOException e10) {
                    throw AsyncTimeout.this.a(e10);
                }
            } catch (Throwable th2) {
                AsyncTimeout.this.a(false);
                throw th2;
            }
        }

        @Override // com.czhj.wire.okio.Source
        public Timeout timeout() {
            return AsyncTimeout.this;
        }

        public String toString() {
            return "AsyncTimeout.source(" + source + ")";
        }
    }

    public static final class Watchdog extends Thread {
        public Watchdog() {
            super("Okio Watchdog");
            setDaemon(true);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            while (true) {
                try {
                    AsyncTimeout a10 = AsyncTimeout.a();
                    if (a10 != null) {
                        a10.timedOut();
                    }
                } catch (InterruptedException unused) {
                }
            }
        }
    }

    public static synchronized AsyncTimeout a() throws InterruptedException {
        synchronized (AsyncTimeout.class) {
            AsyncTimeout asyncTimeout = f8887h.f8889e;
            if (asyncTimeout == null) {
                AsyncTimeout.class.wait();
                return null;
            }
            long a10 = asyncTimeout.a(System.nanoTime());
            if (a10 > 0) {
                long j10 = a10 / C.MICROS_PER_SECOND;
                Long.signum(j10);
                AsyncTimeout.class.wait(j10, (int) (a10 - (C.MICROS_PER_SECOND * j10)));
                return null;
            }
            f8887h.f8889e = asyncTimeout.f8889e;
            asyncTimeout.f8889e = null;
            return asyncTimeout;
        }
    }

    public final void enter() {
        if (this.f8888d) {
            throw new IllegalStateException("Unbalanced enter/exit");
        }
        long timeoutNanos = timeoutNanos();
        boolean hasDeadline = hasDeadline();
        if (timeoutNanos != 0 || hasDeadline) {
            this.f8888d = true;
            a(this, timeoutNanos, hasDeadline);
        }
    }

    public final boolean exit() {
        if (!this.f8888d) {
            return false;
        }
        this.f8888d = false;
        return a(this);
    }

    public IOException newTimeoutException(IOException iOException) {
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    public final Sink sink(Sink sink) {
        return new Sink() { // from class: com.czhj.wire.okio.AsyncTimeout.1

            /* renamed from: a */
            public final /* synthetic */ Sink f8891a;

            public AnonymousClass1(Sink sink2) {
                sink = sink2;
            }

            @Override // com.czhj.wire.okio.Sink, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                AsyncTimeout.this.enter();
                try {
                    try {
                        sink.close();
                        AsyncTimeout.this.a(true);
                    } catch (IOException e10) {
                        throw AsyncTimeout.this.a(e10);
                    }
                } catch (Throwable th2) {
                    AsyncTimeout.this.a(false);
                    throw th2;
                }
            }

            @Override // com.czhj.wire.okio.Sink, java.io.Flushable
            public void flush() throws IOException {
                AsyncTimeout.this.enter();
                try {
                    try {
                        sink.flush();
                        AsyncTimeout.this.a(true);
                    } catch (IOException e10) {
                        throw AsyncTimeout.this.a(e10);
                    }
                } catch (Throwable th2) {
                    AsyncTimeout.this.a(false);
                    throw th2;
                }
            }

            @Override // com.czhj.wire.okio.Sink
            public Timeout timeout() {
                return AsyncTimeout.this;
            }

            public String toString() {
                return "AsyncTimeout.sink(" + sink + ")";
            }

            @Override // com.czhj.wire.okio.Sink
            public void write(Buffer buffer, long j10) throws IOException {
                Util.checkOffsetAndCount(buffer.f8900b, 0L, j10);
                while (true) {
                    long j11 = 0;
                    if (j10 <= 0) {
                        return;
                    }
                    Segment segment = buffer.f8899a;
                    while (true) {
                        if (j11 >= 65536) {
                            break;
                        }
                        Segment segment2 = buffer.f8899a;
                        j11 += segment2.f8952c - segment2.f8951b;
                        if (j11 >= j10) {
                            j11 = j10;
                            break;
                        }
                        segment = segment.f8955f;
                    }
                    AsyncTimeout.this.enter();
                    try {
                        try {
                            sink.write(buffer, j11);
                            j10 -= j11;
                            AsyncTimeout.this.a(true);
                        } catch (IOException e10) {
                            throw AsyncTimeout.this.a(e10);
                        }
                    } catch (Throwable th2) {
                        AsyncTimeout.this.a(false);
                        throw th2;
                    }
                }
            }
        };
    }

    public final Source source(Source source) {
        return new Source() { // from class: com.czhj.wire.okio.AsyncTimeout.2

            /* renamed from: a */
            public final /* synthetic */ Source f8893a;

            public AnonymousClass2(Source source2) {
                source = source2;
            }

            @Override // com.czhj.wire.okio.Source, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                try {
                    try {
                        source.close();
                        AsyncTimeout.this.a(true);
                    } catch (IOException e10) {
                        throw AsyncTimeout.this.a(e10);
                    }
                } catch (Throwable th2) {
                    AsyncTimeout.this.a(false);
                    throw th2;
                }
            }

            @Override // com.czhj.wire.okio.Source
            public long read(Buffer buffer, long j10) throws IOException {
                AsyncTimeout.this.enter();
                try {
                    try {
                        long read = source.read(buffer, j10);
                        AsyncTimeout.this.a(true);
                        return read;
                    } catch (IOException e10) {
                        throw AsyncTimeout.this.a(e10);
                    }
                } catch (Throwable th2) {
                    AsyncTimeout.this.a(false);
                    throw th2;
                }
            }

            @Override // com.czhj.wire.okio.Source
            public Timeout timeout() {
                return AsyncTimeout.this;
            }

            public String toString() {
                return "AsyncTimeout.source(" + source + ")";
            }
        };
    }

    public void timedOut() {
    }

    public static synchronized boolean a(AsyncTimeout asyncTimeout) {
        synchronized (AsyncTimeout.class) {
            AsyncTimeout asyncTimeout2 = f8887h;
            while (asyncTimeout2 != null) {
                AsyncTimeout asyncTimeout3 = asyncTimeout2.f8889e;
                if (asyncTimeout3 == asyncTimeout) {
                    asyncTimeout2.f8889e = asyncTimeout.f8889e;
                    asyncTimeout.f8889e = null;
                    return false;
                }
                asyncTimeout2 = asyncTimeout3;
            }
            return true;
        }
    }

    public final IOException a(IOException iOException) throws IOException {
        return !exit() ? iOException : newTimeoutException(iOException);
    }

    public final void a(boolean z10) throws IOException {
        if (exit() && z10) {
            throw newTimeoutException(null);
        }
    }

    public final long a(long j10) {
        return this.f8890f - j10;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x005d A[Catch: all -> 0x0017, TRY_LEAVE, TryCatch #0 {all -> 0x0017, blocks: (B:4:0x0003, B:6:0x0007, B:7:0x0019, B:10:0x0025, B:11:0x002e, B:12:0x003d, B:13:0x0043, B:15:0x0047, B:17:0x0050, B:20:0x0053, B:22:0x005d, B:30:0x0037, B:31:0x0064, B:32:0x0069), top: B:3:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static synchronized void a(com.czhj.wire.okio.AsyncTimeout r6, long r7, boolean r9) {
        /*
            java.lang.Class<com.czhj.wire.okio.AsyncTimeout> r0 = com.czhj.wire.okio.AsyncTimeout.class
            monitor-enter(r0)
            com.czhj.wire.okio.AsyncTimeout r1 = com.czhj.wire.okio.AsyncTimeout.f8887h     // Catch: java.lang.Throwable -> L17
            if (r1 != 0) goto L19
            com.czhj.wire.okio.AsyncTimeout r1 = new com.czhj.wire.okio.AsyncTimeout     // Catch: java.lang.Throwable -> L17
            r1.<init>()     // Catch: java.lang.Throwable -> L17
            com.czhj.wire.okio.AsyncTimeout.f8887h = r1     // Catch: java.lang.Throwable -> L17
            com.czhj.wire.okio.AsyncTimeout$Watchdog r1 = new com.czhj.wire.okio.AsyncTimeout$Watchdog     // Catch: java.lang.Throwable -> L17
            r1.<init>()     // Catch: java.lang.Throwable -> L17
            r1.start()     // Catch: java.lang.Throwable -> L17
            goto L19
        L17:
            r6 = move-exception
            goto L6a
        L19:
            long r1 = java.lang.System.nanoTime()     // Catch: java.lang.Throwable -> L17
            r3 = 0
            int r5 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r5 == 0) goto L32
            if (r9 == 0) goto L32
            long r3 = r6.deadlineNanoTime()     // Catch: java.lang.Throwable -> L17
            long r3 = r3 - r1
            long r7 = java.lang.Math.min(r7, r3)     // Catch: java.lang.Throwable -> L17
        L2e:
            long r7 = r7 + r1
            r6.f8890f = r7     // Catch: java.lang.Throwable -> L17
            goto L3d
        L32:
            if (r5 == 0) goto L35
            goto L2e
        L35:
            if (r9 == 0) goto L64
            long r7 = r6.deadlineNanoTime()     // Catch: java.lang.Throwable -> L17
            r6.f8890f = r7     // Catch: java.lang.Throwable -> L17
        L3d:
            long r7 = r6.a(r1)     // Catch: java.lang.Throwable -> L17
            com.czhj.wire.okio.AsyncTimeout r9 = com.czhj.wire.okio.AsyncTimeout.f8887h     // Catch: java.lang.Throwable -> L17
        L43:
            com.czhj.wire.okio.AsyncTimeout r3 = r9.f8889e     // Catch: java.lang.Throwable -> L17
            if (r3 == 0) goto L53
            long r3 = r3.a(r1)     // Catch: java.lang.Throwable -> L17
            int r5 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r5 >= 0) goto L50
            goto L53
        L50:
            com.czhj.wire.okio.AsyncTimeout r9 = r9.f8889e     // Catch: java.lang.Throwable -> L17
            goto L43
        L53:
            com.czhj.wire.okio.AsyncTimeout r7 = r9.f8889e     // Catch: java.lang.Throwable -> L17
            r6.f8889e = r7     // Catch: java.lang.Throwable -> L17
            r9.f8889e = r6     // Catch: java.lang.Throwable -> L17
            com.czhj.wire.okio.AsyncTimeout r6 = com.czhj.wire.okio.AsyncTimeout.f8887h     // Catch: java.lang.Throwable -> L17
            if (r9 != r6) goto L62
            java.lang.Class<com.czhj.wire.okio.AsyncTimeout> r6 = com.czhj.wire.okio.AsyncTimeout.class
            r6.notify()     // Catch: java.lang.Throwable -> L17
        L62:
            monitor-exit(r0)
            return
        L64:
            java.lang.AssertionError r6 = new java.lang.AssertionError     // Catch: java.lang.Throwable -> L17
            r6.<init>()     // Catch: java.lang.Throwable -> L17
            throw r6     // Catch: java.lang.Throwable -> L17
        L6a:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L17
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.czhj.wire.okio.AsyncTimeout.a(com.czhj.wire.okio.AsyncTimeout, long, boolean):void");
    }
}
