package com.aggmoread.sdk.client;

/* loaded from: classes.dex */
public class AMVideoConfigs {
    private boolean autoPlayMuted;
    private int autoPlayPolicy;
    private boolean detailPageMuted;
    private boolean enableDetailPage;
    private boolean enableUserControl;
    private boolean needCoverImage;
    private boolean needProgressBar;

    public interface AutoPlayPolicy {
        public static final int ALWAYS = 1;
        public static final int NEVER = 2;
        public static final int WIFI = 0;
    }

    public static final class Builder {
        private boolean autoPlayMuted;
        private int autoPlayPolicy;
        private boolean detailPageMuted;
        private boolean enableDetailPage;
        private boolean enableUserControl;
        private int maxVideoDuration;
        private int minVideoDuration;
        private boolean needCoverImage;
        private boolean needProgressBar;

        public Builder() {
            this.autoPlayPolicy = 1;
            this.autoPlayMuted = true;
            this.needProgressBar = true;
            this.needCoverImage = true;
            this.enableDetailPage = false;
            this.enableUserControl = false;
            this.detailPageMuted = false;
        }

        public AMVideoConfigs build() {
            AMVideoConfigs aMVideoConfigs = new AMVideoConfigs();
            aMVideoConfigs.autoPlayPolicy = this.autoPlayPolicy;
            aMVideoConfigs.autoPlayMuted = this.autoPlayMuted;
            aMVideoConfigs.needCoverImage = this.needCoverImage;
            aMVideoConfigs.needProgressBar = this.needProgressBar;
            aMVideoConfigs.enableDetailPage = this.enableDetailPage;
            aMVideoConfigs.enableUserControl = this.enableUserControl;
            aMVideoConfigs.detailPageMuted = this.detailPageMuted;
            return aMVideoConfigs;
        }

        public Builder setAutoPlayMuted(boolean z10) {
            this.autoPlayMuted = z10;
            return this;
        }

        public Builder setAutoPlayPolicy(int i10) {
            this.autoPlayPolicy = i10;
            return this;
        }

        public Builder setDetailPageMuted(boolean z10) {
            this.detailPageMuted = z10;
            return this;
        }

        public Builder setEnableDetailPage(boolean z10) {
            this.enableDetailPage = z10;
            return this;
        }

        public Builder setEnableUserControl(boolean z10) {
            this.enableUserControl = z10;
            return this;
        }

        public Builder setNeedCoverImage(boolean z10) {
            this.needCoverImage = z10;
            return this;
        }

        public Builder setNeedProgressBar(boolean z10) {
            this.needProgressBar = z10;
            return this;
        }

        public Builder(AMVideoConfigs aMVideoConfigs) {
            this.autoPlayPolicy = 1;
            this.autoPlayMuted = true;
            this.needProgressBar = true;
            this.needCoverImage = true;
            this.enableDetailPage = false;
            this.enableUserControl = false;
            this.detailPageMuted = false;
            this.autoPlayPolicy = aMVideoConfigs.getAutoPlayPolicy();
            this.autoPlayMuted = aMVideoConfigs.isAutoPlayMuted();
            this.needProgressBar = aMVideoConfigs.isNeedProgressBar();
            this.needCoverImage = aMVideoConfigs.isNeedCoverImage();
            this.enableDetailPage = aMVideoConfigs.isEnableDetailPage();
            this.enableUserControl = aMVideoConfigs.isEnableUserControl();
            this.detailPageMuted = aMVideoConfigs.isDetailPageMuted();
        }
    }

    private AMVideoConfigs() {
    }

    public int getAutoPlayPolicy() {
        return this.autoPlayPolicy;
    }

    public boolean isAutoPlayMuted() {
        return this.autoPlayMuted;
    }

    public boolean isDetailPageMuted() {
        return this.detailPageMuted;
    }

    public boolean isEnableDetailPage() {
        return this.enableDetailPage;
    }

    public boolean isEnableUserControl() {
        return this.enableUserControl;
    }

    public boolean isNeedCoverImage() {
        return this.needCoverImage;
    }

    public boolean isNeedProgressBar() {
        return this.needProgressBar;
    }
}
