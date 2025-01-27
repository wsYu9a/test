package com.vivo.mobilead.util;

import android.os.Handler;
import android.os.Looper;

/* loaded from: classes4.dex */
public class z {

    /* renamed from: b */
    private static volatile z f30812b;

    /* renamed from: a */
    private Handler f30813a = new Handler(Looper.getMainLooper());

    private z() {
    }

    public static z b() {
        if (f30812b == null) {
            synchronized (z.class) {
                if (f30812b == null) {
                    f30812b = new z();
                }
            }
        }
        return f30812b;
    }

    public Handler a() {
        if (this.f30813a == null) {
            this.f30813a = new Handler(Looper.getMainLooper());
        }
        return this.f30813a;
    }

    public void a(Runnable runnable) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            runnable.run();
        } else {
            a().post(runnable);
        }
    }

    public void a(Runnable runnable, long j2) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            runnable.run();
        } else {
            a().postDelayed(runnable, j2);
        }
    }
}
