package com.martian.mibook.mvvm.yuewen.adapter;

import ac.a;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.AsyncListDiffer;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.kuaishou.weapon.p0.t;
import com.kwad.sdk.m.e;
import com.martian.libmars.R;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.mibook.application.MiBookManager;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.databinding.ItemBookStoreBinding;
import com.martian.mibook.lib.model.data.TYBookItem;
import com.martian.mibook.mvvm.extensions.ExtKt;
import com.martian.mibook.mvvm.utils.RecyclerViewExposeManager;
import com.martian.mibook.mvvm.yuewen.adapter.TYBookItemListAdapter;
import com.umeng.analytics.pro.f;
import id.c;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import je.i;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010#\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u00012\u00020\u0003:\u0001<B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u001d\u0010\n\u001a\u00020\t2\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\u0004\b\n\u0010\u000bJ\u001d\u0010\f\u001a\u00020\t2\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\u0004\b\f\u0010\u000bJ#\u0010\u0011\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J#\u0010\u0015\u001a\u00020\t2\n\u0010\u0013\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0015\u0010\u001b\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001b\u0010\u001cJ\u0015\u0010\u001e\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\u0019¢\u0006\u0004\b\u001e\u0010\u001cJ\u0017\u0010!\u001a\u00020\t2\u0006\u0010 \u001a\u00020\u001fH\u0016¢\u0006\u0004\b!\u0010\"J\u0017\u0010#\u001a\u00020\t2\u0006\u0010 \u001a\u00020\u001fH\u0016¢\u0006\u0004\b#\u0010\"J!\u0010$\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u000f2\b\u0010 \u001a\u0004\u0018\u00010\u001fH\u0016¢\u0006\u0004\b$\u0010%J\u001f\u0010)\u001a\u00020\t2\u0006\u0010'\u001a\u00020&2\u0006\u0010(\u001a\u00020\u0007H\u0002¢\u0006\u0004\b)\u0010*R\"\u0010/\u001a\u0010\u0012\f\u0012\n ,*\u0004\u0018\u00010\u00070\u00070+8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010.R\u001a\u00103\u001a\b\u0012\u0004\u0012\u00020\u0019008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u00102R\u0018\u00107\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u00106R\u0016\u0010\u001d\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010;\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u00109¨\u0006="}, d2 = {"Lcom/martian/mibook/mvvm/yuewen/adapter/TYBookItemListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/martian/mibook/mvvm/yuewen/adapter/TYBookItemListAdapter$ViewHolder;", "Lcom/martian/mibook/mvvm/utils/RecyclerViewExposeManager$OnItemExposeListener;", "<init>", "()V", "", "Lcom/martian/mibook/lib/model/data/TYBookItem;", "newData", "", "q", "(Ljava/util/List;)V", "k", "Landroid/view/ViewGroup;", "parent", "", "viewType", "m", "(Landroid/view/ViewGroup;I)Lcom/martian/mibook/mvvm/yuewen/adapter/TYBookItemListAdapter$ViewHolder;", "holder", c.f26972i, t.f11204d, "(Lcom/martian/mibook/mvvm/yuewen/adapter/TYBookItemListAdapter$ViewHolder;I)V", "getItemCount", "()I", "", "type", "o", "(Ljava/lang/String;)V", "searchKeyword", "n", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "onAttachedToRecyclerView", "(Landroidx/recyclerview/widget/RecyclerView;)V", "onDetachedFromRecyclerView", "onItemViewVisible", "(ILandroidx/recyclerview/widget/RecyclerView;)V", "Landroid/content/Context;", f.X, "tyBookItem", "p", "(Landroid/content/Context;Lcom/martian/mibook/lib/model/data/TYBookItem;)V", "Landroidx/recyclerview/widget/AsyncListDiffer;", "kotlin.jvm.PlatformType", "c", "Landroidx/recyclerview/widget/AsyncListDiffer;", "mDiffer", "", "d", "Ljava/util/Set;", "sourceIdSet", "Lcom/martian/mibook/mvvm/utils/RecyclerViewExposeManager;", e.TAG, "Lcom/martian/mibook/mvvm/utils/RecyclerViewExposeManager;", "recyclerViewExposeManager", "f", "Ljava/lang/String;", "g", "source", "ViewHolder", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes3.dex */
public final class TYBookItemListAdapter extends RecyclerView.Adapter<ViewHolder> implements RecyclerViewExposeManager.OnItemExposeListener {

