package com.alimm.tanx.ui.image.glide.load.engine.prefill;

import android.graphics.Bitmap;
import ok.a;

/* loaded from: classes.dex */
public final class PreFillType {
    static final Bitmap.Config DEFAULT_CONFIG = Bitmap.Config.RGB_565;
    private final Bitmap.Config config;
    private final int height;
    private final int weight;
    private final int width;

    public static class Builder {
        private Bitmap.Config config;
        private final int height;
        private int weight;
        private final int width;

        public Builder(int i10) {
            this(i10, i10);
        }

        public PreFillType build() {
            return new PreFillType(this.width, this.height, this.config, this.weight);
        }

        public Bitmap.Config getConfig() {
            return this.config;
        }

        public Builder setConfig(Bitmap.Config config) {
            this.config = config;
            return this;
        }

        public Builder setWeight(int i10) {
            if (i10 <= 0) {
                throw new IllegalArgumentException("Weight must be > 0");
            }
            this.weight = i10;
            return this;
        }

        public Builder(int i10, int i11) {
            this.weight = 1;
            if (i10 <= 0) {
                throw new IllegalArgumentException("Width must be > 0");
            }
            if (i11 <= 0) {
                throw new IllegalArgumentException("Height must be > 0");
            }
            this.width = i10;
            this.height = i11;
        }
    }

    public PreFillType(int i10, int i11, Bitmap.Config config, int i12) {
        if (config == null) {
            throw new NullPointerException("Config must not be null");
        }
        this.width = i10;
        this.height = i11;
        this.config = config;
        this.weight = i12;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof PreFillType)) {
            return false;
        }
        PreFillType preFillType = (PreFillType) obj;
        return this.height == preFillType.height && this.width == preFillType.width && this.weight == preFillType.weight && this.config == preFillType.config;
    }

    public Bitmap.Config getConfig() {
        return this.config;
    }

    public int getHeight() {
        return this.height;
    }

    public int getWeight() {
        return this.weight;
    }

    public int getWidth() {
        return this.width;
    }

    public int hashCode() {
        return ((this.config.hashCode() + (((this.width * 31) + this.height) * 31)) * 31) + this.weight;
    }

    public String toString() {
        StringBuilder a10 = a.a("PreFillSize{width=");
        a10.append(this.width);
        a10.append(", height=");
        a10.append(this.height);
        a10.append(", config=");
        a10.append(this.config);
        a10.append(", weight=");
        a10.append(this.weight);
        a10.append('}');
        return a10.toString();
    }
}
