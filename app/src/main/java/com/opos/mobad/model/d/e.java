package com.opos.mobad.model.d;

import android.content.Context;
import com.baidu.mobads.sdk.internal.am;
import com.martian.rpauth.MartianRPUserManager;
import com.opos.acs.st.STManager;
import com.opos.cmn.func.b.b.d;
import com.opos.mobad.b.a.x;
import com.opos.mobad.b.a.y;
import com.opos.mobad.model.d.m;
import com.opos.mobad.model.data.AdData;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class e extends a {

    /* renamed from: b */
    private Context f21569b;

    /* renamed from: c */
    private String f21570c;

    /* renamed from: d */
    private String f21571d;

    /* renamed from: e */
    private com.opos.mobad.model.b.d f21572e;

    /* renamed from: com.opos.mobad.model.d.e$1 */
    class AnonymousClass1 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ com.opos.mobad.model.b.c f21573a;

        /* renamed from: b */
        final /* synthetic */ String f21574b;

        AnonymousClass1(com.opos.mobad.model.b.c cVar, String str) {
            cVar = cVar;
            str = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            e eVar;
            AdData adData;
            String str = "cAdLoader";
            if (com.opos.mobad.service.a.c.a().d()) {
                com.opos.mobad.model.b.c cVar = cVar;
                if (cVar == null || !com.opos.mobad.service.f.a.a(cVar.i())) {
                    try {
                        com.opos.mobad.model.b.d a2 = c.a(e.this.f21569b).a(str);
                        if (a2 == null) {
                            com.opos.cmn.an.f.a.b("cAdLoader", "cache null");
                            e.this.a(new AdData(10001, "net response is null."));
                        } else if (System.currentTimeMillis() >= a2.i()) {
                            e.this.a(new com.opos.mobad.model.b.b(10003, "now time over ad expire time."));
                        } else {
                            com.opos.cmn.an.f.a.b("cAdLoader", "cache data:", a2);
                            if (a2.h() == null || a2.h().size() <= 0) {
                                str = "adItemList is null.";
                                e.this.a(new com.opos.mobad.model.b.b(MartianRPUserManager.f14920g, "adItemList is null."));
                            } else {
                                e eVar2 = e.this;
                                e.this.a(eVar2.a(a2, ((a) eVar2).f21535a));
                            }
                        }
                    } catch (Exception e2) {
                        com.opos.cmn.an.f.a.b(str, "fail cache", e2);
                        str = "unknown error.";
                        e.this.a(new com.opos.mobad.model.b.b(-1, "unknown error."));
                    }
                    return;
                }
                com.opos.cmn.an.f.a.b("cAdLoader", "cache but in childMode");
                eVar = e.this;
                adData = new AdData(10001, "net response is null.");
            } else {
                com.opos.cmn.an.f.a.b("cAdLoader", "cache disable");
                eVar = e.this;
                adData = new AdData(10001, "net response is null.");
            }
            eVar.a(adData);
        }
    }

    public e(Context context, String str, String str2, com.opos.mobad.model.b.c cVar, boolean z, m.a aVar) {
        super(context, str, cVar, z, new i(str, str2, true), aVar);
        this.f21569b = context;
        this.f21570c = str;
        this.f21571d = str2;
    }

    public com.opos.mobad.model.b.d a(com.opos.mobad.model.b.d dVar, q qVar) {
        com.opos.cmn.func.b.b.e eVar;
        List<com.opos.mobad.b.a.b> h2;
        com.opos.mobad.model.b.d bVar;
        try {
            h2 = dVar.h();
        } catch (Throwable th) {
            th = th;
            eVar = null;
        }
        if (h2 != null && h2.size() > 0) {
            JSONArray jSONArray = new JSONArray();
            for (com.opos.mobad.b.a.b bVar2 : h2) {
                List<y> list = bVar2.A;
                if (list != null && list.size() > 0) {
                    y yVar = bVar2.A.get(0);
                    if (d.a(this.f21569b, yVar, qVar)) {
                        if (d.a(yVar)) {
                            List<x> list2 = yVar.aq;
                            if (list2 != null && list2.size() > 0) {
                                if (!d.a(this.f21569b, bVar2, list2)) {
                                    qVar.e(yVar);
                                    com.opos.mobad.model.e.e.a(this.f21569b, yVar);
                                }
                            }
                            qVar.d(yVar);
                        }
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put(STManager.KEY_AD_ID, bVar2.x);
                        jSONObject.put("adSource", bVar2.R);
                        jSONObject.put("bizTraceId", yVar.aU);
                        jSONObject.put("posId", bVar2.y);
                        jSONArray.put(jSONObject);
                    }
                }
            }
            com.opos.cmn.an.f.a.b("cAdLoader", "data size:" + jSONArray.length());
            if (jSONArray.length() <= 0) {
                return new com.opos.mobad.model.b.b(MartianRPUserManager.f14920g, "adItemList is null.");
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("adReqInfoList", jSONArray);
            ((a) this).f21535a.a();
            HashMap hashMap = new HashMap();
            hashMap.put("Content-Type", am.f5520d);
            hashMap.put("Route-Data", com.opos.cmn.biz.a.e.a(this.f21569b));
            eVar = com.opos.cmn.func.b.b.b.a().a(this.f21569b, new d.a().a(jSONObject2.toString().getBytes()).a(hashMap).a("POST").b("https://uapi.ads.heytapmobi.com/union/ads/advert/aol").a());
            try {
                com.opos.cmn.an.f.a.b("cAdLoader", "check code:" + eVar.f17168a);
            } catch (Throwable th2) {
                th = th2;
                try {
                    com.opos.cmn.an.f.a.b("cAdLoader", "check fail", th);
                } finally {
                    if (eVar != null) {
                        eVar.a();
                    }
                }
            }
            if (200 != eVar.f17168a) {
                this.f21572e = dVar;
                return new com.opos.mobad.model.b.b(-1, "unknown error.");
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
                com.opos.cmn.an.f.a.b("cAdLoader", "check result:" + str);
                JSONObject jSONObject3 = new JSONObject(str);
                if (jSONObject3.getInt("code") == 0) {
                    JSONArray optJSONArray = jSONObject3.optJSONArray("traceIdList");
                    if (optJSONArray != null && optJSONArray.length() > 0) {
                        HashSet hashSet = new HashSet(optJSONArray.length());
                        for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                            hashSet.add(optJSONArray.getString(i2));
                        }
                        ArrayList arrayList = new ArrayList();
                        for (com.opos.mobad.b.a.b bVar3 : h2) {
                            List<y> list3 = bVar3.A;
                            if (list3 != null && list3.size() > 0) {
                                y yVar2 = bVar3.A.get(0);
                                if (hashSet.contains(yVar2.aU)) {
                                    qVar.i(yVar2);
                                    arrayList.add(bVar3);
                                } else {
                                    qVar.h(yVar2);
                                }
                            }
                        }
                        com.opos.cmn.an.f.a.a("cAdLoader", "enable size:" + arrayList.size());
                        bVar = arrayList.size() <= 0 ? new com.opos.mobad.model.b.b(MartianRPUserManager.f14920g, "adItemList is null.") : new com.opos.mobad.model.b.d(dVar.c(), arrayList, dVar.i());
                    }
                    bVar = new com.opos.mobad.model.b.b(MartianRPUserManager.f14920g, "adItemList is null.");
                } else {
                    bVar = new com.opos.mobad.model.b.b(-1, "unknown error.");
                }
                bufferedInputStream.close();
                eVar.a();
                return bVar;
            } finally {
            }
        }
        return new com.opos.mobad.model.b.b(MartianRPUserManager.f14920g, "adItemList is null.");
    }

    private void a(String str, String str2, com.opos.mobad.model.b.c cVar) {
        com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.model.d.e.1

            /* renamed from: a */
            final /* synthetic */ com.opos.mobad.model.b.c f21573a;

            /* renamed from: b */
            final /* synthetic */ String f21574b;

            AnonymousClass1(com.opos.mobad.model.b.c cVar2, String str3) {
                cVar = cVar2;
                str = str3;
            }

            @Override // java.lang.Runnable
            public void run() {
                e eVar;
                AdData adData;
                String str3 = "cAdLoader";
                if (com.opos.mobad.service.a.c.a().d()) {
                    com.opos.mobad.model.b.c cVar2 = cVar;
                    if (cVar2 == null || !com.opos.mobad.service.f.a.a(cVar2.i())) {
                        try {
                            com.opos.mobad.model.b.d a2 = c.a(e.this.f21569b).a(str);
                            if (a2 == null) {
                                com.opos.cmn.an.f.a.b("cAdLoader", "cache null");
                                e.this.a(new AdData(10001, "net response is null."));
                            } else if (System.currentTimeMillis() >= a2.i()) {
                                e.this.a(new com.opos.mobad.model.b.b(10003, "now time over ad expire time."));
                            } else {
                                com.opos.cmn.an.f.a.b("cAdLoader", "cache data:", a2);
                                if (a2.h() == null || a2.h().size() <= 0) {
                                    str3 = "adItemList is null.";
                                    e.this.a(new com.opos.mobad.model.b.b(MartianRPUserManager.f14920g, "adItemList is null."));
                                } else {
                                    e eVar2 = e.this;
                                    e.this.a(eVar2.a(a2, ((a) eVar2).f21535a));
                                }
                            }
                        } catch (Exception e2) {
                            com.opos.cmn.an.f.a.b(str3, "fail cache", e2);
                            str3 = "unknown error.";
                            e.this.a(new com.opos.mobad.model.b.b(-1, "unknown error."));
                        }
                        return;
                    }
                    com.opos.cmn.an.f.a.b("cAdLoader", "cache but in childMode");
                    eVar = e.this;
                    adData = new AdData(10001, "net response is null.");
                } else {
                    com.opos.cmn.an.f.a.b("cAdLoader", "cache disable");
                    eVar = e.this;
                    adData = new AdData(10001, "net response is null.");
                }
                eVar.a(adData);
            }
        });
    }

    @Override // com.opos.mobad.model.d.a
    protected void a(y yVar) {
    }

    @Override // com.opos.mobad.model.d.a
    public void a(com.opos.mobad.model.b.c cVar) {
        a(this.f21570c, this.f21571d, cVar);
    }

    @Override // com.opos.mobad.model.d.a
    public void a(boolean z) {
        super.a(z);
    }

    public void k() {
        if (j() != 4 || this.f21572e == null) {
            return;
        }
        com.opos.cmn.an.f.a.b("cAdLoader", "cache origin cache");
        c a2 = c.a(this.f21569b);
        String str = this.f21570c;
        com.opos.mobad.model.b.d dVar = this.f21572e;
        a2.a(str, dVar, dVar.h());
    }
}
