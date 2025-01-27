package com.jd.ad.sdk.jad_nw;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import androidx.annotation.Nullable;
import com.jd.ad.sdk.jad_ox.jad_an;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class jad_dq implements jad_er, jad_mz, jad_an.InterfaceC0340jad_an, com.jd.ad.sdk.jad_qz.jad_fs {
    public final Paint jad_an;
    public final RectF jad_bo;
    public final Matrix jad_cp;
    public final Path jad_dq;
    public final RectF jad_er;
    public final String jad_fs;
    public final List<jad_cp> jad_hu;
    public final com.jd.ad.sdk.jad_lu.jad_mz jad_iv;
    public final boolean jad_jt;

    @Nullable
    public List<jad_mz> jad_jw;

    @Nullable
    public com.jd.ad.sdk.jad_ox.jad_pc jad_kx;

    public jad_dq(com.jd.ad.sdk.jad_lu.jad_mz jad_mzVar, com.jd.ad.sdk.jad_tc.jad_an jad_anVar, com.jd.ad.sdk.jad_sb.jad_pc jad_pcVar) {
        this(jad_mzVar, jad_anVar, jad_pcVar.jad_bo(), jad_pcVar.jad_cp(), jad_an(jad_mzVar, jad_anVar, jad_pcVar.jad_an()), jad_an(jad_pcVar.jad_an()));
    }

    @Nullable
    public static com.jd.ad.sdk.jad_ra.jad_ly jad_an(List<com.jd.ad.sdk.jad_sb.jad_cp> list) {
        for (int i10 = 0; i10 < list.size(); i10++) {
            com.jd.ad.sdk.jad_sb.jad_cp jad_cpVar = list.get(i10);
            if (jad_cpVar instanceof com.jd.ad.sdk.jad_ra.jad_ly) {
                return (com.jd.ad.sdk.jad_ra.jad_ly) jad_cpVar;
            }
        }
        return null;
    }

    @Override // com.jd.ad.sdk.jad_nw.jad_mz
    public Path jad_bo() {
        this.jad_cp.reset();
        com.jd.ad.sdk.jad_ox.jad_pc jad_pcVar = this.jad_kx;
        if (jad_pcVar != null) {
            this.jad_cp.set(jad_pcVar.jad_bo());
        }
        this.jad_dq.reset();
        if (this.jad_jt) {
            return this.jad_dq;
        }
        for (int size = this.jad_hu.size() - 1; size >= 0; size--) {
            jad_cp jad_cpVar = this.jad_hu.get(size);
            if (jad_cpVar instanceof jad_mz) {
                this.jad_dq.addPath(((jad_mz) jad_cpVar).jad_bo(), this.jad_cp);
            }
        }
        return this.jad_dq;
    }

    @Override // com.jd.ad.sdk.jad_nw.jad_cp
    public String jad_cp() {
        return this.jad_fs;
    }

    public List<jad_mz> jad_dq() {
        if (this.jad_jw == null) {
            this.jad_jw = new ArrayList();
            for (int i10 = 0; i10 < this.jad_hu.size(); i10++) {
                jad_cp jad_cpVar = this.jad_hu.get(i10);
                if (jad_cpVar instanceof jad_mz) {
                    this.jad_jw.add((jad_mz) jad_cpVar);
                }
            }
        }
        return this.jad_jw;
    }

    public jad_dq(com.jd.ad.sdk.jad_lu.jad_mz jad_mzVar, com.jd.ad.sdk.jad_tc.jad_an jad_anVar, String str, boolean z10, List<jad_cp> list, @Nullable com.jd.ad.sdk.jad_ra.jad_ly jad_lyVar) {
        this.jad_an = new com.jd.ad.sdk.jad_mv.jad_an();
        this.jad_bo = new RectF();
        this.jad_cp = new Matrix();
        this.jad_dq = new Path();
        this.jad_er = new RectF();
        this.jad_fs = str;
        this.jad_iv = jad_mzVar;
        this.jad_jt = z10;
        this.jad_hu = list;
        if (jad_lyVar != null) {
            com.jd.ad.sdk.jad_ox.jad_pc jad_an = jad_lyVar.jad_an();
            this.jad_kx = jad_an;
            jad_an.jad_an(jad_anVar);
            this.jad_kx.jad_an(this);
        }
        ArrayList arrayList = new ArrayList();
        for (int size = list.size() - 1; size >= 0; size--) {
            jad_cp jad_cpVar = list.get(size);
            if (jad_cpVar instanceof jad_jw) {
                arrayList.add((jad_jw) jad_cpVar);
            }
        }
        for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
            ((jad_jw) arrayList.get(size2)).jad_an(list.listIterator(list.size()));
        }
    }

    public static List<jad_cp> jad_an(com.jd.ad.sdk.jad_lu.jad_mz jad_mzVar, com.jd.ad.sdk.jad_tc.jad_an jad_anVar, List<com.jd.ad.sdk.jad_sb.jad_cp> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (int i10 = 0; i10 < list.size(); i10++) {
            jad_cp jad_an = list.get(i10).jad_an(jad_mzVar, jad_anVar);
            if (jad_an != null) {
                arrayList.add(jad_an);
            }
        }
        return arrayList;
    }

    @Override // com.jd.ad.sdk.jad_ox.jad_an.InterfaceC0340jad_an
    public void jad_an() {
        this.jad_iv.invalidateSelf();
    }

    @Override // com.jd.ad.sdk.jad_nw.jad_er
    public void jad_an(RectF rectF, Matrix matrix, boolean z10) {
        this.jad_cp.set(matrix);
        com.jd.ad.sdk.jad_ox.jad_pc jad_pcVar = this.jad_kx;
        if (jad_pcVar != null) {
            this.jad_cp.preConcat(jad_pcVar.jad_bo());
        }
        this.jad_er.set(0.0f, 0.0f, 0.0f, 0.0f);
        for (int size = this.jad_hu.size() - 1; size >= 0; size--) {
            jad_cp jad_cpVar = this.jad_hu.get(size);
            if (jad_cpVar instanceof jad_er) {
                ((jad_er) jad_cpVar).jad_an(this.jad_er, this.jad_cp, z10);
                rectF.union(this.jad_er);
            }
        }
    }

    @Override // com.jd.ad.sdk.jad_qz.jad_fs
    public <T> void jad_an(T t10, @Nullable com.jd.ad.sdk.jad_yh.jad_cp<T> jad_cpVar) {
        com.jd.ad.sdk.jad_ox.jad_pc jad_pcVar = this.jad_kx;
        if (jad_pcVar != null) {
            jad_pcVar.jad_an(t10, jad_cpVar);
        }
    }

    @Override // com.jd.ad.sdk.jad_nw.jad_cp
    public void jad_an(List<jad_cp> list, List<jad_cp> list2) {
        ArrayList arrayList = new ArrayList(this.jad_hu.size() + list.size());
        arrayList.addAll(list);
        for (int size = this.jad_hu.size() - 1; size >= 0; size--) {
            jad_cp jad_cpVar = this.jad_hu.get(size);
            jad_cpVar.jad_an(arrayList, this.jad_hu.subList(0, size));
            arrayList.add(jad_cpVar);
        }
    }

    @Override // com.jd.ad.sdk.jad_nw.jad_er
    public void jad_an(Canvas canvas, Matrix matrix, int i10) {
        if (this.jad_jt) {
            return;
        }
        this.jad_cp.set(matrix);
        com.jd.ad.sdk.jad_ox.jad_pc jad_pcVar = this.jad_kx;
        if (jad_pcVar != null) {
            this.jad_cp.preConcat(jad_pcVar.jad_bo());
            i10 = (int) (((((this.jad_kx.jad_jw == null ? 100 : r7.jad_fs().intValue()) / 100.0f) * i10) / 255.0f) * 255.0f);
        }
        boolean z10 = false;
        if (this.jad_iv.jad_sf) {
            int i11 = 0;
            int i12 = 0;
            while (true) {
                if (i11 >= this.jad_hu.size()) {
                    break;
                }
                if (!(this.jad_hu.get(i11) instanceof jad_er) || (i12 = i12 + 1) < 2) {
                    i11++;
                } else if (i10 != 255) {
                    z10 = true;
                }
            }
        }
        if (z10) {
            this.jad_bo.set(0.0f, 0.0f, 0.0f, 0.0f);
            jad_an(this.jad_bo, this.jad_cp, true);
            this.jad_an.setAlpha(i10);
            com.jd.ad.sdk.jad_xg.jad_hu.jad_an(canvas, this.jad_bo, this.jad_an, 31);
        }
        if (z10) {
            i10 = 255;
        }
        for (int size = this.jad_hu.size() - 1; size >= 0; size--) {
            jad_cp jad_cpVar = this.jad_hu.get(size);
            if (jad_cpVar instanceof jad_er) {
                ((jad_er) jad_cpVar).jad_an(canvas, this.jad_cp, i10);
            }
        }
        if (z10) {
            canvas.restore();
        }
    }

    @Override // com.jd.ad.sdk.jad_qz.jad_fs
    public void jad_an(com.jd.ad.sdk.jad_qz.jad_er jad_erVar, int i10, List<com.jd.ad.sdk.jad_qz.jad_er> list, com.jd.ad.sdk.jad_qz.jad_er jad_erVar2) {
        if (jad_erVar.jad_cp(this.jad_fs, i10) || "__container".equals(this.jad_fs)) {
            if (!"__container".equals(this.jad_fs)) {
                jad_erVar2 = jad_erVar2.jad_an(this.jad_fs);
                if (jad_erVar.jad_an(this.jad_fs, i10)) {
                    list.add(jad_erVar2.jad_an(this));
                }
            }
            if (jad_erVar.jad_dq(this.jad_fs, i10)) {
                int jad_bo = jad_erVar.jad_bo(this.jad_fs, i10) + i10;
                for (int i11 = 0; i11 < this.jad_hu.size(); i11++) {
                    jad_cp jad_cpVar = this.jad_hu.get(i11);
                    if (jad_cpVar instanceof com.jd.ad.sdk.jad_qz.jad_fs) {
                        ((com.jd.ad.sdk.jad_qz.jad_fs) jad_cpVar).jad_an(jad_erVar, jad_bo, list, jad_erVar2);
                    }
                }
            }
        }
    }
}
