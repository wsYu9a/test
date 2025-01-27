package com.kwad.sdk.core.webview.request;

import com.kwad.sdk.core.d.c;
import com.kwad.sdk.core.network.d;
import com.kwad.sdk.core.network.p;
import com.kwad.sdk.h;
import com.kwad.sdk.utils.x;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class a extends d {
    private String aJk;
    private String mUrl;

    public a(String str, String str2, String str3) {
        JSONObject jSONObject;
        this.mUrl = str;
        this.aJk = str2;
        try {
            jSONObject = new JSONObject(str3);
        } catch (JSONException e10) {
            c.printStackTrace(e10);
            jSONObject = null;
        }
        c.d("WebCardGetDataRequest", "mBodyParams1 size=" + this.mBodyParams.length());
        if (jSONObject != null) {
            c.d("WebCardGetDataRequest", "paramsJsonObj=" + jSONObject.toString());
        }
        x.a(this.mBodyParams, jSONObject, true);
        c.d("WebCardGetDataRequest", "mBodyParams2 size=" + this.mBodyParams.length());
        addHeader("user-agent", p.getUserAgent());
        c.d("WebCardGetDataRequest", "user-agent" + p.getUserAgent());
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.f
    public String getUrl() {
        return h.ze() + this.mUrl;
    }
}
