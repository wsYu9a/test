package com.opos.mobad.f.a;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.opos.mobad.ad.b;
import com.opos.mobad.ad.e.f;
import com.opos.mobad.f.a.a.c;
import com.opos.mobad.service.a.e;
import java.util.List;

/* loaded from: classes4.dex */
public class j extends com.opos.mobad.l.i {

    /* renamed from: a */
    public static final String f20763a = "j";

    /* renamed from: b */
    private com.opos.mobad.ad.e.f f20764b;

    /* renamed from: c */
    private String f20765c;

    /* renamed from: d */
    private RelativeLayout f20766d;

    /* renamed from: g */
    private ViewGroup f20767g;

    /* renamed from: h */
    private Context f20768h;

    /* renamed from: i */
    private com.opos.mobad.f.a.a.n<com.opos.mobad.ad.e.b> f20769i;

    /* renamed from: j */
    private RelativeLayout f20770j;
    private com.opos.mobad.f.b k;

    /* renamed from: com.opos.mobad.f.a.j$1 */
    class AnonymousClass1 implements com.opos.mobad.f.a.b.b<com.opos.mobad.ad.e.b> {

        /* renamed from: a */
        final /* synthetic */ com.opos.mobad.f.b f20771a;

        /* renamed from: b */
        final /* synthetic */ Activity f20772b;

        /* renamed from: c */
        final /* synthetic */ String f20773c;

        AnonymousClass1(com.opos.mobad.f.b bVar, Activity activity, String str) {
            bVar = bVar;
            activity = activity;
            str = str;
        }

        @Override // com.opos.mobad.f.a.b.a
        /* renamed from: a */
        public com.opos.mobad.ad.e.b b(e.a aVar, com.opos.mobad.f.a.a.n nVar) {
            com.opos.mobad.ad.c b2 = bVar.b(aVar.f23520a);
            if (b2 == null) {
                return null;
            }
            return b2.a(activity, str, aVar.f23521b, j.this.f20764b, (com.opos.mobad.ad.e.c) j.this.new a(aVar.f23520a, nVar));
        }
    }

    /* renamed from: com.opos.mobad.f.a.j$2 */
    class AnonymousClass2 implements b.a {

        /* renamed from: com.opos.mobad.f.a.j$2$1 */
        class AnonymousClass1 implements Runnable {
            AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (j.this.d() == 5) {
                    j.this.c("remove but has destroy");
                } else {
                    j.this.m();
                    j.this.k();
                }
            }
        }

        AnonymousClass2() {
        }

