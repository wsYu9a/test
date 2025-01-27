package com.vivo.mobilead.util;

import android.content.Context;
import android.location.Location;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.KsCustomController;
import com.kwad.sdk.api.SdkConfig;
import com.vivo.mobilead.model.VLocation;

/* loaded from: classes4.dex */
public class v {

    /* renamed from: a */
    private static volatile boolean f30778a = false;

    static class a extends KsCustomController {
        a() {
        }

        @Override // com.kwad.sdk.api.KsCustomController
        public boolean canReadInstalledPackages() {
            return h0.K().w();
        }

        @Override // com.kwad.sdk.api.KsCustomController
        public boolean canReadLocation() {
            return h0.K().x();
        }

        @Override // com.kwad.sdk.api.KsCustomController
        public boolean canUseMacAddress() {
            return h0.K().y();
        }

        @Override // com.kwad.sdk.api.KsCustomController
        public boolean canUseNetworkState() {
            return h0.K().B();
        }

        @Override // com.kwad.sdk.api.KsCustomController
        public boolean canUseOaid() {
            return h0.K().z();
        }

        @Override // com.kwad.sdk.api.KsCustomController
        public boolean canUsePhoneState() {
            return h0.K().A();
        }

        @Override // com.kwad.sdk.api.KsCustomController
        public boolean canUseStoragePermission() {
            return h0.K().C();
        }

        @Override // com.kwad.sdk.api.KsCustomController
        public String getAndroidId() {
            return h0.K().c();
        }

        @Override // com.kwad.sdk.api.KsCustomController
        public String getImei() {
            return h0.K().d();
        }

        @Override // com.kwad.sdk.api.KsCustomController
        public Location getLocation() {
            VLocation i2 = h0.K().i();
            Location location = super.getLocation();
            if (location == null) {
                location = new Location("gps");
            }
            if (i2 != null) {
                location.setLatitude(i2.getLat());
                location.setLongitude(i2.getLng());
            }
            return location;
        }

        @Override // com.kwad.sdk.api.KsCustomController
        public String getOaid() {
            return h0.K().e();
        }
    }

    public static boolean a() {
        return f30778a;
    }

    public static void a(Context context, String str) {
        if (f30778a || !com.vivo.mobilead.manager.f.j().f()) {
            return;
        }
        try {
            f30778a = true;
            KsAdSDK.setPersonalRecommend(h0.K().a());
            KsAdSDK.init(context.getApplicationContext(), new SdkConfig.Builder().appId(str).showNotification(true).debug(false).customController(new a()).build());
        } catch (Exception unused) {
            f30778a = false;
        }
    }
}
