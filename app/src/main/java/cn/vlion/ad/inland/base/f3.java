package cn.vlion.ad.inland.base;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import cn.vlion.ad.inland.ad.interstitial.VlionCustomInterstitialActivity;
import cn.vlion.ad.inland.ad.view.active.VlionAdClosedView;
import cn.vlion.ad.inland.ad.view.active.VlionDownloadProgressBar;
import cn.vlion.ad.inland.ad.view.video.VlionDownloadVideoLayout;
import cn.vlion.ad.inland.ad.view.video.VlionVideoEndCardView;
import cn.vlion.ad.inland.base.network.ImageCallback;
import cn.vlion.ad.inland.base.util.config.VlionAdBaseError;
import cn.vlion.ad.inland.base.util.data.VlionImageSuccessData;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;

/* loaded from: classes.dex */
public class f3 extends x3 {

    /* renamed from: b */
    public VlionDownloadVideoLayout f2783b;

    /* renamed from: c */
    public FrameLayout f2784c;

    /* renamed from: d */
    public VlionVideoEndCardView f2785d;

    /* renamed from: e */
    public VlionAdClosedView f2786e;

    /* renamed from: f */
    public FrameLayout f2787f;

    /* renamed from: g */
    public TextView f2788g;

    /* renamed from: h */
    public TextView f2789h;

    /* renamed from: i */
    public ImageView f2790i;

    /* renamed from: j */
    public TextView f2791j;

    /* renamed from: k */
    public VlionDownloadProgressBar f2792k;

    /* renamed from: l */
    public TextView f2793l;

    /* renamed from: m */
    public LinearLayout f2794m;

    /* renamed from: n */
    public a2 f2795n;

    /* renamed from: o */
    public w3 f2796o;

    /* renamed from: p */
    public a f2797p;

    public class a implements ImageCallback {
        @Override // cn.vlion.ad.inland.base.network.ImageCallback
        public final void onFail(VlionAdBaseError vlionAdBaseError) {
        }

        @Override // cn.vlion.ad.inland.base.network.ImageCallback
        public final void onSuccess(VlionImageSuccessData vlionImageSuccessData) {
        }
    }

