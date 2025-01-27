package com.vivo.google.android.exoplayer3;

import java.util.regex.Pattern;

/* loaded from: classes4.dex */
public final class w4 {

    /* renamed from: c */
    public static final Pattern f28245c = Pattern.compile("\\[voice=\"([^\"]*)\"\\]");

    /* renamed from: a */
    public final n6 f28246a = new n6();

    /* renamed from: b */
    public final StringBuilder f28247b = new StringBuilder();

    public static String a(n6 n6Var, StringBuilder sb) {
        boolean z = false;
        sb.setLength(0);
        int i2 = n6Var.f27875b;
        int i3 = n6Var.f27876c;
        while (i2 < i3 && !z) {
            char c2 = (char) n6Var.f27874a[i2];
            if ((c2 < 'A' || c2 > 'Z') && ((c2 < 'a' || c2 > 'z') && !((c2 >= '0' && c2 <= '9') || c2 == '#' || c2 == '-' || c2 == '.' || c2 == '_'))) {
                z = true;
            } else {
                i2++;
                sb.append(c2);
            }
        }
        n6Var.e(i2 - n6Var.f27875b);
        return sb.toString();
    }

    public static String b(n6 n6Var, StringBuilder sb) {
        a(n6Var);
        if (n6Var.a() == 0) {
            return null;
        }
        String a2 = a(n6Var, sb);
        if (!"".equals(a2)) {
            return a2;
        }
        return "" + ((char) n6Var.l());
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x0069 A[LOOP:1: B:3:0x0003->B:41:0x0069, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void a(com.vivo.google.android.exoplayer3.n6 r8) {
        /*
            r0 = 0
            r1 = 1
        L2:
            r2 = 1
        L3:
            int r3 = r8.a()
            if (r3 <= 0) goto L6b
            if (r2 == 0) goto L6b
            int r2 = r8.f27875b
            byte[] r3 = r8.f27874a
            r2 = r3[r2]
            char r2 = (char) r2
            r3 = 9
            if (r2 == r3) goto L28
            r3 = 10
            if (r2 == r3) goto L28
            r3 = 12
            if (r2 == r3) goto L28
            r3 = 13
            if (r2 == r3) goto L28
            r3 = 32
            if (r2 == r3) goto L28
            r2 = 0
            goto L2c
        L28:
            r8.e(r1)
            r2 = 1
        L2c:
            if (r2 != 0) goto L2
            int r2 = r8.f27875b
            int r3 = r8.f27876c
            byte[] r4 = r8.f27874a
            int r5 = r2 + 2
            if (r5 > r3) goto L65
            int r5 = r2 + 1
            r2 = r4[r2]
            r6 = 47
            if (r2 != r6) goto L65
            int r2 = r5 + 1
            r5 = r4[r5]
            r7 = 42
            if (r5 != r7) goto L65
        L48:
            int r5 = r2 + 1
            if (r5 >= r3) goto L5d
            r2 = r4[r2]
            char r2 = (char) r2
            if (r2 != r7) goto L5b
            r2 = r4[r5]
            char r2 = (char) r2
            if (r2 != r6) goto L5b
            int r5 = r5 + 1
            r2 = r5
            r3 = r2
            goto L48
        L5b:
            r2 = r5
            goto L48
        L5d:
            int r2 = r8.f27875b
            int r3 = r3 - r2
            r8.e(r3)
            r2 = 1
            goto L66
        L65:
            r2 = 0
        L66:
            if (r2 == 0) goto L69
            goto L2
        L69:
            r2 = 0
            goto L3
        L6b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vivo.google.android.exoplayer3.w4.a(com.vivo.google.android.exoplayer3.n6):void");
    }
}
