package androidx.coordinatorlayout.widget;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.collection.SimpleArrayMap;
import androidx.core.util.Pools;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes.dex */
public final class DirectedAcyclicGraph<T> {

    /* renamed from: a */
    private final Pools.Pool<ArrayList<T>> f1368a = new Pools.SimplePool(10);

    /* renamed from: b */
    private final SimpleArrayMap<T, ArrayList<T>> f1369b = new SimpleArrayMap<>();

    /* renamed from: c */
    private final ArrayList<T> f1370c = new ArrayList<>();

    /* renamed from: d */
    private final HashSet<T> f1371d = new HashSet<>();

    private void a(T t, ArrayList<T> arrayList, HashSet<T> hashSet) {
        if (arrayList.contains(t)) {
            return;
        }
        if (hashSet.contains(t)) {
            throw new RuntimeException("This graph contains cyclic dependencies");
        }
        hashSet.add(t);
        ArrayList<T> arrayList2 = this.f1369b.get(t);
        if (arrayList2 != null) {
            int size = arrayList2.size();
            for (int i2 = 0; i2 < size; i2++) {
                a(arrayList2.get(i2), arrayList, hashSet);
            }
        }
        hashSet.remove(t);
        arrayList.add(t);
    }

    @NonNull
    private ArrayList<T> b() {
        ArrayList<T> acquire = this.f1368a.acquire();
        return acquire == null ? new ArrayList<>() : acquire;
    }

    private void c(@NonNull ArrayList<T> arrayList) {
        arrayList.clear();
        this.f1368a.release(arrayList);
    }

    public void addEdge(@NonNull T t, @NonNull T t2) {
        if (!this.f1369b.containsKey(t) || !this.f1369b.containsKey(t2)) {
            throw new IllegalArgumentException("All nodes must be present in the graph before being added as an edge");
        }
        ArrayList<T> arrayList = this.f1369b.get(t);
        if (arrayList == null) {
            arrayList = b();
            this.f1369b.put(t, arrayList);
        }
        arrayList.add(t2);
    }

    public void addNode(@NonNull T t) {
        if (this.f1369b.containsKey(t)) {
            return;
        }
        this.f1369b.put(t, null);
    }

    public void clear() {
        int size = this.f1369b.size();
        for (int i2 = 0; i2 < size; i2++) {
            ArrayList<T> valueAt = this.f1369b.valueAt(i2);
            if (valueAt != null) {
                c(valueAt);
            }
        }
        this.f1369b.clear();
    }

    public boolean contains(@NonNull T t) {
        return this.f1369b.containsKey(t);
    }

    int d() {
        return this.f1369b.size();
    }

    @Nullable
    public List getIncomingEdges(@NonNull T t) {
        return this.f1369b.get(t);
    }

    @Nullable
    public List<T> getOutgoingEdges(@NonNull T t) {
        int size = this.f1369b.size();
        ArrayList arrayList = null;
        for (int i2 = 0; i2 < size; i2++) {
            ArrayList<T> valueAt = this.f1369b.valueAt(i2);
            if (valueAt != null && valueAt.contains(t)) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(this.f1369b.keyAt(i2));
            }
        }
        return arrayList;
    }

    @NonNull
    public ArrayList<T> getSortedList() {
        this.f1370c.clear();
        this.f1371d.clear();
        int size = this.f1369b.size();
        for (int i2 = 0; i2 < size; i2++) {
            a(this.f1369b.keyAt(i2), this.f1370c, this.f1371d);
        }
        return this.f1370c;
    }

    public boolean hasOutgoingEdges(@NonNull T t) {
        int size = this.f1369b.size();
        for (int i2 = 0; i2 < size; i2++) {
            ArrayList<T> valueAt = this.f1369b.valueAt(i2);
            if (valueAt != null && valueAt.contains(t)) {
                return true;
            }
        }
        return false;
    }
}
