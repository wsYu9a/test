package com.cdo.oaps.ad;

import java.io.ByteArrayOutputStream;
import java.util.Random;

/* loaded from: classes.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private static Random f6514a = new Random();

    /* renamed from: c, reason: collision with root package name */
    private int f6516c;

    /* renamed from: d, reason: collision with root package name */
    private int f6517d;

    /* renamed from: e, reason: collision with root package name */
    private int f6518e;

    /* renamed from: g, reason: collision with root package name */
    private byte[] f6520g;

    /* renamed from: h, reason: collision with root package name */
    private byte[] f6521h;

    /* renamed from: i, reason: collision with root package name */
    private int f6522i;

    /* renamed from: j, reason: collision with root package name */
    private byte[] f6523j;
    private int k;
    private byte[] l;

    /* renamed from: f, reason: collision with root package name */
    private boolean f6519f = true;

    /* renamed from: b, reason: collision with root package name */
    private ByteArrayOutputStream f6515b = new ByteArrayOutputStream(8);

    private static long a(byte[] bArr, int i2, int i3) {
        long j2 = 0;
        int i4 = i3 > 8 ? i2 + 8 : i3 + i2;
        while (i2 < i4) {
            j2 = (j2 << 8) | (bArr[i2] & 255);
            i2++;
        }
        return (4294967295L & j2) | (j2 >>> 32);
    }

    private void a() {
        this.k = 0;
        while (true) {
            int i2 = this.k;
            if (i2 >= 8) {
                break;
            }
            if (this.f6519f) {
                this.f6523j[i2] = (byte) (r2[i2] ^ this.l[i2]);
            } else {
                this.f6523j[i2] = (byte) (r2[i2] ^ this.f6521h[this.f6518e + i2]);
            }
            this.k = i2 + 1;
        }
        System.arraycopy(b(this.f6523j), 0, this.f6521h, this.f6517d, 8);
        this.k = 0;
        while (true) {
            int i3 = this.k;
            if (i3 >= 8) {
                System.arraycopy(this.f6523j, 0, this.l, 0, 8);
                int i4 = this.f6517d;
                this.f6518e = i4;
                this.f6517d = i4 + 8;
                this.k = 0;
                this.f6519f = false;
                return;
            }
            this.f6521h[this.f6517d + i3] = (byte) (r3[r4] ^ this.l[i3]);
            this.k = i3 + 1;
        }
    }

    private void a(int i2) {
        this.f6515b.write(i2 >>> 24);
        this.f6515b.write(i2 >>> 16);
        this.f6515b.write(i2 >>> 8);
        this.f6515b.write(i2);
    }

    private byte[] a(byte[] bArr) {
        return a(bArr, 0);
    }

    private byte[] a(byte[] bArr, int i2) {
        long a2 = a(bArr, i2, 4);
        long a3 = a(bArr, i2 + 4, 4);
        long a4 = a(this.f6520g, 0, 4);
        long a5 = a(this.f6520g, 4, 4);
        long a6 = a(this.f6520g, 8, 4);
        long a7 = a(this.f6520g, 12, 4);
        long j2 = 3816266640L;
        for (int i3 = 16; i3 > 0; i3--) {
            a3 = (a3 - ((((a2 << 4) + a6) ^ (a2 + j2)) ^ ((a2 >>> 5) + a7))) & 4294967295L;
            a2 = (a2 - ((((a3 << 4) + a4) ^ (a3 + j2)) ^ ((a3 >>> 5) + a5))) & 4294967295L;
            j2 = (j2 - 2654435769L) & 4294967295L;
        }
        this.f6515b.reset();
        a((int) a2);
        a((int) a3);
        return this.f6515b.toByteArray();
    }

    private int b() {
        return f6514a.nextInt();
    }

    private boolean b(byte[] bArr, int i2, int i3) {
        this.k = 0;
        while (true) {
            int i4 = this.k;
            if (i4 >= 8) {
                this.l = a(this.l);
                this.f6516c += 8;
                this.f6517d += 8;
                this.k = 0;
                return true;
            }
            if (this.f6516c + i4 >= i3) {
                return true;
            }
            this.l[i4] = (byte) (r2[i4] ^ bArr[(this.f6517d + i2) + i4]);
            this.k = i4 + 1;
        }
    }

    private byte[] b(byte[] bArr) {
        long a2 = a(bArr, 0, 4);
        long a3 = a(bArr, 4, 4);
        long a4 = a(this.f6520g, 0, 4);
        long a5 = a(this.f6520g, 4, 4);
        long a6 = a(this.f6520g, 8, 4);
        long a7 = a(this.f6520g, 12, 4);
        long j2 = 0;
        for (int i2 = 16; i2 > 0; i2--) {
            j2 = (j2 + 2654435769L) & 4294967295L;
            a2 = (a2 + ((((a3 << 4) + a4) ^ (a3 + j2)) ^ ((a3 >>> 5) + a5))) & 4294967295L;
            a3 = (a3 + ((((a2 << 4) + a6) ^ (a2 + j2)) ^ ((a2 >>> 5) + a7))) & 4294967295L;
        }
        this.f6515b.reset();
        a((int) a2);
        a((int) a3);
        return this.f6515b.toByteArray();
    }

    public byte[] a(byte[] bArr, int i2, int i3, byte[] bArr2) {
        if (bArr2 == null) {
            return null;
        }
        int i4 = 0;
        this.f6518e = 0;
        this.f6517d = 0;
        this.f6520g = bArr2;
        int i5 = i2 + 8;
        byte[] bArr3 = new byte[i5];
        if (i3 % 8 != 0 || i3 < 16) {
            return null;
        }
        byte[] a2 = a(bArr, i2);
        this.l = a2;
        int i6 = a2[0] & 7;
        this.k = i6;
        int i7 = (i3 - i6) - 10;
        if (i7 < 0) {
            return null;
        }
        for (int i8 = i2; i8 < i5; i8++) {
            bArr3[i8] = (byte) 0;
        }
        this.f6521h = new byte[i7];
        this.f6518e = 0;
        this.f6517d = 8;
        this.f6516c = 8;
        this.k++;
        this.f6522i = 1;
        while (true) {
            int i9 = this.f6522i;
            if (i9 > 2) {
                while (i7 != 0) {
                    int i10 = this.k;
                    if (i10 < 8) {
                        this.f6521h[i4] = (byte) (bArr3[(this.f6518e + i2) + i10] ^ this.l[i10]);
                        i4++;
                        this.k = i10 + 1;
                        i7--;
                    }
                    if (this.k == 8) {
                        this.f6518e = this.f6517d - 8;
                        if (!b(bArr, i2, i3)) {
                            return null;
                        }
                        bArr3 = bArr;
                    }
                }
                this.f6522i = 1;
                while (this.f6522i < 8) {
                    int i11 = this.k;
                    if (i11 < 8) {
                        if ((bArr3[(this.f6518e + i2) + i11] ^ this.l[i11]) != 0) {
                            return null;
                        }
                        this.k = i11 + 1;
                    }
                    if (this.k == 8) {
                        this.f6518e = this.f6517d;
                        if (!b(bArr, i2, i3)) {
                            return null;
                        }
                        bArr3 = bArr;
                    }
                    this.f6522i++;
                }
                return (byte[]) this.f6521h.clone();
            }
            int i12 = this.k;
            if (i12 < 8) {
                this.k = i12 + 1;
                this.f6522i = i9 + 1;
            }
            if (this.k == 8) {
                if (!b(bArr, i2, i3)) {
                    return null;
                }
                bArr3 = bArr;
            }
        }
    }

    public byte[] a(byte[] bArr, byte[] bArr2) {
        return a(bArr, 0, bArr.length, bArr2);
    }

    public byte[] b(byte[] bArr, int i2, int i3, byte[] bArr2) {
        int i4;
        if (bArr2 == null) {
            return bArr;
        }
        byte[] bArr3 = new byte[8];
        this.f6523j = bArr3;
        this.l = new byte[8];
        this.k = 1;
        this.f6522i = 0;
        this.f6518e = 0;
        this.f6517d = 0;
        this.f6520g = bArr2;
        this.f6519f = true;
        int i5 = (i3 + 10) % 8;
        this.k = i5;
        if (i5 != 0) {
            this.k = 8 - i5;
        }
        this.f6521h = new byte[this.k + i3 + 10];
        bArr3[0] = (byte) ((b() & 248) | this.k);
        int i6 = 1;
        while (true) {
            i4 = this.k;
            if (i6 > i4) {
                break;
            }
            this.f6523j[i6] = (byte) (b() & 255);
            i6++;
        }
        this.k = i4 + 1;
        for (int i7 = 0; i7 < 8; i7++) {
            this.l[i7] = (byte) 0;
        }
        this.f6522i = 1;
        while (this.f6522i <= 2) {
            int i8 = this.k;
            if (i8 < 8) {
                byte[] bArr4 = this.f6523j;
                this.k = i8 + 1;
                bArr4[i8] = (byte) (b() & 255);
                this.f6522i++;
            }
            if (this.k == 8) {
                a();
            }
        }
        while (i3 > 0) {
            int i9 = this.k;
            if (i9 < 8) {
                byte[] bArr5 = this.f6523j;
                this.k = i9 + 1;
                bArr5[i9] = bArr[i2];
                i3--;
                i2++;
            }
            if (this.k == 8) {
                a();
            }
        }
        this.f6522i = 1;
        while (true) {
            int i10 = this.f6522i;
            if (i10 > 7) {
                return (byte[]) this.f6521h.clone();
            }
            int i11 = this.k;
            if (i11 < 8) {
                byte[] bArr6 = this.f6523j;
                this.k = i11 + 1;
                bArr6[i11] = (byte) 0;
                this.f6522i = i10 + 1;
            }
            if (this.k == 8) {
                a();
            }
        }
    }

    public byte[] b(byte[] bArr, byte[] bArr2) {
        return b(bArr, 0, bArr.length, bArr2);
    }
}
