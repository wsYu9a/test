package cn.vlion.ad.inland.base;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import cn.vlion.ad.inland.ad.config.VlionCustomAdActiveType$VlionCustomTarget;
import cn.vlion.ad.inland.ad.javabean.VlionCustomAdData;
import cn.vlion.ad.inland.ad.javabean.VlionCustomParseAdData;
import cn.vlion.ad.inland.ad.natives.VlionCustomsNativeEventListener;
import cn.vlion.ad.inland.ad.natives.VlionNativeViewEventManager;
import cn.vlion.ad.inland.ad.utils.VlionCustomSpitUtils;
import cn.vlion.ad.inland.ad.utils.sensor.SensorManagerManager;
import cn.vlion.ad.inland.ad.utils.sensor.VlionSensorBean;
import cn.vlion.ad.inland.ad.utils.sensor.VlionSensorManagerHelper;
import cn.vlion.ad.inland.ad.utils.sensor.VlionSensorPara;
import cn.vlion.ad.inland.ad.view.active.VlionShakeGuideLayout;
import cn.vlion.ad.inland.base.adapter.VlionBidderSource;
import cn.vlion.ad.inland.base.adapter.VlionLossBiddingReason;
import cn.vlion.ad.inland.base.bid.VlionNativeActionListener;
import cn.vlion.ad.inland.base.i0;
import cn.vlion.ad.inland.base.javabean.VlionADClickType;
import cn.vlion.ad.inland.base.javabean.VlionAdapterADConfig;
import cn.vlion.ad.inland.base.natives.VlionNativeADEventListener;
import cn.vlion.ad.inland.base.natives.VlionNativeAdData;
import cn.vlion.ad.inland.base.natives.VlionNativeAdImpMaterialListener;
import cn.vlion.ad.inland.base.natives.VlionNativesAdVideoListener;
import cn.vlion.ad.inland.base.util.VlionAdStrategyUtils;
import cn.vlion.ad.inland.base.util.config.VlionAdBaseError;
import cn.vlion.ad.inland.base.util.event.VlionADEventManager;
import cn.vlion.ad.inland.base.util.handle.VlionBaseParameterReplace;
import cn.vlion.ad.inland.base.util.handle.VlionShakeParameterReplace;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import cn.vlion.ad.inland.base.util.log.LogVlion;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/* loaded from: classes.dex */
public final class b4 extends VlionNativeAdImpMaterialListener {

    /* renamed from: d */
    public VlionSensorBean f2647d;

    /* renamed from: e */
    public VlionNativeViewEventManager f2648e;

    /* renamed from: f */
    public VlionNativeADEventListener f2649f;

    /* renamed from: g */
    public i0 f2650g;

    /* renamed from: h */
    public VlionShakeGuideLayout f2651h;

    /* renamed from: j */
    public int f2653j;

    /* renamed from: k */
    public int f2654k;

    /* renamed from: l */
    public long f2655l;

    /* renamed from: m */
    public long f2656m;

    /* renamed from: n */
    public VlionBaseParameterReplace f2657n;

    /* renamed from: o */
    public final /* synthetic */ VlionCustomParseAdData f2658o;

    /* renamed from: p */
    public final /* synthetic */ VlionNativeAdData f2659p;

    /* renamed from: q */
    public final /* synthetic */ z3 f2660q;

    /* renamed from: a */
    public boolean f2644a = false;

    /* renamed from: b */
    public boolean f2645b = false;

    /* renamed from: c */
    public boolean f2646c = false;

    /* renamed from: i */
    public boolean f2652i = false;

    public class a implements SensorManagerManager.OnShakeListener {

        /* renamed from: a */
        public final /* synthetic */ VlionCustomAdData.SeatbidBean.BidBean.McBean.CsBean f2661a;

        public a(VlionCustomAdData.SeatbidBean.BidBean.McBean.CsBean csBean) {
            this.f2661a = csBean;
        }

