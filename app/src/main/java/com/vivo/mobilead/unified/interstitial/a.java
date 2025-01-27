package com.vivo.mobilead.unified.interstitial;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import com.bytedance.pangle.provider.ContentProviderManager;
import com.vivo.ad.f.a;
import com.vivo.ad.model.AdError;
import com.vivo.ad.model.a0;
import com.vivo.ad.model.r;
import com.vivo.ad.model.v;
import com.vivo.ad.model.w;
import com.vivo.ad.view.m;
import com.vivo.mobilead.model.a;
import com.vivo.mobilead.unified.base.AdParams;
import com.vivo.mobilead.unified.base.VivoAdError;
import com.vivo.mobilead.unified.base.callback.MediaListener;
import com.vivo.mobilead.util.VOpenLog;
import com.vivo.mobilead.util.k0;
import com.vivo.mobilead.util.q;
import com.vivo.mobilead.util.r0;
import com.vivo.mobilead.util.u;
import com.vivo.mobilead.util.w0;
import com.vivo.mobilead.util.x0;
import com.vivo.mobilead.util.y0;
import java.util.List;

/* loaded from: classes4.dex */
public abstract class a extends com.vivo.mobilead.unified.a {
    private static final String B = "a";
    private m A;
    protected UnifiedVivoInterstitialAdListener t;
    protected MediaListener u;
    protected Activity v;
    private com.vivo.ad.f.a w;
    private int x;
    private com.vivo.ad.f.c y;
    private int z;

    /* renamed from: com.vivo.mobilead.unified.interstitial.a$a */
    class C0647a extends m {
        C0647a() {
        }

        @Override // com.vivo.ad.view.m
        public void a(View view, int i2, int i3, int i4, int i5, double d2, double d3, boolean z, int i6) {
            x0.a(a.B, "ad click:" + i4 + " " + i5 + " " + i2 + " " + i3);
            if (com.vivo.mobilead.util.c.a(view, ((com.vivo.mobilead.unified.a) a.this).f29666f)) {
                return;
            }
            boolean z2 = (view instanceof com.vivo.ad.view.i) && q.a(((com.vivo.mobilead.unified.a) a.this).f29666f);
            a aVar = a.this;
            aVar.a(((com.vivo.mobilead.unified.a) aVar).f29666f, i2, i3, i4, i5, z, view, z2, d2, d3, i6);
            if (a.this.w == null || !a.this.w.isShowing()) {
                return;
            }
            a.this.z = 14;
            a.this.w.dismiss();
        }
    }

