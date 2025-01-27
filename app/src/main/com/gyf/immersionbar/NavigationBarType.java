package com.gyf.immersionbar;

/* loaded from: classes2.dex */
public enum NavigationBarType {
    CLASSIC(0),
    GESTURES(1),
    GESTURES_THREE_STAGE(2),
    DOUBLE(3),
    UNKNOWN(-1);

    private final int type;

    NavigationBarType(int i10) {
        this.type = i10;
    }

    public int getType() {
        return this.type;
    }
}
