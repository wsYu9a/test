package cn.vlion.ad.inland.base;

import android.content.Context;
import cn.vlion.ad.inland.ad.javabean.VlionCustomParseAdData;
import cn.vlion.ad.inland.ad.view.video.VlionBaseVideoView;
import cn.vlion.ad.inland.base.bid.VlionBiddingActionListener;
import cn.vlion.ad.inland.base.javabean.VlionAdapterADConfig;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;

/* loaded from: classes.dex */
public final class r4 extends e {

    /* renamed from: c */
    public Context f3347c;

    /* renamed from: d */
    public VlionAdapterADConfig f3348d;

    /* renamed from: e */
    public d7 f3349e;

    /* renamed from: f */
    public j f3350f;

    /* renamed from: g */
    public VlionCustomParseAdData f3351g;

    /* renamed from: h */
    public r6 f3352h;

    /* renamed from: i */
    public VlionBiddingActionListener f3353i;

    /* renamed from: j */
    public long f3354j;

    /* renamed from: k */
    public long f3355k;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                r4.this.f3350f.destroy();
                r4.this.f3350f.removeAllViews();
                r4.this.f3350f = null;
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }
    }

    public r4(Context context, VlionAdapterADConfig vlionAdapterADConfig) {
        try {
            this.f3347c = context;
            this.f3348d = vlionAdapterADConfig;
            this.f3352h = new r6();
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public final void a() {
        try {
            d7 d7Var = this.f3349e;
            if (d7Var != null) {
                try {
                    f5 f5Var = d7Var.f2714c;
                    if (f5Var != null) {
                        f5Var.destroy();
                        d7Var.f2714c = null;
                    }
                    if (d7Var.f2716e != null) {
                        d7Var.f2716e = null;
                    }
                    if (d7Var.f2712a != null) {
                        d7Var.f2712a = null;
                    }
                    VlionBaseVideoView vlionBaseVideoView = d7Var.f2715d;
                    if (vlionBaseVideoView != null) {
                        vlionBaseVideoView.destroy();
                        d7Var.f2715d = null;
                    }
                } catch (Throwable th2) {
                    VlionSDkManager.getInstance().upLoadCatchException(th2);
                }
                this.f3349e = null;
            }
            if (this.f3351g != null) {
                this.f3351g = null;
            }
            j jVar = this.f3350f;
            if (jVar != null) {
                jVar.post(new a());
            }
            r6 r6Var = this.f3352h;
            if (r6Var != null) {
                try {
                    q6 q6Var = r6Var.f3358a;
                    if (q6Var != null) {
                        q6Var.cancel();
                        r6Var.f3358a = null;
                    }
                } catch (Throwable th3) {
                    VlionSDkManager.getInstance().upLoadCatchException(th3);
                }
                this.f3352h = null;
            }
            this.f3353i = null;
        } catch (Throwable th4) {
            VlionSDkManager.getInstance().upLoadCatchException(th4);
        }
    }

    public final void a(boolean z10) {
        try {
            VlionCustomParseAdData vlionCustomParseAdData = this.f3351g;
            if (vlionCustomParseAdData == null) {
                VlionBiddingActionListener vlionBiddingActionListener = this.f3353i;
                if (vlionBiddingActionListener != null) {
                    i1 i1Var = i1.f2919i;
                    vlionBiddingActionListener.onAdRenderFailure(i1Var.f2920a, i1Var.f2921b);
                    return;
                }
                return;
            }
            vlionCustomParseAdData.setSingleBid(z10);
            VlionCustomParseAdData vlionCustomParseAdData2 = this.f3351g;
            try {
                d7 d7Var = new d7(this.f3347c, new q4(this));
                this.f3349e = d7Var;
                d7Var.a(vlionCustomParseAdData2, this.f3348d);
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        } catch (Throwable th3) {
            VlionSDkManager.getInstance().upLoadCatchException(th3);
        }
    }
}
