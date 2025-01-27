package com.martian.libmars.widget.linkage;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.kwad.sdk.m.e;
import com.martian.libmars.databinding.LayoutLinkageRecyclerviewBinding;
import com.martian.libmars.ui.theme.ThemeLinearLayout;
import com.martian.libmars.widget.linkage.BaseQuickLinkageAdapter;
import com.umeng.analytics.pro.f;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\f\b\u0016\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0004\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\r\u0010\u000eJ/\u0010\u0015\u001a\u00020\f2\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u001d\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017¢\u0006\u0004\b\u0019\u0010\u001aJ\u0015\u0010\u001c\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\t¢\u0006\u0004\b\u001c\u0010\u001dJ\u0015\u0010\u001f\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\t¢\u0006\u0004\b\u001f\u0010\u001dJ\u0015\u0010 \u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\t¢\u0006\u0004\b \u0010\u001dJ\u0015\u0010!\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\t¢\u0006\u0004\b!\u0010\u001dJ\u0015\u0010#\u001a\u00020\f2\u0006\u0010\"\u001a\u00020\t¢\u0006\u0004\b#\u0010\u001dJ\u000f\u0010$\u001a\u00020\fH\u0016¢\u0006\u0004\b$\u0010\u000eJ\u0017\u0010%\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b%\u0010\u0005R\"\u0010,\u001a\u00020&8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u0015\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R$\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\r\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R$\u0010\u0014\u001a\u0004\u0018\u00010\u00128\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b%\u0010-\u001a\u0004\b2\u0010/\"\u0004\b3\u00101R\u001c\u00106\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u00105R\u001c\u00108\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b7\u00105R$\u0010@\u001a\u0004\u0018\u0001098\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R$\u0010D\u001a\u0004\u0018\u0001098\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bA\u0010;\u001a\u0004\bB\u0010=\"\u0004\bC\u0010?¨\u0006E"}, d2 = {"Lcom/martian/libmars/widget/linkage/MultiLevelRecyclerView;", "Lcom/martian/libmars/ui/theme/ThemeLinearLayout;", "Landroid/content/Context;", f.X, "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "", e.TAG, "()V", "", "Lcom/martian/libmars/widget/linkage/BaseLinkageItem;", "linkageItems", "Lcom/martian/libmars/widget/linkage/BaseQuickLinkageAdapter;", "groupAdapter", "childAdapter", "d", "(Ljava/util/List;Lcom/martian/libmars/widget/linkage/BaseQuickLinkageAdapter;Lcom/martian/libmars/widget/linkage/BaseQuickLinkageAdapter;)V", "", "groupName", "c", "(Ljava/lang/String;)Ljava/util/List;", "newWidth", "setLayoutWidth", "(I)V", "newHeight", "setLayoutHeight", "setGroupWidth", "setChildWidth", "span", "setChildSpanSize", "p", "f", "Lcom/martian/libmars/databinding/LayoutLinkageRecyclerviewBinding;", "Lcom/martian/libmars/databinding/LayoutLinkageRecyclerviewBinding;", "getBinding", "()Lcom/martian/libmars/databinding/LayoutLinkageRecyclerviewBinding;", "setBinding", "(Lcom/martian/libmars/databinding/LayoutLinkageRecyclerviewBinding;)V", "binding", "Lcom/martian/libmars/widget/linkage/BaseQuickLinkageAdapter;", "getGroupAdapter", "()Lcom/martian/libmars/widget/linkage/BaseQuickLinkageAdapter;", "setGroupAdapter", "(Lcom/martian/libmars/widget/linkage/BaseQuickLinkageAdapter;)V", "getChildAdapter", "setChildAdapter", "g", "Ljava/util/List;", "groupList", "h", "childList", "Lcom/martian/libmars/widget/linkage/BaseQuickLinkageAdapter$a;", "i", "Lcom/martian/libmars/widget/linkage/BaseQuickLinkageAdapter$a;", "getGroupItemClickListener", "()Lcom/martian/libmars/widget/linkage/BaseQuickLinkageAdapter$a;", "setGroupItemClickListener", "(Lcom/martian/libmars/widget/linkage/BaseQuickLinkageAdapter$a;)V", "groupItemClickListener", "j", "getChildItemClickListener", "setChildItemClickListener", "childItemClickListener", "libmars_release"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nMultiLevelRecyclerView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MultiLevelRecyclerView.kt\ncom/martian/libmars/widget/linkage/MultiLevelRecyclerView\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,126:1\n1864#2,3:127\n766#2:130\n857#2,2:131\n1#3:133\n*S KotlinDebug\n*F\n+ 1 MultiLevelRecyclerView.kt\ncom/martian/libmars/widget/linkage/MultiLevelRecyclerView\n*L\n42#1:127,3\n56#1:130\n56#1:131,2\n*E\n"})
/* loaded from: classes3.dex */
public class MultiLevelRecyclerView extends ThemeLinearLayout {

    /* renamed from: d, reason: from kotlin metadata */
    public LayoutLinkageRecyclerviewBinding binding;

