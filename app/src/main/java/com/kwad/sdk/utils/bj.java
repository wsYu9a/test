package com.kwad.sdk.utils;

/* loaded from: classes3.dex */
public class bj {
    protected final int mHeight;
    protected final int mWidth;

    public bj(int i10, int i11) {
        this.mWidth = i10;
        this.mHeight = i11;
    }

    public final float OF() {
        return this.mWidth;
    }

    public final float OG() {
        return this.mHeight;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (obj instanceof bj) {
            bj bjVar = (bj) obj;
            if (this.mWidth == bjVar.mWidth && this.mHeight == bjVar.mHeight) {
                return true;
            }
        }
        return false;
    }

    public final int getHeight() {
        return this.mHeight;
    }

    public final int getWidth() {
        return this.mWidth;
    }

    public int hashCode() {
        int i10 = this.mHeight;
        int i11 = this.mWidth;
        return i10 ^ ((i11 >>> 16) | (i11 << 16));
    }

    public String toString() {
        return this.mWidth + "x" + this.mHeight;
    }
}
