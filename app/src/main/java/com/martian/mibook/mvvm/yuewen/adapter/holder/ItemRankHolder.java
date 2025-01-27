package com.martian.mibook.mvvm.yuewen.adapter.holder;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.core.view.ViewGroupKt;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.martian.libmars.common.ConfigSingleton;
import com.martian.libmars.utils.tablayout.CommonNavigator;
import com.martian.libmars.utils.tablayout.ImagePagerTitleView;
import com.martian.libmars.utils.tablayout.TextPagerTitleView;
import com.martian.libmars.widget.recyclerview.LoadingTip;
import com.martian.mibook.R;
import com.martian.mibook.databinding.BsBookStoreItemTitleBinding;
import com.martian.mibook.databinding.ItemBookMallTypeRankBinding;
import com.martian.mibook.lib.model.data.TYBookItem;
import com.martian.mibook.lib.yuewen.response.YWBookChannel;
import com.martian.mibook.mvvm.extensions.ExtKt;
import com.martian.mibook.mvvm.net.ErrorResult;
import com.martian.mibook.mvvm.net.request.YWBookChannelBooksParams;
import com.martian.mibook.mvvm.yuewen.adapter.BookMallAdapter;
import com.martian.mibook.mvvm.yuewen.adapter.BookMallRankPagerAdapter;
import com.martian.mibook.mvvm.yuewen.adapter.holder.ItemRankHolder;
import com.martian.mibook.mvvm.yuewen.viewmodel.BookMallViewModel;
import com.martian.mibook.ui.FlexboxTagLayout;
import com.umeng.analytics.pro.bt;
import hf.e;
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
import l9.m0;
import m9.g;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0002\u00155B!\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0017\u0010\fJ\u0017\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\nH\u0002¢\u0006\u0004\b\u001a\u0010\fJ\u0019\u0010\u001b\u001a\u00020\n2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\nH\u0002¢\u0006\u0004\b\u001d\u0010\fJ\u000f\u0010\u001e\u001a\u00020\nH\u0002¢\u0006\u0004\b\u001e\u0010\fJ\u0017\u0010 \u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\u0011H\u0002¢\u0006\u0004\b \u0010\u001cR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0018\u0010!\u001a\u0004\b\"\u0010#R\u001e\u0010'\u001a\n\u0012\u0004\u0012\u00020%\u0018\u00010$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010&R\u0018\u0010+\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010.\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00100\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u0010-R\u0014\u00104\u001a\u0002018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b2\u00103¨\u00066"}, d2 = {"Lcom/martian/mibook/mvvm/yuewen/adapter/holder/ItemRankHolder;", "Lcom/martian/mibook/mvvm/yuewen/adapter/BookMallAdapter$ItemBaseHolder;", "Lcom/martian/mibook/databinding/ItemBookMallTypeRankBinding;", "binding", "Lcom/martian/mibook/mvvm/yuewen/viewmodel/BookMallViewModel;", "mViewModel", "Landroidx/lifecycle/LifecycleOwner;", "mLifecycleOwner", "<init>", "(Lcom/martian/mibook/databinding/ItemBookMallTypeRankBinding;Lcom/martian/mibook/mvvm/yuewen/viewmodel/BookMallViewModel;Landroidx/lifecycle/LifecycleOwner;)V", "", "v", "()V", "Landroidx/viewpager2/widget/ViewPager2;", "viewpager", bt.aJ, "(Landroidx/viewpager2/widget/ViewPager2;)V", "Lcom/martian/mibook/lib/yuewen/response/YWBookChannel;", "bookChannel", "", id.c.f26972i, "a", "(Lcom/martian/mibook/lib/yuewen/response/YWBookChannel;I)V", "g", "f", "(I)V", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, IAdInterListener.AdReqParam.WIDTH, "(Lcom/martian/mibook/lib/yuewen/response/YWBookChannel;)V", "x", "u", "it", "y", "Lcom/martian/mibook/databinding/ItemBookMallTypeRankBinding;", bt.aO, "()Lcom/martian/mibook/databinding/ItemBookMallTypeRankBinding;", "", "Lcom/martian/mibook/lib/yuewen/response/YWBookChannel$SubTab;", "Ljava/util/List;", "subTabs", "Lcom/martian/mibook/mvvm/yuewen/adapter/BookMallRankPagerAdapter;", "h", "Lcom/martian/mibook/mvvm/yuewen/adapter/BookMallRankPagerAdapter;", "rankPagerAdapter", "i", "I", "currentTitleTab", "j", "mcid", "Landroid/graphics/Rect;", "k", "Landroid/graphics/Rect;", "viewBounds", "b", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nItemRankHolder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ItemRankHolder.kt\ncom/martian/mibook/mvvm/yuewen/adapter/holder/ItemRankHolder\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,494:1\n1#2:495\n*E\n"})
/* loaded from: classes3.dex */
public final class ItemRankHolder extends BookMallAdapter.ItemBaseHolder {

    /* renamed from: f, reason: from kotlin metadata */
    @k
    public final ItemBookMallTypeRankBinding binding;

    /* renamed from: g, reason: from kotlin metadata */
    @l
    public List<YWBookChannel.SubTab> subTabs;

    /* renamed from: h, reason: from kotlin metadata */
    @l
    public BookMallRankPagerAdapter rankPagerAdapter;

    /* renamed from: i, reason: from kotlin metadata */
    public int currentTitleTab;

    /* renamed from: j, reason: from kotlin metadata */
    public int mcid;

    /* renamed from: k, reason: from kotlin metadata */
    @k
    public final Rect viewBounds;

    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "", "Lcom/martian/mibook/lib/model/data/TYBookItem;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
    /* renamed from: com.martian.mibook.mvvm.yuewen.adapter.holder.ItemRankHolder$1 */
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
            List<? extends TYBookItem> list2 = list;
            if (list2 == null || list2.isEmpty()) {
                ItemRankHolder.this.getBinding().viewpager.setVisibility(4);
                ItemRankHolder.this.getBinding().gridItemRankLoadingTip.setLoadingTip(LoadingTip.LoadStatus.empty);
                ItemRankHolder.this.getBinding().gridItemRankLoadingTip.setVisibility(0);
                return;
            }
            List list3 = ItemRankHolder.this.subTabs;
            if (list3 != null) {
                ItemRankHolder itemRankHolder = ItemRankHolder.this;
                ((YWBookChannel.SubTab) list3.get(itemRankHolder.currentTitleTab)).setBookList(list);
                List list4 = itemRankHolder.subTabs;
                YWBookChannel.SubTab subTab = list4 != null ? (YWBookChannel.SubTab) list4.get(itemRankHolder.currentTitleTab) : null;
                if (subTab != null) {
                    subTab.setExposed(Boolean.FALSE);
                }
                BookMallRankPagerAdapter bookMallRankPagerAdapter = itemRankHolder.rankPagerAdapter;
                if (bookMallRankPagerAdapter != null) {
                    bookMallRankPagerAdapter.l(list, itemRankHolder.getBinding().viewpager);
                }
                itemRankHolder.getBinding().gridItemRankLoadingTip.setLoadingTip(LoadingTip.LoadStatus.finish);
                itemRankHolder.getBinding().viewpager.setVisibility(0);
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Lcom/martian/mibook/mvvm/net/ErrorResult;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
    /* renamed from: com.martian.mibook.mvvm.yuewen.adapter.holder.ItemRankHolder$2 */
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
            ItemRankHolder.this.getBinding().viewpager.setVisibility(4);
            LoadingTip loadingTip = ItemRankHolder.this.getBinding().gridItemRankLoadingTip;
            if (errorResult.getErrorCode() == -100002) {
                loadingTip.setLoadingTip(LoadingTip.LoadStatus.network_error);
            } else {
                loadingTip.setLoadingTip(LoadingTip.LoadStatus.serverError);
            }
            if (ba.l.q(errorResult.getErrorMsg()) || errorResult.getErrorMsg().length() >= 20) {
                return;
            }
            loadingTip.setTips(ExtKt.c(errorResult.getErrorMsg()));
        }
    }

    public static final class a implements ViewPager2.PageTransformer {

        /* renamed from: a */
        public final int f15566a;

        /* renamed from: b */
        @k
        public final ViewPager2 f15567b;

        public a(int i10, @k ViewPager2 viewPager) {
            Intrinsics.checkNotNullParameter(viewPager, "viewPager");
            this.f15566a = i10;
            this.f15567b = viewPager;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.PageTransformer
        public void transformPage(@k View page, float f10) {
            Intrinsics.checkNotNullParameter(page, "page");
            float f11 = f10 * (-this.f15566a);
            LinearLayout linearLayout = (LinearLayout) page.findViewById(R.id.ll_page);
            Object tag = linearLayout.getTag(R.id.viewPager2_position);
            Integer num = tag instanceof Integer ? (Integer) tag : null;
            int intValue = num != null ? num.intValue() : 0;
            RecyclerView.Adapter adapter = this.f15567b.getAdapter();
            int pageSize = adapter != null ? adapter.getPageSize() : 0;
            if (intValue == pageSize - 1 || pageSize <= 1) {
                linearLayout.setPadding(linearLayout.getPaddingLeft(), linearLayout.getPaddingTop(), linearLayout.getPaddingLeft(), linearLayout.getPaddingBottom());
            } else {
                linearLayout.setPadding(linearLayout.getPaddingLeft(), linearLayout.getPaddingTop(), this.f15566a, linearLayout.getPaddingBottom());
            }
            page.setTranslationX(f11);
        }
    }

    public static final class c implements FlexboxTagLayout.a {
        public c() {
        }

        @Override // com.martian.mibook.ui.FlexboxTagLayout.a
        public void a(@k String title, int i10) {
            Intrinsics.checkNotNullParameter(title, "title");
            ItemRankHolder.this.u();
        }
    }

    public static final class d implements b.a {
        public d() {
        }

        @Override // com.martian.mibook.mvvm.yuewen.adapter.holder.ItemRankHolder.b.a
        public void a(@k View view, int i10) {
            YWBookChannel.SubTab subTab;
            YWBookChannel.SubTab subTab2;
            Intrinsics.checkNotNullParameter(view, "view");
            ItemRankHolder.this.currentTitleTab = i10;
            ItemRankHolder.this.v();
            ItemRankHolder.this.getBinding().titleView.titleMagicIndicator.c(ItemRankHolder.this.currentTitleTab);
            List list = ItemRankHolder.this.subTabs;
            List<TYBookItem> list2 = null;
            List<TYBookItem> bookList = (list == null || (subTab2 = (YWBookChannel.SubTab) list.get(ItemRankHolder.this.currentTitleTab)) == null) ? null : subTab2.getBookList();
            if (bookList == null || bookList.isEmpty()) {
                ItemRankHolder.this.u();
                return;
            }
            BookMallRankPagerAdapter bookMallRankPagerAdapter = ItemRankHolder.this.rankPagerAdapter;
            if (bookMallRankPagerAdapter != null) {
                List list3 = ItemRankHolder.this.subTabs;
                if (list3 != null && (subTab = (YWBookChannel.SubTab) list3.get(ItemRankHolder.this.currentTitleTab)) != null) {
                    list2 = subTab.getBookList();
                }
                bookMallRankPagerAdapter.l(list2, ItemRankHolder.this.getBinding().viewpager);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ItemRankHolder(@k ItemBookMallTypeRankBinding binding, @l BookMallViewModel bookMallViewModel, @k LifecycleOwner mLifecycleOwner) {
        super(binding, bookMallViewModel);
        MutableLiveData<ErrorResult> B;
        MutableLiveData<List<TYBookItem>> C;
        Intrinsics.checkNotNullParameter(binding, "binding");
        Intrinsics.checkNotNullParameter(mLifecycleOwner, "mLifecycleOwner");
        this.binding = binding;
        this.viewBounds = new Rect();
        if (bookMallViewModel != null && (C = bookMallViewModel.C()) != null) {
            C.observe(mLifecycleOwner, new Observer() { // from class: ud.n
                public /* synthetic */ n() {
                }

                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    ItemRankHolder.k(Function1.this, obj);
                }
            });
        }
        if (bookMallViewModel == null || (B = bookMallViewModel.B()) == null) {
            return;
        }
        B.observe(mLifecycleOwner, new Observer() { // from class: ud.o
            public /* synthetic */ o() {
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ItemRankHolder.l(Function1.this, obj);
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

    public static final void s(ItemRankHolder this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.A();
    }

    public final void v() {
        if (this.binding.flexboxCategory.getChildCount() > 0) {
            this.binding.flexboxCategory.removeAllViews();
        }
        List<YWBookChannel.SubTab> list = this.subTabs;
        if (list != null) {
            List<String> categories = list.get(this.currentTitleTab).getCategories();
            if (categories != null) {
                Intrinsics.checkNotNull(categories);
                this.binding.flexboxCategory.setData(categories);
                this.binding.flexboxCategory.setVisibility(0);
            } else {
                this.binding.flexboxCategory.setVisibility(8);
            }
            this.binding.horizontalScrollview.smoothScrollTo(0, 0);
            this.binding.flexboxCategory.setOnItemTitleClickListener(new c());
        }
    }

    private final void z(ViewPager2 viewPager2) {
        View view;
        Iterator<View> it = ViewGroupKt.getChildren(viewPager2).iterator();
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
            view2.setFadingEdgeLength(ConfigSingleton.i(12.0f));
            view2.setHorizontalFadingEdgeEnabled(true);
            recyclerView.addOnItemTouchListener(new RecyclerView.SimpleOnItemTouchListener() { // from class: com.martian.mibook.mvvm.yuewen.adapter.holder.ItemRankHolder$setViewPagerEvent$2$1

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
                    throw new UnsupportedOperationException("Method not decompiled: com.martian.mibook.mvvm.yuewen.adapter.holder.ItemRankHolder$setViewPagerEvent$2$1.onInterceptTouchEvent(androidx.recyclerview.widget.RecyclerView, android.view.MotionEvent):boolean");
                }
            });
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0051, code lost:
    
        if (kotlin.jvm.internal.Intrinsics.areEqual(r4, "全部") != false) goto L107;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0054, code lost:
    
        r2 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0055, code lost:
    
        kc.b.i(r5, r3, r2, "书城-");
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x00ad, code lost:
    
        if (kotlin.jvm.internal.Intrinsics.areEqual(r4, "全部") != false) goto L107;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A() {
        /*
            r7 = this;
            java.lang.String r0 = "书城-"
            java.lang.String r1 = "全部"
            android.content.Context r2 = r7.getCom.umeng.analytics.pro.f.X java.lang.String()
            boolean r2 = r2 instanceof android.app.Activity
            r2 = 0
            r3 = 100
            java.util.List<com.martian.mibook.lib.yuewen.response.YWBookChannel$SubTab> r4 = r7.subTabs     // Catch: java.lang.Throwable -> L27 java.lang.Exception -> L29
            if (r4 == 0) goto L2b
            int r5 = r7.currentTitleTab     // Catch: java.lang.Throwable -> L27 java.lang.Exception -> L29
            java.lang.Object r4 = r4.get(r5)     // Catch: java.lang.Throwable -> L27 java.lang.Exception -> L29
            com.martian.mibook.lib.yuewen.response.YWBookChannel$SubTab r4 = (com.martian.mibook.lib.yuewen.response.YWBookChannel.SubTab) r4     // Catch: java.lang.Throwable -> L27 java.lang.Exception -> L29
            java.lang.String r4 = r4.getExt()     // Catch: java.lang.Throwable -> L27 java.lang.Exception -> L29
            java.lang.String r5 = "getExt(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r5)     // Catch: java.lang.Throwable -> L27 java.lang.Exception -> L29
            int r3 = java.lang.Integer.parseInt(r4)     // Catch: java.lang.Throwable -> L27 java.lang.Exception -> L29
            goto L2b
        L27:
            r4 = move-exception
            goto L59
        L29:
            goto L87
        L2b:
            com.martian.mibook.databinding.ItemBookMallTypeRankBinding r4 = r7.binding
            com.martian.mibook.ui.FlexboxTagLayout r4 = r4.flexboxCategory
            java.lang.String r4 = r4.getSelectedItem()
            com.martian.mibook.mvvm.yuewen.viewmodel.BookMallViewModel r5 = r7.getMViewModel()
            if (r5 == 0) goto L42
            int r5 = r5.u()
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            goto L43
        L42:
            r5 = r2
        L43:
            if (r5 == 0) goto Lb0
            int r5 = r5.intValue()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual(r4, r1)
            if (r1 == 0) goto L54
            goto L55
        L54:
            r2 = r4
        L55:
            kc.b.i(r5, r3, r2, r0)
            goto Lb0
        L59:
            com.martian.mibook.databinding.ItemBookMallTypeRankBinding r5 = r7.binding
            com.martian.mibook.ui.FlexboxTagLayout r5 = r5.flexboxCategory
            java.lang.String r5 = r5.getSelectedItem()
            com.martian.mibook.mvvm.yuewen.viewmodel.BookMallViewModel r6 = r7.getMViewModel()
            if (r6 == 0) goto L70
            int r6 = r6.u()
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            goto L71
        L70:
            r6 = r2
        L71:
            if (r6 == 0) goto L86
            int r6 = r6.intValue()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual(r5, r1)
            if (r1 == 0) goto L82
            goto L83
        L82:
            r2 = r5
        L83:
            kc.b.i(r6, r3, r2, r0)
        L86:
            throw r4
        L87:
            com.martian.mibook.databinding.ItemBookMallTypeRankBinding r4 = r7.binding
            com.martian.mibook.ui.FlexboxTagLayout r4 = r4.flexboxCategory
            java.lang.String r4 = r4.getSelectedItem()
            com.martian.mibook.mvvm.yuewen.viewmodel.BookMallViewModel r5 = r7.getMViewModel()
            if (r5 == 0) goto L9e
            int r5 = r5.u()
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            goto L9f
        L9e:
            r5 = r2
        L9f:
            if (r5 == 0) goto Lb0
            int r5 = r5.intValue()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual(r4, r1)
            if (r1 == 0) goto L54
            goto L55
        Lb0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.martian.mibook.mvvm.yuewen.adapter.holder.ItemRankHolder.A():void");
    }

    @Override // com.martian.mibook.mvvm.yuewen.adapter.BookMallAdapter.ItemBaseHolder
    public void a(@k YWBookChannel bookChannel, int r72) {
        Intrinsics.checkNotNullParameter(bookChannel, "bookChannel");
        BsBookStoreItemTitleBinding bsBookStoreItemTitleBinding = this.binding.titleView;
        int i10 = 8;
        bsBookStoreItemTitleBinding.getRoot().setVisibility(!ba.l.q(bookChannel.getTitle()) ? 0 : 8);
        bsBookStoreItemTitleBinding.contentTitle.setText(ExtKt.c(bookChannel.getTitle()));
        ImageView imageView = bsBookStoreItemTitleBinding.tvBg;
        if (!ba.l.q(bookChannel.getTopBgUrl())) {
            m0.k(getCom.umeng.analytics.pro.f.X java.lang.String(), bookChannel.getTopBgUrl(), bsBookStoreItemTitleBinding.tvBg);
            i10 = 0;
        }
        imageView.setVisibility(i10);
        bsBookStoreItemTitleBinding.contentMore.setVisibility(0);
        bsBookStoreItemTitleBinding.authorBookMore.setText(getCom.umeng.analytics.pro.f.X java.lang.String().getString(R.string.whole_rank));
        bsBookStoreItemTitleBinding.authorBookMoreView.setImageResource(R.drawable.loan_more);
        this.binding.getRoot().setSelectableLayout(true);
        bsBookStoreItemTitleBinding.contentMore.setSelectableLayout(false);
        this.binding.getRoot().setOnClickListener(new View.OnClickListener() { // from class: ud.m
            public /* synthetic */ m() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ItemRankHolder.s(ItemRankHolder.this, view);
            }
        });
        w(bookChannel);
    }

    @Override // com.martian.mibook.mvvm.yuewen.adapter.BookMallAdapter.ItemBaseHolder
    public void f(int r15) {
        View view;
        View findViewByPosition;
        TYBookItem tYBookItem;
        YWBookChannel.SubTab subTab;
        YWBookChannel.SubTab subTab2;
        if (this.rankPagerAdapter == null) {
            return;
        }
        List<YWBookChannel.SubTab> list = this.subTabs;
        if (list == null || (subTab2 = list.get(this.currentTitleTab)) == null || !subTab2.isExposed()) {
            ViewPager2 viewpager = this.binding.viewpager;
            Intrinsics.checkNotNullExpressionValue(viewpager, "viewpager");
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
                RecyclerView recyclerView = view2 instanceof RecyclerView ? (RecyclerView) view2 : null;
                RecyclerView.LayoutManager layoutManager = recyclerView != null ? recyclerView.getLayoutManager() : null;
                LinearLayoutManager linearLayoutManager = layoutManager instanceof LinearLayoutManager ? (LinearLayoutManager) layoutManager : null;
                if (linearLayoutManager == null || (findViewByPosition = linearLayoutManager.findViewByPosition(this.binding.viewpager.getCurrentItem())) == null) {
                    return;
                }
                Intrinsics.checkNotNull(findViewByPosition);
                View findViewByPosition2 = linearLayoutManager.findViewByPosition(this.binding.viewpager.getCurrentItem() + 1);
                LinearLayout linearLayout = findViewByPosition instanceof LinearLayout ? (LinearLayout) findViewByPosition : null;
                if (linearLayout == null) {
                    return;
                }
                LinearLayout linearLayout2 = findViewByPosition2 instanceof LinearLayout ? (LinearLayout) findViewByPosition2 : null;
                List<YWBookChannel.SubTab> list2 = this.subTabs;
                List<TYBookItem> bookList = (list2 == null || (subTab = list2.get(this.currentTitleTab)) == null) ? null : subTab.getBookList();
                int childCount = linearLayout.getChildCount() * this.binding.viewpager.getCurrentItem();
                int childCount2 = linearLayout.getChildCount() + childCount + (linearLayout2 != null ? linearLayout2.getChildCount() : 0);
                int i10 = childCount;
                while (i10 < childCount2) {
                    View childAt = i10 < linearLayout.getChildCount() + childCount ? linearLayout.getChildAt(i10 - childCount) : linearLayout2 != null ? linearLayout2.getChildAt((i10 - childCount) - linearLayout.getChildCount()) : null;
                    if (childAt != null && childAt.getLocalVisibleRect(this.viewBounds) && childAt.getHeight() > 0 && this.viewBounds.height() / childAt.getHeight() >= 0.8f) {
                        if (i10 == childCount2 - 1) {
                            List<YWBookChannel.SubTab> list3 = this.subTabs;
                            YWBookChannel.SubTab subTab3 = list3 != null ? list3.get(this.currentTitleTab) : null;
                            if (subTab3 != null) {
                                subTab3.setExposed(Boolean.TRUE);
                            }
                        }
                        if (i10 < (bookList != null ? bookList.size() : 0) && bookList != null && (tYBookItem = bookList.get(i10)) != null) {
                            Intrinsics.checkNotNull(tYBookItem);
                            int mSelectPosition = this.binding.flexboxCategory.getMSelectPosition();
                            if (!c().contains(this.currentTitleTab + e.f26694a + mSelectPosition + e.f26694a + tYBookItem.getSourceId())) {
                                c().add(this.currentTitleTab + e.f26694a + mSelectPosition + e.f26694a + tYBookItem.getSourceId());
                                e(tYBookItem);
                            }
                        }
                    }
                    i10++;
                }
            }
        }
    }

    @Override // com.martian.mibook.mvvm.yuewen.adapter.BookMallAdapter.ItemBaseHolder
    public void g() {
        this.rankPagerAdapter = null;
        this.currentTitleTab = 0;
    }

    @k
    /* renamed from: t, reason: from getter */
    public final ItemBookMallTypeRankBinding getBinding() {
        return this.binding;
    }

    public final void u() {
        List<YWBookChannel.SubTab> list = this.subTabs;
        if (list != null) {
            int size = list.size();
            int i10 = this.currentTitleTab;
            if (size <= i10) {
                return;
            }
            String ext = list.get(i10).getExt();
            String selectedItem = this.binding.flexboxCategory.getSelectedItem();
            int mSelectPosition = this.binding.flexboxCategory.getMSelectPosition();
            this.binding.viewpager.setVisibility(4);
            this.binding.gridItemRankLoadingTip.setLoadingTip(LoadingTip.LoadStatus.loading);
            this.binding.gridItemRankLoadingTip.setVisibility(0);
            this.binding.gridItemRankLoadingTip.setOnReloadListener(new Function0<Unit>() { // from class: com.martian.mibook.mvvm.yuewen.adapter.holder.ItemRankHolder$loadBooksRankData$1$1
                public ItemRankHolder$loadBooksRankData$1$1() {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke */
                public final void invoke2() {
                    ItemRankHolder.this.u();
                }
            });
            BookMallRankPagerAdapter bookMallRankPagerAdapter = this.rankPagerAdapter;
            if (bookMallRankPagerAdapter != null) {
                bookMallRankPagerAdapter.l(null, this.binding.viewpager);
            }
            YWBookChannelBooksParams yWBookChannelBooksParams = new YWBookChannelBooksParams(null, null, 0, 0, null, null, 63, null);
            yWBookChannelBooksParams.setPage(0);
            yWBookChannelBooksParams.setPageSize(16);
            yWBookChannelBooksParams.setMcid(this.mcid);
            yWBookChannelBooksParams.setExt(ExtKt.d(ext));
            yWBookChannelBooksParams.setCategory(ExtKt.d(selectedItem));
            yWBookChannelBooksParams.makeSpeed();
            BookMallViewModel mViewModel = getMViewModel();
            if (mViewModel != null) {
                mViewModel.E(yWBookChannelBooksParams, mSelectPosition > 0);
            }
        }
    }

    public final void w(YWBookChannel yWBookChannel) {
        this.currentTitleTab = 0;
        if (yWBookChannel != null) {
            ArrayList arrayList = new ArrayList();
            this.subTabs = arrayList;
            List<YWBookChannel.SubTab> subtabs = yWBookChannel.getSubtabs();
            Intrinsics.checkNotNullExpressionValue(subtabs, "getSubtabs(...)");
            arrayList.addAll(subtabs);
            Integer mcid = yWBookChannel.getMcid();
            Intrinsics.checkNotNullExpressionValue(mcid, "getMcid(...)");
            this.mcid = mcid.intValue();
            List<YWBookChannel.SubTab> list = this.subTabs;
            if (list == null || list.isEmpty()) {
                this.binding.titleView.contentTitle.setVisibility(ba.l.q(yWBookChannel.getTitle()) ? 8 : 0);
                this.binding.titleView.titleMagicIndicator.setVisibility(8);
                this.binding.flexboxCategory.setVisibility(8);
                return;
            }
            this.binding.titleView.contentTitle.setVisibility(8);
            this.binding.titleView.titleMagicIndicator.setVisibility(0);
            List<YWBookChannel.SubTab> list2 = this.subTabs;
            YWBookChannel.SubTab subTab = list2 != null ? list2.get(this.currentTitleTab) : null;
            if (subTab != null) {
                subTab.setBookList(yWBookChannel.getBookList());
            }
            x();
            v();
            y(yWBookChannel);
        }
    }

    public final void x() {
        List<YWBookChannel.SubTab> list = this.subTabs;
        if (list != null) {
            b bVar = new b(list);
            bVar.m(new d());
            CommonNavigator commonNavigator = new CommonNavigator(getCom.umeng.analytics.pro.f.X java.lang.String());
            commonNavigator.setMarginHorizontal(0);
            commonNavigator.setAdapter(bVar);
            this.binding.titleView.titleMagicIndicator.setNavigator(commonNavigator);
        }
    }

    public final void y(YWBookChannel it) {
        if (this.rankPagerAdapter == null) {
            this.rankPagerAdapter = new BookMallRankPagerAdapter();
            this.binding.viewpager.registerOnPageChangeCallback(new ItemRankHolder$setViewPager$1(this));
            this.binding.gridItemRankLoadingTip.setBackgroundType(20);
            this.binding.viewpager.setOrientation(0);
            ViewPager2 viewpager = this.binding.viewpager;
            Intrinsics.checkNotNullExpressionValue(viewpager, "viewpager");
            z(viewpager);
            int dimensionPixelOffset = getCom.umeng.analytics.pro.f.X java.lang.String().getResources().getDimensionPixelOffset(R.dimen.pageOffset);
            ViewPager2 viewpager2 = this.binding.viewpager;
            Intrinsics.checkNotNullExpressionValue(viewpager2, "viewpager");
            viewpager2.setPageTransformer(new a(dimensionPixelOffset, viewpager2));
            this.binding.viewpager.setOffscreenPageLimit(3);
            this.binding.viewpager.setAdapter(this.rankPagerAdapter);
        }
        BookMallRankPagerAdapter bookMallRankPagerAdapter = this.rankPagerAdapter;
        if (bookMallRankPagerAdapter != null) {
            bookMallRankPagerAdapter.l(it.getBookList(), this.binding.viewpager);
        }
        this.binding.gridItemRankLoadingTip.setLoadingTip(LoadingTip.LoadStatus.finish);
        this.binding.viewpager.setVisibility(0);
    }

    public static final class b extends m9.b {

        /* renamed from: b */
        @k
        public List<? extends YWBookChannel.SubTab> f15568b;

        /* renamed from: c */
        @l
        public a f15569c;

        public interface a {
            void a(@k View view, int i10);
        }

        public b() {
            this.f15568b = new ArrayList();
        }

        public static final void k(b this$0, int i10, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            a aVar = this$0.f15569c;
            if (aVar != null) {
                Intrinsics.checkNotNull(view);
                aVar.a(view, i10);
            }
        }

        public static final void l(b this$0, int i10, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            a aVar = this$0.f15569c;
            if (aVar != null) {
                Intrinsics.checkNotNull(view);
                aVar.a(view, i10);
            }
        }

        @Override // m9.b
        public int a() {
            return this.f15568b.size();
        }

        @Override // m9.b
        @l
        public m9.e b(@k Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return null;
        }

        @Override // m9.b
        @k
        public g c(@k Context context, int i10) {
            Intrinsics.checkNotNullParameter(context, "context");
            if (i10 == 0) {
                ImagePagerTitleView imagePagerTitleView = new ImagePagerTitleView(context, ConfigSingleton.i(41.0f), ConfigSingleton.i(13.5f), 1.125f);
                imagePagerTitleView.setPadding(0, 0, ConfigSingleton.i(12.0f), 0);
                imagePagerTitleView.g(R.drawable.icon_rank_title_text_day_unselected, R.drawable.icon_rank_title_text_day_selected, R.drawable.icon_rank_title_text_night_unselected, R.drawable.icon_rank_title_text_night_selected);
                imagePagerTitleView.setOnClickListener(new View.OnClickListener() { // from class: ud.p

                    /* renamed from: c */
                    public final /* synthetic */ int f31025c;

                    public /* synthetic */ p(int i102) {
                        i10 = i102;
                    }

                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        ItemRankHolder.b.k(ItemRankHolder.b.this, i10, view);
                    }
                });
                return imagePagerTitleView;
            }
            int i11 = i102 == this.f15568b.size() - 1 ? ConfigSingleton.i(35.0f) : ConfigSingleton.i(20.0f);
            TextPagerTitleView textPagerTitleView = new TextPagerTitleView(context, false);
            textPagerTitleView.setTextSize(1, 16.0f);
            textPagerTitleView.setText(ExtKt.c(this.f15568b.get(i102).getTitle()));
            textPagerTitleView.setTextStyleMode(1);
            textPagerTitleView.setMaxScale(1.125f);
            textPagerTitleView.setPadding(0, 0, i11, 0);
            textPagerTitleView.setNormalColor(ConfigSingleton.D().j0());
            textPagerTitleView.setSelectedColor(ConfigSingleton.D().h0());
            textPagerTitleView.setOnClickListener(new View.OnClickListener() { // from class: ud.q

                /* renamed from: c */
                public final /* synthetic */ int f31027c;

                public /* synthetic */ q(int i102) {
                    i10 = i102;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ItemRankHolder.b.l(ItemRankHolder.b.this, i10, view);
                }
            });
            return textPagerTitleView;
        }

        public final void m(@l a aVar) {
            this.f15569c = aVar;
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public b(@k List<? extends YWBookChannel.SubTab> subTabs) {
            this();
            Intrinsics.checkNotNullParameter(subTabs, "subTabs");
            this.f15568b = subTabs;
        }
    }
}
