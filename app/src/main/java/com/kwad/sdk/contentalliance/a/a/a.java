package com.kwad.sdk.contentalliance.a.a;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.m;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class a {
    public long adStyle;
    public long clickTime;
    public int contentType;
    public long photoId;

    public a() {
        this.clickTime = -1L;
    }

    @NonNull
    public static a bL(@NonNull AdTemplate adTemplate) {
        return new a(adTemplate, m.eB(adTemplate));
    }

    public final String Cy() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("contentType", this.contentType);
            jSONObject.put("adStyle", this.adStyle);
        } catch (JSONException e10) {
            c.printStackTrace(e10);
        }
        return jSONObject.toString();
    }

    public a(@NonNull AdTemplate adTemplate, long j10) {
        this.clickTime = -1L;
        this.photoId = e.eh(adTemplate);
        this.clickTime = j10;
        this.adStyle = e.dW(adTemplate);
        this.contentType = e.dX(adTemplate);
    }
}
