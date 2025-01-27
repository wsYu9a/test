package com.wbl.ad.yzz.config;

import com.bytedance.sdk.openadsdk.TTCustomController;

/* loaded from: classes5.dex */
public final class AdInitConfig {
    private TTCustomController ttCustomController;
    private YzzCustomController yzzCustomController;

    public static class Builder {
        private TTCustomController ttCustomController;
        private YzzCustomController yzzCustomController;

        public AdInitConfig build() {
            AdInitConfig adInitConfig = new AdInitConfig();
            adInitConfig.ttCustomController = this.ttCustomController;
            adInitConfig.yzzCustomController = this.yzzCustomController;
            return adInitConfig;
        }

        public Builder customController(TTCustomController tTCustomController) {
            this.ttCustomController = tTCustomController;
            return this;
        }

        public Builder yzzCustomController(YzzCustomController yzzCustomController) {
            this.yzzCustomController = yzzCustomController;
            return this;
        }
    }

    public TTCustomController getTtCustomController() {
        return this.ttCustomController;
    }

    public YzzCustomController getYzzCustomController() {
        return this.yzzCustomController;
    }

    public String toString() {
        return "AdInitConfig{ttCustomController=" + this.ttCustomController + ", yzzCustomController=" + this.yzzCustomController + '}';
    }
}
