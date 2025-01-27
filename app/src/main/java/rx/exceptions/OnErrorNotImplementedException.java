package rx.exceptions;

/* loaded from: classes4.dex */
public class OnErrorNotImplementedException extends RuntimeException {
    private static final long serialVersionUID = -6298857009889503852L;

    public OnErrorNotImplementedException(String str, Throwable th2) {
        super(str, th2);
    }

    public OnErrorNotImplementedException(Throwable th2) {
        super(th2.getMessage(), th2);
    }
}
