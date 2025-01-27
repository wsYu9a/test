package com.kwad.sdk.api;

import androidx.annotation.Keep;
import com.kwad.sdk.api.core.KsAdSdkApi;
import com.kwad.sdk.api.loader.Loader;
import com.kwad.sdk.api.model.IKsAdLabel;
import com.kwad.sdk.api.model.NativeAdExtraData;
import com.kwad.sdk.api.model.SplashAdExtraData;
import java.io.Serializable;
import java.util.Map;
import org.json.JSONObject;

@KsAdSdkApi
@Keep
/* loaded from: classes2.dex */
public interface KsScene extends Serializable {

    @KsAdSdkApi
    @Keep
    public static class Builder {
        private KsScene scene;

        @KsAdSdkApi
        @Keep
        public Builder(long j2) {
            KsScene ksScene = (KsScene) Loader.get().newInstance(KsScene.class);
            this.scene = ksScene;
            ksScene.setPosId(j2);
        }

        @KsAdSdkApi
        @Keep
        public Builder action(int i2) {
            this.scene.setAction(i2);
            return this;
        }

        @KsAdSdkApi
        @Keep
        public Builder adLabel(com.kwad.sdk.api.model.a aVar) {
            this.scene.setKsAdLabel(aVar);
            return this;
        }

        @KsAdSdkApi
        @Keep
        public Builder adNum(int i2) {
            this.scene.setAdNum(i2);
            return this;
        }

        @KsAdSdkApi
        @Keep
        public KsScene build() {
            return this.scene;
        }

        @KsAdSdkApi
        @Keep
        public Builder height(int i2) {
            this.scene.setHeight(i2);
            return this;
        }

        @KsAdSdkApi
        @Keep
        public Builder posId(long j2) {
            this.scene.setPosId(j2);
            return this;
        }

        @KsAdSdkApi
        @Keep
        public Builder promoteId(String str) {
            this.scene.setPromoteId(str);
            return this;
        }

        @KsAdSdkApi
        @Keep
        public Builder rewardCallbackExtraData(Map<String, String> map) {
            this.scene.setRewardCallbackExtraData(map);
            return this;
        }

        @KsAdSdkApi
        @Keep
        public Builder screenOrientation(int i2) {
            this.scene.setScreenOrientation(i2);
            return this;
        }

        @KsAdSdkApi
        @Keep
        public Builder setBackUrl(String str) {
            this.scene.setBackUrl(str);
            return this;
        }

        @KsAdSdkApi
        @Keep
        public Builder setBidResponse(String str) {
            this.scene.setBidResponse(str);
            return this;
        }

        @KsAdSdkApi
        @Keep
        public Builder setBidResponseV2(String str) {
            this.scene.setBidResponseV2(str);
            return this;
        }

        @KsAdSdkApi
        @Keep
        public Builder setComment(String str) {
            this.scene.setComment(str);
            return this;
        }

        @KsAdSdkApi
        @Keep
        public Builder setNativeAdExtraData(NativeAdExtraData nativeAdExtraData) {
            this.scene.setNativeAdExtraData(nativeAdExtraData);
            return this;
        }

        @KsAdSdkApi
        @Keep
        public Builder setSplashExtraData(SplashAdExtraData splashAdExtraData) {
            this.scene.setSplashExtraData(splashAdExtraData);
            return this;
        }

        @KsAdSdkApi
        @Keep
        public Builder setUserCommRateBuying(int i2) {
            this.scene.setUserCommRateBuying(i2);
            return this;
        }

        @KsAdSdkApi
        @Keep
        public Builder setUserCommRateSharing(int i2) {
            this.scene.setUserCommRateSharing(i2);
            return this;
        }

        @KsAdSdkApi
        @Keep
        public Builder width(int i2) {
            this.scene.setWidth(i2);
            return this;
        }
    }

    @KsAdSdkApi
    @Keep
    int getAction();

    @KsAdSdkApi
    @Keep
    int getAdNum();

    @KsAdSdkApi
    @Keep
    int getAdStyle();

    @KsAdSdkApi
    @Keep
    String getBackUrl();

    @KsAdSdkApi
    @Keep
    String getBidResponse();

    @KsAdSdkApi
    @Keep
    String getBidResponseV2();

    @KsAdSdkApi
    @Keep
    String getComment();

    @KsAdSdkApi
    @Keep
    int getHeight();

    @KsAdSdkApi
    @Keep
    long getPosId();

    @KsAdSdkApi
    @Keep
    String getPromoteId();

    @KsAdSdkApi
    @Keep
    Map<String, String> getRewardCallbackExtraData();

    @KsAdSdkApi
    @Keep
    int getScreenOrientation();

    @KsAdSdkApi
    @Keep
    long getUserCommRateBuying();

    @KsAdSdkApi
    @Keep
    long getUserCommRateSharing();

    @KsAdSdkApi
    @Keep
    int getWidth();

    @KsAdSdkApi
    @Keep
    void setAction(int i2);

    @KsAdSdkApi
    @Keep
    void setAdNum(int i2);

    @KsAdSdkApi
    @Keep
    void setAdStyle(int i2);

    @KsAdSdkApi
    @Keep
    void setBackUrl(String str);

    @KsAdSdkApi
    @Keep
    void setBidResponse(String str);

    @KsAdSdkApi
    @Keep
    void setBidResponseV2(String str);

    @KsAdSdkApi
    @Keep
    void setComment(String str);

    @KsAdSdkApi
    @Keep
    void setHeight(int i2);

    @KsAdSdkApi
    @Keep
    void setKsAdLabel(IKsAdLabel iKsAdLabel);

    @KsAdSdkApi
    @Keep
    void setNativeAdExtraData(NativeAdExtraData nativeAdExtraData);

    @KsAdSdkApi
    @Keep
    void setPosId(long j2);

    @KsAdSdkApi
    @Keep
    void setPromoteId(String str);

    @KsAdSdkApi
    @Keep
    void setRewardCallbackExtraData(Map<String, String> map);

    @KsAdSdkApi
    @Keep
    void setScreenOrientation(int i2);

    @KsAdSdkApi
    @Keep
    void setSplashExtraData(SplashAdExtraData splashAdExtraData);

    @KsAdSdkApi
    @Keep
    void setUserCommRateBuying(int i2);

    @KsAdSdkApi
    @Keep
    void setUserCommRateSharing(int i2);

    @KsAdSdkApi
    @Keep
    void setWidth(int i2);

    @KsAdSdkApi
    @Keep
    JSONObject toJson();
}
