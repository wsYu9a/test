package com.qq.e.ads.banner2;

import android.app.Activity;
import android.content.Context;
import com.qq.e.ads.LiteAbstractAD;
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

/* loaded from: classes3.dex */
class UnifiedBannerAD extends LiteAbstractAD<UBVI> implements NFBI, IReward {

    /* renamed from: i */
    private UnifiedBannerADListener f16386i;

    /* renamed from: j */
    private AtomicInteger f16387j;

    /* renamed from: k */
    private int f16388k;

    /* renamed from: l */
    private LoadAdParams f16389l;

    /* renamed from: m */
    private UnifiedBannerView f16390m;

    /* renamed from: n */
    private final ADListenerAdapter f16391n;

    /* renamed from: o */
    private volatile ServerSideVerificationOptions f16392o;

    public UnifiedBannerAD(Activity activity, UnifiedBannerView unifiedBannerView, String str, UnifiedBannerADListener unifiedBannerADListener) {
        this(unifiedBannerView, unifiedBannerADListener);
        a(activity, str);
    }

    @Override // com.qq.e.ads.AbstractAD
    public Object a(Context context, POFactory pOFactory, String str, String str2, String str3) {
        return pOFactory.getUnifiedBannerViewDelegate(this.f16390m, (Activity) context, str, str2, str3, this.f16391n);
    }

    @Override // com.qq.e.ads.AbstractAD
    public void b(int i10) {
        UnifiedBannerADListener unifiedBannerADListener = this.f16386i;
        if (unifiedBannerADListener != null) {
            unifiedBannerADListener.onNoAD(AdErrorConvertor.formatErrorCode(i10));
        }
    }

    public void c(int i10) {
        this.f16388k = i10;
        T t10 = this.f16367a;
        if (t10 != 0) {
            ((UBVI) t10).setRefresh(i10);
        }
    }

    public void destroy() {
        T t10 = this.f16367a;
        if (t10 != 0) {
            ((UBVI) t10).destroy();
        } else {
            a("destroy");
        }
    }

    public String getAdNetWorkName() {
        T t10 = this.f16367a;
        if (t10 != 0) {
            return ((UBVI) t10).getAdNetWorkName();
        }
        a("getAdNetWorkName");
        return null;
    }

    public void loadAD() {
        if (a()) {
            if (!b()) {
                this.f16387j.incrementAndGet();
                return;
            }
            T t10 = this.f16367a;
            if (t10 != 0) {
                ((UBVI) t10).fetchAd();
            } else {
                a("loadAD");
            }
        }
    }

    public void onWindowFocusChanged(boolean z10) {
        T t10 = this.f16367a;
        if (t10 != 0) {
            ((UBVI) t10).onWindowFocusChanged(z10);
        }
    }

    public void setLoadAdParams(LoadAdParams loadAdParams) {
        this.f16389l = loadAdParams;
        T t10 = this.f16367a;
        if (t10 != 0) {
            ((UBVI) t10).setLoadAdParams(loadAdParams);
        }
    }

    @Override // com.qq.e.comm.pi.NFBI
    public void setNegativeFeedbackListener(NegativeFeedbackListener negativeFeedbackListener) {
        this.f16391n.setNegativeFeedbackListener(negativeFeedbackListener);
    }

    @Override // com.qq.e.comm.pi.IReward
    public void setRewardListener(ADRewardListener aDRewardListener) {
        this.f16391n.setAdRewardListener(aDRewardListener);
    }

    @Override // com.qq.e.comm.pi.IReward
    public void setServerSideVerificationOptions(ServerSideVerificationOptions serverSideVerificationOptions) {
        this.f16392o = serverSideVerificationOptions;
        T t10 = this.f16367a;
        if (t10 != 0) {
            ((UBVI) t10).setServerSideVerificationOptions(serverSideVerificationOptions);
        }
    }

    public UnifiedBannerAD(Activity activity, UnifiedBannerView unifiedBannerView, String str, String str2, UnifiedBannerADListener unifiedBannerADListener) {
        this(unifiedBannerView, unifiedBannerADListener);
        a(activity, str, str2);
    }

    @Override // com.qq.e.ads.AbstractAD
    public void a(Object obj) {
        UBVI ubvi = (UBVI) obj;
        int i10 = this.f16388k;
        this.f16388k = i10;
        T t10 = this.f16367a;
        if (t10 != 0) {
            ((UBVI) t10).setRefresh(i10);
        }
        LoadAdParams loadAdParams = this.f16389l;
        this.f16389l = loadAdParams;
        T t11 = this.f16367a;
        if (t11 != 0) {
            ((UBVI) t11).setLoadAdParams(loadAdParams);
        }
        ubvi.setServerSideVerificationOptions(this.f16392o);
        while (this.f16387j.getAndDecrement() > 0) {
            loadAD();
        }
    }

    private UnifiedBannerAD(UnifiedBannerView unifiedBannerView, UnifiedBannerADListener unifiedBannerADListener) {
        this.f16387j = new AtomicInteger(0);
        this.f16388k = 30;
        this.f16389l = null;
        this.f16386i = unifiedBannerADListener;
        this.f16390m = unifiedBannerView;
        this.f16391n = new ADListenerAdapter(unifiedBannerADListener);
    }
}
