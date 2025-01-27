package com.kwad.sdk.core.adlog.b;

import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.response.model.AdTemplate;

@KsJson
/* loaded from: classes3.dex */
public class d extends com.kwad.sdk.commercial.c.a {
    public String asf;
    public int asm;
    public int ath;
    public int retryCount;
    public int status;

    public static d CO() {
        return new d();
    }

    public final d cA(int i10) {
        this.asm = i10;
        return this;
    }

    public final d cB(int i10) {
        this.ath = 1;
        return this;
    }

    public final d cC(int i10) {
        this.retryCount = i10;
        return this;
    }

    @Override // com.kwad.sdk.commercial.c.a
    /* renamed from: cD */
    public final d setErrorCode(int i10) {
        super.setErrorCode(i10);
        return this;
    }

    @Override // com.kwad.sdk.commercial.c.a
    /* renamed from: cb */
    public final d setAdTemplate(AdTemplate adTemplate) {
        super.setAdTemplate(adTemplate);
        return this;
    }

    public final d cz(int i10) {
        this.status = i10;
        return this;
    }

    public final d dl(String str) {
        this.asf = str;
        return this;
    }

    @Override // com.kwad.sdk.commercial.c.a
    /* renamed from: dm */
    public final d setErrorMsg(String str) {
        super.setErrorMsg(str);
        return this;
    }
}
