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
public final class y1 implements SensorManagerManager.OnShakeListener {

    /* renamed from: a */
    public final /* synthetic */ i0 f3506a;

    /* renamed from: b */
    public final /* synthetic */ VlionCustomAdData.SeatbidBean.BidBean.McBean.CsBean f3507b;

    /* renamed from: c */
    public final /* synthetic */ v1 f3508c;

    public y1(v1 v1Var, i0 i0Var, VlionCustomAdData.SeatbidBean.BidBean.McBean.CsBean csBean) {
        this.f3508c = v1Var;
        this.f3506a = i0Var;
        this.f3507b = csBean;
    }

    @Override // cn.vlion.ad.inland.ad.utils.sensor.SensorManagerManager.OnShakeListener
    public final void onShake(boolean z10, VlionSensorPara vlionSensorPara) {
        try {
            LogVlion.e("端策略 : VlionCustomBannerLayout onShake =");
            v1 v1Var = this.f3508c;
            if (v1Var.C) {
                return;
            }
            v1Var.C = true;
            VlionSensorManagerHelper.getInstance().unregisterShakeListener(this.f3508c.A);
            v1 v1Var2 = this.f3508c;
            v1Var2.A = null;
            v1Var2.f3446y = false;
            v1Var2.e();
            if (this.f3506a != null) {
                VlionADClickType vlionADClickType = new VlionADClickType("shake", "", "main", "hotsplot", "");
                VlionShakeParameterReplace vlionShakeParameterReplace = new VlionShakeParameterReplace(this.f3508c.f3429h);
                vlionShakeParameterReplace.handleBaseParameter(this.f3508c);
                vlionShakeParameterReplace.handleShakeParameter(z10, vlionSensorPara, vlionADClickType);
                vlionADClickType.setVlionBaseParameterReplace(vlionShakeParameterReplace);
                VlionCustomAdData.SeatbidBean.BidBean.McBean.CsBean csBean = this.f3507b;
                if (csBean != null) {
                    vlionADClickType.setDefaultAdStrategy(csBean.isD());
                    vlionADClickType.setTriggerParam(vlionADClickType.getTriggerParam() + this.f3507b.getTriggerParam());
                }
                v1.a(this.f3508c, vlionADClickType);
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }
}
