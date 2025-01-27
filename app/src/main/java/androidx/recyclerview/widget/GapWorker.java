package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import androidx.annotation.Nullable;
import androidx.core.os.TraceCompat;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
final class GapWorker implements Runnable {

    /* renamed from: a */
    static final ThreadLocal<GapWorker> f3271a = new ThreadLocal<>();

    /* renamed from: b */
    static Comparator<Task> f3272b = new Comparator<Task>() { // from class: androidx.recyclerview.widget.GapWorker.1
        AnonymousClass1() {
        }

        @Override // java.util.Comparator
        public int compare(Task task, Task task2) {
            RecyclerView recyclerView = task.view;
            if ((recyclerView == null) != (task2.view == null)) {
                return recyclerView == null ? 1 : -1;
            }
            boolean z = task.immediate;
            if (z != task2.immediate) {
                return z ? -1 : 1;
            }
            int i2 = task2.viewVelocity - task.viewVelocity;
            if (i2 != 0) {
                return i2;
            }
            int i3 = task.distanceToItem - task2.distanceToItem;
            if (i3 != 0) {
                return i3;
            }
            return 0;
        }
    };

    /* renamed from: d */
    long f3274d;

    /* renamed from: e */
    long f3275e;

    /* renamed from: c */
    ArrayList<RecyclerView> f3273c = new ArrayList<>();

    /* renamed from: f */
    private ArrayList<Task> f3276f = new ArrayList<>();

    /* renamed from: androidx.recyclerview.widget.GapWorker$1 */
    static class AnonymousClass1 implements Comparator<Task> {
        AnonymousClass1() {
        }

        @Override // java.util.Comparator
        public int compare(Task task, Task task2) {
            RecyclerView recyclerView = task.view;
            if ((recyclerView == null) != (task2.view == null)) {
                return recyclerView == null ? 1 : -1;
            }
            boolean z = task.immediate;
            if (z != task2.immediate) {
                return z ? -1 : 1;
            }
            int i2 = task2.viewVelocity - task.viewVelocity;
            if (i2 != 0) {
                return i2;
            }
            int i3 = task.distanceToItem - task2.distanceToItem;
            if (i3 != 0) {
                return i3;
            }
            return 0;
        }
    }

    @SuppressLint({"VisibleForTests"})
    static class LayoutPrefetchRegistryImpl implements RecyclerView.LayoutManager.LayoutPrefetchRegistry {

        /* renamed from: a */
        int f3277a;

        /* renamed from: b */
        int f3278b;

        /* renamed from: c */
        int[] f3279c;

        /* renamed from: d */
        int f3280d;

        LayoutPrefetchRegistryImpl() {
        }

        void a() {
            int[] iArr = this.f3279c;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            this.f3280d = 0;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager.LayoutPrefetchRegistry
        public void addPosition(int i2, int i3) {
            if (i2 < 0) {
                throw new IllegalArgumentException("Layout positions must be non-negative");
            }
            if (i3 < 0) {
                throw new IllegalArgumentException("Pixel distance must be non-negative");
            }
            int i4 = this.f3280d * 2;
            int[] iArr = this.f3279c;
            if (iArr == null) {
                int[] iArr2 = new int[4];
                this.f3279c = iArr2;
                Arrays.fill(iArr2, -1);
            } else if (i4 >= iArr.length) {
                int[] iArr3 = new int[i4 * 2];
                this.f3279c = iArr3;
                System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
            }
            int[] iArr4 = this.f3279c;
            iArr4[i4] = i2;
            iArr4[i4 + 1] = i3;
            this.f3280d++;
        }

        void b(RecyclerView recyclerView, boolean z) {
            this.f3280d = 0;
            int[] iArr = this.f3279c;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            RecyclerView.LayoutManager layoutManager = recyclerView.mLayout;
            if (recyclerView.mAdapter == null || layoutManager == null || !layoutManager.isItemPrefetchEnabled()) {
                return;
            }
            if (z) {
                if (!recyclerView.mAdapterHelper.n()) {
                    layoutManager.collectInitialPrefetchPositions(recyclerView.mAdapter.getItemCount(), this);
                }
            } else if (!recyclerView.hasPendingAdapterUpdates()) {
                layoutManager.collectAdjacentPrefetchPositions(this.f3277a, this.f3278b, recyclerView.mState, this);
            }
            int i2 = this.f3280d;
            if (i2 > layoutManager.mPrefetchMaxCountObserved) {
                layoutManager.mPrefetchMaxCountObserved = i2;
                layoutManager.mPrefetchMaxObservedInInitialPrefetch = z;
                recyclerView.mRecycler.E();
            }
        }

        boolean c(int i2) {
            if (this.f3279c != null) {
                int i3 = this.f3280d * 2;
                for (int i4 = 0; i4 < i3; i4 += 2) {
                    if (this.f3279c[i4] == i2) {
                        return true;
                    }
                }
            }
            return false;
        }

        void d(int i2, int i3) {
            this.f3277a = i2;
            this.f3278b = i3;
        }
    }

    static class Task {
        public int distanceToItem;
        public boolean immediate;
        public int position;
        public RecyclerView view;
        public int viewVelocity;

        Task() {
        }

        public void clear() {
            this.immediate = false;
            this.viewVelocity = 0;
            this.distanceToItem = 0;
            this.view = null;
            this.position = 0;
        }
    }

    GapWorker() {
    }

