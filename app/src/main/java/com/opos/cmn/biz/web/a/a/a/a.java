package com.opos.cmn.biz.web.a.a.a;

import java.lang.Thread;

/* loaded from: classes4.dex */
public class a implements Thread.UncaughtExceptionHandler {

    /* renamed from: a */
    private static a f16839a = new a();

    /* renamed from: b */
    private Thread.UncaughtExceptionHandler f16840b;

    private a() {
    }

    public static a a() {
        return f16839a;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        StringBuilder sb = new StringBuilder();
        sb.append("thread=");
        sb.append(thread != null ? thread.toString() : "null");
        com.opos.cmn.an.f.a.d("ThreadCrashHandler", sb.toString(), th);
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.f16840b;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(thread, th);
        }
    }
}
