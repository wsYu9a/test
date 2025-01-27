package com.opos.acs.st.utils;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobads.sdk.internal.am;
import com.kuaishou.weapon.p0.t;
import com.opos.acs.st.STManager;
import com.opos.cmn.biz.ststrategy.entity.DataEntity;
import com.opos.cmn.biz.ststrategy.entity.MetaEntity;
import com.opos.cmn.biz.ststrategy.entity.STConfigEntity;
import com.opos.cmn.biz.ststrategy.entity.StrategyEntity;
import com.vivo.ic.dm.Downloads;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.UUID;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.regex.Pattern;
import org.apache.http.HttpHeaders;
import org.apache.http.protocol.HTTP;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public final class h {

    /* renamed from: a */
    private static final byte[] f16325a = new byte[0];

    /* renamed from: b */
    private static final ReadWriteLock f16326b = new ReentrantReadWriteLock();

    /* renamed from: c */
    private static Timer f16327c = null;

    /* renamed from: d */
    private static final byte[] f16328d = new byte[0];

    /* renamed from: e */
    private static boolean f16329e = false;

    /* renamed from: f */
    private static boolean f16330f = false;

    /* renamed from: g */
    private static boolean f16331g = false;

    /* renamed from: h */
    private static final ReentrantReadWriteLock f16332h = new ReentrantReadWriteLock();

    /* renamed from: com.opos.acs.st.utils.h$1 */
    static final class AnonymousClass1 implements Runnable {

        /* renamed from: a */
        private /* synthetic */ Context f16333a;

        /* renamed from: b */
        private /* synthetic */ boolean f16334b;

        /* renamed from: c */
        private /* synthetic */ Map f16335c;

        /* renamed from: d */
        private /* synthetic */ MetaEntity f16336d;

        /* renamed from: e */
        private /* synthetic */ STManager.EventListener f16337e;

        AnonymousClass1(Context context, boolean z, Map map, MetaEntity metaEntity, STManager.EventListener eventListener) {
            context = context;
            z3 = z;
            map = map;
            c3 = metaEntity;
            eventListener = eventListener;
        }

        @Override // java.lang.Runnable
        public final void run() {
            h.a(context, false, z3, map, c3, eventListener);
        }
    }

    /* renamed from: com.opos.acs.st.utils.h$2 */
    static final class AnonymousClass2 implements a {

        /* renamed from: a */
        private /* synthetic */ boolean f16338a;

        /* renamed from: b */
        private /* synthetic */ STManager.EventListener f16339b;

        /* renamed from: c */
        private /* synthetic */ Context f16340c;

        /* renamed from: d */
        private /* synthetic */ com.opos.acs.st.b.c f16341d;

        /* renamed from: e */
        private /* synthetic */ MetaEntity f16342e;

        /* renamed from: f */
        private /* synthetic */ boolean f16343f;

        /* renamed from: g */
        private /* synthetic */ long f16344g;

        /* renamed from: h */
        private /* synthetic */ String f16345h;

        AnonymousClass2(boolean z, STManager.EventListener eventListener, Context context, com.opos.acs.st.b.c cVar, MetaEntity metaEntity, boolean z2, long j2, String str) {
            z2 = z;
            eventListener = eventListener;
            context = context;
            a2 = cVar;
            metaEntity = metaEntity;
            z3 = z2;
            currentTimeMillis = j2;
            str4 = str;
        }

        @Override // com.opos.acs.st.utils.h.a
        public final void a() {
            h.b(z2, 1, eventListener);
        }

        @Override // com.opos.acs.st.utils.h.a
        public final void a(String str, String str2) {
            if (!"400".equals(str)) {
                h.a(context, a2, metaEntity.aggrFlag, 0);
                if (!z3) {
                    h.a(context, a2, str);
                }
            }
            long currentTimeMillis = System.currentTimeMillis() - currentTimeMillis;
            String str3 = metaEntity.dataType;
            String str4 = z3 ? ErrorContants.NEW_REALTIME_REPORT_ERROR : ErrorContants.REALTIME_REPORT_ERROR;
            e.a(context);
            e.a(ErrorContants.errorContantseMap(context, "5", str4, str4, str, currentTimeMillis, currentTimeMillis, "dataType:" + str3 + "response:" + str2));
            h.b(z2, 2, eventListener);
        }
    }

    /* renamed from: com.opos.acs.st.utils.h$3 */
    static final class AnonymousClass3 implements a {

        /* renamed from: a */
        private /* synthetic */ Context f16346a;

        /* renamed from: b */
        private /* synthetic */ Integer[] f16347b;

        /* renamed from: c */
        private /* synthetic */ List f16348c;

        /* renamed from: d */
        private /* synthetic */ long f16349d;

        /* renamed from: e */
        private /* synthetic */ List f16350e;

        /* renamed from: f */
        private /* synthetic */ String f16351f;

        /* renamed from: g */
        private /* synthetic */ String f16352g;

        AnonymousClass3(Context context, Integer[] numArr, List list, long j2, List list2, String str, String str2) {
            context = context;
            numArr = numArr;
            arrayList = list;
            currentTimeMillis = j2;
            subList = list2;
            str2 = str;
            str = str2;
        }

        @Override // com.opos.acs.st.utils.h.a
        public final void a() {
            h.a(context, numArr, arrayList);
        }

        @Override // com.opos.acs.st.utils.h.a
        public final void a(String str, String str2) {
            long currentTimeMillis = System.currentTimeMillis() - currentTimeMillis;
            boolean z = subList.size() > 0 && ((com.opos.acs.st.b.c) subList.get(0)).f16299j == 1;
            String str3 = z ? ErrorContants.NEW_PERIODIC_REPORT_ERROR : ErrorContants.PERIODIC_REPORT_ERROR;
            e.a(context);
            e.a(ErrorContants.errorContantseMap(context, "5", str3, str2, str, currentTimeMillis, currentTimeMillis, "dataType:" + str + ",response:" + str2));
            if ("400".equals(str)) {
                h.a(context, numArr, arrayList);
            } else {
                if (z) {
                    return;
                }
                for (int i2 = 0; i2 < subList.size(); i2++) {
                    h.a(context, (com.opos.acs.st.b.c) subList.get(i2), str);
                }
            }
        }
    }

    interface a {
        void a();

        void a(String str, String str2);
    }

    private static com.opos.acs.st.b.c a(Context context, String str, Map<String, String> map, boolean z) {
        int i2;
        com.opos.acs.st.b.c cVar = new com.opos.acs.st.b.c();
        cVar.f16291b = str;
        cVar.f16292c = map.get(STManager.KEY_AD_ID);
        cVar.f16293d = a(context, str, map);
        if (map.get("parEvtId") != null) {
            cVar.f16297h = map.get("parEvtId");
        }
        cVar.f16298i = System.currentTimeMillis();
        long currentTimeMillis = System.currentTimeMillis();
        StrategyEntity i3 = i(context);
        MetaEntity c2 = c(context, str);
        List<String> list = c2 != null ? c2.eventKeys : null;
        if (z) {
            cVar.k = a(context, i3 != null ? i3.commonKeys : null, map);
            cVar.l = a(context, list, map);
            i2 = 1;
        } else {
            String a2 = a(context, str);
            List<String> list2 = i3 != null ? i3.headKeys : null;
            List<String> list3 = i3 != null ? i3.bodyKeys : null;
            cVar.f16294e = a(context, list2, map, a2);
            cVar.f16295f = a(context, list3, map, a2);
            cVar.f16296g = a(context, list, map, ",");
            i2 = 0;
        }
        cVar.f16299j = i2;
        com.opos.cmn.an.f.a.a("Utils", "map2AcsStDbCache,dataType=" + str + ",cost time=" + (System.currentTimeMillis() - currentTimeMillis));
        return cVar;
    }

    public static String a(Context context) {
        return com.opos.cmn.an.h.c.a.f(context);
    }

    private static String a(Context context, com.opos.acs.st.b.c cVar) {
        String str;
        if (cVar == null) {
            return "";
        }
        boolean z = cVar.f16299j == 0;
        try {
            d.a("Utils", "dataType=" + cVar.f16291b + ",acsId=" + cVar.f16292c);
            if (z && (str = cVar.f16295f) != null) {
                cVar.f16295f = str.replace("sessionIdRpl", "1");
            }
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(b(context, cVar));
            return jSONArray.toString();
        } catch (Exception e2) {
            d.b("Utils", "acsStDbCache2JsonString:" + e2.toString());
            return "";
        }
    }

    private static String a(Context context, String str) {
        DataEntity dataEntity;
        Map<String, MetaEntity> map;
        MetaEntity metaEntity;
        String str2;
        STConfigEntity b2 = g.b(context);
        return (b2 == null || (dataEntity = b2.dataEntity) == null || (map = dataEntity.metaEntityMap) == null || str == null || (metaEntity = map.get(str)) == null || (str2 = metaEntity.split) == null) ? "\t" : str2;
    }

    private static String a(Context context, String str, Map<String, String> map) {
        String str2;
        if (context != null && map != null && !b(context, str)) {
            StrategyEntity i2 = i(context);
            MetaEntity c2 = c(context, str);
            if (c2 != null) {
                String str3 = c2.url;
                if (!a(str3) && i2 != null) {
                    int i3 = i2.prtflg;
                    StringBuilder sb = new StringBuilder();
                    if (str3.startsWith("http://")) {
                        String replace = str3.replace("http://", "");
                        sb.append("http://");
                        str2 = str3;
                        str3 = replace;
                    } else if (str3.startsWith("https://")) {
                        String replace2 = str3.replace("https://", "");
                        sb.append("https://");
                        str2 = str3;
                        str3 = replace2;
                    } else if (i3 == 1) {
                        str2 = "https://" + str3;
                        sb.append("https://");
                    } else {
                        sb.append("http://");
                        str2 = "http://" + str3;
                    }
                    d.a("Utils", "prtflg = ".concat(String.valueOf(i3)));
                    d.a("Utils", "nonDmDefaultUrlUrl:".concat(String.valueOf(str3)));
                    d.a("Utils", "dmDefaultUrlUrl:".concat(String.valueOf(str2)));
                    d.a("Utils", "urlBuffer:".concat(String.valueOf(sb)));
                    List<String> list = i2.dmKeys;
                    String str4 = map.get(t.v);
                    int i4 = -1;
                    if (str4 != null) {
                        try {
                            i4 = Integer.parseInt(str4);
                        } catch (Exception e2) {
                            com.opos.cmn.an.f.a.b("Utils", "createUrl error", e2);
                        }
                    }
                    String substring = str3.substring(0, str3.indexOf("/"));
                    String str5 = map.get("area");
                    String substring2 = str3.substring(str3.indexOf("/"));
                    if (i4 < 0 || list == null || i4 >= list.size()) {
                        sb.append(substring);
                    } else {
                        sb.append(list.get(i4));
                    }
                    if (str5 != null && !"".equals(str5.trim())) {
                        sb.append("/");
                        sb.append(str5);
                    }
                    if (!"".equals(substring2.trim())) {
                        sb.append(substring2);
                    }
                    return sb.toString();
                }
            }
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:103:0x01ea, code lost:
    
        if (r1 == null) goto L178;
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x020c, code lost:
    
        if (r1 == null) goto L178;
     */
    /* JADX WARN: Code restructure failed: missing block: B:144:0x02af, code lost:
    
        if (r0 != false) goto L318;
     */
    /* JADX WARN: Code restructure failed: missing block: B:145:0x02b2, code lost:
    
        if (r12 == false) goto L178;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x008f, code lost:
    
        if (r8 != null) goto L193;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00a5, code lost:
    
        if (a(r1) != false) goto L178;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x011b, code lost:
    
        if (r1 == null) goto L178;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x013b, code lost:
    
        if (com.opos.cmn.an.h.f.a.d(r8) == false) goto L318;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String a(android.content.Context r8, java.lang.String r9, java.util.Map<java.lang.String, java.lang.String> r10, java.lang.String r11, boolean r12) {
        /*
            Method dump skipped, instructions count: 724
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.acs.st.utils.h.a(android.content.Context, java.lang.String, java.util.Map, java.lang.String, boolean):java.lang.String");
    }

    private static String a(Context context, List<com.opos.acs.st.b.c> list) {
        String replace;
        if (list == null || list.size() <= 0) {
            return "";
        }
        try {
            JSONArray jSONArray = new JSONArray();
            for (com.opos.acs.st.b.c cVar : list) {
                if (cVar.f16299j == 0) {
                    if (a(context, cVar.f16291b, cVar.f16297h)) {
                        d.a("Utils", "dataType=" + cVar.f16291b + ",acsId=" + cVar.f16292c + ",effective");
                        replace = cVar.f16295f.replace("sessionIdRpl", "1");
                    } else {
                        d.a("Utils", "dataType=" + cVar.f16291b + ",acsId=" + cVar.f16292c + "， not effective");
                        replace = cVar.f16295f.replace("sessionIdRpl", "0");
                    }
                    cVar.f16295f = replace;
                }
                jSONArray.put(b(context, cVar));
            }
            return jSONArray.toString();
        } catch (Exception e2) {
            d.b("Utils", "acsStDbCache2JsonString:" + e2.toString());
            return "";
        }
    }

    private static String a(Context context, List<String> list, Map<String, String> map, String str) {
        StringBuilder sb = new StringBuilder();
        if (list != null && context != null) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                String str2 = list.get(i2);
                if (str2 != null && !"eventKeys".equals(str2)) {
                    sb.append(a(context, str2, map, str, false));
                    if (i2 < list.size() - 1) {
                        sb.append(str);
                    }
                }
            }
        }
        return sb.toString();
    }

    private static String a(Context context, List<String> list, Map<String, String> map, boolean z) {
        String str = "";
        if (list != null && context != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                for (int i2 = 0; i2 < list.size(); i2++) {
                    String str2 = list.get(i2);
                    if (str2 != null && !"eventKeys".equals(str2)) {
                        if ("ext".equals(str2)) {
                            jSONObject.put(str2, "");
                        } else {
                            jSONObject.put(str2, a(context, str2, map, "", z));
                        }
                    }
                }
                str = jSONObject.toString();
            } catch (JSONException e2) {
                d.b("Utils", "", e2);
            }
        }
        d.a("Utils", "getExtJsonValues = ".concat(String.valueOf(str)));
        return str;
    }

    private static String a(Context context, Map<String, String> map, boolean z) {
        String a2;
        synchronized (h.class) {
            StrategyEntity i2 = i(context);
            a2 = com.opos.cmn.an.a.d.a(a(context, i2 != null ? i2.extKeys : null, map, z));
            if (a2 == null) {
                a2 = "";
            }
        }
        return a2;
    }

    private static String a(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            String[] split = str.split("_");
            if (split.length > 0) {
                try {
                    return (Integer.parseInt(split[0]) + 1) + "_" + str2;
                } catch (Exception e2) {
                    com.opos.cmn.an.f.a.b("Utils", "getRetStr error", e2);
                }
            }
        }
        return null;
    }

    private static JSONObject a(Context context, List<String> list, Map<String, String> map) {
        JSONObject jSONObject = new JSONObject();
        if (list != null && context != null) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                String str = list.get(i2);
                if (str != null && !"eventKeys".equals(str)) {
                    try {
                        String a2 = a(context, str, map, "", true);
                        if (a2 != null) {
                            jSONObject.put(str, a2);
                        }
                    } catch (JSONException e2) {
                        com.opos.cmn.an.f.a.b("Utils", "getValueJsonObject", e2);
                    }
                }
            }
        }
        return jSONObject;
    }

    public static void a() {
        synchronized (h.class) {
            synchronized (f16328d) {
                try {
                    d.b("lshxjtu", "cancelReportTimer isCancelTimering=" + f16330f);
                    if (f16327c != null && !f16330f) {
                        f16330f = true;
                        d.b("lshxjtu", "cancelReportTimer really start!!!");
                        f16327c.cancel();
                        f16327c = null;
                    }
                } finally {
                    f16330f = false;
                }
            }
        }
    }

    public static void a(Context context, com.opos.acs.st.b.c cVar, int i2, int i3) {
        String str;
        String str2;
        synchronized (f16325a) {
            if (i2 != 0) {
                String a2 = a(context, cVar.f16291b);
                com.opos.acs.st.b.c a3 = com.opos.acs.st.a.b.a(context, cVar.f16291b, cVar.f16292c, cVar.f16293d);
                if (a3 == null) {
                    com.opos.acs.st.a.b.a(context, cVar);
                } else {
                    if (cVar.f16299j == 0) {
                        int lastIndexOf = a3.f16295f.lastIndexOf(a2);
                        if (lastIndexOf > 0) {
                            try {
                                String substring = a3.f16295f.substring(lastIndexOf + 1);
                                d.a("Utils", "count=".concat(String.valueOf(substring)));
                                int parseInt = Integer.parseInt(substring);
                                a3.f16295f = a3.f16295f.substring(0, lastIndexOf);
                                a3.f16295f += a2 + (parseInt + 1);
                            } catch (Exception e2) {
                                e = e2;
                                str = "Utils";
                                str2 = "insertOrMergeAcsStDbCache";
                                com.opos.cmn.an.f.a.d(str, str2, e);
                                com.opos.acs.st.a.b.b(context, a3);
                            }
                        }
                    } else {
                        try {
                            JSONObject jSONObject = a3.k;
                            if (jSONObject != null && jSONObject.has("count")) {
                                jSONObject.put("count", jSONObject.optInt("count") + 1);
                            }
                        } catch (Exception e3) {
                            e = e3;
                            str = "Utils";
                            str2 = "insertOrMergeAcsStDbCache";
                            com.opos.cmn.an.f.a.d(str, str2, e);
                            com.opos.acs.st.a.b.b(context, a3);
                        }
                    }
                    com.opos.acs.st.a.b.b(context, a3);
                }
            } else {
                com.opos.acs.st.a.b.a(context, cVar);
                if (i3 > 0) {
                    int intValue = com.opos.acs.st.a.b.a(context, cVar.f16291b).intValue();
                    d.a("Utils", cVar.f16291b + "已经有事件 count=" + intValue);
                    if (intValue != 0 && intValue >= i3) {
                        b(context, cVar.f16291b, cVar.f16293d);
                    }
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void a(android.content.Context r2, com.opos.acs.st.b.c r3, java.lang.String r4) {
        /*
            if (r3 == 0) goto L4a
            if (r4 == 0) goto L4a
            int r0 = r3.f16299j
            if (r0 != 0) goto L4a
            java.lang.String r0 = r3.f16296g
            boolean r1 = a(r0)
            if (r1 != 0) goto L25
            java.lang.String r1 = "(?<=\\#)(\\S+)(?=\\#)"
            java.util.regex.Pattern r1 = java.util.regex.Pattern.compile(r1)
            java.util.regex.Matcher r0 = r1.matcher(r0)
            boolean r1 = r0.find()
            if (r1 == 0) goto L25
            java.lang.String r0 = r0.group()
            goto L26
        L25:
            r0 = 0
        L26:
            java.lang.String r4 = a(r0, r4)
            if (r4 == 0) goto L4a
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "#"
            r0.<init>(r1)
            r0.append(r4)
            r0.append(r1)
            java.lang.String r4 = r0.toString()
            java.lang.String r0 = r3.f16296g
            java.lang.String r1 = "#.*?#"
            java.lang.String r4 = r0.replaceAll(r1, r4)
            r3.f16296g = r4
            com.opos.acs.st.a.b.b(r2, r3)
        L4a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.acs.st.utils.h.a(android.content.Context, com.opos.acs.st.b.c, java.lang.String):void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0122  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(android.content.Context r9, java.lang.String r10, java.lang.String r11, java.lang.String r12, com.opos.acs.st.utils.h.a r13) {
        /*
            Method dump skipped, instructions count: 294
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.acs.st.utils.h.a(android.content.Context, java.lang.String, java.lang.String, java.lang.String, com.opos.acs.st.utils.h$a):void");
    }

    public static void a(Context context, Map<String, String> map, STManager.EventListener eventListener) {
        boolean z;
        int i2;
        String str;
        String str2;
        MetaEntity c2;
        MetaEntity metaEntity;
        if (context == null || map == null) {
            return;
        }
        d.a("Utils", "report recordEvent start:".concat(String.valueOf(map)));
        String str3 = map.get(STManager.KEY_DATA_TYPE);
        if (str3 != null) {
            if (!"".equals(str3.trim())) {
                if (b(context, str3)) {
                    d.a("Utils", "report no strategy,save data!dataType=".concat(str3));
                    long currentTimeMillis = System.currentTimeMillis();
                    com.opos.acs.st.b.a aVar = new com.opos.acs.st.b.a();
                    JSONObject b2 = com.opos.acs.st.b.a.b(map);
                    aVar.f16283b = b2 == null ? null : b2.toString();
                    aVar.f16284c = currentTimeMillis;
                    aVar.f16285d = currentTimeMillis;
                    com.opos.acs.st.a.c.a(context, aVar);
                    g.b(context, str3);
                    b(true, 6, eventListener);
                    return;
                }
                MetaEntity c3 = c(context, str3);
                boolean equals = "wbs".equals(c3.version);
                map.put("count", "1");
                map.put("clickId", d());
                map.put("category", String.valueOf(c3.category));
                map.put("eventValue", String.valueOf(c3.eventValue));
                map.put("oriDatatype", equals ? "" : str3);
                String str4 = map.get("statUploadStrategy");
                boolean z2 = (equals || "3".equals(str4) || "2".equals(str4)) ? false : true;
                if (equals || "3".equals(str4)) {
                    str = "3";
                    str2 = "2";
                } else {
                    str = "3";
                    str2 = "2";
                    com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.acs.st.utils.h.1

                        /* renamed from: a */
                        private /* synthetic */ Context f16333a;

                        /* renamed from: b */
                        private /* synthetic */ boolean f16334b;

                        /* renamed from: c */
                        private /* synthetic */ Map f16335c;

                        /* renamed from: d */
                        private /* synthetic */ MetaEntity f16336d;

                        /* renamed from: e */
                        private /* synthetic */ STManager.EventListener f16337e;

                        AnonymousClass1(Context context2, boolean z22, Map map2, MetaEntity c32, STManager.EventListener eventListener2) {
                            context = context2;
                            z3 = z22;
                            map = map2;
                            c3 = c32;
                            eventListener = eventListener2;
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            h.a(context, false, z3, map, c3, eventListener);
                        }
                    });
                }
                if (equals || str.equals(str4) || str2.equals(str4)) {
                    if (equals) {
                        metaEntity = c32;
                    } else {
                        String str5 = c32.newDatatype;
                        if (TextUtils.isEmpty(str5)) {
                            com.opos.cmn.an.f.a.d("Utils", "No associate new dataType!");
                            e.a(context2);
                            e.a(ErrorContants.errorContantseMap(context2, "5", ErrorContants.NO_NEW_OLD_ASSOCIATE, "", "", 0L, 0L, "old dataType:" + str3 + ",new dataType:" + str5));
                            c2 = null;
                        } else {
                            c2 = c(context2, str5);
                            if (c2 == null) {
                                com.opos.cmn.an.f.a.d("Utils", "No associate dataType strategy!");
                                e.a(context2);
                                e.a(ErrorContants.errorContantseMap(context2, "5", ErrorContants.NO_NEW_STRATEGY_ERROR, "", "", 0L, 0L, "old dataType:" + str3 + ",new dataType:" + str5));
                                g.b(context2, str5);
                            }
                        }
                        metaEntity = c2;
                    }
                    if (metaEntity != null) {
                        a(context2, true, false, map2, metaEntity, eventListener2);
                    }
                }
                z = !z22;
                i2 = 7;
                b(z, i2, eventListener2);
            }
        }
        z = true;
        d.b("Utils", "report dataType is empty!");
        i2 = 4;
        b(z, i2, eventListener2);
    }

    public static void a(Context context, boolean z, boolean z2, Map<String, String> map, MetaEntity metaEntity, STManager.EventListener eventListener) {
        boolean z3;
        String str;
        String str2;
        String str3;
        int i2;
        if (metaEntity.uploadFlag != 0) {
            StrategyEntity i3 = i(context);
            com.opos.acs.st.b.c a2 = a(context, metaEntity.dataType, map, z);
            if (!com.opos.cmn.an.h.c.a.d(context)) {
                d.a("Utils", "report data fail:no net!");
                a(context, a2, metaEntity.aggrFlag, i3.triggerNums);
                b(z2, 5, eventListener);
                return;
            }
            if (metaEntity.immFlag != 0) {
                d.a("Utils", "report data immediately.dataType= " + metaEntity.dataType + ",new dataType= " + z);
                String str4 = a2.f16293d;
                if (TextUtils.isEmpty(str4)) {
                    i2 = 4;
                } else {
                    z3 = z;
                    a(context, str4, a(context, a2), metaEntity.dataType, new a() { // from class: com.opos.acs.st.utils.h.2

                        /* renamed from: a */
                        private /* synthetic */ boolean f16338a;

                        /* renamed from: b */
                        private /* synthetic */ STManager.EventListener f16339b;

                        /* renamed from: c */
                        private /* synthetic */ Context f16340c;

                        /* renamed from: d */
                        private /* synthetic */ com.opos.acs.st.b.c f16341d;

                        /* renamed from: e */
                        private /* synthetic */ MetaEntity f16342e;

                        /* renamed from: f */
                        private /* synthetic */ boolean f16343f;

                        /* renamed from: g */
                        private /* synthetic */ long f16344g;

                        /* renamed from: h */
                        private /* synthetic */ String f16345h;

                        AnonymousClass2(boolean z22, STManager.EventListener eventListener2, Context context2, com.opos.acs.st.b.c a22, MetaEntity metaEntity2, boolean z32, long j2, String str42) {
                            z2 = z22;
                            eventListener = eventListener2;
                            context = context2;
                            a2 = a22;
                            metaEntity = metaEntity2;
                            z3 = z32;
                            currentTimeMillis = j2;
                            str4 = str42;
                        }

                        @Override // com.opos.acs.st.utils.h.a
                        public final void a() {
                            h.b(z2, 1, eventListener);
                        }

                        @Override // com.opos.acs.st.utils.h.a
                        public final void a(String str5, String str22) {
                            if (!"400".equals(str5)) {
                                h.a(context, a2, metaEntity.aggrFlag, 0);
                                if (!z3) {
                                    h.a(context, a2, str5);
                                }
                            }
                            long currentTimeMillis = System.currentTimeMillis() - currentTimeMillis;
                            String str32 = metaEntity.dataType;
                            String str42 = z3 ? ErrorContants.NEW_REALTIME_REPORT_ERROR : ErrorContants.REALTIME_REPORT_ERROR;
                            e.a(context);
                            e.a(ErrorContants.errorContantseMap(context, "5", str42, str4, str5, currentTimeMillis, currentTimeMillis, "dataType:" + str32 + "response:" + str22));
                            h.b(z2, 2, eventListener);
                        }
                    });
                    str = "Utils";
                }
            } else {
                StringBuilder sb = new StringBuilder("report data delay!insert db.dataType=");
                sb.append(metaEntity2.dataType);
                sb.append(",is new dataType=");
                z32 = z;
                sb.append(z32);
                str = "Utils";
                d.a(str, sb.toString());
                a(context2, a22, metaEntity2.aggrFlag, i3.triggerNums);
                b(z22, 5, eventListener2);
            }
            if (!z32 && (str2 = map.get("parEvtId")) != null && !"".equals(str2.trim())) {
                try {
                    ReadWriteLock readWriteLock = f16326b;
                    readWriteLock.writeLock().lock();
                    d.a(str, "evtParentId=".concat(str2));
                    com.opos.acs.st.b.b b2 = com.opos.acs.st.a.b.b(context2, str2);
                    if (b2 == null) {
                        com.opos.acs.st.b.b bVar = new com.opos.acs.st.b.b();
                        bVar.f16287b = str2;
                        bVar.f16288c = map.get(STManager.KEY_AD_POS_ID);
                        if (metaEntity2.immFlag != 0) {
                            bVar.f16289d = 1;
                        } else if (metaEntity2.judgePosids != null) {
                            bVar.f16289d = 0;
                        }
                        d.a(str, "insertStatBatchEntity:".concat(String.valueOf(bVar)));
                        com.opos.acs.st.a.b.a(context2, bVar);
                    } else if (b2.f16289d == 0) {
                        if (metaEntity2.immFlag != 0) {
                            b2.f16289d = 1;
                        } else if (b2.f16288c != null && (str3 = map.get(STManager.KEY_AD_POS_ID)) != null && !b2.f16288c.contains(str3)) {
                            b2.f16288c += "|" + map.get(STManager.KEY_AD_POS_ID);
                        }
                        com.opos.acs.st.a.b.b(context2, b2);
                        d.a(str, "updateStatBatchEntity:".concat(String.valueOf(b2)));
                    }
                    readWriteLock.writeLock().unlock();
                } catch (Throwable th) {
                    f16326b.writeLock().unlock();
                    throw th;
                }
            }
            d.a(str, "report recordEvent end!!!!!!!dataType=" + metaEntity2.dataType);
            return;
        }
        d.a("Utils", "report no need upload!");
        i2 = 3;
        b(z22, i2, eventListener2);
    }

    static /* synthetic */ void a(Context context, Integer[] numArr, List list) {
        com.opos.acs.st.a.b.a(context, numArr);
        if (list == null || list.size() <= 0) {
            return;
        }
        try {
            ReadWriteLock readWriteLock = f16326b;
            readWriteLock.writeLock().lock();
            d.a("Utils", "delete batchIds:".concat(String.valueOf(list)));
            com.opos.acs.st.a.b.a(context, (List<String>) list);
            readWriteLock.writeLock().unlock();
        } catch (Throwable th) {
            f16326b.writeLock().unlock();
            throw th;
        }
    }

    private static boolean a(Context context, String str, String str2) {
        MetaEntity c2;
        List<String> list;
        d.a("Utils", "start ifDataEffective");
        if (str2 != null && !"".equals(str2)) {
            try {
                ReadWriteLock readWriteLock = f16326b;
                readWriteLock.readLock().lock();
                com.opos.acs.st.b.b b2 = com.opos.acs.st.a.b.b(context, str2);
                readWriteLock.readLock().unlock();
                d.a("Utils", "statBatchEntity=".concat(String.valueOf(b2)));
                if (b2 != null) {
                    if (b2.f16289d != 1 && b2.f16288c != null && !b(context, str) && (c2 = c(context, str)) != null && (list = c2.judgePosids) != null && list.size() != 0) {
                        d.a("Utils", "statBatchEntity.acsPosIds=" + b2.f16288c);
                        String[] split = b2.f16288c.split("\\|");
                        for (int i2 = 0; i2 < list.size(); i2++) {
                            String str3 = list.get(i2);
                            for (String str4 : split) {
                                if (!Pattern.compile(str3).matcher(str4).find()) {
                                    d.a("Utils", "judgePosid=" + str3 + ",acsPosId=" + str4 + " not match!");
                                }
                            }
                        }
                    }
                }
                d.a("Utils", "end ifDataEffective");
                return false;
            } catch (Throwable th) {
                f16326b.readLock().unlock();
                throw th;
            }
        }
        return true;
    }

    private static boolean a(STConfigEntity sTConfigEntity) {
        DataEntity dataEntity;
        Map<String, MetaEntity> map;
        boolean z = false;
        if (sTConfigEntity != null && (dataEntity = sTConfigEntity.dataEntity) != null && (map = dataEntity.metaEntityMap) != null && map.size() > 0) {
            try {
                Iterator<Map.Entry<String, MetaEntity>> it = sTConfigEntity.dataEntity.metaEntityMap.entrySet().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    if (it.next().getValue().immFlag == 0) {
                        z = true;
                        break;
                    }
                }
            } catch (Exception e2) {
                d.a("Utils", "", e2);
            }
        }
        d.a("Utils", "getReportTimer=".concat(String.valueOf(z)));
        return z;
    }

    public static boolean a(String str) {
        return str == null || "".equals(str.trim());
    }

    private static byte[] a(InputStream inputStream) {
        if (inputStream != null) {
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byte[] bArr = new byte[1000];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (-1 == read) {
                        return byteArrayOutputStream.toByteArray();
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                }
            } catch (Exception e2) {
                d.b("Utils", "", e2);
            }
        }
        return null;
    }

    private static JSONObject b(Context context, com.opos.acs.st.b.c cVar) throws JSONException {
        boolean z = cVar.f16299j == 0;
        JSONObject jSONObject = new JSONObject();
        if (z) {
            String str = cVar.f16296g;
            if (str != null) {
                str = str.replace("#", "");
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("evtTime", cVar.f16298i);
            jSONObject2.put(STManager.KEY_DATA_TYPE, cVar.f16291b);
            jSONObject.put(Downloads.RequestHeaders.URI_SEGMENT, jSONObject2);
            String a2 = a(context, cVar.f16291b);
            jSONObject.put("body", cVar.f16294e + a2 + cVar.f16295f + a2 + str);
        } else {
            JSONObject jSONObject3 = cVar.k;
            JSONObject jSONObject4 = cVar.l;
            if (jSONObject3 == null) {
                jSONObject3 = new JSONObject();
            }
            if (jSONObject4 == null) {
                jSONObject4 = new JSONObject();
            }
            jSONObject3.put("evtTime", cVar.f16298i);
            jSONObject3.put(STManager.KEY_DATA_TYPE, cVar.f16291b);
            jSONObject.put("header", jSONObject3);
            jSONObject.put("body", jSONObject4);
        }
        return jSONObject;
    }

    public static void b(Context context) {
        STConfigEntity b2;
        DataEntity dataEntity;
        Map<String, MetaEntity> map;
        if (context == null || (b2 = g.b(context)) == null || (dataEntity = b2.dataEntity) == null || dataEntity.strategyEntity == null || (map = dataEntity.metaEntityMap) == null) {
            return;
        }
        List<String> a2 = com.opos.acs.st.a.b.a(context);
        synchronized (f16325a) {
            for (String str : map.keySet()) {
                if (a2 != null && a2.size() > 0) {
                    for (int i2 = 0; i2 < a2.size(); i2++) {
                        b(context, str, a2.get(i2));
                    }
                }
            }
            int i3 = b2.dataEntity.strategyEntity.reportLimit;
            if (i3 <= 0) {
                i3 = 30;
            }
            d.a("Utils", "reportLimit =" + i3 + "days, delete count =" + com.opos.acs.st.a.b.a(context, "'cpd-app-expose', 'cpd-srh-expose', 'bd-expose', 'feeds-expose', 'sms-expose'", System.currentTimeMillis() - ((((i3 * 24) * 60) * 60) * 1000)));
        }
    }

    private static void b(Context context, String str, String str2) {
        if (context == null || str2 == null || "".equals(str2.trim()) || b(context, str)) {
            return;
        }
        d.a("Utils", "start:" + str + ",dmUrl:" + str2);
        STConfigEntity b2 = g.b(context);
        int i2 = b2.dataEntity.metaEntityMap.get(str).batchNums;
        if (i2 <= 0) {
            i2 = b2.dataEntity.strategyEntity.batchNums;
        }
        int i3 = i2;
        List<com.opos.acs.st.b.c> a2 = com.opos.acs.st.a.b.a(context, str, str2);
        if (i3 == 0 || a2 == null || a2.size() <= 0) {
            return;
        }
        int size = a2.size() % i3 == 0 ? a2.size() / i3 : (a2.size() / i3) + 1;
        int i4 = 0;
        while (i4 < size) {
            int i5 = i4 * i3;
            int i6 = i4 + 1;
            int i7 = i6 * i3;
            if (i7 > a2.size()) {
                i7 = a2.size();
            }
            if (i7 < i5) {
                return;
            }
            List<com.opos.acs.st.b.c> subList = a2.subList(i5, i7);
            Integer[] numArr = new Integer[subList.size()];
            ArrayList arrayList = new ArrayList();
            int i8 = 0;
            for (com.opos.acs.st.b.c cVar : subList) {
                numArr[i8] = Integer.valueOf(cVar.f16290a);
                String str3 = cVar.f16297h;
                if (str3 != null && !arrayList.contains(str3)) {
                    arrayList.add(cVar.f16297h);
                }
                i8++;
            }
            a(context, str2, a(context, subList), str, new a() { // from class: com.opos.acs.st.utils.h.3

                /* renamed from: a */
                private /* synthetic */ Context f16346a;

                /* renamed from: b */
                private /* synthetic */ Integer[] f16347b;

                /* renamed from: c */
                private /* synthetic */ List f16348c;

                /* renamed from: d */
                private /* synthetic */ long f16349d;

                /* renamed from: e */
                private /* synthetic */ List f16350e;

                /* renamed from: f */
                private /* synthetic */ String f16351f;

                /* renamed from: g */
                private /* synthetic */ String f16352g;

                AnonymousClass3(Context context2, Integer[] numArr2, List arrayList2, long j2, List subList2, String str22, String str4) {
                    context = context2;
                    numArr = numArr2;
                    arrayList = arrayList2;
                    currentTimeMillis = j2;
                    subList = subList2;
                    str2 = str22;
                    str = str4;
                }

                @Override // com.opos.acs.st.utils.h.a
                public final void a() {
                    h.a(context, numArr, arrayList);
                }

                @Override // com.opos.acs.st.utils.h.a
                public final void a(String str4, String str22) {
                    long currentTimeMillis = System.currentTimeMillis() - currentTimeMillis;
                    boolean z = subList.size() > 0 && ((com.opos.acs.st.b.c) subList.get(0)).f16299j == 1;
                    String str32 = z ? ErrorContants.NEW_PERIODIC_REPORT_ERROR : ErrorContants.PERIODIC_REPORT_ERROR;
                    e.a(context);
                    e.a(ErrorContants.errorContantseMap(context, "5", str32, str2, str4, currentTimeMillis, currentTimeMillis, "dataType:" + str + ",response:" + str22));
                    if ("400".equals(str4)) {
                        h.a(context, numArr, arrayList);
                    } else {
                        if (z) {
                            return;
                        }
                        for (int i22 = 0; i22 < subList.size(); i22++) {
                            h.a(context, (com.opos.acs.st.b.c) subList.get(i22), str4);
                        }
                    }
                }
            });
            i4 = i6;
            i3 = i3;
            a2 = a2;
        }
        d.a("Utils", "end:".concat(String.valueOf(str4)));
    }

    public static void b(boolean z, int i2, STManager.EventListener eventListener) {
        if (eventListener != null && z) {
            eventListener.onEventReturn(i2);
        }
    }

    private static boolean b() {
        try {
            ReentrantReadWriteLock reentrantReadWriteLock = f16332h;
            reentrantReadWriteLock.readLock().lock();
            d.a("Utils", "startReportTimer=" + f16331g);
            boolean z = f16331g;
            reentrantReadWriteLock.readLock().unlock();
            return z;
        } catch (Throwable th) {
            f16332h.readLock().unlock();
            throw th;
        }
    }

    private static boolean b(Context context, String str) {
        STConfigEntity b2;
        DataEntity dataEntity;
        Map<String, MetaEntity> map;
        return TextUtils.isEmpty(str) || (b2 = g.b(context)) == null || (dataEntity = b2.dataEntity) == null || dataEntity.strategyEntity == null || (map = dataEntity.metaEntityMap) == null || map.get(str) == null;
    }

    private static byte[] b(String str) {
        byte[] a2;
        byte[] bytes = "".getBytes();
        return (str == null || (a2 = com.opos.cmn.b.c.a.a(str.getBytes())) == null) ? bytes : a2;
    }

    private static MetaEntity c(Context context, String str) {
        STConfigEntity b2;
        DataEntity dataEntity;
        Map<String, MetaEntity> map;
        if (TextUtils.isEmpty(str) || (b2 = g.b(context)) == null || (dataEntity = b2.dataEntity) == null || (map = dataEntity.metaEntityMap) == null) {
            return null;
        }
        return map.get(str);
    }

    private static String c() {
        String str = "";
        try {
            str = System.getProperty("http.agent");
        } catch (Exception e2) {
            d.b("Utils", "", e2);
        }
        StringBuilder sb = new StringBuilder("getUserAgent=");
        sb.append(str != null ? str : "null");
        d.a("Utils", sb.toString());
        return str;
    }

    public static void c(Context context) {
        long j2;
        long j3;
        synchronized (h.class) {
            synchronized (f16328d) {
                try {
                    StringBuilder sb = new StringBuilder("startReportTimer receive,reportTimer=");
                    Object obj = f16327c;
                    if (obj == null) {
                        obj = "null";
                    }
                    sb.append(obj);
                    sb.append(",startReportTimer=");
                    sb.append(b());
                    sb.append(",isStartTimering=");
                    sb.append(f16329e);
                    d.b("lshxjtu", sb.toString());
                    if (context != null && f16327c == null && b() && !f16329e) {
                        f16329e = true;
                        d.b("lshxjtu", "startReportTimer really start!");
                        StrategyEntity i2 = i(context);
                        if (i2 != null) {
                            long j4 = i2.frequencyTime * 1000;
                            j3 = i2.wfTime * 1000;
                            j2 = j4;
                        } else {
                            j2 = 0;
                            j3 = 0;
                        }
                        long j5 = (!d(context) || j3 <= 0) ? j2 : j3;
                        if (j5 <= 0) {
                            j5 = 60000;
                        }
                        long j6 = j5;
                        d.a("Utils", "period=".concat(String.valueOf(j6)));
                        f fVar = new f(context, j2, j3, j6);
                        Timer timer = new Timer();
                        f16327c = timer;
                        timer.schedule(fVar, 0L, j6);
                    }
                } finally {
                    f16329e = false;
                }
            }
        }
    }

    private static String d() {
        return UUID.randomUUID().toString() + "-" + System.currentTimeMillis();
    }

    public static boolean d(Context context) {
        return "WIFI".equalsIgnoreCase(com.opos.cmn.an.h.c.a.f(context));
    }

    public static boolean e(Context context) {
        try {
        } catch (Exception e2) {
            d.c("Utils", "", e2);
        }
        return (context.getApplicationInfo().flags & 2) != 0;
    }

    public static boolean f(Context context) {
        if (context == null || !e(context) || c.b()) {
            return false;
        }
        d.b("Utils", "isDebuggable, not inited");
        return true;
    }

    public static void g(Context context) {
        STConfigEntity b2 = g.b(context);
        if (b2 == null || context == null) {
            return;
        }
        boolean a2 = a(b2);
        try {
            ReentrantReadWriteLock reentrantReadWriteLock = f16332h;
            reentrantReadWriteLock.writeLock().lock();
            f16331g = a2;
            d.a("Utils", "setReportTimer=" + f16331g);
            reentrantReadWriteLock.writeLock().unlock();
            if (a2) {
                d.a("Utils", "startReportTimer=true,start report timer!!!");
                c(context);
            } else {
                d.a("Utils", "startReportTimer=false,cancel report timer!!!");
                a();
            }
        } catch (Throwable th) {
            f16332h.writeLock().unlock();
            throw th;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:75:0x0199, code lost:
    
        r8 = r22;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void h(android.content.Context r25) {
        /*
            Method dump skipped, instructions count: 451
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.acs.st.utils.h.h(android.content.Context):void");
    }

    private static StrategyEntity i(Context context) {
        DataEntity dataEntity;
        STConfigEntity b2 = g.b(context);
        if (b2 == null || (dataEntity = b2.dataEntity) == null) {
            return null;
        }
        return dataEntity.strategyEntity;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0034, code lost:
    
        if (r10.isClosed() == false) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0057, code lost:
    
        if (r10.isClosed() == false) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0042, code lost:
    
        if (r10.isClosed() == false) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0036, code lost:
    
        r10.close();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String j(android.content.Context r10) {
        /*
            r0 = 0
            java.lang.String r1 = "Y29udGVudDovL2NvbS5vcHBvLndlYXRoZXIucHJvdmlkZXIuZGF0YS9hdHRlbnRfY2l0eQ=="
            java.lang.String r1 = com.opos.cmn.an.a.b.a(r1)     // Catch: java.lang.Throwable -> L45 java.lang.Exception -> L47
            android.content.ContentResolver r2 = r10.getContentResolver()     // Catch: java.lang.Throwable -> L45 java.lang.Exception -> L47
            android.net.Uri r3 = android.net.Uri.parse(r1)     // Catch: java.lang.Throwable -> L45 java.lang.Exception -> L47
            r10 = 1
            java.lang.String[] r4 = new java.lang.String[r10]     // Catch: java.lang.Throwable -> L45 java.lang.Exception -> L47
            java.lang.String r1 = "city_name"
            r8 = 0
            r4[r8] = r1     // Catch: java.lang.Throwable -> L45 java.lang.Exception -> L47
            java.lang.String r5 = "location = ? "
            java.lang.String[] r6 = new java.lang.String[r10]     // Catch: java.lang.Throwable -> L45 java.lang.Exception -> L47
            java.lang.String r10 = "1"
            r6[r8] = r10     // Catch: java.lang.Throwable -> L45 java.lang.Exception -> L47
            r7 = 0
            android.database.Cursor r10 = r2.query(r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L45 java.lang.Exception -> L47
            if (r10 == 0) goto L3c
            boolean r1 = r10.moveToFirst()     // Catch: java.lang.Exception -> L3a java.lang.Throwable -> L5b
            if (r1 == 0) goto L3c
            java.lang.String r0 = r10.getString(r8)     // Catch: java.lang.Exception -> L3a java.lang.Throwable -> L5b
            boolean r1 = r10.isClosed()
            if (r1 != 0) goto L5a
        L36:
            r10.close()
            goto L5a
        L3a:
            r1 = move-exception
            goto L4a
        L3c:
            if (r10 == 0) goto L5a
            boolean r1 = r10.isClosed()
            if (r1 != 0) goto L5a
            goto L36
        L45:
            r10 = move-exception
            goto L5f
        L47:
            r10 = move-exception
            r1 = r10
            r10 = r0
        L4a:
            java.lang.String r2 = "Utils"
            java.lang.String r3 = "getLocationFromWeatherDB"
            com.opos.cmn.an.f.a.b(r2, r3, r1)     // Catch: java.lang.Throwable -> L5b
            if (r10 == 0) goto L5a
            boolean r1 = r10.isClosed()
            if (r1 != 0) goto L5a
            goto L36
        L5a:
            return r0
        L5b:
            r0 = move-exception
            r9 = r0
            r0 = r10
            r10 = r9
        L5f:
            if (r0 == 0) goto L6a
            boolean r1 = r0.isClosed()
            if (r1 != 0) goto L6a
            r0.close()
        L6a:
            goto L6c
        L6b:
            throw r10
        L6c:
            goto L6b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.acs.st.utils.h.j(android.content.Context):java.lang.String");
    }

    private static HashMap<String, String> k(Context context) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("Content-type", am.f5520d);
        hashMap.put(HttpHeaders.ACCEPT_CHARSET, "UTF-8");
        hashMap.put("Connection", HTTP.CONN_KEEP_ALIVE);
        hashMap.put("Content-Encoding", "gzip");
        hashMap.put("Route-Data", com.opos.cmn.biz.a.e.a(context));
        return hashMap;
    }

    private static String l(Context context) {
        return context != null ? context.getPackageName() : "";
    }
}
