package com.opos.mobad.n.a;

import android.animation.TypeEvaluator;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public class c<T> implements TypeEvaluator<T> {

    /* renamed from: a */
    private long f21765a = 0;

    /* renamed from: c */
    private int f21767c = 0;

    /* renamed from: b */
    private List<a<T>> f21766b = new ArrayList();

    private static class a<T> {

        /* renamed from: a */
        private long f21768a;

        /* renamed from: b */
        private TypeEvaluator<T> f21769b;

        /* renamed from: c */
        private long f21770c;

        public a(TypeEvaluator<T> typeEvaluator, long j2, long j3) {
            this.f21768a = j2;
            this.f21769b = typeEvaluator;
            this.f21770c = j3;
        }
    }

    private a a(float f2) {
        float f3 = this.f21765a * f2;
        for (int i2 = this.f21767c; i2 < this.f21766b.size(); i2++) {
            a<T> aVar = this.f21766b.get(i2);
            if (f3 >= ((a) aVar).f21770c && f3 <= ((a) aVar).f21768a + ((a) aVar).f21770c) {
                this.f21767c = i2;
                return aVar;
            }
        }
        if (this.f21767c <= 0) {
            return null;
        }
        this.f21767c = 0;
        return a(f2);
    }

    public long a() {
        return this.f21765a;
    }

    public c a(TypeEvaluator<T> typeEvaluator, long j2) {
        if (j2 > 0 && typeEvaluator != null) {
            this.f21766b.add(new a<>(typeEvaluator, j2, this.f21765a));
            this.f21765a += j2;
        }
        return this;
    }

    @Override // android.animation.TypeEvaluator
    public T evaluate(float f2, T t, T t2) {
        List<a<T>> list = this.f21766b;
        if (list == null || list.isEmpty()) {
            return null;
        }
        a a2 = a(f2);
        if (a2 == null) {
            Log.d("", "null node:" + f2);
            return t2;
        }
        double d2 = f2;
        double d3 = this.f21765a;
        Double.isNaN(d2);
        Double.isNaN(d3);
        double d4 = d2 * d3;
        double d5 = a2.f21770c;
        Double.isNaN(d5);
        double d6 = d4 - d5;
        double d7 = a2.f21768a;
        Double.isNaN(d7);
        return (T) a2.f21769b.evaluate((float) (d6 / d7), t, t2);
    }
}
