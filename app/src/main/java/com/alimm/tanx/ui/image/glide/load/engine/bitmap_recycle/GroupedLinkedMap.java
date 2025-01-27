package com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle;

import com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.Poolable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import m5.d;

/* loaded from: classes.dex */
class GroupedLinkedMap<K extends Poolable, V> {
    private final LinkedEntry<K, V> head = new LinkedEntry<>();
    private final Map<K, LinkedEntry<K, V>> keyToEntry = new HashMap();

    public static class LinkedEntry<K, V> {
        private final K key;
        LinkedEntry<K, V> next;
        LinkedEntry<K, V> prev;
        private List<V> values;

        public LinkedEntry() {
            this(null);
        }

        public void add(V v10) {
            if (this.values == null) {
                this.values = new ArrayList();
            }
            this.values.add(v10);
        }

        public V removeLast() {
            int size = size();
            if (size > 0) {
                return this.values.remove(size - 1);
            }
            return null;
        }

        public int size() {
            List<V> list = this.values;
            if (list != null) {
                return list.size();
            }
            return 0;
        }

        public LinkedEntry(K k10) {
            this.prev = this;
            this.next = this;
            this.key = k10;
        }
    }

    private void makeHead(LinkedEntry<K, V> linkedEntry) {
        removeEntry(linkedEntry);
        LinkedEntry<K, V> linkedEntry2 = this.head;
        linkedEntry.prev = linkedEntry2;
        LinkedEntry<K, V> linkedEntry3 = linkedEntry2.next;
        linkedEntry.next = linkedEntry3;
        linkedEntry3.prev = linkedEntry;
        linkedEntry.prev.next = linkedEntry;
    }

    private void makeTail(LinkedEntry<K, V> linkedEntry) {
        removeEntry(linkedEntry);
        LinkedEntry<K, V> linkedEntry2 = this.head;
        linkedEntry.prev = linkedEntry2.prev;
        linkedEntry.next = linkedEntry2;
        linkedEntry2.prev = linkedEntry;
        linkedEntry.prev.next = linkedEntry;
    }

    private static <K, V> void removeEntry(LinkedEntry<K, V> linkedEntry) {
        LinkedEntry<K, V> linkedEntry2 = linkedEntry.prev;
        linkedEntry2.next = linkedEntry.next;
        linkedEntry.next.prev = linkedEntry2;
    }

    private static <K, V> void updateEntry(LinkedEntry<K, V> linkedEntry) {
        linkedEntry.next.prev = linkedEntry;
        linkedEntry.prev.next = linkedEntry;
    }

    public V get(K k10) {
        LinkedEntry<K, V> linkedEntry = this.keyToEntry.get(k10);
        if (linkedEntry == null) {
            linkedEntry = new LinkedEntry<>(k10);
            this.keyToEntry.put(k10, linkedEntry);
        } else {
            k10.offer();
        }
        makeHead(linkedEntry);
        return linkedEntry.removeLast();
    }

    public void put(K k10, V v10) {
        LinkedEntry<K, V> linkedEntry = this.keyToEntry.get(k10);
        if (linkedEntry == null) {
            linkedEntry = new LinkedEntry<>(k10);
            makeTail(linkedEntry);
            this.keyToEntry.put(k10, linkedEntry);
        } else {
            k10.offer();
        }
        linkedEntry.add(v10);
    }

    public V removeLast() {
        for (LinkedEntry linkedEntry = this.head.prev; !linkedEntry.equals(this.head); linkedEntry = linkedEntry.prev) {
            V v10 = (V) linkedEntry.removeLast();
            if (v10 != null) {
                return v10;
            }
            removeEntry(linkedEntry);
            this.keyToEntry.remove(linkedEntry.key);
            ((Poolable) linkedEntry.key).offer();
        }
        return null;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("GroupedLinkedMap( ");
        LinkedEntry linkedEntry = this.head.next;
        boolean z10 = false;
        while (!linkedEntry.equals(this.head)) {
            sb2.append('{');
            sb2.append(linkedEntry.key);
            sb2.append(d.f28378d);
            sb2.append(linkedEntry.size());
            sb2.append("}, ");
            linkedEntry = linkedEntry.next;
            z10 = true;
        }
        if (z10) {
            sb2.delete(sb2.length() - 2, sb2.length());
        }
        sb2.append(" )");
        return sb2.toString();
    }
}
