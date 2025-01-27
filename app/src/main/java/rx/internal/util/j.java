package rx.internal.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import rx.h;

/* loaded from: classes5.dex */
public final class j<T extends rx.h> implements rx.h {

    /* renamed from: a */
    private Set<T> f36812a;

    /* renamed from: b */
    private boolean f36813b = false;

    private static <T extends rx.h> void e(Collection<T> collection) {
        if (collection == null) {
            return;
        }
        ArrayList arrayList = null;
        Iterator<T> it = collection.iterator();
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

    public void a(T t) {
        synchronized (this) {
            if (!this.f36813b) {
                if (this.f36812a == null) {
                    this.f36812a = new HashSet(4);
                }
                this.f36812a.add(t);
                t = null;
            }
        }
        if (t != null) {
            t.unsubscribe();
        }
    }

    public void b() {
        Set<T> set;
        synchronized (this) {
            if (!this.f36813b && (set = this.f36812a) != null) {
                this.f36812a = null;
                e(set);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void c(rx.k.b<T> bVar) {
        Set<T> set;
        synchronized (this) {
            if (!this.f36813b && (set = this.f36812a) != null) {
                for (rx.h hVar : (rx.h[]) set.toArray((Object[]) null)) {
                    bVar.call(hVar);
                }
            }
        }
    }

    public void d(rx.h hVar) {
        Set<T> set;
        synchronized (this) {
            if (!this.f36813b && (set = this.f36812a) != null) {
                boolean remove = set.remove(hVar);
                if (remove) {
                    hVar.unsubscribe();
                }
            }
        }
    }

    @Override // rx.h
    public synchronized boolean isUnsubscribed() {
        return this.f36813b;
    }

    @Override // rx.h
    public void unsubscribe() {
        synchronized (this) {
            if (this.f36813b) {
                return;
            }
            this.f36813b = true;
            Set<T> set = this.f36812a;
            this.f36812a = null;
            e(set);
        }
    }
}
