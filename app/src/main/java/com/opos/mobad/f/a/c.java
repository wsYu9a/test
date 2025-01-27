package com.opos.mobad.f.a;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.RelativeLayout;
import com.opos.mobad.ad.b;
import com.opos.mobad.ad.e.f;
import com.opos.mobad.f.a.a.c;
import com.opos.mobad.service.a.e;
import java.util.List;

/* loaded from: classes4.dex */
public class c extends com.opos.mobad.l.b {

    /* renamed from: a */
    public static final String f20656a = "c";

    /* renamed from: b */
    private com.opos.mobad.ad.e.f f20657b;

    /* renamed from: c */
    private String f20658c;

    /* renamed from: d */
    private RelativeLayout f20659d;

    /* renamed from: g */
    private com.opos.mobad.ad.e.c f20660g;

    /* renamed from: h */
    private ViewGroup f20661h;

    /* renamed from: i */
    private Context f20662i;

    /* renamed from: j */
    private com.opos.mobad.f.a.a.n<com.opos.mobad.ad.e.a> f20663j;
    private com.opos.mobad.f.b k;
    private boolean l;
    private String m;

    /* renamed from: com.opos.mobad.f.a.c$1 */
    class AnonymousClass1 implements com.opos.mobad.f.a.b.b<com.opos.mobad.ad.e.a> {

        /* renamed from: a */
        final /* synthetic */ com.opos.mobad.f.b f20664a;

        /* renamed from: b */
        final /* synthetic */ Context f20665b;

        /* renamed from: c */
        final /* synthetic */ String f20666c;

        AnonymousClass1(com.opos.mobad.f.b bVar, Context context, String str) {
            bVar = bVar;
            context = context;
            str = str;
        }

        @Override // com.opos.mobad.f.a.b.a
        /* renamed from: a */
        public com.opos.mobad.ad.e.a b(e.a aVar, com.opos.mobad.f.a.a.n nVar) {
            com.opos.mobad.ad.c b2 = bVar.b(aVar.f23520a);
            if (b2 == null) {
                return null;
            }
            return b2.a(context, str, aVar.f23521b, c.this.f20657b, c.this.new a(aVar.f23520a, nVar));
        }
    }

    /* renamed from: com.opos.mobad.f.a.c$2 */
    class AnonymousClass2 implements b.a {

        /* renamed from: com.opos.mobad.f.a.c$2$1 */
        class AnonymousClass1 implements Runnable {
            AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public void run() {
                c.this.k();
            }
        }

        AnonymousClass2() {
        }

        @Override // com.opos.mobad.ad.b.a
        public void a() {
            c.this.c("onAdReady");
            com.opos.mobad.service.c.c(new Runnable() { // from class: com.opos.mobad.f.a.c.2.1
                AnonymousClass1() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    c.this.k();
                }
            });
            c.this.o();
        }

        @Override // com.opos.mobad.ad.b.a
        public void a(int i2, String str) {
            c.this.c("onAdFailed code=" + i2 + ",msg =" + str);
            c.this.b(com.opos.mobad.f.a.a.l.a(i2), str);
        }

