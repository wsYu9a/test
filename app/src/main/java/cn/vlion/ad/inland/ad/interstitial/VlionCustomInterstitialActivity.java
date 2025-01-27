package cn.vlion.ad.inland.ad.interstitial;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import cn.vlion.ad.inland.ad.base.VlionBaseAdView;
import cn.vlion.ad.inland.ad.config.VlionCustomAdActiveType$VlionCustomTarget;
import cn.vlion.ad.inland.ad.javabean.VlionCustomAdData;
import cn.vlion.ad.inland.ad.javabean.VlionCustomParseAdData;
import cn.vlion.ad.inland.ad.utils.apkdownload.DownloadApkData;
import cn.vlion.ad.inland.ad.utils.sensor.SensorManagerManager;
import cn.vlion.ad.inland.ad.utils.sensor.VlionSensorBean;
import cn.vlion.ad.inland.ad.utils.sensor.VlionSensorManagerHelper;
import cn.vlion.ad.inland.ad.utils.sensor.VlionSensorPara;
import cn.vlion.ad.inland.ad.view.download.VlionDownLoadSecondConfirmView;
import cn.vlion.ad.inland.base.R;
import cn.vlion.ad.inland.base.b0;
import cn.vlion.ad.inland.base.bid.VlionBiddingActionListener;
import cn.vlion.ad.inland.base.c5;
import cn.vlion.ad.inland.base.i0;
import cn.vlion.ad.inland.base.j1;
import cn.vlion.ad.inland.base.javabean.VlionADClickType;
import cn.vlion.ad.inland.base.javabean.VlionAdapterADConfig;
import cn.vlion.ad.inland.base.javabean.VlionServiceConfig;
import cn.vlion.ad.inland.base.q;
import cn.vlion.ad.inland.base.q0;
import cn.vlion.ad.inland.base.q3;
import cn.vlion.ad.inland.base.r3;
import cn.vlion.ad.inland.base.s0;
import cn.vlion.ad.inland.base.t5;
import cn.vlion.ad.inland.base.util.VlionHandlerUtils;
import cn.vlion.ad.inland.base.util.event.VlionADEventManager;
import cn.vlion.ad.inland.base.util.handle.VlionBaseParameterReplace;
import cn.vlion.ad.inland.base.util.handle.VlionClickParameterReplace;
import cn.vlion.ad.inland.base.util.handle.VlionShakeParameterReplace;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import cn.vlion.ad.inland.base.util.log.LogVlion;
import cn.vlion.ad.inland.base.v3;
import cn.vlion.ad.inland.base.w3;
import cn.vlion.ad.inland.base.x3;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Random;

/* loaded from: classes.dex */
public class VlionCustomInterstitialActivity extends Activity {
    public static j1 F;
    public static WeakReference<View> G;
    public static WeakReference<VlionCustomInterstitialActivity> H;
    public static VlionCustomParseAdData I;
    public static VlionAdapterADConfig J;
    public t5 D;

    /* renamed from: a */
    public i0 f2237a;

    /* renamed from: b */
    public i0 f2238b;

    /* renamed from: c */
    public VlionBaseAdView f2239c;

    /* renamed from: d */
    public FrameLayout f2240d;

    /* renamed from: e */
    public View f2241e;

    /* renamed from: g */
    public VlionSensorBean f2243g;

    /* renamed from: h */
    public x3 f2244h;

    /* renamed from: j */
    public boolean f2246j;

    /* renamed from: q */
    public VlionDownLoadSecondConfirmView f2253q;

    /* renamed from: r */
    public q0 f2254r;

    /* renamed from: t */
    public DownloadApkData f2256t;

    /* renamed from: x */
    public j f2260x;

    /* renamed from: y */
    public i f2261y;

    /* renamed from: z */
    public h f2262z;

    /* renamed from: f */
    public int f2242f = 0;

    /* renamed from: i */
    public int f2245i = 4;

    /* renamed from: k */
    public boolean f2247k = false;

    /* renamed from: l */
    public boolean f2248l = false;

    /* renamed from: m */
    public boolean f2249m = false;

    /* renamed from: n */
    public boolean f2250n = false;

    /* renamed from: o */
    public boolean f2251o = false;

    /* renamed from: p */
    public boolean f2252p = false;

    /* renamed from: s */
    public boolean f2255s = false;

    /* renamed from: u */
    public boolean f2257u = false;

    /* renamed from: v */
    public int f2258v = 0;

    /* renamed from: w */
    public int f2259w = 0;
    public boolean A = false;
    public boolean B = false;
    public boolean C = false;
    public boolean E = false;

