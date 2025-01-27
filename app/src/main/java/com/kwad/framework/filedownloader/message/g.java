package com.kwad.framework.filedownloader.message;

import com.kwad.framework.filedownloader.message.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;

/* loaded from: classes3.dex */
public final class g {
    private final e.b akB;
    private final List<a> akD = new ArrayList();

    public class a {
        private final List<Integer> akE = new ArrayList();
        private final Executor akF;

        /* renamed from: com.kwad.framework.filedownloader.message.g$a$1 */
        public class AnonymousClass1 implements Runnable {
            final /* synthetic */ MessageSnapshot akH;

            public AnonymousClass1(MessageSnapshot messageSnapshot) {
                messageSnapshot = messageSnapshot;
            }

            @Override // java.lang.Runnable
            public final void run() {
                g.this.akB.r(messageSnapshot);
                try {
                    a.this.akE.remove(Integer.valueOf(messageSnapshot.getId()));
                } catch (Exception unused) {
                }
            }
        }

        public a(int i10) {
            this.akF = com.kwad.framework.filedownloader.f.b.r(1, "Flow-" + i10);
        }

        public final void bC(int i10) {
            this.akE.add(Integer.valueOf(i10));
        }

        public final void u(MessageSnapshot messageSnapshot) {
            this.akF.execute(new Runnable() { // from class: com.kwad.framework.filedownloader.message.g.a.1
                final /* synthetic */ MessageSnapshot akH;

                public AnonymousClass1(MessageSnapshot messageSnapshot2) {
                    messageSnapshot = messageSnapshot2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    g.this.akB.r(messageSnapshot);
                    try {
                        a.this.akE.remove(Integer.valueOf(messageSnapshot.getId()));
                    } catch (Exception unused) {
                    }
                }
            });
        }
    }

    public g(int i10, e.b bVar) {
        this.akB = bVar;
        for (int i11 = 0; i11 < 5; i11++) {
            this.akD.add(new a(i11));
        }
    }

    public final void u(MessageSnapshot messageSnapshot) {
        a aVar = null;
        try {
            synchronized (this.akD) {
                try {
                    int id2 = messageSnapshot.getId();
                    Iterator<a> it = this.akD.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        a next = it.next();
                        if (next.akE.contains(Integer.valueOf(id2))) {
                            aVar = next;
                            break;
                        }
                    }
                    if (aVar == null) {
                        Iterator<a> it2 = this.akD.iterator();
                        int i10 = 0;
                        while (true) {
                            if (!it2.hasNext()) {
                                break;
                            }
                            a next2 = it2.next();
                            if (next2.akE.size() <= 0) {
                                aVar = next2;
                                break;
                            } else if (i10 == 0 || next2.akE.size() < i10) {
                                i10 = next2.akE.size();
                                aVar = next2;
                            }
                        }
                    }
                    if (aVar != null) {
                        aVar.bC(id2);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        } finally {
            if (aVar != null) {
                aVar.u(messageSnapshot);
            }
        }
    }
}
