package rx.l;

import java.util.Arrays;
import rx.exceptions.CompositeException;
import rx.exceptions.OnErrorFailedException;
import rx.exceptions.OnErrorNotImplementedException;

/* loaded from: classes5.dex */
public class b<T> extends rx.g<T> {

    /* renamed from: f */
    private final rx.g<? super T> f36882f;

    /* renamed from: g */
    boolean f36883g;

    public b(rx.g<? super T> gVar) {
        super(gVar);
        this.f36883g = false;
        this.f36882f = gVar;
    }

    private void i(Throwable th) {
        System.err.println("RxJavaErrorHandler threw an Exception. It shouldn't. => " + th.getMessage());
        th.printStackTrace();
    }

    protected void g(Throwable th) {
        try {
            rx.m.d.b().a().a(th);
        } catch (Throwable th2) {
            i(th2);
        }
        try {
            this.f36882f.onError(th);
            try {
                unsubscribe();
            } catch (RuntimeException e2) {
                try {
                    rx.m.d.b().a().a(e2);
                } catch (Throwable th3) {
                    i(th3);
                }
                throw new OnErrorFailedException(e2);
            }
        } catch (Throwable th4) {
            if (th4 instanceof OnErrorNotImplementedException) {
                try {
                    unsubscribe();
                    throw th4;
                } catch (Throwable th5) {
                    try {
                        rx.m.d.b().a().a(th5);
                    } catch (Throwable th6) {
                        i(th6);
                    }
                    throw new RuntimeException("Observer.onError not implemented and error while unsubscribing.", new CompositeException(Arrays.asList(th, th5)));
                }
            }
            try {
                rx.m.d.b().a().a(th4);
            } catch (Throwable th7) {
                i(th7);
            }
            try {
                unsubscribe();
                throw new OnErrorFailedException("Error occurred when trying to propagate error to Observer.onError", new CompositeException(Arrays.asList(th, th4)));
            } catch (Throwable th8) {
                try {
                    rx.m.d.b().a().a(th8);
                } catch (Throwable th9) {
                    i(th9);
                }
                throw new OnErrorFailedException("Error occurred when trying to propagate error to Observer.onError and during unsubscription.", new CompositeException(Arrays.asList(th, th4, th8)));
            }
        }
    }

    public rx.g<? super T> h() {
        return this.f36882f;
    }

    @Override // rx.b
    public void onCompleted() {
        if (this.f36883g) {
            return;
        }
        this.f36883g = true;
        try {
            this.f36882f.onCompleted();
        } finally {
            try {
            } finally {
            }
        }
    }

    @Override // rx.b
    public void onError(Throwable th) {
        rx.exceptions.a.e(th);
        if (this.f36883g) {
            return;
        }
        this.f36883g = true;
        g(th);
    }

    @Override // rx.b
    public void onNext(T t) {
        try {
            if (this.f36883g) {
                return;
            }
            this.f36882f.onNext(t);
        } catch (Throwable th) {
            rx.exceptions.a.e(th);
            onError(th);
        }
    }
}
