package com.kwad.sdk.core.config.item;

import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class n extends b<String> {
    private static volatile String[] aea;

    public n(String str, String str2) {
        super(str, str2);
        aea = null;
    }

    public static boolean D(long j2) {
        if (aea == null) {
            return false;
        }
        for (String str : aea) {
            if (str != null && String.valueOf(j2).equals(str.trim())) {
                return true;
            }
        }
        return false;
    }

    private static void bD(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        aea = str.split(",");
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void a(@NonNull SharedPreferences sharedPreferences) {
        String string = sharedPreferences.getString(getKey(), uX());
        setValue(string);
        bD(string);
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void b(@NonNull SharedPreferences.Editor editor) {
        editor.putString(getKey(), getValue());
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void g(JSONObject jSONObject) {
        if (jSONObject == null) {
            setValue(uX());
            return;
        }
        String optString = jSONObject.optString(getKey(), uX());
        setValue(optString);
        bD(optString);
    }
}
