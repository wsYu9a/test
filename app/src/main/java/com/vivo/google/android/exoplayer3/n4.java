package com.vivo.google.android.exoplayer3;

import android.text.Html;
import android.text.TextUtils;
import com.vivo.google.android.exoplayer3.text.Cue;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes4.dex */
public final class n4 extends w3 {
    public static final Pattern o = Pattern.compile("\\s*((?:(\\d+):)?(\\d+):(\\d+),(\\d+))\\s*-->\\s*((?:(\\d+):)?(\\d+):(\\d+),(\\d+))?\\s*");
    public final StringBuilder n;

    public n4() {
        super("SubripDecoder");
        this.n = new StringBuilder();
    }

    public static long a(Matcher matcher, int i2) {
        return ((Long.parseLong(matcher.group(i2 + 1)) * 60 * 60 * 1000) + (Long.parseLong(matcher.group(i2 + 2)) * 60 * 1000) + (Long.parseLong(matcher.group(i2 + 3)) * 1000) + Long.parseLong(matcher.group(i2 + 4))) * 1000;
    }

    @Override // com.vivo.google.android.exoplayer3.w3
    public y3 a(byte[] bArr, int i2, boolean z) {
        StringBuilder sb;
        String str;
        Matcher matcher;
        ArrayList arrayList = new ArrayList();
        long[] jArr = new long[32];
        n6 n6Var = new n6(bArr, i2);
        int i3 = 0;
        while (true) {
            String d2 = n6Var.d();
            if (d2 == null) {
                Cue[] cueArr = new Cue[arrayList.size()];
                arrayList.toArray(cueArr);
                return new o4(cueArr, Arrays.copyOf(jArr, i3));
            }
            if (d2.length() != 0) {
                try {
                    Integer.parseInt(d2);
                    d2 = n6Var.d();
                    matcher = o.matcher(d2);
                } catch (NumberFormatException unused) {
                    sb = new StringBuilder();
                    str = "Skipping invalid index: ";
                }
                if (matcher.matches()) {
                    boolean z2 = true;
                    long a2 = a(matcher, 1);
                    if (i3 == jArr.length) {
                        jArr = Arrays.copyOf(jArr, i3 * 2);
                    }
                    int i4 = i3 + 1;
                    jArr[i3] = a2;
                    if (TextUtils.isEmpty(matcher.group(6))) {
                        i3 = i4;
                        z2 = false;
                    } else {
                        long a3 = a(matcher, 6);
                        if (i4 == jArr.length) {
                            jArr = Arrays.copyOf(jArr, i4 * 2);
                        }
                        i3 = i4 + 1;
                        jArr[i4] = a3;
                    }
                    this.n.setLength(0);
                    while (true) {
                        String d3 = n6Var.d();
                        if (TextUtils.isEmpty(d3)) {
                            break;
                        }
                        if (this.n.length() > 0) {
                            this.n.append("<br>");
                        }
                        this.n.append(d3.trim());
                    }
                    arrayList.add(new Cue(Html.fromHtml(this.n.toString())));
                    if (z2) {
                        arrayList.add(null);
                    }
                } else {
                    sb = new StringBuilder();
                    str = "Skipping invalid timing: ";
                    sb.append(str);
                    sb.append(d2);
                    sb.toString();
                }
            }
        }
    }
}
