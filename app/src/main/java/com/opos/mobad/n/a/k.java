package com.opos.mobad.n.a;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.heytap.msp.mobad.api.R;
import com.opos.mobad.n.a;

/* loaded from: classes4.dex */
public class k extends LinearLayout {

    /* renamed from: a */
    com.opos.mobad.n.c.g f21827a;

    /* renamed from: b */
    private TextView f21828b;

    /* renamed from: c */
    private View f21829c;

    /* renamed from: d */
    private TextView f21830d;

    /* renamed from: e */
    private TextView f21831e;

    /* renamed from: f */
    private FrameLayout f21832f;

    /* renamed from: g */
    private a.InterfaceC0458a f21833g;

    /* renamed from: h */
    private a f21834h;

    /* renamed from: com.opos.mobad.n.a.k$1 */
    class AnonymousClass1 extends com.opos.mobad.n.c.g {
        AnonymousClass1() {
        }

        @Override // com.opos.mobad.n.c.g
        public void a(View view, int[] iArr) {
            com.opos.cmn.an.f.a.b("LogoTipBar", "onFeedBackClick");
            if (k.this.f21833g != null) {
                k.this.f21833g.a(view, iArr);
            }
        }
    }

    static class a {

        /* renamed from: a */
        public final int f21836a;

        /* renamed from: b */
        public final int f21837b;

        /* renamed from: c */
        public final int f21838c;

        /* renamed from: d */
        public final int f21839d;

        /* renamed from: e */
        public final int f21840e;

        /* renamed from: f */
        public final int f21841f;

        /* renamed from: g */
        public final float f21842g;

        /* renamed from: h */
        public final int f21843h;

        /* renamed from: i */
        public final boolean f21844i;

        /* renamed from: j */
        public final int f21845j;
        public final float k;
        public final float l;

        public a(int i2, int i3, int i4, int i5, int i6, int i7, float f2, int i8, boolean z, int i9, float f3, float f4) {
            this.f21836a = i2;
            this.f21839d = i5;
            this.f21837b = i3;
            this.f21838c = i4;
            this.f21840e = i6;
            this.f21841f = i7;
            this.f21842g = f2;
            this.f21843h = i8;
            this.f21844i = z;
            this.f21845j = i9;
            this.k = f3;
            this.l = f4;
        }
    }

    public k(Context context, a aVar) {
        super(context);
        this.f21827a = new com.opos.mobad.n.c.g() { // from class: com.opos.mobad.n.a.k.1
            AnonymousClass1() {
            }

            @Override // com.opos.mobad.n.c.g
            public void a(View view, int[] iArr) {
                com.opos.cmn.an.f.a.b("LogoTipBar", "onFeedBackClick");
                if (k.this.f21833g != null) {
                    k.this.f21833g.a(view, iArr);
                }
            }
        };
        this.f21834h = aVar;
        a();
    }

    public static k a(Context context) {
        return new k(context, new a(14, 28, 43, 20, 10, 10, 14.0f, 637534208, true, 14, 7.42f, 4.15f));
    }

