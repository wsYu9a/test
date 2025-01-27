package cn.vlion.ad.inland.ad.view.video;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import cn.vlion.ad.inland.ad.view.active.VlionAdClosedView;
import cn.vlion.ad.inland.ad.view.button.VlionButtonSolidBgView;
import cn.vlion.ad.inland.ad.view.text.VlionDownloadBottomTextView;
import cn.vlion.ad.inland.base.R;
import cn.vlion.ad.inland.base.javabean.VlionADClickType;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import cn.vlion.ad.inland.base.util.log.LogVlion;

/* loaded from: classes.dex */
public class VlionVideoEndCardView extends LinearLayout {

    /* renamed from: a */
    public Context f2537a;

    /* renamed from: b */
    public ImageView f2538b;

    /* renamed from: c */
    public VlionAdClosedView f2539c;

    /* renamed from: d */
    public FrameLayout f2540d;

    /* renamed from: e */
    public ImageView f2541e;

    /* renamed from: f */
    public TextView f2542f;

    /* renamed from: g */
    public TextView f2543g;

    /* renamed from: h */
    public TextView f2544h;

    /* renamed from: i */
    public VlionButtonSolidBgView f2545i;

    /* renamed from: j */
    public VlionDownloadBottomTextView f2546j;

    /* renamed from: k */
    public a f2547k;

    public interface a {
        void a(VlionADClickType vlionADClickType);

        void b(VlionADClickType vlionADClickType);

        void onAdClose();
    }

    public VlionVideoEndCardView(Context context) {
        this(context, null);
    }

    public final void a() {
        try {
            LayoutInflater.from(this.f2537a).inflate(R.layout.vlion_cn_ad_reward_endcard, (ViewGroup) this, true);
            this.f2540d = (FrameLayout) findViewById(R.id.vlion_ad_endcard_fl);
            this.f2538b = (ImageView) findViewById(R.id.iv_end_card);
            this.f2539c = (VlionAdClosedView) findViewById(R.id.vlion_ad_closed);
            this.f2541e = (ImageView) findViewById(R.id.vlion_ad_app_icon);
            this.f2542f = (TextView) findViewById(R.id.vlion_ad_app_name);
            this.f2543g = (TextView) findViewById(R.id.vlion_ad_app_title);
            this.f2544h = (TextView) findViewById(R.id.vlion_ad_app_des);
            this.f2546j = (VlionDownloadBottomTextView) findViewById(R.id.vlion_ad_app_detal);
            this.f2545i = (VlionButtonSolidBgView) findViewById(R.id.vlion_button_solidbg_download_view);
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    public void setImageGravity(int i10) {
        try {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            layoutParams.gravity = i10;
            this.f2540d.setLayoutParams(layoutParams);
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public void setProgress(int i10) {
        try {
            LogVlion.e("VlionVideoEndCardView setProgress=" + i10);
            VlionButtonSolidBgView vlionButtonSolidBgView = this.f2545i;
            if (vlionButtonSolidBgView != null) {
                vlionButtonSolidBgView.setProgress(i10);
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public VlionVideoEndCardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0055 A[Catch: all -> 0x001a, TryCatch #2 {all -> 0x001a, blocks: (B:6:0x0004, B:11:0x0020, B:13:0x0055, B:16:0x005c, B:18:0x0062, B:23:0x0076, B:24:0x007d, B:25:0x00f5, B:28:0x00a2, B:31:0x00b9, B:33:0x00dd, B:34:0x00f0, B:35:0x00eb, B:38:0x00b2, B:39:0x0016, B:41:0x001d, B:30:0x00a6, B:20:0x006a), top: B:5:0x0004, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00a2 A[Catch: all -> 0x001a, TRY_LEAVE, TryCatch #2 {all -> 0x001a, blocks: (B:6:0x0004, B:11:0x0020, B:13:0x0055, B:16:0x005c, B:18:0x0062, B:23:0x0076, B:24:0x007d, B:25:0x00f5, B:28:0x00a2, B:31:0x00b9, B:33:0x00dd, B:34:0x00f0, B:35:0x00eb, B:38:0x00b2, B:39:0x0016, B:41:0x001d, B:30:0x00a6, B:20:0x006a), top: B:5:0x0004, inners: #0, #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(cn.vlion.ad.inland.ad.javabean.VlionCustomParseAdData r4, int r5, cn.vlion.ad.inland.ad.view.video.VlionVideoEndCardView.a r6) {
        /*
            Method dump skipped, instructions count: 271
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.vlion.ad.inland.ad.view.video.VlionVideoEndCardView.a(cn.vlion.ad.inland.ad.javabean.VlionCustomParseAdData, int, cn.vlion.ad.inland.ad.view.video.VlionVideoEndCardView$a):void");
    }

    public VlionVideoEndCardView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f2537a = context;
        a();
    }

    public final void a(String str, boolean z10) {
        try {
            LogVlion.e("VlionVideoEndCardView setShakeStyle tips=" + str + " isShake=" + z10);
            VlionButtonSolidBgView vlionButtonSolidBgView = this.f2545i;
            if (vlionButtonSolidBgView != null) {
                vlionButtonSolidBgView.setShakeStyle(str, z10);
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }
}