    /* renamed from: e */
    @l
    public BaseQuickLinkageAdapter groupAdapter;

    /* renamed from: f, reason: from kotlin metadata */
    @l
    public BaseQuickLinkageAdapter childAdapter;

    /* renamed from: g, reason: from kotlin metadata */
    @k
    public List<BaseLinkageItem> groupList;

    /* renamed from: h, reason: from kotlin metadata */
    @k
    public List<BaseLinkageItem> childList;

    /* renamed from: i, reason: from kotlin metadata */
    @l
    public BaseQuickLinkageAdapter.a groupItemClickListener;

    /* renamed from: j, reason: from kotlin metadata */
    @l
    public BaseQuickLinkageAdapter.a childItemClickListener;

    public static final class a implements BaseQuickLinkageAdapter.a {

        /* renamed from: a */
        public final /* synthetic */ BaseQuickLinkageAdapter f12763a;

        /* renamed from: b */
        public final /* synthetic */ MultiLevelRecyclerView f12764b;

        public a(BaseQuickLinkageAdapter baseQuickLinkageAdapter, MultiLevelRecyclerView multiLevelRecyclerView) {
            this.f12763a = baseQuickLinkageAdapter;
            this.f12764b = multiLevelRecyclerView;
        }

        @Override // com.martian.libmars.widget.linkage.BaseQuickLinkageAdapter.a
        public void a(@l BaseLinkageItem baseLinkageItem, int i10) {
            this.f12763a.u(i10);
            BaseQuickLinkageAdapter childAdapter = this.f12764b.getChildAdapter();
            if (childAdapter != null) {
                childAdapter.q(this.f12764b.c(baseLinkageItem != null ? baseLinkageItem.getItemName() : null));
            }
            BaseQuickLinkageAdapter.a groupItemClickListener = this.f12764b.getGroupItemClickListener();
            if (groupItemClickListener != null) {
                groupItemClickListener.a(baseLinkageItem, i10);
            }
        }
    }

    public static final class b implements BaseQuickLinkageAdapter.a {

        /* renamed from: a */
        public final /* synthetic */ BaseQuickLinkageAdapter f12765a;

        /* renamed from: b */
        public final /* synthetic */ MultiLevelRecyclerView f12766b;

        public b(BaseQuickLinkageAdapter baseQuickLinkageAdapter, MultiLevelRecyclerView multiLevelRecyclerView) {
            this.f12765a = baseQuickLinkageAdapter;
            this.f12766b = multiLevelRecyclerView;
        }

        @Override // com.martian.libmars.widget.linkage.BaseQuickLinkageAdapter.a
        public void a(@l BaseLinkageItem baseLinkageItem, int i10) {
            this.f12765a.u(i10);
            BaseQuickLinkageAdapter.a childItemClickListener = this.f12766b.getChildItemClickListener();
            if (childItemClickListener != null) {
                childItemClickListener.a(baseLinkageItem, i10);
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MultiLevelRecyclerView(@k Context context) {
        this(context, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void e() {
        getBinding().f12221c.setLayoutManager(new LinearLayoutManager(getContext()));
        RecyclerView recyclerView = getBinding().f12221c;
        BaseQuickLinkageAdapter baseQuickLinkageAdapter = this.groupAdapter;
        BaseQuickLinkageAdapter baseQuickLinkageAdapter2 = null;
        if (baseQuickLinkageAdapter != null) {
            baseQuickLinkageAdapter.r(new a(baseQuickLinkageAdapter, this));
        } else {
            baseQuickLinkageAdapter = null;
        }
        recyclerView.setAdapter(baseQuickLinkageAdapter);
        getBinding().f12220b.setLayoutManager(new LinearLayoutManager(getContext()));
        RecyclerView recyclerView2 = getBinding().f12220b;
        BaseQuickLinkageAdapter baseQuickLinkageAdapter3 = this.childAdapter;
        if (baseQuickLinkageAdapter3 != null) {
            baseQuickLinkageAdapter3.r(new b(baseQuickLinkageAdapter3, this));
            baseQuickLinkageAdapter2 = baseQuickLinkageAdapter3;
        }
        recyclerView2.setAdapter(baseQuickLinkageAdapter2);
    }

    @k
    public final List<BaseLinkageItem> c(@l String groupName) {
        List<BaseLinkageItem> list = this.childList;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (Intrinsics.areEqual(((BaseLinkageItem) obj).getParentName(), groupName)) {
                arrayList.add(obj);
            }
        }
        return CollectionsKt.toMutableList((Collection) arrayList);
    }

    public void d(@l List<BaseLinkageItem> linkageItems, @k BaseQuickLinkageAdapter groupAdapter, @k BaseQuickLinkageAdapter childAdapter) {
        Intrinsics.checkNotNullParameter(groupAdapter, "groupAdapter");
        Intrinsics.checkNotNullParameter(childAdapter, "childAdapter");
        this.groupAdapter = groupAdapter;
        this.childAdapter = childAdapter;
        this.groupList = new ArrayList();
        this.childList = new ArrayList();
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
                } else {
                    this.childList.add(baseLinkageItem);
                }
                i10 = i11;
            }
        }
        e();
        BaseQuickLinkageAdapter baseQuickLinkageAdapter = this.groupAdapter;
        if (baseQuickLinkageAdapter != null) {
            baseQuickLinkageAdapter.q(this.groupList);
        }
        childAdapter.q(c(this.groupList.get(0).getItemName()));
    }

