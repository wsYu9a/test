package com.jd.ad.sdk.jad_ox;

import android.view.animation.Interpolator;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import l5.c;

/* loaded from: classes2.dex */
public abstract class jad_an<K, A> {
    public final jad_cp<K> jad_cp;

    @Nullable
    public com.jd.ad.sdk.jad_yh.jad_cp<A> jad_er;
    public final List<InterfaceC0340jad_an> jad_an = new ArrayList(1);
    public boolean jad_bo = false;
    public float jad_dq = 0.0f;

    @Nullable
    public A jad_fs = null;
    public float jad_jt = -1.0f;
    public float jad_hu = -1.0f;

    /* renamed from: com.jd.ad.sdk.jad_ox.jad_an$jad_an */
    public interface InterfaceC0340jad_an {
        void jad_an();
    }

    public static final class jad_bo<T> implements jad_cp<T> {
        @Override // com.jd.ad.sdk.jad_ox.jad_an.jad_cp
        public boolean isEmpty() {
            return true;
        }

        @Override // com.jd.ad.sdk.jad_ox.jad_an.jad_cp
        public float jad_an() {
            return 1.0f;
        }

        @Override // com.jd.ad.sdk.jad_ox.jad_an.jad_cp
        public float jad_bo() {
            return 0.0f;
        }

        @Override // com.jd.ad.sdk.jad_ox.jad_an.jad_cp
        public com.jd.ad.sdk.jad_yh.jad_an<T> jad_cp() {
            throw new IllegalStateException("not implemented");
        }

        @Override // com.jd.ad.sdk.jad_ox.jad_an.jad_cp
        public boolean jad_an(float f10) {
            return false;
        }

        @Override // com.jd.ad.sdk.jad_ox.jad_an.jad_cp
        public boolean jad_bo(float f10) {
            throw new IllegalStateException("not implemented");
        }
    }

    public interface jad_cp<T> {
        boolean isEmpty();

        @FloatRange(from = c.f27899e, to = 1.0d)
        float jad_an();

        boolean jad_an(float f10);

        @FloatRange(from = c.f27899e, to = 1.0d)
        float jad_bo();

        boolean jad_bo(float f10);

        com.jd.ad.sdk.jad_yh.jad_an<T> jad_cp();
    }

    public static final class jad_dq<T> implements jad_cp<T> {
        public final List<? extends com.jd.ad.sdk.jad_yh.jad_an<T>> jad_an;
        public com.jd.ad.sdk.jad_yh.jad_an<T> jad_cp = null;
        public float jad_dq = -1.0f;

        @NonNull
        public com.jd.ad.sdk.jad_yh.jad_an<T> jad_bo = jad_cp(0.0f);

        public jad_dq(List<? extends com.jd.ad.sdk.jad_yh.jad_an<T>> list) {
            this.jad_an = list;
        }

        @Override // com.jd.ad.sdk.jad_ox.jad_an.jad_cp
        public boolean isEmpty() {
            return false;
        }

        @Override // com.jd.ad.sdk.jad_ox.jad_an.jad_cp
        public float jad_an() {
            return this.jad_an.get(r0.size() - 1).jad_an();
        }

        @Override // com.jd.ad.sdk.jad_ox.jad_an.jad_cp
        public float jad_bo() {
            return this.jad_an.get(0).jad_bo();
        }

        @Override // com.jd.ad.sdk.jad_ox.jad_an.jad_cp
        @NonNull
        public com.jd.ad.sdk.jad_yh.jad_an<T> jad_cp() {
            return this.jad_bo;
        }

        @Override // com.jd.ad.sdk.jad_ox.jad_an.jad_cp
        public boolean jad_an(float f10) {
            com.jd.ad.sdk.jad_yh.jad_an<T> jad_anVar = this.jad_bo;
            if (f10 >= jad_anVar.jad_bo() && f10 < jad_anVar.jad_an()) {
                return !this.jad_bo.jad_cp();
            }
            this.jad_bo = jad_cp(f10);
            return true;
        }

        @Override // com.jd.ad.sdk.jad_ox.jad_an.jad_cp
        public boolean jad_bo(float f10) {
            com.jd.ad.sdk.jad_yh.jad_an<T> jad_anVar = this.jad_cp;
            com.jd.ad.sdk.jad_yh.jad_an<T> jad_anVar2 = this.jad_bo;
            if (jad_anVar == jad_anVar2 && this.jad_dq == f10) {
                return true;
            }
            this.jad_cp = jad_anVar2;
            this.jad_dq = f10;
            return false;
        }

        public final com.jd.ad.sdk.jad_yh.jad_an<T> jad_cp(float f10) {
            List<? extends com.jd.ad.sdk.jad_yh.jad_an<T>> list = this.jad_an;
            com.jd.ad.sdk.jad_yh.jad_an<T> jad_anVar = list.get(list.size() - 1);
            if (f10 >= jad_anVar.jad_bo()) {
                return jad_anVar;
            }
            for (int size = this.jad_an.size() - 2; size >= 1; size--) {
                com.jd.ad.sdk.jad_yh.jad_an<T> jad_anVar2 = this.jad_an.get(size);
                if (this.jad_bo != jad_anVar2 && f10 >= jad_anVar2.jad_bo() && f10 < jad_anVar2.jad_an()) {
                    return jad_anVar2;
                }
            }
            return this.jad_an.get(0);
        }
    }

    public static final class jad_er<T> implements jad_cp<T> {

