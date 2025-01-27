package com.martian.ttbook.sdk.client;

import b.d.e.a.j.d;

/* loaded from: classes.dex */
public class SdkConfiguration extends d {
    public static final SdkConfiguration DEFAULT = new SdkConfiguration();
    private int agreePrivacy;
    private String appName;
    private String oaid;
    private SdkPrivacyController privacyController;
    private boolean useTextureView;

    public static class Builder extends d {
        private int agreePrivacy;
        private String appName;
        private String oaid;
        private SdkPrivacyController privacyController;
        private boolean useTextureView;

        public Builder() {
            this.agreePrivacy = -1;
        }

        public Builder(SdkConfiguration sdkConfiguration) {
            this.agreePrivacy = -1;
            this.appName = sdkConfiguration.getAppName();
            this.agreePrivacy = sdkConfiguration.isAgreePrivacy();
            this.useTextureView = sdkConfiguration.isUseTextureView();
            this.oaid = sdkConfiguration.oaid;
            this.privacyController = sdkConfiguration.privacyController;
            append(sdkConfiguration);
        }

        @Override // b.d.e.a.j.d
        public Builder append(String str, int i2) {
            super.append(str, i2);
            return this;
        }

        @Override // b.d.e.a.j.d
        public Builder append(String str, String str2) {
            super.append(str, str2);
            return this;
        }

        public SdkConfiguration build() {
            SdkConfiguration sdkConfiguration = new SdkConfiguration();
            sdkConfiguration.appName = this.appName;
            sdkConfiguration.agreePrivacy = this.agreePrivacy;
            sdkConfiguration.useTextureView = this.useTextureView;
            sdkConfiguration.oaid = this.oaid;
            sdkConfiguration.privacyController = this.privacyController;
            sdkConfiguration.append(this);
            return sdkConfiguration;
        }

        public Builder setAgreePrivacy(boolean z) {
            this.agreePrivacy = z ? 1 : 0;
            return this;
        }

        public Builder setAppName(String str) {
            this.appName = str;
            return this;
        }

        public Builder setOaid(String str) {
            this.oaid = str;
            return this;
        }

        public Builder setPrivacyController(SdkPrivacyController sdkPrivacyController) {
            this.privacyController = sdkPrivacyController;
            return this;
        }

        public Builder setTextureView(boolean z) {
            this.useTextureView = z;
            return this;
        }
    }

    /* loaded from: classes4.dex */
    public interface Parameters {
        public static final int DEFAULT_ESP_VALUE = -1;
        public static final String KEY_CFG_ESP = "com.sdk.key.CFG_ESP";
        public static final int VALUE_ESP_1 = 1;
        public static final int VALUE_ESP_10 = 128;
        public static final int VALUE_ESP_11 = 256;
        public static final int VALUE_ESP_12 = 512;
        public static final int VALUE_ESP_13 = 1024;
        public static final int VALUE_ESP_14 = 1984;
        public static final int VALUE_ESP_2 = 2;
        public static final int VALUE_ESP_3 = 4;
        public static final int VALUE_ESP_4 = 8;
        public static final int VALUE_ESP_5 = 3;
        public static final int VALUE_ESP_6 = 12;
        public static final int VALUE_ESP_7 = 16;
        public static final int VALUE_ESP_8 = 32;
        public static final int VALUE_ESP_9 = 64;
    }

    private SdkConfiguration() {
        this.agreePrivacy = -1;
        this.useTextureView = false;
    }

    /* synthetic */ SdkConfiguration(AnonymousClass1 anonymousClass1) {
        this();
    }

    public String getAppName() {
        return this.appName;
    }

    public String getOaid() {
        return this.oaid;
    }

    public SdkPrivacyController getPrivacyController() {
        return this.privacyController;
    }

    public boolean hasParameterBitValue(String str, int i2) {
        return has(str) && (getInt(str, -1) & i2) != 0;
    }

    public int isAgreePrivacy() {
        return this.agreePrivacy;
    }

    public boolean isUseTextureView() {
        return this.useTextureView;
    }

    public String toString() {
        return "SdkConfiguration{appName='" + this.appName + "'agreePrivacy='" + this.agreePrivacy + "'useTextureView='" + this.useTextureView + "'oaid='" + this.oaid + "'params=" + getJSONAppender().toString() + '}';
    }
}
