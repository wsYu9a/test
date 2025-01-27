package com.vivo.google.android.exoplayer3;

import android.text.SpannableStringBuilder;
import com.vivo.google.android.exoplayer3.text.Cue;
import com.vivo.google.android.exoplayer3.util.Util;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* loaded from: classes4.dex */
public final class e5 implements y3 {

    /* renamed from: a */
    public final List<a5> f27394a;

    /* renamed from: b */
    public final int f27395b;

    /* renamed from: c */
    public final long[] f27396c;

    /* renamed from: d */
    public final long[] f27397d;

    public e5(List<a5> list) {
        this.f27394a = list;
        int size = list.size();
        this.f27395b = size;
        this.f27396c = new long[size * 2];
        for (int i2 = 0; i2 < this.f27395b; i2++) {
            a5 a5Var = list.get(i2);
            int i3 = i2 * 2;
            long[] jArr = this.f27396c;
            jArr[i3] = a5Var.f27136a;
            jArr[i3 + 1] = a5Var.f27137b;
        }
        long[] jArr2 = this.f27396c;
        long[] copyOf = Arrays.copyOf(jArr2, jArr2.length);
        this.f27397d = copyOf;
        Arrays.sort(copyOf);
    }

    @Override // com.vivo.google.android.exoplayer3.y3
    public int a() {
        return this.f27397d.length;
    }

    @Override // com.vivo.google.android.exoplayer3.y3
    public int a(long j2) {
        int binarySearchCeil = Util.binarySearchCeil(this.f27397d, j2, false, false);
        if (binarySearchCeil < this.f27397d.length) {
            return binarySearchCeil;
        }
        return -1;
    }

    @Override // com.vivo.google.android.exoplayer3.y3
    public long a(int i2) {
        g1.a(i2 >= 0);
        g1.a(i2 < this.f27397d.length);
        return this.f27397d[i2];
    }

    @Override // com.vivo.google.android.exoplayer3.y3
    public List<Cue> b(long j2) {
        a5 a5Var = null;
        SpannableStringBuilder spannableStringBuilder = null;
        ArrayList arrayList = null;
        for (int i2 = 0; i2 < this.f27395b; i2++) {
            long[] jArr = this.f27396c;
            int i3 = i2 * 2;
            if (jArr[i3] <= j2 && j2 < jArr[i3 + 1]) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                a5 a5Var2 = this.f27394a.get(i2);
                if (!(a5Var2.line == Float.MIN_VALUE && a5Var2.position == Float.MIN_VALUE)) {
                    arrayList.add(a5Var2);
                } else if (a5Var == null) {
                    a5Var = a5Var2;
                } else if (spannableStringBuilder == null) {
                    SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder();
                    spannableStringBuilder2.append(a5Var.text).append((CharSequence) "\n").append(a5Var2.text);
                    spannableStringBuilder = spannableStringBuilder2;
                } else {
                    spannableStringBuilder.append((CharSequence) "\n").append(a5Var2.text);
                }
            }
        }
        if (spannableStringBuilder != null) {
            arrayList.add(new a5(0L, 0L, spannableStringBuilder));
        } else if (a5Var != null) {
            arrayList.add(a5Var);
        }
        return arrayList != null ? arrayList : Collections.emptyList();
    }
}
