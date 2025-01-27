package com.kwad.sdk.core.config.item;

import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public abstract class b<T> {
    private T axg;
    private T axh;
    private String mKey;

    public b(String str, T t10) {
        this(str, t10, t10);
    }

    public static String dv(String str) {
        return !TextUtils.isEmpty(str) ? com.kwad.sdk.core.a.c.dT(str) : str;
    }

    public static String dw(String str) {
        return (TextUtils.isEmpty(str) || !com.kwad.sdk.core.a.c.dV(str)) ? str : com.kwad.sdk.core.a.c.dU(str);
    }

    public final T El() {
        return this.axg;
    }

    public abstract void a(SharedPreferences sharedPreferences);

    public abstract void b(SharedPreferences.Editor editor);

    public final String getKey() {
        return this.mKey;
    }

    @Nullable
    public T getValue() {
        return this.axh;
    }

    public abstract void k(JSONObject jSONObject);

    public void setValue(T t10) {
        this.axh = t10;
    }

    private b(String str, T t10, T t11) {
        this.mKey = str;
        this.axh = t10;
        this.axg = t11;
        com.kwad.sdk.core.config.b.a(this);
    }
}
