package com.kwad.sdk.core.request.model;

import android.content.Context;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.components.h;
import com.kwad.sdk.components.o;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ad;
import com.kwad.sdk.utils.aj;
import com.kwad.sdk.utils.av;
import com.kwad.sdk.utils.ba;
import com.kwad.sdk.utils.bo;
import com.kwad.sdk.utils.l;
import com.kwad.sdk.utils.q;
import org.json.JSONArray;

@KsJson
/* loaded from: classes3.dex */
public class b extends com.kwad.sdk.core.response.a.a {
    private static boolean aDq;
    private static JSONArray aDr;
    public String Uu;
    public String ZG;
    public int ZH;
    public int ZJ;
    public String ZK;
    public int ZM;
    public int ZN;
    public String aDA;
    public String aDB;
    public String aDC;
    public int aDD;
    public String aDE;
    public String aDF;
    public String aDG;
    public JSONArray aDH;
    public String aDI;
    public String aDK;
    public String aDL;
    public String aDM;

    @Deprecated
    public String aDO;
    public String aDP;
    public String aDs;
    public String aDt;
    public String aDu;
    public String aDv;
    public String aDw;
    public String aDx;
    public int aDy;
    public int aDz;
    public String axi;
    public String axj;
    public int aDJ = 0;
    public long aDN = 0;

    /* renamed from: com.kwad.sdk.core.request.model.b$1 */
    public class AnonymousClass1 implements com.kwad.sdk.f.a<JSONArray> {
        private static void g(JSONArray jSONArray) {
            JSONArray unused = b.aDr = jSONArray;
        }

        @Override // com.kwad.sdk.f.a
        public final /* synthetic */ void accept(JSONArray jSONArray) {
            g(jSONArray);
        }
    }

    public static b GH() {
        b bVar = new b();
        try {
            bVar.axj = ba.getOaid();
            bVar.aDB = ba.getDeviceId();
            bVar.aDE = bo.OV();
            bVar.ZH = 1;
            bVar.ZJ = bo.Pi();
            bVar.aDx = bo.getOsVersion();
            bVar.aDG = ad.NA();
            h hVar = (h) com.kwad.sdk.components.d.f(h.class);
            if (hVar != null) {
                bVar.aDF = hVar.pl();
            }
            if (((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)) != null) {
                bVar.axi = ba.cN(ServiceProvider.MA());
            }
        } catch (Throwable th2) {
            ServiceProvider.reportSdkCaughtException(th2);
        }
        return bVar;
    }

    private static synchronized JSONArray by(Context context) {
        synchronized (b.class) {
            try {
                if (!aDq) {
                    aDq = true;
                    o oVar = (o) com.kwad.sdk.components.d.f(o.class);
                    com.kwad.sdk.core.d.c.d("DeviceInfo", "getAppList: OptDataFetchComponent: " + oVar);
                    if (oVar != null && q.MZ()) {
                        oVar.a(context, new com.kwad.sdk.f.a<JSONArray>() { // from class: com.kwad.sdk.core.request.model.b.1
                            private static void g(JSONArray jSONArray) {
                                JSONArray unused = b.aDr = jSONArray;
                            }

                            @Override // com.kwad.sdk.f.a
                            public final /* synthetic */ void accept(JSONArray jSONArray) {
                                g(jSONArray);
                            }
                        });
                    }
                }
                JSONArray jSONArray = aDr;
                if (jSONArray == null) {
                    return null;
                }
                aDr = null;
                return jSONArray;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public static b h(boolean z10, int i10) {
        b bVar = new b();
        try {
            Context MA = ServiceProvider.MA();
            bVar.axi = ba.cN(MA);
            bVar.aDs = ba.cQ(MA);
            bVar.aDt = ba.cR(MA);
            bVar.aDu = bo.dt(MA);
            bVar.axj = ba.getOaid();
            bVar.aDE = bo.OV();
            bVar.ZG = bo.OX();
            bVar.ZH = 1;
            bVar.ZJ = bo.Pi();
            bVar.aDx = bo.getOsVersion();
            bVar.ZK = l.getLanguage();
            bVar.ZN = l.getScreenHeight(MA);
            bVar.ZM = l.getScreenWidth(MA);
            bVar.aDy = l.ck(MA);
            bVar.aDz = l.cl(MA);
            bVar.aDA = ba.cO(MA);
            if (z10) {
                bVar.aDH = by(MA);
            }
            bVar.aDB = ba.getDeviceId();
            bVar.aDN = bo.OW();
            bVar.aDC = bo.Pf();
            bVar.aDG = ad.NA();
            h hVar = (h) com.kwad.sdk.components.d.f(h.class);
            if (hVar != null) {
                bVar.aDF = hVar.pl();
            }
            bVar.aDD = bo.Pg();
            com.kwad.sdk.service.a.f fVar = (com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class);
            try {
                StringBuilder sb2 = new StringBuilder("i=");
                sb2.append(fVar.getAppId());
                sb2.append(",n=");
                sb2.append(fVar.getAppName());
                sb2.append(",external:");
                sb2.append(fVar.zB());
                sb2.append(",v1:");
                sb2.append(fVar.getApiVersion());
                sb2.append(",v2:3.3.69");
                sb2.append(",d:");
                sb2.append(bVar.aDB);
                sb2.append(",dh:");
                String str = bVar.aDB;
                sb2.append(str != null ? Integer.valueOf(str.hashCode()) : "");
                sb2.append(",o:");
                sb2.append(bVar.axj);
                sb2.append(",b:42");
                sb2.append(",p:");
                sb2.append(av.isInMainProcess(MA));
                sb2.append(",dy:");
                sb2.append(com.kwad.framework.a.a.agP);
                com.kwad.sdk.core.d.c.T("DeviceInfo", sb2.toString());
            } catch (Exception unused) {
            }
            bVar.aDI = bo.Ph();
            bVar.aDJ = i10;
            if (zT() && com.kwad.sdk.app.b.BJ() != null) {
                bVar.aDK = com.kwad.sdk.app.b.BJ().getVersion(MA, "com.smile.gifmaker");
                bVar.aDL = com.kwad.sdk.app.b.BJ().getVersion(MA, "com.kuaishou.nebula");
                bVar.aDM = com.kwad.sdk.app.b.BJ().getVersion(MA, "com.tencent.mm");
            }
            bVar.Uu = bo.Pd();
            bVar.aDw = aj.cz(MA);
            bVar.aDP = bo.hn("/data/data");
        } catch (Throwable th2) {
            ServiceProvider.reportSdkCaughtException(th2);
        }
        return bVar;
    }

    private static boolean zT() {
        return ((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).zT();
    }
}
