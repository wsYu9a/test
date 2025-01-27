package kotlin.collections;

import androidx.exifinterface.media.ExifInterface;
import com.cdo.oaps.ad.OapsKey;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import f.b.a.d;
import java.util.Arrays;
import java.util.Iterator;
import java.util.RandomAccess;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0011\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\u00060\u0003j\u0002`\u0004B\u001f\u0012\u000e\u0010'\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u0012\u0012\u0006\u0010*\u001a\u00020\u0005¢\u0006\u0004\b+\u0010,B\u0011\b\u0016\u0012\u0006\u0010!\u001a\u00020\u0005¢\u0006\u0004\b+\u0010 J\u001c\u0010\u0007\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0082\b¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\n\u001a\u00028\u00002\u0006\u0010\t\u001a\u00020\u0005H\u0096\u0002¢\u0006\u0004\b\n\u0010\u000bJ\r\u0010\r\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\u0016\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u000fH\u0096\u0002¢\u0006\u0004\b\u0010\u0010\u0011J)\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00010\u0012\"\u0004\b\u0001\u0010\u00012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00010\u0012H\u0014¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u0012H\u0014¢\u0006\u0004\b\u0014\u0010\u0017J\u001b\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0018\u001a\u00020\u0005¢\u0006\u0004\b\u0019\u0010\u001aJ\u0015\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001b\u001a\u00028\u0000¢\u0006\u0004\b\u001d\u0010\u001eJ\u0015\u0010\u001f\u001a\u00020\u001c2\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u001f\u0010 R\u0016\u0010!\u001a\u00020\u00058\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R$\u0010$\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\u00058\u0016@RX\u0096\u000e¢\u0006\f\n\u0004\b$\u0010\"\u001a\u0004\b%\u0010&R\u001e\u0010'\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u00128\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010)\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010\"¨\u0006-"}, d2 = {"Lkotlin/collections/RingBuffer;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/collections/AbstractList;", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "", "n", "forward", "(II)I", "index", MonitorConstants.CONNECT_TYPE_GET, "(I)Ljava/lang/Object;", "", "isFull", "()Z", "", "iterator", "()Ljava/util/Iterator;", "", "array", "toArray", "([Ljava/lang/Object;)[Ljava/lang/Object;", "", "()[Ljava/lang/Object;", "maxCapacity", "expanded", "(I)Lkotlin/collections/RingBuffer;", "element", "", "add", "(Ljava/lang/Object;)V", "removeFirst", "(I)V", "capacity", "I", "<set-?>", OapsKey.KEY_SIZE, "getSize", "()I", "buffer", "[Ljava/lang/Object;", "startIndex", "filledSize", "<init>", "([Ljava/lang/Object;I)V", "kotlin-stdlib"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes5.dex */
final class RingBuffer<T> extends AbstractList<T> implements RandomAccess {
    private final Object[] buffer;
    private final int capacity;
    private int size;
    private int startIndex;

    public RingBuffer(@d Object[] buffer, int i2) {
        Intrinsics.checkParameterIsNotNull(buffer, "buffer");
        this.buffer = buffer;
        if (!(i2 >= 0)) {
            throw new IllegalArgumentException(("ring buffer filled size should not be negative but it is " + i2).toString());
        }
        if (i2 <= buffer.length) {
            this.capacity = buffer.length;
            this.size = i2;
            return;
        }
        throw new IllegalArgumentException(("ring buffer filled size: " + i2 + " cannot be larger than the buffer size: " + buffer.length).toString());
    }

    public final int forward(int i2, int i3) {
        return (i2 + i3) % this.capacity;
    }

    @Override // java.util.Collection, java.util.List
    public final void add(T element) {
        if (isFull()) {
            throw new IllegalStateException("ring buffer is full");
        }
        this.buffer[(this.startIndex + size()) % this.capacity] = element;
        this.size = size() + 1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @d
    public final RingBuffer<T> expanded(int maxCapacity) {
        int coerceAtMost;
        Object[] array;
        int i2 = this.capacity;
        coerceAtMost = RangesKt___RangesKt.coerceAtMost(i2 + (i2 >> 1) + 1, maxCapacity);
        if (this.startIndex == 0) {
            array = Arrays.copyOf(this.buffer, coerceAtMost);
            Intrinsics.checkExpressionValueIsNotNull(array, "java.util.Arrays.copyOf(this, newSize)");
        } else {
            array = toArray(new Object[coerceAtMost]);
        }
        return new RingBuffer<>(array, size());
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public T get(int i2) {
        AbstractList.INSTANCE.checkElementIndex$kotlin_stdlib(i2, size());
        return (T) this.buffer[(this.startIndex + i2) % this.capacity];
    }

    @Override // kotlin.collections.AbstractList, kotlin.collections.AbstractCollection
    public int getSize() {
        return this.size;
    }

    public final boolean isFull() {
        return size() == this.capacity;
    }

    @Override // kotlin.collections.AbstractList, kotlin.collections.AbstractCollection, java.util.Collection, java.lang.Iterable
    @d
    public Iterator<T> iterator() {
        return new AbstractIterator<T>() { // from class: kotlin.collections.RingBuffer$iterator$1
            private int count;
            private int index;

            {
                int i2;
                this.count = RingBuffer.this.size();
                i2 = RingBuffer.this.startIndex;
                this.index = i2;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.collections.AbstractIterator
            protected void computeNext() {
                Object[] objArr;
                if (this.count == 0) {
                    done();
                    return;
                }
                objArr = RingBuffer.this.buffer;
                setNext(objArr[this.index]);
                this.index = (this.index + 1) % RingBuffer.this.capacity;
                this.count--;
            }
        };
    }

    public final void removeFirst(int n) {
        if (!(n >= 0)) {
            throw new IllegalArgumentException(("n shouldn't be negative but it is " + n).toString());
        }
        if (!(n <= size())) {
            throw new IllegalArgumentException(("n shouldn't be greater than the buffer size: n = " + n + ", size = " + size()).toString());
        }
        if (n > 0) {
            int i2 = this.startIndex;
            int i3 = (i2 + n) % this.capacity;
            if (i2 > i3) {
                ArraysKt___ArraysJvmKt.fill(this.buffer, (Object) null, i2, this.capacity);
                ArraysKt___ArraysJvmKt.fill(this.buffer, (Object) null, 0, i3);
            } else {
                ArraysKt___ArraysJvmKt.fill(this.buffer, (Object) null, i2, i3);
            }
            this.startIndex = i3;
            this.size = size() - n;
        }
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection
    @d
    public <T> T[] toArray(@d T[] array) {
        Intrinsics.checkParameterIsNotNull(array, "array");
        if (array.length < size()) {
            array = (T[]) Arrays.copyOf(array, size());
            Intrinsics.checkExpressionValueIsNotNull(array, "java.util.Arrays.copyOf(this, newSize)");
        }
        int size = size();
        int i2 = 0;
        int i3 = 0;
        for (int i4 = this.startIndex; i3 < size && i4 < this.capacity; i4++) {
            array[i3] = this.buffer[i4];
            i3++;
        }
        while (i3 < size) {
            array[i3] = this.buffer[i2];
            i3++;
            i2++;
        }
        if (array.length > size()) {
            array[size()] = null;
        }
        return array;
    }

    public RingBuffer(int i2) {
        this(new Object[i2], 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.collections.AbstractCollection, java.util.Collection
    @d
    public Object[] toArray() {
        return toArray(new Object[size()]);
    }
}
