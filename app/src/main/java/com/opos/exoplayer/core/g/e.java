package com.opos.exoplayer.core.g;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import com.opos.exoplayer.core.e.l;
import com.opos.exoplayer.core.e.m;
import com.opos.exoplayer.core.g.f;
import com.opos.exoplayer.core.t;
import com.opos.exoplayer.core.u;
import java.util.Arrays;
import java.util.Map;

/* loaded from: classes4.dex */
public abstract class e extends h {

    /* renamed from: a */
    private final SparseArray<Map<m, b>> f18875a = new SparseArray<>();

    /* renamed from: b */
    private final SparseBooleanArray f18876b = new SparseBooleanArray();

    /* renamed from: c */
    private int f18877c = 0;

    /* renamed from: d */
    private a f18878d;

    public static final class a {

        /* renamed from: a */
        public final int f18879a;

        /* renamed from: b */
        private final int[] f18880b;

        /* renamed from: c */
        private final m[] f18881c;

        /* renamed from: d */
        private final int[] f18882d;

        /* renamed from: e */
        private final int[][][] f18883e;

        /* renamed from: f */
        private final m f18884f;

        a(int[] iArr, m[] mVarArr, int[] iArr2, int[][][] iArr3, m mVar) {
            this.f18880b = iArr;
            this.f18881c = mVarArr;
            this.f18883e = iArr3;
            this.f18882d = iArr2;
            this.f18884f = mVar;
            this.f18879a = mVarArr.length;
        }
    }

    public static final class b {

        /* renamed from: a */
        public final f.a f18885a;

        /* renamed from: b */
        public final int f18886b;

        /* renamed from: c */
        public final int[] f18887c;

        public f a(m mVar) {
            return this.f18885a.b(mVar.a(this.f18886b), this.f18887c);
        }
    }

    private static int a(t[] tVarArr, l lVar) {
        int length = tVarArr.length;
        int i2 = 0;
        for (int i3 = 0; i3 < tVarArr.length; i3++) {
            t tVar = tVarArr[i3];
            for (int i4 = 0; i4 < lVar.f18513a; i4++) {
                int a2 = tVar.a(lVar.a(i4)) & 7;
                if (a2 > i2) {
                    if (a2 == 4) {
                        return i3;
                    }
                    length = i3;
                    i2 = a2;
                }
            }
        }
        return length;
    }

    private static void a(t[] tVarArr, m[] mVarArr, int[][][] iArr, u[] uVarArr, f[] fVarArr, int i2) {
        boolean z;
        if (i2 == 0) {
            return;
        }
        boolean z2 = false;
        int i3 = -1;
        int i4 = -1;
        for (int i5 = 0; i5 < tVarArr.length; i5++) {
            int a2 = tVarArr[i5].a();
            f fVar = fVarArr[i5];
            if ((a2 == 1 || a2 == 2) && fVar != null && a(iArr[i5], mVarArr[i5], fVar)) {
                if (a2 == 1) {
                    if (i4 != -1) {
                        z = false;
                        break;
                    }
                    i4 = i5;
                } else {
                    if (i3 != -1) {
                        z = false;
                        break;
                    }
                    i3 = i5;
                }
            }
        }
        z = true;
        if (i4 != -1 && i3 != -1) {
            z2 = true;
        }
        if (z && z2) {
            u uVar = new u(i2);
            uVarArr[i4] = uVar;
            uVarArr[i3] = uVar;
        }
    }

    private static boolean a(int[][] iArr, m mVar, f fVar) {
        if (fVar == null) {
            return false;
        }
        int a2 = mVar.a(fVar.d());
        for (int i2 = 0; i2 < fVar.e(); i2++) {
            if ((iArr[a2][fVar.b(i2)] & 32) != 32) {
                return false;
            }
        }
        return true;
    }

    private static int[] a(t tVar, l lVar) {
        int[] iArr = new int[lVar.f18513a];
        for (int i2 = 0; i2 < lVar.f18513a; i2++) {
            iArr[i2] = tVar.a(lVar.a(i2));
        }
        return iArr;
    }

    private static int[] a(t[] tVarArr) {
        int length = tVarArr.length;
        int[] iArr = new int[length];
        for (int i2 = 0; i2 < length; i2++) {
            iArr[i2] = tVarArr[i2].m();
        }
        return iArr;
    }

    private boolean[] a(t[] tVarArr, f[] fVarArr) {
        int length = fVarArr.length;
        boolean[] zArr = new boolean[length];
        for (int i2 = 0; i2 < length; i2++) {
            zArr[i2] = !this.f18876b.get(i2) && (tVarArr[i2].a() == 5 || fVarArr[i2] != null);
        }
        return zArr;
    }

    @Override // com.opos.exoplayer.core.g.h
    public final i a(t[] tVarArr, m mVar) {
        int[] iArr = new int[tVarArr.length + 1];
        int length = tVarArr.length + 1;
        l[][] lVarArr = new l[length][];
        int[][][] iArr2 = new int[tVarArr.length + 1][][];
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = mVar.f18517b;
            lVarArr[i2] = new l[i3];
            iArr2[i2] = new int[i3][];
        }
        int[] a2 = a(tVarArr);
        for (int i4 = 0; i4 < mVar.f18517b; i4++) {
            l a3 = mVar.a(i4);
            int a4 = a(tVarArr, a3);
            int[] a5 = a4 == tVarArr.length ? new int[a3.f18513a] : a(tVarArr[a4], a3);
            int i5 = iArr[a4];
            lVarArr[a4][i5] = a3;
            iArr2[a4][i5] = a5;
            iArr[a4] = iArr[a4] + 1;
        }
        m[] mVarArr = new m[tVarArr.length];
        int[] iArr3 = new int[tVarArr.length];
        for (int i6 = 0; i6 < tVarArr.length; i6++) {
            int i7 = iArr[i6];
            mVarArr[i6] = new m((l[]) Arrays.copyOf(lVarArr[i6], i7));
            iArr2[i6] = (int[][]) Arrays.copyOf(iArr2[i6], i7);
            iArr3[i6] = tVarArr[i6].a();
        }
        m mVar2 = new m((l[]) Arrays.copyOf(lVarArr[tVarArr.length], iArr[tVarArr.length]));
        f[] a6 = a(tVarArr, mVarArr, iArr2);
        int i8 = 0;
        while (true) {
            if (i8 >= tVarArr.length) {
                break;
            }
            if (this.f18876b.get(i8)) {
                a6[i8] = null;
            } else {
                m mVar3 = mVarArr[i8];
                if (a(i8, mVar3)) {
                    b bVar = this.f18875a.get(i8).get(mVar3);
                    a6[i8] = bVar != null ? bVar.a(mVar3) : null;
                }
            }
            i8++;
        }
        boolean[] a7 = a(tVarArr, a6);
        a aVar = new a(iArr3, mVarArr, a2, iArr2, mVar2);
        u[] uVarArr = new u[tVarArr.length];
        for (int i9 = 0; i9 < tVarArr.length; i9++) {
            uVarArr[i9] = a7[i9] ? u.f19198a : null;
        }
        a(tVarArr, mVarArr, iArr2, uVarArr, a6, this.f18877c);
        return new i(mVar, a7, new g(a6), aVar, uVarArr);
    }

    @Override // com.opos.exoplayer.core.g.h
    public final void a(Object obj) {
        this.f18878d = (a) obj;
    }

    public final boolean a(int i2, m mVar) {
        Map<m, b> map = this.f18875a.get(i2);
        return map != null && map.containsKey(mVar);
    }

    protected abstract f[] a(t[] tVarArr, m[] mVarArr, int[][][] iArr);
}
