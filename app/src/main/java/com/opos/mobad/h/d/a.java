package com.opos.mobad.h.d;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.opos.cmn.j.b;
import com.opos.mobad.model.data.AdItemData;
import com.opos.mobad.n.a;
import com.opos.mobad.n.c.j;
import com.opos.mobad.n.d.h;

/* loaded from: classes4.dex */
public abstract class a extends com.opos.mobad.cmn.a.c implements com.opos.mobad.n.a {

    /* renamed from: h */
    protected int f20960h;

    /* renamed from: i */
    protected int f20961i;

    /* renamed from: j */
    protected a.InterfaceC0458a f20962j;
    protected float k;
    protected RelativeLayout l;
    protected RelativeLayout m;
    protected TextView n;
    protected com.opos.cmn.e.a.a.a o;
    protected RelativeLayout p;
    protected TextView q;
    protected com.opos.cmn.e.a.a.a r;
    protected com.opos.mobad.o.a.a s;
    private RelativeLayout t;
    private int u;
    private volatile int v;
    private com.opos.cmn.j.b w;
    private boolean x;
    private com.opos.mobad.n.d.d y;

    /* renamed from: com.opos.mobad.h.d.a$1 */
    class AnonymousClass1 implements View.OnClickListener {

        /* renamed from: a */
        final /* synthetic */ View f20963a;

        /* renamed from: b */
        final /* synthetic */ com.opos.mobad.cmn.a.b.a f20964b;

        AnonymousClass1(View view, com.opos.mobad.cmn.a.b.a aVar) {
            view = view;
            aVar = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a aVar = a.this;
            aVar.a(view, ((com.opos.mobad.cmn.a.c) aVar).f20281d, aVar);
        }
    }