    private void c() {
        Task task;
        int size = this.f3273c.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            RecyclerView recyclerView = this.f3273c.get(i3);
            if (recyclerView.getWindowVisibility() == 0) {
                recyclerView.mPrefetchRegistry.b(recyclerView, false);
                i2 += recyclerView.mPrefetchRegistry.f3280d;
            }
        }
        this.f3276f.ensureCapacity(i2);
        int i4 = 0;
        for (int i5 = 0; i5 < size; i5++) {
            RecyclerView recyclerView2 = this.f3273c.get(i5);
            if (recyclerView2.getWindowVisibility() == 0) {
                LayoutPrefetchRegistryImpl layoutPrefetchRegistryImpl = recyclerView2.mPrefetchRegistry;
                int abs = Math.abs(layoutPrefetchRegistryImpl.f3277a) + Math.abs(layoutPrefetchRegistryImpl.f3278b);
                for (int i6 = 0; i6 < layoutPrefetchRegistryImpl.f3280d * 2; i6 += 2) {
                    if (i4 >= this.f3276f.size()) {
                        task = new Task();
                        this.f3276f.add(task);
                    } else {
                        task = this.f3276f.get(i4);
                    }
                    int[] iArr = layoutPrefetchRegistryImpl.f3279c;
                    int i7 = iArr[i6 + 1];
                    task.immediate = i7 <= abs;
                    task.viewVelocity = abs;
                    task.distanceToItem = i7;
                    task.view = recyclerView2;
                    task.position = iArr[i6];
                    i4++;
                }
            }
        }
        Collections.sort(this.f3276f, f3272b);
    }

    private void d(Task task, long j2) {
        RecyclerView.ViewHolder j3 = j(task.view, task.position, task.immediate ? Long.MAX_VALUE : j2);
        if (j3 == null || j3.mNestedRecyclerView == null || !j3.isBound() || j3.isInvalid()) {
            return;
        }
        i(j3.mNestedRecyclerView.get(), j2);
    }

    private void e(long j2) {
        for (int i2 = 0; i2 < this.f3276f.size(); i2++) {
            Task task = this.f3276f.get(i2);
            if (task.view == null) {
                return;
            }
            d(task, j2);
            task.clear();
        }
    }

    static boolean f(RecyclerView recyclerView, int i2) {
        int j2 = recyclerView.mChildHelper.j();
        for (int i3 = 0; i3 < j2; i3++) {
            RecyclerView.ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(recyclerView.mChildHelper.i(i3));
            if (childViewHolderInt.mPosition == i2 && !childViewHolderInt.isInvalid()) {
                return true;
            }
        }
        return false;
    }

    private void i(@Nullable RecyclerView recyclerView, long j2) {
        if (recyclerView == null) {
            return;
        }
        if (recyclerView.mDataSetHasChangedAfterLayout && recyclerView.mChildHelper.j() != 0) {
            recyclerView.removeAndRecycleViews();
        }
        LayoutPrefetchRegistryImpl layoutPrefetchRegistryImpl = recyclerView.mPrefetchRegistry;
        layoutPrefetchRegistryImpl.b(recyclerView, true);
        if (layoutPrefetchRegistryImpl.f3280d != 0) {
            try {
                TraceCompat.beginSection("RV Nested Prefetch");
                recyclerView.mState.b(recyclerView.mAdapter);
                for (int i2 = 0; i2 < layoutPrefetchRegistryImpl.f3280d * 2; i2 += 2) {
                    j(recyclerView, layoutPrefetchRegistryImpl.f3279c[i2], j2);
                }
            } finally {
                TraceCompat.endSection();
            }
        }
    }

    private RecyclerView.ViewHolder j(RecyclerView recyclerView, int i2, long j2) {
        if (f(recyclerView, i2)) {
            return null;
        }
        RecyclerView.Recycler recycler = recyclerView.mRecycler;
        try {
            recyclerView.onEnterLayoutOrScroll();
            RecyclerView.ViewHolder C = recycler.C(i2, false, j2);
            if (C != null) {
                if (!C.isBound() || C.isInvalid()) {
                    recycler.a(C, false);
                } else {
                    recycler.recycleView(C.itemView);
                }
            }
            return C;
        } finally {
            recyclerView.onExitLayoutOrScroll(false);
        }
    }

    public void add(RecyclerView recyclerView) {
        this.f3273c.add(recyclerView);
    }

    void g(RecyclerView recyclerView, int i2, int i3) {
        if (recyclerView.isAttachedToWindow() && this.f3274d == 0) {
            this.f3274d = recyclerView.getNanoTime();
            recyclerView.post(this);
        }
        recyclerView.mPrefetchRegistry.d(i2, i3);
    }

    void h(long j2) {
        c();
        e(j2);
    }

    public void remove(RecyclerView recyclerView) {
        this.f3273c.remove(recyclerView);
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            TraceCompat.beginSection("RV Prefetch");
            if (!this.f3273c.isEmpty()) {
                int size = this.f3273c.size();
                long j2 = 0;
                for (int i2 = 0; i2 < size; i2++) {
                    RecyclerView recyclerView = this.f3273c.get(i2);
                    if (recyclerView.getWindowVisibility() == 0) {
                        j2 = Math.max(recyclerView.getDrawingTime(), j2);
                    }
                }
                if (j2 != 0) {
                    h(TimeUnit.MILLISECONDS.toNanos(j2) + this.f3275e);
                }
            }
        } finally {
            this.f3274d = 0L;
            TraceCompat.endSection();
        }
    }
}
