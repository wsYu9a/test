package com.vivo.mobilead.unified.b;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdDislike;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import com.vivo.mobilead.j.c;
import com.vivo.mobilead.unified.base.AdParams;
import com.vivo.mobilead.unified.base.e;
import com.vivo.mobilead.unified.base.view.s.n;
import com.vivo.mobilead.unified.nativead.UnifiedVivoNativeExpressAdListener;
import com.vivo.mobilead.util.c0;
import com.vivo.mobilead.util.j0;
import com.vivo.mobilead.util.k0;
import com.vivo.mobilead.util.l0;
import com.vivo.mobilead.util.s0;
import java.util.List;

/* loaded from: classes4.dex */
public class c extends com.vivo.mobilead.unified.nativead.d {

    /* renamed from: g */
    private TTNativeExpressAd f29679g;

    /* renamed from: h */
    private TTNativeExpressAd.AdInteractionListener f29680h;

    class a implements TTAdNative.NativeExpressAdListener {
        a() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener, com.bytedance.sdk.openadsdk.common.CommonListener
        public void onError(int i2, String str) {
            c.this.a(new l0().a(c.a.f28913b).b(com.vivo.mobilead.unified.base.f.a.c(i2)).a(str).a(false));
            k0.a(((e) c.this).f29752e.f30662c, ((e) c.this).f29752e.f30661b, "4", ((e) c.this).f29752e.f30660a, 0, 1, 2, i2, str, c.a.f28913b.intValue());
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener
        public void onNativeExpressAdLoad(List<TTNativeExpressAd> list) {
            if (list == null || list.size() <= 0 || list.get(0) == null) {
                c.this.a(new l0().a(c.a.f28913b).b(402114).a("暂无广告，请重试").a(false));
                k0.a(((e) c.this).f29752e.f30662c, ((e) c.this).f29752e.f30661b, "4", ((e) c.this).f29752e.f30660a, 0, 1, 2, 402114, "暂无广告，请重试", c.a.f28913b.intValue());
                return;
            }
            c.this.f29679g = list.get(0);
            c.this.f29679g.setExpressInteractionListener(c.this.f29680h);
            c cVar = c.this;
            cVar.a(cVar.f29679g);
            c.this.f29679g.render();
        }
    }

    class b implements TTNativeExpressAd.AdInteractionListener {
        b() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
        public void onAdClicked(View view, int i2) {
            if (((e) c.this).f29751d != null && ((com.vivo.mobilead.unified.nativead.d) c.this).f30482f != null) {
                ((UnifiedVivoNativeExpressAdListener) ((e) c.this).f29751d).onAdClick(((com.vivo.mobilead.unified.nativead.d) c.this).f30482f);
            }
            k0.a("4", String.valueOf(c.a.f28913b), ((e) c.this).f29752e.f30660a, ((e) c.this).f29752e.f30661b, ((e) c.this).f29752e.f30662c, 0, false);
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.AdInteractionListener
        public void onAdDismiss() {
            if (((e) c.this).f29751d == null || ((com.vivo.mobilead.unified.nativead.d) c.this).f30482f == null) {
                return;
            }
            ((UnifiedVivoNativeExpressAdListener) ((e) c.this).f29751d).onAdClose(((com.vivo.mobilead.unified.nativead.d) c.this).f30482f);
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
        public void onAdShow(View view, int i2) {
            if (((e) c.this).f29751d != null && ((com.vivo.mobilead.unified.nativead.d) c.this).f30482f != null) {
                ((UnifiedVivoNativeExpressAdListener) ((e) c.this).f29751d).onAdShow(((com.vivo.mobilead.unified.nativead.d) c.this).f30482f);
            }
            k0.a("4", String.valueOf(c.a.f28913b), ((e) c.this).f29752e.f30660a, ((e) c.this).f29752e.f30661b, ((e) c.this).f29752e.f30662c, 0);
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
        public void onRenderFail(View view, String str, int i2) {
            c.this.a(new l0().a(c.a.f28913b).b(com.vivo.mobilead.unified.base.f.a.c(i2)).a(str).a(false));
            if (c.this.f29679g != null) {
                c.this.f29679g.destroy();
            }
            k0.a(((e) c.this).f29752e.f30662c, ((e) c.this).f29752e.f30661b, "4", ((e) c.this).f29752e.f30660a, 0, 1, 2, i2, str, c.a.f28913b.intValue());
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
        public void onRenderSuccess(View view, float f2, float f3) {
            c.this.a(new l0().a(c.a.f28913b).a(true));
            k0.a(((e) c.this).f29752e.f30662c, ((e) c.this).f29752e.f30661b, "4", ((e) c.this).f29752e.f30660a, 0, 1, 1, -10000, "", c.a.f28913b.intValue());
        }
    }

    /* renamed from: com.vivo.mobilead.unified.b.c$c */
    class C0607c implements TTAdDislike.DislikeInteractionCallback {
        C0607c() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
        public void onCancel() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
        public void onSelected(int i2, String str, boolean z) {
            if (((e) c.this).f29751d != null) {
                ((UnifiedVivoNativeExpressAdListener) ((e) c.this).f29751d).onAdClose(((com.vivo.mobilead.unified.nativead.d) c.this).f30482f);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
        public void onShow() {
        }
    }

    public c(Context context, AdParams adParams) {
        super(context, adParams);
        this.f29680h = new b();
    }

    @Override // com.vivo.mobilead.unified.nativead.d
    protected void d() {
        Context context = this.f29749b;
        TTNativeExpressAd tTNativeExpressAd = this.f29679g;
        j0 j0Var = this.f29752e;
        this.f30482f = new n(context, tTNativeExpressAd, j0Var.f30660a, j0Var.f30661b, j0Var.f30662c);
    }

    public void a(TTNativeExpressAd tTNativeExpressAd) {
        Context context;
        if (tTNativeExpressAd == null || (context = this.f29749b) == null || !(context instanceof Activity)) {
            return;
        }
        tTNativeExpressAd.setDislikeCallback((Activity) context, new C0607c());
    }

    @Override // com.vivo.mobilead.unified.base.e
    public void b() {
        AdParams adParams;
        boolean z = false;
        if (s0.b() && this.f29749b != null && (adParams = this.f29750c) != null && !TextUtils.isEmpty(adParams.getPositionId())) {
            int videoPolicy = this.f29750c.getVideoPolicy();
            if (videoPolicy != 0 ? videoPolicy == 1 : c0.a(this.f29749b) == 100) {
                z = true;
            }
            AdSlot.Builder adCount = new AdSlot.Builder().setCodeId(this.f29750c.getPositionId()).setIsAutoPlay(z).setAdCount(1);
            int a2 = a(this.f29749b, this.f29750c.getNativeExpressWidth());
            if (a2 > 0) {
                adCount.setExpressViewAcceptedSize(a2, 0.0f);
            }
            s0.a().createAdNative(this.f29749b).loadNativeExpressAd(adCount.build(), new a());
            j0 j0Var = this.f29752e;
            k0.a(j0Var.f30662c, j0Var.f30661b, "4", 1, 0, 1, c.a.f28913b.intValue(), 1);
            return;
        }
        a(new l0().a(c.a.f28913b).b(402114).a("暂无广告，请重试").a(false));
    }
}
