package cn.vlion.ad.inland.base.util.handle;

import cn.vlion.ad.inland.ad.javabean.VlionCustomParseAdData;
import cn.vlion.ad.inland.base.i0;
import cn.vlion.ad.inland.base.javabean.VlionADClickType;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import java.util.HashMap;

/* loaded from: classes.dex */
public class VlionSwipeParameterReplace extends VlionClickParameterReplace {
    public VlionSwipeParameterReplace(VlionCustomParseAdData vlionCustomParseAdData) {
        super(vlionCustomParseAdData);
    }

    @Override // cn.vlion.ad.inland.base.util.handle.VlionClickParameterReplace, cn.vlion.ad.inland.base.util.handle.VlionBaseParameterReplace
    public String handleReplace(String str) {
        return super.handleReplace(str);
    }

    @Override // cn.vlion.ad.inland.base.util.handle.VlionBaseParameterReplace
    public void handleSwipeParameter(i0 i0Var, VlionADClickType vlionADClickType) {
        super.handleClickParameter(i0Var, vlionADClickType);
        try {
            HashMap<String, String> hashMap = this.AllParameter;
            if (hashMap != null) {
                hashMap.put("__SLD__", "3");
                this.AllParameter.put("__CLICK_MODE__", "3");
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }
}
