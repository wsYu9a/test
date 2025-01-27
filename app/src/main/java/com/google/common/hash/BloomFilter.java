package com.google.common.hash;

import a5.d;
import b5.r;
import b5.u;
import b5.v;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.google.common.hash.BloomFilterStrategies;
import com.google.common.math.LongMath;
import com.google.common.primitives.SignedBytes;
import com.google.common.primitives.UnsignedBytes;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import i5.h;
import i5.t;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.math.RoundingMode;
import javax.annotation.CheckForNull;
import l5.c;

@a5.a
@h
/* loaded from: classes2.dex */
public final class BloomFilter<T> implements v<T>, Serializable {
    private final BloomFilterStrategies.a bits;
    private final Funnel<? super T> funnel;
    private final int numHashFunctions;
    private final Strategy strategy;

    public static class SerialForm<T> implements Serializable {
        private static final long serialVersionUID = 1;
        final long[] data;
        final Funnel<? super T> funnel;
        final int numHashFunctions;
        final Strategy strategy;

        public SerialForm(BloomFilter<T> bloomFilter) {
            this.data = BloomFilterStrategies.a.i(((BloomFilter) bloomFilter).bits.f10045a);
            this.numHashFunctions = ((BloomFilter) bloomFilter).numHashFunctions;
            this.funnel = ((BloomFilter) bloomFilter).funnel;
            this.strategy = ((BloomFilter) bloomFilter).strategy;
        }

        public Object readResolve() {
            return new BloomFilter(new BloomFilterStrategies.a(this.data), this.numHashFunctions, this.funnel, this.strategy);
        }
    }

    public interface Strategy extends Serializable {
        <T> boolean mightContain(@t T t10, Funnel<? super T> funnel, int i10, BloomFilterStrategies.a aVar);

        int ordinal();

        <T> boolean put(@t T t10, Funnel<? super T> funnel, int i10, BloomFilterStrategies.a aVar);
    }

    public /* synthetic */ BloomFilter(BloomFilterStrategies.a aVar, int i10, Funnel funnel, Strategy strategy, a aVar2) {
        this(aVar, i10, funnel, strategy);
    }

    public static <T> BloomFilter<T> create(Funnel<? super T> funnel, int i10, double d10) {
        return create(funnel, i10, d10);
    }

    @d
    public static long optimalNumOfBits(long j10, double d10) {
        if (d10 == c.f27899e) {
            d10 = Double.MIN_VALUE;
        }
        return (long) (((-j10) * Math.log(d10)) / (Math.log(2.0d) * Math.log(2.0d)));
    }

    @d
    public static int optimalNumOfHashFunctions(long j10, long j11) {
        return Math.max(1, (int) Math.round((j11 / j10) * Math.log(2.0d)));
    }

    public static <T> BloomFilter<T> readFrom(InputStream inputStream, Funnel<? super T> funnel) throws IOException {
        int i10;
        int i11;
        int readInt;
        u.F(inputStream, "InputStream");
        u.F(funnel, "Funnel");
        byte b10 = -1;
        try {
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            byte readByte = dataInputStream.readByte();
            try {
                i11 = UnsignedBytes.p(dataInputStream.readByte());
                try {
                    readInt = dataInputStream.readInt();
                } catch (RuntimeException e10) {
                    e = e10;
                    b10 = readByte;
                    i10 = -1;
                    StringBuilder sb2 = new StringBuilder(TTDownloadField.CALL_DOWNLOAD_MODEL_SET_MODEL_TYPE);
                    sb2.append("Unable to deserialize BloomFilter from InputStream. strategyOrdinal: ");
                    sb2.append((int) b10);
                    sb2.append(" numHashFunctions: ");
                    sb2.append(i11);
                    sb2.append(" dataLength: ");
                    sb2.append(i10);
                    throw new IOException(sb2.toString(), e);
                }
                try {
                    BloomFilterStrategies bloomFilterStrategies = BloomFilterStrategies.values()[readByte];
                    BloomFilterStrategies.a aVar = new BloomFilterStrategies.a(LongMath.d(readInt, 64L));
                    for (int i12 = 0; i12 < readInt; i12++) {
                        aVar.g(i12, dataInputStream.readLong());
                    }
                    return new BloomFilter<>(aVar, i11, funnel, bloomFilterStrategies);
                } catch (RuntimeException e11) {
                    e = e11;
                    b10 = readByte;
                    i10 = readInt;
                    StringBuilder sb22 = new StringBuilder(TTDownloadField.CALL_DOWNLOAD_MODEL_SET_MODEL_TYPE);
                    sb22.append("Unable to deserialize BloomFilter from InputStream. strategyOrdinal: ");
                    sb22.append((int) b10);
                    sb22.append(" numHashFunctions: ");
                    sb22.append(i11);
                    sb22.append(" dataLength: ");
                    sb22.append(i10);
                    throw new IOException(sb22.toString(), e);
                }
            } catch (RuntimeException e12) {
                e = e12;
                i11 = -1;
            }
        } catch (RuntimeException e13) {
            e = e13;
            i10 = -1;
            i11 = -1;
        }
    }

    private Object writeReplace() {
        return new SerialForm(this);
    }

    @Override // b5.v
    @Deprecated
    public boolean apply(@t T t10) {
        return mightContain(t10);
    }

