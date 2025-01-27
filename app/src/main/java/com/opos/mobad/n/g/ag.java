package com.opos.mobad.n.g;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.heytap.msp.mobad.api.R;
import com.opos.mobad.n.a;

/* loaded from: classes4.dex */
public class ag extends RelativeLayout {

    /* renamed from: a */
    private int f22417a;

    /* renamed from: b */
    private int f22418b;

    /* renamed from: c */
    private RelativeLayout f22419c;

    /* renamed from: d */
    private View f22420d;

    /* renamed from: e */
    private int f22421e;

    /* renamed from: f */
    private View f22422f;

    /* renamed from: g */
    private ProgressBar f22423g;

    /* renamed from: h */
    private View f22424h;

    /* renamed from: i */
    private com.opos.mobad.c.c.a f22425i;

    /* renamed from: j */
    private String f22426j;
    private boolean k;
    private com.opos.mobad.c.c.b l;
    private a.InterfaceC0458a m;
    private a n;

    /* renamed from: com.opos.mobad.n.g.ag$1 */
    class AnonymousClass1 extends com.opos.mobad.n.c.g {
        AnonymousClass1() {
        }

        @Override // com.opos.mobad.n.c.g
        public void a(View view, int[] iArr) {
            if (ag.this.m != null) {
                ag.this.m.e(view, iArr);
            }
        }
    }

    /* renamed from: com.opos.mobad.n.g.ag$2 */
    class AnonymousClass2 implements com.opos.mobad.c.c.b {
        AnonymousClass2() {
        }

        @Override // com.opos.mobad.c.c.b
        public void a(int i2, String str) {
            com.opos.cmn.an.f.a.b("BlockVideoView", "onError:" + i2 + "," + str);
            if (ag.this.m != null) {
                ag.this.m.a(i2, str);
            }
        }

        @Override // com.opos.mobad.c.c.b
        public void c() {
            com.opos.cmn.an.f.a.b("InterstitialVideo", "onPrepare");
            if (ag.this.f22425i == null) {
                com.opos.cmn.an.f.a.b("BlockVideoView", "onPrepare mPlayer is null");
            } else if (ag.this.m != null) {
                ag.this.m.d(0L, ag.this.f22425i.c());
            }
        }

        @Override // com.opos.mobad.c.c.b
        public void d() {
            com.opos.cmn.an.f.a.b("BlockVideoView", "onStart");
            if (ag.this.f22425i == null) {
                com.opos.cmn.an.f.a.b("BlockVideoView", "onStart mPlayer is null");
                return;
            }
            if (ag.this.n != null) {
                ag.this.n.a();
            }
            ag.this.m.d(ag.this.f22425i.d(), ag.this.f22425i.c());
            ag.this.f22423g.setProgress(0);
            ag.this.f22424h.setVisibility(4);
            ag.this.k();
        }

        @Override // com.opos.mobad.c.c.b
        public void e() {
            com.opos.cmn.an.f.a.b("BlockVideoView", "onComplete");
            if (ag.this.f22425i == null) {
                com.opos.cmn.an.f.a.b("BlockVideoView", "onComplete mPlayer is null");
                return;
            }
            ag.this.f22424h.setVisibility(0);
            if (ag.this.m != null) {
                ag.this.m.a(ag.this.f22425i.d(), ag.this.f22425i.c());
            }
            if (ag.this.n != null) {
                ag.this.n.b();
            }
            if (ag.this.f22423g != null) {
                ag.this.f22423g.setProgress(100);
            }
        }

        @Override // com.opos.mobad.c.c.b
        public void f() {
            com.opos.cmn.an.f.a.b("BlockVideoView", "onResume");
            if (ag.this.f22425i == null) {
                com.opos.cmn.an.f.a.b("BlockVideoView", "onResume mPlayer is null");
                return;
            }
            ag.this.f22424h.setVisibility(4);
            ag.this.k = false;
            ag.this.k();
            if (ag.this.m != null) {
                ag.this.m.b(ag.this.f22425i.d(), ag.this.f22425i.c());
            }
        }

