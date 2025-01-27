package androidx.recyclerview.widget;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;

/* loaded from: classes.dex */
public class SortedList<T> {
    public static final int INVALID_POSITION = -1;

    /* renamed from: a */
    private static final int f3469a = 10;

    /* renamed from: b */
    private static final int f3470b = 10;

    /* renamed from: c */
    private static final int f3471c = 1;

    /* renamed from: d */
    private static final int f3472d = 2;

    /* renamed from: e */
    private static final int f3473e = 4;

    /* renamed from: f */
    T[] f3474f;

    /* renamed from: g */
    private T[] f3475g;

    /* renamed from: h */
    private int f3476h;

    /* renamed from: i */
    private int f3477i;

    /* renamed from: j */
    private int f3478j;
    private Callback k;
    private BatchedCallback l;
    private int m;
    private final Class<T> n;

    public static class BatchedCallback<T2> extends Callback<T2> {

        /* renamed from: a */
        final Callback<T2> f3479a;

        /* renamed from: b */
        private final BatchingListUpdateCallback f3480b;

        public BatchedCallback(Callback<T2> callback) {
            this.f3479a = callback;
            this.f3480b = new BatchingListUpdateCallback(callback);
        }

        @Override // androidx.recyclerview.widget.SortedList.Callback
        public boolean areContentsTheSame(T2 t2, T2 t22) {
            return this.f3479a.areContentsTheSame(t2, t22);
        }

        @Override // androidx.recyclerview.widget.SortedList.Callback
        public boolean areItemsTheSame(T2 t2, T2 t22) {
            return this.f3479a.areItemsTheSame(t2, t22);
        }

        @Override // androidx.recyclerview.widget.SortedList.Callback, java.util.Comparator
        public int compare(T2 t2, T2 t22) {
            return this.f3479a.compare(t2, t22);
        }

        public void dispatchLastEvent() {
            this.f3480b.dispatchLastEvent();
        }

        @Override // androidx.recyclerview.widget.SortedList.Callback
        @Nullable
        public Object getChangePayload(T2 t2, T2 t22) {
            return this.f3479a.getChangePayload(t2, t22);
        }

        @Override // androidx.recyclerview.widget.SortedList.Callback
        public void onChanged(int i2, int i3) {
            this.f3480b.onChanged(i2, i3, null);
        }

        @Override // androidx.recyclerview.widget.ListUpdateCallback
        public void onInserted(int i2, int i3) {
            this.f3480b.onInserted(i2, i3);
        }

        @Override // androidx.recyclerview.widget.ListUpdateCallback
        public void onMoved(int i2, int i3) {
            this.f3480b.onMoved(i2, i3);
        }

        @Override // androidx.recyclerview.widget.ListUpdateCallback
        public void onRemoved(int i2, int i3) {
            this.f3480b.onRemoved(i2, i3);
        }

        @Override // androidx.recyclerview.widget.SortedList.Callback, androidx.recyclerview.widget.ListUpdateCallback
        public void onChanged(int i2, int i3, Object obj) {
            this.f3480b.onChanged(i2, i3, obj);
        }
    }

    public static abstract class Callback<T2> implements Comparator<T2>, ListUpdateCallback {
        public abstract boolean areContentsTheSame(T2 t2, T2 t22);

        public abstract boolean areItemsTheSame(T2 t2, T2 t22);

        @Override // java.util.Comparator
        public abstract int compare(T2 t2, T2 t22);

        @Nullable
        public Object getChangePayload(T2 t2, T2 t22) {
            return null;
        }

        public abstract void onChanged(int i2, int i3);

        public void onChanged(int i2, int i3, Object obj) {
            onChanged(i2, i3);
        }
    }

    public SortedList(@NonNull Class<T> cls, @NonNull Callback<T> callback) {
        this(cls, callback, 10);
    }

    private int a(T t, boolean z) {
        int e2 = e(t, this.f3474f, 0, this.m, 1);
        if (e2 == -1) {
            e2 = 0;
        } else if (e2 < this.m) {
            T t2 = this.f3474f[e2];
            if (this.k.areItemsTheSame(t2, t)) {
                if (this.k.areContentsTheSame(t2, t)) {
                    this.f3474f[e2] = t;
                    return e2;
                }
                this.f3474f[e2] = t;
                Callback callback = this.k;
                callback.onChanged(e2, 1, callback.getChangePayload(t2, t));
                return e2;
            }
        }
        c(e2, t);
        if (z) {
            this.k.onInserted(e2, 1);
        }
        return e2;
    }

