package com.opos.mobad.a;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import com.opos.cmn.i.j;
import com.opos.mobad.cmn.a.a;
import com.opos.mobad.cmn.a.b.f;
import com.opos.mobad.cmn.service.pkginstall.b;
import com.opos.mobad.model.b;
import com.opos.mobad.model.data.AdData;
import com.opos.mobad.model.data.AdItemData;
import com.opos.mobad.model.e.a;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes4.dex */
public class d extends com.opos.mobad.l.a implements com.opos.mobad.ad.a.a {

    /* renamed from: a */
    private static Map<String, Boolean> f19350a = new ConcurrentHashMap();

    /* renamed from: b */
    private Activity f19351b;

    /* renamed from: c */
    private final Handler f19352c;

    /* renamed from: d */
    private com.opos.mobad.a.a.b f19353d;

    /* renamed from: g */
    private c f19354g;

    /* renamed from: h */
    private boolean f19355h;

    /* renamed from: i */
    private String f19356i;

    /* renamed from: j */
    private int f19357j;
    private a.C0457a k;
    private boolean l;
    private Context m;
    private a.b n;
    private b.InterfaceC0437b o;
    private a p;

    /* renamed from: com.opos.mobad.a.d$1 */
    class AnonymousClass1 extends Handler {
        AnonymousClass1() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 0) {
                return;
            }
            com.opos.cmn.an.f.a.b("InterBannerAd", "adHandler WHAT_REFRESH_AD:");
            d dVar = d.this;
            if (dVar.a(dVar.f19351b) || !com.opos.cmn.an.h.a.a.d(d.this.f19351b) || !f.a(d.this.f19351b) || (2 == d.this.d() && !d.this.m())) {
                d dVar2 = d.this;
                if (dVar2.a(dVar2.f19351b)) {
                    return;
                }
                d.this.a(-1, (AdData) null);
                return;
            }
            if (!d.this.r() && !j.a(d.this.f19351b, d.this.h())) {
                d.this.a(com.opos.cmn.i.f.a());
                return;
            }
            com.opos.cmn.an.f.a.b("InterBannerAd", "isBannerCovered() || isBannerCoveredOnShapedScreen()=true");
            d.this.q();
            d.this.c(11004, "you should't play ad on the top in the shaped screen mobile");
        }
    }

    /* renamed from: com.opos.mobad.a.d$2 */
    class AnonymousClass2 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ a.C0457a f19359a;

        /* renamed from: b */
        final /* synthetic */ com.opos.mobad.n.a f19360b;

        AnonymousClass2(a.C0457a c0457a, com.opos.mobad.n.a aVar) {
            c0457a = c0457a;
            aVar = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.opos.cmn.an.f.a.b("InterBannerAd", "show ad view:", d.this.k);
            if (c0457a != null) {
                d.this.f19354g.a(c0457a, aVar);
            }
            d.this.k();
        }
    }

    /* renamed from: com.opos.mobad.a.d$3 */
    class AnonymousClass3 implements b.a {

        /* renamed from: com.opos.mobad.a.d$3$1 */
        class AnonymousClass1 implements Callable<Boolean> {

            /* renamed from: a */
            final /* synthetic */ int f19363a;

            /* renamed from: b */
            final /* synthetic */ a.C0457a f19364b;

            AnonymousClass1(int i2, a.C0457a c0457a) {
                i3 = i2;
                c0457a = c0457a;
            }

            @Override // java.util.concurrent.Callable
            /* renamed from: a */
            public Boolean call() throws Exception {
                d.this.f19357j = i3;
                d.this.k = c0457a;
                com.opos.mobad.service.a.b a2 = com.opos.mobad.service.f.a();
                String str = d.this.f19356i;
                d dVar = d.this;
                a2.a(str, dVar.b(dVar.k.f21743a));
                return Boolean.TRUE;
            }
        }

        AnonymousClass3() {
        }

        @Override // com.opos.mobad.model.b.a
        public void a(int i2, a.C0457a c0457a) {
            if (c0457a != null && c0457a.f21743a.a() == 1) {
                com.opos.mobad.service.a.a().a(d.this.f19356i, 1, c0457a.f21744b.f(), c0457a.f21744b.b(), c0457a.f21745c.aa(), c0457a.f21744b.a(), c0457a.f21744b.J());
                d.this.f19357j = c0457a.f21743a.c();
                d.this.c(-1, com.opos.mobad.ad.a.a(-1));
                return;
            }
            d.this.c(new Callable<Boolean>() { // from class: com.opos.mobad.a.d.3.1

                /* renamed from: a */
                final /* synthetic */ int f19363a;

                /* renamed from: b */
                final /* synthetic */ a.C0457a f19364b;

                AnonymousClass1(int i22, a.C0457a c0457a2) {
                    i3 = i22;
                    c0457a = c0457a2;
                }

                @Override // java.util.concurrent.Callable
                /* renamed from: a */
                public Boolean call() throws Exception {
                    d.this.f19357j = i3;
                    d.this.k = c0457a;
                    com.opos.mobad.service.a.b a2 = com.opos.mobad.service.f.a();
                    String str = d.this.f19356i;
                    d dVar = d.this;
                    a2.a(str, dVar.b(dVar.k.f21743a));
                    return Boolean.TRUE;
                }
            });
            d dVar = d.this;
            if (dVar.a(dVar.f19351b)) {
                return;
            }
            d dVar2 = d.this;
            dVar2.a(dVar2.k, e.a(d.this.m, c0457a2));
        }

        @Override // com.opos.mobad.model.b.a
        public void a(int i2, String str, AdData adData) {
            d.this.b(i2, str);
            if (adData != null) {
                d.this.f19357j = adData.c();
            }
            d.this.a(adData);
        }
    }

    /* renamed from: com.opos.mobad.a.d$4 */
    class AnonymousClass4 implements b.InterfaceC0437b {
        AnonymousClass4() {
        }

        @Override // com.opos.mobad.cmn.service.pkginstall.b.InterfaceC0437b
        public void a(AdItemData adItemData, String str) {
            com.opos.cmn.an.f.a.b("InterBannerAd", "notifyInstallCompletedEvent:" + str);
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(d.this.k.f21745c.k()) || !d.this.k.f21745c.k().equals(str)) {
                return;
            }
            d.this.f19354g.d();
        }

        @Override // com.opos.mobad.cmn.service.pkginstall.b.InterfaceC0437b
        public void b(AdItemData adItemData, String str) {
        }

        @Override // com.opos.mobad.cmn.service.pkginstall.b.InterfaceC0437b
        public void c(AdItemData adItemData, String str) {
        }
    }

    /* renamed from: com.opos.mobad.a.d$5 */
    class AnonymousClass5 extends a {
        AnonymousClass5() {
        }

        @Override // com.opos.mobad.cmn.a.a.a.b
        public void a(int i2, String str) {
            d.this.c(i2, str);
        }

        @Override // com.opos.mobad.ad.i.b
        public void a(long j2) {
            d.this.i();
        }

        @Override // com.opos.mobad.ad.i.b
        public void a(String str) {
            d.this.g_();
        }

        @Override // com.opos.mobad.a.a
        public void a(boolean z) {
            com.opos.cmn.an.f.a.b("IRewardListener", "onVisibilityChange = " + z);
            d.this.l = z;
            d.this.k();
        }

        @Override // com.opos.mobad.cmn.a.a.a.b
        public void d() {
            d.this.f19353d.d();
            d.this.i_();
            d.this.p();
        }
    }

    public d(Activity activity, String str, boolean z, com.opos.mobad.cmn.a.d dVar, com.opos.mobad.ad.a.b bVar, com.opos.mobad.cmn.b.c cVar) {
        super(bVar);
        this.f19352c = new Handler() { // from class: com.opos.mobad.a.d.1
            AnonymousClass1() {
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what != 0) {
                    return;
                }
                com.opos.cmn.an.f.a.b("InterBannerAd", "adHandler WHAT_REFRESH_AD:");
                d dVar2 = d.this;
                if (dVar2.a(dVar2.f19351b) || !com.opos.cmn.an.h.a.a.d(d.this.f19351b) || !f.a(d.this.f19351b) || (2 == d.this.d() && !d.this.m())) {
                    d dVar22 = d.this;
                    if (dVar22.a(dVar22.f19351b)) {
                        return;
                    }
                    d.this.a(-1, (AdData) null);
                    return;
                }
                if (!d.this.r() && !j.a(d.this.f19351b, d.this.h())) {
                    d.this.a(com.opos.cmn.i.f.a());
                    return;
                }
                com.opos.cmn.an.f.a.b("InterBannerAd", "isBannerCovered() || isBannerCoveredOnShapedScreen()=true");
                d.this.q();
                d.this.c(11004, "you should't play ad on the top in the shaped screen mobile");
            }
        };
        this.f19357j = 0;
        this.l = false;
        this.o = new b.InterfaceC0437b() { // from class: com.opos.mobad.a.d.4
            AnonymousClass4() {
            }

            @Override // com.opos.mobad.cmn.service.pkginstall.b.InterfaceC0437b
            public void a(AdItemData adItemData, String str2) {
                com.opos.cmn.an.f.a.b("InterBannerAd", "notifyInstallCompletedEvent:" + str2);
                if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(d.this.k.f21745c.k()) || !d.this.k.f21745c.k().equals(str2)) {
                    return;
                }
                d.this.f19354g.d();
            }

            @Override // com.opos.mobad.cmn.service.pkginstall.b.InterfaceC0437b
            public void b(AdItemData adItemData, String str2) {
            }

            @Override // com.opos.mobad.cmn.service.pkginstall.b.InterfaceC0437b
            public void c(AdItemData adItemData, String str2) {
            }
        };
        this.p = new a() { // from class: com.opos.mobad.a.d.5
            AnonymousClass5() {
            }

            @Override // com.opos.mobad.cmn.a.a.a.b
            public void a(int i2, String str2) {
                d.this.c(i2, str2);
            }

            @Override // com.opos.mobad.ad.i.b
            public void a(long j2) {
                d.this.i();
            }

            @Override // com.opos.mobad.ad.i.b
            public void a(String str2) {
                d.this.g_();
            }

            @Override // com.opos.mobad.a.a
            public void a(boolean z2) {
                com.opos.cmn.an.f.a.b("IRewardListener", "onVisibilityChange = " + z2);
                d.this.l = z2;
                d.this.k();
            }

            @Override // com.opos.mobad.cmn.a.a.a.b
            public void d() {
                d.this.f19353d.d();
                d.this.i_();
                d.this.p();
            }
        };
        this.f19356i = str;
        this.f19351b = activity;
        this.m = activity.getApplicationContext();
        this.f19355h = z;
        com.opos.mobad.cmn.a.a aVar = new com.opos.mobad.cmn.a.a(activity, this.f19356i, dVar);
        this.f19353d = new com.opos.mobad.a.a.b(this.m);
        this.f19354g = new c(this.f19351b, str, aVar, new com.opos.mobad.o.a.a(this.m, null), new com.opos.mobad.cmn.b.e(cVar), this.o, this.p, this.f19353d);
        a.b b2 = f.b(activity);
        this.n = b2;
        aVar.a(b2);
    }

    public void a(int i2, AdData adData) {
        synchronized (this) {
            com.opos.cmn.an.f.a.b("InterBannerAd", "setNextRefreshAdEvent code=", Integer.valueOf(i2), "adData=", adData);
            int i3 = 30;
            if (10000 == i2 && adData != null) {
                i3 = b(adData);
            }
            com.opos.cmn.an.f.a.b("InterBannerAd", "refreshAdTime=" + i3);
            if (!this.f19352c.hasMessages(0)) {
                this.f19352c.sendEmptyMessageDelayed(0, i3 * 1000);
            }
        }
    }

    public void a(AdData adData) {
        if (!this.f19355h) {
            com.opos.cmn.an.f.a.b("InterBannerAd", "do not carousel");
            return;
        }
        com.opos.cmn.an.f.a.b("InterBannerAd", "refreshAdTime=" + (adData != null ? b(adData) : 30));
        if (this.f19352c.hasMessages(0)) {
            return;
        }
        this.f19352c.sendEmptyMessageDelayed(0, r0 * 1000);
    }

    public void a(a.C0457a c0457a, com.opos.mobad.n.a aVar) {
        com.opos.mobad.service.c.a(new Runnable() { // from class: com.opos.mobad.a.d.2

            /* renamed from: a */
            final /* synthetic */ a.C0457a f19359a;

            /* renamed from: b */
            final /* synthetic */ com.opos.mobad.n.a f19360b;

            AnonymousClass2(a.C0457a c0457a2, com.opos.mobad.n.a aVar2) {
                c0457a = c0457a2;
                aVar = aVar2;
            }

            @Override // java.lang.Runnable
            public void run() {
                com.opos.cmn.an.f.a.b("InterBannerAd", "show ad view:", d.this.k);
                if (c0457a != null) {
                    d.this.f19354g.a(c0457a, aVar);
                }
                d.this.k();
            }
        });
    }

    public int b(AdData adData) {
        if (adData == null || adData.f() == null || adData.f().size() <= 0 || adData.f().get(0) == null) {
            return 30;
        }
        return adData.f().get(0).m();
    }

    public void k() {
        if (this.l) {
            a.C0457a c0457a = this.k;
            a(c0457a != null ? c0457a.f21743a : null);
        }
    }

    public boolean m() {
        View h2 = h();
        return h2 != null && h2.isShown();
    }

    public void p() {
        if (5 == d() || !this.f19352c.hasMessages(0)) {
            return;
        }
        this.f19352c.removeMessages(0);
    }

    public void q() {
        try {
            com.opos.cmn.an.f.a.b("InterBannerAd", "setBannerCovered posId=" + this.f19356i);
            f19350a.put(this.f19356i, Boolean.TRUE);
            if (this.f19352c.hasMessages(0)) {
                this.f19352c.removeMessages(0);
            }
            this.f19354g.c();
            com.opos.cmn.an.f.a.b("InterBannerAd", "mIBannerPresenter.destroyAd()");
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.a("InterBannerAd", "", (Throwable) e2);
        }
    }

    public boolean r() {
        boolean z;
        try {
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.a("InterBannerAd", "", (Throwable) e2);
        }
        if (f19350a.containsKey(this.f19356i)) {
            z = f19350a.get(this.f19356i).booleanValue();
            com.opos.cmn.an.f.a.b("InterBannerAd", "isBannerCovered=" + z);
            return z;
        }
        z = false;
        com.opos.cmn.an.f.a.b("InterBannerAd", "isBannerCovered=" + z);
        return z;
    }

    @Override // com.opos.mobad.ad.a.a
    public void a(int i2, int i3) {
    }

    @Override // com.opos.mobad.l.j, com.opos.mobad.ad.b
    public void a(String str) {
        a(str, 30000);
    }

    @Override // com.opos.mobad.l.j, com.opos.mobad.ad.b
    public void a(String str, int i2) {
        int i3;
        if (!f.e()) {
            i3 = 11005;
        } else if (!r() && !j.a(this.m, h())) {
            super.a(str, i2);
            return;
        } else {
            com.opos.cmn.an.f.a.b("InterBannerAd", "isBannerCovered() || isBannerCoveredOnShapedScreen()=true");
            q();
            i3 = 11004;
        }
        c(i3, com.opos.mobad.ad.a.a(i3));
    }

    protected boolean a(Activity activity) {
        boolean z = activity == null || activity.isFinishing();
        com.opos.cmn.an.f.a.b("InterBannerAd", "isActivityFinished=" + z);
        return z;
    }

    @Override // com.opos.mobad.l.a, com.opos.mobad.l.j, com.opos.mobad.ad.b
    public void b() {
        synchronized (this) {
            com.opos.cmn.an.f.a.b("InterBannerAd", "destroyAd");
            if (this.f19352c.hasMessages(0)) {
                this.f19352c.removeMessages(0);
            }
            this.f19354g.c();
            this.f19351b = null;
            this.n.a();
            super.b();
        }
    }

    @Override // com.opos.mobad.l.j
    protected boolean b(String str) {
        return false;
    }

    @Override // com.opos.mobad.l.j
    protected boolean b(String str, int i2) {
        this.f19357j = 0;
        com.opos.mobad.model.b.a(this.m.getApplicationContext()).a(this.m, this.f19356i, 1, str, i2, new b.a() { // from class: com.opos.mobad.a.d.3

            /* renamed from: com.opos.mobad.a.d$3$1 */
            class AnonymousClass1 implements Callable<Boolean> {

                /* renamed from: a */
                final /* synthetic */ int f19363a;

                /* renamed from: b */
                final /* synthetic */ a.C0457a f19364b;

                AnonymousClass1(int i22, a.C0457a c0457a2) {
                    i3 = i22;
                    c0457a = c0457a2;
                }

                @Override // java.util.concurrent.Callable
                /* renamed from: a */
                public Boolean call() throws Exception {
                    d.this.f19357j = i3;
                    d.this.k = c0457a;
                    com.opos.mobad.service.a.b a2 = com.opos.mobad.service.f.a();
                    String str = d.this.f19356i;
                    d dVar = d.this;
                    a2.a(str, dVar.b(dVar.k.f21743a));
                    return Boolean.TRUE;
                }
            }

            AnonymousClass3() {
            }

            @Override // com.opos.mobad.model.b.a
            public void a(int i22, a.C0457a c0457a2) {
                if (c0457a2 != null && c0457a2.f21743a.a() == 1) {
                    com.opos.mobad.service.a.a().a(d.this.f19356i, 1, c0457a2.f21744b.f(), c0457a2.f21744b.b(), c0457a2.f21745c.aa(), c0457a2.f21744b.a(), c0457a2.f21744b.J());
                    d.this.f19357j = c0457a2.f21743a.c();
                    d.this.c(-1, com.opos.mobad.ad.a.a(-1));
                    return;
                }
                d.this.c(new Callable<Boolean>() { // from class: com.opos.mobad.a.d.3.1

                    /* renamed from: a */
                    final /* synthetic */ int f19363a;

                    /* renamed from: b */
                    final /* synthetic */ a.C0457a f19364b;

                    AnonymousClass1(int i222, a.C0457a c0457a22) {
                        i3 = i222;
                        c0457a = c0457a22;
                    }

                    @Override // java.util.concurrent.Callable
                    /* renamed from: a */
                    public Boolean call() throws Exception {
                        d.this.f19357j = i3;
                        d.this.k = c0457a;
                        com.opos.mobad.service.a.b a2 = com.opos.mobad.service.f.a();
                        String str2 = d.this.f19356i;
                        d dVar = d.this;
                        a2.a(str2, dVar.b(dVar.k.f21743a));
                        return Boolean.TRUE;
                    }
                });
                d dVar = d.this;
                if (dVar.a(dVar.f19351b)) {
                    return;
                }
                d dVar2 = d.this;
                dVar2.a(dVar2.k, e.a(d.this.m, c0457a22));
            }

            @Override // com.opos.mobad.model.b.a
            public void a(int i22, String str2, AdData adData) {
                d.this.b(i22, str2);
                if (adData != null) {
                    d.this.f19357j = adData.c();
                }
                d.this.a(adData);
            }
        });
        return true;
    }

    @Override // com.opos.mobad.ad.b
    public int c() {
        return this.f19357j;
    }

    @Override // com.opos.mobad.ad.g.a, com.opos.mobad.ad.g
    public void c(int i2) {
        this.f19354g.d(i2);
    }

    @Override // com.opos.mobad.ad.g.a, com.opos.mobad.ad.g
    public int f() {
        a.C0457a c0457a;
        return (!e() || (c0457a = this.k) == null) ? super.f() : c0457a.f21744b.X();
    }

    @Override // com.opos.mobad.ad.g.a, com.opos.mobad.ad.g
    public int g() {
        a.C0457a c0457a;
        return (!e() || (c0457a = this.k) == null) ? super.g() : c0457a.f21744b.Y();
    }

    @Override // com.opos.mobad.ad.a.a
    public View h() {
        com.opos.cmn.an.f.a.b("InterBannerAd", "getAdView");
        if (!f.e() || 5 == d()) {
            return null;
        }
        return this.f19354g.a();
    }
}
