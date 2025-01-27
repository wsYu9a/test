package b.a.a.a.c.d.b;

import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTRewardVideoAd;
import com.vivo.mobilead.util.k0;

/* loaded from: classes.dex */
public class i extends a<TTAdNative.RewardVideoAdListener> implements TTAdNative.RewardVideoAdListener {
    public i(TTAdNative.RewardVideoAdListener rewardVideoAdListener, String str, int i2) {
        super(rewardVideoAdListener, str, i2);
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative.RewardVideoAdListener
    public void onRewardVideoAdLoad(TTRewardVideoAd tTRewardVideoAd) {
        k0.d(this.f4185b, this.f4186c);
        T t = this.f4184a;
        if (t != 0) {
            ((TTAdNative.RewardVideoAdListener) t).onRewardVideoAdLoad(tTRewardVideoAd == null ? null : new b.a.a.a.c.d.a.j(tTRewardVideoAd, this.f4185b, this.f4186c));
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative.RewardVideoAdListener
    public void onRewardVideoCached() {
        T t = this.f4184a;
        if (t != 0) {
            ((TTAdNative.RewardVideoAdListener) t).onRewardVideoCached();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative.RewardVideoAdListener
    public void onRewardVideoCached(TTRewardVideoAd tTRewardVideoAd) {
        T t = this.f4184a;
        if (t != 0) {
            ((TTAdNative.RewardVideoAdListener) t).onRewardVideoCached(tTRewardVideoAd == null ? null : new b.a.a.a.c.d.a.j(tTRewardVideoAd, this.f4185b, this.f4186c));
        }
    }
}
