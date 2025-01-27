package androidx.arch.core.internal;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class SafeIterableMap<K, V> implements Iterable<Map.Entry<K, V>> {

    /* renamed from: a, reason: collision with root package name */
    Entry<K, V> f1060a;

    /* renamed from: b, reason: collision with root package name */
    private Entry<K, V> f1061b;

    /* renamed from: c, reason: collision with root package name */
    private WeakHashMap<SupportRemove<K, V>, Boolean> f1062c = new WeakHashMap<>();

    /* renamed from: d, reason: collision with root package name */
    private int f1063d = 0;

    static class AscendingIterator<K, V> extends ListIterator<K, V> {
        AscendingIterator(Entry<K, V> entry, Entry<K, V> entry2) {
            super(entry, entry2);
        }

        @Override // androidx.arch.core.internal.SafeIterableMap.ListIterator
        Entry<K, V> a(Entry<K, V> entry) {
            return entry.f1067d;
        }

        @Override // androidx.arch.core.internal.SafeIterableMap.ListIterator
        Entry<K, V> b(Entry<K, V> entry) {
            return entry.f1066c;
        }
    }

    private static class DescendingIterator<K, V> extends ListIterator<K, V> {
        DescendingIterator(Entry<K, V> entry, Entry<K, V> entry2) {
            super(entry, entry2);
        }

        @Override // androidx.arch.core.internal.SafeIterableMap.ListIterator
        Entry<K, V> a(Entry<K, V> entry) {
            return entry.f1066c;
        }

        @Override // androidx.arch.core.internal.SafeIterableMap.ListIterator
        Entry<K, V> b(Entry<K, V> entry) {
            return entry.f1067d;
        }
    }

    static class Entry<K, V> implements Map.Entry<K, V> {

        /* renamed from: a, reason: collision with root package name */
        @NonNull
        final K f1064a;

        /* renamed from: b, reason: collision with root package name */
        @NonNull
        final V f1065b;

        /* renamed from: c, reason: collision with root package name */
        Entry<K, V> f1066c;

        /* renamed from: d, reason: collision with root package name */
        Entry<K, V> f1067d;

        Entry(@NonNull K k, @NonNull V v) {
            this.f1064a = k;
            this.f1065b = v;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Entry)) {
                return false;
            }
            Entry entry = (Entry) obj;
            return this.f1064a.equals(entry.f1064a) && this.f1065b.equals(entry.f1065b);
        }

        @Override // java.util.Map.Entry
        @NonNull
        public K getKey() {
            return this.f1064a;
        }

        @Override // java.util.Map.Entry
        @NonNull
        public V getValue() {
            return this.f1065b;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            return this.f1064a.hashCode() ^ this.f1065b.hashCode();
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            throw new UnsupportedOperationException("An entry modification is not supported");
        }

        public String toString() {
            return this.f1064a + "=" + this.f1065b;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public class IteratorWithAdditions implements Iterator<Map.Entry<K, V>>, SupportRemove<K, V> {

        /* renamed from: a, reason: collision with root package name */
        private Entry<K, V> f1068a;

        /* renamed from: b, reason: collision with root package name */
        private boolean f1069b = true;

        IteratorWithAdditions() {
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f1069b) {
                return SafeIterableMap.this.f1060a != null;
            }
            Entry<K, V> entry = this.f1068a;
            return (entry == null || entry.f1066c == null) ? false : true;
        }

        @Override // androidx.arch.core.internal.SafeIterableMap.SupportRemove
        public void supportRemove(@NonNull Entry<K, V> entry) {
            Entry<K, V> entry2 = this.f1068a;
            if (entry == entry2) {
                Entry<K, V> entry3 = entry2.f1067d;
                this.f1068a = entry3;
                this.f1069b = entry3 == null;
            }
        }

        @Override // java.util.Iterator
        public Map.Entry<K, V> next() {
            if (this.f1069b) {
                this.f1069b = false;
                this.f1068a = SafeIterableMap.this.f1060a;
            } else {
                Entry<K, V> entry = this.f1068a;
                this.f1068a = entry != null ? entry.f1066c : null;
            }
            return this.f1068a;
        }
    }

    private static abstract class ListIterator<K, V> implements Iterator<Map.Entry<K, V>>, SupportRemove<K, V> {

        /* renamed from: a, reason: collision with root package name */
        Entry<K, V> f1071a;

        /* renamed from: b, reason: collision with root package name */
        Entry<K, V> f1072b;

        ListIterator(Entry<K, V> entry, Entry<K, V> entry2) {
            this.f1071a = entry2;
            this.f1072b = entry;
        }

        private Entry<K, V> c() {
            Entry<K, V> entry = this.f1072b;
            Entry<K, V> entry2 = this.f1071a;
            if (entry == entry2 || entry2 == null) {
                return null;
            }
            return b(entry);
        }

        abstract Entry<K, V> a(Entry<K, V> entry);

        abstract Entry<K, V> b(Entry<K, V> entry);

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f1072b != null;
        }

        @Override // androidx.arch.core.internal.SafeIterableMap.SupportRemove
        public void supportRemove(@NonNull Entry<K, V> entry) {
            if (this.f1071a == entry && entry == this.f1072b) {
                this.f1072b = null;
                this.f1071a = null;
            }
            Entry<K, V> entry2 = this.f1071a;
            if (entry2 == entry) {
                this.f1071a = a(entry2);
            }
            if (this.f1072b == entry) {
                this.f1072b = c();
            }
        }

        @Override // java.util.Iterator
        public Map.Entry<K, V> next() {
            Entry<K, V> entry = this.f1072b;
            this.f1072b = c();
            return entry;
        }
    }

    interface SupportRemove<K, V> {
        void supportRemove(@NonNull Entry<K, V> entry);
    }

    protected Entry<K, V> a(K k) {
        Entry<K, V> entry = this.f1060a;
        while (entry != null && !entry.f1064a.equals(k)) {
            entry = entry.f1066c;
        }
        return entry;
    }

    protected Entry<K, V> b(@NonNull K k, @NonNull V v) {
        Entry<K, V> entry = new Entry<>(k, v);
        this.f1063d++;
        Entry<K, V> entry2 = this.f1061b;
        if (entry2 == null) {
            this.f1060a = entry;
            this.f1061b = entry;
            return entry;
        }
        entry2.f1066c = entry;
        entry.f1067d = entry2;
        this.f1061b = entry;
        return entry;
    }

    public Iterator<Map.Entry<K, V>> descendingIterator() {
        DescendingIterator descendingIterator = new DescendingIterator(this.f1061b, this.f1060a);
        this.f1062c.put(descendingIterator, Boolean.FALSE);
        return descendingIterator;
    }

    public Map.Entry<K, V> eldest() {
        return this.f1060a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SafeIterableMap)) {
            return false;
        }
        SafeIterableMap safeIterableMap = (SafeIterableMap) obj;
        if (size() != safeIterableMap.size()) {
            return false;
        }
        Iterator<Map.Entry<K, V>> it = iterator();
        Iterator<Map.Entry<K, V>> it2 = safeIterableMap.iterator();
        while (it.hasNext() && it2.hasNext()) {
            Map.Entry<K, V> next = it.next();
            Map.Entry<K, V> next2 = it2.next();
            if ((next == null && next2 != null) || (next != null && !next.equals(next2))) {
                return false;
            }
        }
        return (it.hasNext() || it2.hasNext()) ? false : true;
    }

    public int hashCode() {
        Iterator<Map.Entry<K, V>> it = iterator();
        int i2 = 0;
        while (it.hasNext()) {
            i2 += it.next().hashCode();
        }
        return i2;
    }

    @Override // java.lang.Iterable
    @NonNull
    public Iterator<Map.Entry<K, V>> iterator() {
        AscendingIterator ascendingIterator = new AscendingIterator(this.f1060a, this.f1061b);
        this.f1062c.put(ascendingIterator, Boolean.FALSE);
        return ascendingIterator;
    }

    public SafeIterableMap<K, V>.IteratorWithAdditions iteratorWithAdditions() {
        SafeIterableMap<K, V>.IteratorWithAdditions iteratorWithAdditions = new IteratorWithAdditions();
        this.f1062c.put(iteratorWithAdditions, Boolean.FALSE);
        return iteratorWithAdditions;
    }

    public Map.Entry<K, V> newest() {
        return this.f1061b;
    }

    public V putIfAbsent(@NonNull K k, @NonNull V v) {
        Entry<K, V> a2 = a(k);
        if (a2 != null) {
            return a2.f1065b;
        }
        b(k, v);
        return null;
    }

    public V remove(@NonNull K k) {
        Entry<K, V> a2 = a(k);
        if (a2 == null) {
            return null;
        }
        this.f1063d--;
        if (!this.f1062c.isEmpty()) {
            Iterator<SupportRemove<K, V>> it = this.f1062c.keySet().iterator();
            while (it.hasNext()) {
                it.next().supportRemove(a2);
            }
        }
        Entry<K, V> entry = a2.f1067d;
        if (entry != null) {
            entry.f1066c = a2.f1066c;
        } else {
            this.f1060a = a2.f1066c;
        }
        Entry<K, V> entry2 = a2.f1066c;
        if (entry2 != null) {
            entry2.f1067d = entry;
        } else {
            this.f1061b = entry;
        }
        a2.f1066c = null;
        a2.f1067d = null;
        return a2.f1065b;
    }

    public int size() {
        return this.f1063d;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Iterator<Map.Entry<K, V>> it = iterator();
        while (it.hasNext()) {
            sb.append(it.next().toString());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
