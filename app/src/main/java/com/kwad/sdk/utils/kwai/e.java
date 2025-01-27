package com.kwad.sdk.utils.kwai;

import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import com.kwad.sdk.utils.kwai.c;
import com.kwad.sdk.utils.q;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: classes2.dex */
public final class e {
    static ExecutorService aCC = Executors.newSingleThreadExecutor();
    static boolean aya = Fx();

    /* renamed from: com.kwad.sdk.utils.kwai.e$1 */
    static class AnonymousClass1 implements c.d {
        AnonymousClass1() {
        }

        @Override // com.kwad.sdk.utils.kwai.c.d
        public final void a(String str, Exception exc) {
            com.kwad.sdk.core.d.b.w("Ks_UnionKv", "name:" + str + " msg:" + Log.getStackTraceString(exc));
        }

        @Override // com.kwad.sdk.utils.kwai.c.d
        public final void e(String str, Throwable th) {
            com.kwad.sdk.core.d.b.e("Ks_UnionKv", "name:" + str + " msg:" + Log.getStackTraceString(th));
        }

        @Override // com.kwad.sdk.utils.kwai.c.d
        public final void i(String str, String str2) {
            com.kwad.sdk.core.d.b.i("Ks_UnionKv", "name:" + str + " msg:" + str2);
        }
    }

    private static boolean Fx() {
        d.setExecutor(aCC);
        d.a(new c.d() { // from class: com.kwad.sdk.utils.kwai.e.1
            AnonymousClass1() {
            }

            @Override // com.kwad.sdk.utils.kwai.c.d
            public final void a(String str, Exception exc) {
                com.kwad.sdk.core.d.b.w("Ks_UnionKv", "name:" + str + " msg:" + Log.getStackTraceString(exc));
            }

            @Override // com.kwad.sdk.utils.kwai.c.d
            public final void e(String str, Throwable th) {
                com.kwad.sdk.core.d.b.e("Ks_UnionKv", "name:" + str + " msg:" + Log.getStackTraceString(th));
            }

            @Override // com.kwad.sdk.utils.kwai.c.d
            public final void i(String str, String str2) {
                com.kwad.sdk.core.d.b.i("Ks_UnionKv", "name:" + str + " msg:" + str2);
            }
        });
        aya = true;
        return true;
    }

    public static c aq(@NonNull Context context, String str) {
        if (!aya) {
            Fx();
        }
        return new c.a(q.G(context, "ks_union"), str).Fv();
    }
}
