package com.kwad.components.core.e.a;

import android.app.Activity;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.bd;
import com.kwad.sdk.utils.bt;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Stack;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes3.dex */
public final class e {
    private final List<b> LL;
    private final Stack<AdTemplate> LM;
    private final AtomicBoolean LN;
    private final Set<String> LO;
    private final String TAG;
    private final AtomicBoolean pz;

    /* renamed from: com.kwad.components.core.e.a.e$1 */
    public class AnonymousClass1 extends bd {
        final /* synthetic */ AdTemplate cP;

        /* renamed from: com.kwad.components.core.e.a.e$1$1 */
        public class C04231 extends com.kwad.components.ad.b.a.c {
            final /* synthetic */ com.kwad.components.ad.b.a.a LQ;

            public C04231(com.kwad.components.ad.b.a.a aVar) {
                aVar = aVar;
            }

            @Override // com.kwad.components.ad.b.a.c, com.kwad.components.ad.b.a.b
            public final void U() {
                aVar.b(this);
                AnonymousClass1.this.nV();
                com.kwad.sdk.core.d.c.d("InstalledActivateManager", "startShow onPushAdClose");
            }
        }

        /* renamed from: com.kwad.components.core.e.a.e$1$2 */
        public class AnonymousClass2 extends com.kwad.sdk.core.c.d {
            public AnonymousClass2() {
            }

            @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
            /* renamed from: onActivityResumed */
            public final void d(Activity activity) {
                super.d(activity);
                com.kwad.sdk.core.c.b.Fi();
                com.kwad.sdk.core.c.b.b((com.kwad.sdk.core.c.c) this);
                com.kwad.sdk.core.d.c.d("InstalledActivateManager", "startShow onBackToForeground");
                AnonymousClass1.this.nW();
            }
        }

        public AnonymousClass1(AdTemplate adTemplate) {
            adTemplate = adTemplate;
        }

        public void nV() {
            com.kwad.sdk.core.c.b.Fi();
            if (!com.kwad.sdk.core.c.b.isEnable()) {
                e.this.LN.set(false);
                return;
            }
            com.kwad.sdk.core.c.b.Fi();
            if (com.kwad.sdk.core.c.b.getCurrentActivity() != null) {
                com.kwad.sdk.core.c.b.Fi();
                if (com.kwad.sdk.core.c.b.isAppOnForeground()) {
                    nW();
                    return;
                }
            }
            com.kwad.sdk.core.c.b.Fi();
            com.kwad.sdk.core.c.b.a(new com.kwad.sdk.core.c.d() { // from class: com.kwad.components.core.e.a.e.1.2
                public AnonymousClass2() {
                }

                @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
                /* renamed from: onActivityResumed */
                public final void d(Activity activity) {
                    super.d(activity);
                    com.kwad.sdk.core.c.b.Fi();
                    com.kwad.sdk.core.c.b.b((com.kwad.sdk.core.c.c) this);
                    com.kwad.sdk.core.d.c.d("InstalledActivateManager", "startShow onBackToForeground");
                    AnonymousClass1.this.nW();
                }
            });
        }

        public void nW() {
            com.kwad.sdk.core.d.c.d("InstalledActivateManager", "startShow");
            e.this.as(adTemplate);
            e.this.LN.set(false);
            e.this.LO.remove(com.kwad.sdk.core.response.b.a.ay(com.kwad.sdk.core.response.b.e.eb(adTemplate)));
        }

        @Override // com.kwad.sdk.utils.bd
        public final void doTask() {
            com.kwad.components.ad.b.a.a aVar = (com.kwad.components.ad.b.a.a) com.kwad.sdk.components.d.f(com.kwad.components.ad.b.a.a.class);
            if (aVar == null || !aVar.S()) {
                nV();
            } else {
                aVar.a(new com.kwad.components.ad.b.a.c() { // from class: com.kwad.components.core.e.a.e.1.1
                    final /* synthetic */ com.kwad.components.ad.b.a.a LQ;

                    public C04231(com.kwad.components.ad.b.a.a aVar2) {
                        aVar = aVar2;
                    }

                    @Override // com.kwad.components.ad.b.a.c, com.kwad.components.ad.b.a.b
                    public final void U() {
                        aVar.b(this);
                        AnonymousClass1.this.nV();
                        com.kwad.sdk.core.d.c.d("InstalledActivateManager", "startShow onPushAdClose");
                    }
                });
            }
        }
    }

