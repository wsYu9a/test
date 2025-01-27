package rx.internal.operators;

import java.io.Serializable;
import qj.b;
import rx.Notification;

/* loaded from: classes5.dex */
public final class NotificationLite<T> {

    /* renamed from: a */
    public static final NotificationLite f30454a = new NotificationLite();

    /* renamed from: b */
    public static final Object f30455b = new Serializable() { // from class: rx.internal.operators.NotificationLite.1
        private static final long serialVersionUID = 1;

        public String toString() {
            return "Notification=>Completed";
        }
    };

    /* renamed from: c */
    public static final Object f30456c = new Serializable() { // from class: rx.internal.operators.NotificationLite.2
        private static final long serialVersionUID = 2;

        public String toString() {
            return "Notification=>NULL";
        }
    };

    /* renamed from: rx.internal.operators.NotificationLite$1 */
    public static class AnonymousClass1 implements Serializable {
        private static final long serialVersionUID = 1;

        public String toString() {
            return "Notification=>Completed";
        }
    }

    /* renamed from: rx.internal.operators.NotificationLite$2 */
    public static class AnonymousClass2 implements Serializable {
        private static final long serialVersionUID = 2;

        public String toString() {
            return "Notification=>NULL";
        }
    }

    public static class OnErrorSentinel implements Serializable {
        private static final long serialVersionUID = 3;

        /* renamed from: e */
        private final Throwable f30457e;

        public OnErrorSentinel(Throwable th2) {
            this.f30457e = th2;
        }

        public String toString() {
            return "Notification=>Error:" + this.f30457e;
        }
    }

    public static <T> NotificationLite<T> f() {
        return f30454a;
    }

    public boolean a(b<? super T> bVar, Object obj) {
        if (obj == f30455b) {
            bVar.onCompleted();
            return true;
        }
        if (obj == f30456c) {
            bVar.onNext(null);
            return false;
        }
        if (obj == null) {
            throw new IllegalArgumentException("The lite notification can not be null");
        }
        if (obj.getClass() == OnErrorSentinel.class) {
            bVar.onError(((OnErrorSentinel) obj).f30457e);
            return true;
        }
        bVar.onNext(obj);
        return false;
    }

    public Object b() {
        return f30455b;
    }

    public Object c(Throwable th2) {
        return new OnErrorSentinel(th2);
    }

    public Throwable d(Object obj) {
        return ((OnErrorSentinel) obj).f30457e;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public T e(Object obj) {
        if (obj == f30456c) {
            return null;
        }
        return obj;
    }

    public boolean g(Object obj) {
        return obj == f30455b;
    }

    public boolean h(Object obj) {
        return obj instanceof OnErrorSentinel;
    }

    public boolean i(Object obj) {
        return (obj == null || h(obj) || g(obj)) ? false : true;
    }

    public boolean j(Object obj) {
        return obj == f30456c;
    }

    public Notification.Kind k(Object obj) {
        if (obj != null) {
            return obj == f30455b ? Notification.Kind.OnCompleted : obj instanceof OnErrorSentinel ? Notification.Kind.OnError : Notification.Kind.OnNext;
        }
        throw new IllegalArgumentException("The lite notification can not be null");
    }

    public Object l(T t10) {
        return t10 == null ? f30456c : t10;
    }
}
