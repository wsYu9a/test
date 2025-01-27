package com.opos.mobad.n.b;

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
import com.opos.mobad.n.c.g;
import com.opos.mobad.n.c.l;

/* loaded from: classes4.dex */
public class e extends LinearLayout {

    /* renamed from: a */
    g f21970a;

    /* renamed from: b */
    private l f21971b;

    /* renamed from: c */
    private TextView f21972c;

    /* renamed from: d */
    private FrameLayout f21973d;

    /* renamed from: e */
    private a.InterfaceC0458a f21974e;

    /* renamed from: f */
    private a f21975f;

    /* renamed from: com.opos.mobad.n.b.e$1 */
    class AnonymousClass1 extends g {
        AnonymousClass1() {
        }

        @Override // com.opos.mobad.n.c.g
        public void a(View view, int[] iArr) {
            com.opos.cmn.an.f.a.b("BannerTipBar", "onFeedBackClick");
            if (e.this.f21974e != null) {
                e.this.f21974e.a(view, iArr);
            }
        }
    }

    static class a {

        /* renamed from: a */
        public final int f21977a;

        /* renamed from: b */
        public final int f21978b;

        /* renamed from: c */
        public final int f21979c;

        /* renamed from: d */
        public final int f21980d;

        /* renamed from: e */
        public final float f21981e;

        /* renamed from: f */
        public final int f21982f;

        /* renamed from: g */
        public final boolean f21983g;

        /* renamed from: h */
        public final int f21984h;

        public a(int i2, int i3, int i4, int i5, float f2, int i6, boolean z, int i7) {
            this.f21977a = i2;
            this.f21979c = i4;
            this.f21978b = i3;
            this.f21980d = i5;
            this.f21981e = f2;
            this.f21982f = i6;
            this.f21983g = z;
            this.f21984h = i7;
        }
    }

    public e(Context context, a aVar) {
        super(context);
        this.f21970a = new g() { // from class: com.opos.mobad.n.b.e.1
            AnonymousClass1() {
            }

            @Override // com.opos.mobad.n.c.g
            public void a(View view, int[] iArr) {
                com.opos.cmn.an.f.a.b("BannerTipBar", "onFeedBackClick");
                if (e.this.f21974e != null) {
                    e.this.f21974e.a(view, iArr);
                }
            }
        };
        this.f21975f = aVar;
        a();
    }

    public static e a(Context context) {
        return new e(context, new a(8, 26, 11, 2, 2.0f, 637534208, true, 10));
    }

    private void a() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(this.f21975f.f21982f);
        gradientDrawable.setCornerRadius(com.opos.cmn.an.h.f.a.a(getContext(), this.f21975f.f21981e));
        com.opos.mobad.n.e.a(this, gradientDrawable);
        setPadding(com.opos.cmn.an.h.f.a.a(getContext(), this.f21975f.f21980d), 0, 0, 0);
        setOrientation(0);
        l lVar = new l(getContext());
        this.f21971b = lVar;
        lVar.setTextColor(Color.parseColor("#FFFFFF"));
        this.f21971b.setTextSize(1, this.f21975f.f21977a);
        this.f21971b.setGravity(17);
        this.f21971b.setMaxEms(6);
        this.f21971b.setEllipsize(TextUtils.TruncateAt.END);
        this.f21971b.setLetterSpacing(com.opos.cmn.an.h.f.a.a(getContext(), 0.67f));
        this.f21971b.setSingleLine();
        this.f21971b.setVisibility(8);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 16;
        addView(this.f21971b, layoutParams);
        this.f21973d = new FrameLayout(getContext());
        TextView textView = new TextView(getContext());
        this.f21972c = textView;
        textView.setBackgroundResource(R.drawable.opos_mobad_feedback_down_arrow);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(getContext(), this.f21975f.f21984h), com.opos.cmn.an.h.f.a.a(getContext(), this.f21975f.f21984h));
        layoutParams2.gravity = 17;
        this.f21973d.addView(this.f21972c, layoutParams2);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -1);
        layoutParams3.setMargins(com.opos.cmn.an.h.f.a.a(getContext(), 1.0f), 0, 0, 0);
        addView(this.f21973d, layoutParams3);
    }

    public void a(a.InterfaceC0458a interfaceC0458a) {
        com.opos.cmn.an.f.a.b("BannerTipBar", "setListener " + interfaceC0458a);
        this.f21974e = interfaceC0458a;
    }

    public void a(boolean z, String str, boolean z2, com.opos.mobad.n.d.g gVar, String str2) {
        a(z, z2, gVar, str2);
    }

    public void a(boolean z, boolean z2, com.opos.mobad.n.d.g gVar, String str) {
        int i2;
        Drawable drawable = null;
        FrameLayout frameLayout = this.f21973d;
        if (z) {
            frameLayout.setVisibility(0);
            this.f21973d.setOnClickListener(this.f21970a);
            this.f21973d.setOnTouchListener(this.f21970a);
            this.f21971b.setOnClickListener(this.f21970a);
            this.f21971b.setOnTouchListener(this.f21970a);
        } else {
            frameLayout.setVisibility(8);
            this.f21971b.setOnClickListener(null);
            this.f21971b.setOnTouchListener(null);
        }
        if (!z2 || this.f21971b.getVisibility() == 0) {
            return;
        }
        if (gVar != null && !TextUtils.isEmpty(gVar.f22084a)) {
            drawable = com.opos.mobad.n.e.a(getContext(), gVar.f22084a);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("getLogoDrawable=");
        sb.append(drawable != null ? drawable : "null");
        com.opos.cmn.an.f.a.b("BannerTipBar", sb.toString());
        ViewGroup.LayoutParams layoutParams = this.f21971b.getLayoutParams();
        l lVar = this.f21971b;
        if (drawable != null) {
            com.opos.mobad.n.e.a(lVar, drawable);
            layoutParams.width = com.opos.cmn.an.h.f.a.a(getContext(), this.f21975f.f21978b);
            i2 = com.opos.cmn.an.h.f.a.a(getContext(), this.f21975f.f21979c);
        } else {
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            lVar.setText(str);
            i2 = -2;
            layoutParams.width = -2;
        }
        layoutParams.height = i2;
        int a2 = com.opos.cmn.an.h.f.a.a(getContext(), this.f21975f.f21980d);
        setPadding(a2, 0, z ? 0 : a2, 0);
        this.f21971b.setLayoutParams(layoutParams);
        this.f21971b.setVisibility(0);
    }
}
