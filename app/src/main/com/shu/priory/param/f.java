package com.shu.priory.param;

import com.shu.priory.bean.AdDeal;
import com.shu.priory.bean.AdDebug;
import com.shu.priory.config.AdKeys;
import com.shu.priory.config.SDKConstants;
import com.shu.priory.utils.h;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class f {

    /* renamed from: a */
    public static int[] f17186a = {1, 2};

    public static String a(AdParam adParam) {
        try {
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("adunit_id", adParam.getParameter("adunit_id"));
            JSONArray jSONArray2 = new JSONArray();
            for (int i10 : f17186a) {
                jSONArray2.put(i10);
            }
            jSONObject.put("dp_support_status", jSONArray2);
            jSONObject.put("voice_ad_support_status", 1);
            if (adParam.getBooleanParam(AdKeys.SPLASH_INTERACTION_DISABLE)) {
                jSONObject.put("interact_status", 0);
            }
            if (adParam.getBooleanParam("update_default")) {
                jSONObject.put("update_default", 1);
            }
            int intParam = adParam.getIntParam("x_status");
            if (intParam == 0) {
                intParam = 4;
            }
            jSONObject.put("x_status", intParam);
            jSONObject.put("secure", 3);
            if (adParam.getParameter("debug") != null) {
                AdDebug adDebug = (AdDebug) adParam.getParameter("debug");
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("action_type", adDebug.getActionType());
                jSONObject2.put("landing_type", adDebug.getLandingType());
                jSONObject.put("debug", jSONObject2);
            }
            if (adParam.getParameter(AdKeys.BID_FLOOR) != null) {
                jSONObject.put("bidfloor", adParam.getDoubleParam(AdKeys.BID_FLOOR));
            }
            Object parameter = adParam.getParameter(AdKeys.PMP);
            if (parameter != null) {
                JSONArray jSONArray3 = new JSONArray();
                for (AdDeal adDeal : (List) parameter) {
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("id", adDeal.getId());
                    jSONObject3.put("bidfloor", adDeal.getBidFloor());
                    jSONArray3.put(jSONObject3);
                }
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("deals", jSONArray3);
                jSONObject.put(AdKeys.PMP, jSONObject4);
            }
            jSONArray.put(jSONObject);
            return jSONArray.toString();
        } catch (Exception e10) {
            h.d(SDKConstants.TAG, "getImpsInfo:" + e10.getMessage());
            return "";
        }
    }
}
