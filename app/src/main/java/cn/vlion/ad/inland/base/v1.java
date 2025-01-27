package cn.vlion.ad.inland.base;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
import cn.vlion.ad.inland.ad.view.video.VolumeControlView;
import cn.vlion.ad.inland.base.bid.VlionBiddingActionListener;
import cn.vlion.ad.inland.base.i0;
import cn.vlion.ad.inland.base.javabean.VlionADClickType;
import cn.vlion.ad.inland.base.javabean.VlionAdapterADConfig;
import cn.vlion.ad.inland.base.javabean.VlionServiceConfigParse;
import cn.vlion.ad.inland.base.network.ok.HttpRequestUtil;
import cn.vlion.ad.inland.base.p1;
import cn.vlion.ad.inland.base.util.event.VlionADEventManager;
import cn.vlion.ad.inland.base.util.handle.VlionClickParameterReplace;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import cn.vlion.ad.inland.base.util.log.LogVlion;

/* loaded from: classes.dex */
public final class v1 extends v0 implements cn.vlion.ad.inland.base.d {
    public VlionSensorBean A;
    public i0 B;
    public boolean C;
    public float D;
    public boolean E;
    public View F;

    /* renamed from: h */
    public VlionCustomParseAdData f3429h;

    /* renamed from: i */
    public VlionAdapterADConfig f3430i;

    /* renamed from: j */
    public q0 f3431j;

    /* renamed from: k */
    public r1 f3432k;

    /* renamed from: l */
    public DownloadApkData f3433l;

    /* renamed from: m */
    public boolean f3434m;

    /* renamed from: n */
    public boolean f3435n;

    /* renamed from: o */
    public LinearLayout f3436o;

    /* renamed from: p */
    public TextView f3437p;

    /* renamed from: q */
    public ImageView f3438q;

    /* renamed from: r */
    public TextView f3439r;

    /* renamed from: s */
    public VlionDownloadProgressBar f3440s;

    /* renamed from: t */
    public ImageView f3441t;

    /* renamed from: u */
    public LinearLayout f3442u;

    /* renamed from: v */
    public VolumeControlView f3443v;

    /* renamed from: w */
    public int f3444w;

    /* renamed from: x */
    public Activity f3445x;

    /* renamed from: y */
    public boolean f3446y;

