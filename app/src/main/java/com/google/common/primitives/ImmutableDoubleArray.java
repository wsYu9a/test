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
public final class ImmutableDoubleArray implements Serializable {
    private static final ImmutableDoubleArray EMPTY = new ImmutableDoubleArray(new double[0]);
    private final double[] array;
    private final int end;
    private final transient int start;

    public static class AsList extends AbstractList<Double> implements RandomAccess, Serializable {
        private final ImmutableDoubleArray parent;

        public /* synthetic */ AsList(ImmutableDoubleArray immutableDoubleArray, a aVar) {
            this(immutableDoubleArray);
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
                if (obj2 instanceof Double) {
                    int i11 = i10 + 1;
                    if (ImmutableDoubleArray.areEqual(this.parent.array[i10], ((Double) obj2).doubleValue())) {
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
            if (obj instanceof Double) {
                return this.parent.indexOf(((Double) obj).doubleValue());
            }
            return -1;
        }

        @Override // java.util.AbstractList, java.util.List
        public int lastIndexOf(@CheckForNull Object obj) {
            if (obj instanceof Double) {
                return this.parent.lastIndexOf(((Double) obj).doubleValue());
            }
            return -1;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.parent.length();
        }

        @Override // java.util.AbstractList, java.util.List
        public List<Double> subList(int i10, int i11) {
            return this.parent.subArray(i10, i11).asList();
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            return this.parent.toString();
        }

        private AsList(ImmutableDoubleArray immutableDoubleArray) {
            this.parent = immutableDoubleArray;
        }

        @Override // java.util.AbstractList, java.util.List
        public Double get(int i10) {
            return Double.valueOf(this.parent.get(i10));
        }
    }

    @CanIgnoreReturnValue
    public static final class b {

        /* renamed from: a */
        public double[] f10181a;

        /* renamed from: b */
        public int f10182b = 0;

        public b(int i10) {
            this.f10181a = new double[i10];
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

        public b a(double d10) {
            g(1);
            double[] dArr = this.f10181a;
            int i10 = this.f10182b;
            dArr[i10] = d10;
            this.f10182b = i10 + 1;
            return this;
        }

        public b b(ImmutableDoubleArray immutableDoubleArray) {
            g(immutableDoubleArray.length());
            System.arraycopy(immutableDoubleArray.array, immutableDoubleArray.start, this.f10181a, this.f10182b, immutableDoubleArray.length());
            this.f10182b += immutableDoubleArray.length();
            return this;
        }

        public b c(Iterable<Double> iterable) {
            if (iterable instanceof Collection) {
                return d((Collection) iterable);
            }
            Iterator<Double> it = iterable.iterator();
            while (it.hasNext()) {
                a(it.next().doubleValue());
            }
            return this;
        }

        public b d(Collection<Double> collection) {
            g(collection.size());
            for (Double d10 : collection) {
                double[] dArr = this.f10181a;
                int i10 = this.f10182b;
                this.f10182b = i10 + 1;
                dArr[i10] = d10.doubleValue();
            }
            return this;
        }

        public b e(double[] dArr) {
            g(dArr.length);
            System.arraycopy(dArr, 0, this.f10181a, this.f10182b, dArr.length);
            this.f10182b += dArr.length;
            return this;
        }

        @CheckReturnValue
        public ImmutableDoubleArray f() {
            return this.f10182b == 0 ? ImmutableDoubleArray.EMPTY : new ImmutableDoubleArray(this.f10181a, 0, this.f10182b);
        }

        public final void g(int i10) {
            int i11 = this.f10182b + i10;
            double[] dArr = this.f10181a;
            if (i11 > dArr.length) {
                this.f10181a = Arrays.copyOf(dArr, h(dArr.length, i11));
            }
        }
    }

    public /* synthetic */ ImmutableDoubleArray(double[] dArr, int i10, int i11, a aVar) {
        this(dArr, i10, i11);
    }

    public static boolean areEqual(double d10, double d11) {
        return Double.doubleToLongBits(d10) == Double.doubleToLongBits(d11);
    }

    public static b builder(int i10) {
        u.k(i10 >= 0, "Invalid initialCapacity: %s", i10);
        return new b(i10);
    }

    public static ImmutableDoubleArray copyOf(double[] dArr) {
        return dArr.length == 0 ? EMPTY : new ImmutableDoubleArray(Arrays.copyOf(dArr, dArr.length));
    }

    private boolean isPartialView() {
        return this.start > 0 || this.end < this.array.length;
    }

    public static ImmutableDoubleArray of() {
        return EMPTY;
    }

    public List<Double> asList() {
        return new AsList();
    }

    public boolean contains(double d10) {
        return indexOf(d10) >= 0;
    }

    public boolean equals(@CheckForNull Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ImmutableDoubleArray)) {
            return false;
        }
        ImmutableDoubleArray immutableDoubleArray = (ImmutableDoubleArray) obj;
        if (length() != immutableDoubleArray.length()) {
            return false;
        }
        for (int i10 = 0; i10 < length(); i10++) {
            if (!areEqual(get(i10), immutableDoubleArray.get(i10))) {
                return false;
            }
        }
        return true;
    }

