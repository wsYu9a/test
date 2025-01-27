package com.umeng.analytics.pro;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes4.dex */
public class bd {
    public static final String A = "rtd";
    public static final String B = "lepd";
    public static final String C = "ccfg";
    private static Map<String, String> D = null;
    private static String E = null;

    /* renamed from: a */
    public static final String f23521a = "env";

    /* renamed from: b */
    public static final String f23522b = "exp";

    /* renamed from: c */
    public static final String f23523c = "imp";

    /* renamed from: d */
    public static final String f23524d = "ua";

    /* renamed from: e */
    public static final String f23525e = "zc";

    /* renamed from: f */
    public static final String f23526f = "id";

    /* renamed from: g */
    public static final String f23527g = "zf";

    /* renamed from: h */
    public static final String f23528h = "exid";

    /* renamed from: i */
    public static final String f23529i = "ucc";

    /* renamed from: j */
    public static final String f23530j = "ugc";

    /* renamed from: k */
    public static final String f23531k = "usi";

    /* renamed from: l */
    public static final String f23532l = "uso";

    /* renamed from: m */
    public static final String f23533m = "user";

    /* renamed from: n */
    public static final String f23534n = "uspi";

    /* renamed from: o */
    public static final String f23535o = "dtfn";

    /* renamed from: p */
    public static final String f23536p = "pr";

    /* renamed from: q */
    public static final String f23537q = "upg";

    /* renamed from: r */
    public static final String f23538r = "pri";

    /* renamed from: s */
    public static final String f23539s = "probe";

    /* renamed from: t */
    public static final String f23540t = "bl";

    /* renamed from: u */
    public static final String f23541u = "wl";

    /* renamed from: v */
    public static final String f23542v = "subp";

    /* renamed from: w */
    public static final String f23543w = "subua";

    /* renamed from: x */
    public static final String f23544x = "sta";

    /* renamed from: y */
    public static final String f23545y = "emi";

    /* renamed from: z */
    public static final String f23546z = "sli";

    public static class a {

        /* renamed from: a */
        private static final bd f23547a = new bd();

        private a() {
        }
    }

    static {
        HashMap hashMap = new HashMap();
        D = hashMap;
        E = "";
        hashMap.put(f23521a, "envelope");
        D.put(f23522b, ".umeng");
        D.put(f23523c, ".imprint");
        D.put(f23524d, "ua.db");
        D.put(f23525e, "umeng_zero_cache.db");
        D.put("id", "umeng_it.cache");
        D.put(f23527g, "umeng_zcfg_flag");
        D.put(f23528h, "exid.dat");
        D.put(f23529i, "umeng_common_config");
        D.put(f23530j, "umeng_general_config");
        D.put(f23531k, "um_session_id");
        D.put(f23532l, "umeng_sp_oaid");
        D.put(f23533m, "mobclick_agent_user_");
        D.put(f23534n, "umeng_subprocess_info");
        D.put(f23535o, "delayed_transmission_flag_new");
        D.put("pr", "umeng_policy_result_flag");
        D.put(f23537q, "um_policy_grant");
        D.put(f23538r, "um_pri");
        D.put(f23539s, "UM_PROBE_DATA");
        D.put(f23540t, "ekv_bl");
        D.put(f23541u, "ekv_wl");
        D.put(f23542v, g.f23919a);
        D.put(f23543w, "ua_");
        D.put(f23544x, "stateless");
        D.put(f23545y, ".emitter");
        D.put(f23546z, "um_slmode_sp");
        D.put(A, "um_rtd_conf");
        D.put(B, "");
        D.put(C, ".dmpvedpogjhejs.cfg");
    }

    public /* synthetic */ bd(AnonymousClass1 anonymousClass1) {
        this();
    }

    public void a(String str) {
        if (!TextUtils.isEmpty(str) && TextUtils.isEmpty(E)) {
            if (str.length() > 3) {
                E = str.substring(0, 3) + hf.e.f26694a;
                return;
            }
            E = str + hf.e.f26694a;
        }
    }

    public String b(String str) {
        if (!D.containsKey(str)) {
            return "";
        }
        String str2 = D.get(str);
        if (!f23522b.equalsIgnoreCase(str) && !f23523c.equalsIgnoreCase(str) && !f23545y.equalsIgnoreCase(str)) {
            return E + str2;
        }
        return p1.b.f29697h + E + str2.substring(1);
    }

    private bd() {
    }

    public void a() {
        E = "";
    }

    public static bd b() {
        return a.f23547a;
    }
}
