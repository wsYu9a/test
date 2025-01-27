package androidx.collection;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes.dex */
public final class ArraySet<E> implements Collection<E>, Set<E> {
    private static final int BASE_SIZE = 4;
    private static final int CACHE_SIZE = 10;
    private static final boolean DEBUG = false;
    private static final String TAG = "ArraySet";

    @Nullable
    private static Object[] sBaseCache;
    private static int sBaseCacheSize;

    @Nullable
    private static Object[] sTwiceBaseCache;
    private static int sTwiceBaseCacheSize;
    Object[] mArray;
    private int[] mHashes;
    int mSize;
    private static final Object sBaseCacheLock = new Object();
    private static final Object sTwiceBaseCacheLock = new Object();

    public class ElementIterator extends IndexBasedArrayIterator<E> {
        public ElementIterator() {
            super(ArraySet.this.mSize);
        }

        @Override // androidx.collection.IndexBasedArrayIterator
        public E elementAt(int i10) {
            return (E) ArraySet.this.valueAt(i10);
        }

        @Override // androidx.collection.IndexBasedArrayIterator
        public void removeAt(int i10) {
            ArraySet.this.removeAt(i10);
        }
    }

    public ArraySet() {
        this(0);
    }

    private void allocArrays(int i10) {
        if (i10 == 8) {
            synchronized (sTwiceBaseCacheLock) {
                try {
                    Object[] objArr = sTwiceBaseCache;
                    if (objArr != null) {
                        try {
                            this.mArray = objArr;
                            sTwiceBaseCache = (Object[]) objArr[0];
                            int[] iArr = (int[]) objArr[1];
                            this.mHashes = iArr;
                            if (iArr != null) {
                                objArr[1] = null;
                                objArr[0] = null;
                                sTwiceBaseCacheSize--;
                                return;
                            }
                        } catch (ClassCastException unused) {
                        }
                        System.out.println("ArraySet Found corrupt ArraySet cache: [0]=" + objArr[0] + " [1]=" + objArr[1]);
                        sTwiceBaseCache = null;
                        sTwiceBaseCacheSize = 0;
                    }
                } finally {
                }
            }
        } else if (i10 == 4) {
            synchronized (sBaseCacheLock) {
                try {
                    Object[] objArr2 = sBaseCache;
                    if (objArr2 != null) {
                        try {
                            this.mArray = objArr2;
                            sBaseCache = (Object[]) objArr2[0];
                            int[] iArr2 = (int[]) objArr2[1];
                            this.mHashes = iArr2;
                            if (iArr2 != null) {
                                objArr2[1] = null;
                                objArr2[0] = null;
                                sBaseCacheSize--;
                                return;
                            }
                        } catch (ClassCastException unused2) {
                        }
                        System.out.println("ArraySet Found corrupt ArraySet cache: [0]=" + objArr2[0] + " [1]=" + objArr2[1]);
                        sBaseCache = null;
                        sBaseCacheSize = 0;
                    }
                } finally {
                }
            }
        }
        this.mHashes = new int[i10];
        this.mArray = new Object[i10];
    }

    private int binarySearch(int i10) {
        try {
            return ContainerHelpers.binarySearch(this.mHashes, this.mSize, i10);
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new ConcurrentModificationException();
        }
    }

    private static void freeArrays(int[] iArr, Object[] objArr, int i10) {
        if (iArr.length == 8) {
            synchronized (sTwiceBaseCacheLock) {
                try {
                    if (sTwiceBaseCacheSize < 10) {
                        objArr[0] = sTwiceBaseCache;
                        objArr[1] = iArr;
                        for (int i11 = i10 - 1; i11 >= 2; i11--) {
                            objArr[i11] = null;
                        }
                        sTwiceBaseCache = objArr;
                        sTwiceBaseCacheSize++;
                    }
                } finally {
                }
            }
            return;
        }
        if (iArr.length == 4) {
            synchronized (sBaseCacheLock) {
                try {
                    if (sBaseCacheSize < 10) {
                        objArr[0] = sBaseCache;
                        objArr[1] = iArr;
                        for (int i12 = i10 - 1; i12 >= 2; i12--) {
                            objArr[i12] = null;
                        }
                        sBaseCache = objArr;
                        sBaseCacheSize++;
                    }
                } finally {
                }
            }
        }
    }

    private int indexOf(Object obj, int i10) {
        int i11 = this.mSize;
        if (i11 == 0) {
            return -1;
        }
        int binarySearch = binarySearch(i10);
        if (binarySearch < 0 || obj.equals(this.mArray[binarySearch])) {
            return binarySearch;
        }
        int i12 = binarySearch + 1;
        while (i12 < i11 && this.mHashes[i12] == i10) {
            if (obj.equals(this.mArray[i12])) {
                return i12;
            }
            i12++;
        }
        for (int i13 = binarySearch - 1; i13 >= 0 && this.mHashes[i13] == i10; i13--) {
            if (obj.equals(this.mArray[i13])) {
                return i13;
            }
        }
        return ~i12;
    }

