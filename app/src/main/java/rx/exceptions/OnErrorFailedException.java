package rx.exceptions;

/* loaded from: classes4.dex */
public class OnErrorFailedException extends RuntimeException {
    private static final long serialVersionUID = -419289748403337611L;

    public OnErrorFailedException(String str, Throwable th2) {
        super(str, th2);
    }

    public OnErrorFailedException(Throwable th2) {
        super(th2.getMessage(), th2);
    }
}
