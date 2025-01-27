package com.bytedance.sdk.openadsdk.live.core;

import com.bytedance.android.live.base.api.IHostPermission;
import com.bytedance.android.live.base.api.LocationProvider;
import com.bytedance.sdk.openadsdk.TTCustomController;

/* loaded from: classes.dex */
public class TTHostPermissionInner implements IHostPermission {

    /* renamed from: j */
    private TTCustomController f6476j;

    /* renamed from: com.bytedance.sdk.openadsdk.live.core.TTHostPermissionInner$1 */
    class AnonymousClass1 extends TTCustomController {
        AnonymousClass1() {
        }
    }

    /* renamed from: com.bytedance.sdk.openadsdk.live.core.TTHostPermissionInner$2 */
    class AnonymousClass2 implements LocationProvider {

        /* renamed from: j */
        final /* synthetic */ com.bytedance.sdk.openadsdk.LocationProvider f6478j;

        AnonymousClass2(com.bytedance.sdk.openadsdk.LocationProvider locationProvider) {
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

    public TTHostPermissionInner(TTCustomController tTCustomController) {
        if (tTCustomController == null) {
            this.f6476j = new TTCustomController() { // from class: com.bytedance.sdk.openadsdk.live.core.TTHostPermissionInner.1
                AnonymousClass1() {
                }
            };
        } else {
            this.f6476j = tTCustomController;
        }
    }

    @Override // com.bytedance.android.live.base.api.IHostPermission
    public boolean alist() {
        TTCustomController tTCustomController = this.f6476j;
        if (tTCustomController == null) {
            return false;
        }
        return tTCustomController.alist();
    }

    @Override // com.bytedance.android.live.base.api.IHostPermission
    public String getAndroidID() {
        TTCustomController tTCustomController = this.f6476j;
        if (tTCustomController == null) {
            return null;
        }
        return tTCustomController.getAndroidId();
    }

    @Override // com.bytedance.android.live.base.api.IHostPermission
    public String getDevImei() {
        TTCustomController tTCustomController = this.f6476j;
        if (tTCustomController == null) {
            return null;
        }
        return tTCustomController.getDevImei();
    }

    @Override // com.bytedance.android.live.base.api.IHostPermission
    public String getDevOaid() {
        TTCustomController tTCustomController = this.f6476j;
        if (tTCustomController == null) {
            return null;
        }
        return tTCustomController.getDevOaid();
    }

    @Override // com.bytedance.android.live.base.api.IHostPermission
    public String getMacAddress() {
        TTCustomController tTCustomController = this.f6476j;
        if (tTCustomController == null) {
            return null;
        }
        return tTCustomController.getMacAddress();
    }

    @Override // com.bytedance.android.live.base.api.IHostPermission
    public LocationProvider getTTLocation() {
        com.bytedance.sdk.openadsdk.LocationProvider tTLocation;
        TTCustomController tTCustomController = this.f6476j;
        if (tTCustomController == null || (tTLocation = tTCustomController.getTTLocation()) == null) {
            return null;
        }
        return new LocationProvider() { // from class: com.bytedance.sdk.openadsdk.live.core.TTHostPermissionInner.2

            /* renamed from: j */
            final /* synthetic */ com.bytedance.sdk.openadsdk.LocationProvider f6478j;

            AnonymousClass2(com.bytedance.sdk.openadsdk.LocationProvider tTLocation2) {
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
        TTCustomController tTCustomController = this.f6476j;
        if (tTCustomController == null) {
            return false;
        }
        return tTCustomController.isCanUseAndroidId();
    }

    @Override // com.bytedance.android.live.base.api.IHostPermission
    public boolean isCanUseLocation() {
        TTCustomController tTCustomController = this.f6476j;
        if (tTCustomController == null) {
            return true;
        }
        return tTCustomController.isCanUseLocation();
    }

    @Override // com.bytedance.android.live.base.api.IHostPermission
    public boolean isCanUsePhoneState() {
        TTCustomController tTCustomController = this.f6476j;
        if (tTCustomController == null) {
            return false;
        }
        return tTCustomController.isCanUsePhoneState();
    }

    @Override // com.bytedance.android.live.base.api.IHostPermission
    public boolean isCanUseWifiState() {
        TTCustomController tTCustomController = this.f6476j;
        if (tTCustomController == null) {
            return false;
        }
        return tTCustomController.isCanUseWifiState();
    }

    @Override // com.bytedance.android.live.base.api.IHostPermission
    public boolean isCanUseWriteExternal() {
        TTCustomController tTCustomController = this.f6476j;
        if (tTCustomController == null) {
            return false;
        }
        return tTCustomController.isCanUseWriteExternal();
    }
}
