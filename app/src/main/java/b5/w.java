package b5;

import b5.b;
import java.util.BitSet;

@g
@a5.c
/* loaded from: classes2.dex */
public final class w extends b.v {

    /* renamed from: g */
    public static final int f1272g = 1023;

    /* renamed from: h */
    public static final int f1273h = -862048943;

    /* renamed from: i */
    public static final int f1274i = 461845907;

    /* renamed from: j */
    public static final double f1275j = 0.5d;

    /* renamed from: d */
    public final char[] f1276d;

    /* renamed from: e */
    public final boolean f1277e;

    /* renamed from: f */
    public final long f1278f;

    public w(char[] cArr, long j10, boolean z10, String str) {
        super(str);
        this.f1276d = cArr;
        this.f1278f = j10;
        this.f1277e = z10;
    }

    @a5.d
    public static int Z(int i10) {
        if (i10 == 1) {
            return 2;
        }
        int highestOneBit = Integer.highestOneBit(i10 - 1) << 1;
        while (highestOneBit * 0.5d < i10) {
            highestOneBit <<= 1;
        }
        return highestOneBit;
    }

    public static b a0(BitSet bitSet, String str) {
        int i10;
        int cardinality = bitSet.cardinality();
        boolean z10 = bitSet.get(0);
        int Z = Z(cardinality);
        char[] cArr = new char[Z];
        int i11 = Z - 1;
        int nextSetBit = bitSet.nextSetBit(0);
        long j10 = 0;
        while (nextSetBit != -1) {
            long j11 = (1 << nextSetBit) | j10;
            int b02 = b0(nextSetBit);
            while (true) {
                i10 = b02 & i11;
                if (cArr[i10] == 0) {
                    break;
                }
                b02 = i10 + 1;
            }
            cArr[i10] = (char) nextSetBit;
            nextSetBit = bitSet.nextSetBit(nextSetBit + 1);
            j10 = j11;
        }
        return new w(cArr, j10, z10, str);
    }

    public static int b0(int i10) {
        return Integer.rotateLeft(i10 * f1273h, 15) * f1274i;
    }

    @Override // b5.b
    public boolean B(char c10) {
        if (c10 == 0) {
            return this.f1277e;
        }
        if (!Y(c10)) {
            return false;
        }
        int length = this.f1276d.length - 1;
        int b02 = b0(c10) & length;
        int i10 = b02;
        do {
            char c11 = this.f1276d[i10];
            if (c11 == 0) {
                return false;
            }
            if (c11 == c10) {
                return true;
            }
            i10 = (i10 + 1) & length;
        } while (i10 != b02);
        return false;
    }

    @Override // b5.b
    public void Q(BitSet bitSet) {
        if (this.f1277e) {
            bitSet.set(0);
        }
        for (char c10 : this.f1276d) {
            if (c10 != 0) {
                bitSet.set(c10);
            }
        }
    }

    public final boolean Y(int i10) {
        return 1 == ((this.f1278f >> i10) & 1);
    }
}