    public double get(int i10) {
        u.C(i10, length());
        return this.array[this.start + i10];
    }

    public int hashCode() {
        int i10 = 1;
        for (int i11 = this.start; i11 < this.end; i11++) {
            i10 = (i10 * 31) + Doubles.j(this.array[i11]);
        }
        return i10;
    }

    public int indexOf(double d10) {
        for (int i10 = this.start; i10 < this.end; i10++) {
            if (areEqual(this.array[i10], d10)) {
                return i10 - this.start;
            }
        }
        return -1;
    }

    public boolean isEmpty() {
        return this.end == this.start;
    }

    public int lastIndexOf(double d10) {
        int i10 = this.end;
        do {
            i10--;
            if (i10 < this.start) {
                return -1;
            }
        } while (!areEqual(this.array[i10], d10));
        return i10 - this.start;
    }

    public int length() {
        return this.end - this.start;
    }

    public Object readResolve() {
        return isEmpty() ? EMPTY : this;
    }

    public ImmutableDoubleArray subArray(int i10, int i11) {
        u.f0(i10, i11, length());
        if (i10 == i11) {
            return EMPTY;
        }
        double[] dArr = this.array;
        int i12 = this.start;
        return new ImmutableDoubleArray(dArr, i10 + i12, i12 + i11);
    }

    public double[] toArray() {
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

    public ImmutableDoubleArray trimmed() {
        return isPartialView() ? new ImmutableDoubleArray(toArray()) : this;
    }

    public Object writeReplace() {
        return trimmed();
    }

    private ImmutableDoubleArray(double[] dArr) {
        this(dArr, 0, dArr.length);
    }

    public static ImmutableDoubleArray of(double d10) {
        return new ImmutableDoubleArray(new double[]{d10});
    }

    private ImmutableDoubleArray(double[] dArr, int i10, int i11) {
        this.array = dArr;
        this.start = i10;
        this.end = i11;
    }

    public static b builder() {
        return new b(10);
    }

    public static ImmutableDoubleArray of(double d10, double d11) {
        return new ImmutableDoubleArray(new double[]{d10, d11});
    }

    public static ImmutableDoubleArray copyOf(Collection<Double> collection) {
        return collection.isEmpty() ? EMPTY : new ImmutableDoubleArray(Doubles.z(collection));
    }

    public static ImmutableDoubleArray of(double d10, double d11, double d12) {
        return new ImmutableDoubleArray(new double[]{d10, d11, d12});
    }

    public static ImmutableDoubleArray copyOf(Iterable<Double> iterable) {
        if (iterable instanceof Collection) {
            return copyOf((Collection<Double>) iterable);
        }
        return builder().c(iterable).f();
    }

    public static ImmutableDoubleArray of(double d10, double d11, double d12, double d13) {
        return new ImmutableDoubleArray(new double[]{d10, d11, d12, d13});
    }

    public static ImmutableDoubleArray of(double d10, double d11, double d12, double d13, double d14) {
        return new ImmutableDoubleArray(new double[]{d10, d11, d12, d13, d14});
    }

    public static ImmutableDoubleArray of(double d10, double d11, double d12, double d13, double d14, double d15) {
        return new ImmutableDoubleArray(new double[]{d10, d11, d12, d13, d14, d15});
    }

    public static ImmutableDoubleArray of(double d10, double... dArr) {
        u.e(dArr.length <= 2147483646, "the total number of elements must fit in an int");
        double[] dArr2 = new double[dArr.length + 1];
        dArr2[0] = d10;
        System.arraycopy(dArr, 0, dArr2, 1, dArr.length);
        return new ImmutableDoubleArray(dArr2);
    }
}
