package com.jd.ad.sdk.jad_rc;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.jd.ad.sdk.jad_ir.jad_hu;
import com.jd.ad.sdk.jad_ju.jad_iv;
import com.jd.ad.sdk.jad_ju.jad_jw;
import com.jd.ad.sdk.jad_qb.jad_jt;
import com.jd.ad.sdk.jad_qb.jad_mz;
import com.jd.ad.sdk.jad_qb.jad_na;
import com.jd.ad.sdk.jad_qb.jad_ob;
import com.jd.ad.sdk.jad_qb.jad_re;
import java.io.InputStream;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Queue;

/* loaded from: classes2.dex */
public class jad_an implements jad_na<jad_jt, InputStream> {
    public static final jad_iv<Integer> jad_bo = jad_iv.jad_an("com.jd.ad.sdk.glide.load.model.stream.HttpGlideUrlLoader.Timeout", 2500);

    @Nullable
    public final jad_mz<jad_jt, jad_jt> jad_an;

    /* renamed from: com.jd.ad.sdk.jad_rc.jad_an$jad_an */
    public static class C0350jad_an implements jad_ob<jad_jt, InputStream> {
        public final jad_mz<jad_jt, jad_jt> jad_an = new jad_mz<>(500);

        @Override // com.jd.ad.sdk.jad_qb.jad_ob
        @NonNull
        public jad_na<jad_jt, InputStream> jad_an(jad_re jad_reVar) {
            return new jad_an(this.jad_an);
        }
    }

    public jad_an(@Nullable jad_mz<jad_jt, jad_jt> jad_mzVar) {
        this.jad_an = jad_mzVar;
    }

    @Override // com.jd.ad.sdk.jad_qb.jad_na
    public /* bridge */ /* synthetic */ boolean jad_an(@NonNull jad_jt jad_jtVar) {
        return true;
    }

    @Override // com.jd.ad.sdk.jad_qb.jad_na
    public jad_na.jad_an<InputStream> jad_an(@NonNull jad_jt jad_jtVar, int i10, int i11, @NonNull jad_jw jad_jwVar) {
        jad_jt jad_jtVar2 = jad_jtVar;
        jad_mz<jad_jt, jad_jt> jad_mzVar = this.jad_an;
        if (jad_mzVar != null) {
            jad_mz.jad_bo<jad_jt> jad_an = jad_mz.jad_bo.jad_an(jad_jtVar2, 0, 0);
            jad_jt jad_an2 = jad_mzVar.jad_an.jad_an((jad_hu<jad_mz.jad_bo<jad_jt>, jad_jt>) jad_an);
            Queue<jad_mz.jad_bo<?>> queue = jad_mz.jad_bo.jad_dq;
            synchronized (queue) {
                ((ArrayDeque) queue).offer(jad_an);
            }
            jad_jt jad_jtVar3 = jad_an2;
            if (jad_jtVar3 == null) {
                jad_mz<jad_jt, jad_jt> jad_mzVar2 = this.jad_an;
                jad_mzVar2.getClass();
                jad_mzVar2.jad_an.jad_bo(jad_mz.jad_bo.jad_an(jad_jtVar2, 0, 0), jad_jtVar2);
            } else {
                jad_jtVar2 = jad_jtVar3;
            }
        }
        return new jad_na.jad_an<>(jad_jtVar2, Collections.emptyList(), new com.jd.ad.sdk.jad_kv.jad_jw(jad_jtVar2, ((Integer) jad_jwVar.jad_an(jad_bo)).intValue(), com.jd.ad.sdk.jad_kv.jad_jw.jad_fs));
    }
}
