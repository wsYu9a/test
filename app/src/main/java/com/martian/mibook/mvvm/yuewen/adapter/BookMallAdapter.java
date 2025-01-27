package com.martian.mibook.mvvm.yuewen.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelKt;
import androidx.recyclerview.widget.AsyncListDiffer;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.kuaishou.weapon.p0.t;
import com.kwad.sdk.m.e;
import com.martian.libmars.common.ConfigSingleton;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.databinding.ItemBookMallTypeCategoryBinding;
import com.martian.mibook.databinding.ItemBookMallTypeGenderBinding;
import com.martian.mibook.databinding.ItemBookMallTypeGridBinding;
import com.martian.mibook.databinding.ItemBookMallTypeRankBinding;
import com.martian.mibook.databinding.ItemBookMallTypeReadingRecordBinding;
import com.martian.mibook.databinding.ItemBookMallTypeRecommendBookBinding;
import com.martian.mibook.databinding.ItemBookMallTypeRecommendTitleBinding;
import com.martian.mibook.databinding.ItemBookMallTypeTabBinding;
import com.martian.mibook.lib.model.data.BookWrapper;
import com.martian.mibook.lib.model.data.MiReadingRecord;
import com.martian.mibook.lib.model.data.TYBookItem;
import com.martian.mibook.lib.model.data.abs.Book;
import com.martian.mibook.lib.yuewen.response.YWBookChannel;
import com.martian.mibook.mvvm.utils.RecyclerViewExposeManager;
import com.martian.mibook.mvvm.yuewen.adapter.holder.ItemCategoryHolder;
import com.martian.mibook.mvvm.yuewen.adapter.holder.ItemGenderHolder;
import com.martian.mibook.mvvm.yuewen.adapter.holder.ItemGridHolder;
import com.martian.mibook.mvvm.yuewen.adapter.holder.ItemRankHolder;
import com.martian.mibook.mvvm.yuewen.adapter.holder.ItemReadingRecordHolder;
import com.martian.mibook.mvvm.yuewen.adapter.holder.ItemRecommendBookHolder;
import com.martian.mibook.mvvm.yuewen.adapter.holder.ItemRecommendTitleHolder;
import com.martian.mibook.mvvm.yuewen.adapter.holder.ItemTabHolder;
import com.martian.mibook.mvvm.yuewen.viewmodel.BookMallViewModel;
import com.umeng.analytics.pro.bt;
import com.umeng.analytics.pro.f;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u001e2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0002WXB\u0019\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eJ\u001b\u0010\u0012\u001a\u00020\f2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f¢\u0006\u0004\b\u0012\u0010\u0013J\u001f\u0010\u0017\u001a\u00020\f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u0018J\u0015\u0010\u001a\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u0010¢\u0006\u0004\b\u001a\u0010\u001bJ\u001d\u0010\u001c\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u0010¢\u0006\u0004\b\u001c\u0010\u001dJ\u001d\u0010\u001e\u001a\u00020\f2\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f¢\u0006\u0004\b\u001e\u0010\u0013J\u0015\u0010!\u001a\u00020\f2\u0006\u0010 \u001a\u00020\u001f¢\u0006\u0004\b!\u0010\"J\u001f\u0010&\u001a\u00020\u00022\u0006\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020\u0015H\u0016¢\u0006\u0004\b&\u0010'J-\u0010,\u001a\u00020\f2\u0006\u0010(\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00152\f\u0010+\u001a\b\u0012\u0004\u0012\u00020*0)H\u0016¢\u0006\u0004\b,\u0010-J\u001f\u0010.\u001a\u00020\f2\u0006\u0010(\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b.\u0010/J\u0017\u00100\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b0\u00101J\u000f\u00102\u001a\u00020\u0015H\u0016¢\u0006\u0004\b2\u00103J!\u00104\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u00152\b\u0010 \u001a\u0004\u0018\u00010\u001fH\u0016¢\u0006\u0004\b4\u00105J\u0019\u00106\u001a\u00020\f2\b\u0010 \u001a\u0004\u0018\u00010\u001fH\u0007¢\u0006\u0004\b6\u0010\"J\u0017\u00107\u001a\u00020\f2\u0006\u0010 \u001a\u00020\u001fH\u0016¢\u0006\u0004\b7\u0010\"J\u0017\u00108\u001a\u00020\f2\u0006\u0010 \u001a\u00020\u001fH\u0016¢\u0006\u0004\b8\u0010\"J\r\u00109\u001a\u00020\f¢\u0006\u0004\b9\u0010:J\u001b\u0010<\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010;\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b<\u0010=J5\u0010A\u001a\u00020\f2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0016\u0010@\u001a\u0012\u0012\u0004\u0012\u00020\u00100>j\b\u0012\u0004\u0012\u00020\u0010`?H\u0002¢\u0006\u0004\bA\u0010BJ\u0017\u0010D\u001a\u00020\u00152\u0006\u0010C\u001a\u00020\u0010H\u0002¢\u0006\u0004\bD\u0010ER\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bF\u0010GR\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bH\u0010IR\u0018\u0010M\u001a\u0004\u0018\u00010J8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bK\u0010LR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bN\u0010OR\"\u0010T\u001a\u0010\u0012\f\u0012\n Q*\u0004\u0018\u00010\u00100\u00100P8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bR\u0010SR\u0018\u0010 \u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bU\u0010V¨\u0006Y"}, d2 = {"Lcom/martian/mibook/mvvm/yuewen/adapter/BookMallAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/martian/mibook/mvvm/yuewen/adapter/BookMallAdapter$ItemBaseHolder;", "Lcom/martian/mibook/mvvm/utils/RecyclerViewExposeManager$OnItemExposeListener;", "Lcom/martian/mibook/mvvm/yuewen/viewmodel/BookMallViewModel;", "mViewModel", "Landroidx/lifecycle/LifecycleOwner;", "mLifecycleOwner", "<init>", "(Lcom/martian/mibook/mvvm/yuewen/viewmodel/BookMallViewModel;Landroidx/lifecycle/LifecycleOwner;)V", "Lcom/martian/mibook/mvvm/yuewen/adapter/holder/ItemGenderHolder$a;", "bookMallActionListener", "", "u", "(Lcom/martian/mibook/mvvm/yuewen/adapter/holder/ItemGenderHolder$a;)V", "", "Lcom/martian/mibook/lib/yuewen/response/YWBookChannel;", "newData", "x", "(Ljava/util/List;)V", "bookChannel", "", id.c.f26972i, IAdInterListener.AdReqParam.WIDTH, "(Lcom/martian/mibook/lib/yuewen/response/YWBookChannel;I)V", "item", "s", "(Lcom/martian/mibook/lib/yuewen/response/YWBookChannel;)V", "j", "(ILcom/martian/mibook/lib/yuewen/response/YWBookChannel;)V", "i", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", bt.aO, "(Landroidx/recyclerview/widget/RecyclerView;)V", "Landroid/view/ViewGroup;", "parent", "viewType", "q", "(Landroid/view/ViewGroup;I)Lcom/martian/mibook/mvvm/yuewen/adapter/BookMallAdapter$ItemBaseHolder;", "holder", "", "", "payloads", "p", "(Lcom/martian/mibook/mvvm/yuewen/adapter/BookMallAdapter$ItemBaseHolder;ILjava/util/List;)V", "o", "(Lcom/martian/mibook/mvvm/yuewen/adapter/BookMallAdapter$ItemBaseHolder;I)V", "getItemViewType", "(I)I", "getItemCount", "()I", "onItemViewVisible", "(ILandroidx/recyclerview/widget/RecyclerView;)V", t.f11211k, "onAttachedToRecyclerView", "onDetachedFromRecyclerView", "n", "()V", "readingRecordChannel", t.f11204d, "(Lcom/martian/mibook/lib/yuewen/response/YWBookChannel;)Lcom/martian/mibook/lib/yuewen/response/YWBookChannel;", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "listData", "v", "(Ljava/util/List;Ljava/util/ArrayList;)V", "ywBookChannel", "k", "(Lcom/martian/mibook/lib/yuewen/response/YWBookChannel;)I", "c", "Lcom/martian/mibook/mvvm/yuewen/viewmodel/BookMallViewModel;", "d", "Landroidx/lifecycle/LifecycleOwner;", "Lcom/martian/mibook/mvvm/utils/RecyclerViewExposeManager;", e.TAG, "Lcom/martian/mibook/mvvm/utils/RecyclerViewExposeManager;", "recyclerViewExposeManager", "f", "Lcom/martian/mibook/mvvm/yuewen/adapter/holder/ItemGenderHolder$a;", "Landroidx/recyclerview/widget/AsyncListDiffer;", "kotlin.jvm.PlatformType", "g", "Landroidx/recyclerview/widget/AsyncListDiffer;", "mDiffer", "h", "Landroidx/recyclerview/widget/RecyclerView;", "a", "ItemBaseHolder", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nBookMallAdapter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BookMallAdapter.kt\ncom/martian/mibook/mvvm/yuewen/adapter/BookMallAdapter\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,524:1\n1864#2,2:525\n1864#2,3:527\n1866#2:530\n*S KotlinDebug\n*F\n+ 1 BookMallAdapter.kt\ncom/martian/mibook/mvvm/yuewen/adapter/BookMallAdapter\n*L\n148#1:525,2\n186#1:527,3\n148#1:530\n*E\n"})
/* loaded from: classes3.dex */
public final class BookMallAdapter extends RecyclerView.Adapter<ItemBaseHolder> implements RecyclerViewExposeManager.OnItemExposeListener {

