package b.a.a.a.c.d.a;

import android.app.Activity;
import com.bytedance.sdk.openadsdk.TTAdDislike;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.bytedance.sdk.openadsdk.TTInteractionAd;
import com.vivo.mobilead.util.k0;
import java.util.Map;

/* loaded from: classes.dex */
public class g extends b.a.a.a.c.d.a.a<TTInteractionAd> implements TTInteractionAd {

    /* renamed from: d */
    private final a f4180d;

    static class a extends b<TTInteractionAd.AdInteractionListener> implements TTInteractionAd.AdInteractionListener {
        public a(String str, int i2) {
            super(str, i2);
        }

        @Override // com.bytedance.sdk.openadsdk.TTInteractionAd.AdInteractionListener
        public void onAdClicked() {
            k0.a(this.f4172a, this.f4173b);
            T t = this.f4174c;
            if (t != 0) {
                ((TTInteractionAd.AdInteractionListener) t).onAdClicked();
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTInteractionAd.AdInteractionListener
        public void onAdDismiss() {
            T t = this.f4174c;
            if (t != 0) {
                ((TTInteractionAd.AdInteractionListener) t).onAdDismiss();
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTInteractionAd.AdInteractionListener
        public void onAdShow() {
            k0.b(this.f4172a, this.f4173b);
            T t = this.f4174c;
            if (t != 0) {
                ((TTInteractionAd.AdInteractionListener) t).onAdShow();
            }
        }
    }

    public g(TTInteractionAd tTInteractionAd, String str, int i2) {
        super(tTInteractionAd, str, i2);
        a aVar = new a(this.f4170b, this.f4171c);
        this.f4180d = aVar;
        ((TTInteractionAd) this.f4169a).setAdInteractionListener(aVar);
    }

    @Override // com.bytedance.sdk.openadsdk.TTInteractionAd
    public int getInteractionType() {
        return ((TTInteractionAd) this.f4169a).getInteractionType();
    }

    @Override // com.bytedance.sdk.openadsdk.TTInteractionAd
    public Map<String, Object> getMediaExtraInfo() {
        return ((TTInteractionAd) this.f4169a).getMediaExtraInfo();
    }

    @Override // com.bytedance.sdk.openadsdk.TTInteractionAd
    public void setAdInteractionListener(TTInteractionAd.AdInteractionListener adInteractionListener) {
        this.f4180d.a(adInteractionListener);
    }

    @Override // com.bytedance.sdk.openadsdk.TTInteractionAd
    public void setDownloadListener(TTAppDownloadListener tTAppDownloadListener) {
        ((TTInteractionAd) this.f4169a).setDownloadListener(tTAppDownloadListener);
    }

    @Override // com.bytedance.sdk.openadsdk.TTInteractionAd
    public void setShowDislikeIcon(TTAdDislike.DislikeInteractionCallback dislikeInteractionCallback) {
        ((TTInteractionAd) this.f4169a).setShowDislikeIcon(dislikeInteractionCallback);
    }

    @Override // com.bytedance.sdk.openadsdk.TTInteractionAd
    public void showInteractionAd(Activity activity) {
        ((TTInteractionAd) this.f4169a).showInteractionAd(activity);
    }
}
