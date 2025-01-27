package com.opos.mobad.q.a.f.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.opos.mobad.cmn.a.b.g;
import com.opos.mobad.n.a;
import com.opos.mobad.q.a.f.a;

/* loaded from: classes4.dex */
public abstract class a implements com.opos.mobad.n.a {

    /* renamed from: a */
    protected Context f23251a;

    /* renamed from: c */
    protected TextView f23253c;

    /* renamed from: d */
    protected TextView f23254d;

    /* renamed from: e */
    protected com.opos.cmn.e.a.a.c f23255e;

    /* renamed from: f */
    protected TextView f23256f;

    /* renamed from: g */
    protected TextView f23257g;

    /* renamed from: h */
    protected RelativeLayout f23258h;

    /* renamed from: i */
    protected RelativeLayout f23259i;

    /* renamed from: j */
    protected Bitmap f23260j;
    protected a.InterfaceC0458a k;
    protected com.opos.mobad.q.a.f.a l;
    protected f m;
    protected int n;
    protected int o;
    protected int p;
    protected int q;
    protected com.opos.mobad.n.d.f r;
    private int t;

    /* renamed from: b */
    protected int[] f23252b = new int[4];
    protected a.InterfaceC0476a s = new a.InterfaceC0476a() { // from class: com.opos.mobad.q.a.f.a.a.3
        AnonymousClass3() {
        }

        @Override // com.opos.mobad.q.a.f.a.InterfaceC0476a
        public void a() {
            com.opos.cmn.an.f.a.b("BaseFloatLayerView", "end to scale");
            f fVar = a.this.m;
            if (fVar != null) {
                fVar.b();
            }
            com.opos.mobad.q.a.f.a aVar = a.this.l;
            if (aVar != null) {
                aVar.a();
            }
        }

        @Override // com.opos.mobad.q.a.f.a.InterfaceC0476a
        public void a(boolean z) {
        }

        @Override // com.opos.mobad.q.a.f.a.InterfaceC0476a
        public void b() {
            com.opos.cmn.an.f.a.b("BaseFloatLayerView", "start to scale");
            f fVar = a.this.m;
            if (fVar != null) {
                fVar.a();
            }
        }
    };

