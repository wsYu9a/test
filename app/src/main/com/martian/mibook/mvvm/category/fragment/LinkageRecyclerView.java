package com.martian.mibook.mvvm.category.fragment;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import com.kuaishou.weapon.p0.t;
import com.kwad.sdk.m.e;
import com.martian.libmars.common.ConfigSingleton;
import com.martian.libmars.widget.linkage.BaseLinkageItem;
import com.martian.libmars.widget.linkage.BaseQuickLinkageAdapter;
import com.martian.libmars.widget.linkage.MultiLevelRecyclerView;
import com.martian.mibook.mvvm.category.fragment.LinkageRecyclerView;
import com.martian.mibook.mvvm.category.viewmodel.CategoryItemInfo;
import com.umeng.analytics.pro.f;
import id.c;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 (2\u00020\u0001:\u0002)*B\u001d\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J/\u0010\u000f\u001a\u00020\u000e2\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0013\u0010\u0012R\"\u0010\u001b\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u001c\u0010!\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010 R\u001c\u0010\"\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010 R&\u0010'\u001a\u0012\u0012\u0004\u0012\u00020\u001c0#j\b\u0012\u0004\u0012\u00020\u001c`$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010&¨\u0006+"}, d2 = {"Lcom/martian/mibook/mvvm/category/fragment/LinkageRecyclerView;", "Lcom/martian/libmars/widget/linkage/MultiLevelRecyclerView;", "Landroid/content/Context;", f.X, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "Lcom/martian/libmars/widget/linkage/BaseLinkageItem;", "linkageItems", "Lcom/martian/libmars/widget/linkage/BaseQuickLinkageAdapter;", "groupAdapter", "childAdapter", "", "d", "(Ljava/util/List;Lcom/martian/libmars/widget/linkage/BaseQuickLinkageAdapter;Lcom/martian/libmars/widget/linkage/BaseQuickLinkageAdapter;)V", e.TAG, "()V", "m", "", "k", "Z", "n", "()Z", "setScrollSmoothly", "(Z)V", "isScrollSmoothly", "", t.f11204d, "I", "mFirstVisiblePosition", "Ljava/util/List;", "groupList", "childList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "o", "Ljava/util/ArrayList;", "titlePositionList", "p", "a", "RecyclerViewSpacingItemDecoration", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nLinkageRecyclerView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LinkageRecyclerView.kt\ncom/martian/mibook/mvvm/category/fragment/LinkageRecyclerView\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,247:1\n1864#2,3:248\n*S KotlinDebug\n*F\n+ 1 LinkageRecyclerView.kt\ncom/martian/mibook/mvvm/category/fragment/LinkageRecyclerView\n*L\n60#1:248,3\n*E\n"})
/* loaded from: classes3.dex */
public final class LinkageRecyclerView extends MultiLevelRecyclerView {

    /* renamed from: p, reason: from kotlin metadata */
    @k
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: q */
    public static int f14205q = 3;

    /* renamed from: k, reason: from kotlin metadata */
    public boolean isScrollSmoothly;

    /* renamed from: l */
    public int mFirstVisiblePosition;

    /* renamed from: m, reason: from kotlin metadata */
    @k
    public List<BaseLinkageItem> groupList;

    /* renamed from: n, reason: from kotlin metadata */
    @k
    public List<BaseLinkageItem> childList;

