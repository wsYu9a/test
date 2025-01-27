package com.kwad.sdk.core.diskcache.a;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.diskcache.kwai.a;
import com.kwad.sdk.core.network.kwai.a;
import com.kwad.sdk.utils.g;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

/* loaded from: classes2.dex */
public final class b {

    /* renamed from: com.kwad.sdk.core.diskcache.a.b$1 */
    static class AnonymousClass1 implements Runnable {
        final /* synthetic */ String aeU;
        final /* synthetic */ String hD;

        AnonymousClass1(String str, String str2) {
            str2 = str;
            str = str2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            OutputStream outputStream = null;
            try {
                a.C0210a bG = com.kwad.sdk.core.diskcache.kwai.a.this.bG(str2);
                if (bG != null) {
                    outputStream = bG.aW(0);
                    if (b.a(str, outputStream, new a.C0217a())) {
                        bG.commit();
                    } else {
                        bG.abort();
                    }
                    com.kwad.sdk.core.diskcache.kwai.a.this.flush();
                }
            } catch (IOException unused) {
            } finally {
                com.kwad.sdk.crash.utils.b.closeQuietly(outputStream);
            }
        }
    }

    static File a(@NonNull com.kwad.sdk.core.diskcache.kwai.a aVar, @NonNull String str) {
        try {
            a.c bF = aVar.bF(str);
            if (bF != null) {
                return bF.aZ(0);
            }
            return null;
        } catch (IOException unused) {
            return null;
        }
    }

    static void a(@NonNull com.kwad.sdk.core.diskcache.kwai.a aVar, @NonNull String str, @NonNull String str2) {
        g.execute(new Runnable() { // from class: com.kwad.sdk.core.diskcache.a.b.1
            final /* synthetic */ String aeU;
            final /* synthetic */ String hD;

            AnonymousClass1(String str22, String str3) {
                str2 = str22;
                str = str3;
            }

            @Override // java.lang.Runnable
            public final void run() {
                OutputStream outputStream = null;
                try {
                    a.C0210a bG = com.kwad.sdk.core.diskcache.kwai.a.this.bG(str2);
                    if (bG != null) {
                        outputStream = bG.aW(0);
                        if (b.a(str, outputStream, new a.C0217a())) {
                            bG.commit();
                        } else {
                            bG.abort();
                        }
                        com.kwad.sdk.core.diskcache.kwai.a.this.flush();
                    }
                } catch (IOException unused) {
                } finally {
                    com.kwad.sdk.crash.utils.b.closeQuietly(outputStream);
                }
            }
        });
    }

    static boolean a(@NonNull com.kwad.sdk.core.diskcache.kwai.a aVar, @NonNull String str, @NonNull String str2, a.C0217a c0217a) {
        boolean z = false;
        OutputStream outputStream = null;
        try {
            try {
                a.C0210a bG = aVar.bG(str2);
                if (bG != null) {
                    outputStream = bG.aW(0);
                    if (a(str, outputStream, c0217a)) {
                        bG.commit();
                        z = true;
                    } else {
                        bG.abort();
                    }
                    aVar.flush();
                }
            } catch (IOException e2) {
                c0217a.msg = e2.getMessage();
            }
            return z;
        } finally {
            com.kwad.sdk.crash.utils.b.closeQuietly(outputStream);
        }
    }

    public static boolean a(String str, OutputStream outputStream, a.C0217a c0217a) {
        return com.kwad.sdk.core.network.kwai.a.a(str, outputStream, c0217a, -1);
    }
}
