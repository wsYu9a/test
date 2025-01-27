package androidx.recyclerview.widget;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.AsyncDifferConfig;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public class AsyncListDiffer<T> {
    private static final Executor sMainThreadExecutor = new MainThreadExecutor();
    final AsyncDifferConfig<T> mConfig;

    @Nullable
    private List<T> mList;
    private final List<ListListener<T>> mListeners;
    Executor mMainThreadExecutor;
    int mMaxScheduledGeneration;

    @NonNull
    private List<T> mReadOnlyList;
    private final ListUpdateCallback mUpdateCallback;

    /* renamed from: androidx.recyclerview.widget.AsyncListDiffer$1 */
    public class AnonymousClass1 implements Runnable {
        final /* synthetic */ Runnable val$commitCallback;
        final /* synthetic */ List val$newList;
        final /* synthetic */ List val$oldList;
        final /* synthetic */ int val$runGeneration;

        /* renamed from: androidx.recyclerview.widget.AsyncListDiffer$1$1 */
        public class C00091 extends DiffUtil.Callback {
            public C00091() {
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // androidx.recyclerview.widget.DiffUtil.Callback
            public boolean areContentsTheSame(int i10, int i11) {
                Object obj = list2.get(i10);
                Object obj2 = list.get(i11);
                if (obj != null && obj2 != null) {
                    return AsyncListDiffer.this.mConfig.getDiffCallback().areContentsTheSame(obj, obj2);
                }
                if (obj == null && obj2 == null) {
                    return true;
                }
                throw new AssertionError();
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // androidx.recyclerview.widget.DiffUtil.Callback
            public boolean areItemsTheSame(int i10, int i11) {
                Object obj = list2.get(i10);
                Object obj2 = list.get(i11);
                return (obj == null || obj2 == null) ? obj == null && obj2 == null : AsyncListDiffer.this.mConfig.getDiffCallback().areItemsTheSame(obj, obj2);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // androidx.recyclerview.widget.DiffUtil.Callback
            @Nullable
            public Object getChangePayload(int i10, int i11) {
                Object obj = list2.get(i10);
                Object obj2 = list.get(i11);
                if (obj == null || obj2 == null) {
                    throw new AssertionError();
                }
                return AsyncListDiffer.this.mConfig.getDiffCallback().getChangePayload(obj, obj2);
            }

            @Override // androidx.recyclerview.widget.DiffUtil.Callback
            public int getNewListSize() {
                return list.size();
            }

            @Override // androidx.recyclerview.widget.DiffUtil.Callback
            public int getOldListSize() {
                return list2.size();
            }
        }

        /* renamed from: androidx.recyclerview.widget.AsyncListDiffer$1$2 */
        public class AnonymousClass2 implements Runnable {
            final /* synthetic */ DiffUtil.DiffResult val$result;

            public AnonymousClass2(DiffUtil.DiffResult diffResult) {
                calculateDiff = diffResult;
            }

            @Override // java.lang.Runnable
            public void run() {
                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                AsyncListDiffer asyncListDiffer = AsyncListDiffer.this;
                if (asyncListDiffer.mMaxScheduledGeneration == i10) {
                    asyncListDiffer.latchList(list, calculateDiff, runnable);
                }
            }
        }

        public AnonymousClass1(List list, List list2, int i10, Runnable runnable) {
            list2 = list;
            list = list2;
            i10 = i10;
            runnable = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            AsyncListDiffer.this.mMainThreadExecutor.execute(new Runnable() { // from class: androidx.recyclerview.widget.AsyncListDiffer.1.2
                final /* synthetic */ DiffUtil.DiffResult val$result;

                public AnonymousClass2(DiffUtil.DiffResult diffResult) {
                    calculateDiff = diffResult;
                }

                @Override // java.lang.Runnable
                public void run() {
                    AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                    AsyncListDiffer asyncListDiffer = AsyncListDiffer.this;
                    if (asyncListDiffer.mMaxScheduledGeneration == i10) {
                        asyncListDiffer.latchList(list, calculateDiff, runnable);
                    }
                }
            });
        }
    }

    public interface ListListener<T> {
        void onCurrentListChanged(@NonNull List<T> list, @NonNull List<T> list2);
    }

    public static class MainThreadExecutor implements Executor {
        final Handler mHandler = new Handler(Looper.getMainLooper());

        @Override // java.util.concurrent.Executor
        public void execute(@NonNull Runnable runnable) {
            this.mHandler.post(runnable);
        }
    }

    public AsyncListDiffer(@NonNull RecyclerView.Adapter adapter, @NonNull DiffUtil.ItemCallback<T> itemCallback) {
        this(new AdapterListUpdateCallback(adapter), new AsyncDifferConfig.Builder(itemCallback).build());
    }

    private void onCurrentListChanged(@NonNull List<T> list, @Nullable Runnable runnable) {
        Iterator<ListListener<T>> it = this.mListeners.iterator();
        while (it.hasNext()) {
            it.next().onCurrentListChanged(list, this.mReadOnlyList);
        }
        if (runnable != null) {
            runnable.run();
        }
    }

    public void addListListener(@NonNull ListListener<T> listListener) {
        this.mListeners.add(listListener);
    }

    @NonNull
    public List<T> getCurrentList() {
        return this.mReadOnlyList;
    }

    public void latchList(@NonNull List<T> list, @NonNull DiffUtil.DiffResult diffResult, @Nullable Runnable runnable) {
        List<T> list2 = this.mReadOnlyList;
        this.mList = list;
        this.mReadOnlyList = Collections.unmodifiableList(list);
        diffResult.dispatchUpdatesTo(this.mUpdateCallback);
        onCurrentListChanged(list2, runnable);
    }

    public void removeListListener(@NonNull ListListener<T> listListener) {
        this.mListeners.remove(listListener);
    }

    public void submitList(@Nullable List<T> list) {
        submitList(list, null);
    }

    public void submitList(@Nullable List<T> list, @Nullable Runnable runnable) {
        int i10 = this.mMaxScheduledGeneration + 1;
        this.mMaxScheduledGeneration = i10;
        List<T> list2 = this.mList;
        if (list == list2) {
            if (runnable != null) {
                runnable.run();
                return;
            }
            return;
        }
        List<T> list3 = this.mReadOnlyList;
        if (list == null) {
            int size = list2.size();
            this.mList = null;
            this.mReadOnlyList = Collections.emptyList();
            this.mUpdateCallback.onRemoved(0, size);
            onCurrentListChanged(list3, runnable);
            return;
        }
        if (list2 != null) {
            this.mConfig.getBackgroundThreadExecutor().execute(new Runnable() { // from class: androidx.recyclerview.widget.AsyncListDiffer.1
                final /* synthetic */ Runnable val$commitCallback;
                final /* synthetic */ List val$newList;
                final /* synthetic */ List val$oldList;
                final /* synthetic */ int val$runGeneration;

                /* renamed from: androidx.recyclerview.widget.AsyncListDiffer$1$1 */
                public class C00091 extends DiffUtil.Callback {
                    public C00091() {
                    }

                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // androidx.recyclerview.widget.DiffUtil.Callback
                    public boolean areContentsTheSame(int i10, int i11) {
                        Object obj = list2.get(i10);
                        Object obj2 = list.get(i11);
                        if (obj != null && obj2 != null) {
                            return AsyncListDiffer.this.mConfig.getDiffCallback().areContentsTheSame(obj, obj2);
                        }
                        if (obj == null && obj2 == null) {
                            return true;
                        }
                        throw new AssertionError();
                    }

                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // androidx.recyclerview.widget.DiffUtil.Callback
                    public boolean areItemsTheSame(int i10, int i11) {
                        Object obj = list2.get(i10);
                        Object obj2 = list.get(i11);
                        return (obj == null || obj2 == null) ? obj == null && obj2 == null : AsyncListDiffer.this.mConfig.getDiffCallback().areItemsTheSame(obj, obj2);
                    }

                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // androidx.recyclerview.widget.DiffUtil.Callback
                    @Nullable
                    public Object getChangePayload(int i10, int i11) {
                        Object obj = list2.get(i10);
                        Object obj2 = list.get(i11);
                        if (obj == null || obj2 == null) {
                            throw new AssertionError();
                        }
                        return AsyncListDiffer.this.mConfig.getDiffCallback().getChangePayload(obj, obj2);
                    }

                    @Override // androidx.recyclerview.widget.DiffUtil.Callback
                    public int getNewListSize() {
                        return list.size();
                    }

                    @Override // androidx.recyclerview.widget.DiffUtil.Callback
                    public int getOldListSize() {
                        return list2.size();
                    }
                }

                /* renamed from: androidx.recyclerview.widget.AsyncListDiffer$1$2 */
                public class AnonymousClass2 implements Runnable {
                    final /* synthetic */ DiffUtil.DiffResult val$result;

                    public AnonymousClass2(DiffUtil.DiffResult diffResult) {
                        calculateDiff = diffResult;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                        AsyncListDiffer asyncListDiffer = AsyncListDiffer.this;
                        if (asyncListDiffer.mMaxScheduledGeneration == i10) {
                            asyncListDiffer.latchList(list, calculateDiff, runnable);
                        }
                    }
                }

                public AnonymousClass1(List list22, List list4, int i102, Runnable runnable2) {
                    list2 = list22;
                    list = list4;
                    i10 = i102;
                    runnable = runnable2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    AsyncListDiffer.this.mMainThreadExecutor.execute(new Runnable() { // from class: androidx.recyclerview.widget.AsyncListDiffer.1.2
                        final /* synthetic */ DiffUtil.DiffResult val$result;

                        public AnonymousClass2(DiffUtil.DiffResult diffResult) {
                            calculateDiff = diffResult;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                            AsyncListDiffer asyncListDiffer = AsyncListDiffer.this;
                            if (asyncListDiffer.mMaxScheduledGeneration == i10) {
                                asyncListDiffer.latchList(list, calculateDiff, runnable);
                            }
                        }
                    });
                }
            });
            return;
        }
        this.mList = list4;
        this.mReadOnlyList = Collections.unmodifiableList(list4);
        this.mUpdateCallback.onInserted(0, list4.size());
        onCurrentListChanged(list3, runnable2);
    }

    public AsyncListDiffer(@NonNull ListUpdateCallback listUpdateCallback, @NonNull AsyncDifferConfig<T> asyncDifferConfig) {
        this.mListeners = new CopyOnWriteArrayList();
        this.mReadOnlyList = Collections.emptyList();
        this.mUpdateCallback = listUpdateCallback;
        this.mConfig = asyncDifferConfig;
        if (asyncDifferConfig.getMainThreadExecutor() != null) {
            this.mMainThreadExecutor = asyncDifferConfig.getMainThreadExecutor();
        } else {
            this.mMainThreadExecutor = sMainThreadExecutor;
        }
    }
}
