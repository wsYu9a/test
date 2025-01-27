package com.opos.mobad.n.e;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.opos.mobad.c.d.a;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

/* loaded from: classes4.dex */
public class a extends com.opos.mobad.n.i.a {

    /* renamed from: a */
    private Context f22096a;

    /* renamed from: d */
    private d f22097d;

    /* renamed from: e */
    private com.opos.mobad.n.d.b f22098e;

    /* renamed from: f */
    private FrameLayout f22099f;

    /* renamed from: g */
    private RelativeLayout f22100g;

    /* renamed from: h */
    private RelativeLayout f22101h;

    /* renamed from: i */
    private com.opos.mobad.c.d.a f22102i;

    /* renamed from: j */
    private c f22103j;

    /* renamed from: com.opos.mobad.n.e.a$1 */
    class AnonymousClass1 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ com.opos.mobad.n.d.b f22104a;

        AnonymousClass1(com.opos.mobad.n.d.b bVar) {
            bVar = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            a aVar = a.this;
            com.opos.mobad.n.d.b bVar = bVar;
            aVar.a(bVar, bVar.f22067a);
        }
    }

    /* renamed from: com.opos.mobad.n.e.a$2 */
    class AnonymousClass2 implements g {
        AnonymousClass2() {
        }

        @Override // com.opos.mobad.n.e.g
        public void a(int i2) {
            com.opos.cmn.an.f.a.b("DyTemplate", "onVideoStart :" + i2);
            a.this.q();
            a.this.c(0L, (long) i2);
        }

        @Override // com.opos.mobad.n.e.g
        public void a(int i2, int i3) {
            com.opos.cmn.an.f.a.b("DyTemplate", "onVideoProgress :" + i2 + "," + i3);
            a.this.c((long) i2, (long) i3);
        }

        @Override // com.opos.mobad.n.e.g
        public void a(String str) {
            com.opos.cmn.an.f.a.b("DyTemplate", "onVideoPlayError :" + str);
            a.this.a(102, str);
        }

        @Override // com.opos.mobad.n.e.g
        public void b(int i2, int i3) {
            com.opos.cmn.an.f.a.b("DyTemplate", "onVideoPause :" + i2 + "," + i3);
        }

        @Override // com.opos.mobad.n.e.g
        public void c(int i2, int i3) {
            com.opos.cmn.an.f.a.b("DyTemplate", "onVideoPlayEnd :" + i2 + "," + i3);
            long j2 = (long) i3;
            a.this.c(j2, j2);
        }
    }

    /* renamed from: com.opos.mobad.n.e.a$3 */
    class AnonymousClass3 implements f {

        /* renamed from: com.opos.mobad.n.e.a$3$1 */
        class AnonymousClass1 implements Callable<Boolean> {
            AnonymousClass1() {
            }

            @Override // java.util.concurrent.Callable
            /* renamed from: a */
            public Boolean call() throws Exception {
                if (a.this.f22097d != null && a.this.r()) {
                    a.this.f22097d.a(false);
                }
                a.this.q();
                a.this.i();
                return Boolean.TRUE;
            }
        }

        AnonymousClass3() {
        }

        @Override // com.opos.mobad.n.e.f
        public void a() {
            com.opos.cmn.an.f.a.b("DyTemplate", "load success");
            a.this.a(new Callable<Boolean>() { // from class: com.opos.mobad.n.e.a.3.1
                AnonymousClass1() {
                }

                @Override // java.util.concurrent.Callable
                /* renamed from: a */
                public Boolean call() throws Exception {
                    if (a.this.f22097d != null && a.this.r()) {
                        a.this.f22097d.a(false);
                    }
                    a.this.q();
                    a.this.i();
                    return Boolean.TRUE;
                }
            });
        }

        @Override // com.opos.mobad.n.e.f
        public void a(String str) {
            com.opos.cmn.an.f.a.b("DyTemplate", "load fail :" + str);
            a.this.a(3);
        }
    }

    /* renamed from: com.opos.mobad.n.e.a$4 */
    class AnonymousClass4 implements b {
        AnonymousClass4() {
        }

        @Override // com.opos.mobad.n.e.b
        public void a(View view, int[] iArr) {
            a.this.a(view, iArr);
        }

        @Override // com.opos.mobad.n.e.b
        public void b(View view, int[] iArr) {
            a.this.b(view, iArr);
        }

        @Override // com.opos.mobad.n.e.b
        public void c(View view, int[] iArr) {
            a.this.c(view, iArr);
        }

        @Override // com.opos.mobad.n.e.b
        public void d(View view, int[] iArr) {
            a.this.g(view, iArr);
        }

        @Override // com.opos.mobad.n.e.b
        public void e(View view, int[] iArr) {
            a.this.d(view, iArr);
        }

        @Override // com.opos.mobad.n.e.b
        public void f(View view, int[] iArr) {
            a.this.e(view, iArr);
        }
    }

    /* renamed from: com.opos.mobad.n.e.a$5 */
    class AnonymousClass5 implements a.InterfaceC0428a {
        AnonymousClass5() {
        }

        @Override // com.opos.mobad.c.d.a.InterfaceC0428a
        public void a(boolean z) {
            com.opos.cmn.an.f.a.b("DyTemplate", "visible change:" + z);
            if (a.this.f22097d == null) {
                return;
            }
            if (!z) {
                a.this.l();
            } else {
                a.this.n();
                a.this.k();
            }
        }
    }

    public a(Context context, int i2) {
        super(i2);
        this.f22096a = context;
        this.f22103j = new i();
        a(context);
    }

    private void a(Context context) {
        this.f22100g = new RelativeLayout(context);
        this.f22099f = new FrameLayout(this.f22096a);
        this.f22101h = new RelativeLayout(context);
    }

    private void a(com.opos.mobad.n.d.b bVar) {
        if (TextUtils.isEmpty(bVar.f22067a)) {
            return;
        }
        com.opos.mobad.n.d.b bVar2 = this.f22098e;
        if (bVar2 != null && bVar.f22067a.equals(bVar2.f22067a)) {
            b(bVar);
            return;
        }
        if (this.f22097d != null) {
            this.f22099f.removeAllViews();
            this.f22097d.d();
            this.f22097d = null;
        }
        if (com.opos.cmn.an.d.b.a.a(bVar.f22067a)) {
            com.opos.mobad.c.b.b.b(new Runnable() { // from class: com.opos.mobad.n.e.a.1

                /* renamed from: a */
                final /* synthetic */ com.opos.mobad.n.d.b f22104a;

                AnonymousClass1(com.opos.mobad.n.d.b bVar3) {
                    bVar = bVar3;
                }

                @Override // java.lang.Runnable
                public void run() {
                    a aVar = a.this;
                    com.opos.mobad.n.d.b bVar3 = bVar;
                    aVar.a(bVar3, bVar3.f22067a);
                }
            });
        } else {
            a(4);
        }
    }

    public void a(com.opos.mobad.n.d.b bVar, String str) {
        com.opos.cmn.an.f.a.b("DyTemplate", "show :" + str);
        long currentTimeMillis = System.currentTimeMillis();
        com.opos.cmn.an.f.a.b("DyTemplate", "adDynamicData.duration = " + bVar.w);
        c a2 = this.f22103j.a(bVar.f22074f).b(bVar.f22073e).c(bVar.l).a((b) new b() { // from class: com.opos.mobad.n.e.a.4
            AnonymousClass4() {
            }

            @Override // com.opos.mobad.n.e.b
            public void a(View view, int[] iArr) {
                a.this.a(view, iArr);
            }

            @Override // com.opos.mobad.n.e.b
            public void b(View view, int[] iArr) {
                a.this.b(view, iArr);
            }

            @Override // com.opos.mobad.n.e.b
            public void c(View view, int[] iArr) {
                a.this.c(view, iArr);
            }

            @Override // com.opos.mobad.n.e.b
            public void d(View view, int[] iArr) {
                a.this.g(view, iArr);
            }

            @Override // com.opos.mobad.n.e.b
            public void e(View view, int[] iArr) {
                a.this.d(view, iArr);
            }

            @Override // com.opos.mobad.n.e.b
            public void f(View view, int[] iArr) {
                a.this.e(view, iArr);
            }
        }).a((f) new f() { // from class: com.opos.mobad.n.e.a.3

            /* renamed from: com.opos.mobad.n.e.a$3$1 */
            class AnonymousClass1 implements Callable<Boolean> {
                AnonymousClass1() {
                }

                @Override // java.util.concurrent.Callable
                /* renamed from: a */
                public Boolean call() throws Exception {
                    if (a.this.f22097d != null && a.this.r()) {
                        a.this.f22097d.a(false);
                    }
                    a.this.q();
                    a.this.i();
                    return Boolean.TRUE;
                }
            }

            AnonymousClass3() {
            }

            @Override // com.opos.mobad.n.e.f
            public void a() {
                com.opos.cmn.an.f.a.b("DyTemplate", "load success");
                a.this.a(new Callable<Boolean>() { // from class: com.opos.mobad.n.e.a.3.1
                    AnonymousClass1() {
                    }

                    @Override // java.util.concurrent.Callable
                    /* renamed from: a */
                    public Boolean call() throws Exception {
                        if (a.this.f22097d != null && a.this.r()) {
                            a.this.f22097d.a(false);
                        }
                        a.this.q();
                        a.this.i();
                        return Boolean.TRUE;
                    }
                });
            }

            @Override // com.opos.mobad.n.e.f
            public void a(String str2) {
                com.opos.cmn.an.f.a.b("DyTemplate", "load fail :" + str2);
                a.this.a(3);
            }
        }).a((g) new g() { // from class: com.opos.mobad.n.e.a.2
            AnonymousClass2() {
            }

            @Override // com.opos.mobad.n.e.g
            public void a(int i2) {
                com.opos.cmn.an.f.a.b("DyTemplate", "onVideoStart :" + i2);
                a.this.q();
                a.this.c(0L, (long) i2);
            }

            @Override // com.opos.mobad.n.e.g
            public void a(int i2, int i3) {
                com.opos.cmn.an.f.a.b("DyTemplate", "onVideoProgress :" + i2 + "," + i3);
                a.this.c((long) i2, (long) i3);
            }

            @Override // com.opos.mobad.n.e.g
            public void a(String str2) {
                com.opos.cmn.an.f.a.b("DyTemplate", "onVideoPlayError :" + str2);
                a.this.a(102, str2);
            }

            @Override // com.opos.mobad.n.e.g
            public void b(int i2, int i3) {
                com.opos.cmn.an.f.a.b("DyTemplate", "onVideoPause :" + i2 + "," + i3);
            }

            @Override // com.opos.mobad.n.e.g
            public void c(int i2, int i3) {
                com.opos.cmn.an.f.a.b("DyTemplate", "onVideoPlayEnd :" + i2 + "," + i3);
                long j2 = (long) i3;
                a.this.c(j2, j2);
            }
        });
        com.opos.mobad.n.d.a aVar = bVar.v;
        if (aVar != null) {
            a2.a(aVar.f22066b, aVar.f22065a);
        }
        com.opos.mobad.n.d.g gVar = bVar.f22078j;
        if (gVar != null && !TextUtils.isEmpty(gVar.f22084a)) {
            a2.d(bVar.f22078j.f22084a);
        }
        com.opos.mobad.n.d.g gVar2 = bVar.f22068b;
        if (gVar2 != null && !TextUtils.isEmpty(gVar2.f22084a)) {
            a2.c((Object) bVar.f22068b.f22084a);
        }
        com.opos.mobad.n.d.g gVar3 = bVar.m;
        if (gVar3 != null && !TextUtils.isEmpty(gVar3.f22084a)) {
            a2.e(bVar.m.f22084a);
        }
        List<com.opos.mobad.n.d.g> list = bVar.f22075g;
        if (list != null && list.size() > 0) {
            com.opos.mobad.n.d.g gVar4 = bVar.f22075g.get(0);
            if (gVar4 != null) {
                a2.a((Object) gVar4.f22084a);
            }
            ArrayList arrayList = new ArrayList();
            for (com.opos.mobad.n.d.g gVar5 : bVar.f22075g) {
                if (gVar4 != null) {
                    arrayList.add(gVar5.f22084a);
                }
            }
            a2.b(arrayList);
        }
        d a3 = a2.a(this.f22096a, str);
        this.f22097d = a3;
        View a4 = a3.a();
        com.opos.cmn.an.f.a.b("DyTemplate", "show view :" + a4 + ", costTime = " + currentTimeMillis);
        this.f22099f.removeAllViews();
        this.f22099f.addView(a4, new ViewGroup.LayoutParams(-1, -2));
    }

    private void a(com.opos.mobad.n.d.d dVar) {
        if (this.f22098e != null) {
            return;
        }
        this.f22101h.addView(this.f22099f, new RelativeLayout.LayoutParams(-1, -2));
        this.f22100g.addView(this.f22101h, new RelativeLayout.LayoutParams(-1, -2));
    }

    private void b(com.opos.mobad.n.d.b bVar) {
        d dVar = this.f22097d;
        if (dVar == null) {
            return;
        }
        dVar.a(bVar.f22074f);
        this.f22097d.b(bVar.f22073e);
        this.f22097d.c(bVar.l);
    }

    public void i() {
        if (this.f22102i == null) {
            com.opos.mobad.c.d.a aVar = new com.opos.mobad.c.d.a(this.f22096a);
            this.f22102i = aVar;
            aVar.a(new a.InterfaceC0428a() { // from class: com.opos.mobad.n.e.a.5
                AnonymousClass5() {
                }

                @Override // com.opos.mobad.c.d.a.InterfaceC0428a
                public void a(boolean z) {
                    com.opos.cmn.an.f.a.b("DyTemplate", "visible change:" + z);
                    if (a.this.f22097d == null) {
                        return;
                    }
                    if (!z) {
                        a.this.l();
                    } else {
                        a.this.n();
                        a.this.k();
                    }
                }
            });
        }
        if (this.f22099f.indexOfChild(this.f22102i) < 0) {
            this.f22099f.addView(this.f22102i, new ViewGroup.LayoutParams(0, 0));
        }
    }

    public void q() {
        this.f22101h.setVisibility(0);
    }

    public boolean r() {
        com.opos.mobad.n.d.b bVar = this.f22098e;
        return (bVar == null || bVar.f22068b == null) ? false : true;
    }

    @Override // com.opos.mobad.n.a
    public void a(com.opos.mobad.n.d.h hVar) {
        com.opos.mobad.n.d.b d2 = hVar.d();
        if (d2 == null) {
            com.opos.cmn.an.f.a.b("DyTemplate", "adShowData is null");
            a(1);
        } else {
            com.opos.cmn.an.f.a.b("DyTemplate", "render");
            a(d2);
            a((com.opos.mobad.n.d.d) d2);
            this.f22098e = d2;
        }
    }

    public void a(boolean z) {
        d dVar = this.f22097d;
        if (dVar != null) {
            dVar.a(z);
        }
    }

    @Override // com.opos.mobad.n.a
    public View c() {
        return this.f22100g;
    }

    @Override // com.opos.mobad.n.i.a
    public boolean f() {
        d dVar = this.f22097d;
        if (dVar == null) {
            return false;
        }
        dVar.b();
        return true;
    }

    @Override // com.opos.mobad.n.i.a
    public boolean g() {
        d dVar = this.f22097d;
        if (dVar == null) {
            return false;
        }
        dVar.c();
        return true;
    }

    @Override // com.opos.mobad.n.i.a
    protected void h() {
        com.opos.cmn.an.f.a.b("DyTemplate", "destroy");
        this.f22100g.removeAllViews();
        this.f22099f.removeAllViews();
        d dVar = this.f22097d;
        if (dVar != null) {
            dVar.d();
        }
    }
}
