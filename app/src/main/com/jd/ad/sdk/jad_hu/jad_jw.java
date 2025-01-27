package com.jd.ad.sdk.jad_hu;

import android.content.Context;
import com.jd.ad.sdk.bl.dynamicrender.DynamicRenderView;
import com.jd.ad.sdk.bl.dynamicrender.ShakeListener;
import com.jd.ad.sdk.dl.common.CommonConstants;
import com.jd.ad.sdk.logger.Logger;

/* loaded from: classes2.dex */
public class jad_jw extends ShakeListener {
    public final /* synthetic */ DynamicRenderView jad_na;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public jad_jw(DynamicRenderView dynamicRenderView, Context context, float f10, float f11, float f12) {
        super(context, f10, f11, f12);
        this.jad_na = dynamicRenderView;
    }

    @Override // com.jd.ad.sdk.bl.dynamicrender.ShakeListener
    public void onShake() {
        DynamicRenderView dynamicRenderView = this.jad_na;
        boolean jad_an = DynamicRenderView.jad_an(dynamicRenderView, dynamicRenderView.jad_sf);
        Logger.d("==== 摇一摇: " + jad_an);
        if (jad_an) {
            DynamicRenderView dynamicRenderView2 = this.jad_na;
            jad_an jad_anVar = dynamicRenderView2.jad_wj.get(dynamicRenderView2.jad_xk);
            if (jad_anVar != null) {
                DynamicRenderView dynamicRenderView3 = this.jad_na;
                float f10 = dynamicRenderView3.jad_ju;
                float f11 = dynamicRenderView3.jad_lw;
                float f12 = dynamicRenderView3.jad_mx;
                CommonConstants.AdTriggerSourceType adTriggerSourceType = CommonConstants.AdTriggerSourceType.SHAKE;
                int ordinal = adTriggerSourceType.ordinal();
                if (f12 > 0.0f) {
                    if (f10 > 0.0f && f11 > 0.0f) {
                        ordinal = CommonConstants.AdTriggerSourceType.SHAKE_ALL.ordinal();
                    } else if (f10 > 0.0f) {
                        ordinal = CommonConstants.AdTriggerSourceType.SHAKE_ACCELERATION_TIME.ordinal();
                    } else if (f11 > 0.0f) {
                        ordinal = CommonConstants.AdTriggerSourceType.SHAKE_ANGLE_TIME.ordinal();
                    }
                } else if (f10 > 0.0f && f11 > 0.0f) {
                    ordinal = CommonConstants.AdTriggerSourceType.SHAKE_ACCELERATION_ANGLE.ordinal();
                } else if (f10 > 0.0f) {
                    ordinal = adTriggerSourceType.ordinal();
                } else if (f11 > 0.0f) {
                    ordinal = CommonConstants.AdTriggerSourceType.SHAKE_ANGLE.ordinal();
                }
                jad_anVar.jad_dq = ordinal;
                jad_anVar.jad_an(this.jad_na.jad_sf);
            }
        }
    }
}
