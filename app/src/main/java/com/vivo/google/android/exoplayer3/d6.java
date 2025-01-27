package com.vivo.google.android.exoplayer3;

import java.io.File;
import java.util.regex.Pattern;

/* loaded from: classes4.dex */
public final class d6 extends a6 {

    /* renamed from: g */
    public static final Pattern f27296g = Pattern.compile("^(.+)\\.(\\d+)\\.(\\d+)\\.v1\\.exo$", 32);

    /* renamed from: h */
    public static final Pattern f27297h = Pattern.compile("^(.+)\\.(\\d+)\\.(\\d+)\\.v2\\.exo$", 32);

    /* renamed from: i */
    public static final Pattern f27298i = Pattern.compile("^(\\d+)\\.(\\d+)\\.(\\d+)\\.v3\\.exo$", 32);

    public d6(String str, long j2, long j3, long j4, File file) {
        super(str, j2, j3, j4, file);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x006e, code lost:
    
        if (r16.renameTo(r1) == false) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x002a, code lost:
    
        if (r1 == null) goto L50;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.vivo.google.android.exoplayer3.d6 a(java.io.File r16, com.vivo.google.android.exoplayer3.c6 r17) {
        /*
            r0 = r17
            java.lang.String r1 = r16.getName()
            java.lang.String r2 = ".v3.exo"
            boolean r2 = r1.endsWith(r2)
            r3 = 3
            r4 = 2
            r5 = 1
            r6 = 0
            if (r2 != 0) goto L7b
            java.lang.String r1 = r16.getName()
            java.util.regex.Pattern r2 = com.vivo.google.android.exoplayer3.d6.f27297h
            java.util.regex.Matcher r2 = r2.matcher(r1)
            boolean r7 = r2.matches()
            if (r7 == 0) goto L2d
            java.lang.String r1 = r2.group(r5)
            java.lang.String r1 = com.vivo.google.android.exoplayer3.util.Util.unescapeFileName(r1)
            if (r1 != 0) goto L3e
            goto L70
        L2d:
            java.util.regex.Pattern r2 = com.vivo.google.android.exoplayer3.d6.f27296g
            java.util.regex.Matcher r2 = r2.matcher(r1)
            boolean r1 = r2.matches()
            if (r1 != 0) goto L3a
            goto L70
        L3a:
            java.lang.String r1 = r2.group(r5)
        L3e:
            java.io.File r7 = r16.getParentFile()
            java.util.HashMap<java.lang.String, com.vivo.google.android.exoplayer3.b6> r8 = r0.f27258a
            java.lang.Object r8 = r8.get(r1)
            com.vivo.google.android.exoplayer3.b6 r8 = (com.vivo.google.android.exoplayer3.b6) r8
            if (r8 != 0) goto L52
            r8 = -1
            com.vivo.google.android.exoplayer3.b6 r8 = r0.a(r1, r8)
        L52:
            int r8 = r8.f27227a
            java.lang.String r1 = r2.group(r4)
            long r9 = java.lang.Long.parseLong(r1)
            java.lang.String r1 = r2.group(r3)
            long r11 = java.lang.Long.parseLong(r1)
            java.io.File r1 = a(r7, r8, r9, r11)
            r2 = r16
            boolean r2 = r2.renameTo(r1)
            if (r2 != 0) goto L71
        L70:
            r1 = r6
        L71:
            if (r1 != 0) goto L74
            return r6
        L74:
            java.lang.String r2 = r1.getName()
            r15 = r1
            r1 = r2
            goto L7e
        L7b:
            r2 = r16
            r15 = r2
        L7e:
            java.util.regex.Pattern r2 = com.vivo.google.android.exoplayer3.d6.f27298i
            java.util.regex.Matcher r1 = r2.matcher(r1)
            boolean r2 = r1.matches()
            if (r2 != 0) goto L8b
            return r6
        L8b:
            long r11 = r15.length()
            java.lang.String r2 = r1.group(r5)
            int r2 = java.lang.Integer.parseInt(r2)
            android.util.SparseArray<java.lang.String> r0 = r0.f27259b
            java.lang.Object r0 = r0.get(r2)
            r8 = r0
            java.lang.String r8 = (java.lang.String) r8
            if (r8 != 0) goto La3
            goto Lb9
        La3:
            com.vivo.google.android.exoplayer3.d6 r6 = new com.vivo.google.android.exoplayer3.d6
            java.lang.String r0 = r1.group(r4)
            long r9 = java.lang.Long.parseLong(r0)
            java.lang.String r0 = r1.group(r3)
            long r13 = java.lang.Long.parseLong(r0)
            r7 = r6
            r7.<init>(r8, r9, r11, r13, r15)
        Lb9:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vivo.google.android.exoplayer3.d6.a(java.io.File, com.vivo.google.android.exoplayer3.c6):com.vivo.google.android.exoplayer3.d6");
    }

    public static File a(File file, int i2, long j2, long j3) {
        return new File(file, i2 + "." + j2 + "." + j3 + ".v3.exo");
    }
}