    class b implements DialogInterface.OnDismissListener {
        b() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            a.this.t();
        }
    }

    class c implements a.e {
        c() {
        }

        @Override // com.vivo.ad.f.a.e
        public void a(DialogInterface dialogInterface, int i2, int i3, int i4, int i5) {
            a aVar = a.this;
            aVar.a(((com.vivo.mobilead.unified.a) aVar).f29666f, i2, i3, i4, i5);
        }
    }

    class d implements DialogInterface.OnShowListener {
        d() {
        }

        @Override // android.content.DialogInterface.OnShowListener
        public void onShow(DialogInterface dialogInterface) {
            if (a.this.w != null) {
                a.this.w.a(true);
            }
        }
    }

    class e implements DialogInterface.OnDismissListener {
        e() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            if (a.this.w != null) {
                a.this.w.a(false);
            }
        }
    }

    public a(Activity activity, AdParams adParams) {
        super(activity, adParams);
        this.x = -1;
        this.z = 6;
        this.A = new C0647a();
        this.v = activity;
    }

    private void s() {
        com.vivo.ad.f.c cVar = new com.vivo.ad.f.c();
        this.y = cVar;
        cVar.a(this.f29666f.T());
        this.y.e(this.f29666f.Z());
        this.y.b(this.f29666f.U());
        this.y.a(this.f29666f.j());
        this.y.b(this.f29666f.O());
        this.y.a(this.f29666f.e());
        this.y.c(this.f29666f.k());
        r z = this.f29666f.z();
        v I = this.f29666f.I();
        boolean z2 = false;
        this.y.c(z != null && 1 == z.a());
        this.y.f(I != null && 1 == I.a());
        this.y.b(this.f29666f.x());
        com.vivo.ad.f.c cVar2 = this.y;
        if (this.f29666f.r() != null && this.f29666f.r().size() > 0) {
            z2 = true;
        }
        cVar2.d(z2);
    }

    public void t() {
        if (!c(this.f29666f)) {
            k0.a(this.f29666f, -1, -1, this.z, k(), this.f29662b.getSourceAppend());
        }
        UnifiedVivoInterstitialAdListener unifiedVivoInterstitialAdListener = this.t;
        if (unifiedVivoInterstitialAdListener != null) {
            unifiedVivoInterstitialAdListener.onAdClose();
        }
    }

    private void u() {
        com.vivo.ad.f.a aVar;
        String b2;
        com.vivo.ad.model.b bVar = this.f29666f;
        if (bVar == null || bVar.f() == null || ((aVar = this.w) != null && aVar.isShowing())) {
            VOpenLog.e(B, "InterstitialAd is showing");
            return;
        }
        com.vivo.ad.model.f f2 = this.f29666f.f();
        boolean z = false;
        if (this.f29666f.Y()) {
            b2 = com.vivo.mobilead.util.f.b(this.f29666f);
        } else {
            List<String> c2 = f2.c();
            b2 = (c2 == null || c2.isEmpty()) ? "" : c2.get(0);
        }
        boolean z2 = !TextUtils.isEmpty(b2) && b2.endsWith(".gif");
        Bitmap a2 = z2 ? null : com.vivo.mobilead.h.b.a().a(b2);
        if (a2 == null && !z2) {
            d(new AdError(40219, "没有广告素材，建议重试", this.f29666f.G(), this.f29666f.P(), this.f29666f.J()));
            return;
        }
        String b3 = com.vivo.mobilead.util.f.b(this.f29666f);
        if (!TextUtils.isEmpty(b3) && b3.endsWith(".gif")) {
            z = true;
        }
        if (!z && !this.f29666f.Y()) {
            this.y.b(com.vivo.mobilead.h.b.a().a(b3));
        }
        this.y.e(b3);
        if (this.f29666f.Y()) {
            this.y.b(a2);
        } else {
            this.y.a(a2);
        }
        com.vivo.ad.model.q y = this.f29666f.y();
        this.y.f(a(f2.e(), 5));
        this.y.d(a(f2.d(), 8));
        if (Build.VERSION.SDK_INT >= 30) {
            a(new com.vivo.ad.f.b(this.v, this.f29666f, y, this.y, this.f29662b.getSourceAppend(), this.A, 1));
        } else {
            a(new h(this.v, this.f29666f, y, this.y, this.f29662b.getSourceAppend(), this.A, 1));
        }
    }

    private void v() {
        a0 Q = this.f29666f.Q();
        if (Q == null) {
            VOpenLog.d(B, "showAd failed, video is null.");
            return;
        }
        if (TextUtils.isEmpty(Q.g())) {
            d(new AdError(40219, "没有广告素材，建议重试", this.f29666f.G(), this.f29666f.P(), this.f29666f.J()));
            return;
        }
        s();
        i iVar = new i(this.v, this.f29666f, this.f29666f.y(), this.y, this.f29662b.getSourceAppend(), this.A, 1);
        a(iVar);
        iVar.a(this.f29662b.getSourceAppend(), k());
    }

    @Override // com.vivo.mobilead.unified.a
    protected int f() {
        return 4;
    }

    @Override // com.vivo.mobilead.unified.a
    protected String k() {
        return "1";
    }

    @Override // com.vivo.mobilead.unified.a
    public void l() {
        a(1);
    }

    public void o() {
        this.x = 2;
        a(2);
    }

    protected void p() {
        UnifiedVivoInterstitialAdListener unifiedVivoInterstitialAdListener = this.t;
        if (unifiedVivoInterstitialAdListener != null) {
            unifiedVivoInterstitialAdListener.onAdReady();
        }
        MediaListener mediaListener = this.u;
        if (mediaListener != null) {
            mediaListener.onVideoCached();
        }
    }

    public void q() {
        int i2;
        if (this.f29666f == null) {
            VOpenLog.d(B, "showAd failed, adItemData is null.");
            return;
        }
        com.vivo.ad.f.a aVar = this.w;
        if (aVar != null && aVar.isShowing()) {
            VOpenLog.d(B, "showAd failed, dialog is showing.");
            return;
        }
        if (this.f29666f.m() == 2 && ((i2 = this.q) <= 0 || i2 > this.f29666f.D())) {
            com.vivo.mobilead.unified.base.h.a.a(this.t, new VivoAdError(402136, "二价计费广告位，未传入价格或传入值无效"));
        } else if (c(this.f29666f)) {
            v();
        } else {
            u();
        }
    }

    private boolean c(com.vivo.ad.model.b bVar) {
        return (bVar == null || bVar.Q() == null) ? false : true;
    }

    protected void d(@NonNull AdError adError) {
        UnifiedVivoInterstitialAdListener unifiedVivoInterstitialAdListener = this.t;
        if (unifiedVivoInterstitialAdListener != null) {
            unifiedVivoInterstitialAdListener.onAdFailed(new VivoAdError(adError.getErrorCode(), adError.getErrorMsg()));
        }
    }

    @Override // com.vivo.mobilead.unified.a
    protected void c() {
        UnifiedVivoInterstitialAdListener unifiedVivoInterstitialAdListener = this.t;
        if (unifiedVivoInterstitialAdListener != null) {
            unifiedVivoInterstitialAdListener.onAdFailed(new VivoAdError(402136, "二价计费广告位，未传入价格或传入值无效"));
        }
    }

    @Override // com.vivo.mobilead.unified.a
    public void d() {
        com.vivo.ad.f.a aVar = this.w;
        if (aVar != null) {
            aVar.a((DialogInterface.OnDismissListener) null);
            this.w.a((DialogInterface.OnShowListener) null);
            this.w.setOnDismissListener(null);
            this.w.dismiss();
        }
    }

    @Override // com.vivo.mobilead.unified.a
    public void a(int i2) {
        super.a(i2, i2 == 2 ? 42 : 41);
        this.x = i2;
    }

    @Override // com.vivo.mobilead.unified.a, com.vivo.mobilead.unified.base.callback.j
    public void a(@NonNull List<com.vivo.ad.model.b> list, long j2) {
        super.a(list, j2);
    }

    @Override // com.vivo.mobilead.unified.a
    protected boolean a(long j2) {
        if (c(this.f29666f)) {
            if (TextUtils.isEmpty(this.f29666f.Q().g())) {
                a(new AdError(40219, "没有广告素材，建议重试", this.f29666f.G(), this.f29666f.P(), this.f29666f.J()));
                return false;
            }
            p();
            n();
            e();
            y0.b(this.f29666f);
            return true;
        }
        y0.b(this.f29666f);
        return super.a(j2);
    }

    @Override // com.vivo.mobilead.unified.a, com.vivo.mobilead.unified.base.callback.f
    public void a(@NonNull com.vivo.ad.model.b bVar) {
        if (this.x == 1) {
            super.a(bVar);
            s();
            p();
        }
    }

    @Override // com.vivo.mobilead.unified.a, com.vivo.mobilead.unified.base.callback.j
    public void a(@NonNull AdError adError) {
        super.a(adError);
        d(adError);
    }

    public void a(Activity activity) {
        int i2;
        com.vivo.ad.model.b bVar = this.f29666f;
        if (bVar == null) {
            return;
        }
        if (bVar.m() == 2 && ((i2 = this.q) <= 0 || i2 > this.f29666f.D())) {
            com.vivo.mobilead.unified.base.h.a.a(this.t, new VivoAdError(402136, "二价计费广告位，未传入价格或传入值无效"));
            return;
        }
        String str = this.f29663c;
        com.vivo.mobilead.m.a.a().a(str, this.t);
        com.vivo.mobilead.m.a.a().a(str, this.u);
        Intent intent = new Intent(activity, (Class<?>) InterstitialVideoActivity.class);
        intent.putExtra("ad_data", this.f29666f);
        intent.putExtra("ad_source_append", this.f29662b.getSourceAppend());
        intent.putExtra("AD_TYPE", k());
        intent.putExtra("ad_backup_info", this.f29662b.getBackUrlInfo());
        intent.putExtra(ContentProviderManager.PLUGIN_PROCESS_NAME, w0.a(activity));
        intent.putExtra("ad_request_id", str);
        activity.startActivity(intent);
    }

    private void a(com.vivo.ad.f.a aVar) {
        this.w = aVar;
        aVar.setOnDismissListener(new b());
        aVar.a(new c());
        aVar.a(new d());
        aVar.a(new e());
        com.vivo.ad.model.e c2 = this.f29666f.c();
        if (c2 != null) {
            aVar.a(c2.l());
        }
        Activity activity = this.v;
        if (activity == null || activity.isFinishing()) {
            return;
        }
        aVar.show();
    }

    private String a(String str, int i2) {
        return r0.a(str, i2);
    }

    public void a(MediaListener mediaListener) {
        this.u = mediaListener;
    }

    public void a(UnifiedVivoInterstitialAdListener unifiedVivoInterstitialAdListener) {
        this.t = unifiedVivoInterstitialAdListener;
    }

    public void a(@NonNull com.vivo.ad.model.b bVar, int i2, int i3, int i4, int i5, boolean z, View view, boolean z2, double d2, double d3, int i6) {
        boolean a2 = com.vivo.mobilead.util.e.a(view, bVar);
        int a3 = u.a(this.v, bVar, a2, i6 == 1, this.f29662b.getSourceAppend(), k(), this.f29662b.getBackUrlInfo(), 1, this.f29668h);
        w wVar = new w(this.f29666f.b());
        wVar.a(d2);
        wVar.b(d3);
        k0.a(bVar, z, i2, i3, i4, i5, wVar, k(), a3, this.f29662b.getSourceAppend(), 1, z2, a2);
        if (bVar.a() != null && !bVar.a().c()) {
            k0.a(bVar, a.EnumC0603a.CLICK, i2, i3, i4, i5, wVar, -999, -999, -999, -999, this.f29662b.getSourceAppend());
            bVar.a().a(true);
        }
        UnifiedVivoInterstitialAdListener unifiedVivoInterstitialAdListener = this.t;
        if (unifiedVivoInterstitialAdListener != null) {
            unifiedVivoInterstitialAdListener.onAdClick();
        }
    }

    public void a(com.vivo.ad.model.b bVar, int i2, int i3, int i4, int i5) {
        if (!bVar.a().f()) {
            bVar.a().d(true);
            k0.a(bVar, a.EnumC0603a.SHOW, -999, -999, -999, -999, i2, i3, i4, i5, this.f29662b.getSourceAppend());
        }
        k0.a(bVar, i2, i3, i4, i5, k(), this.f29662b.getSourceAppend(), 1);
        UnifiedVivoInterstitialAdListener unifiedVivoInterstitialAdListener = this.t;
        if (unifiedVivoInterstitialAdListener != null) {
            unifiedVivoInterstitialAdListener.onAdShow();
        }
    }
}
