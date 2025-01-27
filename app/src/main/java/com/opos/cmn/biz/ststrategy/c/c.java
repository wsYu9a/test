package com.opos.cmn.biz.ststrategy.c;

import android.content.Context;
import android.text.TextUtils;
import com.martian.mibook.application.MiConfigSingleton;
import com.opos.acs.st.STManager;
import java.util.HashSet;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class c {
    private static HashSet<String> a(JSONArray jSONArray) {
        HashSet<String> hashSet = new HashSet<>();
        if (jSONArray.length() > 0) {
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                try {
                    JSONObject jSONObject = jSONArray.getJSONObject(i2);
                    if (jSONObject != null && jSONObject.has(STManager.KEY_DATA_TYPE) && !jSONObject.isNull(STManager.KEY_DATA_TYPE)) {
                        String string = jSONObject.getString(STManager.KEY_DATA_TYPE);
                        if (!TextUtils.isEmpty(string)) {
                            hashSet.add(string);
                        }
                    }
                } catch (JSONException e2) {
                    com.opos.cmn.an.f.a.c("MergeSTConfigUtil", "", e2);
                }
            }
        }
        return hashSet;
    }

    public static JSONArray a(Context context, JSONObject jSONObject) {
        if (context != null && jSONObject != null) {
            com.opos.cmn.an.f.a.b("MergeSTConfigUtil", "getMetaListArray=" + jSONObject.toString());
            try {
                if (jSONObject.has(MiConfigSingleton.t0) && !jSONObject.isNull(MiConfigSingleton.t0)) {
                    JSONObject jSONObject2 = jSONObject.getJSONObject(MiConfigSingleton.t0);
                    if (jSONObject2.has("metaList") && !jSONObject2.isNull("metaList")) {
                        return jSONObject2.getJSONArray("metaList");
                    }
                }
            } catch (JSONException e2) {
                com.opos.cmn.an.f.a.c("MergeSTConfigUtil", "", e2);
            }
        }
        return null;
    }

    public static boolean a(JSONArray jSONArray, JSONArray jSONArray2, HashSet hashSet) {
        boolean z = false;
        if (jSONArray != null && jSONArray.length() > 0 && jSONArray2 != null && jSONArray2.length() > 0) {
            int length = jSONArray2.length();
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                try {
                    JSONObject jSONObject = jSONArray.getJSONObject(i2);
                    if (jSONObject != null && jSONObject.has(STManager.KEY_DATA_TYPE) && !jSONObject.isNull(STManager.KEY_DATA_TYPE)) {
                        String string = jSONObject.getString(STManager.KEY_DATA_TYPE);
                        if (!TextUtils.isEmpty(string) && hashSet != null && !hashSet.contains(string)) {
                            jSONArray2.put(jSONObject);
                        }
                    }
                } catch (Exception e2) {
                    com.opos.cmn.an.f.a.c("MergeSTConfigUtil", "", e2);
                }
            }
            if (jSONArray2.length() >= length) {
                com.opos.cmn.an.f.a.b("MergeSTConfigUtil", "onlineJsonArray length:" + jSONArray2.length() + ",originLength:" + length);
                z = true;
            }
        }
        com.opos.cmn.an.f.a.b("MergeSTConfigUtil", "mergeMetaFromLocalJson mergeResult:" + z);
        return z;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x004a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.HashSet<java.lang.String> b(android.content.Context r3, org.json.JSONObject r4) {
        /*
            java.lang.String r0 = "metaList"
            java.lang.String r1 = "data"
            java.lang.String r2 = "MergeSTConfigUtil"
            if (r3 == 0) goto L3b
            if (r4 == 0) goto L3b
            boolean r3 = r4.has(r1)     // Catch: org.json.JSONException -> L35
            if (r3 == 0) goto L3b
            boolean r3 = r4.isNull(r1)     // Catch: org.json.JSONException -> L35
            if (r3 != 0) goto L3b
            org.json.JSONObject r3 = r4.getJSONObject(r1)     // Catch: org.json.JSONException -> L35
            boolean r4 = r3.has(r0)     // Catch: org.json.JSONException -> L35
            if (r4 == 0) goto L3b
            boolean r4 = r3.isNull(r0)     // Catch: org.json.JSONException -> L35
            if (r4 != 0) goto L3b
            org.json.JSONArray r3 = r3.getJSONArray(r0)     // Catch: org.json.JSONException -> L35
            int r4 = r3.length()     // Catch: org.json.JSONException -> L35
            if (r4 <= 0) goto L3b
            java.util.HashSet r3 = a(r3)     // Catch: org.json.JSONException -> L35
            goto L3c
        L35:
            r3 = move-exception
            java.lang.String r4 = ""
            com.opos.cmn.an.f.a.c(r2, r4, r3)
        L3b:
            r3 = 0
        L3c:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r0 = "getOnlineDataTypeSet="
            r4.append(r0)
            if (r3 == 0) goto L4a
            r0 = r3
            goto L4c
        L4a:
            java.lang.String r0 = "false"
        L4c:
            r4.append(r0)
            java.lang.String r4 = r4.toString()
            com.opos.cmn.an.f.a.b(r2, r4)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.cmn.biz.ststrategy.c.c.b(android.content.Context, org.json.JSONObject):java.util.HashSet");
    }
}
