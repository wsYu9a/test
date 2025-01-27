package com.jd.ad.sdk.jad_mx;

import androidx.annotation.NonNull;
import com.jd.ad.sdk.jad_kv.jad_dq;
import com.jd.ad.sdk.jad_mx.jad_fs;
import com.jd.ad.sdk.jad_qb.jad_na;
import java.io.File;
import java.util.List;

/* loaded from: classes2.dex */
public class jad_cp implements jad_fs, jad_dq.jad_an<Object> {
    public final List<com.jd.ad.sdk.jad_ju.jad_hu> jad_an;
    public final jad_jt<?> jad_bo;
    public final jad_fs.jad_an jad_cp;
    public int jad_dq = -1;
    public com.jd.ad.sdk.jad_ju.jad_hu jad_er;
    public List<com.jd.ad.sdk.jad_qb.jad_na<File, ?>> jad_fs;
    public volatile jad_na.jad_an<?> jad_hu;
    public File jad_iv;
    public int jad_jt;

    public jad_cp(List<com.jd.ad.sdk.jad_ju.jad_hu> list, jad_jt<?> jad_jtVar, jad_fs.jad_an jad_anVar) {
        this.jad_an = list;
        this.jad_bo = jad_jtVar;
        this.jad_cp = jad_anVar;
    }

    @Override // com.jd.ad.sdk.jad_kv.jad_dq.jad_an
    public void jad_an(@NonNull Exception exc) {
        this.jad_cp.jad_an(this.jad_er, exc, this.jad_hu.jad_cp, com.jd.ad.sdk.jad_ju.jad_an.DATA_DISK_CACHE);
    }

    @Override // com.jd.ad.sdk.jad_mx.jad_fs
    public void jad_cp() {
        jad_na.jad_an<?> jad_anVar = this.jad_hu;
        if (jad_anVar != null) {
            jad_anVar.jad_cp.jad_cp();
        }
    }

    @Override // com.jd.ad.sdk.jad_kv.jad_dq.jad_an
    public void jad_an(Object obj) {
        this.jad_cp.jad_an(this.jad_er, obj, this.jad_hu.jad_cp, com.jd.ad.sdk.jad_ju.jad_an.DATA_DISK_CACHE, this.jad_er);
    }

    @Override // com.jd.ad.sdk.jad_mx.jad_fs
    public boolean jad_an() {
        while (true) {
            List<com.jd.ad.sdk.jad_qb.jad_na<File, ?>> list = this.jad_fs;
            boolean z10 = false;
            if (list != null && this.jad_jt < list.size()) {
                this.jad_hu = null;
                while (!z10 && this.jad_jt < this.jad_fs.size()) {
                    List<com.jd.ad.sdk.jad_qb.jad_na<File, ?>> list2 = this.jad_fs;
                    int i10 = this.jad_jt;
                    this.jad_jt = i10 + 1;
                    com.jd.ad.sdk.jad_qb.jad_na<File, ?> jad_naVar = list2.get(i10);
                    File file = this.jad_iv;
                    jad_jt<?> jad_jtVar = this.jad_bo;
                    this.jad_hu = jad_naVar.jad_an(file, jad_jtVar.jad_er, jad_jtVar.jad_fs, jad_jtVar.jad_iv);
                    if (this.jad_hu != null && this.jad_bo.jad_cp(this.jad_hu.jad_cp.jad_an())) {
                        this.jad_hu.jad_cp.jad_an(this.jad_bo.jad_ob, this);
                        z10 = true;
                    }
                }
                return z10;
            }
            int i11 = this.jad_dq + 1;
            this.jad_dq = i11;
            if (i11 >= this.jad_an.size()) {
                return false;
            }
            com.jd.ad.sdk.jad_ju.jad_hu jad_huVar = this.jad_an.get(this.jad_dq);
            jad_jt<?> jad_jtVar2 = this.jad_bo;
            File jad_an = jad_jtVar2.jad_bo().jad_an(new jad_dq(jad_huVar, jad_jtVar2.jad_na));
            this.jad_iv = jad_an;
            if (jad_an != null) {
                this.jad_er = jad_huVar;
                this.jad_fs = this.jad_bo.jad_cp.jad_bo.jad_an((com.jd.ad.sdk.jad_gr.jad_hu) jad_an);
                this.jad_jt = 0;
            }
        }
    }
}
