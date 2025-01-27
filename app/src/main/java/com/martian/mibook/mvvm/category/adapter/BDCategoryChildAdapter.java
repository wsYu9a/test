package com.martian.mibook.mvvm.category.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.martian.libmars.widget.linkage.BaseLinkageItem;
import com.martian.libmars.widget.linkage.BaseQuickLinkageAdapter;
import com.martian.mibook.activity.book.YWCategoriesActivity;
import com.martian.mibook.databinding.ItemCategoryChildTagBinding;
import com.martian.mibook.databinding.ItemCategoryChildTitleBinding;
import com.martian.mibook.fragment.yuewen.YWCategoriesBookListFragment;
import com.martian.mibook.lib.yuewen.response.TYCategoryTagItem;
import com.martian.mibook.lib.yuewen.response.YWCategory;
import com.martian.mibook.mvvm.category.viewmodel.CategoryItemInfo;
import com.martian.mibook.mvvm.extensions.ExtKt;
import id.c;
import kc.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import xi.k;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 \u00182\u00020\u0001:\u0003\u0019\u001a\u001bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0017\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u001c"}, d2 = {"Lcom/martian/mibook/mvvm/category/adapter/BDCategoryChildAdapter;", "Lcom/martian/libmars/widget/linkage/BaseQuickLinkageAdapter;", "<init>", "()V", "", "type", "", IAdInterListener.AdReqParam.WIDTH, "(I)V", c.f26972i, "getItemViewType", "(I)I", "Landroid/view/ViewGroup;", "parent", "viewType", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "holder", "onBindViewHolder", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;I)V", "g", "I", "freeType", "h", "a", "TagViewHolder", "TitleViewHolder", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes3.dex */
public final class BDCategoryChildAdapter extends BaseQuickLinkageAdapter {

    /* renamed from: i */
    public static final int f14190i = 1;

    /* renamed from: j */
    public static final int f14191j = 2;

    /* renamed from: g, reason: from kotlin metadata */
    public int freeType;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/martian/mibook/mvvm/category/adapter/BDCategoryChildAdapter$TagViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/martian/mibook/databinding/ItemCategoryChildTagBinding;", "binding", "<init>", "(Lcom/martian/mibook/mvvm/category/adapter/BDCategoryChildAdapter;Lcom/martian/mibook/databinding/ItemCategoryChildTagBinding;)V", "Lcom/martian/mibook/mvvm/category/viewmodel/CategoryItemInfo;", "item", "", "b", "(Lcom/martian/mibook/mvvm/category/viewmodel/CategoryItemInfo;)V", "Lcom/martian/mibook/databinding/ItemCategoryChildTagBinding;", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
    public final class TagViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: b, reason: from kotlin metadata */
        @k
        public final ItemCategoryChildTagBinding binding;

        /* renamed from: c */
        public final /* synthetic */ BDCategoryChildAdapter f14194c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TagViewHolder(@k BDCategoryChildAdapter bDCategoryChildAdapter, ItemCategoryChildTagBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.f14194c = bDCategoryChildAdapter;
            this.binding = binding;
        }

        public static final void c(TYCategoryTagItem this_apply, TagViewHolder this$0, BDCategoryChildAdapter this$1, View view) {
            Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            if (this_apply.getCategoryId() <= 0) {
                String name = this_apply.getName();
                Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
                int i10 = this$1.freeType;
                Integer from = this_apply.getFrom();
                Intrinsics.checkNotNullExpressionValue(from, "getFrom(...)");
                b.B(name, i10, from.intValue());
                return;
            }
            Integer from2 = this_apply.getFrom();
            int intValue = from2 == null ? YWCategoriesBookListFragment.P : from2.intValue();
            Context context = this$0.binding.getRoot().getContext();
            Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
            YWCategory yWCategory = new YWCategory();
            yWCategory.setCategoryName(this_apply.getName());
            yWCategory.setCategoryId(Integer.valueOf(yWCategory.getCategoryId()));
            YWCategoriesActivity.L2((Activity) context, yWCategory, this$1.freeType, -1, intValue);
        }

