package cn.vlion.ad.inland.base;

import android.app.Activity;
import android.widget.FrameLayout;
import cn.vlion.ad.inland.ad.javabean.VlionCustomParseAdData;
import cn.vlion.ad.inland.base.bid.VlionBiddingActionListener;
import cn.vlion.ad.inland.base.bid.VlionBiddingLoadListener;
import cn.vlion.ad.inland.base.javabean.VlionAdapterADConfig;
import cn.vlion.ad.inland.base.util.date.VlionDateUtils;
import cn.vlion.ad.inland.base.util.handle.VlionBaseParameterReplace;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import cn.vlion.ad.inland.base.util.log.LogVlion;

/* loaded from: classes.dex */
public final class q1 extends e {

    /* renamed from: c */
    public Activity f3305c;

    /* renamed from: d */
    public VlionAdapterADConfig f3306d;

    /* renamed from: e */
    public VlionBiddingLoadListener f3307e;

    /* renamed from: f */
    public VlionBiddingActionListener f3308f;

    /* renamed from: g */
    public f7 f3309g;

    /* renamed from: i */
    public VlionCustomParseAdData f3311i;

    /* renamed from: k */
    public v1 f3313k;

    /* renamed from: m */
    public int f3315m;

    /* renamed from: n */
    public int f3316n;

    /* renamed from: o */
    public long f3317o;

    /* renamed from: p */
    public long f3318p;

    /* renamed from: q */
    public VlionBaseParameterReplace f3319q;

    /* renamed from: h */
    public volatile long f3310h = 0;

    /* renamed from: l */
    public boolean f3314l = false;

    /* renamed from: j */
    public r6 f3312j = new r6();

    public q1(Activity activity, VlionAdapterADConfig vlionAdapterADConfig) {
        this.f3305c = activity;
        this.f3306d = vlionAdapterADConfig;
        new FrameLayout.LayoutParams(-1, -1).gravity = 17;
    }

    public final void a() {
        try {
            this.f3310h = System.currentTimeMillis();
            LogVlion.e("loadBanner:lastLoadTime" + VlionDateUtils.getFormatDate(Long.valueOf(this.f3310h)));
            try {
                LogVlion.e("loadData=");
                f4.a(1, this.f3306d, new o1(this));
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        } catch (Throwable th3) {
            VlionSDkManager.getInstance().upLoadCatchException(th3);
        }
    }

    public final void a(boolean z10) {
        try {
            VlionCustomParseAdData vlionCustomParseAdData = this.f3311i;
            if (vlionCustomParseAdData == null) {
                VlionBiddingActionListener vlionBiddingActionListener = this.f3308f;
                if (vlionBiddingActionListener != null) {
                    i1 i1Var = i1.f2919i;
                    vlionBiddingActionListener.onAdRenderFailure(i1Var.f2920a, i1Var.f2921b);
                    return;
                }
                return;
            }
            vlionCustomParseAdData.setSingleBid(z10);
            VlionCustomParseAdData vlionCustomParseAdData2 = this.f3311i;
            try {
                if (this.f3305c == null) {
                    return;
                }
                f7 f7Var = this.f3309g;
                if (f7Var != null) {
                    f7Var.a();
                    this.f3309g = null;
                }
                f7 f7Var2 = new f7(this.f3305c, new p1(this, vlionCustomParseAdData2));
                this.f3309g = f7Var2;
                f7Var2.a(vlionCustomParseAdData2, this.f3306d);
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        } catch (Throwable th3) {
            VlionSDkManager.getInstance().upLoadCatchException(th3);
        }
    }
}
