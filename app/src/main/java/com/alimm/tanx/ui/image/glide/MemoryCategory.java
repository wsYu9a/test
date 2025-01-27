package com.alimm.tanx.ui.image.glide;

/* loaded from: classes.dex */
public enum MemoryCategory {
    LOW(0.5f),
    NORMAL(1.0f),
    HIGH(1.5f);

    private float multiplier;

    MemoryCategory(float f10) {
        this.multiplier = f10;
    }

    public float getMultiplier() {
        return this.multiplier;
    }
}