    private int indexOfNull() {
        int i10 = this.mSize;
        if (i10 == 0) {
            return -1;
        }
        int binarySearch = binarySearch(0);
        if (binarySearch < 0) {
            return binarySearch;
        }
        if (this.mArray[binarySearch] == null) {
            return binarySearch;
        }
        int i11 = binarySearch + 1;
        while (i11 < i10 && this.mHashes[i11] == 0) {
            if (this.mArray[i11] == null) {
                return i11;
            }
            i11++;
        }
        for (int i12 = binarySearch - 1; i12 >= 0 && this.mHashes[i12] == 0; i12--) {
            if (this.mArray[i12] == null) {
                return i12;
            }
        }
        return ~i11;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean add(@Nullable E e10) {
        int i10;
        int indexOf;
        int i11 = this.mSize;
        if (e10 == null) {
            indexOf = indexOfNull();
            i10 = 0;
        } else {
            int hashCode = e10.hashCode();
            i10 = hashCode;
            indexOf = indexOf(e10, hashCode);
        }
        if (indexOf >= 0) {
            return false;
        }
        int i12 = ~indexOf;
        int[] iArr = this.mHashes;
        if (i11 >= iArr.length) {
            int i13 = 8;
            if (i11 >= 8) {
                i13 = (i11 >> 1) + i11;
            } else if (i11 < 4) {
                i13 = 4;
            }
            Object[] objArr = this.mArray;
            allocArrays(i13);
            if (i11 != this.mSize) {
                throw new ConcurrentModificationException();
            }
            int[] iArr2 = this.mHashes;
            if (iArr2.length > 0) {
                System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                System.arraycopy(objArr, 0, this.mArray, 0, objArr.length);
            }
            freeArrays(iArr, objArr, i11);
        }
        if (i12 < i11) {
            int[] iArr3 = this.mHashes;
            int i14 = i12 + 1;
            int i15 = i11 - i12;
            System.arraycopy(iArr3, i12, iArr3, i14, i15);
            Object[] objArr2 = this.mArray;
            System.arraycopy(objArr2, i12, objArr2, i14, i15);
        }
        int i16 = this.mSize;
        if (i11 == i16) {
            int[] iArr4 = this.mHashes;
            if (i12 < iArr4.length) {
                iArr4[i12] = i10;
                this.mArray[i12] = e10;
                this.mSize = i16 + 1;
                return true;
            }
        }
        throw new ConcurrentModificationException();
    }

    public void addAll(@NonNull ArraySet<? extends E> arraySet) {
        int i10 = arraySet.mSize;
        ensureCapacity(this.mSize + i10);
        if (this.mSize != 0) {
            for (int i11 = 0; i11 < i10; i11++) {
                add(arraySet.valueAt(i11));
            }
        } else if (i10 > 0) {
            System.arraycopy(arraySet.mHashes, 0, this.mHashes, 0, i10);
            System.arraycopy(arraySet.mArray, 0, this.mArray, 0, i10);
            if (this.mSize != 0) {
                throw new ConcurrentModificationException();
            }
            this.mSize = i10;
        }
    }

    @Override // java.util.Collection, java.util.Set
    public void clear() {
        int i10 = this.mSize;
        if (i10 != 0) {
            int[] iArr = this.mHashes;
            Object[] objArr = this.mArray;
            this.mHashes = ContainerHelpers.EMPTY_INTS;
            this.mArray = ContainerHelpers.EMPTY_OBJECTS;
            this.mSize = 0;
            freeArrays(iArr, objArr, i10);
        }
        if (this.mSize != 0) {
            throw new ConcurrentModificationException();
        }
    }

    @Override // java.util.Collection, java.util.Set
    public boolean contains(@Nullable Object obj) {
        return indexOf(obj) >= 0;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean containsAll(@NonNull Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    public void ensureCapacity(int i10) {
        int i11 = this.mSize;
        int[] iArr = this.mHashes;
        if (iArr.length < i10) {
            Object[] objArr = this.mArray;
            allocArrays(i10);
            int i12 = this.mSize;
            if (i12 > 0) {
                System.arraycopy(iArr, 0, this.mHashes, 0, i12);
                System.arraycopy(objArr, 0, this.mArray, 0, this.mSize);
            }
            freeArrays(iArr, objArr, this.mSize);
        }
        if (this.mSize != i11) {
            throw new ConcurrentModificationException();
        }
    }

    @Override // java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set = (Set) obj;
            if (size() != set.size()) {
                return false;
            }
            for (int i10 = 0; i10 < this.mSize; i10++) {
                try {
                    if (!set.contains(valueAt(i10))) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        int[] iArr = this.mHashes;
        int i10 = this.mSize;
        int i11 = 0;
        for (int i12 = 0; i12 < i10; i12++) {
            i11 += iArr[i12];
        }
        return i11;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return this.mSize <= 0;
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.Set
    @NonNull
    public Iterator<E> iterator() {
        return new ElementIterator();
    }

    @Override // java.util.Collection, java.util.Set
    public boolean remove(@Nullable Object obj) {
        int indexOf = indexOf(obj);
        if (indexOf < 0) {
            return false;
        }
        removeAt(indexOf);
        return true;
    }

    public boolean removeAll(@NonNull ArraySet<? extends E> arraySet) {
        int i10 = arraySet.mSize;
        int i11 = this.mSize;
        for (int i12 = 0; i12 < i10; i12++) {
            remove(arraySet.valueAt(i12));
        }
        return i11 != this.mSize;
    }

    public E removeAt(int i10) {
        int i11 = this.mSize;
        Object[] objArr = this.mArray;
        E e10 = (E) objArr[i10];
        if (i11 <= 1) {
            clear();
        } else {
            int i12 = i11 - 1;
            int[] iArr = this.mHashes;
            if (iArr.length <= 8 || i11 >= iArr.length / 3) {
                if (i10 < i12) {
                    int i13 = i10 + 1;
                    int i14 = i12 - i10;
                    System.arraycopy(iArr, i13, iArr, i10, i14);
                    Object[] objArr2 = this.mArray;
                    System.arraycopy(objArr2, i13, objArr2, i10, i14);
                }
                this.mArray[i12] = null;
            } else {
                allocArrays(i11 > 8 ? i11 + (i11 >> 1) : 8);
                if (i10 > 0) {
                    System.arraycopy(iArr, 0, this.mHashes, 0, i10);
                    System.arraycopy(objArr, 0, this.mArray, 0, i10);
                }
                if (i10 < i12) {
                    int i15 = i10 + 1;
                    int i16 = i12 - i10;
                    System.arraycopy(iArr, i15, this.mHashes, i10, i16);
                    System.arraycopy(objArr, i15, this.mArray, i10, i16);
                }
            }
            if (i11 != this.mSize) {
                throw new ConcurrentModificationException();
            }
            this.mSize = i12;
        }
        return e10;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean retainAll(@NonNull Collection<?> collection) {
        boolean z10 = false;
        for (int i10 = this.mSize - 1; i10 >= 0; i10--) {
            if (!collection.contains(this.mArray[i10])) {
                removeAt(i10);
                z10 = true;
            }
        }
        return z10;
    }

    @Override // java.util.Collection, java.util.Set
    public int size() {
        return this.mSize;
    }

    @Override // java.util.Collection, java.util.Set
    @NonNull
    public Object[] toArray() {
        int i10 = this.mSize;
        Object[] objArr = new Object[i10];
        System.arraycopy(this.mArray, 0, objArr, 0, i10);
        return objArr;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb2 = new StringBuilder(this.mSize * 14);
        sb2.append('{');
        for (int i10 = 0; i10 < this.mSize; i10++) {
            if (i10 > 0) {
                sb2.append(", ");
            }
            E valueAt = valueAt(i10);
            if (valueAt != this) {
                sb2.append(valueAt);
            } else {
                sb2.append("(this Set)");
            }
        }
        sb2.append('}');
        return sb2.toString();
    }

    public E valueAt(int i10) {
        return (E) this.mArray[i10];
    }

    public ArraySet(int i10) {
        if (i10 == 0) {
            this.mHashes = ContainerHelpers.EMPTY_INTS;
            this.mArray = ContainerHelpers.EMPTY_OBJECTS;
        } else {
            allocArrays(i10);
        }
        this.mSize = 0;
    }

    @Override // java.util.Collection, java.util.Set
    @NonNull
    public <T> T[] toArray(@NonNull T[] tArr) {
        if (tArr.length < this.mSize) {
            tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), this.mSize));
        }
        System.arraycopy(this.mArray, 0, tArr, 0, this.mSize);
        int length = tArr.length;
        int i10 = this.mSize;
        if (length > i10) {
            tArr[i10] = null;
        }
        return tArr;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean removeAll(@NonNull Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        boolean z10 = false;
        while (it.hasNext()) {
            z10 |= remove(it.next());
        }
        return z10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ArraySet(@Nullable ArraySet<E> arraySet) {
        this();
        if (arraySet != 0) {
            addAll((ArraySet) arraySet);
        }
    }

    public int indexOf(@Nullable Object obj) {
        return obj == null ? indexOfNull() : indexOf(obj, obj.hashCode());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ArraySet(@Nullable Collection<E> collection) {
        this();
        if (collection != 0) {
            addAll(collection);
        }
    }

    @Override // java.util.Collection, java.util.Set
    public boolean addAll(@NonNull Collection<? extends E> collection) {
        ensureCapacity(this.mSize + collection.size());
        Iterator<? extends E> it = collection.iterator();
        boolean z10 = false;
        while (it.hasNext()) {
            z10 |= add(it.next());
        }
        return z10;
    }

    public ArraySet(@Nullable E[] eArr) {
        this();
        if (eArr != null) {
            for (E e10 : eArr) {
                add(e10);
            }
        }
    }
}
