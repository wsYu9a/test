package com.google.common.hash;

import b5.u;
import com.google.common.primitives.Ints;
import com.google.common.primitives.UnsignedBytes;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.Immutable;
import i5.c;
import i5.d;
import i5.h;
import i5.k;
import i5.m;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import javax.annotation.CheckForNull;

@Immutable
@h
/* loaded from: classes2.dex */
final class Murmur3_32HashFunction extends c implements Serializable {
    private static final int C1 = -862048943;
    private static final int C2 = 461845907;
    private static final int CHUNK_SIZE = 4;
    private static final long serialVersionUID = 0;
    private final int seed;
    private final boolean supplementaryPlaneFix;
    static final k MURMUR3_32 = new Murmur3_32HashFunction(0, false);
    static final k MURMUR3_32_FIXED = new Murmur3_32HashFunction(0, true);
    static final k GOOD_FAST_HASH_32 = new Murmur3_32HashFunction(Hashing.f10050a, true);

    @CanIgnoreReturnValue
    public static final class a extends d {

        /* renamed from: a */
        public int f10069a;

        /* renamed from: b */
        public long f10070b;

        /* renamed from: c */
        public int f10071c;

        /* renamed from: d */
        public int f10072d = 0;

        /* renamed from: e */
        public boolean f10073e = false;

        public a(int i10) {
            this.f10069a = i10;
        }

        private void update(int i10, long j10) {
            long j11 = this.f10070b;
            int i11 = this.f10071c;
            long j12 = ((j10 & 4294967295L) << i11) | j11;
            this.f10070b = j12;
            int i12 = i11 + (i10 * 8);
            this.f10071c = i12;
            this.f10072d += i10;
            if (i12 >= 32) {
                this.f10069a = Murmur3_32HashFunction.mixH1(this.f10069a, Murmur3_32HashFunction.mixK1((int) j12));
                this.f10070b >>>= 32;
                this.f10071c -= 32;
            }
        }

        @Override // i5.m
        public HashCode i() {
            u.g0(!this.f10073e);
            this.f10073e = true;
            int mixK1 = this.f10069a ^ Murmur3_32HashFunction.mixK1((int) this.f10070b);
            this.f10069a = mixK1;
            return Murmur3_32HashFunction.fmix(mixK1, this.f10072d);
        }

        @Override // i5.d, i5.m, i5.u
        public m b(char c10) {
            update(2, c10);
            return this;
        }

        @Override // i5.d, i5.m, i5.u
        public m c(byte b10) {
            update(1, b10 & 255);
            return this;
        }

        @Override // i5.d, i5.m, i5.u
        public m e(byte[] bArr, int i10, int i11) {
            u.f0(i10, i10 + i11, bArr.length);
            int i12 = 0;
            while (true) {
                int i13 = i12 + 4;
                if (i13 > i11) {
                    break;
                }
                update(4, Murmur3_32HashFunction.getIntLittleEndian(bArr, i12 + i10));
                i12 = i13;
            }
            while (i12 < i11) {
                c(bArr[i10 + i12]);
                i12++;
            }
            return this;
        }

        @Override // i5.d, i5.m, i5.u
        public m f(ByteBuffer byteBuffer) {
            ByteOrder order = byteBuffer.order();
            byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
            while (byteBuffer.remaining() >= 4) {
                putInt(byteBuffer.getInt());
            }
            while (byteBuffer.hasRemaining()) {
                c(byteBuffer.get());
            }
            byteBuffer.order(order);
            return this;
        }

