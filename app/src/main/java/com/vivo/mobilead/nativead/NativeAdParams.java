package com.vivo.mobilead.nativead;

import com.vivo.mobilead.BaseAdParams;

/* loaded from: classes4.dex */
public class NativeAdParams extends BaseAdParams {
    private boolean mIsUsePrivacyAndPermission;

    public static class Builder extends BaseAdParams.a {
        private boolean isUsePrivacyAndPermission;

        public Builder(String str) {
            super(str);
            this.isUsePrivacyAndPermission = false;
        }

        public Builder setUsePrivacyAndPermission(boolean z) {
            this.isUsePrivacyAndPermission = z;
            return this;
        }

        @Override // com.vivo.mobilead.BaseAdParams.a
        public NativeAdParams build() {
            return new NativeAdParams(this);
        }

        @Override // com.vivo.mobilead.BaseAdParams.a
        public Builder setAdCount(int i2) {
            super.setAdCount(i2);
            return this;
        }

        @Override // com.vivo.mobilead.BaseAdParams.a
        public Builder setFloorPrice(int i2) {
            super.setFloorPrice(i2);
            return this;
        }

        @Override // com.vivo.mobilead.BaseAdParams.a
        public Builder setWxAppId(String str) {
            super.setWxAppId(str);
            return this;
        }
    }

    public NativeAdParams(Builder builder) {
        super(builder);
        this.mIsUsePrivacyAndPermission = builder.isUsePrivacyAndPermission;
    }

    public boolean getmIsUsePrivacyAndPermission() {
        return this.mIsUsePrivacyAndPermission;
    }
}
