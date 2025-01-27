package com.martian.mibook.mvvm.yuewen.adapter;

import ac.a;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.AsyncListDiffer;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.kuaishou.weapon.p0.t;
import com.kwad.sdk.m.e;
import com.martian.libmars.common.ConfigSingleton;
import com.martian.libmars.ui.theme.MiSwitchButton;
import com.martian.mibook.R;
import com.martian.mibook.application.MiBookManager;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.databinding.ItemBookRankListBinding;
import com.martian.mibook.databinding.ItemBookRankTitleBinding;
import com.martian.mibook.lib.model.data.TYBookItem;
import com.martian.mibook.mvvm.extensions.ExtKt;
import com.martian.mibook.mvvm.utils.RecyclerViewExposeManager;
import com.martian.mibook.mvvm.yuewen.adapter.BookRankChildAdapter;
import com.martian.mibook.mvvm.yuewen.viewmodel.BookRankViewModel;
import id.c;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import je.i;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 <2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0004=>?@B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J%\u0010\f\u001a\u00020\u000b2\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\u001d\u0010\u0012\u001a\u00020\u000b2\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u001f\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u001f\u0010 \u001a\u00020\u000b2\u0006\u0010\u001f\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b \u0010!J\u0017\u0010$\u001a\u00020\u000b2\u0006\u0010#\u001a\u00020\"H\u0016¢\u0006\u0004\b$\u0010%J\u0017\u0010&\u001a\u00020\u000b2\u0006\u0010#\u001a\u00020\"H\u0016¢\u0006\u0004\b&\u0010%J!\u0010'\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u00142\b\u0010#\u001a\u0004\u0018\u00010\"H\u0016¢\u0006\u0004\b'\u0010(J\u000f\u0010)\u001a\u00020\u000bH\u0007¢\u0006\u0004\b)\u0010\u0005R\u001a\u0010.\u001a\b\u0012\u0004\u0012\u00020+0*8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u0018\u00102\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u00101R\"\u00107\u001a\u0010\u0012\f\u0012\n 4*\u0004\u0018\u00010\u00070\u0007038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b5\u00106R\u0016\u0010\n\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u00109R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u0010;¨\u0006A"}, d2 = {"Lcom/martian/mibook/mvvm/yuewen/adapter/BookRankChildAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/martian/mibook/mvvm/utils/RecyclerViewExposeManager$OnItemExposeListener;", "<init>", "()V", "", "Lcom/martian/mibook/mvvm/yuewen/viewmodel/BookRankViewModel$b;", "newData", "", "hasTitle", "", "n", "(Ljava/util/List;Z)V", "Lcom/martian/mibook/mvvm/yuewen/adapter/BookRankChildAdapter$b;", "onCheckListener", "m", "(Lcom/martian/mibook/mvvm/yuewen/adapter/BookRankChildAdapter$b;)V", "k", "(Ljava/util/List;)V", "", c.f26972i, "getItemViewType", "(I)I", "getItemCount", "()I", "Landroid/view/ViewGroup;", "parent", "viewType", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "holder", "onBindViewHolder", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;I)V", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "onAttachedToRecyclerView", "(Landroidx/recyclerview/widget/RecyclerView;)V", "onDetachedFromRecyclerView", "onItemViewVisible", "(ILandroidx/recyclerview/widget/RecyclerView;)V", t.f11204d, "", "", "c", "Ljava/util/Set;", "sourceIdSet", "Lcom/martian/mibook/mvvm/utils/RecyclerViewExposeManager;", "d", "Lcom/martian/mibook/mvvm/utils/RecyclerViewExposeManager;", "recyclerViewExposeManager", "Landroidx/recyclerview/widget/AsyncListDiffer;", "kotlin.jvm.PlatformType", e.TAG, "Landroidx/recyclerview/widget/AsyncListDiffer;", "mDiffer", "f", "Z", "g", "Lcom/martian/mibook/mvvm/yuewen/adapter/BookRankChildAdapter$b;", "h", "a", "ItemBookViewHolder", "b", "TitleViewHolder", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes3.dex */
public final class BookRankChildAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements RecyclerViewExposeManager.OnItemExposeListener {

