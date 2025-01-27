package cn.vlion.ad.inland.base;

import cn.vlion.ad.inland.ad.javabean.VlionCustomAdData;
import cn.vlion.ad.inland.ad.javabean.VlionCustomParseAdData;
import cn.vlion.ad.inland.base.natives.VlionNativesAdVideoListener;
import cn.vlion.ad.inland.base.util.handle.VlionBaseParameterReplace;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import java.util.List;

/* loaded from: classes.dex */
public final class l2 implements VlionNativesAdVideoListener {

    /* renamed from: a */
    public final /* synthetic */ VlionNativesAdVideoListener f3062a;

    /* renamed from: b */
    public final /* synthetic */ k2 f3063b;

    public l2(k2 k2Var, VlionNativesAdVideoListener vlionNativesAdVideoListener) {
        this.f3063b = k2Var;
        this.f3062a = vlionNativesAdVideoListener;
    }

    @Override // cn.vlion.ad.inland.base.natives.VlionNativesAdVideoListener
    public final void onAdVideoPlayError(String str) {
        try {
            VlionNativesAdVideoListener vlionNativesAdVideoListener = this.f3062a;
            if (vlionNativesAdVideoListener != null) {
                vlionNativesAdVideoListener.onAdVideoPlayError(str);
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.natives.VlionNativesAdVideoListener
    public final void onProgressUpdate(int i10, int i11) {
        try {
            k2 k2Var = this.f3063b;
            k2Var.f3016j = i10;
            k2Var.f3017k = i11;
            VlionBaseParameterReplace vlionBaseParameterReplace = k2Var.f3020n;
            if (vlionBaseParameterReplace != null) {
                vlionBaseParameterReplace.handleVideoPlayingParameter(i10);
            }
            VlionCustomParseAdData vlionCustomParseAdData = this.f3063b.f3013g;
            if (vlionCustomParseAdData != null) {
                List<VlionCustomAdData.SeatbidBean.BidBean.VideoBean.VmPTrackingBean> vm_p_tracking = vlionCustomParseAdData.getVideoBean().getVm_p_tracking();
                k2 k2Var2 = this.f3063b;
                c5.a(vm_p_tracking, i10, k2Var2.f3020n, k2Var2.f3013g);
            }
            VlionNativesAdVideoListener vlionNativesAdVideoListener = this.f3062a;
            if (vlionNativesAdVideoListener != null) {
                vlionNativesAdVideoListener.onProgressUpdate(i10, i11);
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.natives.VlionNativesAdVideoListener
    public final void onVideoAdComplete() {
        try {
            k2 k2Var = this.f3063b;
            k2Var.f3015i = true;
            VlionBaseParameterReplace vlionBaseParameterReplace = k2Var.f3020n;
            if (vlionBaseParameterReplace != null) {
                vlionBaseParameterReplace.handleVideoFinishParameter(k2Var.f3017k);
            }
            VlionCustomParseAdData vlionCustomParseAdData = this.f3063b.f3013g;
            if (vlionCustomParseAdData != null) {
                List<String> vm_p_succ = vlionCustomParseAdData.getVideoBean().getVm_p_succ();
                k2 k2Var2 = this.f3063b;
                c5.a(vm_p_succ, k2Var2.f3020n, k2Var2.f3013g);
            }
            VlionNativesAdVideoListener vlionNativesAdVideoListener = this.f3062a;
            if (vlionNativesAdVideoListener != null) {
                vlionNativesAdVideoListener.onVideoAdComplete();
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.natives.VlionNativesAdVideoListener
    public final void onVideoAdContinuePlay() {
        try {
            VlionNativesAdVideoListener vlionNativesAdVideoListener = this.f3062a;
            if (vlionNativesAdVideoListener != null) {
                vlionNativesAdVideoListener.onVideoAdContinuePlay();
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.natives.VlionNativesAdVideoListener
    public final void onVideoAdPaused() {
        try {
            VlionNativesAdVideoListener vlionNativesAdVideoListener = this.f3062a;
            if (vlionNativesAdVideoListener != null) {
                vlionNativesAdVideoListener.onVideoAdPaused();
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.natives.VlionNativesAdVideoListener
    public final void onVideoAdStartPlay() {
        try {
            k2 k2Var = this.f3063b;
            VlionCustomParseAdData vlionCustomParseAdData = k2Var.f3013g;
            if (vlionCustomParseAdData != null) {
                k2Var.f3020n = new VlionBaseParameterReplace(vlionCustomParseAdData);
                k2 k2Var2 = this.f3063b;
                k2Var2.f3020n.handleVideoStartParameter(k2Var2.f3015i, k2Var2.f3016j, k2Var2.f3013g.getDuration(), this.f3063b.f3010d);
            }
            VlionCustomParseAdData vlionCustomParseAdData2 = this.f3063b.f3013g;
            if (vlionCustomParseAdData2 != null) {
                List<String> vm_p_start = vlionCustomParseAdData2.getVideoBean().getVm_p_start();
                k2 k2Var3 = this.f3063b;
                c5.b(vm_p_start, k2Var3.f3020n, k2Var3.f3013g);
            }
            VlionNativesAdVideoListener vlionNativesAdVideoListener = this.f3062a;
            if (vlionNativesAdVideoListener != null) {
                vlionNativesAdVideoListener.onVideoAdStartPlay();
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.natives.VlionNativesAdVideoListener
    public final void onVideoError(int i10, int i11) {
        try {
            VlionNativesAdVideoListener vlionNativesAdVideoListener = this.f3062a;
            if (vlionNativesAdVideoListener != null) {
                vlionNativesAdVideoListener.onVideoError(i10, i11);
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.natives.VlionNativesAdVideoListener
    public final void onVideoLoad() {
        try {
            VlionNativesAdVideoListener vlionNativesAdVideoListener = this.f3062a;
            if (vlionNativesAdVideoListener != null) {
                vlionNativesAdVideoListener.onVideoLoad();
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }
}
