package com.opos.exoplayer.core.f.f;

import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.AlignmentSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import java.util.Map;

/* loaded from: classes4.dex */
final class e {
    public static b a(b bVar, String[] strArr, Map<String, b> map) {
        if (bVar == null && strArr == null) {
            return null;
        }
        int i2 = 0;
        if (bVar == null && strArr.length == 1) {
            return map.get(strArr[0]);
        }
        if (bVar == null && strArr.length > 1) {
            b bVar2 = new b();
            int length = strArr.length;
            while (i2 < length) {
                bVar2.a(map.get(strArr[i2]));
                i2++;
            }
            return bVar2;
        }
        if (bVar != null && strArr != null && strArr.length == 1) {
            return bVar.a(map.get(strArr[0]));
        }
        if (bVar == null || strArr == null || strArr.length <= 1) {
            return bVar;
        }
        int length2 = strArr.length;
        while (i2 < length2) {
            bVar.a(map.get(strArr[i2]));
            i2++;
        }
        return bVar;
    }

    static String a(String str) {
        return str.replaceAll("\r\n", "\n").replaceAll(" *\n *", "\n").replaceAll("\n", " ").replaceAll("[ \t\\x0B\f\r]+", " ");
    }

    static void a(SpannableStringBuilder spannableStringBuilder) {
        int length = spannableStringBuilder.length() - 1;
        while (length >= 0 && spannableStringBuilder.charAt(length) == ' ') {
            length--;
        }
        if (length < 0 || spannableStringBuilder.charAt(length) == '\n') {
            return;
        }
        spannableStringBuilder.append('\n');
    }

    public static void a(SpannableStringBuilder spannableStringBuilder, int i2, int i3, b bVar) {
        Object absoluteSizeSpan;
        if (bVar.a() != -1) {
            spannableStringBuilder.setSpan(new StyleSpan(bVar.a()), i2, i3, 33);
        }
        if (bVar.b()) {
            spannableStringBuilder.setSpan(new StrikethroughSpan(), i2, i3, 33);
        }
        if (bVar.c()) {
            spannableStringBuilder.setSpan(new UnderlineSpan(), i2, i3, 33);
        }
        if (bVar.f()) {
            spannableStringBuilder.setSpan(new ForegroundColorSpan(bVar.e()), i2, i3, 33);
        }
        if (bVar.h()) {
            spannableStringBuilder.setSpan(new BackgroundColorSpan(bVar.g()), i2, i3, 33);
        }
        if (bVar.d() != null) {
            spannableStringBuilder.setSpan(new TypefaceSpan(bVar.d()), i2, i3, 33);
        }
        if (bVar.j() != null) {
            spannableStringBuilder.setSpan(new AlignmentSpan.Standard(bVar.j()), i2, i3, 33);
        }
        int k = bVar.k();
        if (k == 1) {
            absoluteSizeSpan = new AbsoluteSizeSpan((int) bVar.l(), true);
        } else if (k == 2) {
            absoluteSizeSpan = new RelativeSizeSpan(bVar.l());
        } else if (k != 3) {
            return;
        } else {
            absoluteSizeSpan = new RelativeSizeSpan(bVar.l() / 100.0f);
        }
        spannableStringBuilder.setSpan(absoluteSizeSpan, i2, i3, 33);
    }
}
