package com.vivo.mobilead.unified.icon;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import com.vivo.ad.e.a;
import com.vivo.ad.model.AdError;
import com.vivo.ad.view.k;
import com.vivo.mobilead.i.m;
import com.vivo.mobilead.model.VivoAdError;
import com.vivo.mobilead.model.a;
import com.vivo.mobilead.unified.base.AdParams;
import com.vivo.mobilead.util.k0;
import com.vivo.mobilead.util.u;
import com.vivo.mobilead.util.x0;
import com.vivo.mobilead.util.y0;
import com.vivo.mobilead.util.z;
import java.io.File;

/* loaded from: classes4.dex */
public class a extends com.vivo.mobilead.unified.a {
    private static volatile long I = 0;
    private static volatile boolean J = false;
    private com.vivo.mobilead.unified.base.view.g A;
    private String B;
    private Runnable C;
    private View.OnClickListener D;
    private k E;
    private com.vivo.mobilead.unified.base.callback.d F;
    private DialogInterface.OnDismissListener G;
    private DialogInterface.OnShowListener H;
    private UnifiedVivoFloatIconAdListener t;
    private boolean u;
    private boolean v;
    private boolean w;
    private com.vivo.ad.model.b x;
    private com.vivo.ad.model.b y;
    private int z;

    /* renamed from: com.vivo.mobilead.unified.icon.a$a */
    class C0643a implements m {
        C0643a() {
        }

        @Override // com.vivo.mobilead.i.m
        public void a() {
            a aVar = a.this;
            aVar.a(((com.vivo.mobilead.unified.a) aVar).f29666f);
        }

        @Override // com.vivo.mobilead.i.m
        public void a(AdError adError) {
            a.this.b(adError);
        }
    }

    class c extends com.vivo.mobilead.util.b1.a.c.b {

        /* renamed from: com.vivo.mobilead.unified.icon.a$c$a */
        class C0645a extends com.vivo.mobilead.util.f1.b {

            /* renamed from: a */
            final /* synthetic */ byte[] f30319a;

            /* renamed from: b */
            final /* synthetic */ File f30320b;

            C0645a(byte[] bArr, File file) {
                this.f30319a = bArr;
                this.f30320b = file;
            }

            @Override // com.vivo.mobilead.util.f1.b
            public void safelyRun() {
                a.this.A.a(a.this.x, null, this.f30319a, this.f30320b);
            }
        }

        c() {
        }

        @Override // com.vivo.mobilead.util.b1.a.c.b, com.vivo.mobilead.util.b1.a.c.a
        public void a(String str, byte[] bArr, File file) {
            super.a(str, bArr, file);
            z.b().a(new C0645a(bArr, file));
        }
    }

    class d extends com.vivo.mobilead.util.f1.b {
        d() {
        }

        @Override // com.vivo.mobilead.util.f1.b
        public void safelyRun() {
            if (a.this.v) {
                x0.a(com.vivo.mobilead.util.f1.b.TAG, "ad is closed, stop looper!");
                return;
            }
            if (a.this.A == null || !a.this.A.c() || a.this.w) {
                a.this.z = 5;
                a.this.o();
            } else {
                a.this.u = true;
                a.this.l();
            }
        }
    }

    class e implements View.OnClickListener {

        /* renamed from: com.vivo.mobilead.unified.icon.a$e$a */
        class C0646a implements a.d {
            C0646a() {
            }

            @Override // com.vivo.ad.e.a.d
            public void a(String str) {
                a aVar = a.this;
                aVar.d(aVar.x);
            }
        }

