package w5;

import java.util.Iterator;
import java.util.LinkedList;

/* loaded from: classes2.dex */
public final class f {

    /* renamed from: e */
    public static final f f31594e = new f(g.f31599b, 0, 0, 0);

    /* renamed from: a */
    public final int f31595a;

    /* renamed from: b */
    public final g f31596b;

    /* renamed from: c */
    public final int f31597c;

    /* renamed from: d */
    public final int f31598d;

    public f(g gVar, int i10, int i11, int i12) {
        this.f31596b = gVar;
        this.f31595a = i10;
        this.f31597c = i11;
        this.f31598d = i12;
    }

    public f a(int i10) {
        g gVar = this.f31596b;
        int i11 = this.f31595a;
        int i12 = this.f31598d;
        if (i11 == 4 || i11 == 2) {
            int i13 = d.f31587h[i11][0];
            int i14 = 65535 & i13;
            int i15 = i13 >> 16;
            gVar = gVar.a(i14, i15);
            i12 += i15;
            i11 = 0;
        }
        int i16 = this.f31597c;
        f fVar = new f(gVar, i11, i16 + 1, i12 + ((i16 == 0 || i16 == 31) ? 18 : i16 == 62 ? 9 : 8));
        return fVar.f31597c == 2078 ? fVar.b(i10 + 1) : fVar;
    }

    public f b(int i10) {
        int i11 = this.f31597c;
        return i11 == 0 ? this : new f(this.f31596b.b(i10 - i11, i11), this.f31595a, 0, this.f31598d);
    }

    public int c() {
        return this.f31597c;
    }

    public int d() {
        return this.f31598d;
    }

    public int e() {
        return this.f31595a;
    }

    public g f() {
        return this.f31596b;
    }

    public boolean g(f fVar) {
        int i10;
        int i11 = this.f31598d + (d.f31587h[this.f31595a][fVar.f31595a] >> 16);
        int i12 = fVar.f31597c;
        if (i12 > 0 && ((i10 = this.f31597c) == 0 || i10 > i12)) {
            i11 += 10;
        }
        return i11 <= fVar.f31598d;
    }

    public f h(int i10, int i11) {
        int i12 = this.f31598d;
        g gVar = this.f31596b;
        int i13 = this.f31595a;
        if (i10 != i13) {
            int i14 = d.f31587h[i13][i10];
            int i15 = 65535 & i14;
            int i16 = i14 >> 16;
            gVar = gVar.a(i15, i16);
            i12 += i16;
        }
        int i17 = i10 == 2 ? 4 : 5;
        return new f(gVar.a(i11, i17), i10, 0, i12 + i17);
    }

    public f i(int i10, int i11) {
        g gVar = this.f31596b;
        int i12 = this.f31595a;
        int i13 = i12 == 2 ? 4 : 5;
        return new f(gVar.a(d.f31589j[i12][i10], i13).a(i11, 5), this.f31595a, 0, this.f31598d + i13 + 5);
    }

    public z5.a j(byte[] bArr) {
        LinkedList linkedList = new LinkedList();
        for (g gVar = b(bArr.length).f31596b; gVar != null; gVar = gVar.d()) {
            linkedList.addFirst(gVar);
        }
        z5.a aVar = new z5.a();
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            ((g) it.next()).c(aVar, bArr);
        }
        return aVar;
    }

    public String toString() {
        return String.format("%s bits=%d bytes=%d", d.f31581b[this.f31595a], Integer.valueOf(this.f31598d), Integer.valueOf(this.f31597c));
    }
}
