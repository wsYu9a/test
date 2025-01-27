package com.opos.mobad.h;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.opos.mobad.ad.c.q;
import com.opos.mobad.ad.c.r;
import com.opos.mobad.cmn.a.a;
import com.opos.mobad.cmn.service.pkginstall.b;
import com.opos.mobad.model.b;
import com.opos.mobad.model.data.AdData;
import com.opos.mobad.model.data.AdItemData;
import com.opos.mobad.model.data.MaterialData;
import com.opos.mobad.model.e.a;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: classes4.dex */
public class c extends b implements com.opos.mobad.ad.c.c, b.InterfaceC0437b {
    private Handler l;

    /* renamed from: com.opos.mobad.h.c$1 */
    class AnonymousClass1 implements b.a {

        /* renamed from: com.opos.mobad.h.c$1$1 */
        class RunnableC04481 implements Runnable {

            /* renamed from: a */
            final /* synthetic */ a.C0457a f20942a;

            RunnableC04481(a.C0457a c0457a) {
                c0457a = c0457a;
            }

            @Override // java.lang.Runnable
            public void run() {
                c cVar = c.this;
                if (cVar.f20865d) {
                    return;
                }
                cVar.a(c0457a);
            }
        }

        /* renamed from: com.opos.mobad.h.c$1$2 */
        class AnonymousClass2 implements Runnable {

            /* renamed from: a */
            final /* synthetic */ int f20944a;

            /* renamed from: b */
            final /* synthetic */ String f20945b;

            AnonymousClass2(int i2, String str) {
                i2 = i2;
                str = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                c cVar = c.this;
                if (cVar.f20865d) {
                    return;
                }
                cVar.a(new q(i2, str));
            }
        }

        AnonymousClass1() {
        }

        @Override // com.opos.mobad.model.b.a
        public void a(int i2, a.C0457a c0457a) {
            com.opos.mobad.c.b.b.a(new Runnable() { // from class: com.opos.mobad.h.c.1.1

                /* renamed from: a */
                final /* synthetic */ a.C0457a f20942a;

                RunnableC04481(a.C0457a c0457a2) {
                    c0457a = c0457a2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    c cVar = c.this;
                    if (cVar.f20865d) {
                        return;
                    }
                    cVar.a(c0457a);
                }
            });
        }

        @Override // com.opos.mobad.model.b.a
        public void a(int i2, String str, AdData adData) {
            com.opos.mobad.c.b.b.a(new Runnable() { // from class: com.opos.mobad.h.c.1.2

                /* renamed from: a */
                final /* synthetic */ int f20944a;

                /* renamed from: b */
                final /* synthetic */ String f20945b;

                AnonymousClass2(int i22, String str2) {
                    i2 = i22;
                    str = str2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    c cVar = c.this;
                    if (cVar.f20865d) {
                        return;
                    }
                    cVar.a(new q(i2, str));
                }
            });
        }
    }

    /* renamed from: com.opos.mobad.h.c$2 */
    class AnonymousClass2 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ String f20947a;

        /* renamed from: b */
        final /* synthetic */ AdItemData f20948b;

