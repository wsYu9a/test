package com.kwad.framework.filedownloader.event;

import com.kwad.framework.filedownloader.f.d;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.concurrent.Executor;

/* loaded from: classes3.dex */
public class a {
    private final Executor akk = com.kwad.framework.filedownloader.f.b.r(10, "EventPool");
    private final HashMap<String, LinkedList<c>> akl = new HashMap<>();

    /* renamed from: com.kwad.framework.filedownloader.event.a$1 */
    public class AnonymousClass1 implements Runnable {
        final /* synthetic */ b akm;

        public AnonymousClass1(b bVar) {
            bVar = bVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                a.this.b(bVar);
            } catch (Exception unused) {
            }
        }
    }

    public final boolean a(String str, c cVar) {
        boolean add;
        if (d.alt) {
            d.e(this, "setListener %s", str);
        }
        if (cVar == null) {
            throw new IllegalArgumentException("listener must not be null!");
        }
        LinkedList<c> linkedList = this.akl.get(str);
        if (linkedList == null) {
            synchronized (str.intern()) {
                try {
                    linkedList = this.akl.get(str);
                    if (linkedList == null) {
                        HashMap<String, LinkedList<c>> hashMap = this.akl;
                        LinkedList<c> linkedList2 = new LinkedList<>();
                        hashMap.put(str, linkedList2);
                        linkedList = linkedList2;
                    }
                } finally {
                }
            }
        }
        synchronized (str.intern()) {
            add = linkedList.add(cVar);
        }
        return add;
    }

    public final boolean b(b bVar) {
        if (d.alt) {
            d.e(this, "publish %s", bVar.getId());
        }
        if (bVar == null) {
            throw new IllegalArgumentException("event must not be null!");
        }
        String id2 = bVar.getId();
        LinkedList<c> linkedList = this.akl.get(id2);
        if (linkedList == null) {
            synchronized (id2.intern()) {
                try {
                    linkedList = this.akl.get(id2);
                    if (linkedList == null) {
                        if (d.alt) {
                            d.c(this, "No listener for this event %s", id2);
                        }
                        return false;
                    }
                } finally {
                }
            }
        }
        a(linkedList, bVar);
        return true;
    }

    public final void c(b bVar) {
        if (d.alt) {
            d.e(this, "asyncPublishInNewThread %s", bVar.getId());
        }
        this.akk.execute(new Runnable() { // from class: com.kwad.framework.filedownloader.event.a.1
            final /* synthetic */ b akm;

            public AnonymousClass1(b bVar2) {
                bVar = bVar2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                try {
                    a.this.b(bVar);
                } catch (Exception unused) {
                }
            }
        });
    }

    private static void a(LinkedList<c> linkedList, b bVar) {
        for (Object obj : linkedList.toArray()) {
            if (obj != null) {
                ((c) obj).a(bVar);
            }
        }
        Runnable runnable = bVar.akq;
        if (runnable != null) {
            runnable.run();
        }
    }
}
