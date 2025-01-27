package com.martian.mibook.mvvm.yuewen.adapter.holder;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.martian.mibook.activity.base.MiWebViewActivity;
import com.martian.mibook.activity.book.FinishedOrNewBooksActivity;
import com.martian.mibook.activity.book.YWChannelBooksActivity;
import com.martian.mibook.databinding.ItemBookMallTypeGridBinding;
import com.martian.mibook.lib.model.data.TYBookItem;
import com.martian.mibook.lib.yuewen.response.YWBookChannel;
import com.martian.mibook.mvvm.net.ErrorResult;
import com.martian.mibook.mvvm.net.request.YWBookChannelBooksParams;
import com.martian.mibook.mvvm.yuewen.adapter.BookMallAdapter;
import com.martian.mibook.mvvm.yuewen.adapter.GridBookAdapter;
import com.martian.mibook.mvvm.yuewen.adapter.holder.ItemGridHolder;
import com.martian.mibook.mvvm.yuewen.viewmodel.BookMallViewModel;
import com.umeng.analytics.pro.bt;
import i8.g;
import id.c;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0013B!\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0015\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u001d\u0010\u0016J\u0017\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\nH\u0002¢\u0006\u0004\b\u001e\u0010\u001fJC\u0010&\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\n2\b\u0010 \u001a\u0004\u0018\u00010\u00102\b\u0010!\u001a\u0004\u0018\u00010\u00102\u0006\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020\u00102\u0006\u0010%\u001a\u00020\u0010H\u0002¢\u0006\u0004\b&\u0010'R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0017\u0010(\u001a\u0004\b)\u0010*R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010+R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010-R\u0018\u00101\u001a\u0004\u0018\u00010.8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u00100R\u0014\u00105\u001a\u0002028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b3\u00104¨\u00066"}, d2 = {"Lcom/martian/mibook/mvvm/yuewen/adapter/holder/ItemGridHolder;", "Lcom/martian/mibook/mvvm/yuewen/adapter/BookMallAdapter$ItemBaseHolder;", "Lcom/martian/mibook/databinding/ItemBookMallTypeGridBinding;", "binding", "Lcom/martian/mibook/mvvm/yuewen/viewmodel/BookMallViewModel;", "mViewModel", "Landroidx/lifecycle/LifecycleOwner;", "mLifecycleOwner", "<init>", "(Lcom/martian/mibook/databinding/ItemBookMallTypeGridBinding;Lcom/martian/mibook/mvvm/yuewen/viewmodel/BookMallViewModel;Landroidx/lifecycle/LifecycleOwner;)V", "Lcom/martian/mibook/lib/yuewen/response/YWBookChannel;", "ywBookChannel", "", "u", "(Lcom/martian/mibook/lib/yuewen/response/YWBookChannel;)Z", "bookChannel", "", c.f26972i, "", "a", "(Lcom/martian/mibook/lib/yuewen/response/YWBookChannel;I)V", "g", "()V", "f", "(I)V", "Lcom/martian/mibook/mvvm/yuewen/adapter/holder/ItemGridHolder$a;", "bookMallActionListener", IAdInterListener.AdReqParam.WIDTH, "(Lcom/martian/mibook/mvvm/yuewen/adapter/holder/ItemGridHolder$a;)V", "x", "q", "(Lcom/martian/mibook/lib/yuewen/response/YWBookChannel;)V", "tid", "ctype", "", "title", "mcid", "speed", "v", "(Lcom/martian/mibook/lib/yuewen/response/YWBookChannel;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;II)Z", "Lcom/martian/mibook/databinding/ItemBookMallTypeGridBinding;", bt.aO, "()Lcom/martian/mibook/databinding/ItemBookMallTypeGridBinding;", "Lcom/martian/mibook/mvvm/yuewen/adapter/holder/ItemGridHolder$a;", "h", "Lcom/martian/mibook/lib/yuewen/response/YWBookChannel;", "Lcom/martian/mibook/mvvm/yuewen/adapter/GridBookAdapter;", "i", "Lcom/martian/mibook/mvvm/yuewen/adapter/GridBookAdapter;", "adapter", "Landroid/graphics/Rect;", "j", "Landroid/graphics/Rect;", "viewBounds", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes3.dex */
public final class ItemGridHolder extends BookMallAdapter.ItemBaseHolder {

