package com.kwad.sdk.core.diskcache.b;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.diskcache.a.a;
import com.kwad.sdk.core.network.a.a;
import com.kwad.sdk.utils.bd;
import com.kwad.sdk.utils.h;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

/* loaded from: classes3.dex */
public final class b {

    /* renamed from: com.kwad.sdk.core.diskcache.b.b$1 */
    public class AnonymousClass1 extends bd {
        final /* synthetic */ String FJ;
        final /* synthetic */ String ayh;

        public AnonymousClass1(String str, String str2) {
            str2 = str;
            str = str2;
        }

        @Override // com.kwad.sdk.utils.bd
        public final void doTask() {
            OutputStream outputStream = null;
            try {
                a.C0487a dB = com.kwad.sdk.core.diskcache.a.a.this.dB(str2);
                if (dB != null) {
                    outputStream = dB.da(0);
                    if (b.a(str, outputStream, new a.C0497a())) {
                        dB.commit();
                    } else {
                        dB.abort();
                    }
                    com.kwad.sdk.core.diskcache.a.a.this.flush();
                }
                com.kwad.sdk.crash.utils.b.closeQuietly(outputStream);
            } catch (IOException unused) {
                com.kwad.sdk.crash.utils.b.closeQuietly(outputStream);
            } catch (Throwable th2) {
                com.kwad.sdk.crash.utils.b.closeQuietly(outputStream);
                throw th2;
            }
        }
    }

    public static void a(@NonNull com.kwad.sdk.core.diskcache.a.a aVar, @NonNull String str, @NonNull String str2) {
        h.execute(new bd() { // from class: com.kwad.sdk.core.diskcache.b.b.1
            final /* synthetic */ String FJ;
            final /* synthetic */ String ayh;

            public AnonymousClass1(String str22, String str3) {
                str2 = str22;
                str = str3;
            }

            @Override // com.kwad.sdk.utils.bd
            public final void doTask() {
                OutputStream outputStream = null;
                try {
                    a.C0487a dB = com.kwad.sdk.core.diskcache.a.a.this.dB(str2);
                    if (dB != null) {
                        outputStream = dB.da(0);
                        if (b.a(str, outputStream, new a.C0497a())) {
                            dB.commit();
                        } else {
                            dB.abort();
                        }
                        com.kwad.sdk.core.diskcache.a.a.this.flush();
                    }
                    com.kwad.sdk.crash.utils.b.closeQuietly(outputStream);
                } catch (IOException unused) {
                    com.kwad.sdk.crash.utils.b.closeQuietly(outputStream);
                } catch (Throwable th2) {
                    com.kwad.sdk.crash.utils.b.closeQuietly(outputStream);
                    throw th2;
                }
            }
        });
    }

    public static File a(@NonNull com.kwad.sdk.core.diskcache.a.a aVar, @NonNull String str) {
        a.c cVar;
        a.c cVar2 = null;
        try {
            cVar = aVar.dA(str);
            if (cVar != null) {
                try {
                    File dd2 = cVar.dd(0);
                    com.kwad.sdk.crash.utils.b.closeQuietly(cVar);
                    return dd2;
                } catch (IOException unused) {
                } catch (Throwable th2) {
                    th = th2;
                    cVar2 = cVar;
                    com.kwad.sdk.crash.utils.b.closeQuietly(cVar2);
                    throw th;
                }
            }
        } catch (IOException unused2) {
            cVar = null;
        } catch (Throwable th3) {
            th = th3;
        }
        com.kwad.sdk.crash.utils.b.closeQuietly(cVar);
        return null;
    }

    public static boolean a(@NonNull com.kwad.sdk.core.diskcache.a.a aVar, @NonNull String str, @NonNull String str2, a.C0497a c0497a) {
        boolean z10 = false;
        OutputStream outputStream = null;
        try {
            try {
                a.C0487a dB = aVar.dB(str2);
                if (dB != null) {
                    outputStream = dB.da(0);
                    if (a(str, outputStream, c0497a)) {
                        dB.commit();
                        z10 = true;
                    } else {
                        dB.abort();
                    }
                    aVar.flush();
                }
            } catch (IOException e10) {
                c0497a.msg = e10.getMessage();
            }
            com.kwad.sdk.crash.utils.b.closeQuietly(outputStream);
            return z10;
        } catch (Throwable th2) {
            com.kwad.sdk.crash.utils.b.closeQuietly(outputStream);
            throw th2;
        }
    }

    public static boolean a(String str, OutputStream outputStream, a.C0497a c0497a) {
        return com.kwad.sdk.core.network.a.a.a(str, outputStream, c0497a, -1L, null);
    }
}
