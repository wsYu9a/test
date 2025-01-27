package cn.vlion.ad.inland.ad.adapter;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.view.ViewGroup;
import cn.vlion.ad.inland.ad.reward.a;
import cn.vlion.ad.inland.base.a3;
import cn.vlion.ad.inland.base.adapter.BaseAdAdapter;
import cn.vlion.ad.inland.base.adapter.VlionLossBiddingReason;
import cn.vlion.ad.inland.base.b2;
import cn.vlion.ad.inland.base.b3;
import cn.vlion.ad.inland.base.b5;
import cn.vlion.ad.inland.base.bid.VlionBiddingActionListener;
import cn.vlion.ad.inland.base.bid.VlionBiddingActionRewardListener;
import cn.vlion.ad.inland.base.bid.VlionNativeActionListener;
import cn.vlion.ad.inland.base.f7;
import cn.vlion.ad.inland.base.i2;
import cn.vlion.ad.inland.base.i4;
import cn.vlion.ad.inland.base.init.VlionMediaInitCallback;
import cn.vlion.ad.inland.base.j;
import cn.vlion.ad.inland.base.j0;
import cn.vlion.ad.inland.base.j7;
import cn.vlion.ad.inland.base.javabean.VlionAdapterADConfig;
import cn.vlion.ad.inland.base.javabean.VlionAdapterInitConfig;
import cn.vlion.ad.inland.base.k2;
import cn.vlion.ad.inland.base.l1;
import cn.vlion.ad.inland.base.m2;
import cn.vlion.ad.inland.base.m4;
import cn.vlion.ad.inland.base.n1;
import cn.vlion.ad.inland.base.o2;
import cn.vlion.ad.inland.base.q0;
import cn.vlion.ad.inland.base.q1;
import cn.vlion.ad.inland.base.q6;
import cn.vlion.ad.inland.base.r4;
import cn.vlion.ad.inland.base.r6;
import cn.vlion.ad.inland.base.s3;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import cn.vlion.ad.inland.base.util.log.LogVlion;
import cn.vlion.ad.inland.base.v1;
import cn.vlion.ad.inland.base.v3;
import cn.vlion.ad.inland.base.y2;
import cn.vlion.ad.inland.base.y3;
import cn.vlion.ad.inland.base.z3;

/* loaded from: classes.dex */
public class VlionCustomAdapter extends BaseAdAdapter {
    private n1 vlionCustomBannerAd;
    private b2 vlionCustomDrawAd;
    private o2 vlionCustomFeedAd;
    private s3 vlionCustomInterstitialAd;
    private y3 vlionCustomNativeAd;
    private i4 vlionCustomRewardedVideoAd;
    private m4 vlionCustomSplashAd;