        @Override // com.opos.mobad.c.c.b
        public void g() {
            com.opos.cmn.an.f.a.b("BlockVideoView", "onPause");
            if (ag.this.f22425i == null) {
                com.opos.cmn.an.f.a.b("BlockVideoView", "onPause mPlayer is null");
                return;
            }
            ag.this.f22424h.setVisibility(0);
            if (ag.this.m == null || ag.this.f22425i == null) {
                return;
            }
            ag.this.m.c(ag.this.f22425i.d(), ag.this.f22425i.c());
        }

        @Override // com.opos.mobad.c.c.b
        public void h() {
            com.opos.cmn.an.f.a.b("BlockVideoView", "onBufferingStart");
            ag.this.l();
        }

        @Override // com.opos.mobad.c.c.b
        public void i() {
            com.opos.cmn.an.f.a.b("BlockVideoView", "onBufferingEnd");
            ag.this.k();
        }

        @Override // com.opos.mobad.c.c.b
        public void j() {
        }
    }

    public interface a {
        void a();

        void b();
    }

    private ag(Context context, int i2, int i3, com.opos.mobad.c.c.a aVar) {
        super(context);
        this.f22426j = "#4DFFFFFF";
        this.k = false;
        AnonymousClass2 anonymousClass2 = new com.opos.mobad.c.c.b() { // from class: com.opos.mobad.n.g.ag.2
            AnonymousClass2() {
            }

            @Override // com.opos.mobad.c.c.b
            public void a(int i22, String str) {
                com.opos.cmn.an.f.a.b("BlockVideoView", "onError:" + i22 + "," + str);
                if (ag.this.m != null) {
                    ag.this.m.a(i22, str);
                }
            }

            @Override // com.opos.mobad.c.c.b
            public void c() {
                com.opos.cmn.an.f.a.b("InterstitialVideo", "onPrepare");
                if (ag.this.f22425i == null) {
                    com.opos.cmn.an.f.a.b("BlockVideoView", "onPrepare mPlayer is null");
                } else if (ag.this.m != null) {
                    ag.this.m.d(0L, ag.this.f22425i.c());
                }
            }

            @Override // com.opos.mobad.c.c.b
            public void d() {
                com.opos.cmn.an.f.a.b("BlockVideoView", "onStart");
                if (ag.this.f22425i == null) {
                    com.opos.cmn.an.f.a.b("BlockVideoView", "onStart mPlayer is null");
                    return;
                }
                if (ag.this.n != null) {
                    ag.this.n.a();
                }
                ag.this.m.d(ag.this.f22425i.d(), ag.this.f22425i.c());
                ag.this.f22423g.setProgress(0);
                ag.this.f22424h.setVisibility(4);
                ag.this.k();
            }

            @Override // com.opos.mobad.c.c.b
            public void e() {
                com.opos.cmn.an.f.a.b("BlockVideoView", "onComplete");
                if (ag.this.f22425i == null) {
                    com.opos.cmn.an.f.a.b("BlockVideoView", "onComplete mPlayer is null");
                    return;
                }
                ag.this.f22424h.setVisibility(0);
                if (ag.this.m != null) {
                    ag.this.m.a(ag.this.f22425i.d(), ag.this.f22425i.c());
                }
                if (ag.this.n != null) {
                    ag.this.n.b();
                }
                if (ag.this.f22423g != null) {
                    ag.this.f22423g.setProgress(100);
                }
            }

            @Override // com.opos.mobad.c.c.b
            public void f() {
                com.opos.cmn.an.f.a.b("BlockVideoView", "onResume");
                if (ag.this.f22425i == null) {
                    com.opos.cmn.an.f.a.b("BlockVideoView", "onResume mPlayer is null");
                    return;
                }
                ag.this.f22424h.setVisibility(4);
                ag.this.k = false;
                ag.this.k();
                if (ag.this.m != null) {
                    ag.this.m.b(ag.this.f22425i.d(), ag.this.f22425i.c());
                }
            }

            @Override // com.opos.mobad.c.c.b
            public void g() {
                com.opos.cmn.an.f.a.b("BlockVideoView", "onPause");
                if (ag.this.f22425i == null) {
                    com.opos.cmn.an.f.a.b("BlockVideoView", "onPause mPlayer is null");
                    return;
                }
                ag.this.f22424h.setVisibility(0);
                if (ag.this.m == null || ag.this.f22425i == null) {
                    return;
                }
                ag.this.m.c(ag.this.f22425i.d(), ag.this.f22425i.c());
            }

            @Override // com.opos.mobad.c.c.b
            public void h() {
                com.opos.cmn.an.f.a.b("BlockVideoView", "onBufferingStart");
                ag.this.l();
            }

            @Override // com.opos.mobad.c.c.b
            public void i() {
                com.opos.cmn.an.f.a.b("BlockVideoView", "onBufferingEnd");
                ag.this.k();
            }

            @Override // com.opos.mobad.c.c.b
            public void j() {
            }
        };
        this.l = anonymousClass2;
        this.f22417a = i2 == 0 ? 256 : i2;
        this.f22418b = i3 == 0 ? 144 : i3;
        this.f22425i = aVar;
        aVar.a(anonymousClass2);
        a(context);
    }

