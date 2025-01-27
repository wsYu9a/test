package com.opos.mobad.n.f;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.heytap.msp.mobad.api.R;

/* loaded from: classes4.dex */
public class k extends RelativeLayout {

    /* renamed from: a */
    private a f22313a;

    /* renamed from: b */
    private com.opos.mobad.n.c.f f22314b;

    /* renamed from: c */
    private LinearLayout f22315c;

    /* renamed from: d */
    private TextView f22316d;

    /* renamed from: e */
    private RelativeLayout f22317e;

    /* renamed from: f */
    private TextView f22318f;

    /* renamed from: g */
    private TextView f22319g;

    /* renamed from: h */
    private TextView f22320h;

    /* renamed from: i */
    private TextView f22321i;

    /* renamed from: j */
    private boolean f22322j;

    /* renamed from: com.opos.mobad.n.f.k$1 */
    class AnonymousClass1 implements Runnable {
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            k.this.b();
        }
    }

    /* renamed from: com.opos.mobad.n.f.k$2 */
    class AnonymousClass2 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ ObjectAnimator f22324a;

        AnonymousClass2(ObjectAnimator objectAnimator) {
            ofFloat = objectAnimator;
        }

        @Override // java.lang.Runnable
        public void run() {
            k.this.setVisibility(0);
            ofFloat.start();
        }
    }

    public static class a {

        /* renamed from: a */
        public final int f22326a;

        /* renamed from: b */
        public final int f22327b;

        /* renamed from: c */
        public final int f22328c;

        /* renamed from: d */
        public final int f22329d;

        /* renamed from: e */
        public final int f22330e;

        /* renamed from: f */
        public final int f22331f;

        /* renamed from: g */
        public final int f22332g;

        /* renamed from: h */
        public final int f22333h;

        /* renamed from: i */
        public final int f22334i;

        /* renamed from: j */
        public final int f22335j;
        public final int k;
        public final int l;
        public final boolean m;
        public final int n;
        public final float o;
        public final float p;
        public final float q;
        public final float r;
        public final boolean s;

        public a(int i2, int i3, int i4, int i5, int i6, int i7) {
            this(i2, i3, i4, i5, i6, i7, true);
        }

        public a(int i2, int i3, int i4, int i5, int i6, int i7, boolean z) {
            int i8;
            float f2;
            this.f22326a = i2;
            this.f22327b = i3;
            this.f22329d = i4;
            this.f22334i = i5;
            this.s = z;
            int i9 = z ? 16 : 8;
            this.f22335j = i9;
            this.k = i9;
            this.n = i6;
            this.l = i7;
            boolean z2 = (16777215 & i7) == 0;
            this.m = z2;
            if (z2) {
                this.f22328c = -1;
                i8 = -1929379841;
            } else {
                this.f22328c = -16777216;
                i8 = -1946157056;
            }
            this.f22330e = i8;
            if (i6 == 1) {
                this.f22332g = 44;
                this.f22331f = z ? 220 : 170;
                this.f22333h = 14;
                this.o = 7.04f;
                this.p = 2.07f;
                this.q = 5.93f;
                f2 = 10.61f;
            } else {
                this.f22332g = 28;
                this.f22331f = 68;
                this.f22333h = 12;
                this.o = 2.63f;
                this.p = 0.26f;
                this.q = 4.74f;
                f2 = 8.48f;
            }
            this.r = f2;
        }
    }

    public k(Context context, a aVar) {
        super(context);
        this.f22322j = false;
        this.f22313a = aVar;
        setVisibility(4);
        d();
    }

    public static k a(Context context, int i2, int i3, int i4, int i5) {
        return new k(context, new a(i2, i3, i4, 42, 0, i5, false));
    }

    private void a(int i2) {
        if (this.f22322j) {
            return;
        }
        if (i2 <= 0) {
            setVisibility(0);
            return;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "alpha", 0.0f, 1.0f);
        ofFloat.setDuration(180L);
        ofFloat.setInterpolator(PathInterpolatorCompat.create(0.33f, 0.0f, 0.67f, 1.0f));
        com.opos.mobad.c.b.b.a(new Runnable() { // from class: com.opos.mobad.n.f.k.2

            /* renamed from: a */
            final /* synthetic */ ObjectAnimator f22324a;

            AnonymousClass2(ObjectAnimator ofFloat2) {
                ofFloat = ofFloat2;
            }

            @Override // java.lang.Runnable
            public void run() {
                k.this.setVisibility(0);
                ofFloat.start();
            }
        }, i2);
        this.f22322j = true;
    }

    public static k b(Context context, int i2, int i3, int i4, int i5) {
        return new k(context, new a(i2, i3, i4, 42, 1, i5, false));
    }

    public static k c(Context context, int i2, int i3, int i4, int i5) {
        return new k(context, new a(i2, i3, i4, 42, 0, i5));
    }

    public static k d(Context context, int i2, int i3, int i4, int i5) {
        return new k(context, new a(i2, i3, i4, 42, 1, i5));
    }

    private void d() {
        int i2;
        setBackgroundColor(this.f22313a.l);
        setGravity(17);
        com.opos.mobad.n.c.f fVar = new com.opos.mobad.n.c.f(getContext(), com.opos.cmn.an.h.f.a.a(getContext(), 8.0f));
        this.f22314b = fVar;
        fVar.setId(View.generateViewId());
        int a2 = com.opos.cmn.an.h.f.a.a(getContext(), this.f22313a.f22326a);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(a2, a2);
        if (this.f22313a.n == 1) {
            i2 = 14;
        } else {
            layoutParams.leftMargin = com.opos.cmn.an.h.f.a.a(getContext(), this.f22313a.f22335j);
            layoutParams.addRule(9);
            i2 = 15;
        }
        layoutParams.addRule(i2);
        addView(this.f22314b, layoutParams);
        e();
        f();
    }

    public static k e(Context context, int i2, int i3, int i4, int i5) {
        return new k(context, new a(i2, i3, i4, 30, 0, i5));
    }

    private void e() {
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.f22315c = linearLayout;
        linearLayout.setId(View.generateViewId());
        this.f22315c.setOrientation(1);
        TextView textView = new TextView(getContext());
        this.f22318f = textView;
        textView.setTypeface(Typeface.defaultFromStyle(1));
        this.f22318f.setTextColor(this.f22313a.f22328c);
        this.f22318f.setTextSize(1, this.f22313a.f22327b);
        this.f22318f.setGravity(3);
        a aVar = this.f22313a;
        if (aVar.n != 0 || aVar.s) {
            this.f22318f.setMaxEms(6);
        } else {
            this.f22318f.setMaxEms(5);
        }
        this.f22318f.setEllipsize(TextUtils.TruncateAt.END);
        this.f22318f.setSingleLine();
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        if (this.f22313a.n == 1) {
            layoutParams.gravity = 1;
        } else {
            layoutParams.gravity = 3;
        }
        this.f22315c.addView(this.f22318f, layoutParams);
        TextView textView2 = new TextView(getContext());
        this.f22319g = textView2;
        textView2.setTextColor(this.f22313a.f22330e);
        this.f22319g.setTextSize(1, this.f22313a.f22329d);
        this.f22319g.setGravity(3);
        this.f22319g.setEllipsize(TextUtils.TruncateAt.END);
        this.f22319g.setSingleLine();
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        a aVar2 = this.f22313a;
        if (aVar2.n == 1) {
            this.f22319g.setMaxEms(13);
            layoutParams2.gravity = 1;
        } else {
            this.f22319g.setMaxEms(aVar2.s ? 7 : 6);
            layoutParams2.gravity = 3;
        }
        this.f22315c.addView(this.f22319g, layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        if (this.f22313a.n == 1) {
            layoutParams3.addRule(14);
            layoutParams3.topMargin = com.opos.cmn.an.h.f.a.a(getContext(), 8.0f);
            layoutParams3.addRule(3, this.f22314b.getId());
            layoutParams3.bottomMargin = com.opos.cmn.an.h.f.a.a(getContext(), this.f22313a.f22334i);
        } else {
            layoutParams3.addRule(15);
            layoutParams3.leftMargin = com.opos.cmn.an.h.f.a.a(getContext(), 8.0f);
            layoutParams3.addRule(1, this.f22314b.getId());
        }
        addView(this.f22315c, layoutParams3);
    }

    public static k f(Context context, int i2, int i3, int i4, int i5) {
        return new k(context, new a(i2, i3, i4, 30, 1, i5));
    }

    private void f() {
        this.f22317e = new RelativeLayout(getContext());
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(this.f22313a.m ? -1 : -16777216);
        gradientDrawable.setCornerRadius(com.opos.cmn.an.h.f.a.a(getContext(), 36.0f));
        this.f22317e.setBackground(gradientDrawable);
        this.f22317e.setGravity(17);
        int a2 = com.opos.cmn.an.h.f.a.a(getContext(), 10.0f);
        this.f22317e.setPadding(a2, 0, a2, 0);
        TextView textView = new TextView(getContext());
        this.f22316d = textView;
        textView.setTypeface(Typeface.defaultFromStyle(1));
        this.f22316d.setId(View.generateViewId());
        this.f22316d.setTextColor(this.f22313a.m ? -16777216 : -1);
        this.f22316d.setTextSize(1, this.f22313a.f22333h);
        this.f22316d.setGravity(17);
        this.f22316d.setSingleLine();
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(15);
        this.f22317e.addView(this.f22316d, layoutParams);
        TextView textView2 = new TextView(getContext());
        this.f22320h = textView2;
        textView2.setId(View.generateViewId());
        this.f22320h.setBackgroundResource(this.f22313a.m ? R.drawable.opos_mobad_bn_black_vector : R.drawable.opos_mobad_bn_white_vector);
        int a3 = com.opos.cmn.an.h.f.a.a(getContext(), this.f22313a.q);
        int a4 = com.opos.cmn.an.h.f.a.a(getContext(), this.f22313a.r);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(a3, a4);
        layoutParams2.addRule(1, this.f22316d.getId());
        layoutParams2.leftMargin = com.opos.cmn.an.h.f.a.a(getContext(), this.f22313a.o);
        layoutParams2.addRule(15);
        this.f22317e.addView(this.f22320h, layoutParams2);
        TextView textView3 = new TextView(getContext());
        this.f22321i = textView3;
        textView3.setId(View.generateViewId());
        this.f22321i.setBackgroundResource(this.f22313a.m ? R.drawable.opos_mobad_bn_black_vector : R.drawable.opos_mobad_bn_white_vector);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(a3, a4);
        layoutParams3.leftMargin = com.opos.cmn.an.h.f.a.a(getContext(), this.f22313a.p);
        layoutParams3.addRule(1, this.f22320h.getId());
        layoutParams3.addRule(15);
        this.f22317e.addView(this.f22321i, layoutParams3);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(this.f22313a.n != 0 ? com.opos.cmn.an.h.f.a.a(getContext(), this.f22313a.f22331f) : -2, com.opos.cmn.an.h.f.a.a(getContext(), this.f22313a.f22332g));
        if (this.f22313a.n == 1) {
            layoutParams4.addRule(14);
            layoutParams4.addRule(3, this.f22315c.getId());
        } else {
            layoutParams4.addRule(15);
            layoutParams4.addRule(11);
            layoutParams4.rightMargin = com.opos.cmn.an.h.f.a.a(getContext(), this.f22313a.k);
        }
        addView(this.f22317e, layoutParams4);
    }

    public void a() {
        this.f22314b.setVisibility(8);
        if (this.f22313a.n == 0) {
            ((RelativeLayout.LayoutParams) this.f22315c.getLayoutParams()).leftMargin = com.opos.cmn.an.h.f.a.a(getContext(), 16.0f);
        }
    }

    public void a(Bitmap bitmap) {
        if (bitmap == null) {
            return;
        }
        this.f22314b.setImageBitmap(bitmap);
    }

    public void a(String str, String str2, String str3, int i2) {
        if (TextUtils.isEmpty(str)) {
            this.f22318f.setVisibility(8);
        } else {
            this.f22318f.setText(str);
        }
        if (TextUtils.isEmpty(str2)) {
            this.f22319g.setVisibility(8);
        } else {
            this.f22319g.setText(str2);
        }
        this.f22316d.setText(str3);
        a(i2);
    }

    public void b() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f22320h, "alpha", 1.0f, 0.0f, 1.0f);
        ofFloat.setInterpolator(new LinearInterpolator());
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f22321i, "alpha", 1.0f, 0.0f, 1.0f);
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

    public View c() {
        return this.f22317e;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.opos.mobad.c.b.b.a(new Runnable() { // from class: com.opos.mobad.n.f.k.1
            AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public void run() {
                k.this.b();
            }
        });
    }
}
