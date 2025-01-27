package com.jd.android.sdk.coreinfo;

/* loaded from: classes2.dex */
public class ScreenSize {
    public int heightPixels;
    public int widthPixels;

    public ScreenSize(int i10, int i11) {
        this.widthPixels = i10;
        this.heightPixels = i11;
    }

    public String toString() {
        return this.widthPixels + "," + this.heightPixels;
    }
}
