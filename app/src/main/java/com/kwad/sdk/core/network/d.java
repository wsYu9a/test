package com.kwad.sdk.core.network;

import androidx.annotation.Nullable;
import com.kwad.components.offline.api.BuildConfig;
import com.kwad.sdk.components.DevelopMangerComponents;
import com.kwad.sdk.core.request.model.StatusInfo;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.az;

/* loaded from: classes3.dex */
public abstract class d extends b {
    public static final String TRACK_ID_KEY = "kuaishou-tracing-token";

    public d() {
        this(0, null);
    }

    @Override // com.kwad.sdk.core.network.b
    public void buildBaseBody() {
        try {
            putBody("protocolVersion", "2.0");
            putBody("SDKVersion", BuildConfig.VERSION_NAME);
            putBody("SDKVersionCode", BuildConfig.VERSION_CODE);
            putBody("sdkApiVersion", ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getApiVersion());
            putBody("sdkApiVersionCode", ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getApiVersionCode());
            putBody("sdkType", 1);
            putBody("appInfo", com.kwad.sdk.core.request.model.a.GF());
            putBody("tkVersion", "6.1.2");
            putBody("adSdkVersion", BuildConfig.VERSION_NAME);
            putBody("networkInfo", com.kwad.sdk.core.request.model.d.GJ());
            putBody("liveSupportMode", ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).pz() ? 1 : 0);
            putBody("userInfo", com.kwad.sdk.core.request.model.g.GM());
            putBody("requestSessionData", q.Fv().eb(getUrl()));
            putBody(o3.a.f29032k, System.currentTimeMillis());
            if (enablePrivateInfoObtain()) {
                buildBaseBodyWithPrivateInfo();
            }
        } catch (Throwable th2) {
            reportSdkCaughtException(th2);
        }
        putBody("mediumDisableSensor", az.Oo());
    }

    public void buildBaseBodyWithPrivateInfo() {
        try {
            putBody("geoInfo", com.kwad.sdk.core.request.model.c.GI());
            putBody("kGeoInfo", ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).zG());
            putBody("ext", com.kwad.sdk.core.request.model.e.GL());
        } catch (Throwable th2) {
            reportSdkCaughtException(th2);
        }
    }

    @Override // com.kwad.sdk.core.network.b
    public void buildBaseHeader() {
        if (com.kwad.framework.a.a.ns.booleanValue()) {
            com.kwad.sdk.components.d.f(DevelopMangerComponents.class);
            addHeader("trace-context", "{\"laneId\":\"STAGING.online.u\"}");
            com.kwad.sdk.components.d.f(DevelopMangerComponents.class);
        }
    }

    public boolean enablePrivateInfoObtain() {
        return true;
    }

    public boolean needAppList() {
        return false;
    }

    public d(int i10, @Nullable SceneImpl sceneImpl) {
        putBody("deviceInfo", com.kwad.sdk.core.request.model.b.h(needAppList(), i10));
        if (sceneImpl != null) {
            putBody("statusInfo", StatusInfo.c(sceneImpl));
        }
    }
}
