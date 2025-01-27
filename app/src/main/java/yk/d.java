package yk;

import android.view.View;
import com.at.api.service.CService;
import com.sn.catpie.service.CCService;
import com.sntech.ads.SNAdSdk;
import com.sntech.ads.SNEventManager;
import com.sntech.ads.api.event.SNEvent;

/* loaded from: classes5.dex */
public final class d implements SNEventManager {

    public static class a {

        /* renamed from: a */
        public static final d f33570a = new d();
    }

    @Override // com.sntech.ads.SNEventManager
    public final void onAdClick(SNEvent.AdPlatform adPlatform, String str) {
        onAdClick(adPlatform, str, null);
    }

    @Override // com.sntech.ads.SNEventManager
    public final void onAdShow(View view, SNEvent.AdPlatform adPlatform, String str, double d10) {
        onAdShow(view, adPlatform, str, d10, null);
    }

    @Override // com.sntech.ads.SNEventManager
    public final void onUserEvent(SNEvent.UserEvent userEvent) {
        CCService cCService = (CCService) SNAdSdk.getExtService(CCService.class);
        if (cCService != null) {
            cCService.onUserEvent(userEvent);
            return;
        }
        CService cService = (CService) SNAdSdk.getExtService(CService.class);
        if (cService != null) {
            cService.onUserEvent(userEvent);
        }
    }

    @Override // com.sntech.ads.SNEventManager
    public final void onWithdraw(String str, float f10, SNEvent.WithdrawChannel withdrawChannel, String str2) {
        CCService cCService = (CCService) SNAdSdk.getExtService(CCService.class);
        if (cCService != null) {
            cCService.onWithdraw(str, f10, withdrawChannel, str2);
            return;
        }
        CService cService = (CService) SNAdSdk.getExtService(CService.class);
        if (cService != null) {
            cService.onWithdraw(str, f10, withdrawChannel, str2);
        }
    }

    @Override // com.sntech.ads.SNEventManager
    public final void setABTest(String str, int i10, String... strArr) {
        CCService cCService = (CCService) SNAdSdk.getExtService(CCService.class);
        if (cCService != null) {
            cCService.setABTest(str, i10, strArr);
            return;
        }
        CService cService = (CService) SNAdSdk.getExtService(CService.class);
        if (cService != null) {
            cService.setABTest(str, i10, strArr);
        }
    }

    @Override // com.sntech.ads.SNEventManager
    public final void onAdClick(SNEvent.AdPlatform adPlatform, String str, String str2) {
        CCService cCService = (CCService) SNAdSdk.getExtService(CCService.class);
        if (cCService != null) {
            cCService.onAdClick(adPlatform, str, str2);
            return;
        }
        CService cService = (CService) SNAdSdk.getExtService(CService.class);
        if (cService != null) {
            cService.onAdClick(adPlatform, str, str2);
        }
    }

    @Override // com.sntech.ads.SNEventManager
    public final void onAdShow(View view, SNEvent.AdPlatform adPlatform, String str, double d10, String str2) {
        CCService cCService = (CCService) SNAdSdk.getExtService(CCService.class);
        if (cCService != null) {
            cCService.onAdShow(view, adPlatform, str, d10, str2);
            return;
        }
        CService cService = (CService) SNAdSdk.getExtService(CService.class);
        if (cService != null) {
            cService.onAdShow(view, adPlatform, str, d10, str2);
        }
    }

    @Override // com.sntech.ads.SNEventManager
    public final void onAdShow(SNEvent.AdPlatform adPlatform, String str, double d10) {
        onAdShow(null, adPlatform, str, d10, null);
    }

    @Override // com.sntech.ads.SNEventManager
    public final void onAdShow(SNEvent.AdPlatform adPlatform, String str, double d10, String str2) {
        onAdShow(null, adPlatform, str, d10, str2);
    }
}