    /* renamed from: f, reason: from kotlin metadata */
    @k
    public final ItemBookMallTypeGridBinding binding;

    /* renamed from: g, reason: from kotlin metadata */
    @l
    public a bookMallActionListener;

    /* renamed from: h, reason: from kotlin metadata */
    @l
    public YWBookChannel bookChannel;

    /* renamed from: i, reason: from kotlin metadata */
    @l
    public GridBookAdapter adapter;

    /* renamed from: j, reason: from kotlin metadata */
    @k
    public final Rect viewBounds;

    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "", "Lcom/martian/mibook/lib/model/data/TYBookItem;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
    /* renamed from: com.martian.mibook.mvvm.yuewen.adapter.holder.ItemGridHolder$1 */
    public static final class AnonymousClass1 extends Lambda implements Function1<List<? extends TYBookItem>, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        public static final void invoke$lambda$0(ItemGridHolder this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            YWBookChannel yWBookChannel = this$0.bookChannel;
            if (yWBookChannel != null) {
                yWBookChannel.setExposed(Boolean.FALSE);
            }
            this$0.f(this$0.getBindingAdapterPosition());
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends TYBookItem> list) {
            invoke2(list);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke */
        public final void invoke2(@l List<? extends TYBookItem> list) {
            List<TYBookItem> arrayList;
            Integer pageIndex;
            ItemGridHolder.this.getBinding().titleView.bookMoreProgressbar.setVisibility(8);
            ItemGridHolder.this.getBinding().titleView.authorBookMoreView.setVisibility(0);
            YWBookChannel yWBookChannel = ItemGridHolder.this.bookChannel;
            if (yWBookChannel != null) {
                yWBookChannel.setBookList(list);
            }
            YWBookChannel yWBookChannel2 = ItemGridHolder.this.bookChannel;
            if (yWBookChannel2 != null) {
                YWBookChannel yWBookChannel3 = ItemGridHolder.this.bookChannel;
                yWBookChannel2.setPageIndex((yWBookChannel3 == null || (pageIndex = yWBookChannel3.getPageIndex()) == null) ? null : Integer.valueOf(pageIndex.intValue() + 1));
            }
            a aVar = ItemGridHolder.this.bookMallActionListener;
            if (aVar != null) {
                aVar.a(ItemGridHolder.this.bookChannel, ItemGridHolder.this.getBindingAdapterPosition());
            }
            GridBookAdapter gridBookAdapter = ItemGridHolder.this.adapter;
            if (gridBookAdapter != null) {
                YWBookChannel yWBookChannel4 = ItemGridHolder.this.bookChannel;
                if (yWBookChannel4 == null || (arrayList = yWBookChannel4.getBookList()) == null) {
                    arrayList = new ArrayList<>();
                }
                gridBookAdapter.o(arrayList);
            }
            ItemGridHolder.this.getBinding().rvGridBooks.postDelayed(new Runnable() { // from class: com.martian.mibook.mvvm.yuewen.adapter.holder.a
                public /* synthetic */ a() {
                }

                @Override // java.lang.Runnable
                public final void run() {
                    ItemGridHolder.AnonymousClass1.invoke$lambda$0(ItemGridHolder.this);
                }
            }, 500L);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Lcom/martian/mibook/mvvm/net/ErrorResult;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
    /* renamed from: com.martian.mibook.mvvm.yuewen.adapter.holder.ItemGridHolder$2 */
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
            ItemGridHolder.this.getBinding().titleView.bookMoreProgressbar.setVisibility(8);
            ItemGridHolder.this.getBinding().titleView.authorBookMoreView.setVisibility(0);
        }
    }

