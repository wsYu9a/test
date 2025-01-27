package com.vivo.mobilead.util;

import android.text.TextUtils;
import com.vivo.ad.model.AdError;
import com.vivo.mobilead.j.c;
import com.vivo.mobilead.util.n;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* loaded from: classes4.dex */
public class a extends com.vivo.mobilead.util.f1.b {

    /* renamed from: a */
    private String f30516a;

    /* renamed from: b */
    private String f30517b;

    /* renamed from: c */
    private String f30518c;

    /* renamed from: d */
    private int f30519d;

    /* renamed from: f */
    private String f30521f;

    /* renamed from: g */
    private long f30522g;

    /* renamed from: i */
    private AdError f30524i;

    /* renamed from: j */
    private b f30525j;
    private String l;
    private String n;
    private int o;
    private String q;
    private boolean r;
    private int s;

    /* renamed from: e */
    private int f30520e = 1;

    /* renamed from: h */
    private int f30523h = 1;
    private int k = 1;
    private volatile boolean m = false;
    private int p = -1;

    /* renamed from: com.vivo.mobilead.util.a$a */
    class C0660a extends com.vivo.mobilead.util.f1.b {

        /* renamed from: com.vivo.mobilead.util.a$a$a */
        class C0661a implements com.vivo.mobilead.i.o {

            /* renamed from: com.vivo.mobilead.util.a$a$a$a */
            class C0662a extends com.vivo.mobilead.util.f1.b {

                /* renamed from: a */
                final /* synthetic */ AdError f30528a;

                C0662a(AdError adError) {
                    this.f30528a = adError;
                }

                @Override // com.vivo.mobilead.util.f1.b
                public void safelyRun() {
                    a.this.f30525j.a(this.f30528a);
                }
            }

            C0661a() {
            }

            @Override // com.vivo.mobilead.i.o
            public void a(int i2, String str) {
                VOpenLog.d(com.vivo.mobilead.util.f1.b.TAG, "fetch AD Fail:" + i2 + " " + str);
                com.vivo.mobilead.splash.a.b.a().a(a.this.l, "dataload:stage5");
                if (!a.this.m) {
                    a.this.m = true;
                    AdError adError = new AdError(i2, str, null, null);
                    adError.setRequestId(a.this.f30516a);
                    if (a.this.f30525j != null) {
                        z.b().a(new C0662a(adError));
                    }
                }
                a.this.a((com.vivo.ad.model.b) null, "3000000");
            }

            @Override // com.vivo.mobilead.i.o
            public void a(List<com.vivo.ad.model.b> list) {
            }
        }

        /* renamed from: com.vivo.mobilead.util.a$a$b */
        class b extends com.vivo.mobilead.util.f1.b {

            /* renamed from: a */
            final /* synthetic */ List f30530a;

            b(List list) {
                this.f30530a = list;
            }

            @Override // com.vivo.mobilead.util.f1.b
            public void safelyRun() {
                if (this.f30530a.size() > 0) {
                    a.this.f30525j.a(this.f30530a);
                } else {
                    if (a.this.f30524i == null || a.this.m) {
                        return;
                    }
                    a.this.m = true;
                    a.this.f30525j.a(a.this.f30524i);
                }
            }
        }

        C0660a() {
        }

