package com.alimm.tanx.core.utils;

import android.text.TextUtils;
import com.alimm.tanx.core.ad.bean.BidInfo;
import com.alimm.tanx.core.constant.AdConstants;
import com.alimm.tanx.core.constant.TanxAdTemplateId;

/* loaded from: classes.dex */
public class tanxc_if {
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static int tanxc_do(BidInfo bidInfo) {
        char c10;
        if (bidInfo != null && !TextUtils.isEmpty(bidInfo.getTemplateId())) {
            String templateId = bidInfo.getTemplateId();
            templateId.hashCode();
            switch (templateId.hashCode()) {
                case 1958016183:
                    if (templateId.equals(TanxAdTemplateId.SPLASH_ID)) {
                        c10 = 0;
                        break;
                    }
                    c10 = 65535;
                    break;
                case 1958016437:
                    if (templateId.equals(TanxAdTemplateId.FEED_PIC_16_9)) {
                        c10 = 1;
                        break;
                    }
                    c10 = 65535;
                    break;
                case 1958016459:
                    if (templateId.equals(TanxAdTemplateId.FEED_VIDEO_16_9)) {
                        c10 = 2;
                        break;
                    }
                    c10 = 65535;
                    break;
                case 1958018138:
                    if (templateId.equals(TanxAdTemplateId.FEED_VIDEO_9_16)) {
                        c10 = 3;
                        break;
                    }
                    c10 = 65535;
                    break;
                case 1958018202:
                    if (templateId.equals(TanxAdTemplateId.REWARD_VIDEO)) {
                        c10 = 4;
                        break;
                    }
                    c10 = 65535;
                    break;
                case 1958020093:
                    if (templateId.equals(TanxAdTemplateId.REWARD_WATCH)) {
                        c10 = 5;
                        break;
                    }
                    c10 = 65535;
                    break;
                case 1958020157:
                    if (templateId.equals(TanxAdTemplateId.FEED_PIC_9_16)) {
                        c10 = 6;
                        break;
                    }
                    c10 = 65535;
                    break;
                case 1958020249:
                    if (templateId.equals(TanxAdTemplateId.TABLE_ID)) {
                        c10 = 7;
                        break;
                    }
                    c10 = 65535;
                    break;
                default:
                    c10 = 65535;
                    break;
            }
            switch (c10) {
                case 0:
                case 1:
                    return 10;
                case 2:
                    return 11;
                case 3:
                    return 13;
                case 4:
                case 5:
                    if (bidInfo.getTemplateConf() != null && !TextUtils.isEmpty(bidInfo.getTemplateConf().getPidStyleId())) {
                        String pidStyleId = bidInfo.getTemplateConf().getPidStyleId();
                        if (pidStyleId.equals("100002")) {
                            return 30;
                        }
                        if (pidStyleId.equals("100003")) {
                            return 31;
                        }
                        if (pidStyleId.equals(AdConstants.PID_STYLE_NEW_REWARD_ID) || pidStyleId.equals("100016") || pidStyleId.equals("100022")) {
                            return 32;
                        }
                    }
                    break;
                case 6:
                    return 12;
                case 7:
                    return 20;
            }
        }
        return -1;
    }
}
