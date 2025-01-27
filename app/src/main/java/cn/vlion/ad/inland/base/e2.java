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
public final class e2 implements SensorManagerManager.OnShakeListener {

    /* renamed from: a */
    public final /* synthetic */ VlionCustomAdData.SeatbidBean.BidBean.McBean.CsBean f2757a;

    /* renamed from: b */
    public final /* synthetic */ i2 f2758b;

    public e2(i2 i2Var, VlionCustomAdData.SeatbidBean.BidBean.McBean.CsBean csBean) {
        this.f2758b = i2Var;
        this.f2757a = csBean;
    }

    @Override // cn.vlion.ad.inland.ad.utils.sensor.SensorManagerManager.OnShakeListener
    public final void onShake(boolean z10, VlionSensorPara vlionSensorPara) {
        try {
            LogVlion.e("端策略 : VlionCustomBannerLayout onShake =");
            i2 i2Var = this.f2758b;
            if (i2Var.F) {
                return;
            }
            i2Var.F = true;
            VlionSensorManagerHelper.getInstance().unregisterShakeListener(this.f2758b.f2929o);
            i2 i2Var2 = this.f2758b;
            i2Var2.f2929o = null;
            i2Var2.f2940z = false;
            i2Var2.d();
            VlionADClickType vlionADClickType = new VlionADClickType("shake", "", "main", "hotsplot", "");
            VlionShakeParameterReplace vlionShakeParameterReplace = new VlionShakeParameterReplace(this.f2758b.A);
            vlionShakeParameterReplace.handleBaseParameter(this.f2758b);
            vlionShakeParameterReplace.handleShakeParameter(z10, vlionSensorPara, vlionADClickType);
            vlionADClickType.setVlionBaseParameterReplace(vlionShakeParameterReplace);
            VlionCustomAdData.SeatbidBean.BidBean.McBean.CsBean csBean = this.f2757a;
            if (csBean != null) {
                vlionADClickType.setDefaultAdStrategy(csBean.isD());
                vlionADClickType.setTriggerParam(vlionADClickType.getTriggerParam() + this.f2757a.getTriggerParam());
            }
            i2.a(this.f2758b, vlionADClickType);
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }
}
