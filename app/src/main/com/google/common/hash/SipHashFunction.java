package com.google.common.hash;

import b5.u;
import com.google.errorprone.annotations.Immutable;
import i5.c;
import i5.f;
import i5.h;
import i5.k;
import i5.m;
import java.io.Serializable;
import java.nio.ByteBuffer;
import javax.annotation.CheckForNull;

@Immutable
@h
/* loaded from: classes2.dex */
final class SipHashFunction extends c implements Serializable {
    static final k SIP_HASH_24 = new SipHashFunction(2, 4, 506097522914230528L, 1084818905618843912L);
    private static final long serialVersionUID = 0;

    /* renamed from: c */
    private final int f10074c;

    /* renamed from: d */
    private final int f10075d;

    /* renamed from: k0 */
    private final long f10076k0;

    /* renamed from: k1 */
    private final long f10077k1;

    public static final class a extends f {

        /* renamed from: l */
        public static final int f10078l = 8;

        /* renamed from: d */
        public final int f10079d;

        /* renamed from: e */
        public final int f10080e;

        /* renamed from: f */
        public long f10081f;

        /* renamed from: g */
        public long f10082g;

        /* renamed from: h */
        public long f10083h;

        /* renamed from: i */
        public long f10084i;

        /* renamed from: j */
        public long f10085j;

        /* renamed from: k */
        public long f10086k;

        public a(int i10, int i11, long j10, long j11) {
            super(8);
            this.f10085j = 0L;
            this.f10086k = 0L;
            this.f10079d = i10;
            this.f10080e = i11;
            this.f10081f = 8317987319222330741L ^ j10;
            this.f10082g = 7237128888997146477L ^ j11;
            this.f10083h = 7816392313619706465L ^ j10;
            this.f10084i = 8387220255154660723L ^ j11;
        }

        @Override // i5.f
        public HashCode j() {
            long j10 = this.f10086k ^ (this.f10085j << 56);
            this.f10086k = j10;
            p(j10);
            this.f10083h ^= 255;
            q(this.f10080e);
            return HashCode.fromLong(((this.f10081f ^ this.f10082g) ^ this.f10083h) ^ this.f10084i);
        }

        @Override // i5.f
        public void m(ByteBuffer byteBuffer) {
            this.f10085j += 8;
            p(byteBuffer.getLong());
        }

        @Override // i5.f
        public void n(ByteBuffer byteBuffer) {
            this.f10085j += byteBuffer.remaining();
            int i10 = 0;
            while (byteBuffer.hasRemaining()) {
                this.f10086k ^= (byteBuffer.get() & 255) << i10;
                i10 += 8;
            }
        }

        public final void p(long j10) {
            this.f10084i ^= j10;
            q(this.f10079d);
            this.f10081f = j10 ^ this.f10081f;
        }

        public final void q(int i10) {
            for (int i11 = 0; i11 < i10; i11++) {
                long j10 = this.f10081f;
                long j11 = this.f10082g;
                this.f10081f = j10 + j11;
                this.f10083h += this.f10084i;
                this.f10082g = Long.rotateLeft(j11, 13);
                long rotateLeft = Long.rotateLeft(this.f10084i, 16);
                long j12 = this.f10082g;
                long j13 = this.f10081f;
                this.f10082g = j12 ^ j13;
                this.f10084i = rotateLeft ^ this.f10083h;
                long rotateLeft2 = Long.rotateLeft(j13, 32);
                long j14 = this.f10083h;
                long j15 = this.f10082g;
                this.f10083h = j14 + j15;
                this.f10081f = rotateLeft2 + this.f10084i;
                this.f10082g = Long.rotateLeft(j15, 17);
                long rotateLeft3 = Long.rotateLeft(this.f10084i, 21);
                long j16 = this.f10082g;
                long j17 = this.f10083h;
                this.f10082g = j16 ^ j17;
                this.f10084i = rotateLeft3 ^ this.f10081f;
                this.f10083h = Long.rotateLeft(j17, 32);
            }
        }
    }

    public SipHashFunction(int i10, int i11, long j10, long j11) {
        u.k(i10 > 0, "The number of SipRound iterations (c=%s) during Compression must be positive.", i10);
        u.k(i11 > 0, "The number of SipRound iterations (d=%s) during Finalization must be positive.", i11);
        this.f10074c = i10;
        this.f10075d = i11;
        this.f10076k0 = j10;
        this.f10077k1 = j11;
    }

    @Override // i5.k
    public int bits() {
        return 64;
    }

    public boolean equals(@CheckForNull Object obj) {
        if (!(obj instanceof SipHashFunction)) {
            return false;
        }
        SipHashFunction sipHashFunction = (SipHashFunction) obj;
        return this.f10074c == sipHashFunction.f10074c && this.f10075d == sipHashFunction.f10075d && this.f10076k0 == sipHashFunction.f10076k0 && this.f10077k1 == sipHashFunction.f10077k1;
    }

    public int hashCode() {
        return (int) ((((SipHashFunction.class.hashCode() ^ this.f10074c) ^ this.f10075d) ^ this.f10076k0) ^ this.f10077k1);
    }

    @Override // i5.k
    public m newHasher() {
        return new a(this.f10074c, this.f10075d, this.f10076k0, this.f10077k1);
    }

    public String toString() {
        int i10 = this.f10074c;
        int i11 = this.f10075d;
        long j10 = this.f10076k0;
        long j11 = this.f10077k1;
        StringBuilder sb2 = new StringBuilder(81);
        sb2.append("Hashing.sipHash");
        sb2.append(i10);
        sb2.append(i11);
        sb2.append("(");
        sb2.append(j10);
        sb2.append(", ");
        sb2.append(j11);
        sb2.append(")");
        return sb2.toString();
    }
}
