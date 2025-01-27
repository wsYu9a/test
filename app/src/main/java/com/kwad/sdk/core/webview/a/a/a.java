package com.kwad.sdk.core.webview.a.a;

import androidx.annotation.NonNull;
import com.kwad.sdk.j.k;
import com.kwai.filedownloader.m;
import com.kwai.filedownloader.r;

/* loaded from: classes2.dex */
public final class a {

    /* renamed from: com.kwad.sdk.core.webview.a.a.a$1 */
    static class AnonymousClass1 extends m {
        final /* synthetic */ com.kwad.sdk.f.kwai.b apP;

        AnonymousClass1(com.kwad.sdk.f.kwai.b bVar) {
            bVar = bVar;
        }

        @Override // com.kwai.filedownloader.m, com.kwai.filedownloader.i
        public final void a(com.kwai.filedownloader.a aVar, Throwable th) {
            super.a(aVar, th);
            com.kwad.sdk.core.webview.a.b.b.a(bVar, 0, 1, th.getMessage());
            InterfaceC0221a.this.e((com.kwad.sdk.f.kwai.b) aVar.getTag());
        }

        @Override // com.kwai.filedownloader.m, com.kwai.filedownloader.i
        public final void c(com.kwai.filedownloader.a aVar) {
            super.c(aVar);
            if (aVar.Gq() == -3) {
                InterfaceC0221a.this.d(bVar);
                return;
            }
            InterfaceC0221a.this.e(bVar);
            com.kwad.sdk.core.webview.a.b.b.a(bVar, 0, 1, "task.getStatus()=" + ((int) aVar.Gq()));
        }
    }

    /* renamed from: com.kwad.sdk.core.webview.a.a.a$a */
    public interface InterfaceC0221a {
        void c(com.kwad.sdk.f.kwai.b bVar);

        void d(com.kwad.sdk.f.kwai.b bVar);

        void e(com.kwad.sdk.f.kwai.b bVar);
    }

    public static void a(com.kwad.sdk.f.kwai.b bVar, @NonNull InterfaceC0221a interfaceC0221a) {
        com.kwad.sdk.core.d.b.d("HybridDownloader", "reportHybrid: download+++url " + bVar.packageUrl);
        interfaceC0221a.c(bVar);
        bVar.aa(System.currentTimeMillis());
        com.kwad.sdk.core.webview.a.b.b.a(bVar, 1);
        r.ds(k.FP());
        r.Hp();
        r.fm(bVar.packageUrl).k(bVar).fj(bVar.ato).bQ(true).a(new m() { // from class: com.kwad.sdk.core.webview.a.a.a.1
            final /* synthetic */ com.kwad.sdk.f.kwai.b apP;

            AnonymousClass1(com.kwad.sdk.f.kwai.b bVar2) {
                bVar = bVar2;
            }

            @Override // com.kwai.filedownloader.m, com.kwai.filedownloader.i
            public final void a(com.kwai.filedownloader.a aVar, Throwable th) {
                super.a(aVar, th);
                com.kwad.sdk.core.webview.a.b.b.a(bVar, 0, 1, th.getMessage());
                InterfaceC0221a.this.e((com.kwad.sdk.f.kwai.b) aVar.getTag());
            }

            @Override // com.kwai.filedownloader.m, com.kwai.filedownloader.i
            public final void c(com.kwai.filedownloader.a aVar) {
                super.c(aVar);
                if (aVar.Gq() == -3) {
                    InterfaceC0221a.this.d(bVar);
                    return;
                }
                InterfaceC0221a.this.e(bVar);
                com.kwad.sdk.core.webview.a.b.b.a(bVar, 0, 1, "task.getStatus()=" + ((int) aVar.Gq()));
            }
        }).start();
    }
}
