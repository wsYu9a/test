package androidx.recyclerview.widget;

import android.util.Log;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import androidx.annotation.WorkerThread;
import androidx.recyclerview.widget.ThreadUtil;
import androidx.recyclerview.widget.TileList;

/* loaded from: classes.dex */
public class AsyncListUtil<T> {

    /* renamed from: a */
    static final String f3163a = "AsyncListUtil";

    /* renamed from: b */
    static final boolean f3164b = false;

    /* renamed from: c */
    final Class<T> f3165c;

    /* renamed from: d */
    final int f3166d;

    /* renamed from: e */
    final DataCallback<T> f3167e;

    /* renamed from: f */
    final ViewCallback f3168f;

    /* renamed from: g */
    final TileList<T> f3169g;

    /* renamed from: h */
    final ThreadUtil.MainThreadCallback<T> f3170h;

    /* renamed from: i */
    final ThreadUtil.BackgroundCallback<T> f3171i;
    boolean m;
    private final ThreadUtil.MainThreadCallback<T> s;
    private final ThreadUtil.BackgroundCallback<T> t;

    /* renamed from: j */
    final int[] f3172j = new int[2];
    final int[] k = new int[2];
    final int[] l = new int[2];
    private int n = 0;
    int o = 0;
    int p = 0;
    int q = 0;
    final SparseIntArray r = new SparseIntArray();

    /* renamed from: androidx.recyclerview.widget.AsyncListUtil$1 */
    class AnonymousClass1 implements ThreadUtil.MainThreadCallback<T> {
        AnonymousClass1() {
        }

        private boolean a(int i2) {
            return i2 == AsyncListUtil.this.q;
        }

        private void b() {
            for (int i2 = 0; i2 < AsyncListUtil.this.f3169g.size(); i2++) {
                AsyncListUtil asyncListUtil = AsyncListUtil.this;
                asyncListUtil.f3171i.recycleTile(asyncListUtil.f3169g.getAtIndex(i2));
            }
            AsyncListUtil.this.f3169g.clear();
        }

        @Override // androidx.recyclerview.widget.ThreadUtil.MainThreadCallback
        public void addTile(int i2, TileList.Tile<T> tile) {
            if (!a(i2)) {
                AsyncListUtil.this.f3171i.recycleTile(tile);
                return;
            }
            TileList.Tile<T> addOrReplace = AsyncListUtil.this.f3169g.addOrReplace(tile);
            if (addOrReplace != null) {
                Log.e(AsyncListUtil.f3163a, "duplicate tile @" + addOrReplace.mStartPosition);
                AsyncListUtil.this.f3171i.recycleTile(addOrReplace);
            }
            int i3 = tile.mStartPosition + tile.mItemCount;
            int i4 = 0;
            while (i4 < AsyncListUtil.this.r.size()) {
                int keyAt = AsyncListUtil.this.r.keyAt(i4);
                if (tile.mStartPosition > keyAt || keyAt >= i3) {
                    i4++;
                } else {
                    AsyncListUtil.this.r.removeAt(i4);
                    AsyncListUtil.this.f3168f.onItemLoaded(keyAt);
                }
            }
        }

        @Override // androidx.recyclerview.widget.ThreadUtil.MainThreadCallback
        public void removeTile(int i2, int i3) {
            if (a(i2)) {
                TileList.Tile<T> removeAtPos = AsyncListUtil.this.f3169g.removeAtPos(i3);
                if (removeAtPos != null) {
                    AsyncListUtil.this.f3171i.recycleTile(removeAtPos);
                    return;
                }
                Log.e(AsyncListUtil.f3163a, "tile not found @" + i3);
            }
        }

        @Override // androidx.recyclerview.widget.ThreadUtil.MainThreadCallback
        public void updateItemCount(int i2, int i3) {
            if (a(i2)) {
                AsyncListUtil asyncListUtil = AsyncListUtil.this;
                asyncListUtil.o = i3;
                asyncListUtil.f3168f.onDataRefresh();
                AsyncListUtil asyncListUtil2 = AsyncListUtil.this;
                asyncListUtil2.p = asyncListUtil2.q;
                b();
                AsyncListUtil asyncListUtil3 = AsyncListUtil.this;
                asyncListUtil3.m = false;
                asyncListUtil3.c();
            }
        }
    }

