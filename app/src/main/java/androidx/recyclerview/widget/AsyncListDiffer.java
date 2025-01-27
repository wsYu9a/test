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

    /* renamed from: a */
    private static final Executor f3146a = new MainThreadExecutor();

    /* renamed from: b */
    private final ListUpdateCallback f3147b;

    /* renamed from: c */
    final AsyncDifferConfig<T> f3148c;

    /* renamed from: d */
    Executor f3149d;

    /* renamed from: e */
    private final List<ListListener<T>> f3150e;

    /* renamed from: f */
    @Nullable
    private List<T> f3151f;

    /* renamed from: g */
    @NonNull
    private List<T> f3152g;

    /* renamed from: h */
    int f3153h;

    /* renamed from: androidx.recyclerview.widget.AsyncListDiffer$1 */
    class AnonymousClass1 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ List f3154a;

        /* renamed from: b */
        final /* synthetic */ List f3155b;

        /* renamed from: c */
        final /* synthetic */ int f3156c;

        /* renamed from: d */
        final /* synthetic */ Runnable f3157d;

        /* renamed from: androidx.recyclerview.widget.AsyncListDiffer$1$1 */
        class C00111 extends DiffUtil.Callback {
            C00111() {
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // androidx.recyclerview.widget.DiffUtil.Callback
            public boolean areContentsTheSame(int i2, int i3) {
                Object obj = list2.get(i2);
                Object obj2 = list.get(i3);
                if (obj != null && obj2 != null) {
                    return AsyncListDiffer.this.f3148c.getDiffCallback().areContentsTheSame(obj, obj2);
                }
                if (obj == null && obj2 == null) {
                    return true;
                }
                throw new AssertionError();
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // androidx.recyclerview.widget.DiffUtil.Callback
            public boolean areItemsTheSame(int i2, int i3) {
                Object obj = list2.get(i2);
                Object obj2 = list.get(i3);
                return (obj == null || obj2 == null) ? obj == null && obj2 == null : AsyncListDiffer.this.f3148c.getDiffCallback().areItemsTheSame(obj, obj2);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // androidx.recyclerview.widget.DiffUtil.Callback
            @Nullable
            public Object getChangePayload(int i2, int i3) {
                Object obj = list2.get(i2);
                Object obj2 = list.get(i3);
                if (obj == null || obj2 == null) {
                    throw new AssertionError();
                }
                return AsyncListDiffer.this.f3148c.getDiffCallback().getChangePayload(obj, obj2);
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
        class AnonymousClass2 implements Runnable {

            /* renamed from: a */
            final /* synthetic */ DiffUtil.DiffResult f3160a;

            AnonymousClass2(DiffUtil.DiffResult diffResult) {
                calculateDiff = diffResult;
            }

            @Override // java.lang.Runnable
            public void run() {
                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                AsyncListDiffer asyncListDiffer = AsyncListDiffer.this;
                if (asyncListDiffer.f3153h == i2) {
                    asyncListDiffer.a(list, calculateDiff, runnable);
                }
            }
        }

        AnonymousClass1(List list, List list2, int i2, Runnable runnable) {
            list2 = list;
            list = list2;
            i2 = i2;
            runnable = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            AsyncListDiffer.this.f3149d.execute(new Runnable() { // from class: androidx.recyclerview.widget.AsyncListDiffer.1.2

                /* renamed from: a */
                final /* synthetic */ DiffUtil.DiffResult f3160a;

                AnonymousClass2(DiffUtil.DiffResult diffResult) {
                    calculateDiff = diffResult;
                }

                @Override // java.lang.Runnable
                public void run() {
                    AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                    AsyncListDiffer asyncListDiffer = AsyncListDiffer.this;
                    if (asyncListDiffer.f3153h == i2) {
                        asyncListDiffer.a(list, calculateDiff, runnable);
                    }
                }
            });
        }
    }

    public interface ListListener<T> {
        void onCurrentListChanged(@NonNull List<T> list, @NonNull List<T> list2);
    }

    private static class MainThreadExecutor implements Executor {

        /* renamed from: a */
        final Handler f3162a = new Handler(Looper.getMainLooper());

        MainThreadExecutor() {
        }

        @Override // java.util.concurrent.Executor
        public void execute(@NonNull Runnable runnable) {
            this.f3162a.post(runnable);
        }
    }

    public AsyncListDiffer(@NonNull RecyclerView.Adapter adapter, @NonNull DiffUtil.ItemCallback<T> itemCallback) {
        this(new AdapterListUpdateCallback(adapter), new AsyncDifferConfig.Builder(itemCallback).build());
    }

    private void b(@NonNull List<T> list, @Nullable Runnable runnable) {
        Iterator<ListListener<T>> it = this.f3150e.iterator();
        while (it.hasNext()) {
            it.next().onCurrentListChanged(list, this.f3152g);
        }
        if (runnable != null) {
            runnable.run();
        }
    }

    void a(@NonNull List<T> list, @NonNull DiffUtil.DiffResult diffResult, @Nullable Runnable runnable) {
        List<T> list2 = this.f3152g;
        this.f3151f = list;
        this.f3152g = Collections.unmodifiableList(list);
        diffResult.dispatchUpdatesTo(this.f3147b);
        b(list2, runnable);
    }

    public void addListListener(@NonNull ListListener<T> listListener) {
        this.f3150e.add(listListener);
    }

    @NonNull
    public List<T> getCurrentList() {
        return this.f3152g;
    }

    public void removeListListener(@NonNull ListListener<T> listListener) {
        this.f3150e.remove(listListener);
    }

    public void submitList(@Nullable List<T> list) {
        submitList(list, null);
    }

    public void submitList(@Nullable List<T> list, @Nullable Runnable runnable) {
        int i2 = this.f3153h + 1;
        this.f3153h = i2;
        List<T> list2 = this.f3151f;
        if (list == list2) {
            if (runnable != null) {
                runnable.run();
                return;
            }
            return;
        }
        List<T> list3 = this.f3152g;
        if (list == null) {
            int size = list2.size();
            this.f3151f = null;
            this.f3152g = Collections.emptyList();
            this.f3147b.onRemoved(0, size);
            b(list3, runnable);
            return;
        }
        if (list2 != null) {
            this.f3148c.getBackgroundThreadExecutor().execute(new Runnable() { // from class: androidx.recyclerview.widget.AsyncListDiffer.1

                /* renamed from: a */
                final /* synthetic */ List f3154a;

                /* renamed from: b */
                final /* synthetic */ List f3155b;

                /* renamed from: c */
                final /* synthetic */ int f3156c;

                /* renamed from: d */
                final /* synthetic */ Runnable f3157d;

                /* renamed from: androidx.recyclerview.widget.AsyncListDiffer$1$1 */
                class C00111 extends DiffUtil.Callback {
                    C00111() {
                    }

                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // androidx.recyclerview.widget.DiffUtil.Callback
                    public boolean areContentsTheSame(int i2, int i3) {
                        Object obj = list2.get(i2);
                        Object obj2 = list.get(i3);
                        if (obj != null && obj2 != null) {
                            return AsyncListDiffer.this.f3148c.getDiffCallback().areContentsTheSame(obj, obj2);
                        }
                        if (obj == null && obj2 == null) {
                            return true;
                        }
                        throw new AssertionError();
                    }

                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // androidx.recyclerview.widget.DiffUtil.Callback
                    public boolean areItemsTheSame(int i2, int i3) {
                        Object obj = list2.get(i2);
                        Object obj2 = list.get(i3);
                        return (obj == null || obj2 == null) ? obj == null && obj2 == null : AsyncListDiffer.this.f3148c.getDiffCallback().areItemsTheSame(obj, obj2);
                    }

                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // androidx.recyclerview.widget.DiffUtil.Callback
                    @Nullable
                    public Object getChangePayload(int i2, int i3) {
                        Object obj = list2.get(i2);
                        Object obj2 = list.get(i3);
                        if (obj == null || obj2 == null) {
                            throw new AssertionError();
                        }
                        return AsyncListDiffer.this.f3148c.getDiffCallback().getChangePayload(obj, obj2);
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
                class AnonymousClass2 implements Runnable {

                    /* renamed from: a */
                    final /* synthetic */ DiffUtil.DiffResult f3160a;

                    AnonymousClass2(DiffUtil.DiffResult diffResult) {
                        calculateDiff = diffResult;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                        AsyncListDiffer asyncListDiffer = AsyncListDiffer.this;
                        if (asyncListDiffer.f3153h == i2) {
                            asyncListDiffer.a(list, calculateDiff, runnable);
                        }
                    }
                }

                AnonymousClass1(List list22, List list4, int i22, Runnable runnable2) {
                    list2 = list22;
                    list = list4;
                    i2 = i22;
                    runnable = runnable2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    AsyncListDiffer.this.f3149d.execute(new Runnable() { // from class: androidx.recyclerview.widget.AsyncListDiffer.1.2

                        /* renamed from: a */
                        final /* synthetic */ DiffUtil.DiffResult f3160a;

                        AnonymousClass2(DiffUtil.DiffResult diffResult) {
                            calculateDiff = diffResult;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                            AsyncListDiffer asyncListDiffer = AsyncListDiffer.this;
                            if (asyncListDiffer.f3153h == i2) {
                                asyncListDiffer.a(list, calculateDiff, runnable);
                            }
                        }
                    });
                }
            });
            return;
        }
        this.f3151f = list4;
        this.f3152g = Collections.unmodifiableList(list4);
        this.f3147b.onInserted(0, list4.size());
        b(list3, runnable2);
    }

    public AsyncListDiffer(@NonNull ListUpdateCallback listUpdateCallback, @NonNull AsyncDifferConfig<T> asyncDifferConfig) {
        this.f3150e = new CopyOnWriteArrayList();
        this.f3152g = Collections.emptyList();
        this.f3147b = listUpdateCallback;
        this.f3148c = asyncDifferConfig;
        if (asyncDifferConfig.getMainThreadExecutor() != null) {
            this.f3149d = asyncDifferConfig.getMainThreadExecutor();
        } else {
            this.f3149d = f3146a;
        }
    }
}
