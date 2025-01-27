package com.vivo.google.android.exoplayer3;

import com.vivo.google.android.exoplayer3.metadata.Metadata;
import com.vivo.google.android.exoplayer3.metadata.id3.ApicFrame;
import com.vivo.google.android.exoplayer3.metadata.id3.BinaryFrame;
import com.vivo.google.android.exoplayer3.metadata.id3.ChapterFrame;
import com.vivo.google.android.exoplayer3.metadata.id3.ChapterTocFrame;
import com.vivo.google.android.exoplayer3.metadata.id3.CommentFrame;
import com.vivo.google.android.exoplayer3.metadata.id3.GeobFrame;
import com.vivo.google.android.exoplayer3.metadata.id3.Id3Frame;
import com.vivo.google.android.exoplayer3.metadata.id3.PrivFrame;
import com.vivo.google.android.exoplayer3.metadata.id3.TextInformationFrame;
import com.vivo.google.android.exoplayer3.metadata.id3.UrlLinkFrame;
import com.vivo.google.android.exoplayer3.util.Util;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

/* loaded from: classes4.dex */
public final class j3 implements f3 {

    /* renamed from: b */
    public static final int f27538b = Util.getIntegerCodeForString("ID3");

    /* renamed from: a */
    public final a f27539a;

    public interface a {
    }

    public static final class b {

        /* renamed from: a */
        public final int f27540a;

        /* renamed from: b */
        public final boolean f27541b;

        /* renamed from: c */
        public final int f27542c;

        public b(int i2, boolean z, int i3) {
            this.f27540a = i2;
            this.f27541b = z;
            this.f27542c = i3;
        }
    }

    public j3(a aVar) {
        this.f27539a = aVar;
    }

    public static int a(int i2) {
        return (i2 == 0 || i2 == 3) ? 1 : 2;
    }

    public static int a(byte[] bArr, int i2, int i3) {
        int b2 = b(bArr, i2);
        if (i3 == 0 || i3 == 3) {
            return b2;
        }
        while (b2 < bArr.length - 1) {
            if (b2 % 2 == 0 && bArr[b2 + 1] == 0) {
                return b2;
            }
            b2 = b(bArr, b2 + 1);
        }
        return bArr.length;
    }

