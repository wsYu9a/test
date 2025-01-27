package b.a.a.a.c.d.a;

import android.view.View;
import com.bytedance.sdk.openadsdk.ISplashClickEyeListener;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import com.bytedance.sdk.openadsdk.TTSplashAd;
import com.vivo.mobilead.util.k0;
import java.util.Map;

/* loaded from: classes.dex */
public class k extends b.a.a.a.c.d.a.a<TTSplashAd> implements TTSplashAd {

    /* renamed from: d */
    private final a f4183d;

    static class a extends b<TTSplashAd.AdInteractionListener> implements TTSplashAd.AdInteractionListener {
        public a(String str, int i2) {
            super(str, i2);
        }

        @Override // com.bytedance.sdk.openadsdk.TTSplashAd.AdInteractionListener
        public void onAdClicked(View view, int i2) {
            k0.a(this.f4172a, this.f4173b);
            T t = this.f4174c;
            if (t != 0) {
                ((TTSplashAd.AdInteractionListener) t).onAdClicked(view, i2);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTSplashAd.AdInteractionListener
        public void onAdShow(View view, int i2) {
            k0.b(this.f4172a, this.f4173b);
            T t = this.f4174c;
            if (t != 0) {
                ((TTSplashAd.AdInteractionListener) t).onAdShow(view, i2);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTSplashAd.AdInteractionListener
        public void onAdSkip() {
            T t = this.f4174c;
            if (t != 0) {
                ((TTSplashAd.AdInteractionListener) t).onAdSkip();
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTSplashAd.AdInteractionListener
        public void onAdTimeOver() {
            T t = this.f4174c;
            if (t != 0) {
                ((TTSplashAd.AdInteractionListener) t).onAdTimeOver();
            }
        }
    }

    public k(TTSplashAd tTSplashAd, String str, int i2) {
        super(tTSplashAd, str, i2);
        a aVar = new a(this.f4170b, this.f4171c);
        this.f4183d = aVar;
        ((TTSplashAd) this.f4169a).setSplashInteractionListener(aVar);
    }

    @Override // com.bytedance.sdk.openadsdk.TTSplashAd
    public int getInteractionType() {
        return ((TTSplashAd) this.f4169a).getInteractionType();
    }

    @Override // com.bytedance.sdk.openadsdk.TTSplashAd
    public Map<String, Object> getMediaExtraInfo() {
        return ((TTSplashAd) this.f4169a).getMediaExtraInfo();
    }

    @Override // com.bytedance.sdk.openadsdk.TTSplashAd
    public int[] getSplashClickEyeSizeToDp() {
        return ((TTSplashAd) this.f4169a).getSplashClickEyeSizeToDp();
    }

    @Override // com.bytedance.sdk.openadsdk.TTSplashAd
    public View getSplashView() {
        return ((TTSplashAd) this.f4169a).getSplashView();
    }

    @Override // com.bytedance.sdk.openadsdk.TTSplashAd
    public void renderExpressAd(TTNativeExpressAd.ExpressAdInteractionListener expressAdInteractionListener) {
        ((TTSplashAd) this.f4169a).renderExpressAd(expressAdInteractionListener);
    }

    @Override // com.bytedance.sdk.openadsdk.TTSplashAd
    public void setDownloadListener(TTAppDownloadListener tTAppDownloadListener) {
        ((TTSplashAd) this.f4169a).setDownloadListener(tTAppDownloadListener);
    }

    @Override // com.bytedance.sdk.openadsdk.TTSplashAd
    public void setNotAllowSdkCountdown() {
        ((TTSplashAd) this.f4169a).setNotAllowSdkCountdown();
    }

    @Override // com.bytedance.sdk.openadsdk.TTSplashAd
    public void setSplashClickEyeListener(ISplashClickEyeListener iSplashClickEyeListener) {
        ((TTSplashAd) this.f4169a).setSplashClickEyeListener(iSplashClickEyeListener);
    }

    @Override // com.bytedance.sdk.openadsdk.TTSplashAd
    public void setSplashInteractionListener(TTSplashAd.AdInteractionListener adInteractionListener) {
        this.f4183d.a(adInteractionListener);
    }

    @Override // com.bytedance.sdk.openadsdk.TTSplashAd
    public void splashClickEyeAnimationFinish() {
        ((TTSplashAd) this.f4169a).splashClickEyeAnimationFinish();
    }

    @Override // com.bytedance.sdk.openadsdk.TTSplashAd
    public void startClickEye() {
        ((TTSplashAd) this.f4169a).startClickEye();
    }
}
