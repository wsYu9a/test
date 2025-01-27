package com.heytap.msp.mobad.api.params;

/* loaded from: classes.dex */
public class NativeAdSize {
    public final int heightInDp;
    public final int widthInDp;

    public static class Builder {
        private int widthInDp = 0;
        private int heightInDp = 0;

        public NativeAdSize build() {
            return new NativeAdSize(this);
        }

        public Builder setHeightInDp(int i2) {
            this.heightInDp = i2;
            return this;
        }

        public Builder setWidthInDp(int i2) {
            this.widthInDp = i2;
            return this;
        }
    }

    public NativeAdSize(Builder builder) {
        this.widthInDp = builder.widthInDp;
        this.heightInDp = builder.heightInDp;
    }

    public String toString() {
        return "NativeAdSize{widthInDp=" + this.widthInDp + ", heightInDp=" + this.heightInDp + '}';
    }
}