        @Override // com.vivo.mobilead.util.f1.b
        public void safelyRun() {
            String str;
            int[] iArr;
            b bVar;
            HashMap hashMap = new HashMap();
            long a2 = n.a.a();
            if (a2 > 0) {
                hashMap.put("firstInstallTime", "" + a2);
            }
            long b2 = n.a.b();
            if (b2 > 0) {
                hashMap.put("lastUpdateTime", "" + b2);
            }
            Future a3 = a1.a(new com.vivo.mobilead.i.n(a.this.f30517b, a.this.f30518c, a.this.f30519d, a.this.f30523h, a.this.f30520e, a.this.o, 1, hashMap, new C0661a(), -1, a.this.p, a.this.q, a.this.s, a.this.r ? 1 : 0));
            ArrayList arrayList = new ArrayList();
            try {
                try {
                    List<com.vivo.ad.model.b> list = (List) a3.get(a.this.f30522g, TimeUnit.MILLISECONDS);
                    a.this.a((List<com.vivo.ad.model.b>) list);
                    a aVar = a.this;
                    aVar.f30524i = new AdError(40218, "没有广告，建议过一会儿重试", aVar.f30516a, null, null);
                    com.vivo.mobilead.splash.a.b.a().a(a.this.l, "dataload:stage7");
                    if (list == null || list.isEmpty()) {
                        a.this.a((com.vivo.ad.model.b) null, "3000006");
                    } else {
                        String str2 = null;
                        int[] iArr2 = null;
                        for (com.vivo.ad.model.b bVar2 : list) {
                            try {
                                str2 = bVar2.P();
                                iArr2 = bVar2.J();
                                if (bVar2.N() != 1) {
                                    x0.b(com.vivo.mobilead.util.f1.b.TAG, "subcode not 1,is " + bVar2.N());
                                    a.this.f30524i.setErrorCode(com.vivo.mobilead.unified.base.f.a.d(bVar2.N()));
                                    a.this.f30524i.setErrorMsg(com.vivo.mobilead.unified.base.f.a.e(bVar2.N()));
                                    a.this.a(bVar2, "3000002");
                                } else if (bVar2.l() != a.this.b()) {
                                    x0.b(com.vivo.mobilead.util.f1.b.TAG, "adType not equal");
                                    a.this.a(bVar2, "3000003");
                                } else if ((bVar2.j() == 2 || bVar2.j() == 12) && bVar2.y() == null) {
                                    x0.b(com.vivo.mobilead.util.f1.b.TAG, "adType is 2 but appinfo is null");
                                    a.this.a(bVar2, "3000004");
                                } else if (bVar2.U() && (bVar2.y() == null || bVar2.z() == null)) {
                                    x0.b(com.vivo.mobilead.util.f1.b.TAG, "adType is 9 but appinfo or deeplink is null");
                                    a.this.a(bVar2, "3000004");
                                } else if (bVar2.j() == 1 && TextUtils.isEmpty(bVar2.v())) {
                                    x0.b(com.vivo.mobilead.util.f1.b.TAG, "adStyle is 1 but linkUrl is null");
                                    a.this.a(bVar2, "3000004");
                                } else {
                                    if (bVar2.j() == 8) {
                                        com.vivo.ad.model.r z = bVar2.z();
                                        com.vivo.ad.model.v I = bVar2.I();
                                        if (z == null && I == null && bVar2.y() == null) {
                                            x0.b(com.vivo.mobilead.util.f1.b.TAG, "adType is 8 but deeplink is null");
                                            a.this.a(bVar2, "3000004");
                                        }
                                    }
                                    if (9 == a.this.f30519d) {
                                        if (44 == bVar2.x() && (bVar2.t() == null || TextUtils.isEmpty(bVar2.t().a()))) {
                                            x0.b(com.vivo.mobilead.util.f1.b.TAG, "InteractUrl is null");
                                            a.this.a(bVar2, "3000005");
                                        } else if (7 != bVar2.x()) {
                                            if (45 == bVar2.x() && (bVar2.Q() == null || TextUtils.isEmpty(bVar2.Q().g()) || bVar2.t() == null || TextUtils.isEmpty(bVar2.t().a()))) {
                                                x0.b(com.vivo.mobilead.util.f1.b.TAG, "AdMaterial is null  or InteractUrl is null ");
                                                a.this.a(bVar2, "3000005");
                                            }
                                            arrayList.add(bVar2);
                                        } else if (bVar2.Q() == null || TextUtils.isEmpty(bVar2.Q().g())) {
                                            x0.b(com.vivo.mobilead.util.f1.b.TAG, "AdMaterial is null ");
                                            a.this.a(bVar2, "3000005");
                                        } else {
                                            arrayList.add(bVar2);
                                        }
                                    } else if (bVar2.f() == null && (bVar2.Q() == null || TextUtils.isEmpty(bVar2.Q().g()))) {
                                        x0.b(com.vivo.mobilead.util.f1.b.TAG, "AdMaterial is null");
                                        a.this.a(bVar2, "3000005");
                                    } else {
                                        if (bVar2.Q() == null && a.this.f30523h == 2) {
                                            a.this.a(bVar2, "3000005");
                                        }
                                        arrayList.add(bVar2);
                                    }
                                }
                            } catch (Exception e2) {
                                e = e2;
                                str = str2;
                                iArr = iArr2;
                                x0.b(com.vivo.mobilead.util.f1.b.TAG, "fetch AD result error", e);
                                a aVar2 = a.this;
                                aVar2.f30524i = new AdError(40213, "请求耗费时间太长，请检查网络状态是否良好", aVar2.f30516a, str, iArr);
                                com.vivo.mobilead.splash.a.b.a().a(a.this.l, "dataload:stage6");
                                a.this.a((com.vivo.ad.model.b) null, "3000001");
                                if (bVar != null) {
                                    return;
                                } else {
                                    return;
                                }
                            }
                        }
                        if (arrayList.size() == 0) {
                            a.this.f30524i.setToken(str2);
                            a.this.f30524i.setShowPriority(iArr2);
                        } else if (arrayList.get(0) != null) {
                            a.this.a((com.vivo.ad.model.b) arrayList.get(0));
                        }
                    }
                    if (a.this.f30525j != null) {
                        z.b().a(new b(arrayList));
                    }
                } finally {
                    if (a.this.f30525j != null) {
                        z.b().a(new b(arrayList));
                    }
                }
            } catch (Exception e3) {
                e = e3;
                str = null;
                iArr = null;
            }
        }
    }

