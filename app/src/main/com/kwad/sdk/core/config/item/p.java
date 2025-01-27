package com.kwad.sdk.core.config.item;

import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class p extends b<String> {
    private static volatile String[] axo;

    public p(String str, String str2) {
        super(str, str2);
        axo = null;
    }

    public static boolean ab(long j10) {
        if (axo == null) {
            return false;
        }
        for (String str : axo) {
            if (str != null && String.valueOf(j10).equals(str.trim())) {
                return true;
            }
        }
        return false;
    }

    private static void dy(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        axo = str.split(",");
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void a(@NonNull SharedPreferences sharedPreferences) {
        String string = sharedPreferences.getString(getKey(), El());
        setValue(string);
        dy(string);
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void b(@NonNull SharedPreferences.Editor editor) {
        editor.putString(getKey(), getValue());
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void k(JSONObject jSONObject) {
        if (jSONObject == null) {
            setValue(El());
            return;
        }
        String optString = jSONObject.optString(getKey(), El());
        setValue(optString);
        dy(optString);
    }
}
