package mj;

import java.io.PrintWriter;
import java.io.StringWriter;

/* loaded from: classes4.dex */
public final class i {
    public static String a(Throwable th2) {
        String str = null;
        if (th2 == null) {
            return null;
        }
        try {
            StringWriter stringWriter = new StringWriter();
            PrintWriter printWriter = new PrintWriter(stringWriter);
            do {
                th2.printStackTrace(printWriter);
                th2 = th2.getCause();
            } while (th2 != null);
            str = stringWriter.toString();
            printWriter.close();
            stringWriter.close();
            return str;
        } catch (Exception unused) {
            return str;
        }
    }
}
