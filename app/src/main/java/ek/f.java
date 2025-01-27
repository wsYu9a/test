package ek;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import rx.Notification;

/* loaded from: classes5.dex */
public class f<T> implements qj.b<T> {

    /* renamed from: f */
    public static qj.b<Object> f25941f = new a();

    /* renamed from: b */
    public final qj.b<T> f25942b;

    /* renamed from: c */
    public final ArrayList<T> f25943c;

    /* renamed from: d */
    public final ArrayList<Throwable> f25944d;

    /* renamed from: e */
    public final ArrayList<Notification<T>> f25945e;

    public f(qj.b<T> bVar) {
        this.f25943c = new ArrayList<>();
        this.f25944d = new ArrayList<>();
        this.f25945e = new ArrayList<>();
        this.f25942b = bVar;
    }

    public void a(List<T> list) {
        if (this.f25943c.size() != list.size()) {
            throw new AssertionError("Number of items does not match. Provided: " + list.size() + "  Actual: " + this.f25943c.size());
        }
        for (int i10 = 0; i10 < list.size(); i10++) {
            if (list.get(i10) == null) {
                if (this.f25943c.get(i10) != null) {
                    throw new AssertionError("Value at index: " + i10 + " expected to be [null] but was: [" + this.f25943c.get(i10) + "]");
                }
            } else if (!list.get(i10).equals(this.f25943c.get(i10))) {
                throw new AssertionError("Value at index: " + i10 + " expected to be [" + list.get(i10) + "] (" + list.get(i10).getClass().getSimpleName() + ") but was: [" + this.f25943c.get(i10) + "] (" + this.f25943c.get(i10).getClass().getSimpleName() + ")");
            }
        }
    }

    public void b() {
        if (this.f25944d.size() > 1) {
            throw new AssertionError("Too many onError events: " + this.f25944d.size());
        }
        if (this.f25945e.size() > 1) {
            throw new AssertionError("Too many onCompleted events: " + this.f25945e.size());
        }
        if (this.f25945e.size() == 1 && this.f25944d.size() == 1) {
            throw new AssertionError("Received both an onError and onCompleted. Should be one or the other.");
        }
        if (this.f25945e.size() == 0 && this.f25944d.size() == 0) {
            throw new AssertionError("No terminal events received.");
        }
    }

    public List<Object> c() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f25943c);
        arrayList.add(this.f25944d);
        arrayList.add(this.f25945e);
        return Collections.unmodifiableList(arrayList);
    }

    public List<Notification<T>> d() {
        return Collections.unmodifiableList(this.f25945e);
    }

    public List<Throwable> e() {
        return Collections.unmodifiableList(this.f25944d);
    }

    public List<T> f() {
        return Collections.unmodifiableList(this.f25943c);
    }

    @Override // qj.b
    public void onCompleted() {
        this.f25945e.add(Notification.b());
        this.f25942b.onCompleted();
    }

    @Override // qj.b
    public void onError(Throwable th2) {
        this.f25944d.add(th2);
        this.f25942b.onError(th2);
    }

    @Override // qj.b
    public void onNext(T t10) {
        this.f25943c.add(t10);
        this.f25942b.onNext(t10);
    }

    public f() {
        this.f25943c = new ArrayList<>();
        this.f25944d = new ArrayList<>();
        this.f25945e = new ArrayList<>();
        this.f25942b = (qj.b<T>) f25941f;
    }

    public static class a implements qj.b<Object> {
        @Override // qj.b
        public void onCompleted() {
        }

        @Override // qj.b
        public void onError(Throwable th2) {
        }

        @Override // qj.b
        public void onNext(Object obj) {
        }
    }
}
