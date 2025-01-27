package ak;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import qj.h;

/* loaded from: classes5.dex */
public final class j<T extends qj.h> implements qj.h {

    /* renamed from: b */
    public Set<T> f274b;

    /* renamed from: c */
    public boolean f275c = false;

    private static <T extends qj.h> void e(Collection<T> collection) {
        if (collection == null) {
            return;
        }
        Iterator<T> it = collection.iterator();
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

    public void a(T t10) {
        synchronized (this) {
            try {
                if (!this.f275c) {
                    if (this.f274b == null) {
                        this.f274b = new HashSet(4);
                    }
                    this.f274b.add(t10);
                    t10 = null;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        if (t10 != null) {
            t10.unsubscribe();
        }
    }

    public void b() {
        Set<T> set;
        synchronized (this) {
            if (!this.f275c && (set = this.f274b) != null) {
                this.f274b = null;
                e(set);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void c(wj.b<T> bVar) {
        Set<T> set;
        synchronized (this) {
            if (!this.f275c && (set = this.f274b) != null) {
                for (qj.h hVar : (qj.h[]) set.toArray((Object[]) null)) {
                    bVar.call(hVar);
                }
            }
        }
    }

    public void d(qj.h hVar) {
        Set<T> set;
        synchronized (this) {
            if (!this.f275c && (set = this.f274b) != null) {
                boolean remove = set.remove(hVar);
                if (remove) {
                    hVar.unsubscribe();
                }
            }
        }
    }

    @Override // qj.h
    public synchronized boolean isUnsubscribed() {
        return this.f275c;
    }

    @Override // qj.h
    public void unsubscribe() {
        synchronized (this) {
            try {
                if (this.f275c) {
                    return;
                }
                this.f275c = true;
                Set<T> set = this.f274b;
                this.f274b = null;
                e(set);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
