package com.kwad.sdk.core.config.item;

import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public abstract class b<T> {
    private T adT;
    private T adU;
    private String mKey;

    public b(String str, T t) {
        this(str, t, t);
    }

    private b(String str, T t, T t2) {
        this.mKey = str;
        this.adU = t;
        this.adT = t2;
        com.kwad.sdk.core.config.b.a(this);
    }

    public static String bB(String str) {
        return !TextUtils.isEmpty(str) ? com.kwad.sdk.core.kwai.c.bW(str) : str;
    }

    public static String bC(String str) {
        return (TextUtils.isEmpty(str) || !com.kwad.sdk.core.kwai.c.bY(str)) ? str : com.kwad.sdk.core.kwai.c.bX(str);
    }

    public abstract void a(SharedPreferences sharedPreferences);

    public abstract void b(SharedPreferences.Editor editor);

    public abstract void g(JSONObject jSONObject);

    public final String getKey() {
        return this.mKey;
    }

    @Nullable
    public T getValue() {
        return this.adU;
    }

    public final void setValue(T t) {
        this.adU = t;
    }

    public final T uX() {
        return this.adT;
    }
}