    @Override // cn.vlion.ad.inland.base.adapter.BaseAdAdapter
    public void destroy() {
        try {
            m4 m4Var = this.vlionCustomSplashAd;
            if (m4Var != null) {
                try {
                    r4 r4Var = m4Var.f3096c;
                    if (r4Var != null) {
                        r4Var.a();
                        m4Var.f3096c = null;
                    }
                } catch (Throwable th2) {
                    VlionSDkManager.getInstance().upLoadCatchException(th2);
                }
                this.vlionCustomSplashAd = null;
            }
            n1 n1Var = this.vlionCustomBannerAd;
            if (n1Var != null) {
                try {
                    q1 q1Var = n1Var.f3110a;
                    if (q1Var != null) {
                        try {
                            f7 f7Var = q1Var.f3309g;
                            if (f7Var != null) {
                                f7Var.a();
                                q1Var.f3309g = null;
                            }
                            v1 v1Var = q1Var.f3313k;
                            if (v1Var != null) {
                                v1Var.destroy();
                                q1Var.f3313k = null;
                            }
                            if (q1Var.f3306d != null) {
                                q1Var.f3306d = null;
                            }
                            if (q1Var.f3311i != null) {
                                q1Var.f3311i = null;
                            }
                            r6 r6Var = q1Var.f3312j;
                            if (r6Var != null) {
                                try {
                                    q6 q6Var = r6Var.f3358a;
                                    if (q6Var != null) {
                                        q6Var.cancel();
                                        r6Var.f3358a = null;
                                    }
                                } catch (Throwable th3) {
                                    VlionSDkManager.getInstance().upLoadCatchException(th3);
                                }
                                q1Var.f3312j = null;
                            }
                        } catch (Throwable th4) {
                            VlionSDkManager.getInstance().upLoadCatchException(th4);
                        }
                        n1Var.f3110a = null;
                    }
                } catch (Throwable th5) {
                    VlionSDkManager.getInstance().upLoadCatchException(th5);
                }
                this.vlionCustomBannerAd = null;
            }
            s3 s3Var = this.vlionCustomInterstitialAd;
            if (s3Var != null) {
                s3Var.a();
                this.vlionCustomInterstitialAd = null;
            }
            o2 o2Var = this.vlionCustomFeedAd;
            if (o2Var != null) {
                try {
                    a3 a3Var = o2Var.f3244c;
                    if (a3Var != null) {
                        try {
                            f7 f7Var2 = a3Var.f2596f;
                            if (f7Var2 != null) {
                                f7Var2.a();
                                a3Var.f2596f = null;
                            }
                            y2 y2Var = a3Var.f2597g;
                            if (y2Var != null) {
                                y2Var.post(new b3(a3Var));
                            }
                            if (a3Var.f2598h != null) {
                                a3Var.f2598h = null;
                            }
                        } catch (Throwable th6) {
                            VlionSDkManager.getInstance().upLoadCatchException(th6);
                        }
                        o2Var.f3244c = null;
                    }
                } catch (Throwable th7) {
                    VlionSDkManager.getInstance().upLoadCatchException(th7);
                }
                this.vlionCustomFeedAd = null;
            }
            i4 i4Var = this.vlionCustomRewardedVideoAd;
            if (i4Var != null) {
                try {
                    if (i4Var.f2947b != null) {
                        i4Var.f2947b = null;
                    }
                    a aVar = i4Var.f2948c;
                    if (aVar != null) {
                        try {
                            if (aVar.f2360f != null) {
                                aVar.f2360f = null;
                            }
                            b5 b5Var = aVar.f2363i;
                            if (b5Var != null) {
                                try {
                                    b5Var.f2672d = true;
                                    b5Var.f2669a = 1;
                                    try {
                                        if (j7.f2999a != null) {
                                            LogVlion.e("WriteFileUtils onDestroy: ");
                                            j7.f2999a.shutdownNow();
                                            j7.f2999a = null;
                                        }
                                    } catch (Throwable th8) {
                                        VlionSDkManager.getInstance().upLoadCatchException(th8);
                                    }
                                    b5Var.f2671c = null;
                                } catch (Throwable th9) {
                                    VlionSDkManager.getInstance().upLoadCatchException(th9);
                                }
                                aVar.f2363i = null;
                            }
                        } catch (Throwable th10) {
                            VlionSDkManager.getInstance().upLoadCatchException(th10);
                        }
                        i4Var.f2948c = null;
                    }
                } catch (Throwable th11) {
                    VlionSDkManager.getInstance().upLoadCatchException(th11);
                }
                this.vlionCustomRewardedVideoAd = null;
            }
            y3 y3Var = this.vlionCustomNativeAd;
            if (y3Var != null) {
                try {
                    z3 z3Var = y3Var.f3530c;
                    if (z3Var != null) {
                        try {
                            q0 q0Var = z3Var.f3546g;
                            if (q0Var != null) {
                                q0Var.a();
                                z3Var.f3546g = null;
                            }
                        } catch (Throwable th12) {
                            VlionSDkManager.getInstance().upLoadCatchException(th12);
                        }
                        y3Var.f3530c = null;
                    }
                } catch (Throwable th13) {
                    VlionSDkManager.getInstance().upLoadCatchException(th13);
                }
                this.vlionCustomNativeAd = null;
            }
            b2 b2Var = this.vlionCustomDrawAd;
            if (b2Var != null) {
                try {
                    k2 k2Var = b2Var.f2642c;
                    if (k2Var != null) {
                        try {
                            f7 f7Var3 = k2Var.f3011e;
                            if (f7Var3 != null) {
                                f7Var3.a();
                                k2Var.f3011e = null;
                            }
                            i2 i2Var = k2Var.f3012f;
                            if (i2Var != null) {
                                i2Var.post(new m2(k2Var));
                            }
                            if (k2Var.f3013g != null) {
                                k2Var.f3013g = null;
                            }
                        } catch (Throwable th14) {
                            VlionSDkManager.getInstance().upLoadCatchException(th14);
                        }
                        b2Var.f2642c = null;
                    }
                } catch (Throwable th15) {
                    VlionSDkManager.getInstance().upLoadCatchException(th15);
                }
                this.vlionCustomDrawAd = null;
            }
        } catch (Throwable th16) {
            VlionSDkManager.getInstance().upLoadCatchException(th16);
        }
    }

    @Override // cn.vlion.ad.inland.base.adapter.BaseAdAdapter
    public String getNetworkName() {
        return "";
    }

    @Override // cn.vlion.ad.inland.base.adapter.BaseAdAdapter
    public void initialize(Application application, VlionAdapterInitConfig vlionAdapterInitConfig, VlionMediaInitCallback vlionMediaInitCallback) {
        if (vlionMediaInitCallback != null) {
            vlionMediaInitCallback.onSuccess();
        }
    }

