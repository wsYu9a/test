package com.alimm.tanx.core.ut.impl;

import android.text.TextUtils;
import com.alimm.tanx.core.ad.ITanxAd;
import com.alimm.tanx.core.ad.bean.AdInfo;
import com.alimm.tanx.core.ad.event.track.expose.ExposeManager;
import com.alimm.tanx.core.ad.listener.bean.IBidInfo;
import com.alimm.tanx.core.constant.TanxAdType;
import com.alimm.tanx.core.orange.OrangeManager;
import com.alimm.tanx.core.request.TanxAdSlot;
import com.alimm.tanx.core.ut.AdUtConstants;
import com.alimm.tanx.core.utils.LogUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class TanxCommonUt extends TanxBaseUt {
    public static final String IS_SUC = "is_suc";

    public static void cacheCheck(ITanxAd iTanxAd, String str, int i10, Exception exc) {
        HashMap hashMap = new HashMap();
        hashMap.put("video_url", str);
        if (exc != null) {
            hashMap.put("error", LogUtils.getStackTraceMessage(exc));
        }
        sendUt(iTanxAd, AdUtConstants.CACHE_CHECK, hashMap, i10);
    }

    public static void fileSizeCheck(ITanxAd iTanxAd, long j10, int i10, long j11) {
        HashMap hashMap = new HashMap();
        hashMap.put("file_size", j10 + "");
        hashMap.put("file_size_m", ((((double) j10) / 1024.0d) / 1024.0d) + "");
        hashMap.put("time", j11 + "");
        sendUt(iTanxAd, AdUtConstants.FILE_SIZE_CHECK, hashMap, i10);
    }

    public static void sendAdRqFail(String str, String str2, String str3, long j10, int i10, String str4, String str5) {
        Map<String, Object> buildArgs = TanxBaseUt.buildArgs(str2, str3, null, null);
        buildArgs.put("scenes", str);
        buildArgs.put("request_time", String.valueOf(j10));
        buildArgs.put("params", str5);
        buildArgs.put("msg", str4);
        AdUtConstants adUtConstants = AdUtConstants.AD_REQUEST;
        String str6 = adUtConstants.arg1;
        TanxBaseUt.send(str6, adUtConstants.eventId, str2, str3, i10, str6, buildArgs, "");
    }

    public static void sendAdRqSuc(String str, TanxAdSlot tanxAdSlot, String str2, long j10, int i10, AdInfo adInfo) {
        ArrayList arrayList = new ArrayList();
        if (adInfo != null && adInfo.getBidInfoList() != null && adInfo.getBidInfoList().size() > 0) {
            for (int i11 = 0; i11 < adInfo.getBidInfoList().size(); i11++) {
                arrayList.add(adInfo.getBidInfoList().get(i11).getTemplateId());
            }
        }
        Map<String, Object> buildArgs = TanxBaseUt.buildArgs(tanxAdSlot.getPid(), str2, null, null);
        buildArgs.put("scenes", str);
        buildArgs.put(ExposeManager.UtArgsNames.templateId, arrayList.toString());
        buildArgs.put("ad_count", String.valueOf(tanxAdSlot.getAdCount()));
        buildArgs.put("result_ad_count", String.valueOf(i10));
        buildArgs.put("request_time", String.valueOf(j10));
        AdUtConstants adUtConstants = AdUtConstants.AD_REQUEST;
        TanxBaseUt.send(adUtConstants.arg1, adUtConstants.eventId, tanxAdSlot.getPid(), str2, adInfo == null ? -1 : adInfo.getStatus(), adUtConstants.arg1, buildArgs, "");
    }

    public static void sendClickExposureFail(String str, String str2, IBidInfo iBidInfo, String str3, int i10, String str4) {
        Map<String, Object> buildArgs = TanxBaseUt.buildArgs(str, str2, iBidInfo.getCreativeId(), iBidInfo.getTemplateId());
        buildArgs.put(ExposeManager.UtArgsNames.templateId, iBidInfo.getTemplateId());
        buildArgs.put("params", str3);
        buildArgs.put("msg", str4);
        AdUtConstants adUtConstants = AdUtConstants.CLICK_REQUEST;
        String str5 = adUtConstants.arg1;
        TanxBaseUt.send(str5, adUtConstants.eventId, str, str2, i10, str5, iBidInfo.getInteractType2Int() + "", "", buildArgs, iBidInfo.getSessionId());
    }

    public static void sendClickExposureSuc(String str, String str2, IBidInfo iBidInfo, String str3) {
        Map<String, Object> buildArgs = TanxBaseUt.buildArgs(str, str2, iBidInfo.getCreativeId(), iBidInfo.getTemplateId());
        buildArgs.put(ExposeManager.UtArgsNames.templateId, iBidInfo.getTemplateId());
        AdUtConstants adUtConstants = AdUtConstants.CLICK_REQUEST;
        String str4 = adUtConstants.arg1;
        TanxBaseUt.send(str4, adUtConstants.eventId, str, str2, 0, str4, iBidInfo.getInteractType2Int() + "", "", buildArgs, iBidInfo.getSessionId());
    }

    public static void sendDownH5ZipFail(String str, int i10, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("params", str);
        hashMap.put("code", i10 + "");
        hashMap.put("msg", str2);
        AdUtConstants adUtConstants = AdUtConstants.DOWN_H5_ZIP;
        String str3 = adUtConstants.arg1;
        TanxBaseUt.send(str3, adUtConstants.eventId, i10, str3, hashMap, "");
    }

    public static void sendExposureFail(String str, String str2, IBidInfo iBidInfo, String str3, int i10, String str4) {
        Map<String, Object> buildArgs = TanxBaseUt.buildArgs(str, str2, iBidInfo.getCreativeId(), iBidInfo.getTemplateId());
        buildArgs.put(ExposeManager.UtArgsNames.templateId, iBidInfo.getTemplateId());
        buildArgs.put("params", str3);
        buildArgs.put("code", i10 + "");
        buildArgs.put("msg", str4);
        AdUtConstants adUtConstants = AdUtConstants.IMP_REQUEST;
        String str5 = adUtConstants.arg1;
        TanxBaseUt.send(str5, adUtConstants.eventId, str, str2, i10, str5, iBidInfo.getInteractType2Int() + "", "", buildArgs, iBidInfo.getSessionId());
    }

    public static void sendExposureSuc(String str, String str2, IBidInfo iBidInfo, String str3) {
        Map<String, Object> buildArgs = TanxBaseUt.buildArgs(str, str2, iBidInfo.getCreativeId(), iBidInfo.getTemplateId());
        buildArgs.put(ExposeManager.UtArgsNames.templateId, iBidInfo.getTemplateId());
        AdUtConstants adUtConstants = AdUtConstants.IMP_REQUEST;
        String str4 = adUtConstants.arg1;
        TanxBaseUt.send(str4, adUtConstants.eventId, str, str2, 0, str4, iBidInfo.getInteractType2Int() + "", "", buildArgs, iBidInfo.getSessionId());
    }

    public static void sendIntoMethod(TanxAdSlot tanxAdSlot, String str, IBidInfo iBidInfo, String str2, AdUtConstants adUtConstants) {
        sendIntoMethod(tanxAdSlot, str, iBidInfo, str2, adUtConstants, new HashMap());
    }

    public static void sendNewConfigFail(String str, long j10, int i10, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        String str4 = str;
        HashMap hashMap = new HashMap();
        hashMap.put("params", str3);
        hashMap.put("msg", str2);
        AdUtConstants adUtConstants = AdUtConstants.NEW_CONFIG_MONITOR;
        TanxBaseUt.send(adUtConstants.arg1, adUtConstants.eventId, "", str4, i10, String.valueOf(j10), hashMap, "");
    }

    public static void sendNewConfigSuc(String str, long j10) {
        HashMap hashMap = new HashMap();
        String str2 = TextUtils.isEmpty(str) ? "" : str;
        AdUtConstants adUtConstants = AdUtConstants.NEW_CONFIG_MONITOR;
        TanxBaseUt.send(adUtConstants.arg1, adUtConstants.eventId, "", str2, 0, j10 + "", hashMap, "");
    }

    public static void sendRewardRqFail(String str, long j10, int i10, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        String str4 = str;
        HashMap hashMap = new HashMap();
        hashMap.put("params", str3);
        hashMap.put("msg", str2);
        AdUtConstants adUtConstants = AdUtConstants.REWARD_REQUEST;
        TanxBaseUt.send(adUtConstants.arg1, adUtConstants.eventId, "", str4, i10, String.valueOf(j10), hashMap, "");
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0031, code lost:
    
        if (r8 != null) goto L61;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void sendRewardRqSuc(java.lang.String r8, long r9, com.alimm.tanx.core.ad.bean.RewardResponse r11) {
        /*
            java.util.HashMap r6 = new java.util.HashMap
            r6.<init>()
            boolean r0 = android.text.TextUtils.isEmpty(r8)
            java.lang.String r1 = ""
            if (r0 == 0) goto Lf
            r3 = r1
            goto L10
        Lf:
            r3 = r8
        L10:
            if (r11 == 0) goto L3a
            java.util.List r8 = r11.getPidRewards()     // Catch: java.lang.Exception -> L34
            if (r8 == 0) goto L3a
            java.util.List r8 = r11.getPidRewards()     // Catch: java.lang.Exception -> L34
            int r8 = r8.size()     // Catch: java.lang.Exception -> L34
            if (r8 <= 0) goto L3a
            java.util.List r8 = r11.getPidRewards()     // Catch: java.lang.Exception -> L34
            r11 = 0
            java.lang.Object r8 = r8.get(r11)     // Catch: java.lang.Exception -> L34
            com.alimm.tanx.core.ad.bean.RewardResponse$PidRewards r8 = (com.alimm.tanx.core.ad.bean.RewardResponse.PidRewards) r8     // Catch: java.lang.Exception -> L34
            java.lang.String r8 = r8.getPid()     // Catch: java.lang.Exception -> L34
            if (r8 == 0) goto L3a
            goto L3b
        L34:
            r8 = move-exception
            com.alimm.tanx.core.utils.LogUtils.e(r8)
            r2 = r1
            goto L3c
        L3a:
            r8 = r1
        L3b:
            r2 = r8
        L3c:
            com.alimm.tanx.core.ut.AdUtConstants r8 = com.alimm.tanx.core.ut.AdUtConstants.REWARD_REQUEST
            java.lang.String r0 = r8.arg1
            int r8 = r8.eventId
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            r11.append(r9)
            r11.append(r1)
            java.lang.String r5 = r11.toString()
            java.lang.String r7 = ""
            r4 = 0
            r1 = r8
            com.alimm.tanx.core.ut.impl.TanxBaseUt.send(r0, r1, r2, r3, r4, r5, r6, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alimm.tanx.core.ut.impl.TanxCommonUt.sendRewardRqSuc(java.lang.String, long, com.alimm.tanx.core.ad.bean.RewardResponse):void");
    }

    public static void sendStartImp(TanxAdSlot tanxAdSlot, String str, IBidInfo iBidInfo, int i10) {
        String pid = tanxAdSlot != null ? tanxAdSlot.getPid() : "";
        Map<String, Object> buildArgs = TanxBaseUt.buildArgs(pid, str, iBidInfo.getCreativeId(), iBidInfo.getTemplateId());
        buildArgs.put("scenes", TanxAdType.getAdTypeStr(i10) + "");
        TanxBaseUt.buildAntiCheatParam(buildArgs);
        AdUtConstants adUtConstants = AdUtConstants.START_IMP;
        String str2 = adUtConstants.arg1;
        TanxBaseUt.send(str2, adUtConstants.eventId, pid, str, str2, iBidInfo.getInteractType2Int() + "", null, buildArgs, iBidInfo.getSessionId());
    }

    public static void sendUt(ITanxAd iTanxAd, AdUtConstants adUtConstants, HashMap<String, String> hashMap, int i10) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        str = "";
        if (iTanxAd != null) {
            String pid = iTanxAd.getAdSlot() != null ? iTanxAd.getAdSlot().getPid() : "";
            String requestId = iTanxAd.getRequestId();
            String creativeId = iTanxAd.getBidInfo() != null ? iTanxAd.getBidInfo().getCreativeId() : "";
            str2 = iTanxAd.getBidInfo() != null ? iTanxAd.getBidInfo().getTemplateId() : "";
            str5 = iTanxAd.getBidInfo() != null ? iTanxAd.getBidInfo().getSessionId() : "";
            str3 = pid;
            str4 = requestId;
            str = creativeId;
        } else {
            str2 = "";
            str3 = str2;
            str4 = str3;
            str5 = str4;
        }
        Map<String, Object> buildArgs = TanxBaseUt.buildArgs(str3, str4, str, str2);
        buildArgs.putAll(hashMap);
        String str6 = adUtConstants.arg1;
        TanxBaseUt.send(str6, adUtConstants.eventId, str3, str4, i10, str6, "", "", buildArgs, str5);
    }

    public static void utShakeDestroy(ITanxAd iTanxAd, String str) {
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7 = "";
        if (iTanxAd != null) {
            try {
                String pid = iTanxAd.getAdSlot() != null ? iTanxAd.getAdSlot().getPid() : "";
                String requestId = iTanxAd.getRequestId();
                if (iTanxAd.getBidInfo() != null) {
                    String creativeId = iTanxAd.getBidInfo().getCreativeId();
                    str2 = iTanxAd.getBidInfo().getTemplateId();
                    String sessionId = iTanxAd.getBidInfo().getSessionId();
                    if (iTanxAd.getBidInfo().getTemplateConf() != null && iTanxAd.getBidInfo().getTemplateConf().getPidStyleId() != null) {
                        str7 = iTanxAd.getBidInfo().getTemplateConf().getPidStyleId();
                    }
                    str3 = str7;
                    str6 = requestId;
                    str7 = creativeId;
                    str4 = sessionId;
                    str5 = pid;
                } else {
                    str2 = "";
                    str3 = str2;
                    str4 = str3;
                    str5 = pid;
                    str6 = requestId;
                }
            } catch (Exception e10) {
                LogUtils.e(e10);
                return;
            }
        } else {
            str6 = "";
            str5 = str6;
            str2 = str5;
            str3 = str2;
            str4 = str3;
        }
        Map<String, Object> buildArgs = TanxBaseUt.buildArgs(str5, str6, str7, str2);
        if (OrangeManager.getInstance().getCommonSwitch("antiCheatingSwitch")) {
            buildArgs.put("sensor_list", str);
        }
        AdUtConstants adUtConstants = AdUtConstants.SHAKE_DESTROY;
        String str8 = adUtConstants.arg1;
        TanxBaseUt.send(str8, adUtConstants.eventId, 1, str5, str6, str8, "", str3, buildArgs, str4);
    }

    public static void utTimer(ITanxAd iTanxAd, boolean z10, int i10) {
        HashMap hashMap = new HashMap();
        hashMap.put("is_suc", z10 ? "1" : "0");
        sendUt(iTanxAd, AdUtConstants.AD_TIMER, hashMap, i10);
    }

    public static void utWebStartLoad(ITanxAd iTanxAd) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6 = "";
        if (iTanxAd != null) {
            String pid = iTanxAd.getAdSlot() != null ? iTanxAd.getAdSlot().getPid() : "";
            String requestId = iTanxAd.getRequestId();
            if (iTanxAd.getBidInfo() != null) {
                String creativeId = iTanxAd.getBidInfo().getCreativeId();
                str = iTanxAd.getBidInfo().getTemplateId();
                String sessionId = iTanxAd.getBidInfo().getSessionId();
                if (iTanxAd.getBidInfo().getTemplateConf() != null && iTanxAd.getBidInfo().getTemplateConf().getPidStyleId() != null) {
                    str6 = iTanxAd.getBidInfo().getTemplateConf().getPidStyleId();
                }
                str4 = str6;
                str2 = pid;
                str3 = requestId;
                str6 = creativeId;
                str5 = sessionId;
            } else {
                str = "";
                str4 = str;
                str5 = str4;
                str2 = pid;
                str3 = requestId;
            }
        } else {
            str = "";
            str2 = str;
            str3 = str2;
            str4 = str3;
            str5 = str4;
        }
        Map<String, Object> buildArgs = TanxBaseUt.buildArgs(str2, str3, str6, str);
        AdUtConstants adUtConstants = AdUtConstants.WEB_START_LOAD;
        String str7 = adUtConstants.arg1;
        TanxBaseUt.send(str7, adUtConstants.eventId, 1, str2, str3, str7, "", str4, buildArgs, str5);
    }

    public static void sendIntoMethod(TanxAdSlot tanxAdSlot, String str, IBidInfo iBidInfo, String str2, AdUtConstants adUtConstants, Map<String, String> map) {
        String pid = tanxAdSlot != null ? tanxAdSlot.getPid() : "";
        Map<String, Object> buildArgs = TanxBaseUt.buildArgs(pid, str, iBidInfo.getCreativeId(), iBidInfo.getTemplateId());
        if (map != null) {
            buildArgs.putAll(map);
        }
        buildArgs.put("method_name", str2);
        String str3 = adUtConstants.arg1;
        TanxBaseUt.send(str3, adUtConstants.eventId, pid, str, str3, buildArgs, iBidInfo.getSessionId());
    }
}