    /* renamed from: j */
    public static final int f15410j = 1;

    /* renamed from: k */
    public static final int f15411k = 2;

    /* renamed from: l */
    public static final int f15412l = 3;

    /* renamed from: m */
    public static final int f15413m = 4;

    /* renamed from: n */
    public static final int f15414n = 5;

    /* renamed from: o */
    public static final int f15415o = 6;

    /* renamed from: p */
    public static final int f15416p = 7;

    /* renamed from: q */
    public static final int f15417q = 8;

    /* renamed from: r */
    public static final int f15418r = -1000005;

    /* renamed from: s */
    public static final int f15419s = -1000006;

    /* renamed from: t */
    public static final int f15420t = -1000009;

    /* renamed from: u */
    public static final int f15421u = -1000010;

    /* renamed from: v */
    public static final int f15422v = -1000099;

    /* renamed from: w */
    public static final int f15423w = -5;

    /* renamed from: x */
    public static final int f15424x = -6;

    /* renamed from: c, reason: from kotlin metadata */
    @l
    public final BookMallViewModel mViewModel;

    /* renamed from: d, reason: from kotlin metadata */
    @k
    public final LifecycleOwner mLifecycleOwner;

    /* renamed from: e */
    @l
    public RecyclerViewExposeManager recyclerViewExposeManager;

