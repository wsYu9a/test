package com.kwad.sdk.utils.a;

import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import com.kwad.sdk.utils.a.c;
import com.kwad.sdk.utils.u;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: classes3.dex */
public final class e {
    static ExecutorService aNT = Executors.newSingleThreadExecutor();
    static boolean aTI = PN();

    /* renamed from: com.kwad.sdk.utils.a.e$1 */
    public class AnonymousClass1 implements c.d {
        @Override // com.kwad.sdk.utils.a.c.d
        public final void a(String str, Exception exc) {
            com.kwad.sdk.core.d.c.w("UnionKv", "name:" + str + " msg:" + Log.getStackTraceString(exc));
        }

        @Override // com.kwad.sdk.utils.a.c.d
        public final void e(String str, Throwable th2) {
            com.kwad.sdk.core.d.c.e("UnionKv", "name:" + str + " msg:" + Log.getStackTraceString(th2));
        }

        @Override // com.kwad.sdk.utils.a.c.d
        public final void i(String str, String str2) {
            com.kwad.sdk.core.d.c.i("UnionKv", "name:" + str + " msg:" + str2);
        }
    }

    private static boolean PN() {
        d.setExecutor(aNT);
        d.a(new c.d() { // from class: com.kwad.sdk.utils.a.e.1
            @Override // com.kwad.sdk.utils.a.c.d
            public final void a(String str, Exception exc) {
                com.kwad.sdk.core.d.c.w("UnionKv", "name:" + str + " msg:" + Log.getStackTraceString(exc));
            }

            @Override // com.kwad.sdk.utils.a.c.d
            public final void e(String str, Throwable th2) {
                com.kwad.sdk.core.d.c.e("UnionKv", "name:" + str + " msg:" + Log.getStackTraceString(th2));
            }

            @Override // com.kwad.sdk.utils.a.c.d
            public final void i(String str, String str2) {
                com.kwad.sdk.core.d.c.i("UnionKv", "name:" + str + " msg:" + str2);
            }
        });
        aTI = true;
        return true;
    }

    public static c aw(@NonNull Context context, String str) {
        if (!aTI) {
            PN();
        }
        return new c.a(u.O(context, "ks_union"), str).PL();
    }
}
