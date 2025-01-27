package com.ss.android.j;

import android.support.v4.media.session.PlaybackStateCompat;
import com.cdo.oaps.ad.OapsKey;
import java.io.File;
import java.io.IOException;
import java.security.MessageDigest;

/* loaded from: classes4.dex */
public class i {

    /* renamed from: j */
    private static final char[] f24401j = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    private static class j {

        /* renamed from: g */
        private long f24402g;

        /* renamed from: i */
        private int f24403i;

        /* renamed from: j */
        private int f24404j;
        private String q;
        private int zx;

        private j() {
        }

        /* synthetic */ j(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    public static String j(File file) {
        return j(file, 9, PlaybackStateCompat.ACTION_PLAY_FROM_URI);
    }

    private static String zx(File file, int i2, long j2) throws Exception {
        return j(new com.ss.android.j.j(file), i2, j2);
    }

    public static String j(File file, int i2, long j2) {
        if (file != null) {
            try {
                if (file.exists()) {
                    return zx(file, i2, j2);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return "";
    }

    private static long zx(String str) throws RuntimeException {
        return (Long.parseLong(str, 16) - 31) >> 4;
    }

    public static int j(String str, File file) {
        return j(str, file, (zx) null);
    }

    public static int j(String str, File file, zx zxVar) {
        String str2;
        if (str == null || str.length() == 0) {
            return 2;
        }
        try {
            if (zxVar != null) {
                if (zxVar.j() <= 0) {
                    try {
                        zxVar.zx();
                    } catch (Throwable unused) {
                    }
                    return 5;
                }
            } else if (file == null || !file.exists()) {
                return 5;
            }
            int i2 = -1;
            long j2 = -1;
            try {
                j j3 = j(str);
                if (j3 != null) {
                    if (j3.f24404j > 1) {
                        return 3;
                    }
                    i2 = j3.f24403i;
                    j2 = j3.f24402g;
                }
                j jVar = null;
                try {
                    if (zxVar != null) {
                        str2 = j(zxVar, i2, j2);
                    } else {
                        str2 = zx(file, i2, j2);
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                    str2 = null;
                }
                if (str2 != null && str2.length() != 0) {
                    if (j3 != null && (j3.f24404j != 1 || j3.zx != 1)) {
                        if (j3.q != null) {
                            try {
                                jVar = j(str2);
                            } catch (Throwable unused2) {
                            }
                            if (jVar != null && j3.f24403i == jVar.f24403i && j3.f24402g == jVar.f24402g && j3.q.equals(jVar.q)) {
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

    /* JADX WARN: Can't wrap try/catch for region: R(13:5|6|(6:13|14|(3:16|(1:18)|19)|(1:21)|22|(4:31|32|33|34)(3:26|27|28))|38|14|(0)|(0)|22|(1:24)|31|32|33|34) */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0040 A[Catch: all -> 0x009c, TryCatch #2 {all -> 0x009c, blocks: (B:6:0x000d, B:10:0x001a, B:14:0x002e, B:16:0x0040, B:18:0x004d, B:21:0x0064, B:22:0x006e, B:31:0x0080), top: B:5:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0064 A[Catch: all -> 0x009c, TryCatch #2 {all -> 0x009c, blocks: (B:6:0x000d, B:10:0x001a, B:14:0x002e, B:16:0x0040, B:18:0x004d, B:21:0x0064, B:22:0x006e, B:31:0x0080), top: B:5:0x000d }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String j(com.ss.android.j.zx r21, int r22, long r23) throws java.lang.Exception {
        /*
            r0 = r22
            java.lang.String r1 = "MD5"
            java.security.MessageDigest r1 = java.security.MessageDigest.getInstance(r1)
            if (r1 != 0) goto Ld
            java.lang.String r0 = ""
            return r0
        Ld:
            long r9 = r21.j()     // Catch: java.lang.Throwable -> L9c
            r11 = 1
            if (r0 <= 0) goto L2c
            r2 = 0
            int r4 = (r23 > r2 ? 1 : (r23 == r2 ? 0 : -1))
            if (r4 <= 0) goto L2c
            long r2 = (long) r0     // Catch: java.lang.Throwable -> L9c
            long r2 = r2 * r23
            r4 = 8
            long r4 = r4 * r9
            r6 = 10
            long r4 = r4 / r6
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 <= 0) goto L29
            goto L2c
        L29:
            r12 = r23
            goto L2e
        L2c:
            r12 = r9
            r0 = 1
        L2e:
            r2 = 8192(0x2000, float:1.148E-41)
            byte[] r14 = new byte[r2]     // Catch: java.lang.Throwable -> L9c
            r15 = 0
            r2 = r21
            r3 = r1
            r4 = r14
            r5 = r15
            r7 = r12
            j(r2, r3, r4, r5, r7)     // Catch: java.lang.Throwable -> L9c
            r2 = 2
            if (r0 <= r2) goto L62
            long r2 = (long) r0     // Catch: java.lang.Throwable -> L9c
            long r2 = r2 * r12
            long r2 = r9 - r2
            int r7 = r0 + (-1)
            long r4 = (long) r7     // Catch: java.lang.Throwable -> L9c
            long r17 = r2 / r4
            r8 = 1
        L4b:
            if (r8 >= r7) goto L62
            long r2 = r12 + r17
            long r15 = r15 + r2
            r2 = r21
            r3 = r1
            r4 = r14
            r5 = r15
            r19 = r7
            r20 = r8
            r7 = r12
            j(r2, r3, r4, r5, r7)     // Catch: java.lang.Throwable -> L9c
            int r8 = r20 + 1
            r7 = r19
            goto L4b
        L62:
            if (r0 <= r11) goto L6e
            long r5 = r9 - r12
            r2 = r21
            r3 = r1
            r4 = r14
            r7 = r12
            j(r2, r3, r4, r5, r7)     // Catch: java.lang.Throwable -> L9c
        L6e:
            byte[] r1 = r1.digest()     // Catch: java.lang.Throwable -> L9c
            java.lang.String r1 = j(r1)     // Catch: java.lang.Throwable -> L9c
            if (r0 != r11) goto L80
            int r2 = (r12 > r9 ? 1 : (r12 == r9 ? 0 : -1))
            if (r2 != 0) goto L80
            r21.zx()     // Catch: java.lang.Throwable -> L7f
        L7f:
            return r1
        L80:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L9c
            r2.<init>()     // Catch: java.lang.Throwable -> L9c
            java.lang.String r0 = j(r0, r12)     // Catch: java.lang.Throwable -> L9c
            r2.append(r0)     // Catch: java.lang.Throwable -> L9c
            java.lang.String r0 = ";"
            r2.append(r0)     // Catch: java.lang.Throwable -> L9c
            r2.append(r1)     // Catch: java.lang.Throwable -> L9c
            java.lang.String r0 = r2.toString()     // Catch: java.lang.Throwable -> L9c
            r21.zx()     // Catch: java.lang.Throwable -> L9b
        L9b:
            return r0
        L9c:
            r0 = move-exception
            r21.zx()     // Catch: java.lang.Throwable -> La0
        La0:
            goto La2
        La1:
            throw r0
        La2:
            goto La1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.j.i.j(com.ss.android.j.zx, int, long):java.lang.String");
    }

    private static void j(zx zxVar, MessageDigest messageDigest, byte[] bArr, long j2, long j3) throws IOException {
        zxVar.j(j2, j3);
        long j4 = 0;
        while (j4 < j3) {
            int j5 = zxVar.j(bArr, 0, (int) Math.min(j3 - j4, bArr.length));
            if (j5 > 0) {
                messageDigest.update(bArr, 0, j5);
                j4 += j5;
            } else {
                throw new IOException("updateSample unexpected readCount <= 0, readCount = " + j5 + ", readTotalCount = " + j4 + ", sampleSize = " + j3);
            }
        }
    }

    private static String j(byte[] bArr) {
        if (bArr != null) {
            int length = bArr.length;
            int i2 = length * 2;
            char[] cArr = new char[i2];
            int i3 = 0;
            for (int i4 = 0; i4 < length; i4++) {
                int i5 = bArr[i4 + 0] & 255;
                int i6 = i3 + 1;
                char[] cArr2 = f24401j;
                cArr[i3] = cArr2[i5 >> 4];
                i3 = i6 + 1;
                cArr[i6] = cArr2[i5 & 15];
            }
            return new String(cArr, 0, i2);
        }
        throw new NullPointerException("bytes is null");
    }

    private static String j(int i2, long j2) {
        return "ttmd5:1:1:" + j(i2) + OapsKey.KEY_GRADE + j(j2);
    }

    private static j j(String str) throws Exception {
        if (!str.startsWith("ttmd5:")) {
            return null;
        }
        String[] split = str.split(";");
        String[] split2 = split[0].split(":");
        j jVar = new j();
        jVar.f24404j = Integer.parseInt(split2[1]);
        if (jVar.f24404j > 1) {
            return jVar;
        }
        jVar.zx = Integer.parseInt(split2[2]);
        String[] split3 = split2[3].split(OapsKey.KEY_GRADE);
        jVar.f24403i = (int) zx(split3[0]);
        jVar.f24402g = zx(split3[1]);
        jVar.q = split[1];
        return jVar;
    }

    private static String j(long j2) {
        return Long.toHexString((j2 << 4) + 31);
    }
}
