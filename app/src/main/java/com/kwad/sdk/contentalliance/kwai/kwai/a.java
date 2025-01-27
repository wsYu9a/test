package com.kwad.sdk.contentalliance.kwai.kwai;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.l;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class a {
    public long adStyle;
    public long clickTime;
    public int contentType;
    public long photoId;

    public a() {
        this.clickTime = -1L;
    }

    public a(@NonNull AdTemplate adTemplate, long j2) {
        this.clickTime = -1L;
        this.photoId = d.ch(adTemplate);
        this.clickTime = j2;
        this.adStyle = d.bW(adTemplate);
        this.contentType = d.bX(adTemplate);
    }

    @NonNull
    public static a ak(@NonNull AdTemplate adTemplate) {
        return new a(adTemplate, l.cx(adTemplate));
    }

    public final String tQ() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("contentType", this.contentType);
            jSONObject.put("adStyle", this.adStyle);
        } catch (JSONException e2) {
            com.kwad.sdk.core.d.b.printStackTrace(e2);
        }
        return jSONObject.toString();
    }
}