    public static String a(int i2, int i3, int i4, int i5, int i6) {
        return i2 == 2 ? String.format(Locale.US, "%c%c%c", Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)) : String.format(Locale.US, "%c%c%c%c", Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6));
    }

    public static int b(byte[] bArr, int i2) {
        while (i2 < bArr.length) {
            if (bArr[i2] == 0) {
                return i2;
            }
            i2++;
        }
        return bArr.length;
    }

    public static ChapterTocFrame b(n6 n6Var, int i2, int i3, boolean z, int i4, a aVar) {
        int i5 = n6Var.f27875b;
        int b2 = b(n6Var.f27874a, i5);
        String str = new String(n6Var.f27874a, i5, b2 - i5, "ISO-8859-1");
        n6Var.d(b2 + 1);
        int l = n6Var.l();
        boolean z2 = (l & 2) != 0;
        boolean z3 = (l & 1) != 0;
        int l2 = n6Var.l();
        String[] strArr = new String[l2];
        for (int i6 = 0; i6 < l2; i6++) {
            int i7 = n6Var.f27875b;
            int b3 = b(n6Var.f27874a, i7);
            strArr[i6] = new String(n6Var.f27874a, i7, b3 - i7, "ISO-8859-1");
            n6Var.d(b3 + 1);
        }
        ArrayList arrayList = new ArrayList();
        int i8 = i5 + i2;
        while (n6Var.f27875b < i8) {
            Id3Frame a2 = a(i3, n6Var, z, i4, aVar);
            if (a2 != null) {
                arrayList.add(a2);
            }
        }
        Id3Frame[] id3FrameArr = new Id3Frame[arrayList.size()];
        arrayList.toArray(id3FrameArr);
        return new ChapterTocFrame(str, z2, z3, strArr, id3FrameArr);
    }

    public static String b(int i2) {
        return i2 != 1 ? i2 != 2 ? i2 != 3 ? "ISO-8859-1" : "UTF-8" : "UTF-16BE" : "UTF-16";
    }

    public static PrivFrame c(n6 n6Var, int i2) {
        byte[] bArr = new byte[i2];
        System.arraycopy(n6Var.f27874a, n6Var.f27875b, bArr, 0, i2);
        n6Var.f27875b += i2;
        int b2 = b(bArr, 0);
        String str = new String(bArr, 0, b2, "ISO-8859-1");
        int i3 = b2 + 1;
        return new PrivFrame(str, i3 < i2 ? Arrays.copyOfRange(bArr, i3, i2) : new byte[0]);
    }

    public static TextInformationFrame d(n6 n6Var, int i2) {
        if (i2 < 1) {
            return null;
        }
        int l = n6Var.l();
        String b2 = b(l);
        int i3 = i2 - 1;
        byte[] bArr = new byte[i3];
        System.arraycopy(n6Var.f27874a, n6Var.f27875b, bArr, 0, i3);
        n6Var.f27875b += i3;
        int a2 = a(bArr, 0, l);
        String str = new String(bArr, 0, a2, b2);
        int a3 = a2 + a(l);
        return new TextInformationFrame("TXXX", str, a3 < i3 ? new String(bArr, a3, a(bArr, a3, l) - a3, b2) : "");
    }

    public static UrlLinkFrame e(n6 n6Var, int i2) {
        if (i2 < 1) {
            return null;
        }
        int l = n6Var.l();
        String b2 = b(l);
        int i3 = i2 - 1;
        byte[] bArr = new byte[i3];
        System.arraycopy(n6Var.f27874a, n6Var.f27875b, bArr, 0, i3);
        n6Var.f27875b += i3;
        int a2 = a(bArr, 0, l);
        String str = new String(bArr, 0, a2, b2);
        int a3 = a2 + a(l);
        return new UrlLinkFrame("WXXX", str, a3 < i3 ? new String(bArr, a3, b(bArr, a3) - a3, "ISO-8859-1") : "");
    }

    public static int f(n6 n6Var, int i2) {
        byte[] bArr = n6Var.f27874a;
        int i3 = n6Var.f27875b;
        while (true) {
            int i4 = i3 + 1;
            if (i4 >= i2) {
                return i2;
            }
            if ((bArr[i3] & 255) == 255 && bArr[i4] == 0) {
                System.arraycopy(bArr, i3 + 2, bArr, i4, (i2 - i3) - 2);
                i2--;
            }
            i3 = i4;
        }
    }

    @Override // com.vivo.google.android.exoplayer3.f3
    public Metadata a(h3 h3Var) {
        ByteBuffer byteBuffer = h3Var.f28192c;
        return a(byteBuffer.array(), byteBuffer.limit());
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x004b, code lost:
    
        if (((r7 & 64) != 0) != false) goto L85;
     */
    /* JADX WARN: Removed duplicated region for block: B:19:0x009d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x009e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.vivo.google.android.exoplayer3.metadata.Metadata a(byte[] r12, int r13) {
        /*
            Method dump skipped, instructions count: 244
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vivo.google.android.exoplayer3.j3.a(byte[], int):com.vivo.google.android.exoplayer3.metadata.Metadata");
    }

    public static UrlLinkFrame c(n6 n6Var, int i2, String str) {
        byte[] bArr = new byte[i2];
        System.arraycopy(n6Var.f27874a, n6Var.f27875b, bArr, 0, i2);
        n6Var.f27875b += i2;
        return new UrlLinkFrame(str, null, new String(bArr, 0, b(bArr, 0), "ISO-8859-1"));
    }

    public static GeobFrame b(n6 n6Var, int i2) {
        int l = n6Var.l();
        String b2 = b(l);
        int i3 = i2 - 1;
        byte[] bArr = new byte[i3];
        System.arraycopy(n6Var.f27874a, n6Var.f27875b, bArr, 0, i3);
        n6Var.f27875b += i3;
        int b3 = b(bArr, 0);
        String str = new String(bArr, 0, b3, "ISO-8859-1");
        int i4 = b3 + 1;
        int a2 = a(bArr, i4, l);
        String str2 = new String(bArr, i4, a2 - i4, b2);
        int a3 = a2 + a(l);
        int a4 = a(bArr, a3, l);
        return new GeobFrame(str, str2, new String(bArr, a3, a4 - a3, b2), Arrays.copyOfRange(bArr, a4 + a(l), i3));
    }

    public static TextInformationFrame b(n6 n6Var, int i2, String str) {
        if (i2 < 1) {
            return null;
        }
        int l = n6Var.l();
        String b2 = b(l);
        int i3 = i2 - 1;
        byte[] bArr = new byte[i3];
        System.arraycopy(n6Var.f27874a, n6Var.f27875b, bArr, 0, i3);
        n6Var.f27875b += i3;
        return new TextInformationFrame(str, null, new String(bArr, 0, a(bArr, 0, l), b2));
    }

    public static ApicFrame a(n6 n6Var, int i2, int i3) {
        int b2;
        String str;
        int l = n6Var.l();
        String b3 = b(l);
        int i4 = i2 - 1;
        byte[] bArr = new byte[i4];
        System.arraycopy(n6Var.f27874a, n6Var.f27875b, bArr, 0, i4);
        n6Var.f27875b += i4;
        if (i3 == 2) {
            str = "image/" + Util.toLowerInvariant(new String(bArr, 0, 3, "ISO-8859-1"));
            if (str.equals("image/jpg")) {
                str = "image/jpeg";
            }
            b2 = 2;
        } else {
            b2 = b(bArr, 0);
            String lowerInvariant = Util.toLowerInvariant(new String(bArr, 0, b2, "ISO-8859-1"));
            if (lowerInvariant.indexOf(47) == -1) {
                str = "image/" + lowerInvariant;
            } else {
                str = lowerInvariant;
            }
        }
        int i5 = bArr[b2 + 1] & 255;
        int i6 = b2 + 2;
        int a2 = a(bArr, i6, l);
        return new ApicFrame(str, new String(bArr, i6, a2 - i6, b3), i5, Arrays.copyOfRange(bArr, a2 + a(l), i4));
    }

    public static BinaryFrame a(n6 n6Var, int i2, String str) {
        byte[] bArr = new byte[i2];
        System.arraycopy(n6Var.f27874a, n6Var.f27875b, bArr, 0, i2);
        n6Var.f27875b += i2;
        return new BinaryFrame(str, bArr);
    }

    public static ChapterFrame a(n6 n6Var, int i2, int i3, boolean z, int i4, a aVar) {
        int i5 = n6Var.f27875b;
        int b2 = b(n6Var.f27874a, i5);
        String str = new String(n6Var.f27874a, i5, b2 - i5, "ISO-8859-1");
        n6Var.d(b2 + 1);
        int c2 = n6Var.c();
        int c3 = n6Var.c();
        long m = n6Var.m();
        long j2 = m == 4294967295L ? -1L : m;
        long m2 = n6Var.m();
        long j3 = m2 == 4294967295L ? -1L : m2;
        ArrayList arrayList = new ArrayList();
        int i6 = i5 + i2;
        while (n6Var.f27875b < i6) {
            Id3Frame a2 = a(i3, n6Var, z, i4, aVar);
            if (a2 != null) {
                arrayList.add(a2);
            }
        }
        Id3Frame[] id3FrameArr = new Id3Frame[arrayList.size()];
        arrayList.toArray(id3FrameArr);
        return new ChapterFrame(str, c2, c3, j2, j3, id3FrameArr);
    }

    public static CommentFrame a(n6 n6Var, int i2) {
        if (i2 < 4) {
            return null;
        }
        int l = n6Var.l();
        String b2 = b(l);
        byte[] bArr = new byte[3];
        System.arraycopy(n6Var.f27874a, n6Var.f27875b, bArr, 0, 3);
        n6Var.f27875b += 3;
        String str = new String(bArr, 0, 3);
        int i3 = i2 - 4;
        byte[] bArr2 = new byte[i3];
        System.arraycopy(n6Var.f27874a, n6Var.f27875b, bArr2, 0, i3);
        n6Var.f27875b += i3;
        int a2 = a(bArr2, 0, l);
        String str2 = new String(bArr2, 0, a2, b2);
        int a3 = a2 + a(l);
        return new CommentFrame(str, str2, a3 < i3 ? new String(bArr2, a3, a(bArr2, a3, l) - a3, b2) : "");
    }

    /* JADX WARN: Code restructure failed: missing block: B:127:0x017c, code lost:
    
        if (r11 == 67) goto L304;
     */
    /* JADX WARN: Removed duplicated region for block: B:66:0x01d0 A[Catch: all -> 0x0122, UnsupportedEncodingException -> 0x01f4, TRY_LEAVE, TryCatch #2 {UnsupportedEncodingException -> 0x01f4, all -> 0x0122, blocks: (B:63:0x0110, B:66:0x01d0, B:71:0x0117, B:78:0x0131, B:80:0x0138, B:88:0x0151, B:97:0x0166, B:104:0x017e, B:110:0x018d, B:116:0x019c, B:122:0x01b6, B:123:0x01c6), top: B:57:0x0106 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.vivo.google.android.exoplayer3.metadata.id3.Id3Frame a(int r20, com.vivo.google.android.exoplayer3.n6 r21, boolean r22, int r23, com.vivo.google.android.exoplayer3.j3.a r24) {
        /*
            Method dump skipped, instructions count: 510
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vivo.google.android.exoplayer3.j3.a(int, com.vivo.google.android.exoplayer3.n6, boolean, int, com.vivo.google.android.exoplayer3.j3$a):com.vivo.google.android.exoplayer3.metadata.id3.Id3Frame");
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0074, code lost:
    
        if ((r10 & 1) != 0) goto L113;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0082, code lost:
    
        if ((r10 & 128) != 0) goto L113;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean a(com.vivo.google.android.exoplayer3.n6 r18, int r19, int r20, boolean r21) {
        /*
            r1 = r18
            r0 = r19
            int r2 = r1.f27875b
        L6:
            int r3 = r18.a()     // Catch: java.lang.Throwable -> Lab
            r4 = 1
            r5 = r20
            if (r3 < r5) goto La7
            r3 = 3
            r6 = 0
            if (r0 < r3) goto L20
            int r7 = r18.c()     // Catch: java.lang.Throwable -> Lab
            long r8 = r18.m()     // Catch: java.lang.Throwable -> Lab
            int r10 = r18.q()     // Catch: java.lang.Throwable -> Lab
            goto L2a
        L20:
            int r7 = r18.n()     // Catch: java.lang.Throwable -> Lab
            int r8 = r18.n()     // Catch: java.lang.Throwable -> Lab
            long r8 = (long) r8
            r10 = 0
        L2a:
            r11 = 0
            if (r7 != 0) goto L38
            int r7 = (r8 > r11 ? 1 : (r8 == r11 ? 0 : -1))
            if (r7 != 0) goto L38
            if (r10 != 0) goto L38
            r1.d(r2)
            return r4
        L38:
            r7 = 4
            if (r0 != r7) goto L69
            if (r21 != 0) goto L69
            r13 = 8421504(0x808080, double:4.160776E-317)
            long r13 = r13 & r8
            int r15 = (r13 > r11 ? 1 : (r13 == r11 ? 0 : -1))
            if (r15 == 0) goto L49
            r1.d(r2)
            return r6
        L49:
            r11 = 255(0xff, double:1.26E-321)
            long r13 = r8 & r11
            r15 = 8
            long r15 = r8 >> r15
            long r15 = r15 & r11
            r17 = 7
            long r15 = r15 << r17
            long r13 = r13 | r15
            r15 = 16
            long r15 = r8 >> r15
            long r15 = r15 & r11
            r17 = 14
            long r15 = r15 << r17
            long r13 = r13 | r15
            r15 = 24
            long r8 = r8 >> r15
            long r8 = r8 & r11
            r11 = 21
            long r8 = r8 << r11
            long r8 = r8 | r13
        L69:
            if (r0 != r7) goto L77
            r3 = r10 & 64
            if (r3 == 0) goto L71
            r3 = 1
            goto L72
        L71:
            r3 = 0
        L72:
            r7 = r10 & 1
            if (r7 == 0) goto L86
            goto L87
        L77:
            if (r0 != r3) goto L85
            r3 = r10 & 32
            if (r3 == 0) goto L7f
            r3 = 1
            goto L80
        L7f:
            r3 = 0
        L80:
            r7 = r10 & 128(0x80, float:1.8E-43)
            if (r7 == 0) goto L86
            goto L87
        L85:
            r3 = 0
        L86:
            r4 = 0
        L87:
            if (r4 == 0) goto L8b
            int r3 = r3 + 4
        L8b:
            long r3 = (long) r3
            int r7 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r7 >= 0) goto L94
            r1.d(r2)
            return r6
        L94:
            int r3 = r18.a()     // Catch: java.lang.Throwable -> Lab
            long r3 = (long) r3
            int r7 = (r3 > r8 ? 1 : (r3 == r8 ? 0 : -1))
            if (r7 >= 0) goto La1
            r1.d(r2)
            return r6
        La1:
            int r3 = (int) r8
            r1.e(r3)     // Catch: java.lang.Throwable -> Lab
            goto L6
        La7:
            r1.d(r2)
            return r4
        Lab:
            r0 = move-exception
            r1.d(r2)
            goto Lb1
        Lb0:
            throw r0
        Lb1:
            goto Lb0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vivo.google.android.exoplayer3.j3.a(com.vivo.google.android.exoplayer3.n6, int, int, boolean):boolean");
    }
}
