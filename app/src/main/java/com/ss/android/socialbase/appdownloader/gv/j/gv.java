package com.ss.android.socialbase.appdownloader.gv.j;

import java.io.IOException;

/* loaded from: classes4.dex */
public class gv {

    /* renamed from: j */
    private int[] f24450j;
    private int[] zx;

    private gv() {
    }

    public static gv j(g gVar) throws IOException {
        zx.j(gVar, 1835009);
        int zx = gVar.zx();
        int zx2 = gVar.zx();
        int zx3 = gVar.zx();
        gVar.zx();
        int zx4 = gVar.zx();
        int zx5 = gVar.zx();
        gv gvVar = new gv();
        gvVar.f24450j = gVar.zx(zx2);
        if (zx3 != 0) {
            gVar.zx(zx3);
        }
        int i2 = (zx5 == 0 ? zx : zx5) - zx4;
        if (i2 % 4 != 0) {
            throw new IOException("String data size is not multiple of 4 (" + i2 + ").");
        }
        gvVar.zx = gVar.zx(i2 / 4);
        if (zx5 != 0) {
            int i3 = zx - zx5;
            if (i3 % 4 != 0) {
                throw new IOException("Style data size is not multiple of 4 (" + i3 + ").");
            }
            gVar.zx(i3 / 4);
        }
        return gvVar;
    }

    public String j(int i2) {
        int[] iArr;
        if (i2 < 0 || (iArr = this.f24450j) == null || i2 >= iArr.length) {
            return null;
        }
        int i3 = iArr[i2];
        int j2 = j(this.zx, i3);
        StringBuilder sb = new StringBuilder(j2);
        while (j2 != 0) {
            i3 += 2;
            sb.append((char) j(this.zx, i3));
            j2--;
        }
        return sb.toString();
    }

    private static final int j(int[] iArr, int i2) {
        int i3 = iArr[i2 / 4];
        return (i2 % 4) / 2 == 0 ? i3 & 65535 : i3 >>> 16;
    }
}
