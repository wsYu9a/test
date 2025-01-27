package cn.vlion.ad.inland.base;

import cn.vlion.ad.inland.ad.javabean.VlionCustomAdData;
import cn.vlion.ad.inland.base.g7;
import cn.vlion.ad.inland.base.javabean.VlionADClickType;
import cn.vlion.ad.inland.base.util.handle.VlionSwipeParameterReplace;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import cn.vlion.ad.inland.base.util.log.LogVlion;

/* loaded from: classes.dex */
public final class l implements g7.a {

    /* renamed from: a */
    public final /* synthetic */ VlionCustomAdData.SeatbidBean.BidBean.McBean.CsBean f3055a;

    /* renamed from: b */
    public final /* synthetic */ j f3056b;

    public l(j jVar, VlionCustomAdData.SeatbidBean.BidBean.McBean.CsBean csBean) {
        this.f3056b = jVar;
        this.f3055a = csBean;
    }

    public final void a(int i10, int i11) {
        try {
            LogVlion.e("CustomVlionSplashView onSwipeAll");
            j.b(this.f3056b, new VlionADClickType("swipe_all", i10 + "," + i11, "main", "", ""));
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public final void b(int i10, int i11) {
        try {
            LogVlion.e("端策略 : CustomVlionSplashView onSwipeUp");
            if (this.f3056b.f2953b != null) {
                VlionADClickType vlionADClickType = new VlionADClickType("swipe_up", i10 + "," + i11, "main", "", "");
                VlionSwipeParameterReplace vlionSwipeParameterReplace = new VlionSwipeParameterReplace(this.f3056b.f2973v);
                vlionSwipeParameterReplace.handleBaseParameter(this.f3056b);
                vlionSwipeParameterReplace.handleSwipeParameter(this.f3056b.f2970s, vlionADClickType);
                vlionADClickType.setVlionBaseParameterReplace(vlionSwipeParameterReplace);
                VlionCustomAdData.SeatbidBean.BidBean.McBean.CsBean csBean = this.f3055a;
                if (csBean != null) {
                    vlionADClickType.setDefaultAdStrategy(csBean.isD());
                }
                j.b(this.f3056b, vlionADClickType);
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }
}
