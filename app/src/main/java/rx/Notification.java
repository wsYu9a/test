package rx;

import qj.b;

/* loaded from: classes4.dex */
public final class Notification<T> {

    /* renamed from: d */
    public static final Notification<Void> f30447d = new Notification<>(Kind.OnCompleted, null, null);

    /* renamed from: a */
    public final Kind f30448a;

    /* renamed from: b */
    public final Throwable f30449b;

    /* renamed from: c */
    public final T f30450c;

    public enum Kind {
        OnNext,
        OnError,
        OnCompleted
    }

    public Notification(Kind kind, T t10, Throwable th2) {
        this.f30450c = t10;
        this.f30449b = th2;
        this.f30448a = kind;
    }

    public static <T> Notification<T> b() {
        return (Notification<T>) f30447d;
    }

    public static <T> Notification<T> c(Class<T> cls) {
        return (Notification<T>) f30447d;
    }

    public static <T> Notification<T> d(Throwable th2) {
        return new Notification<>(Kind.OnError, null, th2);
    }

    public static <T> Notification<T> e(T t10) {
        return new Notification<>(Kind.OnNext, t10, null);
    }

    public void a(b<? super T> bVar) {
        if (m()) {
            bVar.onNext(h());
        } else if (k()) {
            bVar.onCompleted();
        } else if (l()) {
            bVar.onError(g());
        }
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (obj.getClass() != Notification.class) {
            return false;
        }
        Notification notification = (Notification) obj;
        if (notification.f() != f()) {
            return false;
        }
        if (!j() || h().equals(notification.h())) {
            return !i() || g().equals(notification.g());
        }
        return false;
    }

    public Kind f() {
        return this.f30448a;
    }

    public Throwable g() {
        return this.f30449b;
    }

    public T h() {
        return this.f30450c;
    }

    public int hashCode() {
        int hashCode = f().hashCode();
        if (j()) {
            hashCode = (hashCode * 31) + h().hashCode();
        }
        return i() ? (hashCode * 31) + g().hashCode() : hashCode;
    }

    public boolean i() {
        return l() && this.f30449b != null;
    }

    public boolean j() {
        return m() && this.f30450c != null;
    }

    public boolean k() {
        return f() == Kind.OnCompleted;
    }

    public boolean l() {
        return f() == Kind.OnError;
    }

    public boolean m() {
        return f() == Kind.OnNext;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("[");
        sb2.append(super.toString());
        sb2.append(" ");
        sb2.append(f());
        if (j()) {
            sb2.append(" ");
            sb2.append(h());
        }
        if (i()) {
            sb2.append(" ");
            sb2.append(g().getMessage());
        }
        sb2.append("]");
        return sb2.toString();
    }
}