    public interface a {
        void a(@l YWBookChannel yWBookChannel, int i10);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ItemGridHolder(@k ItemBookMallTypeGridBinding binding, @l BookMallViewModel bookMallViewModel, @k LifecycleOwner mLifecycleOwner) {
        super(binding, bookMallViewModel);
        MutableLiveData<ErrorResult> z10;
        MutableLiveData<List<TYBookItem>> A;
        Intrinsics.checkNotNullParameter(binding, "binding");
        Intrinsics.checkNotNullParameter(mLifecycleOwner, "mLifecycleOwner");
        this.binding = binding;
        if (bookMallViewModel != null && (A = bookMallViewModel.A()) != null) {
            A.observe(mLifecycleOwner, new Observer() { // from class: ud.k
                public /* synthetic */ k() {
                }

                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    ItemGridHolder.l(Function1.this, obj);
                }
            });
        }
        if (bookMallViewModel != null && (z10 = bookMallViewModel.z()) != null) {
            z10.observe(mLifecycleOwner, new Observer() { // from class: ud.l
                public /* synthetic */ l() {
                }

                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    ItemGridHolder.m(Function1.this, obj);
                }
            });
        }
        this.viewBounds = new Rect();
    }

    public static final void l(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void m(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void r(ItemGridHolder this$0, YWBookChannel bookChannel, Integer num, Integer num2, String title, int i10, int i11, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(bookChannel, "$bookChannel");
        Intrinsics.checkNotNullParameter(title, "$title");
        this$0.v(bookChannel, num, num2, title, i10, i11);
    }

    public static final void s(ItemGridHolder this$0, YWBookChannel bookChannel, String title, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(bookChannel, "$bookChannel");
        Intrinsics.checkNotNullParameter(title, "$title");
        this$0.q(bookChannel);
        ac.a.K(this$0.getCom.umeng.analytics.pro.f.X java.lang.String(), title, "换一批");
    }

    private final boolean u(YWBookChannel ywBookChannel) {
        if (ywBookChannel == null) {
            return false;
        }
        if (g.h(getCom.umeng.analytics.pro.f.X java.lang.String(), ywBookChannel.getBottomDeeplink())) {
            g.A(getCom.umeng.analytics.pro.f.X java.lang.String(), ywBookChannel.getBottomDeeplink(), "", "", true);
            return true;
        }
        if (ba.l.q(ywBookChannel.getBottomUrl())) {
            return false;
        }
        Context context = getCom.umeng.analytics.pro.f.X java.lang.String();
        Activity activity = context instanceof Activity ? (Activity) context : null;
        if (activity != null) {
            MiWebViewActivity.startWebViewActivity(activity, ywBookChannel.getBottomUrl());
        }
        return true;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: ProcessVariables
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: ud.i.<init>(com.martian.mibook.mvvm.yuewen.adapter.holder.ItemGridHolder, com.martian.mibook.lib.yuewen.response.YWBookChannel, java.lang.Integer, java.lang.Integer, java.lang.String, int, int):void, class status: GENERATED_AND_UNLOADED
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
    public void a(@xi.k com.martian.mibook.lib.yuewen.response.YWBookChannel r11, int r12) {
        /*
            Method dump skipped, instructions count: 316
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.martian.mibook.mvvm.yuewen.adapter.holder.ItemGridHolder.a(com.martian.mibook.lib.yuewen.response.YWBookChannel, int):void");
    }

    @Override // com.martian.mibook.mvvm.yuewen.adapter.BookMallAdapter.ItemBaseHolder
    public void f(int r92) {
        YWBookChannel yWBookChannel;
        List<TYBookItem> bookList;
        TYBookItem tYBookItem;
        List<TYBookItem> bookList2;
        YWBookChannel yWBookChannel2;
        if (this.adapter == null) {
            return;
        }
        YWBookChannel yWBookChannel3 = this.bookChannel;
        if (yWBookChannel3 != null && yWBookChannel3.isExposed()) {
            return;
        }
        RecyclerView.LayoutManager layoutManager = this.binding.rvGridBooks.getLayoutManager();
        Intrinsics.checkNotNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.GridLayoutManager");
        GridLayoutManager gridLayoutManager = (GridLayoutManager) layoutManager;
        int findLastVisibleItemPosition = gridLayoutManager.findLastVisibleItemPosition();
        if (findLastVisibleItemPosition < 0) {
            return;
        }
        int i10 = 0;
        while (true) {
            View childAt = gridLayoutManager.getChildAt(i10);
            this.viewBounds.setEmpty();
            if (childAt != null && childAt.getLocalVisibleRect(this.viewBounds) && childAt.getHeight() > 0 && this.viewBounds.height() / childAt.getHeight() >= 0.8f) {
                if (i10 == this.binding.rvGridBooks.getChildCount() - 1 && (yWBookChannel2 = this.bookChannel) != null) {
                    yWBookChannel2.setExposed(Boolean.TRUE);
                }
                YWBookChannel yWBookChannel4 = this.bookChannel;
                if (i10 < ((yWBookChannel4 == null || (bookList2 = yWBookChannel4.getBookList()) == null) ? 0 : bookList2.size()) && (yWBookChannel = this.bookChannel) != null && (bookList = yWBookChannel.getBookList()) != null && (tYBookItem = bookList.get(i10)) != null && !c().contains(tYBookItem.getSourceId())) {
                    Set<String> c10 = c();
                    String sourceId = tYBookItem.getSourceId();
                    Intrinsics.checkNotNullExpressionValue(sourceId, "getSourceId(...)");
                    c10.add(sourceId);
                    e(tYBookItem);
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
        this.adapter = null;
    }

    public final void q(YWBookChannel bookChannel) {
        this.binding.titleView.authorBookMoreView.setVisibility(8);
        this.binding.titleView.bookMoreProgressbar.setVisibility(0);
        YWBookChannelBooksParams yWBookChannelBooksParams = new YWBookChannelBooksParams(null, null, 0, 0, null, null, 63, null);
        yWBookChannelBooksParams.setPage(bookChannel.getPageIndex());
        yWBookChannelBooksParams.setPageSize(bookChannel.getSize());
        Integer mcid = bookChannel.getMcid();
        Intrinsics.checkNotNullExpressionValue(mcid, "getMcid(...)");
        yWBookChannelBooksParams.setMcid(mcid.intValue());
        BookMallViewModel mViewModel = getMViewModel();
        yWBookChannelBooksParams.setSeed(mViewModel != null ? mViewModel.getSpeed() : 0);
        BookMallViewModel mViewModel2 = getMViewModel();
        if (mViewModel2 != null) {
            mViewModel2.s(yWBookChannelBooksParams);
        }
    }

    @k
    /* renamed from: t, reason: from getter */
    public final ItemBookMallTypeGridBinding getBinding() {
        return this.binding;
    }

    public final boolean v(YWBookChannel bookChannel, Integer tid, Integer ctype, String title, int mcid, int speed) {
        if (u(bookChannel)) {
            return true;
        }
        Context context = getCom.umeng.analytics.pro.f.X java.lang.String();
        Activity activity = context instanceof Activity ? (Activity) context : null;
        if (activity == null) {
            return false;
        }
        if (tid != null && ctype != null) {
            FinishedOrNewBooksActivity.startActivity(activity, tid.intValue(), ctype.intValue(), title);
            return false;
        }
        Integer valueOf = Integer.valueOf(mcid);
        int intValue = bookChannel.getPageIndex().intValue() - 1;
        Integer size = bookChannel.getSize();
        Intrinsics.checkNotNullExpressionValue(size, "getSize(...)");
        YWChannelBooksActivity.L2(activity, title, valueOf, speed, (intValue * size.intValue()) / 10, "");
        return false;
    }

    public final void w(@k a bookMallActionListener) {
        Intrinsics.checkNotNullParameter(bookMallActionListener, "bookMallActionListener");
        this.bookMallActionListener = bookMallActionListener;
    }

    public final void x() {
        List<TYBookItem> arrayList;
        if (this.adapter == null) {
            if (this.binding.rvGridBooks.getLayoutManager() == null) {
                this.binding.rvGridBooks.setLayoutManager(new GridLayoutManager(getCom.umeng.analytics.pro.f.X java.lang.String(), GridBookAdapter.INSTANCE.a()));
            }
            GridBookAdapter gridBookAdapter = new GridBookAdapter();
            this.adapter = gridBookAdapter;
            this.binding.rvGridBooks.setAdapter(gridBookAdapter);
        }
        GridBookAdapter gridBookAdapter2 = this.adapter;
        if (gridBookAdapter2 != null) {
            YWBookChannel yWBookChannel = this.bookChannel;
            if (yWBookChannel == null || (arrayList = yWBookChannel.getBookList()) == null) {
                arrayList = new ArrayList<>();
            }
            gridBookAdapter2.o(arrayList);
        }
    }
}