    /* renamed from: com.opos.mobad.h.d.a$2 */
    class AnonymousClass2 implements View.OnClickListener {
        AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.opos.cmn.an.f.a.b("BaseNativeTempletCreative", "close click origin");
            a aVar = a.this;
            aVar.f20962j.d(view, ((com.opos.mobad.cmn.a.c) aVar).f20281d);
        }
    }

    /* renamed from: com.opos.mobad.h.d.a$3 */
    class AnonymousClass3 implements b.a {
        AnonymousClass3() {
        }

        @Override // com.opos.cmn.j.b.a
        public void a(boolean z) {
            if (a.this.v == 4) {
                com.opos.cmn.an.f.a.b("BaseNativeTempletCreative", "has destroy");
                return;
            }
            com.opos.cmn.an.f.a.b("BaseNativeTempletCreative", "is view visible =" + z);
            if (!z) {
                a.this.v = 2;
            } else if (a.this.v == 0) {
                a.this.v = 1;
                if (a.this.x) {
                    a.this.t();
                }
            }
        }
    }

    /* renamed from: com.opos.mobad.h.d.a$4 */
    static /* synthetic */ class AnonymousClass4 {

        /* renamed from: a */
        static final /* synthetic */ int[] f20968a;

        static {
            int[] iArr = new int[com.opos.mobad.cmn.a.b.a.values().length];
            f20968a = iArr;
            try {
                iArr[com.opos.mobad.cmn.a.b.a.NonClickBt.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f20968a[com.opos.mobad.cmn.a.b.a.ClickBt.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public a(Context context, a.InterfaceC0458a interfaceC0458a, float f2) {
        super(context);
        this.f20960h = 0;
        this.f20961i = 0;
        this.k = 1.0f;
        this.v = 0;
        this.x = false;
        this.f20962j = interfaceC0458a;
        b(f2);
        g();
        s();
    }

    public void a(View view, int[] iArr, com.opos.mobad.cmn.a.b.a aVar) {
        int i2 = AnonymousClass4.f20968a[aVar.ordinal()];
        if (i2 == 1) {
            this.f20962j.g(view, iArr);
        } else {
            if (i2 != 2) {
                return;
            }
            this.f20962j.f(view, iArr);
        }
    }

    private boolean a(com.opos.mobad.n.d.d dVar, TextView textView) {
        if (dVar == null) {
            return false;
        }
        String charSequence = textView.getText() != null ? textView.getText().toString() : "";
        com.opos.cmn.an.f.a.b("BaseNativeTempletCreative", "notifyInstallCompletedEvent desc =" + charSequence + "," + dVar.l);
        return !charSequence.equals(dVar.l);
    }

    private void b(float f2) {
        int b2 = com.opos.cmn.an.h.f.a.b(this.f20278a);
        j jVar = new j(this.f20278a, new j.a(b2, (int) (b2 * 0.6f), f2));
        this.t = jVar;
        jVar.setVisibility(4);
        RelativeLayout relativeLayout = new RelativeLayout(this.f20278a);
        this.l = relativeLayout;
        relativeLayout.setBackgroundColor(-1);
        this.l.setVisibility(4);
        this.t.addView(this.l, new ViewGroup.LayoutParams(-1, -1));
        o();
        p();
    }

    private void o() {
        RelativeLayout relativeLayout = new RelativeLayout(this.f20278a);
        this.m = relativeLayout;
        relativeLayout.setId(1);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(n(), l());
        layoutParams.addRule(10);
        layoutParams.leftMargin = a(16.0f);
        layoutParams.rightMargin = a(16.0f);
        this.l.addView(this.m, layoutParams);
    }

    private void p() {
        this.p = new RelativeLayout(this.f20278a);
        com.opos.cmn.e.a.a.c cVar = new com.opos.cmn.e.a.a.c(this.f20278a, 6.66f);
        cVar.setImageDrawable(new ColorDrawable(Color.parseColor("#f5f5f5")));
        this.p.addView(cVar, new RelativeLayout.LayoutParams(-1, -1));
        q();
        r();
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(n(), a(40.0f));
        layoutParams.addRule(3, 1);
        layoutParams.leftMargin = a(16.0f);
        layoutParams.rightMargin = a(16.0f);
        layoutParams.topMargin = a(10.0f);
        layoutParams.bottomMargin = a(20.0f);
        this.l.addView(this.p, layoutParams);
    }

    private void q() {
        TextView textView = new TextView(this.f20278a);
        this.q = textView;
        textView.setGravity(17);
        this.q.setTextColor(Color.parseColor("#999999"));
        this.q.setTextSize(1, m() * 14.0f);
        this.q.setMaxEms(9);
        this.q.setEllipsize(TextUtils.TruncateAt.END);
        this.q.setSingleLine();
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(9);
        layoutParams.addRule(15);
        layoutParams.leftMargin = a(16.0f);
        this.p.addView(this.q, layoutParams);
    }

    private void r() {
        com.opos.cmn.e.a.a.a aVar = new com.opos.cmn.e.a.a.a(this.f20278a, "opos_module_biz_ui_native_templet_click_bn_normal_bg_img.png", "opos_module_biz_ui_native_templet_click_bn_pressed_bg_img.png");
        this.r = aVar;
        aVar.setGravity(17);
        this.r.setTextColor(Color.parseColor("#0095ff"));
        this.r.setTextSize(1, m() * 12.0f);
        this.r.setSingleLine();
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(a(79.0f), a(24.0f));
        layoutParams.addRule(11);
        layoutParams.addRule(15);
        layoutParams.rightMargin = a(16.0f);
        this.p.addView(this.r, layoutParams);
    }

    private void s() {
        com.opos.cmn.j.b bVar = new com.opos.cmn.j.b(this.f20278a);
        this.w = bVar;
        bVar.a(new b.a() { // from class: com.opos.mobad.h.d.a.3
            AnonymousClass3() {
            }

            @Override // com.opos.cmn.j.b.a
            public void a(boolean z) {
                if (a.this.v == 4) {
                    com.opos.cmn.an.f.a.b("BaseNativeTempletCreative", "has destroy");
                    return;
                }
                com.opos.cmn.an.f.a.b("BaseNativeTempletCreative", "is view visible =" + z);
                if (!z) {
                    a.this.v = 2;
                } else if (a.this.v == 0) {
                    a.this.v = 1;
                    if (a.this.x) {
                        a.this.t();
                    }
                }
            }
        });
        this.l.addView(this.w, new RelativeLayout.LayoutParams(0, 0));
    }

    public void t() {
        if (this.v == 1) {
            this.v = 3;
            com.opos.cmn.an.f.a.b("BaseNativeTempletCreative", "NT onWindowVisibility");
            a.InterfaceC0458a interfaceC0458a = this.f20962j;
            if (interfaceC0458a != null) {
                interfaceC0458a.b();
            }
            this.w.a((b.a) null);
        }
    }

    protected int a(float f2) {
        return com.opos.cmn.an.h.f.a.a(this.f20278a, m() * f2);
    }

    @Override // com.opos.mobad.n.a
    public void a() {
    }

    protected void a(View view, AdItemData adItemData, com.opos.mobad.cmn.a.b.a aVar) {
        if (view != null) {
            view.setOnTouchListener(new com.opos.cmn.e.a.a.b(this.f20281d));
            view.setOnClickListener(new View.OnClickListener() { // from class: com.opos.mobad.h.d.a.1

                /* renamed from: a */
                final /* synthetic */ View f20963a;

                /* renamed from: b */
                final /* synthetic */ com.opos.mobad.cmn.a.b.a f20964b;

                AnonymousClass1(View view2, com.opos.mobad.cmn.a.b.a aVar2) {
                    view = view2;
                    aVar = aVar2;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    a aVar2 = a.this;
                    aVar2.a(view, ((com.opos.mobad.cmn.a.c) aVar2).f20281d, aVar);
                }
            });
        }
    }

    protected void a(View view, AdItemData adItemData, boolean z) {
        if (view != null) {
            view.setOnTouchListener(new com.opos.cmn.e.a.a.b(this.f20281d));
            view.setOnClickListener(new View.OnClickListener() { // from class: com.opos.mobad.h.d.a.2
                AnonymousClass2() {
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    com.opos.cmn.an.f.a.b("BaseNativeTempletCreative", "close click origin");
                    a aVar = a.this;
                    aVar.f20962j.d(view2, ((com.opos.mobad.cmn.a.c) aVar).f20281d);
                }
            });
        }
    }

    protected void a(RelativeLayout.LayoutParams layoutParams) {
        if (this.f20279b.getParent() != null) {
            ((ViewGroup) this.f20279b.getParent()).removeView(this.f20279b);
        }
        this.m.addView(this.f20279b, layoutParams);
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
        this.f20962j = interfaceC0458a;
    }

    @Override // com.opos.mobad.n.a
    public void a(h hVar) {
        com.opos.mobad.n.d.d a2 = hVar.a();
        if (a2 == null) {
            this.f20962j.b(1);
            return;
        }
        if (this.y == null) {
            this.f20962j.e();
        }
        this.y = a2;
        if (a(a2, this.r)) {
            this.r.setText(this.y.l);
        }
        if (this.x) {
            return;
        }
        this.x = true;
        this.t.setVisibility(0);
        this.l.setVisibility(0);
        t();
    }

    @Override // com.opos.mobad.n.a
    public void b() {
    }

    protected void b(RelativeLayout.LayoutParams layoutParams) {
        com.opos.cmn.e.a.a.a aVar = new com.opos.cmn.e.a.a.a(this.f20278a, "opos_module_biz_ui_cmn_close_bn_bg_img.png", "opos_module_biz_ui_cmn_close_bn_bg_img.png");
        this.o = aVar;
        aVar.setGravity(17);
        this.o.setTextColor(-1);
        this.o.setSingleLine();
        this.m.addView(this.o, layoutParams);
    }

    protected void d(AdItemData adItemData) {
        this.r.setText(c(adItemData));
    }

    @Override // com.opos.mobad.n.a
    public int e() {
        return this.u;
    }

    @Override // com.opos.mobad.cmn.a.c
    public void j() {
        RelativeLayout relativeLayout = this.t;
        if (relativeLayout != null && relativeLayout.getChildCount() > 0) {
            this.t.removeAllViews();
            this.t.setVisibility(8);
        }
        com.opos.mobad.o.a.a aVar = this.s;
        if (aVar != null) {
            aVar.a();
        }
    }

    @Override // com.opos.mobad.n.a
    /* renamed from: k */
    public RelativeLayout c() {
        return this.t;
    }

    protected abstract int l();

    protected float m() {
        return this.k;
    }

    protected int n() {
        return (int) (com.opos.cmn.an.h.f.a.b(this.f20278a) * m());
    }
}
