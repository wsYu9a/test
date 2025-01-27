package com.tencent.bugly.crashreport.biz;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.tencent.bugly.proguard.X;
import java.util.List;

/* loaded from: classes4.dex */
public class e implements Application.ActivityLifecycleCallbacks {
    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        Class cls;
        String b10;
        Class cls2;
        String name = activity != null ? activity.getClass().getName() : "unknown";
        cls = f.f22274l;
        if (cls != null) {
            cls2 = f.f22274l;
            if (!cls2.getName().equals(name)) {
                return;
            }
        }
        X.a(">>> %s onCreated <<<", name);
        com.tencent.bugly.crashreport.common.info.a m10 = com.tencent.bugly.crashreport.common.info.a.m();
        if (m10 != null) {
            List<String> list = m10.f22309na;
            b10 = f.b(name, "onCreated");
            list.add(b10);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        Class cls;
        String b10;
        Class cls2;
        String name = activity != null ? activity.getClass().getName() : "unknown";
        cls = f.f22274l;
        if (cls != null) {
            cls2 = f.f22274l;
            if (!cls2.getName().equals(name)) {
                return;
            }
        }
        X.a(">>> %s onDestroyed <<<", name);
        com.tencent.bugly.crashreport.common.info.a m10 = com.tencent.bugly.crashreport.common.info.a.m();
        if (m10 != null) {
            List<String> list = m10.f22309na;
            b10 = f.b(name, "onDestroyed");
            list.add(b10);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        Class cls;
        String b10;
        Class cls2;
        String name = activity != null ? activity.getClass().getName() : "unknown";
        cls = f.f22274l;
        if (cls != null) {
            cls2 = f.f22274l;
            if (!cls2.getName().equals(name)) {
                return;
            }
        }
        X.a(">>> %s onPaused <<<", name);
        com.tencent.bugly.crashreport.common.info.a m10 = com.tencent.bugly.crashreport.common.info.a.m();
        if (m10 == null) {
            return;
        }
        List<String> list = m10.f22309na;
        b10 = f.b(name, "onPaused");
        list.add(b10);
        m10.a(false);
        long currentTimeMillis = System.currentTimeMillis();
        m10.Y = currentTimeMillis;
        m10.Z = currentTimeMillis - m10.X;
        long unused = f.f22269g = currentTimeMillis;
        if (m10.Z < 0) {
            m10.Z = 0L;
        }
        if (activity != null) {
            m10.W = "background";
        } else {
            m10.W = "unknown";
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        Class cls;
        String b10;
        long j10;
        long j11;
        long j12;
        long j13;
        int i10;
        int i11;
        long j14;
        long j15;
        boolean z10;
        long j16;
        boolean z11;
        Class cls2;
        String name = activity != null ? activity.getClass().getName() : "unknown";
        cls = f.f22274l;
        if (cls != null) {
            cls2 = f.f22274l;
            if (!cls2.getName().equals(name)) {
                return;
            }
        }
        X.a(">>> %s onResumed <<<", name);
        com.tencent.bugly.crashreport.common.info.a m10 = com.tencent.bugly.crashreport.common.info.a.m();
        if (m10 == null) {
            return;
        }
        List<String> list = m10.f22309na;
        b10 = f.b(name, "onResumed");
        list.add(b10);
        m10.a(true);
        m10.W = name;
        long currentTimeMillis = System.currentTimeMillis();
        m10.X = currentTimeMillis;
        j10 = f.f22270h;
        m10.f22283aa = currentTimeMillis - j10;
        long j17 = m10.X;
        j11 = f.f22269g;
        long j18 = j17 - j11;
        j12 = f.f22267e;
        if (j18 > (j12 > 0 ? f.f22267e : f.f22266d)) {
            m10.F();
            f.i();
            Long valueOf = Long.valueOf(j18 / 1000);
            j13 = f.f22266d;
            X.c("[session] launch app one times (app in background %d seconds and over %d seconds)", valueOf, Long.valueOf(j13 / 1000));
            i10 = f.f22268f;
            i11 = f.f22264b;
            if (i10 % i11 == 0) {
                c cVar = f.f22271i;
                z11 = f.f22275m;
                cVar.a(4, z11, 0L);
                return;
            }
            f.f22271i.a(4, false, 0L);
            long currentTimeMillis2 = System.currentTimeMillis();
            j14 = f.f22272j;
            long j19 = currentTimeMillis2 - j14;
            j15 = f.f22265c;
            if (j19 > j15) {
                long unused = f.f22272j = currentTimeMillis2;
                X.c("add a timer to upload hot start user info", new Object[0]);
                z10 = f.f22275m;
                if (z10) {
                    c cVar2 = f.f22271i;
                    j16 = f.f22265c;
                    cVar2.a(j16);
                }
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
    }
}
