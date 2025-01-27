package rx;

/* loaded from: classes5.dex */
public final class Notification<T> {

    /* renamed from: a */
    private static final Notification<Void> f35640a = new Notification<>(Kind.OnCompleted, null, null);

    /* renamed from: b */
    private final Kind f35641b;

    /* renamed from: c */
    private final Throwable f35642c;

    /* renamed from: d */
    private final T f35643d;

    public enum Kind {
        OnNext,
        OnError,
        OnCompleted
    }

    private Notification(Kind kind, T t, Throwable th) {
        this.f35643d = t;
        this.f35642c = th;
        this.f35641b = kind;
    }

    public static <T> Notification<T> b() {
        return (Notification<T>) f35640a;
    }

    public static <T> Notification<T> c(Class<T> cls) {
        return (Notification<T>) f35640a;
    }

    public static <T> Notification<T> d(Throwable th) {
        return new Notification<>(Kind.OnError, null, th);
    }

    public static <T> Notification<T> e(T t) {
        return new Notification<>(Kind.OnNext, t, null);
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
        return this.f35641b;
    }

    public Throwable g() {
        return this.f35642c;
    }

    public T h() {
        return this.f35643d;
    }

    public int hashCode() {
        int hashCode = f().hashCode();
        if (j()) {
            hashCode = (hashCode * 31) + h().hashCode();
        }
        return i() ? (hashCode * 31) + g().hashCode() : hashCode;
    }

    public boolean i() {
        return l() && this.f35642c != null;
    }

    public boolean j() {
        return m() && this.f35643d != null;
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
        StringBuilder sb = new StringBuilder("[");
        sb.append(super.toString());
        sb.append(" ");
        sb.append(f());
        if (j()) {
            sb.append(" ");
            sb.append(h());
        }
        if (i()) {
            sb.append(" ");
            sb.append(g().getMessage());
        }
        sb.append("]");
        return sb.toString();
    }
}
