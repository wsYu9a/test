package com.opos.cmn.an.i;

import java.lang.Thread;

/* loaded from: classes4.dex */
public class b implements Thread.UncaughtExceptionHandler {

    /* renamed from: a */
    private static b f16542a = new b();

    /* renamed from: b */
    private Thread.UncaughtExceptionHandler f16543b;

    private b() {
    }

    public static b a() {
        return f16542a;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        StringBuilder sb = new StringBuilder();
        sb.append("thread=");
        sb.append(thread != null ? thread.toString() : "null");
        com.opos.cmn.an.f.a.d("ThreadCrashHandler", sb.toString(), th);
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.f16543b;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(thread, th);
        }
    }
}
