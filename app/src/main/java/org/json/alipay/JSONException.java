package org.json.alipay;

/* loaded from: classes4.dex */
public class JSONException extends Exception {
    public Throwable cause;

    public JSONException(String str) {
        super(str);
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.cause;
    }

    public JSONException(Throwable th2) {
        super(th2.getMessage());
        this.cause = th2;
    }
}