    /* renamed from: o, reason: from kotlin metadata */
    @k
    public ArrayList<Integer> titlePositionList;

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\f\u0018\u00002\u00020\u0001BE\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003¢\u0006\u0004\b\u000b\u0010\fJ/\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J'\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u001c\u0010\u001dR\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010\u0005\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u0014\u0010\u0006\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010!R\u0014\u0010\u0007\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010!R\u0014\u0010\b\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010!R\u0014\u0010\t\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010!R\u0014\u0010\n\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010!¨\u0006'"}, d2 = {"Lcom/martian/mibook/mvvm/category/fragment/LinkageRecyclerView$RecyclerViewSpacingItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "", "", "titlePositionList", "horizontalSpacing", "verticalSpacing", "leftPadding", "rightPadding", "topPadding", "bottomPadding", "<init>", "(Ljava/util/List;IIIIII)V", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", "parent", "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "getItemOffsets", "(Landroid/graphics/Rect;Landroid/view/View;Landroidx/recyclerview/widget/RecyclerView;Landroidx/recyclerview/widget/RecyclerView$State;)V", c.f26972i, "spanCount", "totalItemCount", "", "a", "(III)Z", e.TAG, "Ljava/util/List;", "f", "I", "g", "h", "i", "j", "k", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
    public static final class RecyclerViewSpacingItemDecoration extends RecyclerView.ItemDecoration {

        /* renamed from: e */
        @k
        public final List<Integer> titlePositionList;

        /* renamed from: f, reason: from kotlin metadata */
        public final int horizontalSpacing;

        /* renamed from: g, reason: from kotlin metadata */
        public final int verticalSpacing;

        /* renamed from: h, reason: from kotlin metadata */
        public final int leftPadding;

        /* renamed from: i, reason: from kotlin metadata */
        public final int rightPadding;

        /* renamed from: j, reason: from kotlin metadata */
        public final int topPadding;

        /* renamed from: k, reason: from kotlin metadata */
        public final int bottomPadding;

        public RecyclerViewSpacingItemDecoration(@k List<Integer> titlePositionList, int i10, int i11, int i12, int i13, int i14, int i15) {
            Intrinsics.checkNotNullParameter(titlePositionList, "titlePositionList");
            this.titlePositionList = titlePositionList;
            this.horizontalSpacing = i10;
            this.verticalSpacing = i11;
            this.leftPadding = i12;
            this.rightPadding = i13;
            this.topPadding = i14;
            this.bottomPadding = i15;
        }

        public final boolean a(int r12, int spanCount, int totalItemCount) {
            return r12 >= totalItemCount - (totalItemCount % spanCount);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(@k Rect outRect, @k View view, @k RecyclerView parent, @k RecyclerView.State state) {
            int i10;
            Intrinsics.checkNotNullParameter(outRect, "outRect");
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(parent, "parent");
            Intrinsics.checkNotNullParameter(state, "state");
            RecyclerView.LayoutManager layoutManager = parent.getLayoutManager();
            if (layoutManager instanceof GridLayoutManager) {
                int childAdapterPosition = parent.getChildAdapterPosition(view);
                GridLayoutManager gridLayoutManager = (GridLayoutManager) layoutManager;
                int spanSize = gridLayoutManager.getSpanSizeLookup().getSpanSize(childAdapterPosition);
                RecyclerView.Adapter adapter = parent.getAdapter();
                int pageSize = adapter != null ? adapter.getPageSize() : 0;
                if (spanSize == LinkageRecyclerView.f14205q) {
                    outRect.left = this.leftPadding;
                    outRect.right = this.rightPadding;
                    int i11 = this.topPadding;
                    int i12 = this.verticalSpacing;
                    outRect.top = i11 + i12;
                    outRect.bottom = this.bottomPadding - (i12 / 2);
                    return;
                }
                Integer b10 = LinkageRecyclerView.INSTANCE.b(this.titlePositionList, childAdapterPosition);
                int intValue = childAdapterPosition - (b10 != null ? b10.intValue() : 0);
                boolean z10 = intValue % gridLayoutManager.getSpanCount() == 1;
                boolean z11 = intValue % gridLayoutManager.getSpanCount() == gridLayoutManager.getSpanCount() - LinkageRecyclerView.f14205q;
                outRect.left = z10 ? this.leftPadding : this.horizontalSpacing / 2;
                outRect.right = z11 ? this.rightPadding : this.horizontalSpacing / 2;
                outRect.top = this.verticalSpacing / 2;
                if (a(childAdapterPosition, gridLayoutManager.getSpanCount(), pageSize)) {
                    int i13 = this.bottomPadding;
                    int i14 = this.verticalSpacing;
                    i10 = i13 + i14 + (i14 / 2);
                } else {
                    i10 = this.verticalSpacing / 2;
                }
                outRect.bottom = i10;
            }
        }
    }

