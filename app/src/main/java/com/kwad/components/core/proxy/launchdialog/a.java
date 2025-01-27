package com.kwad.components.core.proxy.launchdialog;

import androidx.lifecycle.Lifecycle;
import com.kwad.components.core.proxy.k;
import com.kwad.components.core.proxy.launchdialog.f;
import com.kwad.components.core.proxy.n;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes3.dex */
public final class a implements k {
    private List<k> Tn = new CopyOnWriteArrayList();
    private Map<com.kwad.components.core.proxy.a, List<b>> To = new HashMap();
    private com.kwad.components.core.proxy.a Tp;

    /* renamed from: com.kwad.components.core.proxy.launchdialog.a$1 */
    public class AnonymousClass1 implements com.kwad.sdk.f.a<k> {
        final /* synthetic */ com.kwad.components.core.proxy.a Tq;

        public AnonymousClass1(com.kwad.components.core.proxy.a aVar) {
            aVar = aVar;
        }

        @Override // com.kwad.sdk.f.a
        /* renamed from: c */
        public void accept(k kVar) {
            kVar.a(aVar);
        }
    }

    /* renamed from: com.kwad.components.core.proxy.launchdialog.a$2 */
    public class AnonymousClass2 implements com.kwad.sdk.f.a<k> {
        final /* synthetic */ com.kwad.components.core.proxy.a Tq;

        public AnonymousClass2(com.kwad.components.core.proxy.a aVar) {
            aVar = aVar;
        }

        @Override // com.kwad.sdk.f.a
        /* renamed from: c */
        public void accept(k kVar) {
            kVar.b(aVar);
        }
    }

    /* renamed from: com.kwad.components.core.proxy.launchdialog.a$3 */
    public class AnonymousClass3 implements com.kwad.sdk.f.a<k> {
        final /* synthetic */ com.kwad.components.core.proxy.a Tq;

        public AnonymousClass3(com.kwad.components.core.proxy.a aVar) {
            aVar = aVar;
        }

        @Override // com.kwad.sdk.f.a
        /* renamed from: c */
        public void accept(k kVar) {
            kVar.c(aVar);
        }
    }

    /* renamed from: com.kwad.components.core.proxy.launchdialog.a$4 */
    public class AnonymousClass4 implements com.kwad.sdk.f.a<k> {
        final /* synthetic */ com.kwad.components.core.proxy.a Tq;

        public AnonymousClass4(com.kwad.components.core.proxy.a aVar) {
            aVar = aVar;
        }

        @Override // com.kwad.sdk.f.a
        /* renamed from: c */
        public void accept(k kVar) {
            kVar.d(aVar);
        }
    }

    /* renamed from: com.kwad.components.core.proxy.launchdialog.a$5 */
    public class AnonymousClass5 implements com.kwad.sdk.f.a<k> {
        final /* synthetic */ com.kwad.components.core.proxy.a Tq;

        public AnonymousClass5(com.kwad.components.core.proxy.a aVar) {
            aVar = aVar;
        }

        @Override // com.kwad.sdk.f.a
        /* renamed from: c */
        public void accept(k kVar) {
            kVar.e(aVar);
        }
    }

    /* renamed from: com.kwad.components.core.proxy.launchdialog.a$6 */
    public class AnonymousClass6 implements com.kwad.sdk.f.a<k> {
        final /* synthetic */ com.kwad.components.core.proxy.a Tq;

        public AnonymousClass6(com.kwad.components.core.proxy.a aVar) {
            aVar = aVar;
        }

        @Override // com.kwad.sdk.f.a
        /* renamed from: c */
        public void accept(k kVar) {
            kVar.f(aVar);
        }
    }

    private void a(k kVar) {
        this.Tn.add(kVar);
    }

    private void b(k kVar) {
        if (kVar != null) {
            this.Tn.remove(kVar);
        }
    }

    @Override // com.kwad.components.core.proxy.k
    public final void c(com.kwad.components.core.proxy.a aVar) {
        this.Tp = aVar;
        a(aVar, new com.kwad.sdk.f.a<k>() { // from class: com.kwad.components.core.proxy.launchdialog.a.3
            final /* synthetic */ com.kwad.components.core.proxy.a Tq;

            public AnonymousClass3(com.kwad.components.core.proxy.a aVar2) {
                aVar = aVar2;
            }

            @Override // com.kwad.sdk.f.a
            /* renamed from: c */
            public void accept(k kVar) {
                kVar.c(aVar);
            }
        });
    }

    @Override // com.kwad.components.core.proxy.k
    public final void d(com.kwad.components.core.proxy.a aVar) {
        a(aVar, new com.kwad.sdk.f.a<k>() { // from class: com.kwad.components.core.proxy.launchdialog.a.4
            final /* synthetic */ com.kwad.components.core.proxy.a Tq;

            public AnonymousClass4(com.kwad.components.core.proxy.a aVar2) {
                aVar = aVar2;
            }

            @Override // com.kwad.sdk.f.a
            /* renamed from: c */
            public void accept(k kVar) {
                kVar.d(aVar);
            }
        });
    }