    @Override // cn.vlion.ad.inland.base.adapter.BaseAdAdapter
    public void loadBannerAD(Activity activity, VlionAdapterADConfig vlionAdapterADConfig) {
        try {
            n1 n1Var = new n1(activity, vlionAdapterADConfig);
            this.vlionCustomBannerAd = n1Var;
            n1Var.a(this.vlionBiddingListener);
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.adapter.BaseAdAdapter
    public void loadDrawAD(Context context, VlionAdapterADConfig vlionAdapterADConfig) {
        try {
            b2 b2Var = new b2(context, vlionAdapterADConfig);
            this.vlionCustomDrawAd = b2Var;
            b2Var.a(this.vlionBiddingListener, this.vlionNativesAdVideoListener);
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.adapter.BaseAdAdapter
    public void loadFeedAD(Context context, VlionAdapterADConfig vlionAdapterADConfig) {
        try {
            o2 o2Var = new o2(context, vlionAdapterADConfig);
            this.vlionCustomFeedAd = o2Var;
            o2Var.a(this.vlionBiddingListener);
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.adapter.BaseAdAdapter
    public void loadInterstitialAD(Activity activity, VlionAdapterADConfig vlionAdapterADConfig) {
        try {
            s3 s3Var = new s3(activity, vlionAdapterADConfig);
            this.vlionCustomInterstitialAd = s3Var;
            s3Var.a(this.vlionBiddingListener);
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.adapter.BaseAdAdapter
    public void loadNativeAD(Context context, VlionAdapterADConfig vlionAdapterADConfig) {
        try {
            y3 y3Var = new y3(context, vlionAdapterADConfig);
            this.vlionCustomNativeAd = y3Var;
            y3Var.a(this.vlionBiddingListener);
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.adapter.BaseAdAdapter
    public void loadRewardVideoAD(Context context, VlionAdapterADConfig vlionAdapterADConfig) {
        try {
            i4 i4Var = new i4(context, vlionAdapterADConfig);
            this.vlionCustomRewardedVideoAd = i4Var;
            i4Var.a(this.vlionBiddingListener);
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.adapter.BaseAdAdapter
    public void loadSplashAD(Context context, VlionAdapterADConfig vlionAdapterADConfig) {
        try {
            m4 m4Var = new m4(context, vlionAdapterADConfig);
            this.vlionCustomSplashAd = m4Var;
            m4Var.a(this.vlionBiddingListener);
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.adapter.BaseAdAdapter
    public void notifyFailPrice(VlionLossBiddingReason vlionLossBiddingReason) {
        if (vlionLossBiddingReason != null) {
            StringBuilder a10 = l1.a("VlionCustomAdapter notifyFailPrice: ");
            a10.append(vlionLossBiddingReason.toString());
            LogVlion.e(a10.toString());
        }
    }

    @Override // cn.vlion.ad.inland.base.adapter.BaseAdAdapter
    public void notifyWinPrice(boolean z10) {
        try {
            n1 n1Var = this.vlionCustomBannerAd;
            if (n1Var != null) {
                try {
                    q1 q1Var = n1Var.f3110a;
                    if (q1Var != null) {
                        q1Var.a(z10);
                        return;
                    }
                    return;
                } catch (Throwable th2) {
                    VlionSDkManager.getInstance().upLoadCatchException(th2);
                    return;
                }
            }
            o2 o2Var = this.vlionCustomFeedAd;
            if (o2Var != null) {
                o2Var.a(z10);
                return;
            }
            s3 s3Var = this.vlionCustomInterstitialAd;
            if (s3Var != null) {
                try {
                    v3 v3Var = s3Var.f3363c;
                    if (v3Var != null) {
                        v3Var.a(z10);
                        return;
                    }
                    return;
                } catch (Throwable th3) {
                    VlionSDkManager.getInstance().upLoadCatchException(th3);
                    return;
                }
            }
            i4 i4Var = this.vlionCustomRewardedVideoAd;
            if (i4Var != null) {
                i4Var.a(z10);
                return;
            }
            m4 m4Var = this.vlionCustomSplashAd;
            if (m4Var == null) {
                b2 b2Var = this.vlionCustomDrawAd;
                if (b2Var != null) {
                    b2Var.a(z10);
                    return;
                }
                return;
            }
            try {
                r4 r4Var = m4Var.f3096c;
                if (r4Var != null) {
                    r4Var.a(z10);
                    return;
                }
                return;
            } catch (Throwable th4) {
                VlionSDkManager.getInstance().upLoadCatchException(th4);
                return;
            }
        } catch (Throwable th5) {
            VlionSDkManager.getInstance().upLoadCatchException(th5);
        }
        VlionSDkManager.getInstance().upLoadCatchException(th5);
    }

    @Override // cn.vlion.ad.inland.base.adapter.BaseAdAdapter
    public void setVlionBiddingActionListener(VlionBiddingActionListener vlionBiddingActionListener) {
        n1 n1Var;
        k2 k2Var;
        super.setVlionBiddingActionListener(vlionBiddingActionListener);
        try {
            n1Var = this.vlionCustomBannerAd;
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
        if (n1Var != null) {
            q1 q1Var = n1Var.f3110a;
            if (q1Var != null) {
                q1Var.f3308f = vlionBiddingActionListener;
                return;
            }
            return;
        }
        o2 o2Var = this.vlionCustomFeedAd;
        if (o2Var != null) {
            a3 a3Var = o2Var.f3244c;
            if (a3Var != null) {
                a3Var.f2594d = vlionBiddingActionListener;
                return;
            }
            return;
        }
        s3 s3Var = this.vlionCustomInterstitialAd;
        if (s3Var != null) {
            try {
                s3Var.f3364d = vlionBiddingActionListener;
                v3 v3Var = s3Var.f3363c;
                if (v3Var != null) {
                    v3Var.f3456d = vlionBiddingActionListener;
                    return;
                }
                return;
            } catch (Throwable th3) {
                VlionSDkManager.getInstance().upLoadCatchException(th3);
                return;
            }
        }
        m4 m4Var = this.vlionCustomSplashAd;
        if (m4Var == null) {
            b2 b2Var = this.vlionCustomDrawAd;
            if (b2Var == null || (k2Var = b2Var.f2642c) == null) {
                return;
            }
            k2Var.f3021o = vlionBiddingActionListener;
            return;
        }
        try {
            r4 r4Var = m4Var.f3096c;
            if (r4Var != null) {
                r4Var.f3353i = vlionBiddingActionListener;
                return;
            }
            return;
        } catch (Throwable th4) {
            VlionSDkManager.getInstance().upLoadCatchException(th4);
            return;
        }
        VlionSDkManager.getInstance().upLoadCatchException(th2);
    }

    @Override // cn.vlion.ad.inland.base.adapter.BaseAdAdapter
    public void setVlionBiddingActionRewardListener(VlionBiddingActionRewardListener vlionBiddingActionRewardListener) {
        a aVar;
        super.setVlionBiddingActionRewardListener(vlionBiddingActionRewardListener);
        i4 i4Var = this.vlionCustomRewardedVideoAd;
        if (i4Var == null || (aVar = i4Var.f2948c) == null) {
            return;
        }
        aVar.f2358d = vlionBiddingActionRewardListener;
    }

    @Override // cn.vlion.ad.inland.base.adapter.BaseAdAdapter
    public void setVlionNativeActionListener(VlionNativeActionListener vlionNativeActionListener) {
        z3 z3Var;
        super.setVlionNativeActionListener(vlionNativeActionListener);
        y3 y3Var = this.vlionCustomNativeAd;
        if (y3Var == null || (z3Var = y3Var.f3530c) == null) {
            return;
        }
        z3Var.f3547h = vlionNativeActionListener;
    }

    @Override // cn.vlion.ad.inland.base.adapter.BaseAdAdapter
    public void showInterstitialAD(Activity activity) {
        try {
            s3 s3Var = this.vlionCustomInterstitialAd;
            if (s3Var != null) {
                s3Var.a(activity);
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.adapter.BaseAdAdapter
    public void showRewardVideoAD(Activity activity) {
        try {
            i4 i4Var = this.vlionCustomRewardedVideoAd;
            if (i4Var != null) {
                try {
                    a aVar = i4Var.f2948c;
                    if (aVar != null) {
                        aVar.a(activity);
                    }
                } catch (Throwable th2) {
                    VlionSDkManager.getInstance().upLoadCatchException(th2);
                }
            }
        } catch (Throwable th3) {
            VlionSDkManager.getInstance().upLoadCatchException(th3);
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x0029 -> B:4:0x0039). Please report as a decompilation issue!!! */
    @Override // cn.vlion.ad.inland.base.adapter.BaseAdAdapter
    public void showSplashAD(ViewGroup viewGroup) {
        j jVar;
        try {
            m4 m4Var = this.vlionCustomSplashAd;
            if (m4Var != null) {
                try {
                    r4 r4Var = m4Var.f3096c;
                    if (r4Var != null) {
                        try {
                            if (r4Var.f3349e != null && viewGroup != null && (jVar = r4Var.f3350f) != null) {
                                j0.a(jVar);
                                viewGroup.removeAllViews();
                                viewGroup.addView(r4Var.f3350f, -1, -1);
                            }
                        } catch (Throwable th2) {
                            VlionSDkManager.getInstance().upLoadCatchException(th2);
                        }
                    }
                } catch (Throwable th3) {
                    VlionSDkManager.getInstance().upLoadCatchException(th3);
                }
            }
        } catch (Throwable th4) {
            VlionSDkManager.getInstance().upLoadCatchException(th4);
        }
    }
}
