package rx.p;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import rx.h;

/* loaded from: classes5.dex */
public final class b implements h {

    /* renamed from: a */
    private Set<h> f37100a;

    /* renamed from: b */
    private volatile boolean f37101b;

    public b() {
    }

    private static void e(Collection<h> collection) {
        if (collection == null) {
            return;
        }
        ArrayList arrayList = null;
        Iterator<h> it = collection.iterator();
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

    public void a(h hVar) {
        if (hVar.isUnsubscribed()) {
            return;
        }
        if (!this.f37101b) {
            synchronized (this) {
                if (!this.f37101b) {
                    if (this.f37100a == null) {
                        this.f37100a = new HashSet(4);
                    }
                    this.f37100a.add(hVar);
                    return;
                }
            }
        }
        hVar.unsubscribe();
    }

    public void b() {
        Set<h> set;
        if (this.f37101b) {
            return;
        }
        synchronized (this) {
            if (!this.f37101b && (set = this.f37100a) != null) {
                this.f37100a = null;
                e(set);
            }
        }
    }

    public boolean c() {
        Set<h> set;
        boolean z = false;
        if (this.f37101b) {
            return false;
        }
        synchronized (this) {
            if (!this.f37101b && (set = this.f37100a) != null && !set.isEmpty()) {
                z = true;
            }
        }
        return z;
    }

    public void d(h hVar) {
        Set<h> set;
        if (this.f37101b) {
            return;
        }
        synchronized (this) {
            if (!this.f37101b && (set = this.f37100a) != null) {
                boolean remove = set.remove(hVar);
                if (remove) {
                    hVar.unsubscribe();
                }
            }
        }
    }

    @Override // rx.h
    public boolean isUnsubscribed() {
        return this.f37101b;
    }

    @Override // rx.h
    public void unsubscribe() {
        if (this.f37101b) {
            return;
        }
        synchronized (this) {
            if (this.f37101b) {
                return;
            }
            this.f37101b = true;
            Set<h> set = this.f37100a;
            this.f37100a = null;
            e(set);
        }
    }

    public b(h... hVarArr) {
        this.f37100a = new HashSet(Arrays.asList(hVarArr));
    }
}
