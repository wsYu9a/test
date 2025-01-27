package com.vivo.google.android.exoplayer3;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.vivo.google.android.exoplayer3.l3;
import com.vivo.google.android.exoplayer3.util.Util;
import java.io.IOException;
import java.util.concurrent.ExecutorService;

/* loaded from: classes4.dex */
public final class v5 {

    /* renamed from: a */
    public final ExecutorService f28154a;

    /* renamed from: b */
    public b<? extends c> f28155b;

    /* renamed from: c */
    public IOException f28156c;

    public interface a<T extends c> {
    }

    public interface c {
    }

    public static final class d extends IOException {
        public d(Throwable th) {
            super("Unexpected " + th.getClass().getSimpleName() + ": " + th.getMessage(), th);
        }
    }

    public v5(String str) {
        this.f28154a = Util.newSingleThreadExecutor(str);
    }

    public boolean a() {
        return this.f28155b != null;
    }

    @SuppressLint({"HandlerLeak"})
    public final class b<T extends c> extends Handler implements Runnable {

        /* renamed from: a */
        public final T f28157a;

        /* renamed from: b */
        public final a<T> f28158b;

        /* renamed from: c */
        public final int f28159c;

        /* renamed from: d */
        public final long f28160d;

        /* renamed from: e */
        public IOException f28161e;

        /* renamed from: f */
        public int f28162f;

        /* renamed from: g */
        public volatile Thread f28163g;

        /* renamed from: h */
        public volatile boolean f28164h;

        public b(Looper looper, T t, a<T> aVar, int i2, long j2) {
            super(looper);
            this.f28157a = t;
            this.f28158b = aVar;
            this.f28159c = i2;
            this.f28160d = j2;
        }

        public void a(boolean z) {
            this.f28164h = z;
            this.f28161e = null;
            if (hasMessages(0)) {
                removeMessages(0);
                if (!z) {
                    sendEmptyMessage(1);
                }
            } else {
                ((l3.c) this.f28157a).f27660f = true;
                if (this.f28163g != null) {
                    this.f28163g.interrupt();
                }
            }
            if (z) {
                v5.this.f28155b = null;
                long elapsedRealtime = SystemClock.elapsedRealtime();
                ((l3) this.f28158b).a(this.f28157a, elapsedRealtime, elapsedRealtime - this.f28160d, true);
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            char c2;
            m0 m0Var;
            if (this.f28164h) {
                return;
            }
            int i2 = message.what;
            if (i2 == 0) {
                this.f28161e = null;
                v5 v5Var = v5.this;
                v5Var.f28154a.execute(v5Var.f28155b);
                return;
            }
            if (i2 == 4) {
                throw ((Error) message.obj);
            }
            v5.this.f28155b = null;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            long j2 = elapsedRealtime - this.f28160d;
            if (((l3.c) this.f28157a).f27660f) {
                ((l3) this.f28158b).a(this.f28157a, elapsedRealtime, j2, false);
                return;
            }
            int i3 = message.what;
            if (i3 == 1) {
                ((l3) this.f28158b).a(this.f28157a, elapsedRealtime, j2, false);
                return;
            }
            if (i3 == 2) {
                a<T> aVar = this.f28158b;
                T t = this.f28157a;
                l3 l3Var = (l3) aVar;
                l3Var.getClass();
                l3.c cVar = (l3.c) t;
                if (l3Var.B == -1) {
                    l3Var.B = cVar.f27663i;
                }
                l3Var.F = true;
                if (l3Var.x == C.TIME_UNSET) {
                    long h2 = l3Var.h();
                    l3Var.x = h2 != Long.MIN_VALUE ? h2 + 10000 : 0L;
                    l3Var.f27648f.onSourceInfoRefreshed(new r3(l3Var.x, l3Var.q.a()), null);
                }
                ((com.vivo.google.android.exoplayer3.b) l3Var.p).a((q3) l3Var);
                return;
            }
            if (i3 != 3) {
                return;
            }
            IOException iOException = (IOException) message.obj;
            this.f28161e = iOException;
            a<T> aVar2 = this.f28158b;
            T t2 = this.f28157a;
            l3 l3Var2 = (l3) aVar2;
            l3Var2.getClass();
            l3.c cVar2 = (l3.c) t2;
            if (l3Var2.B == -1) {
                l3Var2.B = cVar2.f27663i;
            }
            Handler handler = l3Var2.f27646d;
            if (handler != null && l3Var2.f27647e != null) {
                handler.post(new n3(l3Var2, iOException));
            }
            if (iOException instanceof t3) {
                c2 = 3;
            } else {
                c2 = l3Var2.g() > l3Var2.E ? (char) 1 : (char) 0;
                if (l3Var2.B == -1 && ((m0Var = l3Var2.q) == null || m0Var.c() == C.TIME_UNSET)) {
                    l3Var2.C = 0L;
                    l3Var2.u = l3Var2.s;
                    int size = l3Var2.o.size();
                    for (int i4 = 0; i4 < size; i4++) {
                        l3Var2.o.valueAt(i4).a(!l3Var2.s || l3Var2.y[i4]);
                    }
                    cVar2.f27659e.f27602a = 0L;
                    cVar2.f27662h = 0L;
                    cVar2.f27661g = true;
                }
                l3Var2.E = l3Var2.g();
            }
            if (c2 == 3) {
                v5.this.f28156c = this.f28161e;
            } else if (c2 != 2) {
                this.f28162f = c2 == 1 ? 1 : this.f28162f + 1;
                a(Math.min((r1 - 1) * 1000, 5000));
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            d dVar;
            try {
                this.f28163g = Thread.currentThread();
                if (!((l3.c) this.f28157a).f27660f) {
                    g1.a("load:" + this.f28157a.getClass().getSimpleName());
                    try {
                        ((l3.c) this.f28157a).a();
                        g1.a();
                    } catch (Throwable th) {
                        g1.a();
                        throw th;
                    }
                }
                if (this.f28164h) {
                    return;
                }
                sendEmptyMessage(2);
            } catch (IOException e2) {
                if (this.f28164h) {
                    return;
                }
                obtainMessage(3, e2).sendToTarget();
            } catch (Error e3) {
                if (!this.f28164h) {
                    obtainMessage(4, e3).sendToTarget();
                }
                throw e3;
            } catch (InterruptedException unused) {
                g1.b(((l3.c) this.f28157a).f27660f);
                if (this.f28164h) {
                    return;
                }
                sendEmptyMessage(2);
            } catch (Exception e4) {
                if (this.f28164h) {
                    return;
                }
                dVar = new d(e4);
                obtainMessage(3, dVar).sendToTarget();
            } catch (OutOfMemoryError e5) {
                if (this.f28164h) {
                    return;
                }
                dVar = new d(e5);
                obtainMessage(3, dVar).sendToTarget();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void a(long j2) {
            g1.b(v5.this.f28155b == null);
            v5 v5Var = v5.this;
            v5Var.f28155b = this;
            if (j2 > 0) {
                sendEmptyMessageDelayed(0, j2);
            } else {
                this.f28161e = null;
                v5Var.f28154a.execute(this);
            }
        }
    }
}
