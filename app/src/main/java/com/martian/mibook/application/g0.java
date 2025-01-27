package com.martian.mibook.application;

import android.app.Activity;
import android.os.Handler;
import androidx.annotation.NonNull;
import com.baidu.mobads.sdk.api.ExpressInterstitialAd;
import com.baidu.mobads.sdk.api.RewardVideoAd;
import com.bytedance.sdk.openadsdk.TTFeedAd;
import com.bytedance.sdk.openadsdk.TTFullScreenVideoAd;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import com.bytedance.sdk.openadsdk.TTRewardVideoAd;
import com.kwad.sdk.api.KsInterstitialAd;
import com.kwad.sdk.api.KsNativeAd;
import com.kwad.sdk.api.KsRewardVideoAd;
import com.martian.ads.ad.AdConfig;
import com.martian.ads.ad.BaeAd;
import com.martian.ads.ad.BaseAd;
import com.martian.ads.ad.GDTAd;
import com.martian.ads.ad.KsAd;
import com.martian.ads.ad.TTAd;
import com.martian.ads.ad.VivoAd;
import com.martian.apptask.data.AppTask;
import com.martian.apptask.data.AppTaskList;
import com.martian.libmars.activity.j1;
import com.martian.ttbookhd.R;
import com.qq.e.ads.interstitial2.UnifiedInterstitialAD;
import com.qq.e.ads.nativ.NativeUnifiedADData;
import com.qq.e.ads.rewardvideo.RewardVideoAD;
import com.vivo.ad.nativead.NativeResponse;
import com.vivo.mobilead.unified.interstitial.UnifiedVivoInterstitialAd;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class g0 {

    /* renamed from: a */
    public static final int f11409a = 1680000;

    /* renamed from: b */
    private List<AppTask> f11410b;

    /* renamed from: c */
    private List<AppTask> f11411c;

    /* renamed from: d */
    private List<AppTask> f11412d;

    /* renamed from: e */
    private WeakReference<Activity> f11413e;

    /* renamed from: h */
    private AdConfig.AdInfo f11416h;

    /* renamed from: i */
    private AdConfig.AdInfo f11417i;

    /* renamed from: g */
    private long f11415g = -1;

    /* renamed from: f */
    private final i0 f11414f = new i0();

    /* loaded from: classes3.dex */
    class a extends b.d.a.k.b {

        /* renamed from: a */
        final /* synthetic */ b.d.a.k.b f11418a;

        /* renamed from: b */
        final /* synthetic */ boolean f11419b;

        a(final b.d.a.k.b val$portrait, final boolean val$receiver) {
            this.f11418a = val$portrait;
            this.f11419b = val$receiver;
        }

        @Override // b.d.a.k.b, b.d.a.k.a
        public void d(AdConfig config, AppTaskList appTaskList) {
            g0.this.E(appTaskList.getApps().get(0), this.f11418a, this.f11419b, AdConfig.ActionString.SUCCESS);
        }

        @Override // b.d.a.k.b, b.d.a.k.a
        public void h() {
            g0.this.E(null, this.f11418a, this.f11419b, AdConfig.ActionString.FAIL);
        }

        @Override // b.d.a.k.b, b.d.a.k.a
        public void i(AppTask lossAppTask) {
            g0.this.l(lossAppTask);
        }
    }

    /* loaded from: classes3.dex */
    class b extends b.d.a.k.b {

        /* renamed from: a */
        final /* synthetic */ Activity f11421a;

        /* renamed from: b */
        final /* synthetic */ AppTask f11422b;

        /* renamed from: c */
        final /* synthetic */ b.d.a.k.b f11423c;

        b(final Activity val$receiver, final AppTask val$biddingAppTask, final b.d.a.k.b val$activity) {
            this.f11421a = val$receiver;
            this.f11422b = val$biddingAppTask;
            this.f11423c = val$activity;
        }

        @Override // b.d.a.k.b, b.d.a.k.a
        public void d(AdConfig config, AppTaskList appTaskList) {
            com.martian.mibook.lib.model.g.b.o(this.f11421a, "信息流-瀑布流-成功");
            AppTask appTask = appTaskList.getApps().get(0);
            g0.this.l(this.f11422b);
            g0.this.F(appTask, this.f11423c);
        }

        @Override // b.d.a.k.b, b.d.a.k.a
        public void h() {
            com.martian.mibook.lib.model.g.b.o(this.f11421a, "信息流-瀑布流-失败");
            AppTask appTask = this.f11422b;
            if (appTask != null) {
                g0.this.F(appTask, this.f11423c);
                return;
            }
            b.d.a.k.b bVar = this.f11423c;
            if (bVar != null) {
                bVar.h();
            }
        }
    }

    /* loaded from: classes3.dex */
    class c extends b.d.a.k.b {

        /* renamed from: a */
        final /* synthetic */ Activity f11425a;

        /* renamed from: b */
        final /* synthetic */ String f11426b;

        /* renamed from: c */
        final /* synthetic */ b.d.a.k.b f11427c;

        c(final Activity val$receiver, final String val$pid, final b.d.a.k.b val$activity) {
            this.f11425a = val$receiver;
            this.f11426b = val$pid;
            this.f11427c = val$activity;
        }

        @Override // b.d.a.k.b, b.d.a.k.a
        public void a(AdConfig config) {
            super.a(config);
            b.d.a.k.b bVar = this.f11427c;
            if (bVar != null) {
                bVar.a(config);
            }
        }

        @Override // b.d.a.k.b, b.d.a.k.a
        public void c(AdConfig config) {
            b.d.a.k.b bVar = this.f11427c;
            if (bVar != null) {
                bVar.c(config);
            }
        }

        @Override // b.d.a.k.b, b.d.a.k.a
        public void d(AdConfig config, AppTaskList appTaskList) {
            com.martian.mibook.lib.model.g.b.o(this.f11425a, "插屏-bidding-成功");
            g0.this.v(this.f11425a, appTaskList.getApps().get(0), this.f11426b, this.f11427c);
        }

        @Override // b.d.a.k.b, b.d.a.k.a
        public void h() {
            com.martian.mibook.lib.model.g.b.o(this.f11425a, "插屏-bidding-失败");
            g0.this.v(this.f11425a, null, this.f11426b, this.f11427c);
        }

        @Override // b.d.a.k.b, b.d.a.k.a
        public void i(AppTask lossAppTask) {
            g0.this.m(lossAppTask);
        }
    }

    /* loaded from: classes3.dex */
    class d extends b.d.a.k.b {

        /* renamed from: a */
        final /* synthetic */ Activity f11429a;

        /* renamed from: b */
        final /* synthetic */ b.d.a.k.b f11430b;

        /* renamed from: c */
        final /* synthetic */ AppTask f11431c;

        d(final Activity val$biddingAppTask, final b.d.a.k.b val$receiver, final AppTask val$activity) {
            this.f11429a = val$biddingAppTask;
            this.f11430b = val$receiver;
            this.f11431c = val$activity;
        }

        @Override // b.d.a.k.b, b.d.a.k.a
        public void a(AdConfig config) {
            super.a(config);
            b.d.a.k.b bVar = this.f11430b;
            if (bVar != null) {
                bVar.a(config);
            }
        }

        @Override // b.d.a.k.b, b.d.a.k.a
        public void c(AdConfig config) {
            b.d.a.k.b bVar = this.f11430b;
            if (bVar != null) {
                bVar.c(config);
            }
        }

        @Override // b.d.a.k.b, b.d.a.k.a
        public void d(AdConfig config, AppTaskList appTaskList) {
            com.martian.mibook.lib.model.g.b.o(this.f11429a, "插屏-瀑布流-成功");
            AppTask appTask = appTaskList.getApps().get(0);
            g0.this.P(this.f11429a, appTask, this.f11430b);
            g0.this.m(this.f11431c);
            g0.this.H(appTask.getEcpm());
        }

        @Override // b.d.a.k.b, b.d.a.k.a
        public void h() {
            com.martian.mibook.lib.model.g.b.o(this.f11429a, "插屏-瀑布流-失败");
            g0.this.P(this.f11429a, this.f11431c, this.f11430b);
            AppTask appTask = this.f11431c;
            if (appTask != null) {
                g0.this.H(appTask.getEcpm());
            }
        }
    }

    /* loaded from: classes3.dex */
    class e extends b.d.a.k.b {

        /* renamed from: a */
        final /* synthetic */ j1 f11433a;

        /* renamed from: b */
        final /* synthetic */ String f11434b;

        /* renamed from: c */
        final /* synthetic */ b.d.a.k.b f11435c;

        e(final j1 val$receiver, final String val$pid, final b.d.a.k.b val$activity) {
            this.f11433a = val$receiver;
            this.f11434b = val$pid;
            this.f11435c = val$activity;
        }

        @Override // b.d.a.k.b, b.d.a.k.a
        public void d(AdConfig config, AppTaskList appTaskList) {
            com.martian.mibook.lib.model.g.b.o(this.f11433a, "激励视频-bidding-成功");
            g0.this.w(this.f11433a, appTaskList.getApps().get(0), this.f11434b, this.f11435c);
        }

        @Override // b.d.a.k.b, b.d.a.k.a
        public void e(final AdConfig config, final boolean verify) {
            j1 j1Var = this.f11433a;
            final b.d.a.k.b bVar = this.f11435c;
            j1Var.runOnUiThread(new Runnable() { // from class: com.martian.mibook.application.d
                @Override // java.lang.Runnable
                public final void run() {
                    b.d.a.k.b.this.e(config, verify);
                }
            });
        }

        @Override // b.d.a.k.b, b.d.a.k.a
        public void h() {
            com.martian.mibook.lib.model.g.b.o(this.f11433a, "激励视频-bidding-失败");
            g0.this.w(this.f11433a, null, this.f11434b, this.f11435c);
        }

        @Override // b.d.a.k.b, b.d.a.k.a
        public void i(AppTask lossAppTask) {
            g0.this.n(lossAppTask);
        }
    }

    /* loaded from: classes3.dex */
    class f extends b.d.a.k.b {

        /* renamed from: a */
        final /* synthetic */ b.d.a.k.b f11437a;

        /* renamed from: b */
        final /* synthetic */ j1 f11438b;

        /* renamed from: c */
        final /* synthetic */ AppTask f11439c;

        f(final b.d.a.k.b val$appTask, final j1 val$activity, final AppTask val$receiver) {
            this.f11437a = val$appTask;
            this.f11438b = val$activity;
            this.f11439c = val$receiver;
        }

        @Override // b.d.a.k.b, b.d.a.k.a
        public void d(AdConfig config, AppTaskList appTaskList) {
            AppTask appTask = appTaskList.getApps().get(0);
            if (appTask == null) {
                this.f11437a.e(null, false);
                return;
            }
            g0.this.Q(this.f11438b, appTask, this.f11437a);
            g0.this.n(this.f11439c);
            g0.this.M(appTask.getEcpm());
        }

        @Override // b.d.a.k.b, b.d.a.k.a
        public void e(final AdConfig config, final boolean verify) {
            j1 j1Var = this.f11438b;
            if (j1Var != null) {
                final b.d.a.k.b bVar = this.f11437a;
                j1Var.runOnUiThread(new Runnable() { // from class: com.martian.mibook.application.e
                    @Override // java.lang.Runnable
                    public final void run() {
                        b.d.a.k.b.this.e(config, verify);
                    }
                });
            }
        }

        @Override // b.d.a.k.b, b.d.a.k.a
        public void h() {
            j1 j1Var = this.f11438b;
            if (j1Var != null) {
                j1Var.e2(false, "");
            }
            AppTask appTask = this.f11439c;
            if (appTask == null) {
                this.f11437a.e(null, false);
            } else {
                g0.this.Q(this.f11438b, appTask, this.f11437a);
                g0.this.M(this.f11439c.getEcpm());
            }
        }
    }

    /* renamed from: B */
    public /* synthetic */ void C(final j1 activity, final b.d.a.k.b receiver, final AppTask videoAppTask) {
        if (!com.martian.libmars.utils.n0.B(activity)) {
            receiver.e(null, false);
            return;
        }
        activity.e2(false, "");
        com.martian.libugrowth.b.k().g(videoAppTask.id, AdConfig.Action.ESHOW, videoAppTask.source, videoAppTask.getGid(), videoAppTask.getEcpm());
        Object obj = videoAppTask.origin;
        if (obj instanceof TTRewardVideoAd) {
            TTAd.showVideoAd(activity, (TTRewardVideoAd) obj);
        } else if (obj instanceof ExpressInterstitialAd) {
            MiConfigSingleton.V3().j8(true);
            BaeAd.showInterstitialAd(activity, (ExpressInterstitialAd) videoAppTask.origin, videoAppTask.isBidding());
        } else if (obj instanceof RewardVideoAd) {
            BaeAd.showVideoAd((RewardVideoAd) obj, videoAppTask.isBidding());
        } else if (obj instanceof RewardVideoAD) {
            GDTAd.showVideoAd((RewardVideoAD) obj, videoAppTask.isBidding());
        } else if (obj instanceof UnifiedInterstitialAD) {
            GDTAd.showInterstitialAd(activity, (UnifiedInterstitialAD) obj, videoAppTask.isBidding());
        } else if (obj instanceof KsRewardVideoAd) {
            KsAd.showVideoAd(activity, (KsRewardVideoAd) obj, videoAppTask.isBidding());
        } else if (obj instanceof KsInterstitialAd) {
            KsAd.showInterstitialAd(activity, (KsInterstitialAd) obj, videoAppTask.isBidding());
        } else if (obj instanceof TTNativeExpressAd) {
            TTAd.showInterstitialAd((TTNativeExpressAd) obj);
        } else if (obj instanceof TTFullScreenVideoAd) {
            TTAd.showFullScreenVideoAd(activity, (TTFullScreenVideoAd) obj);
        } else {
            if (!BaseAd.isOppoVideoAd(videoAppTask)) {
                receiver.e(null, false);
                return;
            }
            BaseAd.showOppoVideoAd(videoAppTask);
        }
        if (MiConfigSingleton.V3().W3().getEnableBaeAdInfo()) {
            if (this.f11417i == null) {
                this.f11417i = new AdConfig.AdInfo();
            }
            this.f11417i.setSource(videoAppTask.source);
            this.f11417i.setEcpm(videoAppTask.getEcpm());
        }
    }

    public static void D(Activity activity, String event) {
        if (activity != null) {
            com.martian.mibook.lib.model.g.b.o(activity, event);
        }
    }

    public void E(AppTask appTask, b.d.a.k.b receiver, boolean portrait, String event) {
        Activity activity = getActivity();
        if (com.martian.libmars.utils.n0.C(activity)) {
            com.martian.mibook.lib.model.g.b.o(activity, "信息流-bidding-" + event);
            u(activity, appTask, receiver, portrait);
        }
    }

    public void F(AppTask appTask, b.d.a.k.b receiver) {
        if (appTask == null) {
            return;
        }
        G(appTask);
        if (receiver != null) {
            AppTaskList appTaskList = new AppTaskList();
            appTaskList.addAppTask(appTask);
            receiver.d(b.d.a.j.b.Q(appTask), appTaskList);
        }
    }

    public void H(int winPrice) {
        List<AppTask> list = this.f11410b;
        if (list == null || list.isEmpty()) {
            return;
        }
        Iterator<AppTask> it = this.f11410b.iterator();
        while (it.hasNext()) {
            AppTask next = it.next();
            it.remove();
            Object obj = next.origin;
            if (obj instanceof ExpressInterstitialAd) {
                BaeAd.sendInterstitialLossNotification((ExpressInterstitialAd) obj);
            } else if (obj instanceof UnifiedInterstitialAD) {
                GDTAd.sendInterstitialLossNotification(winPrice, (UnifiedInterstitialAD) obj);
            } else if (obj instanceof KsInterstitialAd) {
                KsAd.sendInterstitialLossNotification(winPrice, (KsInterstitialAd) obj);
            } else if (obj instanceof UnifiedVivoInterstitialAd) {
                VivoAd.sendInterstitialLossNotification(winPrice, (UnifiedVivoInterstitialAd) obj);
            } else if (BaseAd.isOppoInterstitialAd(next)) {
                BaseAd.sendOppoInterstitialLossNotification(winPrice, next);
            }
        }
    }

    public static void I(int winPrice, AppTask loseAppTask) {
        if (loseAppTask == null || !loseAppTask.isBidding()) {
            return;
        }
        J(winPrice, loseAppTask, 1, 1, BaeAd.BIDDING_FAIL_LOW_PRICE, 1);
        loseAppTask.destroyNativeAd();
    }

    public static void J(int winPrice, AppTask lossAppTask, int gdtReason, int vivoReason, String baeReason, int oppoReason) {
        AppTask appTask = new AppTask();
        appTask.setEcpm(winPrice);
        K(appTask, lossAppTask, gdtReason, vivoReason, baeReason, oppoReason);
    }

    public static void K(AppTask winAppTask, AppTask lossAppTask, int gdtReason, int vivoReason, String baeReason, int oppoReason) {
        if (lossAppTask == null || !lossAppTask.isBidding()) {
            return;
        }
        int ecpm = winAppTask.getEcpm();
        if (GDTAd.isGdtFlowAd(lossAppTask)) {
            GDTAd.sendLossNotification(ecpm, (NativeUnifiedADData) lossAppTask.origin, gdtReason);
            return;
        }
        if (VivoAd.isVivoAd(lossAppTask)) {
            VivoAd.sendLossNotification(ecpm, (NativeResponse) lossAppTask.origin, vivoReason);
            return;
        }
        if (KsAd.isKsFlowAd(lossAppTask)) {
            KsAd.sendLossNotification(ecpm, (KsNativeAd) lossAppTask.origin);
        } else if (BaeAd.isBaeFlowAd(lossAppTask)) {
            BaeAd.sendLossNotification(winAppTask, (com.baidu.mobads.sdk.api.NativeResponse) lossAppTask.origin, baeReason);
        } else if (BaseAd.isOppoFlowAd(lossAppTask)) {
            BaseAd.sendOppoLossNotification(ecpm, lossAppTask, oppoReason);
        }
    }

    public static void L(AppTask winAppTask, List<AppTask> biddingFailAppTasks) {
        if (biddingFailAppTasks == null || biddingFailAppTasks.isEmpty()) {
            return;
        }
        Iterator<AppTask> it = biddingFailAppTasks.iterator();
        while (it.hasNext()) {
            AppTask next = it.next();
            it.remove();
            K(winAppTask, next, 1, 1, BaeAd.BIDDING_FAIL_LOW_PRICE, 1);
            p(next);
        }
    }

    public void M(int winPrice) {
        List<AppTask> list = this.f11411c;
        if (list == null || list.isEmpty()) {
            return;
        }
        Iterator<AppTask> it = this.f11411c.iterator();
        while (it.hasNext()) {
            AppTask next = it.next();
            it.remove();
            Object obj = next.origin;
            if (obj instanceof ExpressInterstitialAd) {
                BaeAd.sendInterstitialLossNotification((ExpressInterstitialAd) obj);
            } else if (obj instanceof RewardVideoAd) {
                BaeAd.sendVideoLossNotification((RewardVideoAd) obj);
            } else if (obj instanceof RewardVideoAD) {
                GDTAd.sendVideoLossNotification(winPrice, (RewardVideoAD) obj);
            } else if (obj instanceof UnifiedInterstitialAD) {
                GDTAd.sendInterstitialLossNotification(winPrice, (UnifiedInterstitialAD) obj);
            } else if (obj instanceof KsRewardVideoAd) {
                KsAd.sendVideoLossNotification(winPrice, (KsRewardVideoAd) obj);
            } else if (obj instanceof KsInterstitialAd) {
                KsAd.sendInterstitialLossNotification(winPrice, (KsInterstitialAd) obj);
            } else if (BaseAd.isOppoVideoAd(next)) {
                BaseAd.sendOppoVideoLossNotification(winPrice, next);
            }
        }
    }

    public static void N(AppTask appTask) {
        if (appTask == null || !appTask.isBidding()) {
            return;
        }
        if (GDTAd.isGdtFlowAd(appTask)) {
            GDTAd.sendWinNotification((NativeUnifiedADData) appTask.origin);
            return;
        }
        if (VivoAd.isVivoAd(appTask)) {
            VivoAd.sendWinNotification((NativeResponse) appTask.origin);
            return;
        }
        if (KsAd.isKsFlowAd(appTask)) {
            KsAd.sendWinNotification((KsNativeAd) appTask.origin);
        } else if (BaeAd.isBaeFlowAd(appTask)) {
            BaeAd.sendWinNotification((com.baidu.mobads.sdk.api.NativeResponse) appTask.origin);
        } else if (BaseAd.isOppoFlowAd(appTask)) {
            BaseAd.sendOppoWinNotification(appTask);
        }
    }

    public void P(final Activity activity, final AppTask appTask, final b.d.a.k.b receiver) {
        new Handler().postDelayed(new Runnable() { // from class: com.martian.mibook.application.f
            @Override // java.lang.Runnable
            public final void run() {
                g0.this.A(appTask, activity, receiver);
            }
        }, 200L);
    }

    public void Q(final j1 activity, final AppTask videoAppTask, @NonNull final b.d.a.k.b receiver) {
        new Handler().postDelayed(new Runnable() { // from class: com.martian.mibook.application.g
            @Override // java.lang.Runnable
            public final void run() {
                g0.this.C(activity, receiver, videoAppTask);
            }
        }, 200L);
    }

    private Activity getActivity() {
        WeakReference<Activity> weakReference = this.f11413e;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    public void l(AppTask appTask) {
        if (appTask == null || !appTask.isBidding()) {
            return;
        }
        if (this.f11412d == null) {
            this.f11412d = new ArrayList();
        }
        this.f11412d.add(appTask);
    }

    public void m(AppTask appTask) {
        if (appTask == null || !appTask.isBidding()) {
            return;
        }
        if (this.f11410b == null) {
            this.f11410b = new ArrayList();
        }
        this.f11410b.add(appTask);
    }

    public void n(AppTask appTask) {
        if (appTask == null || !appTask.isBidding()) {
            return;
        }
        if (this.f11411c == null) {
            this.f11411c = new ArrayList();
        }
        this.f11411c.add(appTask);
    }

    public static boolean o(AppTask appTask) {
        return appTask != null && System.currentTimeMillis() - appTask.createdOn < 1680000;
    }

    public static void p(AppTask appTask) {
        if (TTAd.isTTFlowAd(appTask)) {
            TTAd.destroyView((TTFeedAd) appTask.origin);
            appTask.origin = null;
        }
        if (appTask != null) {
            appTask.destroyNativeAd();
        }
    }

    public static void q(AppTaskList appTaskList) {
        if (appTaskList == null || appTaskList.getApps() == null || appTaskList.getApps().isEmpty()) {
            return;
        }
        Iterator<AppTask> it = appTaskList.getApps().iterator();
        while (it.hasNext()) {
            p(it.next());
        }
    }

    private void u(Activity activity, AppTask biddingAppTask, b.d.a.k.b receiver, boolean portrait) {
        com.martian.mibook.b.b d0 = com.martian.mibook.b.b.d0(activity, biddingAppTask == null ? 0 : biddingAppTask.getEcpm(), portrait);
        d0.T0(new b(activity, biddingAppTask, receiver));
        com.martian.mibook.lib.model.g.b.o(activity, "信息流-瀑布流-请求");
        d0.F();
    }

    public void v(Activity activity, AppTask biddingAppTask, String pid, b.d.a.k.b receiver) {
        com.martian.mibook.b.b n0 = com.martian.mibook.b.b.n0(activity, pid, biddingAppTask == null ? 0 : biddingAppTask.getEcpm());
        n0.T0(new d(activity, receiver, biddingAppTask));
        com.martian.mibook.lib.model.g.b.o(activity, "插屏-瀑布流-请求");
        n0.F();
    }

    public void w(j1 activity, AppTask appTask, String pid, @NonNull b.d.a.k.b receiver) {
        com.martian.mibook.b.b m0 = com.martian.mibook.b.b.m0(activity, pid, appTask == null ? 0 : appTask.getEcpm());
        m0.T0(new f(receiver, activity, appTask));
        m0.F();
    }

    /* renamed from: z */
    public /* synthetic */ void A(final AppTask appTask, final Activity activity, final b.d.a.k.b receiver) {
        if (appTask == null || !com.martian.libmars.utils.n0.B(activity)) {
            if (receiver != null) {
                receiver.h();
                return;
            }
            return;
        }
        com.martian.libugrowth.b.k().g(appTask.id, AdConfig.Action.ESHOW, appTask.source, appTask.getGid(), appTask.getEcpm());
        Object obj = appTask.origin;
        if (obj instanceof ExpressInterstitialAd) {
            MiConfigSingleton.V3().j8(true);
            BaeAd.showInterstitialAd(activity, (ExpressInterstitialAd) appTask.origin, appTask.isBidding());
        } else if (obj instanceof UnifiedInterstitialAD) {
            GDTAd.showInterstitialAd(activity, (UnifiedInterstitialAD) obj, appTask.isBidding());
        } else if (obj instanceof KsInterstitialAd) {
            KsAd.showInterstitialAd(activity, (KsInterstitialAd) obj, appTask.isBidding());
        } else if (obj instanceof TTNativeExpressAd) {
            TTAd.showInterstitialAd((TTNativeExpressAd) obj);
        } else if (obj instanceof TTFullScreenVideoAd) {
            MiConfigSingleton.V3().j8(true);
            TTAd.showFullScreenVideoAd(activity, (TTFullScreenVideoAd) appTask.origin);
        } else if (obj instanceof UnifiedVivoInterstitialAd) {
            VivoAd.showInterstitialAd(activity, (UnifiedVivoInterstitialAd) obj, appTask.isBidding());
        } else if (!BaseAd.isOppoInterstitialAd(appTask)) {
            return;
        } else {
            BaseAd.showOppoInterstitialAd(appTask);
        }
        if (MiConfigSingleton.V3().W3().getEnableBaeAdInfo()) {
            if (this.f11416h == null) {
                this.f11416h = new AdConfig.AdInfo();
            }
            this.f11416h.setSource(appTask.source);
            this.f11416h.setEcpm(appTask.getEcpm());
        }
    }

    public void G(AppTask winAppTask) {
        List<AppTask> list = this.f11412d;
        if (list == null || list.isEmpty()) {
            return;
        }
        Iterator<AppTask> it = this.f11412d.iterator();
        while (it.hasNext()) {
            AppTask next = it.next();
            it.remove();
            K(winAppTask, next, 1, 1, BaeAd.BIDDING_FAIL_LOW_PRICE, 1);
        }
    }

    public void O(AppTask newSplashAppTask) {
        this.f11414f.o(newSplashAppTask);
    }

    public void R(Activity activity) {
        this.f11414f.p(activity);
    }

    public void r(Activity activity, b.d.a.k.b receiver, boolean portrait) {
        if (System.currentTimeMillis() - this.f11415g < 3000 || !com.martian.libmars.utils.n0.C(activity)) {
            return;
        }
        this.f11415g = System.currentTimeMillis();
        com.martian.mibook.b.b c0 = com.martian.mibook.b.b.c0(activity, portrait);
        c0.T0(new a(receiver, portrait));
        com.martian.mibook.lib.model.g.b.o(activity, "信息流-bidding-请求");
        c0.F();
    }

    public void s(Activity activity, String pid, b.d.a.k.b receiver) {
        com.martian.mibook.b.b e0 = com.martian.mibook.b.b.e0(activity, pid, this.f11416h);
        e0.T0(new c(activity, pid, receiver));
        com.martian.mibook.lib.model.g.b.o(activity, "插屏-bidding-请求");
        e0.F();
    }

    public void t(j1 activity, String pid, @NonNull b.d.a.k.b receiver) {
        if (activity == null) {
            return;
        }
        activity.e2(true, activity.getString(R.string.reward_video_loading));
        com.martian.mibook.b.b l0 = com.martian.mibook.b.b.l0(activity, pid, this.f11417i);
        com.martian.mibook.lib.model.g.b.o(activity, "激励视频-bidding-请求");
        l0.T0(new e(activity, pid, receiver));
        l0.F();
    }

    public void x(Activity activity, boolean portrait, b.d.a.k.b receiver) {
        this.f11413e = new WeakReference<>(activity);
        r(activity, receiver, portrait);
    }

    public AppTask y(Activity activity, b.d.a.k.b receiver) {
        return this.f11414f.k(activity, receiver);
    }
}
