package b.a.a.a.c.d.a;

import android.app.Activity;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.bytedance.sdk.openadsdk.TTRewardVideoAd;
import com.vivo.mobilead.util.k0;
import java.util.Map;

/* loaded from: classes.dex */
public class j extends b.a.a.a.c.d.a.a<TTRewardVideoAd> implements TTRewardVideoAd {

    /* renamed from: d */
    private final a f4182d;

    static class a extends b<TTRewardVideoAd.RewardAdInteractionListener> implements TTRewardVideoAd.RewardAdInteractionListener {
        public a(String str, int i2) {
            super(str, i2);
        }

        @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
        public void onAdClose() {
            T t = this.f4174c;
            if (t != 0) {
                ((TTRewardVideoAd.RewardAdInteractionListener) t).onAdClose();
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
        public void onAdShow() {
            k0.b(this.f4172a, this.f4173b);
            T t = this.f4174c;
            if (t != 0) {
                ((TTRewardVideoAd.RewardAdInteractionListener) t).onAdShow();
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
        public void onAdVideoBarClick() {
            k0.a(this.f4172a, this.f4173b);
            T t = this.f4174c;
            if (t != 0) {
                ((TTRewardVideoAd.RewardAdInteractionListener) t).onAdVideoBarClick();
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
        public void onRewardVerify(boolean z, int i2, String str, int i3, String str2) {
            T t = this.f4174c;
            if (t != 0) {
                ((TTRewardVideoAd.RewardAdInteractionListener) t).onRewardVerify(z, i2, str, i3, str2);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
        public void onSkippedVideo() {
            T t = this.f4174c;
            if (t != 0) {
                ((TTRewardVideoAd.RewardAdInteractionListener) t).onSkippedVideo();
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
        public void onVideoComplete() {
            T t = this.f4174c;
            if (t != 0) {
                ((TTRewardVideoAd.RewardAdInteractionListener) t).onVideoComplete();
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
        public void onVideoError() {
            T t = this.f4174c;
            if (t != 0) {
                ((TTRewardVideoAd.RewardAdInteractionListener) t).onVideoError();
            }
        }
    }

    public j(TTRewardVideoAd tTRewardVideoAd, String str, int i2) {
        super(tTRewardVideoAd, str, i2);
        this.f4182d = new a(this.f4170b, this.f4171c);
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd
    public long getExpirationTimestamp() {
        return ((TTRewardVideoAd) this.f4169a).getExpirationTimestamp();
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd
    public int getInteractionType() {
        return ((TTRewardVideoAd) this.f4169a).getInteractionType();
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd
    public Map<String, Object> getMediaExtraInfo() {
        return ((TTRewardVideoAd) this.f4169a).getMediaExtraInfo();
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd
    public int getRewardVideoAdType() {
        return ((TTRewardVideoAd) this.f4169a).getRewardVideoAdType();
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd
    public void setDownloadListener(TTAppDownloadListener tTAppDownloadListener) {
        ((TTRewardVideoAd) this.f4169a).setDownloadListener(tTAppDownloadListener);
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd
    public void setRewardAdInteractionListener(TTRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener) {
        this.f4182d.a(rewardAdInteractionListener);
        ((TTRewardVideoAd) this.f4169a).setRewardAdInteractionListener(this.f4182d);
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd
    public void setRewardPlayAgainInteractionListener(TTRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener) {
        this.f4182d.a(rewardAdInteractionListener);
        ((TTRewardVideoAd) this.f4169a).setRewardPlayAgainInteractionListener(this.f4182d);
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd
    public void setShowDownLoadBar(boolean z) {
        ((TTRewardVideoAd) this.f4169a).setShowDownLoadBar(z);
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd
    public void showRewardVideoAd(Activity activity) {
        ((TTRewardVideoAd) this.f4169a).showRewardVideoAd(activity);
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd
    public void showRewardVideoAd(Activity activity, TTAdConstant.RitScenes ritScenes, String str) {
        ((TTRewardVideoAd) this.f4169a).showRewardVideoAd(activity, ritScenes, str);
    }
}
