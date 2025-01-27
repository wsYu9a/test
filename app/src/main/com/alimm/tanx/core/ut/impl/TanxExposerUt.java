package com.alimm.tanx.core.ut.impl;

import com.alimm.tanx.core.ad.event.track.expose.ExposeManager;
import com.alimm.tanx.core.ut.AdUtConstants;
import com.tanx.exposer.achieve.AdMonitorType;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
import sg.a;
import sg.c;

/* loaded from: classes.dex */
public class TanxExposerUt extends TanxBaseUt {
    public static void sendMonitorFail(AdMonitorType adMonitorType, String str, int i10, String str2, JSONObject jSONObject) {
        String str3;
        String str4;
        String str5;
        String str6;
        if (jSONObject != null) {
            String optString = jSONObject.optString(ExposeManager.UtArgsNames.pid);
            str4 = jSONObject.optString(ExposeManager.UtArgsNames.reqId);
            str6 = jSONObject.optString("session_id");
            str5 = jSONObject.optString(ExposeManager.UtArgsNames.interactType);
            str3 = optString;
        } else {
            str3 = null;
            str4 = null;
            str5 = null;
            str6 = null;
        }
        Map f10 = c.f(jSONObject);
        if (f10 == null) {
            f10 = new HashMap();
        }
        f10.put("params", str);
        f10.put("code", String.valueOf(i10));
        f10.put("msg", str2);
        if (adMonitorType == AdMonitorType.CLICK) {
            AdUtConstants adUtConstants = AdUtConstants.CLICK_REQUEST;
            String str7 = adUtConstants.arg1;
            TanxBaseUt.send(str7, adUtConstants.eventId, str3, str4, i10, str7, str5, "", new HashMap(f10), str6);
        } else if (adMonitorType == AdMonitorType.EXPOSE) {
            AdUtConstants adUtConstants2 = AdUtConstants.IMP_REQUEST;
            String str8 = adUtConstants2.arg1;
            TanxBaseUt.send(str8, adUtConstants2.eventId, str3, str4, i10, str8, str5, "", new HashMap(f10), str6);
        }
    }

    public static void sendMonitorSuc(AdMonitorType adMonitorType, String str, JSONObject jSONObject) {
        String str2;
        String str3;
        String str4;
        String str5;
        if (jSONObject != null) {
            String optString = jSONObject.optString(ExposeManager.UtArgsNames.pid);
            str3 = jSONObject.optString(ExposeManager.UtArgsNames.reqId);
            str5 = jSONObject.optString("session_id");
            str4 = jSONObject.optString(ExposeManager.UtArgsNames.interactType);
            str2 = optString;
        } else {
            str2 = null;
            str3 = null;
            str4 = null;
            str5 = null;
        }
        Map f10 = c.f(jSONObject);
        if (f10 == null) {
            f10 = new HashMap();
        }
        if (adMonitorType == AdMonitorType.CLICK) {
            AdUtConstants adUtConstants = AdUtConstants.CLICK_REQUEST;
            String str6 = adUtConstants.arg1;
            TanxBaseUt.send(str6, adUtConstants.eventId, str2, str3, 0, str6, str4, "", new HashMap(f10), str5);
        } else if (adMonitorType == AdMonitorType.EXPOSE) {
            AdUtConstants adUtConstants2 = AdUtConstants.IMP_REQUEST;
            String str7 = adUtConstants2.arg1;
            TanxBaseUt.send(str7, adUtConstants2.eventId, str2, str3, 0, str7, str4, "", new HashMap(f10), str5);
        } else if (adMonitorType == AdMonitorType.INTERACT_DEDUPLICATION) {
            a.d("ut imp_video_3s_request", new String[0]);
            AdUtConstants adUtConstants3 = AdUtConstants.IMP_VIDEO_3S_REQUEST;
            String str8 = adUtConstants3.arg1;
            TanxBaseUt.send(str8, adUtConstants3.eventId, str2, str3, 0, str8, str4, "", new HashMap(f10), str5);
        }
    }
}