    /* renamed from: androidx.recyclerview.widget.AsyncListUtil$2 */
    class AnonymousClass2 implements ThreadUtil.BackgroundCallback<T> {

        /* renamed from: a */
        private TileList.Tile<T> f3174a;

        /* renamed from: b */
        final SparseBooleanArray f3175b = new SparseBooleanArray();

        /* renamed from: c */
        private int f3176c;

        /* renamed from: d */
        private int f3177d;

        /* renamed from: e */
        private int f3178e;

        /* renamed from: f */
        private int f3179f;

        AnonymousClass2() {
        }

        private TileList.Tile<T> a() {
            TileList.Tile<T> tile = this.f3174a;
            if (tile != null) {
                this.f3174a = tile.f3529a;
                return tile;
            }
            AsyncListUtil asyncListUtil = AsyncListUtil.this;
            return new TileList.Tile<>(asyncListUtil.f3165c, asyncListUtil.f3166d);
        }

        private void b(TileList.Tile<T> tile) {
            this.f3175b.put(tile.mStartPosition, true);
            AsyncListUtil.this.f3170h.addTile(this.f3176c, tile);
        }

        private void c(int i2) {
            int maxCachedTiles = AsyncListUtil.this.f3167e.getMaxCachedTiles();
            while (this.f3175b.size() >= maxCachedTiles) {
                int keyAt = this.f3175b.keyAt(0);
                SparseBooleanArray sparseBooleanArray = this.f3175b;
                int keyAt2 = sparseBooleanArray.keyAt(sparseBooleanArray.size() - 1);
                int i3 = this.f3178e - keyAt;
                int i4 = keyAt2 - this.f3179f;
                if (i3 > 0 && (i3 >= i4 || i2 == 2)) {
                    g(keyAt);
                } else {
                    if (i4 <= 0) {
                        return;
                    }
                    if (i3 >= i4 && i2 != 1) {
                        return;
                    } else {
                        g(keyAt2);
                    }
                }
            }
        }

        private int d(int i2) {
            return i2 - (i2 % AsyncListUtil.this.f3166d);
        }

        private boolean e(int i2) {
            return this.f3175b.get(i2);
        }

        private void f(String str, Object... objArr) {
            Log.d(AsyncListUtil.f3163a, "[BKGR] " + String.format(str, objArr));
        }

        private void g(int i2) {
            this.f3175b.delete(i2);
            AsyncListUtil.this.f3170h.removeTile(this.f3176c, i2);
        }

        private void h(int i2, int i3, int i4, boolean z) {
            int i5 = i2;
            while (i5 <= i3) {
                AsyncListUtil.this.f3171i.loadTile(z ? (i3 + i2) - i5 : i5, i4);
                i5 += AsyncListUtil.this.f3166d;
            }
        }

        @Override // androidx.recyclerview.widget.ThreadUtil.BackgroundCallback
        public void loadTile(int i2, int i3) {
            if (e(i2)) {
                return;
            }
            TileList.Tile<T> a2 = a();
            a2.mStartPosition = i2;
            int min = Math.min(AsyncListUtil.this.f3166d, this.f3177d - i2);
            a2.mItemCount = min;
            AsyncListUtil.this.f3167e.fillData(a2.mItems, a2.mStartPosition, min);
            c(i3);
            b(a2);
        }

        @Override // androidx.recyclerview.widget.ThreadUtil.BackgroundCallback
        public void recycleTile(TileList.Tile<T> tile) {
            AsyncListUtil.this.f3167e.recycleData(tile.mItems, tile.mItemCount);
            tile.f3529a = this.f3174a;
            this.f3174a = tile;
        }

        @Override // androidx.recyclerview.widget.ThreadUtil.BackgroundCallback
        public void refresh(int i2) {
            this.f3176c = i2;
            this.f3175b.clear();
            int refreshData = AsyncListUtil.this.f3167e.refreshData();
            this.f3177d = refreshData;
            AsyncListUtil.this.f3170h.updateItemCount(this.f3176c, refreshData);
        }

