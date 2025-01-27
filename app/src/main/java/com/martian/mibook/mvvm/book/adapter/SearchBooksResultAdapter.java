package com.martian.mibook.mvvm.book.adapter;

import ac.a;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.kuaishou.weapon.p0.t;
import com.kwad.sdk.m.e;
import com.martian.libmars.common.ConfigSingleton;
import com.martian.libmars.ui.theme.ThemeLinearLayout;
import com.martian.mibook.R;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.databinding.ItemBookMallTypeRecommendBookBinding;
import com.martian.mibook.databinding.ItemSearchBookViewTitleBinding;
import com.martian.mibook.databinding.ItemSearchCategoryBookViewBinding;
import com.martian.mibook.lib.model.data.TYBookItem;
import com.martian.mibook.lib.yuewen.response.YWCategory;
import com.martian.mibook.mvvm.book.adapter.SearchBooksResultAdapter;
import com.martian.mibook.mvvm.extensions.ExtKt;
import com.martian.mibook.mvvm.utils.RecyclerViewExposeManager;
import com.martian.mibook.mvvm.widget.HorizontalSpaceItemDecoration;
import com.umeng.analytics.pro.f;
import id.c;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import je.i;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010#\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 I2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0004JKLMB\u0007¢\u0006\u0004\b\u0004\u0010\u0005JW\u0010\u0012\u001a\u00020\u00112\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\b\u0010\f\u001a\u0004\u0018\u00010\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0007¢\u0006\u0004\b\u0012\u0010\u0013J\u001d\u0010\u0015\u001a\u00020\u00112\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0011H\u0007¢\u0006\u0004\b\u0017\u0010\u0005J\u0017\u0010\u0019\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u001f\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\rH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\rH\u0016¢\u0006\u0004\b \u0010!J-\u0010&\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\r2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020$0#H\u0016¢\u0006\u0004\b&\u0010'J\u001f\u0010&\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\rH\u0016¢\u0006\u0004\b&\u0010(J\u0017\u0010+\u001a\u00020\u00112\u0006\u0010*\u001a\u00020)H\u0016¢\u0006\u0004\b+\u0010,J\u0017\u0010-\u001a\u00020\u00112\u0006\u0010*\u001a\u00020)H\u0016¢\u0006\u0004\b-\u0010,J!\u0010.\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\r2\b\u0010*\u001a\u0004\u0018\u00010)H\u0016¢\u0006\u0004\b.\u0010/R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u00101R\u001e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010#8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u00103R\u001e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010#8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u00103R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u00101R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u00107R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010=\u001a\u00020:8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b;\u0010<R\u0014\u0010@\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b>\u0010?R\u001a\u0010D\u001a\b\u0012\u0004\u0012\u00020\u00060A8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bB\u0010CR\u0018\u0010H\u001a\u0004\u0018\u00010E8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bF\u0010G¨\u0006N"}, d2 = {"Lcom/martian/mibook/mvvm/book/adapter/SearchBooksResultAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/martian/mibook/mvvm/utils/RecyclerViewExposeManager$OnItemExposeListener;", "<init>", "()V", "", "searchKeyword", "", "Lcom/martian/mibook/lib/model/data/TYBookItem;", "categoryBookList", "searchBookList", "searchCategoryTag", "", "searchCategoryTagFreetype", "Lcom/martian/mibook/lib/yuewen/response/YWCategory;", "searchCategory", "", t.f11211k, "(Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/Integer;Lcom/martian/mibook/lib/yuewen/response/YWCategory;)V", "bookList", "q", "(Ljava/util/List;)V", "clear", c.f26972i, "getItemViewType", "(I)I", "Landroid/view/ViewGroup;", "parent", "viewType", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "getItemCount", "()I", "holder", "", "", "payloads", "onBindViewHolder", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;ILjava/util/List;)V", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;I)V", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "onAttachedToRecyclerView", "(Landroidx/recyclerview/widget/RecyclerView;)V", "onDetachedFromRecyclerView", "onItemViewVisible", "(ILandroidx/recyclerview/widget/RecyclerView;)V", "c", "Ljava/lang/String;", "d", "Ljava/util/List;", e.TAG, "f", "g", "Ljava/lang/Integer;", "h", "Lcom/martian/mibook/lib/yuewen/response/YWCategory;", "", "i", "Z", "isResetCategoryBookList", "j", "I", "bottomMargin", "", "k", "Ljava/util/Set;", "sourceIdSet", "Lcom/martian/mibook/mvvm/utils/RecyclerViewExposeManager;", t.f11204d, "Lcom/martian/mibook/mvvm/utils/RecyclerViewExposeManager;", "recyclerViewExposeManager", "m", "CategoryBookViewHolder", "a", "SearchBookViewHolder", "SearchBookViewTitleHolder", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes3.dex */
public final class SearchBooksResultAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements RecyclerViewExposeManager.OnItemExposeListener {

