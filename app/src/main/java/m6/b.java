package m6;

/* loaded from: classes2.dex */
public final class b extends f {
    public b(z5.a aVar) {
        super(aVar);
    }

    @Override // m6.i
    public void h(StringBuilder sb2, int i10) {
        if (i10 < 10000) {
            sb2.append("(3202)");
        } else {
            sb2.append("(3203)");
        }
    }

    @Override // m6.i
    public int i(int i10) {
        return i10 < 10000 ? i10 : i10 - 10000;
    }
}
