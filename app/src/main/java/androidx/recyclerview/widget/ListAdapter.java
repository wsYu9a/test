package androidx.recyclerview.widget;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.AsyncDifferConfig;
import androidx.recyclerview.widget.AsyncListDiffer;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import java.util.List;

/* loaded from: classes.dex */
public abstract class ListAdapter<T, VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {

    /* renamed from: a */
    final AsyncListDiffer<T> f3362a;

    /* renamed from: b */
    private final AsyncListDiffer.ListListener<T> f3363b;

    /* renamed from: androidx.recyclerview.widget.ListAdapter$1 */
    class AnonymousClass1 implements AsyncListDiffer.ListListener<T> {
        AnonymousClass1() {
        }

        @Override // androidx.recyclerview.widget.AsyncListDiffer.ListListener
        public void onCurrentListChanged(@NonNull List<T> list, @NonNull List<T> list2) {
            ListAdapter.this.onCurrentListChanged(list, list2);
        }
    }

    protected ListAdapter(@NonNull DiffUtil.ItemCallback<T> itemCallback) {
        AnonymousClass1 anonymousClass1 = new AsyncListDiffer.ListListener<T>() { // from class: androidx.recyclerview.widget.ListAdapter.1
            AnonymousClass1() {
            }

            @Override // androidx.recyclerview.widget.AsyncListDiffer.ListListener
            public void onCurrentListChanged(@NonNull List<T> list, @NonNull List<T> list2) {
                ListAdapter.this.onCurrentListChanged(list, list2);
            }
        };
        this.f3363b = anonymousClass1;
        AsyncListDiffer<T> asyncListDiffer = new AsyncListDiffer<>(new AdapterListUpdateCallback(this), new AsyncDifferConfig.Builder(itemCallback).build());
        this.f3362a = asyncListDiffer;
        asyncListDiffer.addListListener(anonymousClass1);
    }

    @NonNull
    public List<T> getCurrentList() {
        return this.f3362a.getCurrentList();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f3362a.getCurrentList().size();
    }

    protected T n(int i2) {
        return this.f3362a.getCurrentList().get(i2);
    }

    public void onCurrentListChanged(@NonNull List<T> list, @NonNull List<T> list2) {
    }

    public void submitList(@Nullable List<T> list) {
        this.f3362a.submitList(list);
    }

    public void submitList(@Nullable List<T> list, @Nullable Runnable runnable) {
        this.f3362a.submitList(list, runnable);
    }

    protected ListAdapter(@NonNull AsyncDifferConfig<T> asyncDifferConfig) {
        AnonymousClass1 anonymousClass1 = new AsyncListDiffer.ListListener<T>() { // from class: androidx.recyclerview.widget.ListAdapter.1
            AnonymousClass1() {
            }

            @Override // androidx.recyclerview.widget.AsyncListDiffer.ListListener
            public void onCurrentListChanged(@NonNull List<T> list, @NonNull List<T> list2) {
                ListAdapter.this.onCurrentListChanged(list, list2);
            }
        };
        this.f3363b = anonymousClass1;
        AsyncListDiffer<T> asyncListDiffer = new AsyncListDiffer<>(new AdapterListUpdateCallback(this), asyncDifferConfig);
        this.f3362a = asyncListDiffer;
        asyncListDiffer.addListListener(anonymousClass1);
    }
}
