package com.vivo.ad.f;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.vivo.ad.view.g;
import com.vivo.ad.view.i;
import com.vivo.ad.view.j;
import com.vivo.ad.view.l;
import com.vivo.ad.view.q;
import com.vivo.ad.view.r;
import com.vivo.ad.view.s;
import com.vivo.ad.view.v;
import com.vivo.mobilead.util.k0;
import com.vivo.mobilead.util.m;
import java.io.File;

/* loaded from: classes4.dex */
public class b extends com.vivo.ad.f.a implements DialogInterface.OnShowListener, com.vivo.mobilead.unified.base.view.u.b {
    private LinearLayout B;
    private r C;
    private s D;
    protected g E;
    protected j F;
    protected TextView G;
    protected TextView H;
    protected com.vivo.mobilead.unified.base.view.a I;
    protected s J;
    private q K;
    private View L;
    private v M;

    class a extends com.vivo.mobilead.util.b1.a.c.b {

        /* renamed from: com.vivo.ad.f.b$a$a */
        class C0558a extends com.vivo.mobilead.util.f1.b {

            /* renamed from: a */
            final /* synthetic */ byte[] f26707a;

            /* renamed from: b */
            final /* synthetic */ File f26708b;

            C0558a(byte[] bArr, File file) {
                this.f26707a = bArr;
                this.f26708b = file;
            }

            @Override // com.vivo.mobilead.util.f1.b
            public void safelyRun() {
                b.this.F.setGifRoundWithOverlayColor(-1);
                b.this.F.a(this.f26707a, this.f26708b);
            }
        }

        a() {
        }

        @Override // com.vivo.mobilead.util.b1.a.c.b, com.vivo.mobilead.util.b1.a.c.a
        public void a(String str, byte[] bArr, File file) {
            b.this.F.post(new C0558a(bArr, file));
        }
    }

    public b(Context context, com.vivo.ad.model.b bVar, com.vivo.ad.model.q qVar, c cVar, String str, l lVar, int i2) {
        super(context, bVar, qVar, cVar, str, lVar, i2);
        setContentView(this.m, new ViewGroup.LayoutParams(com.vivo.mobilead.util.q.a(bVar) ? m.b(getContext(), 276.0f) : m.b(getContext(), 260.0f), -2));
    }

