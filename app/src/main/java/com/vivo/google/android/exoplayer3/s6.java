package com.vivo.google.android.exoplayer3;

import java.util.ArrayList;
import java.util.Comparator;

/* loaded from: classes4.dex */
public class s6 {

    /* renamed from: h */
    public static final Comparator<c> f28062h = new a();

    /* renamed from: i */
    public static final Comparator<c> f28063i = new b();

    /* renamed from: a */
    public final int f28064a;

    /* renamed from: e */
    public int f28068e;

    /* renamed from: f */
    public int f28069f;

    /* renamed from: g */
    public int f28070g;

    /* renamed from: c */
    public final c[] f28066c = new c[5];

    /* renamed from: b */
    public final ArrayList<c> f28065b = new ArrayList<>();

    /* renamed from: d */
    public int f28067d = -1;

    public static class a implements Comparator<c> {
        @Override // java.util.Comparator
        public int compare(c cVar, c cVar2) {
            return cVar.f28071a - cVar2.f28071a;
        }
    }

    public static class b implements Comparator<c> {
        @Override // java.util.Comparator
        public int compare(c cVar, c cVar2) {
            float f2 = cVar.f28073c;
            float f3 = cVar2.f28073c;
            if (f2 < f3) {
                return -1;
            }
            return f3 < f2 ? 1 : 0;
        }
    }

    public static class c {

        /* renamed from: a */
        public int f28071a;

        /* renamed from: b */
        public int f28072b;

        /* renamed from: c */
        public float f28073c;
    }

    public s6(int i2) {
        this.f28064a = i2;
    }
}
