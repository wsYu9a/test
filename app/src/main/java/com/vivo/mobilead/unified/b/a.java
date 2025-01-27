package com.vivo.mobilead.unified.b;

import android.content.Context;
import android.text.TextUtils;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.nativ.ADSize;
import com.qq.e.ads.nativ.NativeExpressAD;
import com.qq.e.ads.nativ.NativeExpressADView;
import com.qq.e.comm.util.AdError;
import com.vivo.mobilead.j.c;
import com.vivo.mobilead.unified.base.AdParams;
import com.vivo.mobilead.unified.base.e;
import com.vivo.mobilead.unified.nativead.UnifiedVivoNativeExpressAdListener;
import com.vivo.mobilead.util.j0;
import com.vivo.mobilead.util.k0;
import com.vivo.mobilead.util.l0;
import java.util.List;

/* loaded from: classes4.dex */
public class a extends com.vivo.mobilead.unified.nativead.d {

    /* renamed from: g */
    private NativeExpressADView f29672g;

    /* renamed from: h */
    private NativeExpressAD.NativeExpressADListener f29673h;

    /* renamed from: com.vivo.mobilead.unified.b.a$a */
    class C0605a implements NativeExpressAD.NativeExpressADListener {
        C0605a() {
        }

        @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public void onADClicked(NativeExpressADView nativeExpressADView) {
            if (((e) a.this).f29751d != null && ((com.vivo.mobilead.unified.nativead.d) a.this).f30482f != null) {
                ((UnifiedVivoNativeExpressAdListener) ((e) a.this).f29751d).onAdClick(((com.vivo.mobilead.unified.nativead.d) a.this).f30482f);
            }
            k0.a("4", String.valueOf(c.a.f28914c), ((e) a.this).f29752e.f30660a, ((e) a.this).f29752e.f30661b, ((e) a.this).f29752e.f30662c, 0, false);
        }

        public void onADCloseOverlay(NativeExpressADView nativeExpressADView) {
        }

        @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public void onADClosed(NativeExpressADView nativeExpressADView) {
            if (((e) a.this).f29751d == null || ((com.vivo.mobilead.unified.nativead.d) a.this).f30482f == null) {
                return;
            }
            ((UnifiedVivoNativeExpressAdListener) ((e) a.this).f29751d).onAdClose(((com.vivo.mobilead.unified.nativead.d) a.this).f30482f);
        }

        @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public void onADExposure(NativeExpressADView nativeExpressADView) {
            if (((e) a.this).f29751d != null && ((com.vivo.mobilead.unified.nativead.d) a.this).f30482f != null) {
                ((UnifiedVivoNativeExpressAdListener) ((e) a.this).f29751d).onAdShow(((com.vivo.mobilead.unified.nativead.d) a.this).f30482f);
            }
            k0.a("4", String.valueOf(c.a.f28914c), ((e) a.this).f29752e.f30660a, ((e) a.this).f29752e.f30661b, ((e) a.this).f29752e.f30662c, 0);
        }

        @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public void onADLeftApplication(NativeExpressADView nativeExpressADView) {
        }

        @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public void onADLoaded(List<NativeExpressADView> list) {
            if (list == null || list.size() <= 0 || list.get(0) == null) {
                a.this.a(new l0().a("暂无广告，请重试").b(402116).a(false).a(c.a.f28914c));
                k0.a(((e) a.this).f29752e.f30662c, ((e) a.this).f29752e.f30661b, "4", ((e) a.this).f29752e.f30660a, 0, 1, 2, 402116, "暂无广告，请重试", c.a.f28914c.intValue());
            } else {
                a.this.f29672g = list.get(0);
                a.this.f29672g.render();
            }
        }

        public void onADOpenOverlay(NativeExpressADView nativeExpressADView) {
        }

        @Override // com.qq.e.ads.NativeAbstractAD.BasicADListener
        public void onNoAD(AdError adError) {
            String str;
            int i2;
            if (adError != null) {
                int errorCode = adError.getErrorCode();
                str = adError.getErrorMsg();
                i2 = errorCode;
            } else {
                str = "";
                i2 = -1;
            }
            a.this.a(new l0().a(str).b(com.vivo.mobilead.unified.base.f.a.a(i2)).a(false).a(c.a.f28914c));
            k0.a(((e) a.this).f29752e.f30662c, ((e) a.this).f29752e.f30661b, "4", ((e) a.this).f29752e.f30660a, 0, 1, 2, i2, str, c.a.f28914c.intValue());
        }

        @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public void onRenderFail(NativeExpressADView nativeExpressADView) {
            a.this.a(new l0().a("暂无广告，请重试").b(402116).a(false).a(c.a.f28914c));
            if (nativeExpressADView != null) {
                nativeExpressADView.destroy();
            }
            k0.a(((e) a.this).f29752e.f30662c, ((e) a.this).f29752e.f30661b, "4", ((e) a.this).f29752e.f30660a, 0, 1, 2, 402116, "暂无广告，请重试", c.a.f28914c.intValue());
        }

        @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public void onRenderSuccess(NativeExpressADView nativeExpressADView) {
            a.this.a(new l0().a(c.a.f28914c).a(true));
            k0.a(((e) a.this).f29752e.f30662c, ((e) a.this).f29752e.f30661b, "4", ((e) a.this).f29752e.f30660a, 0, 1, 1, -10000, "", c.a.f28914c.intValue());
        }
    }

    public a(Context context, AdParams adParams) {
        super(context, adParams);
        this.f29673h = new C0605a();
    }

    @Override // com.vivo.mobilead.unified.base.e
    public void b() {
        AdParams adParams;
        if (this.f29749b != null && (adParams = this.f29750c) != null && !TextUtils.isEmpty(adParams.getPositionId())) {
            int a2 = a(this.f29749b, this.f29750c.getNativeExpressWidth());
            ADSize aDSize = new ADSize(-1, -2);
            if (a2 > 0) {
                aDSize = new ADSize(a2, -2);
            }
            NativeExpressAD nativeExpressAD = new NativeExpressAD(this.f29749b, aDSize, this.f29750c.getPositionId(), this.f29673h);
            VideoOption.Builder builder = new VideoOption.Builder();
            builder.setEnableUserControl(true).setAutoPlayPolicy(this.f29750c.getVideoPolicy()).setAutoPlayMuted(true);
            nativeExpressAD.setVideoOption(builder.build());
            nativeExpressAD.loadAD(1);
            j0 j0Var = this.f29752e;
            k0.a(j0Var.f30662c, j0Var.f30661b, "4", 1, 0, 1, c.a.f28914c.intValue(), 1);
            return;
        }
        a(new l0().a(c.a.f28914c).b(402116).a("暂无广告，请重试").a(false));
    }

    @Override // com.vivo.mobilead.unified.nativead.d
    protected void d() {
        if (this.f29672g != null) {
            Context context = this.f29749b;
            NativeExpressADView nativeExpressADView = this.f29672g;
            j0 j0Var = this.f29752e;
            this.f30482f = new com.vivo.mobilead.unified.base.view.s.e(context, nativeExpressADView, j0Var.f30660a, j0Var.f30661b, j0Var.f30662c);
        }
    }
}
