package cn.vlion.ad.inland.base;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import cn.vlion.ad.inland.ad.config.VlionCustomAdActiveType$VlionCustomTarget;
import cn.vlion.ad.inland.ad.javabean.VlionCustomParseAdData;
import cn.vlion.ad.inland.base.bid.VlionBiddingActionListener;
import cn.vlion.ad.inland.base.javabean.VlionADClickType;
import cn.vlion.ad.inland.base.javabean.VlionAdapterADConfig;
import cn.vlion.ad.inland.base.util.VlionAdStrategyUtils;
import cn.vlion.ad.inland.base.util.event.VlionADEventManager;
import cn.vlion.ad.inland.base.util.handle.VlionBaseParameterReplace;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import cn.vlion.ad.inland.base.util.log.LogVlion;

/* loaded from: classes.dex */
public final class k2 extends e {

    /* renamed from: c */
    public Context f3009c;

    /* renamed from: d */
    public VlionAdapterADConfig f3010d;

    /* renamed from: f */
    public i2 f3012f;

    /* renamed from: g */
    public VlionCustomParseAdData f3013g;

    /* renamed from: h */
    public l2 f3014h;

    /* renamed from: j */
    public int f3016j;

    /* renamed from: k */
    public int f3017k;

    /* renamed from: l */
    public long f3018l;

    /* renamed from: m */
    public long f3019m;

    /* renamed from: n */
    public VlionBaseParameterReplace f3020n;

    /* renamed from: o */
    public VlionBiddingActionListener f3021o;

    /* renamed from: e */
    public f7 f3011e = null;

    /* renamed from: i */
    public boolean f3015i = false;

    public class a implements g0 {

        /* renamed from: a */
        public final /* synthetic */ VlionCustomParseAdData f3022a;

        /* renamed from: cn.vlion.ad.inland.base.k2$a$a */
        public class C0026a implements n2 {
            public C0026a() {
            }

            public final void a(VlionADClickType vlionADClickType) {
                try {
                    VlionAdapterADConfig vlionAdapterADConfig = k2.this.f3010d;
                    if (vlionAdapterADConfig != null) {
                        vlionAdapterADConfig.setVlionADClickType(vlionADClickType);
                    }
                    if (!k2.this.f2719b) {
                        if (vlionADClickType.getVlionBaseParameterReplace() != null) {
                            if (k2.this.f3013g.isVideo()) {
                                VlionBaseParameterReplace vlionBaseParameterReplace = vlionADClickType.getVlionBaseParameterReplace();
                                k2 k2Var = k2.this;
                                vlionBaseParameterReplace.handleVideoParameter(k2Var.f3015i, k2Var.f3016j, k2Var.f3017k);
                            }
                            vlionADClickType.getVlionBaseParameterReplace().handleExposureParameter(k2.this.f3018l);
                            vlionADClickType.getVlionBaseParameterReplace().handleRenderSuccessParameter(k2.this.f3019m);
                        }
                        c5.a(k2.this.f3013g, vlionADClickType);
                        if (TextUtils.equals(VlionCustomAdActiveType$VlionCustomTarget.deeplink.toString(), vlionADClickType.getTarget())) {
                            c5.b(k2.this.f3013g, vlionADClickType);
                        }
                        k2 k2Var2 = k2.this;
                        k2Var2.f2719b = true;
                        if (k2Var2.f3010d != null && !vlionADClickType.isDefaultAdStrategy()) {
                            VlionAdStrategyUtils.getInstance().setStrategyBean(k2.this.f3010d.getAdxTagId());
                        }
                    }
                    VlionBiddingActionListener vlionBiddingActionListener = k2.this.f3021o;
                    if (vlionBiddingActionListener != null) {
                        vlionBiddingActionListener.onAdClick();
                    }
                } catch (Throwable th2) {
                    VlionSDkManager.getInstance().upLoadCatchException(th2);
                }
            }
        }

        public class b implements cn.vlion.ad.inland.base.a {
            public b() {
            }

