package kotlin.sequences;

import f.b.a.d;
import f.b.a.e;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0010(\n\u0002\u0010\u000b\n\u0002\b\u000e*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u0002H\u0096\u0002¢\u0006\u0004\b\u0007\u0010\u0004R*\u0010\b\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00010\u00018\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u0010"}, d2 = {"kotlin/sequences/FlatteningSequence$iterator$1", "", "", "ensureItemIterator", "()Z", "next", "()Ljava/lang/Object;", "hasNext", "itemIterator", "Ljava/util/Iterator;", "getItemIterator", "()Ljava/util/Iterator;", "setItemIterator", "(Ljava/util/Iterator;)V", "iterator", "getIterator", "kotlin-stdlib"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes5.dex */
public final class FlatteningSequence$iterator$1<E> implements Iterator<E>, KMappedMarker {

    @e
    private Iterator<? extends E> itemIterator;

    @d
    private final Iterator<T> iterator;
    final /* synthetic */ FlatteningSequence this$0;

    FlatteningSequence$iterator$1(FlatteningSequence flatteningSequence) {
        Sequence sequence;
        this.this$0 = flatteningSequence;
        sequence = flatteningSequence.sequence;
        this.iterator = sequence.iterator();
    }

    private final boolean ensureItemIterator() {
        Function1 function1;
        Function1 function12;
        Iterator<? extends E> it = this.itemIterator;
        if (it != null && !it.hasNext()) {
            this.itemIterator = null;
        }
        while (true) {
            if (this.itemIterator != null) {
                break;
            }
            if (!this.iterator.hasNext()) {
                return false;
            }
            Object next = this.iterator.next();
            function1 = this.this$0.iterator;
            function12 = this.this$0.transformer;
            Iterator<? extends E> it2 = (Iterator) function1.invoke(function12.invoke(next));
            if (it2.hasNext()) {
                this.itemIterator = it2;
                break;
            }
        }
        return true;
    }

    @e
    public final Iterator<E> getItemIterator() {
        return this.itemIterator;
    }

    @d
    public final Iterator<T> getIterator() {
        return this.iterator;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return ensureItemIterator();
    }

    @Override // java.util.Iterator
    public E next() {
        if (!ensureItemIterator()) {
            throw new NoSuchElementException();
        }
        Iterator<? extends E> it = this.itemIterator;
        if (it == null) {
            Intrinsics.throwNpe();
        }
        return it.next();
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final void setItemIterator(@e Iterator<? extends E> it) {
        this.itemIterator = it;
    }
}
