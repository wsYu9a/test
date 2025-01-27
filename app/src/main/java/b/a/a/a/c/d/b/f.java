package b.a.a.a.c.d.b;

import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTInteractionAd;
import com.vivo.mobilead.util.k0;

/* loaded from: classes.dex */
public class f extends a<TTAdNative.InteractionAdListener> implements TTAdNative.InteractionAdListener {
    public f(TTAdNative.InteractionAdListener interactionAdListener, String str, int i2) {
        super(interactionAdListener, str, i2);
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative.InteractionAdListener
    public void onInteractionAdLoad(TTInteractionAd tTInteractionAd) {
        k0.d(this.f4185b, this.f4186c);
        T t = this.f4184a;
        if (t != 0) {
            ((TTAdNative.InteractionAdListener) t).onInteractionAdLoad(tTInteractionAd == null ? null : new b.a.a.a.c.d.a.g(tTInteractionAd, this.f4185b, this.f4186c));
        }
    }
}