    /* renamed from: n */
    public static final int f14098n = 0;

    /* renamed from: o */
    public static final int f14099o = 1;

    /* renamed from: p */
    public static final int f14100p = 2;

    /* renamed from: c, reason: from kotlin metadata */
    @l
    public String searchKeyword;

    /* renamed from: d, reason: from kotlin metadata */
    @l
    public List<TYBookItem> categoryBookList;

    /* renamed from: e */
    @l
    public List<TYBookItem> searchBookList;

    /* renamed from: f, reason: from kotlin metadata */
    @l
    public String searchCategoryTag;

    /* renamed from: g, reason: from kotlin metadata */
    @l
    public Integer searchCategoryTagFreetype;

    /* renamed from: h, reason: from kotlin metadata */
    @l
    public YWCategory searchCategory;

    /* renamed from: i, reason: from kotlin metadata */
    public boolean isResetCategoryBookList;

    /* renamed from: j, reason: from kotlin metadata */
    public final int bottomMargin = ConfigSingleton.i(10.0f);

    /* renamed from: k, reason: from kotlin metadata */
    @k
    public final Set<String> sourceIdSet = new HashSet();

    /* renamed from: l */
    @l
    public RecyclerViewExposeManager recyclerViewExposeManager;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u0010\u001a\n \u000e*\u0004\u0018\u00010\r0\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u000fR\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\u0012¨\u0006\u0014"}, d2 = {"Lcom/martian/mibook/mvvm/book/adapter/SearchBooksResultAdapter$CategoryBookViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/martian/mibook/databinding/ItemSearchCategoryBookViewBinding;", "binding", "<init>", "(Lcom/martian/mibook/mvvm/book/adapter/SearchBooksResultAdapter;Lcom/martian/mibook/databinding/ItemSearchCategoryBookViewBinding;)V", "", "c", "()V", "b", "Lcom/martian/mibook/databinding/ItemSearchCategoryBookViewBinding;", "d", "()Lcom/martian/mibook/databinding/ItemSearchCategoryBookViewBinding;", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "Landroid/content/Context;", f.X, "Lcom/martian/mibook/mvvm/book/adapter/SearchCategoryBooksAdapter;", "Lcom/martian/mibook/mvvm/book/adapter/SearchCategoryBooksAdapter;", "categoryBooksAdapter", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
    public final class CategoryBookViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: b, reason: from kotlin metadata */
        @k
        public final ItemSearchCategoryBookViewBinding binding;

        /* renamed from: c, reason: from kotlin metadata */
        public final Context com.umeng.analytics.pro.f.X java.lang.String;

        /* renamed from: d, reason: from kotlin metadata */
        @l
        public SearchCategoryBooksAdapter categoryBooksAdapter;

        /* renamed from: e */
        public final /* synthetic */ SearchBooksResultAdapter f14114e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CategoryBookViewHolder(@k SearchBooksResultAdapter searchBooksResultAdapter, ItemSearchCategoryBookViewBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.f14114e = searchBooksResultAdapter;
            this.binding = binding;
            Context context = binding.getRoot().getContext();
            this.com.umeng.analytics.pro.f.X java.lang.String = context;
            binding.getRoot().setOnClickListener(new View.OnClickListener() { // from class: nc.c
                public /* synthetic */ c() {
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SearchBooksResultAdapter.CategoryBookViewHolder.b(SearchBooksResultAdapter.this, view);
                }
            });
            if (binding.rvBooks.getLayoutManager() == null) {
                binding.rvBooks.setLayoutManager(new LinearLayoutManager(context, 0, false));
                binding.rvBooks.addItemDecoration(new HorizontalSpaceItemDecoration(ConfigSingleton.i(12.0f)));
            }
            if (this.categoryBooksAdapter == null) {
                SearchCategoryBooksAdapter searchCategoryBooksAdapter = new SearchCategoryBooksAdapter();
                this.categoryBooksAdapter = searchCategoryBooksAdapter;
                binding.rvBooks.setAdapter(searchCategoryBooksAdapter);
            }
            SearchCategoryBooksAdapter searchCategoryBooksAdapter2 = this.categoryBooksAdapter;
            if (searchCategoryBooksAdapter2 != null) {
                searchCategoryBooksAdapter2.l(searchBooksResultAdapter.categoryBookList);
            }
        }