    public class a implements i0.b {
        public a() {
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x00c0 A[Catch: all -> 0x0092, TryCatch #0 {all -> 0x0092, blocks: (B:2:0x0000, B:4:0x0004, B:9:0x0097, B:11:0x00c0, B:12:0x00e4, B:28:0x008a, B:17:0x004a, B:19:0x004e, B:22:0x0057, B:25:0x0085), top: B:1:0x0000, inners: #1 }] */
        @Override // cn.vlion.ad.inland.base.i0.b
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void a(java.lang.String r9, cn.vlion.ad.inland.ad.javabean.VlionCustomAdData.SeatbidBean.BidBean.McBean.CsBean r10) {
            /*
                r8 = this;
                cn.vlion.ad.inland.base.javabean.VlionAdapterADConfig r0 = cn.vlion.ad.inland.ad.interstitial.VlionCustomInterstitialActivity.J     // Catch: java.lang.Throwable -> L92
                if (r0 == 0) goto Lf1
                java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L92
                r0.<init>()     // Catch: java.lang.Throwable -> L92
                java.lang.String r1 = "端策略 : VlionCustomInterstitialActivity triggerType ---------： "
                r0.append(r1)     // Catch: java.lang.Throwable -> L92
                r0.append(r9)     // Catch: java.lang.Throwable -> L92
                java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L92
                cn.vlion.ad.inland.base.util.log.LogVlion.e(r0)     // Catch: java.lang.Throwable -> L92
                java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L92
                r0.<init>()     // Catch: java.lang.Throwable -> L92
                java.lang.String r1 = "端策略 : VlionCustomInterstitialActivity getStrategyBean ---------： "
                r0.append(r1)     // Catch: java.lang.Throwable -> L92
                cn.vlion.ad.inland.base.util.VlionAdStrategyUtils r1 = cn.vlion.ad.inland.base.util.VlionAdStrategyUtils.getInstance()     // Catch: java.lang.Throwable -> L92
                cn.vlion.ad.inland.base.javabean.VlionAdapterADConfig r2 = cn.vlion.ad.inland.ad.interstitial.VlionCustomInterstitialActivity.J     // Catch: java.lang.Throwable -> L92
                java.lang.String r2 = r2.getAdxTagId()     // Catch: java.lang.Throwable -> L92
                cn.vlion.ad.inland.base.javabean.VlionAdClickStrategyBean r1 = r1.getStrategyBean(r2)     // Catch: java.lang.Throwable -> L92
                java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L92
                r0.append(r1)     // Catch: java.lang.Throwable -> L92
                java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L92
                cn.vlion.ad.inland.base.util.log.LogVlion.e(r0)     // Catch: java.lang.Throwable -> L92
                cn.vlion.ad.inland.base.javabean.VlionADClickType r0 = new cn.vlion.ad.inland.base.javabean.VlionADClickType     // Catch: java.lang.Throwable -> L92
                cn.vlion.ad.inland.ad.interstitial.VlionCustomInterstitialActivity r1 = cn.vlion.ad.inland.ad.interstitial.VlionCustomInterstitialActivity.this     // Catch: java.lang.Throwable -> L92
                cn.vlion.ad.inland.base.i0 r1 = r1.f2238b     // Catch: java.lang.Throwable -> L92
                java.lang.String r7 = ","
                if (r1 == 0) goto L94
                java.lang.String r2 = r1.f2908u     // Catch: java.lang.Throwable -> L83
                if (r2 == 0) goto L85
                java.lang.String r3 = "click"
                boolean r2 = r2.equals(r3)     // Catch: java.lang.Throwable -> L83
                if (r2 == 0) goto L57
                goto L85
            L57:
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L83
                r2.<init>()     // Catch: java.lang.Throwable -> L83
                float r3 = r1.f2892e     // Catch: java.lang.Throwable -> L83
                r2.append(r3)     // Catch: java.lang.Throwable -> L83
                r2.append(r7)     // Catch: java.lang.Throwable -> L83
                float r1 = r1.f2893f     // Catch: java.lang.Throwable -> L83
                r2.append(r1)     // Catch: java.lang.Throwable -> L83
                java.lang.String r1 = r2.toString()     // Catch: java.lang.Throwable -> L83
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L83
                r2.<init>()     // Catch: java.lang.Throwable -> L83
                java.lang.String r3 = "ViewOnTouchDataUtils getDistanceXY="
                r2.append(r3)     // Catch: java.lang.Throwable -> L83
                r2.append(r1)     // Catch: java.lang.Throwable -> L83
                java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L83
                cn.vlion.ad.inland.base.util.log.LogVlion.e(r2)     // Catch: java.lang.Throwable -> L83
            L81:
                r3 = r1
                goto L97
            L83:
                r1 = move-exception
                goto L8a
            L85:
                java.lang.String r1 = r1.b()     // Catch: java.lang.Throwable -> L83
                goto L81
            L8a:
                cn.vlion.ad.inland.base.util.init.VlionSDkManager r2 = cn.vlion.ad.inland.base.util.init.VlionSDkManager.getInstance()     // Catch: java.lang.Throwable -> L92
                r2.upLoadCatchException(r1)     // Catch: java.lang.Throwable -> L92
                goto L94
            L92:
                r9 = move-exception
                goto Lea
            L94:
                java.lang.String r1 = ""
                goto L81
            L97:
                java.lang.String r4 = "main"
                java.lang.String r5 = "hotsplot"
                java.lang.String r6 = ""
                r1 = r0
                r2 = r9
                r1.<init>(r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L92
                cn.vlion.ad.inland.base.util.handle.VlionSwipeParameterReplace r9 = new cn.vlion.ad.inland.base.util.handle.VlionSwipeParameterReplace     // Catch: java.lang.Throwable -> L92
                cn.vlion.ad.inland.ad.javabean.VlionCustomParseAdData r1 = cn.vlion.ad.inland.ad.interstitial.VlionCustomInterstitialActivity.I     // Catch: java.lang.Throwable -> L92
                r9.<init>(r1)     // Catch: java.lang.Throwable -> L92
                cn.vlion.ad.inland.ad.interstitial.VlionCustomInterstitialActivity r1 = cn.vlion.ad.inland.ad.interstitial.VlionCustomInterstitialActivity.this     // Catch: java.lang.Throwable -> L92
                cn.vlion.ad.inland.base.x3 r1 = r1.f2244h     // Catch: java.lang.Throwable -> L92
                android.view.ViewGroup r1 = r1.getAdViewContainer()     // Catch: java.lang.Throwable -> L92
                r9.handleBaseParameter(r1)     // Catch: java.lang.Throwable -> L92
                cn.vlion.ad.inland.ad.interstitial.VlionCustomInterstitialActivity r1 = cn.vlion.ad.inland.ad.interstitial.VlionCustomInterstitialActivity.this     // Catch: java.lang.Throwable -> L92
                cn.vlion.ad.inland.base.i0 r1 = r1.f2238b     // Catch: java.lang.Throwable -> L92
                r9.handleSwipeParameter(r1, r0)     // Catch: java.lang.Throwable -> L92
                r0.setVlionBaseParameterReplace(r9)     // Catch: java.lang.Throwable -> L92
                if (r10 == 0) goto Le4
                boolean r9 = r10.isD()     // Catch: java.lang.Throwable -> L92
                r0.setDefaultAdStrategy(r9)     // Catch: java.lang.Throwable -> L92
                java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L92
                r9.<init>()     // Catch: java.lang.Throwable -> L92
                java.lang.String r1 = r0.getTriggerParam()     // Catch: java.lang.Throwable -> L92
                r9.append(r1)     // Catch: java.lang.Throwable -> L92
                r9.append(r7)     // Catch: java.lang.Throwable -> L92
                java.lang.String r10 = r10.getTriggerParam()     // Catch: java.lang.Throwable -> L92
                r9.append(r10)     // Catch: java.lang.Throwable -> L92
                java.lang.String r9 = r9.toString()     // Catch: java.lang.Throwable -> L92
                r0.setTriggerParam(r9)     // Catch: java.lang.Throwable -> L92
            Le4:
                cn.vlion.ad.inland.ad.interstitial.VlionCustomInterstitialActivity r9 = cn.vlion.ad.inland.ad.interstitial.VlionCustomInterstitialActivity.this     // Catch: java.lang.Throwable -> L92
                cn.vlion.ad.inland.ad.interstitial.VlionCustomInterstitialActivity.a(r9, r0)     // Catch: java.lang.Throwable -> L92
                goto Lf1
            Lea:
                cn.vlion.ad.inland.base.util.init.VlionSDkManager r10 = cn.vlion.ad.inland.base.util.init.VlionSDkManager.getInstance()
                r10.upLoadCatchException(r9)
            Lf1:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: cn.vlion.ad.inland.ad.interstitial.VlionCustomInterstitialActivity.a.a(java.lang.String, cn.vlion.ad.inland.ad.javabean.VlionCustomAdData$SeatbidBean$BidBean$McBean$CsBean):void");
        }
    }

    public class b implements i0.b {
        public b() {
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x00c0 A[Catch: all -> 0x0092, TryCatch #0 {all -> 0x0092, blocks: (B:2:0x0000, B:4:0x0004, B:9:0x0097, B:11:0x00c0, B:12:0x00e4, B:28:0x008a, B:17:0x004a, B:19:0x004e, B:22:0x0057, B:25:0x0085), top: B:1:0x0000, inners: #1 }] */
        @Override // cn.vlion.ad.inland.base.i0.b
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void a(java.lang.String r9, cn.vlion.ad.inland.ad.javabean.VlionCustomAdData.SeatbidBean.BidBean.McBean.CsBean r10) {
            /*
                r8 = this;
                cn.vlion.ad.inland.base.javabean.VlionAdapterADConfig r0 = cn.vlion.ad.inland.ad.interstitial.VlionCustomInterstitialActivity.J     // Catch: java.lang.Throwable -> L92
                if (r0 == 0) goto Lf1
                java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L92
                r0.<init>()     // Catch: java.lang.Throwable -> L92
                java.lang.String r1 = "端策略 : VlionCustomInterstitialActivity triggerType ---------： "
                r0.append(r1)     // Catch: java.lang.Throwable -> L92
                r0.append(r9)     // Catch: java.lang.Throwable -> L92
                java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L92
                cn.vlion.ad.inland.base.util.log.LogVlion.e(r0)     // Catch: java.lang.Throwable -> L92
                java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L92
                r0.<init>()     // Catch: java.lang.Throwable -> L92
                java.lang.String r1 = "端策略 : VlionCustomInterstitialActivity getStrategyBean ---------： "
                r0.append(r1)     // Catch: java.lang.Throwable -> L92
                cn.vlion.ad.inland.base.util.VlionAdStrategyUtils r1 = cn.vlion.ad.inland.base.util.VlionAdStrategyUtils.getInstance()     // Catch: java.lang.Throwable -> L92
                cn.vlion.ad.inland.base.javabean.VlionAdapterADConfig r2 = cn.vlion.ad.inland.ad.interstitial.VlionCustomInterstitialActivity.J     // Catch: java.lang.Throwable -> L92
                java.lang.String r2 = r2.getAdxTagId()     // Catch: java.lang.Throwable -> L92
                cn.vlion.ad.inland.base.javabean.VlionAdClickStrategyBean r1 = r1.getStrategyBean(r2)     // Catch: java.lang.Throwable -> L92
                java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L92
                r0.append(r1)     // Catch: java.lang.Throwable -> L92
                java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L92
                cn.vlion.ad.inland.base.util.log.LogVlion.e(r0)     // Catch: java.lang.Throwable -> L92
                cn.vlion.ad.inland.base.javabean.VlionADClickType r0 = new cn.vlion.ad.inland.base.javabean.VlionADClickType     // Catch: java.lang.Throwable -> L92
                cn.vlion.ad.inland.ad.interstitial.VlionCustomInterstitialActivity r1 = cn.vlion.ad.inland.ad.interstitial.VlionCustomInterstitialActivity.this     // Catch: java.lang.Throwable -> L92
                cn.vlion.ad.inland.base.i0 r1 = r1.f2237a     // Catch: java.lang.Throwable -> L92
                java.lang.String r7 = ","
                if (r1 == 0) goto L94
                java.lang.String r2 = r1.f2908u     // Catch: java.lang.Throwable -> L83
                if (r2 == 0) goto L85
                java.lang.String r3 = "click"
                boolean r2 = r2.equals(r3)     // Catch: java.lang.Throwable -> L83
                if (r2 == 0) goto L57
                goto L85
            L57:
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L83
                r2.<init>()     // Catch: java.lang.Throwable -> L83
                float r3 = r1.f2892e     // Catch: java.lang.Throwable -> L83
                r2.append(r3)     // Catch: java.lang.Throwable -> L83
                r2.append(r7)     // Catch: java.lang.Throwable -> L83
                float r1 = r1.f2893f     // Catch: java.lang.Throwable -> L83
                r2.append(r1)     // Catch: java.lang.Throwable -> L83
                java.lang.String r1 = r2.toString()     // Catch: java.lang.Throwable -> L83
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L83
                r2.<init>()     // Catch: java.lang.Throwable -> L83
                java.lang.String r3 = "ViewOnTouchDataUtils getDistanceXY="
                r2.append(r3)     // Catch: java.lang.Throwable -> L83
                r2.append(r1)     // Catch: java.lang.Throwable -> L83
                java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L83
                cn.vlion.ad.inland.base.util.log.LogVlion.e(r2)     // Catch: java.lang.Throwable -> L83
            L81:
                r3 = r1
                goto L97
            L83:
                r1 = move-exception
                goto L8a
            L85:
                java.lang.String r1 = r1.b()     // Catch: java.lang.Throwable -> L83
                goto L81
            L8a:
                cn.vlion.ad.inland.base.util.init.VlionSDkManager r2 = cn.vlion.ad.inland.base.util.init.VlionSDkManager.getInstance()     // Catch: java.lang.Throwable -> L92
                r2.upLoadCatchException(r1)     // Catch: java.lang.Throwable -> L92
                goto L94
            L92:
                r9 = move-exception
                goto Lea
            L94:
                java.lang.String r1 = ""
                goto L81
            L97:
                java.lang.String r4 = "main"
                java.lang.String r5 = "hotsplot"
                java.lang.String r6 = ""
                r1 = r0
                r2 = r9
                r1.<init>(r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L92
                cn.vlion.ad.inland.base.util.handle.VlionSwipeParameterReplace r9 = new cn.vlion.ad.inland.base.util.handle.VlionSwipeParameterReplace     // Catch: java.lang.Throwable -> L92
                cn.vlion.ad.inland.ad.javabean.VlionCustomParseAdData r1 = cn.vlion.ad.inland.ad.interstitial.VlionCustomInterstitialActivity.I     // Catch: java.lang.Throwable -> L92
                r9.<init>(r1)     // Catch: java.lang.Throwable -> L92
                cn.vlion.ad.inland.ad.interstitial.VlionCustomInterstitialActivity r1 = cn.vlion.ad.inland.ad.interstitial.VlionCustomInterstitialActivity.this     // Catch: java.lang.Throwable -> L92
                cn.vlion.ad.inland.base.x3 r1 = r1.f2244h     // Catch: java.lang.Throwable -> L92
                android.view.ViewGroup r1 = r1.getAdViewContainer()     // Catch: java.lang.Throwable -> L92
                r9.handleBaseParameter(r1)     // Catch: java.lang.Throwable -> L92
                cn.vlion.ad.inland.ad.interstitial.VlionCustomInterstitialActivity r1 = cn.vlion.ad.inland.ad.interstitial.VlionCustomInterstitialActivity.this     // Catch: java.lang.Throwable -> L92
                cn.vlion.ad.inland.base.i0 r1 = r1.f2237a     // Catch: java.lang.Throwable -> L92
                r9.handleSwipeParameter(r1, r0)     // Catch: java.lang.Throwable -> L92
                r0.setVlionBaseParameterReplace(r9)     // Catch: java.lang.Throwable -> L92
                if (r10 == 0) goto Le4
                boolean r9 = r10.isD()     // Catch: java.lang.Throwable -> L92
                r0.setDefaultAdStrategy(r9)     // Catch: java.lang.Throwable -> L92
                java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L92
                r9.<init>()     // Catch: java.lang.Throwable -> L92
                java.lang.String r1 = r0.getTriggerParam()     // Catch: java.lang.Throwable -> L92
                r9.append(r1)     // Catch: java.lang.Throwable -> L92
                r9.append(r7)     // Catch: java.lang.Throwable -> L92
                java.lang.String r10 = r10.getTriggerParam()     // Catch: java.lang.Throwable -> L92
                r9.append(r10)     // Catch: java.lang.Throwable -> L92
                java.lang.String r9 = r9.toString()     // Catch: java.lang.Throwable -> L92
                r0.setTriggerParam(r9)     // Catch: java.lang.Throwable -> L92
            Le4:
                cn.vlion.ad.inland.ad.interstitial.VlionCustomInterstitialActivity r9 = cn.vlion.ad.inland.ad.interstitial.VlionCustomInterstitialActivity.this     // Catch: java.lang.Throwable -> L92
                cn.vlion.ad.inland.ad.interstitial.VlionCustomInterstitialActivity.a(r9, r0)     // Catch: java.lang.Throwable -> L92
                goto Lf1
            Lea:
                cn.vlion.ad.inland.base.util.init.VlionSDkManager r10 = cn.vlion.ad.inland.base.util.init.VlionSDkManager.getInstance()
                r10.upLoadCatchException(r9)
            Lf1:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: cn.vlion.ad.inland.ad.interstitial.VlionCustomInterstitialActivity.b.a(java.lang.String, cn.vlion.ad.inland.ad.javabean.VlionCustomAdData$SeatbidBean$BidBean$McBean$CsBean):void");
        }
    }

    public class c implements View.OnClickListener {

        /* renamed from: a */
        public final /* synthetic */ i0 f2265a;

        public c(i0 i0Var) {
            this.f2265a = i0Var;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            try {
                VlionADClickType vlionADClickType = new VlionADClickType("click", b0.a(this.f2265a), "main", "hotsplot", "");
                VlionClickParameterReplace vlionClickParameterReplace = new VlionClickParameterReplace(VlionCustomInterstitialActivity.I);
                vlionClickParameterReplace.handleBaseParameter(VlionCustomInterstitialActivity.this.f2244h);
                vlionClickParameterReplace.handleClickParameter(this.f2265a, vlionADClickType);
                vlionADClickType.setVlionBaseParameterReplace(vlionClickParameterReplace);
                VlionCustomInterstitialActivity.b(VlionCustomInterstitialActivity.this, vlionADClickType);
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }
    }

    public class d implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ VlionServiceConfig.DataBean.ActivityTemplateBean f2267a;

        public class a implements ViewTreeObserver.OnPreDrawListener {
            public a() {
            }

            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public final boolean onPreDraw() {
                try {
                    x3 x3Var = VlionCustomInterstitialActivity.this.f2244h;
                    if (x3Var == null) {
                        return true;
                    }
                    x3Var.getViewTreeObserver().removeOnPreDrawListener(this);
                    d dVar = d.this;
                    VlionCustomInterstitialActivity.this.f2244h.a(dVar.f2267a.getMaterial_url());
                    return true;
                } catch (Throwable th2) {
                    VlionSDkManager.getInstance().upLoadCatchException(th2);
                    return true;
                }
            }
        }

        public d(VlionServiceConfig.DataBean.ActivityTemplateBean activityTemplateBean) {
            this.f2267a = activityTemplateBean;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                x3 x3Var = VlionCustomInterstitialActivity.this.f2244h;
                if (x3Var != null) {
                    x3Var.getViewTreeObserver().addOnPreDrawListener(new a());
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }
    }

    public class f implements cn.vlion.ad.inland.base.a {
        public f() {
        }

        @Override // cn.vlion.ad.inland.base.a
        public final void onAdEnter() {
            VlionADEventManager.getParameterEnter(VlionCustomInterstitialActivity.J);
        }

        @Override // cn.vlion.ad.inland.base.a
        public final void onAdExposure() {
            j1 j1Var = VlionCustomInterstitialActivity.F;
            if (j1Var != null) {
                VlionBaseAdView vlionBaseAdView = VlionCustomInterstitialActivity.this.f2239c;
                v3.a aVar = (v3.a) j1Var;
                try {
                    v3 v3Var = v3.this;
                    if (!v3Var.f2718a) {
                        v3Var.f3464l = System.currentTimeMillis();
                        v3 v3Var2 = v3.this;
                        c5.a(v3Var2.f3459g, vlionBaseAdView, v3Var2.f3464l, v3Var2.f3465m);
                        v3.this.f2718a = true;
                    }
                    VlionBiddingActionListener vlionBiddingActionListener = v3.this.f3456d;
                    if (vlionBiddingActionListener != null) {
                        vlionBiddingActionListener.onAdExposure();
                    }
                } catch (Throwable th2) {
                    VlionSDkManager.getInstance().upLoadCatchException(th2);
                }
            }
        }
    }

    public class g implements SensorManagerManager.OnShakeListener {

        /* renamed from: a */
        public final /* synthetic */ VlionCustomAdData.SeatbidBean.BidBean.McBean.CsBean f2272a;

        public g(VlionCustomAdData.SeatbidBean.BidBean.McBean.CsBean csBean) {
            this.f2272a = csBean;
        }

        @Override // cn.vlion.ad.inland.ad.utils.sensor.SensorManagerManager.OnShakeListener
        public final void onShake(boolean z10, VlionSensorPara vlionSensorPara) {
            try {
                LogVlion.e("端策略 : VlionCustomInterstitialActivity onShake =");
                VlionCustomInterstitialActivity vlionCustomInterstitialActivity = VlionCustomInterstitialActivity.this;
                if (vlionCustomInterstitialActivity.E) {
                    return;
                }
                vlionCustomInterstitialActivity.E = true;
                VlionSensorManagerHelper.getInstance().unregisterShakeListener(VlionCustomInterstitialActivity.this.f2243g);
                VlionCustomInterstitialActivity vlionCustomInterstitialActivity2 = VlionCustomInterstitialActivity.this;
                vlionCustomInterstitialActivity2.f2243g = null;
                vlionCustomInterstitialActivity2.f2247k = false;
                try {
                    x3 x3Var = vlionCustomInterstitialActivity2.f2244h;
                    if (x3Var != null) {
                        x3Var.a(vlionCustomInterstitialActivity2.a(false), vlionCustomInterstitialActivity2.f2247k);
                    }
                } catch (Throwable th2) {
                    VlionSDkManager.getInstance().upLoadCatchException(th2);
                }
                x3 x3Var2 = VlionCustomInterstitialActivity.this.f2244h;
                VlionADClickType vlionADClickType = (x3Var2 == null || !x3Var2.a()) ? new VlionADClickType("shake", "", "main", "", "") : new VlionADClickType("shake", "", "endcard", "", "");
                VlionShakeParameterReplace vlionShakeParameterReplace = new VlionShakeParameterReplace(VlionCustomInterstitialActivity.I);
                vlionShakeParameterReplace.handleBaseParameter(VlionCustomInterstitialActivity.this.f2244h);
                vlionShakeParameterReplace.handleShakeParameter(z10, vlionSensorPara, vlionADClickType);
                vlionADClickType.setVlionBaseParameterReplace(vlionShakeParameterReplace);
                VlionCustomAdData.SeatbidBean.BidBean.McBean.CsBean csBean = this.f2272a;
                if (csBean != null) {
                    vlionADClickType.setDefaultAdStrategy(csBean.isD());
                    vlionADClickType.setTriggerParam(vlionADClickType.getTriggerParam() + this.f2272a.getTriggerParam());
                }
                VlionCustomInterstitialActivity.a(VlionCustomInterstitialActivity.this, vlionADClickType);
            } catch (Throwable th3) {
                VlionSDkManager.getInstance().upLoadCatchException(th3);
            }
        }
    }

    public class h implements Runnable {

        /* renamed from: a */
        public int f2274a;

        public h(int i10) {
            this.f2274a = i10;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                LogVlion.e("VlionCustomInterstitialActivity TimeJump: time=" + this.f2274a);
                int i10 = this.f2274a;
                if (i10 != 0 || VlionCustomInterstitialActivity.this.f2244h == null) {
                    this.f2274a = i10 - 1;
                    VlionHandlerUtils.instant().postDelayed(this, 1000L);
                } else {
                    Random random = new Random();
                    VlionADClickType vlionADClickType = new VlionADClickType("aut_jump", "", "main", "", "");
                    i0 i0Var = new i0();
                    i0Var.f2909v = System.currentTimeMillis();
                    i0Var.f2910w = System.currentTimeMillis() + random.nextInt(1000);
                    i0Var.f2894g = random.nextInt(VlionCustomInterstitialActivity.this.f2244h.getWidth());
                    float nextInt = random.nextInt(VlionCustomInterstitialActivity.this.f2244h.getHeight());
                    i0Var.f2895h = nextInt;
                    i0Var.f2896i = i0Var.f2894g;
                    i0Var.f2897j = nextInt;
                    i0Var.f2888a = random.nextInt(VlionCustomInterstitialActivity.this.getWindow().getDecorView().getWidth());
                    float nextInt2 = random.nextInt(VlionCustomInterstitialActivity.this.getWindow().getDecorView().getHeight());
                    i0Var.f2889b = nextInt2;
                    i0Var.f2890c = i0Var.f2888a;
                    i0Var.f2891d = nextInt2;
                    VlionClickParameterReplace vlionClickParameterReplace = new VlionClickParameterReplace(VlionCustomInterstitialActivity.I);
                    vlionClickParameterReplace.handleBaseParameter(VlionCustomInterstitialActivity.this.f2244h);
                    vlionClickParameterReplace.handleClickParameter(i0Var, vlionADClickType);
                    vlionADClickType.setVlionBaseParameterReplace(vlionClickParameterReplace);
                    VlionCustomInterstitialActivity.a(VlionCustomInterstitialActivity.this, vlionADClickType);
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }
    }

    public class i implements Runnable {

        /* renamed from: a */
        public int f2276a;

        public i(int i10) {
            this.f2276a = i10;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                LogVlion.e("VlionCustomInterstitialActivity TimeCloseBtn: time=" + this.f2276a);
                int i10 = this.f2276a;
                if (i10 == 0) {
                    VlionCustomInterstitialActivity.this.f2244h.a(0);
                    return;
                }
                this.f2276a = i10 - 1;
                x3 x3Var = VlionCustomInterstitialActivity.this.f2244h;
                if (x3Var != null) {
                    x3Var.a(i10);
                }
                VlionHandlerUtils.instant().postDelayed(this, 1000L);
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }
    }

    public class j implements Runnable {

        /* renamed from: a */
        public int f2278a;

        public j(int i10) {
            this.f2278a = i10;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                LogVlion.e("VlionCustomInterstitialActivity TimeTick: time=" + this.f2278a);
                int i10 = this.f2278a;
                if (i10 == 0) {
                    VlionCustomInterstitialActivity.this.finish();
                    return;
                }
                this.f2278a = i10 - 1;
                x3 x3Var = VlionCustomInterstitialActivity.this.f2244h;
                if (x3Var != null) {
                    x3Var.b(i10);
                }
                VlionHandlerUtils.instant().postDelayed(this, 1000L);
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }
    }

    public final String a(boolean z10) {
        Resources resources;
        int i10;
        String str = "";
        try {
            if (I != null) {
                if (z10) {
                    if (this.f2252p) {
                        resources = getResources();
                        i10 = R.string.vlion_custom_ad_download_now_shake;
                    } else if (this.f2251o) {
                        resources = getResources();
                        i10 = R.string.vlion_custom_ad_download_now_shake_open;
                    } else {
                        resources = getResources();
                        i10 = R.string.vlion_custom_ad_click_now_shake_look;
                    }
                } else if (this.f2252p) {
                    resources = getResources();
                    i10 = R.string.vlion_custom_ad_click_download;
                } else if (this.f2251o) {
                    resources = getResources();
                    i10 = R.string.vlion_custom_ad_click_open;
                } else {
                    resources = getResources();
                    i10 = R.string.vlion_custom_ad_click_look;
                }
                str = resources.getString(i10);
            }
            return TextUtils.isEmpty(str) ? getResources().getString(R.string.vlion_custom_ad_click_look) : str;
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
            return "";
        }
    }

    public final void b() {
        try {
            LogVlion.e("VlionCustomInterstitialActivity initOrientation orientation=" + getResources().getConfiguration().orientation + " mAdOrientation=" + this.f2242f);
            if (1 == this.f2242f) {
                setRequestedOrientation(6);
            } else {
                setRequestedOrientation(1);
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public final void c() {
        try {
            VlionCustomParseAdData vlionCustomParseAdData = I;
            if (vlionCustomParseAdData == null || this.E) {
                return;
            }
            VlionCustomAdData.SeatbidBean.BidBean.McBean.CsBean csBean = vlionCustomParseAdData.getCsBean(2, -1);
            if (csBean == null) {
                csBean = I.getDefaultShakeCsBean();
            }
            this.f2243g = new VlionSensorBean(csBean.getAcc(), csBean.getAng(), csBean.getDui(), new g(csBean));
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public final void d() {
        try {
            x3 x3Var = this.f2244h;
            VlionCustomParseAdData vlionCustomParseAdData = I;
            x3Var.a(vlionCustomParseAdData, this.f2241e, vlionCustomParseAdData.isIs_download(), this.f2250n, this.f2245i, this.A, this.B, new e());
            this.f2239c.setAdExposureListener(new f());
            if (this.f2260x != null) {
                VlionHandlerUtils.instant().post(this.f2260x);
            }
            if (this.f2261y != null) {
                VlionHandlerUtils.instant().post(this.f2261y);
            }
            if (this.f2262z != null) {
                VlionHandlerUtils.instant().post(this.f2262z);
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            setContentView(R.layout.vlion_cn_ad_interstitial_view);
            Window window = getWindow();
            if (window != null) {
                WindowManager.LayoutParams attributes = window.getAttributes();
                if (attributes == null) {
                    attributes = new WindowManager.LayoutParams(-1, -1);
                }
                attributes.width = -1;
                attributes.height = -2;
                window.setAttributes(attributes);
                window.getDecorView().setBackgroundResource(android.R.color.transparent);
                window.setBackgroundDrawableResource(android.R.color.transparent);
            }
            this.f2239c = (VlionBaseAdView) findViewById(R.id.vb_frameLayout);
            this.f2240d = (FrameLayout) findViewById(R.id.vlion_ad_inter_view_container);
            this.f2253q = (VlionDownLoadSecondConfirmView) findViewById(R.id.vlionDownLoadSecondConfirmView);
            H = new WeakReference<>(this);
            VlionADEventManager.getParameterShow(J, "VlionCustomInterstitialActivity");
            this.f2239c.b();
            WeakReference<View> weakReference = G;
            if (weakReference != null) {
                this.f2241e = weakReference.get();
            }
            VlionAdapterADConfig vlionAdapterADConfig = J;
            if (vlionAdapterADConfig != null && I != null) {
                this.f2242f = vlionAdapterADConfig.getScreenType();
                this.f2245i = J.getImageScale();
                this.f2250n = I.isVideo();
                boolean isIs_download = I.isIs_download();
                boolean a10 = q.a(getApplicationContext(), I.getDp());
                this.f2251o = a10;
                this.f2252p = !a10 && isIs_download;
                this.f2254r = new q0();
                if (isIs_download) {
                    DownloadApkData downloadApkData = new DownloadApkData(I, J);
                    this.f2256t = downloadApkData;
                    this.f2254r.f3297a = downloadApkData;
                }
                this.f2259w = J.getCloseSec();
                LogVlion.e("VlionCustomInterstitialActivity closeSec=" + this.f2259w);
                b();
                a();
                d();
                return;
            }
            finish();
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
            finish();
        }
    }

    @Override // android.app.Activity
    public final void onDestroy() {
        super.onDestroy();
        try {
            t5 t5Var = this.D;
            if (t5Var != null) {
                t5Var.a();
                this.D = null;
            }
            VlionBaseAdView vlionBaseAdView = this.f2239c;
            if (vlionBaseAdView != null) {
                vlionBaseAdView.a();
                this.f2239c = null;
            }
            i0 i0Var = this.f2237a;
            if (i0Var != null) {
                i0Var.a();
                this.f2237a = null;
            }
            i0 i0Var2 = this.f2238b;
            if (i0Var2 != null) {
                i0Var2.a();
                this.f2238b = null;
            }
            KeyEvent.Callback callback = this.f2241e;
            if (callback != null && (callback instanceof cn.vlion.ad.inland.base.d)) {
                ((cn.vlion.ad.inland.base.d) callback).destroy();
                this.f2241e = null;
            }
            j1 j1Var = F;
            if (j1Var != null) {
                int i10 = this.f2258v;
                v3.a aVar = (v3.a) j1Var;
                try {
                    VlionAdapterADConfig vlionAdapterADConfig = v3.this.f3458f;
                    if (vlionAdapterADConfig != null) {
                        vlionAdapterADConfig.setDuration(i10);
                    }
                    VlionBiddingActionListener vlionBiddingActionListener = v3.this.f3456d;
                    if (vlionBiddingActionListener != null) {
                        vlionBiddingActionListener.onAdClose();
                    }
                } catch (Throwable th2) {
                    VlionSDkManager.getInstance().upLoadCatchException(th2);
                }
                F = null;
            }
            WeakReference<View> weakReference = G;
            if (weakReference != null) {
                weakReference.clear();
                G = null;
            }
            WeakReference<VlionCustomInterstitialActivity> weakReference2 = H;
            if (weakReference2 != null) {
                weakReference2.clear();
                H = null;
            }
            x3 x3Var = this.f2244h;
            if (x3Var != null) {
                x3Var.b();
                this.f2244h.removeAllViews();
            }
            VlionSensorManagerHelper.getInstance().unregisterShakeListener(this.f2243g);
            DownloadApkData downloadApkData = this.f2256t;
            if (downloadApkData != null) {
                downloadApkData.cancelSchedule();
                this.f2256t.setAdClosed(true);
                if (this.f2256t.isInstallComplete()) {
                    s0.a(this.f2256t.getDownloadId());
                }
            }
            if (this.f2260x != null) {
                VlionHandlerUtils.instant().removeCallbacks(this.f2260x);
                this.f2260x = null;
            }
            if (this.f2261y != null) {
                VlionHandlerUtils.instant().removeCallbacks(this.f2261y);
                this.f2261y = null;
            }
            if (this.f2262z != null) {
                VlionHandlerUtils.instant().removeCallbacks(this.f2262z);
                this.f2262z = null;
            }
            q0 q0Var = this.f2254r;
            if (q0Var != null) {
                q0Var.a();
                this.f2254r = null;
            }
        } catch (Throwable th3) {
            VlionSDkManager.getInstance().upLoadCatchException(th3);
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public final boolean onKeyDown(int i10, KeyEvent keyEvent) {
        if (i10 == 4) {
            return true;
        }
        return super.onKeyDown(i10, keyEvent);
    }

    @Override // android.app.Activity
    public final void onPause() {
        super.onPause();
        try {
            LogVlion.e("VlionCustomInterstitialActivity onPause= ");
            this.f2257u = false;
            if (this.f2247k) {
                VlionSensorManagerHelper.getInstance().unregisterShakeListener(this.f2243g);
            }
            x3 x3Var = this.f2244h;
            if (x3Var != null) {
                x3Var.c();
            }
            t5 t5Var = this.D;
            if (t5Var != null) {
                t5Var.a(this.f2257u);
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // android.app.Activity
    public final void onResume() {
        super.onResume();
        try {
            this.f2257u = true;
            LogVlion.e("VlionCustomInterstitialActivity onResume isShake=" + this.f2247k + " isEndShake=" + this.f2255s);
            if (this.f2247k && !this.f2255s) {
                VlionSensorManagerHelper.getInstance().registerShakeListener(getApplicationContext(), this.f2243g);
            }
            x3 x3Var = this.f2244h;
            if (x3Var != null) {
                x3Var.d();
            }
            t5 t5Var = this.D;
            if (t5Var != null) {
                t5Var.a(this.f2257u);
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // android.app.Activity
    public final void setRequestedOrientation(int i10) {
        try {
            if (Build.VERSION.SDK_INT == 26) {
                try {
                    Field declaredField = Activity.class.getDeclaredField("mActivityInfo");
                    declaredField.setAccessible(true);
                    ActivityInfo activityInfo = (ActivityInfo) declaredField.get(this);
                    if (activityInfo != null) {
                        activityInfo.screenOrientation = i10;
                        declaredField.setAccessible(false);
                    }
                } catch (Throwable th2) {
                    VlionSDkManager.getInstance().upLoadCatchException(th2);
                }
            } else {
                super.setRequestedOrientation(i10);
            }
        } catch (Throwable th3) {
            VlionSDkManager.getInstance().upLoadCatchException(th3);
        }
    }

    public class e implements w3 {
        public e() {
        }

        public final void a(int i10) {
            try {
                LogVlion.e("VlionCustomInterstitialActivity onAdEndCardClose " + i10);
                VlionCustomInterstitialActivity.this.f2258v = i10;
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
            VlionCustomInterstitialActivity.this.finish();
            VlionCustomInterstitialActivity.this.overridePendingTransition(0, 0);
        }

        public final void b() {
            LogVlion.e("VlionCustomInterstitialActivity onAdVideoPlaying ");
            j1 j1Var = VlionCustomInterstitialActivity.F;
            if (j1Var != null) {
                v3.a aVar = (v3.a) j1Var;
                try {
                    v3 v3Var = v3.this;
                    VlionCustomParseAdData vlionCustomParseAdData = v3Var.f3459g;
                    if (vlionCustomParseAdData != null) {
                        v3Var.f3463k = new VlionBaseParameterReplace(vlionCustomParseAdData);
                        v3 v3Var2 = v3.this;
                        v3Var2.f3463k.handleVideoStartParameter(v3Var2.f3460h, v3Var2.f3461i, v3Var2.f3459g.getDuration(), v3.this.f3458f);
                    }
                    VlionCustomParseAdData vlionCustomParseAdData2 = v3.this.f3459g;
                    if (vlionCustomParseAdData2 != null) {
                        List<String> vm_p_start = vlionCustomParseAdData2.getVideoBean().getVm_p_start();
                        v3 v3Var3 = v3.this;
                        c5.b(vm_p_start, v3Var3.f3463k, v3Var3.f3459g);
                    }
                } catch (Throwable th2) {
                    VlionSDkManager.getInstance().upLoadCatchException(th2);
                }
            }
        }

        public final void a(int i10, boolean z10) {
            try {
                LogVlion.e("VlionCustomInterstitialActivity onAdSkip " + z10);
                j1 j1Var = VlionCustomInterstitialActivity.F;
                if (j1Var != null) {
                    ((v3.a) j1Var).a(i10, z10);
                }
                if (z10) {
                    VlionCustomInterstitialActivity vlionCustomInterstitialActivity = VlionCustomInterstitialActivity.this;
                    vlionCustomInterstitialActivity.f2258v = i10;
                    vlionCustomInterstitialActivity.finish();
                    VlionCustomInterstitialActivity.this.overridePendingTransition(0, 0);
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
                VlionCustomInterstitialActivity.this.finish();
            }
        }

        public final void a() {
            LogVlion.e("VlionCustomInterstitialActivity onAdVideoPlayComplete ");
            j1 j1Var = VlionCustomInterstitialActivity.F;
            if (j1Var != null) {
                v3.a aVar = (v3.a) j1Var;
                try {
                    v3 v3Var = v3.this;
                    v3Var.f3460h = true;
                    VlionBaseParameterReplace vlionBaseParameterReplace = v3Var.f3463k;
                    if (vlionBaseParameterReplace != null) {
                        vlionBaseParameterReplace.handleVideoFinishParameter(v3Var.f3462j);
                    }
                    VlionCustomParseAdData vlionCustomParseAdData = v3.this.f3459g;
                    if (vlionCustomParseAdData != null) {
                        List<String> vm_p_succ = vlionCustomParseAdData.getVideoBean().getVm_p_succ();
                        v3 v3Var2 = v3.this;
                        c5.a(vm_p_succ, v3Var2.f3463k, v3Var2.f3459g);
                    }
                } catch (Throwable th2) {
                    VlionSDkManager.getInstance().upLoadCatchException(th2);
                }
            }
        }

        public final void a(int i10, int i11) {
            LogVlion.e("VlionCustomInterstitialActivity onAdVideoPlaying ");
            j1 j1Var = VlionCustomInterstitialActivity.F;
            if (j1Var != null) {
                v3.a aVar = (v3.a) j1Var;
                try {
                    v3 v3Var = v3.this;
                    v3Var.f3461i = i10;
                    v3Var.f3462j = i11;
                    VlionBaseParameterReplace vlionBaseParameterReplace = v3Var.f3463k;
                    if (vlionBaseParameterReplace != null) {
                        vlionBaseParameterReplace.handleVideoPlayingParameter(i10);
                    }
                    VlionCustomParseAdData vlionCustomParseAdData = v3.this.f3459g;
                    if (vlionCustomParseAdData != null) {
                        List<VlionCustomAdData.SeatbidBean.BidBean.VideoBean.VmPTrackingBean> vm_p_tracking = vlionCustomParseAdData.getVideoBean().getVm_p_tracking();
                        v3 v3Var2 = v3.this;
                        c5.a(vm_p_tracking, i10, v3Var2.f3463k, v3Var2.f3459g);
                    }
                } catch (Throwable th2) {
                    VlionSDkManager.getInstance().upLoadCatchException(th2);
                }
            }
        }
    }

    public static void b(VlionCustomInterstitialActivity vlionCustomInterstitialActivity, VlionADClickType vlionADClickType) {
        vlionCustomInterstitialActivity.getClass();
        try {
            LogVlion.e("VlionCustomInterstitialActivity adAreaClickAction isOpenHot" + vlionCustomInterstitialActivity.C);
            vlionCustomInterstitialActivity.f2254r.a(vlionCustomInterstitialActivity.getApplicationContext(), I.getDp(), I.isIs_download(), new q3(vlionCustomInterstitialActivity, vlionADClickType));
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(18:7|(3:9|(4:12|(2:14|(2:16|17)(1:19))(2:20|(2:22|23)(2:24|(2:26|27)(1:28)))|18|10)|29)|30|(6:32|(1:34)|35|(1:37)|38|(1:40))|41|(1:43)|44|(9:(1:166)(1:168)|(8:49|(1:51)(1:126)|52|(1:54)(1:125)|55|(1:124)(1:58)|59|(2:61|(16:63|(12:117|(1:(1:(1:70)(1:112))(1:113))(1:114)|71|(1:73)|74|(5:76|(1:78)|79|(3:81|(1:83)|84)|85)|86|(1:90)|91|(2:105|(1:111))(1:95)|96|(2:100|(1:104)))|66|(0)(0)|71|(0)|74|(0)|86|(2:88|90)|91|(1:93)|105|(3:107|109|111)|96|(3:98|100|(2:102|104)))(16:118|(14:120|(0)(0)|71|(0)|74|(0)|86|(0)|91|(0)|105|(0)|96|(0))|66|(0)(0)|71|(0)|74|(0)|86|(0)|91|(0)|105|(0)|96|(0)))(16:121|(14:123|(0)(0)|71|(0)|74|(0)|86|(0)|91|(0)|105|(0)|96|(0))|66|(0)(0)|71|(0)|74|(0)|86|(0)|91|(0)|105|(0)|96|(0)))|(2:128|(1:130)(1:131))|(3:133|(1:139)|136)|140|141|(1:143)|145|(1:(1:161)(3:154|155|157))(2:149|150))(1:46)|47|(0)|(0)|(0)|140|141|(0)|145|(1:147)|(2:152|161)(1:162)) */
    /* JADX WARN: Code restructure failed: missing block: B:163:0x030a, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:164:0x030b, code lost:
    
        cn.vlion.ad.inland.base.util.init.VlionSDkManager.getInstance().upLoadCatchException(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:167:0x00c3, code lost:
    
        if (2 == cn.vlion.ad.inland.base.util.nettype.NetWorkTypeUtil.getConnectionType()) goto L397;
     */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0254 A[Catch: all -> 0x0052, TryCatch #0 {all -> 0x0052, blocks: (B:3:0x0004, B:7:0x000d, B:10:0x0039, B:12:0x003f, B:14:0x004b, B:16:0x004f, B:18:0x0072, B:20:0x0055, B:22:0x0061, B:24:0x0064, B:26:0x0070, B:30:0x0075, B:32:0x007d, B:34:0x0083, B:35:0x0085, B:37:0x008d, B:38:0x008f, B:40:0x0097, B:41:0x0099, B:43:0x009d, B:44:0x00a0, B:47:0x00c5, B:49:0x00cc, B:52:0x00d5, B:55:0x00e2, B:59:0x0114, B:70:0x0169, B:71:0x0180, B:73:0x0186, B:74:0x01a5, B:76:0x01c5, B:78:0x01db, B:79:0x01e1, B:81:0x01e5, B:83:0x01ed, B:84:0x01f3, B:85:0x0205, B:86:0x0215, B:88:0x0219, B:90:0x021d, B:91:0x0236, B:93:0x023a, B:95:0x0242, B:96:0x0271, B:98:0x0279, B:100:0x0281, B:102:0x02a9, B:104:0x02b1, B:105:0x024c, B:107:0x0254, B:109:0x025c, B:111:0x0264, B:112:0x016f, B:113:0x0175, B:114:0x017b, B:115:0x0144, B:118:0x014e, B:121:0x0158, B:128:0x02c0, B:131:0x02ce, B:133:0x02d5, B:136:0x02f3, B:137:0x02e3, B:139:0x02eb, B:145:0x0312, B:147:0x0341, B:149:0x0347, B:152:0x0356, B:159:0x036d, B:164:0x030b, B:166:0x00bf, B:168:0x00c8, B:141:0x02fa, B:143:0x02fe, B:155:0x035c), top: B:2:0x0004, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:114:0x017b A[Catch: all -> 0x0052, TryCatch #0 {all -> 0x0052, blocks: (B:3:0x0004, B:7:0x000d, B:10:0x0039, B:12:0x003f, B:14:0x004b, B:16:0x004f, B:18:0x0072, B:20:0x0055, B:22:0x0061, B:24:0x0064, B:26:0x0070, B:30:0x0075, B:32:0x007d, B:34:0x0083, B:35:0x0085, B:37:0x008d, B:38:0x008f, B:40:0x0097, B:41:0x0099, B:43:0x009d, B:44:0x00a0, B:47:0x00c5, B:49:0x00cc, B:52:0x00d5, B:55:0x00e2, B:59:0x0114, B:70:0x0169, B:71:0x0180, B:73:0x0186, B:74:0x01a5, B:76:0x01c5, B:78:0x01db, B:79:0x01e1, B:81:0x01e5, B:83:0x01ed, B:84:0x01f3, B:85:0x0205, B:86:0x0215, B:88:0x0219, B:90:0x021d, B:91:0x0236, B:93:0x023a, B:95:0x0242, B:96:0x0271, B:98:0x0279, B:100:0x0281, B:102:0x02a9, B:104:0x02b1, B:105:0x024c, B:107:0x0254, B:109:0x025c, B:111:0x0264, B:112:0x016f, B:113:0x0175, B:114:0x017b, B:115:0x0144, B:118:0x014e, B:121:0x0158, B:128:0x02c0, B:131:0x02ce, B:133:0x02d5, B:136:0x02f3, B:137:0x02e3, B:139:0x02eb, B:145:0x0312, B:147:0x0341, B:149:0x0347, B:152:0x0356, B:159:0x036d, B:164:0x030b, B:166:0x00bf, B:168:0x00c8, B:141:0x02fa, B:143:0x02fe, B:155:0x035c), top: B:2:0x0004, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:128:0x02c0 A[Catch: all -> 0x0052, TryCatch #0 {all -> 0x0052, blocks: (B:3:0x0004, B:7:0x000d, B:10:0x0039, B:12:0x003f, B:14:0x004b, B:16:0x004f, B:18:0x0072, B:20:0x0055, B:22:0x0061, B:24:0x0064, B:26:0x0070, B:30:0x0075, B:32:0x007d, B:34:0x0083, B:35:0x0085, B:37:0x008d, B:38:0x008f, B:40:0x0097, B:41:0x0099, B:43:0x009d, B:44:0x00a0, B:47:0x00c5, B:49:0x00cc, B:52:0x00d5, B:55:0x00e2, B:59:0x0114, B:70:0x0169, B:71:0x0180, B:73:0x0186, B:74:0x01a5, B:76:0x01c5, B:78:0x01db, B:79:0x01e1, B:81:0x01e5, B:83:0x01ed, B:84:0x01f3, B:85:0x0205, B:86:0x0215, B:88:0x0219, B:90:0x021d, B:91:0x0236, B:93:0x023a, B:95:0x0242, B:96:0x0271, B:98:0x0279, B:100:0x0281, B:102:0x02a9, B:104:0x02b1, B:105:0x024c, B:107:0x0254, B:109:0x025c, B:111:0x0264, B:112:0x016f, B:113:0x0175, B:114:0x017b, B:115:0x0144, B:118:0x014e, B:121:0x0158, B:128:0x02c0, B:131:0x02ce, B:133:0x02d5, B:136:0x02f3, B:137:0x02e3, B:139:0x02eb, B:145:0x0312, B:147:0x0341, B:149:0x0347, B:152:0x0356, B:159:0x036d, B:164:0x030b, B:166:0x00bf, B:168:0x00c8, B:141:0x02fa, B:143:0x02fe, B:155:0x035c), top: B:2:0x0004, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:133:0x02d5 A[Catch: all -> 0x0052, TryCatch #0 {all -> 0x0052, blocks: (B:3:0x0004, B:7:0x000d, B:10:0x0039, B:12:0x003f, B:14:0x004b, B:16:0x004f, B:18:0x0072, B:20:0x0055, B:22:0x0061, B:24:0x0064, B:26:0x0070, B:30:0x0075, B:32:0x007d, B:34:0x0083, B:35:0x0085, B:37:0x008d, B:38:0x008f, B:40:0x0097, B:41:0x0099, B:43:0x009d, B:44:0x00a0, B:47:0x00c5, B:49:0x00cc, B:52:0x00d5, B:55:0x00e2, B:59:0x0114, B:70:0x0169, B:71:0x0180, B:73:0x0186, B:74:0x01a5, B:76:0x01c5, B:78:0x01db, B:79:0x01e1, B:81:0x01e5, B:83:0x01ed, B:84:0x01f3, B:85:0x0205, B:86:0x0215, B:88:0x0219, B:90:0x021d, B:91:0x0236, B:93:0x023a, B:95:0x0242, B:96:0x0271, B:98:0x0279, B:100:0x0281, B:102:0x02a9, B:104:0x02b1, B:105:0x024c, B:107:0x0254, B:109:0x025c, B:111:0x0264, B:112:0x016f, B:113:0x0175, B:114:0x017b, B:115:0x0144, B:118:0x014e, B:121:0x0158, B:128:0x02c0, B:131:0x02ce, B:133:0x02d5, B:136:0x02f3, B:137:0x02e3, B:139:0x02eb, B:145:0x0312, B:147:0x0341, B:149:0x0347, B:152:0x0356, B:159:0x036d, B:164:0x030b, B:166:0x00bf, B:168:0x00c8, B:141:0x02fa, B:143:0x02fe, B:155:0x035c), top: B:2:0x0004, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:143:0x02fe A[Catch: all -> 0x030a, TRY_LEAVE, TryCatch #1 {all -> 0x030a, blocks: (B:141:0x02fa, B:143:0x02fe), top: B:140:0x02fa, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00cc A[Catch: all -> 0x0052, TryCatch #0 {all -> 0x0052, blocks: (B:3:0x0004, B:7:0x000d, B:10:0x0039, B:12:0x003f, B:14:0x004b, B:16:0x004f, B:18:0x0072, B:20:0x0055, B:22:0x0061, B:24:0x0064, B:26:0x0070, B:30:0x0075, B:32:0x007d, B:34:0x0083, B:35:0x0085, B:37:0x008d, B:38:0x008f, B:40:0x0097, B:41:0x0099, B:43:0x009d, B:44:0x00a0, B:47:0x00c5, B:49:0x00cc, B:52:0x00d5, B:55:0x00e2, B:59:0x0114, B:70:0x0169, B:71:0x0180, B:73:0x0186, B:74:0x01a5, B:76:0x01c5, B:78:0x01db, B:79:0x01e1, B:81:0x01e5, B:83:0x01ed, B:84:0x01f3, B:85:0x0205, B:86:0x0215, B:88:0x0219, B:90:0x021d, B:91:0x0236, B:93:0x023a, B:95:0x0242, B:96:0x0271, B:98:0x0279, B:100:0x0281, B:102:0x02a9, B:104:0x02b1, B:105:0x024c, B:107:0x0254, B:109:0x025c, B:111:0x0264, B:112:0x016f, B:113:0x0175, B:114:0x017b, B:115:0x0144, B:118:0x014e, B:121:0x0158, B:128:0x02c0, B:131:0x02ce, B:133:0x02d5, B:136:0x02f3, B:137:0x02e3, B:139:0x02eb, B:145:0x0312, B:147:0x0341, B:149:0x0347, B:152:0x0356, B:159:0x036d, B:164:0x030b, B:166:0x00bf, B:168:0x00c8, B:141:0x02fa, B:143:0x02fe, B:155:0x035c), top: B:2:0x0004, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0165  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0186 A[Catch: all -> 0x0052, TryCatch #0 {all -> 0x0052, blocks: (B:3:0x0004, B:7:0x000d, B:10:0x0039, B:12:0x003f, B:14:0x004b, B:16:0x004f, B:18:0x0072, B:20:0x0055, B:22:0x0061, B:24:0x0064, B:26:0x0070, B:30:0x0075, B:32:0x007d, B:34:0x0083, B:35:0x0085, B:37:0x008d, B:38:0x008f, B:40:0x0097, B:41:0x0099, B:43:0x009d, B:44:0x00a0, B:47:0x00c5, B:49:0x00cc, B:52:0x00d5, B:55:0x00e2, B:59:0x0114, B:70:0x0169, B:71:0x0180, B:73:0x0186, B:74:0x01a5, B:76:0x01c5, B:78:0x01db, B:79:0x01e1, B:81:0x01e5, B:83:0x01ed, B:84:0x01f3, B:85:0x0205, B:86:0x0215, B:88:0x0219, B:90:0x021d, B:91:0x0236, B:93:0x023a, B:95:0x0242, B:96:0x0271, B:98:0x0279, B:100:0x0281, B:102:0x02a9, B:104:0x02b1, B:105:0x024c, B:107:0x0254, B:109:0x025c, B:111:0x0264, B:112:0x016f, B:113:0x0175, B:114:0x017b, B:115:0x0144, B:118:0x014e, B:121:0x0158, B:128:0x02c0, B:131:0x02ce, B:133:0x02d5, B:136:0x02f3, B:137:0x02e3, B:139:0x02eb, B:145:0x0312, B:147:0x0341, B:149:0x0347, B:152:0x0356, B:159:0x036d, B:164:0x030b, B:166:0x00bf, B:168:0x00c8, B:141:0x02fa, B:143:0x02fe, B:155:0x035c), top: B:2:0x0004, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x01c5 A[Catch: all -> 0x0052, TryCatch #0 {all -> 0x0052, blocks: (B:3:0x0004, B:7:0x000d, B:10:0x0039, B:12:0x003f, B:14:0x004b, B:16:0x004f, B:18:0x0072, B:20:0x0055, B:22:0x0061, B:24:0x0064, B:26:0x0070, B:30:0x0075, B:32:0x007d, B:34:0x0083, B:35:0x0085, B:37:0x008d, B:38:0x008f, B:40:0x0097, B:41:0x0099, B:43:0x009d, B:44:0x00a0, B:47:0x00c5, B:49:0x00cc, B:52:0x00d5, B:55:0x00e2, B:59:0x0114, B:70:0x0169, B:71:0x0180, B:73:0x0186, B:74:0x01a5, B:76:0x01c5, B:78:0x01db, B:79:0x01e1, B:81:0x01e5, B:83:0x01ed, B:84:0x01f3, B:85:0x0205, B:86:0x0215, B:88:0x0219, B:90:0x021d, B:91:0x0236, B:93:0x023a, B:95:0x0242, B:96:0x0271, B:98:0x0279, B:100:0x0281, B:102:0x02a9, B:104:0x02b1, B:105:0x024c, B:107:0x0254, B:109:0x025c, B:111:0x0264, B:112:0x016f, B:113:0x0175, B:114:0x017b, B:115:0x0144, B:118:0x014e, B:121:0x0158, B:128:0x02c0, B:131:0x02ce, B:133:0x02d5, B:136:0x02f3, B:137:0x02e3, B:139:0x02eb, B:145:0x0312, B:147:0x0341, B:149:0x0347, B:152:0x0356, B:159:0x036d, B:164:0x030b, B:166:0x00bf, B:168:0x00c8, B:141:0x02fa, B:143:0x02fe, B:155:0x035c), top: B:2:0x0004, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0219 A[Catch: all -> 0x0052, TryCatch #0 {all -> 0x0052, blocks: (B:3:0x0004, B:7:0x000d, B:10:0x0039, B:12:0x003f, B:14:0x004b, B:16:0x004f, B:18:0x0072, B:20:0x0055, B:22:0x0061, B:24:0x0064, B:26:0x0070, B:30:0x0075, B:32:0x007d, B:34:0x0083, B:35:0x0085, B:37:0x008d, B:38:0x008f, B:40:0x0097, B:41:0x0099, B:43:0x009d, B:44:0x00a0, B:47:0x00c5, B:49:0x00cc, B:52:0x00d5, B:55:0x00e2, B:59:0x0114, B:70:0x0169, B:71:0x0180, B:73:0x0186, B:74:0x01a5, B:76:0x01c5, B:78:0x01db, B:79:0x01e1, B:81:0x01e5, B:83:0x01ed, B:84:0x01f3, B:85:0x0205, B:86:0x0215, B:88:0x0219, B:90:0x021d, B:91:0x0236, B:93:0x023a, B:95:0x0242, B:96:0x0271, B:98:0x0279, B:100:0x0281, B:102:0x02a9, B:104:0x02b1, B:105:0x024c, B:107:0x0254, B:109:0x025c, B:111:0x0264, B:112:0x016f, B:113:0x0175, B:114:0x017b, B:115:0x0144, B:118:0x014e, B:121:0x0158, B:128:0x02c0, B:131:0x02ce, B:133:0x02d5, B:136:0x02f3, B:137:0x02e3, B:139:0x02eb, B:145:0x0312, B:147:0x0341, B:149:0x0347, B:152:0x0356, B:159:0x036d, B:164:0x030b, B:166:0x00bf, B:168:0x00c8, B:141:0x02fa, B:143:0x02fe, B:155:0x035c), top: B:2:0x0004, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:93:0x023a A[Catch: all -> 0x0052, TryCatch #0 {all -> 0x0052, blocks: (B:3:0x0004, B:7:0x000d, B:10:0x0039, B:12:0x003f, B:14:0x004b, B:16:0x004f, B:18:0x0072, B:20:0x0055, B:22:0x0061, B:24:0x0064, B:26:0x0070, B:30:0x0075, B:32:0x007d, B:34:0x0083, B:35:0x0085, B:37:0x008d, B:38:0x008f, B:40:0x0097, B:41:0x0099, B:43:0x009d, B:44:0x00a0, B:47:0x00c5, B:49:0x00cc, B:52:0x00d5, B:55:0x00e2, B:59:0x0114, B:70:0x0169, B:71:0x0180, B:73:0x0186, B:74:0x01a5, B:76:0x01c5, B:78:0x01db, B:79:0x01e1, B:81:0x01e5, B:83:0x01ed, B:84:0x01f3, B:85:0x0205, B:86:0x0215, B:88:0x0219, B:90:0x021d, B:91:0x0236, B:93:0x023a, B:95:0x0242, B:96:0x0271, B:98:0x0279, B:100:0x0281, B:102:0x02a9, B:104:0x02b1, B:105:0x024c, B:107:0x0254, B:109:0x025c, B:111:0x0264, B:112:0x016f, B:113:0x0175, B:114:0x017b, B:115:0x0144, B:118:0x014e, B:121:0x0158, B:128:0x02c0, B:131:0x02ce, B:133:0x02d5, B:136:0x02f3, B:137:0x02e3, B:139:0x02eb, B:145:0x0312, B:147:0x0341, B:149:0x0347, B:152:0x0356, B:159:0x036d, B:164:0x030b, B:166:0x00bf, B:168:0x00c8, B:141:0x02fa, B:143:0x02fe, B:155:0x035c), top: B:2:0x0004, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0279 A[Catch: all -> 0x0052, TryCatch #0 {all -> 0x0052, blocks: (B:3:0x0004, B:7:0x000d, B:10:0x0039, B:12:0x003f, B:14:0x004b, B:16:0x004f, B:18:0x0072, B:20:0x0055, B:22:0x0061, B:24:0x0064, B:26:0x0070, B:30:0x0075, B:32:0x007d, B:34:0x0083, B:35:0x0085, B:37:0x008d, B:38:0x008f, B:40:0x0097, B:41:0x0099, B:43:0x009d, B:44:0x00a0, B:47:0x00c5, B:49:0x00cc, B:52:0x00d5, B:55:0x00e2, B:59:0x0114, B:70:0x0169, B:71:0x0180, B:73:0x0186, B:74:0x01a5, B:76:0x01c5, B:78:0x01db, B:79:0x01e1, B:81:0x01e5, B:83:0x01ed, B:84:0x01f3, B:85:0x0205, B:86:0x0215, B:88:0x0219, B:90:0x021d, B:91:0x0236, B:93:0x023a, B:95:0x0242, B:96:0x0271, B:98:0x0279, B:100:0x0281, B:102:0x02a9, B:104:0x02b1, B:105:0x024c, B:107:0x0254, B:109:0x025c, B:111:0x0264, B:112:0x016f, B:113:0x0175, B:114:0x017b, B:115:0x0144, B:118:0x014e, B:121:0x0158, B:128:0x02c0, B:131:0x02ce, B:133:0x02d5, B:136:0x02f3, B:137:0x02e3, B:139:0x02eb, B:145:0x0312, B:147:0x0341, B:149:0x0347, B:152:0x0356, B:159:0x036d, B:164:0x030b, B:166:0x00bf, B:168:0x00c8, B:141:0x02fa, B:143:0x02fe, B:155:0x035c), top: B:2:0x0004, inners: #1, #2 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a() {
        /*
            Method dump skipped, instructions count: 893
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.vlion.ad.inland.ad.interstitial.VlionCustomInterstitialActivity.a():void");
    }

    public static void a(VlionCustomInterstitialActivity vlionCustomInterstitialActivity, VlionADClickType vlionADClickType) {
        vlionCustomInterstitialActivity.getClass();
        try {
            VlionCustomAdActiveType$VlionCustomTarget a10 = vlionCustomInterstitialActivity.f2254r.a(vlionCustomInterstitialActivity.getApplicationContext(), J, I, new r3(vlionCustomInterstitialActivity));
            if (a10 != null && vlionADClickType != null) {
                vlionADClickType.setTarget(a10.toString());
            }
            if (vlionADClickType != null) {
                q0 q0Var = vlionCustomInterstitialActivity.f2254r;
                Context applicationContext = vlionCustomInterstitialActivity.getApplicationContext();
                VlionCustomParseAdData vlionCustomParseAdData = I;
                q0Var.getClass();
                vlionADClickType.setIsCanOpenDp(q0.a(applicationContext, vlionCustomParseAdData));
            }
            j1 j1Var = F;
            if (j1Var != null) {
                ((v3.a) j1Var).a(vlionADClickType);
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }
}
