package cn.vlion.ad.inland.base;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import cn.vlion.ad.inland.ad.reward.model.VlionVideoAdDetailBottomView;
import cn.vlion.ad.inland.ad.view.active.VlionDownloadProgressBar;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;

/* loaded from: classes.dex */
public final class y6 extends h4 {

    /* renamed from: a */
    public Context f3532a;

    /* renamed from: b */
    public ImageView f3533b;

    /* renamed from: c */
    public TextView f3534c;

    /* renamed from: d */
    public TextView f3535d;

    /* renamed from: e */
    public VlionDownloadProgressBar f3536e;

    /* renamed from: f */
    public LinearLayout f3537f;

    /* renamed from: g */
    public VlionVideoAdDetailBottomView f3538g;

    public y6(Context context, int i10) {
        super(context, null, 0);
        this.f3532a = context;
        a();
    }

    public final void a() {
        try {
            LayoutInflater.from(this.f3532a).inflate(R.layout.vlion_cn_ad_reward_detail_top, (ViewGroup) this, true);
            this.f3533b = (ImageView) findViewById(R.id.vlion_ad_app_icon);
            this.f3534c = (TextView) findViewById(R.id.vlion_iv_title);
            this.f3535d = (TextView) findViewById(R.id.vlion_iv_des);
            VlionDownloadProgressBar vlionDownloadProgressBar = (VlionDownloadProgressBar) findViewById(R.id.vlion_ad_app_action);
            this.f3536e = vlionDownloadProgressBar;
            vlionDownloadProgressBar.setTextSize(13.0f);
            this.f3537f = (LinearLayout) findViewById(R.id.vlion_ad_app_top_view);
            this.f3538g = (VlionVideoAdDetailBottomView) findViewById(R.id.vlionVideoAdDetailBottomView);
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.h4
    public void setProgress(int i10) {
        try {
            VlionVideoAdDetailBottomView vlionVideoAdDetailBottomView = this.f3538g;
            if (vlionVideoAdDetailBottomView != null) {
                vlionVideoAdDetailBottomView.setProgress(i10);
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.h4
    public final void a(int i10) {
        if (i10 >= 5) {
            try {
                LinearLayout linearLayout = this.f3537f;
                if (linearLayout != null) {
                    linearLayout.setVisibility(8);
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }
    }

    @Override // cn.vlion.ad.inland.base.h4
    public final void a(String str, boolean z10) {
        try {
            VlionVideoAdDetailBottomView vlionVideoAdDetailBottomView = this.f3538g;
            if (vlionVideoAdDetailBottomView != null) {
                vlionVideoAdDetailBottomView.a(str, z10);
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x00b6 A[Catch: all -> 0x006c, TryCatch #2 {all -> 0x006c, blocks: (B:3:0x0001, B:7:0x000c, B:10:0x0027, B:14:0x004a, B:16:0x0050, B:21:0x0064, B:22:0x006f, B:23:0x00ad, B:25:0x00b6, B:26:0x00dc, B:28:0x00e5, B:29:0x00f6, B:32:0x00bf, B:34:0x00cb, B:35:0x00d4, B:36:0x0083, B:39:0x009a, B:42:0x0093, B:45:0x0020, B:38:0x0087, B:18:0x0058, B:9:0x0014), top: B:2:0x0001, inners: #0, #1, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00e5 A[Catch: all -> 0x006c, TryCatch #2 {all -> 0x006c, blocks: (B:3:0x0001, B:7:0x000c, B:10:0x0027, B:14:0x004a, B:16:0x0050, B:21:0x0064, B:22:0x006f, B:23:0x00ad, B:25:0x00b6, B:26:0x00dc, B:28:0x00e5, B:29:0x00f6, B:32:0x00bf, B:34:0x00cb, B:35:0x00d4, B:36:0x0083, B:39:0x009a, B:42:0x0093, B:45:0x0020, B:38:0x0087, B:18:0x0058, B:9:0x0014), top: B:2:0x0001, inners: #0, #1, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00bf A[Catch: all -> 0x006c, TryCatch #2 {all -> 0x006c, blocks: (B:3:0x0001, B:7:0x000c, B:10:0x0027, B:14:0x004a, B:16:0x0050, B:21:0x0064, B:22:0x006f, B:23:0x00ad, B:25:0x00b6, B:26:0x00dc, B:28:0x00e5, B:29:0x00f6, B:32:0x00bf, B:34:0x00cb, B:35:0x00d4, B:36:0x0083, B:39:0x009a, B:42:0x0093, B:45:0x0020, B:38:0x0087, B:18:0x0058, B:9:0x0014), top: B:2:0x0001, inners: #0, #1, #3 }] */
    @Override // cn.vlion.ad.inland.base.h4
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(cn.vlion.ad.inland.ad.javabean.VlionCustomParseAdData r5, boolean r6, boolean r7, cn.vlion.ad.inland.base.x5 r8) {
        /*
            Method dump skipped, instructions count: 272
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.vlion.ad.inland.base.y6.a(cn.vlion.ad.inland.ad.javabean.VlionCustomParseAdData, boolean, boolean, cn.vlion.ad.inland.base.x5):void");
    }
}
