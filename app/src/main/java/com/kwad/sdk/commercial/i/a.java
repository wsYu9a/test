package com.kwad.sdk.commercial.i;

import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.response.model.AdTemplate;

@KsJson
/* loaded from: classes3.dex */
public class a extends com.kwad.sdk.commercial.c.a {
    public String arW;
    public String ase;
    public String asf;
    public String asg;

    public static a Cq() {
        return new a();
    }

    @Override // com.kwad.sdk.commercial.c.a
    /* renamed from: bJ */
    public final a setAdTemplate(AdTemplate adTemplate) {
        super.setAdTemplate(adTemplate);
        return this;
    }

    public final a cP(String str) {
        this.asg = str;
        return this;
    }

    public final a cQ(String str) {
        this.arW = str;
        return this;
    }

    public final a cR(String str) {
        this.ase = str;
        return this;
    }

    public final a cS(String str) {
        this.asf = str;
        return this;
    }
}
