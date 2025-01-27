package com.vivo.mobilead.unified.base;

import com.vivo.mobilead.model.BackUrlInfo;
import com.vivo.mobilead.util.w0;

/* loaded from: classes4.dex */
public class AdParams {
    public static final int ORIENTATION_LANDSCAPE = 2;
    public static final int ORIENTATION_PORTRAIT = 1;
    private String appId;
    private BackUrlInfo backUrlInfo;
    private int fetchTimeout;
    private int floorPrice;
    private int nativeExpressHegiht;
    private int nativeExpressWidth;
    private String positionId;
    private int refreshIntervalSeconds;
    private String sourceAppend;
    private int splashOrientation;
    private int videoPolicy;

    public static class Builder {
        private String appid;
        private BackUrlInfo backUrlInfo;
        private int fetchTimeout;
        private String gameId;
        private String positionId;
        private int refreshIntervalSeconds;
        private int splashOrientation = 1;
        private int videoPolicy = 0;
        private int nativeExpressWidth = -1;
        private int nativeExpressHegiht = -1;
        private int floorPrice = -1;

        public Builder(String str) {
            this.positionId = str;
        }

        public AdParams build() {
            return new AdParams(this);
        }

        public Builder setBackUrlInfo(BackUrlInfo backUrlInfo) {
            this.backUrlInfo = backUrlInfo;
            return this;
        }

        public Builder setFetchTimeout(int i2) {
            this.fetchTimeout = i2;
            return this;
        }

        public Builder setFloorPrice(int i2) {
            this.floorPrice = i2;
            return this;
        }

        public Builder setGameId(String str) {
            this.gameId = str;
            return this;
        }

        public Builder setNativeExpressHegiht(int i2) {
            this.nativeExpressHegiht = i2;
            return this;
        }

        public Builder setNativeExpressWidth(int i2) {
            this.nativeExpressWidth = i2;
            return this;
        }

        public Builder setRefreshIntervalSeconds(int i2) {
            this.refreshIntervalSeconds = i2;
            return this;
        }

        public Builder setSplashOrientation(int i2) {
            this.splashOrientation = i2;
            return this;
        }

        public Builder setVideoPolicy(int i2) {
            this.videoPolicy = i2;
            return this;
        }

        public Builder setWxAppid(String str) {
            this.appid = str;
            return this;
        }
    }

    /* synthetic */ AdParams(Builder builder, a aVar) {
        this(builder);
    }

    public BackUrlInfo getBackUrlInfo() {
        return this.backUrlInfo;
    }

    public int getFetchTimeout() {
        return this.fetchTimeout;
    }

    public int getFloorPrice() {
        return this.floorPrice;
    }

    public int getNativeExpressHegiht() {
        return this.nativeExpressHegiht;
    }

    public int getNativeExpressWidth() {
        return this.nativeExpressWidth;
    }

    public String getPositionId() {
        return this.positionId;
    }

    public int getRefreshIntervalSeconds() {
        return this.refreshIntervalSeconds;
    }

    public String getSourceAppend() {
        return this.sourceAppend;
    }

    public int getSplashOrientation() {
        return this.splashOrientation;
    }

    public int getVideoPolicy() {
        return this.videoPolicy;
    }

    public String getWxAppId() {
        return this.appId;
    }

    private AdParams(Builder builder) {
        this.positionId = builder.positionId;
        this.backUrlInfo = builder.backUrlInfo;
        this.fetchTimeout = builder.fetchTimeout;
        this.splashOrientation = builder.splashOrientation;
        this.sourceAppend = w0.b(builder.gameId);
        this.refreshIntervalSeconds = builder.refreshIntervalSeconds;
        this.videoPolicy = builder.videoPolicy;
        this.nativeExpressHegiht = builder.nativeExpressHegiht;
        this.nativeExpressWidth = builder.nativeExpressWidth;
        this.floorPrice = builder.floorPrice;
        this.appId = builder.appid;
    }
}
