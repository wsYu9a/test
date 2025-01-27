package ik;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import qj.h;

/* loaded from: classes5.dex */
public final class b implements h {

    /* renamed from: b */
    public Set<h> f27029b;

    /* renamed from: c */
    public volatile boolean f27030c;

    public b() {
    }

    private static void e(Collection<h> collection) {
        if (collection == null) {
            return;
        }
        Iterator<h> it = collection.iterator();
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

    public void a(h hVar) {
        if (hVar.isUnsubscribed()) {
            return;
        }
        if (!this.f27030c) {
            synchronized (this) {
                try {
                    if (!this.f27030c) {
                        if (this.f27029b == null) {
                            this.f27029b = new HashSet(4);
                        }
                        this.f27029b.add(hVar);
                        return;
                    }
                } finally {
                }
            }
        }
        hVar.unsubscribe();
    }

    public void b() {
        Set<h> set;
        if (this.f27030c) {
            return;
        }
        synchronized (this) {
            if (!this.f27030c && (set = this.f27029b) != null) {
                this.f27029b = null;
                e(set);
            }
        }
    }

    public boolean c() {
        Set<h> set;
        boolean z10 = false;
        if (this.f27030c) {
            return false;
        }
        synchronized (this) {
            try {
                if (!this.f27030c && (set = this.f27029b) != null && !set.isEmpty()) {
                    z10 = true;
                }
            } finally {
            }
        }
        return z10;
    }

    public void d(h hVar) {
        Set<h> set;
        if (this.f27030c) {
            return;
        }
        synchronized (this) {
            if (!this.f27030c && (set = this.f27029b) != null) {
                boolean remove = set.remove(hVar);
                if (remove) {
                    hVar.unsubscribe();
                }
            }
        }
    }

    @Override // qj.h
    public boolean isUnsubscribed() {
        return this.f27030c;
    }

    @Override // qj.h
    public void unsubscribe() {
        if (this.f27030c) {
            return;
        }
        synchronized (this) {
            try {
                if (this.f27030c) {
                    return;
                }
                this.f27030c = true;
                Set<h> set = this.f27029b;
                this.f27029b = null;
                e(set);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public b(h... hVarArr) {
        this.f27029b = new HashSet(Arrays.asList(hVarArr));
    }
}
