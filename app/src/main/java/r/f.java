package r;

import androidx.core.util.Predicate;

/* loaded from: classes.dex */
public final /* synthetic */ class f implements Predicate {

    /* renamed from: a */
    public final /* synthetic */ String f30205a;

    @Override // androidx.core.util.Predicate
    public /* synthetic */ Predicate and(Predicate predicate) {
        return a0.k.a(this, predicate);
    }

    @Override // androidx.core.util.Predicate
    public /* synthetic */ Predicate negate() {
        return a0.k.b(this);
    }

    @Override // androidx.core.util.Predicate
    public /* synthetic */ Predicate or(Predicate predicate) {
        return a0.k.c(this, predicate);
    }

    @Override // androidx.core.util.Predicate
    public final boolean test(Object obj) {
        return this.f30205a.equals((String) obj);
    }
}
