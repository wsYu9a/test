package yk;

import android.app.Activity;
import android.content.Context;
import com.at.api.service.CService;
import com.at.api.service.DService;
import com.at.sdk.callback.RUCallback;
import com.sn.catpie.service.CCService;
import com.sn.catpie.service.DeviceStatService;
import com.sntech.ads.SNAdManager;
import com.sntech.ads.SNAdSdk;
import com.sntech.ads.api.callback.RiskUserCallback;

/* loaded from: classes5.dex */
public final class k implements SNAdManager {

    public static class a {

        /* renamed from: a */
        public static final k f33582a = new k();
    }

    @Override // com.sntech.ads.SNAdManager
    public final String did(Context context) {
        DeviceStatService deviceStatService = (DeviceStatService) SNAdSdk.getExtService(DeviceStatService.class);
        if (deviceStatService != null) {
            return deviceStatService.did(context);
        }
        DService dService = (DService) SNAdSdk.getExtService(DService.class);
        if (dService != null) {
            return dService.did(context);
        }
        return null;
    }

    @Override // com.sntech.ads.SNAdManager
    public final String getSdkVersion() {
        return "5.3.0.0";
    }

    @Override // com.sntech.ads.SNAdManager
    public final void isRiskUser(RiskUserCallback riskUserCallback) {
        if (riskUserCallback == null) {
            throw new IllegalArgumentException("Callback is null");
        }
        CCService cCService = (CCService) SNAdSdk.getExtService(CCService.class);
        if (cCService != null) {
            cCService.isRiskUser(riskUserCallback);
            return;
        }
        CService cService = (CService) SNAdSdk.getExtService(CService.class);
        if (cService != null) {
            cService.isRiskUser(new RUCallback() { // from class: yk.j
                public /* synthetic */ j() {
                }

                @Override // com.at.sdk.callback.RUCallback
                public final void callback(boolean z10) {
                    RiskUserCallback.this.callback(z10);
                }
            });
        }
    }

    @Override // com.sntech.ads.SNAdManager
    public final void onRequestPermissionResult(Activity activity, int i10, String[] strArr, int[] iArr) {
        DeviceStatService deviceStatService = (DeviceStatService) SNAdSdk.getExtService(DeviceStatService.class);
        if (deviceStatService != null) {
            deviceStatService.onRequestPermissionResult(activity, i10, strArr, iArr);
            return;
        }
        DService dService = (DService) SNAdSdk.getExtService(DService.class);
        if (dService != null) {
            dService.onRequestPermissionResult(activity, i10, strArr, iArr);
        }
    }

    @Override // com.sntech.ads.SNAdManager
    public final void requestPermissionsIfNeed(Activity activity, String... strArr) {
        DeviceStatService deviceStatService = (DeviceStatService) SNAdSdk.getExtService(DeviceStatService.class);
        if (deviceStatService != null) {
            deviceStatService.requestPermissionsIfNeed(activity, strArr);
            return;
        }
        DService dService = (DService) SNAdSdk.getExtService(DService.class);
        if (dService != null) {
            dService.requestPermissionsIfNeed(activity, strArr);
        }
    }

    @Override // com.sntech.ads.SNAdManager
    public final void setUserId(String str) {
        CCService cCService = (CCService) SNAdSdk.getExtService(CCService.class);
        if (cCService != null) {
            cCService.setUserId(str);
            return;
        }
        CService cService = (CService) SNAdSdk.getExtService(CService.class);
        if (cService != null) {
            cService.setUserId(str);
        }
    }
}
