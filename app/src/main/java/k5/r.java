package k5;

import java.io.Flushable;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

@p
@a5.a
@a5.c
/* loaded from: classes2.dex */
public final class r {

    /* renamed from: a */
    public static final Logger f27686a = Logger.getLogger(r.class.getName());

    public static void a(Flushable flushable, boolean z10) throws IOException {
        try {
            flushable.flush();
        } catch (IOException e10) {
            if (!z10) {
                throw e10;
            }
            f27686a.log(Level.WARNING, "IOException thrown while flushing Flushable.", (Throwable) e10);
        }
    }

    public static void b(Flushable flushable) {
        try {
            a(flushable, true);
        } catch (IOException e10) {
            f27686a.log(Level.SEVERE, "IOException should not have been thrown.", (Throwable) e10);
        }
    }
}