    public f3(Context context, int i10) {
        super(context);
        this.f2797p = new a();
        try {
            e();
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.x3
    public final void a(int i10) {
        try {
            if (i10 <= 0) {
                FrameLayout frameLayout = this.f2787f;
                if (frameLayout != null) {
                    frameLayout.setVisibility(8);
                }
                VlionAdClosedView vlionAdClosedView = this.f2786e;
                if (vlionAdClosedView != null) {
                    vlionAdClosedView.setVisibility(0);
                    return;
                }
                return;
            }
            FrameLayout frameLayout2 = this.f2787f;
            if (frameLayout2 != null) {
                frameLayout2.setVisibility(0);
            }
            VlionAdClosedView vlionAdClosedView2 = this.f2786e;
            if (vlionAdClosedView2 != null) {
                vlionAdClosedView2.setVisibility(8);
            }
            TextView textView = this.f2788g;
            if (textView != null) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(String.valueOf(i10 + " "));
                sb2.append(getContext().getResources().getString(R.string.vlion_custom_ad_close_title));
                textView.setText(sb2.toString());
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.x3
    public final void b() {
        try {
            VlionDownloadVideoLayout vlionDownloadVideoLayout = this.f2783b;
            if (vlionDownloadVideoLayout != null) {
                vlionDownloadVideoLayout.c();
            }
            VlionDownloadProgressBar vlionDownloadProgressBar = this.f2792k;
            if (vlionDownloadProgressBar != null) {
                vlionDownloadProgressBar.hideAnimation();
                this.f2792k = null;
            }
            a2 a2Var = this.f2795n;
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
                this.f2795n = null;
            }
            if (this.f2797p != null) {
                this.f2797p = null;
            }
        } catch (Throwable th3) {
            VlionSDkManager.getInstance().upLoadCatchException(th3);
        }
    }

    @Override // cn.vlion.ad.inland.base.x3
    public final void c() {
    }

    @Override // cn.vlion.ad.inland.base.x3
    public final void d() {
    }

    public final void e() {
        try {
            LayoutInflater.from(getContext()).inflate(getLayout(), (ViewGroup) this, true);
            this.f2783b = (VlionDownloadVideoLayout) findViewById(R.id.vlion_download_videolayout);
            this.f2784c = (FrameLayout) findViewById(R.id.ll_vlion_ad_view);
            this.f2785d = (VlionVideoEndCardView) findViewById(R.id.vlionVideoEndcardView);
            this.f2786e = (VlionAdClosedView) findViewById(R.id.vlion_ad_closed);
            this.f2787f = (FrameLayout) findViewById(R.id.vilon_cn_timer_ll);
            this.f2788g = (TextView) findViewById(R.id.vilon_cn_timer_text);
            this.f2789h = (TextView) findViewById(R.id.vlion_tv_title_info);
            this.f2790i = (ImageView) findViewById(R.id.vlion_img_showappicon);
            this.f2791j = (TextView) findViewById(R.id.vlion_tv_appName);
            VlionDownloadProgressBar vlionDownloadProgressBar = (VlionDownloadProgressBar) findViewById(R.id.vlion_tv_action);
            this.f2792k = vlionDownloadProgressBar;
            vlionDownloadProgressBar.setTextSize(12.0f);
            this.f2794m = (LinearLayout) findViewById(R.id.vlion_ad_down_info);
            this.f2793l = (TextView) findViewById(R.id.vlion_draw_tips);
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.x3
    public ViewGroup getAdViewContainer() {
        return this.f2784c;
    }

    public int getLayout() {
        return R.layout.vlion_cn_ad_custom_style_video_download_full_base;
    }

    @Override // cn.vlion.ad.inland.base.x3
    public void setImageGravity(int i10) {
        try {
            VlionVideoEndCardView vlionVideoEndCardView = this.f2785d;
            if (vlionVideoEndCardView != null) {
                vlionVideoEndCardView.setImageGravity(i10);
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.x3
    public void setProgress(int i10) {
        try {
            VlionDownloadProgressBar vlionDownloadProgressBar = this.f2792k;
            if (vlionDownloadProgressBar != null) {
                vlionDownloadProgressBar.setProgress(i10);
            }
            VlionVideoEndCardView vlionVideoEndCardView = this.f2785d;
            if (vlionVideoEndCardView != null) {
                vlionVideoEndCardView.setProgress(i10);
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public class b implements VlionAdClosedView.d {
        public b() {
        }

        @Override // cn.vlion.ad.inland.ad.view.active.VlionAdClosedView.d
        public final void a() {
            int current;
            VlionCustomInterstitialActivity.e eVar;
            try {
                f3 f3Var = f3.this;
                VlionDownloadVideoLayout vlionDownloadVideoLayout = f3Var.f2783b;
                if (vlionDownloadVideoLayout != null) {
                    if (vlionDownloadVideoLayout.f2523m) {
                        w3 w3Var = f3Var.f2796o;
                        current = vlionDownloadVideoLayout.getCurrent();
                        eVar = (VlionCustomInterstitialActivity.e) w3Var;
                    } else {
                        w3 w3Var2 = f3Var.f2796o;
                        if (w3Var2 == null) {
                            return;
                        }
                        current = vlionDownloadVideoLayout.getCurrent();
                        eVar = (VlionCustomInterstitialActivity.e) w3Var2;
                    }
                    eVar.a(current, true);
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }

        @Override // cn.vlion.ad.inland.ad.view.active.VlionAdClosedView.d
        public final void a(boolean z10) {
            int current;
            VlionCustomInterstitialActivity.e eVar;
            try {
                f3 f3Var = f3.this;
                VlionDownloadVideoLayout vlionDownloadVideoLayout = f3Var.f2783b;
                if (vlionDownloadVideoLayout != null) {
                    if (vlionDownloadVideoLayout.f2523m) {
                        w3 w3Var = f3Var.f2796o;
                        current = vlionDownloadVideoLayout.getCurrent();
                        eVar = (VlionCustomInterstitialActivity.e) w3Var;
                    } else {
                        w3 w3Var2 = f3Var.f2796o;
                        if (w3Var2 == null) {
                            return;
                        }
                        current = vlionDownloadVideoLayout.getCurrent();
                        eVar = (VlionCustomInterstitialActivity.e) w3Var2;
                    }
                    eVar.a(current, z10);
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0056 A[Catch: all -> 0x0033, TryCatch #0 {all -> 0x0033, blocks: (B:5:0x000a, B:10:0x0012, B:12:0x001a, B:14:0x002c, B:16:0x0030, B:17:0x003c, B:18:0x003f, B:20:0x0056, B:21:0x0077, B:23:0x0086, B:25:0x00d3, B:26:0x00d6, B:28:0x013e, B:30:0x0144, B:52:0x0137, B:53:0x01b2, B:56:0x0062, B:58:0x006c, B:59:0x007f, B:60:0x0036, B:62:0x003a, B:63:0x0154, B:65:0x0158, B:66:0x015d, B:68:0x017f, B:69:0x01a0, B:70:0x01ad, B:71:0x018b, B:73:0x0195, B:74:0x01a8, B:32:0x00e6, B:36:0x0103, B:39:0x011c, B:44:0x012e, B:47:0x0115, B:50:0x00fc), top: B:4:0x000a, inners: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0086 A[Catch: all -> 0x0033, TryCatch #0 {all -> 0x0033, blocks: (B:5:0x000a, B:10:0x0012, B:12:0x001a, B:14:0x002c, B:16:0x0030, B:17:0x003c, B:18:0x003f, B:20:0x0056, B:21:0x0077, B:23:0x0086, B:25:0x00d3, B:26:0x00d6, B:28:0x013e, B:30:0x0144, B:52:0x0137, B:53:0x01b2, B:56:0x0062, B:58:0x006c, B:59:0x007f, B:60:0x0036, B:62:0x003a, B:63:0x0154, B:65:0x0158, B:66:0x015d, B:68:0x017f, B:69:0x01a0, B:70:0x01ad, B:71:0x018b, B:73:0x0195, B:74:0x01a8, B:32:0x00e6, B:36:0x0103, B:39:0x011c, B:44:0x012e, B:47:0x0115, B:50:0x00fc), top: B:4:0x000a, inners: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0062 A[Catch: all -> 0x0033, TryCatch #0 {all -> 0x0033, blocks: (B:5:0x000a, B:10:0x0012, B:12:0x001a, B:14:0x002c, B:16:0x0030, B:17:0x003c, B:18:0x003f, B:20:0x0056, B:21:0x0077, B:23:0x0086, B:25:0x00d3, B:26:0x00d6, B:28:0x013e, B:30:0x0144, B:52:0x0137, B:53:0x01b2, B:56:0x0062, B:58:0x006c, B:59:0x007f, B:60:0x0036, B:62:0x003a, B:63:0x0154, B:65:0x0158, B:66:0x015d, B:68:0x017f, B:69:0x01a0, B:70:0x01ad, B:71:0x018b, B:73:0x0195, B:74:0x01a8, B:32:0x00e6, B:36:0x0103, B:39:0x011c, B:44:0x012e, B:47:0x0115, B:50:0x00fc), top: B:4:0x000a, inners: #2 }] */
    @Override // cn.vlion.ad.inland.base.x3
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(cn.vlion.ad.inland.ad.javabean.VlionCustomParseAdData r24, android.view.View r25, boolean r26, boolean r27, int r28, boolean r29, boolean r30, cn.vlion.ad.inland.ad.interstitial.VlionCustomInterstitialActivity.e r31) {
        /*
            Method dump skipped, instructions count: 503
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.vlion.ad.inland.base.f3.a(cn.vlion.ad.inland.ad.javabean.VlionCustomParseAdData, android.view.View, boolean, boolean, int, boolean, boolean, cn.vlion.ad.inland.ad.interstitial.VlionCustomInterstitialActivity$e):void");
    }

    @Override // cn.vlion.ad.inland.base.x3
    public final void b(int i10) {
        try {
            if (i10 <= 0) {
                FrameLayout frameLayout = this.f2787f;
                if (frameLayout != null) {
                    frameLayout.setVisibility(8);
                    return;
                }
                return;
            }
            FrameLayout frameLayout2 = this.f2787f;
            if (frameLayout2 != null) {
                frameLayout2.setVisibility(0);
            }
            TextView textView = this.f2788g;
            if (textView != null) {
                textView.setText(String.valueOf(i10 + "s"));
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.x3
    public final void a(String str) {
    }

    @Override // cn.vlion.ad.inland.base.x3
    public final void a(String str, boolean z10) {
        try {
            VlionDownloadProgressBar vlionDownloadProgressBar = this.f2792k;
            if (vlionDownloadProgressBar != null) {
                vlionDownloadProgressBar.setShakeStyle(str, z10);
            }
            VlionVideoEndCardView vlionVideoEndCardView = this.f2785d;
            if (vlionVideoEndCardView != null) {
                vlionVideoEndCardView.a(str, z10);
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.x3
    public final void a(String str, boolean z10, boolean z11) {
        try {
            this.f3490a = z11;
            this.f2786e.a(str, z10, new b());
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.x3
    public final boolean a() {
        try {
            VlionVideoEndCardView vlionVideoEndCardView = this.f2785d;
            if (vlionVideoEndCardView != null) {
                if (vlionVideoEndCardView.getVisibility() == 0) {
                    return true;
                }
            }
            return false;
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
            return false;
        }
    }
}
