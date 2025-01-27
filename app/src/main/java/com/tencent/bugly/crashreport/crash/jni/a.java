package com.tencent.bugly.crashreport.crash.jni;

import android.content.Context;
import com.tencent.bugly.crashreport.crash.CrashDetailBean;
import com.tencent.bugly.crashreport.crash.e;
import com.tencent.bugly.proguard.X;
import com.tencent.bugly.proguard.ca;

/* loaded from: classes4.dex */
class a implements Runnable {

    /* renamed from: a */
    final /* synthetic */ NativeCrashHandler f24899a;

    a(NativeCrashHandler nativeCrashHandler) {
        this.f24899a = nativeCrashHandler;
    }

    @Override // java.lang.Runnable
    public void run() {
        Context context;
        boolean z;
        Context context2;
        String str;
        NativeExceptionHandler nativeExceptionHandler;
        Context context3;
        e eVar;
        String str2;
        e eVar2;
        context = this.f24899a.f24894f;
        if (!ca.a(context, "native_record_lock", 10000L)) {
            X.c("[Native] Failed to lock file for handling native crash record.", new Object[0]);
            return;
        }
        z = NativeCrashHandler.f24893e;
        if (!z) {
            this.f24899a.a(999, "false");
        }
        context2 = this.f24899a.f24894f;
        str = this.f24899a.f24898j;
        nativeExceptionHandler = this.f24899a.f24897i;
        CrashDetailBean a2 = c.a(context2, str, nativeExceptionHandler);
        if (a2 != null) {
            X.c("[Native] Get crash from native record.", new Object[0]);
            eVar = this.f24899a.p;
            if (!eVar.c(a2)) {
                eVar2 = this.f24899a.p;
                eVar2.a(a2, 3000L, false);
            }
            str2 = this.f24899a.f24898j;
            c.a(false, str2);
        }
        this.f24899a.b();
        context3 = this.f24899a.f24894f;
        ca.b(context3, "native_record_lock");
    }
}
