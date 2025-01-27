package com.jd.ad.sdk.jad_lu;

import android.graphics.Rect;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.collection.LongSparseArray;
import androidx.collection.SparseArrayCompat;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public class jad_jt {
    public Map<String, List<com.jd.ad.sdk.jad_tc.jad_er>> jad_cp;
    public Map<String, jad_na> jad_dq;
    public Map<String, com.jd.ad.sdk.jad_qz.jad_cp> jad_er;
    public List<com.jd.ad.sdk.jad_qz.jad_hu> jad_fs;
    public LongSparseArray<com.jd.ad.sdk.jad_tc.jad_er> jad_hu;
    public List<com.jd.ad.sdk.jad_tc.jad_er> jad_iv;
    public SparseArrayCompat<com.jd.ad.sdk.jad_qz.jad_dq> jad_jt;
    public Rect jad_jw;
    public float jad_kx;
    public float jad_ly;
    public float jad_mz;
    public boolean jad_na;
    public final jad_vi jad_an = new jad_vi();
    public final HashSet<String> jad_bo = new HashSet<>();
    public int jad_ob = 0;

    public float jad_an() {
        return (long) ((jad_bo() / this.jad_mz) * 1000.0f);
    }

    public float jad_bo() {
        return this.jad_ly - this.jad_kx;
    }

    public List<com.jd.ad.sdk.jad_tc.jad_er> jad_cp() {
        return this.jad_iv;
    }

    @NonNull
    public String toString() {
        StringBuilder sb2 = new StringBuilder("LottieComposition:\n");
        Iterator<com.jd.ad.sdk.jad_tc.jad_er> it = this.jad_iv.iterator();
        while (it.hasNext()) {
            sb2.append(it.next().jad_an("\t"));
        }
        return sb2.toString();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public com.jd.ad.sdk.jad_tc.jad_er jad_an(long j10) {
        return this.jad_hu.get(j10);
    }

    @Nullable
    public com.jd.ad.sdk.jad_qz.jad_hu jad_bo(String str) {
        int size = this.jad_fs.size();
        for (int i10 = 0; i10 < size; i10++) {
            com.jd.ad.sdk.jad_qz.jad_hu jad_huVar = this.jad_fs.get(i10);
            if (!jad_huVar.jad_an.equalsIgnoreCase(str)) {
                if (jad_huVar.jad_an.endsWith("\r")) {
                    if (jad_huVar.jad_an.substring(0, r4.length() - 1).equalsIgnoreCase(str)) {
                    }
                }
            }
            return jad_huVar;
        }
        return null;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void jad_an(String str) {
        com.jd.ad.sdk.jad_xg.jad_dq.jad_an(str);
        this.jad_bo.add(str);
    }
}
