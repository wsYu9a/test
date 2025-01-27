package com.google.common.collect;

import com.google.common.base.Equivalence;
import com.google.common.collect.MapMaker;
import com.google.common.collect.MapMakerInternalMap.Segment;
import com.google.common.collect.MapMakerInternalMap.i;
import com.google.common.primitives.Ints;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.concurrent.GuardedBy;
import com.google.j2objc.annotations.Weak;
import io.reactivex.internal.disposables.ArrayCompositeDisposable;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.locks.ReentrantLock;
import javax.annotation.CheckForNull;

@a5.c
/* loaded from: classes2.dex */
class MapMakerInternalMap<K, V, E extends i<K, V, E>, S extends Segment<K, V, E, S>> extends AbstractMap<K, V> implements ConcurrentMap<K, V>, Serializable {
    static final long CLEANUP_EXECUTOR_DELAY_SECS = 60;
    static final int CONTAINS_VALUE_RETRIES = 3;
    static final int DRAIN_MAX = 16;
    static final int DRAIN_THRESHOLD = 63;
    static final int MAXIMUM_CAPACITY = 1073741824;
    static final int MAX_SEGMENTS = 65536;
    static final x<Object, Object, e> UNSET_WEAK_VALUE_REFERENCE = new a();
    private static final long serialVersionUID = 5;
    final int concurrencyLevel;
    final transient j<K, V, E, S> entryHelper;

    @CheckForNull
    transient Set<Map.Entry<K, V>> entrySet;
    final Equivalence<Object> keyEquivalence;

    @CheckForNull
    transient Set<K> keySet;
    final transient int segmentMask;
    final transient int segmentShift;
    final transient Segment<K, V, E, S>[] segments;

    @CheckForNull
    transient Collection<V> values;

    public static final class SerializationProxy<K, V> extends AbstractSerializationProxy<K, V> {
        private static final long serialVersionUID = 3;

        public SerializationProxy(Strength strength, Strength strength2, Equivalence<Object> equivalence, Equivalence<Object> equivalence2, int i10, ConcurrentMap<K, V> concurrentMap) {
            super(strength, strength2, equivalence, equivalence2, i10, concurrentMap);
        }

        private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
            objectInputStream.defaultReadObject();
            this.delegate = readMapMaker(objectInputStream).i();
            readEntries(objectInputStream);
        }