        public static final void b(SearchBooksResultAdapter this$0, View view) {
            String categoryName;
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (this$0.searchCategory == null) {
                categoryName = this$0.searchCategoryTag;
            } else {
                YWCategory yWCategory = this$0.searchCategory;
                categoryName = yWCategory != null ? yWCategory.getCategoryName() : null;
            }
            if (categoryName == null) {
                return;
            }
            Integer num = this$0.searchCategoryTagFreetype;
            i.b0(num != null ? num.intValue() : 0, categoryName, 4);
        }

        public final void c() {
            Context context;
            int i10;
            this.binding.searchTagName.setText(ExtKt.c(this.f14114e.searchCategoryTag));
            TextView textView = this.binding.searchTagType;
            if (this.f14114e.searchCategory == null) {
                context = this.com.umeng.analytics.pro.f.X java.lang.String;
                i10 = R.string.tag;
            } else {
                context = this.com.umeng.analytics.pro.f.X java.lang.String;
                i10 = R.string.classification;
            }
            textView.setText(context.getString(i10));
            if (this.f14114e.isResetCategoryBookList) {
                this.f14114e.isResetCategoryBookList = false;
                SearchCategoryBooksAdapter searchCategoryBooksAdapter = this.categoryBooksAdapter;
                if (searchCategoryBooksAdapter != null) {
                    searchCategoryBooksAdapter.l(this.f14114e.categoryBookList);
                }
            }
        }

        @k
        /* renamed from: d, reason: from getter */
        public final ItemSearchCategoryBookViewBinding getBinding() {
            return this.binding;
        }
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J!\u0010\u000b\u001a\u00020\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\bH\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\r\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\u001b\u001a\n \u0018*\u0004\u0018\u00010\u00170\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\t\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u001c¨\u0006\u001d"}, d2 = {"Lcom/martian/mibook/mvvm/book/adapter/SearchBooksResultAdapter$SearchBookViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/martian/mibook/databinding/ItemBookMallTypeRecommendBookBinding;", "binding", "<init>", "(Lcom/martian/mibook/mvvm/book/adapter/SearchBooksResultAdapter;Lcom/martian/mibook/databinding/ItemBookMallTypeRecommendBookBinding;)V", "Lcom/martian/mibook/lib/model/data/TYBookItem;", "bookItem", "", "isLastSearchBook", "", "b", "(Lcom/martian/mibook/lib/model/data/TYBookItem;Z)V", "f", "(Z)V", "", "content", "Landroid/text/SpannableString;", e.TAG, "(Ljava/lang/String;)Landroid/text/SpannableString;", "Lcom/martian/mibook/databinding/ItemBookMallTypeRecommendBookBinding;", "d", "()Lcom/martian/mibook/databinding/ItemBookMallTypeRecommendBookBinding;", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "c", "Landroid/content/Context;", f.X, "Z", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
    public final class SearchBookViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: b, reason: from kotlin metadata */
        @k
        public final ItemBookMallTypeRecommendBookBinding binding;

        /* renamed from: c, reason: from kotlin metadata */
        public final Context com.umeng.analytics.pro.f.X java.lang.String;

        /* renamed from: d, reason: from kotlin metadata */
        public boolean isLastSearchBook;

        /* renamed from: e */
        public final /* synthetic */ SearchBooksResultAdapter f14118e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SearchBookViewHolder(@k SearchBooksResultAdapter searchBooksResultAdapter, ItemBookMallTypeRecommendBookBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.f14118e = searchBooksResultAdapter;
            this.binding = binding;
            this.com.umeng.analytics.pro.f.X java.lang.String = binding.getRoot().getContext();
        }

