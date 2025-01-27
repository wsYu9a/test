package com.google.common.collect;

import com.google.common.primitives.Ints;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import e5.b1;
import e5.d1;
import e5.s0;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;
import javax.annotation.CheckForNull;

@e5.m
@a5.c
/* loaded from: classes2.dex */
class CompactHashSet<E> extends AbstractSet<E> implements Serializable {

    @a5.d
    static final double HASH_FLOODING_FPP = 0.001d;
    private static final int MAX_HASH_BUCKET_LENGTH = 9;

    @CheckForNull
    @a5.d
    transient Object[] elements;

    @CheckForNull
    private transient int[] entries;
    private transient int metadata;
    private transient int size;

    @CheckForNull
    private transient Object table;

    public class a implements Iterator<E> {

        /* renamed from: b */
        public int f9404b;

        /* renamed from: c */
        public int f9405c;

        /* renamed from: d */
        public int f9406d = -1;

        public a() {
            this.f9404b = CompactHashSet.this.metadata;
            this.f9405c = CompactHashSet.this.firstEntryIndex();
        }

        public final void a() {
            if (CompactHashSet.this.metadata != this.f9404b) {
                throw new ConcurrentModificationException();
            }
        }

        public void b() {
            this.f9404b += 32;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f9405c >= 0;
        }

        @Override // java.util.Iterator
        @d1
        public E next() {
            a();
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            int i10 = this.f9405c;
            this.f9406d = i10;
            E e10 = (E) CompactHashSet.this.element(i10);
            this.f9405c = CompactHashSet.this.getSuccessor(this.f9405c);
            return e10;
        }

        @Override // java.util.Iterator
        public void remove() {
            a();
            e5.i.e(this.f9406d >= 0);
            b();
            CompactHashSet compactHashSet = CompactHashSet.this;
            compactHashSet.remove(compactHashSet.element(this.f9406d));
            this.f9405c = CompactHashSet.this.adjustAfterRemove(this.f9405c, this.f9406d);
            this.f9406d = -1;
        }
    }

    public CompactHashSet() {
        init(3);
    }

    public static <E> CompactHashSet<E> create() {
        return new CompactHashSet<>();
    }

    private Set<E> createHashFloodingResistantDelegate(int i10) {
        return new LinkedHashSet(i10, 1.0f);
    }

    public static <E> CompactHashSet<E> createWithExpectedSize(int i10) {
        return new CompactHashSet<>(i10);
    }

    public E element(int i10) {
        return (E) requireElements()[i10];
    }

    private int entry(int i10) {
        return requireEntries()[i10];
    }

    private int hashTableMask() {
        return (1 << (this.metadata & 31)) - 1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        int readInt = objectInputStream.readInt();
        if (readInt < 0) {
            StringBuilder sb2 = new StringBuilder(25);
            sb2.append("Invalid size: ");
            sb2.append(readInt);
            throw new InvalidObjectException(sb2.toString());
        }
        init(readInt);
        for (int i10 = 0; i10 < readInt; i10++) {
            add(objectInputStream.readObject());
        }
    }

    private Object[] requireElements() {
        Object[] objArr = this.elements;
        Objects.requireNonNull(objArr);
        return objArr;
    }

    private int[] requireEntries() {
        int[] iArr = this.entries;
        Objects.requireNonNull(iArr);
        return iArr;
    }

    private Object requireTable() {
        Object obj = this.table;
        Objects.requireNonNull(obj);
        return obj;
    }

    private void resizeMeMaybe(int i10) {
        int min;
        int length = requireEntries().length;
        if (i10 <= length || (min = Math.min(1073741823, (Math.max(1, length >>> 1) + length) | 1)) == length) {
            return;
        }
        resizeEntries(min);
    }

    @CanIgnoreReturnValue
    private int resizeTable(int i10, int i11, int i12, int i13) {
        Object a10 = e5.j.a(i11);
        int i14 = i11 - 1;
        if (i13 != 0) {
            e5.j.i(a10, i12 & i14, i13 + 1);
        }
        Object requireTable = requireTable();
        int[] requireEntries = requireEntries();
        for (int i15 = 0; i15 <= i10; i15++) {
            int h10 = e5.j.h(requireTable, i15);
            while (h10 != 0) {
                int i16 = h10 - 1;
                int i17 = requireEntries[i16];
                int b10 = e5.j.b(i17, i10) | i15;
                int i18 = b10 & i14;
                int h11 = e5.j.h(a10, i18);
                e5.j.i(a10, i18, h10);
                requireEntries[i16] = e5.j.d(b10, h11, i14);
                h10 = e5.j.c(i17, i10);
            }
        }
        this.table = a10;
        setHashTableMask(i14);
        return i14;
    }

    private void setElement(int i10, E e10) {
        requireElements()[i10] = e10;
    }

    private void setEntry(int i10, int i11) {
        requireEntries()[i10] = i11;
    }

