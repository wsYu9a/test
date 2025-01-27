package com.kwad.sdk.core.request.model;

import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.t;
import java.io.Serializable;
import java.util.List;
import org.json.JSONObject;

@KsJson
/* loaded from: classes2.dex */
public class StatusInfo extends com.kwad.sdk.core.response.kwai.a {
    public SplashAdInfo alH;
    public NativeAdRequestInfo alI;
    public int alF = ((com.kwad.sdk.service.kwai.e) ServiceProvider.get(com.kwad.sdk.service.kwai.e.class)).isPersonalRecommend() ? 1 : 0;
    public int alG = ((com.kwad.sdk.service.kwai.e) ServiceProvider.get(com.kwad.sdk.service.kwai.e.class)).isProgrammaticRecommend() ? 1 : 0;
    public List<f> alJ = com.kwad.sdk.core.c.a.vW();

    @KsJson
    public static final class NativeAdRequestInfo extends com.kwad.sdk.core.response.kwai.a implements Serializable {
        private static final long serialVersionUID = -7917397487136276024L;
        public NativeAdStyleControl nativeAdStyleControl;

        public static NativeAdRequestInfo create(SceneImpl sceneImpl) {
            NativeAdRequestInfo nativeAdRequestInfo = new NativeAdRequestInfo();
            nativeAdRequestInfo.nativeAdStyleControl = com.kwad.sdk.utils.b.d(sceneImpl);
            return nativeAdRequestInfo;
        }
    }

    @KsJson
    public static final class NativeAdStyleControl extends com.kwad.sdk.core.response.kwai.a implements Serializable {
        private static final long serialVersionUID = -6047032783829467891L;
        public boolean enableShake;

        @Override // com.kwad.sdk.core.response.kwai.a
        public final void afterToJson(JSONObject jSONObject) {
            super.afterToJson(jSONObject);
            t.putValue(jSONObject, "enableShake", this.enableShake);
        }
    }

    @KsJson
    public static final class SplashAdInfo extends com.kwad.sdk.core.response.kwai.a implements Serializable {
        private static final long serialVersionUID = 7910709346852904072L;
        public int dailyShowCount;
        public SplashStyleControl splashStyleControl;

        public static SplashAdInfo create(SceneImpl sceneImpl) {
            SplashAdInfo splashAdInfo = new SplashAdInfo();
            splashAdInfo.dailyShowCount = com.kwad.sdk.utils.b.CC();
            splashAdInfo.splashStyleControl = com.kwad.sdk.utils.b.c(sceneImpl);
            return splashAdInfo;
        }
    }

    @KsJson
    public static final class SplashStyleControl extends com.kwad.sdk.core.response.kwai.a implements Serializable {
        private static final long serialVersionUID = -6510852657198503314L;
        public boolean disableRotate;
        public boolean disableShake;
        public boolean disableSlide;
    }

    private StatusInfo(SceneImpl sceneImpl) {
        this.alI = NativeAdRequestInfo.create(sceneImpl);
        this.alH = SplashAdInfo.create(sceneImpl);
    }

    public static StatusInfo b(SceneImpl sceneImpl) {
        return new StatusInfo(sceneImpl);
    }
}
