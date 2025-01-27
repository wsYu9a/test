package com.martian.ttbook.sdk.client;

/* loaded from: classes4.dex */
public final class VideoSettings {
    public static VideoSettings DEFAULT = new Builder().build();
    private boolean autoPlayMuted;
    private int autoPlayPolicy;
    private int containerRender;
    private boolean enableDetailPage;
    private boolean enableUserControl;
    private int maxVideoDuration;
    private int minVideoDuration;
    private boolean needCoverImage;
    private boolean needProgressBar;
    private VideoAdEventListener videoAdEventListener;
    private int videoPlayPolicy;

    public interface AutoPlayPolicy {
        public static final int ALWAYS = 1;
        public static final int NEVER = 2;
        public static final int WIFI = 0;
    }

    public static final class Builder {
        private boolean autoPlayMuted;
        private int autoPlayPolicy;
        private int containerRender;
        private boolean enableDetailPage;
        private boolean enableUserControl;
        private int maxVideoDuration;
        private int minVideoDuration;
        private boolean needCoverImage;
        private boolean needProgressBar;
        private VideoAdEventListener videoAdEventListener;
        private int videoPlayPolicy;

        public Builder() {
            this.videoPlayPolicy = 1;
            this.containerRender = 1;
            this.autoPlayPolicy = 1;
            this.autoPlayMuted = true;
            this.needProgressBar = true;
            this.needCoverImage = true;
            this.enableDetailPage = false;
            this.enableUserControl = false;
        }

        public Builder(VideoSettings videoSettings) {
            this.videoPlayPolicy = 1;
            this.containerRender = 1;
            this.autoPlayPolicy = 1;
            this.autoPlayMuted = true;
            this.needProgressBar = true;
            this.needCoverImage = true;
            this.enableDetailPage = false;
            this.enableUserControl = false;
            this.videoPlayPolicy = videoSettings.getVideoPlayPolicy();
            this.containerRender = videoSettings.getContainerRender();
            this.autoPlayPolicy = videoSettings.getAutoPlayPolicy();
            this.autoPlayMuted = videoSettings.isAutoPlayMuted();
            this.maxVideoDuration = videoSettings.getMaxVideoDuration();
            this.minVideoDuration = videoSettings.getMinVideoDuration();
            this.needProgressBar = videoSettings.isNeedProgressBar();
            this.needCoverImage = videoSettings.isNeedCoverImage();
            this.enableDetailPage = videoSettings.isEnableDetailPage();
            this.enableUserControl = videoSettings.isEnableUserControl();
            this.videoAdEventListener = videoSettings.getVideoAdEventListener();
        }

        public VideoSettings build() {
            VideoSettings videoSettings = new VideoSettings();
            videoSettings.autoPlayPolicy = this.autoPlayPolicy;
            videoSettings.videoPlayPolicy = this.videoPlayPolicy;
            videoSettings.containerRender = this.containerRender;
            videoSettings.autoPlayMuted = this.autoPlayMuted;
            videoSettings.maxVideoDuration = this.maxVideoDuration;
            videoSettings.minVideoDuration = this.minVideoDuration;
            videoSettings.needCoverImage = this.needCoverImage;
            videoSettings.needProgressBar = this.needProgressBar;
            videoSettings.enableDetailPage = this.enableDetailPage;
            videoSettings.enableUserControl = this.enableUserControl;
            videoSettings.videoAdEventListener = this.videoAdEventListener;
            return videoSettings;
        }

        public Builder setAutoPlayMuted(boolean z) {
            this.autoPlayMuted = z;
            return this;
        }

        public Builder setAutoPlayPolicy(int i2) {
            this.autoPlayPolicy = i2;
            return this;
        }

        public Builder setContainerRender(int i2) {
            this.containerRender = i2;
            return this;
        }

        public Builder setEnableDetailPage(boolean z) {
            this.enableDetailPage = z;
            return this;
        }

        public Builder setEnableUserControl(boolean z) {
            this.enableUserControl = z;
            return this;
        }

        public Builder setMaxVideoDuration(int i2) {
            this.maxVideoDuration = i2;
            return this;
        }

        public Builder setMinVideoDuration(int i2) {
            this.minVideoDuration = i2;
            return this;
        }

        public Builder setNeedCoverImage(boolean z) {
            this.needCoverImage = z;
            return this;
        }

        public Builder setNeedProgressBar(boolean z) {
            this.needProgressBar = z;
            return this;
        }

        public Builder setVideoEventListener(VideoAdEventListener videoAdEventListener) {
            this.videoAdEventListener = videoAdEventListener;
            return this;
        }

        public Builder setVideoPlayPolicy(int i2) {
            this.videoPlayPolicy = i2;
            return this;
        }
    }

    public interface ContainerRender {
        public static final int DEV = 2;
        public static final int SDK = 1;
        public static final int UNKNOWN = 0;
    }

    public interface PlayPolicy {
        public static final int AUTO = 1;
        public static final int MANUAL = 2;
        public static final int UNKNOWN = 0;
    }

    private VideoSettings() {
        this.enableUserControl = true;
    }

    /* synthetic */ VideoSettings(AnonymousClass1 anonymousClass1) {
        this();
    }

    public int getAutoPlayPolicy() {
        return this.autoPlayPolicy;
    }

    public int getContainerRender() {
        return this.containerRender;
    }

    public int getMaxVideoDuration() {
        return this.maxVideoDuration;
    }

    public int getMinVideoDuration() {
        return this.minVideoDuration;
    }

    public VideoAdEventListener getVideoAdEventListener() {
        return this.videoAdEventListener;
    }

    public int getVideoPlayPolicy() {
        return this.videoPlayPolicy;
    }

    public boolean isAutoPlayMuted() {
        return this.autoPlayMuted;
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

    public String toString() {
        return "VideoSettings{maxVideoDuration=" + this.maxVideoDuration + ", minVideoDuration=" + this.minVideoDuration + ", videoPlayPolicy=" + this.videoPlayPolicy + ", containerRender=" + this.containerRender + ", autoPlayPolicy=" + this.autoPlayPolicy + ", autoPlayMuted=" + this.autoPlayMuted + ", needProgressBar=" + this.needProgressBar + ", needCoverImage=" + this.needCoverImage + ", enableDetailPage=" + this.enableDetailPage + ", enableUserControl=" + this.enableUserControl + ", listener=" + this.videoAdEventListener + '}';
    }
}
