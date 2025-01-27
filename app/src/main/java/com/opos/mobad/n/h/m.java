package com.opos.mobad.n.h;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

/* loaded from: classes4.dex */
public class m extends RelativeLayout {

    /* renamed from: a */
    private RelativeLayout f22897a;

    /* renamed from: b */
    private View f22898b;

    /* renamed from: c */
    private int f22899c;

    /* renamed from: d */
    private View f22900d;

    /* renamed from: e */
    private com.opos.mobad.c.c.a f22901e;

    /* renamed from: f */
    private boolean f22902f;

    /* renamed from: g */
    private com.opos.mobad.c.c.b f22903g;

    /* renamed from: h */
    private a f22904h;

    /* renamed from: com.opos.mobad.n.h.m$1 */
    class AnonymousClass1 extends com.opos.mobad.n.c.g {
        AnonymousClass1() {
        }

        @Override // com.opos.mobad.n.c.g
        public void a(View view, int[] iArr) {
            if (m.this.f22904h != null) {
                m.this.f22904h.e(view, iArr);
            }
        }
    }

    /* renamed from: com.opos.mobad.n.h.m$2 */
    class AnonymousClass2 implements com.opos.mobad.c.c.b {
        AnonymousClass2() {
        }

        @Override // com.opos.mobad.c.c.b
        public void a(int i2, String str) {
            com.opos.cmn.an.f.a.b("RewardVideoView", "onError:" + i2 + "," + str);
            if (m.this.f22904h != null) {
                m.this.f22904h.a(i2, str);
            }
        }

        @Override // com.opos.mobad.c.c.b
        public void c() {
            com.opos.cmn.an.f.a.b("RewardVideoView", "onPrepare");
            if (m.this.f22904h != null) {
                m.this.f22904h.e();
            }
        }

        @Override // com.opos.mobad.c.c.b
        public void d() {
            com.opos.cmn.an.f.a.b("RewardVideoView", "onStart");
            if (m.this.f22904h != null) {
                m.this.f22904h.d(0L, m.this.f22901e != null ? m.this.f22901e.c() : 0L);
            }
            m.this.h();
        }

        @Override // com.opos.mobad.c.c.b
        public void e() {
            com.opos.cmn.an.f.a.b("RewardVideoView", "onComplete");
            if (m.this.f22901e == null || m.this.f22904h == null) {
                return;
            }
            m.this.f22904h.a(m.this.f22901e.c(), m.this.f22901e.c());
        }

        @Override // com.opos.mobad.c.c.b
        public void f() {
            com.opos.cmn.an.f.a.b("RewardVideoView", "onResume");
            m.this.h();
            if (m.this.f22904h == null || m.this.f22901e == null) {
                return;
            }
            m.this.f22904h.b(m.this.f22901e.d(), m.this.f22901e.c());
        }

        @Override // com.opos.mobad.c.c.b
        public void g() {
            com.opos.cmn.an.f.a.b("RewardVideoView", "onPause");
            if (m.this.f22904h == null || m.this.f22901e == null) {
                return;
            }
            m.this.f22904h.c(m.this.f22901e.d(), m.this.f22901e.c());
        }

        @Override // com.opos.mobad.c.c.b
        public void h() {
            com.opos.cmn.an.f.a.b("RewardVideoView", "onBufferingStart");
            m.this.i();
        }

        @Override // com.opos.mobad.c.c.b
        public void i() {
            com.opos.cmn.an.f.a.b("RewardVideoView", "onBufferingEnd");
            m.this.h();
        }

        @Override // com.opos.mobad.c.c.b
        public void j() {
            if (m.this.f22904h != null) {
                m.this.f22904h.a();
            }
        }
    }

    private m(Context context, com.opos.mobad.c.c.a aVar) {
        super(context);
        this.f22902f = false;
        AnonymousClass2 anonymousClass2 = new com.opos.mobad.c.c.b() { // from class: com.opos.mobad.n.h.m.2
            AnonymousClass2() {
            }

            @Override // com.opos.mobad.c.c.b
            public void a(int i2, String str) {
                com.opos.cmn.an.f.a.b("RewardVideoView", "onError:" + i2 + "," + str);
                if (m.this.f22904h != null) {
                    m.this.f22904h.a(i2, str);
                }
            }

            @Override // com.opos.mobad.c.c.b
            public void c() {
                com.opos.cmn.an.f.a.b("RewardVideoView", "onPrepare");
                if (m.this.f22904h != null) {
                    m.this.f22904h.e();
                }
            }

            @Override // com.opos.mobad.c.c.b
            public void d() {
                com.opos.cmn.an.f.a.b("RewardVideoView", "onStart");
                if (m.this.f22904h != null) {
                    m.this.f22904h.d(0L, m.this.f22901e != null ? m.this.f22901e.c() : 0L);
                }
                m.this.h();
            }

            @Override // com.opos.mobad.c.c.b
            public void e() {
                com.opos.cmn.an.f.a.b("RewardVideoView", "onComplete");
                if (m.this.f22901e == null || m.this.f22904h == null) {
                    return;
                }
                m.this.f22904h.a(m.this.f22901e.c(), m.this.f22901e.c());
            }

            @Override // com.opos.mobad.c.c.b
            public void f() {
                com.opos.cmn.an.f.a.b("RewardVideoView", "onResume");
                m.this.h();
                if (m.this.f22904h == null || m.this.f22901e == null) {
                    return;
                }
                m.this.f22904h.b(m.this.f22901e.d(), m.this.f22901e.c());
            }

            @Override // com.opos.mobad.c.c.b
            public void g() {
                com.opos.cmn.an.f.a.b("RewardVideoView", "onPause");
                if (m.this.f22904h == null || m.this.f22901e == null) {
                    return;
                }
                m.this.f22904h.c(m.this.f22901e.d(), m.this.f22901e.c());
            }

            @Override // com.opos.mobad.c.c.b
            public void h() {
                com.opos.cmn.an.f.a.b("RewardVideoView", "onBufferingStart");
                m.this.i();
            }

            @Override // com.opos.mobad.c.c.b
            public void i() {
                com.opos.cmn.an.f.a.b("RewardVideoView", "onBufferingEnd");
                m.this.h();
            }

            @Override // com.opos.mobad.c.c.b
            public void j() {
                if (m.this.f22904h != null) {
                    m.this.f22904h.a();
                }
            }
        };
        this.f22903g = anonymousClass2;
        this.f22901e = aVar;
        aVar.a(anonymousClass2);
        a(context);
    }

