package com.qq.e.ads.interstitial2;

import android.app.Activity;
import android.content.Context;
import com.qq.e.ads.LiteAbstractAD;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.rewardvideo.ServerSideVerificationOptions;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.listeners.NegativeFeedbackListener;
import com.qq.e.comm.pi.IReward;
import com.qq.e.comm.pi.NFBI;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.pi.UIADI;
import com.qq.e.comm.util.AdErrorConvertor;
import com.qq.e.comm.util.GDTLogger;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes3.dex */
public class UnifiedInterstitialAD extends LiteAbstractAD<UIADI> implements NFBI, IReward {

    /* renamed from: i */
    private AtomicInteger f16445i;

    /* renamed from: j */
    private AtomicInteger f16446j;

    /* renamed from: k */
    private volatile VideoOption f16447k;

    /* renamed from: l */
    private volatile int f16448l;

    /* renamed from: m */
    private volatile int f16449m;

    /* renamed from: n */
    private volatile LoadAdParams f16450n;

    /* renamed from: o */
    private UnifiedInterstitialADListener f16451o;

    /* renamed from: p */
    private ServerSideVerificationOptions f16452p;

    /* renamed from: q */
    private final ADListenerAdapter f16453q;

    public UnifiedInterstitialAD(Activity activity, String str, UnifiedInterstitialADListener unifiedInterstitialADListener) {
        this(activity, str, unifiedInterstitialADListener, null);
    }

    @Override // com.qq.e.ads.AbstractAD
    public /* bridge */ /* synthetic */ void a(Object obj) {
        c();
    }

    @Override // com.qq.e.ads.AbstractAD
    public void b(int i10) {
        UnifiedInterstitialADListener unifiedInterstitialADListener = this.f16451o;
        if (unifiedInterstitialADListener != null) {
            unifiedInterstitialADListener.onNoAD(AdErrorConvertor.formatErrorCode(i10));
        }
    }

    public void c() {
        setVideoOption(this.f16447k);
        setMinVideoDuration(this.f16448l);
        setMaxVideoDuration(this.f16449m);
        setLoadAdParams(this.f16450n);
        setServerSideVerificationOptions(this.f16452p);
        while (this.f16445i.getAndDecrement() > 0) {
            loadAD();
        }
        while (this.f16446j.getAndDecrement() > 0) {
            loadFullScreenAD();
        }
    }

    public void close() {
        T t10 = this.f16367a;
        if (t10 != 0) {
            ((UIADI) t10).close();
        }
    }

    public void destroy() {
        T t10 = this.f16367a;
        if (t10 != 0) {
            ((UIADI) t10).destroy();
        } else {
            a("destroy");
        }
    }

    public String getAdNetWorkName() {
        T t10 = this.f16367a;
        if (t10 != 0) {
            return ((UIADI) t10).getAdNetWorkName();
        }
        a("getAdNetWorkName");
        return null;
    }

    public int getAdPatternType() {
        T t10 = this.f16367a;
        if (t10 != 0) {
            return ((UIADI) t10).getAdPatternType();
        }
        a("getAdPatternType");
        return 0;
    }

    public int getVideoDuration() {
        T t10 = this.f16367a;
        if (t10 != 0) {
            return ((UIADI) t10).getVideoDuration();
        }
        a("getVideoDuration");
        return 0;
    }

    public void loadAD() {
        if (a()) {
            if (!b()) {
                this.f16445i.incrementAndGet();
                return;
            }
            T t10 = this.f16367a;
            if (t10 != 0) {
                ((UIADI) t10).loadAd();
            } else {
                a("loadAD");
            }
        }
    }

    public void loadFullScreenAD() {
        if (a()) {
            if (!b()) {
                this.f16446j.incrementAndGet();
                return;
            }
            T t10 = this.f16367a;
            if (t10 != 0) {
                ((UIADI) t10).loadFullScreenAD();
            } else {
                a("loadFullScreenAD");
            }
        }
    }