        @Override // androidx.recyclerview.widget.ThreadUtil.BackgroundCallback
        public void updateRange(int i2, int i3, int i4, int i5, int i6) {
            if (i2 > i3) {
                return;
            }
            int d2 = d(i2);
            int d3 = d(i3);
            this.f3178e = d(i4);
            int d4 = d(i5);
            this.f3179f = d4;
            if (i6 == 1) {
                h(this.f3178e, d3, i6, true);
                h(d3 + AsyncListUtil.this.f3166d, this.f3179f, i6, false);
            } else {
                h(d2, d4, i6, false);
                h(this.f3178e, d2 - AsyncListUtil.this.f3166d, i6, true);
            }
        }
    }

    public static abstract class DataCallback<T> {
        @WorkerThread
        public abstract void fillData(@NonNull T[] tArr, int i2, int i3);

        @WorkerThread
        public int getMaxCachedTiles() {
            return 10;
        }

        @WorkerThread
        public void recycleData(@NonNull T[] tArr, int i2) {
        }

        @WorkerThread
        public abstract int refreshData();
    }

    public static abstract class ViewCallback {
        public static final int HINT_SCROLL_ASC = 2;
        public static final int HINT_SCROLL_DESC = 1;
        public static final int HINT_SCROLL_NONE = 0;

        @UiThread
        public void extendRangeInto(@NonNull int[] iArr, @NonNull int[] iArr2, int i2) {
            int i3 = (iArr[1] - iArr[0]) + 1;
            int i4 = i3 / 2;
            iArr2[0] = iArr[0] - (i2 == 1 ? i3 : i4);
            int i5 = iArr[1];
            if (i2 != 2) {
                i3 = i4;
            }
            iArr2[1] = i5 + i3;
        }

        @UiThread
        public abstract void getItemRangeInto(@NonNull int[] iArr);

        @UiThread
        public abstract void onDataRefresh();

        @UiThread
        public abstract void onItemLoaded(int i2);
    }