    private void a() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(this.f21834h.f21843h);
        gradientDrawable.setCornerRadius(com.opos.cmn.an.h.f.a.a(getContext(), this.f21834h.f21842g));
        com.opos.mobad.n.e.a(this, gradientDrawable);
        setPadding(com.opos.cmn.an.h.f.a.a(getContext(), this.f21834h.f21840e), 0, com.opos.cmn.an.h.f.a.a(getContext(), this.f21834h.f21841f), 0);
        setOrientation(0);
        TextView textView = new TextView(getContext());
        this.f21830d = textView;
        textView.setTextColor(Color.parseColor("#FFFFFF"));
        this.f21830d.setTextSize(1, this.f21834h.f21836a);
        this.f21830d.setGravity(17);
        this.f21830d.setMaxEms(6);
        this.f21830d.setEllipsize(TextUtils.TruncateAt.END);
        this.f21830d.setSingleLine();
        this.f21830d.setVisibility(8);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 16;
        addView(this.f21830d, layoutParams);
        this.f21832f = new FrameLayout(getContext());
        TextView textView2 = new TextView(getContext());
        this.f21831e = textView2;
        textView2.setBackgroundResource(R.drawable.opos_mobad_feedback_down_vector);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(getContext(), this.f21834h.k), com.opos.cmn.an.h.f.a.a(getContext(), this.f21834h.l));
        layoutParams2.gravity = 17;
        this.f21832f.addView(this.f21831e, layoutParams2);
        int a2 = com.opos.cmn.an.h.f.a.a(getContext(), this.f21834h.f21845j);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(a2, a2);
        layoutParams3.leftMargin = com.opos.cmn.an.h.f.a.a(getContext(), 2.0f);
        layoutParams3.gravity = 16;
        addView(this.f21832f, layoutParams3);
        if (this.f21834h.f21844i) {
            TextView textView3 = new TextView(getContext());
            this.f21829c = textView3;
            textView3.setBackgroundColor(-1);
            LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(getContext(), 1.0f), com.opos.cmn.an.h.f.a.a(getContext(), 12.0f));
            layoutParams4.setMargins(com.opos.cmn.an.h.f.a.a(getContext(), 4.0f), com.opos.cmn.an.h.f.a.a(getContext(), 8.0f), 0, com.opos.cmn.an.h.f.a.a(getContext(), 8.0f));
            layoutParams4.gravity = 16;
            addView(this.f21829c, layoutParams4);
            TextView textView4 = new TextView(getContext());
            this.f21828b = textView4;
            textView4.setTextSize(1, this.f21834h.f21836a);
            this.f21828b.setTextColor(-1);
            this.f21828b.setGravity(17);
            this.f21828b.setMinWidth(com.opos.cmn.an.h.f.a.a(getContext(), 28.0f));
            LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-2, com.opos.cmn.an.h.f.a.a(getContext(), 20.0f));
            layoutParams5.leftMargin = com.opos.cmn.an.h.f.a.a(getContext(), 4.0f);
            layoutParams5.gravity = 16;
            addView(this.f21828b, layoutParams5);
        }
    }

    public static k b(Context context) {
        return new k(context, new a(10, 21, 30, 14, 4, 0, 3.0f, -1308622848, false, 12, 6.36f, 3.56f));
    }

    public void a(a.InterfaceC0458a interfaceC0458a) {
        com.opos.cmn.an.f.a.b("LogoTipBar", "setListener " + interfaceC0458a);
        this.f21833g = interfaceC0458a;
    }

    public void a(boolean z, String str, boolean z2, com.opos.mobad.n.d.g gVar, String str2) {
        if (this.f21828b != null) {
            if (TextUtils.isEmpty(str)) {
                this.f21828b.setVisibility(8);
                this.f21829c.setVisibility(8);
            } else {
                this.f21828b.setText(str);
                this.f21828b.setVisibility(0);
                if (!TextUtils.isEmpty(str)) {
                    this.f21829c.setVisibility(0);
                }
            }
        }
        a(z, z2, gVar, str2);
    }

    public void a(boolean z, boolean z2, com.opos.mobad.n.d.g gVar, String str) {
        int i2;
        Drawable drawable = null;
        if (z) {
            this.f21832f.setVisibility(0);
            this.f21832f.setOnClickListener(this.f21827a);
            this.f21832f.setOnTouchListener(this.f21827a);
            this.f21830d.setOnClickListener(this.f21827a);
            this.f21830d.setOnTouchListener(this.f21827a);
        } else {
            if (this.f21834h.f21841f == 0) {
                setPadding(com.opos.cmn.an.h.f.a.a(getContext(), this.f21834h.f21840e), 0, com.opos.cmn.an.h.f.a.a(getContext(), this.f21834h.f21840e), 0);
            }
            this.f21832f.setVisibility(8);
            this.f21830d.setOnClickListener(null);
            this.f21830d.setOnTouchListener(null);
        }
        if (!z2 || this.f21830d.getVisibility() == 0) {
            return;
        }
        if (gVar != null && !TextUtils.isEmpty(gVar.f22084a)) {
            drawable = com.opos.mobad.n.e.a(getContext(), gVar.f22084a);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("getLogoDrawable=");
        sb.append(drawable != null ? drawable : "null");
        com.opos.cmn.an.f.a.b("LogoTipBar", sb.toString());
        ViewGroup.LayoutParams layoutParams = this.f21830d.getLayoutParams();
        TextView textView = this.f21830d;
        if (drawable != null) {
            com.opos.mobad.n.e.a(textView, drawable);
            i2 = com.opos.cmn.an.h.f.a.a(getContext(), this.f21834h.f21838c);
        } else {
            textView.setText(str);
            this.f21830d.setMinWidth(com.opos.cmn.an.h.f.a.a(getContext(), this.f21834h.f21837b));
            i2 = -2;
        }
        layoutParams.width = i2;
        layoutParams.height = com.opos.cmn.an.h.f.a.a(getContext(), this.f21834h.f21839d);
        this.f21830d.setVisibility(0);
    }
}
