package com.opos.acs.st.b;

import android.content.Context;
import android.text.TextUtils;
import com.kwad.components.offline.api.tk.model.report.TKDownloadReason;
import com.opos.acs.st.utils.ErrorContants;
import com.opos.acs.st.utils.d;
import com.opos.acs.st.utils.e;
import com.opos.acs.st.utils.h;
import com.opos.cmn.biz.requeststatistic.StatisticEvent;
import com.opos.cmn.nt.crypt.EncryptUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public final class a {

    /* renamed from: a */
    public int f16282a;

    /* renamed from: b */
    public String f16283b;

    /* renamed from: c */
    public long f16284c;

    /* renamed from: d */
    public long f16285d;

    public static StatisticEvent a(Map map) {
        if (map == null) {
            return null;
        }
        long j2 = -1;
        try {
            try {
                if (map.get("ret") != null && !"".equals((String) map.get("ret"))) {
                    j2 = Long.valueOf((String) map.get("ret")).longValue();
                }
            } catch (Exception e2) {
                d.b("ErrorTag", "", e2);
            }
            return new StatisticEvent.Builder((String) map.get("evtId"), (String) map.get("url"), j2, map.get("rt") == null ? 0L : ((Long) map.get("rt")).longValue(), map.get("mt") == null ? 0L : ((Long) map.get("mt")).longValue(), (String) map.get("chn")).setCurrentTime(map.get("ct") == null ? System.currentTimeMillis() : ((Long) map.get("ct")).longValue()).setExt((String) map.get("ext")).setNet((String) map.get(TKDownloadReason.KSAD_TK_NET)).setSdkVersion("330").build();
        } catch (Exception unused) {
            return null;
        }
    }

    public static String a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        String executeEncryptStringV3 = EncryptUtils.executeEncryptStringV3(str, 0);
        com.opos.cmn.an.f.a.b("LocalEncryptUtils", "encrypt value " + str + " to " + executeEncryptStringV3);
        if (!TextUtils.isEmpty(executeEncryptStringV3)) {
            return "@en_v1_".concat(String.valueOf(executeEncryptStringV3));
        }
        Map errorContantseMap = ErrorContants.errorContantseMap(context, "5", ErrorContants.LOCAL_EN_ERROR, "", ErrorContants.NET_ERROR, 0L, 0L, str);
        e.a(context);
        e.a(errorContantseMap);
        return str;
    }

    public static Map<String, String> a(String str) {
        if (!h.a(str)) {
            try {
                return a(new JSONObject(str));
            } catch (JSONException e2) {
                d.b("CommonUtils", "", e2);
            }
        }
        return null;
    }

    public static Map<String, String> a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        Iterator<String> keys = jSONObject.keys();
        HashMap hashMap = new HashMap();
        while (keys.hasNext()) {
            String next = keys.next();
            if (jSONObject.has(next) && !jSONObject.isNull(next)) {
                try {
                    hashMap.put(next, jSONObject.getString(next));
                } catch (JSONException e2) {
                    d.b("CommonUtils", "", e2);
                }
            }
        }
        return hashMap;
    }

    public static String b(Context context, String str) {
        if (TextUtils.isEmpty(str) || !str.startsWith("@en_v1_")) {
            return str;
        }
        try {
            String substring = str.substring(7);
            String executeDecryptStringV3 = EncryptUtils.executeDecryptStringV3(substring, 0);
            if (TextUtils.isEmpty(executeDecryptStringV3)) {
                Map errorContantseMap = ErrorContants.errorContantseMap(context, "5", ErrorContants.LOCAL_DE_ERROR, "", ErrorContants.NET_ERROR, 0L, 0L, substring);
                e.a(context);
                e.a(errorContantseMap);
            } else {
                substring = executeDecryptStringV3;
            }
            com.opos.cmn.an.f.a.b("LocalEncryptUtils", "decrypt value " + str + " to " + substring);
            return substring;
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.d("LocalEncryptUtils", "decryptValue", e2);
            return str;
        }
    }

    public static JSONObject b(Map<String, String> map) {
        if (map != null) {
            try {
                return new JSONObject(map);
            } catch (Exception e2) {
                d.b("CommonUtils", "", e2);
            }
        }
        return null;
    }
}
