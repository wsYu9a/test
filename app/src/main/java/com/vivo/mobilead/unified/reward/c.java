package com.vivo.mobilead.unified.reward;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.Nullable;
import com.cdo.oaps.ad.wrapper.BaseWrapper;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsRewardVideoAd;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.vivo.mobilead.j.c;
import com.vivo.mobilead.unified.base.AdParams;
import com.vivo.mobilead.unified.base.VivoAdError;
import com.vivo.mobilead.unified.base.callback.MediaListener;
import com.vivo.mobilead.util.k0;
import com.vivo.mobilead.util.l0;
import com.vivo.mobilead.util.v;
import java.util.List;

/* loaded from: classes4.dex */
public class c extends h {
    private KsRewardVideoAd.RewardAdInteractionListener A;
    private KsRewardVideoAd y;
    private KsLoadManager.RewardVideoAdListener z;

    class a implements KsLoadManager.RewardVideoAdListener {
        a() {
        }

        @Override // com.kwad.sdk.api.KsLoadManager.RewardVideoAdListener
        public void onError(int i2, String str) {
            c.this.a(new l0().a(c.a.f28915d).a((int[]) null).a(false).b(com.vivo.mobilead.unified.base.f.a.b(i2)).a(str));
            k0.a(((com.vivo.mobilead.unified.a) c.this).f29662b.getPositionId(), ((com.vivo.mobilead.unified.a) c.this).f29663c, BaseWrapper.ENTER_ID_MESSAGE, ((com.vivo.mobilead.unified.a) c.this).f29664d, 1, 2, 2, i2, str, c.a.f28915d.intValue());
        }

        @Override // com.kwad.sdk.api.KsLoadManager.RewardVideoAdListener
        public void onRewardVideoAdLoad(@Nullable List<KsRewardVideoAd> list) {
            if (list == null || list.size() == 0 || list.get(0) == null) {
                c.this.a(new l0().a(c.a.f28915d).a((int[]) null).a(false).b(402130).a("暂无广告，请重试"));
                k0.a(((com.vivo.mobilead.unified.a) c.this).f29662b.getPositionId(), ((com.vivo.mobilead.unified.a) c.this).f29663c, BaseWrapper.ENTER_ID_MESSAGE, ((com.vivo.mobilead.unified.a) c.this).f29664d, 1, 2, 2, 402130, "暂无广告，请重试", c.a.f28915d.intValue());
            } else {
                c.this.y = list.get(0);
                c.this.a(new l0().a(c.a.f28915d).a((int[]) null).a(true));
                k0.a(((com.vivo.mobilead.unified.a) c.this).f29662b.getPositionId(), ((com.vivo.mobilead.unified.a) c.this).f29663c, BaseWrapper.ENTER_ID_MESSAGE, ((com.vivo.mobilead.unified.a) c.this).f29664d, 1, 2, 1, -10000, "", c.a.f28915d.intValue());
            }
        }

        @Override // com.kwad.sdk.api.KsLoadManager.RewardVideoAdListener
        public void onRewardVideoResult(@Nullable List<KsRewardVideoAd> list) {
        }
    }

    class b implements KsRewardVideoAd.RewardAdInteractionListener {
        b() {
        }

        @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
        public void onAdClicked() {
            UnifiedVivoRewardVideoAdListener unifiedVivoRewardVideoAdListener = c.this.t;
            if (unifiedVivoRewardVideoAdListener != null) {
                unifiedVivoRewardVideoAdListener.onAdClick();
            }
            k0.a(BaseWrapper.ENTER_ID_MESSAGE, c.a.f28915d + "", ((com.vivo.mobilead.unified.a) c.this).f29664d, ((com.vivo.mobilead.unified.a) c.this).f29663c, ((com.vivo.mobilead.unified.a) c.this).f29665e, 1, false);
        }

        @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
        public void onPageDismiss() {
            UnifiedVivoRewardVideoAdListener unifiedVivoRewardVideoAdListener = c.this.t;
            if (unifiedVivoRewardVideoAdListener != null) {
                unifiedVivoRewardVideoAdListener.onAdClose();
            }
        }

        @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
        public void onRewardStepVerify(int i2, int i3) {
        }

        @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
        public void onRewardVerify() {
            UnifiedVivoRewardVideoAdListener unifiedVivoRewardVideoAdListener = c.this.t;
            if (unifiedVivoRewardVideoAdListener != null) {
                unifiedVivoRewardVideoAdListener.onRewardVerify();
            }
        }

        @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
        public void onVideoPlayEnd() {
            MediaListener mediaListener = c.this.u;
            if (mediaListener != null) {
                mediaListener.onVideoCompletion();
            }
        }

        @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
        public void onVideoPlayError(int i2, int i3) {
            MediaListener mediaListener = c.this.u;
            if (mediaListener != null) {
                mediaListener.onVideoError(new VivoAdError(i2, ""));
            }
        }

        @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
        public void onVideoPlayStart() {
            MediaListener mediaListener = c.this.u;
            if (mediaListener != null) {
                mediaListener.onVideoStart();
            }
            UnifiedVivoRewardVideoAdListener unifiedVivoRewardVideoAdListener = c.this.t;
            if (unifiedVivoRewardVideoAdListener != null) {
                unifiedVivoRewardVideoAdListener.onAdShow();
            }
            k0.a(BaseWrapper.ENTER_ID_MESSAGE, c.a.f28915d + "", ((com.vivo.mobilead.unified.a) c.this).f29664d, ((com.vivo.mobilead.unified.a) c.this).f29663c, ((com.vivo.mobilead.unified.a) c.this).f29665e, 1);
            k0.a(BaseWrapper.ENTER_ID_MESSAGE, c.a.f28915d + "", ((com.vivo.mobilead.unified.a) c.this).f29664d, ((com.vivo.mobilead.unified.a) c.this).f29663c, ((com.vivo.mobilead.unified.a) c.this).f29665e);
        }

        @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
        public void onVideoSkipToEnd(long j2) {
        }
    }

    public c(Context context, AdParams adParams) {
        super(context, adParams);
        this.z = new a();
        this.A = new b();
    }

    @Override // com.vivo.mobilead.unified.a
    public void l() {
        if (!v.a()) {
            a(new l0().a(c.a.f28915d).a(false).b(402130).a("暂无广告，请重试"));
            return;
        }
        try {
            k0.a(this.f29662b.getPositionId(), this.f29663c, BaseWrapper.ENTER_ID_MESSAGE, 1, 1, 1, c.a.f28915d.intValue(), 2);
            KsAdSDK.getLoadManager().loadRewardVideoAd(new KsScene.Builder(Long.parseLong(this.f29662b.getPositionId())).build(), this.z);
        } catch (Exception unused) {
            a(new l0().a(c.a.f28915d).a(false).b(402130).a("暂无广告，请重试"));
        }
    }

    @Override // com.vivo.mobilead.unified.reward.a
    public void a(Activity activity) {
        KsRewardVideoAd ksRewardVideoAd;
        if (activity == null || activity.isFinishing() || (ksRewardVideoAd = this.y) == null || !ksRewardVideoAd.isAdEnable() || d.c().b()) {
            return;
        }
        d.c().a(true);
        this.y.setRewardAdInteractionListener(this.A);
        this.y.showRewardVideoAd(activity, new KsVideoPlayConfig.Builder().videoSoundEnable(true).build());
    }
}
