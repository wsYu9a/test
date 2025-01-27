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

/* loaded from: classes4.dex */
public class UnifiedInterstitialAD extends LiteAbstractAD<UIADI> implements NFBI, IReward {

    /* renamed from: g */
    private AtomicInteger f23934g;

    /* renamed from: h */
    private AtomicInteger f23935h;

    /* renamed from: i */
    private volatile VideoOption f23936i;

    /* renamed from: j */
    private volatile int f23937j;
    private volatile int k;
    private volatile LoadAdParams l;
    private UnifiedInterstitialADListener m;
    private ServerSideVerificationOptions n;
    private final ADListenerAdapter o;

    public UnifiedInterstitialAD(Activity activity, String str, UnifiedInterstitialADListener unifiedInterstitialADListener) {
        this(activity, str, unifiedInterstitialADListener, null);
    }

    public UnifiedInterstitialAD(Activity activity, String str, UnifiedInterstitialADListener unifiedInterstitialADListener, Map map) {
        this.f23934g = new AtomicInteger(0);
        this.f23935h = new AtomicInteger(0);
        this.m = unifiedInterstitialADListener;
        this.o = new ADListenerAdapter(unifiedInterstitialADListener);
        a(activity, str);
    }

    public UnifiedInterstitialAD(Activity activity, String str, UnifiedInterstitialADListener unifiedInterstitialADListener, Map map, String str2) {
        this.f23934g = new AtomicInteger(0);
        this.f23935h = new AtomicInteger(0);
        this.m = unifiedInterstitialADListener;
        this.o = new ADListenerAdapter(unifiedInterstitialADListener);
        a(activity, str, str2);
    }

    @Override // com.qq.e.ads.AbstractAD
    protected Object a(Context context, POFactory pOFactory, String str, String str2, String str3) {
        return pOFactory.getUnifiedInterstitialADDelegate((Activity) context, str, str2, str3, this.o);
    }

    @Override // com.qq.e.ads.AbstractAD
    protected /* bridge */ /* synthetic */ void a(Object obj) {
        c();
    }

    @Override // com.qq.e.ads.AbstractAD
    protected void b(int i2) {
        UnifiedInterstitialADListener unifiedInterstitialADListener = this.m;
        if (unifiedInterstitialADListener != null) {
            unifiedInterstitialADListener.onNoAD(AdErrorConvertor.formatErrorCode(i2));
        }
    }

    protected void c() {
        setVideoOption(this.f23936i);
        setMinVideoDuration(this.f23937j);
        setMaxVideoDuration(this.k);
        setLoadAdParams(this.l);
        setServerSideVerificationOptions(this.n);
        while (this.f23934g.getAndDecrement() > 0) {
            loadAD();
        }
        while (this.f23935h.getAndDecrement() > 0) {
            loadFullScreenAD();
        }
    }

    public void close() {
        T t = this.f23859a;
        if (t != 0) {
            ((UIADI) t).close();
        }
    }

    public void destroy() {
        T t = this.f23859a;
        if (t != 0) {
            ((UIADI) t).destroy();
        } else {
            a("destroy");
        }
    }

    public String getAdNetWorkName() {
        T t = this.f23859a;
        if (t != 0) {
            return ((UIADI) t).getAdNetWorkName();
        }
        a("getAdNetWorkName");
        return null;
    }

    public int getAdPatternType() {
        T t = this.f23859a;
        if (t != 0) {
            return ((UIADI) t).getAdPatternType();
        }
        a("getAdPatternType");
        return 0;
    }

    public int getVideoDuration() {
        T t = this.f23859a;
        if (t != 0) {
            return ((UIADI) t).getVideoDuration();
        }
        a("getVideoDuration");
        return 0;
    }

    public void loadAD() {
        if (a()) {
            if (!b()) {
                this.f23934g.incrementAndGet();
                return;
            }
            T t = this.f23859a;
            if (t != 0) {
                ((UIADI) t).loadAd();
            } else {
                a("loadAD");
            }
        }
    }

    public void loadFullScreenAD() {
        if (a()) {
            if (!b()) {
                this.f23935h.incrementAndGet();
                return;
            }
            T t = this.f23859a;
            if (t != 0) {
                ((UIADI) t).loadFullScreenAD();
            } else {
                a("loadFullScreenAD");
            }
        }
    }

    public void setLoadAdParams(LoadAdParams loadAdParams) {
        this.l = loadAdParams;
        T t = this.f23859a;
        if (t != 0) {
            ((UIADI) t).setLoadAdParams(this.l);
        }
    }

    public void setMaxVideoDuration(int i2) {
        this.k = i2;
        if (this.k > 0 && this.f23937j > this.k) {
            GDTLogger.e("maxVideoDuration 设置值非法，不得小于minVideoDuration");
        }
        T t = this.f23859a;
        if (t != 0) {
            ((UIADI) t).setMaxVideoDuration(i2);
        }
    }

    public void setMediaListener(UnifiedInterstitialMediaListener unifiedInterstitialMediaListener) {
        this.o.setMediaListener(unifiedInterstitialMediaListener);
    }

    public void setMinVideoDuration(int i2) {
        this.f23937j = i2;
        if (this.k > 0 && this.f23937j > this.k) {
            GDTLogger.e("minVideoDuration 设置值非法，不得大于maxVideoDuration");
        }
        T t = this.f23859a;
        if (t != 0) {
            ((UIADI) t).setMinVideoDuration(i2);
        }
    }

    @Override // com.qq.e.comm.pi.NFBI
    public void setNegativeFeedbackListener(NegativeFeedbackListener negativeFeedbackListener) {
        this.o.setNegativeFeedbackListener(negativeFeedbackListener);
    }

    @Override // com.qq.e.comm.pi.IReward
    public void setRewardListener(com.qq.e.comm.listeners.ADRewardListener aDRewardListener) {
        this.o.setAdRewardListener(aDRewardListener);
    }

    @Override // com.qq.e.comm.pi.IReward
    public void setServerSideVerificationOptions(ServerSideVerificationOptions serverSideVerificationOptions) {
        this.n = serverSideVerificationOptions;
        T t = this.f23859a;
        if (t != 0) {
            ((UIADI) t).setServerSideVerificationOptions(serverSideVerificationOptions);
        }
    }

    public void setVideoOption(VideoOption videoOption) {
        this.f23936i = videoOption;
        T t = this.f23859a;
        if (t != 0) {
            ((UIADI) t).setVideoOption(videoOption);
        }
    }

    public void show() {
        T t = this.f23859a;
        if (t != 0) {
            ((UIADI) t).show();
        } else {
            a("show");
        }
    }

    public void show(Activity activity) {
        T t = this.f23859a;
        if (t != 0) {
            ((UIADI) t).show(activity);
        } else {
            a("show");
        }
    }

    public void showAsPopupWindow() {
        T t = this.f23859a;
        if (t != 0) {
            ((UIADI) t).showAsPopupWindow();
        } else {
            a("showAsPopupWindow");
        }
    }

    public void showAsPopupWindow(Activity activity) {
        T t = this.f23859a;
        if (t != 0) {
            ((UIADI) t).showAsPopupWindow(activity);
        } else {
            a("showAsPopupWindow");
        }
    }

    public void showFullScreenAD(Activity activity) {
        T t = this.f23859a;
        if (t != 0) {
            ((UIADI) t).showFullScreenAD(activity);
        } else {
            a("showFullScreenAD");
        }
    }
}