        /*  JADX ERROR: JadxRuntimeException in pass: ProcessVariables
            jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: rc.a.<init>(com.martian.mibook.lib.yuewen.response.TYCategoryTagItem, com.martian.mibook.mvvm.category.adapter.BDCategoryChildAdapter$TagViewHolder, com.martian.mibook.mvvm.category.adapter.BDCategoryChildAdapter):void, class status: GENERATED_AND_UNLOADED
            	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:290)
            	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.isArgUnused(ProcessVariables.java:146)
            	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.lambda$isVarUnused$0(ProcessVariables.java:131)
            	at jadx.core.utils.ListUtils.allMatch(ListUtils.java:193)
            	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.isVarUnused(ProcessVariables.java:131)
            	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.processBlock(ProcessVariables.java:82)
            	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:64)
            	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
            	at java.base/java.util.ArrayList.forEach(Unknown Source)
            	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
            	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
            	at java.base/java.util.ArrayList.forEach(Unknown Source)
            	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Unknown Source)
            	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
            	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
            	at java.base/java.util.ArrayList.forEach(Unknown Source)
            	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
            	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
            	at java.base/java.util.ArrayList.forEach(Unknown Source)
            	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
            	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:19)
            	at jadx.core.dex.visitors.regions.variables.ProcessVariables.removeUnusedResults(ProcessVariables.java:73)
            	at jadx.core.dex.visitors.regions.variables.ProcessVariables.visit(ProcessVariables.java:48)
            */
        public final void b(@xi.k com.martian.mibook.mvvm.category.viewmodel.CategoryItemInfo r4) {
            /*
                r3 = this;
                java.lang.String r0 = "item"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
                com.martian.mibook.lib.yuewen.response.TYCategoryTagItem r4 = r4.getData()
                if (r4 == 0) goto L54
                com.martian.mibook.mvvm.category.adapter.BDCategoryChildAdapter r0 = r3.f14194c
                com.martian.mibook.databinding.ItemCategoryChildTagBinding r1 = r3.binding
                com.martian.libmars.ui.theme.ThemeTextView r1 = r1.tvPageName
                java.lang.String r2 = r4.getName()
                java.lang.String r2 = com.martian.mibook.mvvm.extensions.ExtKt.c(r2)
                r1.setText(r2)
                java.lang.String r1 = r4.getCoverUrl()
                boolean r1 = ba.l.q(r1)
                if (r1 == 0) goto L54
                com.martian.mibook.databinding.ItemCategoryChildTagBinding r1 = r3.binding
                android.widget.ImageView r1 = r1.tvPageCover
                r2 = 8
                r1.setVisibility(r2)
                com.martian.mibook.databinding.ItemCategoryChildTagBinding r1 = r3.binding
                com.martian.mibook.ui.CircleImageView r1 = r1.tvPageIcon
                r1.setVisibility(r2)
                com.martian.mibook.databinding.ItemCategoryChildTagBinding r1 = r3.binding
                com.martian.libmars.ui.theme.ThemeTextView r1 = r1.tvPageName
                r2 = 17
                r1.setGravity(r2)
                com.martian.mibook.databinding.ItemCategoryChildTagBinding r1 = r3.binding
                com.martian.libmars.ui.theme.ThemeTextView r1 = r1.tvPageName
                r2 = 1096810496(0x41600000, float:14.0)
                r1.setTextSize(r2)
                com.martian.mibook.databinding.ItemCategoryChildTagBinding r1 = r3.binding
                com.martian.libmars.ui.theme.ThemeLinearLayout r1 = r1.categoryRootView
                rc.a r2 = new rc.a
                r2.<init>()
                r1.setOnClickListener(r2)
            L54:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.martian.mibook.mvvm.category.adapter.BDCategoryChildAdapter.TagViewHolder.b(com.martian.mibook.mvvm.category.viewmodel.CategoryItemInfo):void");
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/martian/mibook/mvvm/category/adapter/BDCategoryChildAdapter$TitleViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/martian/mibook/databinding/ItemCategoryChildTitleBinding;", "binding", "<init>", "(Lcom/martian/mibook/mvvm/category/adapter/BDCategoryChildAdapter;Lcom/martian/mibook/databinding/ItemCategoryChildTitleBinding;)V", "Lcom/martian/mibook/mvvm/category/viewmodel/CategoryItemInfo;", "item", "", "a", "(Lcom/martian/mibook/mvvm/category/viewmodel/CategoryItemInfo;)V", "b", "Lcom/martian/mibook/databinding/ItemCategoryChildTitleBinding;", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
    public final class TitleViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: b, reason: from kotlin metadata */
        @k
        public final ItemCategoryChildTitleBinding binding;

        /* renamed from: c */
        public final /* synthetic */ BDCategoryChildAdapter f14196c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TitleViewHolder(@k BDCategoryChildAdapter bDCategoryChildAdapter, ItemCategoryChildTitleBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.f14196c = bDCategoryChildAdapter;
            this.binding = binding;
        }

        public final void a(@k CategoryItemInfo item) {
            Intrinsics.checkNotNullParameter(item, "item");
            this.binding.categoryTitle.setText(ExtKt.c(item.getItemName()));
        }
    }

    public BDCategoryChildAdapter() {
        super(null, 1, null);
        this.freeType = 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int r22) {
        BaseLinkageItem baseLinkageItem = n().get(r22);
        Intrinsics.checkNotNull(baseLinkageItem, "null cannot be cast to non-null type com.martian.mibook.mvvm.category.viewmodel.CategoryItemInfo");
        return ((CategoryItemInfo) baseLinkageItem).getData() == null ? 1 : 2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@k RecyclerView.ViewHolder holder, int r42) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        BaseLinkageItem baseLinkageItem = n().get(r42);
        Intrinsics.checkNotNull(baseLinkageItem, "null cannot be cast to non-null type com.martian.mibook.mvvm.category.viewmodel.CategoryItemInfo");
        CategoryItemInfo categoryItemInfo = (CategoryItemInfo) baseLinkageItem;
        int itemViewType = holder.getItemViewType();
        if (itemViewType == 1) {
            ((TitleViewHolder) holder).a(categoryItemInfo);
        } else {
            if (itemViewType != 2) {
                return;
            }
            ((TagViewHolder) holder).b(categoryItemInfo);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @k
    public RecyclerView.ViewHolder onCreateViewHolder(@k ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        LayoutInflater from = LayoutInflater.from(parent.getContext());
        if (viewType == 1) {
            ItemCategoryChildTitleBinding inflate = ItemCategoryChildTitleBinding.inflate(from, parent, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
            return new TitleViewHolder(this, inflate);
        }
        if (viewType != 2) {
            throw new IllegalArgumentException("Invalid view type");
        }
        ItemCategoryChildTagBinding inflate2 = ItemCategoryChildTagBinding.inflate(from, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate2, "inflate(...)");
        return new TagViewHolder(this, inflate2);
    }

    public final void w(int i10) {
        this.freeType = i10;
    }
}