    public static ag a(Context context, int i2, int i3, com.opos.mobad.c.c.a aVar) {
        return new ag(context, i2, i3, aVar);
    }

    private void a(Context context) {
        setLayoutParams(new ViewGroup.LayoutParams(this.f22417a, this.f22418b));
        this.f22421e = View.generateViewId();
        RelativeLayout relativeLayout = new RelativeLayout(context);
        this.f22419c = relativeLayout;
        relativeLayout.setId(this.f22421e);
        addView(this.f22419c, new RelativeLayout.LayoutParams(this.f22417a, this.f22418b));
        this.f22419c.setBackgroundColor(-16777216);
        this.f22420d = this.f22425i.b();
        this.f22425i.d(-16777216);
        this.f22420d.setBackgroundColor(-16777216);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.f22417a, this.f22418b);
        layoutParams.addRule(13);
        this.f22419c.addView(this.f22420d, layoutParams);
        View view = new View(context);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(7, this.f22421e);
        layoutParams2.addRule(5, this.f22421e);
        layoutParams2.addRule(6, this.f22421e);
        layoutParams2.addRule(8, this.f22421e);
        this.f22419c.addView(view, layoutParams2);
        AnonymousClass1 anonymousClass1 = new com.opos.mobad.n.c.g() { // from class: com.opos.mobad.n.g.ag.1
            AnonymousClass1() {
            }

            @Override // com.opos.mobad.n.c.g
            public void a(View view2, int[] iArr) {
                if (ag.this.m != null) {
                    ag.this.m.e(view2, iArr);
                }
            }
        };
        view.setOnTouchListener(anonymousClass1);
        view.setOnClickListener(anonymousClass1);
        this.f22422f = new ProgressBar(context);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(context, 20.0f), com.opos.cmn.an.h.f.a.a(context, 29.0f));
        layoutParams3.addRule(13);
        this.f22422f.setVisibility(0);
        this.f22419c.addView(this.f22422f, layoutParams3);
        View view2 = new View(context);
        this.f22424h = view2;
        view2.setBackground(context.getResources().getDrawable(R.drawable.opos_mobad_continue_bn));
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(context, 42.0f), com.opos.cmn.an.h.f.a.a(context, 42.0f));
        layoutParams4.addRule(13);
        this.f22424h.setVisibility(4);
        this.f22419c.addView(this.f22424h, layoutParams4);
        ProgressBar progressBar = new ProgressBar(context);
        this.f22423g = progressBar;
        progressBar.setId(View.generateViewId());
        com.opos.mobad.n.c.m.a(this.f22423g, "mOnlyIndeterminate", new Boolean(false));
        this.f22423g.setIndeterminate(false);
        this.f22423g.setProgressDrawable(new ClipDrawable(new ColorDrawable(getResources().getColor(R.color.opos_mobad_video_progress_color)), 3, 1));
        this.f22423g.setBackgroundColor(Color.parseColor(this.f22426j));
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(this.f22417a, com.opos.cmn.an.h.f.a.a(context, 2.0f));
        layoutParams5.addRule(12);
        this.f22423g.setVisibility(0);
        this.f22419c.addView(this.f22423g, layoutParams5);
    }

    private void j() {
        if (this.f22425i == null) {
            com.opos.cmn.an.f.a.b("BlockVideoView", "mPlayer is null");
            return;
        }
        this.f22424h.setVisibility(4);
        this.f22425i.a(0L);
        this.f22425i.e();
        a aVar = this.n;
        if (aVar != null) {
            aVar.a();
        }
    }

    public void k() {
        this.f22422f.setVisibility(8);
    }

    public void l() {
        this.f22422f.setVisibility(0);
    }

    public void a() {
        com.opos.mobad.c.c.a aVar = this.f22425i;
        if (aVar == null) {
            com.opos.cmn.an.f.a.b("BlockVideoView", "stop mPlayer is null");
            return;
        }
        this.k = true;
        int i2 = aVar.i();
        com.opos.mobad.c.c.a aVar2 = this.f22425i;
        if (i2 == 2) {
            aVar2.f();
        }
    }

    public void a(int i2) {
        com.opos.mobad.c.c.a aVar = this.f22425i;
        if (aVar == null) {
            return;
        }
        aVar.a(i2 == 1 ? 1.0f : 0.0f);
    }

    public void a(a.InterfaceC0458a interfaceC0458a) {
        com.opos.cmn.an.f.a.b("BlockVideoView", "setListener " + interfaceC0458a);
        this.m = interfaceC0458a;
    }

    public void a(com.opos.mobad.n.d.e eVar) {
        com.opos.mobad.c.c.a aVar = this.f22425i;
        if (aVar == null) {
            com.opos.cmn.an.f.a.b("BlockVideoView", "mPlayer is null");
        } else {
            aVar.a(eVar.f22079a.f22084a, false);
            a(eVar.B);
        }
    }

    public void a(a aVar) {
        this.n = aVar;
    }

    public void b() {
        com.opos.mobad.c.c.a aVar = this.f22425i;
        if (aVar == null) {
            com.opos.cmn.an.f.a.b("BlockVideoView", "stop mPlayer is null");
            return;
        }
        try {
            int i2 = aVar.i();
            com.opos.mobad.c.c.a aVar2 = this.f22425i;
            if (i2 == 3) {
                aVar2.g();
            } else if (i2 == 5) {
                j();
            }
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.a("BlockVideoView", "", (Throwable) e2);
        }
    }

    public void c() {
        com.opos.mobad.c.c.a aVar = this.f22425i;
        if (aVar != null) {
            aVar.f();
            this.f22425i.h();
            this.f22425i = null;
        }
    }

    public void d() {
        String str;
        com.opos.mobad.c.c.a aVar = this.f22425i;
        if (aVar == null) {
            str = "mPlayer is null";
        } else {
            if (aVar.i() == 5) {
                return;
            }
            if (this.f22425i.i() != 3 || !this.k) {
                this.f22425i.g();
                return;
            }
            str = "resume but user pause";
        }
        com.opos.cmn.an.f.a.b("BlockVideoView", str);
    }

    public void e() {
        com.opos.mobad.c.c.a aVar = this.f22425i;
        if (aVar != null) {
            aVar.f();
        }
    }

    public void f() {
        ProgressBar progressBar;
        if (this.f22425i == null || (progressBar = this.f22423g) == null) {
            return;
        }
        progressBar.setProgress(i());
        com.opos.cmn.an.f.a.b("BlockVideoView", "on progress" + this.f22423g.getProgress());
    }

    public int g() {
        com.opos.mobad.c.c.a aVar = this.f22425i;
        if (aVar == null) {
            return 0;
        }
        return (int) aVar.d();
    }

    public int h() {
        com.opos.mobad.c.c.a aVar = this.f22425i;
        if (aVar == null) {
            return 0;
        }
        return (int) aVar.c();
    }

    public int i() {
        com.opos.mobad.c.c.a aVar = this.f22425i;
        if (aVar == null || 0 == aVar.c()) {
            return 0;
        }
        return (int) Math.min(100L, Math.max(0L, (this.f22425i.d() * 100) / this.f22425i.c()));
    }
}
