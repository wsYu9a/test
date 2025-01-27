package com.kwad.components.core.proxy;

import android.os.Bundle;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bd;
import com.kwad.sdk.utils.bt;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes3.dex */
public class l {
    private static volatile l Tj;
    private final List<m> mListeners = new CopyOnWriteArrayList();

    /* renamed from: com.kwad.components.core.proxy.l$1 */
    public class AnonymousClass1 implements com.kwad.sdk.f.a<m> {
        final /* synthetic */ f Tk;
        final /* synthetic */ Bundle Tl;

        public AnonymousClass1(f fVar, Bundle bundle) {
            fVar = fVar;
            bundle = bundle;
        }

        @Override // com.kwad.sdk.f.a
        public final /* bridge */ /* synthetic */ void accept(m mVar) {
        }
    }

    /* renamed from: com.kwad.components.core.proxy.l$2 */
    public class AnonymousClass2 implements com.kwad.sdk.f.a<m> {
        final /* synthetic */ f Tk;

        public AnonymousClass2(f fVar) {
            fVar = fVar;
        }

        @Override // com.kwad.sdk.f.a
        /* renamed from: b */
        public void accept(m mVar) {
            mVar.d(fVar);
        }
    }

    /* renamed from: com.kwad.components.core.proxy.l$3 */
    public class AnonymousClass3 implements com.kwad.sdk.f.a<m> {
        final /* synthetic */ f Tk;

        public AnonymousClass3(f fVar) {
            fVar = fVar;
        }

        @Override // com.kwad.sdk.f.a
        /* renamed from: b */
        public void accept(m mVar) {
            mVar.c(fVar);
        }
    }

    /* renamed from: com.kwad.components.core.proxy.l$4 */
    public class AnonymousClass4 implements com.kwad.sdk.f.a<m> {
        final /* synthetic */ f Tk;

        public AnonymousClass4(f fVar) {
            fVar = fVar;
        }

        @Override // com.kwad.sdk.f.a
        public final /* bridge */ /* synthetic */ void accept(m mVar) {
        }
    }

    /* renamed from: com.kwad.components.core.proxy.l$5 */
    public class AnonymousClass5 extends bd {
        final /* synthetic */ com.kwad.sdk.f.a oM;

        public AnonymousClass5(com.kwad.sdk.f.a aVar) {
            aVar = aVar;
        }

        @Override // com.kwad.sdk.utils.bd
        public final void doTask() {
            for (m mVar : l.this.mListeners) {
                if (mVar != null) {
                    try {
                        aVar.accept(mVar);
                    } catch (Throwable th2) {
                        ServiceProvider.reportSdkCaughtException(th2);
                    }
                }
            }
        }
    }

    private void c(com.kwad.sdk.f.a<m> aVar) {
        bt.postOnUiThread(new bd() { // from class: com.kwad.components.core.proxy.l.5
            final /* synthetic */ com.kwad.sdk.f.a oM;

            public AnonymousClass5(com.kwad.sdk.f.a aVar2) {
                aVar = aVar2;
            }

            @Override // com.kwad.sdk.utils.bd
            public final void doTask() {
                for (m mVar : l.this.mListeners) {
                    if (mVar != null) {
                        try {
                            aVar.accept(mVar);
                        } catch (Throwable th2) {
                            ServiceProvider.reportSdkCaughtException(th2);
                        }
                    }
                }
            }
        });
    }

    public static l qZ() {
        if (Tj == null) {
            synchronized (l.class) {
                try {
                    if (Tj == null) {
                        Tj = new l();
                    }
                } finally {
                }
            }
        }
        return Tj;
    }

    public final void e(f fVar) {
        c(new com.kwad.sdk.f.a<m>() { // from class: com.kwad.components.core.proxy.l.2
            final /* synthetic */ f Tk;

            public AnonymousClass2(f fVar2) {
                fVar = fVar2;
            }

            @Override // com.kwad.sdk.f.a
            /* renamed from: b */
            public void accept(m mVar) {
                mVar.d(fVar);
            }
        });
    }

    public final void f(f fVar) {
        c(new com.kwad.sdk.f.a<m>() { // from class: com.kwad.components.core.proxy.l.3
            final /* synthetic */ f Tk;

            public AnonymousClass3(f fVar2) {
                fVar = fVar2;
            }

            @Override // com.kwad.sdk.f.a
            /* renamed from: b */
            public void accept(m mVar) {
                mVar.c(fVar);
            }
        });
    }

    public final void g(f fVar) {
        c(new com.kwad.sdk.f.a<m>() { // from class: com.kwad.components.core.proxy.l.4
            final /* synthetic */ f Tk;

            public AnonymousClass4(f fVar2) {
                fVar = fVar2;
            }

            @Override // com.kwad.sdk.f.a
            public final /* bridge */ /* synthetic */ void accept(m mVar) {
            }
        });
    }

    public final void a(f fVar, Bundle bundle) {
        c(new com.kwad.sdk.f.a<m>() { // from class: com.kwad.components.core.proxy.l.1
            final /* synthetic */ f Tk;
            final /* synthetic */ Bundle Tl;

            public AnonymousClass1(f fVar2, Bundle bundle2) {
                fVar = fVar2;
                bundle = bundle2;
            }

            @Override // com.kwad.sdk.f.a
            public final /* bridge */ /* synthetic */ void accept(m mVar) {
            }
        });
    }

    public final void a(m mVar) {
        this.mListeners.add(mVar);
    }
}
