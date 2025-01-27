package b.a.a.a.c.d.b;

import b.a.a.a.c.d.a.k;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTSplashAd;
import com.vivo.mobilead.util.k0;

/* loaded from: classes.dex */
public class j extends a<TTAdNative.SplashAdListener> implements TTAdNative.SplashAdListener {
    public j(TTAdNative.SplashAdListener splashAdListener, String str, int i2) {
        super(splashAdListener, str, i2);
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative.SplashAdListener
    public void onSplashAdLoad(TTSplashAd tTSplashAd) {
        k0.d(this.f4185b, this.f4186c);
        T t = this.f4184a;
        if (t != 0) {
            ((TTAdNative.SplashAdListener) t).onSplashAdLoad(tTSplashAd == null ? null : new k(tTSplashAd, this.f4185b, this.f4186c));
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative.SplashAdListener
    public void onTimeout() {
        T t = this.f4184a;
        if (t != 0) {
            ((TTAdNative.SplashAdListener) t).onTimeout();
        }
    }
}
