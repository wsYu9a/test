package com.vivo.mobilead.unified.interstitial;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.ss.android.socialbase.downloader.constants.DownloadErrorCode;
import com.vivo.ad.h.b.o;
import com.vivo.ad.model.a0;
import com.vivo.ad.model.q;
import com.vivo.ad.view.l;
import com.vivo.ad.view.r;
import com.vivo.ad.view.v;
import com.vivo.mobilead.util.k0;
import com.vivo.mobilead.util.m;
import com.vivo.mobilead.util.r0;
import com.vivo.mobilead.util.y0;
import java.io.File;

/* loaded from: classes4.dex */
public class i extends com.vivo.ad.f.a implements com.vivo.mobilead.unified.base.view.u.b {
    private r B;
    protected com.vivo.ad.view.j C;
    protected TextView D;
    protected TextView E;
    protected com.vivo.mobilead.unified.base.view.a F;
    private o G;
    private int H;
    private LinearLayout I;
    private com.vivo.mobilead.unified.interstitial.l.a J;
    private String K;
    private String L;
    private int M;
    private v N;
    protected View.OnClickListener O;

    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (i.this.J != null && i.this.J.c()) {
                i.this.M = 7;
            }
            i.this.dismiss();
        }
    }

    class b extends com.vivo.mobilead.util.b1.a.c.b {

        class a extends com.vivo.mobilead.util.f1.b {

            /* renamed from: a */
            final /* synthetic */ Bitmap f30356a;

            a(Bitmap bitmap) {
                this.f30356a = bitmap;
            }

            @Override // com.vivo.mobilead.util.f1.b
            public void safelyRun() {
                com.vivo.ad.view.j jVar = i.this.C;
                if (jVar != null) {
                    jVar.setImageBitmap(this.f30356a);
                }
            }
        }

        /* renamed from: com.vivo.mobilead.unified.interstitial.i$b$b */
        class C0651b extends com.vivo.mobilead.util.f1.b {

            /* renamed from: a */
            final /* synthetic */ byte[] f30358a;

            /* renamed from: b */
            final /* synthetic */ File f30359b;

            C0651b(byte[] bArr, File file) {
                this.f30358a = bArr;
                this.f30359b = file;
            }

            @Override // com.vivo.mobilead.util.f1.b
            public void safelyRun() {
                com.vivo.ad.view.j jVar = i.this.C;
                if (jVar != null) {
                    jVar.setGifRoundWithOverlayColor(Color.parseColor("#FFFFFF"));
                    i.this.C.a(this.f30358a, this.f30359b);
                }
            }
        }

        b() {
        }

        @Override // com.vivo.mobilead.util.b1.a.c.b, com.vivo.mobilead.util.b1.a.c.a
        public void a(String str, Bitmap bitmap) {
            i.this.C.post(new a(bitmap));
        }

        @Override // com.vivo.mobilead.util.b1.a.c.b, com.vivo.mobilead.util.b1.a.c.a
        public void a(String str, byte[] bArr, File file) {
            i.this.C.post(new C0651b(bArr, file));
        }
    }

    public i(Context context, com.vivo.ad.model.b bVar, q qVar, com.vivo.ad.f.c cVar, String str, l lVar, int i2) {
        super(context, bVar, qVar, cVar, str, lVar, i2);
        this.M = 7;
        this.O = new a();
    }

    private void h() {
        a0 Q = this.l.Q();
        if (Q == null) {
            return;
        }
        com.vivo.mobilead.unified.interstitial.l.a aVar = new com.vivo.mobilead.unified.interstitial.l.a(getContext());
        this.J = aVar;
        aVar.setId(y0.a());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, a(Q));
        layoutParams.addRule(13);
        this.f26696e.addView(this.J, layoutParams);
        if (this.f26692a == 1) {
            v vVar = new v(getContext(), this.l, this.f26700i, this);
            this.N = vVar;
            View a2 = vVar.a();
            if (a2 != null) {
                a2.setTag(7);
                ViewGroup.LayoutParams layoutParams2 = a2.getLayoutParams();
                if (layoutParams2 instanceof RelativeLayout.LayoutParams) {
                    RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) layoutParams2;
                    layoutParams3.removeRule(12);
                    layoutParams3.addRule(8, this.J.getId());
                }
                this.f26696e.addView(a2);
            }
        }
        View muteView = this.J.getMuteView();
        this.J.removeView(muteView);
        int a3 = m.a(getContext(), 23.0f);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(a3, a3);
        layoutParams4.leftMargin = m.a(getContext(), 10.0f);
        layoutParams4.bottomMargin = m.a(getContext(), 10.0f);
        layoutParams4.addRule(8, this.J.getId());
        layoutParams4.addRule(9);
        this.f26696e.addView(muteView, layoutParams4);
    }

    private void i() {
        c cVar = new c();
        com.vivo.mobilead.unified.base.view.a aVar = this.F;
        if (aVar != null) {
            aVar.setTag(2);
            this.F.setOnAWClickListener(cVar);
        }
        com.vivo.ad.view.j jVar = this.C;
        if (jVar != null) {
            jVar.setTag(1);
            this.C.setOnADWidgetClickListener(cVar);
        }
        r rVar = this.B;
        if (rVar != null) {
            rVar.setTag(1);
            this.B.setOnADWidgetClickListener(cVar);
        }
        com.vivo.mobilead.unified.interstitial.l.a aVar2 = this.J;
        if (aVar2 != null) {
            aVar2.setTag(7);
            this.J.setOnAdWidgetClickListener(cVar);
        }
    }

    private void j() {
        int i2;
        int i3;
        if (m.c(getContext()) == 2) {
            i2 = 11;
            i3 = 12;
        } else {
            i2 = 18;
            i3 = 20;
        }
        if (this.l.b0() || this.l.a0()) {
            this.F.b();
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(13);
            layoutParams.topMargin = m.a(getContext(), i2);
            layoutParams.bottomMargin = m.a(getContext(), i3);
            this.B.addView(this.F, layoutParams);
            return;
        }
        com.vivo.ad.view.j jVar = new com.vivo.ad.view.j(getContext(), m.b(getContext(), 11.0f));
        this.C = jVar;
        jVar.setId(y0.a());
        int a2 = m.a(getContext(), 40);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(a2, a2);
        layoutParams2.addRule(9);
        layoutParams2.addRule(15);
        layoutParams2.topMargin = m.b(getContext(), 14.0f);
        layoutParams2.bottomMargin = m.b(getContext(), 14.0f);
        layoutParams2.leftMargin = m.b(getContext(), 17.0f);
        this.B.addView(this.C, layoutParams2);
        LinearLayout linearLayout = new LinearLayout(getContext());
        if (com.vivo.mobilead.util.q.a(this.l)) {
            linearLayout = new com.vivo.ad.view.i(getContext());
        }
        linearLayout.setOrientation(1);
        TextView textView = new TextView(getContext());
        this.D = textView;
        textView.setTextColor(Color.parseColor("#333333"));
        this.D.setTextSize(1, 13);
        this.D.setSingleLine();
        this.D.setGravity(19);
        linearLayout.addView(this.D, new LinearLayout.LayoutParams(-2, -2));
        if (TextUtils.isEmpty(a(this.l))) {
            o oVar = new o(getContext());
            this.G = oVar;
            linearLayout.addView(oVar, new LinearLayout.LayoutParams(-2, -2));
        } else {
            TextView textView2 = new TextView(getContext());
            this.E = textView2;
            textView2.setTextColor(Color.parseColor("#999999"));
            this.E.setTextSize(1, 11);
            this.E.setSingleLine();
            this.E.setGravity(19);
            linearLayout.addView(this.E, new LinearLayout.LayoutParams(-2, -2));
        }
        if (com.vivo.mobilead.util.q.a(this.l)) {
            a(linearLayout);
        }
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams3.addRule(1, this.C.getId());
        layoutParams3.addRule(0, this.F.getId());
        layoutParams3.leftMargin = m.a(getContext(), 8.0f);
        layoutParams3.rightMargin = m.a(getContext(), 3.0f);
        layoutParams3.topMargin = m.a(getContext(), 16.0f);
        layoutParams3.bottomMargin = m.a(getContext(), 16.0f);
        this.B.addView(linearLayout, layoutParams3);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams4.addRule(11);
        layoutParams4.addRule(15);
        layoutParams4.rightMargin = m.a(getContext(), 17);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor("#4570FF"));
        gradientDrawable.setCornerRadius(m.b(getContext(), 14.0f));
        this.B.addView(this.F, layoutParams4);
        com.vivo.mobilead.util.b1.a.b.b().a(com.vivo.mobilead.util.f.b(this.l), new b());
    }

    private void k() {
        TextView textView = this.D;
        if (textView != null) {
            textView.setText(a(b(this.l), 5));
        }
        TextView textView2 = this.E;
        if (textView2 != null) {
            textView2.setText(a(a(this.l), 8));
        }
        q y = this.l.y();
        float f2 = 5.0f;
        if (y != null) {
            float p = y.p();
            float f3 = p >= 4.0f ? p : 4.0f;
            if (f3 <= 5.0f) {
                f2 = f3;
            }
        } else {
            f2 = 4.0f;
        }
        o oVar = this.G;
        if (oVar != null) {
            oVar.setRating(f2);
        }
        if (com.vivo.mobilead.util.q.a(this.l)) {
            q y2 = this.l.y();
            this.n.setText(a(y2.d() + ExifInterface.GPS_MEASUREMENT_INTERRUPTED + y2.s(), 5));
            this.p.setText(a(y2.g(), 8));
            this.r.setText((y2.q() / 1024) + "MB");
        }
    }

    @Override // com.vivo.mobilead.unified.base.view.u.b
    public void a(int i2, double d2, View view, int i3, int i4, int i5, int i6) {
    }

    @Override // com.vivo.ad.f.a
    protected void c() {
    }

    @Override // com.vivo.ad.f.a
    protected void d() {
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        double d2;
        double d3;
        double d4;
        super.dismiss();
        if (this.J != null) {
            v vVar = this.N;
            if (vVar != null) {
                d2 = vVar.b();
                d3 = this.N.d();
                d4 = this.N.c();
            } else {
                d2 = 0.0d;
                d3 = 0.0d;
                d4 = 0.0d;
            }
            k0.a(this.l, this.K, d2, d3, d4);
            if (this.J.b()) {
                k0.d(this.l, this.K);
            } else if (!this.J.a()) {
                k0.a(this.l, this.K, this.L, 1, this.J.getCurrentPosition(), this.M);
                k0.b(this.l, this.J.getCurrentPosition(), -1, 0, this.K, this.L);
            }
            this.J.d();
            this.J = null;
        }
    }

    @Override // com.vivo.ad.f.a
    protected void g() {
        Button button = new Button(getContext());
        this.f26698g = button;
        button.setBackgroundDrawable(com.vivo.mobilead.util.g.b(getContext(), "vivo_module_cha_ui_bottom_close.png"));
        int b2 = m.b(getContext(), 33.0f);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(b2, b2);
        layoutParams.gravity = 1;
        if (m.c(getContext()) == 1) {
            layoutParams.topMargin = m.b(getContext(), 27.0f);
        } else {
            layoutParams.leftMargin = m.b(getContext(), 16.0f);
            a(20.0f);
        }
        this.f26698g.setOnClickListener(this.O);
        this.I.addView(this.f26698g, layoutParams);
    }

    @Override // com.vivo.ad.f.a
    public void b(boolean z) {
        com.vivo.mobilead.unified.interstitial.l.a aVar = this.J;
        if (aVar != null) {
            aVar.b(z);
        }
    }

    @Override // com.vivo.ad.f.a
    protected void e() {
        if (m.c(getContext()) == 2) {
            this.H = (int) ((m.d(getContext()) * 2.0f) / 3.0f);
        } else {
            this.H = (int) ((m.e(getContext()) * 2.0f) / 3.0f);
        }
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.I = linearLayout;
        linearLayout.setOrientation(m.c(getContext()) == 2 ? 0 : 1);
        setContentView(this.I, new ViewGroup.LayoutParams(-2, -2));
        int b2 = m.b(getContext(), 10.0f);
        com.vivo.mobilead.unified.interstitial.m.a aVar = new com.vivo.mobilead.unified.interstitial.m.a(getContext());
        aVar.setRadius(b2);
        aVar.addView(this.m, this.H, -2);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.H, -2);
        if (m.c(getContext()) == 2) {
            layoutParams.leftMargin = m.a(getContext(), 49.0f);
        }
        this.I.addView(aVar, layoutParams);
        r rVar = new r(getContext());
        this.f26696e = rVar;
        float f2 = b2;
        rVar.setRadius(new float[]{f2, f2, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f});
        this.f26695d.addView(this.f26696e, -1, -2);
        this.B = new r(getContext());
        this.B.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        GradientDrawable gradientDrawable = new GradientDrawable();
        float b3 = m.b(getContext(), 10.0f);
        gradientDrawable.setColor(Color.parseColor("#FFFFFF"));
        gradientDrawable.setCornerRadii(new float[]{0.0f, 0.0f, 0.0f, 0.0f, b3, b3, b3, b3});
        r rVar2 = new r(getContext());
        this.B = rVar2;
        rVar2.setBackground(gradientDrawable);
        this.f26695d.addView(this.B);
        com.vivo.mobilead.unified.base.view.a aVar2 = new com.vivo.mobilead.unified.base.view.a(getContext());
        this.F = aVar2;
        aVar2.e();
        this.F.setText(this.l);
        this.F.setId(y0.a());
        h();
    }

    @Override // com.vivo.ad.f.a
    protected void f() {
        if (this.l == null) {
            return;
        }
        j();
        k();
        i();
    }

    class c extends com.vivo.ad.view.m {
        c() {
        }

        @Override // com.vivo.ad.view.l, com.vivo.ad.view.k
        public void a(View view, int i2, int i3, int i4, int i5, boolean z) {
            i.this.M = 14;
            if (((com.vivo.ad.f.a) i.this).f26700i != null) {
                ((com.vivo.ad.f.a) i.this).f26700i.a(view, i2, i3, i4, i5, z);
            }
        }

        @Override // com.vivo.ad.view.m
        public void a(View view, int i2, int i3, int i4, int i5, double d2, double d3, boolean z, int i6) {
            i.this.M = 14;
            if (((com.vivo.ad.f.a) i.this).f26700i == null || !(((com.vivo.ad.f.a) i.this).f26700i instanceof com.vivo.ad.view.m)) {
                return;
            }
            ((com.vivo.ad.view.m) ((com.vivo.ad.f.a) i.this).f26700i).a(i.this.F, -999, -999, -999, -999, d2, d3, true, i6);
        }
    }

    @Override // com.vivo.ad.f.a
    public void a(boolean z) {
        com.vivo.mobilead.unified.interstitial.l.a aVar = this.J;
        if (aVar != null) {
            aVar.a(z);
        }
    }

    private String b(com.vivo.ad.model.b bVar) {
        a0 Q = bVar.Q();
        return Q != null ? Q.e() : "";
    }

    public void a(String str, String str2) {
        this.K = str;
        this.L = str2;
        this.J.a(this.l, str, str2);
        this.J.setMute(true);
    }

    private int a(a0 a0Var) {
        int i2;
        if (a0Var == null || (i2 = this.H) == 0) {
            return 0;
        }
        if (Build.VERSION.SDK_INT >= 30) {
            return (i2 * 800) / 780;
        }
        if (a0Var.h() == 1080 && a0Var.c() == 720) {
            return (i2 * 720) / TTAdConstant.EXT_PLUGIN_UNINSTALL;
        }
        if (a0Var.h() == 720 && a0Var.c() == 1080) {
            if (m.c(getContext()) == 2) {
                return (i2 * 800) / 780;
            }
            return (i2 * 1920) / DownloadErrorCode.ERROR_TTNET_NOT_MODIFIED;
        }
        if (a0Var.h() <= a0Var.c() && a0Var.h() > 0 && a0Var.c() > 0) {
            float h2 = a0Var.h() / a0Var.c();
            if (m.c(getContext()) != 2 && h2 < 0.975f && Math.abs(h2 - 0.975f) >= Math.abs(h2 - 0.5625f)) {
                return (i2 * 1920) / DownloadErrorCode.ERROR_TTNET_NOT_MODIFIED;
            }
            return (i2 * 800) / 780;
        }
        return (i2 * 720) / TTAdConstant.EXT_PLUGIN_UNINSTALL;
    }

    private String a(String str, int i2) {
        return r0.a(str, i2);
    }

    @Override // com.vivo.ad.f.a
    public void a(com.vivo.ad.model.b bVar, Context context) {
        super.a(bVar, context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(9);
        layoutParams.addRule(10);
        this.x.setLayoutParams(layoutParams);
    }

    private String a(com.vivo.ad.model.b bVar) {
        a0 Q = bVar.Q();
        return Q != null ? Q.a() : "";
    }

    private void a(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return;
        }
        TextView textView = this.D;
        if (textView != null) {
            textView.setVisibility(8);
        }
        TextView textView2 = this.E;
        if (textView2 != null) {
            textView2.setVisibility(8);
        }
        o oVar = this.G;
        if (oVar != null) {
            oVar.setVisibility(8);
        }
        TextView textView3 = new TextView(getContext());
        this.n = textView3;
        textView3.setTextColor(Color.parseColor("#000000"));
        this.n.setTextSize(1, 13.0f);
        this.n.setSingleLine();
        this.n.setGravity(19);
        viewGroup.addView(this.n, new LinearLayout.LayoutParams(-2, -2));
        TextView textView4 = new TextView(getContext());
        this.p = textView4;
        textView4.setTextColor(Color.parseColor("#999999"));
        this.p.setTextSize(1, 11.0f);
        this.p.setSingleLine();
        this.p.setGravity(19);
        viewGroup.addView(this.p, new LinearLayout.LayoutParams(-2, -2));
        TextView textView5 = new TextView(getContext());
        this.r = textView5;
        textView5.setTextColor(Color.parseColor("#999999"));
        this.r.setTextSize(1, 11.0f);
        this.r.setSingleLine();
        this.r.setGravity(19);
        viewGroup.addView(this.r, new LinearLayout.LayoutParams(-2, -2));
        if (viewGroup instanceof com.vivo.ad.view.i) {
            com.vivo.ad.view.i iVar = (com.vivo.ad.view.i) viewGroup;
            iVar.setTag(1);
            iVar.setOnADWidgetClickListener(this.f26700i);
        }
    }

    @Override // com.vivo.mobilead.unified.base.view.u.b
    public void a(double d2, double d3) {
        l lVar = this.f26700i;
        if (lVar == null || !(lVar instanceof com.vivo.ad.view.m)) {
            return;
        }
        ((com.vivo.ad.view.m) lVar).a(this.F, -999, -999, -999, -999, d2, d3, true, 3);
    }
}
