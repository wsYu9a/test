package com.jd.ad.sdk.jad_ir;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class jad_hu<T, Y> {
    public final Map<T, jad_an<Y>> jad_an = new LinkedHashMap(100, 0.75f, true);
    public long jad_bo;
    public long jad_cp;

    public static final class jad_an<Y> {
        public final Y jad_an;
        public final int jad_bo;

        public jad_an(Y y10, int i10) {
            this.jad_an = y10;
            this.jad_bo = i10;
        }
    }

    public jad_hu(long j10) {
        this.jad_bo = j10;
    }

    @Nullable
    public synchronized Y jad_an(@NonNull T t10) {
        jad_an<Y> jad_anVar;
        jad_anVar = this.jad_an.get(t10);
        return jad_anVar != null ? jad_anVar.jad_an : null;
    }

    public int jad_bo(@Nullable Y y10) {
        return 1;
    }

    public synchronized void jad_an(long j10) {
        while (this.jad_cp > j10) {
            Iterator<Map.Entry<T, jad_an<Y>>> it = this.jad_an.entrySet().iterator();
            Map.Entry<T, jad_an<Y>> next = it.next();
            jad_an<Y> value = next.getValue();
            this.jad_cp -= value.jad_bo;
            T key = next.getKey();
            it.remove();
            jad_an(key, value.jad_an);
        }
    }

    @Nullable
    public synchronized Y jad_bo(@NonNull T t10, @Nullable Y y10) {
        int jad_bo = jad_bo(y10);
        long j10 = jad_bo;
        if (j10 >= this.jad_bo) {
            jad_an(t10, y10);
            return null;
        }
        if (y10 != null) {
            this.jad_cp += j10;
        }
        jad_an<Y> put = this.jad_an.put(t10, y10 == null ? null : new jad_an<>(y10, jad_bo));
        if (put != null) {
            this.jad_cp -= put.jad_bo;
            if (!put.jad_an.equals(y10)) {
                jad_an(t10, put.jad_an);
            }
        }
        jad_an(this.jad_bo);
        return put != null ? put.jad_an : null;
    }

    public void jad_an(@NonNull T t10, @Nullable Y y10) {
    }
}
