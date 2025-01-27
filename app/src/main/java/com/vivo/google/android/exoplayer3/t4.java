package com.vivo.google.android.exoplayer3;

import android.text.SpannableStringBuilder;
import com.vivo.google.android.exoplayer3.text.Cue;
import com.vivo.google.android.exoplayer3.util.Util;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* loaded from: classes4.dex */
public final class t4 implements y3 {

    /* renamed from: a */
    public final q4 f28099a;

    /* renamed from: b */
    public final long[] f28100b;

    /* renamed from: c */
    public final Map<String, s4> f28101c;

    /* renamed from: d */
    public final Map<String, r4> f28102d;

    public t4(q4 q4Var, Map<String, s4> map, Map<String, r4> map2) {
        this.f28099a = q4Var;
        this.f28102d = map2;
        this.f28101c = map != null ? Collections.unmodifiableMap(map) : Collections.emptyMap();
        this.f28100b = q4Var.a();
    }

    @Override // com.vivo.google.android.exoplayer3.y3
    public int a() {
        return this.f28100b.length;
    }

    @Override // com.vivo.google.android.exoplayer3.y3
    public int a(long j2) {
        int binarySearchCeil = Util.binarySearchCeil(this.f28100b, j2, false, false);
        if (binarySearchCeil < this.f28100b.length) {
            return binarySearchCeil;
        }
        return -1;
    }

    @Override // com.vivo.google.android.exoplayer3.y3
    public long a(int i2) {
        return this.f28100b[i2];
    }

    @Override // com.vivo.google.android.exoplayer3.y3
    public List<Cue> b(long j2) {
        int i2;
        int i3;
        q4 q4Var = this.f28099a;
        Map<String, s4> map = this.f28101c;
        Map<String, r4> map2 = this.f28102d;
        q4Var.getClass();
        TreeMap treeMap = new TreeMap();
        q4Var.a(j2, false, q4Var.f27965g, treeMap);
        q4Var.a(map, treeMap);
        ArrayList arrayList = new ArrayList();
        for (Map.Entry entry : treeMap.entrySet()) {
            r4 r4Var = map2.get(entry.getKey());
            SpannableStringBuilder spannableStringBuilder = (SpannableStringBuilder) entry.getValue();
            int length = spannableStringBuilder.length();
            int i4 = 0;
            for (int i5 = 0; i5 < length; i5++) {
                if (spannableStringBuilder.charAt(i5) == ' ') {
                    int i6 = i5 + 1;
                    int i7 = i6;
                    while (i7 < spannableStringBuilder.length() && spannableStringBuilder.charAt(i7) == ' ') {
                        i7++;
                    }
                    int i8 = i7 - i6;
                    if (i8 > 0) {
                        spannableStringBuilder.delete(i5, i5 + i8);
                        length -= i8;
                    }
                }
            }
            if (length > 0 && spannableStringBuilder.charAt(0) == ' ') {
                spannableStringBuilder.delete(0, 1);
                length--;
            }
            int i9 = 0;
            while (true) {
                i2 = length - 1;
                if (i9 >= i2) {
                    break;
                }
                if (spannableStringBuilder.charAt(i9) == '\n') {
                    int i10 = i9 + 1;
                    if (spannableStringBuilder.charAt(i10) == ' ') {
                        spannableStringBuilder.delete(i10, i9 + 2);
                        length--;
                    }
                }
                i9++;
            }
            if (length > 0 && spannableStringBuilder.charAt(i2) == ' ') {
                spannableStringBuilder.delete(i2, length);
                length--;
            }
            while (true) {
                i3 = length - 1;
                if (i4 >= i3) {
                    break;
                }
                if (spannableStringBuilder.charAt(i4) == ' ') {
                    int i11 = i4 + 1;
                    if (spannableStringBuilder.charAt(i11) == '\n') {
                        spannableStringBuilder.delete(i4, i11);
                        length--;
                    }
                }
                i4++;
            }
            if (length > 0 && spannableStringBuilder.charAt(i3) == '\n') {
                spannableStringBuilder.delete(i3, length);
            }
            arrayList.add(new Cue(spannableStringBuilder, null, r4Var.f28012c, r4Var.f28013d, r4Var.f28014e, r4Var.f28011b, Integer.MIN_VALUE, r4Var.f28015f));
        }
        return arrayList;
    }
}
