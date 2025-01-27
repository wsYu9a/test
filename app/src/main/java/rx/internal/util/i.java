package rx.internal.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

/* loaded from: classes5.dex */
public final class i implements rx.h {

    /* renamed from: a */
    private LinkedList<rx.h> f36810a;

    /* renamed from: b */
    private volatile boolean f36811b;

    public i() {
    }

    private static void e(Collection<rx.h> collection) {
        if (collection == null) {
            return;
        }
        ArrayList arrayList = null;
        Iterator<rx.h> it = collection.iterator();
        while (it.hasNext()) {
            try {
                it.next().unsubscribe();
            } catch (Throwable th) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(th);
            }
        }
        rx.exceptions.a.d(arrayList);
    }

    public void a(rx.h hVar) {
        if (hVar.isUnsubscribed()) {
            return;
        }
        if (!this.f36811b) {
            synchronized (this) {
                if (!this.f36811b) {
                    LinkedList<rx.h> linkedList = this.f36810a;
                    if (linkedList == null) {
                        linkedList = new LinkedList<>();
                        this.f36810a = linkedList;
                    }
                    linkedList.add(hVar);
                    return;
                }
            }
        }
        hVar.unsubscribe();
    }

    public void b() {
        LinkedList<rx.h> linkedList;
        if (this.f36811b) {
            return;
        }
        synchronized (this) {
            linkedList = this.f36810a;
            this.f36810a = null;
        }
        e(linkedList);
    }

    public boolean c() {
        LinkedList<rx.h> linkedList;
        boolean z = false;
        if (this.f36811b) {
            return false;
        }
        synchronized (this) {
            if (!this.f36811b && (linkedList = this.f36810a) != null && !linkedList.isEmpty()) {
                z = true;
            }
        }
        return z;
    }

    public void d(rx.h hVar) {
        if (this.f36811b) {
            return;
        }
        synchronized (this) {
            LinkedList<rx.h> linkedList = this.f36810a;
            if (!this.f36811b && linkedList != null) {
                boolean remove = linkedList.remove(hVar);
                if (remove) {
                    hVar.unsubscribe();
                }
            }
        }
    }

    @Override // rx.h
    public boolean isUnsubscribed() {
        return this.f36811b;
    }

    @Override // rx.h
    public void unsubscribe() {
        if (this.f36811b) {
            return;
        }
        synchronized (this) {
            if (this.f36811b) {
                return;
            }
            this.f36811b = true;
            LinkedList<rx.h> linkedList = this.f36810a;
            this.f36810a = null;
            e(linkedList);
        }
    }

    public i(rx.h... hVarArr) {
        this.f36810a = new LinkedList<>(Arrays.asList(hVarArr));
    }

    public i(rx.h hVar) {
        LinkedList<rx.h> linkedList = new LinkedList<>();
        this.f36810a = linkedList;
        linkedList.add(hVar);
    }
}
