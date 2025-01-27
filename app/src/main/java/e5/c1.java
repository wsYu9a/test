package e5;

import java.util.Arrays;

@a5.b(emulated = true, serializable = true)
@m
/* loaded from: classes2.dex */
public class c1<K> extends com.google.common.collect.t<K> {

    /* renamed from: r */
    public static final int f25606r = -2;

    /* renamed from: o */
    @a5.d
    public transient long[] f25607o;

    /* renamed from: p */
    public transient int f25608p;

    /* renamed from: q */
    public transient int f25609q;

    public c1() {
        this(3);
    }

    public static <K> c1<K> F() {
        return new c1<>();
    }

    public static <K> c1<K> G(int i10) {
        return new c1<>(i10);
    }

    public final int H(int i10) {
        return (int) (this.f25607o[i10] >>> 32);
    }

    public final int I(int i10) {
        return (int) this.f25607o[i10];
    }

    public final void J(int i10, int i11) {
        long[] jArr = this.f25607o;
        jArr[i10] = (jArr[i10] & 4294967295L) | (i11 << 32);
    }

    public final void K(int i10, int i11) {
        if (i10 == -2) {
            this.f25608p = i11;
        } else {
            L(i10, i11);
        }
        if (i11 == -2) {
            this.f25609q = i10;
        } else {
            J(i11, i10);
        }
    }

    public final void L(int i10, int i11) {
        long[] jArr = this.f25607o;
        jArr[i10] = (jArr[i10] & com.google.common.collect.t.f9962l) | (i11 & 4294967295L);
    }

    @Override // com.google.common.collect.t
    public void a() {
        super.a();
        this.f25608p = -2;
        this.f25609q = -2;
    }

    @Override // com.google.common.collect.t
    public int f() {
        int i10 = this.f25608p;
        if (i10 == -2) {
            return -1;
        }
        return i10;
    }

    @Override // com.google.common.collect.t
    public void o(int i10, float f10) {
        super.o(i10, f10);
        this.f25608p = -2;
        this.f25609q = -2;
        long[] jArr = new long[i10];
        this.f25607o = jArr;
        Arrays.fill(jArr, -1L);
    }

    @Override // com.google.common.collect.t
    public void p(int i10, @d1 K k10, int i11, int i12) {
        super.p(i10, k10, i11, i12);
        K(this.f25609q, i10);
        K(i10, -2);
    }

    @Override // com.google.common.collect.t
    public void q(int i10) {
        int D = D() - 1;
        K(H(i10), I(i10));
        if (i10 < D) {
            K(H(D), i10);
            K(i10, I(D));
        }
        super.q(i10);
    }

    @Override // com.google.common.collect.t
    public int t(int i10) {
        int I = I(i10);
        if (I == -2) {
            return -1;
        }
        return I;
    }

    @Override // com.google.common.collect.t
    public int u(int i10, int i11) {
        return i10 == D() ? i11 : i10;
    }

    @Override // com.google.common.collect.t
    public void z(int i10) {
        super.z(i10);
        long[] jArr = this.f25607o;
        int length = jArr.length;
        long[] copyOf = Arrays.copyOf(jArr, i10);
        this.f25607o = copyOf;
        Arrays.fill(copyOf, length, i10, -1L);
    }

    public c1(int i10) {
        this(i10, 1.0f);
    }

    public c1(int i10, float f10) {
        super(i10, f10);
    }

    public c1(com.google.common.collect.t<K> tVar) {
        o(tVar.D(), 1.0f);
        int f10 = tVar.f();
        while (f10 != -1) {
            v(tVar.j(f10), tVar.l(f10));
            f10 = tVar.t(f10);
        }
    }
}
