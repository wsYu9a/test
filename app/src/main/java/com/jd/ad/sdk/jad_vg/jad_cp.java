package com.jd.ad.sdk.jad_vg;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import com.jd.ad.sdk.jad_ir.jad_kx;
import com.jd.ad.sdk.jad_mx.jad_tg;
import com.jd.ad.sdk.jad_mx.jad_xk;

/* loaded from: classes2.dex */
public abstract class jad_cp<T extends Drawable> implements jad_xk<T>, jad_tg {
    public final T jad_an;

    public jad_cp(T t10) {
        this.jad_an = (T) jad_kx.jad_an(t10);
    }

    @Override // com.jd.ad.sdk.jad_mx.jad_xk
    @NonNull
    public Object get() {
        Drawable.ConstantState constantState = this.jad_an.getConstantState();
        return constantState == null ? this.jad_an : constantState.newDrawable();
    }

    @Override // com.jd.ad.sdk.jad_mx.jad_tg
    public void jad_an() {
        Bitmap jad_bo;
        T t10 = this.jad_an;
        if (t10 instanceof BitmapDrawable) {
            jad_bo = ((BitmapDrawable) t10).getBitmap();
        } else if (!(t10 instanceof com.jd.ad.sdk.jad_xi.jad_cp)) {
            return;
        } else {
            jad_bo = ((com.jd.ad.sdk.jad_xi.jad_cp) t10).jad_bo();
        }
        jad_bo.prepareToDraw();
    }
}
