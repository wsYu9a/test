package com.qq.e.ads.rewardvideo;

import android.app.Activity;
import android.content.Context;
import com.qq.e.ads.LiteAbstractAD;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.listeners.NegativeFeedbackListener;
import com.qq.e.comm.pi.NFBI;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.pi.RVADI;
import com.qq.e.comm.util.AdErrorConvertor;
import java.util.HashMap;

/* loaded from: classes3.dex */
public class RewardVideoAD extends LiteAbstractAD<RVADI> implements NFBI {
    public static final int REWARD_TYPE_PAGE = 1;
    public static final int REWARD_TYPE_VIDEO = 0;

    /* renamed from: i */
    private final RewardVideoADListener f16500i;

    /* renamed from: j */
    private volatile boolean f16501j;

    /* renamed from: k */
    private LoadAdParams f16502k;

    /* renamed from: l */
    private ServerSideVerificationOptions f16503l;

    /* renamed from: m */
    private final boolean f16504m;

    /* renamed from: n */
    private final ADListenerAdapter f16505n;

    public static class ADListenerAdapter implements ADListener {

        /* renamed from: a */
        private NegativeFeedbackListener f16506a;
        public RewardVideoADListener adListener;

        public ADListenerAdapter(RewardVideoADListener rewardVideoADListener) {
            this.adListener = rewardVideoADListener;
        }

        public static void a(ADListenerAdapter aDListenerAdapter, NegativeFeedbackListener negativeFeedbackListener) {
            aDListenerAdapter.f16506a = negativeFeedbackListener;
        }

        @Override // com.qq.e.comm.adevent.ADListener
        public void onADEvent(ADEvent aDEvent) {
            int type = aDEvent.getType();
            if (type == 100) {
                this.adListener.onADLoad();
            }
            if (type == 201) {
                this.adListener.onVideoCached();
                return;
            }
            if (type == 206) {
                this.adListener.onVideoComplete();
                return;
            }
            if (type == 304) {
                NegativeFeedbackListener negativeFeedbackListener = this.f16506a;
                if (negativeFeedbackListener != null) {
                    negativeFeedbackListener.onComplainSuccess();
                    return;
                }
                return;
            }
            switch (type) {
                case 102:
                    this.adListener.onADShow();
                    break;
                case 103:
                    this.adListener.onADExpose();
                    break;
                case 104:
                    String str = (String) aDEvent.getParam(String.class);
                    if (str != null) {
                        HashMap hashMap = new HashMap();
                        hashMap.put("transId", str);
                        Integer num = (Integer) aDEvent.getParam(1, Integer.class);
                        if (num != null) {
                            hashMap.put(ServerSideVerificationOptions.ACTION, num);
                        }
                        this.adListener.onReward(hashMap);
                        break;
                    }
                    break;
                case 105:
                    this.adListener.onADClick();
                    break;
                case 106:
                    this.adListener.onADClose();
                    break;
                case 107:
                    Integer num2 = (Integer) aDEvent.getParam(Integer.class);
                    if (num2 != null) {
                        this.adListener.onError(AdErrorConvertor.formatErrorCode(num2.intValue()));
                        break;
                    }
                    break;
            }
        }
    }

    public RewardVideoAD(Context context, String str, RewardVideoADListener rewardVideoADListener) {
        this(context, str, rewardVideoADListener, true);
    }

    @Override // com.qq.e.ads.AbstractAD
    public Object a(Context context, POFactory pOFactory, String str, String str2, String str3) {
        return pOFactory.getRewardVideoADDelegate(context, str, str2, str3, this.f16505n);
    }

    @Override // com.qq.e.ads.AbstractAD
    public void b(int i10) {
        RewardVideoADListener rewardVideoADListener = this.f16500i;
        if (rewardVideoADListener != null) {
            rewardVideoADListener.onError(AdErrorConvertor.formatErrorCode(i10));
        }
    }

    public String getAdNetWorkName() {
        T t10 = this.f16367a;
        if (t10 != 0) {
            return ((RVADI) t10).getAdNetWorkName();
        }
        a("getAdNetWorkName");
        return null;
    }

    public int getRewardAdType() {
        T t10 = this.f16367a;
        if (t10 != 0) {
            return ((RVADI) t10).getRewardAdType();
        }
        a("getRewardAdType");
        return 0;
    }

    public int getVideoDuration() {
        T t10 = this.f16367a;
        if (t10 != 0) {
            return ((RVADI) t10).getVideoDuration();
        }
        a("getVideoDuration");
        return 0;
    }

    public boolean hasShown() {
        T t10 = this.f16367a;
        if (t10 != 0) {
            return ((RVADI) t10).hasShown();
        }
        a("hasShown");
        return false;
    }

    public void loadAD() {
        if (a()) {
            if (!b()) {
                this.f16501j = true;
                return;
            }
            T t10 = this.f16367a;
            if (t10 != 0) {
                ((RVADI) t10).loadAD();
            } else {
                a("loadAD");
            }
        }
    }

    public void setLoadAdParams(LoadAdParams loadAdParams) {
        this.f16502k = loadAdParams;
        T t10 = this.f16367a;
        if (t10 != 0) {
            ((RVADI) t10).setLoadAdParams(loadAdParams);
        }
    }

    @Override // com.qq.e.comm.pi.NFBI
    public void setNegativeFeedbackListener(NegativeFeedbackListener negativeFeedbackListener) {
        ADListenerAdapter.a(this.f16505n, negativeFeedbackListener);
    }

    public void setServerSideVerificationOptions(ServerSideVerificationOptions serverSideVerificationOptions) {
        this.f16503l = serverSideVerificationOptions;
        T t10 = this.f16367a;
        if (t10 != 0) {
            ((RVADI) t10).setServerSideVerificationOptions(serverSideVerificationOptions);
        }
    }

    public void showAD() {
        T t10 = this.f16367a;
        if (t10 != 0) {
            ((RVADI) t10).showAD();
        } else {
            a("showAD");
        }
    }

    public RewardVideoAD(Context context, String str, RewardVideoADListener rewardVideoADListener, boolean z10) {
        this(rewardVideoADListener, z10);
        a(context, str);
    }

    @Override // com.qq.e.ads.AbstractAD
    public void a(Object obj) {
        RVADI rvadi = (RVADI) obj;
        rvadi.setVolumeOn(this.f16504m);
        rvadi.setLoadAdParams(this.f16502k);
        rvadi.setServerSideVerificationOptions(this.f16503l);
        if (this.f16501j) {
            loadAD();
        }
    }

    public void showAD(Activity activity) {
        T t10 = this.f16367a;
        if (t10 != 0) {
            ((RVADI) t10).showAD(activity);
        } else {
            a("showAD");
        }
    }

    public RewardVideoAD(Context context, String str, RewardVideoADListener rewardVideoADListener, boolean z10, String str2) {
        this(rewardVideoADListener, z10);
        a(context, str, str2);
    }

    private RewardVideoAD(RewardVideoADListener rewardVideoADListener, boolean z10) {
        this.f16502k = null;
        this.f16504m = z10;
        this.f16500i = rewardVideoADListener;
        this.f16505n = new ADListenerAdapter(rewardVideoADListener);
    }
}
