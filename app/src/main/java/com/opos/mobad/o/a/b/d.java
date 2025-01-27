package com.opos.mobad.o.a.b;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.opos.mobad.cmn.a.b.g;

/* loaded from: classes4.dex */
public class d {

    /* renamed from: a */
    private Context f22977a;

    /* renamed from: b */
    private RelativeLayout f22978b;

    /* renamed from: c */
    private TextView f22979c;

    /* renamed from: d */
    private GridLayout f22980d;

    /* renamed from: e */
    private c f22981e;

    /* renamed from: f */
    private GradientDrawable f22982f;

    /* renamed from: g */
    private GradientDrawable f22983g;

    /* renamed from: h */
    private int f22984h;

    /* renamed from: com.opos.mobad.o.a.b.d$1 */
    class AnonymousClass1 implements View.OnClickListener {

        /* renamed from: a */
        final /* synthetic */ int f22985a;

        AnonymousClass1(int i2) {
            i2 = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (d.this.f22981e != null) {
                d.this.f22981e.a(i2);
            }
        }
    }

    public d(Context context, c cVar) {
        this.f22977a = context;
        this.f22981e = cVar;
        c();
    }

    private TextView a(int i2, com.opos.mobad.o.a.a.b bVar) {
        com.opos.cmn.e.a.a.a aVar = new com.opos.cmn.e.a.a.a(this.f22977a, this.f22982f, this.f22983g, Color.parseColor("#8C000000"), Color.parseColor("#FF5A60"));
        aVar.setGravity(17);
        aVar.setTextSize(1, 12.0f);
        GridLayout.LayoutParams layoutParams = new GridLayout.LayoutParams(new ViewGroup.LayoutParams(com.opos.cmn.an.h.f.a.a(this.f22977a, 92.0f), com.opos.cmn.an.h.f.a.a(this.f22977a, 31.0f)));
        double d2 = i2;
        Double.isNaN(d2);
        double d3 = d2 / 3.0d;
        Double.isNaN(d2);
        if (d2 % 3.0d != 0.0d) {
            layoutParams.leftMargin = com.opos.cmn.an.h.f.a.a(this.f22977a, 6.0f);
        }
        if (d3 >= 1.0d) {
            layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.f22977a, 6.0f);
        }
        aVar.setText(bVar.b());
        aVar.setLayoutParams(layoutParams);
        a(aVar, bVar.a());
        return aVar;
    }

    private void a(View view, int i2) {
        if (view != null) {
            view.setOnClickListener(new View.OnClickListener() { // from class: com.opos.mobad.o.a.b.d.1

                /* renamed from: a */
                final /* synthetic */ int f22985a;

                AnonymousClass1(int i22) {
                    i2 = i22;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (d.this.f22981e != null) {
                        d.this.f22981e.a(i2);
                    }
                }
            });
        }
    }

    private void c() {
        this.f22978b = new RelativeLayout(this.f22977a);
        this.f22979c = new TextView(this.f22977a);
        int a2 = g.a();
        this.f22984h = a2;
        this.f22979c.setId(a2);
        this.f22979c.setTextColor(Color.parseColor("#8C000000"));
        this.f22979c.setTextSize(1, 12.0f);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, com.opos.cmn.an.h.f.a.a(this.f22977a, 17.0f));
        layoutParams.addRule(10);
        layoutParams.addRule(9);
        this.f22978b.addView(this.f22979c, layoutParams);
        GradientDrawable gradientDrawable = new GradientDrawable();
        this.f22982f = gradientDrawable;
        gradientDrawable.setColor(Color.parseColor("#F5F6F7"));
        this.f22982f.setCornerRadius(com.opos.cmn.an.h.f.a.a(this.f22977a, 5.0f));
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        this.f22983g = gradientDrawable2;
        gradientDrawable2.setColor(Color.parseColor("#1AFF5A60"));
        this.f22983g.setCornerRadius(com.opos.cmn.an.h.f.a.a(this.f22977a, 5.0f));
    }

    public View a() {
        return this.f22978b;
    }

    public void a(com.opos.mobad.o.a.a.a aVar) {
        if (aVar != null) {
            this.f22979c.setText(aVar.f22952a);
            int size = aVar.f22953b.size();
            if (size > 0) {
                this.f22980d = new GridLayout(this.f22977a);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.f22977a, 288.0f), -2);
                layoutParams.addRule(3, this.f22984h);
                layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.f22977a, 8.0f);
                this.f22980d.setColumnCount(3);
                GridLayout gridLayout = this.f22980d;
                double d2 = size;
                Double.isNaN(d2);
                gridLayout.setRowCount((int) Math.ceil(d2 / 3.0d));
                this.f22980d.setOrientation(0);
                this.f22980d.setUseDefaultMargins(false);
                this.f22978b.addView(this.f22980d, layoutParams);
                for (int i2 = 0; i2 < aVar.f22953b.size(); i2++) {
                    this.f22980d.addView(a(i2, aVar.f22953b.get(i2)));
                }
            }
        }
    }

    public void b() {
        RelativeLayout relativeLayout = this.f22978b;
        if (relativeLayout != null) {
            relativeLayout.removeAllViews();
        }
        if (this.f22981e != null) {
            this.f22981e = null;
        }
    }
}