        public static final void c(SearchBookViewHolder this$0, TYBookItem tYBookItem, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Context context = this$0.com.umeng.analytics.pro.f.X java.lang.String;
            Activity activity = context instanceof Activity ? (Activity) context : null;
            if (activity != null) {
                i.H(activity, tYBookItem);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:23:0x01cf  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x0214  */
        @android.annotation.SuppressLint({"SetTextI18n"})
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void b(@xi.l com.martian.mibook.lib.model.data.TYBookItem r10, boolean r11) {
            /*
                Method dump skipped, instructions count: 559
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.martian.mibook.mvvm.book.adapter.SearchBooksResultAdapter.SearchBookViewHolder.b(com.martian.mibook.lib.model.data.TYBookItem, boolean):void");
        }

        @k
        /* renamed from: d, reason: from getter */
        public final ItemBookMallTypeRecommendBookBinding getBinding() {
            return this.binding;
        }

        public final SpannableString e(String str) {
            SpannableString m10 = ba.l.m(this.com.umeng.analytics.pro.f.X java.lang.String, ExtKt.c(str), ExtKt.c(this.f14118e.searchKeyword), com.martian.libmars.R.color.theme_default);
            Intrinsics.checkNotNullExpressionValue(m10, "getSpannableString(...)");
            return m10;
        }

        public final void f(boolean isLastSearchBook) {
            ThemeLinearLayout root = this.binding.getRoot();
            if (!(root instanceof ThemeLinearLayout)) {
                root = null;
            }
            if (root != null) {
                SearchBooksResultAdapter searchBooksResultAdapter = this.f14118e;
                root.setBackgroundType(isLastSearchBook ? 22 : 23);
                ViewGroup.LayoutParams layoutParams = root.getLayoutParams();
                Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = isLastSearchBook ? searchBooksResultAdapter.bottomMargin : 0;
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/martian/mibook/mvvm/book/adapter/SearchBooksResultAdapter$SearchBookViewTitleHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/martian/mibook/databinding/ItemSearchBookViewTitleBinding;", "binding", "<init>", "(Lcom/martian/mibook/mvvm/book/adapter/SearchBooksResultAdapter;Lcom/martian/mibook/databinding/ItemSearchBookViewTitleBinding;)V", "", "a", "()V", "b", "Lcom/martian/mibook/databinding/ItemSearchBookViewTitleBinding;", "()Lcom/martian/mibook/databinding/ItemSearchBookViewTitleBinding;", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
    public final class SearchBookViewTitleHolder extends RecyclerView.ViewHolder {

        /* renamed from: b, reason: from kotlin metadata */
        @k
        public final ItemSearchBookViewTitleBinding binding;

        /* renamed from: c */
        public final /* synthetic */ SearchBooksResultAdapter f14120c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SearchBookViewTitleHolder(@k SearchBooksResultAdapter searchBooksResultAdapter, ItemSearchBookViewTitleBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.f14120c = searchBooksResultAdapter;
            this.binding = binding;
        }

        public final void a() {
            this.binding.contentTitle.setText(ExtKt.c("搜索结果"));
        }

        @k
        /* renamed from: b, reason: from getter */
        public final ItemSearchBookViewTitleBinding getBinding() {
            return this.binding;
        }
    }

    @SuppressLint({"NotifyDataSetChanged"})
    public final void clear() {
        List<TYBookItem> list;
        List<TYBookItem> list2 = this.categoryBookList;
        if ((list2 == null || list2.isEmpty()) && ((list = this.searchBookList) == null || list.isEmpty())) {
            return;
        }
        List<TYBookItem> list3 = this.categoryBookList;
        if (list3 != null) {
            list3.clear();
        }
        List<TYBookItem> list4 = this.searchBookList;
        if (list4 != null) {
            list4.clear();
        }
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getPageSize() {
        List<TYBookItem> list = this.categoryBookList;
        int i10 = ((list == null || list.isEmpty()) ? 1 : 0) ^ 1;
        List<TYBookItem> list2 = this.searchBookList;
        if (list2 != null && !list2.isEmpty()) {
            List<TYBookItem> list3 = this.searchBookList;
            r2 = (list3 != null ? list3.size() : 0) + 1;
        }
        return i10 + r2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int r52) {
        List<TYBookItem> list = this.categoryBookList;
        boolean z10 = !(list == null || list.isEmpty());
        List<TYBookItem> list2 = this.searchBookList;
        boolean z11 = !(list2 == null || list2.isEmpty());
        if (!z10) {
            return (z11 && r52 == 0) ? 1 : 0;
        }
        if (r52 == 0) {
            return 2;
        }
        return (z11 && r52 == 1) ? 1 : 0;
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
    public void onBindViewHolder(@k RecyclerView.ViewHolder holder, int r42, @k List<Object> payloads) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        if (!(!payloads.isEmpty())) {
            onBindViewHolder(holder, r42);
        } else if ((holder instanceof SearchBookViewHolder) && Intrinsics.areEqual(payloads.get(0), (Object) 1)) {
            ((SearchBookViewHolder) holder).f(false);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @k
    public RecyclerView.ViewHolder onCreateViewHolder(@k ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (viewType == 1) {
            ItemSearchBookViewTitleBinding inflate = ItemSearchBookViewTitleBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
            return new SearchBookViewTitleHolder(this, inflate);
        }
        if (viewType != 2) {
            ItemBookMallTypeRecommendBookBinding inflate2 = ItemBookMallTypeRecommendBookBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
            Intrinsics.checkNotNullExpressionValue(inflate2, "inflate(...)");
            return new SearchBookViewHolder(this, inflate2);
        }
        ItemSearchCategoryBookViewBinding inflate3 = ItemSearchCategoryBookViewBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate3, "inflate(...)");
        return new CategoryBookViewHolder(this, inflate3);
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
    public void onItemViewVisible(int r10, @l RecyclerView recyclerView) {
        if (getPageSize() <= r10) {
            return;
        }
        List<TYBookItem> list = this.categoryBookList;
        int i10 = ((list == null || list.isEmpty()) ? 1 : 0) ^ 1;
        if (getItemViewType(r10) == 0) {
            List<TYBookItem> list2 = this.searchBookList;
            int i11 = i10 + (((list2 == null || list2.isEmpty()) ? 1 : 0) ^ 1);
            int i12 = r10 - i11;
            List<TYBookItem> list3 = this.searchBookList;
            TYBookItem tYBookItem = list3 != null ? list3.get(i12) : null;
            if (tYBookItem == null || this.sourceIdSet.contains(tYBookItem.getSourceId())) {
                return;
            }
            if (r10 == i11) {
                Context context = recyclerView != null ? recyclerView.getContext() : null;
                a.K(context, tYBookItem.getRecommend() + tYBookItem.getSource(), "展示");
            }
            Set<String> set = this.sourceIdSet;
            String sourceId = tYBookItem.getSourceId();
            Intrinsics.checkNotNullExpressionValue(sourceId, "getSourceId(...)");
            set.add(sourceId);
            MiConfigSingleton.b2().V1().g(0, tYBookItem.getSourceName(), tYBookItem.getSourceId(), tYBookItem.getRecommendId(), "", "展示");
        }
    }

    public final void q(@l List<? extends TYBookItem> bookList) {
        List<? extends TYBookItem> list = bookList;
        if (list == null || list.isEmpty()) {
            return;
        }
        int pageSize = getPageSize();
        List<TYBookItem> list2 = this.searchBookList;
        if (list2 != null) {
            list2.addAll(list);
        }
        if (pageSize > 0) {
            notifyItemChanged(pageSize - 1, 1);
        }
        notifyItemRangeInserted(pageSize, bookList.size());
    }

    @SuppressLint({"NotifyDataSetChanged"})
    public final void r(@l String str, @l List<? extends TYBookItem> list, @l List<? extends TYBookItem> list2, @l String str2, @l Integer num, @l YWCategory yWCategory) {
        List<TYBookItem> list3;
        List<TYBookItem> list4 = this.categoryBookList;
        this.searchKeyword = str;
        this.categoryBookList = list != null ? CollectionsKt.toMutableList((Collection) list) : null;
        this.searchBookList = list2 != null ? CollectionsKt.toMutableList((Collection) list2) : null;
        this.searchCategoryTag = str2;
        this.searchCategoryTagFreetype = num;
        this.searchCategory = yWCategory;
        List<TYBookItem> list5 = list4;
        if (list5 != null && !list5.isEmpty() && (list3 = this.searchBookList) != null && !list3.isEmpty()) {
            this.isResetCategoryBookList = true;
        }
        notifyDataSetChanged();
        RecyclerViewExposeManager recyclerViewExposeManager = this.recyclerViewExposeManager;
        if (recyclerViewExposeManager != null) {
            RecyclerViewExposeManager.handleCurrentVisibleItems$default(recyclerViewExposeManager, true, 0L, 2, null);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@k RecyclerView.ViewHolder holder, int r62) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        if (holder instanceof CategoryBookViewHolder) {
            ((CategoryBookViewHolder) holder).c();
            return;
        }
        if (holder instanceof SearchBookViewTitleHolder) {
            ((SearchBookViewTitleHolder) holder).a();
            return;
        }
        if (holder instanceof SearchBookViewHolder) {
            List<TYBookItem> list = this.categoryBookList;
            boolean z10 = false;
            int i10 = ((list == null || list.isEmpty()) ? 1 : 0) ^ 1;
            List<TYBookItem> list2 = this.searchBookList;
            int i11 = ((list2 == null || list2.isEmpty()) ? 1 : 0) ^ 1;
            int i12 = (r62 - i10) - i11;
            if (i11 != 0) {
                List<TYBookItem> list3 = this.searchBookList;
                Intrinsics.checkNotNull(list3);
                if (i12 == list3.size() - 1) {
                    z10 = true;
                }
            }
            SearchBookViewHolder searchBookViewHolder = (SearchBookViewHolder) holder;
            List<TYBookItem> list4 = this.searchBookList;
            searchBookViewHolder.b(list4 != null ? list4.get(i12) : null, z10);
        }
    }
}
