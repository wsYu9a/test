package com.kwad.sdk.core.network.idc;

import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.regex.Pattern;
import org.apache.http.conn.ConnectTimeoutException;

/* loaded from: classes3.dex */
public class DomainException extends Exception {
    private final Pattern CONNECT_ERR_PATTERN;
    private final int httpCode;

    public DomainException(int i10) {
        this(i10, null);
    }

    private Exception getInternal() {
        Throwable cause = getCause();
        if (cause instanceof Exception) {
            return (Exception) cause;
        }
        return null;
    }

    public int getHttpCode() {
        return this.httpCode;
    }

    public boolean isConnectException() {
        String message;
        Exception internal = getInternal();
        if (internal == null) {
            return false;
        }
        if ((internal instanceof SocketTimeoutException) || (internal instanceof ConnectTimeoutException) || (internal instanceof SocketException) || (internal instanceof UnknownHostException)) {
            return true;
        }
        if (!internal.getClass().getSimpleName().equalsIgnoreCase("ErrnoException") || (message = internal.getMessage()) == null) {
            return false;
        }
        return this.CONNECT_ERR_PATTERN.matcher(message).find();
    }

    public DomainException(Throwable th2) {
        this(-1, th2);
    }

    public DomainException(int i10, Throwable th2) {
        super(th2);
        this.CONNECT_ERR_PATTERN = Pattern.compile(".*(ECONN(RESET|REFUSED|ABORTED)|ETIMEDOUT|ENETUNREACH|EHOSTUNREACH).*", 2);
        this.httpCode = i10;
    }
}
