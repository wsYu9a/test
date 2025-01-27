package com.vivo.google.android.exoplayer3;

import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.TypefaceSpan;
import com.vivo.advv.virtualview.common.ExprCommon;
import com.vivo.google.android.exoplayer3.text.Cue;
import com.vivo.google.android.exoplayer3.util.Util;
import java.nio.charset.Charset;
import java.util.List;

/* loaded from: classes4.dex */
public final class u4 extends w3 {
    public static final int u = Util.getIntegerCodeForString("styl");
    public static final int v = Util.getIntegerCodeForString("tbox");
    public final n6 n;
    public boolean o;
    public int p;
    public int q;
    public String r;
    public float s;
    public int t;

    public u4(List<byte[]> list) {
        super("Tx3gDecoder");
        this.n = new n6();
        a(list);
    }

    public static void a(SpannableStringBuilder spannableStringBuilder, int i2, int i3, int i4, int i5, int i6) {
        if (i2 != i3) {
            spannableStringBuilder.setSpan(new ForegroundColorSpan((i2 >>> 8) | ((i2 & 255) << 24)), i4, i5, i6 | 33);
        }
    }

    public static void a(boolean z) {
        if (!z) {
            throw new a4("Unexpected subtitle format.");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0036  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void b(android.text.SpannableStringBuilder r5, int r6, int r7, int r8, int r9, int r10) {
        /*
            if (r6 == r7) goto L4c
            r7 = r10 | 33
            r10 = r6 & 1
            r0 = 0
            r1 = 1
            if (r10 == 0) goto Lc
            r10 = 1
            goto Ld
        Lc:
            r10 = 0
        Ld:
            r2 = r6 & 2
            if (r2 == 0) goto L13
            r2 = 1
            goto L14
        L13:
            r2 = 0
        L14:
            if (r10 == 0) goto L23
            android.text.style.StyleSpan r3 = new android.text.style.StyleSpan
            if (r2 == 0) goto L1f
            r4 = 3
            r3.<init>(r4)
            goto L2b
        L1f:
            r3.<init>(r1)
            goto L2b
        L23:
            if (r2 == 0) goto L2e
            android.text.style.StyleSpan r3 = new android.text.style.StyleSpan
            r4 = 2
            r3.<init>(r4)
        L2b:
            r5.setSpan(r3, r8, r9, r7)
        L2e:
            r6 = r6 & 4
            if (r6 == 0) goto L33
            goto L34
        L33:
            r1 = 0
        L34:
            if (r1 == 0) goto L3e
            android.text.style.UnderlineSpan r6 = new android.text.style.UnderlineSpan
            r6.<init>()
            r5.setSpan(r6, r8, r9, r7)
        L3e:
            if (r1 != 0) goto L4c
            if (r10 != 0) goto L4c
            if (r2 != 0) goto L4c
            android.text.style.StyleSpan r6 = new android.text.style.StyleSpan
            r6.<init>(r0)
            r5.setSpan(r6, r8, r9, r7)
        L4c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vivo.google.android.exoplayer3.u4.b(android.text.SpannableStringBuilder, int, int, int, int, int):void");
    }

    @Override // com.vivo.google.android.exoplayer3.w3
    public y3 a(byte[] bArr, int i2, boolean z) {
        String str;
        String a2;
        n6 n6Var = this.n;
        n6Var.f27874a = bArr;
        n6Var.f27876c = i2;
        n6Var.f27875b = 0;
        a(n6Var.a() >= 2);
        int q = n6Var.q();
        if (q == 0) {
            a2 = "";
        } else {
            if (n6Var.a() >= 2) {
                byte[] bArr2 = n6Var.f27874a;
                int i3 = n6Var.f27875b;
                char c2 = (char) ((bArr2[i3 + 1] & 255) | ((bArr2[i3] & 255) << 8));
                if (c2 == 65279 || c2 == 65534) {
                    str = "UTF-16";
                    a2 = n6Var.a(q, Charset.forName(str));
                }
            }
            str = "UTF-8";
            a2 = n6Var.a(q, Charset.forName(str));
        }
        if (a2.isEmpty()) {
            return v4.f28152b;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(a2);
        b(spannableStringBuilder, this.p, 0, 0, spannableStringBuilder.length(), 16711680);
        a(spannableStringBuilder, this.q, -1, 0, spannableStringBuilder.length(), 16711680);
        String str2 = this.r;
        int length = spannableStringBuilder.length();
        if (str2 != C.SANS_SERIF_NAME) {
            spannableStringBuilder.setSpan(new TypefaceSpan(str2), 0, length, 16711713);
        }
        float f2 = this.s;
        while (this.n.a() >= 8) {
            n6 n6Var2 = this.n;
            int i4 = n6Var2.f27875b;
            int c3 = n6Var2.c();
            int c4 = this.n.c();
            if (c4 == u) {
                a(this.n.a() >= 2);
                int q2 = this.n.q();
                for (int i5 = 0; i5 < q2; i5++) {
                    n6 n6Var3 = this.n;
                    a(n6Var3.a() >= 12);
                    int q3 = n6Var3.q();
                    int q4 = n6Var3.q();
                    n6Var3.e(2);
                    int l = n6Var3.l();
                    n6Var3.e(1);
                    int c5 = n6Var3.c();
                    b(spannableStringBuilder, l, this.p, q3, q4, 0);
                    a(spannableStringBuilder, c5, this.q, q3, q4, 0);
                }
            } else if (c4 == v && this.o) {
                a(this.n.a() >= 2);
                f2 = Util.constrainValue(this.n.q() / this.t, 0.0f, 0.95f);
            }
            this.n.d(i4 + c3);
        }
        return new v4(new Cue(spannableStringBuilder, null, f2, 0, 0, Float.MIN_VALUE, Integer.MIN_VALUE, Float.MIN_VALUE));
    }

    public final void a(List<byte[]> list) {
        String str = C.SANS_SERIF_NAME;
        if (list != null && list.size() == 1 && (list.get(0).length == 48 || list.get(0).length == 53)) {
            byte[] bArr = list.get(0);
            this.p = bArr[24];
            this.q = ((bArr[26] & 255) << 24) | ((bArr[27] & 255) << 16) | ((bArr[28] & 255) << 8) | (bArr[29] & 255);
            if ("Serif".equals(new String(bArr, 43, bArr.length - 43))) {
                str = C.SERIF_NAME;
            }
            this.r = str;
            int i2 = bArr[25] * ExprCommon.OPCODE_MOD_EQ;
            this.t = i2;
            boolean z = (bArr[0] & org.mozilla.universalchardet.prober.g.s) != 0;
            this.o = z;
            if (z) {
                float f2 = ((bArr[11] & 255) | ((bArr[10] & 255) << 8)) / i2;
                this.s = f2;
                this.s = Util.constrainValue(f2, 0.0f, 0.95f);
                return;
            }
        } else {
            this.p = 0;
            this.q = -1;
            this.r = C.SANS_SERIF_NAME;
            this.o = false;
        }
        this.s = 0.85f;
    }
}
