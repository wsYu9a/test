package com.kwad.sdk.core.config.item;

import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class n extends r {
    private JSONObject axn;

    public n(String str) {
        this(str, "{}");
    }

    public final int dx(String str) {
        JSONObject jSONObject;
        if (str != null && (jSONObject = this.axn) != null) {
            try {
                return jSONObject.optInt(str);
            } catch (Exception unused) {
            }
        }
        return -1;
    }

    private n(String str, String str2) {
        super(str, str2);
    }

    @Override // com.kwad.sdk.core.config.item.b
    public void setValue(String str) {
        super.setValue((n) str);
        try {
            this.axn = new JSONObject(getValue());
        } catch (NullPointerException e10) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e10);
        } catch (JSONException e11) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e11);
        }
    }
}
