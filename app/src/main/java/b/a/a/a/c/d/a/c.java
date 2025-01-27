package b.a.a.a.c.d.a;

import android.view.View;
import com.bytedance.sdk.openadsdk.TTAdDislike;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.bytedance.sdk.openadsdk.TTBannerAd;
import com.vivo.mobilead.util.k0;
import java.util.Map;

/* loaded from: classes.dex */
public class c implements TTBannerAd {

    /* renamed from: a */
    private final TTBannerAd f4175a;

    /* renamed from: b */
    private final a f4176b;

    private static class a extends b<TTBannerAd.AdInteractionListener> implements TTBannerAd.AdInteractionListener {
        public a(String str, int i2) {
            super(str, i2);
        }

        @Override // com.bytedance.sdk.openadsdk.TTBannerAd.AdInteractionListener
        public void onAdClicked(View view, int i2) {
            k0.a(this.f4172a, this.f4173b);
            T t = this.f4174c;
            if (t != 0) {
                ((TTBannerAd.AdInteractionListener) t).onAdClicked(view, i2);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTBannerAd.AdInteractionListener
        public void onAdShow(View view, int i2) {
            k0.b(this.f4172a, this.f4173b);
            T t = this.f4174c;
            if (t != 0) {
                ((TTBannerAd.AdInteractionListener) t).onAdShow(view, i2);
            }
        }
    }

    public c(TTBannerAd tTBannerAd, String str, int i2) {
        this.f4175a = tTBannerAd;
        a aVar = new a(str, i2);
        this.f4176b = aVar;
        tTBannerAd.setBannerInteractionListener(aVar);
    }

    @Override // com.bytedance.sdk.openadsdk.TTBannerAd
    public View getBannerView() {
        return this.f4175a.getBannerView();
    }

    @Override // com.bytedance.sdk.openadsdk.TTBannerAd
    public TTAdDislike getDislikeDialog(TTAdDislike.DislikeInteractionCallback dislikeInteractionCallback) {
        return this.f4175a.getDislikeDialog(dislikeInteractionCallback);
    }

    @Override // com.bytedance.sdk.openadsdk.TTBannerAd
    public int getInteractionType() {
        return this.f4175a.getInteractionType();
    }

    @Override // com.bytedance.sdk.openadsdk.TTBannerAd
    public Map<String, Object> getMediaExtraInfo() {
        return this.f4175a.getMediaExtraInfo();
    }

    @Override // com.bytedance.sdk.openadsdk.TTBannerAd
    public void setBannerInteractionListener(TTBannerAd.AdInteractionListener adInteractionListener) {
        this.f4176b.a(adInteractionListener);
    }

    @Override // com.bytedance.sdk.openadsdk.TTBannerAd
    public void setDownloadListener(TTAppDownloadListener tTAppDownloadListener) {
        this.f4175a.setDownloadListener(tTAppDownloadListener);
    }

    @Override // com.bytedance.sdk.openadsdk.TTBannerAd
    public void setShowDislikeIcon(TTAdDislike.DislikeInteractionCallback dislikeInteractionCallback) {
        this.f4175a.setShowDislikeIcon(dislikeInteractionCallback);
    }

    @Override // com.bytedance.sdk.openadsdk.TTBannerAd
    public void setSlideIntervalTime(int i2) {
        this.f4175a.setSlideIntervalTime(i2);
    }
}
