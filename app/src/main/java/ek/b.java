package ek;

import java.util.Arrays;
import rx.exceptions.CompositeException;
import rx.exceptions.OnErrorFailedException;
import rx.exceptions.OnErrorNotImplementedException;

/* loaded from: classes5.dex */
public class b<T> extends qj.g<T> {

    /* renamed from: g */
    public final qj.g<? super T> f25920g;

    /* renamed from: h */
    public boolean f25921h;

    public b(qj.g<? super T> gVar) {
        super(gVar);
        this.f25921h = false;
        this.f25920g = gVar;
    }

    public void g(Throwable th2) {
        try {
            fk.d.b().a().a(th2);
        } catch (Throwable th3) {
            i(th3);
        }
        try {
            this.f25920g.onError(th2);
            try {
                unsubscribe();
            } catch (RuntimeException e10) {
                try {
                    fk.d.b().a().a(e10);
                } catch (Throwable th4) {
                    i(th4);
                }
                throw new OnErrorFailedException(e10);
            }
        } catch (Throwable th5) {
            if (th5 instanceof OnErrorNotImplementedException) {
                try {
                    unsubscribe();
                    throw th5;
                } catch (Throwable th6) {
                    try {
                        fk.d.b().a().a(th6);
                    } catch (Throwable th7) {
                        i(th7);
                    }
                    throw new RuntimeException("Observer.onError not implemented and error while unsubscribing.", new CompositeException(Arrays.asList(th2, th6)));
                }
            }
            try {
                fk.d.b().a().a(th5);
            } catch (Throwable th8) {
                i(th8);
            }
            try {
                unsubscribe();
                throw new OnErrorFailedException("Error occurred when trying to propagate error to Observer.onError", new CompositeException(Arrays.asList(th2, th5)));
            } catch (Throwable th9) {
                try {
                    fk.d.b().a().a(th9);
                } catch (Throwable th10) {
                    i(th10);
                }
                throw new OnErrorFailedException("Error occurred when trying to propagate error to Observer.onError and during unsubscription.", new CompositeException(Arrays.asList(th2, th5, th9)));
            }
        }
    }

    public qj.g<? super T> h() {
        return this.f25920g;
    }

    public final void i(Throwable th2) {
        System.err.println("RxJavaErrorHandler threw an Exception. It shouldn't. => " + th2.getMessage());
        th2.printStackTrace();
    }

    @Override // qj.b
    public void onCompleted() {
        if (this.f25921h) {
            return;
        }
        this.f25921h = true;
        try {
            this.f25920g.onCompleted();
        } finally {
            try {
            } finally {
            }
        }
    }

    @Override // qj.b
    public void onError(Throwable th2) {
        vj.a.e(th2);
        if (this.f25921h) {
            return;
        }
        this.f25921h = true;
        g(th2);
    }

    @Override // qj.b
    public void onNext(T t10) {
        try {
            if (this.f25921h) {
                return;
            }
            this.f25920g.onNext(t10);
        } catch (Throwable th2) {
            vj.a.e(th2);
            onError(th2);
        }
    }
}
