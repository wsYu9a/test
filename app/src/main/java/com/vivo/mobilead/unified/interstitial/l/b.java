package com.vivo.mobilead.unified.interstitial.l;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import com.vivo.ad.model.a0;
import com.vivo.ad.model.q;
import com.vivo.ad.model.r;
import com.vivo.ad.model.w;
import com.vivo.ad.view.p;
import com.vivo.mobilead.j.c;
import com.vivo.mobilead.model.BackUrlInfo;
import com.vivo.mobilead.model.a;
import com.vivo.mobilead.unified.base.VivoAdError;
import com.vivo.mobilead.unified.base.callback.MediaListener;
import com.vivo.mobilead.unified.interstitial.UnifiedVivoInterstitialAdListener;
import com.vivo.mobilead.unified.interstitial.l.c;
import com.vivo.mobilead.util.f;
import com.vivo.mobilead.util.g;
import com.vivo.mobilead.util.h0;
import com.vivo.mobilead.util.j;
import com.vivo.mobilead.util.k0;
import com.vivo.mobilead.util.u;
import com.vivo.mobilead.util.u0;

/* loaded from: classes4.dex */
public class b {

    /* renamed from: a */
    private String f30380a;

    /* renamed from: b */
    private String f30381b;

    /* renamed from: c */
    private BackUrlInfo f30382c;

    /* renamed from: d */
    private int f30383d;

    /* renamed from: e */
    private Activity f30384e;
    private com.vivo.ad.model.b q;
    private UnifiedVivoInterstitialAdListener r;
    private MediaListener s;
    private com.vivo.mobilead.unified.interstitial.l.c t;
    private int u;

    /* renamed from: f */
    private int f30385f = -1;

    /* renamed from: g */
    private int f30386g = 1;

    /* renamed from: h */
    private boolean f30387h = false;

    /* renamed from: i */
    private boolean f30388i = false;

    /* renamed from: j */
    private boolean f30389j = false;
    private boolean k = false;
    private boolean l = false;
    private boolean m = false;
    private boolean n = false;
    private boolean o = false;
    private boolean p = false;
    private boolean v = false;
    private u.b w = new a();
    private c.s x = new C0654b();
    private DialogInterface.OnShowListener y = new c();
    private DialogInterface.OnDismissListener z = new d();
    private p.h A = new e();

    class a implements u.b {
        a() {
        }

        @Override // com.vivo.mobilead.util.u.b
        public boolean a(com.vivo.ad.model.b bVar, boolean z) {
            if (!b.this.m) {
                q y = bVar.y();
                if (z && y != null && bVar.W() && !j.b(b.this.f30384e, y.a()) && y.m() == 1) {
                    b.this.v = true;
                    b.this.a(false);
                    return true;
                }
            }
            return false;
        }
    }

    class c implements DialogInterface.OnShowListener {
        c() {
        }

        @Override // android.content.DialogInterface.OnShowListener
        public void onShow(DialogInterface dialogInterface) {
            if (b.this.t != null) {
                b.this.t.d();
            }
            b.this.p = true;
        }
    }

