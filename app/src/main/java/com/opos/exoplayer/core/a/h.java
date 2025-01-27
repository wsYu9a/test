package com.opos.exoplayer.core.a;

import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.opos.exoplayer.core.Format;
import com.opos.exoplayer.core.drm.DrmInitData;
import com.vivo.google.android.exoplayer3.DefaultLoadControl;
import com.vivo.ic.dm.Downloads;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* loaded from: classes4.dex */
public final class h {

    /* renamed from: a */
    private static final int[] f17585a = {1, 2, 2, 2, 2, 3, 3, 4, 4, 5, 6, 6, 6, 7, 8, 8};

    /* renamed from: b */
    private static final int[] f17586b = {-1, DefaultLoadControl.DEFAULT_MAX_BUFFER_MS, 16000, 32000, -1, -1, 11025, 22050, 44100, -1, -1, 12000, 24000, 48000, -1, -1};

    /* renamed from: c */
    private static final int[] f17587c = {64, 112, 128, Downloads.Impl.STATUS_RUNNING, 224, 256, 384, 448, 512, 640, 768, 896, 1024, 1152, TTAdConstant.EXT_PLUGIN_UNINSTALL, 1536, 1920, 2048, 2304, 2560, 2688, 2816, 2823, 2944, 3072, 3840, 4096, 6144, 7680};

    public static int a(ByteBuffer byteBuffer) {
        byte b2;
        int i2;
        int i3;
        int i4;
        byte b3;
        int i5;
        int position = byteBuffer.position();
        byte b4 = byteBuffer.get(position);
        if (b4 != -2) {
            if (b4 == -1) {
                b3 = byteBuffer.get(position + 4);
                i5 = position + 7;
            } else if (b4 != 31) {
                b2 = byteBuffer.get(position + 4);
                i2 = position + 5;
            } else {
                b3 = byteBuffer.get(position + 5);
                i5 = position + 6;
            }
            i3 = (byteBuffer.get(i5) & 60) >> 2;
            i4 = (b3 & 7) << 4;
            return ((i3 | i4) + 1) * 32;
        }
        b2 = byteBuffer.get(position + 5);
        i2 = position + 4;
        i3 = (byteBuffer.get(i2) & 252) >> 2;
        i4 = (b2 & 1) << 6;
        return ((i3 | i4) + 1) * 32;
    }

    public static int a(byte[] bArr) {
        int i2;
        byte b2;
        int i3;
        byte b3;
        byte b4 = bArr[0];
        if (b4 != -2) {
            if (b4 == -1) {
                i2 = (bArr[4] & 7) << 4;
                b3 = bArr[7];
            } else if (b4 != 31) {
                i2 = (bArr[4] & 1) << 6;
                b2 = bArr[5];
            } else {
                i2 = (bArr[5] & 7) << 4;
                b3 = bArr[6];
            }
            i3 = b3 & 60;
            return (((i3 >> 2) | i2) + 1) * 32;
        }
        i2 = (bArr[5] & 1) << 6;
        b2 = bArr[4];
        i3 = b2 & 252;
        return (((i3 >> 2) | i2) + 1) * 32;
    }

    public static Format a(byte[] bArr, String str, String str2, DrmInitData drmInitData) {
        com.opos.exoplayer.core.i.l c2 = c(bArr);
        c2.b(60);
        int i2 = f17585a[c2.c(6)];
        int i3 = f17586b[c2.c(4)];
        int c3 = c2.c(5);
        int[] iArr = f17587c;
        int i4 = c3 >= iArr.length ? -1 : (iArr[c3] * 1000) / 2;
        c2.b(10);
        return Format.a(str, "audio/vnd.dts", null, i4, -1, i2 + (c2.c(2) > 0 ? 1 : 0), i3, null, drmInitData, 0, str2);
    }

    public static boolean a(int i2) {
        return i2 == 2147385345 || i2 == -25230976 || i2 == 536864768 || i2 == -14745368;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:13:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int b(byte[] r7) {
        /*
            r0 = 0
            r1 = r7[r0]
            r2 = -2
            r3 = 6
            r4 = 7
            r5 = 1
            r6 = 4
            if (r1 == r2) goto L4a
            r2 = -1
            if (r1 == r2) goto L32
            r2 = 31
            if (r1 == r2) goto L21
            r1 = 5
            r1 = r7[r1]
            r1 = r1 & 3
            int r1 = r1 << 12
            r2 = r7[r3]
            r2 = r2 & 255(0xff, float:3.57E-43)
            int r2 = r2 << r6
            r1 = r1 | r2
            r7 = r7[r4]
            goto L58
        L21:
            r0 = r7[r3]
            r0 = r0 & 3
            int r0 = r0 << 12
            r1 = r7[r4]
            r1 = r1 & 255(0xff, float:3.57E-43)
            int r1 = r1 << r6
            r0 = r0 | r1
            r1 = 8
            r7 = r7[r1]
            goto L42
        L32:
            r0 = r7[r4]
            r0 = r0 & 3
            int r0 = r0 << 12
            r1 = r7[r3]
            r1 = r1 & 255(0xff, float:3.57E-43)
            int r1 = r1 << r6
            r0 = r0 | r1
            r1 = 9
            r7 = r7[r1]
        L42:
            r7 = r7 & 60
            int r7 = r7 >> 2
            r7 = r7 | r0
            int r7 = r7 + r5
            r0 = 1
            goto L5d
        L4a:
            r1 = r7[r6]
            r1 = r1 & 3
            int r1 = r1 << 12
            r2 = r7[r4]
            r2 = r2 & 255(0xff, float:3.57E-43)
            int r2 = r2 << r6
            r1 = r1 | r2
            r7 = r7[r3]
        L58:
            r7 = r7 & 240(0xf0, float:3.36E-43)
            int r7 = r7 >> r6
            r7 = r7 | r1
            int r7 = r7 + r5
        L5d:
            if (r0 == 0) goto L63
            int r7 = r7 * 16
            int r7 = r7 / 14
        L63:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.exoplayer.core.a.h.b(byte[]):int");
    }

    private static com.opos.exoplayer.core.i.l c(byte[] bArr) {
        if (bArr[0] == Byte.MAX_VALUE) {
            return new com.opos.exoplayer.core.i.l(bArr);
        }
        byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
        if (d(copyOf)) {
            for (int i2 = 0; i2 < copyOf.length - 1; i2 += 2) {
                byte b2 = copyOf[i2];
                copyOf[i2] = copyOf[r3];
                copyOf[i2 + 1] = b2;
            }
        }
        com.opos.exoplayer.core.i.l lVar = new com.opos.exoplayer.core.i.l(copyOf);
        if (copyOf[0] == 31) {
            com.opos.exoplayer.core.i.l lVar2 = new com.opos.exoplayer.core.i.l(copyOf);
            while (lVar2.a() >= 16) {
                lVar2.b(2);
                lVar.a(lVar2.c(14), 14);
            }
        }
        lVar.a(copyOf);
        return lVar;
    }

    private static boolean d(byte[] bArr) {
        return bArr[0] == -2 || bArr[0] == -1;
    }
}
