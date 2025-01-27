package xj;

import qj.a;
import rx.Notification;

/* loaded from: classes5.dex */
public final class m0<T> implements a.n0<T, Notification<T>> {

    public class a extends qj.g<Notification<T>> {

        /* renamed from: g */
        public boolean f32431g;

        /* renamed from: h */
        public final /* synthetic */ qj.g f32432h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(qj.g gVar, qj.g gVar2) {
            super(gVar);
            this.f32432h = gVar2;
        }

        @Override // qj.b
        /* renamed from: g */
        public void onNext(Notification<T> notification) {
            int i10 = b.f32434a[notification.f().ordinal()];
            if (i10 == 1) {
                if (this.f32431g) {
                    return;
                }
                this.f32432h.onNext(notification.h());
            } else if (i10 == 2) {
                onError(notification.g());
            } else {
                if (i10 != 3) {
                    return;
                }
                onCompleted();
            }
        }

        @Override // qj.b
        public void onCompleted() {
            if (this.f32431g) {
                return;
            }
            this.f32431g = true;
            this.f32432h.onCompleted();
        }

        @Override // qj.b
        public void onError(Throwable th2) {
            if (this.f32431g) {
                return;
            }
            this.f32431g = true;
            this.f32432h.onError(th2);
        }
    }

    public static /* synthetic */ class b {

        /* renamed from: a */
        public static final /* synthetic */ int[] f32434a;

        static {
            int[] iArr = new int[Notification.Kind.values().length];
            f32434a = iArr;
            try {
                iArr[Notification.Kind.OnNext.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f32434a[Notification.Kind.OnError.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f32434a[Notification.Kind.OnCompleted.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public static final class c {

        /* renamed from: a */
        public static final m0<Object> f32435a = new m0<>(null);
    }

    public /* synthetic */ m0(a aVar) {
        this();
    }

    public static m0 a() {
        return c.f32435a;
    }

    public m0() {
    }

    @Override // wj.o
    public qj.g<? super Notification<T>> call(qj.g<? super T> gVar) {
        return new a(gVar, gVar);
    }
}
