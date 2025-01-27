package com.opos.exoplayer.core.f.h;

import android.text.SpannableStringBuilder;
import com.opos.exoplayer.core.i.u;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* loaded from: classes4.dex */
final class i implements com.opos.exoplayer.core.f.d {

    /* renamed from: a */
    private final List<c> f18807a;

    /* renamed from: b */
    private final int f18808b;

    /* renamed from: c */
    private final long[] f18809c;

    /* renamed from: d */
    private final long[] f18810d;

    public i(List<c> list) {
        this.f18807a = list;
        int size = list.size();
        this.f18808b = size;
        this.f18809c = new long[size * 2];
        for (int i2 = 0; i2 < this.f18808b; i2++) {
            c cVar = list.get(i2);
            int i3 = i2 * 2;
            long[] jArr = this.f18809c;
            jArr[i3] = cVar.m;
            jArr[i3 + 1] = cVar.n;
        }
        long[] jArr2 = this.f18809c;
        long[] copyOf = Arrays.copyOf(jArr2, jArr2.length);
        this.f18810d = copyOf;
        Arrays.sort(copyOf);
    }

    @Override // com.opos.exoplayer.core.f.d
    public int a(long j2) {
        int b2 = u.b(this.f18810d, j2, false, false);
        if (b2 < this.f18810d.length) {
            return b2;
        }
        return -1;
    }

    @Override // com.opos.exoplayer.core.f.d
    public long a(int i2) {
        com.opos.exoplayer.core.i.a.a(i2 >= 0);
        com.opos.exoplayer.core.i.a.a(i2 < this.f18810d.length);
        return this.f18810d[i2];
    }

    @Override // com.opos.exoplayer.core.f.d
    public int b() {
        return this.f18810d.length;
    }

    @Override // com.opos.exoplayer.core.f.d
    public List<com.opos.exoplayer.core.f.b> b(long j2) {
        SpannableStringBuilder append;
        SpannableStringBuilder spannableStringBuilder = null;
        ArrayList arrayList = null;
        c cVar = null;
        for (int i2 = 0; i2 < this.f18808b; i2++) {
            long[] jArr = this.f18809c;
            int i3 = i2 * 2;
            if (jArr[i3] <= j2 && j2 < jArr[i3 + 1]) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                c cVar2 = this.f18807a.get(i2);
                if (!cVar2.a()) {
                    arrayList.add(cVar2);
                } else if (cVar == null) {
                    cVar = cVar2;
                } else {
                    if (spannableStringBuilder == null) {
                        spannableStringBuilder = new SpannableStringBuilder();
                        append = spannableStringBuilder.append(cVar.f18616a).append((CharSequence) "\n");
                    } else {
                        append = spannableStringBuilder.append((CharSequence) "\n");
                    }
                    append.append(cVar2.f18616a);
                }
            }
        }
        if (spannableStringBuilder != null) {
            arrayList.add(new c(spannableStringBuilder));
        } else if (cVar != null) {
            arrayList.add(cVar);
        }
        return arrayList != null ? arrayList : Collections.emptyList();
    }
}
