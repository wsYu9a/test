package cn.vlion.ad.inland.base;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import cn.vlion.ad.inland.ad.config.VlionCustomAdActiveType$VlionCustomTarget;
import cn.vlion.ad.inland.ad.javabean.VlionCustomAdData;
import cn.vlion.ad.inland.ad.javabean.VlionCustomParseAdData;
import cn.vlion.ad.inland.ad.utils.apkdownload.DownloadApkData;
import cn.vlion.ad.inland.ad.utils.sensor.VlionSensorBean;
import cn.vlion.ad.inland.ad.utils.sensor.VlionSensorManagerHelper;
import cn.vlion.ad.inland.ad.view.active.VlionDownloadProgressBar;
import cn.vlion.ad.inland.base.javabean.VlionADClickType;
import cn.vlion.ad.inland.base.javabean.VlionAdapterADConfig;
import cn.vlion.ad.inland.base.javabean.VlionServiceConfigParse;
import cn.vlion.ad.inland.base.k2;
import cn.vlion.ad.inland.base.util.event.VlionADEventManager;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import cn.vlion.ad.inland.base.util.log.LogVlion;

/* loaded from: classes.dex */
public final class i2 extends v0 implements d {
    public VlionCustomParseAdData A;
    public VlionAdapterADConfig B;
    public q0 C;
    public View D;
    public TextView E;
    public boolean F;

    /* renamed from: h */
    public TextView f2922h;

    /* renamed from: i */
    public ImageView f2923i;

    /* renamed from: j */
    public TextView f2924j;

    /* renamed from: k */
    public VlionDownloadProgressBar f2925k;

    /* renamed from: l */
    public LinearLayout f2926l;

    /* renamed from: m */
    public a2 f2927m;

    /* renamed from: n */
    public VlionAdapterADConfig f2928n;

    /* renamed from: o */
    public VlionSensorBean f2929o;

    /* renamed from: p */
    public i0 f2930p;

    /* renamed from: q */
    public FrameLayout f2931q;

    /* renamed from: r */
    public FrameLayout f2932r;

    /* renamed from: s */
    public FrameLayout f2933s;

    /* renamed from: t */
    public FrameLayout f2934t;

    /* renamed from: u */
    public Context f2935u;

    /* renamed from: v */
    public DownloadApkData f2936v;

    /* renamed from: w */
    public boolean f2937w;

    /* renamed from: x */
    public boolean f2938x;

    /* renamed from: y */
    public n2 f2939y;

