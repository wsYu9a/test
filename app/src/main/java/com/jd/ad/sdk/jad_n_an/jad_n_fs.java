package com.jd.ad.sdk.jad_n_an;

import android.view.MotionEvent;
import android.view.View;
import com.jd.ad.sdk.dl.common.CommonConstants;
import com.jd.ad.sdk.fdt.utils.ScreenUtils;

/* loaded from: classes2.dex */
public class jad_n_fs implements View.OnTouchListener {
    public final /* synthetic */ float[] jad_n_an;
    public final /* synthetic */ float[] jad_n_bo;
    public final /* synthetic */ float jad_n_cp;
    public final /* synthetic */ float jad_n_dq;
    public final /* synthetic */ jad_n_hu jad_n_er;

    public jad_n_fs(jad_n_hu jad_n_huVar, float[] fArr, float[] fArr2, float f10, float f11) {
        this.jad_n_er = jad_n_huVar;
        this.jad_n_an = fArr;
        this.jad_n_bo = fArr2;
        this.jad_n_cp = f10;
        this.jad_n_dq = f11;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.jad_n_an[0] = motionEvent.getX();
            this.jad_n_an[1] = motionEvent.getY();
            return true;
        }
        if (action == 1) {
            this.jad_n_bo[0] = motionEvent.getX();
            this.jad_n_bo[1] = motionEvent.getY();
            jad_n_hu jad_n_huVar = this.jad_n_er;
            float[] fArr = this.jad_n_an;
            float f10 = fArr[0];
            float f11 = fArr[1];
            float[] fArr2 = this.jad_n_bo;
            float f12 = fArr2[0];
            float f13 = fArr2[1];
            float f14 = this.jad_n_cp;
            float f15 = this.jad_n_dq;
            jad_n_huVar.getClass();
            float f16 = f12 - f10;
            float f17 = f13 - f11;
            if (f14 <= 0.0f) {
                f14 = 1.0f;
            }
            if (f15 <= 0.0f) {
                f15 = 45.0f;
            }
            float f18 = 180.0f - f15;
            float sqrt = (float) Math.sqrt(Math.pow(f17, 2.0d) + Math.pow(f16, 2.0d));
            float degrees = (float) Math.toDegrees(Math.atan2(Math.abs(f17), Math.abs(f16)));
            if (f17 < 0.0f && sqrt > ScreenUtils.dip2px(jad_n_huVar.jad_n_fs.getContext(), f14) && degrees >= f15 && degrees <= f18) {
                jad_n_huVar.jad_n_jw = CommonConstants.AdTriggerSourceType.SLIDE_UP.ordinal();
                jad_n_huVar.jad_n_bo(jad_n_huVar.jad_n_fs);
            }
        }
        return false;
    }
}
