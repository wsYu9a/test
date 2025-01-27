package com.martian.mibook.mvvm.yuewen.adapter.holder;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewGroupKt;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.kuaishou.weapon.p0.t;
import com.kwad.sdk.m.e;
import com.martian.libmars.widget.recyclerview.LoadingTip;
import com.martian.mibook.R;
import com.martian.mibook.activity.base.MiWebViewActivity;
import com.martian.mibook.activity.book.YWChannelBooksActivity;
import com.martian.mibook.databinding.ItemBookMallTypeCategoryBinding;
import com.martian.mibook.databinding.ItemCategoryPageBinding;
import com.martian.mibook.lib.model.data.TYBookItem;
import com.martian.mibook.lib.yuewen.response.YWBookChannel;
import com.martian.mibook.mvvm.extensions.ExtKt;
import com.martian.mibook.mvvm.net.ErrorResult;
import com.martian.mibook.mvvm.net.request.YWBookChannelBooksParams;
import com.martian.mibook.mvvm.yuewen.adapter.BookMallAdapter;
import com.martian.mibook.mvvm.yuewen.adapter.GridBookAdapter;
import com.martian.mibook.mvvm.yuewen.adapter.holder.ItemCategoryHolder;
import com.martian.mibook.mvvm.yuewen.viewmodel.BookMallViewModel;
import com.martian.mibook.ui.FlexboxTagLayout;
import com.umeng.analytics.pro.bt;
import i8.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0002\u000f>B!\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u0018J\u001d\u0010\u001c\u001a\u00020\u000e2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019H\u0002¢\u0006\u0004\b\u001c\u0010\u001dJA\u0010%\u001a\u00020$2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\u001e\u001a\u0004\u0018\u00010\f2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\f2\u0006\u0010\"\u001a\u00020\f2\u0006\u0010#\u001a\u00020\u001fH\u0002¢\u0006\u0004\b%\u0010&J\u000f\u0010'\u001a\u00020\u000eH\u0002¢\u0006\u0004\b'\u0010\u0012J\u000f\u0010(\u001a\u00020\u000eH\u0002¢\u0006\u0004\b(\u0010\u0012J\u0019\u0010*\u001a\u00020$2\b\u0010)\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0004\b*\u0010+J\u0017\u0010.\u001a\u00020\u000e2\u0006\u0010-\u001a\u00020,H\u0002¢\u0006\u0004\b.\u0010/R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0013\u00100\u001a\u0004\b1\u00102R\u0018\u00105\u001a\u0004\u0018\u0001038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u00104R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u00107R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u00109R\u0014\u0010=\u001a\u00020:8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b;\u0010<¨\u0006?"}, d2 = {"Lcom/martian/mibook/mvvm/yuewen/adapter/holder/ItemCategoryHolder;", "Lcom/martian/mibook/mvvm/yuewen/adapter/BookMallAdapter$ItemBaseHolder;", "Lcom/martian/mibook/databinding/ItemBookMallTypeCategoryBinding;", "binding", "Lcom/martian/mibook/mvvm/yuewen/viewmodel/BookMallViewModel;", "mViewModel", "Landroidx/lifecycle/LifecycleOwner;", "mLifecycleOwner", "<init>", "(Lcom/martian/mibook/databinding/ItemBookMallTypeCategoryBinding;Lcom/martian/mibook/mvvm/yuewen/viewmodel/BookMallViewModel;Landroidx/lifecycle/LifecycleOwner;)V", "Lcom/martian/mibook/lib/yuewen/response/YWBookChannel;", "bookChannel", "", id.c.f26972i, "", "a", "(Lcom/martian/mibook/lib/yuewen/response/YWBookChannel;I)V", "g", "()V", "f", "(I)V", "Lcom/martian/mibook/mvvm/yuewen/adapter/holder/ItemCategoryHolder$a;", "bookMallActionListener", "u", "(Lcom/martian/mibook/mvvm/yuewen/adapter/holder/ItemCategoryHolder$a;)V", "", "Lcom/martian/mibook/lib/model/data/TYBookItem;", "tyBookItems", IAdInterListener.AdReqParam.WIDTH, "(Ljava/util/List;)V", "ctype", "", "categoryName", "mcid", "speed", "ext", "", bt.aO, "(Lcom/martian/mibook/lib/yuewen/response/YWBookChannel;Ljava/lang/Integer;Ljava/lang/String;IILjava/lang/String;)Z", "v", "s", "ywBookChannel", t.f11211k, "(Lcom/martian/mibook/lib/yuewen/response/YWBookChannel;)Z", "Landroidx/viewpager2/widget/ViewPager2;", "viewpager", "x", "(Landroidx/viewpager2/widget/ViewPager2;)V", "Lcom/martian/mibook/databinding/ItemBookMallTypeCategoryBinding;", "q", "()Lcom/martian/mibook/databinding/ItemBookMallTypeCategoryBinding;", "Lcom/martian/mibook/mvvm/yuewen/adapter/holder/ItemCategoryHolder$PageAdapter;", "Lcom/martian/mibook/mvvm/yuewen/adapter/holder/ItemCategoryHolder$PageAdapter;", "pageAdapter", "h", "Lcom/martian/mibook/mvvm/yuewen/adapter/holder/ItemCategoryHolder$a;", "i", "Lcom/martian/mibook/lib/yuewen/response/YWBookChannel;", "Landroid/graphics/Rect;", "j", "Landroid/graphics/Rect;", "viewBounds", "PageAdapter", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nItemCategoryHolder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ItemCategoryHolder.kt\ncom/martian/mibook/mvvm/yuewen/adapter/holder/ItemCategoryHolder\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,458:1\n1#2:459\n1855#3,2:460\n*S KotlinDebug\n*F\n+ 1 ItemCategoryHolder.kt\ncom/martian/mibook/mvvm/yuewen/adapter/holder/ItemCategoryHolder\n*L\n242#1:460,2\n*E\n"})
/* loaded from: classes3.dex */
public final class ItemCategoryHolder extends BookMallAdapter.ItemBaseHolder {

    /* renamed from: f, reason: from kotlin metadata */
    @k
    public final ItemBookMallTypeCategoryBinding binding;

    /* renamed from: g, reason: from kotlin metadata */
    @l
    public PageAdapter pageAdapter;

    /* renamed from: h, reason: from kotlin metadata */
    @l
    public a bookMallActionListener;

    /* renamed from: i, reason: from kotlin metadata */
    @l
    public YWBookChannel bookChannel;

    /* renamed from: j, reason: from kotlin metadata */
    @k
    public final Rect viewBounds;

    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "", "Lcom/martian/mibook/lib/model/data/TYBookItem;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
    /* renamed from: com.martian.mibook.mvvm.yuewen.adapter.holder.ItemCategoryHolder$1 */
    public static final class AnonymousClass1 extends Lambda implements Function1<List<? extends TYBookItem>, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends TYBookItem> list) {
            invoke2(list);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke */
        public final void invoke2(@l List<? extends TYBookItem> list) {
            List<YWBookChannel.SubTab> subtabs;
            int mSelectPosition = ItemCategoryHolder.this.getBinding().flexboxCategory.getMSelectPosition();
            List<? extends TYBookItem> list2 = list;
            if (list2 == null || list2.isEmpty()) {
                PageAdapter pageAdapter = ItemCategoryHolder.this.pageAdapter;
                if (pageAdapter != null) {
                    pageAdapter.o(mSelectPosition, LoadingTip.LoadStatus.empty, null);
                    return;
                }
                return;
            }
            YWBookChannel yWBookChannel = ItemCategoryHolder.this.bookChannel;
            if (yWBookChannel != null) {
                yWBookChannel.setExposed(Boolean.FALSE);
            }
            YWBookChannel yWBookChannel2 = ItemCategoryHolder.this.bookChannel;
            YWBookChannel.SubTab subTab = (yWBookChannel2 == null || (subtabs = yWBookChannel2.getSubtabs()) == null) ? null : subtabs.get(mSelectPosition);
            if (subTab != null) {
                subTab.setBookList(list);
            }
            PageAdapter pageAdapter2 = ItemCategoryHolder.this.pageAdapter;
            if (pageAdapter2 != null) {
                pageAdapter2.q(ItemCategoryHolder.this.getBinding().flexboxCategory.getMSelectPosition(), list);
            }
            PageAdapter pageAdapter3 = ItemCategoryHolder.this.pageAdapter;
            if (pageAdapter3 != null) {
                pageAdapter3.o(mSelectPosition, LoadingTip.LoadStatus.finish, null);
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Lcom/martian/mibook/mvvm/net/ErrorResult;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
    /* renamed from: com.martian.mibook.mvvm.yuewen.adapter.holder.ItemCategoryHolder$2 */
    public static final class AnonymousClass2 extends Lambda implements Function1<ErrorResult, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ErrorResult errorResult) {
            invoke2(errorResult);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke */
        public final void invoke2(ErrorResult errorResult) {
            int mSelectPosition = ItemCategoryHolder.this.getBinding().flexboxCategory.getMSelectPosition();
            PageAdapter pageAdapter = ItemCategoryHolder.this.pageAdapter;
            if (pageAdapter != null) {
                pageAdapter.o(mSelectPosition, LoadingTip.LoadStatus.network_error, errorResult);
            }
        }
    }

    @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010!\n\u0002\b\f\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u000201B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u001d\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r2\u0006\u0010\f\u001a\u00020\u0003¢\u0006\u0004\b\u000f\u0010\u0010J%\u0010\u0012\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u00032\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r¢\u0006\u0004\b\u0012\u0010\u0013J'\u0010\u0018\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016¢\u0006\u0004\b\u0018\u0010\u0019J#\u0010\u001d\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u001f\u0010 J#\u0010\"\u001a\u00020\t2\n\u0010!\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\f\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\"\u0010#R\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%R$\u0010)\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r0&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010(R\u001e\u0010+\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00140&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010(R\u001e\u0010-\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00160&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010(R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010/¨\u00062"}, d2 = {"Lcom/martian/mibook/mvvm/yuewen/adapter/holder/ItemCategoryHolder$PageAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/martian/mibook/mvvm/yuewen/adapter/holder/ItemCategoryHolder$PageAdapter$PageViewHolder;", "", "pageSize", "<init>", "(I)V", "Lcom/martian/mibook/mvvm/yuewen/adapter/holder/ItemCategoryHolder$PageAdapter$a;", "onReloadListener", "", "p", "(Lcom/martian/mibook/mvvm/yuewen/adapter/holder/ItemCategoryHolder$PageAdapter$a;)V", id.c.f26972i, "", "Lcom/martian/mibook/lib/model/data/TYBookItem;", t.f11204d, "(I)Ljava/util/List;", "bookList", "q", "(ILjava/util/List;)V", "Lcom/martian/libmars/widget/recyclerview/LoadingTip$LoadStatus;", "loadStatus", "Lcom/martian/mibook/mvvm/net/ErrorResult;", "error", "o", "(ILcom/martian/libmars/widget/recyclerview/LoadingTip$LoadStatus;Lcom/martian/mibook/mvvm/net/ErrorResult;)V", "Landroid/view/ViewGroup;", "parent", "viewType", "n", "(Landroid/view/ViewGroup;I)Lcom/martian/mibook/mvvm/yuewen/adapter/holder/ItemCategoryHolder$PageAdapter$PageViewHolder;", "getItemCount", "()I", "holder", "m", "(Lcom/martian/mibook/mvvm/yuewen/adapter/holder/ItemCategoryHolder$PageAdapter$PageViewHolder;I)V", "c", "I", "", "d", "Ljava/util/List;", "pageListData", e.TAG, "statusTipList", "f", "errorResultList", "g", "Lcom/martian/mibook/mvvm/yuewen/adapter/holder/ItemCategoryHolder$PageAdapter$a;", "a", "PageViewHolder", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
    @SourceDebugExtension({"SMAP\nItemCategoryHolder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ItemCategoryHolder.kt\ncom/martian/mibook/mvvm/yuewen/adapter/holder/ItemCategoryHolder$PageAdapter\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,458:1\n1#2:459\n*E\n"})
    public static final class PageAdapter extends RecyclerView.Adapter<PageViewHolder> {

        /* renamed from: c, reason: from kotlin metadata */
        public final int pageSize;

        /* renamed from: d, reason: from kotlin metadata */
        @k
        public List<List<TYBookItem>> pageListData;

        /* renamed from: e */
        @k
        public List<LoadingTip.LoadStatus> statusTipList;

        /* renamed from: f, reason: from kotlin metadata */
        @k
        public List<ErrorResult> errorResultList;

        /* renamed from: g, reason: from kotlin metadata */
        @l
        public a onReloadListener;

        @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J%\u0010\f\u001a\u00020\u000b2\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\f\u0010\rR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/martian/mibook/mvvm/yuewen/adapter/holder/ItemCategoryHolder$PageAdapter$PageViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/martian/mibook/databinding/ItemCategoryPageBinding;", "pageBinding", "<init>", "(Lcom/martian/mibook/mvvm/yuewen/adapter/holder/ItemCategoryHolder$PageAdapter;Lcom/martian/mibook/databinding/ItemCategoryPageBinding;)V", "", "Lcom/martian/mibook/lib/model/data/TYBookItem;", "bookList", "", id.c.f26972i, "", "a", "(Ljava/util/List;I)V", "b", "Lcom/martian/mibook/databinding/ItemCategoryPageBinding;", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
        public final class PageViewHolder extends RecyclerView.ViewHolder {

            /* renamed from: b, reason: from kotlin metadata */
            @k
            public final ItemCategoryPageBinding pageBinding;

            /* renamed from: c */
            public final /* synthetic */ PageAdapter f15545c;

            public /* synthetic */ class a {

                /* renamed from: a */
                public static final /* synthetic */ int[] f15546a;

                static {
                    int[] iArr = new int[LoadingTip.LoadStatus.values().length];
                    try {
                        iArr[LoadingTip.LoadStatus.loading.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[LoadingTip.LoadStatus.empty.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[LoadingTip.LoadStatus.finish.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    f15546a = iArr;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public PageViewHolder(@k PageAdapter pageAdapter, ItemCategoryPageBinding pageBinding) {
                super(pageBinding.getRoot());
                Intrinsics.checkNotNullParameter(pageBinding, "pageBinding");
                this.f15545c = pageAdapter;
                this.pageBinding = pageBinding;
            }

            public final void a(@l List<? extends TYBookItem> bookList, int r62) {
                LoadingTip.LoadStatus loadStatus = (LoadingTip.LoadStatus) this.f15545c.statusTipList.get(r62);
                int i10 = loadStatus == null ? -1 : a.f15546a[loadStatus.ordinal()];
                if (i10 != -1) {
                    if (i10 == 1) {
                        this.pageBinding.rvBooks.setVisibility(8);
                        this.pageBinding.pageCategoryLoadingTip.setLoadingTip(LoadingTip.LoadStatus.loading);
                        return;
                    }
                    if (i10 == 2) {
                        this.pageBinding.rvBooks.setVisibility(8);
                        this.pageBinding.pageCategoryLoadingTip.setLoadingTip(LoadingTip.LoadStatus.empty);
                        return;
                    }
                    if (i10 != 3) {
                        ErrorResult errorResult = (ErrorResult) this.f15545c.errorResultList.get(r62);
                        if (errorResult != null) {
                            this.pageBinding.pageCategoryLoadingTip.setOnReloadListener(new Function0<Unit>() { // from class: com.martian.mibook.mvvm.yuewen.adapter.holder.ItemCategoryHolder$PageAdapter$PageViewHolder$bind$1$1
                                final /* synthetic */ int $position;

                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                public ItemCategoryHolder$PageAdapter$PageViewHolder$bind$1$1(int r622) {
                                    super(0);
                                    position = r622;
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public /* bridge */ /* synthetic */ Unit invoke() {
                                    invoke2();
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke */
                                public final void invoke2() {
                                    ItemCategoryHolder.PageAdapter.a aVar;
                                    aVar = ItemCategoryHolder.PageAdapter.this.onReloadListener;
                                    if (aVar != null) {
                                        aVar.a(position);
                                    }
                                }
                            });
                            if (errorResult.getErrorCode() == -100002) {
                                this.pageBinding.rvBooks.setVisibility(8);
                                this.pageBinding.pageCategoryLoadingTip.setLoadingTip(LoadingTip.LoadStatus.network_error);
                            } else {
                                this.pageBinding.rvBooks.setVisibility(8);
                                this.pageBinding.pageCategoryLoadingTip.setLoadingTip(LoadingTip.LoadStatus.serverError);
                            }
                            if (ba.l.q(errorResult.getErrorMsg()) || errorResult.getErrorMsg().length() >= 20) {
                                return;
                            }
                            this.pageBinding.pageCategoryLoadingTip.setTips(ExtKt.c(errorResult.getErrorMsg()));
                            return;
                        }
                        return;
                    }
                }
                this.pageBinding.pageCategoryLoadingTip.setLoadingTip(LoadingTip.LoadStatus.finish);
                this.pageBinding.rvBooks.setVisibility(0);
                this.pageBinding.rvBooks.setLayoutManager(new GridLayoutManager(this.pageBinding.rvBooks.getContext(), GridBookAdapter.INSTANCE.a()));
                GridBookAdapter gridBookAdapter = new GridBookAdapter();
                this.pageBinding.rvBooks.setAdapter(gridBookAdapter);
                gridBookAdapter.o(bookList);
            }
        }

        public interface a {
            void a(int i10);
        }

        public PageAdapter(int i10) {
            this.pageSize = i10;
            ArrayList arrayList = new ArrayList(i10);
            for (int i11 = 0; i11 < i10; i11++) {
                arrayList.add(null);
            }
            this.pageListData = arrayList;
            int i12 = this.pageSize;
            ArrayList arrayList2 = new ArrayList(i12);
            for (int i13 = 0; i13 < i12; i13++) {
                arrayList2.add(null);
            }
            this.statusTipList = arrayList2;
            int i14 = this.pageSize;
            ArrayList arrayList3 = new ArrayList(i14);
            for (int i15 = 0; i15 < i14; i15++) {
                arrayList3.add(null);
            }
            this.errorResultList = arrayList3;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: getItemCount, reason: from getter */
        public int getPageSize() {
            return this.pageSize;
        }

        @l
        public final List<TYBookItem> l(int i10) {
            if (this.pageListData.size() > i10) {
                return this.pageListData.get(i10);
            }
            return null;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: m */
        public void onBindViewHolder(@k PageViewHolder holder, int r32) {
            Intrinsics.checkNotNullParameter(holder, "holder");
            holder.a(this.pageListData.get(r32), r32);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @k
        /* renamed from: n */
        public PageViewHolder onCreateViewHolder(@k ViewGroup parent, int viewType) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            ItemCategoryPageBinding inflate = ItemCategoryPageBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
            inflate.pageCategoryLoadingTip.setBackgroundType(20);
            inflate.pageCategoryLoadingTip.setLoadingTip(LoadingTip.LoadStatus.loading);
            return new PageViewHolder(this, inflate);
        }

        public final void o(int r22, @k LoadingTip.LoadStatus loadStatus, @l ErrorResult error) {
            Intrinsics.checkNotNullParameter(loadStatus, "loadStatus");
            if (this.pageSize > r22) {
                this.statusTipList.set(r22, loadStatus);
                this.errorResultList.set(r22, error);
                notifyItemChanged(r22);
            }
        }

        public final void p(@k a onReloadListener) {
            Intrinsics.checkNotNullParameter(onReloadListener, "onReloadListener");
            this.onReloadListener = onReloadListener;
        }

        public final void q(int r22, @l List<? extends TYBookItem> bookList) {
            if (this.pageListData.size() <= r22 || this.pageListData.get(r22) != null) {
                return;
            }
            this.pageListData.set(r22, bookList);
            notifyItemChanged(r22);
        }
    }

    public interface a {
        void a(@l YWBookChannel yWBookChannel, int i10);
    }

    public static final class b implements FlexboxTagLayout.a {
        public b() {
        }

        @Override // com.martian.mibook.ui.FlexboxTagLayout.a
        public void a(@k String title, int i10) {
            Intrinsics.checkNotNullParameter(title, "title");
            ItemCategoryHolder.this.getBinding().viewpager.setCurrentItem(i10);
            PageAdapter pageAdapter = ItemCategoryHolder.this.pageAdapter;
            List<TYBookItem> l10 = pageAdapter != null ? pageAdapter.l(i10) : null;
            if (l10 == null || l10.isEmpty()) {
                ItemCategoryHolder.this.s();
            }
        }
    }

    public static final class c implements PageAdapter.a {
        public c() {
        }

        @Override // com.martian.mibook.mvvm.yuewen.adapter.holder.ItemCategoryHolder.PageAdapter.a
        public void a(int i10) {
            ItemCategoryHolder.this.getBinding().flexboxCategory.setSelectPosition(i10);
            ItemCategoryHolder.this.s();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ItemCategoryHolder(@k ItemBookMallTypeCategoryBinding binding, @l BookMallViewModel bookMallViewModel, @k LifecycleOwner mLifecycleOwner) {
        super(binding, bookMallViewModel);
        MutableLiveData<ErrorResult> x10;
        MutableLiveData<List<TYBookItem>> y10;
        Intrinsics.checkNotNullParameter(binding, "binding");
        Intrinsics.checkNotNullParameter(mLifecycleOwner, "mLifecycleOwner");
        this.binding = binding;
        this.viewBounds = new Rect();
        if (bookMallViewModel != null && (y10 = bookMallViewModel.y()) != null) {
            y10.observe(mLifecycleOwner, new Observer() { // from class: ud.b
                public /* synthetic */ b() {
                }

                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    ItemCategoryHolder.k(Function1.this, obj);
                }
            });
        }
        if (bookMallViewModel == null || (x10 = bookMallViewModel.x()) == null) {
            return;
        }
        x10.observe(mLifecycleOwner, new Observer() { // from class: ud.c
            public /* synthetic */ c() {
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ItemCategoryHolder.l(Function1.this, obj);
            }
        });
    }

    public static final void k(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void l(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void p(ItemCategoryHolder this$0, YWBookChannel bookChannel, Integer num, int i10, int i11, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(bookChannel, "$bookChannel");
        String selectedItem = this$0.binding.flexboxCategory.getSelectedItem();
        String ext = bookChannel.getSubtabs().get(this$0.binding.flexboxCategory.getMSelectPosition()).getExt();
        Intrinsics.checkNotNull(ext);
        this$0.t(bookChannel, num, selectedItem, i10, i11, ext);
    }

    /*  JADX ERROR: JadxRuntimeException in pass: ProcessVariables
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: ud.a.<init>(com.martian.mibook.mvvm.yuewen.adapter.holder.ItemCategoryHolder, com.martian.mibook.lib.yuewen.response.YWBookChannel, java.lang.Integer, int, int):void, class status: GENERATED_AND_UNLOADED
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
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:19)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables.removeUnusedResults(ProcessVariables.java:73)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables.visit(ProcessVariables.java:48)
        */
    @Override // com.martian.mibook.mvvm.yuewen.adapter.BookMallAdapter.ItemBaseHolder
    public void a(@xi.k com.martian.mibook.lib.yuewen.response.YWBookChannel r9, int r10) {
        /*
            Method dump skipped, instructions count: 263
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.martian.mibook.mvvm.yuewen.adapter.holder.ItemCategoryHolder.a(com.martian.mibook.lib.yuewen.response.YWBookChannel, int):void");
    }

    @Override // com.martian.mibook.mvvm.yuewen.adapter.BookMallAdapter.ItemBaseHolder
    public void f(int r12) {
        List<TYBookItem> list;
        View view;
        View findViewByPosition;
        TYBookItem tYBookItem;
        YWBookChannel yWBookChannel;
        List<YWBookChannel.SubTab> subtabs;
        YWBookChannel.SubTab subTab;
        if (this.pageAdapter == null) {
            return;
        }
        YWBookChannel yWBookChannel2 = this.bookChannel;
        if (yWBookChannel2 != null && yWBookChannel2.isExposed()) {
            return;
        }
        ViewPager2 viewpager = this.binding.viewpager;
        Intrinsics.checkNotNullExpressionValue(viewpager, "viewpager");
        Iterator<View> it = ViewGroupKt.getChildren(viewpager).iterator();
        while (true) {
            list = null;
            if (!it.hasNext()) {
                view = null;
                break;
            } else {
                view = it.next();
                if (view instanceof RecyclerView) {
                    break;
                }
            }
        }
        View view2 = view;
        if (view2 == null) {
            return;
        }
        RecyclerView.LayoutManager layoutManager = ((RecyclerView) view2).getLayoutManager();
        LinearLayoutManager linearLayoutManager = layoutManager instanceof LinearLayoutManager ? (LinearLayoutManager) layoutManager : null;
        if (linearLayoutManager == null || (findViewByPosition = linearLayoutManager.findViewByPosition(this.binding.viewpager.getCurrentItem())) == null) {
            return;
        }
        Intrinsics.checkNotNull(findViewByPosition);
        RecyclerView recyclerView = (RecyclerView) findViewByPosition.findViewById(R.id.rv_books);
        if (recyclerView == null) {
            return;
        }
        Intrinsics.checkNotNull(recyclerView);
        RecyclerView.LayoutManager layoutManager2 = recyclerView.getLayoutManager();
        GridLayoutManager gridLayoutManager = layoutManager2 instanceof GridLayoutManager ? (GridLayoutManager) layoutManager2 : null;
        if (gridLayoutManager == null) {
            return;
        }
        int findLastVisibleItemPosition = gridLayoutManager.findLastVisibleItemPosition();
        int mSelectPosition = this.binding.flexboxCategory.getMSelectPosition();
        YWBookChannel yWBookChannel3 = this.bookChannel;
        if (yWBookChannel3 != null && (subtabs = yWBookChannel3.getSubtabs()) != null && (subTab = subtabs.get(mSelectPosition)) != null) {
            list = subTab.getBookList();
        }
        if (list == null || findLastVisibleItemPosition < 0) {
            return;
        }
        int i10 = 0;
        while (true) {
            View childAt = gridLayoutManager.getChildAt(i10);
            this.viewBounds.setEmpty();
            if (childAt != null && childAt.getLocalVisibleRect(this.viewBounds) && childAt.getHeight() > 0 && this.viewBounds.height() / childAt.getHeight() >= 0.8f) {
                if (i10 == recyclerView.getChildCount() - 1 && (yWBookChannel = this.bookChannel) != null) {
                    yWBookChannel.setExposed(Boolean.TRUE);
                }
                if (i10 < list.size() && (tYBookItem = list.get(i10)) != null) {
                    if (!c().contains(mSelectPosition + hf.e.f26694a + tYBookItem.getSourceId())) {
                        c().add(mSelectPosition + hf.e.f26694a + tYBookItem.getSourceId());
                        e(tYBookItem);
                    }
                }
            }
            if (i10 == findLastVisibleItemPosition) {
                return;
            } else {
                i10++;
            }
        }
    }

    @Override // com.martian.mibook.mvvm.yuewen.adapter.BookMallAdapter.ItemBaseHolder
    public void g() {
        if (this.binding.flexboxCategory.getChildCount() > 0) {
            this.binding.flexboxCategory.removeAllViews();
        }
        this.pageAdapter = null;
    }

    @k
    /* renamed from: q, reason: from getter */
    public final ItemBookMallTypeCategoryBinding getBinding() {
        return this.binding;
    }

    public final boolean r(YWBookChannel yWBookChannel) {
        if (yWBookChannel == null) {
            return false;
        }
        if (g.h(getCom.umeng.analytics.pro.f.X java.lang.String(), yWBookChannel.getBottomDeeplink())) {
            g.A(getCom.umeng.analytics.pro.f.X java.lang.String(), yWBookChannel.getBottomDeeplink(), "", "", true);
            return true;
        }
        if (ba.l.q(yWBookChannel.getBottomUrl())) {
            return false;
        }
        Context context = getCom.umeng.analytics.pro.f.X java.lang.String();
        Activity activity = context instanceof Activity ? (Activity) context : null;
        if (activity != null) {
            MiWebViewActivity.startWebViewActivity(activity, yWBookChannel.getBottomUrl());
        }
        return true;
    }

    public final void s() {
        YWBookChannel yWBookChannel = this.bookChannel;
        if (yWBookChannel != null) {
            String selectedItem = this.binding.flexboxCategory.getSelectedItem();
            int mSelectPosition = this.binding.flexboxCategory.getMSelectPosition();
            String ext = yWBookChannel.getSubtabs().get(mSelectPosition).getExt();
            PageAdapter pageAdapter = this.pageAdapter;
            if (pageAdapter != null) {
                pageAdapter.o(mSelectPosition, LoadingTip.LoadStatus.loading, null);
            }
            YWBookChannelBooksParams yWBookChannelBooksParams = new YWBookChannelBooksParams(null, null, 0, 0, null, null, 63, null);
            yWBookChannelBooksParams.setPage(0);
            yWBookChannelBooksParams.setPageSize(8);
            Integer mcid = yWBookChannel.getMcid();
            Intrinsics.checkNotNullExpressionValue(mcid, "getMcid(...)");
            yWBookChannelBooksParams.setMcid(mcid.intValue());
            yWBookChannelBooksParams.setExt(ExtKt.d(ext));
            yWBookChannelBooksParams.setCategory(ExtKt.d(selectedItem));
            yWBookChannelBooksParams.makeSpeed();
            BookMallViewModel mViewModel = getMViewModel();
            if (mViewModel != null) {
                mViewModel.v(yWBookChannelBooksParams, mSelectPosition > 0);
            }
        }
    }

    public final boolean t(YWBookChannel yWBookChannel, Integer num, String str, int i10, int i11, String str2) {
        String title;
        if (r(yWBookChannel)) {
            return true;
        }
        Context context = getCom.umeng.analytics.pro.f.X java.lang.String();
        Activity activity = context instanceof Activity ? (Activity) context : null;
        if (activity != null) {
            switch (i10) {
                case BookMallAdapter.f15421u /* -1000010 */:
                case BookMallAdapter.f15420t /* -1000009 */:
                    kc.b.g(num != null ? num.intValue() : 0);
                    break;
                default:
                    if (ba.l.q(str) || Intrinsics.areEqual("全部", str)) {
                        title = yWBookChannel.getTitle();
                        Intrinsics.checkNotNull(title);
                    } else {
                        title = yWBookChannel.getTitle() + "-" + str;
                    }
                    YWChannelBooksActivity.L2(activity, title, Integer.valueOf(i10), i11, 0, str2);
                    break;
            }
        }
        return false;
    }

    public final void u(@k a bookMallActionListener) {
        Intrinsics.checkNotNullParameter(bookMallActionListener, "bookMallActionListener");
        this.bookMallActionListener = bookMallActionListener;
    }

    public final void v() {
        List<YWBookChannel.SubTab> subtabs;
        if (this.binding.flexboxCategory.getChildCount() == 0) {
            ArrayList arrayList = new ArrayList();
            YWBookChannel yWBookChannel = this.bookChannel;
            if (yWBookChannel != null && (subtabs = yWBookChannel.getSubtabs()) != null) {
                Iterator<T> it = subtabs.iterator();
                while (it.hasNext()) {
                    arrayList.add(((YWBookChannel.SubTab) it.next()).getTitle());
                }
            }
            if (arrayList.isEmpty()) {
                this.binding.flexboxCategory.setVisibility(8);
            } else {
                this.binding.flexboxCategory.setData(arrayList);
                this.binding.flexboxCategory.setVisibility(0);
            }
            this.binding.horizontalScrollview.smoothScrollTo(0, 0);
            this.binding.flexboxCategory.setOnItemTitleClickListener(new b());
        }
    }

    public final void w(List<? extends TYBookItem> list) {
        List<YWBookChannel.SubTab> subtabs;
        List<YWBookChannel.SubTab> subtabs2;
        PageAdapter pageAdapter = this.pageAdapter;
        if (pageAdapter != null) {
            if (pageAdapter != null) {
                pageAdapter.q(this.binding.flexboxCategory.getMSelectPosition(), list);
                return;
            }
            return;
        }
        this.binding.viewpager.setOrientation(0);
        this.binding.viewpager.setOffscreenPageLimit(3);
        ViewPager2 viewpager = this.binding.viewpager;
        Intrinsics.checkNotNullExpressionValue(viewpager, "viewpager");
        x(viewpager);
        this.binding.viewpager.registerOnPageChangeCallback(new ItemCategoryHolder$setViewPagerData$1(this));
        YWBookChannel yWBookChannel = this.bookChannel;
        PageAdapter pageAdapter2 = new PageAdapter((yWBookChannel == null || (subtabs2 = yWBookChannel.getSubtabs()) == null) ? 0 : subtabs2.size());
        this.pageAdapter = pageAdapter2;
        pageAdapter2.p(new c());
        this.binding.viewpager.setAdapter(this.pageAdapter);
        YWBookChannel yWBookChannel2 = this.bookChannel;
        YWBookChannel.SubTab subTab = (yWBookChannel2 == null || (subtabs = yWBookChannel2.getSubtabs()) == null) ? null : subtabs.get(0);
        if (subTab != null) {
            YWBookChannel yWBookChannel3 = this.bookChannel;
            subTab.setBookList(yWBookChannel3 != null ? yWBookChannel3.getBookList() : null);
        }
        PageAdapter pageAdapter3 = this.pageAdapter;
        if (pageAdapter3 != null) {
            pageAdapter3.q(0, list);
        }
        this.binding.viewpager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() { // from class: com.martian.mibook.mvvm.yuewen.adapter.holder.ItemCategoryHolder$setViewPagerData$3
            public ItemCategoryHolder$setViewPagerData$3() {
            }

            @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
            public void onPageSelected(int r22) {
                ItemCategoryHolder.this.getBinding().flexboxCategory.setSelectPosition(r22);
                ItemCategoryHolder.PageAdapter pageAdapter4 = ItemCategoryHolder.this.pageAdapter;
                List<TYBookItem> l10 = pageAdapter4 != null ? pageAdapter4.l(r22) : null;
                if (l10 == null || l10.isEmpty()) {
                    ItemCategoryHolder.this.s();
                }
            }
        });
    }

    public final void x(ViewPager2 viewpager) {
        View view;
        Iterator<View> it = ViewGroupKt.getChildren(viewpager).iterator();
        while (true) {
            if (!it.hasNext()) {
                view = null;
                break;
            } else {
                view = it.next();
                if (view instanceof RecyclerView) {
                    break;
                }
            }
        }
        View view2 = view;
        if (view2 != null) {
            RecyclerView recyclerView = (RecyclerView) view2;
            recyclerView.setNestedScrollingEnabled(false);
            recyclerView.addOnItemTouchListener(new RecyclerView.SimpleOnItemTouchListener() { // from class: com.martian.mibook.mvvm.yuewen.adapter.holder.ItemCategoryHolder$setViewPagerEvent$2$1

                /* renamed from: a, reason: from kotlin metadata */
                public float lastX;

                /* renamed from: b, reason: from kotlin metadata */
                public float lastY;

                /* JADX WARN: Code restructure failed: missing block: B:11:0x0025, code lost:
                
                    if (r2 != 3) goto L43;
                 */
                @Override // androidx.recyclerview.widget.RecyclerView.SimpleOnItemTouchListener, androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public boolean onInterceptTouchEvent(@xi.k androidx.recyclerview.widget.RecyclerView r6, @xi.k android.view.MotionEvent r7) {
                    /*
                        r5 = this;
                        java.lang.String r0 = "rv"
                        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
                        java.lang.String r0 = "e"
                        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
                        int r0 = r7.getActionIndex()
                        r1 = 0
                        if (r0 < 0) goto L72
                        int r2 = r7.getPointerCount()
                        if (r0 < r2) goto L18
                        goto L72
                    L18:
                        int r2 = r7.getActionMasked()
                        r3 = 1
                        if (r2 == 0) goto L5f
                        if (r2 == r3) goto L52
                        r4 = 2
                        if (r2 == r4) goto L28
                        r7 = 3
                        if (r2 == r7) goto L52
                        goto L72
                    L28:
                        float r2 = r7.getX(r0)
                        float r4 = r5.lastX
                        float r2 = r2 - r4
                        float r7 = r7.getY(r0)
                        float r0 = r5.lastY
                        float r7 = r7 - r0
                        float r0 = java.lang.Math.abs(r2)
                        float r7 = java.lang.Math.abs(r7)
                        int r7 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
                        if (r7 >= 0) goto L4a
                        android.view.ViewParent r6 = r6.getParent()
                        r6.requestDisallowInterceptTouchEvent(r1)
                        goto L72
                    L4a:
                        android.view.ViewParent r6 = r6.getParent()
                        r6.requestDisallowInterceptTouchEvent(r3)
                        goto L72
                    L52:
                        r7 = 0
                        r5.lastX = r7
                        r5.lastY = r7
                        android.view.ViewParent r6 = r6.getParent()
                        r6.requestDisallowInterceptTouchEvent(r1)
                        goto L72
                    L5f:
                        float r2 = r7.getX(r0)
                        r5.lastX = r2
                        float r7 = r7.getY(r0)
                        r5.lastY = r7
                        android.view.ViewParent r6 = r6.getParent()
                        r6.requestDisallowInterceptTouchEvent(r3)
                    L72:
                        return r1
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.martian.mibook.mvvm.yuewen.adapter.holder.ItemCategoryHolder$setViewPagerEvent$2$1.onInterceptTouchEvent(androidx.recyclerview.widget.RecyclerView, android.view.MotionEvent):boolean");
                }
            });
        }
    }
}