    /* renamed from: com.opos.mobad.q.a.f.a.a$1 */
    class AnonymousClass1 implements View.OnClickListener {
        AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a aVar = a.this;
            a.InterfaceC0458a interfaceC0458a = aVar.k;
            if (interfaceC0458a != null) {
                interfaceC0458a.d(view, aVar.f23252b);
            }
        }
    }

    /* renamed from: com.opos.mobad.q.a.f.a.a$2 */
    class AnonymousClass2 implements View.OnClickListener {

        /* renamed from: a */
        final /* synthetic */ com.opos.mobad.cmn.a.b.a f23262a;

        AnonymousClass2(com.opos.mobad.cmn.a.b.a aVar) {
            aVar = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a aVar = a.this;
            a.InterfaceC0458a interfaceC0458a = aVar.k;
            if (interfaceC0458a != null) {
                com.opos.mobad.cmn.a.b.a aVar2 = aVar;
                com.opos.mobad.cmn.a.b.a aVar3 = com.opos.mobad.cmn.a.b.a.FloatLayerClickBt;
                int[] iArr = aVar.f23252b;
                if (aVar2 == aVar3) {
                    interfaceC0458a.k(view, iArr);
                } else {
                    interfaceC0458a.j(view, iArr);
                }
            }
        }
    }

    /* renamed from: com.opos.mobad.q.a.f.a.a$3 */
    class AnonymousClass3 implements a.InterfaceC0476a {
        AnonymousClass3() {
        }

        @Override // com.opos.mobad.q.a.f.a.InterfaceC0476a
        public void a() {
            com.opos.cmn.an.f.a.b("BaseFloatLayerView", "end to scale");
            f fVar = a.this.m;
            if (fVar != null) {
                fVar.b();
            }
            com.opos.mobad.q.a.f.a aVar = a.this.l;
            if (aVar != null) {
                aVar.a();
            }
        }

        @Override // com.opos.mobad.q.a.f.a.InterfaceC0476a
        public void a(boolean z) {
        }

        @Override // com.opos.mobad.q.a.f.a.InterfaceC0476a
        public void b() {
            com.opos.cmn.an.f.a.b("BaseFloatLayerView", "start to scale");
            f fVar = a.this.m;
            if (fVar != null) {
                fVar.a();
            }
        }
    }

    public a(Context context, int i2, a.InterfaceC0458a interfaceC0458a) {
        this.f23251a = context.getApplicationContext();
        this.k = interfaceC0458a;
        this.t = i2;
        f();
        g();
        k();
    }

    private void k() {
        com.opos.mobad.q.a.f.a aVar = new com.opos.mobad.q.a.f.a(this.f23251a);
        this.l = aVar;
        aVar.a(this.s);
        this.f23259i.addView(this.l);
    }

    @Override // com.opos.mobad.n.a
    public void a() {
    }

    protected void a(View view) {
        if (view != null) {
            try {
                view.setOnTouchListener(null);
                view.setOnClickListener(null);
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.a("BaseFloatLayerView", "", (Throwable) e2);
            }
        }
    }

    protected void a(View view, com.opos.mobad.cmn.a.b.a aVar) {
        if (view != null) {
            view.setOnTouchListener(new com.opos.cmn.e.a.a.b(this.f23252b));
            view.setOnClickListener(new View.OnClickListener() { // from class: com.opos.mobad.q.a.f.a.a.2

                /* renamed from: a */
                final /* synthetic */ com.opos.mobad.cmn.a.b.a f23262a;

                AnonymousClass2(com.opos.mobad.cmn.a.b.a aVar2) {
                    aVar = aVar2;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    a aVar2 = a.this;
                    a.InterfaceC0458a interfaceC0458a = aVar2.k;
                    if (interfaceC0458a != null) {
                        com.opos.mobad.cmn.a.b.a aVar22 = aVar;
                        com.opos.mobad.cmn.a.b.a aVar3 = com.opos.mobad.cmn.a.b.a.FloatLayerClickBt;
                        int[] iArr = aVar2.f23252b;
                        if (aVar22 == aVar3) {
                            interfaceC0458a.k(view2, iArr);
                        } else {
                            interfaceC0458a.j(view2, iArr);
                        }
                    }
                }
            });
        }
    }

    protected void a(TextView textView, String str) {
        if (textView != null) {
            if (com.opos.cmn.an.c.a.a(str)) {
                str = "";
            }
            textView.setText(str);
        }
    }

    @Override // com.opos.mobad.n.a
    public void a(a.InterfaceC0458a interfaceC0458a) {
        this.k = interfaceC0458a;
    }

    protected void a(String str) {
        a(this.f23253c, str);
    }

    @Override // com.opos.mobad.n.a
    public void b() {
    }

    @Override // com.opos.mobad.n.a
    public int e() {
        return this.t;
    }

    protected void f() {
        RelativeLayout relativeLayout = new RelativeLayout(this.f23251a);
        this.f23259i = relativeLayout;
        relativeLayout.setBackgroundColor(Color.parseColor("#c0000000"));
        this.f23259i.setClickable(true);
        this.f23259i.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.f23258h = new RelativeLayout(this.f23251a);
        this.n = g.a();
        this.o = g.a();
        this.p = g.a();
        this.q = g.a();
    }

    public abstract void g();

    protected void h() {
        if (this.r != null) {
            return;
        }
        TextView textView = new TextView(this.f23251a);
        this.f23254d = textView;
        textView.setGravity(17);
        g.a(this.f23254d, com.opos.cmn.an.d.a.a.c(this.f23251a, "opos_module_biz_ui_reward_video_float_layer_close_bn.png"));
        this.f23259i.addView(this.f23254d, i());
    }

    public abstract RelativeLayout.LayoutParams i();

    protected void j() {
        this.f23254d.setOnTouchListener(new com.opos.cmn.e.a.a.b(this.f23252b));
        this.f23254d.setOnClickListener(new View.OnClickListener() { // from class: com.opos.mobad.q.a.f.a.a.1
            AnonymousClass1() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a aVar = a.this;
                a.InterfaceC0458a interfaceC0458a = aVar.k;
                if (interfaceC0458a != null) {
                    interfaceC0458a.d(view, aVar.f23252b);
                }
            }
        });
    }
}
