package com.kwad.sdk.core.config.item;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.ksad.json.annotation.KsJson;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class h extends b<a> {

    @KsJson
    public static final class a extends com.kwad.sdk.core.response.kwai.a {
        public String adV = "";
        public String adW = "";
    }

    public h() {
        super("idMapping", new a());
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void a(SharedPreferences sharedPreferences) {
        a value = getValue();
        if (value == null) {
            value = new a();
        }
        String string = sharedPreferences.getString(getKey(), "");
        if (!TextUtils.isEmpty(string)) {
            try {
                value.parseJson(new JSONObject(b.bC(string)));
            } catch (JSONException e2) {
                com.kwad.sdk.core.d.b.printStackTraceOnly(e2);
            }
        }
        setValue(value);
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void b(SharedPreferences.Editor editor) {
        if (getValue() == null || getValue().toJson() == null) {
            editor.putString(getKey(), "");
        } else {
            editor.putString(getKey(), b.bB(getValue().toJson().toString()));
        }
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void g(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject(getKey());
        if (optJSONObject == null) {
            return;
        }
        a aVar = new a();
        aVar.parseJson(optJSONObject);
        setValue(aVar);
    }

    public final String getImei() {
        a value = getValue();
        return (value == null || TextUtils.isEmpty(value.adV)) ? "" : value.adV;
    }

    public final String getOaid() {
        a value = getValue();
        return (value == null || TextUtils.isEmpty(value.adW)) ? "" : value.adW;
    }
}
