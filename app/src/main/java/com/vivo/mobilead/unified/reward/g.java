package com.vivo.mobilead.unified.reward;

import android.app.Activity;
import android.content.Context;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTRewardVideoAd;
import com.cdo.oaps.ad.wrapper.BaseWrapper;
import com.vivo.mobilead.j.c;
import com.vivo.mobilead.unified.base.AdParams;
import com.vivo.mobilead.unified.base.VivoAdError;
import com.vivo.mobilead.unified.base.callback.MediaListener;
import com.vivo.mobilead.util.k0;
import com.vivo.mobilead.util.l0;
import com.vivo.mobilead.util.m;
import com.vivo.mobilead.util.s0;

/* loaded from: classes4.dex */
public class g extends h {
    private TTRewardVideoAd.RewardAdInteractionListener A;
    private AdSlot y;
    private TTRewardVideoAd z;

    class a implements TTAdNative.RewardVideoAdListener {
        a() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.RewardVideoAdListener, com.bytedance.sdk.openadsdk.common.CommonListener
        public void onError(int i2, String str) {
            g.this.a(new l0().a(c.a.f28913b).a((int[]) null).a(false).b(com.vivo.mobilead.unified.base.f.a.c(i2)).a(str));
            k0.a(((com.vivo.mobilead.unified.a) g.this).f29662b.getPositionId(), ((com.vivo.mobilead.unified.a) g.this).f29663c, BaseWrapper.ENTER_ID_MESSAGE, ((com.vivo.mobilead.unified.a) g.this).f29664d, 1, 2, 2, i2, str, c.a.f28913b.intValue());
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.RewardVideoAdListener
        public void onRewardVideoAdLoad(TTRewardVideoAd tTRewardVideoAd) {
            if (tTRewardVideoAd == null) {
                g.this.a(new l0().a(c.a.f28913b).a((int[]) null).a(false).b(402114).a("暂无广告，请重试"));
                k0.a(((com.vivo.mobilead.unified.a) g.this).f29662b.getPositionId(), ((com.vivo.mobilead.unified.a) g.this).f29663c, BaseWrapper.ENTER_ID_MESSAGE, ((com.vivo.mobilead.unified.a) g.this).f29664d, 1, 2, 2, 402114, "暂无广告，请重试", c.a.f28913b.intValue());
            } else {
                tTRewardVideoAd.setRewardAdInteractionListener(g.this.A);
                g.this.z = tTRewardVideoAd;
                g.this.a(new l0().a(c.a.f28913b).a((int[]) null).a(true));
                k0.a(((com.vivo.mobilead.unified.a) g.this).f29662b.getPositionId(), ((com.vivo.mobilead.unified.a) g.this).f29663c, BaseWrapper.ENTER_ID_MESSAGE, ((com.vivo.mobilead.unified.a) g.this).f29664d, 1, 2, 1, -10000, "", c.a.f28913b.intValue());
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.RewardVideoAdListener
        public void onRewardVideoCached() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.RewardVideoAdListener
        public void onRewardVideoCached(TTRewardVideoAd tTRewardVideoAd) {
            g.this.p();
        }
    }

    class b implements TTRewardVideoAd.RewardAdInteractionListener {
        b() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
        public void onAdClose() {
            UnifiedVivoRewardVideoAdListener unifiedVivoRewardVideoAdListener = g.this.t;
            if (unifiedVivoRewardVideoAdListener != null) {
                unifiedVivoRewardVideoAdListener.onAdClose();
            }
            g.this.z = null;
        }

        @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
        public void onAdShow() {
            MediaListener mediaListener = g.this.u;
            if (mediaListener != null) {
                mediaListener.onVideoStart();
            }
            k0.a(BaseWrapper.ENTER_ID_MESSAGE, c.a.f28913b + "", ((com.vivo.mobilead.unified.a) g.this).f29664d, ((com.vivo.mobilead.unified.a) g.this).f29663c, ((com.vivo.mobilead.unified.a) g.this).f29665e, 1);
            k0.a(BaseWrapper.ENTER_ID_MESSAGE, c.a.f28913b + "", ((com.vivo.mobilead.unified.a) g.this).f29664d, ((com.vivo.mobilead.unified.a) g.this).f29663c, ((com.vivo.mobilead.unified.a) g.this).f29665e);
        }

        @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
        public void onAdVideoBarClick() {
            k0.a(BaseWrapper.ENTER_ID_MESSAGE, c.a.f28913b + "", ((com.vivo.mobilead.unified.a) g.this).f29664d, ((com.vivo.mobilead.unified.a) g.this).f29663c, ((com.vivo.mobilead.unified.a) g.this).f29665e, 1, false);
        }

        @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
        public void onRewardVerify(boolean z, int i2, String str, int i3, String str2) {
            UnifiedVivoRewardVideoAdListener unifiedVivoRewardVideoAdListener = g.this.t;
            if (unifiedVivoRewardVideoAdListener != null) {
                unifiedVivoRewardVideoAdListener.onRewardVerify();
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
        public void onSkippedVideo() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
        public void onVideoComplete() {
            MediaListener mediaListener = g.this.u;
            if (mediaListener != null) {
                mediaListener.onVideoCompletion();
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
        public void onVideoError() {
            MediaListener mediaListener = g.this.u;
            if (mediaListener != null) {
                mediaListener.onVideoError(new VivoAdError(402119, "视频播放出错，建议重试"));
            }
            g.this.z = null;
        }
    }

    public g(Context context, AdParams adParams) {
        super(context, adParams);
        this.A = new b();
        this.y = new AdSlot.Builder().setCodeId(adParams.getPositionId()).setSupportDeepLink(true).setImageAcceptedSize(context.getResources().getDisplayMetrics().widthPixels, context.getResources().getDisplayMetrics().heightPixels).setOrientation(m.c(context)).build();
    }

    @Override // com.vivo.mobilead.unified.a
    public void l() {
        if (!s0.b()) {
            a(new l0().a("暂无广告，请重试").b(402114).a(false).a(c.a.f28913b));
        } else {
            k0.a(this.f29662b.getPositionId(), this.f29663c, BaseWrapper.ENTER_ID_MESSAGE, 1, 1, 1, c.a.f28913b.intValue(), 2);
            s0.a().createAdNative(this.f29661a).loadRewardVideoAd(this.y, new a());
        }
    }

    @Override // com.vivo.mobilead.unified.reward.a
    public void a(Activity activity) {
        if (activity == null || activity.isFinishing() || this.z == null || d.c().b()) {
            return;
        }
        d.c().a(true);
        this.z.showRewardVideoAd(activity);
    }
}