    public interface b {
        void a(AdError adError);

        void a(List<com.vivo.ad.model.b> list);
    }

    @Override // com.vivo.mobilead.util.f1.b
    public void safelyRun() {
        com.vivo.mobilead.splash.a.b.a().a(this.l, "dataload:stage3");
        if (this.f30522g <= 0) {
            this.f30522g = Long.MAX_VALUE;
        }
        int i2 = this.f30519d == 2 ? com.vivo.mobilead.manager.b.l().getInt("splash_orientation_key", 1) : w0.c();
        com.vivo.mobilead.splash.a.b.a().a(this.l, "dataload:stage4");
        k0.a(this.f30521f, this.f30516a, this.f30517b, this.f30518c, i2, this.f30523h, this.k, 0, this.f30520e, -1, this.p, c.a.f28912a.intValue());
        x0.a("ADRequestTask", "begin fetchAd timeout is " + this.f30522g);
        a1.e(new C0660a());
    }

    public a b(String str) {
        this.f30517b = str;
        return this;
    }

    public a c(String str) {
        this.f30521f = str;
        return this;
    }

    public a d(String str) {
        this.f30516a = str;
        return this;
    }

    public a e(String str) {
        this.f30518c = str;
        return this;
    }

    public a f(int i2) {
        this.f30520e = i2;
        return this;
    }

    public a g(int i2) {
        this.k = i2;
        return this;
    }

    public a b(int i2) {
        this.f30519d = i2;
        return this;
    }

    public a c(int i2) {
        this.s = i2;
        return this;
    }

    public a d(int i2) {
        this.p = i2;
        return this;
    }

    public a e(int i2) {
        this.f30523h = i2;
        return this;
    }

    public a f(String str) {
        this.l = str;
        return this;
    }

    public a g(String str) {
        this.q = str;
        return this;
    }

    public int b() {
        int i2 = this.f30519d;
        if (i2 == 10 || i2 == 2) {
            return 2;
        }
        return i2;
    }

    public void a(com.vivo.ad.model.b bVar, String str) {
        com.vivo.ad.model.r z;
        String valueOf = bVar == null ? "" : String.valueOf(bVar.j());
        String valueOf2 = String.valueOf(0);
        if (bVar != null && (z = bVar.z()) != null && 1 == z.a()) {
            valueOf2 = String.valueOf(1);
        }
        w.a(this.f30517b, this.n, valueOf, valueOf2, this.f30516a, bVar != null ? bVar.d() : "", str, String.valueOf(this.f30520e), String.valueOf(0), String.valueOf(this.f30519d));
    }

    public a a(String str) {
        this.n = str;
        return this;
    }

    public a a(long j2) {
        this.f30522g = j2;
        return this;
    }

    public a a(b bVar) {
        this.f30525j = bVar;
        return this;
    }

    public a a(int i2) {
        this.o = i2;
        return this;
    }

    public void a(boolean z) {
        this.r = z;
    }

    public void a(com.vivo.ad.model.b bVar) {
        com.vivo.ad.model.e c2 = bVar.c();
        if (c2 != null) {
            if (c2.r() == 0) {
                com.vivo.mobilead.f.c.d().a(false);
                com.vivo.mobilead.f.c.d().c();
            } else {
                com.vivo.mobilead.f.c.d().a(true);
                com.vivo.mobilead.f.c.d().a();
                com.vivo.mobilead.f.c.d().a(c2.a() * 1000);
            }
        }
    }

    public void a(List<com.vivo.ad.model.b> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        Iterator<com.vivo.ad.model.b> it = list.iterator();
        while (it.hasNext()) {
            it.next().a().a(this.f30516a);
        }
    }

    public static a a() {
        return new a();
    }
}
