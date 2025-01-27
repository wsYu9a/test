package com.vivo.google.android.exoplayer3;

import com.vivo.google.android.exoplayer3.util.Util;
import com.vivo.google.android.exoplayer3.w1;
import com.vivo.ic.dm.Downloads;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import kotlin.jvm.internal.ByteCompanionObject;
import okio.Utf8;

/* loaded from: classes4.dex */
public final class q1 extends w1 {
    public i6 n;
    public a o;

    public class a implements u1, m0 {

        /* renamed from: a */
        public long[] f27944a;

        /* renamed from: b */
        public long[] f27945b;

        /* renamed from: c */
        public long f27946c = -1;

        /* renamed from: d */
        public long f27947d = -1;

        public a() {
        }

        @Override // com.vivo.google.android.exoplayer3.m0
        public long a(long j2) {
            return this.f27946c + this.f27945b[Util.binarySearchFloor(this.f27944a, (q1.this.f28224i * j2) / C.MICROS_PER_SECOND, true, true)];
        }

        @Override // com.vivo.google.android.exoplayer3.u1
        public long a(h0 h0Var) {
            long j2 = this.f27947d;
            if (j2 < 0) {
                return -1L;
            }
            long j3 = -(j2 + 2);
            this.f27947d = -1L;
            return j3;
        }

        @Override // com.vivo.google.android.exoplayer3.m0
        public boolean a() {
            return true;
        }

        @Override // com.vivo.google.android.exoplayer3.u1
        public long b(long j2) {
            long j3 = (q1.this.f28224i * j2) / C.MICROS_PER_SECOND;
            this.f27947d = this.f27944a[Util.binarySearchFloor(this.f27944a, j3, true, true)];
            return j3;
        }

        @Override // com.vivo.google.android.exoplayer3.u1
        public m0 b() {
            return this;
        }

        @Override // com.vivo.google.android.exoplayer3.m0
        public long c() {
            return (q1.this.n.f27516d * C.MICROS_PER_SECOND) / r0.f27513a;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.vivo.google.android.exoplayer3.w1
    public long a(n6 n6Var) {
        int i2;
        int i3;
        int i4;
        byte[] bArr = n6Var.f27874a;
        int i5 = -1;
        if (!(bArr[0] == -1)) {
            return -1L;
        }
        int i6 = (bArr[2] & 255) >> 4;
        switch (i6) {
            case 1:
                i5 = Downloads.Impl.STATUS_RUNNING;
                return i5;
            case 2:
            case 3:
            case 4:
            case 5:
                i2 = i6 - 2;
                i3 = 576;
                i5 = i3 << i2;
                return i5;
            case 6:
            case 7:
                n6Var.e(4);
                long j2 = n6Var.f27874a[n6Var.f27875b];
                int i7 = 7;
                while (true) {
                    if (i7 >= 0) {
                        if (((1 << i7) & j2) != 0) {
                            i7--;
                        } else if (i7 < 6) {
                            j2 &= r8 - 1;
                            i4 = 7 - i7;
                        } else if (i7 == 7) {
                            i4 = 1;
                        }
                    }
                }
                i4 = 0;
                if (i4 == 0) {
                    throw new NumberFormatException("Invalid UTF-8 sequence first byte: " + j2);
                }
                for (int i8 = 1; i8 < i4; i8++) {
                    if ((n6Var.f27874a[n6Var.f27875b + i8] & 192) != 128) {
                        throw new NumberFormatException("Invalid UTF-8 sequence continuation byte: " + j2);
                    }
                    j2 = (j2 << 6) | (r8 & Utf8.REPLACEMENT_BYTE);
                }
                n6Var.f27875b += i4;
                int l = i6 == 6 ? n6Var.l() : n6Var.q();
                n6Var.d(0);
                i5 = l + 1;
                return i5;
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
                i2 = i6 - 8;
                i3 = 256;
                i5 = i3 << i2;
                return i5;
            default:
                return i5;
        }
    }

    @Override // com.vivo.google.android.exoplayer3.w1
    public void a(boolean z) {
        super.a(z);
        if (z) {
            this.n = null;
            this.o = null;
        }
    }

    @Override // com.vivo.google.android.exoplayer3.w1
    public boolean a(n6 n6Var, long j2, w1.a aVar) {
        byte[] bArr = n6Var.f27874a;
        if (this.n == null) {
            this.n = new i6(bArr, 17);
            byte[] copyOfRange = Arrays.copyOfRange(bArr, 9, n6Var.f27876c);
            copyOfRange[4] = ByteCompanionObject.MIN_VALUE;
            List singletonList = Collections.singletonList(copyOfRange);
            i6 i6Var = this.n;
            int i2 = i6Var.f27515c;
            int i3 = i6Var.f27513a;
            aVar.f28226a = Format.createAudioSampleFormat(null, "audio/flac", null, -1, i2 * i3, i6Var.f27514b, i3, singletonList, null, 0, null);
        } else {
            if ((bArr[0] & ByteCompanionObject.MAX_VALUE) == 3) {
                a aVar2 = new a();
                this.o = aVar2;
                n6Var.e(1);
                int n = n6Var.n() / 18;
                aVar2.f27944a = new long[n];
                aVar2.f27945b = new long[n];
                for (int i4 = 0; i4 < n; i4++) {
                    aVar2.f27944a[i4] = n6Var.i();
                    aVar2.f27945b[i4] = n6Var.i();
                    n6Var.e(2);
                }
            } else if (bArr[0] == -1) {
                a aVar3 = this.o;
                if (aVar3 != null) {
                    aVar3.f27946c = j2;
                    aVar.f28227b = aVar3;
                }
                return false;
            }
        }
        return true;
    }
}
