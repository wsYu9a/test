package rx.internal.operators;

import rx.Notification;
import rx.a;

/* loaded from: classes5.dex */
public final class m0<T> implements a.n0<T, Notification<T>> {

    class a extends rx.g<Notification<T>> {

        /* renamed from: f */
        boolean f36245f;

        /* renamed from: g */
        final /* synthetic */ rx.g f36246g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(rx.g gVar, rx.g gVar2) {
            super(gVar);
            this.f36246g = gVar2;
        }

        @Override // rx.b
        /* renamed from: g */
        public void onNext(Notification<T> notification) {
            int i2 = b.f36248a[notification.f().ordinal()];
            if (i2 == 1) {
                if (this.f36245f) {
                    return;
                }
                this.f36246g.onNext(notification.h());
            } else if (i2 == 2) {
                onError(notification.g());
            } else {
                if (i2 != 3) {
                    return;
                }
                onCompleted();
            }
        }

        @Override // rx.b
        public void onCompleted() {
            if (this.f36245f) {
                return;
            }
            this.f36245f = true;
            this.f36246g.onCompleted();
        }

        @Override // rx.b
        public void onError(Throwable th) {
            if (this.f36245f) {
                return;
            }
            this.f36245f = true;
            this.f36246g.onError(th);
        }
    }

    static /* synthetic */ class b {

        /* renamed from: a */
        static final /* synthetic */ int[] f36248a;

        static {
            int[] iArr = new int[Notification.Kind.values().length];
            f36248a = iArr;
            try {
                iArr[Notification.Kind.OnNext.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f36248a[Notification.Kind.OnError.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f36248a[Notification.Kind.OnCompleted.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private static final class c {

        /* renamed from: a */
        static final m0<Object> f36249a = new m0<>(null);

        private c() {
        }
    }

    /* synthetic */ m0(a aVar) {
        this();
    }

    public static m0 a() {
        return c.f36249a;
    }

    private m0() {
    }

    @Override // rx.k.o
    public rx.g<? super Notification<T>> call(rx.g<? super T> gVar) {
        return new a(gVar, gVar);
    }
}
