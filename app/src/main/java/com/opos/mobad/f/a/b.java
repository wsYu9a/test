package com.opos.mobad.f.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.opos.mobad.f.a.i;

/* loaded from: classes4.dex */
public class b {

    /* renamed from: a */
    private static final String f20642a = "b";

    /* renamed from: b */
    private Context f20643b;

    /* renamed from: c */
    private LinearLayout f20644c;

    /* renamed from: d */
    private i f20645d;

    /* renamed from: e */
    private int f20646e;

    /* renamed from: f */
    private int f20647f;

    /* renamed from: i */
    private a f20650i;

    /* renamed from: g */
    private volatile boolean f20648g = false;

    /* renamed from: h */
    private volatile boolean f20649h = false;

    /* renamed from: j */
    private Animation.AnimationListener f20651j = new Animation.AnimationListener() { // from class: com.opos.mobad.f.a.b.1

        /* renamed from: com.opos.mobad.f.a.b$1$1 */
        class RunnableC04441 implements Runnable {
            RunnableC04441() {
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.i();
            }
        }

        AnonymousClass1() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            com.opos.mobad.service.c.a(new Runnable() { // from class: com.opos.mobad.f.a.b.1.1
                RunnableC04441() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    b.this.i();
                }
            });
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    };

    /* renamed from: com.opos.mobad.f.a.b$1 */
    class AnonymousClass1 implements Animation.AnimationListener {

        /* renamed from: com.opos.mobad.f.a.b$1$1 */
        class RunnableC04441 implements Runnable {
            RunnableC04441() {
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.i();
            }
        }

        AnonymousClass1() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            com.opos.mobad.service.c.a(new Runnable() { // from class: com.opos.mobad.f.a.b.1.1
                RunnableC04441() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    b.this.i();
                }
            });
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    public class a implements i.a {

        /* renamed from: a */
        i.a f20654a;

        public a(i.a aVar) {
            this.f20654a = aVar;
        }

        @Override // com.opos.mobad.f.a.i.a
        public void a(int i2, int i3) {
            b.this.f20647f = i3;
            b.this.f20646e = i2;
            b.this.f20648g = true;
            i.a aVar = this.f20654a;
            if (aVar != null) {
                aVar.a(i2, i3);
            }
        }
    }

    public b(Context context, i.a aVar) {
        this.f20643b = context.getApplicationContext();
        this.f20644c = new LinearLayout(this.f20643b);
        int b2 = com.opos.cmn.an.h.f.a.b(this.f20643b);
        int a2 = com.opos.cmn.an.h.f.a.a(this.f20643b, 60.0f);
        this.f20646e = b2;
        this.f20647f = a2;
        this.f20645d = new i(this.f20643b, new i.b(b2, b2 / 2, b2 / a2));
        a aVar2 = new a(aVar);
        this.f20650i = aVar2;
        this.f20645d.a(aVar2);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 81;
        this.f20644c.addView(this.f20645d, layoutParams);
        this.f20644c.setGravity(81);
        e();
        FrameLayout frameLayout = new FrameLayout(this.f20643b);
        FrameLayout frameLayout2 = new FrameLayout(this.f20643b);
        this.f20645d.addView(frameLayout, new FrameLayout.LayoutParams(-1, -1));
        this.f20645d.addView(frameLayout2, new FrameLayout.LayoutParams(-1, -1));
    }

    private void d() {
        if (this.f20648g) {
            e();
            this.f20648g = false;
        }
    }

    private void e() {
        if (this.f20645d != null) {
            f();
            this.f20645d.setInAnimation(g());
            this.f20645d.setOutAnimation(h());
        }
    }

    private void f() {
        i iVar = this.f20645d;
        if (iVar != null) {
            if (iVar.getInAnimation() != null) {
                this.f20645d.getInAnimation().setAnimationListener(null);
                this.f20645d.getInAnimation().cancel();
            }
            if (this.f20645d.getOutAnimation() != null) {
                this.f20645d.getOutAnimation().cancel();
            }
        }
    }

    private Animation g() {
        TranslateAnimation translateAnimation = new TranslateAnimation(this.f20646e, 0.0f, 0.0f, 0.0f);
        translateAnimation.setDuration(1000L);
        translateAnimation.setAnimationListener(this.f20651j);
        return translateAnimation;
    }

    private Animation h() {
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, this.f20646e * (-1), 0.0f, 0.0f);
        translateAnimation.setDuration(1000L);
        return translateAnimation;
    }

    public void i() {
        i iVar = this.f20645d;
        if (iVar == null || iVar.getNextView() == null) {
            return;
        }
        ((ViewGroup) this.f20645d.getNextView()).removeAllViews();
    }

    public View a() {
        return this.f20644c;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(android.view.View r6) {
        /*
            r5 = this;
            java.lang.String r0 = com.opos.mobad.f.a.b.f20642a
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "show banner view:"
            r1.append(r2)
            r1.append(r6)
            java.lang.String r1 = r1.toString()
            com.opos.cmn.an.f.a.b(r0, r1)
            if (r6 == 0) goto L73
            boolean r0 = r5.f20649h
            if (r0 == 0) goto L1d
            goto L73
        L1d:
            r5.d()
            com.opos.mobad.f.a.i r0 = r5.f20645d
            android.view.View r0 = r0.getCurrentView()
            android.view.ViewGroup r0 = (android.view.ViewGroup) r0
            int r1 = r0.getChildCount()
            r2 = 0
            if (r1 <= 0) goto L3e
            android.view.View r1 = r0.getChildAt(r2)
            if (r1 == r6) goto L3e
            com.opos.mobad.f.a.i r0 = r5.f20645d
            android.view.View r0 = r0.getNextView()
            android.view.ViewGroup r0 = (android.view.ViewGroup) r0
            r2 = 1
        L3e:
            android.widget.FrameLayout$LayoutParams r1 = new android.widget.FrameLayout$LayoutParams
            r3 = -1
            r4 = -2
            r1.<init>(r3, r4)
            r3 = 17
            r1.gravity = r3
            android.view.ViewParent r3 = r6.getParent()
            if (r3 == 0) goto L66
            android.view.ViewParent r3 = r6.getParent()
            if (r3 == r0) goto L6c
            android.view.ViewParent r3 = r6.getParent()
            boolean r3 = r3 instanceof android.view.ViewGroup
            if (r3 == 0) goto L73
            android.view.ViewParent r3 = r6.getParent()
            android.view.ViewGroup r3 = (android.view.ViewGroup) r3
            r3.removeView(r6)
        L66:
            r0.removeAllViews()
            r0.addView(r6, r1)
        L6c:
            if (r2 == 0) goto L73
            com.opos.mobad.f.a.i r6 = r5.f20645d
            r6.showNext()
        L73:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.mobad.f.a.b.a(android.view.View):void");
    }

    public void b() {
        this.f20649h = true;
        this.f20645d.a(null);
        this.f20644c.removeAllViews();
    }

    public boolean c() {
        LinearLayout linearLayout = this.f20644c;
        if (linearLayout != null && linearLayout.isShown() && com.opos.cmn.i.j.a(this.f20643b) && this.f20644c.hasWindowFocus()) {
            com.opos.cmn.an.f.a.b(f20642a, "isBannerShown");
            return true;
        }
        com.opos.cmn.an.f.a.b(f20642a, "isBanner not Shown");
        return false;
    }
}
