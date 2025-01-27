package com.ss.android.a;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.File;
import java.io.IOException;
import java.security.MessageDigest;

/* loaded from: classes4.dex */
public class c {

    /* renamed from: a */
    private static final char[] f20933a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static class a {

        /* renamed from: a */
        private int f20934a;

        /* renamed from: b */
        private int f20935b;

        /* renamed from: c */
        private int f20936c;

        /* renamed from: d */
        private long f20937d;

        /* renamed from: e */
        private String f20938e;

        private a() {
        }

        public /* synthetic */ a(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    public static String a(File file) {
        return a(file, 9, PlaybackStateCompat.ACTION_PLAY_FROM_URI);
    }

    private static String b(File file, int i10, long j10) throws Exception {
        return a(new com.ss.android.a.a(file), i10, j10);
    }

    public static String a(File file, int i10, long j10) {
        if (file != null) {
            try {
                if (file.exists()) {
                    return b(file, i10, j10);
                }
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
        return "";
    }

    private static long b(String str) throws RuntimeException {
        return (Long.parseLong(str, 16) - 31) >> 4;
    }

    public static int a(String str, File file) {
        return a(str, file, (b) null);
    }

    public static int a(String str, File file, b bVar) {
        int i10;
        long j10;
        String str2;
        if (str == null || str.length() == 0) {
            return 2;
        }
        try {
            if (bVar != null) {
                if (bVar.a() <= 0) {
                    try {
                        bVar.b();
                    } catch (Throwable unused) {
                    }
                    return 5;
                }
            } else if (file == null || !file.exists()) {
                return 5;
            }
            try {
                a a10 = a(str);
                if (a10 == null) {
                    i10 = -1;
                    j10 = -1;
                } else {
                    if (a10.f20934a > 1) {
                        return 3;
                    }
                    i10 = a10.f20936c;
                    j10 = a10.f20937d;
                }
                a aVar = null;
                try {
                    if (bVar != null) {
                        str2 = a(bVar, i10, j10);
                    } else {
                        str2 = b(file, i10, j10);
                    }
                } catch (Throwable th2) {
                    th2.printStackTrace();
                    str2 = null;
                }
                if (str2 != null && str2.length() != 0) {
                    if (a10 != null && (a10.f20934a != 1 || a10.f20935b != 1)) {
                        if (a10.f20938e != null) {
                            try {
                                aVar = a(str2);
                            } catch (Throwable unused2) {
                            }
                            if (aVar != null && a10.f20936c == aVar.f20936c && a10.f20937d == aVar.f20937d && a10.f20938e.equals(aVar.f20938e)) {
                                return 0;
                            }
                        }
                    }
                    return str2.equals(str) ? 0 : 1;
                }
                return 6;
            } catch (Throwable unused3) {
                return 4;
            }
        } catch (Throwable unused4) {
            return 99;
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(13:5|6|(6:13|14|(3:16|(1:18)|19)|(1:21)|22|(4:31|33|34|35)(3:26|27|28))|38|14|(0)|(0)|22|(1:24)|31|33|34|35) */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0043 A[Catch: all -> 0x002c, TryCatch #2 {all -> 0x002c, blocks: (B:6:0x000d, B:10:0x001a, B:14:0x0031, B:16:0x0043, B:18:0x0050, B:21:0x0067, B:22:0x0071, B:31:0x0083), top: B:5:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0067 A[Catch: all -> 0x002c, TryCatch #2 {all -> 0x002c, blocks: (B:6:0x000d, B:10:0x001a, B:14:0x0031, B:16:0x0043, B:18:0x0050, B:21:0x0067, B:22:0x0071, B:31:0x0083), top: B:5:0x000d }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String a(com.ss.android.a.b r21, int r22, long r23) throws java.lang.Exception {
        /*
            r0 = r22
            java.lang.String r1 = "MD5"
            java.security.MessageDigest r1 = java.security.MessageDigest.getInstance(r1)
            if (r1 != 0) goto Ld
            java.lang.String r0 = ""
            return r0
        Ld:
            long r9 = r21.a()     // Catch: java.lang.Throwable -> L2c
            r11 = 1
            if (r0 <= 0) goto L2f
            r2 = 0
            int r4 = (r23 > r2 ? 1 : (r23 == r2 ? 0 : -1))
            if (r4 <= 0) goto L2f
            long r2 = (long) r0     // Catch: java.lang.Throwable -> L2c
            long r2 = r2 * r23
            r4 = 8
            long r4 = r4 * r9
            r6 = 10
            long r4 = r4 / r6
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 <= 0) goto L29
            goto L2f
        L29:
            r12 = r23
            goto L31
        L2c:
            r0 = move-exception
            goto L9f
        L2f:
            r12 = r9
            r0 = 1
        L31:
            r2 = 8192(0x2000, float:1.148E-41)
            byte[] r14 = new byte[r2]     // Catch: java.lang.Throwable -> L2c
            r15 = 0
            r2 = r21
            r3 = r1
            r4 = r14
            r5 = r15
            r7 = r12
            a(r2, r3, r4, r5, r7)     // Catch: java.lang.Throwable -> L2c
            r2 = 2
            if (r0 <= r2) goto L65
            long r2 = (long) r0     // Catch: java.lang.Throwable -> L2c
            long r2 = r2 * r12
            long r2 = r9 - r2
            int r7 = r0 + (-1)
            long r4 = (long) r7     // Catch: java.lang.Throwable -> L2c
            long r17 = r2 / r4
            r8 = 1
        L4e:
            if (r8 >= r7) goto L65
            long r2 = r12 + r17
            long r15 = r15 + r2
            r2 = r21
            r3 = r1
            r4 = r14
            r5 = r15
            r19 = r7
            r20 = r8
            r7 = r12
            a(r2, r3, r4, r5, r7)     // Catch: java.lang.Throwable -> L2c
            int r8 = r20 + 1
            r7 = r19
            goto L4e
        L65:
            if (r0 <= r11) goto L71
            long r5 = r9 - r12
            r2 = r21
            r3 = r1
            r4 = r14
            r7 = r12
            a(r2, r3, r4, r5, r7)     // Catch: java.lang.Throwable -> L2c
        L71:
            byte[] r1 = r1.digest()     // Catch: java.lang.Throwable -> L2c
            java.lang.String r1 = a(r1)     // Catch: java.lang.Throwable -> L2c
            if (r0 != r11) goto L83
            int r2 = (r12 > r9 ? 1 : (r12 == r9 ? 0 : -1))
            if (r2 != 0) goto L83
            r21.b()     // Catch: java.lang.Throwable -> L82
        L82:
            return r1
        L83:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L2c
            r2.<init>()     // Catch: java.lang.Throwable -> L2c
            java.lang.String r0 = a(r0, r12)     // Catch: java.lang.Throwable -> L2c
            r2.append(r0)     // Catch: java.lang.Throwable -> L2c
            java.lang.String r0 = ";"
            r2.append(r0)     // Catch: java.lang.Throwable -> L2c
            r2.append(r1)     // Catch: java.lang.Throwable -> L2c
            java.lang.String r0 = r2.toString()     // Catch: java.lang.Throwable -> L2c
            r21.b()     // Catch: java.lang.Throwable -> L9e
        L9e:
            return r0
        L9f:
            r21.b()     // Catch: java.lang.Throwable -> La2
        La2:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.a.c.a(com.ss.android.a.b, int, long):java.lang.String");
    }

    private static void a(b bVar, MessageDigest messageDigest, byte[] bArr, long j10, long j11) throws IOException {
        bVar.a(j10, j11);
        long j12 = 0;
        while (j12 < j11) {
            int a10 = bVar.a(bArr, 0, (int) Math.min(j11 - j12, bArr.length));
            if (a10 > 0) {
                messageDigest.update(bArr, 0, a10);
                j12 += a10;
            } else {
                throw new IOException("updateSample unexpected readCount <= 0, readCount = " + a10 + ", readTotalCount = " + j12 + ", sampleSize = " + j11);
            }
        }
    }

    private static String a(byte[] bArr) {
        if (bArr != null) {
            int length = bArr.length * 2;
            char[] cArr = new char[length];
            int i10 = 0;
            for (byte b10 : bArr) {
                int i11 = i10 + 1;
                char[] cArr2 = f20933a;
                cArr[i10] = cArr2[(b10 & 255) >> 4];
                i10 += 2;
                cArr[i11] = cArr2[b10 & 15];
            }
            return new String(cArr, 0, length);
        }
        throw new NullPointerException("bytes is null");
    }

    private static String a(int i10, long j10) {
        return "ttmd5:1:1:" + a(i10) + "g" + a(j10);
    }

    private static a a(String str) throws Exception {
        if (!str.startsWith("ttmd5:")) {
            return null;
        }
        String[] split = str.split(";");
        String[] split2 = split[0].split(":");
        a aVar = new a();
        aVar.f20934a = Integer.parseInt(split2[1]);
        if (aVar.f20934a > 1) {
            return aVar;
        }
        aVar.f20935b = Integer.parseInt(split2[2]);
        String[] split3 = split2[3].split("g");
        aVar.f20936c = (int) b(split3[0]);
        aVar.f20937d = b(split3[1]);
        aVar.f20938e = split[1];
        return aVar;
    }

    private static String a(long j10) {
        return Long.toHexString((j10 << 4) + 31);
    }
}
