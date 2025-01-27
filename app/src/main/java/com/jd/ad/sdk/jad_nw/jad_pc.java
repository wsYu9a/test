package com.jd.ad.sdk.jad_nw;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import androidx.annotation.Nullable;
import com.jd.ad.sdk.jad_ox.jad_an;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

/* loaded from: classes2.dex */
public class jad_pc implements jad_er, jad_mz, jad_jw, jad_an.InterfaceC0340jad_an, jad_kx {
    public final Matrix jad_an = new Matrix();
    public final Path jad_bo = new Path();
    public final com.jd.ad.sdk.jad_lu.jad_mz jad_cp;
    public final com.jd.ad.sdk.jad_tc.jad_an jad_dq;
    public final String jad_er;
    public final boolean jad_fs;
    public final com.jd.ad.sdk.jad_ox.jad_an<Float, Float> jad_hu;
    public final com.jd.ad.sdk.jad_ox.jad_pc jad_iv;
    public final com.jd.ad.sdk.jad_ox.jad_an<Float, Float> jad_jt;
    public jad_dq jad_jw;

    public jad_pc(com.jd.ad.sdk.jad_lu.jad_mz jad_mzVar, com.jd.ad.sdk.jad_tc.jad_an jad_anVar, com.jd.ad.sdk.jad_sb.jad_mz jad_mzVar2) {
        this.jad_cp = jad_mzVar;
        this.jad_dq = jad_anVar;
        this.jad_er = jad_mzVar2.jad_bo();
        this.jad_fs = jad_mzVar2.jad_er();
        com.jd.ad.sdk.jad_ox.jad_an<Float, Float> jad_an = jad_mzVar2.jad_an().jad_an();
        this.jad_jt = jad_an;
        jad_anVar.jad_an(jad_an);
        jad_an.jad_an(this);
        com.jd.ad.sdk.jad_ox.jad_an<Float, Float> jad_an2 = jad_mzVar2.jad_cp().jad_an();
        this.jad_hu = jad_an2;
        jad_anVar.jad_an(jad_an2);
        jad_an2.jad_an(this);
        com.jd.ad.sdk.jad_ox.jad_pc jad_an3 = jad_mzVar2.jad_dq().jad_an();
        this.jad_iv = jad_an3;
        jad_an3.jad_an(jad_anVar);
        jad_an3.jad_an(this);
    }

    @Override // com.jd.ad.sdk.jad_ox.jad_an.InterfaceC0340jad_an
    public void jad_an() {
        this.jad_cp.invalidateSelf();
    }

    @Override // com.jd.ad.sdk.jad_nw.jad_mz
    public Path jad_bo() {
        Path jad_bo = this.jad_jw.jad_bo();
        this.jad_bo.reset();
        float floatValue = this.jad_jt.jad_fs().floatValue();
        float floatValue2 = this.jad_hu.jad_fs().floatValue();
        for (int i10 = ((int) floatValue) - 1; i10 >= 0; i10--) {
            this.jad_an.set(this.jad_iv.jad_an(i10 + floatValue2));
            this.jad_bo.addPath(jad_bo, this.jad_an);
        }
        return this.jad_bo;
    }

    @Override // com.jd.ad.sdk.jad_nw.jad_cp
    public String jad_cp() {
        return this.jad_er;
    }

    @Override // com.jd.ad.sdk.jad_nw.jad_er
    public void jad_an(RectF rectF, Matrix matrix, boolean z10) {
        this.jad_jw.jad_an(rectF, matrix, z10);
    }

    @Override // com.jd.ad.sdk.jad_qz.jad_fs
    public void jad_an(com.jd.ad.sdk.jad_qz.jad_er jad_erVar, int i10, List<com.jd.ad.sdk.jad_qz.jad_er> list, com.jd.ad.sdk.jad_qz.jad_er jad_erVar2) {
        com.jd.ad.sdk.jad_xg.jad_jt.jad_an(jad_erVar, i10, list, jad_erVar2, this);
    }

    @Override // com.jd.ad.sdk.jad_nw.jad_cp
    public void jad_an(List<jad_cp> list, List<jad_cp> list2) {
        this.jad_jw.jad_an(list, list2);
    }

    @Override // com.jd.ad.sdk.jad_nw.jad_jw
    public void jad_an(ListIterator<jad_cp> listIterator) {
        if (this.jad_jw != null) {
            return;
        }
        while (listIterator.hasPrevious() && listIterator.previous() != this) {
        }
        ArrayList arrayList = new ArrayList();
        while (listIterator.hasPrevious()) {
            arrayList.add(listIterator.previous());
            listIterator.remove();
        }
        Collections.reverse(arrayList);
        this.jad_jw = new jad_dq(this.jad_cp, this.jad_dq, "Repeater", this.jad_fs, arrayList, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.jd.ad.sdk.jad_qz.jad_fs
    public <T> void jad_an(T t10, @Nullable com.jd.ad.sdk.jad_yh.jad_cp<T> jad_cpVar) {
        com.jd.ad.sdk.jad_ox.jad_an<Float, Float> jad_anVar;
        if (this.jad_iv.jad_an(t10, jad_cpVar)) {
            return;
        }
        if (t10 == com.jd.ad.sdk.jad_lu.jad_re.jad_uh) {
            jad_anVar = this.jad_jt;
        } else if (t10 != com.jd.ad.sdk.jad_lu.jad_re.jad_vi) {
            return;
        } else {
            jad_anVar = this.jad_hu;
        }
        jad_anVar.jad_er = jad_cpVar;
    }

    @Override // com.jd.ad.sdk.jad_nw.jad_er
    public void jad_an(Canvas canvas, Matrix matrix, int i10) {
        float floatValue = this.jad_jt.jad_fs().floatValue();
        float floatValue2 = this.jad_hu.jad_fs().floatValue();
        float floatValue3 = this.jad_iv.jad_mz.jad_fs().floatValue() / 100.0f;
        float floatValue4 = this.jad_iv.jad_na.jad_fs().floatValue() / 100.0f;
        for (int i11 = ((int) floatValue) - 1; i11 >= 0; i11--) {
            this.jad_an.set(matrix);
            float f10 = i11;
            this.jad_an.preConcat(this.jad_iv.jad_an(f10 + floatValue2));
            this.jad_jw.jad_an(canvas, this.jad_an, (int) (com.jd.ad.sdk.jad_xg.jad_jt.jad_an(floatValue3, floatValue4, f10 / floatValue) * i10));
        }
    }
}
