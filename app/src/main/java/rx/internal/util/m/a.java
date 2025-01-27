package rx.internal.util.m;

import java.util.Iterator;
import rx.internal.util.atomic.LinkedQueueNode;

/* loaded from: classes5.dex */
abstract class a<E> extends b<E> {
    long K;
    long L;
    long M;
    long N;
    long O;
    long P;
    long Q;
    long R;
    long S;
    long T;
    long U;
    long V;
    long W;
    long X;
    long Y;
    long Z;

    a() {
    }

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
        LinkedQueueNode<E> e2 = e();
        LinkedQueueNode<E> b2 = b();
        int i2 = 0;
        while (e2 != b2 && i2 < Integer.MAX_VALUE) {
            do {
                lvNext = e2.lvNext();
            } while (lvNext == null);
            i2++;
            e2 = lvNext;
        }
        return i2;
    }
}
