package com.alipay.sdk.app;

import android.app.Activity;

/* loaded from: classes.dex */
public class AuthTask {

    /* renamed from: a */
    private Activity f5273a;

    public AuthTask(Activity activity) {
        this.f5273a = activity;
    }

    public synchronized String auth(String str) {
        b.b.a.f.a.a().c(this.f5273a, b.b.a.c.d.a());
        return com.alipay.sdk.util.b.a(this.f5273a, str);
    }
}
