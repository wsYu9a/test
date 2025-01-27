package com.shu.priory.a;

import android.os.Handler;
import android.os.Looper;

/* loaded from: classes3.dex */
final class j {

    /* renamed from: a, reason: collision with root package name */
    private static final Handler f16815a = new Handler(Looper.getMainLooper());

    public void a(Runnable runnable) {
        f16815a.post(runnable);
    }
}
