package com.jd.ad.sdk.jad_hu;

import android.content.Context;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import com.jd.ad.sdk.bl.dynamicrender.DynamicRenderView;
import com.jd.ad.sdk.dl.common.CommonConstants;
import com.jd.ad.sdk.fdt.utils.ScreenUtils;

/* loaded from: classes2.dex */
public class jad_iv implements View.OnTouchListener {
    public String jad_an = "";
    public String jad_bo = "";
    public int jad_cp;
    public int jad_dq;
    public final /* synthetic */ Context jad_er;
    public final /* synthetic */ DynamicRenderView jad_fs;

    public jad_iv(DynamicRenderView dynamicRenderView, Context context) {
        this.jad_fs = dynamicRenderView;
        this.jad_er = context;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z10;
        int x10 = (int) motionEvent.getX();
        int y10 = (int) motionEvent.getY();
        int action = motionEvent.getAction();
        if (action == 0) {
            this.jad_an = DynamicRenderView.jad_an(this.jad_fs, x10, y10);
            this.jad_cp = x10;
            this.jad_dq = y10;
            return false;
        }
        if (action != 1) {
            return false;
        }
        DynamicRenderView dynamicRenderView = this.jad_fs;
        Context context = this.jad_er;
        float f10 = this.jad_cp;
        float f11 = this.jad_dq;
        float f12 = x10;
        float f13 = y10;
        float f14 = dynamicRenderView.jad_kv;
        float f15 = dynamicRenderView.jad_ny;
        if (context != null) {
            float f16 = f12 - f10;
            float f17 = f13 - f11;
            if (f14 <= 0.0f) {
                f14 = 1.0f;
            }
            if (f15 <= 0.0f) {
                f15 = 45.0f;
            }
            float sqrt = (float) Math.sqrt(Math.pow(f17, 2.0d) + Math.pow(f16, 2.0d));
            float degrees = (float) Math.toDegrees(Math.atan2(Math.abs(f17), Math.abs(f16)));
            float f18 = 180.0f - f15;
            if (f17 < 0.0f && sqrt > ScreenUtils.dip2px(context, f14) && degrees >= f15 && degrees <= f18) {
                z10 = true;
                this.jad_bo = DynamicRenderView.jad_an(this.jad_fs, x10, y10);
                if (!TextUtils.isEmpty(this.jad_an) || TextUtils.isEmpty(this.jad_bo) || !this.jad_an.equals(this.jad_bo)) {
                    if (this.jad_fs.jad_jt != 3 && z10) {
                        int ordinal = CommonConstants.AdTriggerSourceType.SLIDE_UP.ordinal();
                        DynamicRenderView dynamicRenderView2 = this.jad_fs;
                        jad_an jad_anVar = dynamicRenderView2.jad_wj.get(dynamicRenderView2.jad_xk);
                        if (jad_anVar == null) {
                            return false;
                        }
                        jad_anVar.jad_dq = ordinal;
                        jad_anVar.jad_an(view);
                        return true;
                    }
                }
                if (this.jad_bo.equals("sdkInteractiveShake")) {
                    return false;
                }
                jad_an jad_anVar2 = this.jad_fs.jad_wj.get(this.jad_bo);
                int ordinal2 = CommonConstants.AdTriggerSourceType.CLICK.ordinal();
                if (!TextUtils.isEmpty(this.jad_an) && this.jad_an.equals(this.jad_fs.jad_xk) && this.jad_fs.jad_jt == 3 && z10) {
                    ordinal2 = CommonConstants.AdTriggerSourceType.SLIDE_UP.ordinal();
                }
                if (jad_anVar2 == null) {
                    return false;
                }
                jad_anVar2.jad_dq = ordinal2;
                jad_anVar2.jad_an(view);
                return true;
            }
        }
        z10 = false;
        this.jad_bo = DynamicRenderView.jad_an(this.jad_fs, x10, y10);
        if (!TextUtils.isEmpty(this.jad_an)) {
        }
        return this.jad_fs.jad_jt != 3 ? false : false;
    }
}