    /* renamed from: i */
    public static final int f15443i = 0;

    /* renamed from: j */
    public static final int f15444j = 1;

    /* renamed from: d, reason: from kotlin metadata */
    @l
    public RecyclerViewExposeManager recyclerViewExposeManager;

    /* renamed from: f, reason: from kotlin metadata */
    public boolean hasTitle;

    /* renamed from: g, reason: from kotlin metadata */
    @l
    public b onCheckListener;

    /* renamed from: c, reason: from kotlin metadata */
    @k
    public final Set<String> sourceIdSet = new HashSet();

    /* renamed from: e */
    @k
    public final AsyncListDiffer<BookRankViewModel.b> mDiffer = new AsyncListDiffer<>(this, new DiffUtil.ItemCallback<BookRankViewModel.b>() { // from class: com.martian.mibook.mvvm.yuewen.adapter.BookRankChildAdapter$mDiffer$1
        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        @SuppressLint({"DiffUtilEquals"})
        /* renamed from: a */
        public boolean areContentsTheSame(@k BookRankViewModel.b oldItem, @k BookRankViewModel.b newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return oldItem.h() != null && newItem.h() != null && Intrinsics.areEqual(oldItem.h().getSourceId(), newItem.h().getSourceId()) && TextUtils.equals(oldItem.h().getBookName(), newItem.h().getBookName());
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        /* renamed from: b */
        public boolean areItemsTheSame(@k BookRankViewModel.b oldItem, @k BookRankViewModel.b newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return Intrinsics.areEqual(oldItem, newItem);
        }
    });

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/martian/mibook/mvvm/yuewen/adapter/BookRankChildAdapter$ItemBookViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/martian/mibook/databinding/ItemBookRankListBinding;", "binding", "<init>", "(Lcom/martian/mibook/mvvm/yuewen/adapter/BookRankChildAdapter;Lcom/martian/mibook/databinding/ItemBookRankListBinding;)V", "Landroid/widget/TextView;", "textView", "", "colorId", "", "d", "(Landroid/widget/TextView;I)V", "Lcom/martian/mibook/mvvm/yuewen/viewmodel/BookRankViewModel$b;", "itemData", "b", "(Lcom/martian/mibook/mvvm/yuewen/viewmodel/BookRankViewModel$b;)V", "Lcom/martian/mibook/databinding/ItemBookRankListBinding;", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
    public final class ItemBookViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: b, reason: from kotlin metadata */
        @k
        public final ItemBookRankListBinding binding;

        /* renamed from: c */
        public final /* synthetic */ BookRankChildAdapter f15451c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ItemBookViewHolder(@k BookRankChildAdapter bookRankChildAdapter, ItemBookRankListBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.f15451c = bookRankChildAdapter;
            this.binding = binding;
        }

        public static final void c(ItemBookViewHolder this$0, TYBookItem bookItem, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(bookItem, "$bookItem");
            Context context = this$0.binding.getRoot().getContext();
            Activity activity = context instanceof Activity ? (Activity) context : null;
            if (activity != null) {
                i.H(activity, bookItem);
            }
        }

        private final void d(TextView textView, int colorId) {
            textView.setTextColor(ContextCompat.getColor(this.binding.getRoot().getContext(), colorId));
        }

        public final void b(@k BookRankViewModel.b itemData) {
            Intrinsics.checkNotNullParameter(itemData, "itemData");
            TYBookItem h10 = itemData.h();
            if (h10 != null) {
                int bindingAdapterPosition = this.f15451c.hasTitle ? getBindingAdapterPosition() : getBindingAdapterPosition() + 1;
                this.binding.bsRankIndex.setText(String.valueOf(bindingAdapterPosition));
                if (bindingAdapterPosition == 1) {
                    TextView bsRankIndex = this.binding.bsRankIndex;
                    Intrinsics.checkNotNullExpressionValue(bsRankIndex, "bsRankIndex");
                    d(bsRankIndex, R.color.book_mall_rank_1);
                } else if (bindingAdapterPosition == 2) {
                    TextView bsRankIndex2 = this.binding.bsRankIndex;
                    Intrinsics.checkNotNullExpressionValue(bsRankIndex2, "bsRankIndex");
                    d(bsRankIndex2, R.color.book_mall_rank_2);
                } else if (bindingAdapterPosition != 3) {
                    this.binding.bsRankIndex.setTextColor(ConfigSingleton.D().j0());
                } else {
                    TextView bsRankIndex3 = this.binding.bsRankIndex;
                    Intrinsics.checkNotNullExpressionValue(bsRankIndex3, "bsRankIndex");
                    d(bsRankIndex3, R.color.book_mall_rank_3);
                }
                MiBookManager.u1(this.binding.getRoot().getContext(), h10, this.binding.bookCover);
                if (!TextUtils.isEmpty(h10.getTitle())) {
                    this.binding.bsRankBookName.setText(ExtKt.c(h10.getTitle()));
                }
                if (!ba.l.q(h10.getBookInfo())) {
                    this.binding.bsRankBookCategory.setText(ExtKt.c(h10.getBookInfo()));
                }
                this.binding.getRoot().setOnClickListener(new View.OnClickListener() { // from class: td.j

                    /* renamed from: c */
                    public final /* synthetic */ TYBookItem f30822c;

                    public /* synthetic */ j(TYBookItem h102) {
                        h10 = h102;
                    }

                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        BookRankChildAdapter.ItemBookViewHolder.c(BookRankChildAdapter.ItemBookViewHolder.this, h10, view);
                    }
                });
            }
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/martian/mibook/mvvm/yuewen/adapter/BookRankChildAdapter$TitleViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/martian/mibook/databinding/ItemBookRankTitleBinding;", "binding", "<init>", "(Lcom/martian/mibook/mvvm/yuewen/adapter/BookRankChildAdapter;Lcom/martian/mibook/databinding/ItemBookRankTitleBinding;)V", "Lcom/martian/mibook/mvvm/yuewen/viewmodel/BookRankViewModel$b;", "itemData", "", "b", "(Lcom/martian/mibook/mvvm/yuewen/viewmodel/BookRankViewModel$b;)V", "Lcom/martian/mibook/databinding/ItemBookRankTitleBinding;", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
    public final class TitleViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: b, reason: from kotlin metadata */
        @k
        public final ItemBookRankTitleBinding binding;

        /* renamed from: c */
        public final /* synthetic */ BookRankChildAdapter f15453c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TitleViewHolder(@k BookRankChildAdapter bookRankChildAdapter, ItemBookRankTitleBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.f15453c = bookRankChildAdapter;
            this.binding = binding;
        }

        public static final void c(BookRankChildAdapter this$0, TitleViewHolder this$1, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            b bVar = this$0.onCheckListener;
            if (bVar != null) {
                bVar.a(this$1.binding.switchButton.isChecked());
            }
        }

        public final void b(@k BookRankViewModel.b itemData) {
            Intrinsics.checkNotNullParameter(itemData, "itemData");
            boolean z10 = false;
            this.binding.switchButton.setVisibility(itemData.i() != null ? 0 : 8);
            MiSwitchButton miSwitchButton = this.binding.switchButton;
            Integer i10 = itemData.i();
            if (i10 != null && i10.intValue() == 50) {
                z10 = true;
            }
            miSwitchButton.setChecked(z10);
            this.binding.tvTitle.setText(ExtKt.c(itemData.j()));
            this.binding.switchButton.setOnClickListener(new View.OnClickListener() { // from class: td.k

                /* renamed from: c */
                public final /* synthetic */ BookRankChildAdapter.TitleViewHolder f30824c;

                public /* synthetic */ k(BookRankChildAdapter.TitleViewHolder this) {
                    this = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    BookRankChildAdapter.TitleViewHolder.c(BookRankChildAdapter.this, this, view);
                }
            });
        }
    }

