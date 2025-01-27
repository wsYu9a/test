package com.vivo.mobilead.splash;

import android.text.TextUtils;
import android.view.View;
import androidx.annotation.LayoutRes;
import com.vivo.mobilead.BaseAdParams;

/* loaded from: classes4.dex */
public class SplashAdParams extends BaseAdParams {
    public static final int ORIENTATION_LANDSCAPE = 2;
    public static final int ORIENTATION_PORTRAIT = 1;
    private String appDesc;
    private String appTitle;
    private View customView;
    private int customViewRes;
    private int fetchTimeout;
    private boolean isSupportCustomView;
    private String splashLinkKey;
    private int splashOrientation;

    public static class Builder extends BaseAdParams.a {
        private static final int MAX_FETCH_TIMEOUT = 5000;
        private static final int MIX_FETCH_TIMEOUT = 3000;
        private String appDesc;
        private String appTitle;
        private View customView;
        private int customViewRes;
        private int fetchTimeout;
        private boolean isSupportCustomView;
        private int splashOrientation;

        public Builder(String str) {
            super(str);
            this.fetchTimeout = 5000;
            this.splashOrientation = 1;
        }

        public Builder addCustomSplashBottomView(View view) {
            if (view != null) {
                this.customView = view;
            }
            return this;
        }

        public Builder setAppDesc(String str) {
            if (!TextUtils.isEmpty(str)) {
                this.appDesc = str;
            }
            return this;
        }

        public Builder setAppTitle(String str) {
            if (!TextUtils.isEmpty(str)) {
                this.appTitle = str;
            }
            return this;
        }

        public Builder setFetchTimeout(int i2) {
            if (i2 >= 3000 && i2 <= 5000) {
                this.fetchTimeout = i2;
            }
            return this;
        }

        public Builder setSplashOrientation(int i2) {
            this.splashOrientation = i2;
            return this;
        }

        public Builder setSupportCustomView(boolean z) {
            this.isSupportCustomView = z;
            return this;
        }

        public Builder addCustomSplashBottomView(@LayoutRes int i2) {
            this.customViewRes = i2;
            return this;
        }

        @Override // com.vivo.mobilead.BaseAdParams.a
        public SplashAdParams build() {
            return new SplashAdParams(this);
        }
    }

    public SplashAdParams(Builder builder) {
        super(builder);
        this.fetchTimeout = builder.fetchTimeout;
        this.appTitle = builder.appTitle;
        this.appDesc = builder.appDesc;
        this.customView = builder.customView;
        this.isSupportCustomView = builder.isSupportCustomView;
        this.customViewRes = builder.customViewRes;
        this.splashOrientation = builder.splashOrientation;
    }

    public String getAppDesc() {
        return this.appDesc;
    }

    public String getAppTitle() {
        return this.appTitle;
    }

    public View getCustomView() {
        return this.customView;
    }

    public int getCustomViewRes() {
        return this.customViewRes;
    }

    public int getFetchTimeout() {
        return this.fetchTimeout;
    }

    public int getSplashOrientation() {
        return this.splashOrientation;
    }

    public String getTaskKey() {
        return this.splashLinkKey;
    }

    public boolean isSupportCustomView() {
        return this.isSupportCustomView;
    }

    public void setTaskKey(String str) {
        this.splashLinkKey = str;
    }
}
