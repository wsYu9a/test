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
    static final boolean DEBUG = false;
    static final String TAG = "AsyncListUtil";
    boolean mAllowScrollHints;
    private final ThreadUtil.BackgroundCallback<T> mBackgroundCallback;
    final ThreadUtil.BackgroundCallback<T> mBackgroundProxy;
    final DataCallback<T> mDataCallback;
    private final ThreadUtil.MainThreadCallback<T> mMainThreadCallback;
    final ThreadUtil.MainThreadCallback<T> mMainThreadProxy;
    final Class<T> mTClass;
    final TileList<T> mTileList;
    final int mTileSize;
    final ViewCallback mViewCallback;
    final int[] mTmpRange = new int[2];
    final int[] mPrevRange = new int[2];
    final int[] mTmpRangeExtended = new int[2];
    private int mScrollHint = 0;
    int mItemCount = 0;
    int mDisplayedGeneration = 0;
    int mRequestedGeneration = 0;
    final SparseIntArray mMissingPositions = new SparseIntArray();

    /* renamed from: androidx.recyclerview.widget.AsyncListUtil$1 */
    public class AnonymousClass1 implements ThreadUtil.MainThreadCallback<T> {
        public AnonymousClass1() {
        }

        private boolean isRequestedGeneration(int i10) {
            return i10 == AsyncListUtil.this.mRequestedGeneration;
        }

        private void recycleAllTiles() {
            for (int i10 = 0; i10 < AsyncListUtil.this.mTileList.size(); i10++) {
                AsyncListUtil asyncListUtil = AsyncListUtil.this;
                asyncListUtil.mBackgroundProxy.recycleTile(asyncListUtil.mTileList.getAtIndex(i10));
            }
            AsyncListUtil.this.mTileList.clear();
        }

        @Override // androidx.recyclerview.widget.ThreadUtil.MainThreadCallback
        public void addTile(int i10, TileList.Tile<T> tile) {
            if (!isRequestedGeneration(i10)) {
                AsyncListUtil.this.mBackgroundProxy.recycleTile(tile);
                return;
            }
            TileList.Tile<T> addOrReplace = AsyncListUtil.this.mTileList.addOrReplace(tile);
            if (addOrReplace != null) {
                Log.e(AsyncListUtil.TAG, "duplicate tile @" + addOrReplace.mStartPosition);
                AsyncListUtil.this.mBackgroundProxy.recycleTile(addOrReplace);
            }
            int i11 = tile.mStartPosition + tile.mItemCount;
            int i12 = 0;
            while (i12 < AsyncListUtil.this.mMissingPositions.size()) {
                int keyAt = AsyncListUtil.this.mMissingPositions.keyAt(i12);
                if (tile.mStartPosition > keyAt || keyAt >= i11) {
                    i12++;
                } else {
                    AsyncListUtil.this.mMissingPositions.removeAt(i12);
                    AsyncListUtil.this.mViewCallback.onItemLoaded(keyAt);
                }
            }
        }

        @Override // androidx.recyclerview.widget.ThreadUtil.MainThreadCallback
        public void removeTile(int i10, int i11) {
            if (isRequestedGeneration(i10)) {
                TileList.Tile<T> removeAtPos = AsyncListUtil.this.mTileList.removeAtPos(i11);
                if (removeAtPos != null) {
                    AsyncListUtil.this.mBackgroundProxy.recycleTile(removeAtPos);
                    return;
                }
                Log.e(AsyncListUtil.TAG, "tile not found @" + i11);
            }
        }

        @Override // androidx.recyclerview.widget.ThreadUtil.MainThreadCallback
        public void updateItemCount(int i10, int i11) {
            if (isRequestedGeneration(i10)) {
                AsyncListUtil asyncListUtil = AsyncListUtil.this;
                asyncListUtil.mItemCount = i11;
                asyncListUtil.mViewCallback.onDataRefresh();
                AsyncListUtil asyncListUtil2 = AsyncListUtil.this;
                asyncListUtil2.mDisplayedGeneration = asyncListUtil2.mRequestedGeneration;
                recycleAllTiles();
                AsyncListUtil asyncListUtil3 = AsyncListUtil.this;
                asyncListUtil3.mAllowScrollHints = false;
                asyncListUtil3.updateRange();
            }
        }
    }

    /* renamed from: androidx.recyclerview.widget.AsyncListUtil$2 */
    public class AnonymousClass2 implements ThreadUtil.BackgroundCallback<T> {
        private int mFirstRequiredTileStart;
        private int mGeneration;
        private int mItemCount;
        private int mLastRequiredTileStart;
        final SparseBooleanArray mLoadedTiles = new SparseBooleanArray();
        private TileList.Tile<T> mRecycledRoot;

        public AnonymousClass2() {
        }

        private TileList.Tile<T> acquireTile() {
            TileList.Tile<T> tile = this.mRecycledRoot;
            if (tile != null) {
                this.mRecycledRoot = tile.mNext;
                return tile;
            }
            AsyncListUtil asyncListUtil = AsyncListUtil.this;
            return new TileList.Tile<>(asyncListUtil.mTClass, asyncListUtil.mTileSize);
        }

        private void addTile(TileList.Tile<T> tile) {
            this.mLoadedTiles.put(tile.mStartPosition, true);
            AsyncListUtil.this.mMainThreadProxy.addTile(this.mGeneration, tile);
        }

        private void flushTileCache(int i10) {
            int maxCachedTiles = AsyncListUtil.this.mDataCallback.getMaxCachedTiles();
            while (this.mLoadedTiles.size() >= maxCachedTiles) {
                int keyAt = this.mLoadedTiles.keyAt(0);
                SparseBooleanArray sparseBooleanArray = this.mLoadedTiles;
                int keyAt2 = sparseBooleanArray.keyAt(sparseBooleanArray.size() - 1);
                int i11 = this.mFirstRequiredTileStart - keyAt;
                int i12 = keyAt2 - this.mLastRequiredTileStart;
                if (i11 > 0 && (i11 >= i12 || i10 == 2)) {
                    removeTile(keyAt);
                } else {
                    if (i12 <= 0) {
                        return;
                    }
                    if (i11 >= i12 && i10 != 1) {
                        return;
                    } else {
                        removeTile(keyAt2);
                    }
                }
            }
        }

        private int getTileStart(int i10) {
            return i10 - (i10 % AsyncListUtil.this.mTileSize);
        }

        private boolean isTileLoaded(int i10) {
            return this.mLoadedTiles.get(i10);
        }

        private void log(String str, Object... objArr) {
            Log.d(AsyncListUtil.TAG, "[BKGR] " + String.format(str, objArr));
        }

        private void removeTile(int i10) {
            this.mLoadedTiles.delete(i10);
            AsyncListUtil.this.mMainThreadProxy.removeTile(this.mGeneration, i10);
        }

        private void requestTiles(int i10, int i11, int i12, boolean z10) {
            int i13 = i10;
            while (i13 <= i11) {
                AsyncListUtil.this.mBackgroundProxy.loadTile(z10 ? (i11 + i10) - i13 : i13, i12);
                i13 += AsyncListUtil.this.mTileSize;
            }
        }

        @Override // androidx.recyclerview.widget.ThreadUtil.BackgroundCallback
        public void loadTile(int i10, int i11) {
            if (isTileLoaded(i10)) {
                return;
            }
            TileList.Tile<T> acquireTile = acquireTile();
            acquireTile.mStartPosition = i10;
            int min = Math.min(AsyncListUtil.this.mTileSize, this.mItemCount - i10);
            acquireTile.mItemCount = min;
            AsyncListUtil.this.mDataCallback.fillData(acquireTile.mItems, acquireTile.mStartPosition, min);
            flushTileCache(i11);
            addTile(acquireTile);
        }

        @Override // androidx.recyclerview.widget.ThreadUtil.BackgroundCallback
        public void recycleTile(TileList.Tile<T> tile) {
            AsyncListUtil.this.mDataCallback.recycleData(tile.mItems, tile.mItemCount);
            tile.mNext = this.mRecycledRoot;
            this.mRecycledRoot = tile;
        }

        @Override // androidx.recyclerview.widget.ThreadUtil.BackgroundCallback
        public void refresh(int i10) {
            this.mGeneration = i10;
            this.mLoadedTiles.clear();
            int refreshData = AsyncListUtil.this.mDataCallback.refreshData();
            this.mItemCount = refreshData;
            AsyncListUtil.this.mMainThreadProxy.updateItemCount(this.mGeneration, refreshData);
        }

        @Override // androidx.recyclerview.widget.ThreadUtil.BackgroundCallback
        public void updateRange(int i10, int i11, int i12, int i13, int i14) {
            if (i10 > i11) {
                return;
            }
            int tileStart = getTileStart(i10);
            int tileStart2 = getTileStart(i11);
            this.mFirstRequiredTileStart = getTileStart(i12);
            int tileStart3 = getTileStart(i13);
            this.mLastRequiredTileStart = tileStart3;
            if (i14 == 1) {
                requestTiles(this.mFirstRequiredTileStart, tileStart2, i14, true);
                requestTiles(tileStart2 + AsyncListUtil.this.mTileSize, this.mLastRequiredTileStart, i14, false);
            } else {
                requestTiles(tileStart, tileStart3, i14, false);
                requestTiles(this.mFirstRequiredTileStart, tileStart - AsyncListUtil.this.mTileSize, i14, true);
            }
        }
    }

    public static abstract class DataCallback<T> {
        @WorkerThread
        public abstract void fillData(@NonNull T[] tArr, int i10, int i11);

        @WorkerThread
        public int getMaxCachedTiles() {
            return 10;
        }

        @WorkerThread
        public void recycleData(@NonNull T[] tArr, int i10) {
        }

        @WorkerThread
        public abstract int refreshData();
    }

    public static abstract class ViewCallback {
        public static final int HINT_SCROLL_ASC = 2;
        public static final int HINT_SCROLL_DESC = 1;
        public static final int HINT_SCROLL_NONE = 0;

        @UiThread
        public void extendRangeInto(@NonNull int[] iArr, @NonNull int[] iArr2, int i10) {
            int i11 = iArr[1];
            int i12 = iArr[0];
            int i13 = (i11 - i12) + 1;
            int i14 = i13 / 2;
            iArr2[0] = i12 - (i10 == 1 ? i13 : i14);
            if (i10 != 2) {
                i13 = i14;
            }
            iArr2[1] = i11 + i13;
        }

        @UiThread
        public abstract void getItemRangeInto(@NonNull int[] iArr);

        @UiThread
        public abstract void onDataRefresh();

        @UiThread
        public abstract void onItemLoaded(int i10);
    }

    public AsyncListUtil(@NonNull Class<T> cls, int i10, @NonNull DataCallback<T> dataCallback, @NonNull ViewCallback viewCallback) {
        AnonymousClass1 anonymousClass1 = new ThreadUtil.MainThreadCallback<T>() { // from class: androidx.recyclerview.widget.AsyncListUtil.1
            public AnonymousClass1() {
            }

            private boolean isRequestedGeneration(int i102) {
                return i102 == AsyncListUtil.this.mRequestedGeneration;
            }

            private void recycleAllTiles() {
                for (int i102 = 0; i102 < AsyncListUtil.this.mTileList.size(); i102++) {
                    AsyncListUtil asyncListUtil = AsyncListUtil.this;
                    asyncListUtil.mBackgroundProxy.recycleTile(asyncListUtil.mTileList.getAtIndex(i102));
                }
                AsyncListUtil.this.mTileList.clear();
            }

            @Override // androidx.recyclerview.widget.ThreadUtil.MainThreadCallback
            public void addTile(int i102, TileList.Tile<T> tile) {
                if (!isRequestedGeneration(i102)) {
                    AsyncListUtil.this.mBackgroundProxy.recycleTile(tile);
                    return;
                }
                TileList.Tile<T> addOrReplace = AsyncListUtil.this.mTileList.addOrReplace(tile);
                if (addOrReplace != null) {
                    Log.e(AsyncListUtil.TAG, "duplicate tile @" + addOrReplace.mStartPosition);
                    AsyncListUtil.this.mBackgroundProxy.recycleTile(addOrReplace);
                }
                int i11 = tile.mStartPosition + tile.mItemCount;
                int i12 = 0;
                while (i12 < AsyncListUtil.this.mMissingPositions.size()) {
                    int keyAt = AsyncListUtil.this.mMissingPositions.keyAt(i12);
                    if (tile.mStartPosition > keyAt || keyAt >= i11) {
                        i12++;
                    } else {
                        AsyncListUtil.this.mMissingPositions.removeAt(i12);
                        AsyncListUtil.this.mViewCallback.onItemLoaded(keyAt);
                    }
                }
            }

            @Override // androidx.recyclerview.widget.ThreadUtil.MainThreadCallback
            public void removeTile(int i102, int i11) {
                if (isRequestedGeneration(i102)) {
                    TileList.Tile<T> removeAtPos = AsyncListUtil.this.mTileList.removeAtPos(i11);
                    if (removeAtPos != null) {
                        AsyncListUtil.this.mBackgroundProxy.recycleTile(removeAtPos);
                        return;
                    }
                    Log.e(AsyncListUtil.TAG, "tile not found @" + i11);
                }
            }

            @Override // androidx.recyclerview.widget.ThreadUtil.MainThreadCallback
            public void updateItemCount(int i102, int i11) {
                if (isRequestedGeneration(i102)) {
                    AsyncListUtil asyncListUtil = AsyncListUtil.this;
                    asyncListUtil.mItemCount = i11;
                    asyncListUtil.mViewCallback.onDataRefresh();
                    AsyncListUtil asyncListUtil2 = AsyncListUtil.this;
                    asyncListUtil2.mDisplayedGeneration = asyncListUtil2.mRequestedGeneration;
                    recycleAllTiles();
                    AsyncListUtil asyncListUtil3 = AsyncListUtil.this;
                    asyncListUtil3.mAllowScrollHints = false;
                    asyncListUtil3.updateRange();
                }
            }
        };
        this.mMainThreadCallback = anonymousClass1;
        AnonymousClass2 anonymousClass2 = new ThreadUtil.BackgroundCallback<T>() { // from class: androidx.recyclerview.widget.AsyncListUtil.2
            private int mFirstRequiredTileStart;
            private int mGeneration;
            private int mItemCount;
            private int mLastRequiredTileStart;
            final SparseBooleanArray mLoadedTiles = new SparseBooleanArray();
            private TileList.Tile<T> mRecycledRoot;

            public AnonymousClass2() {
            }

            private TileList.Tile<T> acquireTile() {
                TileList.Tile<T> tile = this.mRecycledRoot;
                if (tile != null) {
                    this.mRecycledRoot = tile.mNext;
                    return tile;
                }
                AsyncListUtil asyncListUtil = AsyncListUtil.this;
                return new TileList.Tile<>(asyncListUtil.mTClass, asyncListUtil.mTileSize);
            }

            private void addTile(TileList.Tile<T> tile) {
                this.mLoadedTiles.put(tile.mStartPosition, true);
                AsyncListUtil.this.mMainThreadProxy.addTile(this.mGeneration, tile);
            }

            private void flushTileCache(int i102) {
                int maxCachedTiles = AsyncListUtil.this.mDataCallback.getMaxCachedTiles();
                while (this.mLoadedTiles.size() >= maxCachedTiles) {
                    int keyAt = this.mLoadedTiles.keyAt(0);
                    SparseBooleanArray sparseBooleanArray = this.mLoadedTiles;
                    int keyAt2 = sparseBooleanArray.keyAt(sparseBooleanArray.size() - 1);
                    int i11 = this.mFirstRequiredTileStart - keyAt;
                    int i12 = keyAt2 - this.mLastRequiredTileStart;
                    if (i11 > 0 && (i11 >= i12 || i102 == 2)) {
                        removeTile(keyAt);
                    } else {
                        if (i12 <= 0) {
                            return;
                        }
                        if (i11 >= i12 && i102 != 1) {
                            return;
                        } else {
                            removeTile(keyAt2);
                        }
                    }
                }
            }

            private int getTileStart(int i102) {
                return i102 - (i102 % AsyncListUtil.this.mTileSize);
            }

            private boolean isTileLoaded(int i102) {
                return this.mLoadedTiles.get(i102);
            }

            private void log(String str, Object... objArr) {
                Log.d(AsyncListUtil.TAG, "[BKGR] " + String.format(str, objArr));
            }

            private void removeTile(int i102) {
                this.mLoadedTiles.delete(i102);
                AsyncListUtil.this.mMainThreadProxy.removeTile(this.mGeneration, i102);
            }

            private void requestTiles(int i102, int i11, int i12, boolean z10) {
                int i13 = i102;
                while (i13 <= i11) {
                    AsyncListUtil.this.mBackgroundProxy.loadTile(z10 ? (i11 + i102) - i13 : i13, i12);
                    i13 += AsyncListUtil.this.mTileSize;
                }
            }

            @Override // androidx.recyclerview.widget.ThreadUtil.BackgroundCallback
            public void loadTile(int i102, int i11) {
                if (isTileLoaded(i102)) {
                    return;
                }
                TileList.Tile<T> acquireTile = acquireTile();
                acquireTile.mStartPosition = i102;
                int min = Math.min(AsyncListUtil.this.mTileSize, this.mItemCount - i102);
                acquireTile.mItemCount = min;
                AsyncListUtil.this.mDataCallback.fillData(acquireTile.mItems, acquireTile.mStartPosition, min);
                flushTileCache(i11);
                addTile(acquireTile);
            }

            @Override // androidx.recyclerview.widget.ThreadUtil.BackgroundCallback
            public void recycleTile(TileList.Tile<T> tile) {
                AsyncListUtil.this.mDataCallback.recycleData(tile.mItems, tile.mItemCount);
                tile.mNext = this.mRecycledRoot;
                this.mRecycledRoot = tile;
            }

            @Override // androidx.recyclerview.widget.ThreadUtil.BackgroundCallback
            public void refresh(int i102) {
                this.mGeneration = i102;
                this.mLoadedTiles.clear();
                int refreshData = AsyncListUtil.this.mDataCallback.refreshData();
                this.mItemCount = refreshData;
                AsyncListUtil.this.mMainThreadProxy.updateItemCount(this.mGeneration, refreshData);
            }

            @Override // androidx.recyclerview.widget.ThreadUtil.BackgroundCallback
            public void updateRange(int i102, int i11, int i12, int i13, int i14) {
                if (i102 > i11) {
                    return;
                }
                int tileStart = getTileStart(i102);
                int tileStart2 = getTileStart(i11);
                this.mFirstRequiredTileStart = getTileStart(i12);
                int tileStart3 = getTileStart(i13);
                this.mLastRequiredTileStart = tileStart3;
                if (i14 == 1) {
                    requestTiles(this.mFirstRequiredTileStart, tileStart2, i14, true);
                    requestTiles(tileStart2 + AsyncListUtil.this.mTileSize, this.mLastRequiredTileStart, i14, false);
                } else {
                    requestTiles(tileStart, tileStart3, i14, false);
                    requestTiles(this.mFirstRequiredTileStart, tileStart - AsyncListUtil.this.mTileSize, i14, true);
                }
            }
        };
        this.mBackgroundCallback = anonymousClass2;
        this.mTClass = cls;
        this.mTileSize = i10;
        this.mDataCallback = dataCallback;
        this.mViewCallback = viewCallback;
        this.mTileList = new TileList<>(i10);
        MessageThreadUtil messageThreadUtil = new MessageThreadUtil();
        this.mMainThreadProxy = messageThreadUtil.getMainThreadProxy(anonymousClass1);
        this.mBackgroundProxy = messageThreadUtil.getBackgroundProxy(anonymousClass2);
        refresh();
    }

    private boolean isRefreshPending() {
        return this.mRequestedGeneration != this.mDisplayedGeneration;
    }

    @Nullable
    public T getItem(int i10) {
        if (i10 < 0 || i10 >= this.mItemCount) {
            throw new IndexOutOfBoundsException(i10 + " is not within 0 and " + this.mItemCount);
        }
        T itemAt = this.mTileList.getItemAt(i10);
        if (itemAt == null && !isRefreshPending()) {
            this.mMissingPositions.put(i10, 0);
        }
        return itemAt;
    }

    public int getItemCount() {
        return this.mItemCount;
    }

    public void log(String str, Object... objArr) {
        Log.d(TAG, "[MAIN] " + String.format(str, objArr));
    }

    public void onRangeChanged() {
        if (isRefreshPending()) {
            return;
        }
        updateRange();
        this.mAllowScrollHints = true;
    }

    public void refresh() {
        this.mMissingPositions.clear();
        ThreadUtil.BackgroundCallback<T> backgroundCallback = this.mBackgroundProxy;
        int i10 = this.mRequestedGeneration + 1;
        this.mRequestedGeneration = i10;
        backgroundCallback.refresh(i10);
    }

    public void updateRange() {
        int i10;
        this.mViewCallback.getItemRangeInto(this.mTmpRange);
        int[] iArr = this.mTmpRange;
        int i11 = iArr[0];
        int i12 = iArr[1];
        if (i11 > i12 || i11 < 0 || i12 >= this.mItemCount) {
            return;
        }
        if (this.mAllowScrollHints) {
            int[] iArr2 = this.mPrevRange;
            if (i11 > iArr2[1] || (i10 = iArr2[0]) > i12) {
                this.mScrollHint = 0;
            } else if (i11 < i10) {
                this.mScrollHint = 1;
            } else if (i11 > i10) {
                this.mScrollHint = 2;
            }
        } else {
            this.mScrollHint = 0;
        }
        int[] iArr3 = this.mPrevRange;
        iArr3[0] = i11;
        iArr3[1] = i12;
        this.mViewCallback.extendRangeInto(iArr, this.mTmpRangeExtended, this.mScrollHint);
        int[] iArr4 = this.mTmpRangeExtended;
        iArr4[0] = Math.min(this.mTmpRange[0], Math.max(iArr4[0], 0));
        int[] iArr5 = this.mTmpRangeExtended;
        iArr5[1] = Math.max(this.mTmpRange[1], Math.min(iArr5[1], this.mItemCount - 1));
        ThreadUtil.BackgroundCallback<T> backgroundCallback = this.mBackgroundProxy;
        int[] iArr6 = this.mTmpRange;
        int i13 = iArr6[0];
        int i14 = iArr6[1];
        int[] iArr7 = this.mTmpRangeExtended;
        backgroundCallback.updateRange(i13, i14, iArr7[0], iArr7[1], this.mScrollHint);
    }
}
