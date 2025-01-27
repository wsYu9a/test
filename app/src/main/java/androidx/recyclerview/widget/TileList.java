package androidx.recyclerview.widget;

import android.util.SparseArray;
import java.lang.reflect.Array;

/* loaded from: classes.dex */
class TileList<T> {

    /* renamed from: a, reason: collision with root package name */
    final int f3526a;

    /* renamed from: b, reason: collision with root package name */
    private final SparseArray<Tile<T>> f3527b = new SparseArray<>(10);

    /* renamed from: c, reason: collision with root package name */
    Tile<T> f3528c;

    public static class Tile<T> {

        /* renamed from: a, reason: collision with root package name */
        Tile<T> f3529a;
        public int mItemCount;
        public final T[] mItems;
        public int mStartPosition;

        public Tile(Class<T> cls, int i2) {
            this.mItems = (T[]) ((Object[]) Array.newInstance((Class<?>) cls, i2));
        }

        boolean a(int i2) {
            int i3 = this.mStartPosition;
            return i3 <= i2 && i2 < i3 + this.mItemCount;
        }

        T b(int i2) {
            return this.mItems[i2 - this.mStartPosition];
        }
    }

    public TileList(int i2) {
        this.f3526a = i2;
    }

    public Tile<T> addOrReplace(Tile<T> tile) {
        int indexOfKey = this.f3527b.indexOfKey(tile.mStartPosition);
        if (indexOfKey < 0) {
            this.f3527b.put(tile.mStartPosition, tile);
            return null;
        }
        Tile<T> valueAt = this.f3527b.valueAt(indexOfKey);
        this.f3527b.setValueAt(indexOfKey, tile);
        if (this.f3528c == valueAt) {
            this.f3528c = tile;
        }
        return valueAt;
    }

    public void clear() {
        this.f3527b.clear();
    }

    public Tile<T> getAtIndex(int i2) {
        return this.f3527b.valueAt(i2);
    }

    public T getItemAt(int i2) {
        Tile<T> tile = this.f3528c;
        if (tile == null || !tile.a(i2)) {
            int indexOfKey = this.f3527b.indexOfKey(i2 - (i2 % this.f3526a));
            if (indexOfKey < 0) {
                return null;
            }
            this.f3528c = this.f3527b.valueAt(indexOfKey);
        }
        return this.f3528c.b(i2);
    }

    public Tile<T> removeAtPos(int i2) {
        Tile<T> tile = this.f3527b.get(i2);
        if (this.f3528c == tile) {
            this.f3528c = null;
        }
        this.f3527b.delete(i2);
        return tile;
    }

    public int size() {
        return this.f3527b.size();
    }
}
