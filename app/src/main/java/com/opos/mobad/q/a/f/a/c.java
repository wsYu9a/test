package com.opos.mobad.q.a.f.a;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.opos.cmn.i.m;
import com.opos.cmn.j.b;
import com.opos.mobad.e.a.g;
import com.opos.mobad.e.a.h;
import com.opos.mobad.e.a.l;
import com.opos.mobad.e.a.n;
import com.opos.mobad.n.a;
import com.opos.mobad.q.a.i;
import java.util.List;
import java.util.Map;

/* loaded from: classes4.dex */
public class c implements com.opos.mobad.n.a {

    /* renamed from: b */
    private Context f23266b;

    /* renamed from: c */
    private a.InterfaceC0458a f23267c;

    /* renamed from: d */
    private RelativeLayout f23268d;

    /* renamed from: e */
    private FrameLayout f23269e;

    /* renamed from: f */
    private g f23270f;

    /* renamed from: h */
    private String f23272h;

    /* renamed from: i */
    private int f23273i;

    /* renamed from: j */
    private com.opos.mobad.n.d.g f23274j;

    /* renamed from: a */
    private String f23265a = "#c0000000";

    /* renamed from: g */
    private m f23271g = new m(com.opos.mobad.service.c.a(), new Runnable() { // from class: com.opos.mobad.q.a.f.a.c.1
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.opos.cmn.an.f.a.b("InteractiveFloatLayout", "render timeout");
        }
    });

    /* renamed from: com.opos.mobad.q.a.f.a.c$1 */
    class AnonymousClass1 implements Runnable {
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.opos.cmn.an.f.a.b("InteractiveFloatLayout", "render timeout");
        }
    }

    /* renamed from: com.opos.mobad.q.a.f.a.c$2 */
    class AnonymousClass2 implements b.a {
        AnonymousClass2() {
        }

        @Override // com.opos.cmn.j.b.a
        public void a(boolean z) {
            if (c.this.f23270f == null) {
                return;
            }
            if (z) {
                c.this.f23270f.c();
            } else {
                c.this.f23270f.b();
            }
        }
    }

    /* renamed from: com.opos.mobad.q.a.f.a.c$3 */
    class AnonymousClass3 extends i {
        AnonymousClass3() {
        }

        @Override // com.opos.mobad.q.a.i
        public void a(View view, int[] iArr) {
            if (c.this.f23267c != null) {
                c.this.f23267c.d(view, (int[]) null);
            }
        }
    }

    /* renamed from: com.opos.mobad.q.a.f.a.c$4 */
    class AnonymousClass4 extends i {
        AnonymousClass4() {
        }

        @Override // com.opos.mobad.q.a.i
        public void a(View view, int[] iArr) {
            if (c.this.f23267c != null) {
                c.this.f23267c.j(view, iArr);
            }
        }
    }

    /* renamed from: com.opos.mobad.q.a.f.a.c$5 */
    class AnonymousClass5 implements h {

        /* renamed from: a */
        final /* synthetic */ com.opos.mobad.n.d.f f23279a;

        /* renamed from: com.opos.mobad.q.a.f.a.c$5$1 */
        class AnonymousClass1 implements Runnable {

            /* renamed from: a */
            final /* synthetic */ String f23281a;

            AnonymousClass1(String str) {
                str2 = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                AnonymousClass5 anonymousClass5 = AnonymousClass5.this;
                c.this.b(fVar, str2);
            }
        }

        AnonymousClass5(com.opos.mobad.n.d.f fVar) {
            fVar = fVar;
        }

        @Override // com.opos.mobad.e.a.h
        public void a(boolean z, String str) {
            if (z) {
                com.opos.mobad.service.c.a(new Runnable() { // from class: com.opos.mobad.q.a.f.a.c.5.1

                    /* renamed from: a */
                    final /* synthetic */ String f23281a;

                    AnonymousClass1(String str2) {
                        str2 = str2;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        AnonymousClass5 anonymousClass5 = AnonymousClass5.this;
                        c.this.b(fVar, str2);
                    }
                });
            } else {
                com.opos.cmn.an.f.a.b("InteractiveFloatLayout", "prepare fail");
            }
        }
    }

    /* renamed from: com.opos.mobad.q.a.f.a.c$6 */
    class AnonymousClass6 implements com.opos.mobad.e.a.i {
        AnonymousClass6() {
        }

        @Override // com.opos.mobad.e.a.i
        public void a(Map map) {
            com.opos.cmn.an.f.a.b("InteractiveFloatLayout", "load success");
            c.this.f23271g.a();
        }

        @Override // com.opos.mobad.e.a.i
        public void a(Map map, String str) {
            com.opos.cmn.an.f.a.b("InteractiveFloatLayout", "load fail :" + str);
        }
    }

    /* renamed from: com.opos.mobad.q.a.f.a.c$7 */
    class AnonymousClass7 implements com.opos.mobad.e.a.a {
        AnonymousClass7() {
        }

        @Override // com.opos.mobad.e.a.a
        public void a(Map map, String str, l lVar, int i2, String str2, int i3) {
            int[] iArr = {lVar.f20510c, lVar.f20511d, lVar.f20513f, lVar.f20514g};
            if (i2 == 0) {
                if (c.this.f23267c != null) {
                    c.this.f23267c.k(c.this.f23269e, iArr);
                }
            } else if (1 == i2) {
                if (c.this.f23267c != null) {
                    c.this.f23267c.j(c.this.f23269e, iArr);
                }
            } else {
                com.opos.cmn.an.f.a.b("InteractiveFloatLayout", "unknown click:" + i2);
            }
        }

        @Override // com.opos.mobad.e.a.a
        public void a(Map map, String str, l lVar, String str2, int i2) {
        }
    }

    public c(Context context, int i2, a.InterfaceC0458a interfaceC0458a) {
        this.f23266b = context;
        this.f23267c = interfaceC0458a;
        this.f23273i = i2;
        RelativeLayout relativeLayout = new RelativeLayout(context);
        this.f23268d = relativeLayout;
        relativeLayout.setBackgroundColor(Color.parseColor(this.f23265a));
        com.opos.cmn.j.b bVar = new com.opos.cmn.j.b(this.f23266b);
        bVar.a(new b.a() { // from class: com.opos.mobad.q.a.f.a.c.2
            AnonymousClass2() {
            }

            @Override // com.opos.cmn.j.b.a
            public void a(boolean z) {
                if (c.this.f23270f == null) {
                    return;
                }
                if (z) {
                    c.this.f23270f.c();
                } else {
                    c.this.f23270f.b();
                }
            }
        });
        this.f23268d.addView(bVar, new ViewGroup.LayoutParams(0, 0));
        this.f23269e = new FrameLayout(this.f23266b);
        this.f23268d.addView(this.f23269e, new RelativeLayout.LayoutParams(-1, -1));
        TextView textView = new TextView(this.f23266b);
        textView.setGravity(17);
        com.opos.mobad.cmn.a.b.g.a(textView, com.opos.cmn.an.d.a.a.c(this.f23266b, "opos_module_biz_ui_reward_video_float_layer_close_bn.png"));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.f23266b, 30.0f), com.opos.cmn.an.h.f.a.a(this.f23266b, 30.0f));
        layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.f23266b, 54.0f);
        layoutParams.rightMargin = com.opos.cmn.an.h.f.a.a(this.f23266b, 11.0f);
        layoutParams.addRule(11);
        this.f23268d.addView(textView, layoutParams);
        AnonymousClass3 anonymousClass3 = new i() { // from class: com.opos.mobad.q.a.f.a.c.3
            AnonymousClass3() {
            }

            @Override // com.opos.mobad.q.a.i
            public void a(View view, int[] iArr) {
                if (c.this.f23267c != null) {
                    c.this.f23267c.d(view, (int[]) null);
                }
            }
        };
        textView.setOnTouchListener(anonymousClass3);
        textView.setOnClickListener(anonymousClass3);
        AnonymousClass4 anonymousClass4 = new i() { // from class: com.opos.mobad.q.a.f.a.c.4
            AnonymousClass4() {
            }

            @Override // com.opos.mobad.q.a.i
            public void a(View view, int[] iArr) {
                if (c.this.f23267c != null) {
                    c.this.f23267c.j(view, iArr);
                }
            }
        };
        this.f23268d.setOnTouchListener(anonymousClass4);
        this.f23268d.setOnClickListener(anonymousClass4);
    }

    private void a(com.opos.mobad.n.d.f fVar) {
        if (this.f23270f == null) {
            return;
        }
        List<com.opos.mobad.n.d.g> list = fVar.f22076h;
        String str = (list == null || list.size() <= 0 || fVar.f22076h.get(0) == null) ? "" : fVar.f22076h.get(0).f22084a;
        this.f23270f.a(fVar.f22081b);
        this.f23270f.b(fVar.f22082c);
        this.f23270f.c(fVar.f22083d);
        this.f23270f.a((Object) str);
    }

    private void a(com.opos.mobad.n.d.f fVar, String str) {
        com.opos.cmn.an.f.a.b("InteractiveFloatLayout", "prepare and show");
        n.a(str, com.opos.mobad.cmn.service.b.a.a().a(this.f23266b, str).getAbsolutePath(), new h() { // from class: com.opos.mobad.q.a.f.a.c.5

            /* renamed from: a */
            final /* synthetic */ com.opos.mobad.n.d.f f23279a;

            /* renamed from: com.opos.mobad.q.a.f.a.c$5$1 */
            class AnonymousClass1 implements Runnable {

                /* renamed from: a */
                final /* synthetic */ String f23281a;

                AnonymousClass1(String str2) {
                    str2 = str2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    AnonymousClass5 anonymousClass5 = AnonymousClass5.this;
                    c.this.b(fVar, str2);
                }
            }

            AnonymousClass5(com.opos.mobad.n.d.f fVar2) {
                fVar = fVar2;
            }

            @Override // com.opos.mobad.e.a.h
            public void a(boolean z, String str2) {
                if (z) {
                    com.opos.mobad.service.c.a(new Runnable() { // from class: com.opos.mobad.q.a.f.a.c.5.1

                        /* renamed from: a */
                        final /* synthetic */ String f23281a;

                        AnonymousClass1(String str22) {
                            str2 = str22;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            AnonymousClass5 anonymousClass5 = AnonymousClass5.this;
                            c.this.b(fVar, str2);
                        }
                    });
                } else {
                    com.opos.cmn.an.f.a.b("InteractiveFloatLayout", "prepare fail");
                }
            }
        });
    }

    public void b(com.opos.mobad.n.d.f fVar, String str) {
        com.opos.cmn.an.f.a.b("InteractiveFloatLayout", "show");
        this.f23271g.a(3000L);
        List<com.opos.mobad.n.d.g> list = fVar.f22076h;
        g a2 = n.a().a(true).a(fVar.f22081b).b(fVar.f22082c).c(fVar.f22083d).a((Object) ((list == null || list.size() <= 0 || fVar.f22076h.get(0) == null) ? "" : fVar.f22076h.get(0).f22084a)).a((com.opos.mobad.e.a.a) new com.opos.mobad.e.a.a() { // from class: com.opos.mobad.q.a.f.a.c.7
            AnonymousClass7() {
            }

            @Override // com.opos.mobad.e.a.a
            public void a(Map map, String str2, l lVar, int i2, String str22, int i3) {
                int[] iArr = {lVar.f20510c, lVar.f20511d, lVar.f20513f, lVar.f20514g};
                if (i2 == 0) {
                    if (c.this.f23267c != null) {
                        c.this.f23267c.k(c.this.f23269e, iArr);
                    }
                } else if (1 == i2) {
                    if (c.this.f23267c != null) {
                        c.this.f23267c.j(c.this.f23269e, iArr);
                    }
                } else {
                    com.opos.cmn.an.f.a.b("InteractiveFloatLayout", "unknown click:" + i2);
                }
            }

            @Override // com.opos.mobad.e.a.a
            public void a(Map map, String str2, l lVar, String str22, int i2) {
            }
        }).a((com.opos.mobad.e.a.i) new com.opos.mobad.e.a.i() { // from class: com.opos.mobad.q.a.f.a.c.6
            AnonymousClass6() {
            }

            @Override // com.opos.mobad.e.a.i
            public void a(Map map) {
                com.opos.cmn.an.f.a.b("InteractiveFloatLayout", "load success");
                c.this.f23271g.a();
            }

            @Override // com.opos.mobad.e.a.i
            public void a(Map map, String str2) {
                com.opos.cmn.an.f.a.b("InteractiveFloatLayout", "load fail :" + str2);
            }
        }).a(this.f23266b, str, fVar.I, fVar.J);
        this.f23270f = a2;
        View a3 = a2.a();
        this.f23272h = str;
        com.opos.cmn.an.f.a.b("InteractiveFloatLayout", "show view :" + a3);
        this.f23269e.removeAllViews();
        this.f23269e.addView(a3, new ViewGroup.LayoutParams(-1, -1));
    }

    @Override // com.opos.mobad.n.a
    public void a() {
    }

    @Override // com.opos.mobad.n.a
    public void a(a.InterfaceC0458a interfaceC0458a) {
        this.f23267c = interfaceC0458a;
    }

    @Override // com.opos.mobad.n.a
    public void a(com.opos.mobad.n.d.h hVar) {
        com.opos.mobad.n.d.g gVar;
        com.opos.mobad.n.d.f e2 = hVar.e();
        if (e2 == null || (gVar = e2.H) == null) {
            return;
        }
        com.opos.mobad.n.d.g gVar2 = this.f23274j;
        if (gVar2 != null && gVar2.f22084a.equals(gVar.f22084a)) {
            a(e2);
            return;
        }
        this.f23269e.removeAllViews();
        g gVar3 = this.f23270f;
        if (gVar3 != null) {
            gVar3.d();
        }
        this.f23274j = gVar;
        a(e2, gVar.f22084a);
    }

    @Override // com.opos.mobad.n.a
    public void b() {
    }

    @Override // com.opos.mobad.n.a
    public void d() {
        String str = this.f23272h;
        if (!TextUtils.isEmpty(str)) {
            com.opos.mobad.cmn.service.b.a.a().a(str);
        }
        g gVar = this.f23270f;
        if (gVar != null) {
            gVar.d();
        }
        this.f23267c = null;
    }

    @Override // com.opos.mobad.n.a
    public int e() {
        return this.f23273i;
    }

    @Override // com.opos.mobad.n.a
    /* renamed from: f */
    public RelativeLayout c() {
        return this.f23268d;
    }
}
