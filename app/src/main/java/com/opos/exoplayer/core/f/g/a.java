package com.opos.exoplayer.core.f.g;

import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.TypefaceSpan;
import com.opos.exoplayer.core.f.c;
import com.opos.exoplayer.core.f.d;
import com.opos.exoplayer.core.f.f;
import com.opos.exoplayer.core.i.m;
import com.opos.exoplayer.core.i.u;
import com.vivo.advv.virtualview.common.ExprCommon;
import com.vivo.google.android.exoplayer3.C;
import java.nio.charset.Charset;
import java.util.List;
import org.mozilla.universalchardet.prober.g;

/* loaded from: classes4.dex */
public final class a extends c {

    /* renamed from: a */
    private static final int f18748a = u.f("styl");

    /* renamed from: b */
    private static final int f18749b = u.f("tbox");

    /* renamed from: c */
    private final m f18750c;

    /* renamed from: d */
    private boolean f18751d;

    /* renamed from: e */
    private int f18752e;

    /* renamed from: f */
    private int f18753f;

    /* renamed from: g */
    private String f18754g;

    /* renamed from: h */
    private float f18755h;

    /* renamed from: i */
    private int f18756i;

    public a(List<byte[]> list) {
        super("Tx3gDecoder");
        this.f18750c = new m();
        a(list);
    }

    private static String a(m mVar) {
        char f2;
        a(mVar.b() >= 2);
        int h2 = mVar.h();
        if (h2 == 0) {
            return "";
        }
        return mVar.a(h2, Charset.forName((mVar.b() < 2 || !((f2 = mVar.f()) == 65279 || f2 == 65534)) ? "UTF-8" : "UTF-16"));
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0036  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(android.text.SpannableStringBuilder r5, int r6, int r7, int r8, int r9, int r10) {
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
        throw new UnsupportedOperationException("Method not decompiled: com.opos.exoplayer.core.f.g.a.a(android.text.SpannableStringBuilder, int, int, int, int, int):void");
    }

    private static void a(SpannableStringBuilder spannableStringBuilder, String str, String str2, int i2, int i3, int i4) {
        if (str != str2) {
            spannableStringBuilder.setSpan(new TypefaceSpan(str), i2, i3, i4 | 33);
        }
    }

    private void a(m mVar, SpannableStringBuilder spannableStringBuilder) {
        a(mVar.b() >= 12);
        int h2 = mVar.h();
        int h3 = mVar.h();
        mVar.d(2);
        int g2 = mVar.g();
        mVar.d(1);
        int o = mVar.o();
        a(spannableStringBuilder, g2, this.f18752e, h2, h3, 0);
        b(spannableStringBuilder, o, this.f18753f, h2, h3, 0);
    }

    private void a(List<byte[]> list) {
        String str = C.SANS_SERIF_NAME;
        if (list != null && list.size() == 1 && (list.get(0).length == 48 || list.get(0).length == 53)) {
            byte[] bArr = list.get(0);
            this.f18752e = bArr[24];
            this.f18753f = ((bArr[26] & 255) << 24) | ((bArr[27] & 255) << 16) | ((bArr[28] & 255) << 8) | (bArr[29] & 255);
            if ("Serif".equals(new String(bArr, 43, bArr.length - 43))) {
                str = C.SERIF_NAME;
            }
            this.f18754g = str;
            int i2 = bArr[25] * ExprCommon.OPCODE_MOD_EQ;
            this.f18756i = i2;
            boolean z = (bArr[0] & g.s) != 0;
            this.f18751d = z;
            if (z) {
                float f2 = ((bArr[11] & 255) | ((bArr[10] & 255) << 8)) / i2;
                this.f18755h = f2;
                this.f18755h = u.a(f2, 0.0f, 0.95f);
                return;
            }
        } else {
            this.f18752e = 0;
            this.f18753f = -1;
            this.f18754g = C.SANS_SERIF_NAME;
            this.f18751d = false;
        }
        this.f18755h = 0.85f;
    }

    private static void a(boolean z) {
        if (!z) {
            throw new f("Unexpected subtitle format.");
        }
    }

    private static void b(SpannableStringBuilder spannableStringBuilder, int i2, int i3, int i4, int i5, int i6) {
        if (i2 != i3) {
            spannableStringBuilder.setSpan(new ForegroundColorSpan((i2 >>> 8) | ((i2 & 255) << 24)), i4, i5, i6 | 33);
        }
    }

    @Override // com.opos.exoplayer.core.f.c
    protected d a(byte[] bArr, int i2, boolean z) {
        this.f18750c.a(bArr, i2);
        String a2 = a(this.f18750c);
        if (a2.isEmpty()) {
            return b.f18757a;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(a2);
        a(spannableStringBuilder, this.f18752e, 0, 0, spannableStringBuilder.length(), 16711680);
        b(spannableStringBuilder, this.f18753f, -1, 0, spannableStringBuilder.length(), 16711680);
        a(spannableStringBuilder, this.f18754g, C.SANS_SERIF_NAME, 0, spannableStringBuilder.length(), 16711680);
        float f2 = this.f18755h;
        while (this.f18750c.b() >= 8) {
            int d2 = this.f18750c.d();
            int o = this.f18750c.o();
            int o2 = this.f18750c.o();
            if (o2 == f18748a) {
                a(this.f18750c.b() >= 2);
                int h2 = this.f18750c.h();
                for (int i3 = 0; i3 < h2; i3++) {
                    a(this.f18750c, spannableStringBuilder);
                }
            } else if (o2 == f18749b && this.f18751d) {
                a(this.f18750c.b() >= 2);
                f2 = u.a(this.f18750c.h() / this.f18756i, 0.0f, 0.95f);
            }
            this.f18750c.c(d2 + o);
        }
        return new b(new com.opos.exoplayer.core.f.b(spannableStringBuilder, null, f2, 0, 0, Float.MIN_VALUE, Integer.MIN_VALUE, Float.MIN_VALUE));
    }
}
