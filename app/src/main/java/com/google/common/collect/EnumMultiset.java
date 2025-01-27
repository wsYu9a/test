package com.google.common.collect;

import com.google.common.collect.Multisets;
import com.google.common.collect.s;
import com.google.common.primitives.Ints;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import e5.d1;
import e5.u0;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.Enum;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;
import javax.annotation.CheckForNull;

@a5.b(emulated = true)
@e5.m
/* loaded from: classes2.dex */
public final class EnumMultiset<E extends Enum<E>> extends com.google.common.collect.b<E> implements Serializable {

    @a5.c
    private static final long serialVersionUID = 0;
    private transient int[] counts;
    private transient int distinctElements;
    private transient E[] enumConstants;
    private transient long size;
    private transient Class<E> type;

    public class a extends EnumMultiset<E>.c<E> {
        public a() {
            super();
        }

        @Override // com.google.common.collect.EnumMultiset.c
        /* renamed from: b */
        public E a(int i10) {
            return (E) EnumMultiset.this.enumConstants[i10];
        }
    }

    public class b extends EnumMultiset<E>.c<s.a<E>> {

        public class a extends Multisets.f<E> {

            /* renamed from: b */
            public final /* synthetic */ int f9422b;

            public a(int i10) {
                this.f9422b = i10;
            }

            @Override // com.google.common.collect.s.a
            /* renamed from: a */
            public E getElement() {
                return (E) EnumMultiset.this.enumConstants[this.f9422b];
            }

            @Override // com.google.common.collect.s.a
            public int getCount() {
                return EnumMultiset.this.counts[this.f9422b];
            }
        }

        public b() {
            super();
        }

        @Override // com.google.common.collect.EnumMultiset.c
        /* renamed from: b */
        public s.a<E> a(int i10) {
            return new a(i10);
        }
    }

    public abstract class c<T> implements Iterator<T> {

        /* renamed from: b */
        public int f9424b = 0;

        /* renamed from: c */
        public int f9425c = -1;

        public c() {
        }

        public abstract T a(int i10);

        @Override // java.util.Iterator
        public boolean hasNext() {
            while (this.f9424b < EnumMultiset.this.enumConstants.length) {
                int[] iArr = EnumMultiset.this.counts;
                int i10 = this.f9424b;
                if (iArr[i10] > 0) {
                    return true;
                }
                this.f9424b = i10 + 1;
            }
            return false;
        }

        @Override // java.util.Iterator
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            T a10 = a(this.f9424b);
            int i10 = this.f9424b;
            this.f9425c = i10;
            this.f9424b = i10 + 1;
            return a10;
        }

