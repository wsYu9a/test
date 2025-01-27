package com.vivo.mobilead.model;

/* loaded from: classes.dex */
public class VAdConfig {
    private VCustomController customController;
    private boolean isDebug;
    private String mediaId;
    private VThirdSdk vThirdSdk;

    public static class Builder {
        private VCustomController customController;
        private boolean isDebug;
        private String mediaId;
        private VThirdSdk vThirdSdk;

        public VAdConfig build() {
            VAdConfig vAdConfig = new VAdConfig();
            vAdConfig.customController = this.customController;
            vAdConfig.isDebug = this.isDebug;
            vAdConfig.mediaId = this.mediaId;
            vAdConfig.vThirdSdk = this.vThirdSdk;
            return vAdConfig;
        }

        public Builder setCustomController(VCustomController vCustomController) {
            this.customController = vCustomController;
            return this;
        }

        public Builder setDebug(boolean z) {
            this.isDebug = z;
            return this;
        }

        public Builder setMediaId(String str) {
            this.mediaId = str;
            return this;
        }

        public Builder setThirdSdk(VThirdSdk vThirdSdk) {
            this.vThirdSdk = vThirdSdk;
            return this;
        }
    }

    public VCustomController getCustomController() {
        return this.customController;
    }

    public String getMediaId() {
        return this.mediaId;
    }

    public VThirdSdk getThirdSdk() {
        return this.vThirdSdk;
    }

    public boolean isDebug() {
        return this.isDebug;
    }
}
