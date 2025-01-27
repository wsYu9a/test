package cn.vlion.ad.inland.base;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import cn.vlion.ad.inland.ad.config.VlionCustomAdActiveType$VlionCustomTarget;
import cn.vlion.ad.inland.ad.javabean.VlionCustomAdData;
import cn.vlion.ad.inland.ad.javabean.VlionCustomParseAdData;
import cn.vlion.ad.inland.base.bid.VlionBiddingActionListener;
import cn.vlion.ad.inland.base.javabean.VlionADClickType;
import cn.vlion.ad.inland.base.javabean.VlionAdapterADConfig;
import cn.vlion.ad.inland.base.natives.VlionNativesAdVideoListener;
import cn.vlion.ad.inland.base.util.VlionAdStrategyUtils;
import cn.vlion.ad.inland.base.util.event.VlionADEventManager;
import cn.vlion.ad.inland.base.util.handle.VlionBaseParameterReplace;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import cn.vlion.ad.inland.base.util.log.LogVlion;
import java.util.List;

/* loaded from: classes.dex */
public final class a3 extends e {

    /* renamed from: c */
    public Context f2593c;

    /* renamed from: d */
    public VlionBiddingActionListener f2594d;

    /* renamed from: e */
    public VlionAdapterADConfig f2595e;

    /* renamed from: g */
    public y2 f2597g;

    /* renamed from: h */
    public VlionCustomParseAdData f2598h;

    /* renamed from: j */
    public int f2600j;

    /* renamed from: k */
    public int f2601k;

    /* renamed from: l */
    public VlionBaseParameterReplace f2602l;

    /* renamed from: m */
    public long f2603m;

    /* renamed from: n */
    public long f2604n;

    /* renamed from: f */
    public f7 f2596f = null;

    /* renamed from: i */
    public boolean f2599i = false;

    public class a implements g0 {

        /* renamed from: a */
        public final /* synthetic */ VlionCustomParseAdData f2605a;

        /* renamed from: cn.vlion.ad.inland.base.a3$a$a */
        public class C0023a implements c3 {
            public C0023a() {
            }

            public final void a(VlionADClickType vlionADClickType) {
                try {
                    VlionAdapterADConfig vlionAdapterADConfig = a3.this.f2595e;
                    if (vlionAdapterADConfig != null) {
                        vlionAdapterADConfig.setVlionADClickType(vlionADClickType);
                    }
                    if (!a3.this.f2719b) {
                        if (vlionADClickType.getVlionBaseParameterReplace() != null) {
                            if (a3.this.f2598h.isVideo()) {
                                VlionBaseParameterReplace vlionBaseParameterReplace = vlionADClickType.getVlionBaseParameterReplace();
                                a3 a3Var = a3.this;
                                vlionBaseParameterReplace.handleVideoParameter(a3Var.f2599i, a3Var.f2600j, a3Var.f2601k);
                            }
                            vlionADClickType.getVlionBaseParameterReplace().handleExposureParameter(a3.this.f2603m);
                            vlionADClickType.getVlionBaseParameterReplace().handleRenderSuccessParameter(a3.this.f2604n);
                        }
                        c5.a(a3.this.f2598h, vlionADClickType);
                        if (TextUtils.equals(VlionCustomAdActiveType$VlionCustomTarget.deeplink.toString(), vlionADClickType.getTarget())) {
                            c5.b(a3.this.f2598h, vlionADClickType);
                        }
                        a3 a3Var2 = a3.this;
                        a3Var2.f2719b = true;
                        if (a3Var2.f2595e != null && !vlionADClickType.isDefaultAdStrategy()) {
                            VlionAdStrategyUtils.getInstance().setStrategyBean(a3.this.f2595e.getAdxTagId());
                        }
                    }
                    VlionBiddingActionListener vlionBiddingActionListener = a3.this.f2594d;
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
                LogVlion.e("VlionCustomFeedAdManager onAdEnter");
                VlionADEventManager.getParameterEnter(a3.this.f2595e);
            }

            @Override // cn.vlion.ad.inland.base.a
            public final void onAdExposure() {
                try {
                    LogVlion.e("VlionCustomFeedAdManager onAdExposure");
                    a3 a3Var = a3.this;
                    if (!a3Var.f2718a) {
                        a3Var.f2603m = System.currentTimeMillis();
                        a3 a3Var2 = a3.this;
                        c5.a(a3Var2.f2598h, a3Var2.f2597g, a3Var2.f2603m, a3Var2.f2604n);
                        a3.this.f2718a = true;
                    }
                    VlionBiddingActionListener vlionBiddingActionListener = a3.this.f2594d;
                    if (vlionBiddingActionListener != null) {
                        vlionBiddingActionListener.onAdExposure();
                    }
                } catch (Throwable th2) {
                    VlionSDkManager.getInstance().upLoadCatchException(th2);
                }
            }
        }

        public a(VlionCustomParseAdData vlionCustomParseAdData) {
            this.f2605a = vlionCustomParseAdData;
        }

