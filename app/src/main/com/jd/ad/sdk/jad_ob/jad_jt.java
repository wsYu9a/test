package com.jd.ad.sdk.jad_ob;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public class jad_jt {
    public static Map<String, com.jd.ad.sdk.jad_yl.jad_an> jad_an;
    public static Map<String, com.jd.ad.sdk.jad_yl.jad_an> jad_bo;
    public static final Map<String, com.jd.ad.sdk.jad_yl.jad_an> jad_cp = new HashMap();

    public static Map<String, com.jd.ad.sdk.jad_yl.jad_an> jad_an() {
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        com.jd.ad.sdk.jad_pc.jad_cp jad_cp2 = com.jd.ad.sdk.jad_re.jad_an.jad_cp();
        List<com.jd.ad.sdk.jad_pc.jad_fs> list = jad_cp2 != null ? jad_cp2.jad_cp : null;
        if (list != null && list.size() != 0) {
            for (com.jd.ad.sdk.jad_pc.jad_fs jad_fsVar : list) {
                hashMap2.put(Integer.valueOf(jad_fsVar.jad_an), jad_fsVar);
            }
            List<com.jd.ad.sdk.jad_pc.jad_er> list2 = jad_cp2.jad_jt;
            if (list2 != null && list2.size() != 0) {
                for (com.jd.ad.sdk.jad_pc.jad_er jad_erVar : list2) {
                    HashMap hashMap3 = new HashMap();
                    if (jad_erVar != null) {
                        com.jd.ad.sdk.jad_yl.jad_an jad_anVar = new com.jd.ad.sdk.jad_yl.jad_an();
                        com.jd.ad.sdk.jad_pc.jad_fs jad_fsVar2 = (com.jd.ad.sdk.jad_pc.jad_fs) hashMap2.get(Integer.valueOf(jad_erVar.jad_cp));
                        jad_anVar.jad_an = jad_fsVar2 != null ? jad_fsVar2.jad_bo : "";
                        String str = jad_erVar.jad_an;
                        jad_anVar.jad_bo = str;
                        jad_anVar.jad_cp = jad_erVar.jad_er;
                        jad_anVar.jad_dq = jad_erVar.jad_jt;
                        jad_anVar.jad_er = jad_erVar.jad_hu;
                        hashMap3.put(str, jad_anVar);
                    }
                    hashMap.putAll(hashMap3);
                }
                jad_bo = hashMap;
            }
        }
        return hashMap;
    }

    public static com.jd.ad.sdk.jad_yl.jad_an jad_an(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Map<String, com.jd.ad.sdk.jad_yl.jad_an> map = jad_bo;
        if (map == null || map.size() == 0) {
            jad_bo = jad_an();
        }
        Map<String, com.jd.ad.sdk.jad_yl.jad_an> map2 = jad_bo;
        jad_an = map2;
        if (map2 == null || map2.size() <= 0) {
            jad_an = jad_cp;
        }
        Map<String, com.jd.ad.sdk.jad_yl.jad_an> map3 = jad_an;
        if (map3 == null || map3.size() <= 0) {
            return null;
        }
        return map3.get(str);
    }
}
