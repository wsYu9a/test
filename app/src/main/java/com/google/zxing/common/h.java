package com.google.zxing.common;

import com.google.zxing.NotFoundException;

/* loaded from: classes.dex */
public abstract class h {

    /* renamed from: a */
    private static h f8313a = new e();

    /* JADX WARN: Removed duplicated region for block: B:14:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0075  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected static void a(com.google.zxing.common.b r9, float[] r10) throws com.google.zxing.NotFoundException {
        /*
            int r0 = r9.l()
            int r9 = r9.h()
            r1 = 0
            r2 = 1
            r3 = 0
            r4 = 1
        Lc:
            int r5 = r10.length
            r6 = 0
            r7 = -1
            if (r3 >= r5) goto L48
            if (r4 == 0) goto L48
            r4 = r10[r3]
            int r4 = (int) r4
            int r5 = r3 + 1
            r8 = r10[r5]
            int r8 = (int) r8
            if (r4 < r7) goto L43
            if (r4 > r0) goto L43
            if (r8 < r7) goto L43
            if (r8 > r9) goto L43
            if (r4 != r7) goto L29
            r10[r3] = r6
        L27:
            r4 = 1
            goto L32
        L29:
            if (r4 != r0) goto L31
            int r4 = r0 + (-1)
            float r4 = (float) r4
            r10[r3] = r4
            goto L27
        L31:
            r4 = 0
        L32:
            if (r8 != r7) goto L38
            r10[r5] = r6
        L36:
            r4 = 1
            goto L40
        L38:
            if (r8 != r9) goto L40
            int r4 = r9 + (-1)
            float r4 = (float) r4
            r10[r5] = r4
            goto L36
        L40:
            int r3 = r3 + 2
            goto Lc
        L43:
            com.google.zxing.NotFoundException r9 = com.google.zxing.NotFoundException.getNotFoundInstance()
            throw r9
        L48:
            int r3 = r10.length
            int r3 = r3 + (-2)
            r4 = 1
        L4c:
            if (r3 < 0) goto L85
            if (r4 == 0) goto L85
            r4 = r10[r3]
            int r4 = (int) r4
            int r5 = r3 + 1
            r8 = r10[r5]
            int r8 = (int) r8
            if (r4 < r7) goto L80
            if (r4 > r0) goto L80
            if (r8 < r7) goto L80
            if (r8 > r9) goto L80
            if (r4 != r7) goto L66
            r10[r3] = r6
        L64:
            r4 = 1
            goto L6f
        L66:
            if (r4 != r0) goto L6e
            int r4 = r0 + (-1)
            float r4 = (float) r4
            r10[r3] = r4
            goto L64
        L6e:
            r4 = 0
        L6f:
            if (r8 != r7) goto L75
            r10[r5] = r6
        L73:
            r4 = 1
            goto L7d
        L75:
            if (r8 != r9) goto L7d
            int r4 = r9 + (-1)
            float r4 = (float) r4
            r10[r5] = r4
            goto L73
        L7d:
            int r3 = r3 + (-2)
            goto L4c
        L80:
            com.google.zxing.NotFoundException r9 = com.google.zxing.NotFoundException.getNotFoundInstance()
            throw r9
        L85:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.common.h.a(com.google.zxing.common.b, float[]):void");
    }

    public static h b() {
        return f8313a;
    }

    public static void e(h hVar) {
        f8313a = hVar;
    }

    public abstract b c(b bVar, int i2, int i3, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14, float f15, float f16, float f17) throws NotFoundException;

    public abstract b d(b bVar, int i2, int i3, j jVar) throws NotFoundException;
}
