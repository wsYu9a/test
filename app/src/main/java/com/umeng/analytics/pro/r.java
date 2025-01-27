package com.umeng.analytics.pro;

import com.umeng.analytics.AnalyticsConfig;
import java.lang.Thread;

/* loaded from: classes4.dex */
public class r implements Thread.UncaughtExceptionHandler {

    /* renamed from: a */
    private Thread.UncaughtExceptionHandler f24141a;

    /* renamed from: b */
    private v f24142b;

    public r() {
        if (Thread.getDefaultUncaughtExceptionHandler() == this) {
            return;
        }
        this.f24141a = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    public void a(v vVar) {
        this.f24142b = vVar;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th2) {
        a(th2);
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.f24141a;
        if (uncaughtExceptionHandler == null || uncaughtExceptionHandler == Thread.getDefaultUncaughtExceptionHandler()) {
            return;
        }
        this.f24141a.uncaughtException(thread, th2);
    }

    private void a(Throwable th2) {
        if (AnalyticsConfig.CATCH_EXCEPTION) {
            this.f24142b.a(th2);
        } else {
            this.f24142b.a(null);
        }
    }
}
