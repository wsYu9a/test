package m5;

import b5.u;
import com.google.common.net.HostAndPort;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.net.InetAddress;
import java.text.ParseException;
import javax.annotation.CheckForNull;

@a
@a5.c
/* loaded from: classes2.dex */
public final class b {

    /* renamed from: a */
    public final String f28288a;

    public b(String str) {
        this.f28288a = str;
    }

    @CanIgnoreReturnValue
    public static b a(String str) throws ParseException {
        try {
            return b(str);
        } catch (IllegalArgumentException e10) {
            String valueOf = String.valueOf(str);
            ParseException parseException = new ParseException(valueOf.length() != 0 ? "Invalid host specifier: ".concat(valueOf) : new String("Invalid host specifier: "), 0);
            parseException.initCause(e10);
            throw parseException;
        }
    }

    public static b b(String str) {
        InetAddress inetAddress;
        HostAndPort fromString = HostAndPort.fromString(str);
        u.d(!fromString.hasPort());
        String host = fromString.getHost();
        try {
            inetAddress = d.g(host);
        } catch (IllegalArgumentException unused) {
            inetAddress = null;
        }
        if (inetAddress != null) {
            return new b(d.O(inetAddress));
        }
        e d10 = e.d(host);
        if (d10.f()) {
            return new b(d10.toString());
        }
        String valueOf = String.valueOf(host);
        throw new IllegalArgumentException(valueOf.length() != 0 ? "Domain name does not have a recognized public suffix: ".concat(valueOf) : new String("Domain name does not have a recognized public suffix: "));
    }

    public static boolean c(String str) {
        try {
            b(str);
            return true;
        } catch (IllegalArgumentException unused) {
            return false;
        }
    }

    public boolean equals(@CheckForNull Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof b) {
            return this.f28288a.equals(((b) obj).f28288a);
        }
        return false;
    }

    public int hashCode() {
        return this.f28288a.hashCode();
    }

    public String toString() {
        return this.f28288a;
    }
}
