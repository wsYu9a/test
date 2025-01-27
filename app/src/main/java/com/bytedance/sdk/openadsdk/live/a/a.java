package com.bytedance.sdk.openadsdk.live.a;

import com.bytedance.android.live.base.api.IHostPermission;
import com.bytedance.android.live.base.api.LocationProvider;
import com.bytedance.sdk.openadsdk.TTCustomController;

/* loaded from: classes2.dex */
public class a implements IHostPermission {

    /* renamed from: a */
    private TTCustomController f8225a;

    /* renamed from: com.bytedance.sdk.openadsdk.live.a.a$1 */
    public class AnonymousClass1 extends TTCustomController {
        public AnonymousClass1() {
        }
    }

    /* renamed from: com.bytedance.sdk.openadsdk.live.a.a$2 */
    public class AnonymousClass2 implements LocationProvider {

        /* renamed from: a */
        final /* synthetic */ com.bytedance.sdk.openadsdk.LocationProvider f8227a;

        public AnonymousClass2(com.bytedance.sdk.openadsdk.LocationProvider locationProvider) {
            tTLocation = locationProvider;
        }

        @Override // com.bytedance.android.live.base.api.LocationProvider
        public double getLatitude() {
            return tTLocation.getLatitude();
        }

        @Override // com.bytedance.android.live.base.api.LocationProvider
        public double getLongitude() {
            return tTLocation.getLongitude();
        }
    }

    public a(TTCustomController tTCustomController) {
        if (tTCustomController == null) {
            this.f8225a = new TTCustomController() { // from class: com.bytedance.sdk.openadsdk.live.a.a.1
                public AnonymousClass1() {
                }
            };
        } else {
            this.f8225a = tTCustomController;
        }
    }

    @Override // com.bytedance.android.live.base.api.IHostPermission
    public boolean alist() {
        TTCustomController tTCustomController = this.f8225a;
        if (tTCustomController == null) {
            return false;
        }
        return tTCustomController.alist();
    }

    @Override // com.bytedance.android.live.base.api.IHostPermission
    public String getAndroidID() {
        TTCustomController tTCustomController = this.f8225a;
        if (tTCustomController == null) {
            return null;
        }
        return tTCustomController.getAndroidId();
    }

    @Override // com.bytedance.android.live.base.api.IHostPermission
    public String getDevImei() {
        TTCustomController tTCustomController = this.f8225a;
        if (tTCustomController == null) {
            return null;
        }
        return tTCustomController.getDevImei();
    }

    @Override // com.bytedance.android.live.base.api.IHostPermission
    public String getDevOaid() {
        TTCustomController tTCustomController = this.f8225a;
        if (tTCustomController == null) {
            return null;
        }
        return tTCustomController.getDevOaid();
    }

    @Override // com.bytedance.android.live.base.api.IHostPermission
    public String getMacAddress() {
        TTCustomController tTCustomController = this.f8225a;
        if (tTCustomController == null) {
            return null;
        }
        return tTCustomController.getMacAddress();
    }

    @Override // com.bytedance.android.live.base.api.IHostPermission
    public LocationProvider getTTLocation() {
        com.bytedance.sdk.openadsdk.LocationProvider tTLocation;
        TTCustomController tTCustomController = this.f8225a;
        if (tTCustomController == null || (tTLocation = tTCustomController.getTTLocation()) == null) {
            return null;
        }
        return new LocationProvider() { // from class: com.bytedance.sdk.openadsdk.live.a.a.2

            /* renamed from: a */
            final /* synthetic */ com.bytedance.sdk.openadsdk.LocationProvider f8227a;

            public AnonymousClass2(com.bytedance.sdk.openadsdk.LocationProvider tTLocation2) {
                tTLocation = tTLocation2;
            }

            @Override // com.bytedance.android.live.base.api.LocationProvider
            public double getLatitude() {
                return tTLocation.getLatitude();
            }

            @Override // com.bytedance.android.live.base.api.LocationProvider
            public double getLongitude() {
                return tTLocation.getLongitude();
            }
        };
    }

    @Override // com.bytedance.android.live.base.api.IHostPermission
    public boolean isCanGetAndUseAndroidID() {
        TTCustomController tTCustomController = this.f8225a;
        if (tTCustomController == null) {
            return false;
        }
        return tTCustomController.isCanUseAndroidId();
    }

    @Override // com.bytedance.android.live.base.api.IHostPermission
    public boolean isCanUseLocation() {
        TTCustomController tTCustomController = this.f8225a;
        if (tTCustomController == null) {
            return true;
        }
        return tTCustomController.isCanUseLocation();
    }

    @Override // com.bytedance.android.live.base.api.IHostPermission
    public boolean isCanUsePhoneState() {
        TTCustomController tTCustomController = this.f8225a;
        if (tTCustomController == null) {
            return false;
        }
        return tTCustomController.isCanUsePhoneState();
    }

    @Override // com.bytedance.android.live.base.api.IHostPermission
    public boolean isCanUseWifiState() {
        TTCustomController tTCustomController = this.f8225a;
        if (tTCustomController == null) {
            return false;
        }
        return tTCustomController.isCanUseWifiState();
    }

    @Override // com.bytedance.android.live.base.api.IHostPermission
    public boolean isCanUseWriteExternal() {
        TTCustomController tTCustomController = this.f8225a;
        if (tTCustomController == null) {
            return false;
        }
        return tTCustomController.isCanUseWriteExternal();
    }
}
