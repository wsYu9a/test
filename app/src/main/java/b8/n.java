package b8;

import com.martian.apptask.data.ViewWrapper;
import com.qq.e.ads.banner2.UnifiedBannerView;

/* loaded from: classes3.dex */
public class n extends ViewWrapper {

    /* renamed from: a */
    public final UnifiedBannerView f1449a;

    public n(UnifiedBannerView unifiedBannerView) {
        super(unifiedBannerView.getRootView());
        this.f1449a = unifiedBannerView;
    }

    @Override // com.martian.apptask.data.ViewWrapper
    public void onDestroy() {
        UnifiedBannerView unifiedBannerView = this.f1449a;
        if (unifiedBannerView != null) {
            unifiedBannerView.destroy();
        }
    }

    @Override // com.martian.apptask.data.ViewWrapper
    public void onInit() {
    }
}
