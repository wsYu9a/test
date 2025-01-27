package cn.vlion.ad.inland.core;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import cn.vlion.ad.inland.ad.adapter.VlionCustomAdapter;
import cn.vlion.ad.inland.ba.VlionBaAdapter;
import cn.vlion.ad.inland.base.adapter.BaseAdAdapter;
import cn.vlion.ad.inland.base.adapter.VlionBidderSource;
import cn.vlion.ad.inland.base.adapter.VlionLossBiddingReason;
import cn.vlion.ad.inland.base.adapter.VlionLossReason;
import cn.vlion.ad.inland.base.bid.VlionBiddingActionListener;
import cn.vlion.ad.inland.base.bid.VlionBiddingActionRewardListener;
import cn.vlion.ad.inland.base.bid.VlionNativeActionListener;
import cn.vlion.ad.inland.base.javabean.VlionAdLimitStrategyBean;
import cn.vlion.ad.inland.base.javabean.VlionAdapterADConfig;
import cn.vlion.ad.inland.base.javabean.VlionServiceConfig;
import cn.vlion.ad.inland.base.javabean.VlionServiceConfigParse;
import cn.vlion.ad.inland.base.natives.VlionNativesAdVideoListener;
import cn.vlion.ad.inland.base.util.VlionAdLimitStrategyUtils;
import cn.vlion.ad.inland.base.util.config.VlionAdBaseError;
import cn.vlion.ad.inland.base.util.event.VlionADEventManager;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import cn.vlion.ad.inland.base.util.log.LogVlion;
import cn.vlion.ad.inland.core.config.VlionAdError;
import cn.vlion.ad.inland.core.g0;
import cn.vlion.ad.inland.core.h0;
import cn.vlion.ad.inland.core.natives.VlionNativeADListener;
import cn.vlion.ad.inland.cs.VlionCsAdapter;
import cn.vlion.ad.inland.gd.VlionGdAdapter;
import cn.vlion.ad.inland.jd.VlionJDAdapter;
import cn.vlion.ad.inland.kd.VlionKDAdapter;
import cn.vlion.ad.inland.ku.VlionKuAdapter;
import cn.vlion.ad.inland.ta.VlionTaAdapter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.UUID;

/* loaded from: classes.dex */
public class i {

    /* renamed from: b */
    public Context f3608b;

    /* renamed from: c */
    public Activity f3609c;

    /* renamed from: d */
    public j f3610d;

    /* renamed from: e */
    public p0 f3611e;

    /* renamed from: i */
    public j0 f3615i;

    /* renamed from: n */
    public boolean f3620n;

    /* renamed from: o */
    public boolean f3621o;

    /* renamed from: p */
    public l f3622p;

    /* renamed from: q */
    public VlionNativeADListener f3623q;

    /* renamed from: r */
    public m f3624r;

    /* renamed from: s */
    public VlionNativesAdVideoListener f3625s;

    /* renamed from: u */
    public cn.vlion.ad.inland.core.b f3627u;

    /* renamed from: v */
    public VlionAdapterADConfig f3628v;

    /* renamed from: w */
    public BaseAdAdapter f3629w;

    /* renamed from: y */
    public String f3631y;

    /* renamed from: a */
    public final String f3607a = i.class.getName();

    /* renamed from: f */
    public ArrayList<cn.vlion.ad.inland.core.b> f3612f = new ArrayList<>();

    /* renamed from: g */
    public ArrayList<cn.vlion.ad.inland.core.b> f3613g = new ArrayList<>();

    /* renamed from: h */
    public String f3614h = "";

    /* renamed from: j */
    public boolean f3616j = false;

    /* renamed from: k */
    public boolean f3617k = false;

    /* renamed from: l */
    public cn.vlion.ad.inland.core.a f3618l = null;

    /* renamed from: m */
    public boolean f3619m = false;

    /* renamed from: t */
    public boolean f3626t = false;

    /* renamed from: x */
    public boolean f3630x = false;

    public class a implements VlionBiddingActionListener {
        public a() {
        }

