package cn.vlion.ad.inland.base;

import cn.vlion.ad.inland.ad.javabean.VlionCustomAdData;
import cn.vlion.ad.inland.ad.utils.sensor.SensorManagerManager;
import cn.vlion.ad.inland.ad.utils.sensor.VlionSensorManagerHelper;
import cn.vlion.ad.inland.ad.utils.sensor.VlionSensorPara;
import cn.vlion.ad.inland.base.javabean.VlionADClickType;
import cn.vlion.ad.inland.base.util.handle.VlionShakeParameterReplace;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import cn.vlion.ad.inland.base.util.log.LogVlion;

/* loaded from: classes.dex */
public final class t2 implements SensorManagerManager.OnShakeListener {

    /* renamed from: a */
    public final /* synthetic */ VlionCustomAdData.SeatbidBean.BidBean.McBean.CsBean f3372a;

    /* renamed from: b */
    public final /* synthetic */ y2 f3373b;

    public t2(y2 y2Var, VlionCustomAdData.SeatbidBean.BidBean.McBean.CsBean csBean) {
        this.f3373b = y2Var;
        this.f3372a = csBean;
    }

    @Override // cn.vlion.ad.inland.ad.utils.sensor.SensorManagerManager.OnShakeListener
    public final void onShake(boolean z10, VlionSensorPara vlionSensorPara) {
        try {
            LogVlion.e("端策略 : VlionCustomBannerLayout onShake =");
            y2 y2Var = this.f3373b;
            if (y2Var.f3524w) {
                return;
            }
            y2Var.f3524w = true;
            VlionSensorManagerHelper.getInstance().unregisterShakeListener(this.f3373b.f3521t);
            y2 y2Var2 = this.f3373b;
            y2Var2.f3521t = null;
            y2Var2.G = false;
            y2Var2.d();
            VlionADClickType vlionADClickType = new VlionADClickType("shake", "", "main", "hotsplot", "");
            VlionShakeParameterReplace vlionShakeParameterReplace = new VlionShakeParameterReplace(this.f3373b.f3527z);
            vlionShakeParameterReplace.handleBaseParameter(this.f3373b);
            vlionShakeParameterReplace.handleShakeParameter(z10, vlionSensorPara, vlionADClickType);
            vlionADClickType.setVlionBaseParameterReplace(vlionShakeParameterReplace);
            VlionCustomAdData.SeatbidBean.BidBean.McBean.CsBean csBean = this.f3372a;
            if (csBean != null) {
                vlionADClickType.setDefaultAdStrategy(csBean.isD());
                vlionADClickType.setTriggerParam(vlionADClickType.getTriggerParam() + this.f3372a.getTriggerParam());
            }
            y2.a(this.f3373b, vlionADClickType);
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }
}