    /* renamed from: com.martian.mibook.mvvm.category.fragment.LinkageRecyclerView$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Integer b(List<Integer> list, int i10) {
            int size = list.size() - 1;
            int i11 = 0;
            Integer num = null;
            while (i11 <= size) {
                int i12 = (i11 + size) / 2;
                if (list.get(i12).intValue() < i10) {
                    num = list.get(i12);
                    i11 = i12 + 1;
                } else {
                    size = i12 - 1;
                }
            }
            return num;
        }

        public Companion() {
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public LinkageRecyclerView(@k Context context) {
        this(context, null, 2, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // com.martian.libmars.widget.linkage.MultiLevelRecyclerView
    public void d(@l List<BaseLinkageItem> linkageItems, @k BaseQuickLinkageAdapter groupAdapter, @k BaseQuickLinkageAdapter childAdapter) {
        Intrinsics.checkNotNullParameter(groupAdapter, "groupAdapter");
        Intrinsics.checkNotNullParameter(childAdapter, "childAdapter");
        setGroupAdapter(groupAdapter);
        setChildAdapter(childAdapter);
        this.groupList = new ArrayList();
        this.childList = new ArrayList();
        this.titlePositionList = new ArrayList<>();
        if (linkageItems != null) {
            int i10 = 0;
            for (Object obj : linkageItems) {
                int i11 = i10 + 1;
                if (i10 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                BaseLinkageItem baseLinkageItem = (BaseLinkageItem) obj;
                if (baseLinkageItem.getIsGroup()) {
                    this.groupList.add(baseLinkageItem);
                } else if (baseLinkageItem instanceof CategoryItemInfo) {
                    if (((CategoryItemInfo) baseLinkageItem).getData() == null) {
                        this.titlePositionList.add(Integer.valueOf(this.childList.size()));
                    }
                    this.childList.add(baseLinkageItem);
                }
                i10 = i11;
            }
        }
        e();
        BaseQuickLinkageAdapter groupAdapter2 = getGroupAdapter();
        if (groupAdapter2 != null) {
            groupAdapter2.q(this.groupList);
        }
        BaseQuickLinkageAdapter childAdapter2 = getChildAdapter();
        if (childAdapter2 != null) {
            childAdapter2.q(this.childList);
        }
        m();
    }

    public final void e() {
        getBinding().f12221c.setLayoutManager(new LinearLayoutManager(getContext()));
        RecyclerView recyclerView = getBinding().f12221c;
        BaseQuickLinkageAdapter groupAdapter = getGroupAdapter();
        if (groupAdapter != null) {
            groupAdapter.r(new BaseQuickLinkageAdapter.a() { // from class: com.martian.mibook.mvvm.category.fragment.LinkageRecyclerView$initRecyclerView$1$1

                /* renamed from: b */
                public final /* synthetic */ BaseQuickLinkageAdapter f14220b;

                public LinkageRecyclerView$initRecyclerView$1$1(BaseQuickLinkageAdapter groupAdapter2) {
                    groupAdapter = groupAdapter2;
                }

