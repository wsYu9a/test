package rx.internal.operators;

import java.io.Serializable;
import rx.Notification;

/* loaded from: classes5.dex */
public final class NotificationLite<T> {

    /* renamed from: a */
    private static final NotificationLite f35783a = new NotificationLite();

    /* renamed from: b */
    private static final Object f35784b = new Serializable() { // from class: rx.internal.operators.NotificationLite.1
        private static final long serialVersionUID = 1;

        AnonymousClass1() {
        }

        public String toString() {
            return "Notification=>Completed";
        }
    };

    /* renamed from: c */
    private static final Object f35785c = new Serializable() { // from class: rx.internal.operators.NotificationLite.2
        private static final long serialVersionUID = 2;

        AnonymousClass2() {
        }

        public String toString() {
            return "Notification=>NULL";
        }
    };

    /* renamed from: rx.internal.operators.NotificationLite$1 */
    static class AnonymousClass1 implements Serializable {
        private static final long serialVersionUID = 1;

        AnonymousClass1() {
        }

        public String toString() {
            return "Notification=>Completed";
        }
    }

    /* renamed from: rx.internal.operators.NotificationLite$2 */
    static class AnonymousClass2 implements Serializable {
        private static final long serialVersionUID = 2;

        AnonymousClass2() {
        }

        public String toString() {
            return "Notification=>NULL";
        }
    }

    private static class OnErrorSentinel implements Serializable {
        private static final long serialVersionUID = 3;

        /* renamed from: e */
        private final Throwable f35786e;

        public OnErrorSentinel(Throwable th) {
            this.f35786e = th;
        }

        public String toString() {
            return "Notification=>Error:" + this.f35786e;
        }
    }

    private NotificationLite() {
    }

    public static <T> NotificationLite<T> f() {
        return f35783a;
    }

    public boolean a(rx.b<? super T> bVar, Object obj) {
        if (obj == f35784b) {
            bVar.onCompleted();
            return true;
        }
        if (obj == f35785c) {
            bVar.onNext(null);
            return false;
        }
        if (obj == null) {
            throw new IllegalArgumentException("The lite notification can not be null");
        }
        if (obj.getClass() == OnErrorSentinel.class) {
            bVar.onError(((OnErrorSentinel) obj).f35786e);
            return true;
        }
        bVar.onNext(obj);
        return false;
    }

    public Object b() {
        return f35784b;
    }

    public Object c(Throwable th) {
        return new OnErrorSentinel(th);
    }

    public Throwable d(Object obj) {
        return ((OnErrorSentinel) obj).f35786e;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public T e(Object obj) {
        if (obj == f35785c) {
            return null;
        }
        return obj;
    }

    public boolean g(Object obj) {
        return obj == f35784b;
    }

    public boolean h(Object obj) {
        return obj instanceof OnErrorSentinel;
    }

    public boolean i(Object obj) {
        return (obj == null || h(obj) || g(obj)) ? false : true;
    }

    public boolean j(Object obj) {
        return obj == f35785c;
    }

    public Notification.Kind k(Object obj) {
        if (obj != null) {
            return obj == f35784b ? Notification.Kind.OnCompleted : obj instanceof OnErrorSentinel ? Notification.Kind.OnError : Notification.Kind.OnNext;
        }
        throw new IllegalArgumentException("The lite notification can not be null");
    }

    public Object l(T t) {
        return t == null ? f35785c : t;
    }
}