    private void b(T[] tArr) {
        if (tArr.length < 1) {
            return;
        }
        int n = n(tArr);
        if (this.m != 0) {
            h(tArr, n);
            return;
        }
        this.f3474f = tArr;
        this.m = n;
        this.k.onInserted(0, n);
    }

    private void c(int i2, T t) {
        int i3 = this.m;
        if (i2 > i3) {
            throw new IndexOutOfBoundsException("cannot add item to " + i2 + " because size is " + this.m);
        }
        T[] tArr = this.f3474f;
        if (i3 == tArr.length) {
            T[] tArr2 = (T[]) ((Object[]) Array.newInstance((Class<?>) this.n, tArr.length + 10));
            System.arraycopy(this.f3474f, 0, tArr2, 0, i2);
            tArr2[i2] = t;
            System.arraycopy(this.f3474f, i2, tArr2, i2 + 1, this.m - i2);
            this.f3474f = tArr2;
        } else {
            System.arraycopy(tArr, i2, tArr, i2 + 1, i3 - i2);
            this.f3474f[i2] = t;
        }
        this.m++;
    }

    private T[] d(T[] tArr) {
        T[] tArr2 = (T[]) ((Object[]) Array.newInstance((Class<?>) this.n, tArr.length));
        System.arraycopy(tArr, 0, tArr2, 0, tArr.length);
        return tArr2;
    }

    private int e(T t, T[] tArr, int i2, int i3, int i4) {
        while (i2 < i3) {
            int i5 = (i2 + i3) / 2;
            T t2 = tArr[i5];
            int compare = this.k.compare(t2, t);
            if (compare < 0) {
                i2 = i5 + 1;
            } else {
                if (compare == 0) {
                    if (this.k.areItemsTheSame(t2, t)) {
                        return i5;
                    }
                    int g2 = g(t, i5, i2, i3);
                    return (i4 == 1 && g2 == -1) ? i5 : g2;
                }
                i3 = i5;
            }
        }
        if (i4 == 1) {
            return i2;
        }
        return -1;
    }