    public interface b {
        void a(boolean z10);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getPageSize() {
        return this.mDiffer.getCurrentList().size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int r22) {
        return this.mDiffer.getCurrentList().get(r22).h() == null ? 1 : 0;
    }

    public final void k(@l List<BookRankViewModel.b> newData) {
        List<BookRankViewModel.b> list = newData;
        if (list == null || list.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.mDiffer.getCurrentList());
        arrayList.addAll(list);
        this.mDiffer.submitList(arrayList);
    }

    @SuppressLint({"NotifyDataSetChanged"})
    public final void l() {
        if (this.mDiffer.getCurrentList().size() > 0) {
            notifyDataSetChanged();
        }
    }

    public final void m(@k b onCheckListener) {
        Intrinsics.checkNotNullParameter(onCheckListener, "onCheckListener");
        this.onCheckListener = onCheckListener;
    }

    public final void n(@l List<BookRankViewModel.b> newData, boolean hasTitle) {
        this.hasTitle = hasTitle;
        this.mDiffer.submitList(null);
        this.mDiffer.submitList(newData);
        RecyclerViewExposeManager recyclerViewExposeManager = this.recyclerViewExposeManager;
        if (recyclerViewExposeManager != null) {
            RecyclerViewExposeManager.handleCurrentVisibleItems$default(recyclerViewExposeManager, true, 0L, 2, null);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(@k RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        super.onAttachedToRecyclerView(recyclerView);
        if (this.recyclerViewExposeManager == null) {
            this.recyclerViewExposeManager = new RecyclerViewExposeManager();
        }
        RecyclerViewExposeManager recyclerViewExposeManager = this.recyclerViewExposeManager;
        if (recyclerViewExposeManager != null) {
            recyclerViewExposeManager.setRecyclerItemExposeListener(recyclerView, this);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@k RecyclerView.ViewHolder holder, int r42) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        BookRankViewModel.b bVar = this.mDiffer.getCurrentList().get(r42);
        int itemViewType = holder.getItemViewType();
        if (itemViewType == 0) {
            Intrinsics.checkNotNull(bVar);
            ((ItemBookViewHolder) holder).b(bVar);
        } else {
            if (itemViewType != 1) {
                return;
            }
            Intrinsics.checkNotNull(bVar);
            ((TitleViewHolder) holder).b(bVar);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @k
    public RecyclerView.ViewHolder onCreateViewHolder(@k ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        LayoutInflater from = LayoutInflater.from(parent.getContext());
        if (viewType == 0) {
            ItemBookRankListBinding inflate = ItemBookRankListBinding.inflate(from, parent, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
            return new ItemBookViewHolder(this, inflate);
        }
        if (viewType != 1) {
            throw new IllegalArgumentException("Invalid view type");
        }
        ItemBookRankTitleBinding inflate2 = ItemBookRankTitleBinding.inflate(from, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate2, "inflate(...)");
        return new TitleViewHolder(this, inflate2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onDetachedFromRecyclerView(@k RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        super.onDetachedFromRecyclerView(recyclerView);
        RecyclerViewExposeManager recyclerViewExposeManager = this.recyclerViewExposeManager;
        if (recyclerViewExposeManager != null) {
            recyclerViewExposeManager.removeRecyclerItemExposeListener();
        }
    }

    @Override // com.martian.mibook.mvvm.utils.RecyclerViewExposeManager.OnItemExposeListener
    public void onItemViewVisible(int r92, @l RecyclerView recyclerView) {
        if (!this.mDiffer.getCurrentList().isEmpty() && getPageSize() > r92) {
            BookRankViewModel.b bVar = this.mDiffer.getCurrentList().get(r92);
            Intrinsics.checkNotNullExpressionValue(bVar, "get(...)");
            TYBookItem h10 = bVar.h();
            if (h10 == null || this.sourceIdSet.contains(h10.getSourceId())) {
                return;
            }
            if (r92 == 1) {
                Context context = recyclerView != null ? recyclerView.getContext() : null;
                a.K(context, h10.getRecommend() + h10.getSource(), "展示");
            }
            Set<String> set = this.sourceIdSet;
            String sourceId = h10.getSourceId();
            Intrinsics.checkNotNullExpressionValue(sourceId, "getSourceId(...)");
            set.add(sourceId);
            MiConfigSingleton.b2().V1().g(0, h10.getSourceName(), h10.getSourceId(), h10.getRecommendId(), "", "展示");
        }
    }
}
