package com.vivo.ad.g;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.NonNull;

/* loaded from: classes4.dex */
class d {

    /* renamed from: a */
    private static volatile SharedPreferences f26724a;

    d() {
    }

    @NonNull
    static SharedPreferences a(Context context) {
        if (f26724a == null) {
            synchronized (d.class) {
                if (f26724a == null) {
                    f26724a = context.getSharedPreferences("secure_appstore_cache", 0);
                }
            }
        }
        return f26724a;
    }
}
