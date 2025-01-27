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

/* loaded from: classes4.dex */
public final class SplashAD extends LiteAbstractAD<NSPVI> implements IReward {

    /* renamed from: g */
    private volatile ViewGroup f23979g;

    /* renamed from: h */
    private volatile SplashADListener f23980h;

    /* renamed from: i */
    private volatile ADRewardListener f23981i;

    /* renamed from: j */
    private volatile LoadAdParams f23982j;
    private volatile boolean k;
    private volatile boolean l;
    private volatile boolean m;
    private volatile int n;
    private volatile byte[] o;
    private volatile ServerSideVerificationOptions p;
    private int q;

    private class ADListenerAdapter implements ADListener {
        private ADListenerAdapter() {
        }

        /* synthetic */ ADListenerAdapter(SplashAD splashAD, AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.qq.e.comm.adevent.ADListener
        public void onADEvent(ADEvent aDEvent) {
            String str;
            if (SplashAD.this.f23980h == null) {
                GDTLogger.d("SplashADListener == null");
                return;
            }
            int type = aDEvent.getType();
            switch (type) {
                case 100:
                    Long l = (Long) aDEvent.getParam(Long.class);
                    if (l != null) {
                        SplashAD.this.f23980h.onADLoaded(l.longValue());
                        break;
                    }
                    break;
                case 101:
                    Integer num = (Integer) aDEvent.getParam(Integer.class);
                    if (num != null) {
                        SplashAD.this.f23980h.onNoAD(AdErrorConvertor.formatErrorCode(num.intValue()));
                        break;
                    }
                    break;
                case 102:
                    SplashAD.this.f23980h.onADPresent();
                    break;
                case 103:
                    SplashAD.this.f23980h.onADExposure();
                    break;
                case 104:
                    if (SplashAD.this.f23981i != null && (str = (String) aDEvent.getParam(String.class)) != null) {
                        HashMap hashMap = new HashMap();
                        hashMap.put(ServerSideVerificationOptions.TRANS_ID, str);
                        SplashAD.this.f23981i.onReward(hashMap);
                        break;
                    }
                    break;
                case 105:
                    SplashAD.this.f23980h.onADClicked();
                    break;
                case 106:
                    SplashAD.this.f23980h.onADDismissed();
                    break;
                default:
                    switch (type) {
                        case 112:
                            Long l2 = (Long) aDEvent.getParam(Long.class);
                            if (l2 != null) {
                                SplashAD.this.f23980h.onADTick(l2.longValue());
                                break;
                            }
                            break;
                        case 113:
                            if (SplashAD.this.f23980h instanceof SplashADZoomOutListener) {
                                ((SplashADZoomOutListener) SplashAD.this.f23980h).onZoomOut();
                                break;
                            }
                            break;
                        case 114:
                            if (SplashAD.this.f23980h instanceof SplashADZoomOutListener) {
                                ((SplashADZoomOutListener) SplashAD.this.f23980h).onZoomOutPlayFinish();
                                break;
                            }
                            break;
                    }
            }
        }
    }

    public SplashAD(Context context, String str, SplashADListener splashADListener) {
        this(context, str, splashADListener, 0);
    }

    public SplashAD(Context context, String str, SplashADListener splashADListener, int i2) {
        this.k = false;
        this.f23980h = splashADListener;
        this.q = i2;
        a(context, str);
    }

    public SplashAD(Context context, String str, SplashADListener splashADListener, int i2, String str2) {
        this.k = false;
        this.f23980h = splashADListener;
        this.q = i2;
        a(context, str, str2);
    }

    private void a(ViewGroup viewGroup, boolean z) {
        if (viewGroup == null) {
            GDTLogger.e("传入参数有误：传入container参数为空");
            a(4001);
            return;
        }
        T t = this.f23859a;
        if (t == 0) {
            this.m = z;
            this.f23979g = viewGroup;
            return;
        }
        NSPVI nspvi = (NSPVI) t;
        if (z) {
            nspvi.fetchFullScreenAndShowIn(viewGroup);
        } else {
            nspvi.fetchAndShowIn(viewGroup);
        }
    }

    private void a(boolean z) {
        if (a()) {
            if (!b()) {
                this.m = z;
                this.l = true;
                return;
            }
            T t = this.f23859a;
            if (t == 0) {
                a("fetchAdInner");
                return;
            }
            NSPVI nspvi = (NSPVI) t;
            if (z) {
                nspvi.fetchFullScreenAdOnly();
            } else {
                nspvi.fetchAdOnly();
            }
        }
    }

    private void b(ViewGroup viewGroup, boolean z) {
        if (viewGroup == null) {
            GDTLogger.e("传入参数错误，container参数为空");
            a(4001);
            return;
        }
        T t = this.f23859a;
        if (t == 0) {
            this.f23979g = viewGroup;
            return;
        }
        NSPVI nspvi = (NSPVI) t;
        if (z) {
            nspvi.showFullScreenAd(viewGroup);
        } else {
            nspvi.showAd(viewGroup);
        }
    }