        AnonymousClass2(String str, AdItemData adItemData) {
            str = str;
            adItemData = adItemData;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.opos.cmn.an.f.a.b("InterNativeAd", "notifyInstallCompleted pkgName=" + str);
            try {
                c.this.c().a(str);
                c cVar = c.this;
                if (1 == ((b) cVar).f20872j) {
                    if (cVar.a(str, adItemData.i().get(0).H())) {
                        c.this.c().a(str);
                        com.opos.mobad.cmn.a.b.f.a(c.this.f20862a, str, com.opos.cmn.b.a.a.c());
                    } else {
                        c.this.c().b(str, 1);
                    }
                }
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.a("InterNativeAd", "", (Throwable) e2);
            }
        }
    }

    /* renamed from: com.opos.mobad.h.c$3 */
    class AnonymousClass3 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ MaterialData f20950a;

        AnonymousClass3(MaterialData materialData) {
            materialData = materialData;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (materialData == null || 2 != ((b) c.this).f20872j) {
                return;
            }
            com.opos.cmn.an.f.a.b("InterNativeAd", "notifyRewardIfNeed pkgNameTime=" + materialData.H());
            if (!c.this.a(materialData.k(), materialData.H())) {
                c.this.c().b(materialData.k(), 1);
            } else {
                c.this.c().a(materialData.k());
                com.opos.mobad.cmn.a.b.f.a(c.this.f20862a, materialData.k(), com.opos.cmn.b.a.a.c());
            }
        }
    }

    public c(Context context, String str, int i2, com.opos.mobad.cmn.a.d dVar, com.opos.mobad.ad.c.f fVar) {
        super(context, str, i2, dVar, fVar);
        this.l = new Handler(Looper.getMainLooper());
    }

    public c(Context context, String str, com.opos.mobad.cmn.a.d dVar, com.opos.mobad.ad.c.f fVar) {
        super(context, str, dVar, fVar);
        this.l = new Handler(Looper.getMainLooper());
    }

    private List<com.opos.mobad.ad.c.d> a(AdData adData) {
        ArrayList arrayList;
        List<AdItemData> f2;
        if (adData == null || (f2 = adData.f()) == null || f2.size() <= 0) {
            arrayList = null;
        } else {
            arrayList = new ArrayList();
            for (AdItemData adItemData : f2) {
                if (adItemData != null) {
                    arrayList.add(new com.opos.mobad.h.b.a(this.f20862a, this, adItemData));
                }
            }
        }
        com.opos.cmn.an.f.a.b("InterNativeAd", "adDataToINativeAdDataList =", arrayList);
        return arrayList;
    }

    private void a(MaterialData materialData) {
        if (this.f20865d) {
            return;
        }
        this.l.post(new Runnable() { // from class: com.opos.mobad.h.c.3

            /* renamed from: a */
            final /* synthetic */ MaterialData f20950a;

            AnonymousClass3(MaterialData materialData2) {
                materialData = materialData2;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (materialData == null || 2 != ((b) c.this).f20872j) {
                    return;
                }
                com.opos.cmn.an.f.a.b("InterNativeAd", "notifyRewardIfNeed pkgNameTime=" + materialData.H());
                if (!c.this.a(materialData.k(), materialData.H())) {
                    c.this.c().b(materialData.k(), 1);
                } else {
                    c.this.c().a(materialData.k());
                    com.opos.mobad.cmn.a.b.f.a(c.this.f20862a, materialData.k(), com.opos.cmn.b.a.a.c());
                }
            }
        });
    }

    public void a(a.C0457a c0457a) {
        q qVar;
        if (c0457a != null && c0457a.f21743a.a() == 1) {
            com.opos.mobad.service.a.a().a(this.f20863b, 4, c0457a.f21744b.f(), c0457a.f21744b.b(), c0457a.f21745c.aa(), c0457a.f21744b.a(), c0457a.f21744b.J());
            qVar = new q(-1, com.opos.mobad.ad.a.a(-1));
        } else if (c0457a == null) {
            b().a(new q(-1, "unknown error."));
            return;
        } else if (System.currentTimeMillis() <= c0457a.f21743a.h()) {
            AdData adData = c0457a.f21743a;
            a(adData, a(adData));
            return;
        } else {
            com.opos.cmn.an.f.a.d("InterNativeAd", "now time over ad expire time.");
            qVar = new q(10003, "now time over ad expire time.");
        }
        a(qVar);
    }

    private void b(r rVar) {
        com.opos.cmn.an.f.a.b("InterNativeAd", "fetchNativeAd");
        this.k = com.opos.cmn.i.f.a();
        com.opos.mobad.model.b.a(this.f20862a).a(this.f20862a, this.f20863b, 4, this.k, (int) (rVar != null ? rVar.f19480a : 30000L), new b.a() { // from class: com.opos.mobad.h.c.1

            /* renamed from: com.opos.mobad.h.c$1$1 */
            class RunnableC04481 implements Runnable {

                /* renamed from: a */
                final /* synthetic */ a.C0457a f20942a;

                RunnableC04481(a.C0457a c0457a2) {
                    c0457a = c0457a2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    c cVar = c.this;
                    if (cVar.f20865d) {
                        return;
                    }
                    cVar.a(c0457a);
                }
            }

            /* renamed from: com.opos.mobad.h.c$1$2 */
            class AnonymousClass2 implements Runnable {

                /* renamed from: a */
                final /* synthetic */ int f20944a;

                /* renamed from: b */
                final /* synthetic */ String f20945b;

                AnonymousClass2(int i22, String str2) {
                    i2 = i22;
                    str = str2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    c cVar = c.this;
                    if (cVar.f20865d) {
                        return;
                    }
                    cVar.a(new q(i2, str));
                }
            }

            AnonymousClass1() {
            }

            @Override // com.opos.mobad.model.b.a
            public void a(int i2, a.C0457a c0457a2) {
                com.opos.mobad.c.b.b.a(new Runnable() { // from class: com.opos.mobad.h.c.1.1

                    /* renamed from: a */
                    final /* synthetic */ a.C0457a f20942a;

                    RunnableC04481(a.C0457a c0457a22) {
                        c0457a = c0457a22;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        c cVar = c.this;
                        if (cVar.f20865d) {
                            return;
                        }
                        cVar.a(c0457a);
                    }
                });
            }

            @Override // com.opos.mobad.model.b.a
            public void a(int i22, String str2, AdData adData) {
                com.opos.mobad.c.b.b.a(new Runnable() { // from class: com.opos.mobad.h.c.1.2

                    /* renamed from: a */
                    final /* synthetic */ int f20944a;

                    /* renamed from: b */
                    final /* synthetic */ String f20945b;

                    AnonymousClass2(int i222, String str22) {
                        i2 = i222;
                        str = str22;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        c cVar = c.this;
                        if (cVar.f20865d) {
                            return;
                        }
                        cVar.a(new q(i2, str));
                    }
                });
            }
        }, com.opos.mobad.model.b.f21483a);
    }

    private boolean e() {
        boolean a2 = com.opos.mobad.service.f.c().a(this.f20863b);
        if (!a2) {
            com.opos.mobad.service.d.b.a().a(this.f20863b);
        }
        return a2;
    }

    @Override // com.opos.mobad.ad.c.c
    public void a() {
        com.opos.cmn.an.f.a.b("InterNativeAd", "destroyAd");
        if (!com.opos.mobad.cmn.a.b.f.e() || this.f20865d) {
            return;
        }
        this.f20871i = null;
        com.opos.mobad.cmn.service.pkginstall.b.a(this.f20862a).a(this);
        a.b bVar = this.f20869h;
        if (bVar != null) {
            bVar.a();
        }
        this.f20865d = true;
    }

    @Override // com.opos.mobad.model.c.a
    public void a(int i2, String str, AdData adData, Object... objArr) {
    }

    @Override // com.opos.mobad.ad.c.c
    public void a(r rVar) {
        com.opos.mobad.ad.c.f b2;
        q qVar;
        com.opos.cmn.an.f.a.b("InterNativeAd", "loadAd nativeAdParams=", rVar);
        if (!com.opos.mobad.cmn.a.b.f.e()) {
            b2 = b();
            qVar = new q(11005, b(11005));
        } else {
            if (this.f20865d) {
                return;
            }
            if (e()) {
                int a2 = a(4);
                if (a2 == 0) {
                    b(rVar);
                    return;
                } else {
                    a(new q(a2, b(a2)));
                    return;
                }
            }
            b2 = b();
            qVar = new q(-1, "inter error request");
        }
        b2.a(qVar);
    }

    @Override // com.opos.mobad.cmn.service.pkginstall.b.InterfaceC0437b
    public void a(AdItemData adItemData, String str) {
        if (adItemData != null) {
            try {
                if (com.opos.cmn.an.c.a.a(str)) {
                    return;
                }
                com.opos.cmn.an.f.a.b("InterNativeAd", "notifyInstallCompletedEvent pkgName=" + str);
                if (this.f20865d) {
                    return;
                }
                this.l.post(new Runnable() { // from class: com.opos.mobad.h.c.2

                    /* renamed from: a */
                    final /* synthetic */ String f20947a;

                    /* renamed from: b */
                    final /* synthetic */ AdItemData f20948b;

                    AnonymousClass2(String str2, AdItemData adItemData2) {
                        str = str2;
                        adItemData = adItemData2;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        com.opos.cmn.an.f.a.b("InterNativeAd", "notifyInstallCompleted pkgName=" + str);
                        try {
                            c.this.c().a(str);
                            c cVar = c.this;
                            if (1 == ((b) cVar).f20872j) {
                                if (cVar.a(str, adItemData.i().get(0).H())) {
                                    c.this.c().a(str);
                                    com.opos.mobad.cmn.a.b.f.a(c.this.f20862a, str, com.opos.cmn.b.a.a.c());
                                } else {
                                    c.this.c().b(str, 1);
                                }
                            }
                        } catch (Exception e2) {
                            com.opos.cmn.an.f.a.a("InterNativeAd", "", (Throwable) e2);
                        }
                    }
                });
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.a("InterNativeAd", "", (Throwable) e2);
            }
        }
    }

    public void a(AdItemData adItemData, boolean z, int[] iArr, Map<String, String> map, com.opos.mobad.cmn.a.b.a aVar, View view) {
        int i2 = ((b) this).f20872j;
        if (1 == i2) {
            adItemData.g(2);
        } else if (2 == i2) {
            adItemData.g(4);
        }
        this.f20868g.a(adItemData, z, iArr, map, aVar, view, this, (com.opos.mobad.cmn.a.b) null);
    }

    public boolean a(AdItemData adItemData, MaterialData materialData) {
        boolean z = false;
        if (adItemData != null && materialData != null) {
            try {
                if (!com.opos.cmn.an.c.a.a(materialData.k()) && (z = com.opos.mobad.cmn.a.b.f.a(this.f20862a, adItemData, materialData, (int[]) null))) {
                    a(materialData);
                }
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.a("InterNativeAd", "", (Throwable) e2);
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("launchApp pkgName=");
        sb.append(materialData != null ? materialData.k() : "null");
        sb.append(",result=");
        sb.append(z);
        com.opos.cmn.an.f.a.b("InterNativeAd", sb.toString());
        return z;
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0020, code lost:
    
        if (com.opos.cmn.b.a.a.c() >= (com.opos.mobad.cmn.a.b.f.d(r7.f20862a, r8) + ((r9 * 60) * 1000))) goto L24;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean a(java.lang.String r8, int r9) {
        /*
            r7 = this;
            java.lang.String r0 = "InterNativeAd"
            r1 = 0
            android.content.Context r3 = r7.f20862a     // Catch: java.lang.Exception -> L24
            long r3 = com.opos.mobad.cmn.a.b.f.d(r3, r8)     // Catch: java.lang.Exception -> L24
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 == 0) goto L22
            long r1 = com.opos.cmn.b.a.a.c()     // Catch: java.lang.Exception -> L24
            android.content.Context r3 = r7.f20862a     // Catch: java.lang.Exception -> L24
            long r3 = com.opos.mobad.cmn.a.b.f.d(r3, r8)     // Catch: java.lang.Exception -> L24
            int r9 = r9 * 60
            int r9 = r9 * 1000
            long r5 = (long) r9
            long r3 = r3 + r5
            int r9 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r9 < 0) goto L2a
        L22:
            r9 = 1
            goto L2b
        L24:
            r9 = move-exception
            java.lang.String r1 = ""
            com.opos.cmn.an.f.a.a(r0, r1, r9)
        L2a:
            r9 = 0
        L2b:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "canReward pkgName="
            r1.append(r2)
            r1.append(r8)
            java.lang.String r8 = ",result="
            r1.append(r8)
            r1.append(r9)
            java.lang.String r8 = r1.toString()
            com.opos.cmn.an.f.a.b(r0, r8)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.mobad.h.c.a(java.lang.String, int):boolean");
    }

    public void b(AdItemData adItemData) {
        this.f20868g.b(adItemData);
    }

    @Override // com.opos.mobad.cmn.service.pkginstall.b.InterfaceC0437b
    public void b(AdItemData adItemData, String str) {
        if (adItemData != null && adItemData.i() != null) {
            a(adItemData.i().get(0));
        }
        com.opos.cmn.an.f.a.b("InterNativeAd", "notifyLaunchEvent pkgName:" + str);
    }

    @Override // com.opos.mobad.cmn.service.pkginstall.b.InterfaceC0437b
    public void c(AdItemData adItemData, String str) {
        if (adItemData != null && adItemData.i() != null) {
            a(adItemData.i().get(0));
        }
        com.opos.cmn.an.f.a.b("InterNativeAd", "notifyLaunchEventFromWeb pkgName:" + str);
    }

    public boolean d() {
        return this.f20865d;
    }
}
