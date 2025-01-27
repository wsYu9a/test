package b.a.a.a.c.d.b;

import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTFullScreenVideoAd;
import com.vivo.mobilead.util.k0;

/* loaded from: classes.dex */
public class e extends a<TTAdNative.FullScreenVideoAdListener> implements TTAdNative.FullScreenVideoAdListener {
    public e(TTAdNative.FullScreenVideoAdListener fullScreenVideoAdListener, String str, int i2) {
        super(fullScreenVideoAdListener, str, i2);
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative.FullScreenVideoAdListener
    public void onFullScreenVideoAdLoad(TTFullScreenVideoAd tTFullScreenVideoAd) {
        k0.d(this.f4185b, this.f4186c);
        T t = this.f4184a;
        if (t != 0) {
            ((TTAdNative.FullScreenVideoAdListener) t).onFullScreenVideoAdLoad(tTFullScreenVideoAd == null ? null : new b.a.a.a.c.d.a.f(tTFullScreenVideoAd, this.f4185b, this.f4186c));
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative.FullScreenVideoAdListener
    public void onFullScreenVideoCached() {
        T t = this.f4184a;
        if (t != 0) {
            ((TTAdNative.FullScreenVideoAdListener) t).onFullScreenVideoCached();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative.FullScreenVideoAdListener
    public void onFullScreenVideoCached(TTFullScreenVideoAd tTFullScreenVideoAd) {
        T t = this.f4184a;
        if (t != 0) {
            ((TTAdNative.FullScreenVideoAdListener) t).onFullScreenVideoCached(tTFullScreenVideoAd == null ? null : new b.a.a.a.c.d.a.f(tTFullScreenVideoAd, this.f4185b, this.f4186c));
        }
    }
}