    class d implements DialogInterface.OnDismissListener {
        d() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            if (b.this.t != null) {
                b.this.t.e();
            }
            b.this.p = false;
        }
    }

    class e implements p.h {
        e() {
        }

        @Override // com.vivo.ad.view.p.h
        public void dismiss() {
            b.this.p = false;
            if (b.this.t != null) {
                b.this.t.e();
            }
        }

        @Override // com.vivo.ad.view.p.h
        public void onShow() {
            b.this.p = true;
            if (b.this.t != null) {
                b.this.t.d();
            }
        }
    }

    public b(@NonNull Activity activity, @NonNull com.vivo.ad.model.b bVar, String str, String str2, BackUrlInfo backUrlInfo, int i2, UnifiedVivoInterstitialAdListener unifiedVivoInterstitialAdListener, MediaListener mediaListener) {
        this.t = new com.vivo.mobilead.unified.interstitial.l.c(activity, str);
        this.r = unifiedVivoInterstitialAdListener;
        this.s = mediaListener;
        this.f30384e = activity;
        this.q = bVar;
        this.f30380a = str;
        this.f30381b = str2;
        this.f30382c = backUrlInfo;
        this.u = i2;
        i();
        com.vivo.mobilead.manager.b.l().putBoolean("is_click", this.f30387h);
    }

    public void h() {
        com.vivo.ad.model.b bVar;
        if (this.f30384e == null || (bVar = this.q) == null) {
            return;
        }
        if (!TextUtils.isEmpty(bVar.E())) {
            this.m = true;
            j.a(this.f30384e, this.q, false, false, true, this.f30382c, this.f30380a, -1, 1, this.u, false, "", -1, false);
            com.vivo.ad.model.c a2 = this.q.a();
            if (a2 != null) {
                a2.b(true);
                return;
            }
            return;
        }
        if (this.v) {
            return;
        }
        if (!this.q.W()) {
            k();
        } else {
            this.v = true;
            a(true);
        }
    }

    private void i() {
        String b2;
        com.vivo.ad.model.b bVar = this.q;
        if (bVar == null || bVar.Q() == null) {
            return;
        }
        int j2 = this.q.j();
        a0 Q = this.q.Q();
        String e2 = Q.e();
        String a2 = Q.a();
        q y = this.q.y();
        com.vivo.ad.model.u H = this.q.H();
        if (j2 == 2 || this.q.U() || this.q.W() || j2 == 12) {
            if (y != null) {
                b2 = y.b();
            }
            b2 = "";
        } else if (j2 == 8) {
            if (H != null) {
                b2 = H.b();
            }
            b2 = "";
        } else {
            b2 = this.q.L();
        }
        if (TextUtils.isEmpty(e2) || TextUtils.isEmpty(a2) || TextUtils.isEmpty(b2)) {
            this.f30386g = 0;
        }
    }

    private void j() {
        this.t.a(g(), this.A, this.f30380a);
    }

    public void k() {
        float p;
        String j2;
        a0 Q = this.q.Q();
        int j3 = this.q.j();
        String e2 = Q.e();
        String a2 = Q.a();
        String d2 = Q.d();
        q y = this.q.y();
        this.q.H();
        String b2 = f.b(this.q);
        boolean c2 = com.vivo.mobilead.util.c.c(this.q);
        boolean g2 = com.vivo.mobilead.util.e.g(this.q);
        boolean h2 = com.vivo.mobilead.util.e.h(this.q);
        Bitmap a3 = !TextUtils.isEmpty(b2) && b2.endsWith(".gif") ? null : com.vivo.mobilead.h.b.a().a(b2);
        Bitmap a4 = com.vivo.mobilead.h.b.a().a(d2);
        if (a4 == null) {
            a4 = g.a(this.f30384e, "vivo_module_reward_preview.jpg");
        }
        Bitmap bitmap = a4;
        if ((j3 == 2 || j3 == 12) && y != null) {
            p = y.p();
            j2 = y.j();
        } else {
            j2 = "";
            p = -1.0f;
        }
        com.vivo.mobilead.unified.interstitial.l.c cVar = this.t;
        com.vivo.ad.model.b bVar = this.q;
        cVar.a(bitmap, a3, e2, a2, p, j2, bVar, bVar.e(), this.q.k(), this.q.O(), c2, g2, h2, b2);
    }

    private void l() {
        this.t.setFeedBackShowListener(this.y);
        this.t.setFeedBackDismissListener(this.z);
        this.t.g();
    }

    private void m() {
        k0.a(this.q, this.f30386g, this.f30380a, this.f30381b, c.a.f28912a + "", 1, this.t.getMaterialStyle());
        if (this.l) {
            return;
        }
        this.l = true;
        u0.a(this.q, a.EnumC0603a.SHOW, this.f30380a);
    }

    private String g() {
        if (!this.q.b0() && !this.q.Z() && !this.q.a0()) {
            q y = this.q.y();
            if (y != null) {
                if (this.q.U()) {
                    if (j.b(this.f30384e, y.e())) {
                        this.f30385f = 2;
                        return "立即打开";
                    }
                    this.f30385f = 4;
                    return "立即预约";
                }
                if (j.b(this.f30384e, y.a())) {
                    r z = this.q.z();
                    if (z != null && 1 == z.a()) {
                        this.f30385f = 3;
                    } else {
                        this.f30385f = 2;
                        return "立即打开";
                    }
                } else {
                    this.f30385f = 1;
                    return "立即下载";
                }
            } else {
                this.f30385f = 3;
            }
        } else {
            this.f30385f = 3;
        }
        return "查看详情";
    }

    public boolean b() {
        com.vivo.mobilead.unified.interstitial.l.c cVar = this.t;
        if (cVar == null) {
            return true;
        }
        cVar.f();
        return true;
    }

    public void c() {
        com.vivo.mobilead.unified.interstitial.l.c cVar = this.t;
        if (cVar != null) {
            cVar.d();
        }
    }

    public void d() {
        com.vivo.mobilead.unified.interstitial.l.c cVar = this.t;
        if (cVar != null) {
            cVar.c();
        }
        this.f30387h = false;
        this.f30388i = false;
        this.l = false;
        this.n = false;
        this.m = false;
    }

    public void e() {
        com.vivo.mobilead.unified.interstitial.l.c cVar = this.t;
        if (cVar != null && !this.p) {
            cVar.e();
        }
        if (this.m || this.v) {
            this.v = false;
            if (this.f30388i || this.o) {
                UnifiedVivoInterstitialAdListener unifiedVivoInterstitialAdListener = this.r;
                if (unifiedVivoInterstitialAdListener != null) {
                    unifiedVivoInterstitialAdListener.onAdClose();
                }
                Activity activity = this.f30384e;
                if (activity != null) {
                    activity.finish();
                }
            }
        }
    }

    public void f() {
        com.vivo.ad.model.b bVar = this.q;
        if (bVar == null || bVar.Q() == null || this.n) {
            return;
        }
        this.t.setData(this.q);
        this.t.setCallback(this.x);
        int n = this.q.c() != null ? this.q.c().n() : 1;
        if (h0.K().l() != 100 && n == 2) {
            this.t.h();
        } else {
            this.t.i();
        }
        j();
        l();
        m();
        this.n = true;
    }

    public View a() {
        return this.t;
    }

    public void a(int i2, int i3, int i4, int i5, double d2, double d3, int i6, int i7, boolean z, boolean z2) {
        if (!this.f30387h && !com.vivo.mobilead.manager.b.l().getBoolean("is_click", false)) {
            this.f30387h = true;
            w wVar = new w(this.q.b());
            wVar.a(d2);
            wVar.b(d3);
            u0.a(this.q, a.EnumC0603a.CLICK, i2, i3, i4, i5, -999, -999, -999, -999, wVar, this.f30380a);
            com.vivo.mobilead.manager.b.l().putBoolean("is_click", this.f30387h);
        }
        k0.a(this.q, this.f30385f, i6, i7, i2, i3, i4, i5, this.f30383d, this.f30380a, this.f30381b, c.a.f28912a + "", 1, z, "", this.t.getMaterialStyle(), z2);
    }

    /* renamed from: com.vivo.mobilead.unified.interstitial.l.b$b */
    class C0654b implements c.s {
        C0654b() {
        }

        @Override // com.vivo.mobilead.d.a
        public void a() {
        }

        @Override // com.vivo.mobilead.d.a
        public void a(int i2) {
        }

        @Override // com.vivo.mobilead.unified.interstitial.l.c.s
        public void a(int i2, int i3, int i4, int i5, double d2, double d3, boolean z, boolean z2, int i6, int i7, boolean z3) {
            if (!z) {
                if (b.this.f30384e != null) {
                    b bVar = b.this;
                    bVar.f30383d = u.a(bVar.f30384e, b.this.q, z2, i7 == 2, i6, i7, b.this.f30380a, b.this.f30381b, b.this.f30382c, 1, b.this.u, b.this.w);
                    b.this.a(i2, i3, i4, i5, d2, d3, i6, i7, z3, z2);
                }
                if (b.this.r != null) {
                    b.this.r.onAdClick();
                    return;
                }
                return;
            }
            boolean d4 = com.vivo.mobilead.util.c.d(b.this.q);
            if (b.this.r == null || !d4) {
                return;
            }
            b bVar2 = b.this;
            bVar2.f30383d = u.a((Context) bVar2.f30384e, b.this.q, z2, false, b.this.f30380a, b.this.f30381b, b.this.f30382c, 1, b.this.u, b.this.w);
            b.this.r.onAdClick();
            b.this.a(i2, i3, i4, i5, d2, d3, 1, 3, false, z2);
        }

        @Override // com.vivo.mobilead.d.a
        public void a(long j2, long j3) {
        }

        @Override // com.vivo.mobilead.d.a
        public void b() {
        }

        @Override // com.vivo.mobilead.unified.interstitial.l.c.s
        public void onAdClose() {
            if (b.this.f30388i) {
                if (b.this.r != null) {
                    b.this.r.onAdClose();
                }
                k0.d(b.this.q, b.this.f30380a);
                if (b.this.f30384e != null) {
                    b.this.f30384e.finish();
                    return;
                }
                return;
            }
            if (b.this.k) {
                if (b.this.f30384e != null) {
                    b.this.f30384e.finish();
                    return;
                }
                return;
            }
            b.this.f30388i = true;
            if (b.this.q.W()) {
                b.this.v = true;
                b.this.a(true);
            } else {
                b.this.k();
                k0.b(b.this.q, b.this.t.getCurrentPosition(), -1, 0, b.this.f30380a, b.this.f30381b);
                k0.a(b.this.q, b.this.f30380a, b.this.f30381b, 1, b.this.t.getCurrentPosition(), 7, "", b.this.t.getMaterialStyle());
            }
        }

        @Override // com.vivo.mobilead.d.a
        public void onVideoCompletion() {
            if (b.this.s != null) {
                b.this.s.onVideoCompletion();
            }
            k0.b(b.this.q, b.this.t.getDuration(), -1, 1, b.this.f30380a, b.this.f30381b);
            if (!b.this.f30388i) {
                b.this.f30388i = true;
                u0.a(b.this.q, a.EnumC0603a.PLAYEND, b.this.f30380a);
            }
            b.this.h();
        }

        @Override // com.vivo.mobilead.d.a
        public void onVideoPause() {
            if (b.this.s != null) {
                b.this.s.onVideoPause();
            }
        }

        @Override // com.vivo.mobilead.d.a
        public void onVideoResume() {
            if (b.this.s != null) {
                b.this.s.onVideoPlay();
            }
        }

        @Override // com.vivo.mobilead.d.a
        public void onVideoStart() {
            k0.c(b.this.q, b.this.f30380a, b.this.f30381b, c.a.f28912a + "");
            if (!b.this.f30389j) {
                b.this.f30389j = true;
                u0.a(b.this.q, a.EnumC0603a.STARTPLAY, b.this.f30380a);
            }
            if (b.this.r != null) {
                b.this.r.onAdShow();
            }
            if (b.this.s != null) {
                b.this.s.onVideoStart();
            }
        }

        @Override // com.vivo.mobilead.d.a
        public void a(int i2, int i3, String str) {
            if ("视频播放卡顿".equals(str)) {
                b.this.o = true;
                b.this.h();
            }
            k0.a(b.this.q, 1, b.this.f30380a, b.this.f30381b);
            b.this.k = true;
            if (b.this.s != null) {
                b.this.s.onVideoError(new VivoAdError(com.vivo.mobilead.unified.base.f.a.f(i2), str));
            }
        }
    }

    public void a(boolean z) {
        boolean z2 = this.k;
        boolean z3 = z2 || this.f30388i;
        String str = (!this.f30388i || z2) ? "1" : "2";
        com.vivo.mobilead.unified.interstitial.l.c cVar = this.t;
        j.a(this.f30384e, this.q, false, false, false, this.f30382c, this.f30380a, -1, 1, this.u, z3, str, cVar == null ? 0 : cVar.getCurrentPosition(), z);
    }
}
