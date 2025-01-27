package com.kwad.sdk.core.request.model;

import com.ksad.json.annotation.KsJson;

@KsJson
/* loaded from: classes3.dex */
public class g extends com.kwad.sdk.core.response.a.a {
    public String aEc;
    public String aEd;
    public int thirdAge;
    public int thirdGender;
    public String thirdInterest;

    public static g GM() {
        return new g();
    }

    public final g eA(String str) {
        this.aEc = str;
        return this;
    }
}
