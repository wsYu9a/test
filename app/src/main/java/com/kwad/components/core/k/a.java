package com.kwad.components.core.k;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.kwad.components.core.n.kwai.b;
import com.kwad.components.core.response.model.AdResultData;
import com.kwad.sdk.core.network.m;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class a extends m<com.kwad.components.core.n.a, AdResultData> {
    private b JW;

    public a(b bVar) {
        this.JW = bVar;
    }

    @Override // com.kwad.sdk.core.network.m
    /* renamed from: d */
    public void afterParseData(AdResultData adResultData) {
        super.afterParseData(adResultData);
        e(adResultData);
    }

    private static void e(AdResultData adResultData) {
        com.kwad.components.core.m.a pb;
        int i2;
        for (AdTemplate adTemplate : adResultData.getProceedTemplateList()) {
            AdInfo cb = d.cb(adTemplate);
            if (com.kwad.sdk.core.response.a.a.aV(cb)) {
                if (com.kwad.sdk.core.response.a.a.aT(cb).size() == 0) {
                    pb = com.kwad.components.core.m.a.pb();
                    i2 = 21005;
                    pb.g(adTemplate, i2);
                }
            } else if (com.kwad.sdk.core.response.a.a.aZ(cb) && TextUtils.isEmpty(com.kwad.sdk.core.response.a.a.E(cb))) {
                pb = com.kwad.components.core.m.a.pb();
                i2 = 21006;
                pb.g(adTemplate, i2);
            }
        }
    }

    @Override // com.kwad.sdk.core.network.m
    @NonNull
    /* renamed from: aj */
    public AdResultData parseData(String str) {
        JSONObject jSONObject = new JSONObject(str);
        AdResultData adResultData = new AdResultData(this.JW.Ow);
        adResultData.parseJson(jSONObject);
        return adResultData;
    }

    @Override // com.kwad.sdk.core.network.a
    @NonNull
    /* renamed from: mc */
    public com.kwad.components.core.n.a createRequest() {
        return new com.kwad.components.core.n.a(this.JW);
    }
}
