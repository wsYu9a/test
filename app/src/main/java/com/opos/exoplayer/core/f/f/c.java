package com.opos.exoplayer.core.f.f;

import android.text.SpannableStringBuilder;
import com.vivo.google.android.exoplayer3.C;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

/* loaded from: classes4.dex */
final class c {

    /* renamed from: a */
    public final String f18727a;

    /* renamed from: b */
    public final String f18728b;

    /* renamed from: c */
    public final boolean f18729c;

    /* renamed from: d */
    public final long f18730d;

    /* renamed from: e */
    public final long f18731e;

    /* renamed from: f */
    public final b f18732f;

    /* renamed from: g */
    public final String f18733g;

    /* renamed from: h */
    private final String[] f18734h;

    /* renamed from: i */
    private final HashMap<String, Integer> f18735i;

    /* renamed from: j */
    private final HashMap<String, Integer> f18736j;
    private List<c> k;

    private c(String str, String str2, long j2, long j3, b bVar, String[] strArr, String str3) {
        this.f18727a = str;
        this.f18728b = str2;
        this.f18732f = bVar;
        this.f18734h = strArr;
        this.f18729c = str2 != null;
        this.f18730d = j2;
        this.f18731e = j3;
        this.f18733g = (String) com.opos.exoplayer.core.i.a.a(str3);
        this.f18735i = new HashMap<>();
        this.f18736j = new HashMap<>();
    }

    private SpannableStringBuilder a(SpannableStringBuilder spannableStringBuilder) {
        int i2;
        int i3;
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
                    length = i2;
                }
            }
            i9++;
        }
        if (length > 0 && spannableStringBuilder.charAt(i2) == ' ') {
            spannableStringBuilder.delete(i2, length);
            length = i2;
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
                    length = i3;
                }
            }
            i4++;
        }
        if (length > 0 && spannableStringBuilder.charAt(i3) == '\n') {
            spannableStringBuilder.delete(i3, length);
        }
        return spannableStringBuilder;
    }

    private static SpannableStringBuilder a(String str, Map<String, SpannableStringBuilder> map) {
        if (!map.containsKey(str)) {
            map.put(str, new SpannableStringBuilder());
        }
        return map.get(str);
    }

    public static c a(String str) {
        return new c(null, e.a(str), C.TIME_UNSET, C.TIME_UNSET, null, null, "");
    }

    public static c a(String str, long j2, long j3, b bVar, String[] strArr, String str2) {
        return new c(str, null, j2, j3, bVar, strArr, str2);
    }

    private void a(long j2, boolean z, String str, Map<String, SpannableStringBuilder> map) {
        this.f18735i.clear();
        this.f18736j.clear();
        String str2 = this.f18733g;
        if (!"".equals(str2)) {
            str = str2;
        }
        if (this.f18729c && z) {
            a(str, map).append((CharSequence) this.f18728b);
            return;
        }
        if ("br".equals(this.f18727a) && z) {
            a(str, map).append('\n');
            return;
        }
        if ("metadata".equals(this.f18727a) || !a(j2)) {
            return;
        }
        boolean equals = "p".equals(this.f18727a);
        for (Map.Entry<String, SpannableStringBuilder> entry : map.entrySet()) {
            this.f18735i.put(entry.getKey(), Integer.valueOf(entry.getValue().length()));
        }
        for (int i2 = 0; i2 < a(); i2++) {
            a(i2).a(j2, z || equals, str, map);
        }
        if (equals) {
            e.a(a(str, map));
        }
        for (Map.Entry<String, SpannableStringBuilder> entry2 : map.entrySet()) {
            this.f18736j.put(entry2.getKey(), Integer.valueOf(entry2.getValue().length()));
        }
    }

    private void a(Map<String, b> map, SpannableStringBuilder spannableStringBuilder, int i2, int i3) {
        b a2;
        if (i2 == i3 || (a2 = e.a(this.f18732f, this.f18734h, map)) == null) {
            return;
        }
        e.a(spannableStringBuilder, i2, i3, a2);
    }

    private void a(Map<String, b> map, Map<String, SpannableStringBuilder> map2) {
        for (Map.Entry<String, Integer> entry : this.f18736j.entrySet()) {
            String key = entry.getKey();
            a(map, map2.get(key), this.f18735i.containsKey(key) ? this.f18735i.get(key).intValue() : 0, entry.getValue().intValue());
            for (int i2 = 0; i2 < a(); i2++) {
                a(i2).a(map, map2);
            }
        }
    }

    private void a(TreeSet<Long> treeSet, boolean z) {
        boolean equals = "p".equals(this.f18727a);
        if (z || equals) {
            long j2 = this.f18730d;
            if (j2 != C.TIME_UNSET) {
                treeSet.add(Long.valueOf(j2));
            }
            long j3 = this.f18731e;
            if (j3 != C.TIME_UNSET) {
                treeSet.add(Long.valueOf(j3));
            }
        }
        if (this.k == null) {
            return;
        }
        for (int i2 = 0; i2 < this.k.size(); i2++) {
            this.k.get(i2).a(treeSet, z || equals);
        }
    }

    public int a() {
        List<c> list = this.k;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public c a(int i2) {
        List<c> list = this.k;
        if (list != null) {
            return list.get(i2);
        }
        throw new IndexOutOfBoundsException();
    }

    public List<com.opos.exoplayer.core.f.b> a(long j2, Map<String, b> map, Map<String, d> map2) {
        TreeMap treeMap = new TreeMap();
        a(j2, false, this.f18733g, (Map<String, SpannableStringBuilder>) treeMap);
        a(map, treeMap);
        ArrayList arrayList = new ArrayList();
        for (Map.Entry entry : treeMap.entrySet()) {
            d dVar = map2.get(entry.getKey());
            arrayList.add(new com.opos.exoplayer.core.f.b(a((SpannableStringBuilder) entry.getValue()), null, dVar.f18739c, dVar.f18740d, dVar.f18741e, dVar.f18738b, Integer.MIN_VALUE, dVar.f18742f));
        }
        return arrayList;
    }

    public void a(c cVar) {
        if (this.k == null) {
            this.k = new ArrayList();
        }
        this.k.add(cVar);
    }

    public boolean a(long j2) {
        long j3 = this.f18730d;
        return (j3 == C.TIME_UNSET && this.f18731e == C.TIME_UNSET) || (j3 <= j2 && this.f18731e == C.TIME_UNSET) || ((j3 == C.TIME_UNSET && j2 < this.f18731e) || (j3 <= j2 && j2 < this.f18731e));
    }

    public long[] b() {
        TreeSet<Long> treeSet = new TreeSet<>();
        int i2 = 0;
        a(treeSet, false);
        long[] jArr = new long[treeSet.size()];
        Iterator<Long> it = treeSet.iterator();
        while (it.hasNext()) {
            jArr[i2] = it.next().longValue();
            i2++;
        }
        return jArr;
    }
}
