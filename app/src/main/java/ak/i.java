package ak;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

/* loaded from: classes5.dex */
public final class i implements qj.h {

    /* renamed from: b */
    public LinkedList<qj.h> f272b;

    /* renamed from: c */
    public volatile boolean f273c;

    public i() {
    }

    public static void e(Collection<qj.h> collection) {
        if (collection == null) {
            return;
        }
        Iterator<qj.h> it = collection.iterator();
        ArrayList arrayList = null;
        while (it.hasNext()) {
            try {
                it.next().unsubscribe();
            } catch (Throwable th2) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(th2);
            }
        }
        vj.a.d(arrayList);
    }

    public void a(qj.h hVar) {
        if (hVar.isUnsubscribed()) {
            return;
        }
        if (!this.f273c) {
            synchronized (this) {
                try {
                    if (!this.f273c) {
                        LinkedList<qj.h> linkedList = this.f272b;
                        if (linkedList == null) {
                            linkedList = new LinkedList<>();
                            this.f272b = linkedList;
                        }
                        linkedList.add(hVar);
                        return;
                    }
                } finally {
                }
            }
        }
        hVar.unsubscribe();
    }

    public void b() {
        LinkedList<qj.h> linkedList;
        if (this.f273c) {
            return;
        }
        synchronized (this) {
            linkedList = this.f272b;
            this.f272b = null;
        }
        e(linkedList);
    }

    public boolean c() {
        LinkedList<qj.h> linkedList;
        boolean z10 = false;
        if (this.f273c) {
            return false;
        }
        synchronized (this) {
            try {
                if (!this.f273c && (linkedList = this.f272b) != null && !linkedList.isEmpty()) {
                    z10 = true;
                }
            } finally {
            }
        }
        return z10;
    }

    public void d(qj.h hVar) {
        if (this.f273c) {
            return;
        }
        synchronized (this) {
            LinkedList<qj.h> linkedList = this.f272b;
            if (!this.f273c && linkedList != null) {
                boolean remove = linkedList.remove(hVar);
                if (remove) {
                    hVar.unsubscribe();
                }
            }
        }
    }

    @Override // qj.h
    public boolean isUnsubscribed() {
        return this.f273c;
    }

    @Override // qj.h
    public void unsubscribe() {
        if (this.f273c) {
            return;
        }
        synchronized (this) {
            try {
                if (this.f273c) {
                    return;
                }
                this.f273c = true;
                LinkedList<qj.h> linkedList = this.f272b;
                this.f272b = null;
                e(linkedList);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public i(qj.h... hVarArr) {
        this.f272b = new LinkedList<>(Arrays.asList(hVarArr));
    }

    public i(qj.h hVar) {
        LinkedList<qj.h> linkedList = new LinkedList<>();
        this.f272b = linkedList;
        linkedList.add(hVar);
    }
}
