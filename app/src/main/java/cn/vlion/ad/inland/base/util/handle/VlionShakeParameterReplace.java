package cn.vlion.ad.inland.base.util.handle;

import cn.vlion.ad.inland.ad.config.VlionCustomAdActiveType$VlionCustomTarget;
import cn.vlion.ad.inland.ad.javabean.VlionCustomParseAdData;
import cn.vlion.ad.inland.ad.utils.sensor.VlionSensorPara;
import cn.vlion.ad.inland.base.javabean.VlionADClickType;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import java.text.SimpleDateFormat;
import java.util.HashMap;

/* loaded from: classes.dex */
public class VlionShakeParameterReplace extends VlionBaseParameterReplace {
    public VlionShakeParameterReplace(VlionCustomParseAdData vlionCustomParseAdData) {
        super(vlionCustomParseAdData);
    }

    @Override // cn.vlion.ad.inland.base.util.handle.VlionBaseParameterReplace
    public String handleReplace(String str) {
        return super.handleReplace(str);
    }

    @Override // cn.vlion.ad.inland.base.util.handle.VlionBaseParameterReplace
    public void handleShakeParameter(boolean z10, VlionSensorPara vlionSensorPara, VlionADClickType vlionADClickType) {
        HashMap<String, String> hashMap;
        String str;
        String valueOf;
        try {
            HashMap<String, String> hashMap2 = this.AllParameter;
            if (hashMap2 != null) {
                if (z10) {
                    hashMap2.put("__SLD__", "2");
                    this.AllParameter.put("__X_MAX_ACC__", String.valueOf(vlionSensorPara.getSpeedX()));
                    this.AllParameter.put("__Y_MAX_ACC__", String.valueOf(vlionSensorPara.getSpeedY()));
                    hashMap = this.AllParameter;
                    str = "__Z_MAX_ACC__";
                    valueOf = String.valueOf(vlionSensorPara.getSpeedZ());
                } else {
                    hashMap2.put("__SLD__", "5");
                    this.AllParameter.put("__TURN_X__", String.valueOf(vlionSensorPara.getRotateX()));
                    this.AllParameter.put("__TURN_Y__", String.valueOf(vlionSensorPara.getRotateY()));
                    this.AllParameter.put("__TURN_Z__", String.valueOf(vlionSensorPara.getRotateZ()));
                    hashMap = this.AllParameter;
                    str = "__TURN_TIME__";
                    valueOf = String.valueOf(vlionSensorPara.getRotateTime());
                }
                hashMap.put(str, valueOf);
                this.AllParameter.put("__CLICK_MODE__", "2");
                this.AllParameter.put("__DP_RESULT__", "1");
                this.AllParameter.put("__CALL_RESULT__", "2");
                if (vlionADClickType != null && vlionADClickType.getTarget().equals(VlionCustomAdActiveType$VlionCustomTarget.deeplink.toString())) {
                    this.AllParameter.put("__DP_RESULT__", "0");
                    this.AllParameter.put("__CALL_RESULT__", "1");
                }
                this.AllParameter.put("__TS_CUSTOM_V1__", new SimpleDateFormat("yyyyMMddHHmmssSSS").format(Long.valueOf(System.currentTimeMillis())));
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }
}
