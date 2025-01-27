package com.kwai.filedownloader.message;

import com.kwai.filedownloader.message.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public final class g {
    private final e.b aIx;
    private final List<a> aIz = new ArrayList();

    public class a {
        private final List<Integer> aIA = new ArrayList();
        private final Executor aIB;

        /* renamed from: com.kwai.filedownloader.message.g$a$1 */
        final class AnonymousClass1 implements Runnable {
            final /* synthetic */ MessageSnapshot aID;

            AnonymousClass1(MessageSnapshot messageSnapshot) {
                messageSnapshot = messageSnapshot;
            }

            @Override // java.lang.Runnable
            public final void run() {
                g.this.aIx.r(messageSnapshot);
                try {
                    a.this.aIA.remove(Integer.valueOf(messageSnapshot.getId()));
                } catch (Exception unused) {
                }
            }
        }

        public a(int i2) {
            this.aIB = com.kwai.filedownloader.e.b.n(1, "Flow-" + i2);
        }

        public final void cZ(int i2) {
            this.aIA.add(Integer.valueOf(i2));
        }

        public final void u(MessageSnapshot messageSnapshot) {
            this.aIB.execute(new Runnable() { // from class: com.kwai.filedownloader.message.g.a.1
                final /* synthetic */ MessageSnapshot aID;

                AnonymousClass1(MessageSnapshot messageSnapshot2) {
                    messageSnapshot = messageSnapshot2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    g.this.aIx.r(messageSnapshot);
                    try {
                        a.this.aIA.remove(Integer.valueOf(messageSnapshot.getId()));
                    } catch (Exception unused) {
                    }
                }
            });
        }
    }

    g(int i2, e.b bVar) {
        this.aIx = bVar;
        for (int i3 = 0; i3 < 5; i3++) {
            this.aIz.add(new a(i3));
        }
    }

    public final void u(MessageSnapshot messageSnapshot) {
        a aVar = null;
        try {
            synchronized (this.aIz) {
                int id = messageSnapshot.getId();
                Iterator<a> it = this.aIz.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    a next = it.next();
                    if (next.aIA.contains(Integer.valueOf(id))) {
                        aVar = next;
                        break;
                    }
                }
                if (aVar == null) {
                    int i2 = 0;
                    Iterator<a> it2 = this.aIz.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            break;
                        }
                        a next2 = it2.next();
                        if (next2.aIA.size() <= 0) {
                            aVar = next2;
                            break;
                        } else if (i2 == 0 || next2.aIA.size() < i2) {
                            i2 = next2.aIA.size();
                            aVar = next2;
                        }
                    }
                }
                if (aVar != null) {
                    aVar.cZ(id);
                }
            }
        } finally {
            if (aVar != null) {
                aVar.u(messageSnapshot);
            }
        }
    }
}
