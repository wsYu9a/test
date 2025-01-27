package com.opos.mobad.n.a;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.opos.mobad.c.d.a;
import com.opos.mobad.n.a;
import com.opos.mobad.n.b;
import java.io.File;
import java.util.List;
import java.util.Map;

/* loaded from: classes4.dex */
public class i implements com.opos.mobad.n.a {

    /* renamed from: a */
    private Context f21803a;

    /* renamed from: b */
    private RelativeLayout f21804b;

    /* renamed from: c */
    private com.opos.mobad.e.a.g f21805c;

    /* renamed from: d */
    private int f21806d;

    /* renamed from: e */
    private a.InterfaceC0458a f21807e;

    /* renamed from: f */
    private s f21808f;

    /* renamed from: g */
    private FrameLayout f21809g;

    /* renamed from: h */
    private com.opos.mobad.c.b.c f21810h;

    /* renamed from: i */
    private com.opos.mobad.c.b.c f21811i;
    private long k;
    private com.opos.mobad.n.d.c l;
    private com.opos.mobad.n.b m;
    private String n;

    /* renamed from: j */
    private long f21812j = 0;
    private boolean o = false;
    private boolean p = false;
    private boolean q = false;

    /* renamed from: com.opos.mobad.n.a.i$1 */
    class AnonymousClass1 implements Runnable {
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            long h2 = i.this.h();
            if (i.this.l.w > 0) {
                h2 = Math.min(h2, i.this.l.w);
            }
            i iVar = i.this;
            iVar.a(iVar.l, h2);
            if (i.this.f21807e != null) {
                i.this.f21807e.d(h2, -1L);
            }
            com.opos.cmn.an.f.a.b("InteractiveTemplate", "process:" + h2 + ",duration:" + i.this.l.w);
            if (i.this.l.w <= 0 || h2 < i.this.l.w) {
                com.opos.cmn.an.f.a.b("InteractiveTemplate", "process start next");
                i.this.f21810h.a(1000L);
                return;
            }
            com.opos.cmn.an.f.a.b("InteractiveTemplate", "process complete");
            i.this.o = true;
            i.this.f();
            if (i.this.f21807e != null) {
                i.this.f21807e.a(h2, h2);
            }
        }
    }

    /* renamed from: com.opos.mobad.n.a.i$2 */
    class AnonymousClass2 implements Runnable {
        AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.opos.cmn.an.f.a.b("InteractiveTemplate", "render timeout");
            i.this.f21809g.removeAllViews();
            i.this.f21810h.a();
            if (i.this.f21805c != null) {
                i.this.f21805c.d();
            }
            if (i.this.f21807e != null) {
                i.this.f21807e.b(2);
            }
        }
    }

    /* renamed from: com.opos.mobad.n.a.i$3 */
    class AnonymousClass3 implements View.OnAttachStateChangeListener {
        AnonymousClass3() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            if (i.this.f21807e != null) {
                i.this.f21807e.b();
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }
    }

    /* renamed from: com.opos.mobad.n.a.i$4 */
    class AnonymousClass4 implements a.InterfaceC0428a {
        AnonymousClass4() {
        }

        @Override // com.opos.mobad.c.d.a.InterfaceC0428a
        public void a(boolean z) {
            com.opos.cmn.an.f.a.b("InteractiveTemplate", "visible change:" + z);
            i.this.q = z;
            if (i.this.f21805c == null) {
                return;
            }
            if (!z || i.this.p) {
                i.this.f21805c.b();
                i.this.f();
            } else {
                i.this.f21805c.c();
                i.this.g();
            }
        }
    }

    /* renamed from: com.opos.mobad.n.a.i$5 */
    class AnonymousClass5 implements b.a {

        /* renamed from: a */
        final /* synthetic */ com.opos.mobad.n.d.c f21817a;

        /* renamed from: com.opos.mobad.n.a.i$5$1 */
        class AnonymousClass1 implements Runnable {

            /* renamed from: a */
            final /* synthetic */ String f21819a;

            AnonymousClass1(String str) {
                str = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                AnonymousClass5 anonymousClass5 = AnonymousClass5.this;
                i.this.a(cVar, str);
            }
        }

        AnonymousClass5(com.opos.mobad.n.d.c cVar) {
            cVar = cVar;
        }

        @Override // com.opos.mobad.n.b.a
        public void a(boolean z, String str) {
            if (z) {
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.opos.mobad.n.a.i.5.1

                    /* renamed from: a */
                    final /* synthetic */ String f21819a;

                    AnonymousClass1(String str2) {
                        str = str2;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        AnonymousClass5 anonymousClass5 = AnonymousClass5.this;
                        i.this.a(cVar, str);
                    }
                });
            } else if (i.this.f21807e != null) {
                i.this.f21807e.b(4);
            }
        }
    }

    /* renamed from: com.opos.mobad.n.a.i$6 */
    class AnonymousClass6 implements com.opos.mobad.e.a.i {
        AnonymousClass6() {
        }

        @Override // com.opos.mobad.e.a.i
        public void a(Map map) {
            com.opos.cmn.an.f.a.b("InteractiveTemplate", "load success");
            i.this.f21811i.a();
            i.this.j();
            if (i.this.f21807e != null) {
                i.this.f21807e.e();
            }
        }

        @Override // com.opos.mobad.e.a.i
        public void a(Map map, String str) {
            com.opos.cmn.an.f.a.b("InteractiveTemplate", "load fail :" + str);
            i.this.f21811i.a();
            if (i.this.f21807e != null) {
                i.this.f21807e.b(3);
            }
        }
    }

    /* renamed from: com.opos.mobad.n.a.i$7 */
    class AnonymousClass7 implements com.opos.mobad.e.a.a {
        AnonymousClass7() {
        }

        @Override // com.opos.mobad.e.a.a
        public void a(Map map, String str, com.opos.mobad.e.a.l lVar, int i2, String str2, int i3) {
            com.opos.cmn.an.f.a.b("InteractiveTemplate", "cl:" + str + "," + i2);
            int[] iArr = {lVar.f20510c, lVar.f20511d, lVar.f20513f, lVar.f20514g};
            if (i2 == 0) {
                if (i.this.f21807e != null) {
                    i.this.f21807e.f(i.this.f21804b, iArr);
                }
            } else {
                if (1 != i2 || i.this.f21807e == null) {
                    return;
                }
                i.this.f21807e.g(i.this.f21804b, iArr);
            }
        }

        @Override // com.opos.mobad.e.a.a
        public void a(Map map, String str, com.opos.mobad.e.a.l lVar, String str2, int i2) {
            com.opos.cmn.an.f.a.b("InteractiveTemplate", "action:" + str);
            if (i.this.f21807e != null) {
                i.this.f21807e.h(i.this.f21804b, new int[]{lVar.f20510c, lVar.f20511d, lVar.f20513f, lVar.f20514g});
            }
        }
    }

    public i(Context context, int i2, com.opos.mobad.n.b bVar) {
        this.f21803a = context;
        this.f21806d = i2;
        this.m = bVar;
        i();
        Handler handler = new Handler(Looper.getMainLooper());
        this.f21810h = new com.opos.mobad.c.b.c(handler, new Runnable() { // from class: com.opos.mobad.n.a.i.1
            AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public void run() {
                long h2 = i.this.h();
                if (i.this.l.w > 0) {
                    h2 = Math.min(h2, i.this.l.w);
                }
                i iVar = i.this;
                iVar.a(iVar.l, h2);
                if (i.this.f21807e != null) {
                    i.this.f21807e.d(h2, -1L);
                }
                com.opos.cmn.an.f.a.b("InteractiveTemplate", "process:" + h2 + ",duration:" + i.this.l.w);
                if (i.this.l.w <= 0 || h2 < i.this.l.w) {
                    com.opos.cmn.an.f.a.b("InteractiveTemplate", "process start next");
                    i.this.f21810h.a(1000L);
                    return;
                }
                com.opos.cmn.an.f.a.b("InteractiveTemplate", "process complete");
                i.this.o = true;
                i.this.f();
                if (i.this.f21807e != null) {
                    i.this.f21807e.a(h2, h2);
                }
            }
        });
        this.f21811i = new com.opos.mobad.c.b.c(handler, new Runnable() { // from class: com.opos.mobad.n.a.i.2
            AnonymousClass2() {
            }

            @Override // java.lang.Runnable
            public void run() {
                com.opos.cmn.an.f.a.b("InteractiveTemplate", "render timeout");
                i.this.f21809g.removeAllViews();
                i.this.f21810h.a();
                if (i.this.f21805c != null) {
                    i.this.f21805c.d();
                }
                if (i.this.f21807e != null) {
                    i.this.f21807e.b(2);
                }
            }
        });
    }

    private void a(com.opos.mobad.n.d.c cVar) {
        if (TextUtils.isEmpty(cVar.f22069a)) {
            return;
        }
        com.opos.mobad.n.d.c cVar2 = this.l;
        if (cVar2 != null && cVar.f22069a.equals(cVar2.f22069a)) {
            b(cVar);
            return;
        }
        if (this.f21805c != null) {
            this.f21809g.removeAllViews();
            this.f21805c.d();
            this.f21805c = null;
        }
        if (a(cVar.f22069a)) {
            this.m.a(cVar.f22069a, new b.a() { // from class: com.opos.mobad.n.a.i.5

                /* renamed from: a */
                final /* synthetic */ com.opos.mobad.n.d.c f21817a;

                /* renamed from: com.opos.mobad.n.a.i$5$1 */
                class AnonymousClass1 implements Runnable {

                    /* renamed from: a */
                    final /* synthetic */ String f21819a;

                    AnonymousClass1(String str2) {
                        str = str2;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        AnonymousClass5 anonymousClass5 = AnonymousClass5.this;
                        i.this.a(cVar, str);
                    }
                }

                AnonymousClass5(com.opos.mobad.n.d.c cVar3) {
                    cVar = cVar3;
                }

                @Override // com.opos.mobad.n.b.a
                public void a(boolean z, String str2) {
                    if (z) {
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.opos.mobad.n.a.i.5.1

                            /* renamed from: a */
                            final /* synthetic */ String f21819a;

                            AnonymousClass1(String str22) {
                                str = str22;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                AnonymousClass5 anonymousClass5 = AnonymousClass5.this;
                                i.this.a(cVar, str);
                            }
                        });
                    } else if (i.this.f21807e != null) {
                        i.this.f21807e.b(4);
                    }
                }
            });
            return;
        }
        a.InterfaceC0458a interfaceC0458a = this.f21807e;
        if (interfaceC0458a != null) {
            interfaceC0458a.b(4);
        }
    }

    public void a(com.opos.mobad.n.d.c cVar, long j2) {
        long j3 = cVar.f22072d;
        if (j3 <= 0 || j2 >= j3) {
            this.f21808f.a();
        }
    }

    public void a(com.opos.mobad.n.d.c cVar, String str) {
        com.opos.mobad.n.d.g gVar;
        com.opos.cmn.an.f.a.b("InteractiveTemplate", "show :" + str);
        List<com.opos.mobad.n.d.g> list = cVar.f22075g;
        String str2 = (list == null || list.size() <= 0 || cVar.f22075g.get(0) == null || (gVar = cVar.f22075g.get(0)) == null) ? "" : gVar.f22084a;
        this.f21811i.a(3000L);
        com.opos.mobad.e.a.g a2 = com.opos.mobad.e.a.n.a().a(true).a(cVar.f22074f).b(cVar.f22073e).c(cVar.l).b((Object) cVar.f22078j.f22084a).a((Object) str2).a((com.opos.mobad.e.a.a) new com.opos.mobad.e.a.a() { // from class: com.opos.mobad.n.a.i.7
            AnonymousClass7() {
            }

            @Override // com.opos.mobad.e.a.a
            public void a(Map map, String str3, com.opos.mobad.e.a.l lVar, int i2, String str22, int i3) {
                com.opos.cmn.an.f.a.b("InteractiveTemplate", "cl:" + str3 + "," + i2);
                int[] iArr = {lVar.f20510c, lVar.f20511d, lVar.f20513f, lVar.f20514g};
                if (i2 == 0) {
                    if (i.this.f21807e != null) {
                        i.this.f21807e.f(i.this.f21804b, iArr);
                    }
                } else {
                    if (1 != i2 || i.this.f21807e == null) {
                        return;
                    }
                    i.this.f21807e.g(i.this.f21804b, iArr);
                }
            }

            @Override // com.opos.mobad.e.a.a
            public void a(Map map, String str3, com.opos.mobad.e.a.l lVar, String str22, int i2) {
                com.opos.cmn.an.f.a.b("InteractiveTemplate", "action:" + str3);
                if (i.this.f21807e != null) {
                    i.this.f21807e.h(i.this.f21804b, new int[]{lVar.f20510c, lVar.f20511d, lVar.f20513f, lVar.f20514g});
                }
            }
        }).a((com.opos.mobad.e.a.i) new com.opos.mobad.e.a.i() { // from class: com.opos.mobad.n.a.i.6
            AnonymousClass6() {
            }

            @Override // com.opos.mobad.e.a.i
            public void a(Map map) {
                com.opos.cmn.an.f.a.b("InteractiveTemplate", "load success");
                i.this.f21811i.a();
                i.this.j();
                if (i.this.f21807e != null) {
                    i.this.f21807e.e();
                }
            }

            @Override // com.opos.mobad.e.a.i
            public void a(Map map, String str3) {
                com.opos.cmn.an.f.a.b("InteractiveTemplate", "load fail :" + str3);
                i.this.f21811i.a();
                if (i.this.f21807e != null) {
                    i.this.f21807e.b(3);
                }
            }
        }).a(this.f21803a, str, cVar.f22070b, cVar.f22071c);
        this.f21805c = a2;
        View a3 = a2.a();
        this.n = str;
        com.opos.cmn.an.f.a.b("InteractiveTemplate", "show view :" + a3);
        this.f21809g.removeAllViews();
        this.f21809g.addView(a3, new ViewGroup.LayoutParams(-1, -1));
    }

    private boolean a(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                if (new File(str).exists()) {
                    return true;
                }
            }
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.b("InteractiveTemplate", "", e2);
        }
        return false;
    }

    private void b(com.opos.mobad.n.d.c cVar) {
        com.opos.mobad.n.d.g gVar;
        com.opos.mobad.e.a.g gVar2 = this.f21805c;
        if (gVar2 == null) {
            return;
        }
        gVar2.a(cVar.f22074f);
        this.f21805c.b(cVar.f22073e);
        this.f21805c.c(cVar.l);
        com.opos.mobad.n.d.g gVar3 = cVar.f22078j;
        if (gVar3 != null) {
            this.f21805c.b((Object) gVar3.f22084a);
        }
        List<com.opos.mobad.n.d.g> list = cVar.f22075g;
        this.f21805c.a((Object) ((list == null || list.size() <= 0 || cVar.f22075g.get(0) == null || (gVar = cVar.f22075g.get(0)) == null) ? "" : gVar.f22084a));
    }

    public void f() {
        com.opos.cmn.an.f.a.b("InteractiveTemplate", "stop process");
        this.f21810h.a();
        if (this.k > 0) {
            this.f21812j = h();
        }
        this.k = 0L;
    }

    public void g() {
        String str;
        if (this.o) {
            str = "start process but complete";
        } else {
            long j2 = this.l.w;
            if (j2 > 0) {
                a.InterfaceC0458a interfaceC0458a = this.f21807e;
                if (interfaceC0458a != null) {
                    interfaceC0458a.d(this.f21812j, j2);
                }
                com.opos.cmn.an.f.a.b("InteractiveTemplate", "start process");
                this.k = SystemClock.elapsedRealtime();
                this.f21810h.a(1000L);
                return;
            }
            str = "start process but duration 0";
        }
        com.opos.cmn.an.f.a.b("InteractiveTemplate", str);
    }

    public long h() {
        long elapsedRealtime = SystemClock.elapsedRealtime() - this.k;
        if (elapsedRealtime <= 0) {
            elapsedRealtime = 0;
        }
        return elapsedRealtime + this.f21812j;
    }

    private void i() {
        RelativeLayout relativeLayout = new RelativeLayout(this.f21803a);
        this.f21804b = relativeLayout;
        relativeLayout.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.opos.mobad.n.a.i.3
            AnonymousClass3() {
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
                if (i.this.f21807e != null) {
                    i.this.f21807e.b();
                }
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
            }
        });
        com.opos.mobad.c.d.a aVar = new com.opos.mobad.c.d.a(this.f21803a);
        aVar.a(new a.InterfaceC0428a() { // from class: com.opos.mobad.n.a.i.4
            AnonymousClass4() {
            }

            @Override // com.opos.mobad.c.d.a.InterfaceC0428a
            public void a(boolean z) {
                com.opos.cmn.an.f.a.b("InteractiveTemplate", "visible change:" + z);
                i.this.q = z;
                if (i.this.f21805c == null) {
                    return;
                }
                if (!z || i.this.p) {
                    i.this.f21805c.b();
                    i.this.f();
                } else {
                    i.this.f21805c.c();
                    i.this.g();
                }
            }
        });
        this.f21804b.addView(aVar, new ViewGroup.LayoutParams(0, 0));
        FrameLayout frameLayout = new FrameLayout(this.f21803a);
        this.f21809g = frameLayout;
        this.f21804b.addView(frameLayout, new ViewGroup.LayoutParams(-1, -1));
        this.f21808f = new s(this.f21803a);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.f21803a, 50.0f);
        layoutParams.leftMargin = com.opos.cmn.an.h.f.a.a(this.f21803a, 16.0f);
        layoutParams.rightMargin = com.opos.cmn.an.h.f.a.a(this.f21803a, 16.0f);
        this.f21804b.addView(this.f21808f, layoutParams);
    }

    public void j() {
        if (!this.q || this.p) {
            return;
        }
        com.opos.mobad.e.a.g gVar = this.f21805c;
        if (gVar != null) {
            gVar.c();
        }
        g();
    }

    @Override // com.opos.mobad.n.a
    public void a() {
        com.opos.cmn.an.f.a.b("InteractiveTemplate", "stop");
        this.p = true;
        com.opos.mobad.e.a.g gVar = this.f21805c;
        if (gVar != null) {
            gVar.b();
        }
        f();
    }

    @Override // com.opos.mobad.n.a
    public void a(a.InterfaceC0458a interfaceC0458a) {
        this.f21807e = interfaceC0458a;
        this.f21808f.a(interfaceC0458a);
    }

    @Override // com.opos.mobad.n.a
    public void a(com.opos.mobad.n.d.h hVar) {
        com.opos.mobad.n.d.c c2 = hVar.c();
        if (c2 == null) {
            this.f21807e.b(1);
            return;
        }
        com.opos.cmn.an.f.a.b("InteractiveTemplate", "render");
        this.f21808f.a(c2.C, c2.s);
        a(c2, 0L);
        a(c2);
        this.l = c2;
    }

    @Override // com.opos.mobad.n.a
    public void b() {
        com.opos.cmn.an.f.a.b("InteractiveTemplate", "start");
        this.p = false;
        j();
    }

    @Override // com.opos.mobad.n.a
    public View c() {
        return this.f21804b;
    }

    @Override // com.opos.mobad.n.a
    public void d() {
        com.opos.cmn.an.f.a.b("InteractiveTemplate", "destroy");
        String str = this.n;
        if (!TextUtils.isEmpty(str)) {
            this.m.a(str);
        }
        this.f21811i.b();
        this.f21810h.b();
        this.f21804b.removeAllViews();
        com.opos.mobad.e.a.g gVar = this.f21805c;
        if (gVar != null) {
            gVar.d();
        }
    }

    @Override // com.opos.mobad.n.a
    public int e() {
        return this.f21806d;
    }
}