    /* renamed from: com.kwad.components.core.e.a.e$2 */
    public class AnonymousClass2 implements b {
        public AnonymousClass2() {
        }

        @Override // com.kwad.components.core.e.a.b
        public final void fj() {
            com.kwad.sdk.core.d.c.d("InstalledActivateManager", "onViewClose");
            e.this.ef();
            e.this.nU();
        }

        @Override // com.kwad.components.core.e.a.b
        public final void nR() {
            com.kwad.sdk.core.d.c.d("InstalledActivateManager", "onViewShow");
            e.this.eu();
        }
    }

    public static class a {
        private static final e LS = new e((byte) 0);
    }

    public /* synthetic */ e(byte b10) {
        this();
    }

    private void ar(AdTemplate adTemplate) {
        if (!this.LN.get() && !this.pz.get()) {
            com.kwad.sdk.core.d.c.d("InstalledActivateManager", "showInstalledActivate");
            this.LN.set(true);
            bt.runOnUiThreadDelay(new bd() { // from class: com.kwad.components.core.e.a.e.1
                final /* synthetic */ AdTemplate cP;

                /* renamed from: com.kwad.components.core.e.a.e$1$1 */
                public class C04231 extends com.kwad.components.ad.b.a.c {
                    final /* synthetic */ com.kwad.components.ad.b.a.a LQ;

                    public C04231(com.kwad.components.ad.b.a.a aVar2) {
                        aVar = aVar2;
                    }

                    @Override // com.kwad.components.ad.b.a.c, com.kwad.components.ad.b.a.b
                    public final void U() {
                        aVar.b(this);
                        AnonymousClass1.this.nV();
                        com.kwad.sdk.core.d.c.d("InstalledActivateManager", "startShow onPushAdClose");
                    }
                }

                /* renamed from: com.kwad.components.core.e.a.e$1$2 */
                public class AnonymousClass2 extends com.kwad.sdk.core.c.d {
                    public AnonymousClass2() {
                    }

                    @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
                    /* renamed from: onActivityResumed */
                    public final void d(Activity activity) {
                        super.d(activity);
                        com.kwad.sdk.core.c.b.Fi();
                        com.kwad.sdk.core.c.b.b((com.kwad.sdk.core.c.c) this);
                        com.kwad.sdk.core.d.c.d("InstalledActivateManager", "startShow onBackToForeground");
                        AnonymousClass1.this.nW();
                    }
                }

                public AnonymousClass1(AdTemplate adTemplate2) {
                    adTemplate = adTemplate2;
                }

                public void nV() {
                    com.kwad.sdk.core.c.b.Fi();
                    if (!com.kwad.sdk.core.c.b.isEnable()) {
                        e.this.LN.set(false);
                        return;
                    }
                    com.kwad.sdk.core.c.b.Fi();
                    if (com.kwad.sdk.core.c.b.getCurrentActivity() != null) {
                        com.kwad.sdk.core.c.b.Fi();
                        if (com.kwad.sdk.core.c.b.isAppOnForeground()) {
                            nW();
                            return;
                        }
                    }
                    com.kwad.sdk.core.c.b.Fi();
                    com.kwad.sdk.core.c.b.a(new com.kwad.sdk.core.c.d() { // from class: com.kwad.components.core.e.a.e.1.2
                        public AnonymousClass2() {
                        }

                        @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
                        /* renamed from: onActivityResumed */
                        public final void d(Activity activity) {
                            super.d(activity);
                            com.kwad.sdk.core.c.b.Fi();
                            com.kwad.sdk.core.c.b.b((com.kwad.sdk.core.c.c) this);
                            com.kwad.sdk.core.d.c.d("InstalledActivateManager", "startShow onBackToForeground");
                            AnonymousClass1.this.nW();
                        }
                    });
                }

                public void nW() {
                    com.kwad.sdk.core.d.c.d("InstalledActivateManager", "startShow");
                    e.this.as(adTemplate);
                    e.this.LN.set(false);
                    e.this.LO.remove(com.kwad.sdk.core.response.b.a.ay(com.kwad.sdk.core.response.b.e.eb(adTemplate)));
                }

                @Override // com.kwad.sdk.utils.bd
                public final void doTask() {
                    com.kwad.components.ad.b.a.a aVar2 = (com.kwad.components.ad.b.a.a) com.kwad.sdk.components.d.f(com.kwad.components.ad.b.a.a.class);
                    if (aVar2 == null || !aVar2.S()) {
                        nV();
                    } else {
                        aVar2.a(new com.kwad.components.ad.b.a.c() { // from class: com.kwad.components.core.e.a.e.1.1
                            final /* synthetic */ com.kwad.components.ad.b.a.a LQ;

                            public C04231(com.kwad.components.ad.b.a.a aVar22) {
                                aVar = aVar22;
                            }

                            @Override // com.kwad.components.ad.b.a.c, com.kwad.components.ad.b.a.b
                            public final void U() {
                                aVar.b(this);
                                AnonymousClass1.this.nV();
                                com.kwad.sdk.core.d.c.d("InstalledActivateManager", "startShow onPushAdClose");
                            }
                        });
                    }
                }
            }, com.kwad.sdk.core.response.b.b.du(adTemplate2));
        } else {
            com.kwad.sdk.core.d.c.d("InstalledActivateManager", "mLoadDisable: " + this.pz.get() + ", mLoadDisable: " + this.LN.get());
            this.LM.add(adTemplate2);
        }
    }

