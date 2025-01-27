package com.qq.e.ads.banner2;

import android.app.Activity;
import android.content.Context;
import com.qq.e.ads.LiteAbstractAD;
import com.qq.e.ads.cfg.DownAPPConfirmPolicy;
import com.qq.e.ads.rewardvideo.ServerSideVerificationOptions;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.listeners.ADRewardListener;
import com.qq.e.comm.listeners.NegativeFeedbackListener;
import com.qq.e.comm.pi.IReward;
import com.qq.e.comm.pi.NFBI;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.pi.UBVI;
import com.qq.e.comm.util.AdErrorConvertor;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes4.dex */
class UnifiedBannerAD extends LiteAbstractAD<UBVI> implements NFBI, IReward {

    /* renamed from: g */
    private UnifiedBannerADListener f23878g;

    /* renamed from: h */
    private DownAPPConfirmPolicy f23879h;

    /* renamed from: i */
    private AtomicInteger f23880i;

    /* renamed from: j */
    private int f23881j;
    private LoadAdParams k;
    private UnifiedBannerView l;
    private final ADListenerAdapter m;
    private volatile ServerSideVerificationOptions n;

    UnifiedBannerAD(Activity activity, UnifiedBannerView unifiedBannerView, String str, UnifiedBannerADListener unifiedBannerADListener) {
        this(unifiedBannerView, unifiedBannerADListener);
        a(activity, str);
    }

    UnifiedBannerAD(Activity activity, UnifiedBannerView unifiedBannerView, String str, String str2, UnifiedBannerADListener unifiedBannerADListener) {
        this(unifiedBannerView, unifiedBannerADListener);
        a(activity, str, str2);
    }

    private UnifiedBannerAD(UnifiedBannerView unifiedBannerView, UnifiedBannerADListener unifiedBannerADListener) {
        this.f23880i = new AtomicInteger(0);
        this.f23881j = 30;
        this.k = null;
        this.f23878g = unifiedBannerADListener;
        this.l = unifiedBannerView;
        this.m = new ADListenerAdapter(unifiedBannerADListener);
    }

    @Override // com.qq.e.ads.AbstractAD
    protected Object a(Context context, POFactory pOFactory, String str, String str2, String str3) {
        return pOFactory.getUnifiedBannerViewDelegate(this.l, (Activity) context, str, str2, str3, this.m);
    }

    void a(DownAPPConfirmPolicy downAPPConfirmPolicy) {
        T t;
        this.f23879h = downAPPConfirmPolicy;
        if (downAPPConfirmPolicy == null || (t = this.f23859a) == 0) {
            return;
        }
        ((UBVI) t).setDownAPPConfirmPolicy(downAPPConfirmPolicy);
    }

    @Override // com.qq.e.ads.AbstractAD
    protected void b(int i2) {
        UnifiedBannerADListener unifiedBannerADListener = this.f23878g;
        if (unifiedBannerADListener != null) {
            unifiedBannerADListener.onNoAD(AdErrorConvertor.formatErrorCode(i2));
        }
    }

    void c(int i2) {
        this.f23881j = i2;
        T t = this.f23859a;
        if (t != 0) {
            ((UBVI) t).setRefresh(i2);
        }
    }

    void destroy() {
        T t = this.f23859a;
        if (t != 0) {
            ((UBVI) t).destroy();
        } else {
            a("destroy");
        }
    }

    public String getAdNetWorkName() {
        T t = this.f23859a;
        if (t != 0) {
            return ((UBVI) t).getAdNetWorkName();
        }
        a("getAdNetWorkName");
        return null;
    }

    void loadAD() {
        if (a()) {
            if (!b()) {
                this.f23880i.incrementAndGet();
                return;
            }
            T t = this.f23859a;
            if (t != 0) {
                ((UBVI) t).fetchAd();
            } else {
                a("loadAD");
            }
        }
    }

    void onWindowFocusChanged(boolean z) {
        T t = this.f23859a;
        if (t != 0) {
            ((UBVI) t).onWindowFocusChanged(z);
        }
    }

    void setLoadAdParams(LoadAdParams loadAdParams) {
        this.k = loadAdParams;
        T t = this.f23859a;
        if (t != 0) {
            ((UBVI) t).setLoadAdParams(loadAdParams);
        }
    }

    @Override // com.qq.e.comm.pi.NFBI
    public void setNegativeFeedbackListener(NegativeFeedbackListener negativeFeedbackListener) {
        this.m.setNegativeFeedbackListener(negativeFeedbackListener);
    }

    @Override // com.qq.e.comm.pi.IReward
    public void setRewardListener(ADRewardListener aDRewardListener) {
        this.m.setAdRewardListener(aDRewardListener);
    }

    @Override // com.qq.e.comm.pi.IReward
    public void setServerSideVerificationOptions(ServerSideVerificationOptions serverSideVerificationOptions) {
        this.n = serverSideVerificationOptions;
        T t = this.f23859a;
        if (t != 0) {
            ((UBVI) t).setServerSideVerificationOptions(serverSideVerificationOptions);
        }
    }

    @Override // com.qq.e.ads.AbstractAD
    protected void a(Object obj) {
        UBVI ubvi = (UBVI) obj;
        DownAPPConfirmPolicy downAPPConfirmPolicy = this.f23879h;
        if (downAPPConfirmPolicy != null) {
            this.f23879h = downAPPConfirmPolicy;
            T t = this.f23859a;
            if (t != 0) {
                ((UBVI) t).setDownAPPConfirmPolicy(downAPPConfirmPolicy);
            }
        }
        int i2 = this.f23881j;
        this.f23881j = i2;
        T t2 = this.f23859a;
        if (t2 != 0) {
            ((UBVI) t2).setRefresh(i2);
        }
        LoadAdParams loadAdParams = this.k;
        this.k = loadAdParams;
        T t3 = this.f23859a;
        if (t3 != 0) {
            ((UBVI) t3).setLoadAdParams(loadAdParams);
        }
        ubvi.setServerSideVerificationOptions(this.n);
        while (this.f23880i.getAndDecrement() > 0) {
            loadAD();
        }
    }
}
