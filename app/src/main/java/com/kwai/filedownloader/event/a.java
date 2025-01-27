package com.kwai.filedownloader.event;

import com.kwai.filedownloader.e.d;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public class a {
    private final Executor aIg = com.kwai.filedownloader.e.b.n(10, "EventPool");
    private final HashMap<String, LinkedList<c>> aIh = new HashMap<>();

    /* renamed from: com.kwai.filedownloader.event.a$1 */
    final class AnonymousClass1 implements Runnable {
        final /* synthetic */ b aIi;

        AnonymousClass1(b bVar) {
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

    private static void a(LinkedList<c> linkedList, b bVar) {
        for (Object obj : linkedList.toArray()) {
            if (obj != null) {
                ((c) obj).a(bVar);
            }
        }
        Runnable runnable = bVar.aIm;
        if (runnable != null) {
            runnable.run();
        }
    }

    public final boolean a(String str, c cVar) {
        boolean add;
        if (d.aJq) {
            d.i(this, "setListener %s", str);
        }
        if (cVar == null) {
            throw new IllegalArgumentException("listener must not be null!");
        }
        LinkedList<c> linkedList = this.aIh.get(str);
        if (linkedList == null) {
            synchronized (str.intern()) {
                linkedList = this.aIh.get(str);
                if (linkedList == null) {
                    HashMap<String, LinkedList<c>> hashMap = this.aIh;
                    LinkedList<c> linkedList2 = new LinkedList<>();
                    hashMap.put(str, linkedList2);
                    linkedList = linkedList2;
                }
            }
        }
        synchronized (str.intern()) {
            add = linkedList.add(cVar);
        }
        return add;
    }

    public final boolean b(b bVar) {
        if (d.aJq) {
            d.i(this, "publish %s", bVar.getId());
        }
        if (bVar == null) {
            throw new IllegalArgumentException("event must not be null!");
        }
        String id = bVar.getId();
        LinkedList<c> linkedList = this.aIh.get(id);
        if (linkedList == null) {
            synchronized (id.intern()) {
                linkedList = this.aIh.get(id);
                if (linkedList == null) {
                    if (d.aJq) {
                        d.g(this, "No listener for this event %s", id);
                    }
                    return false;
                }
            }
        }
        a(linkedList, bVar);
        return true;
    }

    public final void c(b bVar) {
        if (d.aJq) {
            d.i(this, "asyncPublishInNewThread %s", bVar.getId());
        }
        this.aIg.execute(new Runnable() { // from class: com.kwai.filedownloader.event.a.1
            final /* synthetic */ b aIi;

            AnonymousClass1(b bVar2) {
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
}