        @Override // java.util.Iterator
        public void remove() {
            e5.i.e(this.f9425c >= 0);
            if (EnumMultiset.this.counts[this.f9425c] > 0) {
                EnumMultiset.access$210(EnumMultiset.this);
                EnumMultiset.access$322(EnumMultiset.this, r0.counts[this.f9425c]);
                EnumMultiset.this.counts[this.f9425c] = 0;
            }
            this.f9425c = -1;
        }
    }

    private EnumMultiset(Class<E> cls) {
        this.type = cls;
        b5.u.d(cls.isEnum());
        E[] enumConstants = cls.getEnumConstants();
        this.enumConstants = enumConstants;
        this.counts = new int[enumConstants.length];
    }

    public static /* synthetic */ int access$210(EnumMultiset enumMultiset) {
        int i10 = enumMultiset.distinctElements;
        enumMultiset.distinctElements = i10 - 1;
        return i10;
    }

    public static /* synthetic */ long access$322(EnumMultiset enumMultiset, long j10) {
        long j11 = enumMultiset.size - j10;
        enumMultiset.size = j11;
        return j11;
    }

    private void checkIsE(Object obj) {
        b5.u.E(obj);
        if (isActuallyE(obj)) {
            return;
        }
        String valueOf = String.valueOf(this.type);
        String valueOf2 = String.valueOf(obj);
        StringBuilder sb2 = new StringBuilder(valueOf.length() + 21 + valueOf2.length());
        sb2.append("Expected an ");
        sb2.append(valueOf);
        sb2.append(" but got ");
        sb2.append(valueOf2);
        throw new ClassCastException(sb2.toString());
    }

    public static <E extends Enum<E>> EnumMultiset<E> create(Class<E> cls) {
        return new EnumMultiset<>(cls);
    }

    private boolean isActuallyE(@CheckForNull Object obj) {
        if (!(obj instanceof Enum)) {
            return false;
        }
        Enum r52 = (Enum) obj;
        int ordinal = r52.ordinal();
        E[] eArr = this.enumConstants;
        return ordinal < eArr.length && eArr[ordinal] == r52;
    }

    @a5.c
    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        Class<E> cls = (Class) objectInputStream.readObject();
        this.type = cls;
        E[] enumConstants = cls.getEnumConstants();
        this.enumConstants = enumConstants;
        this.counts = new int[enumConstants.length];
        w.f(this, objectInputStream);
    }

    @a5.c
    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.type);
        w.k(this, objectOutputStream);
    }

    @Override // com.google.common.collect.b, java.util.AbstractCollection, java.util.Collection
    public void clear() {
        Arrays.fill(this.counts, 0);
        this.size = 0L;
        this.distinctElements = 0;
    }

    @Override // com.google.common.collect.b, java.util.AbstractCollection, java.util.Collection, com.google.common.collect.s
    public /* bridge */ /* synthetic */ boolean contains(@CheckForNull Object obj) {
        return super.contains(obj);
    }

    @Override // com.google.common.collect.s
    public int count(@CheckForNull Object obj) {
        if (obj == null || !isActuallyE(obj)) {
            return 0;
        }
        return this.counts[((Enum) obj).ordinal()];
    }

    @Override // com.google.common.collect.b
    public int distinctElements() {
        return this.distinctElements;
    }

    @Override // com.google.common.collect.b
    public Iterator<E> elementIterator() {
        return new a();
    }

    @Override // com.google.common.collect.b, com.google.common.collect.s
    public /* bridge */ /* synthetic */ Set elementSet() {
        return super.elementSet();
    }

    @Override // com.google.common.collect.b
    public Iterator<s.a<E>> entryIterator() {
        return new b();
    }

    @Override // com.google.common.collect.b, com.google.common.collect.s
    public /* bridge */ /* synthetic */ Set entrySet() {
        return super.entrySet();
    }

    @Override // com.google.common.collect.b, java.util.AbstractCollection, java.util.Collection
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, com.google.common.collect.s
    public Iterator<E> iterator() {
        return Multisets.n(this);
    }

    @Override // com.google.common.collect.b, com.google.common.collect.s
    @CanIgnoreReturnValue
    public int remove(@CheckForNull Object obj, int i10) {
        if (obj == null || !isActuallyE(obj)) {
            return 0;
        }
        Enum r12 = (Enum) obj;
        e5.i.b(i10, "occurrences");
        if (i10 == 0) {
            return count(obj);
        }
        int ordinal = r12.ordinal();
        int[] iArr = this.counts;
        int i11 = iArr[ordinal];
        if (i11 == 0) {
            return 0;
        }
        if (i11 <= i10) {
            iArr[ordinal] = 0;
            this.distinctElements--;
            this.size -= i11;
        } else {
            iArr[ordinal] = i11 - i10;
            this.size -= i10;
        }
        return i11;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.s
    public int size() {
        return Ints.x(this.size);
    }

    public static <E extends Enum<E>> EnumMultiset<E> create(Iterable<E> iterable) {
        Iterator<E> it = iterable.iterator();
        b5.u.e(it.hasNext(), "EnumMultiset constructor passed empty Iterable");
        EnumMultiset<E> enumMultiset = new EnumMultiset<>(it.next().getDeclaringClass());
        u0.a(enumMultiset, iterable);
        return enumMultiset;
    }

    @Override // com.google.common.collect.b, com.google.common.collect.s
    @CanIgnoreReturnValue
    public int add(E e10, int i10) {
        checkIsE(e10);
        e5.i.b(i10, "occurrences");
        if (i10 == 0) {
            return count(e10);
        }
        int ordinal = e10.ordinal();
        int i11 = this.counts[ordinal];
        long j10 = i10;
        long j11 = i11 + j10;
        b5.u.p(j11 <= 2147483647L, "too many occurrences: %s", j11);
        this.counts[ordinal] = (int) j11;
        if (i11 == 0) {
            this.distinctElements++;
        }
        this.size += j10;
        return i11;
    }

    @Override // com.google.common.collect.b, com.google.common.collect.s
    @CanIgnoreReturnValue
    public /* bridge */ /* synthetic */ boolean setCount(@d1 Object obj, int i10, int i11) {
        return super.setCount(obj, i10, i11);
    }

    @Override // com.google.common.collect.b, com.google.common.collect.s
    @CanIgnoreReturnValue
    public int setCount(E e10, int i10) {
        checkIsE(e10);
        e5.i.b(i10, c7.g.f1744b);
        int ordinal = e10.ordinal();
        int[] iArr = this.counts;
        int i11 = iArr[ordinal];
        iArr[ordinal] = i10;
        this.size += i10 - i11;
        if (i11 == 0 && i10 > 0) {
            this.distinctElements++;
        } else if (i11 > 0 && i10 == 0) {
            this.distinctElements--;
        }
        return i11;
    }

    public static <E extends Enum<E>> EnumMultiset<E> create(Iterable<E> iterable, Class<E> cls) {
        EnumMultiset<E> create = create(cls);
        u0.a(create, iterable);
        return create;
    }
}
