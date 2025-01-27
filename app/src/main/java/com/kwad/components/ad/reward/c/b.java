package com.kwad.components.ad.reward.c;

import com.ksad.json.annotation.KsJson;

@KsJson
/* loaded from: classes2.dex */
public class b extends com.kwad.sdk.core.response.a.a {
    public static int STATUS_NONE = 2;
    public static int sM = 1;
    public static int sN = 3;
    public int sO;
    public int sP;

    public b() {
        this.sO = STATUS_NONE;
    }

    public final void N(int i10) {
        this.sP = i10;
    }

    public final int getType() {
        return this.sO;
    }

    public final int hj() {
        return this.sP;
    }

    public b(int i10) {
        this.sO = 1;
    }
}
