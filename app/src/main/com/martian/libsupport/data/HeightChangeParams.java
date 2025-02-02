package com.martian.libsupport.data;

/* loaded from: classes3.dex */
public class HeightChangeParams extends WebParams {
    private float ratio;

    public float getRatio() {
        return this.ratio;
    }

    @Override // com.martian.libsupport.data.WebParams
    public String getType() {
        return "onHeightChange";
    }

    public HeightChangeParams setRatio(float f10) {
        this.ratio = f10;
        return this;
    }
}
