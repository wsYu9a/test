package qf;

/* loaded from: classes3.dex */
public class a {

    /* renamed from: c */
    public static final a f30051c;

    /* renamed from: d */
    public static final a f30052d;

    /* renamed from: e */
    public static final a f30053e;

    /* renamed from: f */
    public static final a f30054f;

    /* renamed from: g */
    public static final a f30055g;

    /* renamed from: h */
    public static final a f30056h;

    /* renamed from: i */
    public static final a f30057i;

    /* renamed from: j */
    public static final a f30058j;

    /* renamed from: k */
    public static final a f30059k;

    /* renamed from: l */
    public static final a f30060l;

    /* renamed from: m */
    public static final a f30061m;

    /* renamed from: n */
    public static final a f30062n;

    /* renamed from: o */
    public static final a[] f30063o;

    /* renamed from: a */
    public final int f30064a;

    /* renamed from: b */
    public final boolean f30065b;

    static {
        a aVar = new a(0, false);
        f30051c = aVar;
        a aVar2 = new a(1, true);
        f30052d = aVar2;
        a aVar3 = new a(2, false);
        f30053e = aVar3;
        a aVar4 = new a(3, true);
        f30054f = aVar4;
        a aVar5 = new a(4, false);
        f30055g = aVar5;
        a aVar6 = new a(5, true);
        f30056h = aVar6;
        a aVar7 = new a(6, false);
        f30057i = aVar7;
        a aVar8 = new a(7, true);
        f30058j = aVar8;
        a aVar9 = new a(8, false);
        f30059k = aVar9;
        a aVar10 = new a(9, true);
        f30060l = aVar10;
        a aVar11 = new a(10, false);
        f30061m = aVar11;
        a aVar12 = new a(10, true);
        f30062n = aVar12;
        f30063o = new a[]{aVar, aVar2, aVar3, aVar4, aVar5, aVar6, aVar7, aVar8, aVar9, aVar10, aVar11, aVar12};
    }

    public a(int i10, boolean z10) {
        this.f30064a = i10;
        this.f30065b = z10;
    }

    public boolean a(a aVar) {
        int i10 = this.f30064a;
        int i11 = aVar.f30064a;
        return i10 < i11 || ((!this.f30065b || f30060l == this) && i10 == i11);
    }

    public a b() {
        return !this.f30065b ? f30063o[this.f30064a + 1] : this;
    }

    public a c() {
        if (!this.f30065b) {
            return this;
        }
        a aVar = f30063o[this.f30064a - 1];
        return !aVar.f30065b ? aVar : f30051c;
    }
}
