package u5;

import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import t5.j;
import t5.k;

/* loaded from: classes2.dex */
public final class b implements j {
    /* JADX WARN: Removed duplicated region for block: B:21:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0060 A[LOOP:0: B:24:0x005e->B:25:0x0060, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0033  */
    @Override // t5.j
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public t5.k a(t5.b r11, java.util.Map<com.google.zxing.DecodeHintType, ?> r12) throws com.google.zxing.NotFoundException, com.google.zxing.FormatException {
        /*
            r10 = this;
            v5.a r0 = new v5.a
            z5.b r11 = r11.b()
            r0.<init>(r11)
            r11 = 0
            r1 = 0
            u5.a r2 = r0.b(r11)     // Catch: com.google.zxing.FormatException -> L25 com.google.zxing.NotFoundException -> L28
            t5.l[] r3 = r2.b()     // Catch: com.google.zxing.FormatException -> L25 com.google.zxing.NotFoundException -> L28
            com.google.zxing.aztec.decoder.Decoder r4 = new com.google.zxing.aztec.decoder.Decoder     // Catch: com.google.zxing.FormatException -> L21 com.google.zxing.NotFoundException -> L23
            r4.<init>()     // Catch: com.google.zxing.FormatException -> L21 com.google.zxing.NotFoundException -> L23
            z5.d r2 = r4.c(r2)     // Catch: com.google.zxing.FormatException -> L21 com.google.zxing.NotFoundException -> L23
            r4 = r3
            r3 = r1
            r1 = r2
            r2 = r3
            goto L31
        L21:
            r2 = move-exception
            goto L2b
        L23:
            r2 = move-exception
            goto L2f
        L25:
            r2 = move-exception
            r3 = r1
            goto L2b
        L28:
            r2 = move-exception
            r3 = r1
            goto L2f
        L2b:
            r4 = r3
            r3 = r2
            r2 = r1
            goto L31
        L2f:
            r4 = r3
            r3 = r1
        L31:
            if (r1 != 0) goto L45
            r1 = 1
            u5.a r0 = r0.b(r1)     // Catch: com.google.zxing.FormatException -> L47 com.google.zxing.NotFoundException -> L49
            t5.l[] r4 = r0.b()     // Catch: com.google.zxing.FormatException -> L47 com.google.zxing.NotFoundException -> L49
            com.google.zxing.aztec.decoder.Decoder r1 = new com.google.zxing.aztec.decoder.Decoder     // Catch: com.google.zxing.FormatException -> L47 com.google.zxing.NotFoundException -> L49
            r1.<init>()     // Catch: com.google.zxing.FormatException -> L47 com.google.zxing.NotFoundException -> L49
            z5.d r1 = r1.c(r0)     // Catch: com.google.zxing.FormatException -> L47 com.google.zxing.NotFoundException -> L49
        L45:
            r6 = r4
            goto L51
        L47:
            r11 = move-exception
            goto L4a
        L49:
            r11 = move-exception
        L4a:
            if (r2 != 0) goto L50
            if (r3 == 0) goto L4f
            throw r3
        L4f:
            throw r11
        L50:
            throw r2
        L51:
            if (r12 == 0) goto L68
            com.google.zxing.DecodeHintType r0 = com.google.zxing.DecodeHintType.NEED_RESULT_POINT_CALLBACK
            java.lang.Object r12 = r12.get(r0)
            t5.m r12 = (t5.m) r12
            if (r12 == 0) goto L68
            int r0 = r6.length
        L5e:
            if (r11 >= r0) goto L68
            r2 = r6[r11]
            r12.a(r2)
            int r11 = r11 + 1
            goto L5e
        L68:
            t5.k r11 = new t5.k
            java.lang.String r3 = r1.j()
            byte[] r4 = r1.g()
            int r5 = r1.e()
            com.google.zxing.BarcodeFormat r7 = com.google.zxing.BarcodeFormat.AZTEC
            long r8 = java.lang.System.currentTimeMillis()
            r2 = r11
            r2.<init>(r3, r4, r5, r6, r7, r8)
            java.util.List r12 = r1.a()
            if (r12 == 0) goto L8b
            com.google.zxing.ResultMetadataType r0 = com.google.zxing.ResultMetadataType.BYTE_SEGMENTS
            r11.j(r0, r12)
        L8b:
            java.lang.String r12 = r1.b()
            if (r12 == 0) goto L96
            com.google.zxing.ResultMetadataType r0 = com.google.zxing.ResultMetadataType.ERROR_CORRECTION_LEVEL
            r11.j(r0, r12)
        L96:
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: u5.b.a(t5.b, java.util.Map):t5.k");
    }

    @Override // t5.j
    public k b(t5.b bVar) throws NotFoundException, FormatException {
        return a(bVar, null);
    }

    @Override // t5.j
    public void reset() {
    }
}
