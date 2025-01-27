package cn.vlion.ad.inland.base;

import cn.vlion.ad.inland.ad.javabean.VlionCustomAdData;
import cn.vlion.ad.inland.ad.javabean.VlionCustomParseAdData;
import cn.vlion.ad.inland.base.natives.VlionNativesAdVideoListener;
import cn.vlion.ad.inland.base.p1;
import cn.vlion.ad.inland.base.util.handle.VlionBaseParameterReplace;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import java.util.List;

/* loaded from: classes.dex */
public final class u1 implements VlionNativesAdVideoListener {

    /* renamed from: a */
    public final /* synthetic */ v1 f3391a;

    public u1(v1 v1Var) {
        this.f3391a = v1Var;
    }

    @Override // cn.vlion.ad.inland.base.natives.VlionNativesAdVideoListener
    public final void onAdVideoPlayError(String str) {
    }

    @Override // cn.vlion.ad.inland.base.natives.VlionNativesAdVideoListener
    public final void onProgressUpdate(int i10, int i11) {
        r1 r1Var = this.f3391a.f3432k;
        if (r1Var != null) {
            p1.a aVar = (p1.a) r1Var;
            try {
                q1 q1Var = p1.this.f3273b;
                q1Var.f3315m = i10;
                q1Var.f3316n = i11;
                VlionBaseParameterReplace vlionBaseParameterReplace = q1Var.f3319q;
                if (vlionBaseParameterReplace != null) {
                    vlionBaseParameterReplace.handleVideoPlayingParameter(i10);
                }
                VlionCustomParseAdData vlionCustomParseAdData = p1.this.f3273b.f3311i;
                if (vlionCustomParseAdData != null) {
                    List<VlionCustomAdData.SeatbidBean.BidBean.VideoBean.VmPTrackingBean> vm_p_tracking = vlionCustomParseAdData.getVideoBean().getVm_p_tracking();
                    q1 q1Var2 = p1.this.f3273b;
                    c5.a(vm_p_tracking, i10, q1Var2.f3319q, q1Var2.f3311i);
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }
    }

    @Override // cn.vlion.ad.inland.base.natives.VlionNativesAdVideoListener
    public final void onVideoAdComplete() {
        r1 r1Var = this.f3391a.f3432k;
        if (r1Var != null) {
            p1.a aVar = (p1.a) r1Var;
            try {
                q1 q1Var = p1.this.f3273b;
                q1Var.f3314l = true;
                VlionBaseParameterReplace vlionBaseParameterReplace = q1Var.f3319q;
                if (vlionBaseParameterReplace != null) {
                    vlionBaseParameterReplace.handleVideoFinishParameter(q1Var.f3316n);
                }
                VlionCustomParseAdData vlionCustomParseAdData = p1.this.f3273b.f3311i;
                if (vlionCustomParseAdData != null) {
                    List<String> vm_p_succ = vlionCustomParseAdData.getVideoBean().getVm_p_succ();
                    q1 q1Var2 = p1.this.f3273b;
                    c5.a(vm_p_succ, q1Var2.f3319q, q1Var2.f3311i);
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }
    }

    @Override // cn.vlion.ad.inland.base.natives.VlionNativesAdVideoListener
    public final void onVideoAdContinuePlay() {
    }

    @Override // cn.vlion.ad.inland.base.natives.VlionNativesAdVideoListener
    public final void onVideoAdPaused() {
    }

    @Override // cn.vlion.ad.inland.base.natives.VlionNativesAdVideoListener
    public final void onVideoAdStartPlay() {
        r1 r1Var = this.f3391a.f3432k;
        if (r1Var != null) {
            p1.a aVar = (p1.a) r1Var;
            try {
                q1 q1Var = p1.this.f3273b;
                VlionCustomParseAdData vlionCustomParseAdData = q1Var.f3311i;
                if (vlionCustomParseAdData != null) {
                    q1Var.f3319q = new VlionBaseParameterReplace(vlionCustomParseAdData);
                    q1 q1Var2 = p1.this.f3273b;
                    q1Var2.f3319q.handleVideoStartParameter(q1Var2.f3314l, q1Var2.f3315m, q1Var2.f3311i.getDuration(), p1.this.f3273b.f3306d);
                }
                VlionCustomParseAdData vlionCustomParseAdData2 = p1.this.f3273b.f3311i;
                if (vlionCustomParseAdData2 != null) {
                    List<String> vm_p_start = vlionCustomParseAdData2.getVideoBean().getVm_p_start();
                    q1 q1Var3 = p1.this.f3273b;
                    c5.b(vm_p_start, q1Var3.f3319q, q1Var3.f3311i);
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }
    }

    @Override // cn.vlion.ad.inland.base.natives.VlionNativesAdVideoListener
    public final void onVideoError(int i10, int i11) {
    }

    @Override // cn.vlion.ad.inland.base.natives.VlionNativesAdVideoListener
    public final void onVideoLoad() {
    }
}
