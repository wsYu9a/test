package com.jd.ad.sdk.jad_nw;

import android.annotation.TargetApi;
import android.graphics.Matrix;
import android.graphics.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

@TargetApi(19)
/* loaded from: classes2.dex */
public class jad_ly implements jad_mz, jad_jw {
    public final String jad_dq;
    public final com.jd.ad.sdk.jad_sb.jad_iv jad_fs;
    public final Path jad_an = new Path();
    public final Path jad_bo = new Path();
    public final Path jad_cp = new Path();
    public final List<jad_mz> jad_er = new ArrayList();

    public jad_ly(com.jd.ad.sdk.jad_sb.jad_iv jad_ivVar) {
        this.jad_dq = jad_ivVar.jad_an();
        this.jad_fs = jad_ivVar;
    }

    @Override // com.jd.ad.sdk.jad_nw.jad_cp
    public void jad_an(List<jad_cp> list, List<jad_cp> list2) {
        for (int i10 = 0; i10 < this.jad_er.size(); i10++) {
            this.jad_er.get(i10).jad_an(list, list2);
        }
    }

    @Override // com.jd.ad.sdk.jad_nw.jad_mz
    public Path jad_bo() {
        Path.Op op;
        this.jad_cp.reset();
        com.jd.ad.sdk.jad_sb.jad_iv jad_ivVar = this.jad_fs;
        if (jad_ivVar.jad_cp) {
            return this.jad_cp;
        }
        int jad_an = com.jd.ad.sdk.jad_jt.jad_fs.jad_an(jad_ivVar.jad_bo);
        if (jad_an != 0) {
            if (jad_an == 1) {
                op = Path.Op.UNION;
            } else if (jad_an == 2) {
                op = Path.Op.REVERSE_DIFFERENCE;
            } else if (jad_an == 3) {
                op = Path.Op.INTERSECT;
            } else if (jad_an == 4) {
                op = Path.Op.XOR;
            }
            jad_an(op);
        } else {
            for (int i10 = 0; i10 < this.jad_er.size(); i10++) {
                this.jad_cp.addPath(this.jad_er.get(i10).jad_bo());
            }
        }
        return this.jad_cp;
    }

    @Override // com.jd.ad.sdk.jad_nw.jad_cp
    public String jad_cp() {
        return this.jad_dq;
    }

    @Override // com.jd.ad.sdk.jad_nw.jad_jw
    public void jad_an(ListIterator<jad_cp> listIterator) {
        while (listIterator.hasPrevious() && listIterator.previous() != this) {
        }
        while (listIterator.hasPrevious()) {
            jad_cp previous = listIterator.previous();
            if (previous instanceof jad_mz) {
                this.jad_er.add((jad_mz) previous);
                listIterator.remove();
            }
        }
    }

    @TargetApi(19)
    public final void jad_an(Path.Op op) {
        Matrix matrix;
        Matrix matrix2;
        this.jad_bo.reset();
        this.jad_an.reset();
        for (int size = this.jad_er.size() - 1; size >= 1; size--) {
            jad_mz jad_mzVar = this.jad_er.get(size);
            if (jad_mzVar instanceof jad_dq) {
                jad_dq jad_dqVar = (jad_dq) jad_mzVar;
                List<jad_mz> jad_dq = jad_dqVar.jad_dq();
                for (int size2 = jad_dq.size() - 1; size2 >= 0; size2--) {
                    Path jad_bo = jad_dq.get(size2).jad_bo();
                    com.jd.ad.sdk.jad_ox.jad_pc jad_pcVar = jad_dqVar.jad_kx;
                    if (jad_pcVar != null) {
                        matrix2 = jad_pcVar.jad_bo();
                    } else {
                        jad_dqVar.jad_cp.reset();
                        matrix2 = jad_dqVar.jad_cp;
                    }
                    jad_bo.transform(matrix2);
                    this.jad_bo.addPath(jad_bo);
                }
            } else {
                this.jad_bo.addPath(jad_mzVar.jad_bo());
            }
        }
        jad_mz jad_mzVar2 = this.jad_er.get(0);
        if (jad_mzVar2 instanceof jad_dq) {
            jad_dq jad_dqVar2 = (jad_dq) jad_mzVar2;
            List<jad_mz> jad_dq2 = jad_dqVar2.jad_dq();
            for (int i10 = 0; i10 < jad_dq2.size(); i10++) {
                Path jad_bo2 = jad_dq2.get(i10).jad_bo();
                com.jd.ad.sdk.jad_ox.jad_pc jad_pcVar2 = jad_dqVar2.jad_kx;
                if (jad_pcVar2 != null) {
                    matrix = jad_pcVar2.jad_bo();
                } else {
                    jad_dqVar2.jad_cp.reset();
                    matrix = jad_dqVar2.jad_cp;
                }
                jad_bo2.transform(matrix);
                this.jad_an.addPath(jad_bo2);
            }
        } else {
            this.jad_an.set(jad_mzVar2.jad_bo());
        }
        this.jad_cp.op(this.jad_an, this.jad_bo, op);
    }
}
