package com.vivo.mobilead.unified.b;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.Nullable;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsFeedAd;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import com.vivo.mobilead.j.c;
import com.vivo.mobilead.unified.base.AdParams;
import com.vivo.mobilead.unified.base.e;
import com.vivo.mobilead.unified.base.view.s.f;
import com.vivo.mobilead.unified.nativead.UnifiedVivoNativeExpressAdListener;
import com.vivo.mobilead.util.c0;
import com.vivo.mobilead.util.j0;
import com.vivo.mobilead.util.k0;
import com.vivo.mobilead.util.l0;
import com.vivo.mobilead.util.v;
import java.util.List;

/* loaded from: classes4.dex */
public class b extends com.vivo.mobilead.unified.nativead.d {

    /* renamed from: g */
    private KsFeedAd f29675g;

    /* renamed from: h */
    private KsFeedAd.AdInteractionListener f29676h;

    class a implements KsLoadManager.FeedAdListener {
        a() {
        }

        @Override // com.kwad.sdk.api.KsLoadManager.FeedAdListener
        public void onError(int i2, String str) {
            b.this.a(new l0().a(c.a.f28915d).b(com.vivo.mobilead.unified.base.f.a.b(i2)).a(str).a(false));
            k0.a(((e) b.this).f29752e.f30662c, ((e) b.this).f29752e.f30661b, "4", ((e) b.this).f29752e.f30660a, 0, 1, 2, i2, str, c.a.f28915d.intValue());
        }

        @Override // com.kwad.sdk.api.KsLoadManager.FeedAdListener
        public void onFeedAdLoad(@Nullable List<KsFeedAd> list) {
            if (list == null || list.size() <= 0 || list.get(0) == null || list.get(0).getFeedView(((e) b.this).f29749b) == null) {
                b.this.a(new l0().a(c.a.f28915d).b(402130).a("暂无广告，请重试").a(false));
                k0.a(((e) b.this).f29752e.f30662c, ((e) b.this).f29752e.f30661b, "4", ((e) b.this).f29752e.f30660a, 0, 1, 2, 402130, "暂无广告，请重试", c.a.f28915d.intValue());
            } else {
                b.this.f29675g = list.get(0);
                b.this.a(new l0().a(c.a.f28915d).a(true));
                k0.a(((e) b.this).f29752e.f30662c, ((e) b.this).f29752e.f30661b, "4", ((e) b.this).f29752e.f30660a, 0, 1, 1, -10000, "", c.a.f28915d.intValue());
            }
        }
    }

    /* renamed from: com.vivo.mobilead.unified.b.b$b */
    class C0606b implements KsFeedAd.AdInteractionListener {
        C0606b() {
        }

        @Override // com.kwad.sdk.api.KsFeedAd.AdInteractionListener
        public void onAdClicked() {
            if (((e) b.this).f29751d != null && ((com.vivo.mobilead.unified.nativead.d) b.this).f30482f != null) {
                ((UnifiedVivoNativeExpressAdListener) ((e) b.this).f29751d).onAdClick(((com.vivo.mobilead.unified.nativead.d) b.this).f30482f);
            }
            k0.a("4", String.valueOf(c.a.f28915d), ((e) b.this).f29752e.f30660a, ((e) b.this).f29752e.f30661b, ((e) b.this).f29752e.f30662c, 0, false);
        }

        @Override // com.kwad.sdk.api.KsFeedAd.AdInteractionListener
        public void onAdShow() {
            if (((e) b.this).f29751d != null && ((com.vivo.mobilead.unified.nativead.d) b.this).f30482f != null) {
                ((UnifiedVivoNativeExpressAdListener) ((e) b.this).f29751d).onAdShow(((com.vivo.mobilead.unified.nativead.d) b.this).f30482f);
            }
            k0.a("4", String.valueOf(c.a.f28915d), ((e) b.this).f29752e.f30660a, ((e) b.this).f29752e.f30661b, ((e) b.this).f29752e.f30662c, 0);
        }

        @Override // com.kwad.sdk.api.KsFeedAd.AdInteractionListener
        public void onDislikeClicked() {
            if (((e) b.this).f29751d != null) {
                ((UnifiedVivoNativeExpressAdListener) ((e) b.this).f29751d).onAdClose(((com.vivo.mobilead.unified.nativead.d) b.this).f30482f);
            }
        }

        @Override // com.kwad.sdk.api.KsFeedAd.AdInteractionListener
        public void onDownloadTipsDialogDismiss() {
        }

        @Override // com.kwad.sdk.api.KsFeedAd.AdInteractionListener
        public void onDownloadTipsDialogShow() {
        }
    }

    public b(Context context, AdParams adParams) {
        super(context, adParams);
        this.f29676h = new C0606b();
    }

    @Override // com.vivo.mobilead.unified.nativead.d
    protected void d() {
        View feedView;
        KsFeedAd ksFeedAd = this.f29675g;
        if (ksFeedAd == null || (feedView = ksFeedAd.getFeedView(this.f29749b)) == null) {
            return;
        }
        int videoPolicy = this.f29750c.getVideoPolicy();
        boolean z = true;
        if (videoPolicy != 0 ? videoPolicy != 1 : c0.a(this.f29749b) != 100) {
            z = false;
        }
        this.f29675g.setVideoPlayConfig(new KsAdVideoPlayConfig.Builder().videoSoundEnable(false).dataFlowAutoStart(z).build());
        this.f29675g.setAdInteractionListener(this.f29676h);
        this.f30482f = new f(this.f29749b, feedView);
    }

    @Override // com.vivo.mobilead.unified.base.e
    public void b() {
        AdParams adParams;
        if (v.a() && this.f29749b != null && (adParams = this.f29750c) != null && !TextUtils.isEmpty(adParams.getPositionId())) {
            try {
                KsAdSDK.getLoadManager().loadConfigFeedAd(new KsScene.Builder(Long.parseLong(this.f29750c.getPositionId())).build(), new a());
                j0 j0Var = this.f29752e;
                k0.a(j0Var.f30662c, j0Var.f30661b, "4", 1, 0, 1, c.a.f28915d.intValue(), 1);
                return;
            } catch (Exception unused) {
                a(new l0().a(c.a.f28915d).b(402130).a("暂无广告，请重试").a(false));
                return;
            }
        }
        a(new l0().a(c.a.f28915d).b(402130).a("暂无广告，请重试").a(false));
    }
}
