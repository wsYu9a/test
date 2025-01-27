package com.jd.ad.sdk.jad_nw;

import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import androidx.annotation.Nullable;
import com.jd.ad.sdk.jad_ox.jad_an;
import java.util.List;

/* loaded from: classes2.dex */
public class jad_ob implements jad_an.InterfaceC0340jad_an, jad_kx, jad_mz {
    public final String jad_cp;
    public final boolean jad_dq;
    public final com.jd.ad.sdk.jad_lu.jad_mz jad_er;
    public final com.jd.ad.sdk.jad_ox.jad_an<?, PointF> jad_fs;
    public final com.jd.ad.sdk.jad_ox.jad_an<?, Float> jad_hu;
    public final com.jd.ad.sdk.jad_ox.jad_an<?, PointF> jad_jt;
    public boolean jad_jw;
    public final Path jad_an = new Path();
    public final RectF jad_bo = new RectF();
    public final jad_bo jad_iv = new jad_bo();

    public jad_ob(com.jd.ad.sdk.jad_lu.jad_mz jad_mzVar, com.jd.ad.sdk.jad_tc.jad_an jad_anVar, com.jd.ad.sdk.jad_sb.jad_ly jad_lyVar) {
        this.jad_cp = jad_lyVar.jad_bo();
        this.jad_dq = jad_lyVar.jad_er();
        this.jad_er = jad_mzVar;
        com.jd.ad.sdk.jad_ox.jad_an<PointF, PointF> jad_an = jad_lyVar.jad_cp().jad_an();
        this.jad_fs = jad_an;
        com.jd.ad.sdk.jad_ox.jad_an<PointF, PointF> jad_an2 = jad_lyVar.jad_dq().jad_an();
        this.jad_jt = jad_an2;
        com.jd.ad.sdk.jad_ox.jad_an<Float, Float> jad_an3 = jad_lyVar.jad_an().jad_an();
        this.jad_hu = jad_an3;
        jad_anVar.jad_an(jad_an);
        jad_anVar.jad_an(jad_an2);
        jad_anVar.jad_an(jad_an3);
        jad_an.jad_an(this);
        jad_an2.jad_an(this);
        jad_an3.jad_an(this);
    }

    @Override // com.jd.ad.sdk.jad_qz.jad_fs
    public void jad_an(com.jd.ad.sdk.jad_qz.jad_er jad_erVar, int i10, List<com.jd.ad.sdk.jad_qz.jad_er> list, com.jd.ad.sdk.jad_qz.jad_er jad_erVar2) {
        com.jd.ad.sdk.jad_xg.jad_jt.jad_an(jad_erVar, i10, list, jad_erVar2, this);
    }

    @Override // com.jd.ad.sdk.jad_nw.jad_mz
    public Path jad_bo() {
        if (this.jad_jw) {
            return this.jad_an;
        }
        this.jad_an.reset();
        if (!this.jad_dq) {
            PointF jad_fs = this.jad_jt.jad_fs();
            float f10 = jad_fs.x / 2.0f;
            float f11 = jad_fs.y / 2.0f;
            com.jd.ad.sdk.jad_ox.jad_an<?, Float> jad_anVar = this.jad_hu;
            float jad_hu = jad_anVar == null ? 0.0f : ((com.jd.ad.sdk.jad_ox.jad_dq) jad_anVar).jad_hu();
            float min = Math.min(f10, f11);
            if (jad_hu > min) {
                jad_hu = min;
            }
            PointF jad_fs2 = this.jad_fs.jad_fs();
            this.jad_an.moveTo(jad_fs2.x + f10, (jad_fs2.y - f11) + jad_hu);
            this.jad_an.lineTo(jad_fs2.x + f10, (jad_fs2.y + f11) - jad_hu);
            if (jad_hu > 0.0f) {
                RectF rectF = this.jad_bo;
                float f12 = jad_fs2.x + f10;
                float f13 = jad_hu * 2.0f;
                float f14 = jad_fs2.y + f11;
                rectF.set(f12 - f13, f14 - f13, f12, f14);
                this.jad_an.arcTo(this.jad_bo, 0.0f, 90.0f, false);
            }
            this.jad_an.lineTo((jad_fs2.x - f10) + jad_hu, jad_fs2.y + f11);
            if (jad_hu > 0.0f) {
                RectF rectF2 = this.jad_bo;
                float f15 = jad_fs2.x - f10;
                float f16 = jad_fs2.y + f11;
                float f17 = jad_hu * 2.0f;
                rectF2.set(f15, f16 - f17, f17 + f15, f16);
                this.jad_an.arcTo(this.jad_bo, 90.0f, 90.0f, false);
            }
            this.jad_an.lineTo(jad_fs2.x - f10, (jad_fs2.y - f11) + jad_hu);
            if (jad_hu > 0.0f) {
                RectF rectF3 = this.jad_bo;
                float f18 = jad_fs2.x - f10;
                float f19 = jad_fs2.y - f11;
                float f20 = jad_hu * 2.0f;
                rectF3.set(f18, f19, f18 + f20, f20 + f19);
                this.jad_an.arcTo(this.jad_bo, 180.0f, 90.0f, false);
            }
            this.jad_an.lineTo((jad_fs2.x + f10) - jad_hu, jad_fs2.y - f11);
            if (jad_hu > 0.0f) {
                RectF rectF4 = this.jad_bo;
                float f21 = jad_fs2.x + f10;
                float f22 = jad_hu * 2.0f;
                float f23 = jad_fs2.y - f11;
                rectF4.set(f21 - f22, f23, f21, f22 + f23);
                this.jad_an.arcTo(this.jad_bo, 270.0f, 90.0f, false);
            }
            this.jad_an.close();
            this.jad_iv.jad_an(this.jad_an);
        }
        this.jad_jw = true;
        return this.jad_an;
    }

    @Override // com.jd.ad.sdk.jad_nw.jad_cp
    public String jad_cp() {
        return this.jad_cp;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.jd.ad.sdk.jad_qz.jad_fs
    public <T> void jad_an(T t10, @Nullable com.jd.ad.sdk.jad_yh.jad_cp<T> jad_cpVar) {
        com.jd.ad.sdk.jad_ox.jad_an jad_anVar;
        if (t10 == com.jd.ad.sdk.jad_lu.jad_re.jad_ly) {
            jad_anVar = this.jad_jt;
        } else if (t10 == com.jd.ad.sdk.jad_lu.jad_re.jad_na) {
            jad_anVar = this.jad_fs;
        } else if (t10 != com.jd.ad.sdk.jad_lu.jad_re.jad_mz) {
            return;
        } else {
            jad_anVar = this.jad_hu;
        }
        jad_anVar.jad_er = jad_cpVar;
    }

    @Override // com.jd.ad.sdk.jad_ox.jad_an.InterfaceC0340jad_an
    public void jad_an() {
        this.jad_jw = false;
        this.jad_er.invalidateSelf();
    }

    @Override // com.jd.ad.sdk.jad_nw.jad_cp
    public void jad_an(List<jad_cp> list, List<jad_cp> list2) {
        for (int i10 = 0; i10 < list.size(); i10++) {
            jad_cp jad_cpVar = list.get(i10);
            if (jad_cpVar instanceof jad_sf) {
                jad_sf jad_sfVar = (jad_sf) jad_cpVar;
                if (jad_sfVar.jad_dq == 1) {
                    this.jad_iv.jad_an.add(jad_sfVar);
                    jad_sfVar.jad_cp.add(this);
                }
            }
        }
    }
}
