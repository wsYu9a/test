package com.kwad.sdk.commercial.d;

import com.ksad.json.annotation.KsJson;

@KsJson
/* loaded from: classes3.dex */
public class b extends com.kwad.sdk.commercial.c.a {
    public int adNum;
    public String adSource;
    public boolean arT;
    public boolean arU;
    public String arV;
    public String methodName;

    public static b Cj() {
        return new b();
    }

    public final b bl(boolean z10) {
        this.arT = z10;
        return this;
    }

    public final b cF(String str) {
        this.methodName = str;
        return this;
    }

    public final b cG(String str) {
        this.arV = str;
        return this;
    }

    public final b cH(String str) {
        this.adSource = str;
        return this;
    }

    public final b cj(int i10) {
        this.adNum = i10;
        return this;
    }
}
