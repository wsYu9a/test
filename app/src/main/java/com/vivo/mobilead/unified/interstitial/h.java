package com.vivo.mobilead.unified.interstitial;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.vivo.ad.h.b.f;
import com.vivo.ad.h.b.o;
import com.vivo.ad.model.q;
import com.vivo.ad.view.l;
import com.vivo.ad.view.r;
import com.vivo.ad.view.s;
import com.vivo.ad.view.v;
import com.vivo.mobilead.util.k0;
import com.vivo.mobilead.util.m;
import com.vivo.mobilead.util.r0;
import com.vivo.mobilead.util.y0;
import java.io.File;

/* loaded from: classes4.dex */
public class h extends com.vivo.ad.f.a implements com.vivo.mobilead.unified.base.view.u.b {
    private r B;
    protected com.vivo.ad.view.j C;
    protected TextView D;
    protected LinearLayout E;
    protected TextView F;
    protected com.vivo.mobilead.unified.base.view.a G;
    protected s H;
    private o I;
    private int J;
    private LinearLayout K;
    private v L;

    class a extends com.vivo.mobilead.util.b1.a.c.b {

        /* renamed from: com.vivo.mobilead.unified.interstitial.h$a$a */
        class C0650a extends com.vivo.mobilead.util.f1.b {

            /* renamed from: a */
            final /* synthetic */ byte[] f30347a;

            /* renamed from: b */
            final /* synthetic */ File f30348b;

            C0650a(byte[] bArr, File file) {
                this.f30347a = bArr;
                this.f30348b = file;
            }

            @Override // com.vivo.mobilead.util.f1.b
            public void safelyRun() {
                h.this.C.a(this.f30347a, this.f30348b);
            }
        }

        a() {
        }

        @Override // com.vivo.mobilead.util.b1.a.c.b, com.vivo.mobilead.util.b1.a.c.a
        public void a(String str, byte[] bArr, File file) {
            h.this.C.post(new C0650a(bArr, file));
        }
    }

    class b extends com.vivo.mobilead.util.b1.a.c.b {

        class a extends com.vivo.mobilead.util.f1.b {

            /* renamed from: a */
            final /* synthetic */ byte[] f30351a;

            /* renamed from: b */
            final /* synthetic */ File f30352b;

            a(byte[] bArr, File file) {
                this.f30351a = bArr;
                this.f30352b = file;
            }

            @Override // com.vivo.mobilead.util.f1.b
            public void safelyRun() {
                if (this.f30351a == null && this.f30352b == null) {
                    return;
                }
                h.this.C.setGifRoundWithOverlayColor(com.vivo.mobilead.util.i.a("#FFFFFF"));
                h.this.C.a(this.f30351a, this.f30352b);
            }
        }

        b() {
        }

        @Override // com.vivo.mobilead.util.b1.a.c.b, com.vivo.mobilead.util.b1.a.c.a
        public void a(String str, byte[] bArr, File file) {
            super.a(str, bArr, file);
            h.this.C.post(new a(bArr, file));
        }
    }

    public h(Context context, com.vivo.ad.model.b bVar, q qVar, com.vivo.ad.f.c cVar, String str, l lVar, int i2) {
        super(context, bVar, qVar, cVar, str, lVar, i2);
    }

    private void h() {
        o oVar = this.I;
        if (oVar != null) {
            oVar.setVisibility(8);
        }
        com.vivo.ad.view.i iVar = new com.vivo.ad.view.i(getContext());
        iVar.setOrientation(1);
        TextView textView = new TextView(getContext());
        this.q = textView;
        textView.setEllipsize(TextUtils.TruncateAt.END);
        this.q.setTextSize(1, 11.0f);
        this.q.setTextColor(Color.parseColor("#999999"));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        layoutParams.addRule(3, this.G.getId());
        layoutParams.bottomMargin = m.b(getContext(), 40.0f);
        iVar.addView(this.q);
        if (com.vivo.mobilead.util.c.b(this.l)) {
            iVar.setTag(1);
            iVar.setOnADWidgetClickListener(this.f26700i);
            LinearLayout linearLayout = this.E;
            if (linearLayout != null) {
                linearLayout.setTag(1);
                ((com.vivo.ad.view.i) this.E).setOnADWidgetClickListener(this.f26700i);
            }
        }
        this.B.addView(iVar, layoutParams);
    }

