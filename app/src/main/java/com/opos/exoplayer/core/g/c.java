package com.opos.exoplayer.core.g;

import android.graphics.Point;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.opos.exoplayer.core.Format;
import com.opos.exoplayer.core.e.l;
import com.opos.exoplayer.core.e.m;
import com.opos.exoplayer.core.g.f;
import com.opos.exoplayer.core.i.u;
import com.opos.exoplayer.core.t;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes4.dex */
public class c extends e {

    /* renamed from: a */
    private static final int[] f18850a = new int[0];

    /* renamed from: b */
    private final f.a f18851b;

    /* renamed from: c */
    private final AtomicReference<a> f18852c;

    public static final class a {

        /* renamed from: a */
        public static final a f18853a = new a();

        /* renamed from: b */
        public final String f18854b;

        /* renamed from: c */
        public final String f18855c;

        /* renamed from: d */
        public final boolean f18856d;

        /* renamed from: e */
        public final int f18857e;

        /* renamed from: f */
        public final int f18858f;

        /* renamed from: g */
        public final int f18859g;

        /* renamed from: h */
        public final int f18860h;

        /* renamed from: i */
        public final boolean f18861i;

        /* renamed from: j */
        public final int f18862j;
        public final int k;
        public final boolean l;
        public final boolean m;
        public final boolean n;
        public final boolean o;
        public final boolean p;

        private a() {
            this(null, null, false, 0, false, false, true, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, true, true, Integer.MAX_VALUE, Integer.MAX_VALUE, true);
        }

        private a(String str, String str2, boolean z, int i2, boolean z2, boolean z3, boolean z4, int i3, int i4, int i5, boolean z5, boolean z6, int i6, int i7, boolean z7) {
            this.f18854b = u.b(str);
            this.f18855c = u.b(str2);
            this.f18856d = z;
            this.f18857e = i2;
            this.m = z2;
            this.n = z3;
            this.o = z4;
            this.f18858f = i3;
            this.f18859g = i4;
            this.f18860h = i5;
            this.f18861i = z5;
            this.p = z6;
            this.f18862j = i6;
            this.k = i7;
            this.l = z7;
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                if (obj == null || a.class != obj.getClass()) {
                    return false;
                }
                a aVar = (a) obj;
                if (this.f18856d != aVar.f18856d || this.f18857e != aVar.f18857e || this.m != aVar.m || this.n != aVar.n || this.o != aVar.o || this.f18858f != aVar.f18858f || this.f18859g != aVar.f18859g || this.f18861i != aVar.f18861i || this.p != aVar.p || this.l != aVar.l || this.f18862j != aVar.f18862j || this.k != aVar.k || this.f18860h != aVar.f18860h || !TextUtils.equals(this.f18854b, aVar.f18854b) || !TextUtils.equals(this.f18855c, aVar.f18855c)) {
                    return false;
                }
            }
            return true;
        }

