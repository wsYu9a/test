package rx.l;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import rx.Notification;

/* loaded from: classes5.dex */
public class f<T> implements rx.b<T> {

    /* renamed from: a */
    private static rx.b<Object> f36903a = new a();

    /* renamed from: b */
    private final rx.b<T> f36904b;

    /* renamed from: c */
    private final ArrayList<T> f36905c;

    /* renamed from: d */
    private final ArrayList<Throwable> f36906d;

    /* renamed from: e */
    private final ArrayList<Notification<T>> f36907e;

    static class a implements rx.b<Object> {
        a() {
        }

        @Override // rx.b
        public void onCompleted() {
        }

        @Override // rx.b
        public void onError(Throwable th) {
        }

        @Override // rx.b
        public void onNext(Object obj) {
        }
    }

    public f(rx.b<T> bVar) {
        this.f36905c = new ArrayList<>();
        this.f36906d = new ArrayList<>();
        this.f36907e = new ArrayList<>();
        this.f36904b = bVar;
    }

    public void a(List<T> list) {
        if (this.f36905c.size() != list.size()) {
            throw new AssertionError("Number of items does not match. Provided: " + list.size() + "  Actual: " + this.f36905c.size());
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            if (list.get(i2) == null) {
                if (this.f36905c.get(i2) != null) {
                    throw new AssertionError("Value at index: " + i2 + " expected to be [null] but was: [" + this.f36905c.get(i2) + "]");
                }
            } else if (!list.get(i2).equals(this.f36905c.get(i2))) {
                throw new AssertionError("Value at index: " + i2 + " expected to be [" + list.get(i2) + "] (" + list.get(i2).getClass().getSimpleName() + ") but was: [" + this.f36905c.get(i2) + "] (" + this.f36905c.get(i2).getClass().getSimpleName() + ")");
            }
        }
    }

    public void b() {
        if (this.f36906d.size() > 1) {
            throw new AssertionError("Too many onError events: " + this.f36906d.size());
        }
        if (this.f36907e.size() > 1) {
            throw new AssertionError("Too many onCompleted events: " + this.f36907e.size());
        }
        if (this.f36907e.size() == 1 && this.f36906d.size() == 1) {
            throw new AssertionError("Received both an onError and onCompleted. Should be one or the other.");
        }
        if (this.f36907e.size() == 0 && this.f36906d.size() == 0) {
            throw new AssertionError("No terminal events received.");
        }
    }

    public List<Object> c() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f36905c);
        arrayList.add(this.f36906d);
        arrayList.add(this.f36907e);
        return Collections.unmodifiableList(arrayList);
    }

    public List<Notification<T>> d() {
        return Collections.unmodifiableList(this.f36907e);
    }

    public List<Throwable> e() {
        return Collections.unmodifiableList(this.f36906d);
    }

    public List<T> f() {
        return Collections.unmodifiableList(this.f36905c);
    }

    @Override // rx.b
    public void onCompleted() {
        this.f36907e.add(Notification.b());
        this.f36904b.onCompleted();
    }

    @Override // rx.b
    public void onError(Throwable th) {
        this.f36906d.add(th);
        this.f36904b.onError(th);
    }

    @Override // rx.b
    public void onNext(T t) {
        this.f36905c.add(t);
        this.f36904b.onNext(t);
    }

    public f() {
        this.f36905c = new ArrayList<>();
        this.f36906d = new ArrayList<>();
        this.f36907e = new ArrayList<>();
        this.f36904b = (rx.b<T>) f36903a;
    }
}
