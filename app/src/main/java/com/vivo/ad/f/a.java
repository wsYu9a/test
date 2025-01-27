package com.vivo.ad.f;

import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.vivo.ad.e.e;
import com.vivo.ad.model.q;
import com.vivo.ad.view.l;
import com.vivo.ad.view.p;
import com.vivo.ad.view.r;
import com.vivo.mobilead.util.g;
import com.vivo.mobilead.util.k0;
import com.vivo.mobilead.util.m;
import com.vivo.mobilead.util.n;
import com.vivo.mobilead.util.y0;

/* loaded from: classes4.dex */
public abstract class a extends Dialog implements DialogInterface.OnShowListener {
    protected View.OnClickListener A;

    /* renamed from: a */
    protected int f26692a;

    /* renamed from: b */
    protected com.vivo.ad.f.c f26693b;

    /* renamed from: c */
    protected q f26694c;

    /* renamed from: d */
    protected LinearLayout f26695d;

    /* renamed from: e */
    protected r f26696e;

    /* renamed from: f */
    private Button f26697f;

    /* renamed from: g */
    protected Button f26698g;

    /* renamed from: h */
    private FrameLayout f26699h;

    /* renamed from: i */
    protected l f26700i;

    /* renamed from: j */
    protected e f26701j;
    private int k;
    protected com.vivo.ad.model.b l;
    protected RelativeLayout m;
    protected TextView n;
    protected TextView o;
    protected TextView p;
    protected TextView q;
    protected TextView r;
    protected String s;
    protected boolean t;
    private LinearLayout u;
    private float v;
    private float w;
    protected com.vivo.ad.e.e x;
    private DialogInterface.OnShowListener y;
    private DialogInterface.OnDismissListener z;

