package com.google.common.math;

import a5.c;
import b5.r;
import b5.u;
import c7.g;
import com.google.common.primitives.Doubles;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Iterator;
import javax.annotation.CheckForNull;
import l5.d;
import l5.e;
import l5.j;

@a5.a
@c
@e
/* loaded from: classes2.dex */
public final class Stats implements Serializable {
    static final int BYTES = 40;
    private static final long serialVersionUID = 0;
    private final long count;
    private final double max;
    private final double mean;
    private final double min;
    private final double sumOfSquaresOfDeltas;

    public Stats(long j10, double d10, double d11, double d12, double d13) {
        this.count = j10;
        this.mean = d10;
        this.sumOfSquaresOfDeltas = d11;
        this.min = d12;
        this.max = d13;
    }

    public static Stats fromByteArray(byte[] bArr) {
        u.E(bArr);
        u.m(bArr.length == 40, "Expected Stats.BYTES = %s remaining , got %s", 40, bArr.length);
        return readFrom(ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN));
    }

    public static double meanOf(Iterable<? extends Number> iterable) {
        return meanOf(iterable.iterator());
    }

    public static Stats of(Iterable<? extends Number> iterable) {
        j jVar = new j();
        jVar.c(iterable);
        return jVar.s();
    }

    public static Stats readFrom(ByteBuffer byteBuffer) {
        u.E(byteBuffer);
        u.m(byteBuffer.remaining() >= 40, "Expected at least Stats.BYTES = %s remaining , got %s", 40, byteBuffer.remaining());
        return new Stats(byteBuffer.getLong(), byteBuffer.getDouble(), byteBuffer.getDouble(), byteBuffer.getDouble(), byteBuffer.getDouble());
    }

    public long count() {
        return this.count;
    }

    public boolean equals(@CheckForNull Object obj) {
        if (obj == null || Stats.class != obj.getClass()) {
            return false;
        }
        Stats stats = (Stats) obj;
        return this.count == stats.count && Double.doubleToLongBits(this.mean) == Double.doubleToLongBits(stats.mean) && Double.doubleToLongBits(this.sumOfSquaresOfDeltas) == Double.doubleToLongBits(stats.sumOfSquaresOfDeltas) && Double.doubleToLongBits(this.min) == Double.doubleToLongBits(stats.min) && Double.doubleToLongBits(this.max) == Double.doubleToLongBits(stats.max);
    }

    public int hashCode() {
        return r.b(Long.valueOf(this.count), Double.valueOf(this.mean), Double.valueOf(this.sumOfSquaresOfDeltas), Double.valueOf(this.min), Double.valueOf(this.max));
    }

    public double max() {
        u.g0(this.count != 0);
        return this.max;
    }

    public double mean() {
        u.g0(this.count != 0);
        return this.mean;
    }

    public double min() {
        u.g0(this.count != 0);
        return this.min;
    }

    public double populationStandardDeviation() {
        return Math.sqrt(populationVariance());
    }

    public double populationVariance() {
        u.g0(this.count > 0);
        if (Double.isNaN(this.sumOfSquaresOfDeltas)) {
            return Double.NaN;
        }
        return this.count == 1 ? l5.c.f27899e : d.b(this.sumOfSquaresOfDeltas) / count();
    }

    public double sampleStandardDeviation() {
        return Math.sqrt(sampleVariance());
    }

    public double sampleVariance() {
        u.g0(this.count > 1);
        if (Double.isNaN(this.sumOfSquaresOfDeltas)) {
            return Double.NaN;
        }
        return d.b(this.sumOfSquaresOfDeltas) / (this.count - 1);
    }

    public double sum() {
        return this.mean * this.count;
    }

    public double sumOfSquaresOfDeltas() {
        return this.sumOfSquaresOfDeltas;
    }

    public byte[] toByteArray() {
        ByteBuffer order = ByteBuffer.allocate(40).order(ByteOrder.LITTLE_ENDIAN);
        writeTo(order);
        return order.array();
    }

    public String toString() {
        return count() > 0 ? com.google.common.base.a.c(this).e(g.f1744b, this.count).b("mean", this.mean).b("populationStandardDeviation", populationStandardDeviation()).b("min", this.min).b("max", this.max).toString() : com.google.common.base.a.c(this).e(g.f1744b, this.count).toString();
    }

    public void writeTo(ByteBuffer byteBuffer) {
        u.E(byteBuffer);
        u.m(byteBuffer.remaining() >= 40, "Expected at least Stats.BYTES = %s remaining , got %s", 40, byteBuffer.remaining());
        byteBuffer.putLong(this.count).putDouble(this.mean).putDouble(this.sumOfSquaresOfDeltas).putDouble(this.min).putDouble(this.max);
    }

    public static double meanOf(Iterator<? extends Number> it) {
        u.d(it.hasNext());
        double doubleValue = it.next().doubleValue();
        long j10 = 1;
        while (it.hasNext()) {
            double doubleValue2 = it.next().doubleValue();
            j10++;
            doubleValue = (Doubles.n(doubleValue2) && Doubles.n(doubleValue)) ? doubleValue + ((doubleValue2 - doubleValue) / j10) : j.i(doubleValue, doubleValue2);
        }
        return doubleValue;
    }

    public static Stats of(Iterator<? extends Number> it) {
        j jVar = new j();
        jVar.d(it);
        return jVar.s();
    }

    public static Stats of(double... dArr) {
        j jVar = new j();
        jVar.f(dArr);
        return jVar.s();
    }

    public static double meanOf(double... dArr) {
        u.d(dArr.length > 0);
        double d10 = dArr[0];
        for (int i10 = 1; i10 < dArr.length; i10++) {
            double d11 = dArr[i10];
            d10 = (Doubles.n(d11) && Doubles.n(d10)) ? d10 + ((d11 - d10) / (i10 + 1)) : j.i(d10, d11);
        }
        return d10;
    }

    public static Stats of(int... iArr) {
        j jVar = new j();
        jVar.g(iArr);
        return jVar.s();
    }

    public static Stats of(long... jArr) {
        j jVar = new j();
        jVar.h(jArr);
        return jVar.s();
    }

    public static double meanOf(int... iArr) {
        u.d(iArr.length > 0);
        double d10 = iArr[0];
        for (int i10 = 1; i10 < iArr.length; i10++) {
            double d11 = iArr[i10];
            d10 = (Doubles.n(d11) && Doubles.n(d10)) ? d10 + ((d11 - d10) / (i10 + 1)) : j.i(d10, d11);
        }
        return d10;
    }

    public static double meanOf(long... jArr) {
        u.d(jArr.length > 0);
        double d10 = jArr[0];
        for (int i10 = 1; i10 < jArr.length; i10++) {
            double d11 = jArr[i10];
            d10 = (Doubles.n(d11) && Doubles.n(d10)) ? d10 + ((d11 - d10) / (i10 + 1)) : j.i(d10, d11);
        }
        return d10;
    }
}