        @NonNull
        public final com.jd.ad.sdk.jad_yh.jad_an<T> jad_an;
        public float jad_bo = -1.0f;

        public jad_er(List<? extends com.jd.ad.sdk.jad_yh.jad_an<T>> list) {
            this.jad_an = list.get(0);
        }

        @Override // com.jd.ad.sdk.jad_ox.jad_an.jad_cp
        public boolean isEmpty() {
            return false;
        }

        @Override // com.jd.ad.sdk.jad_ox.jad_an.jad_cp
        public float jad_an() {
            return this.jad_an.jad_an();
        }

        @Override // com.jd.ad.sdk.jad_ox.jad_an.jad_cp
        public float jad_bo() {
            return this.jad_an.jad_bo();
        }

        @Override // com.jd.ad.sdk.jad_ox.jad_an.jad_cp
        public com.jd.ad.sdk.jad_yh.jad_an<T> jad_cp() {
            return this.jad_an;
        }

        @Override // com.jd.ad.sdk.jad_ox.jad_an.jad_cp
        public boolean jad_an(float f10) {
            return !this.jad_an.jad_cp();
        }

        @Override // com.jd.ad.sdk.jad_ox.jad_an.jad_cp
        public boolean jad_bo(float f10) {
            if (this.jad_bo == f10) {
                return true;
            }
            this.jad_bo = f10;
            return false;
        }
    }

    public jad_an(List<? extends com.jd.ad.sdk.jad_yh.jad_an<K>> list) {
        this.jad_cp = jad_an(list);
    }

    public com.jd.ad.sdk.jad_yh.jad_an<K> jad_an() {
        com.jd.ad.sdk.jad_yh.jad_an<K> jad_cp2 = this.jad_cp.jad_cp();
        com.jd.ad.sdk.jad_lu.jad_dq.jad_an("BaseKeyframeAnimation#getCurrentKeyframe");
        return jad_cp2;
    }

    public abstract A jad_an(com.jd.ad.sdk.jad_yh.jad_an<K> jad_anVar, float f10);

    @FloatRange(from = c.f27899e, to = 1.0d)
    public float jad_bo() {
        if (this.jad_hu == -1.0f) {
            this.jad_hu = this.jad_cp.jad_an();
        }
        return this.jad_hu;
    }

    public float jad_cp() {
        com.jd.ad.sdk.jad_yh.jad_an<K> jad_an = jad_an();
        if (jad_an.jad_cp()) {
            return 0.0f;
        }
        return jad_an.jad_dq.getInterpolation(jad_dq());
    }

    public float jad_dq() {
        if (this.jad_bo) {
            return 0.0f;
        }
        com.jd.ad.sdk.jad_yh.jad_an<K> jad_an = jad_an();
        if (jad_an.jad_cp()) {
            return 0.0f;
        }
        return (this.jad_dq - jad_an.jad_bo()) / (jad_an.jad_an() - jad_an.jad_bo());
    }

    public float jad_er() {
        return this.jad_dq;
    }

    public A jad_fs() {
        float jad_dq2 = jad_dq();
        if (this.jad_er == null && this.jad_cp.jad_bo(jad_dq2)) {
            return this.jad_fs;
        }
        com.jd.ad.sdk.jad_yh.jad_an<K> jad_an = jad_an();
        Interpolator interpolator = jad_an.jad_er;
        A jad_an2 = (interpolator == null || jad_an.jad_fs == null) ? jad_an(jad_an, jad_cp()) : jad_an(jad_an, jad_dq2, interpolator.getInterpolation(jad_dq2), jad_an.jad_fs.getInterpolation(jad_dq2));
        this.jad_fs = jad_an2;
        return jad_an2;
    }

    public void jad_jt() {
        for (int i10 = 0; i10 < this.jad_an.size(); i10++) {
            this.jad_an.get(i10).jad_an();
        }
    }

    public A jad_an(com.jd.ad.sdk.jad_yh.jad_an<K> jad_anVar, float f10, float f11, float f12) {
        throw new UnsupportedOperationException("This animation does not support split dimensions!");
    }

    public void jad_an(InterfaceC0340jad_an interfaceC0340jad_an) {
        this.jad_an.add(interfaceC0340jad_an);
    }

    public void jad_an(@Nullable com.jd.ad.sdk.jad_yh.jad_cp<A> jad_cpVar) {
        this.jad_er = jad_cpVar;
    }

    public void jad_an(@FloatRange(from = 0.0d, to = 1.0d) float f10) {
        if (this.jad_cp.isEmpty()) {
            return;
        }
        if (this.jad_jt == -1.0f) {
            this.jad_jt = this.jad_cp.jad_bo();
        }
        float f11 = this.jad_jt;
        if (f10 < f11) {
            if (f11 == -1.0f) {
                this.jad_jt = this.jad_cp.jad_bo();
            }
            f10 = this.jad_jt;
        } else if (f10 > jad_bo()) {
            f10 = jad_bo();
        }
        if (f10 == this.jad_dq) {
            return;
        }
        this.jad_dq = f10;
        if (this.jad_cp.jad_an(f10)) {
            jad_jt();
        }
    }

    public static <T> jad_cp<T> jad_an(List<? extends com.jd.ad.sdk.jad_yh.jad_an<T>> list) {
        if (list.isEmpty()) {
            return new jad_bo();
        }
        return list.size() == 1 ? new jad_er(list) : new jad_dq(list);
    }
}
