package b.d.a;

import com.martian.apptask.data.ViewWrapper;
import com.qq.e.ads.banner2.UnifiedBannerView;

/* loaded from: classes2.dex */
public class e extends ViewWrapper {

    /* renamed from: a */
    private final UnifiedBannerView f4359a;

    public e(UnifiedBannerView ad2) {
        super(ad2.getRootView());
        this.f4359a = ad2;
    }

    @Override // com.martian.apptask.data.ViewWrapper
    public void onDestroy() {
        UnifiedBannerView unifiedBannerView = this.f4359a;
        if (unifiedBannerView != null) {
            unifiedBannerView.destroy();
        }
    }

    @Override // com.martian.apptask.data.ViewWrapper
    protected void onInit() {
    }
}
