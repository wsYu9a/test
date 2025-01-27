package com.qq.e.ads.banner2;

import com.qq.e.ads.rewardvideo.ServerSideVerificationOptions;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.listeners.ADRewardListener;
import com.qq.e.comm.listeners.NegativeFeedbackListener;
import com.qq.e.comm.util.AdErrorConvertor;
import java.util.HashMap;

/* loaded from: classes4.dex */
class ADListenerAdapter implements ADListener {

    /* renamed from: a */
    private final UnifiedBannerADListener f23875a;

    /* renamed from: b */
    private NegativeFeedbackListener f23876b;

    /* renamed from: c */
    private ADRewardListener f23877c;

    ADListenerAdapter(UnifiedBannerADListener unifiedBannerADListener) {
        this.f23875a = unifiedBannerADListener;
    }

    @Override // com.qq.e.comm.adevent.ADListener
    public void onADEvent(ADEvent aDEvent) {
        UnifiedBannerADListener unifiedBannerADListener;
        String str;
        if (aDEvent == null) {
        }
        int type = aDEvent.getType();
        if (type == 100) {
            UnifiedBannerADListener unifiedBannerADListener2 = this.f23875a;
            if (unifiedBannerADListener2 != null) {
                unifiedBannerADListener2.onADReceive();
                return;
            }
            return;
        }
        if (type == 101) {
            Integer num = (Integer) aDEvent.getParam(Integer.class);
            if (num == null || (unifiedBannerADListener = this.f23875a) == null) {
                return;
            }
            unifiedBannerADListener.onNoAD(AdErrorConvertor.formatErrorCode(num.intValue()));
            return;
        }
        if (type == 303) {
            UnifiedBannerADListener unifiedBannerADListener3 = this.f23875a;
            if (unifiedBannerADListener3 != null) {
                unifiedBannerADListener3.onADLeftApplication();
                return;
            }
            return;
        }
        if (type == 304) {
            NegativeFeedbackListener negativeFeedbackListener = this.f23876b;
            if (negativeFeedbackListener != null) {
                negativeFeedbackListener.onComplainSuccess();
                return;
            }
            return;
        }
        switch (type) {
            case 103:
                UnifiedBannerADListener unifiedBannerADListener4 = this.f23875a;
                if (unifiedBannerADListener4 != null) {
                    unifiedBannerADListener4.onADExposure();
                    break;
                }
                break;
            case 104:
                if (this.f23877c != null && (str = (String) aDEvent.getParam(String.class)) != null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(ServerSideVerificationOptions.TRANS_ID, str);
                    this.f23877c.onReward(hashMap);
                    break;
                }
                break;
            case 105:
                UnifiedBannerADListener unifiedBannerADListener5 = this.f23875a;
                if (unifiedBannerADListener5 != null) {
                    unifiedBannerADListener5.onADClicked();
                    break;
                }
                break;
            case 106:
                UnifiedBannerADListener unifiedBannerADListener6 = this.f23875a;
                if (unifiedBannerADListener6 != null) {
                    unifiedBannerADListener6.onADClosed();
                    break;
                }
                break;
        }
    }

    public void setAdRewardListener(ADRewardListener aDRewardListener) {
        this.f23877c = aDRewardListener;
    }

    public void setNegativeFeedbackListener(NegativeFeedbackListener negativeFeedbackListener) {
        this.f23876b = negativeFeedbackListener;
    }
}