    /* renamed from: com.vivo.ad.f.a$a */
    class ViewOnClickListenerC0557a implements View.OnClickListener {
        ViewOnClickListenerC0557a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.dismiss();
        }
    }

    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a aVar = a.this;
            aVar.t = true;
            k0.a(aVar.l, aVar.s);
            a.this.j();
        }
    }

    class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a aVar = a.this;
            aVar.t = false;
            k0.a(aVar.l, aVar.s);
            a.this.j();
        }
    }

    class d implements p.h {
        d() {
        }

        @Override // com.vivo.ad.view.p.h
        public void dismiss() {
            a.this.b(false);
        }

        @Override // com.vivo.ad.view.p.h
        public void onShow() {
            a.this.b(true);
        }
    }

    public interface e {
        void a(DialogInterface dialogInterface, int i2, int i3, int i4, int i5);
    }

    public a(Context context, com.vivo.ad.model.b bVar, q qVar, com.vivo.ad.f.c cVar, String str, l lVar, int i2) {
        super(context, R.style.Theme.Dialog);
        this.k = 0;
        this.t = false;
        this.v = 20.0f;
        this.w = 45.0f;
        this.A = new ViewOnClickListenerC0557a();
        this.f26692a = i2;
        this.l = bVar;
        this.s = str;
        this.f26694c = qVar;
        this.f26693b = cVar;
        this.f26700i = lVar;
        setCanceledOnTouchOutside(false);
        if (context instanceof Activity) {
            setOwnerActivity((Activity) context);
        }
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        setFeatureDrawableAlpha(0, 0);
        requestWindowFeature(1);
        i();
        f();
        a(bVar, context);
    }

    private View h() {
        int b2 = m.b(getContext(), 20.0f);
        if (2 == m.c(getContext())) {
            b2 = m.b(getContext(), 10.0f);
        }
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.u = linearLayout;
        linearLayout.setOrientation(1);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(m.b(getContext(), 16.0f), -2);
        layoutParams.topMargin = b2;
        this.u.setLayoutParams(layoutParams);
        this.u.setId(y0.a());
        float b3 = m.b(getContext(), 3.0f);
        float[] fArr = {b3, b3, 0.0f, 0.0f, 0.0f, 0.0f, b3, b3};
        TextView textView = new TextView(getContext());
        textView.setText("隐\n私");
        textView.setId(y0.a());
        textView.setTextColor(Color.parseColor("#FFFFFF"));
        textView.setTextSize(1, 10.0f);
        int b4 = m.b(getContext(), 3.0f);
        textView.setPadding(b4, b4, b4, b4);
        textView.setBackground(a(Color.parseColor("#333333"), fArr));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        TextView textView2 = new TextView(getContext());
        textView2.setText("权\n限");
        textView2.setTextColor(Color.parseColor("#FFFFFF"));
        textView2.setTextSize(1, 10.0f);
        textView2.setPadding(b4, b4, b4, m.b(getContext(), 3.0f));
        textView2.setBackground(a(Color.parseColor("#333333"), fArr));
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.topMargin = m.b(getContext(), 4.0f);
        this.u.addView(textView, layoutParams2);
        this.u.addView(textView2, layoutParams3);
        this.m.addView(this.u);
        textView2.setOnClickListener(new b());
        textView.setOnClickListener(new c());
        return this.u;
    }

    private void i() {
        this.m = new RelativeLayout(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(m.b(getContext(), 266.67f), -2);
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.f26695d = linearLayout;
        linearLayout.setOrientation(1);
        if (com.vivo.mobilead.util.q.a(this.l)) {
            View h2 = h();
            layoutParams.addRule(5);
            layoutParams.addRule(6);
            layoutParams.addRule(1, h2.getId());
        }
        this.m.addView(this.f26695d, layoutParams);
        d();
        e();
        c();
    }

    public void j() {
        p pVar = new p(getContext(), this.l, this.s);
        pVar.a(new d());
        pVar.a(this.t);
    }

    public void a(boolean z) {
    }

    public void b(boolean z) {
    }

    protected void c() {
        Button button = new Button(getContext());
        this.f26698g = button;
        button.setBackgroundDrawable(g.b(getContext(), "vivo_module_cha_ui_bottom_close.png"));
        int b2 = m.b(getContext(), 33.0f);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(b2, b2);
        layoutParams.topMargin = m.b(getContext(), 27.0f);
        layoutParams.gravity = 1;
        this.f26698g.setLayoutParams(layoutParams);
        this.f26695d.addView(this.f26698g);
        this.f26698g.setOnClickListener(this.A);
    }

    protected void d() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(m.b(getContext(), 15.33f), m.b(getContext(), 15.33f));
        layoutParams.gravity = 21;
        Button button = new Button(getContext());
        this.f26697f = button;
        button.setClickable(false);
        this.f26697f.setBackgroundDrawable(g.b(getContext(), "vivo_module_cha_ui_top_close.png"));
        this.f26697f.setLayoutParams(layoutParams);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(m.b(getContext(), 25.0f), m.b(getContext(), 25.0f));
        layoutParams2.gravity = 5;
        FrameLayout frameLayout = new FrameLayout(getContext());
        this.f26699h = frameLayout;
        frameLayout.setLayoutParams(layoutParams2);
        this.f26699h.addView(this.f26697f);
        this.f26695d.addView(this.f26699h);
        this.f26699h.setOnClickListener(this.A);
    }

    protected abstract void e();

    protected abstract void f();

    protected void g() {
        int b2 = m.b(getContext(), 33.0f);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(b2, b2);
        int c2 = m.c(getContext());
        int i2 = this.k;
        if (i2 != 0) {
            if (i2 == 1) {
                this.f26698g.setVisibility(0);
                this.f26699h.setVisibility(8);
                if (c2 == 1) {
                    layoutParams.topMargin = m.b(getContext(), 27.0f);
                } else {
                    layoutParams.topMargin = m.b(getContext(), 13.0f);
                }
                layoutParams.gravity = 1;
                this.f26698g.setLayoutParams(layoutParams);
                a(this.v);
                return;
            }
            return;
        }
        if (c2 != 1) {
            this.f26699h.setVisibility(0);
            this.f26698g.setVisibility(8);
            a(this.w);
        } else {
            layoutParams.topMargin = m.b(getContext(), 27.0f);
            layoutParams.gravity = 1;
            this.f26698g.setLayoutParams(layoutParams);
            this.f26698g.setVisibility(0);
            this.f26699h.setVisibility(8);
            a(this.v);
        }
    }

    @Override // android.content.DialogInterface.OnShowListener
    public void onShow(DialogInterface dialogInterface) {
        r rVar;
        if (this.f26701j == null || (rVar = this.f26696e) == null) {
            return;
        }
        int[] a2 = n.a(rVar);
        int[] b2 = n.b(this.f26696e);
        if (a2 == null || a2.length <= 1 || b2 == null || b2.length <= 1) {
            return;
        }
        this.f26701j.a(dialogInterface, a2[0], a2[1], b2[0] + a2[0], b2[1] + a2[1]);
    }

    public void a(com.vivo.ad.model.b bVar, Context context) {
        e.g gVar = new e.g(context, bVar, this.s);
        gVar.a(this.y);
        gVar.a(this.z);
        com.vivo.ad.e.e eVar = this.x;
        if (eVar != null) {
            eVar.a(gVar);
            return;
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(11);
        com.vivo.ad.e.e b2 = gVar.b();
        this.x = b2;
        b2.setId(y0.a());
        this.f26696e.addView(this.x, layoutParams);
    }

    public void a(DialogInterface.OnDismissListener onDismissListener) {
        this.z = onDismissListener;
    }

    public void a(DialogInterface.OnShowListener onShowListener) {
        this.y = onShowListener;
    }

    public void a(int i2) {
        this.k = i2;
        g();
    }

    public void a(e eVar) {
        this.f26701j = eVar;
        setOnShowListener(new com.vivo.mobilead.g.e(this));
    }

    public Drawable a(int i2, float[] fArr) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(i2);
        gradientDrawable.setCornerRadii(fArr);
        return gradientDrawable;
    }

    protected void a(float f2) {
        LinearLayout linearLayout;
        if (com.vivo.mobilead.util.q.a(this.l) && (linearLayout = this.u) != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) linearLayout.getLayoutParams();
            layoutParams.topMargin = m.b(getContext(), f2);
            this.u.setLayoutParams(layoutParams);
        }
    }
}
