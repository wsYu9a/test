package com.google.common.primitives;

import b5.u;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.CheckReturnValue;
import com.google.errorprone.annotations.Immutable;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;
import javax.annotation.CheckForNull;
import okhttp3.HttpUrl;

@a5.b
@Immutable
@a5.a
@n5.b
/* loaded from: classes2.dex */
public final class ImmutableIntArray implements Serializable {
    private static final ImmutableIntArray EMPTY = new ImmutableIntArray(new int[0]);
    private final int[] array;
    private final int end;
    private final transient int start;

    public static class AsList extends AbstractList<Integer> implements RandomAccess, Serializable {
        private final ImmutableIntArray parent;

        public /* synthetic */ AsList(ImmutableIntArray immutableIntArray, a aVar) {
            this(immutableIntArray);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean contains(@CheckForNull Object obj) {
            return indexOf(obj) >= 0;
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public boolean equals(@CheckForNull Object obj) {
            if (obj instanceof AsList) {
                return this.parent.equals(((AsList) obj).parent);
            }
            if (!(obj instanceof List)) {
                return false;
            }
            List list = (List) obj;
            if (size() != list.size()) {
                return false;
            }
            int i10 = this.parent.start;
            for (Object obj2 : list) {
                if (obj2 instanceof Integer) {
                    int i11 = i10 + 1;
                    if (this.parent.array[i10] == ((Integer) obj2).intValue()) {
                        i10 = i11;
                    }
                }
                return false;
            }
            return true;
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public int hashCode() {
            return this.parent.hashCode();
        }

        @Override // java.util.AbstractList, java.util.List
        public int indexOf(@CheckForNull Object obj) {
            if (obj instanceof Integer) {
                return this.parent.indexOf(((Integer) obj).intValue());
            }
            return -1;
        }

        @Override // java.util.AbstractList, java.util.List
        public int lastIndexOf(@CheckForNull Object obj) {
            if (obj instanceof Integer) {
                return this.parent.lastIndexOf(((Integer) obj).intValue());
            }
            return -1;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.parent.length();
        }

        @Override // java.util.AbstractList, java.util.List
        public List<Integer> subList(int i10, int i11) {
            return this.parent.subArray(i10, i11).asList();
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            return this.parent.toString();
        }

        private AsList(ImmutableIntArray immutableIntArray) {
            this.parent = immutableIntArray;
        }

        @Override // java.util.AbstractList, java.util.List
        public Integer get(int i10) {
            return Integer.valueOf(this.parent.get(i10));
        }
    }

    @CanIgnoreReturnValue
    public static final class b {

        /* renamed from: a */
        public int[] f10183a;

        /* renamed from: b */
        public int f10184b = 0;

        public b(int i10) {
            this.f10183a = new int[i10];
        }

        public static int h(int i10, int i11) {
            if (i11 < 0) {
                throw new AssertionError("cannot store more than MAX_VALUE elements");
            }
            int i12 = i10 + (i10 >> 1) + 1;
            if (i12 < i11) {
                i12 = Integer.highestOneBit(i11 - 1) << 1;
            }
            if (i12 < 0) {
                return Integer.MAX_VALUE;
            }
            return i12;
        }

        public b a(int i10) {
            g(1);
            int[] iArr = this.f10183a;
            int i11 = this.f10184b;
            iArr[i11] = i10;
            this.f10184b = i11 + 1;
            return this;
        }

        public b b(ImmutableIntArray immutableIntArray) {
            g(immutableIntArray.length());
            System.arraycopy(immutableIntArray.array, immutableIntArray.start, this.f10183a, this.f10184b, immutableIntArray.length());
            this.f10184b += immutableIntArray.length();
            return this;
        }

        public b c(Iterable<Integer> iterable) {
            if (iterable instanceof Collection) {
                return d((Collection) iterable);
            }
            Iterator<Integer> it = iterable.iterator();
            while (it.hasNext()) {
                a(it.next().intValue());
            }
            return this;
        }

        public b d(Collection<Integer> collection) {
            g(collection.size());
            for (Integer num : collection) {
                int[] iArr = this.f10183a;
                int i10 = this.f10184b;
                this.f10184b = i10 + 1;
                iArr[i10] = num.intValue();
            }
            return this;
        }

        public b e(int[] iArr) {
            g(iArr.length);
            System.arraycopy(iArr, 0, this.f10183a, this.f10184b, iArr.length);
            this.f10184b += iArr.length;
            return this;
        }

        @CheckReturnValue
        public ImmutableIntArray f() {
            return this.f10184b == 0 ? ImmutableIntArray.EMPTY : new ImmutableIntArray(this.f10183a, 0, this.f10184b);
        }

        public final void g(int i10) {
            int i11 = this.f10184b + i10;
            int[] iArr = this.f10183a;
            if (i11 > iArr.length) {
                this.f10183a = Arrays.copyOf(iArr, h(iArr.length, i11));
            }
        }
    }

    public /* synthetic */ ImmutableIntArray(int[] iArr, int i10, int i11, a aVar) {
        this(iArr, i10, i11);
    }

    public static b builder(int i10) {
        u.k(i10 >= 0, "Invalid initialCapacity: %s", i10);
        return new b(i10);
    }

    public static ImmutableIntArray copyOf(int[] iArr) {
        return iArr.length == 0 ? EMPTY : new ImmutableIntArray(Arrays.copyOf(iArr, iArr.length));
    }

    private boolean isPartialView() {
        return this.start > 0 || this.end < this.array.length;
    }

    public static ImmutableIntArray of() {
        return EMPTY;
    }

    public List<Integer> asList() {
        return new AsList();
    }

    public boolean contains(int i10) {
        return indexOf(i10) >= 0;
    }

    public boolean equals(@CheckForNull Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ImmutableIntArray)) {
            return false;
        }
        ImmutableIntArray immutableIntArray = (ImmutableIntArray) obj;
        if (length() != immutableIntArray.length()) {
            return false;
        }
        for (int i10 = 0; i10 < length(); i10++) {
            if (get(i10) != immutableIntArray.get(i10)) {
                return false;
            }
        }
        return true;
    }

