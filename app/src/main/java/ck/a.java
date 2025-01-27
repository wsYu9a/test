package ck;

import java.util.Iterator;
import rx.internal.util.atomic.LinkedQueueNode;

/* loaded from: classes5.dex */
public abstract class a<E> extends b<E> {
    public long L;
    public long M;
    public long N;
    public long O;
    public long P;
    public long Q;
    public long R;
    public long S;
    public long T;
    public long U;
    public long V;
    public long W;
    public long X;
    public long Y;
    public long Z;

    /* renamed from: a0 */
    public long f2108a0;

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean isEmpty() {
        return e() == b();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        LinkedQueueNode<E> lvNext;
        LinkedQueueNode<E> e10 = e();
        LinkedQueueNode<E> b10 = b();
        int i10 = 0;
        while (e10 != b10 && i10 < Integer.MAX_VALUE) {
            do {
                lvNext = e10.lvNext();
            } while (lvNext == null);
            i10++;
            e10 = lvNext;
        }
        return i10;
    }
}