        public int hashCode() {
            boolean z = this.f18856d;
            int i2 = this.f18857e;
            boolean z2 = this.m;
            boolean z3 = this.n;
            boolean z4 = this.o;
            int i3 = this.f18858f;
            int i4 = this.f18859g;
            boolean z5 = this.f18861i;
            boolean z6 = this.p;
            boolean z7 = this.l;
            return (((((((((((((z6 ? 1 : 0) + (((z5 ? 1 : 0) + (((((((z4 ? 1 : 0) + (((z3 ? 1 : 0) + (((z2 ? 1 : 0) + ((((z ? 1 : 0) * 31) + i2) * 31)) * 31)) * 31)) * 31) + i3) * 31) + i4) * 31)) * 31)) * 31) + (z7 ? 1 : 0)) * 31) + this.f18862j) * 31) + this.k) * 31) + this.f18860h) * 31) + this.f18854b.hashCode()) * 31) + this.f18855c.hashCode();
        }
    }

    private static final class b {

        /* renamed from: a */
        public final int f18863a;

        /* renamed from: b */
        public final int f18864b;

        /* renamed from: c */
        public final String f18865c;

        public b(int i2, int i3, String str) {
            this.f18863a = i2;
            this.f18864b = i3;
            this.f18865c = str;
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                if (obj == null || b.class != obj.getClass()) {
                    return false;
                }
                b bVar = (b) obj;
                if (this.f18863a != bVar.f18863a || this.f18864b != bVar.f18864b || !TextUtils.equals(this.f18865c, bVar.f18865c)) {
                    return false;
                }
            }
            return true;
        }

        public int hashCode() {
            int i2 = this.f18863a;
            int i3 = this.f18864b;
            String str = this.f18865c;
            return (str != null ? str.hashCode() : 0) + (((i2 * 31) + i3) * 31);
        }
    }

    /* renamed from: com.opos.exoplayer.core.g.c$c */
    private static final class C0416c implements Comparable<C0416c> {

        /* renamed from: a */
        private final a f18866a;

        /* renamed from: b */
        private final int f18867b;

        /* renamed from: c */
        private final int f18868c;

        /* renamed from: d */
        private final int f18869d;

        /* renamed from: e */
        private final int f18870e;

        /* renamed from: f */
        private final int f18871f;

        /* renamed from: g */
        private final int f18872g;

        public C0416c(Format format, a aVar, int i2) {
            this.f18866a = aVar;
            this.f18867b = c.a(i2, false) ? 1 : 0;
            this.f18868c = c.a(format, aVar.f18854b) ? 1 : 0;
            this.f18869d = (format.x & 1) != 0 ? 1 : 0;
            this.f18870e = format.r;
            this.f18871f = format.s;
            this.f18872g = format.f17492b;
        }

        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(@NonNull C0416c c0416c) {
            int i2 = this.f18867b;
            int i3 = c0416c.f18867b;
            if (i2 != i3) {
                return c.c(i2, i3);
            }
            int i4 = this.f18868c;
            int i5 = c0416c.f18868c;
            if (i4 != i5 || (i4 = this.f18869d) != (i5 = c0416c.f18869d)) {
                return c.c(i4, i5);
            }
            if (this.f18866a.m) {
                return c.c(c0416c.f18872g, this.f18872g);
            }
            int i6 = i2 != 1 ? -1 : 1;
            int i7 = this.f18870e;
            int i8 = c0416c.f18870e;
            return ((i7 == i8 && (i7 = this.f18871f) == (i8 = c0416c.f18871f)) ? c.c(this.f18872g, c0416c.f18872g) : c.c(i7, i8)) * i6;
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                if (obj == null || C0416c.class != obj.getClass()) {
                    return false;
                }
                C0416c c0416c = (C0416c) obj;
                if (this.f18867b != c0416c.f18867b || this.f18868c != c0416c.f18868c || this.f18869d != c0416c.f18869d || this.f18870e != c0416c.f18870e || this.f18871f != c0416c.f18871f || this.f18872g != c0416c.f18872g) {
                    return false;
                }
            }
            return true;
        }

        public int hashCode() {
            return (((((((((this.f18867b * 31) + this.f18868c) * 31) + this.f18869d) * 31) + this.f18870e) * 31) + this.f18871f) * 31) + this.f18872g;
        }
    }

    public c() {
        this(null);
    }

    public c(f.a aVar) {
        this.f18851b = aVar;
        this.f18852c = new AtomicReference<>(a.f18853a);
    }

    private static int a(l lVar, int[] iArr, int i2, String str, int i3, int i4, int i5, List<Integer> list) {
        int i6 = 0;
        for (int i7 = 0; i7 < list.size(); i7++) {
            int intValue = list.get(i7).intValue();
            if (a(lVar.a(intValue), str, iArr[intValue], i2, i3, i4, i5)) {
                i6++;
            }
        }
        return i6;
    }

    private static int a(l lVar, int[] iArr, b bVar) {
        int i2 = 0;
        for (int i3 = 0; i3 < lVar.f18513a; i3++) {
            if (a(lVar.a(i3), iArr[i3], bVar)) {
                i2++;
            }
        }
        return i2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x000c, code lost:
    
        if ((r6 > r7) != (r4 > r5)) goto L30;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static android.graphics.Point a(boolean r3, int r4, int r5, int r6, int r7) {
        /*
            if (r3 == 0) goto Lf
            r3 = 0
            r0 = 1
            if (r6 <= r7) goto L8
            r1 = 1
            goto L9
        L8:
            r1 = 0
        L9:
            if (r4 <= r5) goto Lc
            r3 = 1
        Lc:
            if (r1 == r3) goto Lf
            goto L12
        Lf:
            r2 = r5
            r5 = r4
            r4 = r2
        L12:
            int r3 = r6 * r4
            int r0 = r7 * r5
            if (r3 < r0) goto L22
            android.graphics.Point r3 = new android.graphics.Point
            int r4 = com.opos.exoplayer.core.i.u.a(r0, r6)
            r3.<init>(r5, r4)
            goto L2c
        L22:
            android.graphics.Point r5 = new android.graphics.Point
            int r3 = com.opos.exoplayer.core.i.u.a(r3, r7)
            r5.<init>(r3, r4)
            r3 = r5
        L2c:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.exoplayer.core.g.c.a(boolean, int, int, int, int):android.graphics.Point");
    }

    private static List<Integer> a(l lVar, int i2, int i3, boolean z) {
        int i4;
        ArrayList arrayList = new ArrayList(lVar.f18513a);
        for (int i5 = 0; i5 < lVar.f18513a; i5++) {
            arrayList.add(Integer.valueOf(i5));
        }
        if (i2 != Integer.MAX_VALUE && i3 != Integer.MAX_VALUE) {
            int i6 = Integer.MAX_VALUE;
            for (int i7 = 0; i7 < lVar.f18513a; i7++) {
                Format a2 = lVar.a(i7);
                int i8 = a2.f17500j;
                if (i8 > 0 && (i4 = a2.k) > 0) {
                    Point a3 = a(z, i2, i3, i8, i4);
                    int i9 = a2.f17500j;
                    int i10 = a2.k;
                    int i11 = i9 * i10;
                    if (i9 >= ((int) (a3.x * 0.98f)) && i10 >= ((int) (a3.y * 0.98f)) && i11 < i6) {
                        i6 = i11;
                    }
                }
            }
            if (i6 != Integer.MAX_VALUE) {
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    int a4 = lVar.a(((Integer) arrayList.get(size)).intValue()).a();
                    if (a4 == -1 || a4 > i6) {
                        arrayList.remove(size);
                    }
                }
            }
        }
        return arrayList;
    }

    protected static boolean a(int i2, boolean z) {
        int i3 = i2 & 7;
        return i3 == 4 || (z && i3 == 3);
    }

    protected static boolean a(Format format) {
        return TextUtils.isEmpty(format.y) || a(format, "und");
    }

    private static boolean a(Format format, int i2, b bVar) {
        if (!a(i2, false) || format.r != bVar.f18863a || format.s != bVar.f18864b) {
            return false;
        }
        String str = bVar.f18865c;
        return str == null || TextUtils.equals(str, format.f17496f);
    }

    protected static boolean a(Format format, String str) {
        return str != null && TextUtils.equals(str, u.b(format.y));
    }

    private static boolean a(Format format, String str, int i2, int i3, int i4, int i5, int i6) {
        if (!a(i2, false) || (i2 & i3) == 0) {
            return false;
        }
        if (str != null && !u.a(format.f17496f, str)) {
            return false;
        }
        int i7 = format.f17500j;
        if (i7 != -1 && i7 > i4) {
            return false;
        }
        int i8 = format.k;
        if (i8 != -1 && i8 > i5) {
            return false;
        }
        int i9 = format.f17492b;
        return i9 == -1 || i9 <= i6;
    }

    private static int[] a(l lVar, int[] iArr, boolean z) {
        int a2;
        HashSet hashSet = new HashSet();
        b bVar = null;
        int i2 = 0;
        for (int i3 = 0; i3 < lVar.f18513a; i3++) {
            Format a3 = lVar.a(i3);
            b bVar2 = new b(a3.r, a3.s, z ? null : a3.f17496f);
            if (hashSet.add(bVar2) && (a2 = a(lVar, iArr, bVar2)) > i2) {
                i2 = a2;
                bVar = bVar2;
            }
        }
        if (i2 <= 1) {
            return f18850a;
        }
        int[] iArr2 = new int[i2];
        int i4 = 0;
        for (int i5 = 0; i5 < lVar.f18513a; i5++) {
            if (a(lVar.a(i5), iArr[i5], bVar)) {
                iArr2[i4] = i5;
                i4++;
            }
        }
        return iArr2;
    }

    private static int[] a(l lVar, int[] iArr, boolean z, int i2, int i3, int i4, int i5, int i6, int i7, boolean z2) {
        String str;
        int a2;
        if (lVar.f18513a >= 2) {
            List<Integer> a3 = a(lVar, i6, i7, z2);
            if (a3.size() >= 2) {
                if (z) {
                    str = null;
                } else {
                    HashSet hashSet = new HashSet();
                    String str2 = null;
                    int i8 = 0;
                    for (int i9 = 0; i9 < a3.size(); i9++) {
                        String str3 = lVar.a(a3.get(i9).intValue()).f17496f;
                        if (hashSet.add(str3) && (a2 = a(lVar, iArr, i2, str3, i3, i4, i5, a3)) > i8) {
                            i8 = a2;
                            str2 = str3;
                        }
                    }
                    str = str2;
                }
                b(lVar, iArr, i2, str, i3, i4, i5, a3);
                if (a3.size() >= 2) {
                    return u.a(a3);
                }
            }
        }
        return f18850a;
    }

    private static int b(int i2, int i3) {
        if (i2 == -1) {
            return i3 == -1 ? 0 : -1;
        }
        if (i3 == -1) {
            return 1;
        }
        return i2 - i3;
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x0083, code lost:
    
        if (b(r2.f17492b, r9) < 0) goto L129;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static com.opos.exoplayer.core.g.f b(com.opos.exoplayer.core.e.m r18, int[][] r19, com.opos.exoplayer.core.g.c.a r20) {
        /*
            Method dump skipped, instructions count: 203
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.exoplayer.core.g.c.b(com.opos.exoplayer.core.e.m, int[][], com.opos.exoplayer.core.g.c$a):com.opos.exoplayer.core.g.f");
    }

    private static f b(t tVar, m mVar, int[][] iArr, a aVar, f.a aVar2) {
        int i2 = aVar.o ? 24 : 16;
        boolean z = aVar.n && (tVar.m() & i2) != 0;
        for (int i3 = 0; i3 < mVar.f18517b; i3++) {
            l a2 = mVar.a(i3);
            int[] a3 = a(a2, iArr[i3], z, i2, aVar.f18858f, aVar.f18859g, aVar.f18860h, aVar.f18862j, aVar.k, aVar.l);
            if (a3.length > 0) {
                return aVar2.b(a2, a3);
            }
        }
        return null;
    }

    private static void b(l lVar, int[] iArr, int i2, String str, int i3, int i4, int i5, List<Integer> list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            int intValue = list.get(size).intValue();
            if (!a(lVar.a(intValue), str, iArr[intValue], i2, i3, i4, i5)) {
                list.remove(size);
            }
        }
    }

    public static int c(int i2, int i3) {
        if (i2 > i3) {
            return 1;
        }
        return i3 > i2 ? -1 : 0;
    }

    protected f a(int i2, m mVar, int[][] iArr, a aVar) {
        l lVar = null;
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < mVar.f18517b; i5++) {
            l a2 = mVar.a(i5);
            int[] iArr2 = iArr[i5];
            for (int i6 = 0; i6 < a2.f18513a; i6++) {
                if (a(iArr2[i6], aVar.p)) {
                    int i7 = (a2.a(i6).x & 1) != 0 ? 2 : 1;
                    if (a(iArr2[i6], false)) {
                        i7 += 1000;
                    }
                    if (i7 > i4) {
                        lVar = a2;
                        i3 = i6;
                        i4 = i7;
                    }
                }
            }
        }
        if (lVar == null) {
            return null;
        }
        return new d(lVar, i3);
    }

    protected f a(m mVar, int[][] iArr, a aVar) {
        l lVar = null;
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < mVar.f18517b; i4++) {
            l a2 = mVar.a(i4);
            int[] iArr2 = iArr[i4];
            for (int i5 = 0; i5 < a2.f18513a; i5++) {
                if (a(iArr2[i5], aVar.p)) {
                    Format a3 = a2.a(i5);
                    int i6 = a3.x & (aVar.f18857e ^ (-1));
                    int i7 = 1;
                    boolean z = (i6 & 1) != 0;
                    boolean z2 = (i6 & 2) != 0;
                    boolean a4 = a(a3, aVar.f18855c);
                    if (a4 || (aVar.f18856d && a(a3))) {
                        i7 = (a4 ? 1 : 0) + (z ? 8 : !z2 ? 6 : 4);
                    } else if (z) {
                        i7 = 3;
                    } else if (z2) {
                        if (a(a3, aVar.f18854b)) {
                            i7 = 2;
                        }
                    }
                    if (a(iArr2[i5], false)) {
                        i7 += 1000;
                    }
                    if (i7 > i3) {
                        lVar = a2;
                        i2 = i5;
                        i3 = i7;
                    }
                }
            }
        }
        if (lVar == null) {
            return null;
        }
        return new d(lVar, i2);
    }

    protected f a(m mVar, int[][] iArr, a aVar, f.a aVar2) {
        C0416c c0416c = null;
        int i2 = -1;
        int i3 = -1;
        for (int i4 = 0; i4 < mVar.f18517b; i4++) {
            l a2 = mVar.a(i4);
            int[] iArr2 = iArr[i4];
            for (int i5 = 0; i5 < a2.f18513a; i5++) {
                if (a(iArr2[i5], aVar.p)) {
                    C0416c c0416c2 = new C0416c(a2.a(i5), aVar, iArr2[i5]);
                    if (c0416c == null || c0416c2.compareTo(c0416c) > 0) {
                        i2 = i4;
                        i3 = i5;
                        c0416c = c0416c2;
                    }
                }
            }
        }
        if (i2 == -1) {
            return null;
        }
        l a3 = mVar.a(i2);
        if (!aVar.m && aVar2 != null) {
            int[] a4 = a(a3, iArr[i2], aVar.n);
            if (a4.length > 0) {
                return aVar2.b(a3, a4);
            }
        }
        return new d(a3, i3);
    }

    protected f a(t tVar, m mVar, int[][] iArr, a aVar, f.a aVar2) {
        f b2 = (aVar.m || aVar2 == null) ? null : b(tVar, mVar, iArr, aVar, aVar2);
        return b2 == null ? b(mVar, iArr, aVar) : b2;
    }

    @Override // com.opos.exoplayer.core.g.e
    protected f[] a(t[] tVarArr, m[] mVarArr, int[][][] iArr) {
        int length = tVarArr.length;
        f[] fVarArr = new f[length];
        a aVar = this.f18852c.get();
        boolean z = false;
        int i2 = 0;
        boolean z2 = false;
        while (true) {
            if (i2 >= length) {
                break;
            }
            if (2 == tVarArr[i2].a()) {
                if (!z) {
                    fVarArr[i2] = a(tVarArr[i2], mVarArr[i2], iArr[i2], aVar, this.f18851b);
                    z = fVarArr[i2] != null;
                }
                z2 |= mVarArr[i2].f18517b > 0;
            }
            i2++;
        }
        boolean z3 = false;
        boolean z4 = false;
        for (int i3 = 0; i3 < length; i3++) {
            int a2 = tVarArr[i3].a();
            if (a2 != 1) {
                if (a2 != 2) {
                    if (a2 != 3) {
                        fVarArr[i3] = a(tVarArr[i3].a(), mVarArr[i3], iArr[i3], aVar);
                    } else if (!z3) {
                        fVarArr[i3] = a(mVarArr[i3], iArr[i3], aVar);
                        z3 = fVarArr[i3] != null;
                    }
                }
            } else if (!z4) {
                fVarArr[i3] = a(mVarArr[i3], iArr[i3], aVar, z2 ? null : this.f18851b);
                z4 = fVarArr[i3] != null;
            }
        }
        return fVarArr;
    }
}