    public int get(int i10) {
        u.C(i10, length());
        return this.array[this.start + i10];
    }

    public int hashCode() {
        int i10 = 1;
        for (int i11 = this.start; i11 < this.end; i11++) {
            i10 = (i10 * 31) + Ints.l(this.array[i11]);
        }
        return i10;
    }

    public int indexOf(int i10) {
        for (int i11 = this.start; i11 < this.end; i11++) {
            if (this.array[i11] == i10) {
                return i11 - this.start;
            }
        }
        return -1;
    }

    public boolean isEmpty() {
        return this.end == this.start;
    }

    public int lastIndexOf(int i10) {
        int i11;
        int i12 = this.end;
        do {
            i12--;
            i11 = this.start;
            if (i12 < i11) {
                return -1;
            }
        } while (this.array[i12] != i10);
        return i12 - i11;
    }

    public int length() {
        return this.end - this.start;
    }

    public Object readResolve() {
        return isEmpty() ? EMPTY : this;
    }

    public ImmutableIntArray subArray(int i10, int i11) {
        u.f0(i10, i11, length());
        if (i10 == i11) {
            return EMPTY;
        }
        int[] iArr = this.array;
        int i12 = this.start;
        return new ImmutableIntArray(iArr, i10 + i12, i12 + i11);
    }

    public int[] toArray() {
        return Arrays.copyOfRange(this.array, this.start, this.end);
    }

    public String toString() {
        if (isEmpty()) {
            return HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        }
        StringBuilder sb2 = new StringBuilder(length() * 5);
        sb2.append('[');
        sb2.append(this.array[this.start]);
        int i10 = this.start;
        while (true) {
            i10++;
            if (i10 >= this.end) {
                sb2.append(']');
                return sb2.toString();
            }
            sb2.append(", ");
            sb2.append(this.array[i10]);
        }
    }

    public ImmutableIntArray trimmed() {
        return isPartialView() ? new ImmutableIntArray(toArray()) : this;
    }

    public Object writeReplace() {
        return trimmed();
    }

    private ImmutableIntArray(int[] iArr) {
        this(iArr, 0, iArr.length);
    }

    public static ImmutableIntArray copyOf(Collection<Integer> collection) {
        return collection.isEmpty() ? EMPTY : new ImmutableIntArray(Ints.B(collection));
    }

    public static ImmutableIntArray of(int i10) {
        return new ImmutableIntArray(new int[]{i10});
    }

    private ImmutableIntArray(int[] iArr, int i10, int i11) {
        this.array = iArr;
        this.start = i10;
        this.end = i11;
    }

    public static b builder() {
        return new b(10);
    }

    public static ImmutableIntArray copyOf(Iterable<Integer> iterable) {
        if (iterable instanceof Collection) {
            return copyOf((Collection<Integer>) iterable);
        }
        return builder().c(iterable).f();
    }

    public static ImmutableIntArray of(int i10, int i11) {
        return new ImmutableIntArray(new int[]{i10, i11});
    }

    public static ImmutableIntArray of(int i10, int i11, int i12) {
        return new ImmutableIntArray(new int[]{i10, i11, i12});
    }

    public static ImmutableIntArray of(int i10, int i11, int i12, int i13) {
        return new ImmutableIntArray(new int[]{i10, i11, i12, i13});
    }

    public static ImmutableIntArray of(int i10, int i11, int i12, int i13, int i14) {
        return new ImmutableIntArray(new int[]{i10, i11, i12, i13, i14});
    }

    public static ImmutableIntArray of(int i10, int i11, int i12, int i13, int i14, int i15) {
        return new ImmutableIntArray(new int[]{i10, i11, i12, i13, i14, i15});
    }

    public static ImmutableIntArray of(int i10, int... iArr) {
        u.e(iArr.length <= 2147483646, "the total number of elements must fit in an int");
        int[] iArr2 = new int[iArr.length + 1];
        iArr2[0] = i10;
        System.arraycopy(iArr, 0, iArr2, 1, iArr.length);
        return new ImmutableIntArray(iArr2);
    }
}
