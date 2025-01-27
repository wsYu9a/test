package com.opos.mobad.n.f;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.heytap.msp.mobad.api.R;
import com.opos.mobad.n.a;

/* loaded from: classes4.dex */
public class h extends RelativeLayout implements com.opos.mobad.n.f.a {
    private static int n = 280;
    private static int o = 488;

    /* renamed from: a */
    private com.opos.mobad.n.a.b f22266a;

    /* renamed from: b */
    private com.opos.mobad.n.c.h f22267b;

    /* renamed from: c */
    private View f22268c;

    /* renamed from: d */
    private View f22269d;

    /* renamed from: e */
    private TextView f22270e;

    /* renamed from: f */
    private i f22271f;

    /* renamed from: g */
    private com.opos.mobad.n.a.k f22272g;

    /* renamed from: h */
    private com.opos.mobad.n.c.h f22273h;

    /* renamed from: i */
    private TextView f22274i;

    /* renamed from: j */
    private boolean f22275j;
    private a.InterfaceC0458a k;
    private RelativeLayout l;
    private RelativeLayout m;
    private com.opos.mobad.n.d.d p;
    private AnimatorSet q;
    private ObjectAnimator r;
    private AnimatorSet s;
    private AnimatorSet t;
    private com.opos.mobad.n.c.g u;

    /* renamed from: com.opos.mobad.n.f.h$1 */
    class AnonymousClass1 extends AnimatorListenerAdapter {

        /* renamed from: a */
        final /* synthetic */ a f22276a;

        /* renamed from: com.opos.mobad.n.f.h$1$1 */
        class RunnableC04621 implements Runnable {
            RunnableC04621() {
            }

            @Override // java.lang.Runnable
            public void run() {
                aVar.a();
            }
        }

        AnonymousClass1(a aVar) {
            aVar = aVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            h.this.r.removeListener(this);
            if (aVar != null) {
                com.opos.mobad.c.b.b.a(new Runnable() { // from class: com.opos.mobad.n.f.h.1.1
                    RunnableC04621() {
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        aVar.a();
                    }
                });
            }
        }
    }

    /* renamed from: com.opos.mobad.n.f.h$2 */
    class AnonymousClass2 extends AnimatorListenerAdapter {

        /* renamed from: a */
        final /* synthetic */ int f22279a;

        /* renamed from: b */
        final /* synthetic */ int f22280b;

        /* renamed from: com.opos.mobad.n.f.h$2$1 */
        class AnonymousClass1 implements Runnable {
            AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public void run() {
                AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                h.this.a(a2, a3);
            }
        }

