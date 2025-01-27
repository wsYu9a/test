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
import com.vivo.ic.dm.Downloads;

/* loaded from: classes4.dex */
public class f extends RelativeLayout implements com.opos.mobad.n.f.a {

    /* renamed from: a */
    private com.opos.mobad.n.a.b f22221a;

    /* renamed from: b */
    private com.opos.mobad.n.c.h f22222b;

    /* renamed from: c */
    private View f22223c;

    /* renamed from: d */
    private View f22224d;

    /* renamed from: e */
    private TextView f22225e;

    /* renamed from: f */
    private i f22226f;

    /* renamed from: g */
    private com.opos.mobad.n.a.k f22227g;

    /* renamed from: h */
    private com.opos.mobad.n.c.h f22228h;

    /* renamed from: i */
    private TextView f22229i;

    /* renamed from: j */
    private int f22230j;
    private boolean k;
    private a.InterfaceC0458a l;
    private RelativeLayout m;
    private RelativeLayout n;
    private com.opos.mobad.n.d.d o;
    private AnimatorSet p;
    private ObjectAnimator q;
    private AnimatorSet r;
    private AnimatorSet s;
    private com.opos.mobad.n.c.g t;

    /* renamed from: com.opos.mobad.n.f.f$1 */
    class AnonymousClass1 extends AnimatorListenerAdapter {

        /* renamed from: a */
        final /* synthetic */ a f22231a;

        /* renamed from: com.opos.mobad.n.f.f$1$1 */
        class RunnableC04601 implements Runnable {
            RunnableC04601() {
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
            f.this.q.removeListener(this);
            if (aVar != null) {
                com.opos.mobad.c.b.b.a(new Runnable() { // from class: com.opos.mobad.n.f.f.1.1
                    RunnableC04601() {
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        aVar.a();
                    }
                });
            }
        }
    }

    /* renamed from: com.opos.mobad.n.f.f$2 */
    class AnonymousClass2 extends AnimatorListenerAdapter {

        /* renamed from: a */
        final /* synthetic */ int f22234a;

        /* renamed from: b */
        final /* synthetic */ int f22235b;

        /* renamed from: com.opos.mobad.n.f.f$2$1 */
        class AnonymousClass1 implements Runnable {
            AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public void run() {
                AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                f.this.a(a2, a3);
            }
        }

        AnonymousClass2(int i2, int i3) {
            a2 = i2;
            a3 = i3;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            f.this.r.removeListener(this);
            if (f.this.f22226f != null) {
                f.this.f22226f.setVisibility(8);
            }
            if (f.this.f22227g != null) {
                f.this.f22227g.setVisibility(8);
            }
            f.this.f22221a.setVisibility(8);
            com.opos.mobad.c.b.b.a(new Runnable() { // from class: com.opos.mobad.n.f.f.2.1
                AnonymousClass1() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                    f.this.a(a2, a3);
                }
            });
        }
    }

    /* renamed from: com.opos.mobad.n.f.f$3 */
    class AnonymousClass3 implements ValueAnimator.AnimatorUpdateListener {
        AnonymousClass3() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            f.this.f22224d.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    /* renamed from: com.opos.mobad.n.f.f$4 */
    class AnonymousClass4 extends com.opos.mobad.n.c.g {

        /* renamed from: com.opos.mobad.n.f.f$4$1 */
        class AnonymousClass1 implements a {

            /* renamed from: a */
            final /* synthetic */ View f22240a;

            /* renamed from: b */
            final /* synthetic */ int[] f22241b;

            /* renamed from: com.opos.mobad.n.f.f$4$1$1 */
            class RunnableC04611 implements Runnable {
                RunnableC04611() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (f.this.l != null) {
                        a.InterfaceC0458a interfaceC0458a = f.this.l;
                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                        interfaceC0458a.d(view, iArr);
                    }
                }
            }

            AnonymousClass1(View view, int[] iArr) {
                view = view;
                iArr = iArr;
            }