        @Override // cn.vlion.ad.inland.ad.utils.sensor.SensorManagerManager.OnShakeListener
        public final void onShake(boolean z10, VlionSensorPara vlionSensorPara) {
            try {
                LogVlion.e("端策略 : VlionCustomNativeAdManager onShake =");
                b4 b4Var = b4.this;
                if (b4Var.f2646c) {
                    return;
                }
                b4Var.f2646c = true;
                b4Var.a();
                b4 b4Var2 = b4.this;
                b4Var2.f2644a = false;
                b4Var2.f2647d = null;
                VlionShakeGuideLayout vlionShakeGuideLayout = b4Var2.f2651h;
                if (vlionShakeGuideLayout != null) {
                    vlionShakeGuideLayout.setVisibility(8);
                    b4.this.f2651h.destroy();
                    b4.this.f2651h = null;
                }
                VlionADClickType vlionADClickType = new VlionADClickType("shake", "", "main", "hotsplot", "");
                VlionShakeParameterReplace vlionShakeParameterReplace = new VlionShakeParameterReplace(b4.this.f2658o);
                vlionShakeParameterReplace.handleBaseParameter(b4.this.mrootView);
                vlionShakeParameterReplace.handleShakeParameter(z10, vlionSensorPara, vlionADClickType);
                vlionADClickType.setVlionBaseParameterReplace(vlionShakeParameterReplace);
                VlionCustomAdData.SeatbidBean.BidBean.McBean.CsBean csBean = this.f2661a;
                if (csBean != null) {
                    vlionADClickType.setDefaultAdStrategy(csBean.isD());
                    vlionADClickType.setTriggerParam(vlionADClickType.getTriggerParam() + this.f2661a.getTriggerParam());
                }
                b4.this.a(vlionADClickType);
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                b4 b4Var = b4.this;
                if (b4Var.mcontainerLayout == null || b4Var.f2651h == null) {
                    return;
                }
                ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
                j0.a(b4.this.f2651h);
                b4 b4Var2 = b4.this;
                b4Var2.mcontainerLayout.addView(b4Var2.f2651h, layoutParams);
                LogVlion.e("ShakeGuide -------1111111111111------=:");
                b4.this.f2651h.startAnimator(true);
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }
    }

