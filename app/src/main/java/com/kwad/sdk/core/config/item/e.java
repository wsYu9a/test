package com.kwad.sdk.core.config.item;

import android.content.SharedPreferences;
import com.kwad.sdk.service.ServiceProvider;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class e extends b<JSONObject> {
    public e() {
        super(uZ(), new JSONObject());
    }

    private static String uZ() {
        com.kwad.sdk.service.kwai.e eVar = (com.kwad.sdk.service.kwai.e) ServiceProvider.get(com.kwad.sdk.service.kwai.e.class);
        return (eVar == null || !eVar.getIsExternal()) ? "commercialReportConf" : "commercialExternalReportConf";
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void a(SharedPreferences sharedPreferences) {
        JSONObject value = getValue();
        if (value == null) {
            value = new JSONObject();
        }
        JSONObject jSONObject = null;
        try {
            jSONObject = new JSONObject(sharedPreferences.getString(getKey(), ""));
        } catch (Throwable unused) {
        }
        if (jSONObject != null) {
            value = jSONObject;
        }
        setValue(value);
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void b(SharedPreferences.Editor editor) {
        String key;
        String str;
        if (getValue() != null) {
            key = getKey();
            str = getValue().toString();
        } else {
            key = getKey();
            str = "";
        }
        editor.putString(key, str);
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void g(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject == null || (optJSONObject = jSONObject.optJSONObject(getKey())) == null) {
            setValue(uX());
        } else {
            setValue(optJSONObject);
        }
    }
}
