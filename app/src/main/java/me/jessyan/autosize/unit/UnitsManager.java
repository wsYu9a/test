package me.jessyan.autosize.unit;

import me.jessyan.autosize.utils.Preconditions;

/* loaded from: classes4.dex */
public class UnitsManager {
    private float mDesignHeight;
    private float mDesignWidth;
    private boolean isSupportDP = true;
    private boolean isSupportSP = true;
    private Subunits mSupportSubunits = Subunits.NONE;
    private boolean isSupportScreenSizeDP = false;

    public float getDesignHeight() {
        return this.mDesignHeight;
    }

    public float getDesignWidth() {
        return this.mDesignWidth;
    }

    public Subunits getSupportSubunits() {
        return this.mSupportSubunits;
    }

    public boolean isSupportDP() {
        return this.isSupportDP;
    }

    public boolean isSupportSP() {
        return this.isSupportSP;
    }

    public boolean isSupportScreenSizeDP() {
        return this.isSupportScreenSizeDP;
    }

    public UnitsManager setDesignHeight(float f10) {
        Preconditions.checkArgument(f10 > 0.0f, "designHeight must be > 0");
        this.mDesignHeight = f10;
        return this;
    }

    public UnitsManager setDesignSize(float f10, float f11) {
        setDesignWidth(f10);
        setDesignHeight(f11);
        return this;
    }

    public UnitsManager setDesignWidth(float f10) {
        Preconditions.checkArgument(f10 > 0.0f, "designWidth must be > 0");
        this.mDesignWidth = f10;
        return this;
    }

    public UnitsManager setSupportDP(boolean z10) {
        this.isSupportDP = z10;
        return this;
    }

    public UnitsManager setSupportSP(boolean z10) {
        this.isSupportSP = z10;
        return this;
    }

    public UnitsManager setSupportScreenSizeDP(boolean z10) {
        this.isSupportScreenSizeDP = z10;
        return this;
    }

    public UnitsManager setSupportSubunits(Subunits subunits) {
        this.mSupportSubunits = (Subunits) Preconditions.checkNotNull(subunits, "The supportSubunits can not be null, use Subunits.NONE instead");
        return this;
    }
}
