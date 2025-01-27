package com.tencent.bugly.proguard;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.sigmob.sdk.base.common.y;
import com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public class ea extends Thread {

    /* renamed from: a */
    private boolean f22729a = false;

    /* renamed from: b */
    private boolean f22730b = false;

    /* renamed from: c */
    final List<da> f22731c = new ArrayList();

    /* renamed from: d */
    private List<fa> f22732d = new ArrayList();

    /* renamed from: e */
    ArrayList<da> f22733e = new ArrayList<>();

    private int e() {
        int i10 = 0;
        for (int i11 = 0; i11 < this.f22731c.size(); i11++) {
            try {
                i10 = Math.max(i10, this.f22731c.get(i11).a());
            } catch (Exception e10) {
                X.a(e10);
            }
        }
        return i10;
    }

    public void a() {
        a(new Handler(Looper.getMainLooper()));
    }

    public void b() {
        for (int i10 = 0; i10 < this.f22731c.size(); i10++) {
            try {
                if (this.f22731c.get(i10).c().equals(Looper.getMainLooper().getThread().getName())) {
                    X.a("remove handler::%s", this.f22731c.get(i10));
                    this.f22731c.remove(i10);
                }
            } catch (Exception e10) {
                X.a(e10);
                return;
            }
        }
    }

    public boolean c() {
        if (isAlive()) {
            return false;
        }
        try {
            start();
            return true;
        } catch (Exception e10) {
            X.a(e10);
            return false;
        }
    }

    public boolean d() {
        this.f22729a = true;
        if (!isAlive()) {
            return false;
        }
        try {
            interrupt();
        } catch (Exception e10) {
            X.a(e10);
        }
        return true;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        while (!this.f22729a) {
            for (int i10 = 0; i10 < this.f22731c.size(); i10++) {
                try {
                    this.f22731c.get(i10).f();
                } catch (Exception e10) {
                    X.a(e10);
                } catch (OutOfMemoryError e11) {
                    X.a(e11);
                }
            }
            long uptimeMillis = SystemClock.uptimeMillis();
            for (long j10 = 2000; j10 > 0 && !isInterrupted(); j10 = y.f.f18076n - (SystemClock.uptimeMillis() - uptimeMillis)) {
                Thread.sleep(j10);
            }
            int e12 = e();
            if (e12 != 0 && e12 != 1) {
                this.f22733e.clear();
                for (int i11 = 0; i11 < this.f22731c.size(); i11++) {
                    da daVar = this.f22731c.get(i11);
                    if (daVar.d()) {
                        this.f22733e.add(daVar);
                        daVar.a(Long.MAX_VALUE);
                    }
                }
                NativeCrashHandler nativeCrashHandler = NativeCrashHandler.getInstance();
                if (nativeCrashHandler == null || !nativeCrashHandler.isEnableCatchAnrTrace()) {
                    X.a("do not enable jni mannual dump anr trace", new Object[0]);
                } else {
                    nativeCrashHandler.dumpAnrNativeStack();
                    X.a("jni mannual dump anr trace", new Object[0]);
                }
                int i12 = 0;
                while (true) {
                    if (this.f22730b) {
                        break;
                    }
                    X.a("do not enable anr continue check", new Object[0]);
                    Thread.sleep(y.f.f18076n);
                    i12++;
                    if (i12 == 15) {
                        this.f22733e.clear();
                        break;
                    }
                }
                for (int i13 = 0; i13 < this.f22733e.size(); i13++) {
                    da daVar2 = this.f22733e.get(i13);
                    for (int i14 = 0; i14 < this.f22732d.size(); i14++) {
                        X.b("main thread blocked,now begin to upload anr stack", new Object[0]);
                        this.f22732d.get(i14).a(daVar2);
                        this.f22730b = false;
                    }
                }
            }
        }
    }

    public void a(Handler handler) {
        a(handler, 5000L);
    }

    public void a(Handler handler, long j10) {
        if (handler == null) {
            X.b("addThread handler should not be null", new Object[0]);
            return;
        }
        String name = handler.getLooper().getThread().getName();
        for (int i10 = 0; i10 < this.f22731c.size(); i10++) {
            try {
                if (this.f22731c.get(i10).c().equals(handler.getLooper().getThread().getName())) {
                    X.b("addThread fail ,this thread has been added in monitor queue", new Object[0]);
                    return;
                }
            } catch (Exception e10) {
                X.a(e10);
            }
        }
        this.f22731c.add(new da(handler, name, j10));
    }

    public void b(fa faVar) {
        this.f22732d.remove(faVar);
    }

    public void a(fa faVar) {
        if (this.f22732d.contains(faVar)) {
            X.a("addThreadMonitorListeners fail ,this threadMonitorListener has been added in monitor queue", new Object[0]);
        } else {
            this.f22732d.add(faVar);
        }
    }

    public void a(boolean z10) {
        this.f22730b = z10;
    }
}