    public AsyncListUtil(@NonNull Class<T> cls, int i2, @NonNull DataCallback<T> dataCallback, @NonNull ViewCallback viewCallback) {
        AnonymousClass1 anonymousClass1 = new ThreadUtil.MainThreadCallback<T>() { // from class: androidx.recyclerview.widget.AsyncListUtil.1
            AnonymousClass1() {
            }

            private boolean a(int i22) {
                return i22 == AsyncListUtil.this.q;
            }

            private void b() {
                for (int i22 = 0; i22 < AsyncListUtil.this.f3169g.size(); i22++) {
                    AsyncListUtil asyncListUtil = AsyncListUtil.this;
                    asyncListUtil.f3171i.recycleTile(asyncListUtil.f3169g.getAtIndex(i22));
                }
                AsyncListUtil.this.f3169g.clear();
            }

            @Override // androidx.recyclerview.widget.ThreadUtil.MainThreadCallback
            public void addTile(int i22, TileList.Tile<T> tile) {
                if (!a(i22)) {
                    AsyncListUtil.this.f3171i.recycleTile(tile);
                    return;
                }
                TileList.Tile<T> addOrReplace = AsyncListUtil.this.f3169g.addOrReplace(tile);
                if (addOrReplace != null) {
                    Log.e(AsyncListUtil.f3163a, "duplicate tile @" + addOrReplace.mStartPosition);
                    AsyncListUtil.this.f3171i.recycleTile(addOrReplace);
                }
                int i3 = tile.mStartPosition + tile.mItemCount;
                int i4 = 0;
                while (i4 < AsyncListUtil.this.r.size()) {
                    int keyAt = AsyncListUtil.this.r.keyAt(i4);
                    if (tile.mStartPosition > keyAt || keyAt >= i3) {
                        i4++;
                    } else {
                        AsyncListUtil.this.r.removeAt(i4);
                        AsyncListUtil.this.f3168f.onItemLoaded(keyAt);
                    }
                }
            }

            @Override // androidx.recyclerview.widget.ThreadUtil.MainThreadCallback
            public void removeTile(int i22, int i3) {
                if (a(i22)) {
                    TileList.Tile<T> removeAtPos = AsyncListUtil.this.f3169g.removeAtPos(i3);
                    if (removeAtPos != null) {
                        AsyncListUtil.this.f3171i.recycleTile(removeAtPos);
                        return;
                    }
                    Log.e(AsyncListUtil.f3163a, "tile not found @" + i3);
                }
            }

            @Override // androidx.recyclerview.widget.ThreadUtil.MainThreadCallback
            public void updateItemCount(int i22, int i3) {
                if (a(i22)) {
                    AsyncListUtil asyncListUtil = AsyncListUtil.this;
                    asyncListUtil.o = i3;
                    asyncListUtil.f3168f.onDataRefresh();
                    AsyncListUtil asyncListUtil2 = AsyncListUtil.this;
                    asyncListUtil2.p = asyncListUtil2.q;
                    b();
                    AsyncListUtil asyncListUtil3 = AsyncListUtil.this;
                    asyncListUtil3.m = false;
                    asyncListUtil3.c();
                }
            }
        };
        this.s = anonymousClass1;
        AnonymousClass2 anonymousClass2 = new ThreadUtil.BackgroundCallback<T>() { // from class: androidx.recyclerview.widget.AsyncListUtil.2

            /* renamed from: a */
            private TileList.Tile<T> f3174a;

            /* renamed from: b */
            final SparseBooleanArray f3175b = new SparseBooleanArray();

            /* renamed from: c */
            private int f3176c;

            /* renamed from: d */
            private int f3177d;

            /* renamed from: e */
            private int f3178e;

            /* renamed from: f */
            private int f3179f;

            AnonymousClass2() {
            }

            private TileList.Tile<T> a() {
                TileList.Tile<T> tile = this.f3174a;
                if (tile != null) {
                    this.f3174a = tile.f3529a;
                    return tile;
                }
                AsyncListUtil asyncListUtil = AsyncListUtil.this;
                return new TileList.Tile<>(asyncListUtil.f3165c, asyncListUtil.f3166d);
            }

            private void b(TileList.Tile<T> tile) {
                this.f3175b.put(tile.mStartPosition, true);
                AsyncListUtil.this.f3170h.addTile(this.f3176c, tile);
            }

            private void c(int i22) {
                int maxCachedTiles = AsyncListUtil.this.f3167e.getMaxCachedTiles();
                while (this.f3175b.size() >= maxCachedTiles) {
                    int keyAt = this.f3175b.keyAt(0);
                    SparseBooleanArray sparseBooleanArray = this.f3175b;
                    int keyAt2 = sparseBooleanArray.keyAt(sparseBooleanArray.size() - 1);
                    int i3 = this.f3178e - keyAt;
                    int i4 = keyAt2 - this.f3179f;
                    if (i3 > 0 && (i3 >= i4 || i22 == 2)) {
                        g(keyAt);
                    } else {
                        if (i4 <= 0) {
                            return;
                        }
                        if (i3 >= i4 && i22 != 1) {
                            return;
                        } else {
                            g(keyAt2);
                        }
                    }
                }
            }

            private int d(int i22) {
                return i22 - (i22 % AsyncListUtil.this.f3166d);
            }

            private boolean e(int i22) {
                return this.f3175b.get(i22);
            }

            private void f(String str, Object... objArr) {
                Log.d(AsyncListUtil.f3163a, "[BKGR] " + String.format(str, objArr));
            }

            private void g(int i22) {
                this.f3175b.delete(i22);
                AsyncListUtil.this.f3170h.removeTile(this.f3176c, i22);
            }

            private void h(int i22, int i3, int i4, boolean z) {
                int i5 = i22;
                while (i5 <= i3) {
                    AsyncListUtil.this.f3171i.loadTile(z ? (i3 + i22) - i5 : i5, i4);
                    i5 += AsyncListUtil.this.f3166d;
                }
            }

            @Override // androidx.recyclerview.widget.ThreadUtil.BackgroundCallback
            public void loadTile(int i22, int i3) {
                if (e(i22)) {
                    return;
                }
                TileList.Tile<T> a2 = a();
                a2.mStartPosition = i22;
                int min = Math.min(AsyncListUtil.this.f3166d, this.f3177d - i22);
                a2.mItemCount = min;
                AsyncListUtil.this.f3167e.fillData(a2.mItems, a2.mStartPosition, min);
                c(i3);
                b(a2);
            }

            @Override // androidx.recyclerview.widget.ThreadUtil.BackgroundCallback
            public void recycleTile(TileList.Tile<T> tile) {
                AsyncListUtil.this.f3167e.recycleData(tile.mItems, tile.mItemCount);
                tile.f3529a = this.f3174a;
                this.f3174a = tile;
            }

            @Override // androidx.recyclerview.widget.ThreadUtil.BackgroundCallback
            public void refresh(int i22) {
                this.f3176c = i22;
                this.f3175b.clear();
                int refreshData = AsyncListUtil.this.f3167e.refreshData();
                this.f3177d = refreshData;
                AsyncListUtil.this.f3170h.updateItemCount(this.f3176c, refreshData);
            }

            @Override // androidx.recyclerview.widget.ThreadUtil.BackgroundCallback
            public void updateRange(int i22, int i3, int i4, int i5, int i6) {
                if (i22 > i3) {
                    return;
                }
                int d2 = d(i22);
                int d3 = d(i3);
                this.f3178e = d(i4);
                int d4 = d(i5);
                this.f3179f = d4;
                if (i6 == 1) {
                    h(this.f3178e, d3, i6, true);
                    h(d3 + AsyncListUtil.this.f3166d, this.f3179f, i6, false);
                } else {
                    h(d2, d4, i6, false);
                    h(this.f3178e, d2 - AsyncListUtil.this.f3166d, i6, true);
                }
            }
        };
        this.t = anonymousClass2;
        this.f3165c = cls;
        this.f3166d = i2;
        this.f3167e = dataCallback;
        this.f3168f = viewCallback;
        this.f3169g = new TileList<>(i2);
        MessageThreadUtil messageThreadUtil = new MessageThreadUtil();
        this.f3170h = messageThreadUtil.getMainThreadProxy(anonymousClass1);
        this.f3171i = messageThreadUtil.getBackgroundProxy(anonymousClass2);
        refresh();
    }

