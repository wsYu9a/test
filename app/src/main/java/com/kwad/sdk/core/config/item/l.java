package com.kwad.sdk.core.config.item;

import android.content.SharedPreferences;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class l<ValueType> extends b<JSONObject> {
    public l(String str) {
        super(str, new JSONObject());
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void a(SharedPreferences sharedPreferences) {
        JSONObject jSONObject;
        JSONObject value = getValue();
        if (value == null) {
            value = new JSONObject();
        }
        try {
            jSONObject = new JSONObject(sharedPreferences.getString(getKey(), ""));
        } catch (Throwable unused) {
            jSONObject = null;
        }
        if (jSONObject != null) {
            value = jSONObject;
        }
        setValue(value);
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void b(SharedPreferences.Editor editor) {
        if (getValue() != null) {
            editor.putString(getKey(), getValue().toString());
        } else {
            editor.putString(getKey(), "");
        }
    }

    public final ValueType getValue(String str) {
        try {
            if (getValue().has(str)) {
                return (ValueType) getValue().get(str);
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void k(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject == null || (optJSONObject = jSONObject.optJSONObject(getKey())) == null) {
            setValue(El());
        } else {
            setValue(optJSONObject);
        }
    }
}