                @Override // com.martian.libmars.widget.linkage.BaseQuickLinkageAdapter.a
                public void a(@l BaseLinkageItem baseLinkageItem, int i10) {
                    ArrayList arrayList;
                    Integer num;
                    ArrayList arrayList2;
                    RecyclerView.LayoutManager layoutManager = LinkageRecyclerView.this.getBinding().f12220b.getLayoutManager();
                    arrayList = LinkageRecyclerView.this.titlePositionList;
                    if (arrayList.size() > i10) {
                        arrayList2 = LinkageRecyclerView.this.titlePositionList;
                        num = (Integer) arrayList2.get(i10);
                    } else {
                        num = 0;
                    }
                    Intrinsics.checkNotNull(num);
                    int intValue = num.intValue();
                    if (layoutManager instanceof GridLayoutManager) {
                        if (LinkageRecyclerView.this.getIsScrollSmoothly()) {
                            LinkageRecyclerView$initRecyclerView$1$1$onItemClick$mScroller$1 linkageRecyclerView$initRecyclerView$1$1$onItemClick$mScroller$1 = new LinearSmoothScroller(LinkageRecyclerView.this.getContext()) { // from class: com.martian.mibook.mvvm.category.fragment.LinkageRecyclerView$initRecyclerView$1$1$onItemClick$mScroller$1
                                public LinkageRecyclerView$initRecyclerView$1$1$onItemClick$mScroller$1(Context context) {
                                    super(context);
                                }

                                @Override // androidx.recyclerview.widget.LinearSmoothScroller
                                public int getHorizontalSnapPreference() {
                                    return -1;
                                }

                                @Override // androidx.recyclerview.widget.LinearSmoothScroller
                                public int getVerticalSnapPreference() {
                                    return -1;
                                }
                            };
                            linkageRecyclerView$initRecyclerView$1$1$onItemClick$mScroller$1.setTargetPosition(intValue);
                            ((GridLayoutManager) layoutManager).startSmoothScroll(linkageRecyclerView$initRecyclerView$1$1$onItemClick$mScroller$1);
                        } else {
                            ((GridLayoutManager) layoutManager).scrollToPositionWithOffset(intValue, 0);
                        }
                        LinkageRecyclerView.this.mFirstVisiblePosition = intValue;
                    }
                    groupAdapter.u(i10);
                    BaseQuickLinkageAdapter.a groupItemClickListener = LinkageRecyclerView.this.getGroupItemClickListener();
                    if (groupItemClickListener != null) {
                        groupItemClickListener.a(baseLinkageItem, i10);
                    }
                }
            });
        } else {
            groupAdapter2 = null;
        }
        recyclerView.setAdapter(groupAdapter2);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), f14205q);
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() { // from class: com.martian.mibook.mvvm.category.fragment.LinkageRecyclerView$initRecyclerView$2
            public LinkageRecyclerView$initRecyclerView$2() {
            }

            @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
            public int getSpanSize(int r22) {
                BaseQuickLinkageAdapter childAdapter;
                childAdapter = LinkageRecyclerView.this.getChildAdapter();
                Integer valueOf = childAdapter != null ? Integer.valueOf(childAdapter.getItemViewType(r22)) : null;
                if (valueOf != null && valueOf.intValue() == 2) {
                    return 1;
                }
                return LinkageRecyclerView.f14205q;
            }
        });
        getBinding().f12220b.setItemViewCacheSize(30);
        getBinding().f12220b.setLayoutManager(gridLayoutManager);
        if (getBinding().f12220b.getItemDecorationCount() <= 0) {
            getBinding().f12220b.addItemDecoration(new RecyclerViewSpacingItemDecoration(this.titlePositionList, ConfigSingleton.i(8.0f), ConfigSingleton.i(8.0f), ConfigSingleton.i(12.0f), ConfigSingleton.i(12.0f), ConfigSingleton.i(12.0f), ConfigSingleton.i(12.0f)));
        }
        getBinding().f12220b.setAdapter(getChildAdapter());
    }

    public final void m() {
        getBinding().f12220b.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.martian.mibook.mvvm.category.fragment.LinkageRecyclerView$initLinkageChild$1
            public LinkageRecyclerView$initLinkageChild$1() {
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(@k RecyclerView recyclerView, int dx, int dy) {
                int i10;
                ArrayList arrayList;
                int i11;
                BaseQuickLinkageAdapter groupAdapter;
                ArrayList arrayList2;
                int i12;
                ArrayList arrayList3;
                ArrayList arrayList4;
                ArrayList arrayList5;
                Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
                super.onScrolled(recyclerView, dx, dy);
                if (recyclerView.getScrollState() != 0) {
                    RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
                    int childCount = layoutManager != null ? layoutManager.getChildCount() : 0;
                    int itemCount = layoutManager != null ? layoutManager.getItemCount() : 0;
                    LinearLayoutManager linearLayoutManager = layoutManager instanceof LinearLayoutManager ? (LinearLayoutManager) layoutManager : null;
                    int findFirstVisibleItemPosition = linearLayoutManager != null ? linearLayoutManager.findFirstVisibleItemPosition() : 0;
                    i10 = LinkageRecyclerView.this.mFirstVisiblePosition;
                    if (i10 == findFirstVisibleItemPosition || findFirstVisibleItemPosition < 0) {
                        return;
                    }
                    if (childCount + findFirstVisibleItemPosition >= itemCount) {
                        arrayList4 = LinkageRecyclerView.this.titlePositionList;
                        arrayList5 = LinkageRecyclerView.this.titlePositionList;
                        Object obj = arrayList4.get(CollectionsKt.getLastIndex(arrayList5));
                        Intrinsics.checkNotNullExpressionValue(obj, "get(...)");
                        findFirstVisibleItemPosition = ((Number) obj).intValue();
                    }
                    LinkageRecyclerView.this.mFirstVisiblePosition = findFirstVisibleItemPosition;
                    arrayList = LinkageRecyclerView.this.titlePositionList;
                    i11 = LinkageRecyclerView.this.mFirstVisiblePosition;
                    int indexOf = arrayList.indexOf(Integer.valueOf(i11));
                    if (indexOf == -1) {
                        LinkageRecyclerView.Companion companion = LinkageRecyclerView.INSTANCE;
                        arrayList2 = LinkageRecyclerView.this.titlePositionList;
                        i12 = LinkageRecyclerView.this.mFirstVisiblePosition;
                        Integer b10 = companion.b(arrayList2, i12);
                        arrayList3 = LinkageRecyclerView.this.titlePositionList;
                        indexOf = CollectionsKt.indexOf((List<? extends Integer>) arrayList3, b10);
                    }
                    groupAdapter = LinkageRecyclerView.this.getGroupAdapter();
                    if (groupAdapter != null) {
                        groupAdapter.u(indexOf);
                    }
                    RecyclerView.LayoutManager layoutManager2 = LinkageRecyclerView.this.getBinding().f12221c.getLayoutManager();
                    if (layoutManager2 != null) {
                        LinkageRecyclerView linkageRecyclerView = LinkageRecyclerView.this;
                        if (layoutManager2 instanceof LinearLayoutManager) {
                            if (!linkageRecyclerView.getIsScrollSmoothly()) {
                                ((LinearLayoutManager) layoutManager2).scrollToPositionWithOffset(indexOf, 0);
                                return;
                            }
                            LinearSmoothScroller linearSmoothScroller = new LinearSmoothScroller(linkageRecyclerView.getContext());
                            linearSmoothScroller.setTargetPosition(indexOf);
                            layoutManager2.startSmoothScroll(linearSmoothScroller);
                        }
                    }
                }
            }
        });
    }

    /* renamed from: n, reason: from getter */
    public final boolean getIsScrollSmoothly() {
        return this.isScrollSmoothly;
    }

    public final void setScrollSmoothly(boolean z10) {
        this.isScrollSmoothly = z10;
    }

    public /* synthetic */ LinkageRecyclerView(Context context, AttributeSet attributeSet, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i10 & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public LinkageRecyclerView(@k Context context, @l AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.groupList = new ArrayList();
        this.childList = new ArrayList();
        this.titlePositionList = new ArrayList<>();
    }
}
