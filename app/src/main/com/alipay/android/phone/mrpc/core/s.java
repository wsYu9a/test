package com.alipay.android.phone.mrpc.core;

import android.content.Context;

/* loaded from: classes.dex */
public final class s {

    /* renamed from: a, reason: collision with root package name */
    public static Boolean f6418a;

    public static final boolean a(Context context) {
        Boolean bool = f6418a;
        if (bool != null) {
            return bool.booleanValue();
        }
        try {
            boolean z10 = (context.getPackageManager().getApplicationInfo(context.getPackageName(), 0).flags & 2) != 0;
            f6418a = Boolean.valueOf(z10);
            return z10;
        } catch (Exception unused) {
            return false;
        }
    }
}