    @Override // com.kwad.components.core.proxy.k
    public final void e(com.kwad.components.core.proxy.a aVar) {
        a(aVar, new com.kwad.sdk.f.a<k>() { // from class: com.kwad.components.core.proxy.launchdialog.a.5
            final /* synthetic */ com.kwad.components.core.proxy.a Tq;

            public AnonymousClass5(com.kwad.components.core.proxy.a aVar2) {
                aVar = aVar2;
            }

            @Override // com.kwad.sdk.f.a
            /* renamed from: c */
            public void accept(k kVar) {
                kVar.e(aVar);
            }
        });
    }

    @Override // com.kwad.components.core.proxy.k
    public final void f(com.kwad.components.core.proxy.a aVar) {
        a(aVar, new com.kwad.sdk.f.a<k>() { // from class: com.kwad.components.core.proxy.launchdialog.a.6
            final /* synthetic */ com.kwad.components.core.proxy.a Tq;

            public AnonymousClass6(com.kwad.components.core.proxy.a aVar2) {
                aVar = aVar2;
            }

            @Override // com.kwad.sdk.f.a
            /* renamed from: c */
            public void accept(k kVar) {
                kVar.f(aVar);
            }
        });
        i(aVar2);
    }

    public final void h(com.kwad.components.core.proxy.a aVar) {
        DetectEventType detectEventType = DetectEventType.USER_CANCEL;
        Lifecycle.Event event = Lifecycle.Event.ON_RESUME;
        f.b bVar = new f.b(event);
        Lifecycle.Event event2 = Lifecycle.Event.ON_PAUSE;
        b bVar2 = new b(detectEventType, aVar, bVar, new f.b(event2), new f.b(event));
        a(bVar2);
        b bVar3 = new b(DetectEventType.USER_CONFIRM, aVar, new f.b(event), new f.b(event2), new f.a(1000L), new f.b(Lifecycle.Event.ON_STOP));
        a(bVar3);
        ArrayList arrayList = new ArrayList();
        arrayList.add(bVar2);
        arrayList.add(bVar3);
        this.To.put(aVar, arrayList);
    }

    public final void i(com.kwad.components.core.proxy.a aVar) {
        List<b> list;
        if (aVar != null && (list = this.To.get(aVar)) != null) {
            Iterator<b> it = list.iterator();
            while (it.hasNext()) {
                b(it.next());
            }
            list.clear();
        }
        this.To.remove(aVar);
    }

    public final com.kwad.components.core.proxy.a ra() {
        return this.Tp;
    }

    public final b a(DetectEventType detectEventType) {
        List<b> list;
        com.kwad.components.core.proxy.a aVar = this.Tp;
        if (aVar == null || (list = this.To.get(aVar)) == null) {
            return null;
        }
        for (b bVar : list) {
            if (bVar.b(detectEventType)) {
                return bVar;
            }
        }
        return null;
    }

    @Override // com.kwad.components.core.proxy.k
    public final void b(com.kwad.components.core.proxy.a aVar) {
        a(aVar, new com.kwad.sdk.f.a<k>() { // from class: com.kwad.components.core.proxy.launchdialog.a.2
            final /* synthetic */ com.kwad.components.core.proxy.a Tq;

            public AnonymousClass2(com.kwad.components.core.proxy.a aVar2) {
                aVar = aVar2;
            }

            @Override // com.kwad.sdk.f.a
            /* renamed from: c */
            public void accept(k kVar) {
                kVar.b(aVar);
            }
        });
    }

    @Override // com.kwad.components.core.proxy.k
    public final void a(com.kwad.components.core.proxy.a aVar) {
        a(aVar, new com.kwad.sdk.f.a<k>() { // from class: com.kwad.components.core.proxy.launchdialog.a.1
            final /* synthetic */ com.kwad.components.core.proxy.a Tq;

            public AnonymousClass1(com.kwad.components.core.proxy.a aVar2) {
                aVar = aVar2;
            }

            @Override // com.kwad.sdk.f.a
            /* renamed from: c */
            public void accept(k kVar) {
                kVar.a(aVar);
            }
        });
    }

    private void a(com.kwad.components.core.proxy.a aVar, com.kwad.sdk.f.a<k> aVar2) {
        for (k kVar : this.Tn) {
            if (kVar instanceof n) {
                n nVar = (n) kVar;
                if (nVar.g(aVar)) {
                    aVar2.accept(nVar);
                }
            } else {
                aVar2.accept(kVar);
            }
        }
    }
}
