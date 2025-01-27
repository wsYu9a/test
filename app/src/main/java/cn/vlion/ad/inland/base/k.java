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
public final class k implements SensorManagerManager.OnShakeListener {

    /* renamed from: a */
    public final /* synthetic */ VlionCustomAdData.SeatbidBean.BidBean.McBean.CsBean f3007a;

    /* renamed from: b */
    public final /* synthetic */ j f3008b;

    public k(j jVar, VlionCustomAdData.SeatbidBean.BidBean.McBean.CsBean csBean) {
        this.f3008b = jVar;
        this.f3007a = csBean;
    }

    @Override // cn.vlion.ad.inland.ad.utils.sensor.SensorManagerManager.OnShakeListener
    public final void onShake(boolean z10, VlionSensorPara vlionSensorPara) {
        try {
            LogVlion.e("端策略 : CustomVlionSplashView onShake =");
            j jVar = this.f3008b;
            if (jVar.f2977z) {
                return;
            }
            jVar.f2977z = true;
            VlionSensorManagerHelper.getInstance().unregisterShakeListener(this.f3008b.f2969r);
            j jVar2 = this.f3008b;
            jVar2.f2969r = null;
            jVar2.f2959h = false;
            jVar2.a();
            VlionSensorManagerHelper.getInstance().unregisterShakeListener(this.f3008b.f2969r);
            if (this.f3008b.f2953b != null) {
                VlionADClickType vlionADClickType = new VlionADClickType("shake", "", "main", "", "");
                VlionShakeParameterReplace vlionShakeParameterReplace = new VlionShakeParameterReplace(this.f3008b.f2973v);
                vlionShakeParameterReplace.handleBaseParameter(this.f3008b);
                vlionShakeParameterReplace.handleShakeParameter(z10, vlionSensorPara, vlionADClickType);
                vlionADClickType.setVlionBaseParameterReplace(vlionShakeParameterReplace);
                VlionCustomAdData.SeatbidBean.BidBean.McBean.CsBean csBean = this.f3007a;
                if (csBean != null) {
                    vlionADClickType.setDefaultAdStrategy(csBean.isD());
                    vlionADClickType.setTriggerParam(vlionADClickType.getTriggerParam() + this.f3007a.getTriggerParam());
                }
                j.b(this.f3008b, vlionADClickType);
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }
}
