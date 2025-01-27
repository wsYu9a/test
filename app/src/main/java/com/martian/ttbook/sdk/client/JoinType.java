package com.martian.ttbook.sdk.client;

import com.martian.ads.ad.AdConfig;

/* loaded from: classes4.dex */
public enum JoinType {
    DEFAULT(2, AdConfig.UnionType.DEFAULT),
    SDK(2, "SDK"),
    API(1, AdConfig.UnionType.API);

    private final int valueInt;
    private final String valueString;

    JoinType(int i2, String str) {
        this.valueInt = i2;
        this.valueString = str;
    }

    public static JoinType to(int i2) {
        JoinType joinType = API;
        if (i2 == joinType.valueInt) {
            return joinType;
        }
        JoinType joinType2 = SDK;
        return i2 == joinType2.valueInt ? joinType2 : DEFAULT;
    }

    public int getIntValue() {
        return this.valueInt;
    }

    public String getStringValue() {
        return this.valueString;
    }
}
