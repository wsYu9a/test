package com.kwad.sdk.core.report;

import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.response.model.AdTemplate;

@KsJson
/* loaded from: classes3.dex */
public class h extends com.kwad.sdk.core.response.a.a {
    public int aBQ;
    public long creativeId;
    public long llsid;
    public int score;
    public String source = "union";

    public static h ce(AdTemplate adTemplate) {
        h hVar = new h();
        hVar.creativeId = com.kwad.sdk.core.response.b.e.el(adTemplate);
        hVar.llsid = com.kwad.sdk.core.response.b.e.dY(adTemplate);
        int ep = com.kwad.sdk.core.response.b.e.ep(adTemplate);
        hVar.score = ep;
        hVar.aBQ = ep > 0 ? 1 : 0;
        return hVar;
    }

    public final String Gr() {
        return toJson().toString();
    }
}
