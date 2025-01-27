package com.opos.exoplayer.core.h;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import androidx.annotation.Nullable;
import com.opos.exoplayer.core.i.u;
import java.io.IOException;
import java.util.concurrent.ExecutorService;

/* loaded from: classes4.dex */
public final class r {

    /* renamed from: a */
    private final ExecutorService f18988a;

    /* renamed from: b */
    private e<? extends b> f18989b;

    /* renamed from: c */
    private IOException f18990c;

    public interface a<T extends b> {
        int a(T t, long j2, long j3, IOException iOException);

        void a(T t, long j2, long j3);

        void a(T t, long j2, long j3, boolean z);
    }

    public interface b {
        void a();

        boolean b();

        void c();
    }

    public interface c {
        void g();
    }

    public static final class d extends IOException {
        public d(Throwable th) {
            super("Unexpected " + th.getClass().getSimpleName() + ": " + th.getMessage(), th);
        }
    }

    @SuppressLint({"HandlerLeak"})
    private final class e<T extends b> extends Handler implements Runnable {

        /* renamed from: a */
        public final int f18991a;

        /* renamed from: c */
        private final T f18993c;

        /* renamed from: d */
        private final a<T> f18994d;

        /* renamed from: e */
        private final long f18995e;

        /* renamed from: f */
        private IOException f18996f;

        /* renamed from: g */
        private int f18997g;

        /* renamed from: h */
        private volatile Thread f18998h;

        /* renamed from: i */
        private volatile boolean f18999i;

        public e(Looper looper, T t, a<T> aVar, int i2, long j2) {
            super(looper);
            this.f18993c = t;
            this.f18994d = aVar;
            this.f18991a = i2;
            this.f18995e = j2;
        }

        private void a() {
            this.f18996f = null;
            r.this.f18988a.execute(r.this.f18989b);
        }

        private void b() {
            r.this.f18989b = null;
        }

        private long c() {
            return Math.min((this.f18997g - 1) * 1000, 5000);
        }

        public void a(int i2) {
            IOException iOException = this.f18996f;
            if (iOException != null && this.f18997g > i2) {
                throw iOException;
            }
        }

        public void a(long j2) {
            com.opos.exoplayer.core.i.a.b(r.this.f18989b == null);
            r.this.f18989b = this;
            if (j2 > 0) {
                sendEmptyMessageDelayed(0, j2);
            } else {
                a();
            }
        }

        public void a(boolean z) {
            this.f18999i = z;
            this.f18996f = null;
            if (hasMessages(0)) {
                removeMessages(0);
                if (!z) {
                    sendEmptyMessage(1);
                }
            } else {
                this.f18993c.a();
                if (this.f18998h != null) {
                    this.f18998h.interrupt();
                }
            }
            if (z) {
                b();
                long elapsedRealtime = SystemClock.elapsedRealtime();
                this.f18994d.a((a<T>) this.f18993c, elapsedRealtime, elapsedRealtime - this.f18995e, true);
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (this.f18999i) {
                return;
            }
            int i2 = message.what;
            if (i2 == 0) {
                a();
                return;
            }
            if (i2 == 4) {
                throw ((Error) message.obj);
            }
            b();
            long elapsedRealtime = SystemClock.elapsedRealtime();
            long j2 = elapsedRealtime - this.f18995e;
            if (!this.f18993c.b()) {
                int i3 = message.what;
                if (i3 != 1) {
                    if (i3 == 2) {
                        try {
                            this.f18994d.a(this.f18993c, elapsedRealtime, j2);
                            return;
                        } catch (RuntimeException e2) {
                            com.opos.cmn.an.f.a.d("LoadTask", "Unexpected exception handling load completed", e2);
                            r.this.f18990c = new d(e2);
                            return;
                        }
                    }
                    if (i3 != 3) {
                        return;
                    }
                    IOException iOException = (IOException) message.obj;
                    this.f18996f = iOException;
                    int a2 = this.f18994d.a((a<T>) this.f18993c, elapsedRealtime, j2, iOException);
                    if (a2 == 3) {
                        r.this.f18990c = this.f18996f;
                        return;
                    } else {
                        if (a2 != 2) {
                            this.f18997g = a2 != 1 ? 1 + this.f18997g : 1;
                            a(c());
                            return;
                        }
                        return;
                    }
                }
            }
            this.f18994d.a((a<T>) this.f18993c, elapsedRealtime, j2, false);
        }

        @Override // java.lang.Runnable
        public void run() {
            Object e2;
            try {
                this.f18998h = Thread.currentThread();
                if (!this.f18993c.b()) {
                    com.opos.exoplayer.core.i.t.a("load:" + this.f18993c.getClass().getSimpleName());
                    try {
                        this.f18993c.c();
                        com.opos.exoplayer.core.i.t.a();
                    } catch (Throwable th) {
                        com.opos.exoplayer.core.i.t.a();
                        throw th;
                    }
                }
                if (this.f18999i) {
                    return;
                }
                sendEmptyMessage(2);
            } catch (IOException e3) {
                e2 = e3;
                if (this.f18999i) {
                    return;
                }
                obtainMessage(3, e2).sendToTarget();
            } catch (Error e4) {
                com.opos.cmn.an.f.a.d("LoadTask", "Unexpected error loading stream", e4);
                if (!this.f18999i) {
                    obtainMessage(4, e4).sendToTarget();
                }
                throw e4;
            } catch (InterruptedException unused) {
                com.opos.exoplayer.core.i.a.b(this.f18993c.b());
                if (this.f18999i) {
                    return;
                }
                sendEmptyMessage(2);
            } catch (Exception e5) {
                com.opos.cmn.an.f.a.d("LoadTask", "Unexpected exception loading stream", e5);
                if (this.f18999i) {
                    return;
                }
                e2 = new d(e5);
                obtainMessage(3, e2).sendToTarget();
            } catch (OutOfMemoryError e6) {
                com.opos.cmn.an.f.a.d("LoadTask", "OutOfMemory error loading stream", e6);
                if (this.f18999i) {
                    return;
                }
                e2 = new d(e6);
                obtainMessage(3, e2).sendToTarget();
            }
        }
    }

    private static final class f implements Runnable {

        /* renamed from: a */
        private final c f19000a;

        public f(c cVar) {
            this.f19000a = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f19000a.g();
        }
    }

    public r(String str) {
        this.f18988a = u.a(str);
    }

    public <T extends b> long a(T t, a<T> aVar, int i2) {
        Looper myLooper = Looper.myLooper();
        com.opos.exoplayer.core.i.a.b(myLooper != null);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        new e(myLooper, t, aVar, i2, elapsedRealtime).a(0L);
        return elapsedRealtime;
    }

    public void a(int i2) {
        IOException iOException = this.f18990c;
        if (iOException != null) {
            throw iOException;
        }
        e<? extends b> eVar = this.f18989b;
        if (eVar != null) {
            if (i2 == Integer.MIN_VALUE) {
                i2 = eVar.f18991a;
            }
            eVar.a(i2);
        }
    }

    public void a(@Nullable c cVar) {
        e<? extends b> eVar = this.f18989b;
        if (eVar != null) {
            eVar.a(true);
        }
        if (cVar != null) {
            this.f18988a.execute(new f(cVar));
        }
        this.f18988a.shutdown();
    }

    public boolean a() {
        return this.f18989b != null;
    }

    public void b() {
        this.f18989b.a(false);
    }
}