    @Override // com.qq.e.ads.AbstractAD
    protected Object a(Context context, POFactory pOFactory, String str, String str2, String str3) {
        return pOFactory.getNativeSplashAdView(context, str, str2, str3);
    }

    @Override // com.qq.e.ads.AbstractAD
    protected void b(int i2) {
        if (this.f23980h != null) {
            this.f23980h.onNoAD(AdErrorConvertor.formatErrorCode(i2));
        }
    }

    public void fetchAdOnly() {
        a(false);
    }

    public void fetchAndShowIn(ViewGroup viewGroup) {
        a(viewGroup, false);
    }

    public void fetchFullScreenAdOnly() {
        a(true);
    }

    public void fetchFullScreenAndShowIn(ViewGroup viewGroup) {
        a(viewGroup, true);
    }

    public String getAdNetWorkName() {
        T t = this.f23859a;
        if (t != 0) {
            return ((NSPVI) t).getAdNetWorkName();
        }
        a("getAdNetWorkName");
        return null;
    }

    public Bitmap getZoomOutBitmap() {
        T t = this.f23859a;
        if (t != 0) {
            return ((NSPVI) t).getZoomOutBitmap();
        }
        a("getZoomOutBitmap");
        return null;
    }

    public void preLoad() {
        if (a()) {
            if (!b()) {
                this.k = true;
                return;
            }
            T t = this.f23859a;
            if (t != 0) {
                ((NSPVI) t).preload();
            } else {
                a("preLoad");
            }
        }
    }

    @Deprecated
    public void setAdLogoMargin(int i2, int i3) {
    }

    public void setDeveloperLogo(int i2) {
        T t = this.f23859a;
        if (t == 0) {
            this.n = i2;
        } else {
            ((NSPVI) t).setDeveloperLogo(i2);
        }
    }

    public void setDeveloperLogo(byte[] bArr) {
        T t = this.f23859a;
        if (t == 0) {
            this.o = bArr;
        } else {
            ((NSPVI) t).setDeveloperLogo(bArr);
        }
    }

    public void setLoadAdParams(LoadAdParams loadAdParams) {
        T t = this.f23859a;
        if (t != 0) {
            ((NSPVI) t).setLoadAdParams(loadAdParams);
        } else {
            this.f23982j = loadAdParams;
        }
    }

    @Deprecated
    public void setPreloadView(View view) {
    }

    @Override // com.qq.e.comm.pi.IReward
    public void setRewardListener(ADRewardListener aDRewardListener) {
        this.f23981i = aDRewardListener;
    }

    @Override // com.qq.e.comm.pi.IReward
    public void setServerSideVerificationOptions(ServerSideVerificationOptions serverSideVerificationOptions) {
        this.p = serverSideVerificationOptions;
        T t = this.f23859a;
        if (t != 0) {
            ((NSPVI) t).setServerSideVerificationOptions(serverSideVerificationOptions);
        }
    }

    public void showAd(ViewGroup viewGroup) {
        b(viewGroup, false);
    }

    public void showFullScreenAd(ViewGroup viewGroup) {
        b(viewGroup, true);
    }

    public void zoomOutAnimationFinish() {
        T t = this.f23859a;
        if (t != 0) {
            ((NSPVI) t).zoomOutAnimationFinish();
        } else {
            a("zoomOutAnimationFinish");
        }
    }

    @Override // com.qq.e.ads.AbstractAD
    protected void a(Object obj) {
        NSPVI nspvi = (NSPVI) obj;
        if (this.f23982j != null) {
            nspvi.setLoadAdParams(this.f23982j);
        }
        if (this.n != 0) {
            nspvi.setDeveloperLogo(this.n);
        }
        if (this.o != null) {
            nspvi.setDeveloperLogo(this.o);
        }
        nspvi.setFetchDelay(this.q);
        nspvi.setAdListener(new ADListenerAdapter());
        nspvi.setServerSideVerificationOptions(this.p);
        if ((this.f23980h instanceof SplashADZoomOutListener) && ((SplashADZoomOutListener) this.f23980h).isSupportZoomOut()) {
            nspvi.setSupportZoomOut(true);
        }
        if (this.f23979g != null) {
            if (this.m) {
                fetchFullScreenAndShowIn(this.f23979g);
            } else {
                fetchAndShowIn(this.f23979g);
            }
        }
        if (this.k) {
            nspvi.preload();
            this.k = false;
        }
        if (this.l) {
            if (this.m) {
                nspvi.fetchFullScreenAdOnly();
            } else {
                nspvi.fetchAdOnly();
            }
            this.l = false;
        }
    }
}