    public class c implements i0.b {
        public c() {
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x00c6 A[Catch: all -> 0x009a, TryCatch #0 {all -> 0x009a, blocks: (B:2:0x0000, B:4:0x0008, B:9:0x009f, B:11:0x00c6, B:12:0x00ea, B:28:0x0092, B:17:0x0052, B:19:0x0056, B:22:0x005f, B:25:0x008d), top: B:1:0x0000, inners: #1 }] */
        @Override // cn.vlion.ad.inland.base.i0.b
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void a(java.lang.String r9, cn.vlion.ad.inland.ad.javabean.VlionCustomAdData.SeatbidBean.BidBean.McBean.CsBean r10) {
            /*
                r8 = this;
                cn.vlion.ad.inland.base.b4 r0 = cn.vlion.ad.inland.base.b4.this     // Catch: java.lang.Throwable -> L9a
                cn.vlion.ad.inland.base.z3 r0 = r0.f2660q     // Catch: java.lang.Throwable -> L9a
                cn.vlion.ad.inland.base.javabean.VlionAdapterADConfig r0 = r0.f3543d     // Catch: java.lang.Throwable -> L9a
                if (r0 == 0) goto Lf7
                java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L9a
                r0.<init>()     // Catch: java.lang.Throwable -> L9a
                java.lang.String r1 = "端策略 : onSwipeClick ---------： "
                r0.append(r1)     // Catch: java.lang.Throwable -> L9a
                r0.append(r9)     // Catch: java.lang.Throwable -> L9a
                java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L9a
                cn.vlion.ad.inland.base.util.log.LogVlion.e(r0)     // Catch: java.lang.Throwable -> L9a
                java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L9a
                r0.<init>()     // Catch: java.lang.Throwable -> L9a
                java.lang.String r1 = "端策略 : getStrategyBean ---------： "
                r0.append(r1)     // Catch: java.lang.Throwable -> L9a
                cn.vlion.ad.inland.base.util.VlionAdStrategyUtils r1 = cn.vlion.ad.inland.base.util.VlionAdStrategyUtils.getInstance()     // Catch: java.lang.Throwable -> L9a
                cn.vlion.ad.inland.base.b4 r2 = cn.vlion.ad.inland.base.b4.this     // Catch: java.lang.Throwable -> L9a
                cn.vlion.ad.inland.base.z3 r2 = r2.f2660q     // Catch: java.lang.Throwable -> L9a
                cn.vlion.ad.inland.base.javabean.VlionAdapterADConfig r2 = r2.f3543d     // Catch: java.lang.Throwable -> L9a
                java.lang.String r2 = r2.getAdxTagId()     // Catch: java.lang.Throwable -> L9a
                cn.vlion.ad.inland.base.javabean.VlionAdClickStrategyBean r1 = r1.getStrategyBean(r2)     // Catch: java.lang.Throwable -> L9a
                java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L9a
                r0.append(r1)     // Catch: java.lang.Throwable -> L9a
                java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L9a
                cn.vlion.ad.inland.base.util.log.LogVlion.e(r0)     // Catch: java.lang.Throwable -> L9a
                cn.vlion.ad.inland.base.javabean.VlionADClickType r0 = new cn.vlion.ad.inland.base.javabean.VlionADClickType     // Catch: java.lang.Throwable -> L9a
                cn.vlion.ad.inland.base.b4 r1 = cn.vlion.ad.inland.base.b4.this     // Catch: java.lang.Throwable -> L9a
                cn.vlion.ad.inland.base.i0 r1 = r1.f2650g     // Catch: java.lang.Throwable -> L9a
                java.lang.String r7 = ","
                if (r1 == 0) goto L9c
                java.lang.String r2 = r1.f2908u     // Catch: java.lang.Throwable -> L8b
                if (r2 == 0) goto L8d
                java.lang.String r3 = "click"
                boolean r2 = r2.equals(r3)     // Catch: java.lang.Throwable -> L8b
                if (r2 == 0) goto L5f
                goto L8d
            L5f:
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L8b
                r2.<init>()     // Catch: java.lang.Throwable -> L8b
                float r3 = r1.f2892e     // Catch: java.lang.Throwable -> L8b
                r2.append(r3)     // Catch: java.lang.Throwable -> L8b
                r2.append(r7)     // Catch: java.lang.Throwable -> L8b
                float r1 = r1.f2893f     // Catch: java.lang.Throwable -> L8b
                r2.append(r1)     // Catch: java.lang.Throwable -> L8b
                java.lang.String r1 = r2.toString()     // Catch: java.lang.Throwable -> L8b
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L8b
                r2.<init>()     // Catch: java.lang.Throwable -> L8b
                java.lang.String r3 = "ViewOnTouchDataUtils getDistanceXY="
                r2.append(r3)     // Catch: java.lang.Throwable -> L8b
                r2.append(r1)     // Catch: java.lang.Throwable -> L8b
                java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L8b
                cn.vlion.ad.inland.base.util.log.LogVlion.e(r2)     // Catch: java.lang.Throwable -> L8b
            L89:
                r3 = r1
                goto L9f
            L8b:
                r1 = move-exception
                goto L92
            L8d:
                java.lang.String r1 = r1.b()     // Catch: java.lang.Throwable -> L8b
                goto L89
            L92:
                cn.vlion.ad.inland.base.util.init.VlionSDkManager r2 = cn.vlion.ad.inland.base.util.init.VlionSDkManager.getInstance()     // Catch: java.lang.Throwable -> L9a
                r2.upLoadCatchException(r1)     // Catch: java.lang.Throwable -> L9a
                goto L9c
            L9a:
                r9 = move-exception
                goto Lf0
            L9c:
                java.lang.String r1 = ""
                goto L89
            L9f:
                java.lang.String r4 = "main"
                java.lang.String r5 = "hotsplot"
                java.lang.String r6 = ""
                r1 = r0
                r2 = r9
                r1.<init>(r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L9a
                cn.vlion.ad.inland.base.util.handle.VlionSwipeParameterReplace r9 = new cn.vlion.ad.inland.base.util.handle.VlionSwipeParameterReplace     // Catch: java.lang.Throwable -> L9a
                cn.vlion.ad.inland.base.b4 r1 = cn.vlion.ad.inland.base.b4.this     // Catch: java.lang.Throwable -> L9a
                cn.vlion.ad.inland.ad.javabean.VlionCustomParseAdData r1 = r1.f2658o     // Catch: java.lang.Throwable -> L9a
                r9.<init>(r1)     // Catch: java.lang.Throwable -> L9a
                cn.vlion.ad.inland.base.b4 r1 = cn.vlion.ad.inland.base.b4.this     // Catch: java.lang.Throwable -> L9a
                android.view.View r1 = r1.mrootView     // Catch: java.lang.Throwable -> L9a
                r9.handleBaseParameter(r1)     // Catch: java.lang.Throwable -> L9a
                cn.vlion.ad.inland.base.b4 r1 = cn.vlion.ad.inland.base.b4.this     // Catch: java.lang.Throwable -> L9a
                cn.vlion.ad.inland.base.i0 r1 = r1.f2650g     // Catch: java.lang.Throwable -> L9a
                r9.handleSwipeParameter(r1, r0)     // Catch: java.lang.Throwable -> L9a
                r0.setVlionBaseParameterReplace(r9)     // Catch: java.lang.Throwable -> L9a
                if (r10 == 0) goto Lea
                boolean r9 = r10.isD()     // Catch: java.lang.Throwable -> L9a
                r0.setDefaultAdStrategy(r9)     // Catch: java.lang.Throwable -> L9a
                java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L9a
                r9.<init>()     // Catch: java.lang.Throwable -> L9a
                java.lang.String r1 = r0.getTriggerParam()     // Catch: java.lang.Throwable -> L9a
                r9.append(r1)     // Catch: java.lang.Throwable -> L9a
                r9.append(r7)     // Catch: java.lang.Throwable -> L9a
                java.lang.String r10 = r10.getTriggerParam()     // Catch: java.lang.Throwable -> L9a
                r9.append(r10)     // Catch: java.lang.Throwable -> L9a
                java.lang.String r9 = r9.toString()     // Catch: java.lang.Throwable -> L9a
                r0.setTriggerParam(r9)     // Catch: java.lang.Throwable -> L9a
            Lea:
                cn.vlion.ad.inland.base.b4 r9 = cn.vlion.ad.inland.base.b4.this     // Catch: java.lang.Throwable -> L9a
                r9.a(r0)     // Catch: java.lang.Throwable -> L9a
                goto Lf7
            Lf0:
                cn.vlion.ad.inland.base.util.init.VlionSDkManager r10 = cn.vlion.ad.inland.base.util.init.VlionSDkManager.getInstance()
                r10.upLoadCatchException(r9)
            Lf7:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: cn.vlion.ad.inland.base.b4.c.a(java.lang.String, cn.vlion.ad.inland.ad.javabean.VlionCustomAdData$SeatbidBean$BidBean$McBean$CsBean):void");
        }
    }

    public class d implements VlionCustomsNativeEventListener {

        /* renamed from: a */
        public final /* synthetic */ ViewGroup f2665a;

        /* renamed from: b */
        public final /* synthetic */ VlionNativeADEventListener f2666b;

        public d(ViewGroup viewGroup, VlionNativeADEventListener vlionNativeADEventListener) {
            this.f2665a = viewGroup;
            this.f2666b = vlionNativeADEventListener;
        }

        @Override // cn.vlion.ad.inland.ad.natives.VlionCustomsNativeEventListener
        public final void isResume(boolean z10) {
            try {
                if (z10) {
                    b4 b4Var = b4.this;
                    b4Var.getClass();
                    try {
                        if (b4Var.f2644a) {
                            VlionSensorManagerHelper.getInstance().registerShakeListener(VlionSDkManager.getInstance().getApplication(), b4Var.f2647d);
                            LogVlion.e("端策略 :  ---注册摇一摇监听---= ");
                        }
                    } catch (Throwable th2) {
                        VlionSDkManager.getInstance().upLoadCatchException(th2);
                    }
                } else {
                    b4.this.a();
                }
            } catch (Throwable th3) {
                VlionSDkManager.getInstance().upLoadCatchException(th3);
            }
        }

        @Override // cn.vlion.ad.inland.ad.natives.VlionCustomsNativeEventListener
        public final void onAdEnter() {
            VlionADEventManager.getParameterEnter(b4.this.f2660q.f3543d);
        }

        @Override // cn.vlion.ad.inland.ad.natives.VlionCustomsNativeEventListener
        public final void onClick(VlionADClickType vlionADClickType) {
            b4.this.a(vlionADClickType);
        }

        @Override // cn.vlion.ad.inland.ad.natives.VlionCustomsNativeEventListener
        public final void onClose() {
            try {
                LogVlion.e("VlionCustomNativeAdManager onClose");
                VlionNativeActionListener vlionNativeActionListener = b4.this.f2660q.f3547h;
                if (vlionNativeActionListener != null) {
                    vlionNativeActionListener.onClose();
                }
                VlionNativeADEventListener vlionNativeADEventListener = this.f2666b;
                if (vlionNativeADEventListener != null) {
                    vlionNativeADEventListener.onClose();
                }
                b4.this.a();
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }

        @Override // cn.vlion.ad.inland.ad.natives.VlionCustomsNativeEventListener
        public final void onExposure() {
            try {
                LogVlion.e("VlionCustomNativeAdManager onAdExposure isReadyExposure=" + b4.this.f2660q.f2718a);
                b4 b4Var = b4.this;
                if (!b4Var.f2660q.f2718a) {
                    b4Var.f2655l = System.currentTimeMillis();
                    b4 b4Var2 = b4.this;
                    c5.a(b4Var2.f2658o, this.f2665a, b4Var2.f2655l, b4Var2.f2656m);
                    b4.this.f2660q.f2718a = true;
                    VlionNativeADEventListener vlionNativeADEventListener = this.f2666b;
                    if (vlionNativeADEventListener != null) {
                        vlionNativeADEventListener.onExposure();
                    }
                }
                VlionNativeActionListener vlionNativeActionListener = b4.this.f2660q.f3547h;
                if (vlionNativeActionListener != null) {
                    vlionNativeActionListener.onExposure();
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }
    }

    public class e implements VlionNativesAdVideoListener {
        public e() {
        }

        @Override // cn.vlion.ad.inland.base.natives.VlionNativesAdVideoListener
        public final void onAdVideoPlayError(String str) {
        }

        @Override // cn.vlion.ad.inland.base.natives.VlionNativesAdVideoListener
        public final void onProgressUpdate(int i10, int i11) {
            try {
                b4 b4Var = b4.this;
                b4Var.f2653j = i10;
                b4Var.f2654k = i11;
                VlionBaseParameterReplace vlionBaseParameterReplace = b4Var.f2657n;
                if (vlionBaseParameterReplace != null) {
                    vlionBaseParameterReplace.handleVideoPlayingParameter(i10);
                }
                LogVlion.e(" VlionCustomNativeAdManager 视频总时长：" + i11 + "  播放时长 ： " + i10);
                VlionCustomParseAdData vlionCustomParseAdData = b4.this.f2658o;
                if (vlionCustomParseAdData != null) {
                    List<VlionCustomAdData.SeatbidBean.BidBean.VideoBean.VmPTrackingBean> vm_p_tracking = vlionCustomParseAdData.getVideoBean().getVm_p_tracking();
                    b4 b4Var2 = b4.this;
                    c5.a(vm_p_tracking, i10, b4Var2.f2657n, b4Var2.f2658o);
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }

        @Override // cn.vlion.ad.inland.base.natives.VlionNativesAdVideoListener
        public final void onVideoAdComplete() {
            try {
                b4 b4Var = b4.this;
                b4Var.f2652i = true;
                VlionBaseParameterReplace vlionBaseParameterReplace = b4Var.f2657n;
                if (vlionBaseParameterReplace != null) {
                    vlionBaseParameterReplace.handleVideoFinishParameter(b4Var.f2654k);
                }
                LogVlion.e(" VlionCustomNativeAdManager VideoCompleted：");
                VlionCustomParseAdData vlionCustomParseAdData = b4.this.f2658o;
                if (vlionCustomParseAdData != null) {
                    List<String> vm_p_succ = vlionCustomParseAdData.getVideoBean().getVm_p_succ();
                    b4 b4Var2 = b4.this;
                    c5.a(vm_p_succ, b4Var2.f2657n, b4Var2.f2658o);
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
                LogVlion.e(" VlionCustomNativeAdManager VideoWillStart：");
                b4 b4Var = b4.this;
                VlionCustomParseAdData vlionCustomParseAdData = b4Var.f2658o;
                if (vlionCustomParseAdData != null) {
                    b4Var.f2657n = new VlionBaseParameterReplace(vlionCustomParseAdData);
                    b4 b4Var2 = b4.this;
                    b4Var2.f2657n.handleVideoStartParameter(b4Var2.f2652i, b4Var2.f2653j, b4Var2.f2658o.getDuration(), b4.this.f2660q.f3543d);
                }
                VlionCustomParseAdData vlionCustomParseAdData2 = b4.this.f2658o;
                if (vlionCustomParseAdData2 != null) {
                    List<String> vm_p_start = vlionCustomParseAdData2.getVideoBean().getVm_p_start();
                    b4 b4Var3 = b4.this;
                    c5.b(vm_p_start, b4Var3.f2657n, b4Var3.f2658o);
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

    public b4(z3 z3Var, VlionCustomParseAdData vlionCustomParseAdData, VlionNativeAdData vlionNativeAdData) {
        this.f2660q = z3Var;
        this.f2658o = vlionCustomParseAdData;
        this.f2659p = vlionNativeAdData;
    }

    public final void a() {
        try {
            if (this.f2644a) {
                VlionSensorManagerHelper.getInstance().unregisterShakeListener(this.f2647d);
                LogVlion.e("端策略 :  ---移除摇一摇监听---= ");
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.natives.VlionNativeAdImpMaterialListener, cn.vlion.ad.inland.base.natives.VlionNativeAdMaterialListener
    public final void destroy() {
        super.destroy();
        try {
            i0 i0Var = this.f2650g;
            if (i0Var != null) {
                i0Var.a();
                this.f2650g = null;
            }
            a();
            VlionNativeViewEventManager vlionNativeViewEventManager = this.f2648e;
            if (vlionNativeViewEventManager != null) {
                vlionNativeViewEventManager.destroy();
                this.f2648e = null;
            }
            r6 r6Var = this.f2660q.f3545f;
            if (r6Var != null) {
                try {
                    q6 q6Var = r6Var.f3358a;
                    if (q6Var != null) {
                        q6Var.cancel();
                        r6Var.f3358a = null;
                    }
                } catch (Throwable th2) {
                    VlionSDkManager.getInstance().upLoadCatchException(th2);
                }
                this.f2660q.f3545f = null;
            }
        } catch (Throwable th3) {
            VlionSDkManager.getInstance().upLoadCatchException(th3);
        }
    }

    @Override // cn.vlion.ad.inland.base.natives.VlionNativeAdMaterialListener
    public final void notifyWinPrice(double d10, VlionBidderSource vlionBidderSource) {
        VlionNativeActionListener vlionNativeActionListener = this.f2660q.f3547h;
        if (vlionNativeActionListener != null) {
            vlionNativeActionListener.notifyWinPrice(d10, vlionBidderSource);
        }
        LogVlion.e("VlionCustomNativeAdManager notifyWinPrice");
    }

    @Override // cn.vlion.ad.inland.base.natives.VlionNativeAdMaterialListener
    public final void notifyWinPriceFailure(double d10, VlionBidderSource vlionBidderSource, VlionLossBiddingReason vlionLossBiddingReason) {
        VlionNativeActionListener vlionNativeActionListener = this.f2660q.f3547h;
        if (vlionNativeActionListener != null) {
            vlionNativeActionListener.notifyWinPriceFailure(d10, vlionBidderSource, vlionLossBiddingReason);
        }
        LogVlion.e("VlionCustomNativeAdManager price=" + d10);
    }

    @Override // cn.vlion.ad.inland.base.natives.VlionNativeAdImpMaterialListener, cn.vlion.ad.inland.base.natives.VlionNativeAdMaterialListener
    public final void onAdRender(Context context, VlionNativeAdData vlionNativeAdData) {
        super.onAdRender(context, vlionNativeAdData);
        VlionAdapterADConfig vlionAdapterADConfig = this.f2660q.f3543d;
        if (vlionAdapterADConfig == null || this.f2658o == null || this.mcontainerLayout == null) {
            return;
        }
        try {
            ArrayList<String> splitString = VlionCustomSpitUtils.getSplitString(vlionAdapterADConfig.getCreativeType());
            if (splitString.size() > 0) {
                for (int i10 = 0; i10 < splitString.size(); i10++) {
                    if ("2".equals(splitString.get(i10))) {
                        if (!this.f2646c) {
                            this.f2644a = true;
                        }
                    } else if ("5".equals(splitString.get(i10))) {
                        this.f2645b = true;
                    }
                }
            }
            VlionCustomParseAdData vlionCustomParseAdData = this.f2658o;
            if (vlionCustomParseAdData != null) {
                if (vlionCustomParseAdData.getCsBean(2, -1) == null) {
                    this.f2644a = false;
                }
                if (this.f2658o.getCsBean(5, -1) == null) {
                    this.f2645b = false;
                }
            }
            if (this.f2644a) {
                if (this.f2647d == null) {
                    VlionCustomAdData.SeatbidBean.BidBean.McBean.CsBean csBean = this.f2658o.getCsBean(2, -1);
                    if (csBean == null) {
                        csBean = this.f2658o.getDefaultShakeCsBean();
                    }
                    this.f2647d = new VlionSensorBean(csBean.getAcc(), csBean.getAng(), csBean.getDui(), new a(csBean));
                }
                if (this.f2651h == null) {
                    this.f2651h = new VlionShakeGuideLayout(this.mcontainerLayout.getContext());
                }
                l5 l5Var = this.mcontainerLayout;
                if (l5Var != null) {
                    l5Var.removeView(this.f2651h);
                    this.mcontainerLayout.post(new b());
                }
            }
            if (this.f2645b) {
                if (this.f2650g == null) {
                    this.f2650g = new i0(this.mcontainerLayout);
                }
                this.f2650g.a(this.mcontainerLayout, this.f2658o.getCsBean(5, -1), new c());
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.natives.VlionNativeAdImpMaterialListener, cn.vlion.ad.inland.base.natives.VlionNativeAdMaterialListener
    public final void onNativeAdRenderFailure(VlionAdBaseError vlionAdBaseError) {
        try {
            VlionNativeActionListener vlionNativeActionListener = this.f2660q.f3547h;
            if (vlionNativeActionListener != null) {
                vlionNativeActionListener.onAdRenderFailure(vlionAdBaseError);
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.natives.VlionNativeAdImpMaterialListener, cn.vlion.ad.inland.base.natives.VlionNativeAdMaterialListener
    public final void onNativeAdRenderSuccess() {
        this.f2656m = System.currentTimeMillis();
        VlionNativeActionListener vlionNativeActionListener = this.f2660q.f3547h;
        if (vlionNativeActionListener != null) {
            vlionNativeActionListener.onAdRenderSuccess();
        }
    }

    @Override // cn.vlion.ad.inland.base.natives.VlionNativeAdImpMaterialListener, cn.vlion.ad.inland.base.natives.VlionNativeAdMaterialListener
    public final void registerNativeView(Activity activity, ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, VlionNativeADEventListener vlionNativeADEventListener) {
        l5 l5Var;
        super.registerNativeView(activity, viewGroup, list, list2, list3, vlionNativeADEventListener);
        try {
            LogVlion.e("VlionCustomNativeAdManager registerNativeView=");
            this.f2649f = vlionNativeADEventListener;
            VlionADEventManager.getParameterShow(this.f2660q.f3543d, "VlionCustomNativeAdManager");
            this.f2648e = new VlionNativeViewEventManager(activity, viewGroup, list, list3, this.f2658o.getmDefaultVal(), this.f2658o.getMacroValues(), new d(viewGroup, vlionNativeADEventListener));
            if (this.f2659p.getVlionNativeType() != 4 || (l5Var = this.mcontainerLayout) == null) {
                return;
            }
            l5Var.setAdVlionVideoListener(new e());
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
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

    public static void a(b4 b4Var, VlionADClickType vlionADClickType) {
        VlionAdapterADConfig vlionAdapterADConfig;
        VlionCustomParseAdData vlionCustomParseAdData;
        b4Var.getClass();
        try {
            z3 z3Var = b4Var.f2660q;
            Context context = z3Var.f3542c;
            if (context != null && (vlionAdapterADConfig = z3Var.f3543d) != null && (vlionCustomParseAdData = b4Var.f2658o) != null) {
                VlionCustomAdActiveType$VlionCustomTarget a10 = z3Var.f3546g.a(context, vlionAdapterADConfig, vlionCustomParseAdData, new d4(b4Var));
                if (a10 != null && vlionADClickType != null) {
                    vlionADClickType.setTarget(a10.toString());
                }
                if (vlionADClickType != null) {
                    z3 z3Var2 = b4Var.f2660q;
                    q0 q0Var = z3Var2.f3546g;
                    Context context2 = z3Var2.f3542c;
                    VlionCustomParseAdData vlionCustomParseAdData2 = b4Var.f2658o;
                    q0Var.getClass();
                    vlionADClickType.setIsCanOpenDp(q0.a(context2, vlionCustomParseAdData2));
                }
                VlionAdapterADConfig vlionAdapterADConfig2 = b4Var.f2660q.f3543d;
                if (vlionAdapterADConfig2 != null) {
                    vlionAdapterADConfig2.setVlionADClickType(vlionADClickType);
                }
                if (!b4Var.f2660q.f2719b) {
                    if (vlionADClickType.getVlionBaseParameterReplace() != null) {
                        if (b4Var.f2658o.isVideo()) {
                            vlionADClickType.getVlionBaseParameterReplace().handleVideoParameter(b4Var.f2652i, b4Var.f2653j, b4Var.f2654k);
                        }
                        vlionADClickType.getVlionBaseParameterReplace().handleExposureParameter(b4Var.f2655l);
                        vlionADClickType.getVlionBaseParameterReplace().handleRenderSuccessParameter(b4Var.f2656m);
                    }
                    c5.a(b4Var.f2658o, vlionADClickType);
                    if (TextUtils.equals(VlionCustomAdActiveType$VlionCustomTarget.deeplink.toString(), vlionADClickType.getTarget())) {
                        c5.b(b4Var.f2658o, vlionADClickType);
                    }
                    z3 z3Var3 = b4Var.f2660q;
                    z3Var3.f2719b = true;
                    if (z3Var3.f3543d != null && !vlionADClickType.isDefaultAdStrategy()) {
                        VlionAdStrategyUtils.getInstance().setStrategyBean(b4Var.f2660q.f3543d.getAdxTagId());
                    }
                }
                LogVlion.e("VlionCustomNativeAdManager adButtonClickAction  onAdClick");
                VlionNativeActionListener vlionNativeActionListener = b4Var.f2660q.f3547h;
                if (vlionNativeActionListener != null) {
                    vlionNativeActionListener.onClick();
                }
                if (b4Var.f2649f != null) {
                    VlionAdapterADConfig vlionAdapterADConfig3 = b4Var.f2660q.f3543d;
                    if (a(vlionAdapterADConfig3, vlionAdapterADConfig3.getPlatform())) {
                        b4Var.f2649f.onClick();
                    }
                }
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public final void a(VlionADClickType vlionADClickType) {
        VlionCustomParseAdData vlionCustomParseAdData;
        try {
            LogVlion.e("VlionCustomNativeAdManager onAdClick");
            try {
                z3 z3Var = this.f2660q;
                Context context = z3Var.f3542c;
                if (context != null && (vlionCustomParseAdData = this.f2658o) != null) {
                    z3Var.f3546g.a(context, vlionCustomParseAdData.getDp(), this.f2658o.isIs_download(), new c4(this, vlionADClickType));
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        } catch (Throwable th3) {
            VlionSDkManager.getInstance().upLoadCatchException(th3);
        }
    }
}
