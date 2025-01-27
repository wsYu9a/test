package com.vivo.mobilead.manager;

import com.vivo.ad.model.p;
import com.vivo.ad.model.t;
import com.vivo.ad.model.x;
import com.vivo.mobilead.j.c;
import com.vivo.mobilead.model.e;
import com.vivo.mobilead.util.d0;
import com.vivo.mobilead.util.h0;
import com.vivo.mobilead.util.n0;
import com.vivo.mobilead.util.o;
import com.vivo.mobilead.util.x0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.apache.tools.zip.UnixStat;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class e {

    /* renamed from: a */
    private com.vivo.mobilead.model.e f29527a;

    private static class b {

        /* renamed from: a */
        private static final e f29528a = new e();
    }

    /* synthetic */ e(a aVar) {
        this();
    }

    public static e c() {
        return b.f29528a;
    }

    private synchronized void d() {
        String i2 = com.vivo.mobilead.manager.b.l().i();
        if (i2 == null || "".equals(i2)) {
            return;
        }
        try {
            this.f29527a = a(new JSONObject(i2));
        } catch (Exception e2) {
            x0.b("StrategyManager", "strategy get error! " + e2);
        }
    }

    public com.vivo.mobilead.model.e a(JSONObject jSONObject) {
        String str;
        String str2;
        com.vivo.mobilead.model.e eVar = new com.vivo.mobilead.model.e();
        if (jSONObject != null) {
            jSONObject.optString("mediaId");
            eVar.f29577a = jSONObject.optInt("status", c.C0596c.f28919b);
            eVar.f29578b = jSONObject.optLong("nextRequestTime");
            eVar.f29579c = jSONObject.optLong("timestamp");
            com.vivo.mobilead.manager.b.l().b(eVar.f29578b);
            String str3 = "matchs";
            JSONArray optJSONArray = jSONObject.optJSONArray("matchs");
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                for (int i2 = 0; i2 < length; i2++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                    if (optJSONObject != null) {
                        eVar.a(optJSONObject.optString("key"), optJSONObject.optString("appId"));
                    }
                }
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("positions");
            if (optJSONArray2 != null) {
                int length2 = optJSONArray2.length();
                int i3 = 0;
                while (i3 < length2) {
                    JSONObject optJSONObject2 = optJSONArray2.optJSONObject(i3);
                    if (optJSONObject2 != null) {
                        e.a aVar = new e.a();
                        aVar.f29587a = optJSONObject2.optString("positionId");
                        optJSONObject2.optInt("status", c.C0596c.f28919b);
                        JSONArray optJSONArray3 = optJSONObject2.optJSONArray(str3);
                        if (optJSONArray3 != null) {
                            int length3 = optJSONArray3.length();
                            int i4 = 0;
                            while (i4 < length3) {
                                JSONObject optJSONObject3 = optJSONArray3.optJSONObject(i4);
                                if (optJSONObject3 != null) {
                                    aVar.a(optJSONObject3.optString("key"), optJSONObject3.optString("id"));
                                    str2 = str3;
                                    aVar.a(optJSONObject3.optString("key"), Integer.valueOf(optJSONObject3.optInt(com.umeng.analytics.pro.d.F, 0)));
                                } else {
                                    str2 = str3;
                                }
                                i4++;
                                str3 = str2;
                            }
                        }
                        str = str3;
                        eVar.a(aVar);
                    } else {
                        str = str3;
                    }
                    i3++;
                    str3 = str;
                }
            }
            HashSet hashSet = new HashSet();
            JSONArray optJSONArray4 = jSONObject.optJSONArray("integrationMediaList");
            String str4 = "";
            if (optJSONArray4 != null) {
                eVar.f29580d.clear();
                eVar.f29581e.clear();
                int length4 = optJSONArray4.length();
                for (int i5 = 0; i5 < length4; i5++) {
                    JSONObject optJSONObject4 = optJSONArray4.optJSONObject(i5);
                    if (optJSONObject4 != null) {
                        p pVar = new p();
                        pVar.f26920c = o.a().a(optJSONObject4.optString("appId"), "" + eVar.f29579c);
                        pVar.f26918a = optJSONObject4.optInt("sourceType");
                        pVar.f26919b = optJSONObject4.optInt("enable");
                        pVar.f26921d = optJSONObject4.optString("testToast");
                        if (pVar.f26919b == c.C0596c.f28918a) {
                            eVar.f29580d.add(pVar);
                            hashSet.add(Integer.valueOf(pVar.f26918a));
                        } else {
                            eVar.f29581e.add(pVar);
                        }
                    }
                }
            }
            JSONObject optJSONObject5 = jSONObject.optJSONObject("integrationPositionMap");
            if (optJSONObject5 != null) {
                Iterator<String> keys = optJSONObject5.keys();
                while (keys.hasNext()) {
                    String obj = keys.next().toString();
                    JSONArray optJSONArray5 = optJSONObject5.optJSONArray(obj);
                    if (optJSONArray5 != null) {
                        ArrayList arrayList = new ArrayList();
                        ArrayList arrayList2 = new ArrayList();
                        int i6 = 0;
                        while (i6 < optJSONArray5.length()) {
                            JSONObject optJSONObject6 = optJSONArray5.optJSONObject(i6);
                            t tVar = new t();
                            tVar.f26929a = optJSONObject6.optInt("sourceType");
                            tVar.f26930b = optJSONObject6.optInt(com.heytap.mcssdk.n.d.A);
                            o a2 = o.a();
                            String optString = optJSONObject6.optString("posId");
                            JSONObject jSONObject2 = optJSONObject5;
                            StringBuilder sb = new StringBuilder();
                            sb.append(str4);
                            String str5 = str4;
                            Iterator<String> it = keys;
                            sb.append(eVar.f29579c);
                            tVar.f26931c = a2.a(optString, sb.toString());
                            tVar.f26932d = optJSONObject6.optDouble("requestPr", -1.0d);
                            tVar.f26933e = (float) optJSONObject6.optDouble("showFactor", -1.0d);
                            if (hashSet.contains(Integer.valueOf(tVar.f26929a))) {
                                arrayList.add(tVar);
                            } else {
                                arrayList2.add(tVar);
                            }
                            i6++;
                            optJSONObject5 = jSONObject2;
                            str4 = str5;
                            keys = it;
                        }
                        JSONObject jSONObject3 = optJSONObject5;
                        String str6 = str4;
                        Iterator<String> it2 = keys;
                        if (arrayList.size() > 0) {
                            eVar.f29582f.put(obj, arrayList);
                        }
                        if (arrayList2.size() > 0) {
                            eVar.f29583g.put(obj, arrayList2);
                        }
                        optJSONObject5 = jSONObject3;
                        str4 = str6;
                        keys = it2;
                    }
                }
            }
            JSONObject optJSONObject7 = jSONObject.optJSONObject("timeoutMap");
            if (optJSONObject7 != null) {
                Iterator<String> keys2 = optJSONObject7.keys();
                while (keys2.hasNext()) {
                    String obj2 = keys2.next().toString();
                    eVar.f29584h.put(Integer.valueOf(d0.a(obj2)), Long.valueOf(optJSONObject7.optLong(obj2, com.vivo.mobilead.model.e.l.longValue())));
                }
            }
            JSONObject optJSONObject8 = jSONObject.optJSONObject("uiCfgMap");
            if (optJSONObject8 != null) {
                Iterator<String> keys3 = optJSONObject8.keys();
                while (keys3.hasNext()) {
                    String obj3 = keys3.next().toString();
                    JSONObject optJSONObject9 = optJSONObject8.optJSONObject(obj3);
                    if (optJSONObject9 != null) {
                        Iterator<String> keys4 = optJSONObject9.keys();
                        HashMap<String, x> hashMap = new HashMap<>();
                        while (keys4.hasNext()) {
                            String obj4 = keys4.next().toString();
                            JSONObject optJSONObject10 = optJSONObject9.optJSONObject(obj4);
                            if (optJSONObject10 != null) {
                                x xVar = new x();
                                xVar.a(optJSONObject10.optInt("copyWritingSpacingLr"));
                                xVar.b(optJSONObject10.optInt("copyWritingSpacingUd"));
                                xVar.c(optJSONObject10.optInt("fontSize"));
                                xVar.a(optJSONObject10.optString("fontColor"));
                                xVar.b(optJSONObject10.optString("installedText"));
                                xVar.d(optJSONObject10.optString("uninstalledText"));
                                hashMap.put(obj4, xVar);
                            }
                        }
                        eVar.f29586j.put(Integer.valueOf(d0.a(obj3)), hashMap);
                    }
                }
            }
            JSONObject optJSONObject11 = jSONObject.optJSONObject("config");
            if (optJSONObject11 != null) {
                com.vivo.mobilead.manager.b.l().a(optJSONObject11.optInt("bannerCircleTime", 15));
                com.vivo.mobilead.manager.b.l().b("KEY_PLAYPERCENTCLOSEBTN", optJSONObject11.optInt("playPercentCloseBtn", 80));
                com.vivo.mobilead.manager.b.l().b("KEY_VIDEOLOADCLOSEBTN", optJSONObject11.optInt("videoLoadCloseBtn", 5));
                com.vivo.mobilead.manager.b.l().a("SKIP_BTN_LOCATION", optJSONObject11.optInt("skipBtnLocation", 2));
                JSONArray optJSONArray6 = optJSONObject11.optJSONArray("collectionControls");
                if (optJSONArray6 != null && optJSONArray6.length() > 0) {
                    for (int i7 = 0; i7 < optJSONArray6.length(); i7++) {
                        JSONObject optJSONObject12 = optJSONArray6.optJSONObject(i7);
                        if (optJSONObject12 != null) {
                            int optInt = optJSONObject12.optInt("sourceType", 0);
                            if (optInt == c.a.f28912a.intValue()) {
                                h0.K().c(optJSONObject12.optInt("controlItem", UnixStat.PERM_MASK), optJSONObject12.optInt("ignoreItem", 0));
                            } else if (optInt == c.a.f28915d.intValue()) {
                                h0.K().a(optJSONObject12.optInt("controlItem", UnixStat.PERM_MASK), optJSONObject12.optInt("ignoreItem", 0));
                            } else if (optInt == c.a.f28913b.intValue()) {
                                h0.K().b(optJSONObject12.optInt("controlItem", UnixStat.PERM_MASK), optJSONObject12.optInt("ignoreItem", 0));
                            }
                        }
                    }
                }
                com.vivo.mobilead.manager.b.l().c(optJSONObject11.optInt("reqCtl", 31));
                n0.b().g(optJSONObject11.optInt("useRealTimeAppList", -1));
                n0.b().b(optJSONObject11.optInt("bannerReadFileTimeout", -1));
                n0.b().f(optJSONObject11.optInt("screenReadFileTimeout", -1));
                n0.b().d(optJSONObject11.optInt("interstitialReadFileTimeout", -1));
                n0.b().e(optJSONObject11.optInt("nativeReadFileTimeout", -1));
                n0.b().c(optJSONObject11.optInt("incentiveReadFileTimeout", -1));
            }
            com.vivo.mobilead.manager.b.l().c(jSONObject.optLong("svCloseFeatureSwitch", 0L));
        }
        return eVar;
    }

    public synchronized com.vivo.mobilead.model.e b(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            this.f29527a = a(jSONObject);
        } catch (Exception unused) {
        }
        com.vivo.mobilead.manager.b.l().a(jSONObject.toString());
        return this.f29527a;
    }

    private e() {
        d();
    }

    public com.vivo.mobilead.model.e b() {
        com.vivo.mobilead.model.e eVar = this.f29527a;
        return eVar == null ? new com.vivo.mobilead.model.e() : eVar;
    }

    public String a() {
        List<p> list;
        com.vivo.mobilead.model.e eVar = this.f29527a;
        if (eVar == null || (list = eVar.f29580d) == null || list.isEmpty()) {
            return "";
        }
        for (p pVar : this.f29527a.f29580d) {
            if (pVar.f26918a == c.a.f28913b.intValue()) {
                return pVar.f26920c;
            }
        }
        return "";
    }
}
