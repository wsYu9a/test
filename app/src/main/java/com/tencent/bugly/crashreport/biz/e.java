package com.tencent.bugly.crashreport.biz;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import androidx.core.os.EnvironmentCompat;
import com.tencent.bugly.proguard.X;
import java.util.List;

/* loaded from: classes4.dex */
class e implements Application.ActivityLifecycleCallbacks {
    e() {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        Class cls;
        String b2;
        Class cls2;
        String name = activity != null ? activity.getClass().getName() : EnvironmentCompat.MEDIA_UNKNOWN;
        cls = f.l;
        if (cls != null) {
            cls2 = f.l;
            if (!cls2.getName().equals(name)) {
                return;
            }
        }
        X.a(">>> %s onCreated <<<", name);
        com.tencent.bugly.crashreport.common.info.a m = com.tencent.bugly.crashreport.common.info.a.m();
        if (m != null) {
            List<String> list = m.na;
            b2 = f.b(name, "onCreated");
            list.add(b2);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        Class cls;
        String b2;
        Class cls2;
        String name = activity != null ? activity.getClass().getName() : EnvironmentCompat.MEDIA_UNKNOWN;
        cls = f.l;
        if (cls != null) {
            cls2 = f.l;
            if (!cls2.getName().equals(name)) {
                return;
            }
        }
        X.a(">>> %s onDestroyed <<<", name);
        com.tencent.bugly.crashreport.common.info.a m = com.tencent.bugly.crashreport.common.info.a.m();
        if (m != null) {
            List<String> list = m.na;
            b2 = f.b(name, "onDestroyed");
            list.add(b2);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        Class cls;
        String b2;
        Class cls2;
        String name = activity != null ? activity.getClass().getName() : EnvironmentCompat.MEDIA_UNKNOWN;
        cls = f.l;
        if (cls != null) {
            cls2 = f.l;
            if (!cls2.getName().equals(name)) {
                return;
            }
        }
        X.a(">>> %s onPaused <<<", name);
        com.tencent.bugly.crashreport.common.info.a m = com.tencent.bugly.crashreport.common.info.a.m();
        if (m == null) {
            return;
        }
        List<String> list = m.na;
        b2 = f.b(name, "onPaused");
        list.add(b2);
        m.a(false);
        long currentTimeMillis = System.currentTimeMillis();
        m.Y = currentTimeMillis;
        m.Z = currentTimeMillis - m.X;
        long unused = f.f24738g = currentTimeMillis;
        if (m.Z < 0) {
            m.Z = 0L;
        }
        if (activity != null) {
            m.W = "background";
        } else {
            m.W = EnvironmentCompat.MEDIA_UNKNOWN;
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        Class cls;
        String b2;
        long j2;
        long j3;
        long j4;
        long j5;
        int i2;
        int i3;
        long j6;
        long j7;
        boolean z;
        long j8;
        boolean z2;
        Class cls2;
        String name = activity != null ? activity.getClass().getName() : EnvironmentCompat.MEDIA_UNKNOWN;
        cls = f.l;
        if (cls != null) {
            cls2 = f.l;
            if (!cls2.getName().equals(name)) {
                return;
            }
        }
        X.a(">>> %s onResumed <<<", name);
        com.tencent.bugly.crashreport.common.info.a m = com.tencent.bugly.crashreport.common.info.a.m();
        if (m == null) {
            return;
        }
        List<String> list = m.na;
        b2 = f.b(name, "onResumed");
        list.add(b2);
        m.a(true);
        m.W = name;
        long currentTimeMillis = System.currentTimeMillis();
        m.X = currentTimeMillis;
        j2 = f.f24739h;
        m.aa = currentTimeMillis - j2;
        long j9 = m.X;
        j3 = f.f24738g;
        long j10 = j9 - j3;
        j4 = f.f24736e;
        if (j10 > (j4 > 0 ? f.f24736e : f.f24735d)) {
            m.F();
            f.i();
            j5 = f.f24735d;
            X.c("[session] launch app one times (app in background %d seconds and over %d seconds)", Long.valueOf(j10 / 1000), Long.valueOf(j5 / 1000));
            i2 = f.f24737f;
            i3 = f.f24733b;
            if (i2 % i3 == 0) {
                c cVar = f.f24740i;
                z2 = f.m;
                cVar.a(4, z2, 0L);
                return;
            }
            f.f24740i.a(4, false, 0L);
            long currentTimeMillis2 = System.currentTimeMillis();
            j6 = f.f24741j;
            long j11 = currentTimeMillis2 - j6;
            j7 = f.f24734c;
            if (j11 > j7) {
                long unused = f.f24741j = currentTimeMillis2;
                X.c("add a timer to upload hot start user info", new Object[0]);
                z = f.m;
                if (z) {
                    c cVar2 = f.f24740i;
                    j8 = f.f24734c;
                    cVar2.a(j8);
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
