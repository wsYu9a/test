package s3;

import com.sigmob.sdk.archives.tar.e;
import kotlin.io.encoding.Base64;
import okio.Utf8;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a */
    public static char[] f30569a = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};

    /* renamed from: b */
    public static byte[] f30570b = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, Utf8.REPLACEMENT_BYTE, e.I, e.J, e.K, e.L, nf.c.f28888t, 57, 58, 59, 60, Base64.padSymbol, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, b5.a.f1194u, 19, b5.a.f1197x, b5.a.f1198y, b5.a.f1199z, b5.a.A, b5.a.B, b5.a.C, -1, -1, -1, -1, -1, -1, b5.a.D, b5.a.E, b5.a.F, b5.a.G, b5.a.H, b5.a.I, 32, 33, 34, 35, 36, 37, 38, 39, nf.c.f28885q, 41, 42, 43, 44, 45, 46, 47, e.E, e.F, e.G, e.H, -1, -1, -1, -1, -1};

    /* JADX WARN: Code restructure failed: missing block: B:33:0x007c, code lost:
    
        if (r2 == (-1)) goto L153;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x007e, code lost:
    
        r0.append((char) (r2 | ((r6 & 3) << 6)));
        r2 = r5;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static byte[] a(java.lang.String r9) {
        /*
            java.lang.StringBuffer r0 = new java.lang.StringBuffer
            r0.<init>()
            java.lang.String r1 = "US-ASCII"
            byte[] r9 = r9.getBytes(r1)
            int r1 = r9.length
            r2 = 0
        Ld:
            java.lang.String r3 = "iso8859-1"
            if (r2 >= r1) goto L47
        L11:
            byte[] r4 = s3.a.f30570b
            int r5 = r2 + 1
            r2 = r9[r2]
            r2 = r4[r2]
            r4 = -1
            if (r5 >= r1) goto L21
            if (r2 == r4) goto L1f
            goto L21
        L1f:
            r2 = r5
            goto L11
        L21:
            if (r2 == r4) goto L47
        L23:
            byte[] r6 = s3.a.f30570b
            int r7 = r5 + 1
            r5 = r9[r5]
            r5 = r6[r5]
            if (r7 >= r1) goto L32
            if (r5 == r4) goto L30
            goto L32
        L30:
            r5 = r7
            goto L23
        L32:
            if (r5 == r4) goto L47
            int r2 = r2 << 2
            r6 = r5 & 48
            int r6 = r6 >>> 4
            r2 = r2 | r6
            char r2 = (char) r2
            r0.append(r2)
        L3f:
            int r2 = r7 + 1
            r6 = r9[r7]
            r7 = 61
            if (r6 != r7) goto L50
        L47:
            java.lang.String r9 = r0.toString()
            byte[] r9 = r9.getBytes(r3)
            return r9
        L50:
            byte[] r8 = s3.a.f30570b
            r6 = r8[r6]
            if (r2 >= r1) goto L5b
            if (r6 == r4) goto L59
            goto L5b
        L59:
            r7 = r2
            goto L3f
        L5b:
            if (r6 == r4) goto L47
            r5 = r5 & 15
            int r5 = r5 << 4
            r8 = r6 & 60
            int r8 = r8 >>> 2
            r5 = r5 | r8
            char r5 = (char) r5
            r0.append(r5)
        L6a:
            int r5 = r2 + 1
            r2 = r9[r2]
            if (r2 != r7) goto L71
            goto L47
        L71:
            byte[] r8 = s3.a.f30570b
            r2 = r8[r2]
            if (r5 >= r1) goto L7c
            if (r2 == r4) goto L7a
            goto L7c
        L7a:
            r2 = r5
            goto L6a
        L7c:
            if (r2 == r4) goto L47
            r3 = r6 & 3
            int r3 = r3 << 6
            r2 = r2 | r3
            char r2 = (char) r2
            r0.append(r2)
            r2 = r5
            goto Ld
        */
        throw new UnsupportedOperationException("Method not decompiled: s3.a.a(java.lang.String):byte[]");
    }
}