        @Override // com.opos.mobad.ad.b.a
        public void b() {
            c.this.c("onAdClose");
            c.this.i_();
        }
    }

    /* renamed from: com.opos.mobad.f.a.c$3 */
    class AnonymousClass3 implements c.a<com.opos.mobad.f.a.a.n<com.opos.mobad.ad.e.a>> {

        /* renamed from: a */
        final /* synthetic */ String f20670a;

        /* renamed from: b */
        final /* synthetic */ int f20671b;

        /* renamed from: c */
        final /* synthetic */ com.opos.mobad.f.a.b.b f20672c;

        /* renamed from: d */
        final /* synthetic */ com.opos.mobad.f.a.c.a f20673d;

        /* renamed from: e */
        final /* synthetic */ b.a f20674e;

        AnonymousClass3(String str, int i2, com.opos.mobad.f.a.b.b bVar, com.opos.mobad.f.a.c.a aVar, b.a aVar2) {
            str = str;
            k = i2;
            bVar = bVar;
            aVar = aVar;
            aVar2 = aVar2;
        }

        @Override // com.opos.mobad.f.a.a.c.a
        public int a(int i2) {
            return c.this.k.a(i2);
        }

        @Override // com.opos.mobad.f.a.a.c.a
        public com.opos.mobad.f.a.a.n<com.opos.mobad.ad.e.a> a(List<e.a> list, e.a aVar, long j2) {
            return com.opos.mobad.f.a.a.k.a(str, new com.opos.mobad.f.a.d.b(k), list, aVar, j2, bVar, aVar, aVar2);
        }

        @Override // com.opos.mobad.f.a.a.c.a
        public com.opos.mobad.f.a.a.n<com.opos.mobad.ad.e.a> a(List<e.a> list, e.a aVar, long j2, int i2) {
            return com.opos.mobad.f.a.a.k.a(str, new com.opos.mobad.f.a.d.c(i2, k), list, aVar, j2, bVar, aVar, aVar2);
        }
    }

    private class a extends com.opos.mobad.f.a.a.b implements com.opos.mobad.ad.e.c {

        /* renamed from: c */
        private final int f20678c;

        public a(int i2, com.opos.mobad.f.a.a.n nVar) {
            super(i2, nVar);
            this.f20678c = i2;
        }

        @Override // com.opos.mobad.f.a.a.b, com.opos.mobad.ad.b.a
        public void a(int i2, String str) {
            c.this.c("ad failed:" + i2 + ",msg:" + str + ", state=" + c.this.d());
            if (1 == c.this.d()) {
                super.a(i2, str);
                return;
            }
            if (2 == c.this.d() && this.f20678c == c.this.f20663j.j()) {
                c.this.c(i2, str);
                return;
            }
            c.this.c("ignore fail:" + this.f20678c);
        }

        @Override // com.opos.mobad.ad.i.b
        public void a(long j2) {
            c.this.c("ad click:" + this.f20678c + "," + c.this.f20663j.i());
            if (this.f20678c != c.this.f20663j.j()) {
                return;
            }
            com.opos.mobad.service.j.n.a().b(c.this.f20658c);
            c.this.i();
        }

        @Override // com.opos.mobad.ad.i.b
        public void a(String str) {
            c.this.c("ad show");
            if (this.f20678c != c.this.f20663j.j()) {
                return;
            }
            com.opos.mobad.service.j.n.a().a(c.this.f20658c);
            c.this.d(str);
        }

        @Override // com.opos.mobad.f.a.a.b, com.opos.mobad.ad.b.a
        public void b() {
            c.this.c("ad close:" + this.f20678c + "," + c.this.f20663j.i());
            if (this.f20678c != c.this.f20663j.j()) {
                return;
            }
            c.this.i_();
        }
    }

    public c(Context context, String str, com.opos.mobad.ad.e.f fVar, com.opos.mobad.ad.e.c cVar, com.opos.mobad.f.b bVar) {
        super(cVar);
        if (context == null || TextUtils.isEmpty(str) || fVar == null || cVar == null || bVar == null) {
            com.opos.cmn.an.f.a.c(f20656a, "HotSplashAd params null.");
            c(-1, "HotSplashAd params null.");
            return;
        }
        this.f20660g = cVar;
        this.f20658c = str;
        this.f20662i = context.getApplicationContext();
        this.f20659d = new RelativeLayout(this.f20662i);
        this.f20657b = a(fVar);
        this.k = bVar;
        this.f20663j = a(str, new com.opos.mobad.f.a.b.b<com.opos.mobad.ad.e.a>() { // from class: com.opos.mobad.f.a.c.1

            /* renamed from: a */
            final /* synthetic */ com.opos.mobad.f.b f20664a;

            /* renamed from: b */
            final /* synthetic */ Context f20665b;

            /* renamed from: c */
            final /* synthetic */ String f20666c;

            AnonymousClass1(com.opos.mobad.f.b bVar2, Context context2, String str2) {
                bVar = bVar2;
                context = context2;
                str = str2;
            }

            @Override // com.opos.mobad.f.a.b.a
            /* renamed from: a */
            public com.opos.mobad.ad.e.a b(e.a aVar, com.opos.mobad.f.a.a.n nVar) {
                com.opos.mobad.ad.c b2 = bVar.b(aVar.f23520a);
                if (b2 == null) {
                    return null;
                }
                return b2.a(context, str, aVar.f23521b, c.this.f20657b, c.this.new a(aVar.f23520a, nVar));
            }
        }, new com.opos.mobad.f.a.c.a(this.f20662i));
    }

    private com.opos.mobad.ad.e.f a(com.opos.mobad.ad.e.f fVar) {
        String str;
        f.a a2 = new f.a(this.f20662i).a(fVar.f19489a).a(fVar.f19492d).b(fVar.f19494f).c(com.opos.mobad.service.f.b().a(this.f20658c) == com.opos.mobad.m.a.n.VERTICAL.a()).a(fVar.f19495g);
        if (TextUtils.isEmpty(fVar.f19490b)) {
            Context context = this.f20662i;
            str = com.opos.mobad.l.n.a(context, context.getPackageName());
        } else {
            str = fVar.f19490b;
        }
        String str2 = TextUtils.isEmpty(fVar.f19491c) ? "欢迎使用" : fVar.f19491c;
        return a2.b(str2).a(str).a(k.a(fVar.f19493e, this.f20662i, str, str2)).a();
    }

    private com.opos.mobad.f.a.a.n<com.opos.mobad.ad.e.a> a(String str, com.opos.mobad.f.a.b.b<com.opos.mobad.ad.e.a> bVar, com.opos.mobad.f.a.c.a aVar) {
        return new com.opos.mobad.f.a.a.c(str, 60, new c.a<com.opos.mobad.f.a.a.n<com.opos.mobad.ad.e.a>>() { // from class: com.opos.mobad.f.a.c.3

            /* renamed from: a */
            final /* synthetic */ String f20670a;

            /* renamed from: b */
            final /* synthetic */ int f20671b;

            /* renamed from: c */
            final /* synthetic */ com.opos.mobad.f.a.b.b f20672c;

            /* renamed from: d */
            final /* synthetic */ com.opos.mobad.f.a.c.a f20673d;

            /* renamed from: e */
            final /* synthetic */ b.a f20674e;

            AnonymousClass3(String str2, int i2, com.opos.mobad.f.a.b.b bVar2, com.opos.mobad.f.a.c.a aVar2, b.a aVar22) {
                str = str2;
                k = i2;
                bVar = bVar2;
                aVar = aVar2;
                aVar2 = aVar22;
            }

            @Override // com.opos.mobad.f.a.a.c.a
            public int a(int i2) {
                return c.this.k.a(i2);
            }

            @Override // com.opos.mobad.f.a.a.c.a
            public com.opos.mobad.f.a.a.n<com.opos.mobad.ad.e.a> a(List<e.a> list, e.a aVar2, long j2) {
                return com.opos.mobad.f.a.a.k.a(str, new com.opos.mobad.f.a.d.b(k), list, aVar2, j2, bVar, aVar, aVar2);
            }

            @Override // com.opos.mobad.f.a.a.c.a
            public com.opos.mobad.f.a.a.n<com.opos.mobad.ad.e.a> a(List<e.a> list, e.a aVar2, long j2, int i2) {
                return com.opos.mobad.f.a.a.k.a(str, new com.opos.mobad.f.a.d.c(i2, k), list, aVar2, j2, bVar, aVar, aVar2);
            }
        });
    }

    public void k() {
        this.f20659d.removeAllViews();
        com.opos.mobad.f.a.a.n<com.opos.mobad.ad.e.a> nVar = this.f20663j;
        if (nVar == null) {
            return;
        }
        boolean z = nVar.j() != 1;
        if (z) {
            com.opos.mobad.ad.e.f fVar = this.f20657b;
            if (fVar.f19496h) {
                View a2 = fVar.f19493e.a();
                if (this.f20659d != null && a2 != null) {
                    if (a2.getParent() != null) {
                        ((ViewGroup) a2.getParent()).removeView(a2);
                    }
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, (int) ((com.opos.cmn.an.h.f.a.b(this.f20662i) * 0.3778f) + 0.5f));
                    layoutParams.addRule(12);
                    a2.setId(1);
                    a2.setBackgroundColor(-1);
                    l.a(this.f20659d, a2, layoutParams);
                }
            }
        }
        com.opos.mobad.ad.e.a i2 = this.f20663j.i();
        if (i2 != null) {
            View h2 = i2.h();
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
            if (z) {
                layoutParams2.addRule(2, 1);
            }
            if (l.a(this.f20659d, h2, layoutParams2)) {
                return;
            }
            c(10500, com.opos.mobad.ad.a.a(10500));
        }
    }

    @Override // com.opos.mobad.l.j, com.opos.mobad.ad.b
    public void a() {
        a(com.opos.mobad.service.f.b().k());
    }

    @Override // com.opos.mobad.ad.g.a, com.opos.mobad.ad.g
    public void a(int i2, String str, int i3) {
        if (com.opos.mobad.service.f.b().b(this.f20658c) && d() == 2 && !this.l) {
            this.l = true;
            com.opos.mobad.service.i.d.a().a(this.f20658c, this.m, i2, str, this.f20663j.j(), g(), i3);
        }
    }

    @Override // com.opos.mobad.ad.e.a
    public void a(Activity activity) {
        com.opos.mobad.ad.e.c cVar;
        String str;
        if (activity == null || activity.isFinishing() || activity.isDestroyed()) {
            cVar = this.f20660g;
            str = "activity error.";
        } else if (com.opos.cmn.an.h.f.a.a(activity)) {
            ViewGroup viewGroup = (ViewGroup) activity.findViewById(R.id.content);
            this.f20661h = viewGroup;
            if (viewGroup == null) {
                cVar = this.f20660g;
                str = "container null";
            } else {
                View h2 = h();
                if (h2 != null) {
                    ViewParent parent = h2.getParent();
                    if (parent != null) {
                        if (parent == this.f20661h) {
                            return;
                        }
                        if (parent instanceof ViewGroup) {
                            ((ViewGroup) parent).removeView(h2);
                        } else {
                            cVar = this.f20660g;
                            str = "view had add to container";
                        }
                    }
                    this.f20661h.addView(h2, new ViewGroup.LayoutParams(-1, -1));
                    if (this.f20663j.j() == 1 || this.f20663j.j() == 8) {
                        this.f20663j.i().a(activity);
                        return;
                    }
                    return;
                }
                cVar = this.f20660g;
                str = "unknown error.";
            }
        } else {
            cVar = this.f20660g;
            str = "splash must be displayed in full screen mode.";
        }
        cVar.a(-1, str);
    }

    @Override // com.opos.mobad.l.j, com.opos.mobad.ad.b
    public void b() {
        RelativeLayout relativeLayout;
        super.b();
        com.opos.mobad.f.a.a.n<com.opos.mobad.ad.e.a> nVar = this.f20663j;
        if (nVar != null) {
            nVar.b();
        }
        ViewGroup viewGroup = this.f20661h;
        if (viewGroup != null && (relativeLayout = this.f20659d) != null) {
            viewGroup.removeView(relativeLayout);
        }
        this.f20661h = null;
    }

    @Override // com.opos.mobad.ad.g.a, com.opos.mobad.ad.g
    public void b(int i2) {
        if (com.opos.mobad.service.f.b().b(this.f20658c) && d() == 2 && !this.l) {
            this.l = true;
            com.opos.mobad.service.i.d.a().a(this.f20658c, this.m, this.f20663j.j(), g(), i2);
        }
    }

    @Override // com.opos.mobad.l.j
    protected boolean b(String str) {
        return false;
    }

    @Override // com.opos.mobad.l.j
    protected boolean b(String str, int i2) {
        c("doload");
        this.l = false;
        this.m = str;
        this.f20663j.a(str, i2);
        return true;
    }

    @Override // com.opos.mobad.ad.b
    public int c() {
        return 0;
    }

    @Override // com.opos.mobad.ad.g.a, com.opos.mobad.ad.g
    public void c(int i2) {
        com.opos.mobad.ad.e.a i3;
        if (com.opos.mobad.service.f.b().b(this.f20658c) && (i3 = this.f20663j.i()) != null) {
            i3.c(i2);
        }
    }

    public void c(String str) {
        com.opos.cmn.an.f.a.b("delegator Splash", str);
    }

    @Override // com.opos.mobad.l.j, com.opos.mobad.ad.b
    public boolean e() {
        com.opos.mobad.ad.e.a i2 = this.f20663j.i();
        if (i2 != null) {
            return i2.e();
        }
        return false;
    }

    @Override // com.opos.mobad.ad.g.a, com.opos.mobad.ad.g
    public int g() {
        com.opos.mobad.ad.e.a i2;
        int i3;
        if (com.opos.mobad.service.f.b().b(this.f20658c) && (i2 = this.f20663j.i()) != null) {
            int g2 = i2.g();
            if (g2 > 0) {
                return g2;
            }
            e.a k = this.f20663j.k();
            if (k != null && (i3 = k.f23526g) > 0) {
                return i3;
            }
        }
        return 0;
    }

    @Override // com.opos.mobad.ad.e.b
    public View h() {
        if (d() != 2) {
            return null;
        }
        k();
        return this.f20659d;
    }
}