        e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.x.r() != null && a.this.x.r().size() > 0) {
                new a.c(((com.vivo.mobilead.unified.a) a.this).f29661a).a(((com.vivo.mobilead.unified.a) a.this).f29662b.getSourceAppend()).a(a.this.x).a(a.this.G).a(a.this.H).a(new C0646a()).a();
            } else {
                a aVar = a.this;
                aVar.d(aVar.x);
            }
        }
    }

    class f implements k {
        f() {
        }

        @Override // com.vivo.ad.view.k
        public void a(View view, int i2, int i3, int i4, int i5, boolean z) {
            a aVar = a.this;
            aVar.b(aVar.x, i2, i3, i4, i5, true);
        }
    }

    class g implements com.vivo.mobilead.unified.base.callback.d {
        g() {
        }

        @Override // com.vivo.mobilead.unified.base.callback.d
        public void a() {
            boolean unused = a.J = true;
            if (a.this.x.a().f()) {
                return;
            }
            a aVar = a.this;
            aVar.c(aVar.x);
            a aVar2 = a.this;
            aVar2.b(aVar2.y, 11);
            a.this.o();
        }
    }

    class h implements DialogInterface.OnDismissListener {
        h() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            a.this.w = false;
        }
    }

    class i implements DialogInterface.OnShowListener {
        i() {
        }

        @Override // android.content.DialogInterface.OnShowListener
        public void onShow(DialogInterface dialogInterface) {
            a.this.w = true;
        }
    }

    public a(Context context, AdParams adParams, UnifiedVivoFloatIconAdListener unifiedVivoFloatIconAdListener) {
        super(context, adParams);
        this.u = false;
        this.v = false;
        this.w = false;
        this.z = 5;
        this.C = new d();
        this.D = new e();
        this.E = new f();
        this.F = new g();
        this.G = new h();
        this.H = new i();
        this.t = unifiedVivoFloatIconAdListener;
    }

    private void p() {
        com.vivo.mobilead.unified.base.view.g gVar = this.A;
        if (gVar != null && gVar.isShowing()) {
            this.A.a();
        }
        this.v = true;
        this.A = null;
        this.u = false;
        J = false;
        z.b().a().removeCallbacks(this.C);
    }

    private void q() {
        if (this.A != null) {
            if (!TextUtils.isEmpty(this.B) && this.B.endsWith(".gif")) {
                com.vivo.mobilead.util.b1.a.b.b().a(this.B, new c());
                return;
            }
            Bitmap a2 = com.vivo.mobilead.h.b.a().a(this.B);
            if (a2 != null) {
                this.A.a(this.x, a2, null, null);
            }
        }
    }

    @Override // com.vivo.mobilead.unified.a
    protected void c() {
    }

    @Override // com.vivo.mobilead.unified.a
    protected int f() {
        return 5;
    }

    @Override // com.vivo.mobilead.unified.a
    protected String k() {
        return "4";
    }

    class b extends com.vivo.mobilead.util.b1.a.c.b {

        /* renamed from: a */
        final /* synthetic */ Bitmap f30313a;

        /* renamed from: com.vivo.mobilead.unified.icon.a$b$a */
        class C0644a extends com.vivo.mobilead.util.f1.b {

            /* renamed from: a */
            final /* synthetic */ byte[] f30315a;

            /* renamed from: b */
            final /* synthetic */ File f30316b;

            C0644a(byte[] bArr, File file) {
                this.f30315a = bArr;
                this.f30316b = file;
            }

            @Override // com.vivo.mobilead.util.f1.b
            public void safelyRun() {
                com.vivo.mobilead.unified.base.view.g gVar = a.this.A;
                com.vivo.ad.model.b bVar = a.this.x;
                b bVar2 = b.this;
                gVar.a(bVar, bVar2.f30313a, this.f30315a, this.f30316b, a.this.D, a.this.E, a.this.F);
            }
        }

        b(Bitmap bitmap) {
            this.f30313a = bitmap;
        }

        @Override // com.vivo.mobilead.util.b1.a.c.b, com.vivo.mobilead.util.b1.a.c.a
        public void a(String str, byte[] bArr, File file) {
            super.a(str, bArr, file);
            z.b().a(new C0644a(bArr, file));
        }

        @Override // com.vivo.mobilead.util.b1.a.c.b, com.vivo.mobilead.util.b1.a.c.a
        public void a(VivoAdError vivoAdError) {
            super.a(vivoAdError);
            com.vivo.mobilead.unified.base.h.a.a(a.this.t, new com.vivo.mobilead.unified.base.VivoAdError(40219, "没有广告素材，建议重试"));
        }
    }

    public void o() {
        z.b().a().removeCallbacks(this.C);
        z.b().a().postDelayed(this.C, this.z * 1000);
    }

    protected void c(com.vivo.ad.model.b bVar) {
        int i2;
        int i3;
        int i4;
        int i5;
        if (this.t == null || bVar == null) {
            return;
        }
        com.vivo.mobilead.unified.base.view.g gVar = this.A;
        if (gVar != null) {
            Rect b2 = gVar.b();
            int i6 = b2.left;
            int i7 = b2.top;
            int i8 = b2.right;
            i5 = b2.bottom;
            i2 = i6;
            i3 = i7;
            i4 = i8;
        } else {
            i2 = 0;
            i3 = 0;
            i4 = 0;
            i5 = 0;
        }
        if (bVar.a().f()) {
            return;
        }
        this.t.onAdShow();
        bVar.a().d(true);
        k0.a(bVar, i2, i3, i4, i5, k(), this.f29662b.getSourceAppend(), 0);
        k0.a(bVar, a.EnumC0603a.SHOW, -999, -999, -999, -999, i2, i3, i4, i5, this.f29662b.getSourceAppend());
    }

    @Override // com.vivo.mobilead.unified.a
    public void d() {
        if (this.v) {
            return;
        }
        b(this.x, 12);
        p();
    }

    @Override // com.vivo.mobilead.unified.a
    public void l() {
        a(1, 3);
    }

    @Override // com.vivo.mobilead.unified.a, com.vivo.mobilead.unified.base.callback.f
    public void b(@NonNull AdError adError) {
        super.b(adError);
        if (this.v) {
            return;
        }
        if (!this.u) {
            com.vivo.mobilead.unified.base.h.a.a(this.t, new com.vivo.mobilead.unified.base.VivoAdError(adError.getErrorCode(), adError.getErrorMsg()));
        } else {
            o();
        }
    }

    public void d(com.vivo.ad.model.b bVar) {
        I = System.currentTimeMillis();
        UnifiedVivoFloatIconAdListener unifiedVivoFloatIconAdListener = this.t;
        if (unifiedVivoFloatIconAdListener != null) {
            unifiedVivoFloatIconAdListener.onAdClose();
        }
        b(bVar, 10);
        p();
    }

    @Override // com.vivo.mobilead.unified.a, com.vivo.mobilead.unified.base.callback.j
    public void a(@NonNull AdError adError) {
        super.a(adError);
        if (this.v) {
            return;
        }
        if (!this.u) {
            com.vivo.mobilead.unified.base.h.a.a(this.t, new com.vivo.mobilead.unified.base.VivoAdError(adError.getErrorCode(), adError.getErrorMsg()));
        } else {
            o();
        }
    }

    protected void b(com.vivo.ad.model.b bVar, int i2, int i3, int i4, int i5, boolean z) {
        boolean a2 = com.vivo.mobilead.util.e.a(z, this.f29666f);
        int a3 = u.a(this.f29661a, bVar, a2, z, this.f29662b.getSourceAppend(), k(), this.f29662b.getBackUrlInfo(), 0, this.f29668h);
        if (this.t == null || bVar == null) {
            return;
        }
        k0.a(bVar, z, i2, i3, i4, i5, k(), a3, this.f29662b.getSourceAppend(), 0, a2);
        if (!bVar.a().c()) {
            k0.a(bVar, a.EnumC0603a.CLICK, i2, i3, i4, i5, -999, -999, -999, -999, this.f29662b.getSourceAppend());
            bVar.a().a(true);
        }
        this.t.onAdClick();
    }

    @Override // com.vivo.mobilead.unified.a
    protected boolean a(long j2) {
        this.f29666f.a().a(3);
        String b2 = com.vivo.mobilead.util.f.b(this.f29666f);
        if (TextUtils.isEmpty(b2)) {
            a(new AdError(40219, "没有广告素材，建议重试", this.f29666f.P(), this.f29666f.J()));
            return false;
        }
        this.B = b2;
        y0.a(this.f29666f, (m) null);
        y0.a(this.f29666f, this.B, j2, new C0643a());
        return true;
    }

    public void b(com.vivo.ad.model.b bVar, int i2) {
        if (bVar == null || bVar.a() == null || bVar.a().d()) {
            return;
        }
        bVar.a().b(true);
        k0.a(bVar, this.f29662b.getSourceAppend(), k(), -1, -1, i2);
    }

    @Override // com.vivo.mobilead.unified.a, com.vivo.mobilead.unified.base.callback.f
    public void a(@NonNull com.vivo.ad.model.b bVar) {
        super.a(bVar);
        if (this.v) {
            return;
        }
        this.y = this.x;
        this.x = bVar;
        this.z = bVar.c().j();
        if (this.u) {
            q();
            return;
        }
        UnifiedVivoFloatIconAdListener unifiedVivoFloatIconAdListener = this.t;
        if (unifiedVivoFloatIconAdListener != null) {
            unifiedVivoFloatIconAdListener.onAdReady();
        }
    }

    public void a(Activity activity) {
        a(activity, -1, -1);
    }

    public void a(Activity activity, int i2, int i3) {
        if (activity == null || activity.isFinishing() || this.x == null || this.v || J || TextUtils.isEmpty(this.B)) {
            return;
        }
        boolean z = !TextUtils.isEmpty(this.B) && this.B.endsWith(".gif");
        Bitmap a2 = z ? null : com.vivo.mobilead.h.b.a().a(this.B);
        if (a2 == null && !z) {
            com.vivo.mobilead.unified.base.h.a.a(this.t, new com.vivo.mobilead.unified.base.VivoAdError(40219, "没有广告素材，建议重试"));
            return;
        }
        if ((System.currentTimeMillis() - I) / 1000 < com.vivo.mobilead.manager.b.l().e()) {
            com.vivo.mobilead.unified.base.h.a.a(this.t, new com.vivo.mobilead.unified.base.VivoAdError(402125, "Icon展示太频繁"));
            return;
        }
        com.vivo.mobilead.unified.base.view.g gVar = new com.vivo.mobilead.unified.base.view.g(activity, i2, i3);
        this.A = gVar;
        if (!z) {
            gVar.a(this.x, a2, null, null, this.D, this.E, this.F);
        } else {
            com.vivo.mobilead.util.b1.a.b.b().a(this.B, new b(a2));
        }
    }
}
