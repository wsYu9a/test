package com.vivo.mobilead.unified.reward;

import android.app.Activity;
import android.content.Context;
import android.os.SystemClock;
import com.cdo.oaps.ad.wrapper.BaseWrapper;
import com.qq.e.ads.rewardvideo.RewardVideoAD;
import com.qq.e.ads.rewardvideo.RewardVideoADListener;
import com.qq.e.comm.util.AdError;
import com.vivo.mobilead.j.c;
import com.vivo.mobilead.unified.base.AdParams;
import com.vivo.mobilead.unified.base.VivoAdError;
import com.vivo.mobilead.unified.base.callback.MediaListener;
import com.vivo.mobilead.util.k0;
import com.vivo.mobilead.util.l0;
import java.util.Map;

/* loaded from: classes4.dex */
public class b extends h {
    private RewardVideoAD y;
    private RewardVideoADListener z;

    class a implements RewardVideoADListener {
        a() {
        }

        @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
        public void onADClick() {
            UnifiedVivoRewardVideoAdListener unifiedVivoRewardVideoAdListener = b.this.t;
            if (unifiedVivoRewardVideoAdListener != null) {
                unifiedVivoRewardVideoAdListener.onAdClick();
            }
            k0.a(BaseWrapper.ENTER_ID_MESSAGE, String.valueOf(c.a.f28914c), ((com.vivo.mobilead.unified.a) b.this).f29664d, ((com.vivo.mobilead.unified.a) b.this).f29663c, ((com.vivo.mobilead.unified.a) b.this).f29665e, 1, false);
        }

        @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
        public void onADClose() {
            UnifiedVivoRewardVideoAdListener unifiedVivoRewardVideoAdListener = b.this.t;
            if (unifiedVivoRewardVideoAdListener != null) {
                unifiedVivoRewardVideoAdListener.onAdClose();
            }
        }

        @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
        public void onADExpose() {
            MediaListener mediaListener = b.this.u;
            if (mediaListener != null) {
                mediaListener.onVideoStart();
            }
            k0.a(BaseWrapper.ENTER_ID_MESSAGE, String.valueOf(c.a.f28914c), ((com.vivo.mobilead.unified.a) b.this).f29664d, ((com.vivo.mobilead.unified.a) b.this).f29663c, ((com.vivo.mobilead.unified.a) b.this).f29665e);
        }

        @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
        public void onADLoad() {
            b.this.a(new l0().a(c.a.f28914c).a((int[]) null).a(true));
            k0.a(((com.vivo.mobilead.unified.a) b.this).f29662b.getPositionId(), ((com.vivo.mobilead.unified.a) b.this).f29663c, BaseWrapper.ENTER_ID_MESSAGE, ((com.vivo.mobilead.unified.a) b.this).f29664d, 1, 2, 1, -10000, "", c.a.f28914c.intValue());
        }

        @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
        public void onADShow() {
            UnifiedVivoRewardVideoAdListener unifiedVivoRewardVideoAdListener = b.this.t;
            if (unifiedVivoRewardVideoAdListener != null) {
                unifiedVivoRewardVideoAdListener.onAdShow();
            }
            k0.a(BaseWrapper.ENTER_ID_MESSAGE, String.valueOf(c.a.f28914c), ((com.vivo.mobilead.unified.a) b.this).f29664d, ((com.vivo.mobilead.unified.a) b.this).f29663c, ((com.vivo.mobilead.unified.a) b.this).f29665e, 1);
        }

        @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
        public void onError(AdError adError) {
            if (adError == null) {
                adError = new AdError();
            }
            if (adError.getErrorCode() != 5002 && adError.getErrorCode() != 5003) {
                b.this.a(new l0().a(c.a.f28914c).a((int[]) null).a(false).b(com.vivo.mobilead.unified.base.f.a.a(adError.getErrorCode())).a(adError.getErrorMsg()));
                k0.a(((com.vivo.mobilead.unified.a) b.this).f29662b.getPositionId(), ((com.vivo.mobilead.unified.a) b.this).f29663c, BaseWrapper.ENTER_ID_MESSAGE, ((com.vivo.mobilead.unified.a) b.this).f29664d, 1, 2, 2, adError.getErrorCode(), adError.getErrorMsg(), c.a.f28914c.intValue());
            } else {
                MediaListener mediaListener = b.this.u;
                if (mediaListener != null) {
                    mediaListener.onVideoError(new VivoAdError(com.vivo.mobilead.unified.base.f.a.a(adError.getErrorCode()), adError.getErrorMsg()));
                }
            }
        }

        @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
        public void onReward(Map<String, Object> map) {
            UnifiedVivoRewardVideoAdListener unifiedVivoRewardVideoAdListener = b.this.t;
            if (unifiedVivoRewardVideoAdListener != null) {
                unifiedVivoRewardVideoAdListener.onRewardVerify();
            }
        }

        @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
        public void onVideoCached() {
            b.this.p();
        }

        @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
        public void onVideoComplete() {
            MediaListener mediaListener = b.this.u;
            if (mediaListener != null) {
                mediaListener.onVideoCompletion();
            }
        }
    }

    public b(Context context, AdParams adParams) {
        super(context, adParams);
        this.z = new a();
    }

    @Override // com.vivo.mobilead.unified.reward.a
    public void a(Activity activity) {
        RewardVideoAD rewardVideoAD = this.y;
        if (rewardVideoAD == null || rewardVideoAD.hasShown() || d.c().b()) {
            return;
        }
        if (SystemClock.elapsedRealtime() < this.y.getExpireTimestamp() - 1000) {
            d.c().a(true);
            this.y.showAD(activity);
        } else {
            UnifiedVivoRewardVideoAdListener unifiedVivoRewardVideoAdListener = this.t;
            if (unifiedVivoRewardVideoAdListener != null) {
                unifiedVivoRewardVideoAdListener.onAdFailed(new VivoAdError(402113, "广告已经过期，请不要缓存广告过久"));
            }
        }
    }

    @Override // com.vivo.mobilead.unified.a
    public void l() {
        this.y = new RewardVideoAD(this.f29661a, this.f29662b.getPositionId(), this.z, true);
        k0.a(this.f29662b.getPositionId(), this.f29663c, BaseWrapper.ENTER_ID_MESSAGE, 1, 1, 1, c.a.f28914c.intValue(), 2);
        this.y.loadAD();
    }
}
