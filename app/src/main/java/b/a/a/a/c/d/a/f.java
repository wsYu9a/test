package b.a.a.a.c.d.a;

import android.app.Activity;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.bytedance.sdk.openadsdk.TTFullScreenVideoAd;
import com.vivo.mobilead.util.k0;
import java.util.Map;

/* loaded from: classes.dex */
public class f extends b.a.a.a.c.d.a.a<TTFullScreenVideoAd> implements TTFullScreenVideoAd {

    /* renamed from: d */
    private final a f4179d;

    private static class a extends b<TTFullScreenVideoAd.FullScreenVideoAdInteractionListener> implements TTFullScreenVideoAd.FullScreenVideoAdInteractionListener {
        public a(String str, int i2) {
            super(str, i2);
        }

        @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
        public void onAdClose() {
            T t = this.f4174c;
            if (t != 0) {
                ((TTFullScreenVideoAd.FullScreenVideoAdInteractionListener) t).onAdClose();
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
        public void onAdShow() {
            k0.b(this.f4172a, this.f4173b);
            T t = this.f4174c;
            if (t != 0) {
                ((TTFullScreenVideoAd.FullScreenVideoAdInteractionListener) t).onAdShow();
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
        public void onAdVideoBarClick() {
            k0.a(this.f4172a, this.f4173b);
            T t = this.f4174c;
            if (t != 0) {
                ((TTFullScreenVideoAd.FullScreenVideoAdInteractionListener) t).onAdVideoBarClick();
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
        public void onSkippedVideo() {
            T t = this.f4174c;
            if (t != 0) {
                ((TTFullScreenVideoAd.FullScreenVideoAdInteractionListener) t).onSkippedVideo();
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
        public void onVideoComplete() {
            T t = this.f4174c;
            if (t != 0) {
                ((TTFullScreenVideoAd.FullScreenVideoAdInteractionListener) t).onVideoComplete();
            }
        }
    }

    public f(TTFullScreenVideoAd tTFullScreenVideoAd, String str, int i2) {
        super(tTFullScreenVideoAd, str, i2);
        a aVar = new a(this.f4170b, this.f4171c);
        this.f4179d = aVar;
        ((TTFullScreenVideoAd) this.f4169a).setFullScreenVideoAdInteractionListener(aVar);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd
    public long getExpirationTimestamp() {
        return ((TTFullScreenVideoAd) this.f4169a).getExpirationTimestamp();
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd
    public int getFullVideoAdType() {
        return ((TTFullScreenVideoAd) this.f4169a).getFullVideoAdType();
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd
    public int getInteractionType() {
        return ((TTFullScreenVideoAd) this.f4169a).getInteractionType();
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd
    public Map<String, Object> getMediaExtraInfo() {
        return ((TTFullScreenVideoAd) this.f4169a).getMediaExtraInfo();
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd
    public void setDownloadListener(TTAppDownloadListener tTAppDownloadListener) {
        ((TTFullScreenVideoAd) this.f4169a).setDownloadListener(tTAppDownloadListener);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd
    public void setFullScreenVideoAdInteractionListener(TTFullScreenVideoAd.FullScreenVideoAdInteractionListener fullScreenVideoAdInteractionListener) {
        this.f4179d.a(fullScreenVideoAdInteractionListener);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd
    public void setShowDownLoadBar(boolean z) {
        ((TTFullScreenVideoAd) this.f4169a).setShowDownLoadBar(z);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd
    public void showFullScreenVideoAd(Activity activity) {
        ((TTFullScreenVideoAd) this.f4169a).showFullScreenVideoAd(activity);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd
    public void showFullScreenVideoAd(Activity activity, TTAdConstant.RitScenes ritScenes, String str) {
        ((TTFullScreenVideoAd) this.f4169a).showFullScreenVideoAd(activity, ritScenes, str);
    }
}
