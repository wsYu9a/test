package com.tencent.bugly.proguard;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public class ea extends Thread {

    /* renamed from: a */
    private boolean f25060a = false;

    /* renamed from: b */
    private boolean f25061b = false;

    /* renamed from: c */
    final List<da> f25062c = new ArrayList();

    /* renamed from: d */
    private List<fa> f25063d = new ArrayList();

    /* renamed from: e */
    ArrayList<da> f25064e = new ArrayList<>();

    private int e() {
        int i2 = 0;
        for (int i3 = 0; i3 < this.f25062c.size(); i3++) {
            try {
                i2 = Math.max(i2, this.f25062c.get(i3).a());
            } catch (Exception e2) {
                X.a(e2);
            }
        }
        return i2;
    }

    public void a() {
        a(new Handler(Looper.getMainLooper()));
    }

    public void b() {
        for (int i2 = 0; i2 < this.f25062c.size(); i2++) {
            try {
                if (this.f25062c.get(i2).c().equals(Looper.getMainLooper().getThread().getName())) {
                    X.a("remove handler::%s", this.f25062c.get(i2));
                    this.f25062c.remove(i2);
                }
            } catch (Exception e2) {
                X.a(e2);
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
        } catch (Exception e2) {
            X.a(e2);
            return false;
        }
    }

    public boolean d() {
        this.f25060a = true;
        if (!isAlive()) {
            return false;
        }
        try {
            interrupt();
        } catch (Exception e2) {
            X.a(e2);
        }
        return true;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        while (!this.f25060a) {
            for (int i2 = 0; i2 < this.f25062c.size(); i2++) {
                try {
                    this.f25062c.get(i2).f();
                } catch (Exception e2) {
                    X.a(e2);
                } catch (OutOfMemoryError e3) {
                    X.a(e3);
                }
            }
            long uptimeMillis = SystemClock.uptimeMillis();
            for (long j2 = 2000; j2 > 0 && !isInterrupted(); j2 = 2000 - (SystemClock.uptimeMillis() - uptimeMillis)) {
                Thread.sleep(j2);
            }
            int e4 = e();
            if (e4 != 0 && e4 != 1) {
                this.f25064e.clear();
                for (int i3 = 0; i3 < this.f25062c.size(); i3++) {
                    da daVar = this.f25062c.get(i3);
                    if (daVar.d()) {
                        this.f25064e.add(daVar);
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
                int i4 = 0;
                while (true) {
                    if (this.f25061b) {
                        break;
                    }
                    X.a("do not enable anr continue check", new Object[0]);
                    Thread.sleep(2000L);
                    i4++;
                    if (i4 == 15) {
                        this.f25064e.clear();
                        break;
                    }
                }
                for (int i5 = 0; i5 < this.f25064e.size(); i5++) {
                    da daVar2 = this.f25064e.get(i5);
                    for (int i6 = 0; i6 < this.f25063d.size(); i6++) {
                        X.b("main thread blocked,now begin to upload anr stack", new Object[0]);
                        this.f25063d.get(i6).a(daVar2);
                        this.f25061b = false;
                    }
                }
            }
        }
    }

    public void a(Handler handler) {
        a(handler, 5000L);
    }

    public void a(Handler handler, long j2) {
        if (handler == null) {
            X.b("addThread handler should not be null", new Object[0]);
            return;
        }
        String name = handler.getLooper().getThread().getName();
        for (int i2 = 0; i2 < this.f25062c.size(); i2++) {
            try {
                if (this.f25062c.get(i2).c().equals(handler.getLooper().getThread().getName())) {
                    X.b("addThread fail ,this thread has been added in monitor queue", new Object[0]);
                    return;
                }
            } catch (Exception e2) {
                X.a(e2);
            }
        }
        this.f25062c.add(new da(handler, name, j2));
    }

    public void b(fa faVar) {
        this.f25063d.remove(faVar);
    }

    public void a(fa faVar) {
        if (this.f25063d.contains(faVar)) {
            X.a("addThreadMonitorListeners fail ,this threadMonitorListener has been added in monitor queue", new Object[0]);
        } else {
            this.f25063d.add(faVar);
        }
    }

    public void a(boolean z) {
        this.f25061b = z;
    }
}
