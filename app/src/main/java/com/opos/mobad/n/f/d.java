package com.opos.mobad.n.f;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.heytap.msp.mobad.api.R;

/* loaded from: classes4.dex */
public class d extends RelativeLayout {

    /* renamed from: a */
    private com.opos.mobad.n.c.f f22187a;

    /* renamed from: b */
    private LinearLayout f22188b;

    /* renamed from: c */
    private TextView f22189c;

    /* renamed from: d */
    private FrameLayout f22190d;

    /* renamed from: e */
    private TextView f22191e;

    /* renamed from: f */
    private LinearLayout f22192f;

    /* renamed from: g */
    private TextView f22193g;

    /* renamed from: h */
    private TextView f22194h;

    /* renamed from: i */
    private TextView f22195i;

    /* renamed from: j */
    private TextView f22196j;
    private TextView k;
    private int l;

    public d(Context context, int i2) {
        super(context);
        this.l = 1;
        this.l = i2;
        c();
    }

    public static d a(Context context) {
        return new d(context, 1);
    }

    public static d b(Context context) {
        return new d(context, 0);
    }

    private void c() {
        com.opos.mobad.n.c.f fVar = new com.opos.mobad.n.c.f(getContext(), com.opos.cmn.an.h.f.a.a(getContext(), 14.0f));
        this.f22187a = fVar;
        fVar.setId(View.generateViewId());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(getContext(), 60.0f), com.opos.cmn.an.h.f.a.a(getContext(), 60.0f));
        layoutParams.addRule(this.l == 1 ? 14 : 15);
        addView(this.f22187a, layoutParams);
        e();
        d();
    }

    private void d() {
        TextView textView;
        float f2;
        int a2;
        int a3;
        float f3;
        RelativeLayout.LayoutParams layoutParams;
        this.f22190d = new FrameLayout(getContext());
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(-16777216);
        gradientDrawable.setCornerRadius(com.opos.cmn.an.h.f.a.a(getContext(), 36.0f));
        this.f22190d.setBackground(gradientDrawable);
        RelativeLayout relativeLayout = new RelativeLayout(getContext());
        TextView textView2 = new TextView(getContext());
        this.f22189c = textView2;
        textView2.setId(View.generateViewId());
        this.f22189c.setTextColor(-1);
        if (this.l == 1) {
            textView = this.f22189c;
            f2 = 14.0f;
        } else {
            textView = this.f22189c;
            f2 = 10.0f;
        }
        textView.setTextSize(1, f2);
        this.f22189c.setGravity(17);
        this.f22189c.setSingleLine();
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(15);
        relativeLayout.addView(this.f22189c, layoutParams2);
        TextView textView3 = new TextView(getContext());
        this.f22196j = textView3;
        textView3.setId(View.generateViewId());
        TextView textView4 = this.f22196j;
        int i2 = R.drawable.opos_mobad_bn_white_vector;
        textView4.setBackgroundResource(i2);
        if (this.l == 1) {
            a2 = com.opos.cmn.an.h.f.a.a(getContext(), 5.9f);
            a3 = com.opos.cmn.an.h.f.a.a(getContext(), 10.5f);
            f3 = 7.04f;
        } else {
            a2 = com.opos.cmn.an.h.f.a.a(getContext(), 3.56f);
            a3 = com.opos.cmn.an.h.f.a.a(getContext(), 6.36f);
            f3 = 1.62f;
        }
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(a2, a3);
        layoutParams3.addRule(1, this.f22189c.getId());
        layoutParams3.leftMargin = com.opos.cmn.an.h.f.a.a(getContext(), f3);
        layoutParams3.addRule(15);
        relativeLayout.addView(this.f22196j, layoutParams3);
        TextView textView5 = new TextView(getContext());
        this.k = textView5;
        textView5.setId(View.generateViewId());
        this.k.setBackgroundResource(i2);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(a2, a3);
        layoutParams4.leftMargin = com.opos.cmn.an.h.f.a.a(getContext(), this.l == 1 ? 2.07f : 0.44f);
        layoutParams4.addRule(1, this.f22196j.getId());
        layoutParams4.addRule(15);
        relativeLayout.addView(this.k, layoutParams4);
        FrameLayout.LayoutParams layoutParams5 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams5.gravity = 17;
        this.f22190d.addView(relativeLayout, layoutParams5);
        if (this.l == 1) {
            layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(getContext(), 220.0f), com.opos.cmn.an.h.f.a.a(getContext(), 44.0f));
            layoutParams.addRule(14);
            layoutParams.addRule(3, this.f22188b.getId());
        } else {
            layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(getContext(), 68.0f), com.opos.cmn.an.h.f.a.a(getContext(), 28.0f));
            layoutParams.addRule(15);
            layoutParams.addRule(11);
        }
        addView(this.f22190d, layoutParams);
    }

    private void e() {
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.f22188b = linearLayout;
        linearLayout.setId(View.generateViewId());
        this.f22188b.setOrientation(1);
        TextView textView = new TextView(getContext());
        this.f22191e = textView;
        textView.setTypeface(Typeface.defaultFromStyle(1));
        this.f22191e.setTextColor(-16777216);
        this.f22191e.setTextSize(1, 14.0f);
        this.f22191e.setGravity(17);
        this.f22191e.setMaxEms(6);
        this.f22191e.setEllipsize(TextUtils.TruncateAt.END);
        this.f22191e.setSingleLine();
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        if (this.l == 1) {
            layoutParams.gravity = 1;
        } else {
            layoutParams.gravity = 3;
        }
        this.f22188b.addView(this.f22191e, layoutParams);
        f();
        TextView textView2 = new TextView(getContext());
        this.f22193g = textView2;
        textView2.setTextColor(Color.parseColor("#8C000000"));
        this.f22193g.setTextSize(1, 12.0f);
        this.f22193g.setGravity(17);
        this.f22193g.setEllipsize(TextUtils.TruncateAt.END);
        this.f22193g.setSingleLine();
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.topMargin = com.opos.cmn.an.h.f.a.a(getContext(), 4.0f);
        if (this.l == 1) {
            this.f22193g.setMaxEms(13);
            layoutParams2.gravity = 1;
        } else {
            this.f22193g.setMaxEms(7);
            layoutParams2.gravity = 3;
        }
        this.f22188b.addView(this.f22193g, layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        if (this.l == 1) {
            layoutParams3.addRule(14);
            layoutParams3.topMargin = com.opos.cmn.an.h.f.a.a(getContext(), 4.0f);
            layoutParams3.addRule(3, this.f22187a.getId());
            layoutParams3.bottomMargin = com.opos.cmn.an.h.f.a.a(getContext(), 24.0f);
        } else {
            layoutParams3.addRule(15);
            layoutParams3.leftMargin = com.opos.cmn.an.h.f.a.a(getContext(), 8.0f);
            layoutParams3.addRule(1, this.f22187a.getId());
        }
        addView(this.f22188b, layoutParams3);
    }

    private void f() {
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.f22192f = linearLayout;
        linearLayout.setOrientation(0);
        TextView textView = new TextView(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(getContext(), 12.0f), com.opos.cmn.an.h.f.a.a(getContext(), 12.0f));
        textView.setBackgroundResource(R.drawable.opos_mobad_download_vector);
        layoutParams.gravity = 16;
        this.f22192f.addView(textView, layoutParams);
        TextView textView2 = new TextView(getContext());
        this.f22194h = textView2;
        textView2.setTextColor(Color.parseColor("#8C000000"));
        this.f22194h.setTextSize(1, 10.0f);
        this.f22194h.setGravity(17);
        this.f22194h.setEllipsize(TextUtils.TruncateAt.END);
        this.f22194h.setSingleLine();
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -1);
        layoutParams2.gravity = 16;
        this.f22192f.addView(this.f22194h, layoutParams2);
        TextView textView3 = new TextView(getContext());
        textView3.setBackgroundColor(-1946157056);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(2, -1);
        layoutParams3.gravity = 16;
        layoutParams3.setMargins(com.opos.cmn.an.h.f.a.a(getContext(), 6.0f), com.opos.cmn.an.h.f.a.a(getContext(), 2.0f), com.opos.cmn.an.h.f.a.a(getContext(), 6.0f), com.opos.cmn.an.h.f.a.a(getContext(), 2.0f));
        this.f22192f.addView(textView3, layoutParams3);
        TextView textView4 = new TextView(getContext());
        this.f22195i = textView4;
        textView4.setTextColor(Color.parseColor("#8C000000"));
        this.f22195i.setTextSize(1, 10.0f);
        this.f22195i.setGravity(17);
        this.f22195i.setEllipsize(TextUtils.TruncateAt.END);
        this.f22195i.setSingleLine();
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -1);
        layoutParams4.gravity = 16;
        this.f22192f.addView(this.f22195i, layoutParams4);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-2, com.opos.cmn.an.h.f.a.a(getContext(), 14.0f));
        if (this.l == 1) {
            layoutParams5.gravity = 1;
        } else {
            layoutParams5.gravity = 3;
        }
        layoutParams5.topMargin = com.opos.cmn.an.h.f.a.a(getContext(), 4.0f);
        this.f22188b.addView(this.f22192f, layoutParams5);
    }

    public void a() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f22196j, "alpha", 1.0f, 0.0f, 1.0f);
        ofFloat.setInterpolator(new LinearInterpolator());
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.k, "alpha", 1.0f, 0.0f, 1.0f);
        ofFloat2.setInterpolator(new LinearInterpolator());
        ofFloat.setRepeatCount(-1);
        ofFloat.setRepeatMode(1);
        ofFloat2.setRepeatCount(-1);
        ofFloat2.setRepeatMode(1);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ofFloat, ofFloat2);
        ofFloat2.setStartDelay(170L);
        animatorSet.setDuration(1400L);
        animatorSet.start();
    }

    public void a(Bitmap bitmap) {
        if (bitmap == null) {
            return;
        }
        this.f22187a.setImageBitmap(bitmap);
    }

    public void a(com.opos.mobad.n.c.g gVar) {
        this.f22190d.setOnClickListener(gVar);
        this.f22190d.setOnTouchListener(gVar);
    }

    public void a(String str, String str2, String str3, String str4, String str5) {
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2) && (TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4))) {
            this.f22188b.setVisibility(8);
        }
        if (TextUtils.isEmpty(str)) {
            this.f22191e.setVisibility(8);
        } else {
            this.f22191e.setText(str);
        }
        if (TextUtils.isEmpty(str2)) {
            this.f22193g.setVisibility(8);
        } else {
            this.f22193g.setText(str2);
        }
        if (TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4)) {
            this.f22192f.setVisibility(8);
        } else {
            this.f22195i.setText(str4);
            this.f22194h.setText(str3);
        }
        this.f22189c.setText(str5);
    }

    public void b() {
        this.f22187a.setVisibility(8);
    }
}