            @Override // cn.vlion.ad.inland.base.a
            public final void onAdEnter() {
                LogVlion.e("VlionCustomDrawAdManager onAdEnter");
                VlionADEventManager.getParameterEnter(k2.this.f3010d);
            }

            @Override // cn.vlion.ad.inland.base.a
            public final void onAdExposure() {
                try {
                    LogVlion.e("VlionCustomDrawAdManager onAdExposure");
                    k2 k2Var = k2.this;
                    if (!k2Var.f2718a) {
                        k2Var.f3018l = System.currentTimeMillis();
                        k2 k2Var2 = k2.this;
                        c5.a(k2Var2.f3013g, k2Var2.f3012f, k2Var2.f3018l, k2Var2.f3019m);
                        k2.this.f2718a = true;
                    }
                    VlionBiddingActionListener vlionBiddingActionListener = k2.this.f3021o;
                    if (vlionBiddingActionListener != null) {
                        vlionBiddingActionListener.onAdExposure();
                    }
                } catch (Throwable th2) {
                    VlionSDkManager.getInstance().upLoadCatchException(th2);
                }
            }
        }

        public a(VlionCustomParseAdData vlionCustomParseAdData) {
            this.f3022a = vlionCustomParseAdData;
        }

        @Override // cn.vlion.ad.inland.base.g0
        public final void a(i1 i1Var) {
            try {
                LogVlion.e("VlionCustomDrawAdManager onAdRenderFailure");
                VlionBiddingActionListener vlionBiddingActionListener = k2.this.f3021o;
                if (vlionBiddingActionListener == null || i1Var == null) {
                    return;
                }
                vlionBiddingActionListener.onAdRenderFailure(i1Var.f2920a, i1Var.f2921b);
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }

        @Override // cn.vlion.ad.inland.base.g0
        public final void onAdRenderSuccess(View view) {
            i2 i2Var;
            StringBuilder a10 = l1.a("VlionCustomDrawAdManager onAdRenderSuccess (null!=view)=");
            a10.append(view != null);
            LogVlion.e(a10.toString());
            if (view != null) {
                try {
                    k2.this.f3019m = System.currentTimeMillis();
                    k2 k2Var = k2.this;
                    k2 k2Var2 = k2.this;
                    k2Var.f3012f = new i2(k2Var2.f3009c, k2Var2.f3010d);
                    k2 k2Var3 = k2.this;
                    k2Var3.f3012f.a(view, k2Var3.f3010d, this.f3022a, new C0026a());
                    k2.this.f3012f.setAdExposureListener(new b());
                    k2.this.f3012f.a();
                    LogVlion.e("VlionCustomDrawAdManager onAdRenderSuccess  callback");
                    k2 k2Var4 = k2.this;
                    VlionBiddingActionListener vlionBiddingActionListener = k2Var4.f3021o;
                    if (vlionBiddingActionListener == null || (i2Var = k2Var4.f3012f) == null) {
                        return;
                    }
                    vlionBiddingActionListener.onAdRenderSuccess(i2Var);
                } catch (Throwable th2) {
                    VlionSDkManager.getInstance().upLoadCatchException(th2);
                }
            }
        }
    }

    public k2(Context context, VlionAdapterADConfig vlionAdapterADConfig) {
        this.f3009c = context;
        this.f3010d = vlionAdapterADConfig;
    }

    public final void a(VlionCustomParseAdData vlionCustomParseAdData) {
        try {
            LogVlion.e("VlionCustomDrawAdManager initView");
            f7 f7Var = new f7(this.f3009c, new a(vlionCustomParseAdData));
            this.f3011e = f7Var;
            l2 l2Var = this.f3014h;
            f7Var.f2810h = l2Var;
            a7 a7Var = f7Var.f2806d;
            if (a7Var != null) {
                a7Var.setVlionNativesAdVideoListener(l2Var);
            }
            this.f3011e.a(vlionCustomParseAdData, this.f3010d);
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }
}