    public long approximateElementCount() {
        double b10 = this.bits.b();
        return c.q(((-Math.log1p(-(this.bits.a() / b10))) * b10) / this.numHashFunctions, RoundingMode.HALF_UP);
    }

    @d
    public long bitSize() {
        return this.bits.b();
    }

    public BloomFilter<T> copy() {
        return new BloomFilter<>(this.bits.c(), this.numHashFunctions, this.funnel, this.strategy);
    }

    @Override // b5.v
    public boolean equals(@CheckForNull Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BloomFilter)) {
            return false;
        }
        BloomFilter bloomFilter = (BloomFilter) obj;
        return this.numHashFunctions == bloomFilter.numHashFunctions && this.funnel.equals(bloomFilter.funnel) && this.bits.equals(bloomFilter.bits) && this.strategy.equals(bloomFilter.strategy);
    }

    public double expectedFpp() {
        return Math.pow(this.bits.a() / bitSize(), this.numHashFunctions);
    }

    public int hashCode() {
        return r.b(Integer.valueOf(this.numHashFunctions), this.funnel, this.strategy, this.bits);
    }

    public boolean isCompatible(BloomFilter<T> bloomFilter) {
        u.E(bloomFilter);
        return this != bloomFilter && this.numHashFunctions == bloomFilter.numHashFunctions && bitSize() == bloomFilter.bitSize() && this.strategy.equals(bloomFilter.strategy) && this.funnel.equals(bloomFilter.funnel);
    }

    public boolean mightContain(@t T t10) {
        return this.strategy.mightContain(t10, this.funnel, this.numHashFunctions, this.bits);
    }

    @CanIgnoreReturnValue
    public boolean put(@t T t10) {
        return this.strategy.put(t10, this.funnel, this.numHashFunctions, this.bits);
    }

    public void putAll(BloomFilter<T> bloomFilter) {
        u.E(bloomFilter);
        u.e(this != bloomFilter, "Cannot combine a BloomFilter with itself.");
        int i10 = this.numHashFunctions;
        int i11 = bloomFilter.numHashFunctions;
        u.m(i10 == i11, "BloomFilters must have the same number of hash functions (%s != %s)", i10, i11);
        u.s(bitSize() == bloomFilter.bitSize(), "BloomFilters must have the same size underlying bit arrays (%s != %s)", bitSize(), bloomFilter.bitSize());
        u.y(this.strategy.equals(bloomFilter.strategy), "BloomFilters must have equal strategies (%s != %s)", this.strategy, bloomFilter.strategy);
        u.y(this.funnel.equals(bloomFilter.funnel), "BloomFilters must have equal funnels (%s != %s)", this.funnel, bloomFilter.funnel);
        this.bits.f(bloomFilter.bits);
    }

    public void writeTo(OutputStream outputStream) throws IOException {
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
        dataOutputStream.writeByte(SignedBytes.a(this.strategy.ordinal()));
        dataOutputStream.writeByte(UnsignedBytes.a(this.numHashFunctions));
        dataOutputStream.writeInt(this.bits.f10045a.length());
        for (int i10 = 0; i10 < this.bits.f10045a.length(); i10++) {
            dataOutputStream.writeLong(this.bits.f10045a.get(i10));
        }
    }

    private BloomFilter(BloomFilterStrategies.a aVar, int i10, Funnel<? super T> funnel, Strategy strategy) {
        u.k(i10 > 0, "numHashFunctions (%s) must be > 0", i10);
        u.k(i10 <= 255, "numHashFunctions (%s) must be <= 255", i10);
        this.bits = (BloomFilterStrategies.a) u.E(aVar);
        this.numHashFunctions = i10;
        this.funnel = (Funnel) u.E(funnel);
        this.strategy = (Strategy) u.E(strategy);
    }

    public static <T> BloomFilter<T> create(Funnel<? super T> funnel, long j10, double d10) {
        return create(funnel, j10, d10, BloomFilterStrategies.MURMUR128_MITZ_64);
    }

    @d
    public static <T> BloomFilter<T> create(Funnel<? super T> funnel, long j10, double d10, Strategy strategy) {
        u.E(funnel);
        u.p(j10 >= 0, "Expected insertions (%s) must be >= 0", j10);
        u.u(d10 > c.f27899e, "False positive probability (%s) must be > 0.0", Double.valueOf(d10));
        u.u(d10 < 1.0d, "False positive probability (%s) must be < 1.0", Double.valueOf(d10));
        u.E(strategy);
        if (j10 == 0) {
            j10 = 1;
        }
        long optimalNumOfBits = optimalNumOfBits(j10, d10);
        try {
            return new BloomFilter<>(new BloomFilterStrategies.a(optimalNumOfBits), optimalNumOfHashFunctions(j10, optimalNumOfBits), funnel, strategy);
        } catch (IllegalArgumentException e10) {
            StringBuilder sb2 = new StringBuilder(57);
            sb2.append("Could not create BloomFilter of ");
            sb2.append(optimalNumOfBits);
            sb2.append(" bits");
            throw new IllegalArgumentException(sb2.toString(), e10);
        }
    }

    public static <T> BloomFilter<T> create(Funnel<? super T> funnel, int i10) {
        return create(funnel, i10);
    }

    public static <T> BloomFilter<T> create(Funnel<? super T> funnel, long j10) {
        return create(funnel, j10, 0.03d);
    }
}