        @Override // i5.d, i5.m, i5.u
        public m g(CharSequence charSequence, Charset charset) {
            if (!b5.c.f1249c.equals(charset)) {
                return super.g(charSequence, charset);
            }
            int length = charSequence.length();
            int i10 = 0;
            while (true) {
                int i11 = i10 + 4;
                if (i11 > length) {
                    break;
                }
                char charAt = charSequence.charAt(i10);
                char charAt2 = charSequence.charAt(i10 + 1);
                char charAt3 = charSequence.charAt(i10 + 2);
                char charAt4 = charSequence.charAt(i10 + 3);
                if (charAt >= 128 || charAt2 >= 128 || charAt3 >= 128 || charAt4 >= 128) {
                    break;
                }
                update(4, (charAt2 << '\b') | charAt | (charAt3 << 16) | (charAt4 << 24));
                i10 = i11;
            }
            while (i10 < length) {
                char charAt5 = charSequence.charAt(i10);
                if (charAt5 < 128) {
                    update(1, charAt5);
                } else if (charAt5 < 2048) {
                    update(2, Murmur3_32HashFunction.charToTwoUtf8Bytes(charAt5));
                } else if (charAt5 < 55296 || charAt5 > 57343) {
                    update(3, Murmur3_32HashFunction.charToThreeUtf8Bytes(charAt5));
                } else {
                    int codePointAt = Character.codePointAt(charSequence, i10);
                    if (codePointAt == charAt5) {
                        a(charSequence.subSequence(i10, length).toString().getBytes(charset));
                        return this;
                    }
                    i10++;
                    update(4, Murmur3_32HashFunction.codePointToFourUtf8Bytes(codePointAt));
                }
                i10++;
            }
            return this;
        }

        @Override // i5.d, i5.m, i5.u
        public m putInt(int i10) {
            update(4, i10);
            return this;
        }

        @Override // i5.d, i5.m, i5.u
        public m putLong(long j10) {
            update(4, (int) j10);
            update(4, j10 >>> 32);
            return this;
        }
    }

    public Murmur3_32HashFunction(int i10, boolean z10) {
        this.seed = i10;
        this.supplementaryPlaneFix = z10;
    }

    public static long charToThreeUtf8Bytes(char c10) {
        return (c10 >>> '\f') | 224 | ((((c10 >>> 6) & 63) | 128) << 8) | (((c10 & '?') | 128) << 16);
    }

    public static long charToTwoUtf8Bytes(char c10) {
        return (c10 >>> 6) | 192 | (((c10 & '?') | 128) << 8);
    }

    public static long codePointToFourUtf8Bytes(int i10) {
        return (i10 >>> 18) | 240 | ((((i10 >>> 12) & 63) | 128) << 8) | ((((i10 >>> 6) & 63) | 128) << 16) | (((i10 & 63) | 128) << 24);
    }

    public static HashCode fmix(int i10, int i11) {
        int i12 = i10 ^ i11;
        int i13 = (i12 ^ (i12 >>> 16)) * (-2048144789);
        int i14 = (i13 ^ (i13 >>> 13)) * (-1028477387);
        return HashCode.fromInt(i14 ^ (i14 >>> 16));
    }

    public static int getIntLittleEndian(byte[] bArr, int i10) {
        return Ints.k(bArr[i10 + 3], bArr[i10 + 2], bArr[i10 + 1], bArr[i10]);
    }

    public static int mixH1(int i10, int i11) {
        return (Integer.rotateLeft(i10 ^ i11, 13) * 5) - 430675100;
    }

    public static int mixK1(int i10) {
        return Integer.rotateLeft(i10 * (-862048943), 15) * 461845907;
    }

    @Override // i5.k
    public int bits() {
        return 32;
    }

    public boolean equals(@CheckForNull Object obj) {
        if (!(obj instanceof Murmur3_32HashFunction)) {
            return false;
        }
        Murmur3_32HashFunction murmur3_32HashFunction = (Murmur3_32HashFunction) obj;
        return this.seed == murmur3_32HashFunction.seed && this.supplementaryPlaneFix == murmur3_32HashFunction.supplementaryPlaneFix;
    }