    /* renamed from: z */
    public boolean f2940z;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            i2.this.c();
        }
    }

    public i2(Context context, VlionAdapterADConfig vlionAdapterADConfig) {
        super(context);
        this.f2937w = false;
        this.f2938x = false;
        this.f2940z = false;
        this.F = false;
        this.f2935u = context;
        try {
            this.f2928n = vlionAdapterADConfig;
            LayoutInflater.from(context).inflate(R.layout.vlion_cn_ad_draw_layout_base, (ViewGroup) this, true);
            this.f2932r = (FrameLayout) findViewById(R.id.vlion_ad_draw_ll_image);
            this.f2933s = (FrameLayout) findViewById(R.id.vlion_ad_draw_ll_video);
            this.f2934t = (FrameLayout) findViewById(R.id.vlion_ad_draw_video);
            this.f2931q = (FrameLayout) findViewById(R.id.vlion_ad_draw_info);
            this.f2926l = (LinearLayout) findViewById(R.id.vlion_ad_down_info);
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public static void b(i2 i2Var, VlionADClickType vlionADClickType) {
        i2Var.getClass();
        try {
            LogVlion.e("VlionCustomDrawAdLayout adAreaClickAction isOpenHot" + VlionServiceConfigParse.getInstance().isHotspot());
            i2Var.C.a(i2Var.f2935u, i2Var.A.getDp(), i2Var.f2937w, new f2(i2Var, vlionADClickType));
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:148:0x00f4 A[Catch: all -> 0x0088, TryCatch #3 {all -> 0x0088, blocks: (B:3:0x0008, B:10:0x0018, B:13:0x003e, B:18:0x005c, B:21:0x007e, B:22:0x008c, B:24:0x0093, B:25:0x00a0, B:27:0x00a8, B:29:0x00ae, B:30:0x00b9, B:32:0x00bd, B:33:0x00fc, B:36:0x010d, B:38:0x0113, B:40:0x011f, B:42:0x0123, B:44:0x0125, B:48:0x0128, B:50:0x012c, B:52:0x0132, B:53:0x0134, B:55:0x0162, B:57:0x016a, B:59:0x016e, B:60:0x023d, B:62:0x0243, B:67:0x0257, B:68:0x025e, B:70:0x027f, B:71:0x02fb, B:72:0x0309, B:74:0x0330, B:78:0x0287, B:80:0x0291, B:81:0x0303, B:82:0x0175, B:84:0x0179, B:85:0x017e, B:88:0x018d, B:90:0x0199, B:92:0x01d6, B:93:0x01d9, B:115:0x0236, B:117:0x0298, B:119:0x029c, B:120:0x02a1, B:123:0x02c7, B:125:0x02d1, B:126:0x02da, B:128:0x02e4, B:129:0x02eb, B:131:0x02f5, B:134:0x02c0, B:135:0x00c1, B:137:0x00c5, B:139:0x00cb, B:140:0x00ce, B:142:0x00d2, B:146:0x00e7, B:148:0x00f4, B:150:0x00de, B:96:0x01e6, B:99:0x0202, B:102:0x021b, B:107:0x022d, B:110:0x0214, B:113:0x01fb, B:101:0x0204, B:98:0x01eb, B:104:0x021d, B:64:0x024b, B:122:0x02b4), top: B:2:0x0008, inners: #1, #2, #6 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(android.view.View r21, cn.vlion.ad.inland.base.javabean.VlionAdapterADConfig r22, cn.vlion.ad.inland.ad.javabean.VlionCustomParseAdData r23, cn.vlion.ad.inland.base.k2.a.C0026a r24) {
        /*
            Method dump skipped, instructions count: 829
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.vlion.ad.inland.base.i2.a(android.view.View, cn.vlion.ad.inland.base.javabean.VlionAdapterADConfig, cn.vlion.ad.inland.ad.javabean.VlionCustomParseAdData, cn.vlion.ad.inland.base.k2$a$a):void");
    }

    public final void c() {
        try {
            if (this.f2940z) {
                VlionSensorManagerHelper.getInstance().unregisterShakeListener(this.f2929o);
                LogVlion.e("端策略 :  ---移除摇一摇监听---= ");
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public final void d() {
        VlionDownloadProgressBar vlionDownloadProgressBar;
        Resources resources;
        int i10;
        VlionDownloadProgressBar vlionDownloadProgressBar2;
        Resources resources2;
        int i11;
        try {
            if (this.f2937w) {
                if (this.f2938x) {
                    if (this.f2940z) {
                        vlionDownloadProgressBar2 = this.f2925k;
                        resources2 = getResources();
                        i11 = R.string.vlion_custom_ad_download_now_shake_open;
                        vlionDownloadProgressBar2.setShakeStyle(resources2.getString(i11), true);
                        return;
                    }
                    vlionDownloadProgressBar = this.f2925k;
                    resources = getResources();
                    i10 = R.string.vlion_custom_ad_deeplink_open;
                    vlionDownloadProgressBar.setShakeStyle(resources.getString(i10), false);
                }
                if (this.f2940z) {
                    vlionDownloadProgressBar2 = this.f2925k;
                    resources2 = getResources();
                    i11 = R.string.vlion_custom_ad_download_now_shake;
                    vlionDownloadProgressBar2.setShakeStyle(resources2.getString(i11), true);
                    return;
                }
                vlionDownloadProgressBar = this.f2925k;
                resources = getResources();
                i10 = R.string.vlion_custom_ad_download_now;
                vlionDownloadProgressBar.setShakeStyle(resources.getString(i10), false);
            }
            VlionCustomParseAdData vlionCustomParseAdData = this.A;
            if (vlionCustomParseAdData == null || !q.a(this.f2935u, vlionCustomParseAdData.getDp())) {
                if (this.f2940z) {
                    vlionDownloadProgressBar2 = this.f2925k;
                    resources2 = getResources();
                    i11 = R.string.vlion_custom_ad_click_now_shake_look;
                    vlionDownloadProgressBar2.setShakeStyle(resources2.getString(i11), true);
                    return;
                }
                vlionDownloadProgressBar = this.f2925k;
                resources = getResources();
                i10 = R.string.vlion_custom_ad_look_detail;
                vlionDownloadProgressBar.setShakeStyle(resources.getString(i10), false);
            }
            if (this.f2940z) {
                vlionDownloadProgressBar2 = this.f2925k;
                resources2 = getResources();
                i11 = R.string.vlion_custom_ad_download_now_shake_open;
                vlionDownloadProgressBar2.setShakeStyle(resources2.getString(i11), true);
                return;
            }
            vlionDownloadProgressBar = this.f2925k;
            resources = getResources();
            i10 = R.string.vlion_custom_ad_deeplink_open;
            vlionDownloadProgressBar.setShakeStyle(resources.getString(i10), false);
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.v0, cn.vlion.ad.inland.base.d
    public final void destroy() {
        super.destroy();
        try {
            i0 i0Var = this.f2930p;
            if (i0Var != null) {
                i0Var.a();
                this.f2930p = null;
            }
            View view = this.D;
            if (view != null) {
                if (view instanceof h5) {
                    LogVlion.e(" 222 destroy--=");
                    ((h5) this.D).destroy();
                } else if (view instanceof a7) {
                    LogVlion.e(" 1111 destroy--=");
                    ((a7) this.D).destroy();
                }
            }
            removeAllViews();
            DownloadApkData downloadApkData = this.f2936v;
            if (downloadApkData != null) {
                downloadApkData.cancelSchedule();
                this.f2936v.setAdClosed(true);
                if (this.f2936v.isInstallComplete()) {
                    s0.a(this.f2936v.getDownloadId());
                }
            }
            q0 q0Var = this.C;
            if (q0Var != null) {
                q0Var.a();
                this.C = null;
            }
            a2 a2Var = this.f2927m;
            if (a2Var != null) {
                try {
                    if (a2Var.f2581a != null) {
                        a2Var.f2581a = null;
                    }
                    if (a2Var.f2582b != null) {
                        a2Var.f2582b = null;
                    }
                    if (a2Var.f2583c != null) {
                        a2Var.f2583c = null;
                    }
                    if (a2Var.f2584d != null) {
                        a2Var.f2584d = null;
                    }
                    if (a2Var.f2585e != null) {
                        a2Var.f2585e = null;
                    }
                    if (a2Var.f2586f != null) {
                        a2Var.f2586f = null;
                    }
                } catch (Throwable th2) {
                    VlionSDkManager.getInstance().upLoadCatchException(th2);
                }
                this.f2927m = null;
            }
        } catch (Throwable th3) {
            VlionSDkManager.getInstance().upLoadCatchException(th3);
        }
    }

    public final void e() {
        try {
            VlionCustomParseAdData vlionCustomParseAdData = this.A;
            if (vlionCustomParseAdData == null) {
                return;
            }
            VlionCustomAdData.SeatbidBean.BidBean.McBean.CsBean csBean = vlionCustomParseAdData.getCsBean(2, -1);
            if (csBean == null) {
                csBean = this.A.getDefaultShakeCsBean();
            }
            LogVlion.e("端策略 : VlionCustomBannerLayout shakeCsbean.getAcc() =" + csBean.getAcc() + " shakeCsbean.getAng()=" + csBean.getAng() + " shakeCsbean.getDui()=" + csBean.getDui());
            this.f2929o = new VlionSensorBean(csBean.getAcc(), csBean.getAng(), csBean.getDui(), new e2(this, csBean));
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        VlionADEventManager.getParameterShow(this.f2928n, "VlionCustomDrawAdLayout");
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        try {
            LogVlion.e("VlionBaseNativesVideoView onDetachedFromWindow onDetachedFromWindow------isStarted=");
            post(new a());
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x008a A[Catch: all -> 0x001f, TRY_LEAVE, TryCatch #0 {all -> 0x001f, blocks: (B:2:0x0000, B:6:0x0005, B:14:0x0031, B:15:0x0037, B:16:0x004a, B:18:0x008a, B:22:0x003a, B:23:0x0043, B:24:0x0015, B:27:0x0022), top: B:1:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0043 A[Catch: all -> 0x001f, TryCatch #0 {all -> 0x001f, blocks: (B:2:0x0000, B:6:0x0005, B:14:0x0031, B:15:0x0037, B:16:0x004a, B:18:0x008a, B:22:0x003a, B:23:0x0043, B:24:0x0015, B:27:0x0022), top: B:1:0x0000 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void settingLayoutStyle(java.lang.String r4) {
        /*
            r3 = this;
            android.content.Context r0 = r3.f2935u     // Catch: java.lang.Throwable -> L1f
            if (r0 != 0) goto L5
            return
        L5:
            int r0 = r4.hashCode()     // Catch: java.lang.Throwable -> L1f
            r1 = -1332593428(0xffffffffb0923cec, float:-1.0640213E-9)
            r2 = 1
            if (r0 == r1) goto L22
            r1 = 1435616896(0x5591c680, float:2.0035217E13)
            if (r0 == r1) goto L15
            goto L2c
        L15:
            java.lang.String r0 = "DRAW_TWO_BUTTON"
            boolean r4 = r4.equals(r0)     // Catch: java.lang.Throwable -> L1f
            if (r4 == 0) goto L2c
            r4 = 1
            goto L2d
        L1f:
            r4 = move-exception
            goto L96
        L22:
            java.lang.String r0 = "DRAW_BASE"
            boolean r4 = r4.equals(r0)     // Catch: java.lang.Throwable -> L1f
            if (r4 == 0) goto L2c
            r4 = 0
            goto L2d
        L2c:
            r4 = -1
        L2d:
            if (r4 == 0) goto L43
            if (r4 == r2) goto L3a
            android.content.Context r4 = r3.f2935u     // Catch: java.lang.Throwable -> L1f
            android.view.LayoutInflater r4 = android.view.LayoutInflater.from(r4)     // Catch: java.lang.Throwable -> L1f
        L37:
            int r0 = cn.vlion.ad.inland.base.R.layout.vlion_cn_ad_draw_layout1     // Catch: java.lang.Throwable -> L1f
            goto L4a
        L3a:
            android.content.Context r4 = r3.f2935u     // Catch: java.lang.Throwable -> L1f
            android.view.LayoutInflater r4 = android.view.LayoutInflater.from(r4)     // Catch: java.lang.Throwable -> L1f
            int r0 = cn.vlion.ad.inland.base.R.layout.vlion_cn_ad_draw_layout2     // Catch: java.lang.Throwable -> L1f
            goto L4a
        L43:
            android.content.Context r4 = r3.f2935u     // Catch: java.lang.Throwable -> L1f
            android.view.LayoutInflater r4 = android.view.LayoutInflater.from(r4)     // Catch: java.lang.Throwable -> L1f
            goto L37
        L4a:
            r1 = 0
            android.view.View r4 = r4.inflate(r0, r1, r2)     // Catch: java.lang.Throwable -> L1f
            int r0 = cn.vlion.ad.inland.base.R.id.vlion_tv_title_info     // Catch: java.lang.Throwable -> L1f
            android.view.View r0 = r4.findViewById(r0)     // Catch: java.lang.Throwable -> L1f
            android.widget.TextView r0 = (android.widget.TextView) r0     // Catch: java.lang.Throwable -> L1f
            r3.f2922h = r0     // Catch: java.lang.Throwable -> L1f
            int r0 = cn.vlion.ad.inland.base.R.id.vlion_img_showappicon     // Catch: java.lang.Throwable -> L1f
            android.view.View r0 = r4.findViewById(r0)     // Catch: java.lang.Throwable -> L1f
            android.widget.ImageView r0 = (android.widget.ImageView) r0     // Catch: java.lang.Throwable -> L1f
            r3.f2923i = r0     // Catch: java.lang.Throwable -> L1f
            int r0 = cn.vlion.ad.inland.base.R.id.vlion_tv_appName     // Catch: java.lang.Throwable -> L1f
            android.view.View r0 = r4.findViewById(r0)     // Catch: java.lang.Throwable -> L1f
            android.widget.TextView r0 = (android.widget.TextView) r0     // Catch: java.lang.Throwable -> L1f
            r3.f2924j = r0     // Catch: java.lang.Throwable -> L1f
            int r0 = cn.vlion.ad.inland.base.R.id.vlion_tv_action     // Catch: java.lang.Throwable -> L1f
            android.view.View r0 = r4.findViewById(r0)     // Catch: java.lang.Throwable -> L1f
            cn.vlion.ad.inland.ad.view.active.VlionDownloadProgressBar r0 = (cn.vlion.ad.inland.ad.view.active.VlionDownloadProgressBar) r0     // Catch: java.lang.Throwable -> L1f
            r3.f2925k = r0     // Catch: java.lang.Throwable -> L1f
            r1 = 1094713344(0x41400000, float:12.0)
            r0.setTextSize(r1)     // Catch: java.lang.Throwable -> L1f
            int r0 = cn.vlion.ad.inland.base.R.id.vlion_draw_tips     // Catch: java.lang.Throwable -> L1f
            android.view.View r0 = r4.findViewById(r0)     // Catch: java.lang.Throwable -> L1f
            android.widget.TextView r0 = (android.widget.TextView) r0     // Catch: java.lang.Throwable -> L1f
            r3.E = r0     // Catch: java.lang.Throwable -> L1f
            android.widget.FrameLayout r0 = r3.f2931q     // Catch: java.lang.Throwable -> L1f
            if (r0 == 0) goto L9d
            r0.removeAllViews()     // Catch: java.lang.Throwable -> L1f
            cn.vlion.ad.inland.base.j0.a(r4)     // Catch: java.lang.Throwable -> L1f
            android.widget.FrameLayout r0 = r3.f2931q     // Catch: java.lang.Throwable -> L1f
            r0.addView(r4)     // Catch: java.lang.Throwable -> L1f
            goto L9d
        L96:
            cn.vlion.ad.inland.base.util.init.VlionSDkManager r0 = cn.vlion.ad.inland.base.util.init.VlionSDkManager.getInstance()
            r0.upLoadCatchException(r4)
        L9d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.vlion.ad.inland.base.i2.settingLayoutStyle(java.lang.String):void");
    }

    public static void a(i2 i2Var, VlionADClickType vlionADClickType) {
        i2Var.getClass();
        try {
            VlionCustomAdActiveType$VlionCustomTarget a10 = i2Var.C.a(i2Var.f2935u, i2Var.B, i2Var.A, new g2(i2Var));
            if (a10 != null && vlionADClickType != null) {
                vlionADClickType.setTarget(a10.toString());
            }
            if (vlionADClickType != null) {
                q0 q0Var = i2Var.C;
                Context context = i2Var.f2935u;
                VlionCustomParseAdData vlionCustomParseAdData = i2Var.A;
                q0Var.getClass();
                vlionADClickType.setIsCanOpenDp(q0.a(context, vlionCustomParseAdData));
            }
            n2 n2Var = i2Var.f2939y;
            if (n2Var != null) {
                ((k2.a.C0026a) n2Var).a(vlionADClickType);
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.v0
    public final void a(boolean z10) {
        try {
            super.a(z10);
            LogVlion.e("VlionCustomDrawAdLayout isResume=" + z10 + " isRectVisible=" + b());
            if (z10 && b()) {
                try {
                    View view = this.D;
                    if (view instanceof a7) {
                        a7 a7Var = (a7) view;
                        a7Var.setExposurePlay(true);
                        try {
                            LogVlion.e("VlionVideoViewBaseGroup  startVideo");
                            e1 e1Var = a7Var.f2623f;
                            if (e1Var != null) {
                                e1Var.f();
                            }
                        } catch (Throwable th2) {
                            VlionSDkManager.getInstance().upLoadCatchException(th2);
                        }
                    }
                } catch (Throwable th3) {
                    VlionSDkManager.getInstance().upLoadCatchException(th3);
                }
                try {
                    if (this.f2940z) {
                        VlionSensorManagerHelper.getInstance().registerShakeListener(VlionSDkManager.getInstance().getApplication(), this.f2929o);
                        LogVlion.e("端策略 :  ---注册摇一摇监听---= ");
                        return;
                    }
                    return;
                } catch (Throwable th4) {
                    VlionSDkManager.getInstance().upLoadCatchException(th4);
                    return;
                }
            }
            try {
                View view2 = this.D;
                if (view2 instanceof a7) {
                    a7 a7Var2 = (a7) view2;
                    a7Var2.setExposurePlay(false);
                    try {
                        LogVlion.e("VlionVideoViewBaseGroup  stopVideo ");
                        e1 e1Var2 = a7Var2.f2623f;
                        if (e1Var2 != null) {
                            e1Var2.h();
                        }
                    } catch (Throwable th5) {
                        VlionSDkManager.getInstance().upLoadCatchException(th5);
                    }
                }
            } catch (Throwable th6) {
                VlionSDkManager.getInstance().upLoadCatchException(th6);
            }
            c();
            return;
        } catch (Throwable th7) {
            VlionSDkManager.getInstance().upLoadCatchException(th7);
        }
        VlionSDkManager.getInstance().upLoadCatchException(th7);
    }
}
