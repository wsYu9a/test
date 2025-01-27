package cn.vlion.ad.inland.ad.reward.model;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import cn.vlion.ad.inland.ad.view.active.VlionDownloadProgressBar;
import cn.vlion.ad.inland.ad.view.text.VlionDownloadBottomTextView;
import cn.vlion.ad.inland.base.R;
import cn.vlion.ad.inland.base.g4;
import cn.vlion.ad.inland.base.h4;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;

/* loaded from: classes.dex */
public class VlionVideoAdDetailBottomView extends h4 {

    /* renamed from: a */
    public Context f2372a;

    /* renamed from: b */
    public ImageView f2373b;

    /* renamed from: c */
    public TextView f2374c;

    /* renamed from: d */
    public TextView f2375d;

    /* renamed from: e */
    public TextView f2376e;

    /* renamed from: f */
    public VlionDownloadProgressBar f2377f;

    /* renamed from: g */
    public VlionDownloadBottomTextView f2378g;

    /* renamed from: h */
    public g4 f2379h;

    public VlionVideoAdDetailBottomView(Context context) {
        this(context, null);
    }

    public final void a() {
        try {
            LayoutInflater.from(this.f2372a).inflate(R.layout.vlion_cn_ad_reward_detail_bottom, (ViewGroup) this, true);
            this.f2373b = (ImageView) findViewById(R.id.vlion_ad_app_icon);
            this.f2374c = (TextView) findViewById(R.id.vlion_ad_app_name);
            this.f2375d = (TextView) findViewById(R.id.vlion_ad_app_title);
            this.f2376e = (TextView) findViewById(R.id.vlion_ad_app_des);
            this.f2377f = (VlionDownloadProgressBar) findViewById(R.id.vlion_ad_app_action);
            this.f2378g = (VlionDownloadBottomTextView) findViewById(R.id.vlion_ad_app_detal);
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.h4
    public void setProgress(int i10) {
        try {
            VlionDownloadProgressBar vlionDownloadProgressBar = this.f2377f;
            if (vlionDownloadProgressBar != null) {
                vlionDownloadProgressBar.setProgress(i10);
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public VlionVideoAdDetailBottomView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // cn.vlion.ad.inland.base.h4
    public final void a(int i10) {
    }

    public VlionVideoAdDetailBottomView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f2372a = context;
        a();
    }

    @Override // cn.vlion.ad.inland.base.h4
    public final void a(String str, boolean z10) {
        try {
            VlionDownloadProgressBar vlionDownloadProgressBar = this.f2377f;
            if (vlionDownloadProgressBar != null) {
                vlionDownloadProgressBar.setShakeStyle(str, z10);
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x00b7 A[Catch: all -> 0x003a, TryCatch #2 {all -> 0x003a, blocks: (B:3:0x0001, B:7:0x0007, B:9:0x0011, B:12:0x0018, B:14:0x001e, B:19:0x0032, B:20:0x003d, B:22:0x00b7, B:23:0x00c4, B:26:0x0062, B:29:0x0079, B:31:0x009d, B:32:0x00b0, B:33:0x00ab, B:36:0x0072, B:28:0x0066, B:16:0x0026), top: B:2:0x0001, inners: #0, #1 }] */
    @Override // cn.vlion.ad.inland.base.h4
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(cn.vlion.ad.inland.ad.javabean.VlionCustomParseAdData r4, boolean r5, boolean r6, cn.vlion.ad.inland.base.x5 r7) {
        /*
            r3 = this;
            r6 = 0
            r3.setVisibility(r6)     // Catch: java.lang.Throwable -> L3a
            if (r4 != 0) goto L7
            return
        L7:
            r3.f2379h = r7     // Catch: java.lang.Throwable -> L3a
            boolean r6 = r4.isIs_download()     // Catch: java.lang.Throwable -> L3a
            r7 = 8
            if (r6 == 0) goto L62
            cn.vlion.ad.inland.ad.javabean.VlionCustomAdData$SeatbidBean$BidBean$AppInfoBean r6 = r4.getAppInfoBean()     // Catch: java.lang.Throwable -> L3a
            if (r6 != 0) goto L18
            return
        L18:
            cn.vlion.ad.inland.ad.javabean.VlionCustomAdData$SeatbidBean$BidBean$AppInfoBean$AppLogoBean r0 = r6.getApp_logo()     // Catch: java.lang.Throwable -> L3a
            if (r0 == 0) goto L3d
            cn.vlion.ad.inland.ad.javabean.VlionCustomAdData$SeatbidBean$BidBean$AppInfoBean$AppLogoBean r0 = r6.getApp_logo()     // Catch: java.lang.Throwable -> L3a
            java.lang.String r0 = r0.getUrl()     // Catch: java.lang.Throwable -> L3a
            android.widget.ImageView r1 = r3.f2373b     // Catch: java.lang.Throwable -> L31
            cn.vlion.ad.inland.base.u6 r2 = new cn.vlion.ad.inland.base.u6     // Catch: java.lang.Throwable -> L31
            r2.<init>()     // Catch: java.lang.Throwable -> L31
            cn.vlion.ad.inland.base.network.ok.HttpRequestUtil.downloadBitmap(r1, r0, r2)     // Catch: java.lang.Throwable -> L31
            goto L3d
        L31:
            r0 = move-exception
            cn.vlion.ad.inland.base.util.init.VlionSDkManager r1 = cn.vlion.ad.inland.base.util.init.VlionSDkManager.getInstance()     // Catch: java.lang.Throwable -> L3a
            r1.upLoadCatchException(r0)     // Catch: java.lang.Throwable -> L3a
            goto L3d
        L3a:
            r4 = move-exception
            goto Ld6
        L3d:
            android.widget.TextView r0 = r3.f2374c     // Catch: java.lang.Throwable -> L3a
            java.lang.String r1 = r6.getApp_name()     // Catch: java.lang.Throwable -> L3a
            java.lang.String r1 = java.lang.String.valueOf(r1)     // Catch: java.lang.Throwable -> L3a
            r0.setText(r1)     // Catch: java.lang.Throwable -> L3a
            android.widget.TextView r0 = r3.f2375d     // Catch: java.lang.Throwable -> L3a
            java.lang.String r1 = r6.getApp_desc()     // Catch: java.lang.Throwable -> L3a
            java.lang.String r1 = java.lang.String.valueOf(r1)     // Catch: java.lang.Throwable -> L3a
            r0.setText(r1)     // Catch: java.lang.Throwable -> L3a
            cn.vlion.ad.inland.ad.view.text.VlionDownloadBottomTextView r0 = r3.f2378g     // Catch: java.lang.Throwable -> L3a
            r0.setAppInfo(r6)     // Catch: java.lang.Throwable -> L3a
            android.widget.TextView r6 = r3.f2376e     // Catch: java.lang.Throwable -> L3a
            r6.setVisibility(r7)     // Catch: java.lang.Throwable -> L3a
            goto Lb5
        L62:
            java.lang.String r6 = r4.getBrand_logo()     // Catch: java.lang.Throwable -> L3a
            android.widget.ImageView r0 = r3.f2373b     // Catch: java.lang.Throwable -> L71
            cn.vlion.ad.inland.base.u6 r1 = new cn.vlion.ad.inland.base.u6     // Catch: java.lang.Throwable -> L71
            r1.<init>()     // Catch: java.lang.Throwable -> L71
            cn.vlion.ad.inland.base.network.ok.HttpRequestUtil.downloadBitmap(r0, r6, r1)     // Catch: java.lang.Throwable -> L71
            goto L79
        L71:
            r6 = move-exception
            cn.vlion.ad.inland.base.util.init.VlionSDkManager r0 = cn.vlion.ad.inland.base.util.init.VlionSDkManager.getInstance()     // Catch: java.lang.Throwable -> L3a
            r0.upLoadCatchException(r6)     // Catch: java.lang.Throwable -> L3a
        L79:
            android.widget.TextView r6 = r3.f2374c     // Catch: java.lang.Throwable -> L3a
            java.lang.String r0 = r4.getBrand_name()     // Catch: java.lang.Throwable -> L3a
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch: java.lang.Throwable -> L3a
            r6.setText(r0)     // Catch: java.lang.Throwable -> L3a
            android.widget.TextView r6 = r3.f2375d     // Catch: java.lang.Throwable -> L3a
            java.lang.String r0 = r4.getTitle()     // Catch: java.lang.Throwable -> L3a
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch: java.lang.Throwable -> L3a
            r6.setText(r0)     // Catch: java.lang.Throwable -> L3a
            java.lang.String r6 = r4.getDes()     // Catch: java.lang.Throwable -> L3a
            boolean r6 = android.text.TextUtils.isEmpty(r6)     // Catch: java.lang.Throwable -> L3a
            if (r6 != 0) goto Lab
            android.widget.TextView r6 = r3.f2376e     // Catch: java.lang.Throwable -> L3a
            java.lang.String r0 = r4.getDes()     // Catch: java.lang.Throwable -> L3a
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch: java.lang.Throwable -> L3a
            r6.setText(r0)     // Catch: java.lang.Throwable -> L3a
            goto Lb0
        Lab:
            android.widget.TextView r6 = r3.f2376e     // Catch: java.lang.Throwable -> L3a
            r6.setVisibility(r7)     // Catch: java.lang.Throwable -> L3a
        Lb0:
            cn.vlion.ad.inland.ad.view.text.VlionDownloadBottomTextView r6 = r3.f2378g     // Catch: java.lang.Throwable -> L3a
            r6.setVisibility(r7)     // Catch: java.lang.Throwable -> L3a
        Lb5:
            if (r5 == 0) goto Lc4
            cn.vlion.ad.inland.base.i0 r5 = new cn.vlion.ad.inland.base.i0     // Catch: java.lang.Throwable -> L3a
            r5.<init>(r3)     // Catch: java.lang.Throwable -> L3a
            cn.vlion.ad.inland.base.s6 r6 = new cn.vlion.ad.inland.base.s6     // Catch: java.lang.Throwable -> L3a
            r6.<init>(r3, r5, r4)     // Catch: java.lang.Throwable -> L3a
            r3.setOnClickListener(r6)     // Catch: java.lang.Throwable -> L3a
        Lc4:
            cn.vlion.ad.inland.base.i0 r5 = new cn.vlion.ad.inland.base.i0     // Catch: java.lang.Throwable -> L3a
            cn.vlion.ad.inland.ad.view.active.VlionDownloadProgressBar r6 = r3.f2377f     // Catch: java.lang.Throwable -> L3a
            r5.<init>(r6)     // Catch: java.lang.Throwable -> L3a
            cn.vlion.ad.inland.ad.view.active.VlionDownloadProgressBar r6 = r3.f2377f     // Catch: java.lang.Throwable -> L3a
            cn.vlion.ad.inland.base.t6 r7 = new cn.vlion.ad.inland.base.t6     // Catch: java.lang.Throwable -> L3a
            r7.<init>(r3, r5, r4)     // Catch: java.lang.Throwable -> L3a
            r6.setOnClickListener(r7)     // Catch: java.lang.Throwable -> L3a
            goto Ldd
        Ld6:
            cn.vlion.ad.inland.base.util.init.VlionSDkManager r5 = cn.vlion.ad.inland.base.util.init.VlionSDkManager.getInstance()
            r5.upLoadCatchException(r4)
        Ldd:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.vlion.ad.inland.ad.reward.model.VlionVideoAdDetailBottomView.a(cn.vlion.ad.inland.ad.javabean.VlionCustomParseAdData, boolean, boolean, cn.vlion.ad.inland.base.x5):void");
    }
}