    private Drawable b(int i2) {
        float b2 = m.b(getContext(), 3.33f);
        ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(new float[]{b2, b2, b2, b2, b2, b2, b2, b2}, null, null));
        shapeDrawable.getPaint().setColor(i2);
        shapeDrawable.getPaint().setStyle(Paint.Style.FILL);
        return shapeDrawable;
    }

    private void c(int i2) {
        TextView textView = this.n;
        if (textView != null) {
            textView.setVisibility(i2);
        }
        TextView textView2 = this.p;
        if (textView2 != null) {
            textView2.setVisibility(i2);
        }
    }

    private void d(int i2) {
        TextView textView = this.q;
        if (textView != null) {
            textView.setVisibility(i2);
        }
        TextView textView2 = this.o;
        if (textView2 != null) {
            textView2.setVisibility(i2);
        }
    }

    private void h() {
        i iVar = new i(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        iVar.setOrientation(1);
        TextView textView = new TextView(getContext());
        this.n = textView;
        textView.setGravity(17);
        this.n.setTextColor(Color.parseColor("#B3ffffff"));
        this.n.setShadowLayer(m.b(getContext(), 1.0f), 0.0f, m.b(getContext(), 1.0f), Color.parseColor("#B34D4D4D"));
        this.n.setTextSize(1, 11.0f);
        this.n.setSingleLine();
        this.n.setEllipsize(TextUtils.TruncateAt.END);
        TextView textView2 = new TextView(getContext());
        this.p = textView2;
        textView2.setGravity(17);
        this.p.setEllipsize(TextUtils.TruncateAt.END);
        this.p.setTextSize(1, 11.0f);
        this.p.setTextColor(Color.parseColor("#B3ffffff"));
        this.p.setShadowLayer(m.b(getContext(), 1.0f), 0.0f, m.b(getContext(), 1.0f), Color.parseColor("#B34D4D4D"));
        iVar.addView(this.n);
        iVar.addView(this.p);
        iVar.setTag(8);
        iVar.setOnADWidgetClickListener(this.f26700i);
        this.B.addView(iVar, layoutParams);
    }

    private void i() {
        i iVar = new i(getContext());
        iVar.setOrientation(1);
        TextView textView = new TextView(getContext());
        this.q = textView;
        textView.setEllipsize(TextUtils.TruncateAt.END);
        this.q.setTextSize(1, 11.0f);
        this.q.setTextColor(Color.parseColor("#999999"));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        layoutParams.topMargin = m.b(getContext(), 13.0f);
        layoutParams.bottomMargin = m.b(getContext(), 10.0f);
        iVar.addView(this.q);
        iVar.setTag(8);
        iVar.setOnADWidgetClickListener(this.f26700i);
        this.B.addView(iVar, layoutParams);
    }

    private void j() {
        i iVar = new i(getContext());
        iVar.setOrientation(1);
        TextView textView = new TextView(getContext());
        this.o = textView;
        textView.setTextColor(Color.parseColor("#333333"));
        this.o.setTextSize(1, 20.0f);
        this.o.setSingleLine();
        this.o.setEllipsize(TextUtils.TruncateAt.END);
        this.o.setGravity(17);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.setMargins(0, m.b(getContext(), 20.0f), 0, m.b(getContext(), 7.0f));
        this.o.setLayoutParams(layoutParams);
        iVar.addView(this.o);
        iVar.setTag(8);
        iVar.setOnADWidgetClickListener(this.f26700i);
        this.B.addView(iVar);
    }

    @Override // com.vivo.mobilead.unified.base.view.u.b
    public void a(double d2, double d3) {
        l lVar = this.f26700i;
        if (lVar == null || !(lVar instanceof com.vivo.ad.view.m)) {
            return;
        }
        ((com.vivo.ad.view.m) lVar).a(this.I, -999, -999, -999, -999, d2, d3, true, 3);
    }

    @Override // com.vivo.mobilead.unified.base.view.u.b
    public void a(int i2, double d2, View view, int i3, int i4, int i5, int i6) {
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        double d2;
        double d3;
        double d4;
        super.dismiss();
        v vVar = this.M;
        if (vVar != null) {
            d2 = vVar.b();
            d3 = this.M.d();
            d4 = this.M.c();
        } else {
            d2 = 0.0d;
            d3 = 0.0d;
            d4 = 0.0d;
        }
        k0.a(this.l, this.s, d2, d3, d4);
    }

    @Override // com.vivo.ad.f.a
    protected void e() {
        int b2 = m.b(getContext(), 266.67f);
        this.f26696e = new r(getContext());
        this.f26696e.setLayoutParams(new LinearLayout.LayoutParams(-1, b2));
        this.f26696e.setBackgroundColor(Color.parseColor("#19FFFFFF"));
        this.f26695d.addView(this.f26696e);
        r rVar = new r(getContext());
        this.C = rVar;
        rVar.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.f26696e.addView(this.C);
        s sVar = new s(getContext(), m.b(getContext(), 3.33f));
        this.D = sVar;
        sVar.setScaleType(ImageView.ScaleType.FIT_CENTER);
        this.D.setLayoutParams(new RelativeLayout.LayoutParams(-1, m.b(getContext(), 266.67f)));
        this.C.addView(this.D);
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.B = linearLayout;
        linearLayout.setOrientation(1);
        this.B.setGravity(1);
        this.B.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.C.addView(this.B);
        s sVar2 = new s(getContext(), m.b(getContext(), 3.33f));
        this.J = sVar2;
        sVar2.setScaleType(ImageView.ScaleType.FIT_CENTER);
        this.J.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.f26696e.addView(this.J);
        g gVar = new g(getContext());
        this.E = gVar;
        gVar.setLayoutParams(new LinearLayout.LayoutParams(-1, m.b(getContext(), 106.67f)));
        this.E.setBackgroundDrawable(com.vivo.mobilead.util.g.b(getContext(), "vivo_module_cha_ui_icon_bg.png"));
        this.F = new j(getContext(), m.b(getContext(), 11.0f));
        int b3 = m.b(getContext(), 65.33f);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(b3, b3);
        layoutParams.addRule(13);
        this.F.setLayoutParams(layoutParams);
        this.E.addView(this.F);
        if (this.f26692a == 1) {
            v vVar = new v(getContext(), this.l, this.f26700i, this);
            this.M = vVar;
            View a2 = vVar.a();
            if (a2 != null) {
                this.E.addView(a2);
            }
        }
        this.B.addView(this.E);
        TextView textView = new TextView(getContext());
        this.G = textView;
        textView.setTextColor(Color.parseColor("#333333"));
        this.G.setTextSize(1, 21.33f);
        this.G.setSingleLine();
        this.G.setGravity(17);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.setMargins(0, m.b(getContext(), 20.0f), 0, m.b(getContext(), 7.0f));
        this.G.setLayoutParams(layoutParams2);
        this.B.addView(this.G);
        if (com.vivo.mobilead.util.q.a(this.l)) {
            j();
        }
        TextView textView2 = new TextView(getContext());
        this.H = textView2;
        textView2.setTextColor(Color.parseColor("#666666"));
        this.H.setTextSize(1, 11.67f);
        this.H.setSingleLine();
        this.H.setGravity(17);
        this.H.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        this.B.addView(this.H);
        this.K = new q(getContext());
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.setMargins(0, m.b(getContext(), 5.0f), 0, 0);
        this.B.addView(this.K, layoutParams3);
        if (this.f26692a == 1) {
            v vVar2 = new v(getContext(), this.l, this.f26700i, this);
            this.M = vVar2;
            View a3 = vVar2.a();
            this.L = a3;
            if (a3 != null) {
                this.B.addView(a3);
            }
        }
        if (com.vivo.mobilead.util.q.a(this.l)) {
            h();
        }
        com.vivo.mobilead.unified.base.view.a aVar = new com.vivo.mobilead.unified.base.view.a(getContext());
        this.I = aVar;
        aVar.b();
        this.I.setText(this.l);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams4.setMargins(0, m.b(getContext(), 6.0f), 0, 0);
        layoutParams4.gravity = 17;
        this.I.setLayoutParams(layoutParams4);
        this.B.addView(this.I);
        if (com.vivo.mobilead.util.q.a(this.l)) {
            i();
        }
        this.I.setTag(9);
        this.I.setOnAWClickListener(this.f26700i);
        if (com.vivo.mobilead.util.c.a(this.l)) {
            r rVar2 = this.C;
            if (rVar2 != null) {
                rVar2.setTag(8);
                this.C.setOnADWidgetClickListener(this.f26700i);
            }
            s sVar3 = this.D;
            if (sVar3 != null) {
                sVar3.setTag(8);
                this.D.setOnADWidgetClickListener(this.f26700i);
            }
            s sVar4 = this.J;
            if (sVar4 != null) {
                sVar4.setTag(8);
                this.J.setOnADWidgetClickListener(this.f26700i);
            }
            g gVar2 = this.E;
            if (gVar2 != null) {
                gVar2.setTag(8);
                this.E.setOnADWidgetClickListener(this.f26700i);
            }
            j jVar = this.F;
            if (jVar != null) {
                jVar.setTag(8);
                this.F.setOnADWidgetClickListener(this.f26700i);
            }
        }
    }

    @Override // com.vivo.ad.f.a
    protected void f() {
        if (this.f26693b == null) {
            return;
        }
        g();
        if (!this.f26693b.h() && !this.f26693b.k() && !this.f26693b.i()) {
            this.f26696e.setBackgroundDrawable(b(Color.parseColor("#66FFFFFF")));
            this.C.setVisibility(8);
            this.J.setVisibility(0);
            this.J.setImageBitmap(this.f26693b.a());
            if (this.f26692a == 1) {
                v vVar = new v(getContext(), this.l, this.f26700i, this);
                this.M = vVar;
                View a2 = vVar.a();
                if (a2 == null || !(a2.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                    return;
                }
                ((RelativeLayout.LayoutParams) a2.getLayoutParams()).addRule(12);
                this.f26696e.addView(a2);
                return;
            }
            return;
        }
        this.f26696e.setBackgroundDrawable(b(-1));
        this.C.setVisibility(0);
        this.J.setVisibility(8);
        if (this.f26693b.g() == 20) {
            this.E.setVisibility(0);
            this.G.setVisibility(0);
            this.H.setVisibility(0);
            this.D.setVisibility(8);
            if (this.f26693b.j()) {
                com.vivo.mobilead.util.b1.a.b.b().a(this.f26693b.e(), new a());
            } else {
                this.F.setImageBitmap(this.f26693b.d());
            }
            this.G.setText(this.f26693b.f());
            this.H.setText(this.f26693b.c());
            if (this.f26694c.p() <= 0.0f || TextUtils.isEmpty(this.f26694c.j())) {
                this.K.setVisibility(4);
            } else {
                this.K.setDownloadStr(this.f26694c.j() + "人");
                this.K.setRating(this.f26694c.p());
                int i2 = getContext().getResources().getConfiguration().orientation;
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.K.getLayoutParams();
                if (i2 == 1) {
                    layoutParams.setMargins(0, m.b(getContext(), 14.0f), 0, 0);
                } else {
                    layoutParams.setMargins(0, m.b(getContext(), 9.0f), 0, 0);
                }
                this.K.setLayoutParams(layoutParams);
                this.K.setVisibility(0);
            }
            if (com.vivo.mobilead.util.q.a(this.l) && this.p != null) {
                com.vivo.ad.model.q y = this.l.y();
                this.K.setVisibility(8);
                this.G.setVisibility(8);
                this.o.setText(y.d() + ExifInterface.GPS_MEASUREMENT_INTERRUPTED + y.s());
                this.q.setText(this.l.y().g() + " " + (this.l.y().q() / 1024) + "MB");
                c(8);
            }
            if (this.f26692a == 1 && this.B.indexOfChild(this.L) >= 0) {
                this.B.removeView(this.L);
            }
        } else {
            this.E.setVisibility(8);
            this.G.setVisibility(8);
            this.H.setVisibility(8);
            this.K.setVisibility(8);
            this.D.setVisibility(0);
            this.D.setImageBitmap(this.f26693b.a());
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams2.addRule(12);
            layoutParams2.addRule(14);
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams3.setMargins(0, m.a(getContext(), 8.0f), 0, m.a(getContext(), 23.33f));
            layoutParams3.gravity = 17;
            if (com.vivo.mobilead.util.q.a(this.l)) {
                com.vivo.ad.model.q y2 = this.l.y();
                this.n.setText(y2.d() + " V" + y2.s() + " " + (y2.q() / 1024) + "MB");
                this.p.setText(y2.g());
                d(8);
            } else {
                this.I.setLayoutParams(layoutParams3);
            }
            this.B.setLayoutParams(layoutParams2);
        }
        if (6 == this.f26693b.b()) {
            this.I.setVisibility(8);
        }
    }
}
