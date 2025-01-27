package b8;

import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import com.martian.apptask.data.ViewWrapper;

/* loaded from: classes3.dex */
public class q extends ViewWrapper {

    /* renamed from: a */
    public final TTNativeExpressAd f1451a;

    public q(TTNativeExpressAd tTNativeExpressAd) {
        super(tTNativeExpressAd.getExpressAdView());
        this.f1451a = tTNativeExpressAd;
    }

    @Override // com.martian.apptask.data.ViewWrapper
    public void onDestroy() {
        TTNativeExpressAd tTNativeExpressAd = this.f1451a;
        if (tTNativeExpressAd != null) {
            tTNativeExpressAd.destroy();
        }
    }

    @Override // com.martian.apptask.data.ViewWrapper
    public void onInit() {
        TTNativeExpressAd tTNativeExpressAd = this.f1451a;
        if (tTNativeExpressAd != null) {
            tTNativeExpressAd.render();
        }
    }
}
