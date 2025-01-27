package com.opos.mobad.n.a;

import android.animation.Animator;
import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.heytap.msp.mobad.api.R;

/* loaded from: classes4.dex */
public class o implements f {

    /* renamed from: a */
    private boolean f21855a = false;

    /* renamed from: b */
    private com.opos.mobad.n.c.h f21856b;

    /* renamed from: c */
    private com.opos.mobad.n.c.e f21857c;

    /* renamed from: d */
    private Context f21858d;

    /* renamed from: e */
    private RelativeLayout f21859e;

    /* renamed from: f */
    private TextView f21860f;

    /* renamed from: g */
    private Animator f21861g;

    /* renamed from: h */
    private Animator f21862h;

    /* renamed from: i */
    private Animator f21863i;

    /* renamed from: j */
    private Animator f21864j;
    private m k;
    private RelativeLayout l;

    /* renamed from: com.opos.mobad.n.a.o$1 */
    class AnonymousClass1 implements Animator.AnimatorListener {
        AnonymousClass1() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (o.this.k == m.BREATH) {
                o.this.i();
            } else if (o.this.k == m.SPLASH) {
                o.this.j();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    public o(Context context, m mVar) {
        this.f21858d = context;
        this.k = mVar;
        this.l = new RelativeLayout(this.f21858d);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, com.opos.cmn.an.h.f.a.a(this.f21858d, 96.0f));
        this.f21859e = new RelativeLayout(context);
        layoutParams.addRule(13);
        this.l.addView(this.f21859e, layoutParams);
        g();
        h();
    }

    private void g() {
        TextView a2 = q.a(this.f21858d);
        this.f21860f = a2;
        a2.setId(View.generateViewId());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.f21858d, 324.0f), com.opos.cmn.an.h.f.a.a(this.f21858d, 66.0f));
        layoutParams.addRule(13);
        this.f21859e.addView(this.f21860f, layoutParams);
        if (this.k == m.BREATH) {
            this.f21857c = new com.opos.mobad.n.c.e(this.f21858d);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.f21858d, 346.0f), com.opos.cmn.an.h.f.a.a(this.f21858d, 88.0f));
            layoutParams2.addRule(13);
            this.f21857c.setImageResource(R.drawable.opos_mobad_btn_fading);
            this.f21857c.setScaleType(ImageView.ScaleType.FIT_CENTER);
            this.f21857c.b(com.opos.cmn.an.h.f.a.a(this.f21858d, 88.0f));
            this.f21857c.a(com.opos.cmn.an.h.f.a.a(this.f21858d, 30.0f));
            this.f21859e.addView(this.f21857c, layoutParams2);
        }
    }

    @TargetApi(21)
    private void h() {
        if (Build.VERSION.SDK_INT < 21) {
            return;
        }
        this.f21856b = new com.opos.mobad.n.c.h(this.f21858d);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(5, this.f21860f.getId());
        layoutParams.addRule(7, this.f21860f.getId());
        layoutParams.addRule(6, this.f21860f.getId());
        layoutParams.addRule(8, this.f21860f.getId());
        layoutParams.addRule(13);
        this.f21856b.setBackgroundColor(0);
        this.f21856b.a(com.opos.cmn.an.h.f.a.a(this.f21858d, 60.0f));
        this.f21859e.addView(this.f21856b, layoutParams);
    }

    public void i() {
        if (this.f21863i == null) {
            Animator a2 = n.a(this.f21857c);
            this.f21863i = a2;
            a2.start();
        }
    }

    public void j() {
        if (this.f21862h == null) {
            Animator a2 = n.a((RelativeLayout) this.f21856b);
            this.f21862h = a2;
            a2.start();
        }
    }

    @Override // com.opos.mobad.n.a.f
    public View a() {
        return this.l;
    }

    @Override // com.opos.mobad.n.a.f
    public void a(com.opos.mobad.n.c.g gVar) {
        this.f21860f.setOnTouchListener(gVar);
        this.f21860f.setOnClickListener(gVar);
    }

    @Override // com.opos.mobad.n.a.f
    public void a(String str, int i2, int i3) {
        this.f21860f.setText(str);
    }

    @Override // com.opos.mobad.n.a.f
    public void b() {
        if (Build.VERSION.SDK_INT >= 21 && this.k != m.NONE) {
            Animator animator = this.f21861g;
            if (animator == null || !animator.isRunning()) {
                if (this.f21864j == null) {
                    this.f21864j = n.c(this.l);
                }
                this.f21864j.start();
            }
        }
    }

    @Override // com.opos.mobad.n.a.f
    public void c() {
        if (Build.VERSION.SDK_INT < 21 || this.k == m.NONE || this.f21855a) {
            return;
        }
        this.f21855a = true;
        Animator a2 = n.a((View) this.l);
        this.f21861g = a2;
        a2.addListener(new Animator.AnimatorListener() { // from class: com.opos.mobad.n.a.o.1
            AnonymousClass1() {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (o.this.k == m.BREATH) {
                    o.this.i();
                } else if (o.this.k == m.SPLASH) {
                    o.this.j();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        });
        this.f21861g.start();
    }

    @Override // com.opos.mobad.n.a.f
    public void d() {
    }

    @Override // com.opos.mobad.n.a.f
    public void e() {
    }

    @Override // com.opos.mobad.n.a.f
    public void f() {
        Animator animator = this.f21861g;
        if (animator != null) {
            animator.end();
        }
        Animator animator2 = this.f21863i;
        if (animator2 != null) {
            animator2.end();
        }
        Animator animator3 = this.f21862h;
        if (animator3 != null) {
            animator3.end();
        }
        Animator animator4 = this.f21864j;
        if (animator4 != null) {
            animator4.end();
        }
    }
}