        @Override // cn.vlion.ad.inland.base.g0
        public final void a(i1 i1Var) {
            try {
                LogVlion.e("VlionCustomFeedAdManager onAdRenderFailure");
                VlionBiddingActionListener vlionBiddingActionListener = a3.this.f2594d;
                if (vlionBiddingActionListener == null || i1Var == null) {
                    return;
                }
                vlionBiddingActionListener.onAdRenderFailure(i1Var.f2920a, i1Var.f2921b);
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }

        @Override // cn.vlion.ad.inland.base.g0
        @SuppressLint({"ClickableViewAccessibility"})
        public final void onAdRenderSuccess(View view) {
            StringBuilder a10 = l1.a("VlionCustomFeedAdManager onAdRenderSuccess (null!=view)=");
            a10.append(view != null);
            LogVlion.e(a10.toString());
            if (view != null) {
                try {
                    a3.this.f2604n = System.currentTimeMillis();
                    a3 a3Var = a3.this;
                    a3 a3Var2 = a3.this;
                    a3Var.f2597g = new y2(a3Var2.f2593c, a3Var2.f2595e);
                    a3 a3Var3 = a3.this;
                    a3Var3.f2597g.a(view, a3Var3.f2595e, this.f2605a, new C0023a());
                    a3.this.f2597g.setAdExposureListener(new b());
                    a3.this.f2597g.a();
                    LogVlion.e("VlionCustomFeedAdManager onAdRenderSuccess  callback");
                    a3 a3Var4 = a3.this;
                    VlionBiddingActionListener vlionBiddingActionListener = a3Var4.f2594d;
                    if (vlionBiddingActionListener != null) {
                        vlionBiddingActionListener.onAdRenderSuccess(a3Var4.f2597g);
                    }
                } catch (Throwable th2) {
                    VlionSDkManager.getInstance().upLoadCatchException(th2);
                }
            }
        }
    }

    public class b implements VlionNativesAdVideoListener {
        public b() {
        }

        @Override // cn.vlion.ad.inland.base.natives.VlionNativesAdVideoListener
        public final void onAdVideoPlayError(String str) {
        }

        @Override // cn.vlion.ad.inland.base.natives.VlionNativesAdVideoListener
        public final void onProgressUpdate(int i10, int i11) {
            try {
                a3 a3Var = a3.this;
                a3Var.f2600j = i10;
                a3Var.f2601k = i11;
                VlionBaseParameterReplace vlionBaseParameterReplace = a3Var.f2602l;
                if (vlionBaseParameterReplace != null) {
                    vlionBaseParameterReplace.handleVideoPlayingParameter(i10);
                }
                VlionCustomParseAdData vlionCustomParseAdData = a3.this.f2598h;
                if (vlionCustomParseAdData != null) {
                    List<VlionCustomAdData.SeatbidBean.BidBean.VideoBean.VmPTrackingBean> vm_p_tracking = vlionCustomParseAdData.getVideoBean().getVm_p_tracking();
                    a3 a3Var2 = a3.this;
                    c5.a(vm_p_tracking, i10, a3Var2.f2602l, a3Var2.f2598h);
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }

        @Override // cn.vlion.ad.inland.base.natives.VlionNativesAdVideoListener
        public final void onVideoAdComplete() {
            try {
                a3 a3Var = a3.this;
                a3Var.f2599i = true;
                VlionBaseParameterReplace vlionBaseParameterReplace = a3Var.f2602l;
                if (vlionBaseParameterReplace != null) {
                    vlionBaseParameterReplace.handleVideoFinishParameter(a3Var.f2601k);
                }
                VlionCustomParseAdData vlionCustomParseAdData = a3.this.f2598h;
                if (vlionCustomParseAdData != null) {
                    List<String> vm_p_succ = vlionCustomParseAdData.getVideoBean().getVm_p_succ();
                    a3 a3Var2 = a3.this;
                    c5.a(vm_p_succ, a3Var2.f2602l, a3Var2.f2598h);
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }

        @Override // cn.vlion.ad.inland.base.natives.VlionNativesAdVideoListener
        public final void onVideoAdContinuePlay() {
        }

        @Override // cn.vlion.ad.inland.base.natives.VlionNativesAdVideoListener
        public final void onVideoAdPaused() {
        }

        @Override // cn.vlion.ad.inland.base.natives.VlionNativesAdVideoListener
        public final void onVideoAdStartPlay() {
            try {
                a3 a3Var = a3.this;
                VlionCustomParseAdData vlionCustomParseAdData = a3Var.f2598h;
                if (vlionCustomParseAdData != null) {
                    a3Var.f2602l = new VlionBaseParameterReplace(vlionCustomParseAdData);
                    a3 a3Var2 = a3.this;
                    a3Var2.f2602l.handleVideoStartParameter(a3Var2.f2599i, a3Var2.f2600j, a3Var2.f2598h.getDuration(), a3.this.f2595e);
                }
                VlionCustomParseAdData vlionCustomParseAdData2 = a3.this.f2598h;
                if (vlionCustomParseAdData2 != null) {
                    List<String> vm_p_start = vlionCustomParseAdData2.getVideoBean().getVm_p_start();
                    a3 a3Var3 = a3.this;
                    c5.b(vm_p_start, a3Var3.f2602l, a3Var3.f2598h);
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }

        @Override // cn.vlion.ad.inland.base.natives.VlionNativesAdVideoListener
        public final void onVideoError(int i10, int i11) {
        }

        @Override // cn.vlion.ad.inland.base.natives.VlionNativesAdVideoListener
        public final void onVideoLoad() {
        }
    }

    public a3(Context context, VlionAdapterADConfig vlionAdapterADConfig) {
        this.f2593c = context;
        this.f2595e = vlionAdapterADConfig;
    }

    public final void a(VlionCustomParseAdData vlionCustomParseAdData) {
        try {
            LogVlion.e("VlionCustomFeedAdManager initView");
            f7 f7Var = new f7(this.f2593c, new a(vlionCustomParseAdData));
            this.f2596f = f7Var;
            b bVar = new b();
            f7Var.f2810h = bVar;
            a7 a7Var = f7Var.f2806d;
            if (a7Var != null) {
                a7Var.setVlionNativesAdVideoListener(bVar);
            }
            this.f2596f.a(vlionCustomParseAdData, this.f2595e);
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }
}