    private void setHashTableMask(int i10) {
        this.metadata = e5.j.d(this.metadata, 32 - Integer.numberOfLeadingZeros(i10), 31);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(size());
        Iterator<E> it = iterator();
        while (it.hasNext()) {
            objectOutputStream.writeObject(it.next());
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    @CanIgnoreReturnValue
    public boolean add(@d1 E e10) {
        if (needsAllocArrays()) {
            allocArrays();
        }
        Set<E> delegateOrNull = delegateOrNull();
        if (delegateOrNull != null) {
            return delegateOrNull.add(e10);
        }
        int[] requireEntries = requireEntries();
        Object[] requireElements = requireElements();
        int i10 = this.size;
        int i11 = i10 + 1;
        int d10 = s0.d(e10);
        int hashTableMask = hashTableMask();
        int i12 = d10 & hashTableMask;
        int h10 = e5.j.h(requireTable(), i12);
        if (h10 != 0) {
            int b10 = e5.j.b(d10, hashTableMask);
            int i13 = 0;
            while (true) {
                int i14 = h10 - 1;
                int i15 = requireEntries[i14];
                if (e5.j.b(i15, hashTableMask) == b10 && b5.r.a(e10, requireElements[i14])) {
                    return false;
                }
                int c10 = e5.j.c(i15, hashTableMask);
                i13++;
                if (c10 != 0) {
                    h10 = c10;
                } else {
                    if (i13 >= 9) {
                        return convertToHashFloodingResistantImplementation().add(e10);
                    }
                    if (i11 > hashTableMask) {
                        hashTableMask = resizeTable(hashTableMask, e5.j.e(hashTableMask), d10, i10);
                    } else {
                        requireEntries[i14] = e5.j.d(i15, i11, hashTableMask);
                    }
                }
            }
        } else if (i11 > hashTableMask) {
            hashTableMask = resizeTable(hashTableMask, e5.j.e(hashTableMask), d10, i10);
        } else {
            e5.j.i(requireTable(), i12, i11);
        }
        resizeMeMaybe(i11);
        insertEntry(i10, e10, d10, hashTableMask);
        this.size = i11;
        incrementModCount();
        return true;
    }

    public int adjustAfterRemove(int i10, int i11) {
        return i10 - 1;
    }

    @CanIgnoreReturnValue
    public int allocArrays() {
        b5.u.h0(needsAllocArrays(), "Arrays already allocated");
        int i10 = this.metadata;
        int j10 = e5.j.j(i10);
        this.table = e5.j.a(j10);
        setHashTableMask(j10 - 1);
        this.entries = new int[i10];
        this.elements = new Object[i10];
        return i10;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        if (needsAllocArrays()) {
            return;
        }
        incrementModCount();
        Set<E> delegateOrNull = delegateOrNull();
        if (delegateOrNull != null) {
            this.metadata = Ints.g(size(), 3, 1073741823);
            delegateOrNull.clear();
            this.table = null;
            this.size = 0;
            return;
        }
        Arrays.fill(requireElements(), 0, this.size, (Object) null);
        e5.j.g(requireTable());
        Arrays.fill(requireEntries(), 0, this.size, 0);
        this.size = 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(@CheckForNull Object obj) {
        if (needsAllocArrays()) {
            return false;
        }
        Set<E> delegateOrNull = delegateOrNull();
        if (delegateOrNull != null) {
            return delegateOrNull.contains(obj);
        }
        int d10 = s0.d(obj);
        int hashTableMask = hashTableMask();
        int h10 = e5.j.h(requireTable(), d10 & hashTableMask);
        if (h10 == 0) {
            return false;
        }
        int b10 = e5.j.b(d10, hashTableMask);
        do {
            int i10 = h10 - 1;
            int entry = entry(i10);
            if (e5.j.b(entry, hashTableMask) == b10 && b5.r.a(obj, element(i10))) {
                return true;
            }
            h10 = e5.j.c(entry, hashTableMask);
        } while (h10 != 0);
        return false;
    }

    @CanIgnoreReturnValue
    @a5.d
    public Set<E> convertToHashFloodingResistantImplementation() {
        Set<E> createHashFloodingResistantDelegate = createHashFloodingResistantDelegate(hashTableMask() + 1);
        int firstEntryIndex = firstEntryIndex();
        while (firstEntryIndex >= 0) {
            createHashFloodingResistantDelegate.add(element(firstEntryIndex));
            firstEntryIndex = getSuccessor(firstEntryIndex);
        }
        this.table = createHashFloodingResistantDelegate;
        this.entries = null;
        this.elements = null;
        incrementModCount();
        return createHashFloodingResistantDelegate;
    }

    @CheckForNull
    @a5.d
    public Set<E> delegateOrNull() {
        Object obj = this.table;
        if (obj instanceof Set) {
            return (Set) obj;
        }
        return null;
    }

    public int firstEntryIndex() {
        return isEmpty() ? -1 : 0;
    }

    public int getSuccessor(int i10) {
        int i11 = i10 + 1;
        if (i11 < this.size) {
            return i11;
        }
        return -1;
    }

    public void incrementModCount() {
        this.metadata += 32;
    }

    public void init(int i10) {
        b5.u.e(i10 >= 0, "Expected size must be >= 0");
        this.metadata = Ints.g(i10, 1, 1073741823);
    }

    public void insertEntry(int i10, @d1 E e10, int i11, int i12) {
        setEntry(i10, e5.j.d(i11, 0, i12));
        setElement(i10, e10);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return size() == 0;
    }

    @a5.d
    public boolean isUsingHashFloodingResistance() {
        return delegateOrNull() != null;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<E> iterator() {
        Set<E> delegateOrNull = delegateOrNull();
        return delegateOrNull != null ? delegateOrNull.iterator() : new a();
    }

    public void moveLastEntry(int i10, int i11) {
        Object requireTable = requireTable();
        int[] requireEntries = requireEntries();
        Object[] requireElements = requireElements();
        int size = size();
        int i12 = size - 1;
        if (i10 >= i12) {
            requireElements[i10] = null;
            requireEntries[i10] = 0;
            return;
        }
        Object obj = requireElements[i12];
        requireElements[i10] = obj;
        requireElements[i12] = null;
        requireEntries[i10] = requireEntries[i12];
        requireEntries[i12] = 0;
        int d10 = s0.d(obj) & i11;
        int h10 = e5.j.h(requireTable, d10);
        if (h10 == size) {
            e5.j.i(requireTable, d10, i10 + 1);
            return;
        }
        while (true) {
            int i13 = h10 - 1;
            int i14 = requireEntries[i13];
            int c10 = e5.j.c(i14, i11);
            if (c10 == size) {
                requireEntries[i13] = e5.j.d(i14, i10 + 1, i11);
                return;
            }
            h10 = c10;
        }
    }

    @a5.d
    public boolean needsAllocArrays() {
        return this.table == null;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    @CanIgnoreReturnValue
    public boolean remove(@CheckForNull Object obj) {
        if (needsAllocArrays()) {
            return false;
        }
        Set<E> delegateOrNull = delegateOrNull();
        if (delegateOrNull != null) {
            return delegateOrNull.remove(obj);
        }
        int hashTableMask = hashTableMask();
        int f10 = e5.j.f(obj, null, hashTableMask, requireTable(), requireEntries(), requireElements(), null);
        if (f10 == -1) {
            return false;
        }
        moveLastEntry(f10, hashTableMask);
        this.size--;
        incrementModCount();
        return true;
    }

    public void resizeEntries(int i10) {
        this.entries = Arrays.copyOf(requireEntries(), i10);
        this.elements = Arrays.copyOf(requireElements(), i10);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        Set<E> delegateOrNull = delegateOrNull();
        return delegateOrNull != null ? delegateOrNull.size() : this.size;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public Object[] toArray() {
        if (needsAllocArrays()) {
            return new Object[0];
        }
        Set<E> delegateOrNull = delegateOrNull();
        return delegateOrNull != null ? delegateOrNull.toArray() : Arrays.copyOf(requireElements(), this.size);
    }

    public void trimToSize() {
        if (needsAllocArrays()) {
            return;
        }
        Set<E> delegateOrNull = delegateOrNull();
        if (delegateOrNull != null) {
            Set<E> createHashFloodingResistantDelegate = createHashFloodingResistantDelegate(size());
            createHashFloodingResistantDelegate.addAll(delegateOrNull);
            this.table = createHashFloodingResistantDelegate;
            return;
        }
        int i10 = this.size;
        if (i10 < requireEntries().length) {
            resizeEntries(i10);
        }
        int j10 = e5.j.j(i10);
        int hashTableMask = hashTableMask();
        if (j10 < hashTableMask) {
            resizeTable(hashTableMask, j10, 0, 0);
        }
    }

    public static <E> CompactHashSet<E> create(Collection<? extends E> collection) {
        CompactHashSet<E> createWithExpectedSize = createWithExpectedSize(collection.size());
        createWithExpectedSize.addAll(collection);
        return createWithExpectedSize;
    }

    public CompactHashSet(int i10) {
        init(i10);
    }

    @SafeVarargs
    public static <E> CompactHashSet<E> create(E... eArr) {
        CompactHashSet<E> createWithExpectedSize = createWithExpectedSize(eArr.length);
        Collections.addAll(createWithExpectedSize, eArr);
        return createWithExpectedSize;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    @CanIgnoreReturnValue
    public <T> T[] toArray(T[] tArr) {
        if (needsAllocArrays()) {
            if (tArr.length > 0) {
                tArr[0] = null;
            }
            return tArr;
        }
        Set<E> delegateOrNull = delegateOrNull();
        if (delegateOrNull != null) {
            return (T[]) delegateOrNull.toArray(tArr);
        }
        return (T[]) b1.n(requireElements(), 0, this.size, tArr);
    }
}
