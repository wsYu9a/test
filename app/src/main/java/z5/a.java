package z5;

import java.util.Arrays;
import okhttp3.internal.ws.WebSocketProtocol;

/* loaded from: classes2.dex */
public final class a implements Cloneable {

    /* renamed from: b */
    public int[] f33647b;

    /* renamed from: c */
    public int f33648c;

    public a() {
        this.f33648c = 0;
        this.f33647b = new int[1];
    }

    public static int[] o(int i10) {
        return new int[(i10 + 31) / 32];
    }

    public void a(boolean z10) {
        f(this.f33648c + 1);
        if (z10) {
            int[] iArr = this.f33647b;
            int i10 = this.f33648c;
            int i11 = i10 / 32;
            iArr[i11] = (1 << (i10 & 31)) | iArr[i11];
        }
        this.f33648c++;
    }

    public void b(a aVar) {
        int i10 = aVar.f33648c;
        f(this.f33648c + i10);
        for (int i11 = 0; i11 < i10; i11++) {
            a(aVar.h(i11));
        }
    }

    public void c(int i10, int i11) {
        if (i11 < 0 || i11 > 32) {
            throw new IllegalArgumentException("Num bits must be between 0 and 32");
        }
        f(this.f33648c + i11);
        while (i11 > 0) {
            boolean z10 = true;
            if (((i10 >> (i11 - 1)) & 1) != 1) {
                z10 = false;
            }
            a(z10);
            i11--;
        }
    }

    public void d() {
        int length = this.f33647b.length;
        for (int i10 = 0; i10 < length; i10++) {
            this.f33647b[i10] = 0;
        }
    }

    /* renamed from: e */
    public a clone() {
        return new a((int[]) this.f33647b.clone(), this.f33648c);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.f33648c == aVar.f33648c && Arrays.equals(this.f33647b, aVar.f33647b);
    }

    public final void f(int i10) {
        if (i10 > (this.f33647b.length << 5)) {
            int[] o10 = o(i10);
            int[] iArr = this.f33647b;
            System.arraycopy(iArr, 0, o10, 0, iArr.length);
            this.f33647b = o10;
        }
    }

    public void g(int i10) {
        int[] iArr = this.f33647b;
        int i11 = i10 / 32;
        iArr[i11] = (1 << (i10 & 31)) ^ iArr[i11];
    }

    public boolean h(int i10) {
        return ((1 << (i10 & 31)) & this.f33647b[i10 / 32]) != 0;
    }

    public int hashCode() {
        return (this.f33648c * 31) + Arrays.hashCode(this.f33647b);
    }

    public int[] i() {
        return this.f33647b;
    }

    public int j(int i10) {
        int i11 = this.f33648c;
        if (i10 >= i11) {
            return i11;
        }
        int i12 = i10 / 32;
        int i13 = (~((1 << (i10 & 31)) - 1)) & this.f33647b[i12];
        while (i13 == 0) {
            i12++;
            int[] iArr = this.f33647b;
            if (i12 == iArr.length) {
                return this.f33648c;
            }
            i13 = iArr[i12];
        }
        int numberOfTrailingZeros = (i12 << 5) + Integer.numberOfTrailingZeros(i13);
        int i14 = this.f33648c;
        return numberOfTrailingZeros > i14 ? i14 : numberOfTrailingZeros;
    }

    public int k(int i10) {
        int i11 = this.f33648c;
        if (i10 >= i11) {
            return i11;
        }
        int i12 = i10 / 32;
        int i13 = (~((1 << (i10 & 31)) - 1)) & (~this.f33647b[i12]);
        while (i13 == 0) {
            i12++;
            int[] iArr = this.f33647b;
            if (i12 == iArr.length) {
                return this.f33648c;
            }
            i13 = ~iArr[i12];
        }
        int numberOfTrailingZeros = (i12 << 5) + Integer.numberOfTrailingZeros(i13);
        int i14 = this.f33648c;
        return numberOfTrailingZeros > i14 ? i14 : numberOfTrailingZeros;
    }

    public int l() {
        return this.f33648c;
    }

    public int m() {
        return (this.f33648c + 7) / 8;
    }

