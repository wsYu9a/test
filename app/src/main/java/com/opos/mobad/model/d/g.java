package com.opos.mobad.model.d;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobads.sdk.api.SplashAd;
import com.baidu.mobads.sdk.internal.am;
import com.opos.acs.st.STManager;
import com.opos.cmn.func.b.b.d;
import com.opos.mobad.b.a.b;
import com.opos.mobad.b.a.x;
import com.opos.mobad.b.a.y;
import com.opos.mobad.model.data.AdData;
import com.opos.mobad.model.data.AdItemData;
import com.opos.mobad.model.data.FloatLayerData;
import com.opos.mobad.model.data.MaterialData;
import com.opos.mobad.model.data.MaterialFileData;
import com.opos.mobad.model.data.PendantData;
import com.opos.mobad.provider.ad.AdEntity;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class g implements n {

    /* renamed from: e */
    private static final int f21578e = y.e.APP_INSTALLED.a();

    /* renamed from: f */
    private static final int f21579f = y.e.APP_UNINSTALLED.a();

    /* renamed from: a */
    private Context f21580a;

    /* renamed from: b */
    private com.opos.mobad.model.a.a f21581b;

    /* renamed from: c */
    private o f21582c;

    /* renamed from: d */
    private com.opos.mobad.provider.ad.a f21583d;

    /* renamed from: com.opos.mobad.model.d.g$1 */
    class AnonymousClass1 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ long f21584a;

        /* renamed from: b */
        final /* synthetic */ boolean f21585b;

        /* renamed from: c */
        final /* synthetic */ String f21586c;

        /* renamed from: d */
        final /* synthetic */ com.opos.mobad.model.b.c f21587d;

        /* renamed from: e */
        final /* synthetic */ com.opos.mobad.model.c.a f21588e;

        /* renamed from: f */
        final /* synthetic */ Object[] f21589f;

        AnonymousClass1(long j2, boolean z, String str, com.opos.mobad.model.b.c cVar, com.opos.mobad.model.c.a aVar, Object[] objArr) {
            j2 = j2;
            z = z;
            str = str;
            cVar = cVar;
            aVar = aVar;
            objArr = objArr;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.opos.cmn.an.f.a.b("FetchAdTask", "fetchAd fetchTimeout=" + j2 + ",needDownloadMaterial=" + z);
            try {
                try {
                    FutureTask a2 = g.this.a(str, cVar, z);
                    com.opos.cmn.an.j.b.b(a2);
                    AdData adData = (AdData) a2.get(j2, TimeUnit.MILLISECONDS);
                    com.opos.mobad.model.c.a aVar = aVar;
                    if (aVar != null) {
                        if (adData != null) {
                            aVar.a(adData.d(), adData.e(), adData, objArr);
                        } else {
                            aVar.a(-1, "unknown error.", null, objArr);
                        }
                    }
                } catch (Exception e2) {
                    com.opos.cmn.an.f.a.c("FetchAdTask", SplashAd.KEY_FETCHAD, e2);
                    com.opos.mobad.model.c.a aVar2 = aVar;
                    if (aVar2 != null) {
                        aVar2.a(-1, "unknown error.", null, objArr);
                    }
                }
            } catch (Throwable th) {
                com.opos.mobad.model.c.a aVar3 = aVar;
                if (aVar3 != null) {
                    aVar3.a(-1, "unknown error.", null, objArr);
                }
                throw th;
            }
        }
    }

    /* renamed from: com.opos.mobad.model.d.g$2 */
    class AnonymousClass2 implements Callable<AdData> {

        /* renamed from: a */
        final /* synthetic */ String f21591a;

        /* renamed from: b */
        final /* synthetic */ com.opos.mobad.model.b.c f21592b;

        /* renamed from: c */
        final /* synthetic */ boolean f21593c;

        AnonymousClass2(String str, com.opos.mobad.model.b.c cVar, boolean z) {
            str = str;
            cVar = cVar;
            z = z;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public AdData call() throws Exception {
            return g.this.b(str, cVar, z);
        }
    }

    /* renamed from: com.opos.mobad.model.d.g$3 */
    class AnonymousClass3 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ com.opos.mobad.model.b.c f21595a;

        /* renamed from: b */
        final /* synthetic */ String f21596b;

        /* renamed from: c */
        final /* synthetic */ String f21597c;

        /* renamed from: d */
        final /* synthetic */ l f21598d;

        /* renamed from: e */
        final /* synthetic */ AtomicReference f21599e;

        /* renamed from: f */
        final /* synthetic */ CountDownLatch f21600f;

        AnonymousClass3(com.opos.mobad.model.b.c cVar, String str, String str2, l lVar, AtomicReference atomicReference, CountDownLatch countDownLatch) {
            cVar = cVar;
            str = str;
            str2 = str2;
            lVar = lVar;
            atomicReference = atomicReference;
            countDownLatch = countDownLatch;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v12, types: [java.lang.String] */
        /* JADX WARN: Type inference failed for: r0v16 */
        /* JADX WARN: Type inference failed for: r0v17 */
        /* JADX WARN: Type inference failed for: r0v24 */
        /* JADX WARN: Type inference failed for: r0v25 */
        /* JADX WARN: Type inference failed for: r0v26 */
        /* JADX WARN: Type inference failed for: r0v5, types: [boolean] */
        /* JADX WARN: Type inference failed for: r0v7, types: [java.util.concurrent.CountDownLatch] */
        /* JADX WARN: Type inference failed for: r0v9, types: [com.opos.mobad.model.d.h] */
        /* JADX WARN: Type inference failed for: r1v2, types: [android.content.Context] */
        /* JADX WARN: Type inference failed for: r2v1 */
        /* JADX WARN: Type inference failed for: r2v10 */
        /* JADX WARN: Type inference failed for: r2v11 */
        /* JADX WARN: Type inference failed for: r2v12 */
        /* JADX WARN: Type inference failed for: r2v13 */
        /* JADX WARN: Type inference failed for: r2v14 */
        /* JADX WARN: Type inference failed for: r2v15 */
        /* JADX WARN: Type inference failed for: r2v6 */
        /* JADX WARN: Type inference failed for: r2v7 */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x00be -> B:9:0x00c7). Please report as a decompilation issue!!! */
        @Override // java.lang.Runnable
        public void run() {
            h hVar;
            ?? r2;
            AdEntity a2;
            g gVar;
            ?? r0;
            ?? r02;
            if (com.opos.mobad.service.a.c.a().d()) {
                com.opos.mobad.model.b.c cVar = cVar;
                String str = "FetchAdTask";
                if (cVar == null || !com.opos.mobad.service.f.a.a(cVar.i())) {
                    hVar = new h(str, str2);
                    r2 = 1;
                    r2 = 1;
                    r2 = 1;
                    r2 = 1;
                    int i2 = 1;
                    try {
                        a2 = g.this.f21583d.a(str);
                    } catch (Exception e2) {
                        com.opos.cmn.an.f.a.b(str, "fail cache", e2);
                        r0 = hVar;
                        i2 = r2;
                    }
                    if (a2 == null) {
                        hVar.a(g.this.f21580a, 1);
                        hVar = hVar;
                        str = str;
                    } else if (System.currentTimeMillis() >= a2.f23121c) {
                        hVar.a(g.this.f21580a, 2);
                        hVar = hVar;
                        str = str;
                    } else {
                        com.opos.mobad.model.b.d dVar = new com.opos.mobad.model.b.d(com.opos.mobad.b.a.d.f19667c.a(a2.f23119a), g.this.a(a2.f23120b), a2.f23121c);
                        com.opos.cmn.an.f.a.b("FetchAdTask", "cache data:", dVar);
                        r0 = hVar;
                        if (dVar.h() != null) {
                            r0 = hVar;
                            if (dVar.h().size() > 0) {
                                l lVar = lVar;
                                if (lVar != null) {
                                    lVar.a();
                                }
                                gVar = g.this;
                                com.opos.mobad.model.b.d a3 = gVar.a(dVar, hVar);
                                if (a3 == null) {
                                    r02 = "cache check fail";
                                } else {
                                    AtomicReference atomicReference = atomicReference;
                                    ?? compareAndSet = atomicReference.compareAndSet(null, a3);
                                    hVar = compareAndSet;
                                    str = str;
                                    r2 = atomicReference;
                                    if (compareAndSet != 0) {
                                        com.opos.cmn.an.f.a.b("FetchAdTask", "check cache select");
                                        ?? r03 = countDownLatch;
                                        r03.countDown();
                                        hVar = r03;
                                        str = str;
                                        r2 = atomicReference;
                                    }
                                }
                            }
                        }
                        ?? r1 = g.this.f21580a;
                        r0.a(r1, i2);
                        hVar = r0;
                        str = r1;
                        r2 = i2;
                    }
                }
                r02 = "cache but in childMode";
                com.opos.cmn.an.f.a.b("FetchAdTask", (String) r02);
                hVar = r02;
                str = str;
                r2 = gVar;
            }
        }
    }

    /* renamed from: com.opos.mobad.model.d.g$4 */
    class AnonymousClass4 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ String f21602a;

        /* renamed from: b */
        final /* synthetic */ com.opos.mobad.model.b.c f21603b;

        /* renamed from: c */
        final /* synthetic */ l f21604c;

        /* renamed from: d */
        final /* synthetic */ AtomicReference f21605d;

        /* renamed from: e */
        final /* synthetic */ CountDownLatch f21606e;

        /* renamed from: f */
        final /* synthetic */ AtomicBoolean f21607f;

        AnonymousClass4(String str, com.opos.mobad.model.b.c cVar, l lVar, AtomicReference atomicReference, CountDownLatch countDownLatch, AtomicBoolean atomicBoolean) {
            str = str;
            cVar = cVar;
            lVar = lVar;
            atomicReference = atomicReference;
            countDownLatch = countDownLatch;
            atomicBoolean = atomicBoolean;
        }

        @Override // java.lang.Runnable
        public void run() {
            long currentTimeMillis = System.currentTimeMillis();
            com.opos.mobad.model.b.d a2 = g.this.f21581b.a(str, cVar, lVar);
            if (a2 != null && a2.f() == 1035) {
                com.opos.mobad.service.f.c().a(str, false, a2.l());
            }
            g.this.a(str, cVar.a(), a2.f(), System.currentTimeMillis() - currentTimeMillis);
            if (atomicReference.compareAndSet(null, a2)) {
                com.opos.cmn.an.f.a.b("FetchAdTask", "fetch data select");
                countDownLatch.countDown();
                return;
            }
            com.opos.cmn.an.f.a.b("FetchAdTask", "cache new fetchAd");
            if (a2.f() != 0 || a2.b() <= 0 || a2.h() == null || a2.h().size() <= 0) {
                return;
            }
            List<com.opos.mobad.b.a.b> subList = a2.h().subList(0, Math.min(a2.b(), a2.h().size()));
            atomicBoolean.set(true);
            g.this.a(str, a2, subList);
        }
    }

    /* renamed from: com.opos.mobad.model.d.g$5 */
    class AnonymousClass5 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Set f21609a;

        AnonymousClass5(Set set) {
            r2 = set;
        }

        @Override // java.lang.Runnable
        public void run() {
            g.this.f21582c.a(r2, null);
        }
    }

    /* renamed from: com.opos.mobad.model.d.g$6 */
    class AnonymousClass6 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ List f21611a;

        /* renamed from: b */
        final /* synthetic */ com.opos.mobad.model.b.d f21612b;

        /* renamed from: c */
        final /* synthetic */ String f21613c;

        AnonymousClass6(List list, com.opos.mobad.model.b.d dVar, String str) {
            list = list;
            dVar = dVar;
            str = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                byte[] b2 = g.this.b((List<com.opos.mobad.b.a.b>) list);
                g.this.f21583d.a(str, new AdEntity(com.opos.mobad.b.a.d.f19667c.b((com.heytap.nearx.a.a.e<com.opos.mobad.b.a.d>) dVar.c()), b2, dVar.i()));
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.a("FetchAdTask", "cache fail", (Throwable) e2);
            }
        }
    }

    public g(Context context, com.opos.mobad.model.a.b bVar) {
        this.f21580a = com.opos.mobad.service.b.a(context.getApplicationContext());
        this.f21583d = new com.opos.mobad.provider.ad.a(this.f21580a);
        this.f21581b = new com.opos.mobad.model.a.a.a(this.f21580a, bVar);
        this.f21582c = new j(this.f21580a);
    }

    private static final int a(AdData adData) {
        if (adData == null) {
            return 0;
        }
        try {
            if (adData.f() != null && adData.f().size() > 0) {
                return adData.f().get(0).X();
            }
            return 0;
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.b("FetchAdTask", "", e2);
            return 0;
        }
    }

    public com.opos.mobad.model.b.d a(com.opos.mobad.model.b.d dVar, h hVar) {
        com.opos.cmn.func.b.b.e eVar;
        List<com.opos.mobad.b.a.b> h2;
        Context context;
        try {
            h2 = dVar.h();
        } catch (Throwable th) {
            th = th;
            eVar = null;
        }
        if (h2 != null && h2.size() > 0) {
            JSONArray jSONArray = new JSONArray();
            for (com.opos.mobad.b.a.b bVar : h2) {
                List<y> list = bVar.A;
                if (list != null && list.size() > 0) {
                    y yVar = bVar.A.get(0);
                    if (a(yVar, hVar)) {
                        if (c(yVar)) {
                            List<x> list2 = yVar.aq;
                            if (list2 != null && list2.size() > 0) {
                                if (!a(bVar, list2)) {
                                    hVar.e(yVar);
                                    com.opos.mobad.model.e.e.a(this.f21580a, yVar);
                                }
                            }
                            hVar.d(yVar);
                        }
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put(STManager.KEY_AD_ID, bVar.x);
                        jSONObject.put("adSource", bVar.R);
                        jSONObject.put("bizTraceId", yVar.aU);
                        jSONObject.put("posId", bVar.y);
                        jSONArray.put(jSONObject);
                    }
                }
            }
            com.opos.cmn.an.f.a.b("FetchAdTask", "data size:" + jSONArray.length());
            if (jSONArray.length() <= 0) {
                context = this.f21580a;
                hVar.a(context, 1);
                return null;
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("adReqInfoList", jSONArray);
            HashMap hashMap = new HashMap();
            hashMap.put("Content-Type", am.f5520d);
            hashMap.put("Route-Data", com.opos.cmn.biz.a.e.a(this.f21580a));
            eVar = com.opos.cmn.func.b.b.b.a().a(this.f21580a, new d.a().a(jSONObject2.toString().getBytes()).a(hashMap).a("POST").b("https://uapi.ads.heytapmobi.com/union/ads/advert/aol").a());
            try {
                com.opos.cmn.an.f.a.b("FetchAdTask", "check code:" + eVar.f17168a);
            } catch (Throwable th2) {
                th = th2;
                try {
                    com.opos.cmn.an.f.a.b("FetchAdTask", "check fail", th);
                    if (eVar == null) {
                        return null;
                    }
                    return null;
                } finally {
                    if (eVar != null) {
                        eVar.a();
                    }
                }
            }
            if (200 != eVar.f17168a) {
                eVar.a();
                hVar.a(this.f21580a, 3);
                return null;
            }
            BufferedInputStream bufferedInputStream = new BufferedInputStream(eVar.f17170c);
            try {
                byte[] bArr = new byte[1024];
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                while (true) {
                    int read = bufferedInputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    if (read > 0) {
                        byteArrayOutputStream.write(bArr, 0, read);
                    }
                }
                String str = new String(byteArrayOutputStream.toByteArray(), Charset.forName("UTF-8"));
                com.opos.cmn.an.f.a.b("FetchAdTask", "check result:" + str);
                JSONObject jSONObject3 = new JSONObject(str);
                if (jSONObject3.getInt("code") == 0) {
                    JSONArray optJSONArray = jSONObject3.optJSONArray("traceIdList");
                    if (optJSONArray != null && optJSONArray.length() > 0) {
                        HashSet hashSet = new HashSet(optJSONArray.length());
                        for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                            hashSet.add(optJSONArray.getString(i2));
                        }
                        ArrayList arrayList = new ArrayList();
                        for (com.opos.mobad.b.a.b bVar2 : h2) {
                            List<y> list3 = bVar2.A;
                            if (list3 != null && list3.size() > 0) {
                                y yVar2 = bVar2.A.get(0);
                                if (hashSet.contains(yVar2.aU)) {
                                    hVar.i(yVar2);
                                    arrayList.add(bVar2);
                                } else {
                                    hVar.h(yVar2);
                                }
                            }
                        }
                        com.opos.cmn.an.f.a.a("FetchAdTask", "enable size:" + arrayList.size());
                        if (arrayList.size() > 0) {
                            hVar.a(this.f21580a);
                            com.opos.mobad.model.b.d dVar2 = new com.opos.mobad.model.b.d(dVar.c(), arrayList, dVar.i());
                            bufferedInputStream.close();
                            eVar.a();
                            return dVar2;
                        }
                        hVar.a(this.f21580a, 4);
                    }
                    hVar.a(this.f21580a, 4);
                } else {
                    hVar.a(this.f21580a, 3);
                }
                bufferedInputStream.close();
                return null;
            } finally {
            }
        }
        context = this.f21580a;
        hVar.a(context, 1);
        return null;
    }

    private com.opos.mobad.model.b.d a(String str, com.opos.mobad.model.b.c cVar, AtomicBoolean atomicBoolean, l lVar) {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        com.opos.mobad.model.b.d dVar = null;
        AtomicReference atomicReference = new AtomicReference(null);
        a(str, cVar.a(), countDownLatch, atomicReference, lVar, cVar);
        a(str, cVar, countDownLatch, atomicReference, atomicBoolean, lVar);
        try {
            countDownLatch.await();
            dVar = (com.opos.mobad.model.b.d) atomicReference.get();
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.b("FetchAdTask", "response, select fail", e2);
        }
        return dVar == null ? new com.opos.mobad.model.b.b(-1, "unknown error.") : dVar;
    }

    private com.opos.mobad.model.b.e a(x xVar) {
        if (com.opos.cmn.d.b.a(com.opos.cmn.d.c.a(this.f21580a, xVar.f19904d), xVar.f19905e)) {
            return null;
        }
        com.opos.mobad.model.b.e eVar = new com.opos.mobad.model.b.e();
        eVar.a(xVar.f19904d);
        eVar.b(xVar.f19905e);
        eVar.c(com.opos.cmn.d.c.a(this.f21580a, xVar.f19904d));
        return eVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x00c7, code lost:
    
        if (r14.size() < r36.b()) goto L161;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x0149, code lost:
    
        if (r2.size() > 0) goto L205;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x0153, code lost:
    
        if (r2.size() > 0) goto L205;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.opos.mobad.model.data.AdData a(java.lang.String r34, com.opos.mobad.model.b.c r35, com.opos.mobad.model.b.d r36, boolean r37, com.opos.mobad.model.d.l r38, java.util.concurrent.atomic.AtomicBoolean r39) {
        /*
            Method dump skipped, instructions count: 726
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.mobad.model.d.g.a(java.lang.String, com.opos.mobad.model.b.c, com.opos.mobad.model.b.d, boolean, com.opos.mobad.model.d.l, java.util.concurrent.atomic.AtomicBoolean):com.opos.mobad.model.data.AdData");
    }

    private MaterialFileData a(com.opos.mobad.b.a.b bVar, Set<com.opos.mobad.model.b.e> set, boolean z, q qVar) {
        x xVar = bVar.D;
        if (z) {
            set = null;
        }
        return a(xVar, true, set, qVar);
    }

    private MaterialFileData a(x xVar, boolean z) {
        if (xVar == null) {
            return null;
        }
        MaterialFileData materialFileData = new MaterialFileData();
        materialFileData.a(z ? xVar.f19904d : com.opos.cmn.d.c.a(this.f21580a, xVar.f19904d));
        materialFileData.b(xVar.f19905e);
        return materialFileData;
    }

    private MaterialFileData a(x xVar, boolean z, Set<com.opos.mobad.model.b.e> set, q qVar) {
        if (xVar == null || com.opos.cmn.an.c.a.a(xVar.f19904d)) {
            return null;
        }
        if (set == null) {
            return a(xVar, true);
        }
        com.opos.mobad.model.b.e a2 = a(xVar);
        if (a2 != null) {
            set.add(a2);
            if (!z) {
                com.opos.mobad.service.j.n.a().a(false);
            }
        } else {
            if (!z) {
                com.opos.mobad.service.j.n.a().a(true);
            }
            qVar.a(xVar.f19904d, 2);
            com.opos.cmn.an.f.a.b("FetchAdTask", "material File " + xVar.toString() + " exists,don't need download again!!!");
        }
        return a(xVar, false);
    }

    private List<MaterialData> a(y yVar, Set<com.opos.mobad.model.b.e> set, Set<com.opos.mobad.model.b.e> set2, boolean z, q qVar) {
        List<MaterialFileData> a2;
        List<MaterialFileData> a3;
        List<MaterialFileData> a4;
        List<x> list = yVar.V;
        if (z) {
            a2 = a(list, (Set<com.opos.mobad.model.b.e>) null, qVar);
            a3 = a(yVar.ba, (Set<com.opos.mobad.model.b.e>) null, qVar);
            a4 = yVar.Q == y.b.RAW_VIDEO ? a(yVar.S, set2, qVar) : a(yVar.S, (Set<com.opos.mobad.model.b.e>) null, qVar);
        } else {
            a2 = a(list, set, qVar);
            a3 = a(yVar.ba, set2, qVar);
            a4 = a(yVar.S, set, qVar);
        }
        List<MaterialFileData> a5 = a(yVar.aq, (Set<com.opos.mobad.model.b.e>) null, qVar);
        com.opos.mobad.b.a.r rVar = yVar.aH;
        MaterialData materialData = new MaterialData(yVar, a4, a2, a5, a3, rVar != null ? new FloatLayerData(yVar.aH, a(rVar.f19857d, false, set, qVar), a(yVar.aH.f19860g, set2, qVar), a(yVar.aH.f19861h, set2, qVar)) : null, yVar.aY != null ? new PendantData(a(yVar.aY.f19980g, false, set2, qVar), yVar.aY) : null);
        ArrayList arrayList = new ArrayList();
        arrayList.add(materialData);
        return arrayList;
    }

    private List<MaterialFileData> a(List<x> list, Set<com.opos.mobad.model.b.e> set, q qVar) {
        ArrayList arrayList = new ArrayList();
        if (list != null && list.size() > 0) {
            Iterator<x> it = list.iterator();
            while (it.hasNext()) {
                MaterialFileData a2 = a(it.next(), false, set, qVar);
                if (a2 != null) {
                    arrayList.add(a2);
                }
            }
        }
        return arrayList;
    }

    public List<com.opos.mobad.b.a.b> a(byte[] bArr) throws IOException {
        DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(bArr));
        ArrayList arrayList = new ArrayList();
        while (dataInputStream.available() > 0) {
            int readInt = dataInputStream.readInt();
            byte[] bArr2 = new byte[readInt];
            dataInputStream.read(bArr2, 0, readInt);
            arrayList.add(com.opos.mobad.b.a.b.f19603c.a(bArr2));
        }
        return arrayList;
    }

    public FutureTask<AdData> a(String str, com.opos.mobad.model.b.c cVar, boolean z) {
        return new FutureTask<>(new Callable<AdData>() { // from class: com.opos.mobad.model.d.g.2

            /* renamed from: a */
            final /* synthetic */ String f21591a;

            /* renamed from: b */
            final /* synthetic */ com.opos.mobad.model.b.c f21592b;

            /* renamed from: c */
            final /* synthetic */ boolean f21593c;

            AnonymousClass2(String str2, com.opos.mobad.model.b.c cVar2, boolean z2) {
                str = str2;
                cVar = cVar2;
                z = z2;
            }

            @Override // java.util.concurrent.Callable
            /* renamed from: a */
            public AdData call() throws Exception {
                return g.this.b(str, cVar, z);
            }
        });
    }

    private void a(String str, com.opos.mobad.model.b.c cVar, CountDownLatch countDownLatch, AtomicReference atomicReference, AtomicBoolean atomicBoolean, l lVar) {
        com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.model.d.g.4

            /* renamed from: a */
            final /* synthetic */ String f21602a;

            /* renamed from: b */
            final /* synthetic */ com.opos.mobad.model.b.c f21603b;

            /* renamed from: c */
            final /* synthetic */ l f21604c;

            /* renamed from: d */
            final /* synthetic */ AtomicReference f21605d;

            /* renamed from: e */
            final /* synthetic */ CountDownLatch f21606e;

            /* renamed from: f */
            final /* synthetic */ AtomicBoolean f21607f;

            AnonymousClass4(String str2, com.opos.mobad.model.b.c cVar2, l lVar2, AtomicReference atomicReference2, CountDownLatch countDownLatch2, AtomicBoolean atomicBoolean2) {
                str = str2;
                cVar = cVar2;
                lVar = lVar2;
                atomicReference = atomicReference2;
                countDownLatch = countDownLatch2;
                atomicBoolean = atomicBoolean2;
            }

            @Override // java.lang.Runnable
            public void run() {
                long currentTimeMillis = System.currentTimeMillis();
                com.opos.mobad.model.b.d a2 = g.this.f21581b.a(str, cVar, lVar);
                if (a2 != null && a2.f() == 1035) {
                    com.opos.mobad.service.f.c().a(str, false, a2.l());
                }
                g.this.a(str, cVar.a(), a2.f(), System.currentTimeMillis() - currentTimeMillis);
                if (atomicReference.compareAndSet(null, a2)) {
                    com.opos.cmn.an.f.a.b("FetchAdTask", "fetch data select");
                    countDownLatch.countDown();
                    return;
                }
                com.opos.cmn.an.f.a.b("FetchAdTask", "cache new fetchAd");
                if (a2.f() != 0 || a2.b() <= 0 || a2.h() == null || a2.h().size() <= 0) {
                    return;
                }
                List<com.opos.mobad.b.a.b> subList = a2.h().subList(0, Math.min(a2.b(), a2.h().size()));
                atomicBoolean.set(true);
                g.this.a(str, a2, subList);
            }
        });
    }

    public void a(String str, com.opos.mobad.model.b.d dVar, List<com.opos.mobad.b.a.b> list) {
        StringBuilder sb = new StringBuilder();
        sb.append("cache list num:");
        sb.append(list != null ? list.size() : 0);
        com.opos.cmn.an.f.a.b("FetchAdTask", sb.toString());
        if (list == null || list.size() <= 0) {
            return;
        }
        com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.model.d.g.6

            /* renamed from: a */
            final /* synthetic */ List f21611a;

            /* renamed from: b */
            final /* synthetic */ com.opos.mobad.model.b.d f21612b;

            /* renamed from: c */
            final /* synthetic */ String f21613c;

            AnonymousClass6(List list2, com.opos.mobad.model.b.d dVar2, String str2) {
                list = list2;
                dVar = dVar2;
                str = str2;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    byte[] b2 = g.this.b((List<com.opos.mobad.b.a.b>) list);
                    g.this.f21583d.a(str, new AdEntity(com.opos.mobad.b.a.d.f19667c.b((com.heytap.nearx.a.a.e<com.opos.mobad.b.a.d>) dVar.c()), b2, dVar.i()));
                } catch (Exception e2) {
                    com.opos.cmn.an.f.a.a("FetchAdTask", "cache fail", (Throwable) e2);
                }
            }
        });
    }

    public void a(String str, String str2, int i2, long j2) {
        com.opos.mobad.cmn.a.b.d.a(this.f21580a, str, str2, i2, j2);
    }

    private void a(String str, String str2, CountDownLatch countDownLatch, AtomicReference atomicReference, l lVar, com.opos.mobad.model.b.c cVar) {
        com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.model.d.g.3

            /* renamed from: a */
            final /* synthetic */ com.opos.mobad.model.b.c f21595a;

            /* renamed from: b */
            final /* synthetic */ String f21596b;

            /* renamed from: c */
            final /* synthetic */ String f21597c;

            /* renamed from: d */
            final /* synthetic */ l f21598d;

            /* renamed from: e */
            final /* synthetic */ AtomicReference f21599e;

            /* renamed from: f */
            final /* synthetic */ CountDownLatch f21600f;

            AnonymousClass3(com.opos.mobad.model.b.c cVar2, String str3, String str22, l lVar2, AtomicReference atomicReference2, CountDownLatch countDownLatch2) {
                cVar = cVar2;
                str = str3;
                str2 = str22;
                lVar = lVar2;
                atomicReference = atomicReference2;
                countDownLatch = countDownLatch2;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v12, types: [java.lang.String] */
            /* JADX WARN: Type inference failed for: r0v16 */
            /* JADX WARN: Type inference failed for: r0v17 */
            /* JADX WARN: Type inference failed for: r0v24 */
            /* JADX WARN: Type inference failed for: r0v25 */
            /* JADX WARN: Type inference failed for: r0v26 */
            /* JADX WARN: Type inference failed for: r0v5, types: [boolean] */
            /* JADX WARN: Type inference failed for: r0v7, types: [java.util.concurrent.CountDownLatch] */
            /* JADX WARN: Type inference failed for: r0v9, types: [com.opos.mobad.model.d.h] */
            /* JADX WARN: Type inference failed for: r1v2, types: [android.content.Context] */
            /* JADX WARN: Type inference failed for: r2v1 */
            /* JADX WARN: Type inference failed for: r2v10 */
            /* JADX WARN: Type inference failed for: r2v11 */
            /* JADX WARN: Type inference failed for: r2v12 */
            /* JADX WARN: Type inference failed for: r2v13 */
            /* JADX WARN: Type inference failed for: r2v14 */
            /* JADX WARN: Type inference failed for: r2v15 */
            /* JADX WARN: Type inference failed for: r2v6 */
            /* JADX WARN: Type inference failed for: r2v7 */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x00be -> B:9:0x00c7). Please report as a decompilation issue!!! */
            @Override // java.lang.Runnable
            public void run() {
                h hVar;
                ?? r2;
                AdEntity a2;
                g gVar;
                ?? r0;
                ?? r02;
                if (com.opos.mobad.service.a.c.a().d()) {
                    com.opos.mobad.model.b.c cVar2 = cVar;
                    String str3 = "FetchAdTask";
                    if (cVar2 == null || !com.opos.mobad.service.f.a.a(cVar2.i())) {
                        hVar = new h(str, str2);
                        r2 = 1;
                        r2 = 1;
                        r2 = 1;
                        i2 = 1;
                        int i2 = 1;
                        try {
                            a2 = g.this.f21583d.a(str);
                        } catch (Exception e2) {
                            com.opos.cmn.an.f.a.b(str3, "fail cache", e2);
                            r0 = hVar;
                            i2 = r2;
                        }
                        if (a2 == null) {
                            hVar.a(g.this.f21580a, 1);
                            hVar = hVar;
                            str3 = str3;
                        } else if (System.currentTimeMillis() >= a2.f23121c) {
                            hVar.a(g.this.f21580a, 2);
                            hVar = hVar;
                            str3 = str3;
                        } else {
                            com.opos.mobad.model.b.d dVar = new com.opos.mobad.model.b.d(com.opos.mobad.b.a.d.f19667c.a(a2.f23119a), g.this.a(a2.f23120b), a2.f23121c);
                            com.opos.cmn.an.f.a.b("FetchAdTask", "cache data:", dVar);
                            r0 = hVar;
                            if (dVar.h() != null) {
                                r0 = hVar;
                                if (dVar.h().size() > 0) {
                                    l lVar2 = lVar;
                                    if (lVar2 != null) {
                                        lVar2.a();
                                    }
                                    gVar = g.this;
                                    com.opos.mobad.model.b.d a3 = gVar.a(dVar, hVar);
                                    if (a3 == null) {
                                        r02 = "cache check fail";
                                    } else {
                                        AtomicReference atomicReference2 = atomicReference;
                                        ?? compareAndSet = atomicReference2.compareAndSet(null, a3);
                                        hVar = compareAndSet;
                                        str3 = str3;
                                        r2 = atomicReference2;
                                        if (compareAndSet != 0) {
                                            com.opos.cmn.an.f.a.b("FetchAdTask", "check cache select");
                                            ?? r03 = countDownLatch;
                                            r03.countDown();
                                            hVar = r03;
                                            str3 = str3;
                                            r2 = atomicReference2;
                                        }
                                    }
                                }
                            }
                            ?? r1 = g.this.f21580a;
                            r0.a(r1, i2);
                            hVar = r0;
                            str3 = r1;
                            r2 = i2;
                        }
                    }
                    r02 = "cache but in childMode";
                    com.opos.cmn.an.f.a.b("FetchAdTask", (String) r02);
                    hVar = r02;
                    str3 = str3;
                    r2 = gVar;
                }
            }
        });
    }

    private void a(List<AdItemData> list) {
        MaterialData materialData;
        com.opos.cmn.an.f.a.b("FetchAdTask", "prepare web" + list);
        if (list == null || list.size() <= 0) {
            return;
        }
        Iterator<AdItemData> it = list.iterator();
        while (it.hasNext()) {
            List<MaterialData> i2 = it.next().i();
            if (i2 != null && i2.size() > 0 && (materialData = i2.get(0)) != null) {
                u.a(this.f21580a, materialData.f21725i, materialData.f21724h);
            }
        }
    }

    private boolean a(com.opos.mobad.b.a.b bVar, List<x> list) {
        if (bVar.M == b.c.PLAY_CACHE) {
            x xVar = list.get(0);
            if (TextUtils.isEmpty(com.opos.cmn.d.d.a(this.f21580a, xVar.f19904d, xVar.f19905e))) {
                com.opos.mobad.service.j.n.a().b(false);
                com.opos.cmn.an.f.a.b("FetchAdTask", "isVideoEnableMaterial but not cache video");
                return false;
            }
            com.opos.mobad.service.j.n.a().b(true);
        }
        com.opos.cmn.an.f.a.b("FetchAdTask", "isVideoEnableMaterial");
        return true;
    }

    private boolean a(y yVar) {
        String str;
        y.c cVar;
        y.c cVar2;
        if (!b(yVar) || (cVar = yVar.ax) != (cVar2 = y.c.DOWNLOADER)) {
            str = "is not downloader mat";
        } else {
            if (cVar != cVar2) {
                com.opos.cmn.an.f.a.b("FetchAdTask", "is invalid downloader mat");
                return false;
            }
            str = "is downloader mat";
        }
        com.opos.cmn.an.f.a.b("FetchAdTask", str);
        return true;
    }

    private boolean a(y yVar, q qVar) {
        boolean z = yVar == null || !b(yVar, qVar);
        com.opos.cmn.an.f.a.b("FetchAdTask", "isValidMaterialEntity materialEntity=", yVar, "result=", Boolean.valueOf(z));
        return z;
    }

    public AdData b(String str, com.opos.mobad.model.b.c cVar, boolean z) {
        Exception e2;
        AdData adData;
        l lVar;
        com.opos.mobad.model.b.d a2;
        com.opos.cmn.an.f.a.b("FetchAdTask", "fetchAdData");
        try {
            lVar = new l(str, cVar.a());
            com.opos.cmn.an.f.a.a("FetchAdTask", "fetchAdRequest=", cVar);
            AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            a2 = a(str, cVar, atomicBoolean, lVar);
            com.opos.cmn.an.f.a.b("FetchAdTask", "fetchAdResponse end");
            com.opos.mobad.model.e.d.a(this.f21580a, str, a2.d());
            lVar.b();
            if (a2.p()) {
                com.opos.mobad.service.i.d.a().b();
            }
            if (a2.q()) {
                com.opos.mobad.service.f.b().a();
            }
            adData = z ? a(str, cVar, a2, false, lVar, atomicBoolean) : a(str, cVar, a2, true, lVar, atomicBoolean);
        } catch (Exception e3) {
            e2 = e3;
            adData = null;
        }
        try {
            if (adData.d() != 10000) {
                lVar.a(this.f21580a, adData.d(), adData.e(), a2.a(), cVar.i());
            } else {
                lVar.a(this.f21580a, a2.j(), a2.a(), cVar.i(), a(adData));
            }
        } catch (Exception e4) {
            e2 = e4;
            com.opos.cmn.an.f.a.a("FetchAdTask", "fetchAdData", (Throwable) e2);
            return adData;
        }
        return adData;
    }

    private boolean b(y yVar) {
        y.h hVar = yVar.R;
        y.h hVar2 = y.h.DOWNLOAD;
        return hVar == hVar2 || yVar.au == hVar2 || yVar.av == hVar2 || yVar.aI == hVar2 || yVar.aJ == hVar2;
    }

    private boolean b(y yVar, q qVar) {
        Integer num = yVar.aL;
        if (num != null) {
            int intValue = num.intValue();
            int i2 = f21578e;
            if (i2 == (i2 & intValue) && !TextUtils.isEmpty(yVar.X) && com.opos.cmn.an.h.d.a.d(this.f21580a, yVar.X)) {
                com.opos.cmn.an.f.a.b("FetchAdTask", "filter install");
                qVar.a(yVar);
                return true;
            }
            int i3 = f21579f;
            if (i3 == (intValue & i3) && !TextUtils.isEmpty(yVar.X) && !com.opos.cmn.an.h.d.a.d(this.f21580a, yVar.X)) {
                com.opos.cmn.an.f.a.b("FetchAdTask", "filter uninstall");
                qVar.g(yVar);
                return true;
            }
        }
        return false;
    }

    public byte[] b(List<com.opos.mobad.b.a.b> list) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        Iterator<com.opos.mobad.b.a.b> it = list.iterator();
        while (it.hasNext()) {
            byte[] b2 = com.opos.mobad.b.a.b.f19603c.b((com.heytap.nearx.a.a.e<com.opos.mobad.b.a.b>) it.next());
            dataOutputStream.writeInt(b2.length);
            dataOutputStream.write(b2);
        }
        dataOutputStream.flush();
        return byteArrayOutputStream.toByteArray();
    }

    private boolean c(y yVar) {
        y.b bVar = yVar.Q;
        return bVar == y.b.VIDEO || bVar == y.b.FULL_VIDEO || bVar == y.b.POP_WINDOW_VIDEO || bVar == y.b.RAW_VIDEO || bVar == y.b.VIDEO_HTML || bVar == y.b.VIDEO_TIP_BAR;
    }

    public void a(String str, com.opos.mobad.model.b.c cVar, com.opos.mobad.model.c.a aVar, long j2, boolean z, Object... objArr) {
        com.opos.cmn.an.j.b.b(new Runnable() { // from class: com.opos.mobad.model.d.g.1

            /* renamed from: a */
            final /* synthetic */ long f21584a;

            /* renamed from: b */
            final /* synthetic */ boolean f21585b;

            /* renamed from: c */
            final /* synthetic */ String f21586c;

            /* renamed from: d */
            final /* synthetic */ com.opos.mobad.model.b.c f21587d;

            /* renamed from: e */
            final /* synthetic */ com.opos.mobad.model.c.a f21588e;

            /* renamed from: f */
            final /* synthetic */ Object[] f21589f;

            AnonymousClass1(long j22, boolean z2, String str2, com.opos.mobad.model.b.c cVar2, com.opos.mobad.model.c.a aVar2, Object[] objArr2) {
                j2 = j22;
                z = z2;
                str = str2;
                cVar = cVar2;
                aVar = aVar2;
                objArr = objArr2;
            }

            @Override // java.lang.Runnable
            public void run() {
                com.opos.cmn.an.f.a.b("FetchAdTask", "fetchAd fetchTimeout=" + j2 + ",needDownloadMaterial=" + z);
                try {
                    try {
                        FutureTask a2 = g.this.a(str, cVar, z);
                        com.opos.cmn.an.j.b.b(a2);
                        AdData adData = (AdData) a2.get(j2, TimeUnit.MILLISECONDS);
                        com.opos.mobad.model.c.a aVar2 = aVar;
                        if (aVar2 != null) {
                            if (adData != null) {
                                aVar2.a(adData.d(), adData.e(), adData, objArr);
                            } else {
                                aVar2.a(-1, "unknown error.", null, objArr);
                            }
                        }
                    } catch (Exception e2) {
                        com.opos.cmn.an.f.a.c("FetchAdTask", SplashAd.KEY_FETCHAD, e2);
                        com.opos.mobad.model.c.a aVar22 = aVar;
                        if (aVar22 != null) {
                            aVar22.a(-1, "unknown error.", null, objArr);
                        }
                    }
                } catch (Throwable th) {
                    com.opos.mobad.model.c.a aVar3 = aVar;
                    if (aVar3 != null) {
                        aVar3.a(-1, "unknown error.", null, objArr);
                    }
                    throw th;
                }
            }
        });
    }
}
