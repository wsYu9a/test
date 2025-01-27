package com.opos.exoplayer.core.metadata.id3;

import com.opos.exoplayer.core.i.m;
import com.opos.exoplayer.core.i.u;
import com.opos.exoplayer.core.metadata.Metadata;
import com.opos.exoplayer.core.metadata.d;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

/* loaded from: classes4.dex */
public final class a implements com.opos.exoplayer.core.metadata.a {

    /* renamed from: a */
    public static final int f19145a = u.f("ID3");

    /* renamed from: b */
    private final InterfaceC0417a f19146b;

    /* renamed from: com.opos.exoplayer.core.metadata.id3.a$a */
    public interface InterfaceC0417a {
        boolean a(int i2, int i3, int i4, int i5, int i6);
    }

    private static final class b {

        /* renamed from: a */
        private final int f19147a;

        /* renamed from: b */
        private final boolean f19148b;

        /* renamed from: c */
        private final int f19149c;

        public b(int i2, boolean z, int i3) {
            this.f19147a = i2;
            this.f19148b = z;
            this.f19149c = i3;
        }
    }

    public a() {
        this(null);
    }

    public a(InterfaceC0417a interfaceC0417a) {
        this.f19146b = interfaceC0417a;
    }

    private static int a(byte[] bArr, int i2, int i3) {
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

    private static ApicFrame a(m mVar, int i2, int i3) {
        int b2;
        String str;
        int g2 = mVar.g();
        String a2 = a(g2);
        int i4 = i2 - 1;
        byte[] bArr = new byte[i4];
        mVar.a(bArr, 0, i4);
        if (i3 == 2) {
            str = "image/" + u.d(new String(bArr, 0, 3, "ISO-8859-1"));
            if (str.equals("image/jpg")) {
                str = "image/jpeg";
            }
            b2 = 2;
        } else {
            b2 = b(bArr, 0);
            String d2 = u.d(new String(bArr, 0, b2, "ISO-8859-1"));
            if (d2.indexOf(47) == -1) {
                str = "image/" + d2;
            } else {
                str = d2;
            }
        }
        byte b3 = bArr[b2 + 1];
        int i5 = b2 + 2;
        int a3 = a(bArr, i5, g2);
        return new ApicFrame(str, new String(bArr, i5, a3 - i5, a2), b3 & 255, b(bArr, b(g2) + a3, i4));
    }

    private static ChapterFrame a(m mVar, int i2, int i3, boolean z, int i4, InterfaceC0417a interfaceC0417a) {
        int d2 = mVar.d();
        int b2 = b(mVar.f19048a, d2);
        String str = new String(mVar.f19048a, d2, b2 - d2, "ISO-8859-1");
        mVar.c(b2 + 1);
        int o = mVar.o();
        int o2 = mVar.o();
        long m = mVar.m();
        long j2 = m == 4294967295L ? -1L : m;
        long m2 = mVar.m();
        long j3 = m2 == 4294967295L ? -1L : m2;
        ArrayList arrayList = new ArrayList();
        while (mVar.d() < d2 + i2) {
            Id3Frame a2 = a(i3, mVar, z, i4, interfaceC0417a);
            if (a2 != null) {
                arrayList.add(a2);
            }
        }
        Id3Frame[] id3FrameArr = new Id3Frame[arrayList.size()];
        arrayList.toArray(id3FrameArr);
        return new ChapterFrame(str, o, o2, j2, j3, id3FrameArr);
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x008e, code lost:
    
        if (r23.a(r19, r8, r9, r10, r13) == false) goto L198;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static com.opos.exoplayer.core.metadata.id3.Id3Frame a(int r19, com.opos.exoplayer.core.i.m r20, boolean r21, int r22, com.opos.exoplayer.core.metadata.id3.a.InterfaceC0417a r23) {
        /*
            Method dump skipped, instructions count: 537
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.exoplayer.core.metadata.id3.a.a(int, com.opos.exoplayer.core.i.m, boolean, int, com.opos.exoplayer.core.metadata.id3.a$a):com.opos.exoplayer.core.metadata.id3.Id3Frame");
    }

    private static TextInformationFrame a(m mVar, int i2) {
        if (i2 < 1) {
            return null;
        }
        int g2 = mVar.g();
        String a2 = a(g2);
        int i3 = i2 - 1;
        byte[] bArr = new byte[i3];
        mVar.a(bArr, 0, i3);
        int a3 = a(bArr, 0, g2);
        String str = new String(bArr, 0, a3, a2);
        int b2 = a3 + b(g2);
        return new TextInformationFrame("TXXX", str, a(bArr, b2, a(bArr, b2, g2), a2));
    }

    private static TextInformationFrame a(m mVar, int i2, String str) {
        if (i2 < 1) {
            return null;
        }
        int g2 = mVar.g();
        String a2 = a(g2);
        int i3 = i2 - 1;
        byte[] bArr = new byte[i3];
        mVar.a(bArr, 0, i3);
        return new TextInformationFrame(str, null, new String(bArr, 0, a(bArr, 0, g2), a2));
    }

    private static b a(m mVar) {
        StringBuilder sb;
        String str;
        String str2;
        if (mVar.b() < 10) {
            str2 = "Data too short to be an ID3 tag";
        } else {
            int k = mVar.k();
            if (k == f19145a) {
                k = mVar.g();
                mVar.d(1);
                int g2 = mVar.g();
                int t = mVar.t();
                if (k == 2) {
                    if ((g2 & 64) != 0) {
                        str2 = "Skipped ID3 tag with majorVersion=2 and undefined compression scheme";
                    }
                } else if (k == 3) {
                    if ((g2 & 64) != 0) {
                        int o = mVar.o();
                        mVar.d(o);
                        t -= o + 4;
                    }
                } else if (k == 4) {
                    if ((g2 & 64) != 0) {
                        int t2 = mVar.t();
                        mVar.d(t2 - 4);
                        t -= t2;
                    }
                    if ((g2 & 16) != 0) {
                        t -= 10;
                    }
                } else {
                    sb = new StringBuilder();
                    str = "Skipped ID3 tag with unsupported majorVersion=";
                }
                return new b(k, k < 4 && (g2 & 128) != 0, t);
            }
            sb = new StringBuilder();
            str = "Unexpected first three bytes of ID3 tag header: ";
            sb.append(str);
            sb.append(k);
            str2 = sb.toString();
        }
        com.opos.cmn.an.f.a.c("Id3Decoder", str2);
        return null;
    }

    private static String a(int i2) {
        return i2 != 0 ? i2 != 1 ? i2 != 2 ? i2 != 3 ? "ISO-8859-1" : "UTF-8" : "UTF-16BE" : "UTF-16" : "ISO-8859-1";
    }

    private static String a(int i2, int i3, int i4, int i5, int i6) {
        return i2 == 2 ? String.format(Locale.US, "%c%c%c", Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)) : String.format(Locale.US, "%c%c%c%c", Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6));
    }

    private static String a(byte[] bArr, int i2, int i3, String str) {
        return (i3 <= i2 || i3 > bArr.length) ? "" : new String(bArr, i2, i3 - i2, str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0045, code lost:
    
        r20.c(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:?, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0077, code lost:
    
        if ((r10 & 1) != 0) goto L106;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0087, code lost:
    
        if ((r10 & 128) != 0) goto L106;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean a(com.opos.exoplayer.core.i.m r20, int r21, int r22, boolean r23) {
        /*
            r1 = r20
            r0 = r21
            int r2 = r20.d()
        L8:
            int r3 = r20.b()     // Catch: java.lang.Throwable -> Laa
            r4 = 1
            r5 = 0
            r6 = r22
            if (r3 < r6) goto La6
            r3 = 3
            if (r0 < r3) goto L22
            int r7 = r20.o()     // Catch: java.lang.Throwable -> Laa
            long r8 = r20.m()     // Catch: java.lang.Throwable -> Laa
            int r10 = r20.h()     // Catch: java.lang.Throwable -> Laa
            goto L2c
        L22:
            int r7 = r20.k()     // Catch: java.lang.Throwable -> Laa
            int r8 = r20.k()     // Catch: java.lang.Throwable -> Laa
            long r8 = (long) r8
            r10 = 0
        L2c:
            r11 = 0
            if (r7 != 0) goto L38
            int r7 = (r8 > r11 ? 1 : (r8 == r11 ? 0 : -1))
            if (r7 != 0) goto L38
            if (r10 != 0) goto L38
            goto La6
        L38:
            r7 = 4
            if (r0 != r7) goto L6c
            if (r23 != 0) goto L6c
            r13 = 8421504(0x808080, double:4.160776E-317)
            long r13 = r13 & r8
            int r15 = (r13 > r11 ? 1 : (r13 == r11 ? 0 : -1))
            if (r15 == 0) goto L4a
        L45:
            r1.c(r2)
            r4 = 0
            goto La9
        L4a:
            r11 = 24
            long r11 = r8 >> r11
            r13 = 255(0xff, double:1.26E-321)
            long r11 = r11 & r13
            r15 = 21
            long r11 = r11 << r15
            long r15 = r8 & r13
            r17 = 8
            long r17 = r8 >> r17
            long r17 = r17 & r13
            r19 = 7
            long r17 = r17 << r19
            long r15 = r15 | r17
            r17 = 16
            long r8 = r8 >> r17
            long r8 = r8 & r13
            r13 = 14
            long r8 = r8 << r13
            long r8 = r8 | r15
            long r8 = r8 | r11
        L6c:
            if (r0 != r7) goto L7c
            r3 = r10 & 64
            if (r3 == 0) goto L74
            r3 = 1
            goto L75
        L74:
            r3 = 0
        L75:
            r7 = r10 & 1
            if (r7 == 0) goto L7a
            goto L8c
        L7a:
            r4 = 0
            goto L8c
        L7c:
            if (r0 != r3) goto L8a
            r3 = r10 & 32
            if (r3 == 0) goto L84
            r3 = 1
            goto L85
        L84:
            r3 = 0
        L85:
            r7 = r10 & 128(0x80, float:1.8E-43)
            if (r7 == 0) goto L7a
            goto L8c
        L8a:
            r3 = 0
            goto L7a
        L8c:
            if (r4 == 0) goto L90
            int r3 = r3 + 4
        L90:
            long r3 = (long) r3
            int r7 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r7 >= 0) goto L96
        L95:
            goto L45
        L96:
            int r3 = r20.b()     // Catch: java.lang.Throwable -> Laa
            long r3 = (long) r3     // Catch: java.lang.Throwable -> Laa
            int r7 = (r3 > r8 ? 1 : (r3 == r8 ? 0 : -1))
            if (r7 >= 0) goto La0
            goto L95
        La0:
            int r3 = (int) r8     // Catch: java.lang.Throwable -> Laa
            r1.d(r3)     // Catch: java.lang.Throwable -> Laa
            goto L8
        La6:
            r1.c(r2)
        La9:
            return r4
        Laa:
            r0 = move-exception
            r1.c(r2)
            goto Lb0
        Laf:
            throw r0
        Lb0:
            goto Laf
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.exoplayer.core.metadata.id3.a.a(com.opos.exoplayer.core.i.m, int, int, boolean):boolean");
    }

    private static int b(int i2) {
        return (i2 == 0 || i2 == 3) ? 1 : 2;
    }

    private static int b(byte[] bArr, int i2) {
        while (i2 < bArr.length) {
            if (bArr[i2] == 0) {
                return i2;
            }
            i2++;
        }
        return bArr.length;
    }

    private static ChapterTocFrame b(m mVar, int i2, int i3, boolean z, int i4, InterfaceC0417a interfaceC0417a) {
        int d2 = mVar.d();
        int b2 = b(mVar.f19048a, d2);
        String str = new String(mVar.f19048a, d2, b2 - d2, "ISO-8859-1");
        mVar.c(b2 + 1);
        int g2 = mVar.g();
        boolean z2 = (g2 & 2) != 0;
        boolean z3 = (g2 & 1) != 0;
        int g3 = mVar.g();
        String[] strArr = new String[g3];
        for (int i5 = 0; i5 < g3; i5++) {
            int d3 = mVar.d();
            int b3 = b(mVar.f19048a, d3);
            strArr[i5] = new String(mVar.f19048a, d3, b3 - d3, "ISO-8859-1");
            mVar.c(b3 + 1);
        }
        ArrayList arrayList = new ArrayList();
        while (mVar.d() < d2 + i2) {
            Id3Frame a2 = a(i3, mVar, z, i4, interfaceC0417a);
            if (a2 != null) {
                arrayList.add(a2);
            }
        }
        Id3Frame[] id3FrameArr = new Id3Frame[arrayList.size()];
        arrayList.toArray(id3FrameArr);
        return new ChapterTocFrame(str, z2, z3, strArr, id3FrameArr);
    }

    private static UrlLinkFrame b(m mVar, int i2) {
        if (i2 < 1) {
            return null;
        }
        int g2 = mVar.g();
        String a2 = a(g2);
        int i3 = i2 - 1;
        byte[] bArr = new byte[i3];
        mVar.a(bArr, 0, i3);
        int a3 = a(bArr, 0, g2);
        String str = new String(bArr, 0, a3, a2);
        int b2 = b(g2) + a3;
        return new UrlLinkFrame("WXXX", str, a(bArr, b2, b(bArr, b2), "ISO-8859-1"));
    }

    private static UrlLinkFrame b(m mVar, int i2, String str) {
        byte[] bArr = new byte[i2];
        mVar.a(bArr, 0, i2);
        return new UrlLinkFrame(str, null, new String(bArr, 0, b(bArr, 0), "ISO-8859-1"));
    }

    private static byte[] b(byte[] bArr, int i2, int i3) {
        return i3 <= i2 ? new byte[0] : Arrays.copyOfRange(bArr, i2, i3);
    }

    private static BinaryFrame c(m mVar, int i2, String str) {
        byte[] bArr = new byte[i2];
        mVar.a(bArr, 0, i2);
        return new BinaryFrame(str, bArr);
    }

    private static PrivFrame c(m mVar, int i2) {
        byte[] bArr = new byte[i2];
        mVar.a(bArr, 0, i2);
        int b2 = b(bArr, 0);
        return new PrivFrame(new String(bArr, 0, b2, "ISO-8859-1"), b(bArr, b2 + 1, i2));
    }

    private static GeobFrame d(m mVar, int i2) {
        int g2 = mVar.g();
        String a2 = a(g2);
        int i3 = i2 - 1;
        byte[] bArr = new byte[i3];
        mVar.a(bArr, 0, i3);
        int b2 = b(bArr, 0);
        String str = new String(bArr, 0, b2, "ISO-8859-1");
        int i4 = b2 + 1;
        int a3 = a(bArr, i4, g2);
        String a4 = a(bArr, i4, a3, a2);
        int b3 = a3 + b(g2);
        int a5 = a(bArr, b3, g2);
        return new GeobFrame(str, a4, a(bArr, b3, a5, a2), b(bArr, b(g2) + a5, i3));
    }

    private static CommentFrame e(m mVar, int i2) {
        if (i2 < 4) {
            return null;
        }
        int g2 = mVar.g();
        String a2 = a(g2);
        byte[] bArr = new byte[3];
        mVar.a(bArr, 0, 3);
        String str = new String(bArr, 0, 3);
        int i3 = i2 - 4;
        byte[] bArr2 = new byte[i3];
        mVar.a(bArr2, 0, i3);
        int a3 = a(bArr2, 0, g2);
        String str2 = new String(bArr2, 0, a3, a2);
        int b2 = a3 + b(g2);
        return new CommentFrame(str, str2, a(bArr2, b2, a(bArr2, b2, g2), a2));
    }

    private static int f(m mVar, int i2) {
        byte[] bArr = mVar.f19048a;
        int d2 = mVar.d();
        while (true) {
            int i3 = d2 + 1;
            if (i3 >= i2) {
                return i2;
            }
            if ((bArr[d2] & 255) == 255 && bArr[i3] == 0) {
                System.arraycopy(bArr, d2 + 2, bArr, i3, (i2 - d2) - 2);
                i2--;
            }
            d2 = i3;
        }
    }

    @Override // com.opos.exoplayer.core.metadata.a
    public Metadata a(d dVar) {
        ByteBuffer byteBuffer = dVar.f17739b;
        return a(byteBuffer.array(), byteBuffer.limit());
    }

    public Metadata a(byte[] bArr, int i2) {
        ArrayList arrayList = new ArrayList();
        m mVar = new m(bArr, i2);
        b a2 = a(mVar);
        if (a2 == null) {
            return null;
        }
        int d2 = mVar.d();
        int i3 = a2.f19147a == 2 ? 6 : 10;
        int i4 = a2.f19149c;
        if (a2.f19148b) {
            i4 = f(mVar, a2.f19149c);
        }
        mVar.b(i4 + d2);
        boolean z = false;
        if (!a(mVar, a2.f19147a, i3, false)) {
            if (a2.f19147a != 4 || !a(mVar, 4, i3, true)) {
                com.opos.cmn.an.f.a.c("Id3Decoder", "Failed to validate ID3 tag with majorVersion=" + a2.f19147a);
                return null;
            }
            z = true;
        }
        while (mVar.b() >= i3) {
            Id3Frame a3 = a(a2.f19147a, mVar, z, i3, this.f19146b);
            if (a3 != null) {
                arrayList.add(a3);
            }
        }
        return new Metadata(arrayList);
    }
}
