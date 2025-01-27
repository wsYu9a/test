package com.kwad.sdk.core.request.model;

import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.x;
import java.io.Serializable;
import java.util.List;
import org.json.JSONObject;

@KsJson
/* loaded from: classes3.dex */
public class StatusInfo extends com.kwad.sdk.core.response.a.a {
    public int aDW;
    public int aDX;
    public SplashAdInfo aDY;
    public NativeAdRequestInfo aDZ;
    public List<f> aEa;

    @KsJson
    public static final class NativeAdRequestInfo extends com.kwad.sdk.core.response.a.a implements Serializable {
        private static final long serialVersionUID = -7917397487136276024L;
        public NativeAdStyleControl nativeAdStyleControl;

        public static NativeAdRequestInfo create(SceneImpl sceneImpl) {
            NativeAdRequestInfo nativeAdRequestInfo = new NativeAdRequestInfo();
            nativeAdRequestInfo.nativeAdStyleControl = com.kwad.sdk.utils.c.e(sceneImpl);
            return nativeAdRequestInfo;
        }
    }

    @KsJson
    public static final class NativeAdStyleControl extends com.kwad.sdk.core.response.a.a implements Serializable {
        private static final long serialVersionUID = -6047032783829467891L;
        public boolean enableShake;

        @Override // com.kwad.sdk.core.response.a.a
        public final void afterToJson(JSONObject jSONObject) {
            super.afterToJson(jSONObject);
            x.putValue(jSONObject, "enableShake", this.enableShake);
        }
    }

    @KsJson
    public static final class SplashAdInfo extends com.kwad.sdk.core.response.a.a implements Serializable {
        private static final long serialVersionUID = 7910709346852904072L;
        public int dailyShowCount;
        public SplashStyleControl splashStyleControl;

        public static SplashAdInfo create(SceneImpl sceneImpl) {
            SplashAdInfo splashAdInfo = new SplashAdInfo();
            splashAdInfo.dailyShowCount = com.kwad.sdk.utils.c.MC();
            splashAdInfo.splashStyleControl = com.kwad.sdk.utils.c.d(sceneImpl);
            return splashAdInfo;
        }
    }

    @KsJson
    public static final class SplashStyleControl extends com.kwad.sdk.core.response.a.a implements Serializable {
        private static final long serialVersionUID = -6510852657198503314L;
        public boolean disableRotate;
        public boolean disableShake;
        public boolean disableSlide;
    }

    private StatusInfo(SceneImpl sceneImpl) {
        try {
            this.aDW = ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).zC() ? 1 : 0;
            this.aDX = ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).zD() ? 1 : 0;
            this.aEa = com.kwad.sdk.core.local.a.Fm();
            this.aDZ = NativeAdRequestInfo.create(sceneImpl);
            this.aDY = SplashAdInfo.create(sceneImpl);
        } catch (Throwable th2) {
            ServiceProvider.reportSdkCaughtException(th2);
        }
    }

    public static StatusInfo c(SceneImpl sceneImpl) {
        return new StatusInfo(sceneImpl);
    }
}
