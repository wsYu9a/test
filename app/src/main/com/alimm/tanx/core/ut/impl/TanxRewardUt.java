package com.alimm.tanx.core.ut.impl;

import android.text.TextUtils;
import com.alimm.tanx.core.ad.ITanxAd;
import com.alimm.tanx.core.ad.bean.BidInfo;
import com.alimm.tanx.core.request.TanxAdSlot;
import com.alimm.tanx.core.ut.AdUtConstants;
import com.czhj.sdk.common.Constants;
import java.util.Map;

/* loaded from: classes.dex */
public class TanxRewardUt extends TanxBaseUt {
    public static void utCloseAdVideoProgress(ITanxAd iTanxAd, long j10) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        if (iTanxAd != null) {
            String pid = iTanxAd.getAdSlot() != null ? iTanxAd.getAdSlot().getPid() : "";
            String requestId = iTanxAd.getRequestId();
            if (iTanxAd.getBidInfo() != null) {
                str = iTanxAd.getBidInfo().getCreativeId();
                str2 = iTanxAd.getBidInfo().getTemplateId();
                str5 = iTanxAd.getBidInfo().getSessionId();
            } else {
                str = "";
                str2 = str;
                str5 = str2;
            }
            str3 = pid;
            str4 = requestId;
        } else {
            str = "";
            str2 = str;
            str3 = str2;
            str4 = str3;
            str5 = str4;
        }
        Map<String, Object> buildArgs = TanxBaseUt.buildArgs(str3, str4, str, str2);
        buildArgs.put("progress", j10 + "");
        AdUtConstants adUtConstants = AdUtConstants.CLOSE_AD_VIDEO_PROGRESS;
        String str6 = adUtConstants.arg1;
        TanxBaseUt.send(str6, adUtConstants.eventId, str3, str4, 0, str6, buildArgs, str5);
    }

    public static void utFeedbackPopImp(ITanxAd iTanxAd) {
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
                if (iTanxAd.getBidInfo().getTemplateConf() != null && TextUtils.isEmpty(iTanxAd.getBidInfo().getTemplateConf().getPidStyleId())) {
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
        AdUtConstants adUtConstants = AdUtConstants.FEEDBACK_POP_IMP;
        String str7 = adUtConstants.arg1;
        TanxBaseUt.send(str7, adUtConstants.eventId, str2, str3, 0, str7, str4, "", buildArgs, str5);
    }

    public static void utIsRewardValid(ITanxAd iTanxAd, int i10) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5 = "";
        if (iTanxAd != null) {
            String pid = iTanxAd.getAdSlot() != null ? iTanxAd.getAdSlot().getPid() : "";
            String requestId = iTanxAd.getRequestId();
            if (iTanxAd.getBidInfo() != null) {
                str5 = iTanxAd.getBidInfo().getCreativeId();
                str = iTanxAd.getBidInfo().getTemplateId();
                str4 = iTanxAd.getBidInfo().getSessionId();
            } else {
                str = "";
                str4 = str;
            }
            str2 = pid;
            str3 = requestId;
        } else {
            str = "";
            str2 = str;
            str3 = str2;
            str4 = str3;
        }
        Map<String, Object> buildArgs = TanxBaseUt.buildArgs(str2, str3, str5, str);
        AdUtConstants adUtConstants = AdUtConstants.IS_REWARD_VALID;
        String str6 = adUtConstants.arg1;
        TanxBaseUt.send(str6, adUtConstants.eventId, str2, str3, i10, str6, buildArgs, str4);
    }

    public static void utPlayEndClickTime(ITanxAd iTanxAd, long j10, int i10) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        if (iTanxAd != null) {
            String pid = iTanxAd.getAdSlot() != null ? iTanxAd.getAdSlot().getPid() : "";
            String requestId = iTanxAd.getRequestId();
            if (iTanxAd.getBidInfo() != null) {
                str = iTanxAd.getBidInfo().getCreativeId();
                str2 = iTanxAd.getBidInfo().getTemplateId();
                str3 = pid;
                str4 = requestId;
                str5 = iTanxAd.getBidInfo().getSessionId();
            } else {
                str = "";
                str2 = str;
                str5 = str2;
                str3 = pid;
                str4 = requestId;
            }
        } else {
            str = "";
            str2 = str;
            str3 = str2;
            str4 = str3;
            str5 = str4;
        }
        Map<String, Object> buildArgs = TanxBaseUt.buildArgs(str3, str4, str, str2);
        buildArgs.put("time", j10 + "");
        buildArgs.put(Constants.CLICK_TYPE, i10 + "");
        AdUtConstants adUtConstants = AdUtConstants.PLAY_END_CLICK_TIME;
        String str6 = adUtConstants.arg1;
        TanxBaseUt.send(str6, adUtConstants.eventId, str3, str4, 0, str6, buildArgs, str5);
    }

    public static void utSavePopCancel(ITanxAd iTanxAd) {
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
                if (iTanxAd.getBidInfo().getTemplateConf() != null && TextUtils.isEmpty(iTanxAd.getBidInfo().getTemplateConf().getPidStyleId())) {
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
        AdUtConstants adUtConstants = AdUtConstants.SAVE_POP_CANCEL;
        String str7 = adUtConstants.arg1;
        TanxBaseUt.send(str7, adUtConstants.eventId, str2, str3, 0, str7, str4, "", buildArgs, str5);
    }

    public static void utSavePopImp(ITanxAd iTanxAd) {
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
                if (iTanxAd.getBidInfo().getTemplateConf() != null && TextUtils.isEmpty(iTanxAd.getBidInfo().getTemplateConf().getPidStyleId())) {
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
        AdUtConstants adUtConstants = AdUtConstants.SAVE_POP_IMP;
        String str7 = adUtConstants.arg1;
        TanxBaseUt.send(str7, adUtConstants.eventId, str2, str3, 0, str7, str4, "", buildArgs, str5);
    }

    public static void utSavePopPresist(ITanxAd iTanxAd) {
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
                if (iTanxAd.getBidInfo().getTemplateConf() != null && !TextUtils.isEmpty(iTanxAd.getBidInfo().getTemplateConf().getPidStyleId())) {
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
        AdUtConstants adUtConstants = AdUtConstants.SAVE_POP_PRESIST;
        String str7 = adUtConstants.arg1;
        TanxBaseUt.send(str7, adUtConstants.eventId, str2, str3, 0, str7, str4, "", buildArgs, str5);
    }

    public static void utViewDraw(ITanxAd iTanxAd, int i10) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        if (iTanxAd != null) {
            String pid = iTanxAd.getAdSlot() != null ? iTanxAd.getAdSlot().getPid() : "";
            String requestId = iTanxAd.getRequestId();
            if (iTanxAd.getBidInfo() != null) {
                String creativeId = iTanxAd.getBidInfo().getCreativeId();
                String templateId = iTanxAd.getBidInfo().getTemplateId();
                str5 = iTanxAd.getBidInfo().getSessionId();
                str3 = creativeId;
                str = pid;
                str2 = requestId;
                str4 = templateId;
            } else {
                str3 = "";
                str4 = str3;
                str5 = str4;
                str = pid;
                str2 = requestId;
            }
        } else {
            str = "";
            str2 = str;
            str3 = str2;
            str4 = str3;
            str5 = str4;
        }
        utViewDraw(str, str2, str3, str4, i10, str5);
    }

    public static void utViewDraw(BidInfo bidInfo, TanxAdSlot tanxAdSlot, int i10) {
        String str;
        String str2;
        String str3;
        String str4;
        String pid = tanxAdSlot != null ? tanxAdSlot.getPid() : "";
        if (tanxAdSlot == null) {
            str = "";
        } else {
            str = tanxAdSlot.getReqId();
        }
        if (bidInfo == null) {
            str2 = "";
            str3 = str2;
            str4 = str3;
        } else {
            String creativeId = bidInfo.getCreativeId();
            String templateId = bidInfo.getTemplateId();
            str4 = bidInfo.getSessionId();
            str3 = templateId;
            str2 = creativeId;
        }
        utViewDraw(pid, str, str2, str3, i10, str4);
    }

    public static void utViewDraw(String str, String str2, String str3, String str4, int i10, String str5) {
        Map<String, Object> buildArgs = TanxBaseUt.buildArgs(str, str2, str3, str4);
        buildArgs.put("is_suc", i10 + "");
        int i11 = i10 == 1 ? 0 : 1;
        AdUtConstants adUtConstants = AdUtConstants.REWARD_VIDEO_VIEW_CREATE;
        String str6 = adUtConstants.arg1;
        TanxBaseUt.send(str6, adUtConstants.eventId, str, str2, i11, str6, buildArgs, str5);
    }
}