    /* renamed from: e */
    @l
    public RecyclerViewExposeManager recyclerViewExposeManager;

    /* renamed from: c, reason: from kotlin metadata */
    @k
    public final AsyncListDiffer<TYBookItem> mDiffer = new AsyncListDiffer<>(this, new DiffUtil.ItemCallback<TYBookItem>() { // from class: com.martian.mibook.mvvm.yuewen.adapter.TYBookItemListAdapter$mDiffer$1
        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        @SuppressLint({"DiffUtilEquals"})
        /* renamed from: a */
        public boolean areContentsTheSame(@k TYBookItem oldItem, @k TYBookItem newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return Intrinsics.areEqual(oldItem.getSourceId(), newItem.getSourceId()) && TextUtils.equals(oldItem.getBookName(), newItem.getBookName());
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        /* renamed from: b */
        public boolean areItemsTheSame(@k TYBookItem oldItem, @k TYBookItem newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return Intrinsics.areEqual(oldItem, newItem);
        }
    });

    /* renamed from: d, reason: from kotlin metadata */
    @k
    public final Set<String> sourceIdSet = new HashSet();

    /* renamed from: f, reason: from kotlin metadata */
    @k
    public String searchKeyword = "";

    /* renamed from: g, reason: from kotlin metadata */
    @k
    public String source = "";

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0019\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/martian/mibook/mvvm/yuewen/adapter/TYBookItemListAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/martian/mibook/databinding/ItemBookStoreBinding;", "binding", "<init>", "(Lcom/martian/mibook/mvvm/yuewen/adapter/TYBookItemListAdapter;Lcom/martian/mibook/databinding/ItemBookStoreBinding;)V", "", "name", "Landroid/text/SpannableString;", "g", "(Ljava/lang/String;)Landroid/text/SpannableString;", "Lcom/martian/mibook/lib/model/data/TYBookItem;", "bookItem", "", "c", "(Lcom/martian/mibook/lib/model/data/TYBookItem;)V", "Landroid/widget/TextView;", "textView", "h", "(Landroid/widget/TextView;Lcom/martian/mibook/lib/model/data/TYBookItem;)V", "b", "Lcom/martian/mibook/databinding/ItemBookStoreBinding;", "f", "()Lcom/martian/mibook/databinding/ItemBookStoreBinding;", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
    public final class ViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: b, reason: from kotlin metadata */
        @k
        public final ItemBookStoreBinding binding;

        /* renamed from: c */
        public final /* synthetic */ TYBookItemListAdapter f15533c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(@k TYBookItemListAdapter tYBookItemListAdapter, ItemBookStoreBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.f15533c = tYBookItemListAdapter;
            this.binding = binding;
        }

        public static final void d(TYBookItemListAdapter this$0, ViewHolder this$1, TYBookItem bookItem, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            Intrinsics.checkNotNullParameter(bookItem, "$bookItem");
            Context context = this$1.binding.getRoot().getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            this$0.p(context, bookItem);
        }

        public static final void e(TYBookItemListAdapter this$0, ViewHolder this$1, TYBookItem bookItem, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            Intrinsics.checkNotNullParameter(bookItem, "$bookItem");
            Context context = this$1.binding.getRoot().getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            this$0.p(context, bookItem);
        }

        private final SpannableString g(String name) {
            return ba.l.m(this.binding.getRoot().getContext(), name, this.f15533c.searchKeyword, R.color.theme_default);
        }

        public final void c(@k TYBookItem bookItem) {
            Intrinsics.checkNotNullParameter(bookItem, "bookItem");
            MiBookManager.u1(this.binding.getRoot().getContext(), bookItem, this.binding.bookCover);
            String y10 = ba.l.y(bookItem.getIntro());
            if (ba.l.q(this.f15533c.searchKeyword)) {
                this.binding.tvBookName.setText(ExtKt.c(bookItem.getTitle()));
                this.binding.tvBookAuthorName.setText(ExtKt.c(bookItem.getBookInfo()));
                this.binding.tvBookShortContent.setText(ExtKt.c(y10));
            } else {
                if (!ba.l.q(bookItem.getTitle())) {
                    String title = bookItem.getTitle();
                    Intrinsics.checkNotNullExpressionValue(title, "getTitle(...)");
                    if (StringsKt.contains$default((CharSequence) title, (CharSequence) this.f15533c.searchKeyword, false, 2, (Object) null)) {
                        ThemeTextView themeTextView = this.binding.tvBookName;
                        String c10 = ExtKt.c(bookItem.getTitle());
                        Intrinsics.checkNotNull(c10);
                        themeTextView.setText(g(c10));
                    } else {
                        this.binding.tvBookName.setText(ExtKt.c(bookItem.getTitle()));
                    }
                }
                StringBuilder sb2 = new StringBuilder();
                List<String> roleList = bookItem.getRoleList();
                if (roleList != null && !roleList.isEmpty()) {
                    sb2.append(this.binding.getRoot().getContext().getString(com.martian.mibook.R.string.lead) + "：");
                    for (String str : bookItem.getRoleList()) {
                        sb2.append(" ");
                        sb2.append(str);
                    }
                }
                String sb3 = sb2.toString();
                Intrinsics.checkNotNullExpressionValue(sb3, "toString(...)");
                if (StringsKt.contains$default((CharSequence) sb3, (CharSequence) this.f15533c.searchKeyword, false, 2, (Object) null)) {
                    ThemeTextView themeTextView2 = this.binding.tvBookAuthorName;
                    String c11 = ExtKt.c(sb2.toString());
                    Intrinsics.checkNotNull(c11);
                    themeTextView2.setText(g(c11));
                } else {
                    String bookInfo = bookItem.getBookInfo();
                    Intrinsics.checkNotNullExpressionValue(bookInfo, "getBookInfo(...)");
                    if (StringsKt.contains$default((CharSequence) bookInfo, (CharSequence) this.f15533c.searchKeyword, false, 2, (Object) null)) {
                        ThemeTextView themeTextView3 = this.binding.tvBookAuthorName;
                        String c12 = ExtKt.c(bookItem.getBookInfo());
                        Intrinsics.checkNotNull(c12);
                        themeTextView3.setText(g(c12));
                    } else {
                        this.binding.tvBookAuthorName.setText(ExtKt.c(bookItem.getBookInfo()));
                    }
                }
                if (!ba.l.q(y10)) {
                    Intrinsics.checkNotNull(y10);
                    if (StringsKt.contains$default((CharSequence) y10, (CharSequence) this.f15533c.searchKeyword, false, 2, (Object) null)) {
                        ThemeTextView themeTextView4 = this.binding.tvBookShortContent;
                        String c13 = ExtKt.c(y10);
                        Intrinsics.checkNotNull(c13);
                        themeTextView4.setText(g(c13));
                    } else {
                        this.binding.tvBookShortContent.setText(ExtKt.c(y10));
                    }
                }
            }
            this.binding.tvBookMark.setVisibility(8);
            TextView tvBookScore = this.binding.tvBookScore;
            Intrinsics.checkNotNullExpressionValue(tvBookScore, "tvBookScore");
            h(tvBookScore, bookItem);
            this.binding.getRoot().setOnClickListener(new View.OnClickListener() { // from class: td.y

                /* renamed from: c */
                public final /* synthetic */ TYBookItemListAdapter.ViewHolder f30857c;

                /* renamed from: d */
                public final /* synthetic */ TYBookItem f30858d;

                public /* synthetic */ y(TYBookItemListAdapter.ViewHolder this, TYBookItem bookItem2) {
                    this = this;
                    bookItem = bookItem2;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    TYBookItemListAdapter.ViewHolder.d(TYBookItemListAdapter.this, this, bookItem, view);
                }
            });
            this.binding.bookCover.setOnClickListener(new View.OnClickListener() { // from class: td.z

                /* renamed from: c */
                public final /* synthetic */ TYBookItemListAdapter.ViewHolder f30860c;

                /* renamed from: d */
                public final /* synthetic */ TYBookItem f30861d;

                public /* synthetic */ z(TYBookItemListAdapter.ViewHolder this, TYBookItem bookItem2) {
                    this = this;
                    bookItem = bookItem2;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    TYBookItemListAdapter.ViewHolder.e(TYBookItemListAdapter.this, this, bookItem, view);
                }
            });
        }

        @k
        /* renamed from: f, reason: from getter */
        public final ItemBookStoreBinding getBinding() {
            return this.binding;
        }

        public final void h(TextView textView, TYBookItem bookItem) {
            if (bookItem.getScore() <= 0) {
                textView.setVisibility(8);
                return;
            }
            textView.setVisibility(0);
            double score = bookItem.getScore() / 10.0d;
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format(Locale.getDefault(), "%.1f", Arrays.copyOf(new Object[]{Double.valueOf(score)}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(...)");
            textView.setText(format + "分");
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getPageSize() {
        return this.mDiffer.getCurrentList().size();
    }

    public final void k(@l List<? extends TYBookItem> newData) {
        List<? extends TYBookItem> list = newData;
        if (list == null || list.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.mDiffer.getCurrentList());
        arrayList.addAll(list);
        this.mDiffer.submitList(arrayList);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: l */
    public void onBindViewHolder(@k ViewHolder holder, int i10) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        TYBookItem tYBookItem = this.mDiffer.getCurrentList().get(i10);
        if (tYBookItem != null) {
            holder.c(tYBookItem);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @k
    /* renamed from: m */
    public ViewHolder onCreateViewHolder(@k ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        ItemBookStoreBinding inflate = ItemBookStoreBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return new ViewHolder(this, inflate);
    }

    public final void n(@k String searchKeyword) {
        Intrinsics.checkNotNullParameter(searchKeyword, "searchKeyword");
        this.searchKeyword = searchKeyword;
    }

    public final void o(@k String type) {
        Intrinsics.checkNotNullParameter(type, "type");
        this.source = type;
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
            TYBookItem tYBookItem = this.mDiffer.getCurrentList().get(r92);
            Intrinsics.checkNotNullExpressionValue(tYBookItem, "get(...)");
            TYBookItem tYBookItem2 = tYBookItem;
            if (this.sourceIdSet.contains(tYBookItem2.getSourceId())) {
                return;
            }
            if (r92 == 0) {
                Context context = recyclerView != null ? recyclerView.getContext() : null;
                a.K(context, tYBookItem2.getRecommend() + tYBookItem2.getSource(), "展示");
            }
            Set<String> set = this.sourceIdSet;
            String sourceId = tYBookItem2.getSourceId();
            Intrinsics.checkNotNullExpressionValue(sourceId, "getSourceId(...)");
            set.add(sourceId);
            MiConfigSingleton.b2().V1().g(0, tYBookItem2.getSourceName(), tYBookItem2.getSourceId(), tYBookItem2.getRecommendId(), "", "展示");
        }
    }

    public final void p(Context r62, TYBookItem tyBookItem) {
        if (!ba.l.q(this.source) && !ba.l.q(tyBookItem.getRecommend())) {
            String recommend = tyBookItem.getRecommend();
            Intrinsics.checkNotNullExpressionValue(recommend, "getRecommend(...)");
            if (!StringsKt.contains$default((CharSequence) recommend, (CharSequence) this.source, false, 2, (Object) null)) {
                tyBookItem.setRecommend(tyBookItem.getRecommend() + this.source);
            }
        }
        if (r62 instanceof Activity) {
            i.I((Activity) r62, tyBookItem, null);
        }
    }

    public final void q(@l List<? extends TYBookItem> newData) {
        this.mDiffer.submitList(newData);
        RecyclerViewExposeManager recyclerViewExposeManager = this.recyclerViewExposeManager;
        if (recyclerViewExposeManager != null) {
            RecyclerViewExposeManager.handleCurrentVisibleItems$default(recyclerViewExposeManager, true, 0L, 2, null);
        }
    }
}
