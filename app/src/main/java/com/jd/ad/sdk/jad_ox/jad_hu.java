package com.jd.ad.sdk.jad_ox;

import android.graphics.Path;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class jad_hu {
    public final List<jad_an<com.jd.ad.sdk.jad_sb.jad_na, Path>> jad_an;
    public final List<jad_an<Integer, Integer>> jad_bo;
    public final List<com.jd.ad.sdk.jad_sb.jad_jt> jad_cp;

    public jad_hu(List<com.jd.ad.sdk.jad_sb.jad_jt> list) {
        this.jad_cp = list;
        this.jad_an = new ArrayList(list.size());
        this.jad_bo = new ArrayList(list.size());
        for (int i10 = 0; i10 < list.size(); i10++) {
            this.jad_an.add(list.get(i10).jad_an().jad_an());
            this.jad_bo.add(list.get(i10).jad_bo().jad_an());
        }
    }

    public List<jad_an<com.jd.ad.sdk.jad_sb.jad_na, Path>> jad_an() {
        return this.jad_an;
    }

    public List<jad_an<Integer, Integer>> jad_bo() {
        return this.jad_bo;
    }
}
