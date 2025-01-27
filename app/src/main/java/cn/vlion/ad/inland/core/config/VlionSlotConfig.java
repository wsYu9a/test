package cn.vlion.ad.inland.core.config;

/* loaded from: classes.dex */
public class VlionSlotConfig {
    private float height;
    private boolean hideSkip;
    private int imageScale;
    private int interstitialCloseTime;
    private final String slotID;
    private float tolerateTime;
    private float width;

    public static class Builder {
        private float height;
        private String slotID;
        private float width;
        private float tolerateTime = 5.0f;
        private boolean hideSkip = false;
        private int imageScale = 4;
        private int interstitialCloseTime = 0;

        public VlionSlotConfig build() {
            return new VlionSlotConfig(this);
        }

        public Builder setImageScale(int i10) {
            if (i10 == 2 || i10 == 3 || i10 == 4 || i10 == 5) {
                this.imageScale = i10;
            } else {
                this.imageScale = 4;
            }
            return this;
        }

        public Builder setInterstitialCloseTime(int i10) {
            this.interstitialCloseTime = i10;
            return this;
        }

        public Builder setSize(float f10, float f11) {
            this.width = f10;
            this.height = f11;
            return this;
        }

        public Builder setSkipButtonHidden(boolean z10) {
            this.hideSkip = z10;
            return this;
        }

        public Builder setSlotID(String str) {
            this.slotID = str;
            return this;
        }

        public Builder setTolerateTime(float f10) {
            this.tolerateTime = Math.max(f10, 1.0f);
            return this;
        }
    }

    public VlionSlotConfig(Builder builder) {
        this.hideSkip = false;
        this.interstitialCloseTime = 0;
        this.slotID = builder.slotID;
        this.width = builder.width;
        this.height = builder.height;
        this.tolerateTime = builder.tolerateTime;
        this.imageScale = builder.imageScale;
        this.hideSkip = builder.hideSkip;
        this.interstitialCloseTime = builder.interstitialCloseTime;
    }

    public float getHeight() {
        return this.height;
    }

    public int getImageScale() {
        return this.imageScale;
    }

    public int getInterstitialCloseTime() {
        return this.interstitialCloseTime;
    }

    public String getSlotID() {
        return this.slotID;
    }

    public float getTolerateTime() {
        return this.tolerateTime;
    }

    public float getWidth() {
        return this.width;
    }

    public boolean isHideSkip() {
        return this.hideSkip;
    }
}
