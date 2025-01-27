package com.alimm.tanx.core.ut.impl;

import com.alimm.tanx.core.ad.ITanxAd;
import com.alimm.tanx.core.ut.AdUtConstants;
import java.util.Map;

/* loaded from: classes.dex */
public class TanxFeedUt extends TanxBaseUt {
    public static void utClose(ITanxAd iTanxAd, int i10) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        if (iTanxAd != null) {
            String pid = iTanxAd.getAdSlot() != null ? iTanxAd.getAdSlot().getPid() : "";
            if (iTanxAd.getBidInfo() != null) {
                String requestId = iTanxAd.getRequestId();
                str = iTanxAd.getBidInfo().getCreativeId();
                str2 = iTanxAd.getBidInfo().getTemplateId();
                str5 = iTanxAd.getBidInfo().getSessionId();
                str3 = pid;
                str4 = requestId;
            } else {
                str = "";
                str2 = str;
                str4 = str2;
                str5 = str4;
                str3 = pid;
            }
        } else {
            str = "";
            str2 = str;
            str3 = str2;
            str4 = str3;
            str5 = str4;
        }
        Map<String, Object> buildArgs = TanxBaseUt.buildArgs(str3, str4, str, str2);
        buildArgs.put("option", i10 + "");
        AdUtConstants adUtConstants = AdUtConstants.FLOW_VIEW_CANCEL;
        String str6 = adUtConstants.arg1;
        TanxBaseUt.send(str6, adUtConstants.eventId, str3, str4, str6, buildArgs, str5);
    }

    public static void utViewDraw(ITanxAd iTanxAd, int i10) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        if (iTanxAd != null) {
            String pid = iTanxAd.getAdSlot() != null ? iTanxAd.getAdSlot().getPid() : "";
            String requestId = iTanxAd.getRequestId();
            if (iTanxAd.getBidInfo() != null) {
                str = iTanxAd.getBidInfo().getCreativeId();
                str2 = iTanxAd.getBidInfo().getTemplateId();
                String sessionId = iTanxAd.getBidInfo().getSessionId();
                if (iTanxAd.getBidInfo().getTemplateConf() != null) {
                    str3 = pid;
                    str4 = requestId;
                    str6 = sessionId;
                    str5 = iTanxAd.getBidInfo().getTemplateConf().getPidStyleId() != null ? iTanxAd.getBidInfo().getTemplateConf().getPidStyleId() : "";
                } else {
                    str5 = "";
                    str3 = pid;
                    str4 = requestId;
                    str6 = sessionId;
                }
            } else {
                str = "";
                str2 = str;
                str5 = str2;
                str6 = str5;
                str3 = pid;
                str4 = requestId;
            }
        } else {
            str = "";
            str2 = str;
            str3 = str2;
            str4 = str3;
            str5 = str4;
            str6 = str5;
        }
        Map<String, Object> buildArgs = TanxBaseUt.buildArgs(str3, str4, str, str2);
        buildArgs.put("is_suc", i10 + "");
        int i11 = i10 == 1 ? 0 : 1;
        AdUtConstants adUtConstants = AdUtConstants.FLOW_VIEW_CREATE;
        String str7 = adUtConstants.arg1;
        TanxBaseUt.send(str7, adUtConstants.eventId, i11, str3, str4, str7, "", str5, buildArgs, str6);
    }
}
