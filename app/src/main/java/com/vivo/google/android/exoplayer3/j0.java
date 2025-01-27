package com.vivo.google.android.exoplayer3;

import com.vivo.google.android.exoplayer3.j3;
import java.util.regex.Pattern;

/* loaded from: classes4.dex */
public final class j0 {

    /* renamed from: c */
    public static final j3.a f27520c = new a();

    /* renamed from: d */
    public static final Pattern f27521d = Pattern.compile("^ [0-9a-fA-F]{8} ([0-9a-fA-F]{8}) ([0-9a-fA-F]{8})");

    /* renamed from: a */
    public int f27522a = -1;

    /* renamed from: b */
    public int f27523b = -1;

    public static class a implements j3.a {
    }

    public boolean a() {
        return (this.f27522a == -1 || this.f27523b == -1) ? false : true;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x004c A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x004d A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean a(com.vivo.google.android.exoplayer3.metadata.Metadata r8) {
        /*
            r7 = this;
            r0 = 0
            r1 = 0
        L2:
            int r2 = r8.length()
            if (r1 >= r2) goto L50
            com.vivo.google.android.exoplayer3.metadata.Metadata$Entry r2 = r8.get(r1)
            boolean r3 = r2 instanceof com.vivo.google.android.exoplayer3.metadata.id3.CommentFrame
            if (r3 == 0) goto L4d
            com.vivo.google.android.exoplayer3.metadata.id3.CommentFrame r2 = (com.vivo.google.android.exoplayer3.metadata.id3.CommentFrame) r2
            java.lang.String r3 = r2.f27797c
            java.lang.String r2 = r2.f27798d
            java.lang.String r4 = "iTunSMPB"
            boolean r3 = r4.equals(r3)
            r4 = 1
            if (r3 != 0) goto L20
            goto L49
        L20:
            java.util.regex.Pattern r3 = com.vivo.google.android.exoplayer3.j0.f27521d
            java.util.regex.Matcher r2 = r3.matcher(r2)
            boolean r3 = r2.find()
            if (r3 == 0) goto L49
            java.lang.String r3 = r2.group(r4)     // Catch: java.lang.NumberFormatException -> L49
            r5 = 16
            int r3 = java.lang.Integer.parseInt(r3, r5)     // Catch: java.lang.NumberFormatException -> L49
            r6 = 2
            java.lang.String r2 = r2.group(r6)     // Catch: java.lang.NumberFormatException -> L49
            int r2 = java.lang.Integer.parseInt(r2, r5)     // Catch: java.lang.NumberFormatException -> L49
            if (r3 > 0) goto L43
            if (r2 <= 0) goto L49
        L43:
            r7.f27522a = r3     // Catch: java.lang.NumberFormatException -> L49
            r7.f27523b = r2     // Catch: java.lang.NumberFormatException -> L49
            r2 = 1
            goto L4a
        L49:
            r2 = 0
        L4a:
            if (r2 == 0) goto L4d
            return r4
        L4d:
            int r1 = r1 + 1
            goto L2
        L50:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vivo.google.android.exoplayer3.j0.a(com.vivo.google.android.exoplayer3.metadata.Metadata):boolean");
    }
}
