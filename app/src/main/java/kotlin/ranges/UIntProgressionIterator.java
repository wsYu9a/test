package kotlin.ranges;

import java.util.NoSuchElementException;
import kotlin.ExperimentalUnsignedTypes;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.UInt;
import kotlin.UnsignedKt;
import kotlin.collections.UIntIterator;
import kotlin.jvm.internal.DefaultConstructorMarker;

@SinceKotlin(version = "1.3")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\"\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\u0006\u0010\u000e\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u000fø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0003\u001a\u00020\u0002H\u0096\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u00020\u0005H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007R\u0019\u0010\b\u001a\u00020\u00058\u0002@\u0002X\u0082\u0004ø\u0001\u0000¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0019\u0010\n\u001a\u00020\u00058\u0002@\u0002X\u0082\u000eø\u0001\u0000¢\u0006\u0006\n\u0004\b\n\u0010\tR\u0019\u0010\u000b\u001a\u00020\u00058\u0002@\u0002X\u0082\u0004ø\u0001\u0000¢\u0006\u0006\n\u0004\b\u000b\u0010\tR\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\f\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, d2 = {"Lkotlin/ranges/UIntProgressionIterator;", "Lkotlin/collections/UIntIterator;", "", "hasNext", "()Z", "Lkotlin/UInt;", "nextUInt", "()I", "finalElement", "I", "next", "step", "Z", "first", "last", "", "<init>", "(IIILkotlin/jvm/internal/DefaultConstructorMarker;)V", "kotlin-stdlib"}, k = 1, mv = {1, 4, 0})
@ExperimentalUnsignedTypes
/* loaded from: classes5.dex */
final class UIntProgressionIterator extends UIntIterator {
    private final int finalElement;
    private boolean hasNext;
    private int next;
    private final int step;

    private UIntProgressionIterator(int i2, int i3, int i4) {
        this.finalElement = i3;
        boolean z = true;
        int uintCompare = UnsignedKt.uintCompare(i2, i3);
        if (i4 <= 0 ? uintCompare < 0 : uintCompare > 0) {
            z = false;
        }
        this.hasNext = z;
        this.step = UInt.m168constructorimpl(i4);
        this.next = this.hasNext ? i2 : i3;
    }

    @Override // java.util.Iterator
    /* renamed from: hasNext, reason: from getter */
    public boolean getHasNext() {
        return this.hasNext;
    }

    @Override // kotlin.collections.UIntIterator
    public int nextUInt() {
        int i2 = this.next;
        if (i2 != this.finalElement) {
            this.next = UInt.m168constructorimpl(this.step + i2);
        } else {
            if (!this.hasNext) {
                throw new NoSuchElementException();
            }
            this.hasNext = false;
        }
        return i2;
    }

    public /* synthetic */ UIntProgressionIterator(int i2, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(i2, i3, i4);
    }
}
