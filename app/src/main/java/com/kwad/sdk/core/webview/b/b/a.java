package com.kwad.sdk.core.webview.b.b;

import androidx.annotation.NonNull;
import com.kwad.framework.filedownloader.m;
import com.kwad.framework.filedownloader.r;
import com.kwad.sdk.core.d.c;

/* loaded from: classes3.dex */
public final class a {

    /* renamed from: com.kwad.sdk.core.webview.b.b.a$1 */
    public class AnonymousClass1 extends m {
        final /* synthetic */ com.kwad.sdk.g.a.b aIG;

        public AnonymousClass1(com.kwad.sdk.g.a.b bVar) {
            bVar = bVar;
        }

        @Override // com.kwad.framework.filedownloader.m, com.kwad.framework.filedownloader.i
        public final void a(com.kwad.framework.filedownloader.a aVar, Throwable th2) {
            super.a(aVar, th2);
            com.kwad.sdk.core.webview.b.c.b.a(bVar, 0, 1, th2.getMessage());
            InterfaceC0501a.this.e((com.kwad.sdk.g.a.b) aVar.getTag());
        }

        @Override // com.kwad.framework.filedownloader.m, com.kwad.framework.filedownloader.i
        public final void c(com.kwad.framework.filedownloader.a aVar) {
            super.c(aVar);
            if (aVar.vd() == -3) {
                InterfaceC0501a.this.d(bVar);
                return;
            }
            InterfaceC0501a.this.e(bVar);
            com.kwad.sdk.core.webview.b.c.b.a(bVar, 0, 1, "task.getStatus()=" + ((int) aVar.vd()));
        }
    }

    /* renamed from: com.kwad.sdk.core.webview.b.b.a$a */
    public interface InterfaceC0501a {
        void c(com.kwad.sdk.g.a.b bVar);

        void d(com.kwad.sdk.g.a.b bVar);

        void e(com.kwad.sdk.g.a.b bVar);
    }

    public static void a(com.kwad.sdk.g.a.b bVar, @NonNull InterfaceC0501a interfaceC0501a) {
        c.d("HybridDownloader", "reportHybrid: download+++url " + bVar.packageUrl);
        interfaceC0501a.c(bVar);
        bVar.aI(System.currentTimeMillis());
        com.kwad.sdk.core.webview.b.c.b.a(bVar, 1);
        r.aA(com.kwad.sdk.n.m.Qa());
        r.wc();
        r.bg(bVar.packageUrl).e(bVar).be(bVar.aMA).bc(true).a(new m() { // from class: com.kwad.sdk.core.webview.b.b.a.1
            final /* synthetic */ com.kwad.sdk.g.a.b aIG;

            public AnonymousClass1(com.kwad.sdk.g.a.b bVar2) {
                bVar = bVar2;
            }

            @Override // com.kwad.framework.filedownloader.m, com.kwad.framework.filedownloader.i
            public final void a(com.kwad.framework.filedownloader.a aVar, Throwable th2) {
                super.a(aVar, th2);
                com.kwad.sdk.core.webview.b.c.b.a(bVar, 0, 1, th2.getMessage());
                InterfaceC0501a.this.e((com.kwad.sdk.g.a.b) aVar.getTag());
            }

            @Override // com.kwad.framework.filedownloader.m, com.kwad.framework.filedownloader.i
            public final void c(com.kwad.framework.filedownloader.a aVar) {
                super.c(aVar);
                if (aVar.vd() == -3) {
                    InterfaceC0501a.this.d(bVar);
                    return;
                }
                InterfaceC0501a.this.e(bVar);
                com.kwad.sdk.core.webview.b.c.b.a(bVar, 0, 1, "task.getStatus()=" + ((int) aVar.vd()));
            }
        }).start();
    }
}