    public void as(AdTemplate adTemplate) {
        if (a(adTemplate, new b() { // from class: com.kwad.components.core.e.a.e.2
            public AnonymousClass2() {
            }

            @Override // com.kwad.components.core.e.a.b
            public final void fj() {
                com.kwad.sdk.core.d.c.d("InstalledActivateManager", "onViewClose");
                e.this.ef();
                e.this.nU();
            }

            @Override // com.kwad.components.core.e.a.b
            public final void nR() {
                com.kwad.sdk.core.d.c.d("InstalledActivateManager", "onViewShow");
                e.this.eu();
            }
        })) {
            return;
        }
        nU();
    }

    public static e nT() {
        return a.LS;
    }

    public synchronized void nU() {
        if (this.LM.isEmpty()) {
            return;
        }
        ar(this.LM.pop());
    }

    public final synchronized void aq(AdTemplate adTemplate) {
        String ay = com.kwad.sdk.core.response.b.a.ay(com.kwad.sdk.core.response.b.e.eb(adTemplate));
        if (com.kwad.sdk.core.response.b.b.dt(adTemplate) && !this.LO.contains(ay)) {
            this.LO.add(ay);
            ar(adTemplate);
        }
    }

    public final void ef() {
        this.pz.set(false);
        Iterator<b> it = this.LL.iterator();
        while (it.hasNext()) {
            it.next().fj();
        }
    }

    public final void eu() {
        this.pz.set(true);
        Iterator<b> it = this.LL.iterator();
        while (it.hasNext()) {
            it.next().nR();
        }
    }

    public final boolean isShowing() {
        return this.pz.get();
    }

    private e() {
        this.TAG = "InstalledActivateManager";
        this.LL = new CopyOnWriteArrayList();
        this.LM = new Stack<>();
        this.pz = new AtomicBoolean();
        this.LN = new AtomicBoolean();
        this.LO = new HashSet();
    }

    public final void b(b bVar) {
        this.LL.remove(bVar);
    }

    public final void a(b bVar) {
        this.LL.add(bVar);
    }

    private static boolean a(AdTemplate adTemplate, b bVar) {
        com.kwad.sdk.core.d.c.d("InstalledActivateManager", "showToActivityWindow");
        return new h().b(adTemplate, bVar);
    }
}
