package b.d.a;

import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import com.martian.apptask.data.ViewWrapper;

/* loaded from: classes2.dex */
public class h extends ViewWrapper {

    /* renamed from: a */
    private final TTNativeExpressAd f4361a;

    public h(TTNativeExpressAd ad2) {
        super(ad2.getExpressAdView());
        this.f4361a = ad2;
    }

    @Override // com.martian.apptask.data.ViewWrapper
    public void onDestroy() {
        TTNativeExpressAd tTNativeExpressAd = this.f4361a;
        if (tTNativeExpressAd != null) {
            tTNativeExpressAd.destroy();
        }
    }

    @Override // com.martian.apptask.data.ViewWrapper
    protected void onInit() {
        TTNativeExpressAd tTNativeExpressAd = this.f4361a;
        if (tTNativeExpressAd != null) {
            tTNativeExpressAd.render();
        }
    }
}