    @Override // i5.c, i5.k
    public HashCode hashBytes(byte[] bArr, int i10, int i11) {
        u.f0(i10, i10 + i11, bArr.length);
        int i12 = this.seed;
        int i13 = 0;
        int i14 = 0;
        while (true) {
            int i15 = i14 + 4;
            if (i15 > i11) {
                break;
            }
            i12 = mixH1(i12, mixK1(getIntLittleEndian(bArr, i14 + i10)));
            i14 = i15;
        }
        int i16 = i14;
        int i17 = 0;
        while (i16 < i11) {
            i13 ^= UnsignedBytes.p(bArr[i10 + i16]) << i17;
            i16++;
            i17 += 8;
        }
        return fmix(mixK1(i13) ^ i12, i11);
    }

    public int hashCode() {
        return Murmur3_32HashFunction.class.hashCode() ^ this.seed;
    }

    @Override // i5.c, i5.k
    public HashCode hashInt(int i10) {
        return fmix(mixH1(this.seed, mixK1(i10)), 4);
    }

    @Override // i5.c, i5.k
    public HashCode hashLong(long j10) {
        int i10 = (int) (j10 >>> 32);
        return fmix(mixH1(mixH1(this.seed, mixK1((int) j10)), mixK1(i10)), 8);
    }

    @Override // i5.c, i5.k
    public HashCode hashString(CharSequence charSequence, Charset charset) {
        if (!b5.c.f1249c.equals(charset)) {
            return hashBytes(charSequence.toString().getBytes(charset));
        }
        int length = charSequence.length();
        int i10 = this.seed;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        while (true) {
            int i14 = i12 + 4;
            if (i14 > length) {
                break;
            }
            char charAt = charSequence.charAt(i12);
            char charAt2 = charSequence.charAt(i12 + 1);
            char charAt3 = charSequence.charAt(i12 + 2);
            char charAt4 = charSequence.charAt(i12 + 3);
            if (charAt >= 128 || charAt2 >= 128 || charAt3 >= 128 || charAt4 >= 128) {
                break;
            }
            i10 = mixH1(i10, mixK1((charAt2 << '\b') | charAt | (charAt3 << 16) | (charAt4 << 24)));
            i13 += 4;
            i12 = i14;
        }
        long j10 = 0;
        while (i12 < length) {
            char charAt5 = charSequence.charAt(i12);
            if (charAt5 < 128) {
                j10 |= charAt5 << i11;
                i11 += 8;
                i13++;
            } else if (charAt5 < 2048) {
                j10 |= charToTwoUtf8Bytes(charAt5) << i11;
                i11 += 16;
                i13 += 2;
            } else if (charAt5 < 55296 || charAt5 > 57343) {
                j10 |= charToThreeUtf8Bytes(charAt5) << i11;
                i11 += 24;
                i13 += 3;
            } else {
                int codePointAt = Character.codePointAt(charSequence, i12);
                if (codePointAt == charAt5) {
                    return hashBytes(charSequence.toString().getBytes(charset));
                }
                i12++;
                j10 |= codePointToFourUtf8Bytes(codePointAt) << i11;
                if (this.supplementaryPlaneFix) {
                    i11 += 32;
                }
                i13 += 4;
            }
            if (i11 >= 32) {
                i10 = mixH1(i10, mixK1((int) j10));
                j10 >>>= 32;
                i11 -= 32;
            }
            i12++;
        }
        return fmix(mixK1((int) j10) ^ i10, i13);
    }

    @Override // i5.c, i5.k
    public HashCode hashUnencodedChars(CharSequence charSequence) {
        int i10 = this.seed;
        for (int i11 = 1; i11 < charSequence.length(); i11 += 2) {
            i10 = mixH1(i10, mixK1(charSequence.charAt(i11 - 1) | (charSequence.charAt(i11) << 16)));
        }
        if ((charSequence.length() & 1) == 1) {
            i10 ^= mixK1(charSequence.charAt(charSequence.length() - 1));
        }
        return fmix(i10, charSequence.length() * 2);
    }

    @Override // i5.k
    public m newHasher() {
        return new a(this.seed);
    }

    public String toString() {
        int i10 = this.seed;
        StringBuilder sb2 = new StringBuilder(31);
        sb2.append("Hashing.murmur3_32(");
        sb2.append(i10);
        sb2.append(")");
        return sb2.toString();
    }
}
