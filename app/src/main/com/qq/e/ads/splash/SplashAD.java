package com.qq.e.ads.splash;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import com.qq.e.ads.LiteAbstractAD;
import com.qq.e.ads.rewardvideo.ServerSideVerificationOptions;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.listeners.ADRewardListener;
import com.qq.e.comm.pi.IReward;
import com.qq.e.comm.pi.NSPVI;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.util.AdErrorConvertor;
import com.qq.e.comm.util.GDTLogger;
import java.util.HashMap;

/* loaded from: classes3.dex */
public final class SplashAD extends LiteAbstractAD<NSPVI> implements IReward {

    /* renamed from: i */
    private volatile ViewGroup f16512i;

    /* renamed from: j */
    private volatile SplashADListener f16513j;

    /* renamed from: k */
    private volatile ADRewardListener f16514k;

    /* renamed from: l */
    private volatile LoadAdParams f16515l;

    /* renamed from: m */
    private volatile boolean f16516m;

    /* renamed from: n */
    private volatile boolean f16517n;

    /* renamed from: o */
    private volatile boolean f16518o;

    /* renamed from: p */
    private volatile int f16519p;

    /* renamed from: q */
    private volatile byte[] f16520q;

    /* renamed from: r */
    private volatile ServerSideVerificationOptions f16521r;

    /* renamed from: s */
    private int f16522s;

    public class ADListenerAdapter implements ADListener {
        private ADListenerAdapter() {
        }

        @Override // com.qq.e.comm.adevent.ADListener
        public void onADEvent(ADEvent aDEvent) {
            String str;
            if (SplashAD.this.f16513j == null) {
                GDTLogger.d("SplashADListener == null");
                return;
            }
            int type = aDEvent.getType();
            if (type == 112) {
                Long l10 = (Long) aDEvent.getParam(Long.class);
                if (l10 != null) {
                    SplashAD.this.f16513j.onADTick(l10.longValue());
                }
                return;
            }
            switch (type) {
                case 100:
                    Long l11 = (Long) aDEvent.getParam(Long.class);
                    if (l11 != null) {
                        SplashAD.this.f16513j.onADLoaded(l11.longValue());
                        break;
                    }
                    break;
                case 101:
                    Integer num = (Integer) aDEvent.getParam(Integer.class);
                    if (num != null) {
                        SplashAD.this.f16513j.onNoAD(AdErrorConvertor.formatErrorCode(num.intValue()));
                        break;
                    }
                    break;
                case 102:
                    SplashAD.this.f16513j.onADPresent();
                    break;
                case 103:
                    SplashAD.this.f16513j.onADExposure();
                    break;
                case 104:
                    if (SplashAD.this.f16514k != null && (str = (String) aDEvent.getParam(String.class)) != null) {
                        HashMap hashMap = new HashMap();
                        hashMap.put("transId", str);
                        SplashAD.this.f16514k.onReward(hashMap);
                        break;
                    }
                    break;
                case 105:
                    SplashAD.this.f16513j.onADClicked();
                    break;
                case 106:
                    SplashAD.this.f16513j.onADDismissed();
                    break;
            }
        }