            @Override // com.opos.mobad.n.f.f.a
            public void a() {
                com.opos.mobad.c.b.b.a(new Runnable() { // from class: com.opos.mobad.n.f.f.4.1.1
                    RunnableC04611() {
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        if (f.this.l != null) {
                            a.InterfaceC0458a interfaceC0458a = f.this.l;
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
            f.this.a(new a() { // from class: com.opos.mobad.n.f.f.4.1

                /* renamed from: a */
                final /* synthetic */ View f22240a;

                /* renamed from: b */
                final /* synthetic */ int[] f22241b;

                /* renamed from: com.opos.mobad.n.f.f$4$1$1 */
                class RunnableC04611 implements Runnable {
                    RunnableC04611() {
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        if (f.this.l != null) {
                            a.InterfaceC0458a interfaceC0458a = f.this.l;
                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                            interfaceC0458a.d(view, iArr);
                        }
                    }
                }

                AnonymousClass1(View view2, int[] iArr2) {
                    view = view2;
                    iArr = iArr2;
                }

                @Override // com.opos.mobad.n.f.f.a
                public void a() {
                    com.opos.mobad.c.b.b.a(new Runnable() { // from class: com.opos.mobad.n.f.f.4.1.1
                        RunnableC04611() {
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            if (f.this.l != null) {
                                a.InterfaceC0458a interfaceC0458a = f.this.l;
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

    public f(Context context, int i2, boolean z) {
        super(context);
        this.t = new AnonymousClass4();
        this.f22230j = i2;
        this.k = z;
        c();
    }

    public void a(int i2, int i3) {
        this.f22222b.setVisibility(8);
        this.f22225e.setVisibility(8);
        this.m.setVisibility(8);
        ViewGroup.LayoutParams layoutParams = this.f22228h.getLayoutParams();
        if (layoutParams.width != i2 || layoutParams.height != i3) {
            layoutParams.width = i2;
            layoutParams.height = i3;
        }
        this.n.setVisibility(0);
        View view = this.f22224d;
        if (view != null) {
            view.setVisibility(0);
            this.f22229i.setVisibility(0);
            Interpolator create = PathInterpolatorCompat.create(0.33f, 0.0f, 0.1f, 1.0f);
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            ofFloat.setDuration(133L);
            ofFloat.setInterpolator(create);
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.opos.mobad.n.f.f.3
                AnonymousClass3() {
                }

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    f.this.f22224d.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            });
        }
    }

    private void a(com.opos.mobad.n.d.a aVar) {
        String str;
        if (aVar == null) {
            str = "app info is null";
        } else {
            if (this.o == null) {
                if (indexOfChild(this.f22221a) < 0) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams.addRule(12);
                    layoutParams.addRule(14);
                    layoutParams.bottomMargin = com.opos.cmn.an.h.f.a.a(getContext(), 14.0f);
                    addView(this.f22221a, layoutParams);
                }
                this.f22221a.a(this.f22230j, aVar.f22065a, aVar.f22066b);
                return;
            }
            str = "app info has render";
        }
        com.opos.cmn.an.f.a.b("InterstitialViewFrame", str);
    }

    private void a(com.opos.mobad.n.d.d dVar) {
        RelativeLayout.LayoutParams layoutParams;
        int a2;
        if (!this.k) {
            if (this.f22222b.indexOfChild(this.f22227g) < 0) {
                this.f22227g.a(this.l);
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, com.opos.cmn.an.h.f.a.a(getContext(), 14.0f));
                layoutParams2.topMargin = com.opos.cmn.an.h.f.a.a(getContext(), 12.0f);
                layoutParams2.leftMargin = com.opos.cmn.an.h.f.a.a(getContext(), 12.0f);
                this.f22222b.addView(this.f22227g, layoutParams2);
                this.f22227g.bringToFront();
            }
            this.f22227g.a(dVar.r, dVar.f22077i, dVar.f22078j, dVar.k);
            return;
        }
        if (indexOfChild(this.f22226f) < 0) {
            this.f22226f.a(this.l);
            if (this.f22230j == 1) {
                layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.c(getContext()) - com.opos.cmn.an.h.f.a.a(getContext(), 20.0f), com.opos.cmn.an.h.f.a.a(getContext(), 28.0f));
                layoutParams.addRule(10);
                a2 = com.opos.cmn.an.h.f.a.a(getContext(), 14.0f);
            } else {
                layoutParams = new RelativeLayout.LayoutParams(-1, com.opos.cmn.an.h.f.a.a(getContext(), 28.0f));
                layoutParams.addRule(10);
                a2 = com.opos.cmn.an.h.f.a.a(getContext(), 38.0f);
            }
            layoutParams.topMargin = a2;
            addView(this.f22226f, layoutParams);
            this.f22226f.bringToFront();
        }
        this.f22226f.a(dVar.r, dVar.B, dVar.s, dVar.f22077i, dVar.f22078j, dVar.k);
    }

    public void a(a aVar) {
        this.q = ObjectAnimator.ofFloat(this, "alpha", 1.0f, 0.0f);
        this.q.setInterpolator(PathInterpolatorCompat.create(0.1f, 0.0f, 0.9f, 1.0f));
        this.q.setDuration(150L);
        this.q.start();
        this.q.addListener(new AnimatorListenerAdapter() { // from class: com.opos.mobad.n.f.f.1

            /* renamed from: a */
            final /* synthetic */ a f22231a;

            /* renamed from: com.opos.mobad.n.f.f$1$1 */
            class RunnableC04601 implements Runnable {
                RunnableC04601() {
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
                f.this.q.removeListener(this);
                if (aVar != null) {
                    com.opos.mobad.c.b.b.a(new Runnable() { // from class: com.opos.mobad.n.f.f.1.1
                        RunnableC04601() {
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
        this.m = new RelativeLayout(getContext());
        com.opos.mobad.n.c.h hVar = new com.opos.mobad.n.c.h(getContext());
        this.f22222b = hVar;
        hVar.a(com.opos.cmn.an.h.f.a.a(getContext(), 16.0f));
        this.f22222b.setId(View.generateViewId());
        this.f22222b.setBackgroundColor(-1);
        boolean z = this.k;
        int i2 = Downloads.Impl.STATUS_CANNOT_RESUME;
        int i3 = this.f22230j;
        int i4 = z ? i3 == 1 ? Downloads.Impl.STATUS_CANNOT_RESUME : 275 : i3 == 1 ? 272 : 258;
        if (!z) {
            i2 = this.f22230j == 1 ? 262 : 401;
        } else if (this.f22230j == 1) {
            i2 = 275;
        }
        this.m.addView(this.f22222b, new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(getContext(), i4), com.opos.cmn.an.h.f.a.a(getContext(), i2)));
        TextView textView = new TextView(getContext());
        this.f22225e = textView;
        textView.setBackgroundResource(R.drawable.opos_mobad_dialog_close);
        this.f22225e.setOnClickListener(this.t);
        this.f22225e.setOnTouchListener(this.t);
        int a2 = com.opos.cmn.an.h.f.a.a(getContext(), 48.0f);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(a2, a2);
        if (this.f22230j == 1) {
            layoutParams.addRule(1, this.f22222b.getId());
            layoutParams.addRule(15);
            layoutParams.leftMargin = com.opos.cmn.an.h.f.a.a(getContext(), 22.0f);
        } else {
            layoutParams.addRule(3, this.f22222b.getId());
            layoutParams.addRule(14);
            layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(getContext(), 22.0f);
        }
        this.m.addView(this.f22225e, layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13);
        addView(this.m, layoutParams2);
        this.f22221a = new com.opos.mobad.n.a.b(getContext());
        if (this.k) {
            this.f22226f = new i(getContext());
        } else {
            this.f22227g = com.opos.mobad.n.a.k.b(getContext());
        }
        d();
    }

    private void d() {
        int i2 = this.f22230j;
        int i3 = i2 == 0 ? 320 : Downloads.Impl.STATUS_CANNOT_RESUME;
        int i4 = i2 == 0 ? 619 : 275;
        this.n = new RelativeLayout(getContext());
        com.opos.mobad.n.c.h hVar = new com.opos.mobad.n.c.h(getContext());
        this.f22228h = hVar;
        hVar.a();
        this.f22228h.a(com.opos.cmn.an.h.f.a.a(getContext(), 16.0f));
        this.f22228h.setId(View.generateViewId());
        this.f22228h.setBackgroundColor(-1);
        this.f22228h.setVisibility(0);
        this.n.addView(this.f22228h, new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(getContext(), i3), com.opos.cmn.an.h.f.a.a(getContext(), i4)));
        TextView textView = new TextView(getContext());
        this.f22229i = textView;
        textView.setVisibility(0);
        this.f22229i.setBackgroundResource(R.drawable.opos_mobad_dialog_close);
        this.f22229i.setOnClickListener(this.t);
        this.f22229i.setOnTouchListener(this.t);
        int a2 = com.opos.cmn.an.h.f.a.a(getContext(), 48.0f);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(a2, a2);
        if (this.f22230j == 1) {
            layoutParams.addRule(1, this.f22228h.getId());
            layoutParams.addRule(15);
            layoutParams.leftMargin = com.opos.cmn.an.h.f.a.a(getContext(), 22.0f);
        } else {
            layoutParams.addRule(3, this.f22228h.getId());
            layoutParams.addRule(14);
            layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(getContext(), 22.0f);
        }
        this.n.addView(this.f22229i, layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13);
        this.n.setVisibility(4);
        addView(this.n, layoutParams2);
    }

    private void e() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "alpha", 0.0f, 1.0f);
        ofFloat.setInterpolator(PathInterpolatorCompat.create(0.1f, 0.0f, 0.1f, 1.0f));
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f22222b, "scaleY", 0.8f, 1.0f);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.f22222b, "scaleX", 0.8f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        this.p = animatorSet;
        animatorSet.playTogether(ofFloat, ofFloat2, ofFloat3);
        this.p.setDuration(250L);
        this.p.start();
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
        this.f22223c = view;
        if (this.f22222b.indexOfChild(view) < 0) {
            this.f22222b.removeAllViews();
            this.f22222b.addView(view, new RelativeLayout.LayoutParams(-1, -1));
        }
    }

    @Override // com.opos.mobad.n.f.a
    public void a(a.InterfaceC0458a interfaceC0458a) {
        this.l = interfaceC0458a;
        this.f22221a.a(interfaceC0458a);
    }

    @Override // com.opos.mobad.n.f.a
    public void a(com.opos.mobad.n.d.h hVar) {
        a.InterfaceC0458a interfaceC0458a;
        if (hVar == null) {
            com.opos.cmn.an.f.a.d("", "render builder with data null");
            interfaceC0458a = this.l;
            if (interfaceC0458a == null) {
                return;
            }
        } else {
            com.opos.mobad.n.d.d b2 = this.k ? hVar.b() : hVar.a();
            if (b2 != null) {
                a(b2.v);
                a(b2);
                if (this.o == null) {
                    e();
                }
                this.o = b2;
                return;
            }
            com.opos.cmn.an.f.a.d("InterstitialViewFrame", "render with data null");
            interfaceC0458a = this.l;
            if (interfaceC0458a == null) {
                return;
            }
        }
        interfaceC0458a.b(1);
    }

    @Override // com.opos.mobad.n.f.a
    public void b() {
        int i2 = this.f22230j;
        int i3 = i2 == 0 ? 320 : Downloads.Impl.STATUS_CANNOT_RESUME;
        int i4 = i2 == 0 ? 619 : 275;
        int a2 = com.opos.cmn.an.h.f.a.a(getContext(), i3);
        int a3 = com.opos.cmn.an.h.f.a.a(getContext(), i4);
        int width = this.f22222b.getWidth();
        int height = this.f22222b.getHeight();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f22222b, "scaleX", 1.0f, a2 / width);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f22222b, "scaleY", 1.0f, a3 / height);
        int i5 = this.f22230j;
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.f22225e, i5 == 1 ? "translationX" : "translationY", 0.0f, (i5 == 1 ? a2 - width : a3 - height) / 2);
        Interpolator create = PathInterpolatorCompat.create(0.33f, 0.0f, 0.67f, 1.0f);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.k ? this.f22226f : this.f22227g, "alpha", 1.0f, 0.0f);
        ofFloat4.setInterpolator(create);
        ofFloat4.setDuration(133L);
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.f22221a, "alpha", 1.0f, 0.0f);
        ofFloat5.setInterpolator(create);
        ofFloat5.setDuration(133L);
        Interpolator create2 = PathInterpolatorCompat.create(0.3f, 0.0f, 0.1f, 1.0f);
        ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(this.f22223c, "scaleX", 1.0f, 1.266f);
        ofFloat6.setInterpolator(create2);
        ObjectAnimator ofFloat7 = ObjectAnimator.ofFloat(this.f22223c, "scaleY", 1.0f, 1.266f);
        ofFloat7.setInterpolator(create2);
        ObjectAnimator ofFloat8 = ObjectAnimator.ofFloat(this.f22223c, "alpha", 1.0f, 0.0f);
        ofFloat8.setInterpolator(create);
        ofFloat5.setDuration(133L);
        AnimatorSet animatorSet = new AnimatorSet();
        this.r = animatorSet;
        animatorSet.playTogether(ofFloat, ofFloat2, ofFloat3, ofFloat6, ofFloat7);
        this.r.setDuration(267L);
        this.r.start();
        AnimatorSet animatorSet2 = new AnimatorSet();
        this.s = animatorSet2;
        animatorSet2.playTogether(ofFloat4, ofFloat5, ofFloat8);
        this.s.setDuration(133L);
        this.s.start();
        this.r.addListener(new AnimatorListenerAdapter() { // from class: com.opos.mobad.n.f.f.2

            /* renamed from: a */
            final /* synthetic */ int f22234a;

            /* renamed from: b */
            final /* synthetic */ int f22235b;

            /* renamed from: com.opos.mobad.n.f.f$2$1 */
            class AnonymousClass1 implements Runnable {
                AnonymousClass1() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                    f.this.a(a2, a3);
                }
            }

            AnonymousClass2(int a22, int a32) {
                a2 = a22;
                a3 = a32;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                f.this.r.removeListener(this);
                if (f.this.f22226f != null) {
                    f.this.f22226f.setVisibility(8);
                }
                if (f.this.f22227g != null) {
                    f.this.f22227g.setVisibility(8);
                }
                f.this.f22221a.setVisibility(8);
                com.opos.mobad.c.b.b.a(new Runnable() { // from class: com.opos.mobad.n.f.f.2.1
                    AnonymousClass1() {
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                        f.this.a(a2, a3);
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
        this.f22224d = view;
        if (this.f22228h.indexOfChild(view) < 0) {
            if (this.f22224d.getParent() != null) {
                ((ViewGroup) this.f22224d.getParent()).removeView(this.f22224d);
            }
            this.f22228h.addView(this.f22224d, new RelativeLayout.LayoutParams(-1, -1));
        }
    }
}
