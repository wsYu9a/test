package com.kwad.sdk.commercial.e;

import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.response.model.AdTemplate;

@KsJson
/* loaded from: classes3.dex */
public class b extends com.kwad.sdk.commercial.c.a {
    public String arW;
    public String arX;

    public static b Ck() {
        return new b();
    }

    @Override // com.kwad.sdk.commercial.c.a
    /* renamed from: bI */
    public final b setAdTemplate(AdTemplate adTemplate) {
        super.setAdTemplate(adTemplate);
        return this;
    }

    public final b cI(String str) {
        this.arW = str;
        return this;
    }

    public final b cJ(String str) {
        this.arX = str;
        return this;
    }
}