    /* renamed from: z */
    public boolean f3447z;

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            q0 q0Var;
            VlionBiddingActionListener vlionBiddingActionListener;
            try {
                r1 r1Var = v1.this.f3432k;
                if (r1Var != null && (vlionBiddingActionListener = p1.this.f3273b.f3308f) != null) {
                    vlionBiddingActionListener.onAdClose();
                }
                v1 v1Var = v1.this;
                if (!v1Var.f3434m || (q0Var = v1Var.f3431j) == null) {
                    return;
                }
                q0Var.a(v1Var.f3445x.getApplicationContext());
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }
    }

    public class b implements View.OnClickListener {

        /* renamed from: a */
        public final /* synthetic */ i0 f3449a;

        public b(i0 i0Var) {
            this.f3449a = i0Var;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            try {
                v1 v1Var = v1.this;
                if (v1Var.f3434m && v1Var.f3440s.getTextDetail().equals(v1.this.getResources().getString(R.string.vlion_custom_ad_click_downloading))) {
                    v1 v1Var2 = v1.this;
                    v1Var2.f3431j.a(v1Var2.f3445x.getApplicationContext());
                    LogVlion.e("VlionCustomBannerLayout 暂停下载-- " + v1.this.f3433l.getDownloadId());
                } else {
                    VlionADClickType vlionADClickType = new VlionADClickType("button", b0.a(this.f3449a), "click", "main", "");
                    VlionClickParameterReplace vlionClickParameterReplace = new VlionClickParameterReplace(v1.this.f3429h);
                    vlionClickParameterReplace.handleBaseParameter(v1.this);
                    vlionClickParameterReplace.handleClickParameter(this.f3449a, vlionADClickType);
                    vlionADClickType.setVlionBaseParameterReplace(vlionClickParameterReplace);
                    v1.a(v1.this, vlionADClickType);
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }
    }

    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            try {
                LogVlion.e("VlionCustomBannerLayout Click ------------： ");
                VlionADClickType vlionADClickType = new VlionADClickType("click", b0.a(v1.this.B), "main", "hotsplot", "");
                VlionClickParameterReplace vlionClickParameterReplace = new VlionClickParameterReplace(v1.this.f3429h);
                vlionClickParameterReplace.handleBaseParameter(v1.this);
                vlionClickParameterReplace.handleClickParameter(v1.this.B, vlionADClickType);
                vlionADClickType.setVlionBaseParameterReplace(vlionClickParameterReplace);
                v1.b(v1.this, vlionADClickType);
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }
    }

    public class d implements i0.b {
        public d() {
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x00c8 A[Catch: all -> 0x009e, TryCatch #0 {all -> 0x009e, blocks: (B:2:0x0000, B:4:0x0006, B:9:0x00a3, B:11:0x00c8, B:12:0x00ec, B:28:0x0096, B:17:0x0056, B:19:0x005a, B:22:0x0063, B:25:0x0091), top: B:1:0x0000, inners: #1 }] */
        @Override // cn.vlion.ad.inland.base.i0.b
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void a(java.lang.String r9, cn.vlion.ad.inland.ad.javabean.VlionCustomAdData.SeatbidBean.BidBean.McBean.CsBean r10) {
            /*
                r8 = this;
                cn.vlion.ad.inland.base.v1 r0 = cn.vlion.ad.inland.base.v1.this     // Catch: java.lang.Throwable -> L9e
                cn.vlion.ad.inland.base.javabean.VlionAdapterADConfig r0 = r0.f3430i     // Catch: java.lang.Throwable -> L9e
                if (r0 == 0) goto Lf9
                java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L9e
                r0.<init>()     // Catch: java.lang.Throwable -> L9e
                java.lang.String r1 = "端策略 : VlionCustomBannerLayout onSwipeClick ---------： "
                r0.append(r1)     // Catch: java.lang.Throwable -> L9e
                cn.vlion.ad.inland.base.v1 r1 = cn.vlion.ad.inland.base.v1.this     // Catch: java.lang.Throwable -> L9e
                cn.vlion.ad.inland.base.javabean.VlionAdapterADConfig r1 = r1.f3430i     // Catch: java.lang.Throwable -> L9e
                java.lang.String r1 = r1.getAdxTagId()     // Catch: java.lang.Throwable -> L9e
                r0.append(r1)     // Catch: java.lang.Throwable -> L9e
                java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L9e
                cn.vlion.ad.inland.base.util.log.LogVlion.e(r0)     // Catch: java.lang.Throwable -> L9e
                java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L9e
                r0.<init>()     // Catch: java.lang.Throwable -> L9e
                java.lang.String r1 = "端策略 : VlionCustomBannerLayout getStrategyBean ---------： "
                r0.append(r1)     // Catch: java.lang.Throwable -> L9e
                cn.vlion.ad.inland.base.util.VlionAdStrategyUtils r1 = cn.vlion.ad.inland.base.util.VlionAdStrategyUtils.getInstance()     // Catch: java.lang.Throwable -> L9e
                cn.vlion.ad.inland.base.v1 r2 = cn.vlion.ad.inland.base.v1.this     // Catch: java.lang.Throwable -> L9e
                cn.vlion.ad.inland.base.javabean.VlionAdapterADConfig r2 = r2.f3430i     // Catch: java.lang.Throwable -> L9e
                java.lang.String r2 = r2.getAdxTagId()     // Catch: java.lang.Throwable -> L9e
                cn.vlion.ad.inland.base.javabean.VlionAdClickStrategyBean r1 = r1.getStrategyBean(r2)     // Catch: java.lang.Throwable -> L9e
                java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L9e
                r0.append(r1)     // Catch: java.lang.Throwable -> L9e
                java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L9e
                cn.vlion.ad.inland.base.util.log.LogVlion.e(r0)     // Catch: java.lang.Throwable -> L9e
                cn.vlion.ad.inland.base.javabean.VlionADClickType r0 = new cn.vlion.ad.inland.base.javabean.VlionADClickType     // Catch: java.lang.Throwable -> L9e
                cn.vlion.ad.inland.base.v1 r1 = cn.vlion.ad.inland.base.v1.this     // Catch: java.lang.Throwable -> L9e
                cn.vlion.ad.inland.base.i0 r1 = r1.B     // Catch: java.lang.Throwable -> L9e
                java.lang.String r7 = ","
                if (r1 == 0) goto La0
                java.lang.String r2 = r1.f2908u     // Catch: java.lang.Throwable -> L8f
                if (r2 == 0) goto L91
                java.lang.String r3 = "click"
                boolean r2 = r2.equals(r3)     // Catch: java.lang.Throwable -> L8f
                if (r2 == 0) goto L63
                goto L91
            L63:
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L8f
                r2.<init>()     // Catch: java.lang.Throwable -> L8f
                float r3 = r1.f2892e     // Catch: java.lang.Throwable -> L8f
                r2.append(r3)     // Catch: java.lang.Throwable -> L8f
                r2.append(r7)     // Catch: java.lang.Throwable -> L8f
                float r1 = r1.f2893f     // Catch: java.lang.Throwable -> L8f
                r2.append(r1)     // Catch: java.lang.Throwable -> L8f
                java.lang.String r1 = r2.toString()     // Catch: java.lang.Throwable -> L8f
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L8f
                r2.<init>()     // Catch: java.lang.Throwable -> L8f
                java.lang.String r3 = "ViewOnTouchDataUtils getDistanceXY="
                r2.append(r3)     // Catch: java.lang.Throwable -> L8f
                r2.append(r1)     // Catch: java.lang.Throwable -> L8f
                java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L8f
                cn.vlion.ad.inland.base.util.log.LogVlion.e(r2)     // Catch: java.lang.Throwable -> L8f
            L8d:
                r3 = r1
                goto La3
            L8f:
                r1 = move-exception
                goto L96
            L91:
                java.lang.String r1 = r1.b()     // Catch: java.lang.Throwable -> L8f
                goto L8d
            L96:
                cn.vlion.ad.inland.base.util.init.VlionSDkManager r2 = cn.vlion.ad.inland.base.util.init.VlionSDkManager.getInstance()     // Catch: java.lang.Throwable -> L9e
                r2.upLoadCatchException(r1)     // Catch: java.lang.Throwable -> L9e
                goto La0
            L9e:
                r9 = move-exception
                goto Lf2
            La0:
                java.lang.String r1 = ""
                goto L8d
            La3:
                java.lang.String r4 = "main"
                java.lang.String r5 = "hotsplot"
                java.lang.String r6 = ""
                r1 = r0
                r2 = r9
                r1.<init>(r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L9e
                cn.vlion.ad.inland.base.util.handle.VlionSwipeParameterReplace r9 = new cn.vlion.ad.inland.base.util.handle.VlionSwipeParameterReplace     // Catch: java.lang.Throwable -> L9e
                cn.vlion.ad.inland.base.v1 r1 = cn.vlion.ad.inland.base.v1.this     // Catch: java.lang.Throwable -> L9e
                cn.vlion.ad.inland.ad.javabean.VlionCustomParseAdData r1 = r1.f3429h     // Catch: java.lang.Throwable -> L9e
                r9.<init>(r1)     // Catch: java.lang.Throwable -> L9e
                cn.vlion.ad.inland.base.v1 r1 = cn.vlion.ad.inland.base.v1.this     // Catch: java.lang.Throwable -> L9e
                r9.handleBaseParameter(r1)     // Catch: java.lang.Throwable -> L9e
                cn.vlion.ad.inland.base.v1 r1 = cn.vlion.ad.inland.base.v1.this     // Catch: java.lang.Throwable -> L9e
                cn.vlion.ad.inland.base.i0 r1 = r1.B     // Catch: java.lang.Throwable -> L9e
                r9.handleSwipeParameter(r1, r0)     // Catch: java.lang.Throwable -> L9e
                r0.setVlionBaseParameterReplace(r9)     // Catch: java.lang.Throwable -> L9e
                if (r10 == 0) goto Lec
                boolean r9 = r10.isD()     // Catch: java.lang.Throwable -> L9e
                r0.setDefaultAdStrategy(r9)     // Catch: java.lang.Throwable -> L9e
                java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L9e
                r9.<init>()     // Catch: java.lang.Throwable -> L9e
                java.lang.String r1 = r0.getTriggerParam()     // Catch: java.lang.Throwable -> L9e
                r9.append(r1)     // Catch: java.lang.Throwable -> L9e
                r9.append(r7)     // Catch: java.lang.Throwable -> L9e
                java.lang.String r10 = r10.getTriggerParam()     // Catch: java.lang.Throwable -> L9e
                r9.append(r10)     // Catch: java.lang.Throwable -> L9e
                java.lang.String r9 = r9.toString()     // Catch: java.lang.Throwable -> L9e
                r0.setTriggerParam(r9)     // Catch: java.lang.Throwable -> L9e
            Lec:
                cn.vlion.ad.inland.base.v1 r9 = cn.vlion.ad.inland.base.v1.this     // Catch: java.lang.Throwable -> L9e
                cn.vlion.ad.inland.base.v1.a(r9, r0)     // Catch: java.lang.Throwable -> L9e
                goto Lf9
            Lf2:
                cn.vlion.ad.inland.base.util.init.VlionSDkManager r10 = cn.vlion.ad.inland.base.util.init.VlionSDkManager.getInstance()
                r10.upLoadCatchException(r9)
            Lf9:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: cn.vlion.ad.inland.base.v1.d.a(java.lang.String, cn.vlion.ad.inland.ad.javabean.VlionCustomAdData$SeatbidBean$BidBean$McBean$CsBean):void");
        }
    }

    public v1(Activity activity) {
        super(activity);
        this.f3434m = false;
        this.f3435n = false;
        this.f3446y = false;
        this.f3447z = false;
        this.C = false;
        this.D = 0.5625f;
        this.E = false;
        this.f3445x = activity;
    }

    public static void b(v1 v1Var, VlionADClickType vlionADClickType) {
        v1Var.getClass();
        try {
            LogVlion.e("VlionCustomBannerLayout adAreaClickAction isOpenHot" + VlionServiceConfigParse.getInstance().isHotspot());
            v1Var.f3431j.a(v1Var.getContext(), v1Var.f3429h.getDp(), v1Var.f3434m, new w1(v1Var, vlionADClickType));
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x00a0 A[Catch: all -> 0x004f, TryCatch #2 {all -> 0x004f, blocks: (B:2:0x0000, B:9:0x000e, B:11:0x0018, B:13:0x0045, B:16:0x0052, B:20:0x007b, B:22:0x00a0, B:25:0x00b0, B:31:0x00c9, B:34:0x00ec, B:35:0x00ff, B:38:0x0110, B:40:0x0116, B:42:0x0122, B:44:0x0126, B:46:0x0137, B:48:0x0129, B:50:0x0135, B:54:0x013a, B:56:0x013e, B:58:0x0145, B:59:0x0147, B:61:0x0150, B:62:0x0152, B:63:0x0154, B:64:0x0157, B:66:0x018b, B:71:0x0160, B:72:0x0169, B:73:0x0172, B:74:0x017a, B:75:0x0183, B:81:0x00c2, B:83:0x00f8, B:85:0x0072, B:27:0x00b3, B:29:0x00b7, B:30:0x00be, B:78:0x00bc), top: B:1:0x0000, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x013e A[Catch: all -> 0x004f, TryCatch #2 {all -> 0x004f, blocks: (B:2:0x0000, B:9:0x000e, B:11:0x0018, B:13:0x0045, B:16:0x0052, B:20:0x007b, B:22:0x00a0, B:25:0x00b0, B:31:0x00c9, B:34:0x00ec, B:35:0x00ff, B:38:0x0110, B:40:0x0116, B:42:0x0122, B:44:0x0126, B:46:0x0137, B:48:0x0129, B:50:0x0135, B:54:0x013a, B:56:0x013e, B:58:0x0145, B:59:0x0147, B:61:0x0150, B:62:0x0152, B:63:0x0154, B:64:0x0157, B:66:0x018b, B:71:0x0160, B:72:0x0169, B:73:0x0172, B:74:0x017a, B:75:0x0183, B:81:0x00c2, B:83:0x00f8, B:85:0x0072, B:27:0x00b3, B:29:0x00b7, B:30:0x00be, B:78:0x00bc), top: B:1:0x0000, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0157 A[Catch: all -> 0x004f, TryCatch #2 {all -> 0x004f, blocks: (B:2:0x0000, B:9:0x000e, B:11:0x0018, B:13:0x0045, B:16:0x0052, B:20:0x007b, B:22:0x00a0, B:25:0x00b0, B:31:0x00c9, B:34:0x00ec, B:35:0x00ff, B:38:0x0110, B:40:0x0116, B:42:0x0122, B:44:0x0126, B:46:0x0137, B:48:0x0129, B:50:0x0135, B:54:0x013a, B:56:0x013e, B:58:0x0145, B:59:0x0147, B:61:0x0150, B:62:0x0152, B:63:0x0154, B:64:0x0157, B:66:0x018b, B:71:0x0160, B:72:0x0169, B:73:0x0172, B:74:0x017a, B:75:0x0183, B:81:0x00c2, B:83:0x00f8, B:85:0x0072, B:27:0x00b3, B:29:0x00b7, B:30:0x00be, B:78:0x00bc), top: B:1:0x0000, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0160 A[Catch: all -> 0x004f, TryCatch #2 {all -> 0x004f, blocks: (B:2:0x0000, B:9:0x000e, B:11:0x0018, B:13:0x0045, B:16:0x0052, B:20:0x007b, B:22:0x00a0, B:25:0x00b0, B:31:0x00c9, B:34:0x00ec, B:35:0x00ff, B:38:0x0110, B:40:0x0116, B:42:0x0122, B:44:0x0126, B:46:0x0137, B:48:0x0129, B:50:0x0135, B:54:0x013a, B:56:0x013e, B:58:0x0145, B:59:0x0147, B:61:0x0150, B:62:0x0152, B:63:0x0154, B:64:0x0157, B:66:0x018b, B:71:0x0160, B:72:0x0169, B:73:0x0172, B:74:0x017a, B:75:0x0183, B:81:0x00c2, B:83:0x00f8, B:85:0x0072, B:27:0x00b3, B:29:0x00b7, B:30:0x00be, B:78:0x00bc), top: B:1:0x0000, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0169 A[Catch: all -> 0x004f, TryCatch #2 {all -> 0x004f, blocks: (B:2:0x0000, B:9:0x000e, B:11:0x0018, B:13:0x0045, B:16:0x0052, B:20:0x007b, B:22:0x00a0, B:25:0x00b0, B:31:0x00c9, B:34:0x00ec, B:35:0x00ff, B:38:0x0110, B:40:0x0116, B:42:0x0122, B:44:0x0126, B:46:0x0137, B:48:0x0129, B:50:0x0135, B:54:0x013a, B:56:0x013e, B:58:0x0145, B:59:0x0147, B:61:0x0150, B:62:0x0152, B:63:0x0154, B:64:0x0157, B:66:0x018b, B:71:0x0160, B:72:0x0169, B:73:0x0172, B:74:0x017a, B:75:0x0183, B:81:0x00c2, B:83:0x00f8, B:85:0x0072, B:27:0x00b3, B:29:0x00b7, B:30:0x00be, B:78:0x00bc), top: B:1:0x0000, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0172 A[Catch: all -> 0x004f, TryCatch #2 {all -> 0x004f, blocks: (B:2:0x0000, B:9:0x000e, B:11:0x0018, B:13:0x0045, B:16:0x0052, B:20:0x007b, B:22:0x00a0, B:25:0x00b0, B:31:0x00c9, B:34:0x00ec, B:35:0x00ff, B:38:0x0110, B:40:0x0116, B:42:0x0122, B:44:0x0126, B:46:0x0137, B:48:0x0129, B:50:0x0135, B:54:0x013a, B:56:0x013e, B:58:0x0145, B:59:0x0147, B:61:0x0150, B:62:0x0152, B:63:0x0154, B:64:0x0157, B:66:0x018b, B:71:0x0160, B:72:0x0169, B:73:0x0172, B:74:0x017a, B:75:0x0183, B:81:0x00c2, B:83:0x00f8, B:85:0x0072, B:27:0x00b3, B:29:0x00b7, B:30:0x00be, B:78:0x00bc), top: B:1:0x0000, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x017a A[Catch: all -> 0x004f, TryCatch #2 {all -> 0x004f, blocks: (B:2:0x0000, B:9:0x000e, B:11:0x0018, B:13:0x0045, B:16:0x0052, B:20:0x007b, B:22:0x00a0, B:25:0x00b0, B:31:0x00c9, B:34:0x00ec, B:35:0x00ff, B:38:0x0110, B:40:0x0116, B:42:0x0122, B:44:0x0126, B:46:0x0137, B:48:0x0129, B:50:0x0135, B:54:0x013a, B:56:0x013e, B:58:0x0145, B:59:0x0147, B:61:0x0150, B:62:0x0152, B:63:0x0154, B:64:0x0157, B:66:0x018b, B:71:0x0160, B:72:0x0169, B:73:0x0172, B:74:0x017a, B:75:0x0183, B:81:0x00c2, B:83:0x00f8, B:85:0x0072, B:27:0x00b3, B:29:0x00b7, B:30:0x00be, B:78:0x00bc), top: B:1:0x0000, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0183 A[Catch: all -> 0x004f, TRY_LEAVE, TryCatch #2 {all -> 0x004f, blocks: (B:2:0x0000, B:9:0x000e, B:11:0x0018, B:13:0x0045, B:16:0x0052, B:20:0x007b, B:22:0x00a0, B:25:0x00b0, B:31:0x00c9, B:34:0x00ec, B:35:0x00ff, B:38:0x0110, B:40:0x0116, B:42:0x0122, B:44:0x0126, B:46:0x0137, B:48:0x0129, B:50:0x0135, B:54:0x013a, B:56:0x013e, B:58:0x0145, B:59:0x0147, B:61:0x0150, B:62:0x0152, B:63:0x0154, B:64:0x0157, B:66:0x018b, B:71:0x0160, B:72:0x0169, B:73:0x0172, B:74:0x017a, B:75:0x0183, B:81:0x00c2, B:83:0x00f8, B:85:0x0072, B:27:0x00b3, B:29:0x00b7, B:30:0x00be, B:78:0x00bc), top: B:1:0x0000, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00f8 A[Catch: all -> 0x004f, TryCatch #2 {all -> 0x004f, blocks: (B:2:0x0000, B:9:0x000e, B:11:0x0018, B:13:0x0045, B:16:0x0052, B:20:0x007b, B:22:0x00a0, B:25:0x00b0, B:31:0x00c9, B:34:0x00ec, B:35:0x00ff, B:38:0x0110, B:40:0x0116, B:42:0x0122, B:44:0x0126, B:46:0x0137, B:48:0x0129, B:50:0x0135, B:54:0x013a, B:56:0x013e, B:58:0x0145, B:59:0x0147, B:61:0x0150, B:62:0x0152, B:63:0x0154, B:64:0x0157, B:66:0x018b, B:71:0x0160, B:72:0x0169, B:73:0x0172, B:74:0x017a, B:75:0x0183, B:81:0x00c2, B:83:0x00f8, B:85:0x0072, B:27:0x00b3, B:29:0x00b7, B:30:0x00be, B:78:0x00bc), top: B:1:0x0000, inners: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(android.view.View r6, cn.vlion.ad.inland.base.javabean.VlionAdapterADConfig r7, cn.vlion.ad.inland.ad.javabean.VlionCustomParseAdData r8, cn.vlion.ad.inland.base.p1.a r9) {
        /*
            Method dump skipped, instructions count: 424
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.vlion.ad.inland.base.v1.a(android.view.View, cn.vlion.ad.inland.base.javabean.VlionAdapterADConfig, cn.vlion.ad.inland.ad.javabean.VlionCustomParseAdData, cn.vlion.ad.inland.base.p1$a):void");
    }

    public final void c() {
        VlionCustomParseAdData vlionCustomParseAdData;
        try {
            if (this.f3436o != null && (vlionCustomParseAdData = this.f3429h) != null) {
                this.f3434m = vlionCustomParseAdData.isIs_download();
                this.f3434m = this.f3429h.isIs_download();
                this.f3431j = new q0();
                this.f3435n = q.a(getContext(), this.f3429h.getDp());
                if (this.f3434m) {
                    DownloadApkData downloadApkData = new DownloadApkData(this.f3429h, this.f3430i);
                    this.f3433l = downloadApkData;
                    this.f3431j.f3297a = downloadApkData;
                }
                e();
                if (!TextUtils.isEmpty(this.f3429h.getTitle())) {
                    this.f3437p.setText(this.f3429h.getTitle());
                }
                try {
                    HttpRequestUtil.downloadBitmap(this.f3438q, this.f3429h.getBrand_logo(), new s1());
                } catch (Throwable th2) {
                    VlionSDkManager.getInstance().upLoadCatchException(th2);
                }
                if (!TextUtils.isEmpty(this.f3429h.getBrand_name())) {
                    this.f3439r.setText(this.f3429h.getBrand_name());
                }
                this.f3441t.setOnClickListener(new a());
                this.f3440s.setOnClickListener(new b(new i0(this.f3440s)));
                this.B = new i0(this);
                setOnClickListener(new c());
                if (this.f3446y) {
                    i0 i0Var = this.B;
                    try {
                        VlionCustomParseAdData vlionCustomParseAdData2 = this.f3429h;
                        if (vlionCustomParseAdData2 != null) {
                            VlionCustomAdData.SeatbidBean.BidBean.McBean.CsBean csBean = vlionCustomParseAdData2.getCsBean(2, -1);
                            if (csBean == null) {
                                csBean = this.f3429h.getDefaultShakeCsBean();
                            }
                            this.A = new VlionSensorBean(csBean.getAcc(), csBean.getAng(), csBean.getDui(), new y1(this, i0Var, csBean));
                        }
                    } catch (Throwable th3) {
                        VlionSDkManager.getInstance().upLoadCatchException(th3);
                    }
                }
                if (this.f3447z) {
                    this.B.a(this, this.f3429h.getCsBean(5, -1), new d());
                }
            }
        } catch (Throwable th4) {
            VlionSDkManager.getInstance().upLoadCatchException(th4);
        }
    }

    public final void d() {
        try {
            if (this.f3446y) {
                VlionSensorManagerHelper.getInstance().unregisterShakeListener(this.A);
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.v0, cn.vlion.ad.inland.base.d
    public final void destroy() {
        super.destroy();
        try {
            View view = this.F;
            if (view != null) {
                if (view instanceof h5) {
                    LogVlion.e(" 222 destroy--=");
                    ((h5) this.F).destroy();
                } else if (view instanceof a7) {
                    LogVlion.e(" 1111 destroy--=");
                    ((a7) this.F).destroy();
                }
            }
            i0 i0Var = this.B;
            if (i0Var != null) {
                i0Var.a();
                this.B = null;
            }
            if (this.A != null) {
                VlionSensorManagerHelper.getInstance().unregisterShakeListener(this.A);
            }
            removeAllViews();
            q0 q0Var = this.f3431j;
            if (q0Var != null) {
                q0Var.a();
                this.f3431j = null;
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public final void e() {
        VlionDownloadProgressBar vlionDownloadProgressBar;
        Resources resources;
        int i10;
        VlionDownloadProgressBar vlionDownloadProgressBar2;
        Resources resources2;
        int i11;
        try {
            if (!this.f3434m) {
                if (q.a(getContext(), this.f3429h.getDp())) {
                    if (this.f3446y) {
                        vlionDownloadProgressBar2 = this.f3440s;
                        resources2 = getResources();
                        i11 = R.string.vlion_custom_ad_download_now_shake_open;
                        vlionDownloadProgressBar2.setShakeStyle(resources2.getString(i11), true);
                        return;
                    }
                    vlionDownloadProgressBar = this.f3440s;
                    resources = getResources();
                    i10 = R.string.vlion_custom_ad_deeplink_open;
                    vlionDownloadProgressBar.setShakeStyle(resources.getString(i10), false);
                }
                if (this.f3446y) {
                    vlionDownloadProgressBar2 = this.f3440s;
                    resources2 = getResources();
                    i11 = R.string.vlion_custom_ad_click_now_shake_look;
                    vlionDownloadProgressBar2.setShakeStyle(resources2.getString(i11), true);
                    return;
                }
                vlionDownloadProgressBar = this.f3440s;
                resources = getResources();
                i10 = R.string.vlion_custom_ad_look_detail;
                vlionDownloadProgressBar.setShakeStyle(resources.getString(i10), false);
            }
            if (this.f3429h.getAppInfoBean() == null) {
                return;
            }
            if (this.f3435n) {
                if (this.f3446y) {
                    vlionDownloadProgressBar2 = this.f3440s;
                    resources2 = getResources();
                    i11 = R.string.vlion_custom_ad_download_now_shake_open;
                    vlionDownloadProgressBar2.setShakeStyle(resources2.getString(i11), true);
                    return;
                }
                vlionDownloadProgressBar = this.f3440s;
                resources = getResources();
                i10 = R.string.vlion_custom_ad_deeplink_open;
                vlionDownloadProgressBar.setShakeStyle(resources.getString(i10), false);
            }
            if (this.f3446y) {
                vlionDownloadProgressBar2 = this.f3440s;
                resources2 = getResources();
                i11 = R.string.vlion_custom_ad_download_now_shake;
                vlionDownloadProgressBar2.setShakeStyle(resources2.getString(i11), true);
                return;
            }
            vlionDownloadProgressBar = this.f3440s;
            resources = getResources();
            i10 = R.string.vlion_custom_ad_download_now;
            vlionDownloadProgressBar.setShakeStyle(resources.getString(i10), false);
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        LogVlion.e("VlionCustomBannerLayout onAttachedToWindow: ");
        VlionADEventManager.getParameterShow(this.f3430i, "VlionCustomBannerLayout");
    }

    @Override // cn.vlion.ad.inland.base.v0, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        try {
            if (this.E) {
                return;
            }
            LogVlion.e("VlionCustomBannerLayout onLayout--: ");
            int i14 = this.f3444w;
            if (i14 == 1 || i14 == 2 || i14 == 3 || i14 == 7) {
                a(this.f3436o);
            }
            this.E = true;
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public void settingLayoutStyle(int i10) {
        LayoutInflater from;
        int i11;
        try {
            if (getContext() == null) {
                return;
            }
            switch (i10) {
                case -1:
                    LayoutInflater.from(getContext()).inflate(R.layout.vlion_cn_ad_banner_layout1_3, (ViewGroup) this, true);
                    from = LayoutInflater.from(getContext());
                    i11 = R.layout.vlion_cn_ad_banner_layout1_3;
                    break;
                case 0:
                default:
                    from = LayoutInflater.from(getContext());
                    i11 = R.layout.vlion_cn_ad_banner_layout1_3;
                    break;
                case 1:
                case 2:
                case 3:
                    from = LayoutInflater.from(getContext());
                    i11 = R.layout.vlion_cn_ad_banner_layout1_3;
                    break;
                case 4:
                    from = LayoutInflater.from(getContext());
                    i11 = R.layout.vlion_cn_ad_banner_layout4;
                    break;
                case 5:
                    from = LayoutInflater.from(getContext());
                    i11 = R.layout.vlion_cn_ad_banner_layout5;
                    break;
                case 6:
                    from = LayoutInflater.from(getContext());
                    i11 = R.layout.vlion_cn_ad_banner_layout6;
                    break;
                case 7:
                    from = LayoutInflater.from(getContext());
                    i11 = R.layout.vlion_cn_ad_banner_layout7;
                    break;
            }
            from.inflate(i11, (ViewGroup) this, true);
            this.f3436o = (LinearLayout) findViewById(R.id.vlion_adContainer);
            this.f3437p = (TextView) findViewById(R.id.vlion_tv_title_info);
            this.f3438q = (ImageView) findViewById(R.id.vlion_img_showappicon);
            this.f3439r = (TextView) findViewById(R.id.vlion_tv_appName);
            this.f3440s = (VlionDownloadProgressBar) findViewById(R.id.vlion_tv_action);
            this.f3441t = (ImageView) findViewById(R.id.vlion_img_close);
            this.f3442u = (LinearLayout) findViewById(R.id.ll_video_sound_layout);
            this.f3443v = (VolumeControlView) findViewById(R.id.soundView);
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public final void a(LinearLayout linearLayout) {
        if (linearLayout != null) {
            try {
                ViewGroup.LayoutParams layoutParams = linearLayout.getLayoutParams();
                float width = linearLayout.getWidth();
                float f10 = this.D;
                int i10 = (int) (width * f10);
                View view = this.F;
                if (view != null && (view instanceof h5)) {
                    h5 h5Var = (h5) view;
                    float f11 = h5Var.f2856i / h5Var.f2855h;
                    if (f10 > f11) {
                        i10 = (int) (linearLayout.getWidth() * f11);
                    }
                }
                layoutParams.width = linearLayout.getWidth();
                layoutParams.height = i10;
                linearLayout.setLayoutParams(layoutParams);
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }
    }

    public static void a(v1 v1Var, VlionADClickType vlionADClickType) {
        v1Var.getClass();
        try {
            VlionCustomAdActiveType$VlionCustomTarget a10 = v1Var.f3431j.a(v1Var.getContext(), v1Var.f3430i, v1Var.f3429h, new x1(v1Var));
            if (a10 != null && vlionADClickType != null) {
                vlionADClickType.setTarget(a10.toString());
            }
            if (vlionADClickType != null) {
                q0 q0Var = v1Var.f3431j;
                Context context = v1Var.getContext();
                VlionCustomParseAdData vlionCustomParseAdData = v1Var.f3429h;
                q0Var.getClass();
                vlionADClickType.setIsCanOpenDp(q0.a(context, vlionCustomParseAdData));
            }
            r1 r1Var = v1Var.f3432k;
            if (r1Var != null) {
                ((p1.a) r1Var).a(vlionADClickType);
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.v0
    public final void a(boolean z10) {
        try {
            super.a(z10);
            LogVlion.e("VlionCustomBannerLayout isResume=" + z10 + " isRectVisible=" + b());
            if (z10 && b()) {
                try {
                    View view = this.F;
                    if (view != null && (view instanceof a7)) {
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
                    if (this.f3446y) {
                        VlionSensorManagerHelper.getInstance().registerShakeListener(VlionSDkManager.getInstance().getApplication(), this.A);
                        return;
                    }
                    return;
                } catch (Throwable th4) {
                    VlionSDkManager.getInstance().upLoadCatchException(th4);
                    return;
                }
            }
            d();
            try {
                View view2 = this.F;
                if (view2 == null || !(view2 instanceof a7)) {
                    return;
                }
                a7 a7Var2 = (a7) view2;
                a7Var2.setExposurePlay(false);
                try {
                    LogVlion.e("VlionVideoViewBaseGroup  stopVideo ");
                    e1 e1Var2 = a7Var2.f2623f;
                    if (e1Var2 != null) {
                        e1Var2.h();
                        return;
                    }
                    return;
                } catch (Throwable th5) {
                    VlionSDkManager.getInstance().upLoadCatchException(th5);
                    return;
                }
            } catch (Throwable th6) {
                VlionSDkManager.getInstance().upLoadCatchException(th6);
                return;
            }
        } catch (Throwable th7) {
            VlionSDkManager.getInstance().upLoadCatchException(th7);
        }
        VlionSDkManager.getInstance().upLoadCatchException(th7);
    }

    public final void a(LinearLayout linearLayout, View view, float f10) {
        try {
            this.D = f10;
            if (linearLayout != null && view != null) {
                try {
                    linearLayout.removeAllViews();
                    j0.a(view);
                    linearLayout.addView(view, new LinearLayout.LayoutParams(-1, -1));
                } catch (Throwable th2) {
                    VlionSDkManager.getInstance().upLoadCatchException(th2);
                }
            }
        } catch (Throwable th3) {
            VlionSDkManager.getInstance().upLoadCatchException(th3);
        }
    }
}
