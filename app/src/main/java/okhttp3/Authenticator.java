package okhttp3;

import java.io.IOException;
import javax.annotation.Nullable;

/* loaded from: classes.dex */
public interface Authenticator {
    public static final Authenticator NONE = new Authenticator() { // from class: okhttp3.Authenticator.1
        AnonymousClass1() {
        }

        @Override // okhttp3.Authenticator
        public Request authenticate(@Nullable Route route, Response response) {
            return null;
        }
    };

    /* renamed from: okhttp3.Authenticator$1 */
    class AnonymousClass1 implements Authenticator {
        AnonymousClass1() {
        }

        @Override // okhttp3.Authenticator
        public Request authenticate(@Nullable Route route, Response response) {
            return null;
        }
    }

    @Nullable
    Request authenticate(@Nullable Route route, Response response) throws IOException;
}
