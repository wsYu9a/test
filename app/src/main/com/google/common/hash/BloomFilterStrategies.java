package com.google.common.hash;

import b5.u;
import com.google.common.hash.BloomFilter;
import com.google.common.math.LongMath;
import com.google.common.primitives.Ints;
import com.google.common.primitives.Longs;
import i5.h;
import i5.r;
import i5.t;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicLongArray;
import javax.annotation.CheckForNull;

@h
/* loaded from: classes2.dex */
enum BloomFilterStrategies implements BloomFilter.Strategy {
    MURMUR128_MITZ_32 { // from class: com.google.common.hash.BloomFilterStrategies.1
        @Override // com.google.common.hash.BloomFilter.Strategy
        public <T> boolean mightContain(@t T t10, Funnel<? super T> funnel, int i10, a aVar) {
            long b10 = aVar.b();
            long asLong = Hashing.x().hashObject(t10, funnel).asLong();
            int i11 = (int) asLong;
            int i12 = (int) (asLong >>> 32);
            for (int i13 = 1; i13 <= i10; i13++) {
                int i14 = (i13 * i12) + i11;
                if (i14 < 0) {
                    i14 = ~i14;
                }
                if (!aVar.e(i14 % b10)) {
                    return false;
                }
            }
            return true;
        }

        @Override // com.google.common.hash.BloomFilter.Strategy
        public <T> boolean put(@t T t10, Funnel<? super T> funnel, int i10, a aVar) {
            long b10 = aVar.b();
            long asLong = Hashing.x().hashObject(t10, funnel).asLong();
            int i11 = (int) asLong;
            int i12 = (int) (asLong >>> 32);
            boolean z10 = false;
            for (int i13 = 1; i13 <= i10; i13++) {
                int i14 = (i13 * i12) + i11;
                if (i14 < 0) {
                    i14 = ~i14;
                }
                z10 |= aVar.h(i14 % b10);
            }
            return z10;
        }
    },
    MURMUR128_MITZ_64 { // from class: com.google.common.hash.BloomFilterStrategies.2
        private long lowerEight(byte[] bArr) {
            return Longs.j(bArr[7], bArr[6], bArr[5], bArr[4], bArr[3], bArr[2], bArr[1], bArr[0]);
        }

        private long upperEight(byte[] bArr) {
            return Longs.j(bArr[15], bArr[14], bArr[13], bArr[12], bArr[11], bArr[10], bArr[9], bArr[8]);
        }

        @Override // com.google.common.hash.BloomFilter.Strategy
        public <T> boolean mightContain(@t T t10, Funnel<? super T> funnel, int i10, a aVar) {
            long b10 = aVar.b();
            byte[] bytesInternal = Hashing.x().hashObject(t10, funnel).getBytesInternal();
            long lowerEight = lowerEight(bytesInternal);
            long upperEight = upperEight(bytesInternal);
            for (int i11 = 0; i11 < i10; i11++) {
                if (!aVar.e((Long.MAX_VALUE & lowerEight) % b10)) {
                    return false;
                }
                lowerEight += upperEight;
            }
            return true;
        }

        @Override // com.google.common.hash.BloomFilter.Strategy
        public <T> boolean put(@t T t10, Funnel<? super T> funnel, int i10, a aVar) {
            long b10 = aVar.b();
            byte[] bytesInternal = Hashing.x().hashObject(t10, funnel).getBytesInternal();
            long lowerEight = lowerEight(bytesInternal);
            long upperEight = upperEight(bytesInternal);
            boolean z10 = false;
            for (int i11 = 0; i11 < i10; i11++) {
                z10 |= aVar.h((Long.MAX_VALUE & lowerEight) % b10);
                lowerEight += upperEight;
            }
            return z10;
        }
    };

    /* renamed from: com.google.common.hash.BloomFilterStrategies$1 */
    public enum AnonymousClass1 extends BloomFilterStrategies {
        @Override // com.google.common.hash.BloomFilter.Strategy
        public <T> boolean mightContain(@t T t10, Funnel<? super T> funnel, int i10, a aVar) {
            long b10 = aVar.b();
            long asLong = Hashing.x().hashObject(t10, funnel).asLong();
            int i11 = (int) asLong;
            int i12 = (int) (asLong >>> 32);
            for (int i13 = 1; i13 <= i10; i13++) {
                int i14 = (i13 * i12) + i11;
                if (i14 < 0) {
                    i14 = ~i14;
                }
                if (!aVar.e(i14 % b10)) {
                    return false;
                }
            }
            return true;
        }

        @Override // com.google.common.hash.BloomFilter.Strategy
        public <T> boolean put(@t T t10, Funnel<? super T> funnel, int i10, a aVar) {
            long b10 = aVar.b();
            long asLong = Hashing.x().hashObject(t10, funnel).asLong();
            int i11 = (int) asLong;
            int i12 = (int) (asLong >>> 32);
            boolean z10 = false;
            for (int i13 = 1; i13 <= i10; i13++) {
                int i14 = (i13 * i12) + i11;
                if (i14 < 0) {
                    i14 = ~i14;
                }
                z10 |= aVar.h(i14 % b10);
            }
            return z10;
        }
    }

