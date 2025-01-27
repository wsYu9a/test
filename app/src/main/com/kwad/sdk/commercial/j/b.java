package com.kwad.sdk.commercial.j;

import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.response.model.AdTemplate;

@KsJson
/* loaded from: classes3.dex */
public class b extends com.kwad.sdk.commercial.c.a {
    public String ase;
    public String asf;
    public int asm;
    public int asn;
    public int status;

    public static b Cu() {
        return new b();
    }

    @Override // com.kwad.sdk.commercial.c.a
    /* renamed from: bK */
    public final b setAdTemplate(AdTemplate adTemplate) {
        super.setAdTemplate(adTemplate);
        return this;
    }

    public final b cX(String str) {
        this.ase = str;
        return this;
    }

    public final b cY(String str) {
        this.asf = str;
        return this;
    }

    @Override // com.kwad.sdk.commercial.c.a
    /* renamed from: cZ */
    public final b setErrorMsg(String str) {
        super.setErrorMsg(str);
        return this;
    }

    public final b co(int i10) {
        this.status = i10;
        return this;
    }

    public final b cp(int i10) {
        this.asm = i10;
        return this;
    }

    public final b cq(int i10) {
        this.asn = i10;
        return this;
    }

    @Override // com.kwad.sdk.commercial.c.a
    /* renamed from: cr */
    public final b setErrorCode(int i10) {
        super.setErrorCode(i10);
        return this;
    }
}