    private boolean a() {
        return this.q != this.p;
    }

    void b(String str, Object... objArr) {
        Log.d(f3163a, "[MAIN] " + String.format(str, objArr));
    }

    void c() {
        this.f3168f.getItemRangeInto(this.f3172j);
        int[] iArr = this.f3172j;
        if (iArr[0] > iArr[1] || iArr[0] < 0 || iArr[1] >= this.o) {
            return;
        }
        if (this.m) {
            int i2 = iArr[0];
            int[] iArr2 = this.k;
            if (i2 > iArr2[1] || iArr2[0] > iArr[1]) {
                this.n = 0;
            } else if (iArr[0] < iArr2[0]) {
                this.n = 1;
            } else if (iArr[0] > iArr2[0]) {
                this.n = 2;
            }
        } else {
            this.n = 0;
        }
        int[] iArr3 = this.k;
        iArr3[0] = iArr[0];
        iArr3[1] = iArr[1];
        this.f3168f.extendRangeInto(iArr, this.l, this.n);
        int[] iArr4 = this.l;
        iArr4[0] = Math.min(this.f3172j[0], Math.max(iArr4[0], 0));
        int[] iArr5 = this.l;
        iArr5[1] = Math.max(this.f3172j[1], Math.min(iArr5[1], this.o - 1));
        ThreadUtil.BackgroundCallback<T> backgroundCallback = this.f3171i;
        int[] iArr6 = this.f3172j;
        int i3 = iArr6[0];
        int i4 = iArr6[1];
        int[] iArr7 = this.l;
        backgroundCallback.updateRange(i3, i4, iArr7[0], iArr7[1], this.n);
    }

    @Nullable
    public T getItem(int i2) {
        if (i2 < 0 || i2 >= this.o) {
            throw new IndexOutOfBoundsException(i2 + " is not within 0 and " + this.o);
        }
        T itemAt = this.f3169g.getItemAt(i2);
        if (itemAt == null && !a()) {
            this.r.put(i2, 0);
        }
        return itemAt;
    }

    public int getItemCount() {
        return this.o;
    }

    public void onRangeChanged() {
        if (a()) {
            return;
        }
        c();
        this.m = true;
    }

    public void refresh() {
        this.r.clear();
        ThreadUtil.BackgroundCallback<T> backgroundCallback = this.f3171i;
        int i2 = this.q + 1;
        this.q = i2;
        backgroundCallback.refresh(i2);
    }
}
