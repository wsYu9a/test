package com.vivo.ad.g;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* loaded from: classes4.dex */
class e {

    /* renamed from: a */
    @NonNull
    private SharedPreferences f26725a;

    private e(@NonNull SharedPreferences sharedPreferences) {
        this.f26725a = sharedPreferences;
    }

    static e a(Context context, @Nullable SharedPreferences sharedPreferences) {
        if (sharedPreferences == null) {
            sharedPreferences = d.a(context);
        }
        return new e(sharedPreferences);
    }

    private SharedPreferences e() {
        return this.f26725a;
    }

    long b() {
        return e().getLong("SECURE_UPDATE_TIME_LIMIT_SECOND", 14400L);
    }

    @Nullable
    String c() {
        return e().getString("SECURE_LAST_SECURE_VALUE", null);
    }

    long d() {
        return e().getLong("SECURE_LAST_USE_TIMESTAMP", 0L);
    }

    void a(long j2, long j3) {
        if (j2 > 0 || j3 > 0) {
            SharedPreferences.Editor edit = e().edit();
            if (j2 > 0) {
                edit.putLong("SECURE_REUSE_TIME_SECOND", j2);
            }
            if (j3 > 0) {
                edit.putLong("SECURE_UPDATE_TIME_LIMIT_SECOND", j3);
            }
            edit.apply();
        }
    }

    void a(long j2) {
        e().edit().putLong("SECURE_LAST_USE_TIMESTAMP", j2).apply();
    }

    long a() {
        return e().getLong("SECURE_REUSE_TIME_SECOND", 28800L);
    }

    void a(String str, long j2) {
        e().edit().putString("SECURE_LAST_SECURE_VALUE", str).putLong("SECURE_LAST_USE_TIMESTAMP", j2).apply();
    }
}
