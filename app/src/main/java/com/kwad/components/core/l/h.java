package com.kwad.components.core.l;

import android.os.Bundle;
import com.kwad.sdk.utils.bi;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes2.dex */
public class h {
    private static volatile h NT;
    private final List<i> mListeners = new CopyOnWriteArrayList();

    /* renamed from: com.kwad.components.core.l.h$1 */
    final class AnonymousClass1 implements com.kwad.sdk.e.a<i> {
        final /* synthetic */ d NU;
        final /* synthetic */ Bundle NV;

        AnonymousClass1(d dVar, Bundle bundle) {
            dVar = dVar;
            bundle = bundle;
        }

        @Override // com.kwad.sdk.e.a
        /* renamed from: b */
        public void accept(i iVar) {
            iVar.onActivityCreated(dVar, bundle);
        }
    }

    /* renamed from: com.kwad.components.core.l.h$2 */
    final class AnonymousClass2 implements com.kwad.sdk.e.a<i> {
        final /* synthetic */ d NU;

        AnonymousClass2(d dVar) {
            dVar = dVar;
        }

        @Override // com.kwad.sdk.e.a
        /* renamed from: b */
        public void accept(i iVar) {
            iVar.onActivityResumed(dVar);
        }
    }

    /* renamed from: com.kwad.components.core.l.h$3 */
    final class AnonymousClass3 implements com.kwad.sdk.e.a<i> {
        final /* synthetic */ d NU;

        AnonymousClass3(d dVar) {
            dVar = dVar;
        }

        @Override // com.kwad.sdk.e.a
        /* renamed from: b */
        public void accept(i iVar) {
            iVar.onActivityPaused(dVar);
        }
    }

    /* renamed from: com.kwad.components.core.l.h$4 */
    final class AnonymousClass4 implements com.kwad.sdk.e.a<i> {
        final /* synthetic */ d NU;

        AnonymousClass4(d dVar) {
            dVar = dVar;
        }

        @Override // com.kwad.sdk.e.a
        /* renamed from: b */
        public void accept(i iVar) {
            iVar.onActivityDestroyed(dVar);
        }
    }

    /* renamed from: com.kwad.components.core.l.h$5 */
    final class AnonymousClass5 implements Runnable {
        final /* synthetic */ com.kwad.sdk.e.a NX;

        AnonymousClass5(com.kwad.sdk.e.a aVar) {
            aVar = aVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            for (i iVar : h.this.mListeners) {
                if (iVar != null) {
                    try {
                        aVar.accept(iVar);
                    } catch (Throwable th) {
                        com.kwad.sdk.core.d.b.printStackTraceOnly(th);
                    }
                }
            }
        }
    }

    private void a(com.kwad.sdk.e.a<i> aVar) {
        bi.postOnUiThread(new Runnable() { // from class: com.kwad.components.core.l.h.5
            final /* synthetic */ com.kwad.sdk.e.a NX;

            AnonymousClass5(com.kwad.sdk.e.a aVar2) {
                aVar = aVar2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                for (i iVar : h.this.mListeners) {
                    if (iVar != null) {
                        try {
                            aVar.accept(iVar);
                        } catch (Throwable th) {
                            com.kwad.sdk.core.d.b.printStackTraceOnly(th);
                        }
                    }
                }
            }
        });
    }

    public static h oZ() {
        if (NT == null) {
            synchronized (h.class) {
                if (NT == null) {
                    NT = new h();
                }
            }
        }
        return NT;
    }

    public final void a(d dVar, Bundle bundle) {
        a(new com.kwad.sdk.e.a<i>() { // from class: com.kwad.components.core.l.h.1
            final /* synthetic */ d NU;
            final /* synthetic */ Bundle NV;

            AnonymousClass1(d dVar2, Bundle bundle2) {
                dVar = dVar2;
                bundle = bundle2;
            }

            @Override // com.kwad.sdk.e.a
            /* renamed from: b */
            public void accept(i iVar) {
                iVar.onActivityCreated(dVar, bundle);
            }
        });
    }

    public final void a(i iVar) {
        this.mListeners.add(iVar);
    }

    public final void d(d dVar) {
        a(new com.kwad.sdk.e.a<i>() { // from class: com.kwad.components.core.l.h.2
            final /* synthetic */ d NU;

            AnonymousClass2(d dVar2) {
                dVar = dVar2;
            }

            @Override // com.kwad.sdk.e.a
            /* renamed from: b */
            public void accept(i iVar) {
                iVar.onActivityResumed(dVar);
            }
        });
    }

    public final void e(d dVar) {
        a(new com.kwad.sdk.e.a<i>() { // from class: com.kwad.components.core.l.h.3
            final /* synthetic */ d NU;

            AnonymousClass3(d dVar2) {
                dVar = dVar2;
            }

            @Override // com.kwad.sdk.e.a
            /* renamed from: b */
            public void accept(i iVar) {
                iVar.onActivityPaused(dVar);
            }
        });
    }

    public final void f(d dVar) {
        a(new com.kwad.sdk.e.a<i>() { // from class: com.kwad.components.core.l.h.4
            final /* synthetic */ d NU;

            AnonymousClass4(d dVar2) {
                dVar = dVar2;
            }

            @Override // com.kwad.sdk.e.a
            /* renamed from: b */
            public void accept(i iVar) {
                iVar.onActivityDestroyed(dVar);
            }
        });
    }
}
