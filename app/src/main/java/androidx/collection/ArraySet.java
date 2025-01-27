package androidx.collection;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public final class ArraySet<E> implements Collection<E>, Set<E> {

    /* renamed from: a */
    private static final boolean f1123a = false;

    /* renamed from: b */
    private static final String f1124b = "ArraySet";

    /* renamed from: c */
    private static final int[] f1125c = new int[0];

    /* renamed from: d */
    private static final Object[] f1126d = new Object[0];

    /* renamed from: e */
    private static final int f1127e = 4;

    /* renamed from: f */
    private static final int f1128f = 10;

    /* renamed from: g */
    @Nullable
    private static Object[] f1129g;

    /* renamed from: h */
    private static int f1130h;

    /* renamed from: i */
    @Nullable
    private static Object[] f1131i;

    /* renamed from: j */
    private static int f1132j;
    private int[] k;
    Object[] l;
    int m;
    private MapCollections<E, E> n;

    /* renamed from: androidx.collection.ArraySet$1 */
    class AnonymousClass1 extends MapCollections<E, E> {
        AnonymousClass1() {
        }

        @Override // androidx.collection.MapCollections
        protected void a() {
            ArraySet.this.clear();
        }

        @Override // androidx.collection.MapCollections
        protected Object b(int i2, int i3) {
            return ArraySet.this.l[i2];
        }

        @Override // androidx.collection.MapCollections
        protected Map<E, E> c() {
            throw new UnsupportedOperationException("not a map");
        }

        @Override // androidx.collection.MapCollections
        protected int d() {
            return ArraySet.this.m;
        }

        @Override // androidx.collection.MapCollections
        protected int e(Object obj) {
            return ArraySet.this.indexOf(obj);
        }

        @Override // androidx.collection.MapCollections
        protected int f(Object obj) {
            return ArraySet.this.indexOf(obj);
        }

        @Override // androidx.collection.MapCollections
        protected void g(E e2, E e3) {
            ArraySet.this.add(e2);
        }

        @Override // androidx.collection.MapCollections
        protected void h(int i2) {
            ArraySet.this.removeAt(i2);
        }

        @Override // androidx.collection.MapCollections
        protected E i(int i2, E e2) {
            throw new UnsupportedOperationException("not a map");
        }
    }

    public ArraySet() {
        this(0);
    }

    private void a(int i2) {
        if (i2 == 8) {
            synchronized (ArraySet.class) {
                Object[] objArr = f1131i;
                if (objArr != null) {
                    this.l = objArr;
                    f1131i = (Object[]) objArr[0];
                    this.k = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    f1132j--;
                    return;
                }
            }
        } else if (i2 == 4) {
            synchronized (ArraySet.class) {
                Object[] objArr2 = f1129g;
                if (objArr2 != null) {
                    this.l = objArr2;
                    f1129g = (Object[]) objArr2[0];
                    this.k = (int[]) objArr2[1];
                    objArr2[1] = null;
                    objArr2[0] = null;
                    f1130h--;
                    return;
                }
            }
        }
        this.k = new int[i2];
        this.l = new Object[i2];
    }

    private static void b(int[] iArr, Object[] objArr, int i2) {
        if (iArr.length == 8) {
            synchronized (ArraySet.class) {
                if (f1132j < 10) {
                    objArr[0] = f1131i;
                    objArr[1] = iArr;
                    for (int i3 = i2 - 1; i3 >= 2; i3--) {
                        objArr[i3] = null;
                    }
                    f1131i = objArr;
                    f1132j++;
                }
            }
            return;
        }
        if (iArr.length == 4) {
            synchronized (ArraySet.class) {
                if (f1130h < 10) {
                    objArr[0] = f1129g;
                    objArr[1] = iArr;
                    for (int i4 = i2 - 1; i4 >= 2; i4--) {
                        objArr[i4] = null;
                    }
                    f1129g = objArr;
                    f1130h++;
                }
            }
        }
    }

    private MapCollections<E, E> c() {
        if (this.n == null) {
            this.n = new MapCollections<E, E>() { // from class: androidx.collection.ArraySet.1
                AnonymousClass1() {
                }

                @Override // androidx.collection.MapCollections
                protected void a() {
                    ArraySet.this.clear();
                }

                @Override // androidx.collection.MapCollections
                protected Object b(int i2, int i3) {
                    return ArraySet.this.l[i2];
                }

                @Override // androidx.collection.MapCollections
                protected Map<E, E> c() {
                    throw new UnsupportedOperationException("not a map");
                }

                @Override // androidx.collection.MapCollections
                protected int d() {
                    return ArraySet.this.m;
                }

                @Override // androidx.collection.MapCollections
                protected int e(Object obj) {
                    return ArraySet.this.indexOf(obj);
                }

                @Override // androidx.collection.MapCollections
                protected int f(Object obj) {
                    return ArraySet.this.indexOf(obj);
                }

                @Override // androidx.collection.MapCollections
                protected void g(E e2, E e3) {
                    ArraySet.this.add(e2);
                }

                @Override // androidx.collection.MapCollections
                protected void h(int i2) {
                    ArraySet.this.removeAt(i2);
                }

                @Override // androidx.collection.MapCollections
                protected E i(int i2, E e2) {
                    throw new UnsupportedOperationException("not a map");
                }
            };
        }
        return this.n;
    }

    private int d(Object obj, int i2) {
        int i3 = this.m;
        if (i3 == 0) {
            return -1;
        }
        int a2 = ContainerHelpers.a(this.k, i3, i2);
        if (a2 < 0 || obj.equals(this.l[a2])) {
            return a2;
        }
        int i4 = a2 + 1;
        while (i4 < i3 && this.k[i4] == i2) {
            if (obj.equals(this.l[i4])) {
                return i4;
            }
            i4++;
        }
        for (int i5 = a2 - 1; i5 >= 0 && this.k[i5] == i2; i5--) {
            if (obj.equals(this.l[i5])) {
                return i5;
            }
        }
        return i4 ^ (-1);
    }

    private int e() {
        int i2 = this.m;
        if (i2 == 0) {
            return -1;
        }
        int a2 = ContainerHelpers.a(this.k, i2, 0);
        if (a2 < 0 || this.l[a2] == null) {
            return a2;
        }
        int i3 = a2 + 1;
        while (i3 < i2 && this.k[i3] == 0) {
            if (this.l[i3] == null) {
                return i3;
            }
            i3++;
        }
        for (int i4 = a2 - 1; i4 >= 0 && this.k[i4] == 0; i4--) {
            if (this.l[i4] == null) {
                return i4;
            }
        }
        return i3 ^ (-1);
    }

    @Override // java.util.Collection, java.util.Set
    public boolean add(@Nullable E e2) {
        int i2;
        int d2;
        if (e2 == null) {
            d2 = e();
            i2 = 0;
        } else {
            int hashCode = e2.hashCode();
            i2 = hashCode;
            d2 = d(e2, hashCode);
        }
        if (d2 >= 0) {
            return false;
        }
        int i3 = d2 ^ (-1);
        int i4 = this.m;
        int[] iArr = this.k;
        if (i4 >= iArr.length) {
            int i5 = 4;
            if (i4 >= 8) {
                i5 = (i4 >> 1) + i4;
            } else if (i4 >= 4) {
                i5 = 8;
            }
            Object[] objArr = this.l;
            a(i5);
            int[] iArr2 = this.k;
            if (iArr2.length > 0) {
                System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                System.arraycopy(objArr, 0, this.l, 0, objArr.length);
            }
            b(iArr, objArr, this.m);
        }
        int i6 = this.m;
        if (i3 < i6) {
            int[] iArr3 = this.k;
            int i7 = i3 + 1;
            System.arraycopy(iArr3, i3, iArr3, i7, i6 - i3);
            Object[] objArr2 = this.l;
            System.arraycopy(objArr2, i3, objArr2, i7, this.m - i3);
        }
        this.k[i3] = i2;
        this.l[i3] = e2;
        this.m++;
        return true;
    }

    public void addAll(@NonNull ArraySet<? extends E> arraySet) {
        int i2 = arraySet.m;
        ensureCapacity(this.m + i2);
        if (this.m != 0) {
            for (int i3 = 0; i3 < i2; i3++) {
                add(arraySet.valueAt(i3));
            }
        } else if (i2 > 0) {
            System.arraycopy(arraySet.k, 0, this.k, 0, i2);
            System.arraycopy(arraySet.l, 0, this.l, 0, i2);
            this.m = i2;
        }
    }

    @Override // java.util.Collection, java.util.Set
    public void clear() {
        int i2 = this.m;
        if (i2 != 0) {
            b(this.k, this.l, i2);
            this.k = f1125c;
            this.l = f1126d;
            this.m = 0;
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

    public void ensureCapacity(int i2) {
        int[] iArr = this.k;
        if (iArr.length < i2) {
            Object[] objArr = this.l;
            a(i2);
            int i3 = this.m;
            if (i3 > 0) {
                System.arraycopy(iArr, 0, this.k, 0, i3);
                System.arraycopy(objArr, 0, this.l, 0, this.m);
            }
            b(iArr, objArr, this.m);
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
            for (int i2 = 0; i2 < this.m; i2++) {
                try {
                    if (!set.contains(valueAt(i2))) {
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
        int[] iArr = this.k;
        int i2 = this.m;
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            i3 += iArr[i4];
        }
        return i3;
    }

    public int indexOf(@Nullable Object obj) {
        return obj == null ? e() : d(obj, obj.hashCode());
    }

    @Override // java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return this.m <= 0;
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<E> iterator() {
        return c().getKeySet().iterator();
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
        int i2 = arraySet.m;
        int i3 = this.m;
        for (int i4 = 0; i4 < i2; i4++) {
            remove(arraySet.valueAt(i4));
        }
        return i3 != this.m;
    }

    public E removeAt(int i2) {
        Object[] objArr = this.l;
        E e2 = (E) objArr[i2];
        int i3 = this.m;
        if (i3 <= 1) {
            b(this.k, objArr, i3);
            this.k = f1125c;
            this.l = f1126d;
            this.m = 0;
        } else {
            int[] iArr = this.k;
            if (iArr.length <= 8 || i3 >= iArr.length / 3) {
                int i4 = i3 - 1;
                this.m = i4;
                if (i2 < i4) {
                    int i5 = i2 + 1;
                    System.arraycopy(iArr, i5, iArr, i2, i4 - i2);
                    Object[] objArr2 = this.l;
                    System.arraycopy(objArr2, i5, objArr2, i2, this.m - i2);
                }
                this.l[this.m] = null;
            } else {
                a(i3 > 8 ? i3 + (i3 >> 1) : 8);
                this.m--;
                if (i2 > 0) {
                    System.arraycopy(iArr, 0, this.k, 0, i2);
                    System.arraycopy(objArr, 0, this.l, 0, i2);
                }
                int i6 = this.m;
                if (i2 < i6) {
                    int i7 = i2 + 1;
                    System.arraycopy(iArr, i7, this.k, i2, i6 - i2);
                    System.arraycopy(objArr, i7, this.l, i2, this.m - i2);
                }
            }
        }
        return e2;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean retainAll(@NonNull Collection<?> collection) {
        boolean z = false;
        for (int i2 = this.m - 1; i2 >= 0; i2--) {
            if (!collection.contains(this.l[i2])) {
                removeAt(i2);
                z = true;
            }
        }
        return z;
    }

    @Override // java.util.Collection, java.util.Set
    public int size() {
        return this.m;
    }

    @Override // java.util.Collection, java.util.Set
    @NonNull
    public Object[] toArray() {
        int i2 = this.m;
        Object[] objArr = new Object[i2];
        System.arraycopy(this.l, 0, objArr, 0, i2);
        return objArr;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.m * 14);
        sb.append('{');
        for (int i2 = 0; i2 < this.m; i2++) {
            if (i2 > 0) {
                sb.append(", ");
            }
            E valueAt = valueAt(i2);
            if (valueAt != this) {
                sb.append(valueAt);
            } else {
                sb.append("(this Set)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    @Nullable
    public E valueAt(int i2) {
        return (E) this.l[i2];
    }

    public ArraySet(int i2) {
        if (i2 == 0) {
            this.k = f1125c;
            this.l = f1126d;
        } else {
            a(i2);
        }
        this.m = 0;
    }

    @Override // java.util.Collection, java.util.Set
    @NonNull
    public <T> T[] toArray(@NonNull T[] tArr) {
        if (tArr.length < this.m) {
            tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), this.m));
        }
        System.arraycopy(this.l, 0, tArr, 0, this.m);
        int length = tArr.length;
        int i2 = this.m;
        if (length > i2) {
            tArr[i2] = null;
        }
        return tArr;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean removeAll(@NonNull Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        boolean z = false;
        while (it.hasNext()) {
            z |= remove(it.next());
        }
        return z;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ArraySet(@Nullable ArraySet<E> arraySet) {
        this();
        if (arraySet != 0) {
            addAll((ArraySet) arraySet);
        }
    }

    @Override // java.util.Collection, java.util.Set
    public boolean addAll(@NonNull Collection<? extends E> collection) {
        ensureCapacity(this.m + collection.size());
        Iterator<? extends E> it = collection.iterator();
        boolean z = false;
        while (it.hasNext()) {
            z |= add(it.next());
        }
        return z;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ArraySet(@Nullable Collection<E> collection) {
        this();
        if (collection != 0) {
            addAll(collection);
        }
    }
}
