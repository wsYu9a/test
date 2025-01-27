package com.kwad.sdk.core.adlog.b;

import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.response.model.AdTemplate;

@KsJson
/* loaded from: classes3.dex */
public class b extends com.kwad.sdk.commercial.c.a {
    public int asU;
    public String asV;
    public int asm;
    public int ate;
    public int atf;
    public long atg;
    public int retryCount;
    public int status;

    public static b CN() {
        return new b();
    }

    public final b an(long j10) {
        this.atg = j10;
        return this;
    }

    @Override // com.kwad.sdk.commercial.c.a
    /* renamed from: ca */
    public final b setAdTemplate(AdTemplate adTemplate) {
        super.setAdTemplate(adTemplate);
        return this;
    }

    public final b ct(int i10) {
        this.status = i10;
        return this;
    }

    public final b cu(int i10) {
        this.asm = i10;
        return this;
    }

    public final b cv(int i10) {
        this.retryCount = i10;
        return this;
    }

    public final b cw(int i10) {
        this.asU = i10;
        return this;
    }

    public final b cx(int i10) {
        this.ate = i10;
        return this;
    }

    public final b cy(int i10) {
        this.atf = i10;
        return this;
    }

    public final b dk(String str) {
        this.asV = str;
        return this;
    }
}