        AnonymousClass2(int i2, int i3) {
            a2 = i2;
            a3 = i3;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            h.this.s.removeListener(this);
            if (h.this.f22271f != null) {
                h.this.f22271f.setVisibility(8);
            }
            if (h.this.f22272g != null) {
                h.this.f22272g.setVisibility(8);
            }
            h.this.f22266a.setVisibility(8);
            com.opos.mobad.c.b.b.a(new Runnable() { // from class: com.opos.mobad.n.f.h.2.1
                AnonymousClass1() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                    h.this.a(a2, a3);
                }
            });
        }
    }

    /* renamed from: com.opos.mobad.n.f.h$3 */
    class AnonymousClass3 implements ValueAnimator.AnimatorUpdateListener {
        AnonymousClass3() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            h.this.f22269d.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    /* renamed from: com.opos.mobad.n.f.h$4 */
    class AnonymousClass4 extends com.opos.mobad.n.c.g {

        /* renamed from: com.opos.mobad.n.f.h$4$1 */
        class AnonymousClass1 implements a {

            /* renamed from: a */
            final /* synthetic */ View f22285a;

            /* renamed from: b */
            final /* synthetic */ int[] f22286b;

            /* renamed from: com.opos.mobad.n.f.h$4$1$1 */
            class RunnableC04631 implements Runnable {
                RunnableC04631() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (h.this.k != null) {
                        a.InterfaceC0458a interfaceC0458a = h.this.k;
                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                        interfaceC0458a.d(view, iArr);
                    }
                }
            }

            AnonymousClass1(View view, int[] iArr) {
                view = view;
                iArr = iArr;
            }

            @Override // com.opos.mobad.n.f.h.a
            public void a() {
                com.opos.mobad.c.b.b.a(new Runnable() { // from class: com.opos.mobad.n.f.h.4.1.1
                    RunnableC04631() {
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        if (h.this.k != null) {
                            a.InterfaceC0458a interfaceC0458a = h.this.k;
                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                            interfaceC0458a.d(view, iArr);
                        }
                    }
                });
            }
        }

        AnonymousClass4() {
        }

        @Override // com.opos.mobad.n.c.g
        public void a(View view, int[] iArr) {
            h.this.a(new a() { // from class: com.opos.mobad.n.f.h.4.1

                /* renamed from: a */
                final /* synthetic */ View f22285a;

                /* renamed from: b */
                final /* synthetic */ int[] f22286b;

                /* renamed from: com.opos.mobad.n.f.h$4$1$1 */
                class RunnableC04631 implements Runnable {
                    RunnableC04631() {
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        if (h.this.k != null) {
                            a.InterfaceC0458a interfaceC0458a = h.this.k;
                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                            interfaceC0458a.d(view, iArr);
                        }
                    }
                }

                AnonymousClass1(View view2, int[] iArr2) {
                    view = view2;
                    iArr = iArr2;
                }

                @Override // com.opos.mobad.n.f.h.a
                public void a() {
                    com.opos.mobad.c.b.b.a(new Runnable() { // from class: com.opos.mobad.n.f.h.4.1.1
                        RunnableC04631() {
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            if (h.this.k != null) {
                                a.InterfaceC0458a interfaceC0458a = h.this.k;
                                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                interfaceC0458a.d(view, iArr);
                            }
                        }
                    });
                }
            });
        }
    }

    public interface a {
        void a();
    }

    public h(Context context, boolean z) {
        super(context);
        this.u = new AnonymousClass4();
        this.f22275j = z;
        c();
    }

    public void a(int i2, int i3) {
        this.f22267b.setVisibility(8);
        this.f22270e.setVisibility(8);
        this.l.setVisibility(8);
        ViewGroup.LayoutParams layoutParams = this.f22273h.getLayoutParams();
        if (layoutParams.width != i2 || layoutParams.height != i3) {
            layoutParams.width = i2;
            layoutParams.height = i3;
        }
        this.m.setVisibility(0);
        View view = this.f22269d;
        if (view != null) {
            view.setVisibility(0);
            this.f22274i.setVisibility(0);
            Interpolator create = PathInterpolatorCompat.create(0.33f, 0.0f, 0.1f, 1.0f);
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            ofFloat.setDuration(133L);
            ofFloat.setInterpolator(create);
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.opos.mobad.n.f.h.3
                AnonymousClass3() {
                }

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    h.this.f22269d.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            });
        }
    }

    private void a(com.opos.mobad.n.d.a aVar) {
        String str;
        if (aVar == null) {
            str = "app info is null";
        } else {
            if (this.p == null) {
                if (indexOfChild(this.f22266a) < 0) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams.addRule(12);
                    layoutParams.addRule(14);
                    layoutParams.bottomMargin = com.opos.cmn.an.h.f.a.a(getContext(), 4.0f);
                    addView(this.f22266a, layoutParams);
                }
                this.f22266a.a(0, aVar.f22065a, aVar.f22066b);
                return;
            }
            str = "app info has render";
        }
        com.opos.cmn.an.f.a.b("InterstitialViewFrame", str);
    }

    private void a(com.opos.mobad.n.d.d dVar) {
        if (this.f22275j) {
            if (indexOfChild(this.f22271f) < 0) {
                this.f22271f.a(this.k);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, com.opos.cmn.an.h.f.a.a(getContext(), 28.0f));
                layoutParams.addRule(10);
                layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(getContext(), 16.0f);
                addView(this.f22271f, layoutParams);
                this.f22271f.bringToFront();
            }
            this.f22271f.a(dVar.r, dVar.B, dVar.s, dVar.f22077i, dVar.f22078j, dVar.k);
            return;
        }
        if (this.f22267b.indexOfChild(this.f22272g) < 0) {
            this.f22272g.a(this.k);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, com.opos.cmn.an.h.f.a.a(getContext(), 14.0f));
            layoutParams2.topMargin = com.opos.cmn.an.h.f.a.a(getContext(), 12.0f);
            layoutParams2.leftMargin = com.opos.cmn.an.h.f.a.a(getContext(), 12.0f);
            this.f22267b.addView(this.f22272g, layoutParams2);
            this.f22272g.bringToFront();
        }
        this.f22272g.a(dVar.r, dVar.f22077i, dVar.f22078j, dVar.k);
    }

    public void a(a aVar) {
        this.r = ObjectAnimator.ofFloat(this, "alpha", 1.0f, 0.0f);
        this.r.setInterpolator(PathInterpolatorCompat.create(0.1f, 0.0f, 0.9f, 1.0f));
        this.r.setDuration(150L);
        this.r.start();
        this.r.addListener(new AnimatorListenerAdapter() { // from class: com.opos.mobad.n.f.h.1

            /* renamed from: a */
            final /* synthetic */ a f22276a;

            /* renamed from: com.opos.mobad.n.f.h$1$1 */
            class RunnableC04621 implements Runnable {
                RunnableC04621() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    aVar.a();
                }
            }

            AnonymousClass1(a aVar2) {
                aVar = aVar2;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                h.this.r.removeListener(this);
                if (aVar != null) {
                    com.opos.mobad.c.b.b.a(new Runnable() { // from class: com.opos.mobad.n.f.h.1.1
                        RunnableC04621() {
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            aVar.a();
                        }
                    });
                }
            }
        });
    }

    private void c() {
        setClipChildren(false);
        if (Build.VERSION.SDK_INT >= 29) {
            setForceDarkAllowed(false);
        }
        setClickable(true);
        this.l = new RelativeLayout(getContext());
        com.opos.mobad.n.c.h hVar = new com.opos.mobad.n.c.h(getContext());
        this.f22267b = hVar;
        hVar.a(com.opos.cmn.an.h.f.a.a(getContext(), 16.0f));
        this.f22267b.setId(View.generateViewId());
        this.f22267b.setBackgroundColor(-1);
        boolean z = this.f22275j;
        this.l.addView(this.f22267b, new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(getContext(), z ? org.mozilla.universalchardet.prober.g.n : 258), com.opos.cmn.an.h.f.a.a(getContext(), z ? 427 : 401)));
        TextView textView = new TextView(getContext());
        this.f22270e = textView;
        textView.setBackgroundResource(R.drawable.opos_mobad_dialog_close);
        this.f22270e.setOnClickListener(this.u);
        this.f22270e.setOnTouchListener(this.u);
        int a2 = com.opos.cmn.an.h.f.a.a(getContext(), 36.0f);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(a2, a2);
        layoutParams.addRule(3, this.f22267b.getId());
        layoutParams.addRule(14);
        layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(getContext(), 6.0f);
        this.l.addView(this.f22270e, layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13);
        addView(this.l, layoutParams2);
        this.f22266a = new com.opos.mobad.n.a.b(getContext());
        if (this.f22275j) {
            this.f22271f = new i(getContext());
        } else {
            this.f22272g = com.opos.mobad.n.a.k.b(getContext());
        }
        d();
    }

    private void d() {
        this.m = new RelativeLayout(getContext());
        com.opos.mobad.n.c.h hVar = new com.opos.mobad.n.c.h(getContext());
        this.f22273h = hVar;
        hVar.a();
        this.f22273h.a(com.opos.cmn.an.h.f.a.a(getContext(), 16.0f));
        this.f22273h.setId(View.generateViewId());
        this.f22273h.setBackgroundColor(-1);
        this.f22273h.setVisibility(0);
        this.m.addView(this.f22273h, new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(getContext(), n), com.opos.cmn.an.h.f.a.a(getContext(), o)));
        TextView textView = new TextView(getContext());
        this.f22274i = textView;
        textView.setVisibility(0);
        this.f22274i.setBackgroundResource(R.drawable.opos_mobad_dialog_close);
        this.f22274i.setOnClickListener(this.u);
        this.f22274i.setOnTouchListener(this.u);
        int a2 = com.opos.cmn.an.h.f.a.a(getContext(), 36.0f);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(a2, a2);
        layoutParams.addRule(3, this.f22273h.getId());
        layoutParams.addRule(14);
        layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(getContext(), 6.0f);
        this.m.addView(this.f22274i, layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13);
        this.m.setVisibility(4);
        addView(this.m, layoutParams2);
    }

    private void e() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "alpha", 0.0f, 1.0f);
        ofFloat.setInterpolator(PathInterpolatorCompat.create(0.1f, 0.0f, 0.1f, 1.0f));
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f22267b, "scaleY", 0.8f, 1.0f);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.f22267b, "scaleX", 0.8f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        this.q = animatorSet;
        animatorSet.playTogether(ofFloat, ofFloat2, ofFloat3);
        this.q.setDuration(250L);
        this.q.start();
    }

    @Override // com.opos.mobad.n.f.a
    public ViewGroup a() {
        return this;
    }

    @Override // com.opos.mobad.n.f.a
    public void a(View view) {
        if (view == null) {
            return;
        }
        this.f22268c = view;
        if (this.f22267b.indexOfChild(view) < 0) {
            this.f22267b.removeAllViews();
            this.f22267b.addView(view, new RelativeLayout.LayoutParams(-1, -1));
        }
    }

    @Override // com.opos.mobad.n.f.a
    public void a(a.InterfaceC0458a interfaceC0458a) {
        this.k = interfaceC0458a;
        this.f22266a.a(interfaceC0458a);
    }

    @Override // com.opos.mobad.n.f.a
    public void a(com.opos.mobad.n.d.h hVar) {
        a.InterfaceC0458a interfaceC0458a;
        if (hVar == null) {
            com.opos.cmn.an.f.a.d("", "render builder with data null");
            interfaceC0458a = this.k;
            if (interfaceC0458a == null) {
                return;
            }
        } else {
            com.opos.mobad.n.d.d b2 = this.f22275j ? hVar.b() : hVar.a();
            if (b2 != null) {
                a(b2.v);
                a(b2);
                if (this.p == null) {
                    e();
                }
                this.p = b2;
                return;
            }
            com.opos.cmn.an.f.a.d("InterstitialViewFrame", "render with data null");
            interfaceC0458a = this.k;
            if (interfaceC0458a == null) {
                return;
            }
        }
        interfaceC0458a.b(1);
    }

    @Override // com.opos.mobad.n.f.a
    public void b() {
        int a2 = com.opos.cmn.an.h.f.a.a(getContext(), n);
        int a3 = com.opos.cmn.an.h.f.a.a(getContext(), o);
        int width = this.f22267b.getWidth();
        int height = this.f22267b.getHeight();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f22267b, "scaleX", 1.0f, a2 / width);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f22267b, "scaleY", 1.0f, a3 / height);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.f22270e, "translationY", 0.0f, (a3 - height) / 2);
        Interpolator create = PathInterpolatorCompat.create(0.33f, 0.0f, 0.67f, 1.0f);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.f22275j ? this.f22271f : this.f22272g, "alpha", 1.0f, 0.0f);
        ofFloat4.setInterpolator(create);
        ofFloat4.setDuration(133L);
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.f22266a, "alpha", 1.0f, 0.0f);
        ofFloat5.setInterpolator(create);
        ofFloat5.setDuration(133L);
        Interpolator create2 = PathInterpolatorCompat.create(0.3f, 0.0f, 0.1f, 1.0f);
        ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(this.f22268c, "scaleX", 1.0f, 1.266f);
        ofFloat6.setInterpolator(create2);
        ObjectAnimator ofFloat7 = ObjectAnimator.ofFloat(this.f22268c, "scaleY", 1.0f, 1.266f);
        ofFloat7.setInterpolator(create2);
        ObjectAnimator ofFloat8 = ObjectAnimator.ofFloat(this.f22268c, "alpha", 1.0f, 0.0f);
        ofFloat8.setInterpolator(create);
        ofFloat5.setDuration(133L);
        AnimatorSet animatorSet = new AnimatorSet();
        this.s = animatorSet;
        animatorSet.playTogether(ofFloat, ofFloat2, ofFloat3, ofFloat6, ofFloat7);
        this.s.setDuration(267L);
        this.s.start();
        AnimatorSet animatorSet2 = new AnimatorSet();
        this.t = animatorSet2;
        animatorSet2.playTogether(ofFloat4, ofFloat5, ofFloat8);
        this.t.setDuration(133L);
        this.t.start();
        this.s.addListener(new AnimatorListenerAdapter() { // from class: com.opos.mobad.n.f.h.2

            /* renamed from: a */
            final /* synthetic */ int f22279a;

            /* renamed from: b */
            final /* synthetic */ int f22280b;

            /* renamed from: com.opos.mobad.n.f.h$2$1 */
            class AnonymousClass1 implements Runnable {
                AnonymousClass1() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                    h.this.a(a2, a3);
                }
            }

            AnonymousClass2(int a22, int a32) {
                a2 = a22;
                a3 = a32;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                h.this.s.removeListener(this);
                if (h.this.f22271f != null) {
                    h.this.f22271f.setVisibility(8);
                }
                if (h.this.f22272g != null) {
                    h.this.f22272g.setVisibility(8);
                }
                h.this.f22266a.setVisibility(8);
                com.opos.mobad.c.b.b.a(new Runnable() { // from class: com.opos.mobad.n.f.h.2.1
                    AnonymousClass1() {
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                        h.this.a(a2, a3);
                    }
                });
            }
        });
    }

    @Override // com.opos.mobad.n.f.a
    public void b(View view) {
        if (view == null) {
            return;
        }
        this.f22269d = view;
        if (this.f22273h.indexOfChild(view) < 0) {
            if (this.f22269d.getParent() != null) {
                ((ViewGroup) this.f22269d.getParent()).removeView(this.f22269d);
            }
            this.f22273h.addView(this.f22269d, new RelativeLayout.LayoutParams(-1, -1));
        }
    }
}
