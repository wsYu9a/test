package b.a.a.a.c.d.a;

import android.app.Activity;
import android.view.View;
import com.bytedance.sdk.openadsdk.DislikeInfo;
import com.bytedance.sdk.openadsdk.TTAdDislike;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import com.vivo.mobilead.util.k0;
import java.util.Map;

/* loaded from: classes.dex */
public class i extends b.a.a.a.c.d.a.a<TTNativeExpressAd> implements TTNativeExpressAd {

    /* renamed from: d */
    private final a f4181d;

    static class a extends b<TTNativeExpressAd.ExpressAdInteractionListener> implements TTNativeExpressAd.AdInteractionListener {
        public a(String str, int i2) {
            super(str, i2);
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
        public void onAdClicked(View view, int i2) {
            k0.a(this.f4172a, this.f4173b);
            T t = this.f4174c;
            if (t != 0) {
                ((TTNativeExpressAd.ExpressAdInteractionListener) t).onAdClicked(view, i2);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.AdInteractionListener
        public void onAdDismiss() {
            T t = this.f4174c;
            if (t instanceof TTNativeExpressAd.AdInteractionListener) {
                ((TTNativeExpressAd.AdInteractionListener) t).onAdDismiss();
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
        public void onAdShow(View view, int i2) {
            k0.b(this.f4172a, this.f4173b);
            T t = this.f4174c;
            if (t != 0) {
                ((TTNativeExpressAd.ExpressAdInteractionListener) t).onAdShow(view, i2);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
        public void onRenderFail(View view, String str, int i2) {
            T t = this.f4174c;
            if (t != 0) {
                ((TTNativeExpressAd.ExpressAdInteractionListener) t).onRenderFail(view, str, i2);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
        public void onRenderSuccess(View view, float f2, float f3) {
            T t = this.f4174c;
            if (t != 0) {
                ((TTNativeExpressAd.ExpressAdInteractionListener) t).onRenderSuccess(view, f2, f3);
            }
        }
    }

    public i(TTNativeExpressAd tTNativeExpressAd, String str, int i2) {
        super(tTNativeExpressAd, str, i2);
        a aVar = new a(str, i2);
        this.f4181d = aVar;
        ((TTNativeExpressAd) this.f4169a).setExpressInteractionListener((TTNativeExpressAd.AdInteractionListener) aVar);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void destroy() {
        ((TTNativeExpressAd) this.f4169a).destroy();
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public TTAdDislike getDislikeDialog(Activity activity) {
        return ((TTNativeExpressAd) this.f4169a).getDislikeDialog(activity);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public DislikeInfo getDislikeInfo() {
        return ((TTNativeExpressAd) this.f4169a).getDislikeInfo();
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public View getExpressAdView() {
        return ((TTNativeExpressAd) this.f4169a).getExpressAdView();
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public int getImageMode() {
        return ((TTNativeExpressAd) this.f4169a).getImageMode();
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public int getInteractionType() {
        return ((TTNativeExpressAd) this.f4169a).getInteractionType();
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public Map<String, Object> getMediaExtraInfo() {
        return ((TTNativeExpressAd) this.f4169a).getMediaExtraInfo();
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void render() {
        ((TTNativeExpressAd) this.f4169a).render();
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void setCanInterruptVideoPlay(boolean z) {
        ((TTNativeExpressAd) this.f4169a).setCanInterruptVideoPlay(z);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void setDislikeCallback(Activity activity, TTAdDislike.DislikeInteractionCallback dislikeInteractionCallback) {
        ((TTNativeExpressAd) this.f4169a).setDislikeCallback(activity, dislikeInteractionCallback);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void setDislikeDialog(TTDislikeDialogAbstract tTDislikeDialogAbstract) {
        ((TTNativeExpressAd) this.f4169a).setDislikeDialog(tTDislikeDialogAbstract);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void setDownloadListener(TTAppDownloadListener tTAppDownloadListener) {
        ((TTNativeExpressAd) this.f4169a).setDownloadListener(tTAppDownloadListener);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void setExpressInteractionListener(TTNativeExpressAd.ExpressAdInteractionListener expressAdInteractionListener) {
        this.f4181d.a(expressAdInteractionListener);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void setSlideIntervalTime(int i2) {
        ((TTNativeExpressAd) this.f4169a).setSlideIntervalTime(i2);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void setVideoAdListener(TTNativeExpressAd.ExpressVideoAdListener expressVideoAdListener) {
        ((TTNativeExpressAd) this.f4169a).setVideoAdListener(expressVideoAdListener);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void showInteractionExpressAd(Activity activity) {
        ((TTNativeExpressAd) this.f4169a).showInteractionExpressAd(activity);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void setExpressInteractionListener(TTNativeExpressAd.AdInteractionListener adInteractionListener) {
        this.f4181d.a(adInteractionListener);
    }
}
