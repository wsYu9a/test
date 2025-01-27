package com.qq.e.ads.interstitial2;

import com.qq.e.ads.rewardvideo.ServerSideVerificationOptions;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.adevent.AdEventType;
import com.qq.e.comm.listeners.NegativeFeedbackListener;
import com.qq.e.comm.util.AdErrorConvertor;
import com.qq.e.comm.util.a;
import java.util.HashMap;

/* loaded from: classes4.dex */
class ADListenerAdapter implements ADListener {

    /* renamed from: a */
    private final UnifiedInterstitialADListener f23930a;

    /* renamed from: b */
    private UnifiedInterstitialMediaListener f23931b;

    /* renamed from: c */
    private com.qq.e.comm.listeners.ADRewardListener f23932c;

    /* renamed from: d */
    private NegativeFeedbackListener f23933d;

    ADListenerAdapter(UnifiedInterstitialADListener unifiedInterstitialADListener) {
        this.f23930a = unifiedInterstitialADListener;
    }

    @Override // com.qq.e.comm.adevent.ADListener
    public void onADEvent(ADEvent aDEvent) {
        UnifiedInterstitialADListener unifiedInterstitialADListener;
        String str;
        if (aDEvent == null) {
        }
        int type = aDEvent.getType();
        if (type == 109) {
            UnifiedInterstitialADListener unifiedInterstitialADListener2 = this.f23930a;
            if (unifiedInterstitialADListener2 == null || !a.b(unifiedInterstitialADListener2)) {
                return;
            }
            this.f23930a.onRenderSuccess();
            return;
        }
        if (type == 110) {
            UnifiedInterstitialADListener unifiedInterstitialADListener3 = this.f23930a;
            if (unifiedInterstitialADListener3 == null || !a.a(unifiedInterstitialADListener3)) {
                return;
            }
            this.f23930a.onRenderFail();
            return;
        }
        if (type == 201) {
            UnifiedInterstitialADListener unifiedInterstitialADListener4 = this.f23930a;
            if (unifiedInterstitialADListener4 != null) {
                unifiedInterstitialADListener4.onVideoCached();
                return;
            }
            return;
        }
        if (type == 202) {
            UnifiedInterstitialMediaListener unifiedInterstitialMediaListener = this.f23931b;
            if (unifiedInterstitialMediaListener != null) {
                unifiedInterstitialMediaListener.onVideoStart();
                return;
            }
            return;
        }
        if (type == 204) {
            UnifiedInterstitialMediaListener unifiedInterstitialMediaListener2 = this.f23931b;
            if (unifiedInterstitialMediaListener2 != null) {
                unifiedInterstitialMediaListener2.onVideoPause();
                return;
            }
            return;
        }
        if (type == 206) {
            UnifiedInterstitialMediaListener unifiedInterstitialMediaListener3 = this.f23931b;
            if (unifiedInterstitialMediaListener3 != null) {
                unifiedInterstitialMediaListener3.onVideoComplete();
                return;
            }
            return;
        }
        if (type == 207) {
            Integer num = (Integer) aDEvent.getParam(Integer.class);
            UnifiedInterstitialMediaListener unifiedInterstitialMediaListener4 = this.f23931b;
            if (unifiedInterstitialMediaListener4 == null || num == null) {
                return;
            }
            unifiedInterstitialMediaListener4.onVideoError(AdErrorConvertor.formatErrorCode(num.intValue()));
            return;
        }
        switch (type) {
            case 100:
                UnifiedInterstitialADListener unifiedInterstitialADListener5 = this.f23930a;
                if (unifiedInterstitialADListener5 != null) {
                    unifiedInterstitialADListener5.onADReceive();
                    break;
                }
                break;
            case 101:
                Integer num2 = (Integer) aDEvent.getParam(Integer.class);
                if (num2 != null && (unifiedInterstitialADListener = this.f23930a) != null) {
                    unifiedInterstitialADListener.onNoAD(AdErrorConvertor.formatErrorCode(num2.intValue()));
                    break;
                }
                break;
            case 102:
                UnifiedInterstitialADListener unifiedInterstitialADListener6 = this.f23930a;
                if (unifiedInterstitialADListener6 != null) {
                    unifiedInterstitialADListener6.onADOpened();
                    break;
                }
                break;
            case 103:
                UnifiedInterstitialADListener unifiedInterstitialADListener7 = this.f23930a;
                if (unifiedInterstitialADListener7 != null) {
                    unifiedInterstitialADListener7.onADExposure();
                    break;
                }
                break;
            case 104:
                if (this.f23932c != null && (str = (String) aDEvent.getParam(String.class)) != null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(ServerSideVerificationOptions.TRANS_ID, str);
                    this.f23932c.onReward(hashMap);
                    break;
                }
                break;
            case 105:
                UnifiedInterstitialADListener unifiedInterstitialADListener8 = this.f23930a;
                if (unifiedInterstitialADListener8 != null) {
                    unifiedInterstitialADListener8.onADClicked();
                    break;
                }
                break;
            case 106:
                UnifiedInterstitialADListener unifiedInterstitialADListener9 = this.f23930a;
                if (unifiedInterstitialADListener9 != null) {
                    unifiedInterstitialADListener9.onADClosed();
                    break;
                }
                break;
            default:
                switch (type) {
                    case 209:
                        UnifiedInterstitialMediaListener unifiedInterstitialMediaListener5 = this.f23931b;
                        if (unifiedInterstitialMediaListener5 != null) {
                            unifiedInterstitialMediaListener5.onVideoInit();
                            break;
                        }
                        break;
                    case 210:
                        Integer num3 = (Integer) aDEvent.getParam(Integer.class);
                        UnifiedInterstitialMediaListener unifiedInterstitialMediaListener6 = this.f23931b;
                        if (unifiedInterstitialMediaListener6 != null && num3 != null) {
                            unifiedInterstitialMediaListener6.onVideoReady(num3.intValue());
                            break;
                        }
                        break;
                    case AdEventType.VIDEO_LOADING /* 211 */:
                        UnifiedInterstitialMediaListener unifiedInterstitialMediaListener7 = this.f23931b;
                        if (unifiedInterstitialMediaListener7 != null) {
                            unifiedInterstitialMediaListener7.onVideoLoading();
                            break;
                        }
                        break;
                    default:
                        switch (type) {
                            case 301:
                                UnifiedInterstitialMediaListener unifiedInterstitialMediaListener8 = this.f23931b;
                                if (unifiedInterstitialMediaListener8 != null) {
                                    unifiedInterstitialMediaListener8.onVideoPageOpen();
                                    break;
                                }
                                break;
                            case 302:
                                UnifiedInterstitialMediaListener unifiedInterstitialMediaListener9 = this.f23931b;
                                if (unifiedInterstitialMediaListener9 != null) {
                                    unifiedInterstitialMediaListener9.onVideoPageClose();
                                    break;
                                }
                                break;
                            case 303:
                                UnifiedInterstitialADListener unifiedInterstitialADListener10 = this.f23930a;
                                if (unifiedInterstitialADListener10 != null) {
                                    unifiedInterstitialADListener10.onADLeftApplication();
                                    break;
                                }
                                break;
                            case 304:
                                NegativeFeedbackListener negativeFeedbackListener = this.f23933d;
                                if (negativeFeedbackListener != null) {
                                    negativeFeedbackListener.onComplainSuccess();
                                    break;
                                }
                                break;
                        }
                }
        }
    }

    public void setAdRewardListener(com.qq.e.comm.listeners.ADRewardListener aDRewardListener) {
        this.f23932c = aDRewardListener;
    }

    public void setMediaListener(UnifiedInterstitialMediaListener unifiedInterstitialMediaListener) {
        this.f23931b = unifiedInterstitialMediaListener;
    }

    public void setNegativeFeedbackListener(NegativeFeedbackListener negativeFeedbackListener) {
        this.f23933d = negativeFeedbackListener;
    }
}
