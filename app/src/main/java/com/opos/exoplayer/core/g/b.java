package com.opos.exoplayer.core.g;

import com.opos.exoplayer.core.Format;
import com.opos.exoplayer.core.e.l;
import java.util.Arrays;
import java.util.Comparator;

/* loaded from: classes4.dex */
public abstract class b implements f {

    /* renamed from: a */
    protected final l f18844a;

    /* renamed from: b */
    protected final int f18845b;

    /* renamed from: c */
    protected final int[] f18846c;

    /* renamed from: d */
    private final Format[] f18847d;

    /* renamed from: e */
    private final long[] f18848e;

    /* renamed from: f */
    private int f18849f;

    private static final class a implements Comparator<Format> {
        private a() {
        }

        /* synthetic */ a(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(Format format, Format format2) {
            return format2.f17492b - format.f17492b;
        }
    }

    public b(l lVar, int... iArr) {
        int i2 = 0;
        com.opos.exoplayer.core.i.a.b(iArr.length > 0);
        this.f18844a = (l) com.opos.exoplayer.core.i.a.a(lVar);
        int length = iArr.length;
        this.f18845b = length;
        this.f18847d = new Format[length];
        for (int i3 = 0; i3 < iArr.length; i3++) {
            this.f18847d[i3] = lVar.a(iArr[i3]);
        }
        Arrays.sort(this.f18847d, new a());
        this.f18846c = new int[this.f18845b];
        while (true) {
            int i4 = this.f18845b;
            if (i2 >= i4) {
                this.f18848e = new long[i4];
                return;
            } else {
                this.f18846c[i2] = lVar.a(this.f18847d[i2]);
                i2++;
            }
        }
    }

    @Override // com.opos.exoplayer.core.g.f
    public final Format a(int i2) {
        return this.f18847d[i2];
    }

    @Override // com.opos.exoplayer.core.g.f
    public void a() {
    }

    @Override // com.opos.exoplayer.core.g.f
    public void a(float f2) {
    }

    protected final boolean a(int i2, long j2) {
        return this.f18848e[i2] > j2;
    }

    @Override // com.opos.exoplayer.core.g.f
    public final int b(int i2) {
        return this.f18846c[i2];
    }

    @Override // com.opos.exoplayer.core.g.f
    public void c() {
    }

    @Override // com.opos.exoplayer.core.g.f
    public final l d() {
        return this.f18844a;
    }

    @Override // com.opos.exoplayer.core.g.f
    public final int e() {
        return this.f18846c.length;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            if (this.f18844a != bVar.f18844a || !Arrays.equals(this.f18846c, bVar.f18846c)) {
                return false;
            }
        }
        return true;
    }

    @Override // com.opos.exoplayer.core.g.f
    public final Format f() {
        return this.f18847d[b()];
    }

    public int hashCode() {
        if (this.f18849f == 0) {
            this.f18849f = (System.identityHashCode(this.f18844a) * 31) + Arrays.hashCode(this.f18846c);
        }
        return this.f18849f;
    }
}