    public final void f(Context r22) {
        LayoutLinkageRecyclerviewBinding d10 = LayoutLinkageRecyclerviewBinding.d(LayoutInflater.from(r22), this, true);
        Intrinsics.checkNotNullExpressionValue(d10, "inflate(...)");
        setBinding(d10);
    }

    @k
    public final LayoutLinkageRecyclerviewBinding getBinding() {
        LayoutLinkageRecyclerviewBinding layoutLinkageRecyclerviewBinding = this.binding;
        if (layoutLinkageRecyclerviewBinding != null) {
            return layoutLinkageRecyclerviewBinding;
        }
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        return null;
    }

    @l
    public final BaseQuickLinkageAdapter getChildAdapter() {
        return this.childAdapter;
    }

    @l
    public final BaseQuickLinkageAdapter.a getChildItemClickListener() {
        return this.childItemClickListener;
    }

    @l
    public final BaseQuickLinkageAdapter getGroupAdapter() {
        return this.groupAdapter;
    }

    @l
    public final BaseQuickLinkageAdapter.a getGroupItemClickListener() {
        return this.groupItemClickListener;
    }

    @Override // com.martian.libmars.ui.theme.ThemeLinearLayout, k9.a
    public void p() {
        super.p();
        BaseQuickLinkageAdapter baseQuickLinkageAdapter = this.groupAdapter;
        if (baseQuickLinkageAdapter != null) {
            baseQuickLinkageAdapter.notifyDataSetChanged();
        }
    }

    public final void setBinding(@k LayoutLinkageRecyclerviewBinding layoutLinkageRecyclerviewBinding) {
        Intrinsics.checkNotNullParameter(layoutLinkageRecyclerviewBinding, "<set-?>");
        this.binding = layoutLinkageRecyclerviewBinding;
    }

    public final void setChildAdapter(@l BaseQuickLinkageAdapter baseQuickLinkageAdapter) {
        this.childAdapter = baseQuickLinkageAdapter;
    }

    public final void setChildItemClickListener(@l BaseQuickLinkageAdapter.a aVar) {
        this.childItemClickListener = aVar;
    }

    public final void setChildSpanSize(int span) {
        LinearLayoutManager linearLayoutManager;
        RecyclerView recyclerView = getBinding().f12220b;
        if (span > 1) {
            GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), span);
            gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() { // from class: com.martian.libmars.widget.linkage.MultiLevelRecyclerView$setChildSpanSize$1$1

                /* renamed from: b */
                public final /* synthetic */ int f12768b;

                public MultiLevelRecyclerView$setChildSpanSize$1$1(int span2) {
                    span = span2;
                }

                @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
                public int getSpanSize(int r32) {
                    BaseLinkageItem o10;
                    BaseQuickLinkageAdapter childAdapter = MultiLevelRecyclerView.this.getChildAdapter();
                    if (childAdapter == null || (o10 = childAdapter.o(r32)) == null || !o10.getIsGroup()) {
                        return 1;
                    }
                    return span;
                }
            });
            linearLayoutManager = gridLayoutManager;
        } else {
            linearLayoutManager = new LinearLayoutManager(getContext(), 1, false);
        }
        recyclerView.setLayoutManager(linearLayoutManager);
        getBinding().f12220b.requestLayout();
    }

    public final void setChildWidth(int newWidth) {
        RecyclerView recyclerView = getBinding().f12220b;
        ViewGroup.LayoutParams layoutParams = getBinding().f12220b.getLayoutParams();
        layoutParams.width = newWidth;
        recyclerView.setLayoutParams(layoutParams);
    }

    public final void setGroupAdapter(@l BaseQuickLinkageAdapter baseQuickLinkageAdapter) {
        this.groupAdapter = baseQuickLinkageAdapter;
    }

    public final void setGroupItemClickListener(@l BaseQuickLinkageAdapter.a aVar) {
        this.groupItemClickListener = aVar;
    }

    public final void setGroupWidth(int newWidth) {
        RecyclerView recyclerView = getBinding().f12221c;
        ViewGroup.LayoutParams layoutParams = getBinding().f12221c.getLayoutParams();
        layoutParams.width = newWidth;
        recyclerView.setLayoutParams(layoutParams);
    }

    public final void setLayoutHeight(int newHeight) {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.height = newHeight;
        setLayoutParams(layoutParams);
    }

    public final void setLayoutWidth(int newWidth) {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.width = newWidth;
        setLayoutParams(layoutParams);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MultiLevelRecyclerView(@k Context context, @l AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MultiLevelRecyclerView(@k Context context, @l AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        Intrinsics.checkNotNullParameter(context, "context");
        this.groupList = new ArrayList();
        this.childList = new ArrayList();
        f(context);
    }
}