    public void setLoadAdParams(LoadAdParams loadAdParams) {
        this.f16450n = loadAdParams;
        T t10 = this.f16367a;
        if (t10 != 0) {
            ((UIADI) t10).setLoadAdParams(this.f16450n);
        }
    }

    public void setMaxVideoDuration(int i10) {
        this.f16449m = i10;
        if (this.f16449m > 0 && this.f16448l > this.f16449m) {
            GDTLogger.e("maxVideoDuration 设置值非法，不得小于minVideoDuration");
        }
        T t10 = this.f16367a;
        if (t10 != 0) {
            ((UIADI) t10).setMaxVideoDuration(i10);
        }
    }

    public void setMediaListener(UnifiedInterstitialMediaListener unifiedInterstitialMediaListener) {
        this.f16453q.setMediaListener(unifiedInterstitialMediaListener);
    }

    public void setMinVideoDuration(int i10) {
        this.f16448l = i10;
        if (this.f16449m > 0 && this.f16448l > this.f16449m) {
            GDTLogger.e("minVideoDuration 设置值非法，不得大于maxVideoDuration");
        }
        T t10 = this.f16367a;
        if (t10 != 0) {
            ((UIADI) t10).setMinVideoDuration(i10);
        }
    }

    @Override // com.qq.e.comm.pi.NFBI
    public void setNegativeFeedbackListener(NegativeFeedbackListener negativeFeedbackListener) {
        this.f16453q.setNegativeFeedbackListener(negativeFeedbackListener);
    }

    @Override // com.qq.e.comm.pi.IReward
    public void setRewardListener(com.qq.e.comm.listeners.ADRewardListener aDRewardListener) {
        this.f16453q.setAdRewardListener(aDRewardListener);
    }

    @Override // com.qq.e.comm.pi.IReward
    public void setServerSideVerificationOptions(ServerSideVerificationOptions serverSideVerificationOptions) {
        this.f16452p = serverSideVerificationOptions;
        T t10 = this.f16367a;
        if (t10 != 0) {
            ((UIADI) t10).setServerSideVerificationOptions(serverSideVerificationOptions);
        }
    }

    public void setVideoOption(VideoOption videoOption) {
        this.f16447k = videoOption;
        T t10 = this.f16367a;
        if (t10 != 0) {
            ((UIADI) t10).setVideoOption(videoOption);
        }
    }

    public void show() {
        T t10 = this.f16367a;
        if (t10 != 0) {
            ((UIADI) t10).show();
        } else {
            a("show");
        }
    }

    public void showFullScreenAD(Activity activity) {
        T t10 = this.f16367a;
        if (t10 != 0) {
            ((UIADI) t10).showFullScreenAD(activity);
        } else {
            a("showFullScreenAD");
        }
    }

    public UnifiedInterstitialAD(Activity activity, String str, UnifiedInterstitialADListener unifiedInterstitialADListener, Map map) {
        this.f16445i = new AtomicInteger(0);
        this.f16446j = new AtomicInteger(0);
        this.f16451o = unifiedInterstitialADListener;
        this.f16453q = new ADListenerAdapter(unifiedInterstitialADListener);
        a(activity, str);
    }

    @Override // com.qq.e.ads.AbstractAD
    public Object a(Context context, POFactory pOFactory, String str, String str2, String str3) {
        return pOFactory.getUnifiedInterstitialADDelegate((Activity) context, str, str2, str3, this.f16453q);
    }

    public void show(Activity activity) {
        T t10 = this.f16367a;
        if (t10 != 0) {
            ((UIADI) t10).show(activity);
        } else {
            a("show");
        }
    }

    public UnifiedInterstitialAD(Activity activity, String str, UnifiedInterstitialADListener unifiedInterstitialADListener, Map map, String str2) {
        this.f16445i = new AtomicInteger(0);
        this.f16446j = new AtomicInteger(0);
        this.f16451o = unifiedInterstitialADListener;
        this.f16453q = new ADListenerAdapter(unifiedInterstitialADListener);
        a(activity, str, str2);
    }
}