    private int f(T t, T[] tArr, int i2, int i3) {
        while (i2 < i3) {
            if (this.k.areItemsTheSame(tArr[i2], t)) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    private int g(T t, int i2, int i3, int i4) {
        T t2;
        for (int i5 = i2 - 1; i5 >= i3; i5--) {
            T t3 = this.f3474f[i5];
            if (this.k.compare(t3, t) != 0) {
                break;
            }
            if (this.k.areItemsTheSame(t3, t)) {
                return i5;
            }
        }
        do {
            i2++;
            if (i2 >= i4) {
                return -1;
            }
            t2 = this.f3474f[i2];
            if (this.k.compare(t2, t) != 0) {
                return -1;
            }
        } while (!this.k.areItemsTheSame(t2, t));
        return i2;
    }

    private void h(T[] tArr, int i2) {
        boolean z = !(this.k instanceof BatchedCallback);
        if (z) {
            beginBatchedUpdates();
        }
        this.f3475g = this.f3474f;
        int i3 = 0;
        this.f3476h = 0;
        int i4 = this.m;
        this.f3477i = i4;
        this.f3474f = (T[]) ((Object[]) Array.newInstance((Class<?>) this.n, i4 + i2 + 10));
        this.f3478j = 0;
        while (true) {
            int i5 = this.f3476h;
            int i6 = this.f3477i;
            if (i5 >= i6 && i3 >= i2) {
                break;
            }
            if (i5 == i6) {
                int i7 = i2 - i3;
                System.arraycopy(tArr, i3, this.f3474f, this.f3478j, i7);
                int i8 = this.f3478j + i7;
                this.f3478j = i8;
                this.m += i7;
                this.k.onInserted(i8 - i7, i7);
                break;
            }
            if (i3 == i2) {
                int i9 = i6 - i5;
                System.arraycopy(this.f3475g, i5, this.f3474f, this.f3478j, i9);
                this.f3478j += i9;
                break;
            }
            T t = this.f3475g[i5];
            T t2 = tArr[i3];
            int compare = this.k.compare(t, t2);
            if (compare > 0) {
                T[] tArr2 = this.f3474f;
                int i10 = this.f3478j;
                int i11 = i10 + 1;
                this.f3478j = i11;
                tArr2[i10] = t2;
                this.m++;
                i3++;
                this.k.onInserted(i11 - 1, 1);
            } else if (compare == 0 && this.k.areItemsTheSame(t, t2)) {
                T[] tArr3 = this.f3474f;
                int i12 = this.f3478j;
                this.f3478j = i12 + 1;
                tArr3[i12] = t2;
                i3++;
                this.f3476h++;
                if (!this.k.areContentsTheSame(t, t2)) {
                    Callback callback = this.k;
                    callback.onChanged(this.f3478j - 1, 1, callback.getChangePayload(t, t2));
                }
            } else {
                T[] tArr4 = this.f3474f;
                int i13 = this.f3478j;
                this.f3478j = i13 + 1;
                tArr4[i13] = t;
                this.f3476h++;
            }
        }
        this.f3475g = null;
        if (z) {
            endBatchedUpdates();
        }
    }

    private boolean i(T t, boolean z) {
        int e2 = e(t, this.f3474f, 0, this.m, 2);
        if (e2 == -1) {
            return false;
        }
        j(e2, z);
        return true;
    }

    private void j(int i2, boolean z) {
        T[] tArr = this.f3474f;
        System.arraycopy(tArr, i2 + 1, tArr, i2, (this.m - i2) - 1);
        int i3 = this.m - 1;
        this.m = i3;
        this.f3474f[i3] = null;
        if (z) {
            this.k.onRemoved(i2, 1);
        }
    }

    private void k(T t) {
        T[] tArr = this.f3474f;
        int i2 = this.f3478j;
        tArr[i2] = t;
        int i3 = i2 + 1;
        this.f3478j = i3;
        this.m++;
        this.k.onInserted(i3 - 1, 1);
    }

    private void l(@NonNull T[] tArr) {
        boolean z = !(this.k instanceof BatchedCallback);
        if (z) {
            beginBatchedUpdates();
        }
        this.f3476h = 0;
        this.f3477i = this.m;
        this.f3475g = this.f3474f;
        this.f3478j = 0;
        int n = n(tArr);
        this.f3474f = (T[]) ((Object[]) Array.newInstance((Class<?>) this.n, n));
        while (true) {
            int i2 = this.f3478j;
            if (i2 >= n && this.f3476h >= this.f3477i) {
                break;
            }
            int i3 = this.f3476h;
            int i4 = this.f3477i;
            if (i3 >= i4) {
                int i5 = n - i2;
                System.arraycopy(tArr, i2, this.f3474f, i2, i5);
                this.f3478j += i5;
                this.m += i5;
                this.k.onInserted(i2, i5);
                break;
            }
            if (i2 >= n) {
                int i6 = i4 - i3;
                this.m -= i6;
                this.k.onRemoved(i2, i6);
                break;
            }
            T t = this.f3475g[i3];
            T t2 = tArr[i2];
            int compare = this.k.compare(t, t2);
            if (compare < 0) {
                m();
            } else if (compare > 0) {
                k(t2);
            } else if (this.k.areItemsTheSame(t, t2)) {
                T[] tArr2 = this.f3474f;
                int i7 = this.f3478j;
                tArr2[i7] = t2;
                this.f3476h++;
                this.f3478j = i7 + 1;
                if (!this.k.areContentsTheSame(t, t2)) {
                    Callback callback = this.k;
                    callback.onChanged(this.f3478j - 1, 1, callback.getChangePayload(t, t2));
                }
            } else {
                m();
                k(t2);
            }
        }
        this.f3475g = null;
        if (z) {
            endBatchedUpdates();
        }
    }

    private void m() {
        this.m--;
        this.f3476h++;
        this.k.onRemoved(this.f3478j, 1);
    }

    private int n(@NonNull T[] tArr) {
        if (tArr.length == 0) {
            return 0;
        }
        Arrays.sort(tArr, this.k);
        int i2 = 1;
        int i3 = 0;
        for (int i4 = 1; i4 < tArr.length; i4++) {
            T t = tArr[i4];
            if (this.k.compare(tArr[i3], t) == 0) {
                int f2 = f(t, tArr, i3, i2);
                if (f2 != -1) {
                    tArr[f2] = t;
                } else {
                    if (i2 != i4) {
                        tArr[i2] = t;
                    }
                    i2++;
                }
            } else {
                if (i2 != i4) {
                    tArr[i2] = t;
                }
                i3 = i2;
                i2++;
            }
        }
        return i2;
    }

    private void o() {
        if (this.f3475g != null) {
            throw new IllegalStateException("Data cannot be mutated in the middle of a batch update operation such as addAll or replaceAll.");
        }
    }

    public int add(T t) {
        o();
        return a(t, true);
    }

    public void addAll(@NonNull T[] tArr, boolean z) {
        o();
        if (tArr.length == 0) {
            return;
        }
        if (z) {
            b(tArr);
        } else {
            b(d(tArr));
        }
    }

    public void beginBatchedUpdates() {
        o();
        Callback callback = this.k;
        if (callback instanceof BatchedCallback) {
            return;
        }
        if (this.l == null) {
            this.l = new BatchedCallback(callback);
        }
        this.k = this.l;
    }

    public void clear() {
        o();
        int i2 = this.m;
        if (i2 == 0) {
            return;
        }
        Arrays.fill(this.f3474f, 0, i2, (Object) null);
        this.m = 0;
        this.k.onRemoved(0, i2);
    }

    public void endBatchedUpdates() {
        o();
        Callback callback = this.k;
        if (callback instanceof BatchedCallback) {
            ((BatchedCallback) callback).dispatchLastEvent();
        }
        Callback callback2 = this.k;
        BatchedCallback batchedCallback = this.l;
        if (callback2 == batchedCallback) {
            this.k = batchedCallback.f3479a;
        }
    }

    public T get(int i2) throws IndexOutOfBoundsException {
        int i3;
        if (i2 < this.m && i2 >= 0) {
            T[] tArr = this.f3475g;
            return (tArr == null || i2 < (i3 = this.f3478j)) ? this.f3474f[i2] : tArr[(i2 - i3) + this.f3476h];
        }
        throw new IndexOutOfBoundsException("Asked to get item at " + i2 + " but size is " + this.m);
    }

    public int indexOf(T t) {
        if (this.f3475g == null) {
            return e(t, this.f3474f, 0, this.m, 4);
        }
        int e2 = e(t, this.f3474f, 0, this.f3478j, 4);
        if (e2 != -1) {
            return e2;
        }
        int e3 = e(t, this.f3475g, this.f3476h, this.f3477i, 4);
        if (e3 != -1) {
            return (e3 - this.f3476h) + this.f3478j;
        }
        return -1;
    }

    public void recalculatePositionOfItemAt(int i2) {
        o();
        T t = get(i2);
        j(i2, false);
        int a2 = a(t, false);
        if (i2 != a2) {
            this.k.onMoved(i2, a2);
        }
    }

    public boolean remove(T t) {
        o();
        return i(t, true);
    }

    public T removeItemAt(int i2) {
        o();
        T t = get(i2);
        j(i2, true);
        return t;
    }

    public void replaceAll(@NonNull T[] tArr, boolean z) {
        o();
        if (z) {
            l(tArr);
        } else {
            l(d(tArr));
        }
    }

    public int size() {
        return this.m;
    }

    public void updateItemAt(int i2, T t) {
        o();
        T t2 = get(i2);
        boolean z = t2 == t || !this.k.areContentsTheSame(t2, t);
        if (t2 != t && this.k.compare(t2, t) == 0) {
            this.f3474f[i2] = t;
            if (z) {
                Callback callback = this.k;
                callback.onChanged(i2, 1, callback.getChangePayload(t2, t));
                return;
            }
            return;
        }
        if (z) {
            Callback callback2 = this.k;
            callback2.onChanged(i2, 1, callback2.getChangePayload(t2, t));
        }
        j(i2, false);
        int a2 = a(t, false);
        if (i2 != a2) {
            this.k.onMoved(i2, a2);
        }
    }

    public SortedList(@NonNull Class<T> cls, @NonNull Callback<T> callback, int i2) {
        this.n = cls;
        this.f3474f = (T[]) ((Object[]) Array.newInstance((Class<?>) cls, i2));
        this.k = callback;
        this.m = 0;
    }

    public void replaceAll(@NonNull T... tArr) {
        replaceAll(tArr, false);
    }

    public void addAll(@NonNull T... tArr) {
        addAll(tArr, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void replaceAll(@NonNull Collection<T> collection) {
        replaceAll(collection.toArray((Object[]) Array.newInstance((Class<?>) this.n, collection.size())), true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void addAll(@NonNull Collection<T> collection) {
        addAll(collection.toArray((Object[]) Array.newInstance((Class<?>) this.n, collection.size())), true);
    }
}