        @Override // cn.vlion.ad.inland.base.bid.VlionBiddingActionListener
        public final void onAdClick() {
            try {
                if (i.this.f3628v != null) {
                    VlionADEventManager.submitClick(i.this.f3628v, i.this.f3628v.getVlionADClickType());
                }
                if (i.this.f3627u != null) {
                    LogVlion.e(i.this.f3607a + " " + i.this.f3614h + " plat=" + i.this.f3627u.h() + "  onAdClick  isFinished()");
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(i.this.f3607a);
                    sb2.append(" ");
                    sb2.append(i.this.f3614h);
                    sb2.append(" null != vlionBidResultListener = ");
                    sb2.append(i.this.f3622p != null);
                    LogVlion.e(sb2.toString());
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(i.this.f3607a);
                    sb3.append(" ");
                    sb3.append(i.this.f3614h);
                    sb3.append(" null != vlionAdapterADConfig = ");
                    sb3.append(i.this.f3628v != null);
                    LogVlion.e(sb3.toString());
                    i iVar = i.this;
                    if (iVar.f3622p == null || !i.a(iVar.f3628v, i.this.f3627u.h())) {
                        return;
                    }
                    i.this.f3622p.onAdClick();
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }

        @Override // cn.vlion.ad.inland.base.bid.VlionBiddingActionListener
        public final void onAdClose() {
            try {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(i.this.f3607a);
                sb2.append(" ");
                sb2.append(i.this.f3614h);
                sb2.append(" plat=");
                cn.vlion.ad.inland.core.b bVar = i.this.f3627u;
                sb2.append(bVar == null ? "" : bVar.h());
                sb2.append("  onAdClose  isFinished()");
                LogVlion.e(sb2.toString());
                VlionADEventManager.submitClose(i.this.f3628v);
                l lVar = i.this.f3622p;
                if (lVar != null) {
                    lVar.onAdClose();
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }

        @Override // cn.vlion.ad.inland.base.bid.VlionBiddingActionListener
        public final void onAdExposure() {
            try {
                if (i.this.f3627u != null) {
                    LogVlion.e(i.this.f3607a + " " + i.this.f3614h + " plat=" + i.this.f3627u.h() + "  onAdExposure  isFinished()");
                    i iVar = i.this;
                    if (!iVar.f3626t) {
                        VlionADEventManager.submitTrigger(iVar.f3628v);
                    }
                    VlionADEventManager.submitImp(i.this.f3628v, i.this.f3627u.i(), i.this.f3627u.q());
                    l lVar = i.this.f3622p;
                    if (lVar != null) {
                        lVar.onAdExposure();
                    }
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }

        @Override // cn.vlion.ad.inland.base.bid.VlionBiddingActionListener
        public final void onAdRenderFailure(int i10, String str) {
            try {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(i.this.f3607a);
                sb2.append(" ");
                sb2.append(i.this.f3614h);
                sb2.append(" plat=");
                cn.vlion.ad.inland.core.b bVar = i.this.f3627u;
                sb2.append(bVar == null ? "" : bVar.h());
                sb2.append(" code=");
                sb2.append(i10);
                sb2.append(" desc=");
                sb2.append(str);
                sb2.append("  onAdRenderFailure  isFinished()");
                LogVlion.e(sb2.toString());
                VlionADEventManager.submitRenderFail(i.this.f3628v);
                l lVar = i.this.f3622p;
                if (lVar != null) {
                    VlionAdBaseError vlionAdBaseError = VlionAdBaseError.AD_RENDER_ERROR;
                    lVar.onAdRenderFailure(new VlionAdError(vlionAdBaseError.getErrorCode(), vlionAdBaseError.getErrorMessage(), String.valueOf(i10), str));
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }

        @Override // cn.vlion.ad.inland.base.bid.VlionBiddingActionListener
        public final void onAdRenderSuccess(View view) {
            try {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(i.this.f3607a);
                sb2.append(" ");
                sb2.append(i.this.f3614h);
                sb2.append(" plat=");
                cn.vlion.ad.inland.core.b bVar = i.this.f3627u;
                sb2.append(bVar == null ? "" : bVar.h());
                sb2.append("  onAdRenderSuccess  (null == view)=");
                sb2.append(view == null);
                sb2.append(" isFinished()");
                LogVlion.e(sb2.toString());
                VlionADEventManager.submitRenderSuccess(i.this.f3628v);
                l lVar = i.this.f3622p;
                if (lVar != null) {
                    lVar.onAdRenderSuccess(view);
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }

        @Override // cn.vlion.ad.inland.base.bid.VlionBiddingActionListener
        public final void onAdShowFailure(int i10, String str) {
            try {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(i.this.f3607a);
                sb2.append(" ");
                sb2.append(i.this.f3614h);
                sb2.append(" plat=");
                cn.vlion.ad.inland.core.b bVar = i.this.f3627u;
                sb2.append(bVar == null ? "" : bVar.h());
                sb2.append(" code=");
                sb2.append(i10);
                sb2.append(" desc=");
                sb2.append(str);
                sb2.append("  onAdShowFailure isFinished()");
                LogVlion.e(sb2.toString());
                l lVar = i.this.f3622p;
                if (lVar != null) {
                    lVar.onAdShowFailure(new VlionAdError(VlionAdBaseError.AD_Show_ERROR_CODE, VlionAdBaseError.AD_RENDER_ERROR.getErrorMessage(), String.valueOf(i10), str));
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }

        @Override // cn.vlion.ad.inland.base.bid.VlionBiddingActionListener
        public final void onAdSkip() {
            try {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(i.this.f3607a);
                sb2.append(" ");
                sb2.append(i.this.f3614h);
                sb2.append(" plat=");
                cn.vlion.ad.inland.core.b bVar = i.this.f3627u;
                sb2.append(bVar == null ? "" : bVar.h());
                sb2.append("  onAdSkip   isFinished()");
                LogVlion.e(sb2.toString());
                l lVar = i.this.f3622p;
                if (lVar != null) {
                    lVar.onAdSkip();
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }
    }

    public class b implements VlionNativeActionListener {
        public b() {
        }

        @Override // cn.vlion.ad.inland.base.bid.VlionNativeActionListener
        public final void notifyWinPrice(double d10, VlionBidderSource vlionBidderSource) {
            try {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(i.this.f3607a);
                sb2.append(" ");
                sb2.append(i.this.f3614h);
                sb2.append(" plat=");
                cn.vlion.ad.inland.core.b bVar = i.this.f3627u;
                sb2.append(bVar == null ? "" : bVar.h());
                sb2.append("  notifyWinPrice");
                LogVlion.e(sb2.toString());
                i iVar = i.this;
                if (iVar.f3627u != null) {
                    VlionADEventManager.submitBidSuccess(iVar.f3628v, i.this.f3627u.i(), i.this.f3627u.q(), d10, vlionBidderSource);
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }

        @Override // cn.vlion.ad.inland.base.bid.VlionNativeActionListener
        public final void notifyWinPriceFailure(double d10, VlionBidderSource vlionBidderSource, VlionLossBiddingReason vlionLossBiddingReason) {
            try {
                if (i.this.f3627u != null) {
                    LogVlion.e(i.this.f3607a + " " + i.this.f3614h + " plat=" + i.this.f3627u.h() + "  notifyWinPriceFailure  price=" + (i.this.f3627u.j() * d10));
                    VlionADEventManager.submitBidFail(i.this.f3628v, d10, i.this.f3627u.q(), vlionBidderSource, vlionLossBiddingReason != null ? vlionLossBiddingReason.getVlionLossReason() : null);
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }

        @Override // cn.vlion.ad.inland.base.bid.VlionNativeActionListener
        public final void onAdRenderFailure(VlionAdBaseError vlionAdBaseError) {
            try {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(i.this.f3607a);
                sb2.append(" ");
                sb2.append(i.this.f3614h);
                sb2.append(" plat=");
                cn.vlion.ad.inland.core.b bVar = i.this.f3627u;
                sb2.append(bVar == null ? "" : bVar.h());
                sb2.append(" code=");
                sb2.append(vlionAdBaseError.getErrorCode());
                sb2.append(" desc=");
                sb2.append(vlionAdBaseError.getErrorCode());
                sb2.append("  onAdRenderFailure ");
                LogVlion.e(sb2.toString());
                VlionADEventManager.submitRenderFail(i.this.f3628v);
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }

        @Override // cn.vlion.ad.inland.base.bid.VlionNativeActionListener
        public final void onAdRenderSuccess() {
            try {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(i.this.f3607a);
                sb2.append(" ");
                sb2.append(i.this.f3614h);
                sb2.append(" plat=");
                cn.vlion.ad.inland.core.b bVar = i.this.f3627u;
                sb2.append(bVar == null ? "" : bVar.h());
                sb2.append("  onAdRenderSuccess ");
                LogVlion.e(sb2.toString());
                VlionADEventManager.submitRenderSuccess(i.this.f3628v);
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }

        @Override // cn.vlion.ad.inland.base.bid.VlionNativeActionListener
        public final void onClick() {
            try {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(i.this.f3607a);
                sb2.append(" ");
                sb2.append(i.this.f3614h);
                sb2.append(" plat=");
                cn.vlion.ad.inland.core.b bVar = i.this.f3627u;
                sb2.append(bVar == null ? "" : bVar.h());
                sb2.append("  onClick  ");
                LogVlion.e(sb2.toString());
                if (i.this.f3628v != null) {
                    VlionADEventManager.submitClick(i.this.f3628v, i.this.f3628v.getVlionADClickType());
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }

        @Override // cn.vlion.ad.inland.base.bid.VlionNativeActionListener
        public final void onClose() {
            try {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(i.this.f3607a);
                sb2.append(" ");
                sb2.append(i.this.f3614h);
                sb2.append(" plat=");
                cn.vlion.ad.inland.core.b bVar = i.this.f3627u;
                sb2.append(bVar == null ? "" : bVar.h());
                sb2.append("  onClose  ");
                LogVlion.e(sb2.toString());
                VlionADEventManager.submitClose(i.this.f3628v);
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }

        @Override // cn.vlion.ad.inland.base.bid.VlionNativeActionListener
        public final void onExposure() {
            try {
                if (i.this.f3627u != null) {
                    LogVlion.e(i.this.f3607a + " " + i.this.f3614h + " plat=" + i.this.f3627u.h() + "  onExposure ");
                    VlionADEventManager.submitTrigger(i.this.f3628v);
                    VlionADEventManager.submitImp(i.this.f3628v, (double) i.this.f3627u.i(), i.this.f3627u.q());
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }
    }

    public class c implements VlionBiddingActionRewardListener {
        public c() {
        }

        @Override // cn.vlion.ad.inland.base.bid.VlionBiddingActionRewardListener
        public final void onAdClick() {
            try {
                if (i.this.f3628v != null) {
                    VlionADEventManager.submitClick(i.this.f3628v, i.this.f3628v.getVlionADClickType());
                }
                if (i.this.f3627u != null) {
                    LogVlion.e(i.this.f3607a + " " + i.this.f3614h + " plat=" + i.this.f3627u.h() + "  onAdClick    isFinished()");
                    i iVar = i.this;
                    if (iVar.f3624r == null || !i.a(iVar.f3628v, i.this.f3627u.h())) {
                        return;
                    }
                    ((h0.a) i.this.f3624r).a();
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }

        @Override // cn.vlion.ad.inland.base.bid.VlionBiddingActionRewardListener
        public final void onAdClose() {
            try {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(i.this.f3607a);
                sb2.append(" ");
                sb2.append(i.this.f3614h);
                sb2.append(" plat=");
                cn.vlion.ad.inland.core.b bVar = i.this.f3627u;
                sb2.append(bVar == null ? "" : bVar.h());
                sb2.append("  onAdClose    isFinished()");
                LogVlion.e(sb2.toString());
                VlionADEventManager.submitClose(i.this.f3628v);
                m mVar = i.this.f3624r;
                if (mVar != null) {
                    ((h0.a) mVar).b();
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }

        @Override // cn.vlion.ad.inland.base.bid.VlionBiddingActionRewardListener
        public final void onAdExposure() {
            try {
                if (i.this.f3627u != null) {
                    LogVlion.e(i.this.f3607a + " " + i.this.f3614h + " plat=" + i.this.f3627u.h() + "  onAdExposure    isFinished()");
                    VlionADEventManager.submitImp(i.this.f3628v, (double) i.this.f3627u.i(), i.this.f3627u.q());
                    m mVar = i.this.f3624r;
                    if (mVar != null) {
                        ((h0.a) mVar).c();
                    }
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }

        @Override // cn.vlion.ad.inland.base.bid.VlionBiddingActionRewardListener
        public final void onAdPlayFailure(int i10, String str) {
            try {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(i.this.f3607a);
                sb2.append(" ");
                sb2.append(i.this.f3614h);
                sb2.append(" plat=");
                cn.vlion.ad.inland.core.b bVar = i.this.f3627u;
                sb2.append(bVar == null ? "" : bVar.h());
                sb2.append(" code=");
                sb2.append(i10);
                sb2.append(" desc=");
                sb2.append(str);
                sb2.append("  onAdPlayFailure isFinished()");
                LogVlion.e(sb2.toString());
                m mVar = i.this.f3624r;
                if (mVar != null) {
                    VlionAdBaseError vlionAdBaseError = VlionAdBaseError.AD_REWARD_VIDEO_PLAY_ERROR;
                    ((h0.a) mVar).b(new VlionAdError(vlionAdBaseError.getErrorCode(), vlionAdBaseError.getErrorMessage(), String.valueOf(i10), str));
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }

        @Override // cn.vlion.ad.inland.base.bid.VlionBiddingActionRewardListener
        public final void onAdRenderFailure(int i10, String str) {
            try {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(i.this.f3607a);
                sb2.append(" ");
                sb2.append(i.this.f3614h);
                sb2.append(" plat=");
                cn.vlion.ad.inland.core.b bVar = i.this.f3627u;
                sb2.append(bVar == null ? "" : bVar.h());
                sb2.append(" code=");
                sb2.append(i10);
                sb2.append(" desc=");
                sb2.append(str);
                sb2.append("  onAdRenderFailure  isFinished()");
                LogVlion.e(sb2.toString());
                VlionADEventManager.submitRenderFail(i.this.f3628v);
                m mVar = i.this.f3624r;
                if (mVar != null) {
                    VlionAdBaseError vlionAdBaseError = VlionAdBaseError.AD_RENDER_ERROR;
                    ((h0.a) mVar).c(new VlionAdError(vlionAdBaseError.getErrorCode(), vlionAdBaseError.getErrorMessage(), String.valueOf(i10), str));
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }

        @Override // cn.vlion.ad.inland.base.bid.VlionBiddingActionRewardListener
        public final void onAdRenderSuccess() {
            try {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(i.this.f3607a);
                sb2.append(" ");
                sb2.append(i.this.f3614h);
                sb2.append(" plat=");
                cn.vlion.ad.inland.core.b bVar = i.this.f3627u;
                sb2.append(bVar == null ? "" : bVar.h());
                sb2.append("  onAdRenderSuccess ");
                LogVlion.e(sb2.toString());
                VlionADEventManager.submitRenderSuccess(i.this.f3628v);
                m mVar = i.this.f3624r;
                if (mVar != null) {
                    ((h0.a) mVar).d();
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }

        @Override // cn.vlion.ad.inland.base.bid.VlionBiddingActionRewardListener
        public final void onAdReward() {
            try {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(i.this.f3607a);
                sb2.append(" ");
                sb2.append(i.this.f3614h);
                sb2.append(" plat=");
                cn.vlion.ad.inland.core.b bVar = i.this.f3627u;
                sb2.append(bVar == null ? "" : bVar.h());
                sb2.append("  onAdReward");
                LogVlion.e(sb2.toString());
                m mVar = i.this.f3624r;
                if (mVar != null) {
                    ((h0.a) mVar).e();
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }

        @Override // cn.vlion.ad.inland.base.bid.VlionBiddingActionRewardListener
        public final void onAdShowFailure(int i10, String str) {
            try {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(i.this.f3607a);
                sb2.append(" ");
                sb2.append(i.this.f3614h);
                sb2.append(" plat=");
                cn.vlion.ad.inland.core.b bVar = i.this.f3627u;
                sb2.append(bVar == null ? "" : bVar.h());
                sb2.append(" code=");
                sb2.append(i10);
                sb2.append(" desc=");
                sb2.append(str);
                sb2.append("  onAdShowFailure isFinished()");
                LogVlion.e(sb2.toString());
                m mVar = i.this.f3624r;
                if (mVar != null) {
                    ((h0.a) mVar).d(new VlionAdError(VlionAdBaseError.AD_Show_ERROR_CODE, VlionAdBaseError.AD_RENDER_ERROR.getErrorMessage(), String.valueOf(i10), str));
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }

        @Override // cn.vlion.ad.inland.base.bid.VlionBiddingActionRewardListener
        public final void onAdVideoPlayComplete() {
            try {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(i.this.f3607a);
                sb2.append(" ");
                sb2.append(i.this.f3614h);
                sb2.append(" plat=");
                cn.vlion.ad.inland.core.b bVar = i.this.f3627u;
                sb2.append(bVar == null ? "" : bVar.h());
                sb2.append("  onAdVideoPlayComplete ");
                LogVlion.e(sb2.toString());
                m mVar = i.this.f3624r;
                if (mVar != null) {
                    ((h0.a) mVar).f();
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }

        @Override // cn.vlion.ad.inland.base.bid.VlionBiddingActionRewardListener
        public final void onAdVideoPlaying(int i10, int i11) {
            try {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(i.this.f3607a);
                sb2.append(" ");
                sb2.append(i.this.f3614h);
                sb2.append(" plat=");
                cn.vlion.ad.inland.core.b bVar = i.this.f3627u;
                sb2.append(bVar == null ? "" : bVar.h());
                sb2.append("  onAdVideoPlaying  current=");
                sb2.append(i10);
                sb2.append(" total=");
                sb2.append(i11);
                LogVlion.e(sb2.toString());
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }

        @Override // cn.vlion.ad.inland.base.bid.VlionBiddingActionRewardListener
        public final void onAdVideoSkip() {
            try {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(i.this.f3607a);
                sb2.append(" ");
                sb2.append(i.this.f3614h);
                sb2.append(" plat=");
                cn.vlion.ad.inland.core.b bVar = i.this.f3627u;
                sb2.append(bVar == null ? "" : bVar.h());
                sb2.append("  onAdVideoSkip");
                LogVlion.e(sb2.toString());
                m mVar = i.this.f3624r;
                if (mVar != null) {
                    ((h0.a) mVar).g();
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }

        @Override // cn.vlion.ad.inland.base.bid.VlionBiddingActionRewardListener
        public final void onAdVideoStart() {
            try {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(i.this.f3607a);
                sb2.append(" ");
                sb2.append(i.this.f3614h);
                sb2.append(" plat=");
                cn.vlion.ad.inland.core.b bVar = i.this.f3627u;
                sb2.append(bVar == null ? "" : bVar.h());
                sb2.append("  onAdVideoStart");
                LogVlion.e(sb2.toString());
                m mVar = i.this.f3624r;
                if (mVar != null) {
                    ((h0.a) mVar).h();
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }
    }

    public i(Activity activity, j0 j0Var, VlionServiceConfig.DataBean.AdBean.PlacementBean placementBean) {
        this.f3609c = activity;
        this.f3608b = activity;
        this.f3615i = j0Var;
        a(placementBean);
    }

    public static VlionAdLimitStrategyBean.AdLimitStrategyBean a(List list, String str) {
        if (list == null) {
            return null;
        }
        try {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                VlionAdLimitStrategyBean.AdLimitStrategyBean adLimitStrategyBean = (VlionAdLimitStrategyBean.AdLimitStrategyBean) it.next();
                if (adLimitStrategyBean.getAdSrcName().equals(str)) {
                    return adLimitStrategyBean;
                }
            }
            VlionAdLimitStrategyBean.AdLimitStrategyBean adLimitStrategyBean2 = new VlionAdLimitStrategyBean.AdLimitStrategyBean();
            adLimitStrategyBean2.setAdSrcName(str);
            adLimitStrategyBean2.setCount(0);
            adLimitStrategyBean2.setLasttime(0L);
            LogVlion.e("频控策略 : VlionBaseAdSource  -新增了频次策略对象 ：=" + str);
            list.add(adLimitStrategyBean2);
            return adLimitStrategyBean2;
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
            return null;
        }
    }

    public final boolean c() {
        StringBuilder a10 = f.a("VlionBaseLoadAdSource isConfigEmpty=");
        a10.append(this.f3616j);
        LogVlion.e(a10.toString());
        return this.f3616j;
    }

    public final void d() {
        try {
            BaseAdAdapter baseAdAdapter = this.f3629w;
            if (baseAdAdapter == null) {
                return;
            }
            baseAdAdapter.setVlionBiddingActionListener(new a());
            this.f3629w.setVlionNativeActionListener(new b());
            this.f3629w.setVlionNativesAdVideoListener(this.f3625s);
            this.f3629w.setVlionBiddingActionRewardListener(new c());
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public final void e() {
        LogVlion.e("VlionBaseLoadAdSource checkCallback SuccessResultSource=");
        a((VlionAdError) null, false);
    }

    public i(Context context, j0 j0Var, VlionServiceConfig.DataBean.AdBean.PlacementBean placementBean) {
        this.f3608b = context;
        this.f3615i = j0Var;
        a(placementBean);
    }

    public final boolean b() {
        return this.f3617k;
    }

    public void a() {
        try {
            if (this.f3615i != null) {
                this.f3615i = null;
            }
            j jVar = this.f3610d;
            if (jVar != null) {
                jVar.a();
                this.f3610d = null;
            }
            p0 p0Var = this.f3611e;
            if (p0Var != null) {
                p0Var.a();
                this.f3611e = null;
            }
            cn.vlion.ad.inland.core.b bVar = this.f3627u;
            if (bVar != null) {
                bVar.a();
                this.f3627u = null;
            }
            if (this.f3628v != null) {
                this.f3628v = null;
            }
            BaseAdAdapter baseAdAdapter = this.f3629w;
            if (baseAdAdapter != null) {
                baseAdAdapter.destroy();
                this.f3629w = null;
            }
            if (this.f3630x) {
                return;
            }
            ArrayList<cn.vlion.ad.inland.core.b> arrayList = this.f3612f;
            if (arrayList != null && arrayList.size() > 0) {
                for (int i10 = 0; i10 < this.f3612f.size(); i10++) {
                    cn.vlion.ad.inland.core.b bVar2 = this.f3612f.get(i10);
                    if (bVar2 != null) {
                        bVar2.a();
                    }
                }
                this.f3612f.clear();
            }
            ArrayList<cn.vlion.ad.inland.core.b> arrayList2 = this.f3613g;
            if (arrayList2 == null || arrayList2.size() <= 0) {
                return;
            }
            for (int i11 = 0; i11 < this.f3613g.size(); i11++) {
                cn.vlion.ad.inland.core.b bVar3 = this.f3613g.get(i11);
                if (bVar3 != null) {
                    bVar3.a();
                }
            }
            this.f3613g.clear();
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public final void a(double d10, VlionBidderSource vlionBidderSource) {
        try {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(this.f3607a);
            sb2.append("  (null != baseAdAdapterCacheData)=");
            sb2.append(this.f3618l != null);
            LogVlion.e(sb2.toString());
            if (this.f3618l == null || this.f3629w == null) {
                LogVlion.e("notifyDrawWinPrice ad is not ready");
                return;
            }
            StringBuilder sb3 = new StringBuilder();
            sb3.append(this.f3607a);
            sb3.append(" notifyBannerWinPrice (null != baseAdSourceData)=");
            sb3.append(this.f3627u != null);
            LogVlion.e(sb3.toString());
            if (this.f3627u != null) {
                VlionADEventManager.submitBidSuccess(this.f3628v, r0.i(), this.f3627u.q(), d10, vlionBidderSource);
            }
            this.f3629w.notifyWinPrice(this.f3620n);
            VlionAdapterADConfig vlionAdapterADConfig = this.f3628v;
            if (vlionAdapterADConfig != null) {
                vlionAdapterADConfig.setSecondPrice((int) d10);
                this.f3628v.setSecondBrandName(vlionBidderSource);
            }
            VlionLossBiddingReason vlionLossBiddingReason = new VlionLossBiddingReason();
            vlionLossBiddingReason.setBiddingPrice((int) this.f3618l.c());
            vlionLossBiddingReason.setVlionLossReason(VlionLossReason.BidFailure);
            vlionLossBiddingReason.setBrandName(d.a(this.f3618l));
            a(vlionLossBiddingReason, this.f3629w);
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public final void a(double d10, VlionBidderSource vlionBidderSource, VlionLossReason vlionLossReason) {
        try {
            if (this.f3618l != null) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(this.f3607a);
                sb2.append(" notifyBannerWinPrice (null != baseAdSourceData)=");
                sb2.append(this.f3627u != null);
                LogVlion.e(sb2.toString());
                cn.vlion.ad.inland.core.b bVar = this.f3627u;
                if (bVar != null) {
                    VlionADEventManager.submitBidFail(this.f3628v, d10, bVar.q(), vlionBidderSource, vlionLossReason);
                }
            } else {
                LogVlion.e(this.f3607a + "notifyWinPriceFailure ad is not ready");
            }
            VlionLossBiddingReason vlionLossBiddingReason = new VlionLossBiddingReason();
            vlionLossBiddingReason.setBiddingPrice((int) d10);
            vlionLossBiddingReason.setVlionLossReason(vlionLossReason);
            vlionLossBiddingReason.setBrandName(vlionBidderSource);
            a(vlionLossBiddingReason, (BaseAdAdapter) null);
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public final void a(VlionLossBiddingReason vlionLossBiddingReason, BaseAdAdapter baseAdAdapter) {
        StringBuilder sb2;
        String str;
        BaseAdAdapter c10;
        StringBuilder sb3;
        String str2;
        try {
            ArrayList<cn.vlion.ad.inland.core.b> arrayList = this.f3612f;
            if (arrayList != null && arrayList.size() > 0) {
                for (int i10 = 0; i10 < this.f3612f.size(); i10++) {
                    cn.vlion.ad.inland.core.b bVar = this.f3612f.get(i10);
                    if (bVar != null && (c10 = bVar.c()) != null && 1 == bVar.e()) {
                        if (baseAdAdapter != null) {
                            if (baseAdAdapter.equals(c10)) {
                                sb3 = new StringBuilder();
                                sb3.append(this.f3607a);
                                str2 = "notifyBidWin win same";
                            } else {
                                c10.notifyFailPrice(vlionLossBiddingReason);
                                sb3 = new StringBuilder();
                                sb3.append(this.f3607a);
                                str2 = "notifyBidWin win not same";
                            }
                            sb3.append(str2);
                            LogVlion.e(sb3.toString());
                        } else {
                            LogVlion.e(this.f3607a + "notifyBidFailure loss");
                            c10.notifyFailPrice(vlionLossBiddingReason);
                        }
                    }
                }
            }
            ArrayList<cn.vlion.ad.inland.core.b> arrayList2 = this.f3613g;
            if (arrayList2 == null || arrayList2.size() <= 0) {
                return;
            }
            for (int i11 = 0; i11 < this.f3613g.size(); i11++) {
                cn.vlion.ad.inland.core.b bVar2 = this.f3613g.get(i11);
                if (bVar2 != null) {
                    BaseAdAdapter c11 = bVar2.c();
                    if (baseAdAdapter != null) {
                        if (baseAdAdapter.equals(c11)) {
                            sb2 = new StringBuilder();
                            sb2.append(this.f3607a);
                            str = "notifyWaterWin win same";
                        } else {
                            c11.notifyFailPrice(vlionLossBiddingReason);
                            sb2 = new StringBuilder();
                            sb2.append(this.f3607a);
                            str = "notifyWaterWin win not same";
                        }
                        sb2.append(str);
                        LogVlion.e(sb2.toString());
                    } else {
                        LogVlion.e(this.f3607a + "notifyBidFailure loss");
                        c11.notifyFailPrice(vlionLossBiddingReason);
                    }
                }
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public final void a(VlionServiceConfig.DataBean.AdBean.PlacementBean placementBean) {
        char c10;
        ArrayList<cn.vlion.ad.inland.core.b> arrayList;
        cn.vlion.ad.inland.core.b bVar;
        try {
            this.f3630x = VlionServiceConfigParse.getInstance().isCacheStatusOPen();
            this.f3619m = placementBean.getIsBiding().booleanValue();
            List<VlionServiceConfig.DataBean.AdBean.PlacementBean.SourcesBean> sources = placementBean.getSources();
            if (sources != null && sources.size() > 0) {
                this.f3631y = UUID.randomUUID().toString();
                LogVlion.e("VlionBaseLoadAdSource intArray    ad_trace ====" + this.f3631y);
                for (int i10 = 0; i10 < sources.size(); i10++) {
                    VlionServiceConfig.DataBean.AdBean.PlacementBean.SourcesBean sourcesBean = sources.get(i10);
                    if (sourcesBean != null) {
                        VlionServiceConfig.DataBean.AdBean.PlacementBean.SourcesBean.ConfigBean config = sourcesBean.getConfig();
                        if (config != null) {
                            String platformName = sourcesBean.getPlatformName();
                            switch (platformName.hashCode()) {
                                case 2371:
                                    if (platformName.equals("JM")) {
                                        c10 = 1;
                                        break;
                                    }
                                    c10 = 65535;
                                    break;
                                case 2732:
                                    if (platformName.equals("VB")) {
                                        c10 = 5;
                                        break;
                                    }
                                    c10 = 65535;
                                    break;
                                case 2741:
                                    if (platformName.equals("VK")) {
                                        c10 = 6;
                                        break;
                                    }
                                    c10 = 65535;
                                    break;
                                case 2742:
                                    if (platformName.equals("VL")) {
                                        c10 = 0;
                                        break;
                                    }
                                    c10 = 65535;
                                    break;
                                case 84915:
                                    if (platformName.equals("VGD")) {
                                        c10 = 3;
                                        break;
                                    }
                                    c10 = 65535;
                                    break;
                                case 84924:
                                    if (platformName.equals("VGM")) {
                                        c10 = 2;
                                        break;
                                    }
                                    c10 = 65535;
                                    break;
                                case 85039:
                                    if (platformName.equals("VKD")) {
                                        c10 = 7;
                                        break;
                                    }
                                    c10 = 65535;
                                    break;
                                case 85315:
                                    if (platformName.equals("VTA")) {
                                        c10 = 4;
                                        break;
                                    }
                                    c10 = 65535;
                                    break;
                                default:
                                    c10 = 65535;
                                    break;
                            }
                            switch (c10) {
                                case 0:
                                    if (k0.i()) {
                                        if (sources.size() == 1) {
                                            this.f3620n = true;
                                        }
                                        if (!a(sourcesBean, this.f3615i)) {
                                            if (config.getIs_bid().booleanValue()) {
                                                arrayList = this.f3612f;
                                                bVar = new cn.vlion.ad.inland.core.b(new VlionCustomAdapter(), placementBean, sourcesBean, this.f3615i, this.f3631y);
                                            } else {
                                                arrayList = this.f3613g;
                                                bVar = new cn.vlion.ad.inland.core.b(new VlionCustomAdapter(), placementBean, sourcesBean, this.f3615i, this.f3631y);
                                            }
                                            arrayList.add(bVar);
                                            break;
                                        }
                                        this.f3617k = true;
                                        break;
                                    } else {
                                        break;
                                    }
                                case 1:
                                    if (k0.g()) {
                                        if (!a(sourcesBean, this.f3615i)) {
                                            if (config.getIs_bid().booleanValue()) {
                                                arrayList = this.f3612f;
                                                bVar = new cn.vlion.ad.inland.core.b(new VlionJDAdapter(), placementBean, sourcesBean, this.f3615i, this.f3631y);
                                            } else {
                                                arrayList = this.f3613g;
                                                bVar = new cn.vlion.ad.inland.core.b(new VlionJDAdapter(), placementBean, sourcesBean, this.f3615i, this.f3631y);
                                            }
                                            arrayList.add(bVar);
                                            break;
                                        }
                                        this.f3617k = true;
                                        break;
                                    } else {
                                        break;
                                    }
                                case 2:
                                    if (k0.c()) {
                                        if (!a(sourcesBean, this.f3615i)) {
                                            if (config.getIs_bid().booleanValue()) {
                                                arrayList = this.f3612f;
                                                bVar = new cn.vlion.ad.inland.core.b(new VlionCsAdapter(), placementBean, sourcesBean, this.f3615i, this.f3631y);
                                            } else {
                                                arrayList = this.f3613g;
                                                bVar = new cn.vlion.ad.inland.core.b(new VlionCsAdapter(), placementBean, sourcesBean, this.f3615i, this.f3631y);
                                            }
                                            arrayList.add(bVar);
                                            break;
                                        }
                                        this.f3617k = true;
                                        break;
                                    } else {
                                        break;
                                    }
                                case 3:
                                    if (k0.d()) {
                                        if (!a(sourcesBean, this.f3615i)) {
                                            if (config.getIs_bid().booleanValue()) {
                                                arrayList = this.f3612f;
                                                bVar = new cn.vlion.ad.inland.core.b(new VlionGdAdapter(), placementBean, sourcesBean, this.f3615i, this.f3631y);
                                            } else {
                                                arrayList = this.f3613g;
                                                bVar = new cn.vlion.ad.inland.core.b(new VlionGdAdapter(), placementBean, sourcesBean, this.f3615i, this.f3631y);
                                            }
                                            arrayList.add(bVar);
                                            break;
                                        }
                                        this.f3617k = true;
                                        break;
                                    } else {
                                        break;
                                    }
                                case 4:
                                    if (k0.e()) {
                                        if (!a(sourcesBean, this.f3615i)) {
                                            if (config.getIs_bid().booleanValue()) {
                                                arrayList = this.f3612f;
                                                bVar = new cn.vlion.ad.inland.core.b(new VlionTaAdapter(), placementBean, sourcesBean, this.f3615i, this.f3631y);
                                            } else {
                                                arrayList = this.f3613g;
                                                bVar = new cn.vlion.ad.inland.core.b(new VlionTaAdapter(), placementBean, sourcesBean, this.f3615i, this.f3631y);
                                            }
                                            arrayList.add(bVar);
                                            break;
                                        }
                                        this.f3617k = true;
                                        break;
                                    } else {
                                        break;
                                    }
                                case 5:
                                    if (k0.b()) {
                                        if (!a(sourcesBean, this.f3615i)) {
                                            if (config.getIs_bid().booleanValue()) {
                                                arrayList = this.f3612f;
                                                bVar = new cn.vlion.ad.inland.core.b(new VlionBaAdapter(), placementBean, sourcesBean, this.f3615i, this.f3631y);
                                            } else {
                                                arrayList = this.f3613g;
                                                bVar = new cn.vlion.ad.inland.core.b(new VlionBaAdapter(), placementBean, sourcesBean, this.f3615i, this.f3631y);
                                            }
                                            arrayList.add(bVar);
                                            break;
                                        }
                                        this.f3617k = true;
                                        break;
                                    } else {
                                        break;
                                    }
                                case 6:
                                    if (k0.h()) {
                                        if (!a(sourcesBean, this.f3615i)) {
                                            if (config.getIs_bid().booleanValue()) {
                                                arrayList = this.f3612f;
                                                bVar = new cn.vlion.ad.inland.core.b(new VlionKuAdapter(), placementBean, sourcesBean, this.f3615i, this.f3631y);
                                            } else {
                                                arrayList = this.f3613g;
                                                bVar = new cn.vlion.ad.inland.core.b(new VlionKuAdapter(), placementBean, sourcesBean, this.f3615i, this.f3631y);
                                            }
                                            arrayList.add(bVar);
                                            break;
                                        }
                                        this.f3617k = true;
                                        break;
                                    } else {
                                        break;
                                    }
                                case 7:
                                    if (k0.f()) {
                                        if (sources.size() == 1) {
                                            this.f3620n = true;
                                        }
                                        if (!a(sourcesBean, this.f3615i)) {
                                            if (config.getIs_bid().booleanValue()) {
                                                arrayList = this.f3612f;
                                                bVar = new cn.vlion.ad.inland.core.b(new VlionKDAdapter(), placementBean, sourcesBean, this.f3615i, this.f3631y);
                                            } else {
                                                arrayList = this.f3613g;
                                                bVar = new cn.vlion.ad.inland.core.b(new VlionKDAdapter(), placementBean, sourcesBean, this.f3615i, this.f3631y);
                                            }
                                            arrayList.add(bVar);
                                            break;
                                        }
                                        this.f3617k = true;
                                        break;
                                    } else {
                                        break;
                                    }
                            }
                        } else {
                            return;
                        }
                    }
                }
            }
            if (this.f3612f.size() > 0) {
                LogVlion.e("VlionBaseLoadAdSource bidSize=" + this.f3612f.size());
                this.f3610d = new j(this.f3608b, this.f3609c, this.f3612f, this.f3630x);
            }
            if (this.f3613g.size() > 0) {
                LogVlion.e("VlionBaseLoadAdSource waterfallSize=" + this.f3613g.size());
                this.f3611e = new p0(this.f3608b, this.f3609c, this.f3613g, this.f3630x);
            }
            if (this.f3612f.isEmpty() && this.f3613g.isEmpty()) {
                LogVlion.e("VlionBaseLoadAdSource configBothEmpty=true");
                this.f3616j = true;
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public final void a(VlionNativesAdVideoListener vlionNativesAdVideoListener) {
        this.f3625s = vlionNativesAdVideoListener;
    }

    public final void a(VlionAdError vlionAdError) {
        LogVlion.e("VlionBaseLoadAdSource checkCallback FailResultSource=");
        a(vlionAdError, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x01ca  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x01d9 A[Catch: all -> 0x006d, TryCatch #1 {all -> 0x006d, blocks: (B:3:0x0001, B:8:0x002d, B:11:0x0040, B:13:0x0058, B:15:0x005c, B:16:0x00b7, B:19:0x00c8, B:22:0x00d7, B:24:0x00e5, B:26:0x00f7, B:27:0x0118, B:29:0x0132, B:30:0x013b, B:32:0x0158, B:35:0x015d, B:37:0x0161, B:38:0x0168, B:40:0x016c, B:42:0x0174, B:44:0x0178, B:46:0x0187, B:50:0x019f, B:52:0x01a3, B:54:0x01a9, B:55:0x01ab, B:56:0x01be, B:59:0x01cd, B:61:0x01d9, B:62:0x0224, B:64:0x0242, B:65:0x024d, B:67:0x0251, B:68:0x025e, B:70:0x0262, B:73:0x0271, B:74:0x01f5, B:77:0x0204, B:80:0x0211, B:83:0x01b0, B:85:0x01b4, B:87:0x01ba, B:91:0x0070, B:93:0x0079, B:95:0x007f, B:96:0x00b4, B:97:0x008a, B:99:0x008e, B:101:0x0094, B:103:0x0098, B:105:0x00aa), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0242 A[Catch: all -> 0x006d, TryCatch #1 {all -> 0x006d, blocks: (B:3:0x0001, B:8:0x002d, B:11:0x0040, B:13:0x0058, B:15:0x005c, B:16:0x00b7, B:19:0x00c8, B:22:0x00d7, B:24:0x00e5, B:26:0x00f7, B:27:0x0118, B:29:0x0132, B:30:0x013b, B:32:0x0158, B:35:0x015d, B:37:0x0161, B:38:0x0168, B:40:0x016c, B:42:0x0174, B:44:0x0178, B:46:0x0187, B:50:0x019f, B:52:0x01a3, B:54:0x01a9, B:55:0x01ab, B:56:0x01be, B:59:0x01cd, B:61:0x01d9, B:62:0x0224, B:64:0x0242, B:65:0x024d, B:67:0x0251, B:68:0x025e, B:70:0x0262, B:73:0x0271, B:74:0x01f5, B:77:0x0204, B:80:0x0211, B:83:0x01b0, B:85:0x01b4, B:87:0x01ba, B:91:0x0070, B:93:0x0079, B:95:0x007f, B:96:0x00b4, B:97:0x008a, B:99:0x008e, B:101:0x0094, B:103:0x0098, B:105:0x00aa), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x024d A[Catch: all -> 0x006d, TryCatch #1 {all -> 0x006d, blocks: (B:3:0x0001, B:8:0x002d, B:11:0x0040, B:13:0x0058, B:15:0x005c, B:16:0x00b7, B:19:0x00c8, B:22:0x00d7, B:24:0x00e5, B:26:0x00f7, B:27:0x0118, B:29:0x0132, B:30:0x013b, B:32:0x0158, B:35:0x015d, B:37:0x0161, B:38:0x0168, B:40:0x016c, B:42:0x0174, B:44:0x0178, B:46:0x0187, B:50:0x019f, B:52:0x01a3, B:54:0x01a9, B:55:0x01ab, B:56:0x01be, B:59:0x01cd, B:61:0x01d9, B:62:0x0224, B:64:0x0242, B:65:0x024d, B:67:0x0251, B:68:0x025e, B:70:0x0262, B:73:0x0271, B:74:0x01f5, B:77:0x0204, B:80:0x0211, B:83:0x01b0, B:85:0x01b4, B:87:0x01ba, B:91:0x0070, B:93:0x0079, B:95:0x007f, B:96:0x00b4, B:97:0x008a, B:99:0x008e, B:101:0x0094, B:103:0x0098, B:105:0x00aa), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01f5 A[Catch: all -> 0x006d, TryCatch #1 {all -> 0x006d, blocks: (B:3:0x0001, B:8:0x002d, B:11:0x0040, B:13:0x0058, B:15:0x005c, B:16:0x00b7, B:19:0x00c8, B:22:0x00d7, B:24:0x00e5, B:26:0x00f7, B:27:0x0118, B:29:0x0132, B:30:0x013b, B:32:0x0158, B:35:0x015d, B:37:0x0161, B:38:0x0168, B:40:0x016c, B:42:0x0174, B:44:0x0178, B:46:0x0187, B:50:0x019f, B:52:0x01a3, B:54:0x01a9, B:55:0x01ab, B:56:0x01be, B:59:0x01cd, B:61:0x01d9, B:62:0x0224, B:64:0x0242, B:65:0x024d, B:67:0x0251, B:68:0x025e, B:70:0x0262, B:73:0x0271, B:74:0x01f5, B:77:0x0204, B:80:0x0211, B:83:0x01b0, B:85:0x01b4, B:87:0x01ba, B:91:0x0070, B:93:0x0079, B:95:0x007f, B:96:0x00b4, B:97:0x008a, B:99:0x008e, B:101:0x0094, B:103:0x0098, B:105:0x00aa), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x01cc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final synchronized void a(cn.vlion.ad.inland.core.config.VlionAdError r8, boolean r9) {
        /*
            Method dump skipped, instructions count: 653
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.vlion.ad.inland.core.i.a(cn.vlion.ad.inland.core.config.VlionAdError, boolean):void");
    }

    public final void a(g0.a aVar) {
        this.f3623q = aVar;
    }

    public final void a(h0.a aVar) {
        this.f3624r = aVar;
    }

    public final void a(l lVar) {
        this.f3622p = lVar;
    }

    public final synchronized void a(boolean z10) {
        p0 p0Var;
        try {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("VlionBaseLoadAdSource loadTimeOver isServiceTimeOut=");
            sb2.append(z10);
            sb2.append("  (null != vlionWaterfallAdSource)=");
            sb2.append(this.f3611e != null);
            LogVlion.e(sb2.toString());
            if (!z10 && (p0Var = this.f3611e) != null) {
                p0Var.h();
            }
            a((VlionAdError) null, z10);
        } finally {
        }
    }

    public final boolean a(double d10) {
        try {
            if (this.f3613g == null) {
                return false;
            }
            LogVlion.e("VlionBaseLoadAdSource isWaterfallLoad  waterfallBaseAdAdapters.size=" + this.f3613g.size());
            if (this.f3613g.isEmpty()) {
                return false;
            }
            ArrayList arrayList = new ArrayList();
            for (int i10 = 0; i10 < this.f3613g.size(); i10++) {
                cn.vlion.ad.inland.core.b bVar = this.f3613g.get(i10);
                if (bVar != null) {
                    LogVlion.e("VlionBaseLoadAdSource isWaterfallLoad  baseAdSourceData.getPrice()=" + bVar.i() + " bidPrice=" + d10);
                    if (bVar.i() > d10) {
                        LogVlion.e("VlionBaseLoadAdSource isWaterfallLoad  exchange=");
                        arrayList.add(bVar);
                    }
                }
            }
            LogVlion.e("VlionBaseLoadAdSource isWaterfallLoad  waterfallMAxBaseAdAdapters.isEmpty()=" + arrayList.size());
            if (arrayList.isEmpty()) {
                return false;
            }
            this.f3611e = new p0(this.f3608b, this.f3609c, arrayList, this.f3630x);
            return true;
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
            return false;
        }
    }

    public static boolean a(VlionAdapterADConfig vlionAdapterADConfig, String str) {
        if (vlionAdapterADConfig != null && str != null) {
            try {
                if (str.equals("VL")) {
                    LogVlion.e("isClickBack ====  PlatformName =" + str);
                    LogVlion.e("isClickBack ====  getAutoJumpPercent =" + vlionAdapterADConfig.getClickBackPercent());
                    if (vlionAdapterADConfig.getClickBackPercent() == 100) {
                        return true;
                    }
                    int nextInt = new Random().nextInt(100);
                    LogVlion.e("isClickBack =====randomNumber =" + nextInt + "     getAutoJumpPercent =" + vlionAdapterADConfig.getClickBackPercent());
                    if (nextInt > vlionAdapterADConfig.getClickBackPercent()) {
                        LogVlion.e("isClickBack ==return===false =");
                        vlionAdapterADConfig.setClickBackPercent(100);
                        return false;
                    }
                    vlionAdapterADConfig.setClickBackPercent(100);
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }
        return true;
    }

    public static boolean a(VlionServiceConfig.DataBean.AdBean.PlacementBean.SourcesBean sourcesBean, j0 j0Var) {
        int i10;
        int i11;
        VlionAdLimitStrategyBean.AdLimitStrategyBean a10;
        if (j0Var != null) {
            try {
                VlionAdLimitStrategyBean strategyBean = VlionAdLimitStrategyUtils.getInstance().getStrategyBean(j0Var.e());
                if (strategyBean == null) {
                    return false;
                }
                List<VlionAdLimitStrategyBean.AdLimitStrategyBean> adLimitStrategyBean = strategyBean.getAdLimitStrategyBean();
                if (adLimitStrategyBean == null) {
                    adLimitStrategyBean = new ArrayList<>();
                }
                LogVlion.e("频控策略 : VlionBaseAdSource  itembean.getShowId()=" + j0Var.e());
                LogVlion.e("频控策略 : VlionBaseAdSource  itembean.getPlatformName()=" + sourcesBean.getPlatformName());
                VlionServiceConfig.DataBean.AdBean.PlacementBean.SourcesBean.FrequencyStrategyBean frequencyStrategy = sourcesBean.getFrequencyStrategy();
                if (frequencyStrategy != null) {
                    i11 = frequencyStrategy.getLimitNum();
                    i10 = frequencyStrategy.getTimeSpan();
                } else {
                    i10 = 0;
                    i11 = 0;
                }
                if (i11 > 0 && (a10 = a(adLimitStrategyBean, sourcesBean.getPlatformName())) != null) {
                    long currentTimeMillis = (System.currentTimeMillis() / 1000) - a10.getLasttime();
                    boolean z10 = currentTimeMillis <= ((long) i10);
                    LogVlion.e("频控策略 : VlionBaseAdSource (currentTime -recordTime)=" + currentTimeMillis + " 后台设置时长控制：" + i10 + " 是否限制 ：" + z10);
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("频控策略 : VlionBaseAdSource  本机记录频次=");
                    sb2.append(a10.getCount());
                    sb2.append(" 后台设置频次：");
                    sb2.append(i11);
                    sb2.append(" 是否限制 ：");
                    sb2.append(a10.getCount() > i11);
                    LogVlion.e(sb2.toString());
                    if (z10 || a10.getCount() > i11) {
                        LogVlion.e("频控策略 : VlionBaseAdSource  频次控制生效 删除广告源 ：" + a10.getAdSrcName());
                        return true;
                    }
                }
                strategyBean.setAdLimitStrategyBean(adLimitStrategyBean);
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }
        return false;
    }
}