    public boolean n(int i10, int i11, boolean z10) {
        if (i11 < i10 || i10 < 0 || i11 > this.f33648c) {
            throw new IllegalArgumentException();
        }
        if (i11 == i10) {
            return true;
        }
        int i12 = i11 - 1;
        int i13 = i10 / 32;
        int i14 = i12 / 32;
        int i15 = i13;
        while (i15 <= i14) {
            int i16 = (2 << (i15 >= i14 ? 31 & i12 : 31)) - (1 << (i15 > i13 ? 0 : i10 & 31));
            int i17 = this.f33647b[i15] & i16;
            if (!z10) {
                i16 = 0;
            }
            if (i17 != i16) {
                return false;
            }
            i15++;
        }
        return true;
    }

    public void p() {
        int[] iArr = new int[this.f33647b.length];
        int i10 = (this.f33648c - 1) / 32;
        int i11 = i10 + 1;
        for (int i12 = 0; i12 < i11; i12++) {
            long j10 = this.f33647b[i12];
            long j11 = ((j10 & 1431655765) << 1) | ((j10 >> 1) & 1431655765);
            long j12 = ((j11 & 858993459) << 2) | ((j11 >> 2) & 858993459);
            long j13 = ((j12 & 252645135) << 4) | ((j12 >> 4) & 252645135);
            long j14 = ((j13 & 16711935) << 8) | ((j13 >> 8) & 16711935);
            iArr[i10 - i12] = (int) (((j14 & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 16) | ((j14 >> 16) & WebSocketProtocol.PAYLOAD_SHORT_MAX));
        }
        int i13 = this.f33648c;
        int i14 = i11 << 5;
        if (i13 != i14) {
            int i15 = i14 - i13;
            int i16 = iArr[0] >>> i15;
            for (int i17 = 1; i17 < i11; i17++) {
                int i18 = iArr[i17];
                iArr[i17 - 1] = i16 | (i18 << (32 - i15));
                i16 = i18 >>> i15;
            }
            iArr[i10] = i16;
        }
        this.f33647b = iArr;
    }

    public void q(int i10) {
        int[] iArr = this.f33647b;
        int i11 = i10 / 32;
        iArr[i11] = (1 << (i10 & 31)) | iArr[i11];
    }

    public void r(int i10, int i11) {
        this.f33647b[i10 / 32] = i11;
    }

    public void s(int i10, int i11) {
        if (i11 < i10 || i10 < 0 || i11 > this.f33648c) {
            throw new IllegalArgumentException();
        }
        if (i11 == i10) {
            return;
        }
        int i12 = i11 - 1;
        int i13 = i10 / 32;
        int i14 = i12 / 32;
        int i15 = i13;
        while (i15 <= i14) {
            int i16 = 31;
            int i17 = i15 > i13 ? 0 : i10 & 31;
            if (i15 >= i14) {
                i16 = 31 & i12;
            }
            int i18 = (2 << i16) - (1 << i17);
            int[] iArr = this.f33647b;
            iArr[i15] = i18 | iArr[i15];
            i15++;
        }
    }

    public void t(int i10, byte[] bArr, int i11, int i12) {
        for (int i13 = 0; i13 < i12; i13++) {
            int i14 = 0;
            for (int i15 = 0; i15 < 8; i15++) {
                if (h(i10)) {
                    i14 |= 1 << (7 - i15);
                }
                i10++;
            }
            bArr[i11 + i13] = (byte) i14;
        }
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(this.f33648c);
        for (int i10 = 0; i10 < this.f33648c; i10++) {
            if ((i10 & 7) == 0) {
                sb2.append(b5.a.O);
            }
            sb2.append(h(i10) ? 'X' : '.');
        }
        return sb2.toString();
    }

    public void u(a aVar) {
        if (this.f33648c != aVar.f33648c) {
            throw new IllegalArgumentException("Sizes don't match");
        }
        int i10 = 0;
        while (true) {
            int[] iArr = this.f33647b;
            if (i10 >= iArr.length) {
                return;
            }
            iArr[i10] = iArr[i10] ^ aVar.f33647b[i10];
            i10++;
        }
    }

    public a(int i10) {
        this.f33648c = i10;
        this.f33647b = o(i10);
    }

    public a(int[] iArr, int i10) {
        this.f33647b = iArr;
        this.f33648c = i10;
    }
}
