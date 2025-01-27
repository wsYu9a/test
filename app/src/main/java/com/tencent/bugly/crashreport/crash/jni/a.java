package com.tencent.bugly.crashreport.crash.jni;

import android.content.Context;
import com.tencent.bugly.crashreport.crash.CrashDetailBean;
import com.tencent.bugly.crashreport.crash.e;
import com.tencent.bugly.proguard.X;
import com.tencent.bugly.proguard.ca;

/* loaded from: classes4.dex */
public class a implements Runnable {

    /* renamed from: a */
    final /* synthetic */ NativeCrashHandler f22529a;

    public a(NativeCrashHandler nativeCrashHandler) {
        this.f22529a = nativeCrashHandler;
    }

    @Override // java.lang.Runnable
    public void run() {
        Context context;
        boolean z10;
        Context context2;
        String str;
        NativeExceptionHandler nativeExceptionHandler;
        Context context3;
        e eVar;
        String str2;
        e eVar2;
        context = this.f22529a.f22518f;
        if (!ca.a(context, "native_record_lock", 10000L)) {
            X.c("[Native] Failed to lock file for handling native crash record.", new Object[0]);
            return;
        }
        z10 = NativeCrashHandler.f22517e;
        if (!z10) {
            this.f22529a.a(999, "false");
        }
        context2 = this.f22529a.f22518f;
        str = this.f22529a.f22522j;
        nativeExceptionHandler = this.f22529a.f22521i;
        CrashDetailBean a10 = c.a(context2, str, nativeExceptionHandler);
        if (a10 != null) {
            X.c("[Native] Get crash from native record.", new Object[0]);
            eVar = this.f22529a.f22528p;
            if (!eVar.c(a10)) {
                eVar2 = this.f22529a.f22528p;
                eVar2.a(a10, 3000L, false);
            }
            str2 = this.f22529a.f22522j;
            c.a(false, str2);
        }
        this.f22529a.b();
        context3 = this.f22529a.f22518f;
        ca.b(context3, "native_record_lock");
    }
}
