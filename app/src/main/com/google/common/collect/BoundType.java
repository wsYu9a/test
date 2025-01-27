package com.google.common.collect;

@a5.b
@e5.m
/* loaded from: classes2.dex */
public enum BoundType {
    OPEN(false),
    CLOSED(true);

    final boolean inclusive;

    BoundType(boolean z10) {
        this.inclusive = z10;
    }

    public static BoundType forBoolean(boolean z10) {
        return z10 ? CLOSED : OPEN;
    }
}