    /* renamed from: com.google.common.hash.BloomFilterStrategies$2 */
    public enum AnonymousClass2 extends BloomFilterStrategies {
        private long lowerEight(byte[] bArr) {
            return Longs.j(bArr[7], bArr[6], bArr[5], bArr[4], bArr[3], bArr[2], bArr[1], bArr[0]);
        }

        private long upperEight(byte[] bArr) {
            return Longs.j(bArr[15], bArr[14], bArr[13], bArr[12], bArr[11], bArr[10], bArr[9], bArr[8]);
        }

        @Override // com.google.common.hash.BloomFilter.Strategy
        public <T> boolean mightContain(@t T t10, Funnel<? super T> funnel, int i10, a aVar) {
            long b10 = aVar.b();
            byte[] bytesInternal = Hashing.x().hashObject(t10, funnel).getBytesInternal();
            long lowerEight = lowerEight(bytesInternal);
            long upperEight = upperEight(bytesInternal);
            for (int i11 = 0; i11 < i10; i11++) {
                if (!aVar.e((Long.MAX_VALUE & lowerEight) % b10)) {
                    return false;
                }
                lowerEight += upperEight;
            }
            return true;
        }

        @Override // com.google.common.hash.BloomFilter.Strategy
        public <T> boolean put(@t T t10, Funnel<? super T> funnel, int i10, a aVar) {
            long b10 = aVar.b();
            byte[] bytesInternal = Hashing.x().hashObject(t10, funnel).getBytesInternal();
            long lowerEight = lowerEight(bytesInternal);
            long upperEight = upperEight(bytesInternal);
            boolean z10 = false;
            for (int i11 = 0; i11 < i10; i11++) {
                z10 |= aVar.h((Long.MAX_VALUE & lowerEight) % b10);
                lowerEight += upperEight;
            }
            return z10;
        }
    }

    /* synthetic */ BloomFilterStrategies(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static final class a {

        /* renamed from: c */
        public static final int f10044c = 6;

        /* renamed from: a */
        public final AtomicLongArray f10045a;

        /* renamed from: b */
        public final r f10046b;

        public a(long j10) {
            u.e(j10 > 0, "data length is zero!");
            this.f10045a = new AtomicLongArray(Ints.d(LongMath.g(j10, 64L, RoundingMode.CEILING)));
            this.f10046b = LongAddables.a();
        }

        public static long[] i(AtomicLongArray atomicLongArray) {
            int length = atomicLongArray.length();
            long[] jArr = new long[length];
            for (int i10 = 0; i10 < length; i10++) {
                jArr[i10] = atomicLongArray.get(i10);
            }
            return jArr;
        }

        public long a() {
            return this.f10046b.sum();
        }

        public long b() {
            return this.f10045a.length() * 64;
        }

        public a c() {
            return new a(i(this.f10045a));
        }

        public int d() {
            return this.f10045a.length();
        }

        public boolean e(long j10) {
            return ((1 << ((int) j10)) & this.f10045a.get((int) (j10 >>> 6))) != 0;
        }

        public boolean equals(@CheckForNull Object obj) {
            if (obj instanceof a) {
                return Arrays.equals(i(this.f10045a), i(((a) obj).f10045a));
            }
            return false;
        }

        public void f(a aVar) {
            u.m(this.f10045a.length() == aVar.f10045a.length(), "BitArrays must be of equal length (%s != %s)", this.f10045a.length(), aVar.f10045a.length());
            for (int i10 = 0; i10 < this.f10045a.length(); i10++) {
                g(i10, aVar.f10045a.get(i10));
            }
        }

        public void g(int i10, long j10) {
            long j11;
            long j12;
            do {
                j11 = this.f10045a.get(i10);
                j12 = j11 | j10;
                if (j11 == j12) {
                    return;
                }
            } while (!this.f10045a.compareAndSet(i10, j11, j12));
            this.f10046b.add(Long.bitCount(j12) - Long.bitCount(j11));
        }

        public boolean h(long j10) {
            long j11;
            long j12;
            if (e(j10)) {
                return false;
            }
            int i10 = (int) (j10 >>> 6);
            long j13 = 1 << ((int) j10);
            do {
                j11 = this.f10045a.get(i10);
                j12 = j11 | j13;
                if (j11 == j12) {
                    return false;
                }
            } while (!this.f10045a.compareAndSet(i10, j11, j12));
            this.f10046b.increment();
            return true;
        }

        public int hashCode() {
            return Arrays.hashCode(i(this.f10045a));
        }

        public a(long[] jArr) {
            u.e(jArr.length > 0, "data length is zero!");
            this.f10045a = new AtomicLongArray(jArr);
            this.f10046b = LongAddables.a();
            long j10 = 0;
            for (long j11 : jArr) {
                j10 += Long.bitCount(j11);
            }
            this.f10046b.add(j10);
        }
    }
}
