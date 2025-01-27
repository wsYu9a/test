package rx.n;

import rx.d;

/* loaded from: classes5.dex */
public final class e extends rx.d {

    /* renamed from: a */
    private static final String f36952a = "RxNewThreadScheduler-";

    /* renamed from: b */
    private static final rx.internal.util.f f36953b = new rx.internal.util.f(f36952a);

    /* renamed from: c */
    private static final e f36954c = new e();

    private e() {
    }

    static e c() {
        return f36954c;
    }

    @Override // rx.d
    public d.a a() {
        return new rx.internal.schedulers.b(f36953b);
    }
}