    public static m a(Context context, com.opos.mobad.c.c.a aVar) {
        return new m(context, aVar);
    }

    private void a(Context context) {
        setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.f22899c = View.generateViewId();
        RelativeLayout relativeLayout = new RelativeLayout(context);
        this.f22897a = relativeLayout;
        relativeLayout.setId(this.f22899c);
        addView(this.f22897a, new RelativeLayout.LayoutParams(-1, -1));
        this.f22898b = this.f22901e.b();
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(13);
        this.f22897a.addView(this.f22898b, layoutParams);
        View view = new View(context);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(7, this.f22899c);
        layoutParams2.addRule(5, this.f22899c);
        layoutParams2.addRule(6, this.f22899c);
        layoutParams2.addRule(8, this.f22899c);
        this.f22897a.addView(view, layoutParams2);
        AnonymousClass1 anonymousClass1 = new com.opos.mobad.n.c.g() { // from class: com.opos.mobad.n.h.m.1
            AnonymousClass1() {
            }

            @Override // com.opos.mobad.n.c.g
            public void a(View view2, int[] iArr) {
                if (m.this.f22904h != null) {
                    m.this.f22904h.e(view2, iArr);
                }
            }
        };
        view.setOnTouchListener(anonymousClass1);
        view.setOnClickListener(anonymousClass1);
        this.f22900d = new ProgressBar(context);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(context, 20.0f), com.opos.cmn.an.h.f.a.a(context, 29.0f));
        layoutParams3.addRule(13);
        this.f22900d.setVisibility(0);
        this.f22897a.addView(this.f22900d, layoutParams3);
    }

    public void h() {
        this.f22900d.setVisibility(8);
    }

    public void i() {
        this.f22900d.setVisibility(0);
    }

    public void a() {
        com.opos.mobad.c.c.a aVar = this.f22901e;
        if (aVar == null) {
            com.opos.cmn.an.f.a.b("RewardVideoView", "stop mPlayer is null");
            return;
        }
        this.f22902f = true;
        int i2 = aVar.i();
        com.opos.mobad.c.c.a aVar2 = this.f22901e;
        if (i2 == 2) {
            aVar2.f();
        }
    }

    public void a(int i2) {
        com.opos.mobad.c.c.a aVar = this.f22901e;
        if (aVar == null) {
            return;
        }
        aVar.a(i2 == 1 ? 1.0f : 0.0f);
    }

    public void a(com.opos.mobad.n.d.e eVar) {
        com.opos.mobad.c.c.a aVar = this.f22901e;
        if (aVar == null) {
            com.opos.cmn.an.f.a.b("RewardVideoView", "mPlayer is null");
        } else {
            aVar.a(eVar.f22079a.f22084a, false);
            a(eVar.B);
        }
    }

    public void a(a aVar) {
        com.opos.cmn.an.f.a.b("RewardVideoView", "setListener " + aVar);
        this.f22904h = aVar;
    }

    public com.opos.mobad.c.c.a b() {
        return this.f22901e;
    }

    public void c() {
        if (this.f22901e == null) {
            com.opos.cmn.an.f.a.b("RewardVideoView", "stop mPlayer is null");
        } else {
            e();
        }
    }

    public void d() {
        com.opos.mobad.c.c.a aVar = this.f22901e;
        if (aVar != null) {
            aVar.f();
            this.f22901e.h();
            this.f22901e = null;
        }
    }

    public void e() {
        com.opos.mobad.c.c.a aVar = this.f22901e;
        if (aVar == null) {
            com.opos.cmn.an.f.a.b("RewardVideoView", "mPlayer is null");
        } else if (aVar.i() != 5) {
            this.f22901e.g();
        }
    }

    public int f() {
        com.opos.mobad.c.c.a aVar = this.f22901e;
        if (aVar != null) {
            try {
                return (int) aVar.d();
            } catch (Exception unused) {
            }
        }
        return 0;
    }

    public int g() {
        com.opos.mobad.c.c.a aVar = this.f22901e;
        if (aVar != null) {
            try {
                return (int) aVar.c();
            } catch (Exception unused) {
            }
        }
        return 0;
    }
}