    private void i() {
        r rVar;
        com.vivo.ad.view.j jVar;
        com.vivo.mobilead.unified.base.view.a aVar = this.G;
        if (aVar != null) {
            aVar.setTag(2);
            this.G.setOnAWClickListener(this.f26700i);
        }
        if (com.vivo.mobilead.util.c.a(this.l)) {
            r rVar2 = this.f26696e;
            if (rVar2 != null) {
                rVar2.setTag(8);
                this.f26696e.setOnADWidgetClickListener(this.f26700i);
            }
            s sVar = this.H;
            if (sVar != null) {
                sVar.setTag(8);
                this.H.setOnADWidgetClickListener(this.f26700i);
            }
        }
        if (!com.vivo.mobilead.util.c.a(this.C, this.l) && (jVar = this.C) != null) {
            jVar.setOnADWidgetClickListener(this.f26700i);
        }
        if (!com.vivo.mobilead.util.c.b(this.l) || (rVar = this.B) == null) {
            return;
        }
        rVar.setTag(1);
        this.B.setOnADWidgetClickListener(this.f26700i);
    }

    private void j() {
        int i2;
        int i3;
        int i4;
        int i5;
        if (m.c(getContext()) == 2) {
            i2 = 11;
            i3 = 12;
        } else {
            i2 = 18;
            i3 = 20;
        }
        com.vivo.ad.model.f f2 = this.l.f();
        Bitmap a2 = com.vivo.mobilead.h.b.a().a(f2.c().get(0));
        if (a2 != null) {
            i4 = a2.getWidth();
            i5 = a2.getHeight();
        } else {
            i4 = 0;
            i5 = 0;
        }
        int i6 = this.J;
        if (i6 == 0) {
            return;
        }
        float f3 = i4 / i6;
        int i7 = (int) (i5 / f3);
        int d2 = m.c(getContext()) != 2 ? (int) (1920.0f / f3) : (int) ((m.d(getContext()) * 2.1f) / 3.0f);
        if (i7 > d2) {
            i7 = d2;
        }
        float b2 = m.b(getContext(), 3.33f);
        s sVar = new s(getContext(), new float[]{b2, b2, b2, b2, 0.0f, 0.0f, 0.0f, 0.0f});
        this.H = sVar;
        sVar.setId(y0.a());
        this.H.setScaleType(ImageView.ScaleType.FIT_CENTER);
        this.H.setLayoutParams(new RelativeLayout.LayoutParams(-1, i7));
        this.f26696e.setBackgroundColor(Color.parseColor("#80000000"));
        this.f26696e.addView(this.H);
        if (a2 != null) {
            this.H.setImageBitmap(a2);
        }
        v vVar = new v(getContext(), this.l, this.f26700i, this);
        this.L = vVar;
        View a3 = vVar.a();
        if (a3 != null) {
            a3.setTag(8);
            ViewGroup.LayoutParams layoutParams = a3.getLayoutParams();
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                layoutParams2.removeRule(12);
                layoutParams2.addRule(8, this.H.getId());
            }
            this.f26696e.addView(a3);
        }
        if (this.l.b0()) {
            this.G.b();
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams3.addRule(13);
            layoutParams3.topMargin = m.a(getContext(), i2);
            layoutParams3.bottomMargin = m.a(getContext(), i3);
            this.B.addView(this.G, layoutParams3);
            return;
        }
        this.G.e();
        com.vivo.ad.view.j jVar = new com.vivo.ad.view.j(getContext(), m.b(getContext(), 11.0f));
        this.C = jVar;
        jVar.setId(y0.a());
        int a4 = m.a(getContext(), 40);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(a4, a4);
        layoutParams4.addRule(9);
        layoutParams4.addRule(15);
        layoutParams4.topMargin = m.b(getContext(), 14.0f);
        layoutParams4.bottomMargin = m.b(getContext(), 14.0f);
        layoutParams4.leftMargin = m.b(getContext(), 17.0f);
        this.C.setTag(1);
        this.B.addView(this.C, layoutParams4);
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
        if (TextUtils.isEmpty(f2.d())) {
            o oVar = new o(getContext());
            this.I = oVar;
            linearLayout.addView(oVar, new LinearLayout.LayoutParams(-2, -2));
        } else {
            TextView textView2 = new TextView(getContext());
            this.F = textView2;
            textView2.setTextColor(Color.parseColor("#999999"));
            this.F.setTextSize(1, 11);
            this.F.setSingleLine();
            this.F.setGravity(19);
            linearLayout.addView(this.F, new LinearLayout.LayoutParams(-2, -2));
        }
        if (com.vivo.mobilead.util.q.a(this.l)) {
            a(linearLayout);
        }
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams5.addRule(1, this.C.getId());
        layoutParams5.addRule(0, this.G.getId());
        layoutParams5.leftMargin = m.a(getContext(), 8.0f);
        layoutParams5.rightMargin = m.a(getContext(), 3.0f);
        layoutParams5.topMargin = m.a(getContext(), 16.0f);
        layoutParams5.bottomMargin = m.a(getContext(), 8.0f);
        this.B.addView(linearLayout, layoutParams5);
        RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams6.addRule(11);
        layoutParams6.addRule(15);
        layoutParams6.rightMargin = m.a(getContext(), 17);
        this.B.addView(this.G, layoutParams6);
        Bitmap bitmap = null;
        String b3 = com.vivo.mobilead.util.f.b(this.l);
        if (TextUtils.isEmpty(b3) || !b3.endsWith(".gif")) {
            bitmap = com.vivo.mobilead.h.b.a().a(b3);
        } else {
            com.vivo.mobilead.util.b1.a.b.b().a(b3, new b());
        }
        if (bitmap != null) {
            this.C.setImageBitmap(bitmap);
        }
    }

    private void k() {
        com.vivo.ad.model.f f2 = this.l.f();
        if (f2 != null) {
            TextView textView = this.D;
            if (textView != null) {
                textView.setText(a(f2.e(), 5));
            }
            TextView textView2 = this.F;
            if (textView2 != null) {
                textView2.setText(a(f2.d(), 8));
            }
        }
        q y = this.l.y();
        float f3 = 5.0f;
        if (y != null) {
            float p = y.p();
            float f4 = p >= 4.0f ? p : 4.0f;
            if (f4 <= 5.0f) {
                f3 = f4;
            }
        } else {
            f3 = 4.0f;
        }
        o oVar = this.I;
        if (oVar != null) {
            oVar.setRating(f3);
        }
        if (com.vivo.mobilead.util.q.a(this.l)) {
            m();
            l();
        }
    }

    private void l() {
        q y = this.l.y();
        TextView textView = this.n;
        if (textView != null) {
            textView.setText(a(y.d() + ExifInterface.GPS_MEASUREMENT_INTERRUPTED + y.s(), 5));
        }
        TextView textView2 = this.p;
        if (textView2 != null) {
            textView2.setText(a(y.g(), 8));
        }
        TextView textView3 = this.r;
        if (textView3 != null) {
            textView3.setText((y.q() / 1024) + "MB");
        }
    }

    private void m() {
        q y = this.l.y();
        TextView textView = this.D;
        if (textView != null) {
            textView.setText(y.d() + ExifInterface.GPS_MEASUREMENT_INTERRUPTED + y.s());
            this.D.setEllipsize(TextUtils.TruncateAt.END);
            this.D.setTextSize(1, 20.0f);
        }
        TextView textView2 = this.q;
        if (textView2 != null) {
            textView2.setText(this.l.y().g() + " " + (this.l.y().q() / 1024) + "MB");
        }
    }

    private void n() {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        if (m.c(getContext()) == 2) {
            i2 = 16;
            i3 = 24;
            i4 = 60;
            i5 = 13;
            i6 = 10;
            i7 = 105;
        } else {
            i2 = 28;
            i3 = 65;
            i4 = 66;
            i5 = 52;
            i6 = 9;
            i7 = org.mozilla.universalchardet.prober.g.f35436i;
        }
        this.f26696e.setLayoutParams(new LinearLayout.LayoutParams(-1, m.a(getContext(), i7)));
        this.f26696e.setBackground(new BitmapDrawable(com.vivo.ad.h.b.f.a(com.vivo.mobilead.util.g.a(getContext(), "vivo_module_cha_ui_icon_bg.png"), m.b(getContext(), 3.33f), f.b.TOP)));
        int a2 = m.a(getContext(), i4);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(a2, a2);
        layoutParams.addRule(13);
        com.vivo.ad.view.j jVar = new com.vivo.ad.view.j(getContext(), m.b(getContext(), 11.0f));
        this.C = jVar;
        jVar.setTag(8);
        this.C.setId(y0.a());
        this.f26696e.addView(this.C, layoutParams);
        v vVar = new v(getContext(), this.l, this.f26700i, this);
        this.L = vVar;
        View a3 = vVar.a();
        if (a3 != null) {
            a3.setTag(8);
            this.f26696e.addView(a3);
        }
        this.E = new LinearLayout(getContext());
        if (com.vivo.mobilead.util.q.a(this.l)) {
            this.E = new com.vivo.ad.view.i(getContext());
        }
        this.E.setId(y0.a());
        TextView textView = new TextView(getContext());
        this.D = textView;
        textView.setId(y0.a());
        this.D.setTextColor(Color.parseColor("#333333"));
        this.D.setTextSize(1, 27);
        this.D.setSingleLine();
        this.D.setGravity(19);
        this.E.addView(this.D);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(14);
        layoutParams2.topMargin = m.a(getContext(), i5);
        this.B.addView(this.E, layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.addRule(14);
        com.vivo.ad.model.f f2 = this.l.f();
        if (f2 == null || TextUtils.isEmpty(f2.d())) {
            o oVar = new o(getContext());
            this.I = oVar;
            oVar.setId(y0.a());
            RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams4.addRule(14);
            layoutParams4.addRule(3, this.E.getId());
            this.B.addView(this.I, layoutParams4);
            layoutParams3.addRule(3, this.I.getId());
        } else {
            TextView textView2 = new TextView(getContext());
            this.F = textView2;
            textView2.setId(y0.a());
            this.F.setTextColor(Color.parseColor("#666666"));
            this.F.setTextSize(1, 18);
            this.F.setSingleLine();
            this.F.setGravity(19);
            RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams5.addRule(14);
            layoutParams5.addRule(3, this.E.getId());
            layoutParams5.topMargin = m.a(getContext(), i6);
            this.B.addView(this.F, layoutParams5);
            layoutParams3.addRule(3, this.F.getId());
        }
        this.G.setId(y0.a());
        layoutParams3.topMargin = m.a(getContext(), i2);
        layoutParams3.bottomMargin = m.a(getContext(), i3);
        this.G.b();
        this.B.addView(this.G, layoutParams3);
        if (com.vivo.mobilead.util.q.a(this.l)) {
            h();
        }
        Bitmap bitmap = null;
        String b2 = com.vivo.mobilead.util.f.b(this.l);
        if (TextUtils.isEmpty(b2) && f2 != null && f2.c() != null && f2.c().size() > 0) {
            b2 = f2.c().get(0);
        }
        if (TextUtils.isEmpty(b2) || !b2.endsWith(".gif")) {
            bitmap = com.vivo.mobilead.h.b.a().a(b2);
        } else {
            com.vivo.mobilead.util.b1.a.b.b().a(b2, new a());
        }
        if (bitmap != null) {
            this.C.setImageBitmap(bitmap);
        }
    }

    @Override // com.vivo.mobilead.unified.base.view.u.b
    public void a(double d2, double d3) {
        l lVar = this.f26700i;
        if (lVar == null || !(lVar instanceof com.vivo.ad.view.m)) {
            return;
        }
        ((com.vivo.ad.view.m) lVar).a(this.G, -999, -999, -999, -999, d2, d3, true, 3);
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
        v vVar = this.L;
        if (vVar != null) {
            d2 = vVar.b();
            d3 = this.L.d();
            d4 = this.L.c();
        } else {
            d2 = 0.0d;
            d3 = 0.0d;
            d4 = 0.0d;
        }
        k0.a(this.l, this.s, d2, d3, d4);
    }

    @Override // com.vivo.ad.f.a
    protected void e() {
        if (m.c(getContext()) == 2) {
            int d2 = m.d(getContext());
            if (a(this.l)) {
                this.J = m.b(getContext(), 327.27f);
            } else {
                this.J = (int) ((d2 * 2.0f) / 3.0f);
            }
            LinearLayout linearLayout = new LinearLayout(getContext());
            this.K = linearLayout;
            linearLayout.setOrientation(0);
            setContentView(this.K, new ViewGroup.LayoutParams(-2, -2));
            if (com.vivo.mobilead.util.q.a(this.l)) {
                this.K.addView(this.m, new ViewGroup.LayoutParams(this.J + m.a(getContext(), 16.0f), -2));
            } else {
                this.K.addView(this.m, new ViewGroup.LayoutParams(this.J, -2));
            }
        } else {
            this.J = (int) ((m.e(getContext()) * 2.0f) / 3.0f);
            if (com.vivo.mobilead.util.q.a(this.l)) {
                setContentView(this.m, new ViewGroup.LayoutParams(this.J + m.a(getContext(), 16.0f), -2));
            } else {
                setContentView(this.m, new ViewGroup.LayoutParams(this.J, -2));
            }
        }
        this.f26696e = new r(getContext());
        this.f26696e.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        this.f26695d.addView(this.f26696e);
        this.B = new r(getContext());
        this.B.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        GradientDrawable gradientDrawable = new GradientDrawable();
        float b2 = m.b(getContext(), 3.33f);
        gradientDrawable.setColor(Color.parseColor("#FFFFFF"));
        gradientDrawable.setCornerRadii(new float[]{0.0f, 0.0f, 0.0f, 0.0f, b2, b2, b2, b2});
        r rVar = new r(getContext());
        this.B = rVar;
        rVar.setBackground(gradientDrawable);
        this.f26695d.addView(this.B);
        com.vivo.mobilead.unified.base.view.a aVar = new com.vivo.mobilead.unified.base.view.a(getContext());
        this.G = aVar;
        aVar.e();
        this.G.setText(this.l);
        this.G.setId(y0.a());
        this.G.setGravity(17);
    }

    @Override // com.vivo.ad.f.a
    protected void f() {
        com.vivo.ad.model.b bVar = this.l;
        if (bVar == null) {
            return;
        }
        if (a(bVar)) {
            n();
        } else {
            j();
        }
        k();
        i();
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
            this.f26695d.addView(this.f26698g, layoutParams);
        } else {
            layoutParams.leftMargin = m.b(getContext(), 16.0f);
            LinearLayout linearLayout = this.K;
            if (linearLayout != null) {
                linearLayout.addView(this.f26698g, layoutParams);
            }
        }
        this.f26698g.setOnClickListener(this.A);
        a(20.0f);
    }

    private boolean a(com.vivo.ad.model.b bVar) {
        com.vivo.ad.model.f f2;
        return bVar == null || bVar.x() == 20 || (f2 = bVar.f()) == null || f2.c() == null || f2.c().size() <= 0 || TextUtils.isEmpty(f2.c().get(0));
    }

    private String a(String str, int i2) {
        return r0.a(str, i2);
    }

    private void a(ViewGroup viewGroup) {
        TextView textView = this.D;
        if (textView != null) {
            textView.setVisibility(8);
        }
        TextView textView2 = this.F;
        if (textView2 != null) {
            textView2.setVisibility(8);
        }
        o oVar = this.I;
        if (oVar != null) {
            oVar.setVisibility(8);
        }
        q y = this.l.y();
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
        this.p.setText(y.g());
        viewGroup.addView(this.p, new LinearLayout.LayoutParams(-2, -2));
        TextView textView5 = new TextView(getContext());
        this.r = textView5;
        textView5.setTextColor(Color.parseColor("#999999"));
        this.r.setTextSize(1, 11.0f);
        this.r.setSingleLine();
        this.r.setGravity(19);
        this.r.setText((y.q() / 1024) + "MB");
        viewGroup.addView(this.r, new LinearLayout.LayoutParams(-2, -2));
        if ((viewGroup instanceof com.vivo.ad.view.i) && com.vivo.mobilead.util.c.b(this.l)) {
            viewGroup.setTag(1);
            ((com.vivo.ad.view.i) viewGroup).setOnADWidgetClickListener(this.f26700i);
        }
    }
}
