package com.sigmob.sdk.base.models;

import kotlin.text.Typography;

/* loaded from: classes4.dex */
public class CurrentAppOrientation {
    private final boolean locked;
    private final String orientation;

    public CurrentAppOrientation(String str, boolean z10) {
        this.orientation = str;
        this.locked = z10;
    }

    public String toString() {
        return "\"appOrientation\"={\"orientation\"=\"" + this.orientation + Typography.quote + ", \"locked\"=" + this.locked + '}';
    }
}
