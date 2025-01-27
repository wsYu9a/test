package com.google.common.math;

import a5.c;
import b5.r;
import b5.u;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import javax.annotation.CheckForNull;
import l5.e;

@a5.a
@c
@e
/* loaded from: classes2.dex */
public final class PairedStats implements Serializable {
    private static final int BYTES = 88;
    private static final long serialVersionUID = 0;
    private final double sumOfProductsOfDeltas;
    private final Stats xStats;
    private final Stats yStats;

    public PairedStats(Stats stats, Stats stats2, double d10) {
        this.xStats = stats;
        this.yStats = stats2;
        this.sumOfProductsOfDeltas = d10;
    }

    private static double ensureInUnitRange(double d10) {
        if (d10 >= 1.0d) {
            return 1.0d;
        }
        if (d10 <= -1.0d) {
            return -1.0d;
        }
        return d10;
    }

    private static double ensurePositive(double d10) {
        if (d10 > l5.c.f27899e) {
            return d10;
        }
        return Double.MIN_VALUE;
    }

    public static PairedStats fromByteArray(byte[] bArr) {
        u.E(bArr);
        u.m(bArr.length == 88, "Expected PairedStats.BYTES = %s, got %s", 88, bArr.length);
        ByteBuffer order = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
        return new PairedStats(Stats.readFrom(order), Stats.readFrom(order), order.getDouble());
    }

    public long count() {
        return this.xStats.count();
    }

    public boolean equals(@CheckForNull Object obj) {
        if (obj == null || PairedStats.class != obj.getClass()) {
            return false;
        }
        PairedStats pairedStats = (PairedStats) obj;
        return this.xStats.equals(pairedStats.xStats) && this.yStats.equals(pairedStats.yStats) && Double.doubleToLongBits(this.sumOfProductsOfDeltas) == Double.doubleToLongBits(pairedStats.sumOfProductsOfDeltas);
    }

    public int hashCode() {
        return r.b(this.xStats, this.yStats, Double.valueOf(this.sumOfProductsOfDeltas));
    }

    public a leastSquaresFit() {
        u.g0(count() > 1);
        if (Double.isNaN(this.sumOfProductsOfDeltas)) {
            return a.a();
        }
        double sumOfSquaresOfDeltas = this.xStats.sumOfSquaresOfDeltas();
        if (sumOfSquaresOfDeltas > l5.c.f27899e) {
            return this.yStats.sumOfSquaresOfDeltas() > l5.c.f27899e ? a.f(this.xStats.mean(), this.yStats.mean()).b(this.sumOfProductsOfDeltas / sumOfSquaresOfDeltas) : a.b(this.yStats.mean());
        }
        u.g0(this.yStats.sumOfSquaresOfDeltas() > l5.c.f27899e);
        return a.i(this.xStats.mean());
    }

    public double pearsonsCorrelationCoefficient() {
        u.g0(count() > 1);
        if (Double.isNaN(this.sumOfProductsOfDeltas)) {
            return Double.NaN;
        }
        double sumOfSquaresOfDeltas = xStats().sumOfSquaresOfDeltas();
        double sumOfSquaresOfDeltas2 = yStats().sumOfSquaresOfDeltas();
        u.g0(sumOfSquaresOfDeltas > l5.c.f27899e);
        u.g0(sumOfSquaresOfDeltas2 > l5.c.f27899e);
        return ensureInUnitRange(this.sumOfProductsOfDeltas / Math.sqrt(ensurePositive(sumOfSquaresOfDeltas * sumOfSquaresOfDeltas2)));
    }

    public double populationCovariance() {
        u.g0(count() != 0);
        return this.sumOfProductsOfDeltas / count();
    }

    public double sampleCovariance() {
        u.g0(count() > 1);
        return this.sumOfProductsOfDeltas / (count() - 1);
    }

    public double sumOfProductsOfDeltas() {
        return this.sumOfProductsOfDeltas;
    }

    public byte[] toByteArray() {
        ByteBuffer order = ByteBuffer.allocate(88).order(ByteOrder.LITTLE_ENDIAN);
        this.xStats.writeTo(order);
        this.yStats.writeTo(order);
        order.putDouble(this.sumOfProductsOfDeltas);
        return order.array();
    }

    public String toString() {
        return count() > 0 ? com.google.common.base.a.c(this).f("xStats", this.xStats).f("yStats", this.yStats).b("populationCovariance", populationCovariance()).toString() : com.google.common.base.a.c(this).f("xStats", this.xStats).f("yStats", this.yStats).toString();
    }

    public Stats xStats() {
        return this.xStats;
    }

    public Stats yStats() {
        return this.yStats;
    }
}