        public /* synthetic */ ADListenerAdapter(SplashAD splashAD, AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    public SplashAD(Context context, String str, SplashADListener splashADListener) {
        this(context, str, splashADListener, 0);
    }

    public void fetchAdOnly() {
        a(false);
    }

    public void fetchFullScreenAdOnly() {
        a(true);
    }

    public String getAdNetWorkName() {
        T t10 = this.f16367a;
        if (t10 != 0) {
            return ((NSPVI) t10).getAdNetWorkName();
        }
        a("getAdNetWorkName");
        return null;
    }

    @Deprecated
    public Bitmap getZoomOutBitmap() {
        GDTLogger.e("注意！开屏V+功能已废弃，调用不生效");
        return null;
    }

    public void preLoad() {
        if (a()) {
            if (!b()) {
                this.f16516m = true;
                return;
            }
            T t10 = this.f16367a;
            if (t10 != 0) {
                ((NSPVI) t10).preload();
            } else {
                a("preLoad");
            }
        }
    }

    @Deprecated
    public void setAdLogoMargin(int i10, int i11) {
    }

    public void setDeveloperLogo(int i10) {
        T t10 = this.f16367a;
        if (t10 == 0) {
            this.f16519p = i10;
        } else {
            ((NSPVI) t10).setDeveloperLogo(i10);
        }
    }

    public void setLoadAdParams(LoadAdParams loadAdParams) {
        T t10 = this.f16367a;
        if (t10 != 0) {
            ((NSPVI) t10).setLoadAdParams(loadAdParams);
        } else {
            this.f16515l = loadAdParams;
        }
    }

    @Deprecated
    public void setPreloadView(View view) {
    }

    @Override // com.qq.e.comm.pi.IReward
    public void setRewardListener(ADRewardListener aDRewardListener) {
        this.f16514k = aDRewardListener;
    }

    @Override // com.qq.e.comm.pi.IReward
    public void setServerSideVerificationOptions(ServerSideVerificationOptions serverSideVerificationOptions) {
        this.f16521r = serverSideVerificationOptions;
        T t10 = this.f16367a;
        if (t10 != 0) {
            ((NSPVI) t10).setServerSideVerificationOptions(serverSideVerificationOptions);
        }
    }

    public void showAd(ViewGroup viewGroup) {
        b(viewGroup, false);
    }

    public void showFullScreenAd(ViewGroup viewGroup) {
        b(viewGroup, true);
    }

    @Deprecated
    public void zoomOutAnimationFinish() {
        GDTLogger.e("注意！开屏V+功能已废弃，调用不生效");
    }

    public SplashAD(Context context, String str, SplashADListener splashADListener, int i10) {
        this.f16516m = false;
        this.f16513j = splashADListener;
        this.f16522s = i10;
        a(context, str);
    }

    private void a(ViewGroup viewGroup, boolean z10) {
        if (viewGroup == null) {
            GDTLogger.e("传入参数有误：传入container参数为空");
            a(4001);
            return;
        }
        T t10 = this.f16367a;
        if (t10 == 0) {
            this.f16518o = z10;
            this.f16512i = viewGroup;
            return;
        }
        NSPVI nspvi = (NSPVI) t10;
        if (z10) {
            nspvi.fetchFullScreenAndShowIn(viewGroup);
        } else {
            nspvi.fetchAndShowIn(viewGroup);
        }
    }

    @Override // com.qq.e.ads.AbstractAD
    public void b(int i10) {
        if (this.f16513j != null) {
            this.f16513j.onNoAD(AdErrorConvertor.formatErrorCode(i10));
        }
    }

    public void setDeveloperLogo(byte[] bArr) {
        T t10 = this.f16367a;
        if (t10 == 0) {
            this.f16520q = bArr;
        } else {
            ((NSPVI) t10).setDeveloperLogo(bArr);
        }
    }

    public SplashAD(Context context, String str, SplashADListener splashADListener, int i10, String str2) {
        this.f16516m = false;
        this.f16513j = splashADListener;
        this.f16522s = i10;
        a(context, str, str2);
    }

    private void a(boolean z10) {
        if (a()) {
            if (!b()) {
                this.f16518o = z10;
                this.f16517n = true;
                return;
            }
            T t10 = this.f16367a;
            if (t10 == 0) {
                a("fetchAdInner");
                return;
            }
            NSPVI nspvi = (NSPVI) t10;
            if (z10) {
                nspvi.fetchFullScreenAdOnly();
            } else {
                nspvi.fetchAdOnly();
            }
        }
    }

    private void b(ViewGroup viewGroup, boolean z10) {
        if (viewGroup == null) {
            GDTLogger.e("传入参数错误，container参数为空");
            a(4001);
            return;
        }
        T t10 = this.f16367a;
        if (t10 == 0) {
            this.f16512i = viewGroup;
            return;
        }
        NSPVI nspvi = (NSPVI) t10;
        if (z10) {
            nspvi.showFullScreenAd(viewGroup);
        } else {
            nspvi.showAd(viewGroup);
        }
    }

    @Override // com.qq.e.ads.AbstractAD
    public Object a(Context context, POFactory pOFactory, String str, String str2, String str3) {
        return pOFactory.getNativeSplashAdView(context, str, str2, str3);
    }

    @Override // com.qq.e.ads.AbstractAD
    public void a(Object obj) {
        NSPVI nspvi = (NSPVI) obj;
        if (this.f16515l != null) {
            nspvi.setLoadAdParams(this.f16515l);
        }
        if (this.f16519p != 0) {
            nspvi.setDeveloperLogo(this.f16519p);
        }
        if (this.f16520q != null) {
            nspvi.setDeveloperLogo(this.f16520q);
        }
        nspvi.setFetchDelay(this.f16522s);
        nspvi.setAdListener(new ADListenerAdapter());
        nspvi.setServerSideVerificationOptions(this.f16521r);
        if (this.f16512i != null) {
            if (this.f16518o) {
                a(this.f16512i, true);
            } else {
                a(this.f16512i, false);
            }
        }
        if (this.f16516m) {
            nspvi.preload();
            this.f16516m = false;
        }
        if (this.f16517n) {
            if (this.f16518o) {
                nspvi.fetchFullScreenAdOnly();
            } else {
                nspvi.fetchAdOnly();
            }
            this.f16517n = false;
        }
    }
}
