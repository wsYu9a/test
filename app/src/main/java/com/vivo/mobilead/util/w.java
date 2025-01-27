package com.vivo.mobilead.util;

import android.text.TextUtils;
import com.cdo.oaps.ad.OapsKey;
import com.tencent.connect.common.Constants;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class w {
    private static String a(String str) {
        return TextUtils.isEmpty(str) ? "-10000" : str;
    }

    public static void b(com.vivo.ad.model.b bVar, String str, String str2) {
        if (j.b(com.vivo.mobilead.manager.b.l().h(), 5) && bVar != null) {
            String valueOf = String.valueOf(d.a(bVar) ? 1 : 0);
            String a2 = k.a(com.vivo.mobilead.manager.f.j().c()).a();
            String valueOf2 = bVar.a() == null ? "" : String.valueOf(bVar.a().a());
            HashMap hashMap = new HashMap();
            hashMap.put("cfrom", "3005");
            hashMap.put(OapsKey.KEY_TOKEN, a(bVar.P()));
            hashMap.put(com.heytap.mcssdk.n.d.p, a(a2));
            hashMap.put("adStyle", a(bVar.j() + ""));
            hashMap.put("isDeeplink", a(valueOf));
            hashMap.put("id", a(bVar.d()));
            hashMap.put("lossId", a(str));
            hashMap.put("renderType", a(valueOf2));
            hashMap.put("uiVersion", a(str2));
            hashMap.put("adType", a(bVar.l() + ""));
            com.vivo.mobilead.b.c cVar = new com.vivo.mobilead.b.c(com.vivo.mobilead.b.c.a("https://adsdk.vivo.com.cn", hashMap), "vivo");
            cVar.c(a(bVar.G()));
            cVar.b(a(bVar.C()));
            com.vivo.mobilead.manager.c.d().a(cVar);
        }
    }

    public static void c(com.vivo.ad.model.b bVar, String str, String str2) {
        if (j.b(com.vivo.mobilead.manager.b.l().h(), 5) && bVar != null) {
            String a2 = k.a(com.vivo.mobilead.manager.f.j().c()).a();
            String valueOf = bVar.a() == null ? "" : String.valueOf(bVar.a().a());
            HashMap hashMap = new HashMap();
            hashMap.put("cfrom", "3008");
            hashMap.put(OapsKey.KEY_TOKEN, a(bVar.P()));
            hashMap.put(com.heytap.mcssdk.n.d.p, a(a2));
            hashMap.put("adStyle", a(bVar.j() + ""));
            hashMap.put("id", a(bVar.d()));
            hashMap.put("lossId", a(str));
            hashMap.put("renderType", a(valueOf));
            hashMap.put("uiVersion", a(str2));
            hashMap.put("adType", a(bVar.l() + ""));
            com.vivo.mobilead.b.c cVar = new com.vivo.mobilead.b.c(com.vivo.mobilead.b.c.a("https://adsdk.vivo.com.cn", hashMap), "vivo");
            cVar.c(a(bVar.G()));
            cVar.b(a(bVar.C()));
            com.vivo.mobilead.manager.c.d().a(cVar);
        }
    }

    public static void d(com.vivo.ad.model.b bVar, String str, String str2) {
        if (j.b(com.vivo.mobilead.manager.b.l().h(), 4) && bVar != null) {
            String valueOf = String.valueOf(d.a(bVar) ? 1 : 0);
            String a2 = k.a(com.vivo.mobilead.manager.f.j().c()).a();
            String valueOf2 = bVar.a() == null ? "" : String.valueOf(bVar.a().a());
            HashMap hashMap = new HashMap();
            hashMap.put("cfrom", "3002");
            hashMap.put(OapsKey.KEY_TOKEN, a(bVar.P()));
            hashMap.put(com.heytap.mcssdk.n.d.p, a(a2));
            hashMap.put("adStyle", a(bVar.j() + ""));
            hashMap.put("isDeeplink", a(valueOf));
            hashMap.put("id", a(bVar.d()));
            hashMap.put("lossId", a(str));
            hashMap.put("renderType", a(valueOf2));
            hashMap.put("uiVersion", a(str2));
            hashMap.put("adType", a(bVar.l() + ""));
            com.vivo.mobilead.b.c cVar = new com.vivo.mobilead.b.c(com.vivo.mobilead.b.c.a("https://adsdk.vivo.com.cn", hashMap), "vivo");
            cVar.c(a(bVar.G()));
            cVar.b(a(bVar.C()));
            com.vivo.mobilead.manager.c.d().a(cVar);
        }
    }

    public static void e(com.vivo.ad.model.b bVar, String str, String str2) {
        if (j.b(com.vivo.mobilead.manager.b.l().h(), 5) && bVar != null) {
            String valueOf = String.valueOf(d.a(bVar) ? 1 : 0);
            String a2 = k.a(com.vivo.mobilead.manager.f.j().c()).a();
            String valueOf2 = bVar.a() == null ? "" : String.valueOf(bVar.a().a());
            HashMap hashMap = new HashMap();
            hashMap.put("cfrom", "3003");
            hashMap.put(OapsKey.KEY_TOKEN, a(bVar.P()));
            hashMap.put(com.heytap.mcssdk.n.d.p, a(a2));
            hashMap.put("adStyle", a(bVar.j() + ""));
            hashMap.put("isDeeplink", a(valueOf));
            hashMap.put("id", a(bVar.d()));
            hashMap.put("lossId", a(str));
            hashMap.put("renderType", a(valueOf2));
            hashMap.put("uiVersion", a(str2));
            hashMap.put("adType", a(bVar.l() + ""));
            com.vivo.mobilead.b.c cVar = new com.vivo.mobilead.b.c(com.vivo.mobilead.b.c.a("https://adsdk.vivo.com.cn", hashMap), "vivo");
            cVar.c(a(bVar.G()));
            cVar.b(a(bVar.C()));
            com.vivo.mobilead.manager.c.d().a(cVar);
        }
    }

    public static void f(com.vivo.ad.model.b bVar, String str, String str2) {
        if (j.b(com.vivo.mobilead.manager.b.l().h(), 5) && bVar != null) {
            String a2 = k.a(com.vivo.mobilead.manager.f.j().c()).a();
            String valueOf = bVar.a() == null ? "" : String.valueOf(bVar.a().a());
            HashMap hashMap = new HashMap();
            hashMap.put("cfrom", "3006");
            hashMap.put(OapsKey.KEY_TOKEN, a(bVar.P()));
            hashMap.put(com.heytap.mcssdk.n.d.p, a(a2));
            hashMap.put("adStyle", a(bVar.j() + ""));
            hashMap.put("id", a(bVar.d()));
            hashMap.put("lossId", a(str));
            hashMap.put("renderType", a(valueOf));
            hashMap.put("uiVersion", a(str2));
            hashMap.put("adType", a(bVar.l() + ""));
            com.vivo.mobilead.b.c cVar = new com.vivo.mobilead.b.c(com.vivo.mobilead.b.c.a("https://adsdk.vivo.com.cn", hashMap), "vivo");
            cVar.c(a(bVar.G()));
            cVar.b(a(bVar.C()));
            com.vivo.mobilead.manager.c.d().a(cVar);
        }
    }

    public static void g(com.vivo.ad.model.b bVar, String str, String str2) {
        if (j.b(com.vivo.mobilead.manager.b.l().h(), 5) && bVar != null) {
            String a2 = k.a(com.vivo.mobilead.manager.f.j().c()).a();
            String valueOf = bVar.a() == null ? "" : String.valueOf(bVar.a().a());
            HashMap hashMap = new HashMap();
            hashMap.put("cfrom", "3007");
            hashMap.put(OapsKey.KEY_TOKEN, a(bVar.P()));
            hashMap.put(com.heytap.mcssdk.n.d.p, a(a2));
            hashMap.put("adStyle", a(bVar.j() + ""));
            hashMap.put("id", a(bVar.d()));
            hashMap.put("lossId", a(str));
            hashMap.put("renderType", a(valueOf));
            hashMap.put("uiVersion", a(str2));
            hashMap.put("adType", a(bVar.l() + ""));
            com.vivo.mobilead.b.c cVar = new com.vivo.mobilead.b.c(com.vivo.mobilead.b.c.a("https://adsdk.vivo.com.cn", hashMap), "vivo");
            cVar.c(a(bVar.G()));
            cVar.b(a(bVar.C()));
            com.vivo.mobilead.manager.c.d().a(cVar);
        }
    }

    public static void a(String str, String str2, String str3, String str4, String str5, String str6) {
        a(str, str2, str3, str4, str5, str6, "");
    }

    public static void a(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        if (j.b(com.vivo.mobilead.manager.b.l().h(), 1)) {
            HashMap hashMap = new HashMap();
            hashMap.put("cfrom", Constants.DEFAULT_UIN);
            hashMap.put(com.heytap.mcssdk.n.d.p, a(str2));
            hashMap.put("lossId", a(str3));
            hashMap.put("renderType", a(str4));
            hashMap.put("uiVersion", a(str5));
            hashMap.put("adType", a(str6));
            hashMap.put("renderStyle", String.valueOf(str7));
            com.vivo.mobilead.b.c cVar = new com.vivo.mobilead.b.c(com.vivo.mobilead.b.c.a("https://adsdk.vivo.com.cn", hashMap), "vivo");
            cVar.b(a(str));
            com.vivo.mobilead.manager.c.d().a(cVar);
        }
    }

    public static void a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10) {
        a(str, str2, str3, str4, str5, str6, str7, str8, str9, str10, "");
    }

    public static void a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11) {
        if (j.b(com.vivo.mobilead.manager.b.l().h(), 2)) {
            HashMap hashMap = new HashMap();
            hashMap.put("cfrom", "3000");
            hashMap.put(com.heytap.mcssdk.n.d.p, a(str2));
            hashMap.put("adStyle", a(str3));
            hashMap.put("isDeeplink", a(str4));
            hashMap.put("id", a(str6));
            hashMap.put("lossId", a(str7));
            hashMap.put("renderType", a(str8));
            hashMap.put("uiVersion", a(str9));
            hashMap.put("adType", a(str10));
            hashMap.put("renderStyle", a(str11));
            com.vivo.mobilead.b.c cVar = new com.vivo.mobilead.b.c(com.vivo.mobilead.b.c.a("https://adsdk.vivo.com.cn", hashMap), "vivo");
            cVar.c(a(str5));
            cVar.b(a(str));
            com.vivo.mobilead.manager.c.d().a(cVar);
        }
    }

    public static void a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12) {
        if (j.b(com.vivo.mobilead.manager.b.l().h(), 3)) {
            HashMap hashMap = new HashMap();
            hashMap.put("cfrom", "3001");
            hashMap.put(OapsKey.KEY_TOKEN, a(str));
            hashMap.put(com.heytap.mcssdk.n.d.p, a(str3));
            hashMap.put("adStyle", a(str4));
            hashMap.put("isDeeplink", a(str5));
            hashMap.put("materialType", a(str7));
            hashMap.put("id", a(str8));
            hashMap.put("lossId", a(str9));
            hashMap.put("renderType", a(str10));
            hashMap.put("uiVersion", a(str11));
            hashMap.put("adType", a(str12));
            com.vivo.mobilead.b.c cVar = new com.vivo.mobilead.b.c(com.vivo.mobilead.b.c.a("https://adsdk.vivo.com.cn", hashMap), "vivo");
            cVar.c(a(str6));
            cVar.b(a(str2));
            com.vivo.mobilead.manager.c.d().a(cVar);
        }
    }

    public static void a(List<com.vivo.mobilead.unified.exitFloat.c> list, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        com.vivo.ad.model.b a2;
        if (j.b(com.vivo.mobilead.manager.b.l().h(), 3)) {
            JSONArray jSONArray = new JSONArray();
            if (list != null && list.size() > 0) {
                for (com.vivo.mobilead.unified.exitFloat.c cVar : list) {
                    if (cVar != null && (a2 = cVar.a()) != null) {
                        JSONObject jSONObject = new JSONObject();
                        if (!TextUtils.isEmpty(a2.P())) {
                            t.a(jSONObject, OapsKey.KEY_TOKEN, a2.P());
                        }
                        if (!TextUtils.isEmpty(a2.G())) {
                            t.a(jSONObject, "reqId", a2.G());
                        }
                        t.a(jSONObject, "adStyle", a2.j() + "");
                        if (!TextUtils.isEmpty(a2.d())) {
                            t.a(jSONObject, "id", a2.d());
                        }
                        com.vivo.ad.model.r z = a2.z();
                        int i2 = 0;
                        if (z != null && 1 == z.a()) {
                            i2 = 1;
                        }
                        t.a(jSONObject, "isDeeplink", i2 + "");
                        if (jSONObject.length() > 0) {
                            jSONArray.put(jSONObject);
                        }
                    }
                }
            }
            HashMap hashMap = new HashMap();
            hashMap.put("cfrom", "3001");
            hashMap.put(com.heytap.mcssdk.n.d.p, a(str2));
            hashMap.put("materialType", a(str3));
            hashMap.put("lossId", a(str4));
            hashMap.put("renderType", a(str5));
            hashMap.put("uiVersion", a(str6));
            hashMap.put("adType", a(str7));
            hashMap.put("renderStyle", a(str8));
            hashMap.put("admsg", a(jSONArray.toString()));
            com.vivo.mobilead.b.c cVar2 = new com.vivo.mobilead.b.c(com.vivo.mobilead.b.c.a("https://adsdk.vivo.com.cn", hashMap), "vivo");
            cVar2.b(a(str));
            com.vivo.mobilead.manager.c.d().a(cVar2);
        }
    }

    public static void a(com.vivo.ad.model.b bVar, String str, String str2) {
        if (j.b(com.vivo.mobilead.manager.b.l().h(), 5) && bVar != null) {
            String valueOf = String.valueOf(d.a(bVar) ? 1 : 0);
            String a2 = k.a(com.vivo.mobilead.manager.f.j().c()).a();
            String valueOf2 = bVar.a() == null ? "" : String.valueOf(bVar.a().a());
            HashMap hashMap = new HashMap();
            hashMap.put("cfrom", "3004");
            hashMap.put(OapsKey.KEY_TOKEN, a(bVar.P()));
            hashMap.put(com.heytap.mcssdk.n.d.p, a(a2));
            hashMap.put("adStyle", a(bVar.j() + ""));
            hashMap.put("isDeeplink", a(valueOf));
            hashMap.put("id", a(bVar.d()));
            hashMap.put("lossId", a(str));
            hashMap.put("renderType", a(valueOf2));
            hashMap.put("uiVersion", a(str2));
            hashMap.put("adType", a(bVar.l() + ""));
            com.vivo.mobilead.b.c cVar = new com.vivo.mobilead.b.c(com.vivo.mobilead.b.c.a("https://adsdk.vivo.com.cn", hashMap), "vivo");
            cVar.c(a(bVar.G()));
            cVar.b(a(bVar.C()));
            com.vivo.mobilead.manager.c.d().a(cVar);
        }
    }
}
