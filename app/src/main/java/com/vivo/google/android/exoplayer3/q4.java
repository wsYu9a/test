package com.vivo.google.android.exoplayer3;

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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

/* loaded from: classes4.dex */
public final class q4 {

    /* renamed from: a */
    public final String f27959a;

    /* renamed from: b */
    public final String f27960b;

    /* renamed from: c */
    public final boolean f27961c;

    /* renamed from: d */
    public final long f27962d;

    /* renamed from: e */
    public final long f27963e;

    /* renamed from: f */
    public final s4 f27964f;

    /* renamed from: g */
    public final String f27965g;

    /* renamed from: h */
    public final String[] f27966h;

    /* renamed from: i */
    public final HashMap<String, Integer> f27967i;

    /* renamed from: j */
    public final HashMap<String, Integer> f27968j;
    public List<q4> k;

    public q4(String str, String str2, long j2, long j3, s4 s4Var, String[] strArr, String str3) {
        this.f27959a = str;
        this.f27960b = str2;
        this.f27964f = s4Var;
        this.f27966h = strArr;
        this.f27961c = str2 != null;
        this.f27962d = j2;
        this.f27963e = j3;
        this.f27965g = (String) g1.a(str3);
        this.f27967i = new HashMap<>();
        this.f27968j = new HashMap<>();
    }

    public static SpannableStringBuilder a(String str, Map<String, SpannableStringBuilder> map) {
        if (!map.containsKey(str)) {
            map.put(str, new SpannableStringBuilder());
        }
        return map.get(str);
    }

    public void a(q4 q4Var) {
        if (this.k == null) {
            this.k = new ArrayList();
        }
        this.k.add(q4Var);
    }

    public final void a(Map<String, s4> map, Map<String, SpannableStringBuilder> map2) {
        for (Map.Entry<String, Integer> entry : this.f27968j.entrySet()) {
            String key = entry.getKey();
            int intValue = this.f27967i.containsKey(key) ? this.f27967i.get(key).intValue() : 0;
            SpannableStringBuilder spannableStringBuilder = map2.get(key);
            int intValue2 = entry.getValue().intValue();
            if (intValue != intValue2) {
                s4 s4Var = this.f27964f;
                String[] strArr = this.f27966h;
                if (s4Var == null && strArr == null) {
                    s4Var = null;
                } else if (s4Var == null && strArr.length == 1) {
                    s4Var = map.get(strArr[0]);
                } else if (s4Var == null && strArr.length > 1) {
                    s4Var = new s4();
                    for (String str : strArr) {
                        s4Var.a(map.get(str));
                    }
                } else if (s4Var != null && strArr != null && strArr.length == 1) {
                    s4Var = s4Var.a(map.get(strArr[0]));
                } else if (s4Var != null && strArr != null && strArr.length > 1) {
                    for (String str2 : strArr) {
                        s4Var.a(map.get(str2));
                    }
                }
                if (s4Var != null) {
                    if (s4Var.a() != -1) {
                        spannableStringBuilder.setSpan(new StyleSpan(s4Var.a()), intValue, intValue2, 33);
                    }
                    if (s4Var.f28052f == 1) {
                        spannableStringBuilder.setSpan(new StrikethroughSpan(), intValue, intValue2, 33);
                    }
                    if (s4Var.f28053g == 1) {
                        spannableStringBuilder.setSpan(new UnderlineSpan(), intValue, intValue2, 33);
                    }
                    if (s4Var.f28049c) {
                        if (!s4Var.f28049c) {
                            throw new IllegalStateException("Font color has not been defined.");
                        }
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(s4Var.f28048b), intValue, intValue2, 33);
                    }
                    if (s4Var.f28051e) {
                        if (!s4Var.f28051e) {
                            throw new IllegalStateException("Background color has not been defined.");
                        }
                        spannableStringBuilder.setSpan(new BackgroundColorSpan(s4Var.f28050d), intValue, intValue2, 33);
                    }
                    if (s4Var.f28047a != null) {
                        spannableStringBuilder.setSpan(new TypefaceSpan(s4Var.f28047a), intValue, intValue2, 33);
                    }
                    if (s4Var.m != null) {
                        spannableStringBuilder.setSpan(new AlignmentSpan.Standard(s4Var.m), intValue, intValue2, 33);
                    }
                    int i2 = s4Var.f28056j;
                    if (i2 == 1) {
                        spannableStringBuilder.setSpan(new AbsoluteSizeSpan((int) s4Var.k, true), intValue, intValue2, 33);
                    } else if (i2 == 2) {
                        spannableStringBuilder.setSpan(new RelativeSizeSpan(s4Var.k), intValue, intValue2, 33);
                    } else if (i2 == 3) {
                        spannableStringBuilder.setSpan(new RelativeSizeSpan(s4Var.k / 100.0f), intValue, intValue2, 33);
                    }
                }
            }
            int i3 = 0;
            while (true) {
                List<q4> list = this.k;
                if (i3 < (list == null ? 0 : list.size())) {
                    List<q4> list2 = this.k;
                    if (list2 == null) {
                        throw new IndexOutOfBoundsException();
                    }
                    list2.get(i3).a(map, map2);
                    i3++;
                }
            }
        }
    }

    public final void a(TreeSet<Long> treeSet, boolean z) {
        boolean equals = "p".equals(this.f27959a);
        if (z || equals) {
            long j2 = this.f27962d;
            if (j2 != C.TIME_UNSET) {
                treeSet.add(Long.valueOf(j2));
            }
            long j3 = this.f27963e;
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

    public long[] a() {
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

    public final void a(long j2, boolean z, String str, Map<String, SpannableStringBuilder> map) {
        this.f27967i.clear();
        this.f27968j.clear();
        String str2 = this.f27965g;
        String str3 = "".equals(str2) ? str : str2;
        if (this.f27961c && z) {
            a(str3, map).append((CharSequence) this.f27960b);
            return;
        }
        if ("br".equals(this.f27959a) && z) {
            a(str3, map).append('\n');
            return;
        }
        if ("metadata".equals(this.f27959a)) {
            return;
        }
        long j3 = this.f27962d;
        if (!((j3 == C.TIME_UNSET && this.f27963e == C.TIME_UNSET) || (j3 <= j2 && this.f27963e == C.TIME_UNSET) || ((j3 == C.TIME_UNSET && j2 < this.f27963e) || (j3 <= j2 && j2 < this.f27963e)))) {
            return;
        }
        boolean equals = "p".equals(this.f27959a);
        for (Map.Entry<String, SpannableStringBuilder> entry : map.entrySet()) {
            this.f27967i.put(entry.getKey(), Integer.valueOf(entry.getValue().length()));
        }
        int i2 = 0;
        while (true) {
            List<q4> list = this.k;
            if (i2 < (list == null ? 0 : list.size())) {
                List<q4> list2 = this.k;
                if (list2 != null) {
                    list2.get(i2).a(j2, z || equals, str3, map);
                    i2++;
                } else {
                    throw new IndexOutOfBoundsException();
                }
            } else {
                if (equals) {
                    SpannableStringBuilder a2 = a(str3, map);
                    int length = a2.length() - 1;
                    while (length >= 0 && a2.charAt(length) == ' ') {
                        length--;
                    }
                    if (length >= 0 && a2.charAt(length) != '\n') {
                        a2.append('\n');
                    }
                }
                for (Map.Entry<String, SpannableStringBuilder> entry2 : map.entrySet()) {
                    this.f27968j.put(entry2.getKey(), Integer.valueOf(entry2.getValue().length()));
                }
                return;
            }
        }
    }
}