    /* renamed from: f, reason: from kotlin metadata */
    @l
    public ItemGenderHolder.a bookMallActionListener;

    /* renamed from: g, reason: from kotlin metadata */
    @k
    public final AsyncListDiffer<YWBookChannel> mDiffer;

    /* renamed from: h, reason: from kotlin metadata */
    @l
    public RecyclerView recyclerView;

    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH&¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\fH&¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0011\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH&¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u0017\u0010\u001dR\u001a\u0010\"\u001a\u00020\u001e8\u0004X\u0084\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u001f\u001a\u0004\b \u0010!R\u001d\u0010'\u001a\b\u0012\u0004\u0012\u00020$0#8\u0006¢\u0006\f\n\u0004\b\u0015\u0010%\u001a\u0004\b\u001b\u0010&¨\u0006("}, d2 = {"Lcom/martian/mibook/mvvm/yuewen/adapter/BookMallAdapter$ItemBaseHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroidx/viewbinding/ViewBinding;", bt.aO, "Lcom/martian/mibook/mvvm/yuewen/viewmodel/BookMallViewModel;", "mViewModel", "<init>", "(Landroidx/viewbinding/ViewBinding;Lcom/martian/mibook/mvvm/yuewen/viewmodel/BookMallViewModel;)V", "Lcom/martian/mibook/lib/yuewen/response/YWBookChannel;", "bookChannel", "", id.c.f26972i, "", "a", "(Lcom/martian/mibook/lib/yuewen/response/YWBookChannel;I)V", "g", "()V", "f", "(I)V", "Lcom/martian/mibook/lib/model/data/TYBookItem;", "tyBookItem", e.TAG, "(Lcom/martian/mibook/lib/model/data/TYBookItem;)V", "b", "Landroidx/viewbinding/ViewBinding;", "d", "()Landroidx/viewbinding/ViewBinding;", "c", "Lcom/martian/mibook/mvvm/yuewen/viewmodel/BookMallViewModel;", "()Lcom/martian/mibook/mvvm/yuewen/viewmodel/BookMallViewModel;", "Landroid/content/Context;", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", f.X, "", "", "Ljava/util/Set;", "()Ljava/util/Set;", "sourceIdSet", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
    public static abstract class ItemBaseHolder extends RecyclerView.ViewHolder {

        /* renamed from: b, reason: from kotlin metadata */
        @k
        public final ViewBinding com.umeng.analytics.pro.bt.aO java.lang.String;

        /* renamed from: c, reason: from kotlin metadata */
        @l
        public final BookMallViewModel mViewModel;

        /* renamed from: d, reason: from kotlin metadata */
        @k
        public final Context com.umeng.analytics.pro.f.X java.lang.String;

        /* renamed from: e */
        @k
        public final Set<String> sourceIdSet;

        public /* synthetic */ ItemBaseHolder(ViewBinding viewBinding, BookMallViewModel bookMallViewModel, int i10, DefaultConstructorMarker defaultConstructorMarker) {
            this(viewBinding, (i10 & 2) != 0 ? null : bookMallViewModel);
        }

        public abstract void a(@k YWBookChannel bookChannel, int r22);

        @l
        /* renamed from: b, reason: from getter */
        public final BookMallViewModel getMViewModel() {
            return this.mViewModel;
        }

        @k
        public final Set<String> c() {
            return this.sourceIdSet;
        }

        @k
        /* renamed from: d, reason: from getter */
        public final ViewBinding getCom.umeng.analytics.pro.bt.aO java.lang.String() {
            return this.com.umeng.analytics.pro.bt.aO java.lang.String;
        }

        public final void e(@l TYBookItem tYBookItem) {
            if (tYBookItem != null) {
                MiConfigSingleton.b2().V1().i(tYBookItem);
            }
        }

        public abstract void f(int r12);

        public abstract void g();

        @k
        /* renamed from: getContext, reason: from getter */
        public final Context getCom.umeng.analytics.pro.f.X java.lang.String() {
            return this.com.umeng.analytics.pro.f.X java.lang.String;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ItemBaseHolder(@k ViewBinding t10, @l BookMallViewModel bookMallViewModel) {
            super(t10.getRoot());
            Intrinsics.checkNotNullParameter(t10, "t");
            this.com.umeng.analytics.pro.bt.aO java.lang.String = t10;
            this.mViewModel = bookMallViewModel;
            Context context = t10.getRoot().getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            this.com.umeng.analytics.pro.f.X java.lang.String = context;
            this.sourceIdSet = new HashSet();
        }
    }

    public static final class b implements ItemGridHolder.a {
        public b() {
        }

        @Override // com.martian.mibook.mvvm.yuewen.adapter.holder.ItemGridHolder.a
        public void a(@l YWBookChannel yWBookChannel, int i10) {
            BookMallAdapter.this.w(yWBookChannel, i10);
        }
    }

    public static final class c implements ItemCategoryHolder.a {
        public c() {
        }

        @Override // com.martian.mibook.mvvm.yuewen.adapter.holder.ItemCategoryHolder.a
        public void a(@l YWBookChannel yWBookChannel, int i10) {
            BookMallAdapter.this.w(yWBookChannel, i10);
        }
    }

    public BookMallAdapter(@l BookMallViewModel bookMallViewModel, @k LifecycleOwner mLifecycleOwner) {
        Intrinsics.checkNotNullParameter(mLifecycleOwner, "mLifecycleOwner");
        this.mViewModel = bookMallViewModel;
        this.mLifecycleOwner = mLifecycleOwner;
        this.mDiffer = new AsyncListDiffer<>(this, new DiffUtil.ItemCallback<YWBookChannel>() { // from class: com.martian.mibook.mvvm.yuewen.adapter.BookMallAdapter$mDiffer$1
            @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
            /* renamed from: a */
            public boolean areContentsTheSame(@k YWBookChannel oldItem, @k YWBookChannel newItem) {
                Intrinsics.checkNotNullParameter(oldItem, "oldItem");
                Intrinsics.checkNotNullParameter(newItem, "newItem");
                return Intrinsics.areEqual(oldItem.getMcid(), newItem.getMcid()) && Intrinsics.areEqual(oldItem.getTid(), oldItem.getTid());
            }

            @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
            /* renamed from: b */
            public boolean areItemsTheSame(@k YWBookChannel oldItem, @k YWBookChannel newItem) {
                Intrinsics.checkNotNullParameter(oldItem, "oldItem");
                Intrinsics.checkNotNullParameter(newItem, "newItem");
                return Intrinsics.areEqual(oldItem, newItem);
            }
        });
    }

    public static /* synthetic */ YWBookChannel m(BookMallAdapter bookMallAdapter, YWBookChannel yWBookChannel, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            yWBookChannel = null;
        }
        return bookMallAdapter.l(yWBookChannel);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getPageSize() {
        return this.mDiffer.getCurrentList().size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int r22) {
        YWBookChannel yWBookChannel = this.mDiffer.getCurrentList().get(r22);
        Intrinsics.checkNotNull(yWBookChannel);
        return k(yWBookChannel);
    }

    public final void i(@l List<? extends YWBookChannel> newData) {
        List<? extends YWBookChannel> list = newData;
        if (list == null || list.isEmpty()) {
            return;
        }
        ArrayList<YWBookChannel> arrayList = new ArrayList<>();
        arrayList.addAll(this.mDiffer.getCurrentList());
        v(newData, arrayList);
        this.mDiffer.submitList(arrayList);
    }

    public final void j(int r32, @k YWBookChannel item) {
        Intrinsics.checkNotNullParameter(item, "item");
        if (r32 > this.mDiffer.getCurrentList().size()) {
            return;
        }
        List<YWBookChannel> currentList = this.mDiffer.getCurrentList();
        Intrinsics.checkNotNullExpressionValue(currentList, "getCurrentList(...)");
        List<YWBookChannel> mutableList = CollectionsKt.toMutableList((Collection) currentList);
        mutableList.add(r32, item);
        this.mDiffer.submitList(mutableList);
    }

    public final int k(YWBookChannel ywBookChannel) {
        Integer mcid;
        Integer mcid2;
        Integer mcid3 = ywBookChannel.getMcid();
        if (mcid3 != null && mcid3.intValue() == -5) {
            return 5;
        }
        Integer mcid4 = ywBookChannel.getMcid();
        if (mcid4 != null && mcid4.intValue() == -6) {
            return 8;
        }
        Integer mcid5 = ywBookChannel.getMcid();
        if (mcid5 != null && mcid5.intValue() == -1000099) {
            return 4;
        }
        List<YWBookChannel.SubTab> subtabs = ywBookChannel.getSubtabs();
        if (subtabs != null && !subtabs.isEmpty()) {
            Integer mcid6 = ywBookChannel.getMcid();
            if ((mcid6 != null && mcid6.intValue() == -1000006) || ((mcid = ywBookChannel.getMcid()) != null && mcid.intValue() == -1000005)) {
                return 3;
            }
            Integer mcid7 = ywBookChannel.getMcid();
            if ((mcid7 != null && mcid7.intValue() == -1000010) || ((mcid2 = ywBookChannel.getMcid()) != null && mcid2.intValue() == -1000009)) {
                return 2;
            }
        }
        if (ywBookChannel.getLayoutType() == 1) {
            return 1;
        }
        if (ywBookChannel.getLayoutType() == -1) {
            return 2;
        }
        if (ywBookChannel.getLayoutType() == -2) {
            return 3;
        }
        if (ywBookChannel.getLayoutType() == -4) {
            return 4;
        }
        return ywBookChannel.getRecommendType() == 0 ? 7 : 6;
    }

    @l
    public final YWBookChannel l(@l YWBookChannel yWBookChannel) {
        MiReadingRecord a22 = MiConfigSingleton.b2().a2();
        if (a22 == null) {
            return null;
        }
        Book H = MiConfigSingleton.b2().M1().H(a22.getSourceString());
        BookWrapper o10 = MiConfigSingleton.b2().M1().T().o(a22.getSourceString());
        if (yWBookChannel != null) {
            yWBookChannel.setReadingRecord(a22);
            yWBookChannel.setReadingRecordBook(H);
            yWBookChannel.setBookWrapper(o10);
            return yWBookChannel;
        }
        YWBookChannel yWBookChannel2 = new YWBookChannel();
        yWBookChannel2.setMcid(-6);
        yWBookChannel2.setReadingRecord(a22);
        yWBookChannel2.setReadingRecordBook(H);
        yWBookChannel2.setBookWrapper(o10);
        return yWBookChannel2;
    }

    public final void n() {
        Object obj;
        BookMallViewModel bookMallViewModel;
        CoroutineScope viewModelScope;
        CoroutineScope viewModelScope2;
        List<YWBookChannel> currentList = this.mDiffer.getCurrentList();
        Intrinsics.checkNotNullExpressionValue(currentList, "getCurrentList(...)");
        Iterator it = CollectionsKt.take(currentList, 5).iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            Integer mcid = ((YWBookChannel) obj).getMcid();
            if (mcid != null && mcid.intValue() == -6) {
                break;
            }
        }
        YWBookChannel yWBookChannel = (YWBookChannel) obj;
        MiReadingRecord a22 = MiConfigSingleton.b2().a2();
        if (yWBookChannel == null) {
            if (a22 == null || (bookMallViewModel = this.mViewModel) == null || (viewModelScope = ViewModelKt.getViewModelScope(bookMallViewModel)) == null) {
                return;
            }
            BuildersKt__Builders_commonKt.launch$default(viewModelScope, Dispatchers.getIO(), null, new BookMallAdapter$notifyReadingRecord$2(this, null), 2, null);
            return;
        }
        if (a22 == null) {
            s(yWBookChannel);
            return;
        }
        BookMallViewModel bookMallViewModel2 = this.mViewModel;
        if (bookMallViewModel2 == null || (viewModelScope2 = ViewModelKt.getViewModelScope(bookMallViewModel2)) == null) {
            return;
        }
        BuildersKt__Builders_commonKt.launch$default(viewModelScope2, Dispatchers.getIO(), null, new BookMallAdapter$notifyReadingRecord$1(this, yWBookChannel, null), 2, null);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: o */
    public void onBindViewHolder(@k ItemBaseHolder holder, int r62) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        YWBookChannel yWBookChannel = this.mDiffer.getCurrentList().get(r62);
        ItemGenderHolder itemGenderHolder = holder instanceof ItemGenderHolder ? (ItemGenderHolder) holder : null;
        if (itemGenderHolder != null) {
            itemGenderHolder.r(this.bookMallActionListener);
        }
        ItemGridHolder itemGridHolder = holder instanceof ItemGridHolder ? (ItemGridHolder) holder : null;
        if (itemGridHolder != null) {
            itemGridHolder.w(new b());
        }
        ItemCategoryHolder itemCategoryHolder = holder instanceof ItemCategoryHolder ? (ItemCategoryHolder) holder : null;
        if (itemCategoryHolder != null) {
            itemCategoryHolder.u(new c());
        }
        ViewGroup.LayoutParams layoutParams = holder.itemView.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
        if (marginLayoutParams != null) {
            marginLayoutParams.topMargin = r62 == 0 ? ConfigSingleton.i(8.0f) : holder instanceof ItemRecommendBookHolder ? 0 : ConfigSingleton.i(12.0f);
        }
        Intrinsics.checkNotNull(yWBookChannel);
        holder.a(yWBookChannel, r62);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(@k RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        super.onAttachedToRecyclerView(recyclerView);
        this.recyclerView = recyclerView;
        if (this.recyclerViewExposeManager == null) {
            this.recyclerViewExposeManager = new RecyclerViewExposeManager();
        }
        RecyclerViewExposeManager recyclerViewExposeManager = this.recyclerViewExposeManager;
        if (recyclerViewExposeManager != null) {
            recyclerViewExposeManager.setThreshold(0.0f);
        }
        RecyclerViewExposeManager recyclerViewExposeManager2 = this.recyclerViewExposeManager;
        if (recyclerViewExposeManager2 != null) {
            recyclerViewExposeManager2.setRecyclerItemExposeListener(recyclerView, this);
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
        this.recyclerView = null;
    }

    @Override // com.martian.mibook.mvvm.utils.RecyclerViewExposeManager.OnItemExposeListener
    public void onItemViewVisible(int r32, @l RecyclerView recyclerView) {
        YWBookChannel yWBookChannel;
        if (this.mDiffer.getCurrentList().isEmpty() || getPageSize() <= r32 || (yWBookChannel = this.mDiffer.getCurrentList().get(r32)) == null) {
            return;
        }
        List<TYBookItem> bookList = yWBookChannel.getBookList();
        if (((bookList == null || bookList.isEmpty()) && yWBookChannel.getBookItem() == null) || yWBookChannel.isExposed()) {
            return;
        }
        RecyclerView.ViewHolder findViewHolderForAdapterPosition = recyclerView != null ? recyclerView.findViewHolderForAdapterPosition(r32) : null;
        if (findViewHolderForAdapterPosition instanceof ItemBaseHolder) {
            ((ItemBaseHolder) findViewHolderForAdapterPosition).f(r32);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: p */
    public void onBindViewHolder(@k ItemBaseHolder holder, int r32, @k List<Object> payloads) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        if (!(!payloads.isEmpty())) {
            onBindViewHolder(holder, r32);
        } else if (holder instanceof ItemRecommendBookHolder) {
            ((ItemRecommendBookHolder) holder).k();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @k
    /* renamed from: q */
    public ItemBaseHolder onCreateViewHolder(@k ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        switch (viewType) {
            case 1:
                ItemBookMallTypeGridBinding inflate = ItemBookMallTypeGridBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
                Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
                return new ItemGridHolder(inflate, this.mViewModel, this.mLifecycleOwner);
            case 2:
                ItemBookMallTypeCategoryBinding inflate2 = ItemBookMallTypeCategoryBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
                Intrinsics.checkNotNullExpressionValue(inflate2, "inflate(...)");
                return new ItemCategoryHolder(inflate2, this.mViewModel, this.mLifecycleOwner);
            case 3:
                ItemBookMallTypeRankBinding inflate3 = ItemBookMallTypeRankBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
                Intrinsics.checkNotNullExpressionValue(inflate3, "inflate(...)");
                return new ItemRankHolder(inflate3, this.mViewModel, this.mLifecycleOwner);
            case 4:
                ItemBookMallTypeGenderBinding inflate4 = ItemBookMallTypeGenderBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
                Intrinsics.checkNotNullExpressionValue(inflate4, "inflate(...)");
                return new ItemGenderHolder(inflate4);
            case 5:
                ItemBookMallTypeTabBinding inflate5 = ItemBookMallTypeTabBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
                Intrinsics.checkNotNullExpressionValue(inflate5, "inflate(...)");
                return new ItemTabHolder(inflate5, this.mViewModel);
            case 6:
                ItemBookMallTypeRecommendTitleBinding inflate6 = ItemBookMallTypeRecommendTitleBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
                Intrinsics.checkNotNullExpressionValue(inflate6, "inflate(...)");
                return new ItemRecommendTitleHolder(inflate6);
            case 7:
            default:
                ItemBookMallTypeRecommendBookBinding inflate7 = ItemBookMallTypeRecommendBookBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
                Intrinsics.checkNotNullExpressionValue(inflate7, "inflate(...)");
                return new ItemRecommendBookHolder(inflate7, this.mViewModel);
            case 8:
                ItemBookMallTypeReadingRecordBinding inflate8 = ItemBookMallTypeReadingRecordBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
                Intrinsics.checkNotNullExpressionValue(inflate8, "inflate(...)");
                return new ItemReadingRecordHolder(inflate8, this.mViewModel);
        }
    }

    @SuppressLint({"NotifyDataSetChanged"})
    public final void r(@l RecyclerView recyclerView) {
        RecyclerView.ViewHolder findViewHolderForAdapterPosition;
        if (recyclerView == null || this.mDiffer.getCurrentList().size() <= 0) {
            return;
        }
        RecyclerView.RecycledViewPool recycledViewPool = recyclerView.getRecycledViewPool();
        Intrinsics.checkNotNullExpressionValue(recycledViewPool, "getRecycledViewPool(...)");
        int pageSize = getPageSize();
        for (int i10 = 0; i10 < pageSize; i10++) {
            if (recycledViewPool.getRecycledView(getItemViewType(i10)) == null && (findViewHolderForAdapterPosition = recyclerView.findViewHolderForAdapterPosition(i10)) != null && (findViewHolderForAdapterPosition instanceof ItemRankHolder)) {
                notifyItemChanged(i10);
            }
        }
    }

    public final void s(@k YWBookChannel item) {
        Intrinsics.checkNotNullParameter(item, "item");
        List<YWBookChannel> currentList = this.mDiffer.getCurrentList();
        Intrinsics.checkNotNullExpressionValue(currentList, "getCurrentList(...)");
        List<YWBookChannel> mutableList = CollectionsKt.toMutableList((Collection) currentList);
        mutableList.remove(item);
        this.mDiffer.submitList(mutableList);
    }

    public final void t(@k RecyclerView recyclerView) {
        ItemBaseHolder itemBaseHolder;
        Set<String> c10;
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        RecyclerView.RecycledViewPool recycledViewPool = recyclerView.getRecycledViewPool();
        Intrinsics.checkNotNullExpressionValue(recycledViewPool, "getRecycledViewPool(...)");
        int pageSize = getPageSize();
        for (int i10 = 0; i10 < pageSize; i10++) {
            RecyclerView.ViewHolder recycledView = recycledViewPool.getRecycledView(getItemViewType(i10));
            if (recycledView != null) {
                itemBaseHolder = recycledView instanceof ItemBaseHolder ? (ItemBaseHolder) recycledView : null;
                if (itemBaseHolder != null) {
                    itemBaseHolder.g();
                }
            } else {
                RecyclerView.ViewHolder findViewHolderForAdapterPosition = recyclerView.findViewHolderForAdapterPosition(i10);
                if (findViewHolderForAdapterPosition != null) {
                    boolean z10 = findViewHolderForAdapterPosition instanceof ItemBaseHolder;
                    ItemBaseHolder itemBaseHolder2 = z10 ? (ItemBaseHolder) findViewHolderForAdapterPosition : null;
                    if (itemBaseHolder2 != null) {
                        itemBaseHolder2.g();
                    }
                    itemBaseHolder = z10 ? (ItemBaseHolder) findViewHolderForAdapterPosition : null;
                    if (itemBaseHolder != null && (c10 = itemBaseHolder.c()) != null) {
                        c10.clear();
                    }
                }
            }
        }
    }

    public final void u(@k ItemGenderHolder.a bookMallActionListener) {
        Intrinsics.checkNotNullParameter(bookMallActionListener, "bookMallActionListener");
        this.bookMallActionListener = bookMallActionListener;
    }

    public final void v(List<? extends YWBookChannel> newData, ArrayList<YWBookChannel> listData) {
        Integer mcid;
        Integer mcid2;
        YWBookChannel yWBookChannel;
        int k10;
        Integer mcid3;
        Integer mcid4;
        int i10 = 0;
        for (Object obj : newData) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            YWBookChannel yWBookChannel2 = (YWBookChannel) obj;
            Integer mcid5 = yWBookChannel2.getMcid();
            if ((mcid5 != null && mcid5.intValue() == -5) || (((mcid = yWBookChannel2.getMcid()) != null && mcid.intValue() == -6) || ((mcid2 = yWBookChannel2.getMcid()) != null && mcid2.intValue() == -1000099))) {
                listData.add(yWBookChannel2);
            } else {
                List<YWBookChannel.SubTab> subtabs = yWBookChannel2.getSubtabs();
                if (subtabs != null && !subtabs.isEmpty()) {
                    Integer mcid6 = yWBookChannel2.getMcid();
                    if ((mcid6 != null && mcid6.intValue() == -1000006) || ((mcid3 = yWBookChannel2.getMcid()) != null && mcid3.intValue() == -1000005)) {
                        listData.add(yWBookChannel2);
                    } else {
                        Integer mcid7 = yWBookChannel2.getMcid();
                        if ((mcid7 != null && mcid7.intValue() == -1000010) || ((mcid4 = yWBookChannel2.getMcid()) != null && mcid4.intValue() == -1000009)) {
                            listData.add(yWBookChannel2);
                        }
                    }
                }
                if (yWBookChannel2.getLayoutType() == 1 || yWBookChannel2.getLayoutType() == -1 || yWBookChannel2.getLayoutType() == -2 || yWBookChannel2.getLayoutType() == -4) {
                    listData.add(yWBookChannel2);
                } else {
                    if (ba.l.q(yWBookChannel2.getTitle())) {
                        int lastIndex = CollectionsKt.getLastIndex(listData);
                        if (lastIndex >= 0) {
                            YWBookChannel yWBookChannel3 = listData.get(lastIndex);
                            Intrinsics.checkNotNullExpressionValue(yWBookChannel3, "get(...)");
                            YWBookChannel yWBookChannel4 = yWBookChannel3;
                            int k11 = k(yWBookChannel4);
                            if ((k11 == 6 || k11 == 7) && yWBookChannel4.isLastBookItem()) {
                                notifyItemChanged(lastIndex, 1);
                            }
                        }
                    } else {
                        YWBookChannel yWBookChannel5 = new YWBookChannel();
                        yWBookChannel5.setMcid(yWBookChannel2.getMcid());
                        yWBookChannel5.setTitle(yWBookChannel2.getTitle());
                        yWBookChannel5.setBottomType(Integer.valueOf(yWBookChannel2.getBottomType()));
                        yWBookChannel5.setRecommendType(1);
                        listData.add(yWBookChannel5);
                    }
                    List<TYBookItem> bookList = yWBookChannel2.getBookList();
                    if (bookList != null) {
                        Intrinsics.checkNotNull(bookList);
                        int i12 = 0;
                        for (Object obj2 : bookList) {
                            int i13 = i12 + 1;
                            if (i12 < 0) {
                                CollectionsKt.throwIndexOverflow();
                            }
                            YWBookChannel yWBookChannel6 = new YWBookChannel();
                            yWBookChannel6.setMcid(yWBookChannel2.getMcid());
                            yWBookChannel6.setRecommendType(0);
                            yWBookChannel6.setBookItem((TYBookItem) obj2);
                            yWBookChannel6.setExposed(Boolean.FALSE);
                            listData.add(yWBookChannel6);
                            List<TYBookItem> bookList2 = yWBookChannel2.getBookList();
                            Intrinsics.checkNotNullExpressionValue(bookList2, "getBookList(...)");
                            if (i12 == CollectionsKt.getLastIndex(bookList2)) {
                                if (i11 > CollectionsKt.getLastIndex(newData) || !((k10 = k((yWBookChannel = newData.get(i11)))) == 6 || k10 == 7)) {
                                    yWBookChannel6.setLastBookItem(true);
                                } else {
                                    yWBookChannel6.setLastBookItem(!ba.l.q(yWBookChannel.getTitle()));
                                }
                            }
                            i12 = i13;
                        }
                    }
                }
            }
            i10 = i11;
        }
    }

    public final void w(@l YWBookChannel yWBookChannel, int i10) {
        List<YWBookChannel> currentList = this.mDiffer.getCurrentList();
        Intrinsics.checkNotNullExpressionValue(currentList, "getCurrentList(...)");
        List<YWBookChannel> mutableList = CollectionsKt.toMutableList((Collection) currentList);
        if (mutableList.size() > i10) {
            mutableList.set(i10, yWBookChannel);
        }
        this.mDiffer.submitList(mutableList);
    }

    public final void x(@k List<? extends YWBookChannel> newData) {
        Intrinsics.checkNotNullParameter(newData, "newData");
        ArrayList<YWBookChannel> arrayList = new ArrayList<>();
        v(newData, arrayList);
        this.mDiffer.submitList(arrayList);
        RecyclerViewExposeManager recyclerViewExposeManager = this.recyclerViewExposeManager;
        if (recyclerViewExposeManager != null) {
            RecyclerViewExposeManager.handleCurrentVisibleItems$default(recyclerViewExposeManager, true, 0L, 2, null);
        }
    }
}
