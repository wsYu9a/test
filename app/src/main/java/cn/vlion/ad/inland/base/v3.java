package cn.vlion.ad.inland.base;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.widget.FrameLayout;
import cn.vlion.ad.inland.ad.config.VlionCustomAdActiveType$VlionCustomTarget;
import cn.vlion.ad.inland.ad.interstitial.VlionCustomInterstitialActivity;
import cn.vlion.ad.inland.ad.javabean.VlionCustomParseAdData;
import cn.vlion.ad.inland.base.bid.VlionBiddingActionListener;
import cn.vlion.ad.inland.base.javabean.VlionADClickType;
import cn.vlion.ad.inland.base.javabean.VlionAdapterADConfig;
import cn.vlion.ad.inland.base.util.VlionAdStrategyUtils;
import cn.vlion.ad.inland.base.util.event.VlionADEventManager;
import cn.vlion.ad.inland.base.util.handle.VlionBaseParameterReplace;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import cn.vlion.ad.inland.base.util.log.LogVlion;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public final class v3 extends e {

    /* renamed from: c */
    public Context f3455c;

    /* renamed from: d */
    public VlionBiddingActionListener f3456d;

    /* renamed from: e */
    public f7 f3457e;

    /* renamed from: f */
    public VlionAdapterADConfig f3458f;

    /* renamed from: g */
    public VlionCustomParseAdData f3459g;

    /* renamed from: h */
    public boolean f3460h = false;

    /* renamed from: i */
    public int f3461i;

    /* renamed from: j */
    public int f3462j;

    /* renamed from: k */
    public VlionBaseParameterReplace f3463k;

    /* renamed from: l */
    public long f3464l;

    /* renamed from: m */
    public long f3465m;

    public v3(Context context, VlionAdapterADConfig vlionAdapterADConfig) {
        this.f3455c = context;
        this.f3458f = vlionAdapterADConfig;
    }

    public final void a(Context context) {
        VlionSDkManager vlionSDkManager;
        Throwable th2;
        FrameLayout frameLayout;
        try {
            if (context == null) {
                LogVlion.e("showInterstitial  context is null");
                VlionSDkManager.getInstance().upLoadCatchException(new Throwable("showInterstitial  context is null"));
                return;
            }
            f7 f7Var = this.f3457e;
            if (f7Var != null) {
                int i10 = f7Var.f2805c;
                if (i10 == 2) {
                    frameLayout = f7Var.f2808f;
                } else if (i10 == 3) {
                    frameLayout = f7Var.f2806d;
                } else {
                    g0 g0Var = f7Var.f2803a;
                    if (g0Var != null) {
                        g0Var.a(i1.f2913c);
                    }
                    frameLayout = null;
                }
                if (frameLayout != null) {
                    if (this.f3458f != null) {
                        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                        layoutParams.gravity = 17;
                        if (1 == this.f3458f.getScreenType()) {
                            VlionCustomParseAdData vlionCustomParseAdData = this.f3459g;
                            if (vlionCustomParseAdData != null) {
                                int width = vlionCustomParseAdData.getWidth();
                                int height = this.f3459g.getHeight();
                                LogVlion.e("showInterstitial mWidth=" + width + " mHeight=" + height);
                                layoutParams.width = width;
                                layoutParams.height = height;
                            }
                            frameLayout.setLayoutParams(layoutParams);
                        }
                    }
                    VlionAdapterADConfig vlionAdapterADConfig = this.f3458f;
                    VlionCustomParseAdData vlionCustomParseAdData2 = this.f3459g;
                    a aVar = new a();
                    j1 j1Var = VlionCustomInterstitialActivity.F;
                    try {
                        VlionCustomInterstitialActivity.G = new WeakReference<>(frameLayout);
                        VlionCustomInterstitialActivity.F = aVar;
                        VlionCustomInterstitialActivity.I = vlionCustomParseAdData2;
                        VlionCustomInterstitialActivity.J = vlionAdapterADConfig;
                        Intent intent = new Intent(context, (Class<?>) VlionCustomInterstitialActivity.class);
                        intent.addFlags(268435456);
                        context.startActivity(intent);
                        return;
                    } catch (Throwable th3) {
                        VlionSDkManager.getInstance().upLoadCatchException(th3);
                        return;
                    }
                }
                LogVlion.e("showInterstitial  adview is null");
                vlionSDkManager = VlionSDkManager.getInstance();
                th2 = new Throwable("showInterstitial  adview is null");
            } else {
                LogVlion.e("showInterstitial  vlionViewManger is null");
                vlionSDkManager = VlionSDkManager.getInstance();
                th2 = new Throwable("showInterstitial  vlionViewManger is null");
            }
            vlionSDkManager.upLoadCatchException(th2);
        } catch (Throwable th4) {
            VlionSDkManager.getInstance().upLoadCatchException(th4);
        }
    }

    public final void a(boolean z10) {
        try {
            VlionCustomParseAdData vlionCustomParseAdData = this.f3459g;
            if (vlionCustomParseAdData == null) {
                VlionBiddingActionListener vlionBiddingActionListener = this.f3456d;
                if (vlionBiddingActionListener != null) {
                    i1 i1Var = i1.f2919i;
                    vlionBiddingActionListener.onAdRenderFailure(i1Var.f2920a, i1Var.f2921b);
                    return;
                }
                return;
            }
            vlionCustomParseAdData.setSingleBid(z10);
            VlionCustomParseAdData vlionCustomParseAdData2 = this.f3459g;
            try {
                f7 f7Var = this.f3457e;
                if (f7Var != null) {
                    f7Var.a();
                    this.f3457e = null;
                }
                f7 f7Var2 = new f7(this.f3455c, new u3(this));
                this.f3457e = f7Var2;
                f7Var2.a(vlionCustomParseAdData2, this.f3458f);
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        } catch (Throwable th3) {
            VlionSDkManager.getInstance().upLoadCatchException(th3);
        }
    }

    public class a implements j1 {
        public a() {
        }

        public final void a(VlionADClickType vlionADClickType) {
            try {
                VlionAdapterADConfig vlionAdapterADConfig = v3.this.f3458f;
                if (vlionAdapterADConfig != null) {
                    vlionAdapterADConfig.setVlionADClickType(vlionADClickType);
                }
                if (!v3.this.f2719b) {
                    if (vlionADClickType.getVlionBaseParameterReplace() != null) {
                        if (v3.this.f3459g.isVideo()) {
                            VlionBaseParameterReplace vlionBaseParameterReplace = vlionADClickType.getVlionBaseParameterReplace();
                            v3 v3Var = v3.this;
                            vlionBaseParameterReplace.handleVideoParameter(v3Var.f3460h, v3Var.f3461i, v3Var.f3462j);
                        }
                        vlionADClickType.getVlionBaseParameterReplace().handleExposureParameter(v3.this.f3464l);
                        vlionADClickType.getVlionBaseParameterReplace().handleRenderSuccessParameter(v3.this.f3465m);
                    }
                    c5.a(v3.this.f3459g, vlionADClickType);
                    if (TextUtils.equals(VlionCustomAdActiveType$VlionCustomTarget.deeplink.toString(), vlionADClickType.getTarget())) {
                        c5.b(v3.this.f3459g, vlionADClickType);
                    }
                    v3 v3Var2 = v3.this;
                    v3Var2.f2719b = true;
                    if (v3Var2.f3458f != null && !vlionADClickType.isDefaultAdStrategy()) {
                        VlionAdStrategyUtils.getInstance().setStrategyBean(v3.this.f3458f.getAdxTagId());
                    }
                }
                VlionBiddingActionListener vlionBiddingActionListener = v3.this.f3456d;
                if (vlionBiddingActionListener != null) {
                    vlionBiddingActionListener.onAdClick();
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }

        public final void a(int i10, boolean z10) {
            try {
                if (z10) {
                    VlionADEventManager.getParameterSkip(v3.this.f3458f, i10);
                    VlionBiddingActionListener vlionBiddingActionListener = v3.this.f3456d;
                    if (vlionBiddingActionListener != null) {
                        vlionBiddingActionListener.onAdSkip();
                    }
                } else {
                    VlionADEventManager.submitClick(v3.this.f3458f, new VlionADClickType("misclose", "", "main", "button", VlionCustomAdActiveType$VlionCustomTarget.misclose.toString()));
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }
    }
}
