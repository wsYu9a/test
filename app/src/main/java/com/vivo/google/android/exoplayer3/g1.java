package com.vivo.google.android.exoplayer3;

import android.os.Trace;
import android.text.TextUtils;
import com.vivo.google.android.exoplayer3.util.Util;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: classes4.dex */
public final class g1 {
    public static int a(int i2) {
        int i3 = 0;
        while (i2 > 0) {
            i3++;
            i2 >>>= 1;
        }
        return i3;
    }

    public static int a(int i2, int i3, int i4) {
        if (i2 < i3 || i2 >= i4) {
            throw new IndexOutOfBoundsException();
        }
        return i2;
    }

    public static <T> T a(T t) {
        t.getClass();
        return t;
    }

    public static String a(XmlPullParser xmlPullParser, String str) {
        int attributeCount = xmlPullParser.getAttributeCount();
        for (int i2 = 0; i2 < attributeCount; i2++) {
            if (str.equals(xmlPullParser.getAttributeName(i2))) {
                return xmlPullParser.getAttributeValue(i2);
            }
        }
        return null;
    }

    public static void a(String str) {
        if (Util.SDK_INT >= 18) {
            Trace.beginSection(str);
        }
    }

    public static void a(boolean z) {
        if (!z) {
            throw new IllegalArgumentException();
        }
    }

    public static void a(boolean z, Object obj) {
        if (!z) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
    }

    public static boolean a(int i2, n6 n6Var, boolean z) {
        if (n6Var.a() < 7) {
            if (z) {
                return false;
            }
            throw new f("too short header: " + n6Var.a());
        }
        if (n6Var.l() != i2) {
            if (z) {
                return false;
            }
            throw new f("expected header type " + Integer.toHexString(i2));
        }
        if (n6Var.l() == 118 && n6Var.l() == 111 && n6Var.l() == 114 && n6Var.l() == 98 && n6Var.l() == 105 && n6Var.l() == 115) {
            return true;
        }
        if (z) {
            return false;
        }
        throw new f("expected characters 'vorbis'");
    }

    public static String b(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException();
        }
        return str;
    }

    public static void b(boolean z) {
        if (!z) {
            throw new IllegalStateException();
        }
    }

    public static void b(boolean z, Object obj) {
        if (!z) {
            throw new IllegalStateException(String.valueOf(obj));
        }
    }

    public static boolean b(XmlPullParser xmlPullParser, String str) {
        return (xmlPullParser.getEventType() == 2) && xmlPullParser.getName().equals(str);
    }

    public static String c(String str) {
        if (str == null) {
            return null;
        }
        int indexOf = str.indexOf(47);
        if (indexOf != -1) {
            return str.substring(0, indexOf);
        }
        throw new IllegalArgumentException("Invalid mime type: " + str);
    }

    public static boolean d(String str) {
        return "audio".equals(c(str));
    }

    public static boolean e(String str) {
        return "video".equals(c(str));
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x006b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void a(long r15, com.vivo.google.android.exoplayer3.n6 r17, com.vivo.google.android.exoplayer3.n0[] r18) {
        /*
            r0 = r17
            r1 = r18
        L4:
            int r2 = r17.a()
            r3 = 1
            if (r2 <= r3) goto La0
            r2 = 0
            r4 = 0
        Ld:
            int r5 = r17.a()
            r6 = 255(0xff, float:3.57E-43)
            r7 = -1
            if (r5 != 0) goto L18
            r5 = -1
            goto L20
        L18:
            int r5 = r17.l()
            int r4 = r4 + r5
            if (r5 == r6) goto Ld
            r5 = r4
        L20:
            r4 = 0
        L21:
            int r8 = r17.a()
            if (r8 != 0) goto L29
            r4 = -1
            goto L30
        L29:
            int r8 = r17.l()
            int r4 = r4 + r8
            if (r8 == r6) goto L21
        L30:
            if (r4 == r7) goto L99
            int r6 = r17.a()
            if (r4 <= r6) goto L39
            goto L99
        L39:
            r6 = 4
            r7 = 3
            r8 = 8
            if (r5 != r6) goto L68
            if (r4 >= r8) goto L42
            goto L68
        L42:
            int r5 = r0.f27875b
            int r6 = r17.l()
            int r9 = r17.q()
            int r10 = r17.c()
            int r11 = r17.l()
            r0.d(r5)
            r5 = 181(0xb5, float:2.54E-43)
            if (r6 != r5) goto L68
            r5 = 49
            if (r9 != r5) goto L68
            r5 = 1195456820(0x47413934, float:49465.203)
            if (r10 != r5) goto L68
            if (r11 != r7) goto L68
            r5 = 1
            goto L69
        L68:
            r5 = 0
        L69:
            if (r5 == 0) goto L94
            r0.e(r8)
            int r5 = r17.l()
            r5 = r5 & 31
            r0.e(r3)
            int r5 = r5 * 3
            int r3 = r0.f27875b
            int r6 = r1.length
        L7c:
            if (r2 >= r6) goto L91
            r8 = r1[r2]
            r0.d(r3)
            r8.a(r0, r5)
            r11 = 1
            r13 = 0
            r14 = 0
            r9 = r15
            r12 = r5
            r8.a(r9, r11, r12, r13, r14)
            int r2 = r2 + 1
            goto L7c
        L91:
            int r5 = r5 + 10
            int r4 = r4 - r5
        L94:
            r0.e(r4)
            goto L4
        L99:
            int r2 = r0.f27876c
            r0.d(r2)
            goto L4
        La0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vivo.google.android.exoplayer3.g1.a(long, com.vivo.google.android.exoplayer3.n6, com.vivo.google.android.exoplayer3.n0[]):void");
    }

    public static void a() {
        if (Util.SDK_INT >= 18) {
            Trace.endSection();
        }
    }

    public static z2 a(h0 h0Var) {
        h0Var.getClass();
        n6 n6Var = new n6(16);
        if (a3.a(h0Var, n6Var).f27134a != Util.getIntegerCodeForString("RIFF")) {
            return null;
        }
        d0 d0Var = (d0) h0Var;
        d0Var.a(n6Var.f27874a, 0, 4, false);
        n6Var.d(0);
        int c2 = n6Var.c();
        if (c2 != Util.getIntegerCodeForString("WAVE")) {
            String str = "Unsupported RIFF format: " + c2;
            return null;
        }
        a3 a2 = a3.a(h0Var, n6Var);
        while (a2.f27134a != Util.getIntegerCodeForString("fmt ")) {
            d0Var.a((int) a2.f27135b, false);
            a2 = a3.a(h0Var, n6Var);
        }
        b(a2.f27135b >= 16);
        d0Var.a(n6Var.f27874a, 0, 16, false);
        n6Var.d(0);
        int h2 = n6Var.h();
        int h3 = n6Var.h();
        int g2 = n6Var.g();
        int g3 = n6Var.g();
        int h4 = n6Var.h();
        int h5 = n6Var.h();
        int i2 = (h3 * h5) / 8;
        if (h4 != i2) {
            throw new f("Expected block alignment: " + i2 + "; got: " + h4);
        }
        int pcmEncoding = Util.getPcmEncoding(h5);
        if (pcmEncoding == 0) {
            String str2 = "Unsupported WAV bit depth: " + h5;
            return null;
        }
        if (h2 == 1 || h2 == 65534) {
            d0Var.a(((int) a2.f27135b) - 16, false);
            return new z2(h3, g2, g3, h4, h5, pcmEncoding);
        }
        String str3 = "Unsupported WAV format type: " + h2;
        return null;
    }
}