        @Override // com.opos.mobad.ad.b.a
        public void a() {
            j.this.c("onAdReady");
            com.opos.mobad.service.c.c(new Runnable() { // from class: com.opos.mobad.f.a.j.2.1
                AnonymousClass1() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (j.this.d() == 5) {
                        j.this.c("remove but has destroy");
                    } else {
                        j.this.m();
                        j.this.k();
                    }
                }
            });
            j.this.o();
        }

        @Override // com.opos.mobad.ad.b.a
        public void a(int i2, String str) {
            j.this.c("onAdFailed code=" + i2 + ",msg =" + str);
            j.this.b(com.opos.mobad.f.a.a.l.a(i2), str);
            j.this.m();
        }

        @Override // com.opos.mobad.ad.b.a
        public void b() {
            j.this.c("onAdClose");
            j.this.i_();
        }
    }

    /* renamed from: com.opos.mobad.f.a.j$3 */
    class AnonymousClass3 implements c.a<com.opos.mobad.f.a.a.n<com.opos.mobad.ad.e.b>> {

        /* renamed from: a */
        final /* synthetic */ String f20777a;

        /* renamed from: b */
        final /* synthetic */ int f20778b;

        /* renamed from: c */
        final /* synthetic */ com.opos.mobad.f.a.b.b f20779c;

        /* renamed from: d */
        final /* synthetic */ com.opos.mobad.f.a.c.a f20780d;

        /* renamed from: e */
        final /* synthetic */ b.a f20781e;

        AnonymousClass3(String str, int i2, com.opos.mobad.f.a.b.b bVar, com.opos.mobad.f.a.c.a aVar, b.a aVar2) {
            str = str;
            k = i2;
            bVar = bVar;
            aVar = aVar;
            aVar2 = aVar2;
        }

        @Override // com.opos.mobad.f.a.a.c.a
        public int a(int i2) {
            return j.this.k.a(i2);
        }

        @Override // com.opos.mobad.f.a.a.c.a
        public com.opos.mobad.f.a.a.n<com.opos.mobad.ad.e.b> a(List<e.a> list, e.a aVar, long j2) {
            return com.opos.mobad.f.a.a.k.a(str, new com.opos.mobad.f.a.d.b(k), list, aVar, j2, bVar, aVar, aVar2);
        }

        @Override // com.opos.mobad.f.a.a.c.a
        public com.opos.mobad.f.a.a.n<com.opos.mobad.ad.e.b> a(List<e.a> list, e.a aVar, long j2, int i2) {
            return com.opos.mobad.f.a.a.k.a(str, new com.opos.mobad.f.a.d.c(i2, k), list, aVar, j2, bVar, aVar, aVar2);
        }
    }

    private class a extends com.opos.mobad.f.a.a.b implements com.opos.mobad.ad.e.c {

        /* renamed from: c */
        private final int f20784c;

        public a(int i2, com.opos.mobad.f.a.a.n nVar) {
            super(i2, nVar);
            this.f20784c = i2;
        }

        @Override // com.opos.mobad.f.a.a.b, com.opos.mobad.ad.b.a
        public void a(int i2, String str) {
            j.this.c("ad failed:" + i2 + ",msg:" + str + ", state=" + j.this.d());
            if (1 == j.this.d()) {
                super.a(i2, str);
                return;
            }
            if (2 == j.this.d() && this.f20784c == j.this.f20769i.j()) {
                j.this.c(i2, str);
                return;
            }
            j.this.c("ignore fail:" + this.f20784c);
        }

        @Override // com.opos.mobad.ad.i.b
        public void a(long j2) {
            j.this.c("ad click:" + this.f20784c + "," + j.this.f20769i.i());
            if (this.f20784c != j.this.f20769i.j()) {
                return;
            }
            com.opos.mobad.service.j.n.a().b(j.this.f20765c);
            j.this.i();
        }

        @Override // com.opos.mobad.ad.i.b
        public void a(String str) {
            j.this.c("ad show");
            if (this.f20784c != j.this.f20769i.j()) {
                return;
            }
            com.opos.mobad.service.j.n.a().a(j.this.f20765c);
            j.this.d(str);
        }

        @Override // com.opos.mobad.f.a.a.b, com.opos.mobad.ad.b.a
        public void b() {
            j.this.c("ad close:" + this.f20784c + "," + j.this.f20769i.i());
            if (this.f20784c != j.this.f20769i.j()) {
                return;
            }
            j.this.i_();
        }
    }

    public j(Activity activity, String str, com.opos.mobad.ad.e.f fVar, com.opos.mobad.ad.e.c cVar, com.opos.mobad.f.b bVar) {
        super(cVar);
        String str2;
        String str3;
        if (fVar == null) {
            str2 = f20763a;
            str3 = "SplashAd params null.";
        } else {
            if (activity == null || activity.isFinishing() || activity.isDestroyed()) {
                com.opos.cmn.an.f.a.c("", "SplashAd constructor param activity error.");
                c(-1, "SplashAd Constructor param Activity was died.");
                return;
            }
            if (com.opos.cmn.an.h.f.a.a(activity)) {
                this.f20765c = str;
                this.f20768h = activity.getApplicationContext();
                this.f20764b = a(fVar);
                this.f20766d = new RelativeLayout(this.f20768h);
                this.f20767g = (ViewGroup) activity.getWindow().getDecorView().findViewById(R.id.content);
                this.k = bVar;
                if (a(this.f20764b.f19493e.a())) {
                    String a2 = com.opos.mobad.ad.a.a(10502);
                    c(10502, a2);
                    com.opos.cmn.an.f.a.c(f20763a, a2);
                    return;
                } else {
                    if (fVar.f19496h) {
                        a(this.f20768h, this.f20764b);
                    }
                    this.f20769i = a(str, new com.opos.mobad.f.a.b.b<com.opos.mobad.ad.e.b>() { // from class: com.opos.mobad.f.a.j.1

                        /* renamed from: a */
                        final /* synthetic */ com.opos.mobad.f.b f20771a;

                        /* renamed from: b */
                        final /* synthetic */ Activity f20772b;

                        /* renamed from: c */
                        final /* synthetic */ String f20773c;

                        AnonymousClass1(com.opos.mobad.f.b bVar2, Activity activity2, String str4) {
                            bVar = bVar2;
                            activity = activity2;
                            str = str4;
                        }

                        @Override // com.opos.mobad.f.a.b.a
                        /* renamed from: a */
                        public com.opos.mobad.ad.e.b b(e.a aVar, com.opos.mobad.f.a.a.n nVar) {
                            com.opos.mobad.ad.c b2 = bVar.b(aVar.f23520a);
                            if (b2 == null) {
                                return null;
                            }
                            return b2.a(activity, str, aVar.f23521b, j.this.f20764b, (com.opos.mobad.ad.e.c) j.this.new a(aVar.f23520a, nVar));
                        }
                    }, new com.opos.mobad.f.a.c.a(this.f20768h));
                    return;
                }
            }
            str2 = f20763a;
            str3 = "SplashAd must be displayed in full screen mode.";
        }
        com.opos.cmn.an.f.a.c(str2, str3);
        c(-1, str3);
    }

    private com.opos.mobad.ad.e.f a(com.opos.mobad.ad.e.f fVar) {
        String str;
        f.a a2 = new f.a(this.f20768h).a(fVar.f19489a).a(fVar.f19492d).b(fVar.f19494f).c(fVar.f19496h).a(fVar.f19495g);
        if (TextUtils.isEmpty(fVar.f19490b)) {
            Context context = this.f20768h;
            str = com.opos.mobad.l.n.a(context, context.getPackageName());
        } else {
            str = fVar.f19490b;
        }
        String str2 = TextUtils.isEmpty(fVar.f19491c) ? "欢迎使用" : fVar.f19491c;
        return a2.b(str2).a(str).a(k.a(fVar.f19493e, this.f20768h, str, str2)).a();
    }

    private com.opos.mobad.f.a.a.n<com.opos.mobad.ad.e.b> a(String str, com.opos.mobad.f.a.b.b<com.opos.mobad.ad.e.b> bVar, com.opos.mobad.f.a.c.a aVar) {
        return new com.opos.mobad.f.a.a.c(str, 60, new c.a<com.opos.mobad.f.a.a.n<com.opos.mobad.ad.e.b>>() { // from class: com.opos.mobad.f.a.j.3

            /* renamed from: a */
            final /* synthetic */ String f20777a;

            /* renamed from: b */
            final /* synthetic */ int f20778b;

            /* renamed from: c */
            final /* synthetic */ com.opos.mobad.f.a.b.b f20779c;

            /* renamed from: d */
            final /* synthetic */ com.opos.mobad.f.a.c.a f20780d;

            /* renamed from: e */
            final /* synthetic */ b.a f20781e;

            AnonymousClass3(String str2, int i2, com.opos.mobad.f.a.b.b bVar2, com.opos.mobad.f.a.c.a aVar2, b.a aVar22) {
                str = str2;
                k = i2;
                bVar = bVar2;
                aVar = aVar2;
                aVar2 = aVar22;
            }

            @Override // com.opos.mobad.f.a.a.c.a
            public int a(int i2) {
                return j.this.k.a(i2);
            }

            @Override // com.opos.mobad.f.a.a.c.a
            public com.opos.mobad.f.a.a.n<com.opos.mobad.ad.e.b> a(List<e.a> list, e.a aVar2, long j2) {
                return com.opos.mobad.f.a.a.k.a(str, new com.opos.mobad.f.a.d.b(k), list, aVar2, j2, bVar, aVar, aVar2);
            }

            @Override // com.opos.mobad.f.a.a.c.a
            public com.opos.mobad.f.a.a.n<com.opos.mobad.ad.e.b> a(List<e.a> list, e.a aVar2, long j2, int i2) {
                return com.opos.mobad.f.a.a.k.a(str, new com.opos.mobad.f.a.d.c(i2, k), list, aVar2, j2, bVar, aVar, aVar2);
            }
        });
    }

    private boolean a(View view) {
        return (view == null || view.getParent() == null) ? false : true;
    }

    public void k() {
        this.f20766d.removeAllViews();
        com.opos.mobad.f.a.a.n<com.opos.mobad.ad.e.b> nVar = this.f20769i;
        if (nVar == null) {
            return;
        }
        boolean z = nVar.j() != 1;
        if (z) {
            com.opos.mobad.ad.e.f fVar = this.f20764b;
            if (fVar.f19496h) {
                View a2 = fVar.f19493e.a();
                if (this.f20766d != null && a2 != null) {
                    if (a2.getParent() != null) {
                        ((ViewGroup) a2.getParent()).removeView(a2);
                    }
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, (int) ((com.opos.cmn.an.h.f.a.b(this.f20768h) * 0.3778f) + 0.5f));
                    layoutParams.addRule(12);
                    a2.setId(1);
                    a2.setBackgroundColor(-1);
                    l.a(this.f20766d, a2, layoutParams);
                }
            }
        }
        com.opos.mobad.ad.e.b i2 = this.f20769i.i();
        if (i2 != null) {
            View h2 = i2.h();
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
            if (z) {
                layoutParams2.addRule(2, 1);
            }
            if (!l.a(this.f20766d, h2, layoutParams2)) {
                c(10500, com.opos.mobad.ad.a.a(10500));
                return;
            }
        }
        l.a(this.f20767g, this.f20766d);
    }

    public void m() {
        if (d() == 5) {
            c("remove pre view but has destroy");
            return;
        }
        c("removePreLoadView");
        RelativeLayout relativeLayout = this.f20770j;
        if (relativeLayout != null) {
            this.f20767g.removeView(relativeLayout);
            this.f20770j.removeAllViews();
            this.f20770j = null;
        }
    }

    @Override // com.opos.mobad.l.j, com.opos.mobad.ad.b
    public void a() {
        a(com.opos.mobad.service.f.b().k());
    }

    public void a(Context context, com.opos.mobad.ad.e.f fVar) {
        View a2 = fVar.f19493e.a();
        boolean z = fVar.f19492d;
        c("showPreLoadPage: " + z);
        if (z) {
            RelativeLayout relativeLayout = new RelativeLayout(context);
            this.f20770j = relativeLayout;
            relativeLayout.setBackgroundColor(-1);
            this.f20770j.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, l.a(context));
            layoutParams.addRule(12);
            this.f20770j.addView(a2, layoutParams);
            l.a(this.f20767g, this.f20770j);
        }
    }

    @Override // com.opos.mobad.l.j, com.opos.mobad.ad.b
    public void b() {
        super.b();
        com.opos.mobad.f.a.a.n<com.opos.mobad.ad.e.b> nVar = this.f20769i;
        if (nVar != null) {
            nVar.b();
        }
        ViewGroup viewGroup = this.f20767g;
        if (viewGroup != null) {
            RelativeLayout relativeLayout = this.f20770j;
            if (relativeLayout != null) {
                viewGroup.removeView(relativeLayout);
            }
            RelativeLayout relativeLayout2 = this.f20766d;
            if (relativeLayout2 != null) {
                viewGroup.removeView(relativeLayout2);
            }
            this.f20767g = null;
        }
    }

    @Override // com.opos.mobad.l.j
    protected boolean b(String str) {
        return false;
    }

    @Override // com.opos.mobad.l.j
    protected boolean b(String str, int i2) {
        c("doload");
        this.f20769i.a(str, i2);
        return true;
    }

    @Override // com.opos.mobad.ad.b
    public int c() {
        return 0;
    }

    public void c(String str) {
        com.opos.cmn.an.f.a.b("delegator Splash", str);
    }

    @Override // com.opos.mobad.l.j, com.opos.mobad.ad.b
    public boolean e() {
        com.opos.mobad.ad.e.b i2 = this.f20769i.i();
        if (i2 != null) {
            return i2.e();
        }
        return false;
    }

    @Override // com.opos.mobad.ad.e.b
    public View h() {
        if (d() != 2) {
            return null;
        }
        k();
        return this.f20766d;
    }
}
