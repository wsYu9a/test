package com.martian.libugrowth.request;

import v8.a;

/* loaded from: classes3.dex */
public class AbParams extends UGrowthHttpGetParams {

    @a
    private String value;

    @Override // u8.b
    public String getRequestMethod() {
        return "ab/options";
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String str) {
        this.value = str;
    }
}
