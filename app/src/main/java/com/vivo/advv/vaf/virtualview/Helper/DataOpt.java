package com.vivo.advv.vaf.virtualview.Helper;

import com.martian.mibook.application.MiConfigSingleton;
import com.vivo.advv.vaf.virtualview.loader.StringLoader;
import com.vivo.advv.virtualview.common.Common;
import com.vivo.advv.virtualview.common.DataItem;
import com.vivo.ic.dm.Downloads;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class DataOpt {
    private static StringLoader sStringLoader;

    private static void doFilter(JSONObject jSONObject) {
        if (jSONObject != null) {
            doFilterSub(jSONObject.optJSONArray("vData"), false);
            doFilterSub(jSONObject.optJSONArray("vStyle"), true);
        }
    }

    private static void doFilterSub(JSONArray jSONArray, boolean z) {
        if (jSONArray != null) {
            int length = jSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i2);
                if (optJSONObject != null) {
                    String optString = optJSONObject.optString("tag");
                    if (optString != null) {
                        int stringId = sStringLoader.getStringId(optString, false);
                        optJSONObject.remove("tag");
                        try {
                            optJSONObject.put("tag", stringId);
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                        }
                    }
                    String optString2 = optJSONObject.optString("key");
                    if (optString2 != null) {
                        int stringId2 = sStringLoader.getStringId(optString2, false);
                        optJSONObject.remove("key");
                        try {
                            optJSONObject.put("key", stringId2);
                        } catch (JSONException e3) {
                            e3.printStackTrace();
                        }
                    }
                    Object opt = optJSONObject.opt(Downloads.RequestHeaders.COLUMN_VALUE);
                    if (opt != null) {
                        if ((opt instanceof JSONArray) || (opt instanceof JSONObject)) {
                            filter(opt);
                        } else if (opt instanceof String) {
                            DataItem dataItem = new DataItem((String) opt);
                            if (Common.parseColor(dataItem)) {
                                optJSONObject.remove(Downloads.RequestHeaders.COLUMN_VALUE);
                                try {
                                    optJSONObject.put(Downloads.RequestHeaders.COLUMN_VALUE, dataItem.mIntValue);
                                } catch (JSONException e4) {
                                    e4.printStackTrace();
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public static void filter(Object obj) {
        JSONArray optJSONArray = obj instanceof JSONObject ? ((JSONObject) obj).optJSONArray(MiConfigSingleton.t0) : obj instanceof JSONArray ? (JSONArray) obj : null;
        if (optJSONArray != null) {
            int length = optJSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                doFilter(optJSONArray.optJSONObject(i2));
            }
        }
    }

    public static void setStringLoader(StringLoader stringLoader) {
        sStringLoader = stringLoader;
    }
}
