package cn.vlion.ad.inland.base;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import cn.vlion.ad.inland.ad.config.VlionCustomAdActiveType$VlionCustomTarget;
import cn.vlion.ad.inland.ad.javabean.VlionCustomAdData;
import cn.vlion.ad.inland.ad.javabean.VlionCustomParseAdData;
import cn.vlion.ad.inland.ad.utils.VlionCustomSpitUtils;
import cn.vlion.ad.inland.ad.utils.apkdownload.DownloadApkData;
import cn.vlion.ad.inland.ad.utils.sensor.VlionSensorBean;
import cn.vlion.ad.inland.ad.utils.sensor.VlionSensorManagerHelper;
import cn.vlion.ad.inland.ad.view.active.VlionAdClosedView;
import cn.vlion.ad.inland.ad.view.dialog.VlionDownloadHoldDialogActivity;
import cn.vlion.ad.inland.ad.view.dialog.VlionDownloadSecondConfirmActivity;
import cn.vlion.ad.inland.base.bid.VlionBiddingActionListener;
import cn.vlion.ad.inland.base.javabean.VlionADClickType;
import cn.vlion.ad.inland.base.javabean.VlionAdapterADConfig;
import cn.vlion.ad.inland.base.javabean.VlionServiceConfig;
import cn.vlion.ad.inland.base.javabean.VlionServiceConfigParse;
import cn.vlion.ad.inland.base.q4;
import cn.vlion.ad.inland.base.util.VlionAdLimitStrategyUtils;
import cn.vlion.ad.inland.base.util.VlionHandlerUtils;
import cn.vlion.ad.inland.base.util.event.VlionADEventManager;
import cn.vlion.ad.inland.base.util.handle.VlionClickParameterReplace;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import cn.vlion.ad.inland.base.util.log.LogVlion;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class j extends FrameLayout implements cn.vlion.ad.inland.base.d {
    public g7 A;

    /* renamed from: a */
    public Context f2952a;

    /* renamed from: b */
    public k1 f2953b;

    /* renamed from: c */
    public e f2954c;

    /* renamed from: d */
    public boolean f2955d;

    /* renamed from: e */
    public boolean f2956e;

    /* renamed from: f */
    public boolean f2957f;

    /* renamed from: g */
    public d f2958g;

    /* renamed from: h */
    public boolean f2959h;

    /* renamed from: i */
    public boolean f2960i;

    /* renamed from: j */
    public boolean f2961j;

    /* renamed from: k */
    public boolean f2962k;

    /* renamed from: l */
    public FrameLayout f2963l;

    /* renamed from: m */
    public i f2964m;

    /* renamed from: n */
    public VlionAdapterADConfig f2965n;

    /* renamed from: o */
    public int f2966o;

    /* renamed from: p */
    public boolean f2967p;

    /* renamed from: q */
    public WeakReference<Activity> f2968q;

    /* renamed from: r */
    public VlionSensorBean f2969r;

    /* renamed from: s */
    public i0 f2970s;

    /* renamed from: t */
    public boolean f2971t;

    /* renamed from: u */
    public q0 f2972u;

    /* renamed from: v */
    public VlionCustomParseAdData f2973v;

    /* renamed from: w */
    public VlionAdapterADConfig f2974w;

    /* renamed from: x */
    public String f2975x;

    /* renamed from: y */
    public t5 f2976y;

    /* renamed from: z */
    public boolean f2977z;

    public class a implements View.OnTouchListener {
        public a() {
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View view, MotionEvent motionEvent) {
            g7 g7Var;
            try {
                i0 i0Var = j.this.f2970s;
                if (i0Var != null) {
                    i0Var.onTouch(view, motionEvent);
                }
                g7Var = j.this.A;
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
            if (g7Var != null) {
                g7Var.a(motionEvent);
                j jVar = j.this;
                jVar.f2975x = jVar.A.a();
                LogVlion.e("CustomVlionSplashView onShake up -- RawXY =" + j.this.f2975x);
                return false;
            }
            if (motionEvent.getAction() == 0) {
                j.this.f2975x = motionEvent.getRawX() + "," + motionEvent.getRawY();
                StringBuilder sb2 = new StringBuilder();
                sb2.append("CustomVlionSplashView click hot -- RawXY =");
                sb2.append(j.this.f2975x);
                LogVlion.e(sb2.toString());
            }
            return false;
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            try {
                LogVlion.e("CustomVlionSplashView adAreaClickAction isOpenHot " + j.this.f2962k);
                if (j.this.f2962k) {
                    LogVlion.e("CustomVlionSplashView click ------ RawXY =" + j.this.f2975x);
                    VlionADClickType vlionADClickType = new VlionADClickType("click", j.this.f2975x, "main", "hotsplot", "");
                    VlionClickParameterReplace vlionClickParameterReplace = new VlionClickParameterReplace(j.this.f2973v);
                    vlionClickParameterReplace.handleBaseParameter(j.this);
                    vlionClickParameterReplace.handleClickParameter(j.this.f2970s, vlionADClickType);
                    vlionADClickType.setVlionBaseParameterReplace(vlionClickParameterReplace);
                    j.b(j.this, vlionADClickType);
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }
    }

    public class c implements o4 {
        public c() {
        }
    }

    public class d implements Application.ActivityLifecycleCallbacks {
        public d() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityCreated(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityDestroyed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityPaused(Activity activity) {
            try {
                LogVlion.e("CustomVlionSplashView onActivityPaused");
                WeakReference<Activity> weakReference = j.this.f2968q;
                if (weakReference != null && weakReference.get() != null && !j.this.f2968q.get().equals(activity)) {
                    return;
                }
                j.this.f2968q = new WeakReference<>(activity);
                j.this.a(false);
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityResumed(Activity activity) {
            try {
                LogVlion.e("CustomVlionSplashView onActivityResumed isExposure=" + j.this.f2956e);
                WeakReference<Activity> weakReference = j.this.f2968q;
                if (weakReference == null || weakReference.get() == null || !j.this.f2968q.get().equals(activity)) {
                    return;
                }
                j.this.a(true);
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStarted(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStopped(Activity activity) {
        }
    }

    public class e implements Runnable {

        /* renamed from: a */
        public int f2982a;

        public e(int i10) {
            this.f2982a = i10;
        }

        @Override // java.lang.Runnable
        public final void run() {
            k1 k1Var;
            try {
                LogVlion.e("CustomVlionSplashView TimeTick: time=" + this.f2982a + " isVisible=" + j.this.f2957f);
                int i10 = this.f2982a;
                if (i10 != 0) {
                    this.f2982a = i10 - 1;
                    i iVar = j.this.f2964m;
                    if (iVar != null) {
                        try {
                            iVar.f2881t = i10;
                            VlionAdClosedView vlionAdClosedView = iVar.f2877p;
                            if (vlionAdClosedView != null) {
                                String str = "跳过  " + i10;
                                try {
                                    TextView textView = vlionAdClosedView.f2399c;
                                    if (textView != null) {
                                        textView.setText(str);
                                    }
                                } catch (Throwable th2) {
                                    VlionSDkManager.getInstance().upLoadCatchException(th2);
                                }
                            }
                        } catch (Throwable th3) {
                            VlionSDkManager.getInstance().upLoadCatchException(th3);
                        }
                    }
                    VlionHandlerUtils.instant().postDelayed(this, 1000L);
                    return;
                }
                j jVar = j.this;
                jVar.f2955d = true;
                i iVar2 = jVar.f2964m;
                if (iVar2 != null) {
                    try {
                        iVar2.f2881t = 0;
                        VlionAdClosedView vlionAdClosedView2 = iVar2.f2877p;
                        if (vlionAdClosedView2 != null) {
                            String str2 = "跳过  0";
                            try {
                                TextView textView2 = vlionAdClosedView2.f2399c;
                                if (textView2 != null) {
                                    textView2.setText(str2);
                                }
                            } catch (Throwable th4) {
                                VlionSDkManager.getInstance().upLoadCatchException(th4);
                            }
                        }
                    } catch (Throwable th5) {
                        VlionSDkManager.getInstance().upLoadCatchException(th5);
                    }
                }
                j jVar2 = j.this;
                if (jVar2.f2957f && (k1Var = jVar2.f2953b) != null) {
                    try {
                        VlionBiddingActionListener vlionBiddingActionListener = q4.this.f3325a.f3353i;
                        if (vlionBiddingActionListener != null) {
                            vlionBiddingActionListener.onAdClose();
                        }
                    } catch (Throwable th6) {
                        VlionSDkManager.getInstance().upLoadCatchException(th6);
                    }
                }
                j.this.destroy();
                return;
            } catch (Throwable th7) {
                VlionSDkManager.getInstance().upLoadCatchException(th7);
            }
            VlionSDkManager.getInstance().upLoadCatchException(th7);
        }
    }

    public j(Context context, q4.a aVar) {
        super(context);
        this.f2959h = false;
        this.f2960i = false;
        this.f2961j = false;
        this.f2962k = false;
        this.f2966o = 5;
        this.f2971t = false;
        this.f2975x = "";
        this.f2977z = false;
        this.f2952a = context;
        this.f2953b = aVar;
        b();
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0014, code lost:
    
        if (r8.f2971t != false) goto L80;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a() {
        /*
            r8 = this;
            boolean r0 = r8.f2959h     // Catch: java.lang.Throwable -> L1b
            if (r0 == 0) goto L31
            boolean r0 = r8.f2960i     // Catch: java.lang.Throwable -> L1b
            if (r0 == 0) goto L22
            android.content.res.Resources r0 = r8.getResources()     // Catch: java.lang.Throwable -> L1b
            int r1 = cn.vlion.ad.inland.base.R.string.vlion_custom_ad_splash_twist_swipe_tips_text     // Catch: java.lang.Throwable -> L1b
            java.lang.String r0 = r0.getString(r1)     // Catch: java.lang.Throwable -> L1b
            boolean r1 = r8.f2971t     // Catch: java.lang.Throwable -> L1b
            if (r1 == 0) goto L1d
        L16:
            android.content.res.Resources r1 = r8.getResources()     // Catch: java.lang.Throwable -> L1b
            goto L44
        L1b:
            r0 = move-exception
            goto L7b
        L1d:
            android.content.res.Resources r1 = r8.getResources()     // Catch: java.lang.Throwable -> L1b
            goto L47
        L22:
            android.content.res.Resources r0 = r8.getResources()     // Catch: java.lang.Throwable -> L1b
            int r1 = cn.vlion.ad.inland.base.R.string.vlion_custom_ad_splash_twist_tips_text     // Catch: java.lang.Throwable -> L1b
            java.lang.String r0 = r0.getString(r1)     // Catch: java.lang.Throwable -> L1b
            boolean r1 = r8.f2971t     // Catch: java.lang.Throwable -> L1b
            if (r1 == 0) goto L1d
            goto L16
        L31:
            boolean r0 = r8.f2960i     // Catch: java.lang.Throwable -> L1b
            if (r0 == 0) goto L4a
            android.content.res.Resources r0 = r8.getResources()     // Catch: java.lang.Throwable -> L1b
            int r1 = cn.vlion.ad.inland.base.R.string.vlion_custom_ad_splash_swipe_tips_text     // Catch: java.lang.Throwable -> L1b
            java.lang.String r0 = r0.getString(r1)     // Catch: java.lang.Throwable -> L1b
            boolean r1 = r8.f2971t     // Catch: java.lang.Throwable -> L1b
            if (r1 == 0) goto L1d
            goto L16
        L44:
            int r2 = cn.vlion.ad.inland.base.R.string.vlion_custom_ad_download_now     // Catch: java.lang.Throwable -> L1b
            goto L5d
        L47:
            int r2 = cn.vlion.ad.inland.base.R.string.vlion_custom_ad_splash_click_action_text     // Catch: java.lang.Throwable -> L1b
            goto L5d
        L4a:
            java.lang.String r0 = ""
            boolean r1 = r8.f2971t     // Catch: java.lang.Throwable -> L1b
            if (r1 == 0) goto L57
            android.content.res.Resources r1 = r8.getResources()     // Catch: java.lang.Throwable -> L1b
            int r2 = cn.vlion.ad.inland.base.R.string.vlion_custom_ad_click_download     // Catch: java.lang.Throwable -> L1b
            goto L5d
        L57:
            android.content.res.Resources r1 = r8.getResources()     // Catch: java.lang.Throwable -> L1b
            int r2 = cn.vlion.ad.inland.base.R.string.vlion_custom_ad_splash_click_tips_text     // Catch: java.lang.Throwable -> L1b
        L5d:
            java.lang.String r1 = r1.getString(r2)     // Catch: java.lang.Throwable -> L1b
            cn.vlion.ad.inland.base.i r2 = r8.f2964m     // Catch: java.lang.Throwable -> L1b
            if (r2 == 0) goto L82
            cn.vlion.ad.inland.base.javabean.VlionAdapterADConfig r3 = r8.f2965n     // Catch: java.lang.Throwable -> L1b
            boolean r4 = r8.f2959h     // Catch: java.lang.Throwable -> L1b
            boolean r5 = r8.f2960i     // Catch: java.lang.Throwable -> L1b
            cn.vlion.ad.inland.base.j$c r6 = new cn.vlion.ad.inland.base.j$c     // Catch: java.lang.Throwable -> L1b
            r6.<init>()     // Catch: java.lang.Throwable -> L1b
            cn.vlion.ad.inland.ad.javabean.VlionCustomParseAdData r7 = r8.f2973v     // Catch: java.lang.Throwable -> L1b
            r2.a(r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L1b
            cn.vlion.ad.inland.base.i r2 = r8.f2964m     // Catch: java.lang.Throwable -> L1b
            r2.a(r0, r1)     // Catch: java.lang.Throwable -> L1b
            goto L82
        L7b:
            cn.vlion.ad.inland.base.util.init.VlionSDkManager r1 = cn.vlion.ad.inland.base.util.init.VlionSDkManager.getInstance()
            r1.upLoadCatchException(r0)
        L82:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.vlion.ad.inland.base.j.a():void");
    }

    public final void b() {
        try {
            LogVlion.e("CustomVlionSplashView initActivityLifecycle");
            this.f2958g = new d();
            VlionSDkManager.getInstance().registerActivityLifecycleCallbacks(this.f2958g);
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public final boolean c() {
        try {
            int width = getWidth();
            int height = getHeight();
            LogVlion.e("CustomVlionSplashView isRectVisible: width()=" + width + " height=" + height);
            if (width == 0 || height == 0) {
                return false;
            }
            Rect rect = new Rect();
            boolean isShown = isShown();
            boolean localVisibleRect = getLocalVisibleRect(rect);
            LogVlion.e("CustomVlionSplashView isRectVisible: isShown=" + isShown + " isLocalVisibleRect=" + localVisibleRect);
            if (isShown && localVisibleRect) {
                int i10 = (rect.bottom - rect.top) * (rect.right - rect.left);
                StringBuilder sb2 = new StringBuilder();
                sb2.append("CustomVlionSplashView isRectVisible: width * height=");
                int i11 = width * height;
                sb2.append(i11);
                sb2.append(" (rect.right - rect.left) * (rect.bottom - rect.top)=");
                sb2.append((rect.bottom - rect.top) * (rect.right - rect.left));
                sb2.append(" 左移一位=");
                sb2.append(((rect.bottom - rect.top) * (rect.right - rect.left)) << 1);
                sb2.append(" rectPix=");
                sb2.append(i10);
                LogVlion.e(sb2.toString());
                if (!this.f2967p && i10 > 0) {
                    VlionADEventManager.getParameterEnter(this.f2965n);
                    this.f2967p = true;
                }
                return i11 <= (((rect.bottom - rect.top) * (rect.right - rect.left)) << 1);
            }
            return false;
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
            return false;
        }
    }

    public final void d() {
        try {
            LogVlion.e("VlionAdExposureUtils exposure ");
            if (this.f2959h) {
                try {
                    if (c()) {
                        VlionSensorManagerHelper.getInstance().registerShakeListener(VlionSDkManager.getInstance().getApplication(), this.f2969r);
                    }
                } catch (Throwable th2) {
                    VlionSDkManager.getInstance().upLoadCatchException(th2);
                }
            }
            if (this.f2976y != null) {
                VlionAdLimitStrategyUtils.getInstance().setLimitStrategyBean(this.f2965n.getAdxTagId() + 5, null);
            }
            k1 k1Var = this.f2953b;
            if (k1Var != null) {
                ((q4.a) k1Var).a();
            }
            this.f2956e = true;
        } catch (Throwable th3) {
            VlionSDkManager.getInstance().upLoadCatchException(th3);
        }
    }

    @Override // cn.vlion.ad.inland.base.d
    public final void destroy() {
        VlionDownloadSecondConfirmActivity vlionDownloadSecondConfirmActivity;
        VlionDownloadHoldDialogActivity vlionDownloadHoldDialogActivity;
        try {
            LogVlion.e("CustomVlionSplashView destroy: ");
            t5 t5Var = this.f2976y;
            if (t5Var != null) {
                t5Var.a();
                this.f2976y = null;
            }
            WeakReference<VlionDownloadHoldDialogActivity> weakReference = VlionDownloadHoldDialogActivity.f2444e;
            if (weakReference != null && (vlionDownloadHoldDialogActivity = weakReference.get()) != null) {
                vlionDownloadHoldDialogActivity.finish();
            }
            WeakReference<VlionDownloadSecondConfirmActivity> weakReference2 = VlionDownloadSecondConfirmActivity.f2451j;
            if (weakReference2 != null && (vlionDownloadSecondConfirmActivity = weakReference2.get()) != null) {
                vlionDownloadSecondConfirmActivity.finish();
            }
            i0 i0Var = this.f2970s;
            if (i0Var != null) {
                i0Var.a();
                this.f2970s = null;
            }
            if (this.f2958g != null) {
                VlionSDkManager.getInstance().unregisterActivityLifecycleCallbacks(this.f2958g);
                this.f2958g = null;
            }
            i iVar = this.f2964m;
            if (iVar != null) {
                iVar.destroy();
                this.f2964m = null;
            }
            VlionSensorManagerHelper.getInstance().unregisterShakeListener(this.f2969r);
            if (this.f2954c != null) {
                VlionHandlerUtils.instant().removeCallbacks(this.f2954c);
                this.f2954c = null;
            }
            q0 q0Var = this.f2972u;
            if (q0Var != null) {
                q0Var.a();
                this.f2972u = null;
            }
            try {
                LogVlion.e("CustomVlionSplashView unregisterExposure= ");
                if (this.f2958g != null) {
                    VlionSDkManager.getInstance().unregisterActivityLifecycleCallbacks(this.f2958g);
                    this.f2958g = null;
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
            a(false);
        } catch (Throwable th3) {
            VlionSDkManager.getInstance().upLoadCatchException(th3);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        try {
            LogVlion.e("CustomVlionSplashView onAttachedToWindow: ");
            VlionHandlerUtils.instant().post(this.f2954c);
            VlionADEventManager.getParameterShow(this.f2965n, "CustomVlionSplashView");
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        destroy();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        try {
            LogVlion.e("CustomVlionSplashView onLayout: isTimeEnd=" + this.f2955d + "isExposure=" + this.f2956e);
            if (this.f2955d || this.f2956e) {
                return;
            }
            a(c());
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // android.view.View
    public final void onWindowFocusChanged(boolean z10) {
        super.onWindowFocusChanged(z10);
        try {
            LogVlion.e("CustomVlionSplashView onWindowFocusChanged: " + z10);
            a(z10);
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public final void a(View view, VlionAdapterADConfig vlionAdapterADConfig, VlionCustomParseAdData vlionCustomParseAdData) {
        if (view == null || vlionAdapterADConfig == null) {
            return;
        }
        try {
            Context context = this.f2952a;
            if (context == null) {
                return;
            }
            this.f2965n = vlionAdapterADConfig;
            this.f2974w = vlionAdapterADConfig;
            this.f2963l = (FrameLayout) LayoutInflater.from(context).inflate(R.layout.vlion_cn_ad_splash_view, (ViewGroup) this, true).findViewById(R.id.vlion_splash_fl_container);
            this.f2973v = vlionCustomParseAdData;
            b(view, vlionAdapterADConfig, vlionCustomParseAdData);
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public final void b(View view, VlionAdapterADConfig vlionAdapterADConfig, VlionCustomParseAdData vlionCustomParseAdData) {
        i iVar;
        try {
            VlionServiceConfig.DataBean.TemplatesBean a10 = t4.a(vlionAdapterADConfig);
            if (a10 == null) {
                return;
            }
            vlionAdapterADConfig.setTemplate(String.valueOf(a10.getId()));
            ArrayList<String> splitString = VlionCustomSpitUtils.getSplitString(vlionAdapterADConfig.getCreativeType());
            VlionServiceConfig.DataBean.TemplatesBean.MainBean main = a10.getMain();
            if (main != null) {
                int max_sec = main.getMax_sec();
                this.f2966o = max_sec;
                if (max_sec <= 0) {
                    this.f2966o = 5;
                }
                this.f2954c = new e(this.f2966o);
                String style = main.getStyle();
                if (style.hashCode() == -540435981 && style.equals("OPEN_P_MAIN_BASE")) {
                    iVar = new i(this.f2952a, 0);
                    this.f2964m = iVar;
                    iVar.a(view);
                    this.f2963l.removeAllViews();
                    j0.a(this.f2964m);
                    this.f2963l.addView(this.f2964m);
                }
                iVar = new i(this.f2952a, 0);
                this.f2964m = iVar;
                iVar.a(view);
                this.f2963l.removeAllViews();
                j0.a(this.f2964m);
                this.f2963l.addView(this.f2964m);
            }
            if (splitString.size() > 0) {
                for (int i10 = 0; i10 < splitString.size(); i10++) {
                    if ("shake".equals(splitString.get(i10))) {
                        if (!this.f2977z) {
                            this.f2959h = true;
                        }
                    } else if ("swipe-up".equals(splitString.get(i10))) {
                        this.f2960i = true;
                    } else if ("swipe-all".equals(splitString.get(i10))) {
                        this.f2961j = true;
                    }
                }
            }
            if (vlionCustomParseAdData != null) {
                if (vlionCustomParseAdData.getCsBean(2, -1) == null) {
                    this.f2959h = false;
                }
                if (this.f2973v.getCsBean(3, -1) == null) {
                    this.f2960i = false;
                }
                if (this.f2973v.getCsBean(4, -1) == null) {
                    this.f2961j = false;
                }
            }
            if (this.f2959h) {
                a(vlionCustomParseAdData, vlionAdapterADConfig);
            }
            if (this.f2960i || this.f2961j) {
                b(vlionCustomParseAdData, vlionAdapterADConfig);
            }
            this.f2971t = vlionCustomParseAdData.isIs_download();
            this.f2972u = new q0();
            if (this.f2971t) {
                this.f2972u.f3297a = new DownloadApkData(vlionCustomParseAdData, vlionAdapterADConfig);
            }
            if (this.f2971t) {
                VlionCustomAdData.SeatbidBean.BidBean.AppInfoBean appInfoBean = vlionCustomParseAdData.getAppInfoBean();
                i iVar2 = this.f2964m;
                if (iVar2 != null && appInfoBean != null) {
                    iVar2.setAppinfo(appInfoBean);
                }
            }
            a();
            this.f2970s = new i0();
            setOnTouchListener(new a());
            this.f2962k = VlionServiceConfigParse.getInstance().isHotspot();
            setOnClickListener(new b());
            VlionServiceConfig.DataBean.ActivityTemplateBean activityTemplate = VlionServiceConfigParse.getInstance().getActivityTemplate(vlionAdapterADConfig.getAdxTagId(), 5, a10.getId() + "");
            if (activityTemplate == null || activityTemplate.getType() != 2) {
                return;
            }
            this.f2962k = true;
            this.f2976y = new t5(this, activityTemplate.getMaterial_url());
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public final void a(VlionCustomParseAdData vlionCustomParseAdData, VlionAdapterADConfig vlionAdapterADConfig) {
        if (vlionAdapterADConfig == null || vlionCustomParseAdData == null) {
            return;
        }
        try {
            VlionCustomAdData.SeatbidBean.BidBean.McBean.CsBean csBean = vlionCustomParseAdData.getCsBean(2, -1);
            if (csBean == null) {
                csBean = vlionCustomParseAdData.getDefaultShakeCsBean();
            }
            LogVlion.e("CustomVlionSplashView onShake isD =" + csBean.isD());
            this.f2969r = new VlionSensorBean(csBean.getAcc(), csBean.getAng(), csBean.getDui(), new k(this, csBean));
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public static void a(j jVar, VlionADClickType vlionADClickType) {
        jVar.getClass();
        try {
            VlionCustomAdActiveType$VlionCustomTarget a10 = jVar.f2972u.a(jVar.getContext(), jVar.f2974w, jVar.f2973v, new o(jVar));
            if (a10 != null && vlionADClickType != null) {
                vlionADClickType.setTarget(a10.toString());
            }
            if (vlionADClickType != null) {
                q0 q0Var = jVar.f2972u;
                Context context = jVar.getContext();
                VlionCustomParseAdData vlionCustomParseAdData = jVar.f2973v;
                q0Var.getClass();
                vlionADClickType.setIsCanOpenDp(q0.a(context, vlionCustomParseAdData));
            }
            k1 k1Var = jVar.f2953b;
            if (k1Var != null) {
                ((q4.a) k1Var).a(vlionADClickType);
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public final void a(boolean z10) {
        try {
            LogVlion.e("CustomVlionSplashView isResume= " + z10 + " isTimeEnd=" + this.f2955d);
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
            return;
        }
        if (z10) {
            if (this.f2955d) {
                k1 k1Var = this.f2953b;
                if (k1Var != null) {
                    try {
                        VlionBiddingActionListener vlionBiddingActionListener = q4.this.f3325a.f3353i;
                        if (vlionBiddingActionListener != null) {
                            vlionBiddingActionListener.onAdClose();
                        }
                    } catch (Throwable th3) {
                        VlionSDkManager.getInstance().upLoadCatchException(th3);
                    }
                }
                destroy();
                this.f2955d = false;
                return;
            }
            if (this.f2959h) {
                try {
                    if (c()) {
                        VlionSensorManagerHelper.getInstance().registerShakeListener(VlionSDkManager.getInstance().getApplication(), this.f2969r);
                    }
                } catch (Throwable th4) {
                    VlionSDkManager.getInstance().upLoadCatchException(th4);
                }
            }
            VlionSDkManager.getInstance().upLoadCatchException(th2);
            return;
        }
        if (this.f2959h) {
            VlionSensorManagerHelper.getInstance().unregisterShakeListener(this.f2969r);
        }
        b(z10);
    }

    public final void b(VlionCustomParseAdData vlionCustomParseAdData, VlionAdapterADConfig vlionAdapterADConfig) {
        if (vlionCustomParseAdData == null) {
            return;
        }
        try {
            LogVlion.e("CustomVlionSplashView isSwipeUp=" + this.f2960i + " isSwipeAll=" + this.f2961j);
            if (this.f2960i) {
                VlionCustomAdData.SeatbidBean.BidBean.McBean.CsBean csBean = vlionCustomParseAdData.getCsBean(3, -1);
                if (csBean == null) {
                    csBean = vlionCustomParseAdData.getDefaultSwipeUpCsBean();
                }
                g7 g7Var = new g7(this.f2960i, csBean.getH(), new l(this, csBean));
                this.A = g7Var;
                this.f2964m.settingVlionViewTouch(g7Var);
            }
            if (this.f2961j) {
                i0 i0Var = new i0(this.f2963l);
                this.f2970s = i0Var;
                i0Var.a(this.f2963l, vlionCustomParseAdData.getCsBean(4, -1), new m(this, vlionAdapterADConfig));
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public final void b(boolean z10) {
        try {
            LogVlion.e("CustomVlionSplashView isViewVisible: isExposure=" + this.f2956e + " this.isVisible=" + this.f2957f);
            if (this.f2956e) {
                this.f2957f = z10;
            } else if (z10) {
                boolean c10 = c();
                LogVlion.e("CustomVlionSplashView isViewVisible: isRectVisible=" + c10 + " isVisible=" + this.f2957f);
                if (!this.f2957f && c10) {
                    LogVlion.e("CustomVlionSplashView becomeVisible: ");
                    this.f2957f = true;
                    d();
                }
            } else if (this.f2957f) {
                this.f2957f = false;
            }
            t5 t5Var = this.f2976y;
            if (t5Var != null) {
                t5Var.a(z10);
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public static void b(j jVar, VlionADClickType vlionADClickType) {
        jVar.getClass();
        try {
            q0 q0Var = jVar.f2972u;
            if (q0Var != null && jVar.f2973v != null) {
                q0Var.a(jVar.getContext(), jVar.f2973v.getDp(), jVar.f2971t, new n(jVar, vlionADClickType));
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }
}
