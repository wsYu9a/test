package b.a.a.a.c.d.b;

import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTBannerAd;
import com.vivo.mobilead.util.k0;

/* loaded from: classes.dex */
public class b extends a<TTAdNative.BannerAdListener> implements TTAdNative.BannerAdListener {
    public b(TTAdNative.BannerAdListener bannerAdListener, String str, int i2) {
        super(bannerAdListener, str, i2);
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative.BannerAdListener
    public void onBannerAdLoad(TTBannerAd tTBannerAd) {
        k0.d(this.f4185b, this.f4186c);
        T t = this.f4184a;
        if (t != 0) {
            ((TTAdNative.BannerAdListener) t).onBannerAdLoad(tTBannerAd == null ? null : new b.a.a.a.c.d.a.c(tTBannerAd, this.f4185b, this.f4186c));
        }
    }
}
