package rx.exceptions;

/* loaded from: classes5.dex */
public class OnErrorFailedException extends RuntimeException {
    private static final long serialVersionUID = -419289748403337611L;

    public OnErrorFailedException(String str, Throwable th) {
        super(str, th);
    }

    public OnErrorFailedException(Throwable th) {
        super(th.getMessage(), th);
    }
}