        private Object readResolve() {
            return this.delegate;
        }

        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
            objectOutputStream.defaultWriteObject();
            writeMapTo(objectOutputStream);
        }
    }

    public enum Strength {
        STRONG { // from class: com.google.common.collect.MapMakerInternalMap.Strength.1
            @Override // com.google.common.collect.MapMakerInternalMap.Strength
            public Equivalence<Object> defaultEquivalence() {
                return Equivalence.equals();
            }
        },
        WEAK { // from class: com.google.common.collect.MapMakerInternalMap.Strength.2
            @Override // com.google.common.collect.MapMakerInternalMap.Strength
            public Equivalence<Object> defaultEquivalence() {
                return Equivalence.identity();
            }
        };

        /* renamed from: com.google.common.collect.MapMakerInternalMap$Strength$1 */
        public enum AnonymousClass1 extends Strength {
            @Override // com.google.common.collect.MapMakerInternalMap.Strength
            public Equivalence<Object> defaultEquivalence() {
                return Equivalence.equals();
            }
        }

        /* renamed from: com.google.common.collect.MapMakerInternalMap$Strength$2 */
        public enum AnonymousClass2 extends Strength {
            @Override // com.google.common.collect.MapMakerInternalMap.Strength
            public Equivalence<Object> defaultEquivalence() {
                return Equivalence.identity();
            }
        }

        public abstract Equivalence<Object> defaultEquivalence();

        /* synthetic */ Strength(a aVar) {
            this();
        }
    }

    public static final class StrongKeyDummyValueSegment<K> extends Segment<K, MapMaker.Dummy, n<K>, StrongKeyDummyValueSegment<K>> {
        public StrongKeyDummyValueSegment(MapMakerInternalMap<K, MapMaker.Dummy, n<K>, StrongKeyDummyValueSegment<K>> mapMakerInternalMap, int i10, int i11) {
            super(mapMakerInternalMap, i10, i11);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public StrongKeyDummyValueSegment<K> self() {
            return this;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public n<K> castForTesting(i<K, MapMaker.Dummy, ?> iVar) {
            return (n) iVar;
        }
    }

    public static final class StrongKeyStrongValueSegment<K, V> extends Segment<K, V, o<K, V>, StrongKeyStrongValueSegment<K, V>> {
        public StrongKeyStrongValueSegment(MapMakerInternalMap<K, V, o<K, V>, StrongKeyStrongValueSegment<K, V>> mapMakerInternalMap, int i10, int i11) {
            super(mapMakerInternalMap, i10, i11);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public StrongKeyStrongValueSegment<K, V> self() {
            return this;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public o<K, V> castForTesting(i<K, V, ?> iVar) {
            return (o) iVar;
        }
    }

    public static final class StrongKeyWeakValueSegment<K, V> extends Segment<K, V, p<K, V>, StrongKeyWeakValueSegment<K, V>> {
        private final ReferenceQueue<V> queueForValues;

        public StrongKeyWeakValueSegment(MapMakerInternalMap<K, V, p<K, V>, StrongKeyWeakValueSegment<K, V>> mapMakerInternalMap, int i10, int i11) {
            super(mapMakerInternalMap, i10, i11);
            this.queueForValues = new ReferenceQueue<>();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public ReferenceQueue<V> getValueReferenceQueueForTesting() {
            return this.queueForValues;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public x<K, V, p<K, V>> getWeakValueReferenceForTesting(i<K, V, ?> iVar) {
            return castForTesting((i) iVar).getValueReference();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public void maybeClearReferenceQueues() {
            clearReferenceQueue(this.queueForValues);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public void maybeDrainReferenceQueues() {
            drainValueReferenceQueue(this.queueForValues);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public x<K, V, p<K, V>> newWeakValueReferenceForTesting(i<K, V, ?> iVar, V v10) {
            return new y(this.queueForValues, v10, castForTesting((i) iVar));
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public StrongKeyWeakValueSegment<K, V> self() {
            return this;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public void setWeakValueReferenceForTesting(i<K, V, ?> iVar, x<K, V, ? extends i<K, V, ?>> xVar) {
            p<K, V> castForTesting = castForTesting((i) iVar);
            x xVar2 = castForTesting.f9619e;
            castForTesting.f9619e = xVar;
            xVar2.clear();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public p<K, V> castForTesting(i<K, V, ?> iVar) {
            return (p) iVar;
        }
    }

    public static final class WeakKeyDummyValueSegment<K> extends Segment<K, MapMaker.Dummy, t<K>, WeakKeyDummyValueSegment<K>> {
        private final ReferenceQueue<K> queueForKeys;

        public WeakKeyDummyValueSegment(MapMakerInternalMap<K, MapMaker.Dummy, t<K>, WeakKeyDummyValueSegment<K>> mapMakerInternalMap, int i10, int i11) {
            super(mapMakerInternalMap, i10, i11);
            this.queueForKeys = new ReferenceQueue<>();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public ReferenceQueue<K> getKeyReferenceQueueForTesting() {
            return this.queueForKeys;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public void maybeClearReferenceQueues() {
            clearReferenceQueue(this.queueForKeys);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public void maybeDrainReferenceQueues() {
            drainKeyReferenceQueue(this.queueForKeys);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public WeakKeyDummyValueSegment<K> self() {
            return this;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public t<K> castForTesting(i<K, MapMaker.Dummy, ?> iVar) {
            return (t) iVar;
        }
    }

    public static final class WeakKeyStrongValueSegment<K, V> extends Segment<K, V, u<K, V>, WeakKeyStrongValueSegment<K, V>> {
        private final ReferenceQueue<K> queueForKeys;

        public WeakKeyStrongValueSegment(MapMakerInternalMap<K, V, u<K, V>, WeakKeyStrongValueSegment<K, V>> mapMakerInternalMap, int i10, int i11) {
            super(mapMakerInternalMap, i10, i11);
            this.queueForKeys = new ReferenceQueue<>();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public ReferenceQueue<K> getKeyReferenceQueueForTesting() {
            return this.queueForKeys;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public void maybeClearReferenceQueues() {
            clearReferenceQueue(this.queueForKeys);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public void maybeDrainReferenceQueues() {
            drainKeyReferenceQueue(this.queueForKeys);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public WeakKeyStrongValueSegment<K, V> self() {
            return this;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public u<K, V> castForTesting(i<K, V, ?> iVar) {
            return (u) iVar;
        }
    }

    public static final class WeakKeyWeakValueSegment<K, V> extends Segment<K, V, v<K, V>, WeakKeyWeakValueSegment<K, V>> {
        private final ReferenceQueue<K> queueForKeys;
        private final ReferenceQueue<V> queueForValues;

        public WeakKeyWeakValueSegment(MapMakerInternalMap<K, V, v<K, V>, WeakKeyWeakValueSegment<K, V>> mapMakerInternalMap, int i10, int i11) {
            super(mapMakerInternalMap, i10, i11);
            this.queueForKeys = new ReferenceQueue<>();
            this.queueForValues = new ReferenceQueue<>();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public ReferenceQueue<K> getKeyReferenceQueueForTesting() {
            return this.queueForKeys;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public ReferenceQueue<V> getValueReferenceQueueForTesting() {
            return this.queueForValues;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public x<K, V, v<K, V>> getWeakValueReferenceForTesting(i<K, V, ?> iVar) {
            return castForTesting((i) iVar).getValueReference();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public void maybeClearReferenceQueues() {
            clearReferenceQueue(this.queueForKeys);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public void maybeDrainReferenceQueues() {
            drainKeyReferenceQueue(this.queueForKeys);
            drainValueReferenceQueue(this.queueForValues);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public x<K, V, v<K, V>> newWeakValueReferenceForTesting(i<K, V, ?> iVar, V v10) {
            return new y(this.queueForValues, v10, castForTesting((i) iVar));
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public WeakKeyWeakValueSegment<K, V> self() {
            return this;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public void setWeakValueReferenceForTesting(i<K, V, ?> iVar, x<K, V, ? extends i<K, V, ?>> xVar) {
            v<K, V> castForTesting = castForTesting((i) iVar);
            x xVar2 = castForTesting.f9625d;
            castForTesting.f9625d = xVar;
            xVar2.clear();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public v<K, V> castForTesting(i<K, V, ?> iVar) {
            return (v) iVar;
        }
    }

    public class a implements x<Object, Object, e> {
        @Override // com.google.common.collect.MapMakerInternalMap.x
        /* renamed from: c */
        public x<Object, Object, e> b(ReferenceQueue<Object> referenceQueue, e eVar) {
            return this;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.x
        public void clear() {
        }

        @Override // com.google.common.collect.MapMakerInternalMap.x
        /* renamed from: d */
        public e a() {
            return null;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.x
        public Object get() {
            return null;
        }
    }

    public static abstract class b<K, V, E extends i<K, V, E>> implements i<K, V, E> {

        /* renamed from: b */
        public final K f9600b;

        /* renamed from: c */
        public final int f9601c;

        /* renamed from: d */
        @CheckForNull
        public final E f9602d;

        public b(K k10, int i10, @CheckForNull E e10) {
            this.f9600b = k10;
            this.f9601c = i10;
            this.f9602d = e10;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.i
        public int getHash() {
            return this.f9601c;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.i
        public K getKey() {
            return this.f9600b;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.i
        public E getNext() {
            return this.f9602d;
        }
    }

    public static abstract class c<K, V, E extends i<K, V, E>> extends WeakReference<K> implements i<K, V, E> {

        /* renamed from: b */
        public final int f9603b;

        /* renamed from: c */
        @CheckForNull
        public final E f9604c;

        public c(ReferenceQueue<K> referenceQueue, K k10, int i10, @CheckForNull E e10) {
            super(k10, referenceQueue);
            this.f9603b = i10;
            this.f9604c = e10;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.i
        public int getHash() {
            return this.f9603b;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.i
        public K getKey() {
            return get();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.i
        public E getNext() {
            return this.f9604c;
        }
    }

    public static final class d implements Runnable {

        /* renamed from: b */
        public final WeakReference<MapMakerInternalMap<?, ?, ?, ?>> f9605b;

        public d(MapMakerInternalMap<?, ?, ?, ?> mapMakerInternalMap) {
            this.f9605b = new WeakReference<>(mapMakerInternalMap);
        }

        @Override // java.lang.Runnable
        public void run() {
            MapMakerInternalMap<?, ?, ?, ?> mapMakerInternalMap = this.f9605b.get();
            if (mapMakerInternalMap == null) {
                throw new CancellationException();
            }
            for (Segment<?, ?, ?, ?> segment : mapMakerInternalMap.segments) {
                segment.runCleanup();
            }
        }
    }

    public static final class e implements i<Object, Object, e> {
        public e() {
            throw new AssertionError();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.i
        /* renamed from: b */
        public e getNext() {
            throw new AssertionError();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.i
        public int getHash() {
            throw new AssertionError();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.i
        public Object getKey() {
            throw new AssertionError();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.i
        public Object getValue() {
            throw new AssertionError();
        }
    }

    public final class f extends MapMakerInternalMap<K, V, E, S>.h<Map.Entry<K, V>> {
        public f(MapMakerInternalMap mapMakerInternalMap) {
            super();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.h, java.util.Iterator
        /* renamed from: f */
        public Map.Entry<K, V> next() {
            return c();
        }
    }

    public final class g extends m<Map.Entry<K, V>> {
        public g() {
            super(null);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            MapMakerInternalMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            Map.Entry entry;
            Object key;
            Object obj2;
            return (obj instanceof Map.Entry) && (key = (entry = (Map.Entry) obj).getKey()) != null && (obj2 = MapMakerInternalMap.this.get(key)) != null && MapMakerInternalMap.this.valueEquivalence().equivalent(entry.getValue(), obj2);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return MapMakerInternalMap.this.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new f(MapMakerInternalMap.this);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            Map.Entry entry;
            Object key;
            return (obj instanceof Map.Entry) && (key = (entry = (Map.Entry) obj).getKey()) != null && MapMakerInternalMap.this.remove(key, entry.getValue());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return MapMakerInternalMap.this.size();
        }
    }

    public abstract class h<T> implements Iterator<T> {

        /* renamed from: b */
        public int f9607b;

        /* renamed from: c */
        public int f9608c = -1;

        /* renamed from: d */
        @CheckForNull
        public Segment<K, V, E, S> f9609d;

        /* renamed from: e */
        @CheckForNull
        public AtomicReferenceArray<E> f9610e;

        /* renamed from: f */
        @CheckForNull
        public E f9611f;

        /* renamed from: g */
        @CheckForNull
        public MapMakerInternalMap<K, V, E, S>.z f9612g;

        /* renamed from: h */
        @CheckForNull
        public MapMakerInternalMap<K, V, E, S>.z f9613h;

        public h() {
            this.f9607b = MapMakerInternalMap.this.segments.length - 1;
            a();
        }

        public final void a() {
            this.f9612g = null;
            if (d() || e()) {
                return;
            }
            while (true) {
                int i10 = this.f9607b;
                if (i10 < 0) {
                    return;
                }
                Segment<K, V, E, S>[] segmentArr = MapMakerInternalMap.this.segments;
                this.f9607b = i10 - 1;
                Segment<K, V, E, S> segment = segmentArr[i10];
                this.f9609d = segment;
                if (segment.count != 0) {
                    this.f9610e = this.f9609d.table;
                    this.f9608c = r0.length() - 1;
                    if (e()) {
                        return;
                    }
                }
            }
        }

        public boolean b(E e10) {
            try {
                Object key = e10.getKey();
                Object liveValue = MapMakerInternalMap.this.getLiveValue(e10);
                if (liveValue == null) {
                    this.f9609d.postReadCleanup();
                    return false;
                }
                this.f9612g = new z(key, liveValue);
                this.f9609d.postReadCleanup();
                return true;
            } catch (Throwable th2) {
                this.f9609d.postReadCleanup();
                throw th2;
            }
        }

        public MapMakerInternalMap<K, V, E, S>.z c() {
            MapMakerInternalMap<K, V, E, S>.z zVar = this.f9612g;
            if (zVar == null) {
                throw new NoSuchElementException();
            }
            this.f9613h = zVar;
            a();
            return this.f9613h;
        }

        public boolean d() {
            E e10 = this.f9611f;
            if (e10 == null) {
                return false;
            }
            while (true) {
                this.f9611f = (E) e10.getNext();
                E e11 = this.f9611f;
                if (e11 == null) {
                    return false;
                }
                if (b(e11)) {
                    return true;
                }
                e10 = this.f9611f;
            }
        }

        public boolean e() {
            while (true) {
                int i10 = this.f9608c;
                if (i10 < 0) {
                    return false;
                }
                AtomicReferenceArray<E> atomicReferenceArray = this.f9610e;
                this.f9608c = i10 - 1;
                E e10 = atomicReferenceArray.get(i10);
                this.f9611f = e10;
                if (e10 != null && (b(e10) || d())) {
                    return true;
                }
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f9612g != null;
        }

        @Override // java.util.Iterator
        public abstract T next();

        @Override // java.util.Iterator
        public void remove() {
            e5.i.e(this.f9613h != null);
            MapMakerInternalMap.this.remove(this.f9613h.getKey());
            this.f9613h = null;
        }
    }

    public interface i<K, V, E extends i<K, V, E>> {
        int getHash();

        K getKey();

        E getNext();

        V getValue();
    }

    public interface j<K, V, E extends i<K, V, E>, S extends Segment<K, V, E, S>> {
        E a(S s10, E e10, @CheckForNull E e11);

        Strength b();

        void c(S s10, E e10, V v10);

        E d(S s10, K k10, int i10, @CheckForNull E e10);

        Strength e();

        S f(MapMakerInternalMap<K, V, E, S> mapMakerInternalMap, int i10, int i11);
    }

    public final class k extends MapMakerInternalMap<K, V, E, S>.h<K> {
        public k(MapMakerInternalMap mapMakerInternalMap) {
            super();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.h, java.util.Iterator
        public K next() {
            return c().getKey();
        }
    }

    public final class l extends m<K> {
        public l() {
            super(null);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            MapMakerInternalMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return MapMakerInternalMap.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return MapMakerInternalMap.this.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return new k(MapMakerInternalMap.this);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            return MapMakerInternalMap.this.remove(obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return MapMakerInternalMap.this.size();
        }
    }

    public static abstract class m<E> extends AbstractSet<E> {
        public m() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public Object[] toArray() {
            return MapMakerInternalMap.toArrayList(this).toArray();
        }

        public /* synthetic */ m(a aVar) {
            this();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public <T> T[] toArray(T[] tArr) {
            return (T[]) MapMakerInternalMap.toArrayList(this).toArray(tArr);
        }
    }

    public static final class n<K> extends b<K, MapMaker.Dummy, n<K>> implements q<K, MapMaker.Dummy, n<K>> {

        public static final class a<K> implements j<K, MapMaker.Dummy, n<K>, StrongKeyDummyValueSegment<K>> {

            /* renamed from: a */
            public static final a<?> f9616a = new a<>();

            public static <K> a<K> h() {
                return (a<K>) f9616a;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.j
            public Strength b() {
                return Strength.STRONG;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.j
            public Strength e() {
                return Strength.STRONG;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.j
            /* renamed from: g */
            public n<K> a(StrongKeyDummyValueSegment<K> strongKeyDummyValueSegment, n<K> nVar, @CheckForNull n<K> nVar2) {
                return nVar.b(nVar2);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.j
            /* renamed from: i */
            public n<K> d(StrongKeyDummyValueSegment<K> strongKeyDummyValueSegment, K k10, int i10, @CheckForNull n<K> nVar) {
                return new n<>(k10, i10, nVar);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.j
            /* renamed from: j */
            public StrongKeyDummyValueSegment<K> f(MapMakerInternalMap<K, MapMaker.Dummy, n<K>, StrongKeyDummyValueSegment<K>> mapMakerInternalMap, int i10, int i11) {
                return new StrongKeyDummyValueSegment<>(mapMakerInternalMap, i10, i11);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.j
            /* renamed from: k */
            public void c(StrongKeyDummyValueSegment<K> strongKeyDummyValueSegment, n<K> nVar, MapMaker.Dummy dummy) {
            }
        }

        public n(K k10, int i10, @CheckForNull n<K> nVar) {
            super(k10, i10, nVar);
        }

        public n<K> b(n<K> nVar) {
            return new n<>(this.f9600b, this.f9601c, nVar);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.i
        /* renamed from: c */
        public MapMaker.Dummy getValue() {
            return MapMaker.Dummy.VALUE;
        }

        public void d(MapMaker.Dummy dummy) {
        }
    }

    public static final class o<K, V> extends b<K, V, o<K, V>> implements q<K, V, o<K, V>> {

        /* renamed from: e */
        @CheckForNull
        public volatile V f9617e;

        public static final class a<K, V> implements j<K, V, o<K, V>, StrongKeyStrongValueSegment<K, V>> {

            /* renamed from: a */
            public static final a<?, ?> f9618a = new a<>();

            public static <K, V> a<K, V> h() {
                return (a<K, V>) f9618a;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.j
            public Strength b() {
                return Strength.STRONG;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.j
            public Strength e() {
                return Strength.STRONG;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.j
            /* renamed from: g */
            public o<K, V> a(StrongKeyStrongValueSegment<K, V> strongKeyStrongValueSegment, o<K, V> oVar, @CheckForNull o<K, V> oVar2) {
                return oVar.b(oVar2);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.j
            /* renamed from: i */
            public o<K, V> d(StrongKeyStrongValueSegment<K, V> strongKeyStrongValueSegment, K k10, int i10, @CheckForNull o<K, V> oVar) {
                return new o<>(k10, i10, oVar);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.j
            /* renamed from: j */
            public StrongKeyStrongValueSegment<K, V> f(MapMakerInternalMap<K, V, o<K, V>, StrongKeyStrongValueSegment<K, V>> mapMakerInternalMap, int i10, int i11) {
                return new StrongKeyStrongValueSegment<>(mapMakerInternalMap, i10, i11);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.j
            /* renamed from: k */
            public void c(StrongKeyStrongValueSegment<K, V> strongKeyStrongValueSegment, o<K, V> oVar, V v10) {
                oVar.c(v10);
            }
        }

        public o(K k10, int i10, @CheckForNull o<K, V> oVar) {
            super(k10, i10, oVar);
            this.f9617e = null;
        }

        public o<K, V> b(o<K, V> oVar) {
            o<K, V> oVar2 = new o<>(this.f9600b, this.f9601c, oVar);
            oVar2.f9617e = this.f9617e;
            return oVar2;
        }

        public void c(V v10) {
            this.f9617e = v10;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.i
        @CheckForNull
        public V getValue() {
            return this.f9617e;
        }
    }

    public static final class p<K, V> extends b<K, V, p<K, V>> implements w<K, V, p<K, V>> {

        /* renamed from: e */
        public volatile x<K, V, p<K, V>> f9619e;

        public static final class a<K, V> implements j<K, V, p<K, V>, StrongKeyWeakValueSegment<K, V>> {

            /* renamed from: a */
            public static final a<?, ?> f9620a = new a<>();

            public static <K, V> a<K, V> h() {
                return (a<K, V>) f9620a;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.j
            public Strength b() {
                return Strength.WEAK;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.j
            public Strength e() {
                return Strength.STRONG;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.j
            /* renamed from: g */
            public p<K, V> a(StrongKeyWeakValueSegment<K, V> strongKeyWeakValueSegment, p<K, V> pVar, @CheckForNull p<K, V> pVar2) {
                if (Segment.isCollected(pVar)) {
                    return null;
                }
                return pVar.d(((StrongKeyWeakValueSegment) strongKeyWeakValueSegment).queueForValues, pVar2);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.j
            /* renamed from: i */
            public p<K, V> d(StrongKeyWeakValueSegment<K, V> strongKeyWeakValueSegment, K k10, int i10, @CheckForNull p<K, V> pVar) {
                return new p<>(k10, i10, pVar);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.j
            /* renamed from: j */
            public StrongKeyWeakValueSegment<K, V> f(MapMakerInternalMap<K, V, p<K, V>, StrongKeyWeakValueSegment<K, V>> mapMakerInternalMap, int i10, int i11) {
                return new StrongKeyWeakValueSegment<>(mapMakerInternalMap, i10, i11);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.j
            /* renamed from: k */
            public void c(StrongKeyWeakValueSegment<K, V> strongKeyWeakValueSegment, p<K, V> pVar, V v10) {
                pVar.e(v10, ((StrongKeyWeakValueSegment) strongKeyWeakValueSegment).queueForValues);
            }
        }

        public p(K k10, int i10, @CheckForNull p<K, V> pVar) {
            super(k10, i10, pVar);
            this.f9619e = MapMakerInternalMap.unsetWeakValueReference();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.w
        public void a() {
            this.f9619e.clear();
        }

        public p<K, V> d(ReferenceQueue<V> referenceQueue, p<K, V> pVar) {
            p<K, V> pVar2 = new p<>(this.f9600b, this.f9601c, pVar);
            pVar2.f9619e = this.f9619e.b(referenceQueue, pVar2);
            return pVar2;
        }

        public void e(V v10, ReferenceQueue<V> referenceQueue) {
            x<K, V, p<K, V>> xVar = this.f9619e;
            this.f9619e = new y(referenceQueue, v10, this);
            xVar.clear();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.i
        public V getValue() {
            return this.f9619e.get();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.w
        public x<K, V, p<K, V>> getValueReference() {
            return this.f9619e;
        }
    }

    public interface q<K, V, E extends i<K, V, E>> extends i<K, V, E> {
    }

    public final class r extends MapMakerInternalMap<K, V, E, S>.h<V> {
        public r(MapMakerInternalMap mapMakerInternalMap) {
            super();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.h, java.util.Iterator
        public V next() {
            return c().getValue();
        }
    }

    public final class s extends AbstractCollection<V> {
        public s() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            MapMakerInternalMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            return MapMakerInternalMap.this.containsValue(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return MapMakerInternalMap.this.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            return new r(MapMakerInternalMap.this);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return MapMakerInternalMap.this.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public Object[] toArray() {
            return MapMakerInternalMap.toArrayList(this).toArray();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            return (T[]) MapMakerInternalMap.toArrayList(this).toArray(tArr);
        }
    }

    public static final class t<K> extends c<K, MapMaker.Dummy, t<K>> implements q<K, MapMaker.Dummy, t<K>> {

        public static final class a<K> implements j<K, MapMaker.Dummy, t<K>, WeakKeyDummyValueSegment<K>> {

            /* renamed from: a */
            public static final a<?> f9622a = new a<>();

            public static <K> a<K> h() {
                return (a<K>) f9622a;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.j
            public Strength b() {
                return Strength.STRONG;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.j
            public Strength e() {
                return Strength.WEAK;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.j
            /* renamed from: g */
            public t<K> a(WeakKeyDummyValueSegment<K> weakKeyDummyValueSegment, t<K> tVar, @CheckForNull t<K> tVar2) {
                if (tVar.getKey() == null) {
                    return null;
                }
                return tVar.b(((WeakKeyDummyValueSegment) weakKeyDummyValueSegment).queueForKeys, tVar2);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.j
            /* renamed from: i */
            public t<K> d(WeakKeyDummyValueSegment<K> weakKeyDummyValueSegment, K k10, int i10, @CheckForNull t<K> tVar) {
                return new t<>(((WeakKeyDummyValueSegment) weakKeyDummyValueSegment).queueForKeys, k10, i10, tVar);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.j
            /* renamed from: j */
            public WeakKeyDummyValueSegment<K> f(MapMakerInternalMap<K, MapMaker.Dummy, t<K>, WeakKeyDummyValueSegment<K>> mapMakerInternalMap, int i10, int i11) {
                return new WeakKeyDummyValueSegment<>(mapMakerInternalMap, i10, i11);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.j
            /* renamed from: k */
            public void c(WeakKeyDummyValueSegment<K> weakKeyDummyValueSegment, t<K> tVar, MapMaker.Dummy dummy) {
            }
        }

        public t(ReferenceQueue<K> referenceQueue, K k10, int i10, @CheckForNull t<K> tVar) {
            super(referenceQueue, k10, i10, tVar);
        }

        public t<K> b(ReferenceQueue<K> referenceQueue, t<K> tVar) {
            return new t<>(referenceQueue, getKey(), this.f9603b, tVar);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.i
        /* renamed from: c */
        public MapMaker.Dummy getValue() {
            return MapMaker.Dummy.VALUE;
        }

        public void d(MapMaker.Dummy dummy) {
        }
    }

    public static final class u<K, V> extends c<K, V, u<K, V>> implements q<K, V, u<K, V>> {

        /* renamed from: d */
        @CheckForNull
        public volatile V f9623d;

        public static final class a<K, V> implements j<K, V, u<K, V>, WeakKeyStrongValueSegment<K, V>> {

            /* renamed from: a */
            public static final a<?, ?> f9624a = new a<>();

            public static <K, V> a<K, V> h() {
                return (a<K, V>) f9624a;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.j
            public Strength b() {
                return Strength.STRONG;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.j
            public Strength e() {
                return Strength.WEAK;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.j
            /* renamed from: g */
            public u<K, V> a(WeakKeyStrongValueSegment<K, V> weakKeyStrongValueSegment, u<K, V> uVar, @CheckForNull u<K, V> uVar2) {
                if (uVar.getKey() == null) {
                    return null;
                }
                return uVar.b(((WeakKeyStrongValueSegment) weakKeyStrongValueSegment).queueForKeys, uVar2);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.j
            /* renamed from: i */
            public u<K, V> d(WeakKeyStrongValueSegment<K, V> weakKeyStrongValueSegment, K k10, int i10, @CheckForNull u<K, V> uVar) {
                return new u<>(((WeakKeyStrongValueSegment) weakKeyStrongValueSegment).queueForKeys, k10, i10, uVar);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.j
            /* renamed from: j */
            public WeakKeyStrongValueSegment<K, V> f(MapMakerInternalMap<K, V, u<K, V>, WeakKeyStrongValueSegment<K, V>> mapMakerInternalMap, int i10, int i11) {
                return new WeakKeyStrongValueSegment<>(mapMakerInternalMap, i10, i11);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.j
            /* renamed from: k */
            public void c(WeakKeyStrongValueSegment<K, V> weakKeyStrongValueSegment, u<K, V> uVar, V v10) {
                uVar.c(v10);
            }
        }

        public u(ReferenceQueue<K> referenceQueue, K k10, int i10, @CheckForNull u<K, V> uVar) {
            super(referenceQueue, k10, i10, uVar);
            this.f9623d = null;
        }

        public u<K, V> b(ReferenceQueue<K> referenceQueue, u<K, V> uVar) {
            u<K, V> uVar2 = new u<>(referenceQueue, getKey(), this.f9603b, uVar);
            uVar2.c(this.f9623d);
            return uVar2;
        }

        public void c(V v10) {
            this.f9623d = v10;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.i
        @CheckForNull
        public V getValue() {
            return this.f9623d;
        }
    }

    public static final class v<K, V> extends c<K, V, v<K, V>> implements w<K, V, v<K, V>> {

        /* renamed from: d */
        public volatile x<K, V, v<K, V>> f9625d;

        public static final class a<K, V> implements j<K, V, v<K, V>, WeakKeyWeakValueSegment<K, V>> {

            /* renamed from: a */
            public static final a<?, ?> f9626a = new a<>();

            public static <K, V> a<K, V> h() {
                return (a<K, V>) f9626a;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.j
            public Strength b() {
                return Strength.WEAK;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.j
            public Strength e() {
                return Strength.WEAK;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.j
            /* renamed from: g */
            public v<K, V> a(WeakKeyWeakValueSegment<K, V> weakKeyWeakValueSegment, v<K, V> vVar, @CheckForNull v<K, V> vVar2) {
                if (vVar.getKey() == null || Segment.isCollected(vVar)) {
                    return null;
                }
                return vVar.d(((WeakKeyWeakValueSegment) weakKeyWeakValueSegment).queueForKeys, ((WeakKeyWeakValueSegment) weakKeyWeakValueSegment).queueForValues, vVar2);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.j
            /* renamed from: i */
            public v<K, V> d(WeakKeyWeakValueSegment<K, V> weakKeyWeakValueSegment, K k10, int i10, @CheckForNull v<K, V> vVar) {
                return new v<>(((WeakKeyWeakValueSegment) weakKeyWeakValueSegment).queueForKeys, k10, i10, vVar);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.j
            /* renamed from: j */
            public WeakKeyWeakValueSegment<K, V> f(MapMakerInternalMap<K, V, v<K, V>, WeakKeyWeakValueSegment<K, V>> mapMakerInternalMap, int i10, int i11) {
                return new WeakKeyWeakValueSegment<>(mapMakerInternalMap, i10, i11);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.j
            /* renamed from: k */
            public void c(WeakKeyWeakValueSegment<K, V> weakKeyWeakValueSegment, v<K, V> vVar, V v10) {
                vVar.e(v10, ((WeakKeyWeakValueSegment) weakKeyWeakValueSegment).queueForValues);
            }
        }

        public v(ReferenceQueue<K> referenceQueue, K k10, int i10, @CheckForNull v<K, V> vVar) {
            super(referenceQueue, k10, i10, vVar);
            this.f9625d = MapMakerInternalMap.unsetWeakValueReference();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.w
        public void a() {
            this.f9625d.clear();
        }

        public v<K, V> d(ReferenceQueue<K> referenceQueue, ReferenceQueue<V> referenceQueue2, v<K, V> vVar) {
            v<K, V> vVar2 = new v<>(referenceQueue, getKey(), this.f9603b, vVar);
            vVar2.f9625d = this.f9625d.b(referenceQueue2, vVar2);
            return vVar2;
        }

        public void e(V v10, ReferenceQueue<V> referenceQueue) {
            x<K, V, v<K, V>> xVar = this.f9625d;
            this.f9625d = new y(referenceQueue, v10, this);
            xVar.clear();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.i
        public V getValue() {
            return this.f9625d.get();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.w
        public x<K, V, v<K, V>> getValueReference() {
            return this.f9625d;
        }
    }

    public interface w<K, V, E extends i<K, V, E>> extends i<K, V, E> {
        void a();

        x<K, V, E> getValueReference();
    }

    public interface x<K, V, E extends i<K, V, E>> {
        E a();

        x<K, V, E> b(ReferenceQueue<V> referenceQueue, E e10);

        void clear();

        @CheckForNull
        V get();
    }

    public static final class y<K, V, E extends i<K, V, E>> extends WeakReference<V> implements x<K, V, E> {

        /* renamed from: b */
        @Weak
        public final E f9627b;

        public y(ReferenceQueue<V> referenceQueue, V v10, E e10) {
            super(v10, referenceQueue);
            this.f9627b = e10;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.x
        public E a() {
            return this.f9627b;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.x
        public x<K, V, E> b(ReferenceQueue<V> referenceQueue, E e10) {
            return new y(referenceQueue, get(), e10);
        }
    }

    public final class z extends e5.b<K, V> {

        /* renamed from: b */
        public final K f9628b;

        /* renamed from: c */
        public V f9629c;

        public z(K k10, V v10) {
            this.f9628b = k10;
            this.f9629c = v10;
        }

        @Override // e5.b, java.util.Map.Entry
        public boolean equals(@CheckForNull Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return this.f9628b.equals(entry.getKey()) && this.f9629c.equals(entry.getValue());
        }

        @Override // e5.b, java.util.Map.Entry
        public K getKey() {
            return this.f9628b;
        }

        @Override // e5.b, java.util.Map.Entry
        public V getValue() {
            return this.f9629c;
        }

        @Override // e5.b, java.util.Map.Entry
        public int hashCode() {
            return this.f9628b.hashCode() ^ this.f9629c.hashCode();
        }

        @Override // e5.b, java.util.Map.Entry
        public V setValue(V v10) {
            V v11 = (V) MapMakerInternalMap.this.put(this.f9628b, v10);
            this.f9629c = v10;
            return v11;
        }
    }

    private MapMakerInternalMap(MapMaker mapMaker, j<K, V, E, S> jVar) {
        this.concurrencyLevel = Math.min(mapMaker.b(), 65536);
        this.keyEquivalence = mapMaker.d();
        this.entryHelper = jVar;
        int min = Math.min(mapMaker.c(), 1073741824);
        int i10 = 0;
        int i11 = 1;
        int i12 = 1;
        int i13 = 0;
        while (i12 < this.concurrencyLevel) {
            i13++;
            i12 <<= 1;
        }
        this.segmentShift = 32 - i13;
        this.segmentMask = i12 - 1;
        this.segments = newSegmentArray(i12);
        int i14 = min / i12;
        while (i11 < (i12 * i14 < min ? i14 + 1 : i14)) {
            i11 <<= 1;
        }
        while (true) {
            Segment<K, V, E, S>[] segmentArr = this.segments;
            if (i10 >= segmentArr.length) {
                return;
            }
            segmentArr[i10] = createSegment(i11, -1);
            i10++;
        }
    }

    public static <K, V> MapMakerInternalMap<K, V, ? extends i<K, V, ?>, ?> create(MapMaker mapMaker) {
        Strength e10 = mapMaker.e();
        Strength strength = Strength.STRONG;
        if (e10 == strength && mapMaker.f() == strength) {
            return new MapMakerInternalMap<>(mapMaker, o.a.h());
        }
        if (mapMaker.e() == strength && mapMaker.f() == Strength.WEAK) {
            return new MapMakerInternalMap<>(mapMaker, p.a.h());
        }
        Strength e11 = mapMaker.e();
        Strength strength2 = Strength.WEAK;
        if (e11 == strength2 && mapMaker.f() == strength) {
            return new MapMakerInternalMap<>(mapMaker, u.a.h());
        }
        if (mapMaker.e() == strength2 && mapMaker.f() == strength2) {
            return new MapMakerInternalMap<>(mapMaker, v.a.h());
        }
        throw new AssertionError();
    }

    public static <K> MapMakerInternalMap<K, MapMaker.Dummy, ? extends i<K, MapMaker.Dummy, ?>, ?> createWithDummyValues(MapMaker mapMaker) {
        Strength e10 = mapMaker.e();
        Strength strength = Strength.STRONG;
        if (e10 == strength && mapMaker.f() == strength) {
            return new MapMakerInternalMap<>(mapMaker, n.a.h());
        }
        Strength e11 = mapMaker.e();
        Strength strength2 = Strength.WEAK;
        if (e11 == strength2 && mapMaker.f() == strength) {
            return new MapMakerInternalMap<>(mapMaker, t.a.h());
        }
        if (mapMaker.f() == strength2) {
            throw new IllegalArgumentException("Map cannot have both weak and dummy values");
        }
        throw new AssertionError();
    }

    public static int rehash(int i10) {
        int i11 = i10 + ((i10 << 15) ^ (-12931));
        int i12 = i11 ^ (i11 >>> 10);
        int i13 = i12 + (i12 << 3);
        int i14 = i13 ^ (i13 >>> 6);
        int i15 = i14 + (i14 << 2) + (i14 << 14);
        return i15 ^ (i15 >>> 16);
    }

    public static <E> ArrayList<E> toArrayList(Collection<E> collection) {
        ArrayList<E> arrayList = new ArrayList<>(collection.size());
        Iterators.a(arrayList, collection.iterator());
        return arrayList;
    }

    public static <K, V, E extends i<K, V, E>> x<K, V, E> unsetWeakValueReference() {
        return (x<K, V, E>) UNSET_WEAK_VALUE_REFERENCE;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        for (Segment<K, V, E, S> segment : this.segments) {
            segment.clear();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(@CheckForNull Object obj) {
        if (obj == null) {
            return false;
        }
        int hash = hash(obj);
        return segmentFor(hash).containsKey(obj, hash);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsValue(@CheckForNull Object obj) {
        if (obj == null) {
            return false;
        }
        Segment<K, V, E, S>[] segmentArr = this.segments;
        long j10 = -1;
        int i10 = 0;
        while (i10 < 3) {
            long j11 = 0;
            for (StrongKeyDummyValueSegment strongKeyDummyValueSegment : segmentArr) {
                int i11 = strongKeyDummyValueSegment.count;
                AtomicReferenceArray<E> atomicReferenceArray = strongKeyDummyValueSegment.table;
                for (int i12 = 0; i12 < atomicReferenceArray.length(); i12++) {
                    for (E e10 = atomicReferenceArray.get(i12); e10 != null; e10 = e10.getNext()) {
                        Object liveValue = strongKeyDummyValueSegment.getLiveValue(e10);
                        if (liveValue != null && valueEquivalence().equivalent(obj, liveValue)) {
                            return true;
                        }
                    }
                }
                j11 += strongKeyDummyValueSegment.modCount;
            }
            if (j11 == j10) {
                return false;
            }
            i10++;
            j10 = j11;
        }
        return false;
    }

    @a5.d
    public E copyEntry(E e10, E e11) {
        return segmentFor(e10.getHash()).copyEntry(e10, e11);
    }

    public Segment<K, V, E, S> createSegment(int i10, int i11) {
        return this.entryHelper.f(this, i10, i11);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = this.entrySet;
        if (set != null) {
            return set;
        }
        g gVar = new g();
        this.entrySet = gVar;
        return gVar;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(@CheckForNull Object obj) {
        if (obj == null) {
            return null;
        }
        int hash = hash(obj);
        return segmentFor(hash).get(obj, hash);
    }

    public E getEntry(@CheckForNull Object obj) {
        if (obj == null) {
            return null;
        }
        int hash = hash(obj);
        return segmentFor(hash).getEntry(obj, hash);
    }

    public V getLiveValue(E e10) {
        if (e10.getKey() == null) {
            return null;
        }
        return (V) e10.getValue();
    }

    public int hash(Object obj) {
        return rehash(this.keyEquivalence.hash(obj));
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean isEmpty() {
        Segment<K, V, E, S>[] segmentArr = this.segments;
        long j10 = 0;
        for (int i10 = 0; i10 < segmentArr.length; i10++) {
            if (segmentArr[i10].count != 0) {
                return false;
            }
            j10 += segmentArr[i10].modCount;
        }
        if (j10 == 0) {
            return true;
        }
        for (int i11 = 0; i11 < segmentArr.length; i11++) {
            if (segmentArr[i11].count != 0) {
                return false;
            }
            j10 -= segmentArr[i11].modCount;
        }
        return j10 == 0;
    }

    @a5.d
    public boolean isLiveForTesting(i<K, V, ?> iVar) {
        return segmentFor(iVar.getHash()).getLiveValueForTesting(iVar) != null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        Set<K> set = this.keySet;
        if (set != null) {
            return set;
        }
        l lVar = new l();
        this.keySet = lVar;
        return lVar;
    }

    @a5.d
    public Strength keyStrength() {
        return this.entryHelper.e();
    }

    public final Segment<K, V, E, S>[] newSegmentArray(int i10) {
        return new Segment[i10];
    }

    @Override // java.util.AbstractMap, java.util.Map
    @CanIgnoreReturnValue
    public V put(K k10, V v10) {
        b5.u.E(k10);
        b5.u.E(v10);
        int hash = hash(k10);
        return segmentFor(hash).put(k10, hash, v10, false);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    @CanIgnoreReturnValue
    public V putIfAbsent(K k10, V v10) {
        b5.u.E(k10);
        b5.u.E(v10);
        int hash = hash(k10);
        return segmentFor(hash).put(k10, hash, v10, true);
    }

    public void reclaimKey(E e10) {
        int hash = e10.getHash();
        segmentFor(hash).reclaimKey(e10, hash);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void reclaimValue(x<K, V, E> xVar) {
        E a10 = xVar.a();
        int hash = a10.getHash();
        segmentFor(hash).reclaimValue(a10.getKey(), hash, xVar);
    }

    @Override // java.util.AbstractMap, java.util.Map
    @CanIgnoreReturnValue
    public V remove(@CheckForNull Object obj) {
        if (obj == null) {
            return null;
        }
        int hash = hash(obj);
        return segmentFor(hash).remove(obj, hash);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    @CanIgnoreReturnValue
    public boolean replace(K k10, @CheckForNull V v10, V v11) {
        b5.u.E(k10);
        b5.u.E(v11);
        if (v10 == null) {
            return false;
        }
        int hash = hash(k10);
        return segmentFor(hash).replace(k10, hash, v10, v11);
    }

    public Segment<K, V, E, S> segmentFor(int i10) {
        return this.segments[(i10 >>> this.segmentShift) & this.segmentMask];
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        long j10 = 0;
        for (int i10 = 0; i10 < this.segments.length; i10++) {
            j10 += r0[i10].count;
        }
        return Ints.x(j10);
    }

    @a5.d
    public Equivalence<Object> valueEquivalence() {
        return this.entryHelper.b().defaultEquivalence();
    }

    @a5.d
    public Strength valueStrength() {
        return this.entryHelper.b();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Collection<V> values() {
        Collection<V> collection = this.values;
        if (collection != null) {
            return collection;
        }
        s sVar = new s();
        this.values = sVar;
        return sVar;
    }

    public Object writeReplace() {
        return new SerializationProxy(this.entryHelper.e(), this.entryHelper.b(), this.keyEquivalence, this.entryHelper.b().defaultEquivalence(), this.concurrencyLevel, this);
    }

    public static abstract class AbstractSerializationProxy<K, V> extends e5.z<K, V> implements Serializable {
        private static final long serialVersionUID = 3;
        final int concurrencyLevel;
        transient ConcurrentMap<K, V> delegate;
        final Equivalence<Object> keyEquivalence;
        final Strength keyStrength;
        final Equivalence<Object> valueEquivalence;
        final Strength valueStrength;

        public AbstractSerializationProxy(Strength strength, Strength strength2, Equivalence<Object> equivalence, Equivalence<Object> equivalence2, int i10, ConcurrentMap<K, V> concurrentMap) {
            this.keyStrength = strength;
            this.valueStrength = strength2;
            this.keyEquivalence = equivalence;
            this.valueEquivalence = equivalence2;
            this.concurrencyLevel = i10;
            this.delegate = concurrentMap;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void readEntries(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
            while (true) {
                Object readObject = objectInputStream.readObject();
                if (readObject == null) {
                    return;
                }
                this.delegate.put(readObject, objectInputStream.readObject());
            }
        }

        public MapMaker readMapMaker(ObjectInputStream objectInputStream) throws IOException {
            return new MapMaker().g(objectInputStream.readInt()).j(this.keyStrength).k(this.valueStrength).h(this.keyEquivalence).a(this.concurrencyLevel);
        }

        public void writeMapTo(ObjectOutputStream objectOutputStream) throws IOException {
            objectOutputStream.writeInt(this.delegate.size());
            for (Map.Entry<K, V> entry : this.delegate.entrySet()) {
                objectOutputStream.writeObject(entry.getKey());
                objectOutputStream.writeObject(entry.getValue());
            }
            objectOutputStream.writeObject(null);
        }

        @Override // e5.z, com.google.common.collect.j, e5.l0
        public ConcurrentMap<K, V> delegate() {
            return this.delegate;
        }
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    @CanIgnoreReturnValue
    public boolean remove(@CheckForNull Object obj, @CheckForNull Object obj2) {
        if (obj == null || obj2 == null) {
            return false;
        }
        int hash = hash(obj);
        return segmentFor(hash).remove(obj, hash, obj2);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    @CanIgnoreReturnValue
    public V replace(K k10, V v10) {
        b5.u.E(k10);
        b5.u.E(v10);
        int hash = hash(k10);
        return segmentFor(hash).replace(k10, hash, v10);
    }

    public static abstract class Segment<K, V, E extends i<K, V, E>, S extends Segment<K, V, E, S>> extends ReentrantLock {
        volatile int count;

        @Weak
        final MapMakerInternalMap<K, V, E, S> map;
        final int maxSegmentSize;
        int modCount;
        final AtomicInteger readCount = new AtomicInteger();

        @CheckForNull
        volatile AtomicReferenceArray<E> table;
        int threshold;

        public Segment(MapMakerInternalMap<K, V, E, S> mapMakerInternalMap, int i10, int i11) {
            this.map = mapMakerInternalMap;
            this.maxSegmentSize = i11;
            initTable(newEntryArray(i10));
        }

        public static <K, V, E extends i<K, V, E>> boolean isCollected(E e10) {
            return e10.getValue() == null;
        }

        public abstract E castForTesting(i<K, V, ?> iVar);

        public void clear() {
            if (this.count != 0) {
                lock();
                try {
                    AtomicReferenceArray<E> atomicReferenceArray = this.table;
                    for (int i10 = 0; i10 < atomicReferenceArray.length(); i10++) {
                        atomicReferenceArray.set(i10, null);
                    }
                    maybeClearReferenceQueues();
                    this.readCount.set(0);
                    this.modCount++;
                    this.count = 0;
                    unlock();
                } catch (Throwable th2) {
                    unlock();
                    throw th2;
                }
            }
        }

        public <T> void clearReferenceQueue(ReferenceQueue<T> referenceQueue) {
            while (referenceQueue.poll() != null) {
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @CanIgnoreReturnValue
        public boolean clearValueForTesting(K k10, int i10, x<K, V, ? extends i<K, V, ?>> xVar) {
            lock();
            try {
                AtomicReferenceArray<E> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i10;
                i iVar = (i) atomicReferenceArray.get(length);
                for (i iVar2 = iVar; iVar2 != null; iVar2 = iVar2.getNext()) {
                    Object key = iVar2.getKey();
                    if (iVar2.getHash() == i10 && key != null && this.map.keyEquivalence.equivalent(k10, key)) {
                        if (((w) iVar2).getValueReference() != xVar) {
                            return false;
                        }
                        atomicReferenceArray.set(length, removeFromChain(iVar, iVar2));
                        return true;
                    }
                }
                return false;
            } finally {
                unlock();
            }
        }

        public boolean containsKey(Object obj, int i10) {
            try {
                boolean z10 = false;
                if (this.count == 0) {
                    return false;
                }
                E liveEntry = getLiveEntry(obj, i10);
                if (liveEntry != null) {
                    if (liveEntry.getValue() != null) {
                        z10 = true;
                    }
                }
                return z10;
            } finally {
                postReadCleanup();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @a5.d
        public boolean containsValue(Object obj) {
            try {
                if (this.count != 0) {
                    AtomicReferenceArray<E> atomicReferenceArray = this.table;
                    int length = atomicReferenceArray.length();
                    for (int i10 = 0; i10 < length; i10++) {
                        for (E e10 = atomicReferenceArray.get(i10); e10 != null; e10 = e10.getNext()) {
                            Object liveValue = getLiveValue(e10);
                            if (liveValue != null && this.map.valueEquivalence().equivalent(obj, liveValue)) {
                                postReadCleanup();
                                return true;
                            }
                        }
                    }
                }
                return false;
            } finally {
                postReadCleanup();
            }
        }

        public E copyEntry(E e10, E e11) {
            return this.map.entryHelper.a(self(), e10, e11);
        }

        public E copyForTesting(i<K, V, ?> iVar, @CheckForNull i<K, V, ?> iVar2) {
            return this.map.entryHelper.a(self(), castForTesting(iVar), castForTesting(iVar2));
        }

        /* JADX WARN: Multi-variable type inference failed */
        @GuardedBy("this")
        public void drainKeyReferenceQueue(ReferenceQueue<K> referenceQueue) {
            int i10 = 0;
            do {
                Reference<? extends K> poll = referenceQueue.poll();
                if (poll == null) {
                    return;
                }
                this.map.reclaimKey((i) poll);
                i10++;
            } while (i10 != 16);
        }

        @GuardedBy("this")
        public void drainValueReferenceQueue(ReferenceQueue<V> referenceQueue) {
            int i10 = 0;
            do {
                Reference<? extends V> poll = referenceQueue.poll();
                if (poll == null) {
                    return;
                }
                this.map.reclaimValue((x) poll);
                i10++;
            } while (i10 != 16);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @GuardedBy("this")
        public void expand() {
            AtomicReferenceArray<E> atomicReferenceArray = this.table;
            int length = atomicReferenceArray.length();
            if (length >= 1073741824) {
                return;
            }
            int i10 = this.count;
            ArrayCompositeDisposable arrayCompositeDisposable = (AtomicReferenceArray<E>) newEntryArray(length << 1);
            this.threshold = (arrayCompositeDisposable.length() * 3) / 4;
            int length2 = arrayCompositeDisposable.length() - 1;
            for (int i11 = 0; i11 < length; i11++) {
                E e10 = atomicReferenceArray.get(i11);
                if (e10 != null) {
                    i next = e10.getNext();
                    int hash = e10.getHash() & length2;
                    if (next == null) {
                        arrayCompositeDisposable.set(hash, e10);
                    } else {
                        i iVar = e10;
                        while (next != null) {
                            int hash2 = next.getHash() & length2;
                            if (hash2 != hash) {
                                iVar = next;
                                hash = hash2;
                            }
                            next = next.getNext();
                        }
                        arrayCompositeDisposable.set(hash, iVar);
                        while (e10 != iVar) {
                            int hash3 = e10.getHash() & length2;
                            i copyEntry = copyEntry(e10, (i) arrayCompositeDisposable.get(hash3));
                            if (copyEntry != null) {
                                arrayCompositeDisposable.set(hash3, copyEntry);
                            } else {
                                i10--;
                            }
                            e10 = e10.getNext();
                        }
                    }
                }
            }
            this.table = arrayCompositeDisposable;
            this.count = i10;
        }

        public V get(Object obj, int i10) {
            try {
                E liveEntry = getLiveEntry(obj, i10);
                if (liveEntry == null) {
                    postReadCleanup();
                    return null;
                }
                V v10 = (V) liveEntry.getValue();
                if (v10 == null) {
                    tryDrainReferenceQueues();
                }
                return v10;
            } finally {
                postReadCleanup();
            }
        }

        public E getEntry(Object obj, int i10) {
            if (this.count == 0) {
                return null;
            }
            for (E first = getFirst(i10); first != null; first = (E) first.getNext()) {
                if (first.getHash() == i10) {
                    Object key = first.getKey();
                    if (key == null) {
                        tryDrainReferenceQueues();
                    } else if (this.map.keyEquivalence.equivalent(obj, key)) {
                        return first;
                    }
                }
            }
            return null;
        }

        public E getFirst(int i10) {
            return this.table.get(i10 & (r0.length() - 1));
        }

        public ReferenceQueue<K> getKeyReferenceQueueForTesting() {
            throw new AssertionError();
        }

        public E getLiveEntry(Object obj, int i10) {
            return getEntry(obj, i10);
        }

        @CheckForNull
        public V getLiveValue(E e10) {
            if (e10.getKey() == null) {
                tryDrainReferenceQueues();
                return null;
            }
            V v10 = (V) e10.getValue();
            if (v10 != null) {
                return v10;
            }
            tryDrainReferenceQueues();
            return null;
        }

        @CheckForNull
        public V getLiveValueForTesting(i<K, V, ?> iVar) {
            return getLiveValue(castForTesting(iVar));
        }

        public ReferenceQueue<V> getValueReferenceQueueForTesting() {
            throw new AssertionError();
        }

        public x<K, V, E> getWeakValueReferenceForTesting(i<K, V, ?> iVar) {
            throw new AssertionError();
        }

        public void initTable(AtomicReferenceArray<E> atomicReferenceArray) {
            int length = (atomicReferenceArray.length() * 3) / 4;
            this.threshold = length;
            if (length == this.maxSegmentSize) {
                this.threshold = length + 1;
            }
            this.table = atomicReferenceArray;
        }

        public void maybeClearReferenceQueues() {
        }

        @GuardedBy("this")
        public void maybeDrainReferenceQueues() {
        }

        public AtomicReferenceArray<E> newEntryArray(int i10) {
            return new AtomicReferenceArray<>(i10);
        }

        public E newEntryForTesting(K k10, int i10, @CheckForNull i<K, V, ?> iVar) {
            return this.map.entryHelper.d(self(), k10, i10, castForTesting(iVar));
        }

        public x<K, V, E> newWeakValueReferenceForTesting(i<K, V, ?> iVar, V v10) {
            throw new AssertionError();
        }

        public void postReadCleanup() {
            if ((this.readCount.incrementAndGet() & 63) == 0) {
                runCleanup();
            }
        }

        @GuardedBy("this")
        public void preWriteCleanup() {
            runLockedCleanup();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public V put(K k10, int i10, V v10, boolean z10) {
            lock();
            try {
                preWriteCleanup();
                int i11 = this.count + 1;
                if (i11 > this.threshold) {
                    expand();
                    i11 = this.count + 1;
                }
                AtomicReferenceArray<E> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i10;
                i iVar = (i) atomicReferenceArray.get(length);
                for (i iVar2 = iVar; iVar2 != null; iVar2 = iVar2.getNext()) {
                    Object key = iVar2.getKey();
                    if (iVar2.getHash() == i10 && key != null && this.map.keyEquivalence.equivalent(k10, key)) {
                        V v11 = (V) iVar2.getValue();
                        if (v11 == null) {
                            this.modCount++;
                            setValue(iVar2, v10);
                            this.count = this.count;
                            unlock();
                            return null;
                        }
                        if (z10) {
                            unlock();
                            return v11;
                        }
                        this.modCount++;
                        setValue(iVar2, v10);
                        unlock();
                        return v11;
                    }
                }
                this.modCount++;
                i d10 = this.map.entryHelper.d(self(), k10, i10, iVar);
                setValue(d10, v10);
                atomicReferenceArray.set(length, d10);
                this.count = i11;
                unlock();
                return null;
            } catch (Throwable th2) {
                unlock();
                throw th2;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @CanIgnoreReturnValue
        public boolean reclaimKey(E e10, int i10) {
            lock();
            try {
                AtomicReferenceArray<E> atomicReferenceArray = this.table;
                int length = i10 & (atomicReferenceArray.length() - 1);
                i iVar = (i) atomicReferenceArray.get(length);
                for (i iVar2 = iVar; iVar2 != null; iVar2 = iVar2.getNext()) {
                    if (iVar2 == e10) {
                        this.modCount++;
                        i removeFromChain = removeFromChain(iVar, iVar2);
                        int i11 = this.count - 1;
                        atomicReferenceArray.set(length, removeFromChain);
                        this.count = i11;
                        return true;
                    }
                }
                unlock();
                return false;
            } finally {
                unlock();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @CanIgnoreReturnValue
        public boolean reclaimValue(K k10, int i10, x<K, V, E> xVar) {
            lock();
            try {
                AtomicReferenceArray<E> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i10;
                i iVar = (i) atomicReferenceArray.get(length);
                for (i iVar2 = iVar; iVar2 != null; iVar2 = iVar2.getNext()) {
                    Object key = iVar2.getKey();
                    if (iVar2.getHash() == i10 && key != null && this.map.keyEquivalence.equivalent(k10, key)) {
                        if (((w) iVar2).getValueReference() != xVar) {
                            return false;
                        }
                        this.modCount++;
                        i removeFromChain = removeFromChain(iVar, iVar2);
                        int i11 = this.count - 1;
                        atomicReferenceArray.set(length, removeFromChain);
                        this.count = i11;
                        return true;
                    }
                }
                return false;
            } finally {
                unlock();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @CanIgnoreReturnValue
        public V remove(Object obj, int i10) {
            lock();
            try {
                preWriteCleanup();
                AtomicReferenceArray<E> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i10;
                i iVar = (i) atomicReferenceArray.get(length);
                for (i iVar2 = iVar; iVar2 != null; iVar2 = iVar2.getNext()) {
                    Object key = iVar2.getKey();
                    if (iVar2.getHash() == i10 && key != null && this.map.keyEquivalence.equivalent(obj, key)) {
                        V v10 = (V) iVar2.getValue();
                        if (v10 == null && !isCollected(iVar2)) {
                            return null;
                        }
                        this.modCount++;
                        i removeFromChain = removeFromChain(iVar, iVar2);
                        int i11 = this.count - 1;
                        atomicReferenceArray.set(length, removeFromChain);
                        this.count = i11;
                        return v10;
                    }
                }
                return null;
            } finally {
                unlock();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @GuardedBy("this")
        public boolean removeEntryForTesting(E e10) {
            int hash = e10.getHash();
            AtomicReferenceArray<E> atomicReferenceArray = this.table;
            int length = hash & (atomicReferenceArray.length() - 1);
            i iVar = (i) atomicReferenceArray.get(length);
            for (i iVar2 = iVar; iVar2 != null; iVar2 = iVar2.getNext()) {
                if (iVar2 == e10) {
                    this.modCount++;
                    i removeFromChain = removeFromChain(iVar, iVar2);
                    int i10 = this.count - 1;
                    atomicReferenceArray.set(length, removeFromChain);
                    this.count = i10;
                    return true;
                }
            }
            return false;
        }

        @GuardedBy("this")
        public E removeFromChain(E e10, E e11) {
            int i10 = this.count;
            E e12 = (E) e11.getNext();
            while (e10 != e11) {
                E copyEntry = copyEntry(e10, e12);
                if (copyEntry != null) {
                    e12 = copyEntry;
                } else {
                    i10--;
                }
                e10 = (E) e10.getNext();
            }
            this.count = i10;
            return e12;
        }

        public E removeFromChainForTesting(i<K, V, ?> iVar, i<K, V, ?> iVar2) {
            return removeFromChain(castForTesting(iVar), castForTesting(iVar2));
        }

        @CanIgnoreReturnValue
        public boolean removeTableEntryForTesting(i<K, V, ?> iVar) {
            return removeEntryForTesting(castForTesting(iVar));
        }

        /* JADX WARN: Multi-variable type inference failed */
        public boolean replace(K k10, int i10, V v10, V v11) {
            lock();
            try {
                preWriteCleanup();
                AtomicReferenceArray<E> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i10;
                i iVar = (i) atomicReferenceArray.get(length);
                for (i iVar2 = iVar; iVar2 != null; iVar2 = iVar2.getNext()) {
                    Object key = iVar2.getKey();
                    if (iVar2.getHash() == i10 && key != null && this.map.keyEquivalence.equivalent(k10, key)) {
                        Object value = iVar2.getValue();
                        if (value != null) {
                            if (!this.map.valueEquivalence().equivalent(v10, value)) {
                                return false;
                            }
                            this.modCount++;
                            setValue(iVar2, v11);
                            return true;
                        }
                        if (isCollected(iVar2)) {
                            this.modCount++;
                            i removeFromChain = removeFromChain(iVar, iVar2);
                            int i11 = this.count - 1;
                            atomicReferenceArray.set(length, removeFromChain);
                            this.count = i11;
                        }
                        return false;
                    }
                }
                return false;
            } finally {
                unlock();
            }
        }

        public void runCleanup() {
            runLockedCleanup();
        }

        public void runLockedCleanup() {
            if (tryLock()) {
                try {
                    maybeDrainReferenceQueues();
                    this.readCount.set(0);
                } finally {
                    unlock();
                }
            }
        }

        public abstract S self();

        public void setTableEntryForTesting(int i10, i<K, V, ?> iVar) {
            this.table.set(i10, castForTesting(iVar));
        }

        public void setValue(E e10, V v10) {
            this.map.entryHelper.c(self(), e10, v10);
        }

        public void setValueForTesting(i<K, V, ?> iVar, V v10) {
            this.map.entryHelper.c(self(), castForTesting(iVar), v10);
        }

        public void setWeakValueReferenceForTesting(i<K, V, ?> iVar, x<K, V, ? extends i<K, V, ?>> xVar) {
            throw new AssertionError();
        }

        public void tryDrainReferenceQueues() {
            if (tryLock()) {
                try {
                    maybeDrainReferenceQueues();
                } finally {
                    unlock();
                }
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:13:0x003d, code lost:
        
            if (r8.map.valueEquivalence().equivalent(r11, r4.getValue()) == false) goto L86;
         */
        /* JADX WARN: Code restructure failed: missing block: B:14:0x003f, code lost:
        
            r5 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:15:0x0047, code lost:
        
            r8.modCount++;
            r9 = removeFromChain(r3, r4);
            r10 = r8.count - 1;
            r0.set(r1, r9);
            r8.count = r10;
         */
        /* JADX WARN: Code restructure failed: missing block: B:17:0x005b, code lost:
        
            return r5;
         */
        /* JADX WARN: Code restructure failed: missing block: B:21:0x0045, code lost:
        
            if (isCollected(r4) == false) goto L93;
         */
        /* JADX WARN: Code restructure failed: missing block: B:23:0x0061, code lost:
        
            return false;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public boolean remove(java.lang.Object r9, int r10, java.lang.Object r11) {
            /*
                r8 = this;
                r8.lock()
                r8.preWriteCleanup()     // Catch: java.lang.Throwable -> L5c
                java.util.concurrent.atomic.AtomicReferenceArray<E extends com.google.common.collect.MapMakerInternalMap$i<K, V, E>> r0 = r8.table     // Catch: java.lang.Throwable -> L5c
                int r1 = r0.length()     // Catch: java.lang.Throwable -> L5c
                r2 = 1
                int r1 = r1 - r2
                r1 = r1 & r10
                java.lang.Object r3 = r0.get(r1)     // Catch: java.lang.Throwable -> L5c
                com.google.common.collect.MapMakerInternalMap$i r3 = (com.google.common.collect.MapMakerInternalMap.i) r3     // Catch: java.lang.Throwable -> L5c
                r4 = r3
            L16:
                r5 = 0
                if (r4 == 0) goto L67
                java.lang.Object r6 = r4.getKey()     // Catch: java.lang.Throwable -> L5c
                int r7 = r4.getHash()     // Catch: java.lang.Throwable -> L5c
                if (r7 != r10) goto L62
                if (r6 == 0) goto L62
                com.google.common.collect.MapMakerInternalMap<K, V, E extends com.google.common.collect.MapMakerInternalMap$i<K, V, E>, S extends com.google.common.collect.MapMakerInternalMap$Segment<K, V, E, S>> r7 = r8.map     // Catch: java.lang.Throwable -> L5c
                com.google.common.base.Equivalence<java.lang.Object> r7 = r7.keyEquivalence     // Catch: java.lang.Throwable -> L5c
                boolean r6 = r7.equivalent(r9, r6)     // Catch: java.lang.Throwable -> L5c
                if (r6 == 0) goto L62
                java.lang.Object r9 = r4.getValue()     // Catch: java.lang.Throwable -> L5c
                com.google.common.collect.MapMakerInternalMap<K, V, E extends com.google.common.collect.MapMakerInternalMap$i<K, V, E>, S extends com.google.common.collect.MapMakerInternalMap$Segment<K, V, E, S>> r10 = r8.map     // Catch: java.lang.Throwable -> L5c
                com.google.common.base.Equivalence r10 = r10.valueEquivalence()     // Catch: java.lang.Throwable -> L5c
                boolean r9 = r10.equivalent(r11, r9)     // Catch: java.lang.Throwable -> L5c
                if (r9 == 0) goto L41
                r5 = 1
                goto L47
            L41:
                boolean r9 = isCollected(r4)     // Catch: java.lang.Throwable -> L5c
                if (r9 == 0) goto L5e
            L47:
                int r9 = r8.modCount     // Catch: java.lang.Throwable -> L5c
                int r9 = r9 + r2
                r8.modCount = r9     // Catch: java.lang.Throwable -> L5c
                com.google.common.collect.MapMakerInternalMap$i r9 = r8.removeFromChain(r3, r4)     // Catch: java.lang.Throwable -> L5c
                int r10 = r8.count     // Catch: java.lang.Throwable -> L5c
                int r10 = r10 - r2
                r0.set(r1, r9)     // Catch: java.lang.Throwable -> L5c
                r8.count = r10     // Catch: java.lang.Throwable -> L5c
                r8.unlock()
                return r5
            L5c:
                r9 = move-exception
                goto L6b
            L5e:
                r8.unlock()
                return r5
            L62:
                com.google.common.collect.MapMakerInternalMap$i r4 = r4.getNext()     // Catch: java.lang.Throwable -> L5c
                goto L16
            L67:
                r8.unlock()
                return r5
            L6b:
                r8.unlock()
                throw r9
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.MapMakerInternalMap.Segment.remove(java.lang.Object, int, java.lang.Object):boolean");
        }

        /* JADX WARN: Multi-variable type inference failed */
        public V replace(K k10, int i10, V v10) {
            lock();
            try {
                preWriteCleanup();
                AtomicReferenceArray<E> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i10;
                i iVar = (i) atomicReferenceArray.get(length);
                for (i iVar2 = iVar; iVar2 != null; iVar2 = iVar2.getNext()) {
                    Object key = iVar2.getKey();
                    if (iVar2.getHash() == i10 && key != null && this.map.keyEquivalence.equivalent(k10, key)) {
                        V v11 = (V) iVar2.getValue();
                        if (v11 == null) {
                            if (isCollected(iVar2)) {
                                this.modCount++;
                                i removeFromChain = removeFromChain(iVar, iVar2);
                                int i11 = this.count - 1;
                                atomicReferenceArray.set(length, removeFromChain);
                                this.count = i11;
                            }
                            return null;
                        }
                        this.modCount++;
                        setValue(iVar2, v10);
                        return v11;
                    }
                }
                return null;
            } finally {
                unlock();
            }
        }
    }
}
