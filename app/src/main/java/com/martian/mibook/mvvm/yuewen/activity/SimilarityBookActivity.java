package com.martian.mibook.mvvm.yuewen.activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.google.android.material.appbar.AppBarLayout;
import com.kuaishou.weapon.p0.t;
import com.martian.libmars.R;
import com.martian.libmars.common.ConfigSingleton;
import com.martian.libmars.databinding.LayoutToolbarBinding;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.mibook.databinding.ActivitySimilarityBookNewBinding;
import com.martian.mibook.lib.model.data.BookWrapper;
import com.martian.mibook.lib.model.data.TYBookItem;
import com.martian.mibook.lib.model.data.abs.Book;
import com.martian.mibook.mvvm.base.BaseMVVMActivity;
import com.martian.mibook.mvvm.widget.MiClassicsFooter;
import com.martian.mibook.mvvm.yuewen.activity.SimilarityBookActivity;
import com.martian.mibook.mvvm.yuewen.adapter.SimilarityBookBannerAdapter;
import com.martian.mibook.mvvm.yuewen.adapter.TYBookItemListAdapter;
import com.martian.mibook.mvvm.yuewen.viewmodel.SimilarityBookViewModel;
import com.martian.mibook.ui.viewpagerlayoutmanager.CenterSnapHelper;
import com.martian.mibook.ui.viewpagerlayoutmanager.ScaleLayoutManager;
import com.martian.mibook.ui.viewpagerlayoutmanager.ViewPagerLayoutManager;
import com.scwang.smart.refresh.header.MaterialHeader;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import pf.f;
import sf.h;
import xi.k;
import xi.l;

@Route(path = kc.a.f27752h)
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\u0005J\u000f\u0010\b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\b\u0010\u0005J\u000f\u0010\t\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\u0005J\u000f\u0010\n\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\n\u0010\u0005J\u000f\u0010\u000b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000b\u0010\u0005J\u0019\u0010\u000e\u001a\u00020\u00062\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0012\u001a\u00020\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0014\u0010\u0005J\u0017\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u001f\u0010\u001c\u001a\u00020\u00062\u000e\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0019H\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010 \u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u001eH\u0003¢\u0006\u0004\b \u0010!J#\u0010$\u001a\u00020\u00062\b\b\u0002\u0010\"\u001a\u00020\u00152\b\b\u0002\u0010#\u001a\u00020\u0015H\u0002¢\u0006\u0004\b$\u0010%J\u0017\u0010'\u001a\u00020\u00062\u0006\u0010&\u001a\u00020\u0015H\u0002¢\u0006\u0004\b'\u0010\u0018R\u0018\u0010+\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010.\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00101\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u00100R\u001e\u00105\u001a\n\u0012\u0004\u0012\u000202\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u00104R\u0016\u00107\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u00100R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u00109¨\u0006:"}, d2 = {"Lcom/martian/mibook/mvvm/yuewen/activity/SimilarityBookActivity;", "Lcom/martian/mibook/mvvm/base/BaseMVVMActivity;", "Lcom/martian/mibook/databinding/ActivitySimilarityBookNewBinding;", "Lcom/martian/mibook/mvvm/yuewen/viewmodel/SimilarityBookViewModel;", "<init>", "()V", "", "initView", "Y1", "X1", "T1", "U1", "Lcom/martian/libmars/databinding/LayoutToolbarBinding;", "toolbarBinding", "s1", "(Lcom/martian/libmars/databinding/LayoutToolbarBinding;)V", "Landroid/os/Bundle;", "savedInstanceState", "c1", "(Landroid/os/Bundle;)V", "A0", "", "isFollowTheme", "f2", "(Z)V", "", "Lcom/martian/mibook/lib/model/data/TYBookItem;", "bookList", "d2", "(Ljava/util/List;)V", "", "selectedPosition", "e2", "(I)V", "isLoadMore", "showLoading", "V1", "(ZZ)V", "canScroll", "c2", "Lcom/martian/mibook/mvvm/yuewen/adapter/TYBookItemListAdapter;", "h", "Lcom/martian/mibook/mvvm/yuewen/adapter/TYBookItemListAdapter;", "mAdapter", "i", "Z", "loadMoreFail", "j", "I", "pageIndex", "Lcom/martian/mibook/lib/model/data/BookWrapper;", "k", "Ljava/util/List;", "bookWrapperList", t.f11204d, id.c.f26972i, "m", "Ljava/lang/Boolean;", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes3.dex */
public final class SimilarityBookActivity extends BaseMVVMActivity<ActivitySimilarityBookNewBinding, SimilarityBookViewModel> {

    /* renamed from: h, reason: from kotlin metadata */
    @l
    public TYBookItemListAdapter mAdapter;

    /* renamed from: i, reason: from kotlin metadata */
    public boolean loadMoreFail;

    /* renamed from: j, reason: from kotlin metadata */
    public int pageIndex;

    /* renamed from: k, reason: from kotlin metadata */
    @l
    public List<? extends BookWrapper> bookWrapperList;

    /* renamed from: l */
    public int position = -1;

    /* renamed from: m, reason: from kotlin metadata */
    @l
    public Boolean isFollowTheme;

    public static final class a implements SimilarityBookBannerAdapter.a {
        public a() {
        }

        @Override // com.martian.mibook.mvvm.yuewen.adapter.SimilarityBookBannerAdapter.a
        public void a(@l View view, int i10) {
            ie.c.b(SimilarityBookActivity.L1(SimilarityBookActivity.this).recyclerViewBanner, view);
            if (SimilarityBookActivity.this.position == i10) {
                return;
            }
            SimilarityBookActivity.this.e2(i10);
        }
    }

    public static final class b implements ViewPagerLayoutManager.a {
        public b() {
        }

        @Override // com.martian.mibook.ui.viewpagerlayoutmanager.ViewPagerLayoutManager.a
        public void onPageScrollStateChanged(int i10) {
        }

        @Override // com.martian.mibook.ui.viewpagerlayoutmanager.ViewPagerLayoutManager.a
        public void onPageSelected(int i10) {
            if (SimilarityBookActivity.this.position == i10) {
                return;
            }
            SimilarityBookActivity.this.e2(i10);
        }
    }

    public static final class c implements h {
        public c() {
        }

        @Override // sf.g
        public void b(@k f refreshLayout) {
            Intrinsics.checkNotNullParameter(refreshLayout, "refreshLayout");
            SimilarityBookActivity.this.T1();
        }

        @Override // sf.e
        public void p(@k f refreshLayout) {
            Intrinsics.checkNotNullParameter(refreshLayout, "refreshLayout");
            if (!SimilarityBookActivity.this.loadMoreFail) {
                SimilarityBookActivity.this.pageIndex++;
            }
            SimilarityBookActivity.W1(SimilarityBookActivity.this, true, false, 2, null);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ ActivitySimilarityBookNewBinding L1(SimilarityBookActivity similarityBookActivity) {
        return (ActivitySimilarityBookNewBinding) similarityBookActivity.a1();
    }

    public final void T1() {
        e2(this.position);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void U1() {
        this.loadMoreFail = false;
        ((ActivitySimilarityBookNewBinding) a1()).refreshLayout.p();
        ((ActivitySimilarityBookNewBinding) a1()).refreshLayout.S();
        ((ActivitySimilarityBookNewBinding) a1()).refreshLayout.n();
    }

    public static /* synthetic */ void W1(SimilarityBookActivity similarityBookActivity, boolean z10, boolean z11, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = true;
        }
        if ((i10 & 2) != 0) {
            TYBookItemListAdapter tYBookItemListAdapter = similarityBookActivity.mAdapter;
            z11 = (tYBookItemListAdapter != null ? tYBookItemListAdapter.getPageSize() : 0) <= 0;
        }
        similarityBookActivity.V1(z10, z11);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void X1() {
        this.bookWrapperList = m1().n();
        SimilarityBookBannerAdapter similarityBookBannerAdapter = new SimilarityBookBannerAdapter();
        similarityBookBannerAdapter.m(new a());
        ScaleLayoutManager j10 = new ScaleLayoutManager.a().l(ConfigSingleton.i(14.0f)).p(0.65f).r(0).j(this);
        j10.S(new b());
        CenterSnapHelper centerSnapHelper = new CenterSnapHelper();
        ((ActivitySimilarityBookNewBinding) a1()).recyclerViewBanner.setAdapter(similarityBookBannerAdapter);
        ((ActivitySimilarityBookNewBinding) a1()).recyclerViewBanner.setLayoutManager(j10);
        centerSnapHelper.attachToRecyclerView(((ActivitySimilarityBookNewBinding) a1()).recyclerViewBanner);
        similarityBookBannerAdapter.l(this.bookWrapperList);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void Y1() {
        m1().o().observe(this, new Observer() { // from class: sd.g
            public /* synthetic */ g() {
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                SimilarityBookActivity.Z1(Function1.this, obj);
            }
        });
        m1().g().observe(this, new Observer() { // from class: sd.h
            public /* synthetic */ h() {
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                SimilarityBookActivity.a2(Function1.this, obj);
            }
        });
        ((ActivitySimilarityBookNewBinding) a1()).rvLoadedTip.setOnReloadListener(new Function0<Unit>() { // from class: com.martian.mibook.mvvm.yuewen.activity.SimilarityBookActivity$initListener$3
            public SimilarityBookActivity$initListener$3() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke */
            public final void invoke2() {
                SimilarityBookActivity.this.V1(false, true);
            }
        });
    }

    public static final void Z1(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void a2(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void b2(SimilarityBookActivity this$0, AppBarLayout appBarLayout, int i10) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        boolean z10 = Math.abs((float) i10) / ((float) ConfigSingleton.i(12.0f)) >= 1.0f;
        if (Intrinsics.areEqual(this$0.isFollowTheme, Boolean.valueOf(z10))) {
            return;
        }
        this$0.f2(z10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void initView() {
        ((ActivitySimilarityBookNewBinding) a1()).rvSimilarityBook.setLayoutManager(new LinearLayoutManager(this));
        MaterialHeader materialHeader = new MaterialHeader(this);
        materialHeader.b(getResources().getColor(R.color.theme_default));
        ((ActivitySimilarityBookNewBinding) a1()).refreshLayout.O(materialHeader);
        ((ActivitySimilarityBookNewBinding) a1()).refreshLayout.U(new MiClassicsFooter(this, null, false, 6, null));
        ((ActivitySimilarityBookNewBinding) a1()).refreshLayout.B(new c());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.martian.mibook.mvvm.base.BaseMVVMActivity, k9.b
    public void A0() {
        super.A0();
        ((ActivitySimilarityBookNewBinding) a1()).viewTopBg.setAlpha(ConfigSingleton.D().A0() ? 0.0f : 1.0f);
        Boolean bool = this.isFollowTheme;
        f2(bool != null ? bool.booleanValue() : false);
    }

    public final void V1(boolean isLoadMore, boolean showLoading) {
        Book book;
        List<? extends BookWrapper> list = this.bookWrapperList;
        BookWrapper bookWrapper = list != null ? list.get(this.position) : null;
        if (bookWrapper == null || (book = bookWrapper.book) == null) {
            return;
        }
        m1().m(this.pageIndex, book.getSourceName(), book.getSourceId(), book.getBookName(), isLoadMore, showLoading);
    }

    @Override // com.martian.mibook.mvvm.base.BaseActivity
    public void c1(@l Bundle savedInstanceState) {
        initView();
        Y1();
        X1();
        e2(0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void c2(boolean canScroll) {
        ((ActivitySimilarityBookNewBinding) a1()).refreshLayout.N(canScroll);
        ViewGroup.LayoutParams layoutParams = ((ActivitySimilarityBookNewBinding) a1()).rlHeader.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type com.google.android.material.appbar.AppBarLayout.LayoutParams");
        ((AppBarLayout.LayoutParams) layoutParams).setScrollFlags(canScroll ? 3 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void d2(List<? extends TYBookItem> bookList) {
        U1();
        if (this.mAdapter == null) {
            this.mAdapter = new TYBookItemListAdapter();
            ((ActivitySimilarityBookNewBinding) a1()).rvSimilarityBook.setAdapter(this.mAdapter);
        }
        if (this.pageIndex != 0) {
            List<? extends TYBookItem> list = bookList;
            if (list == null || list.isEmpty()) {
                ((ActivitySimilarityBookNewBinding) a1()).refreshLayout.e0();
                return;
            }
            TYBookItemListAdapter tYBookItemListAdapter = this.mAdapter;
            if (tYBookItemListAdapter != null) {
                tYBookItemListAdapter.k(bookList);
                return;
            }
            return;
        }
        List<? extends TYBookItem> list2 = bookList;
        if (list2 == null || list2.isEmpty()) {
            ((ActivitySimilarityBookNewBinding) a1()).rvSimilarityBook.setVisibility(8);
            c2(false);
            z1("", ((ActivitySimilarityBookNewBinding) a1()).rvLoadedTip);
            return;
        }
        C1(((ActivitySimilarityBookNewBinding) a1()).rvLoadedTip);
        c2(true);
        TYBookItemListAdapter tYBookItemListAdapter2 = this.mAdapter;
        if (tYBookItemListAdapter2 != null) {
            tYBookItemListAdapter2.q(null);
        }
        TYBookItemListAdapter tYBookItemListAdapter3 = this.mAdapter;
        if (tYBookItemListAdapter3 != null) {
            tYBookItemListAdapter3.q(bookList);
        }
        ((ActivitySimilarityBookNewBinding) a1()).rvSimilarityBook.setVisibility(0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SuppressLint({"SetTextI18n"})
    public final void e2(int selectedPosition) {
        this.position = selectedPosition;
        ((ActivitySimilarityBookNewBinding) a1()).recyclerViewBanner.smoothScrollToPosition(this.position);
        List<? extends BookWrapper> list = this.bookWrapperList;
        BookWrapper bookWrapper = list != null ? list.get(this.position) : null;
        ThemeTextView themeTextView = ((ActivitySimilarityBookNewBinding) a1()).similarityBookName;
        String bookName = bookWrapper != null ? bookWrapper.getBookName() : null;
        themeTextView.setText("《" + bookName + "》" + getString(com.martian.mibook.R.string.find_similar_book_hint));
        this.pageIndex = 0;
        W1(this, false, false, 2, null);
    }

    public final void f2(boolean isFollowTheme) {
        LayoutToolbarBinding toolbarBinding = getToolbarBinding();
        if (toolbarBinding != null) {
            this.isFollowTheme = Boolean.valueOf(isFollowTheme);
            if (isFollowTheme) {
                toolbarBinding.f12248h.setBackgroundType(0);
                toolbarBinding.f12249i.setTextColorType(0);
                toolbarBinding.f12245e.setEnableFilter(true);
                toolbarBinding.f12249i.p();
                toolbarBinding.f12245e.p();
                return;
            }
            toolbarBinding.f12248h.setBackgroundType(-1);
            toolbarBinding.f12249i.setTextColorType(-1);
            toolbarBinding.f12248h.setBackgroundColor(getResources().getColor(R.color.transparent));
            if (ConfigSingleton.D().A0()) {
                toolbarBinding.f12245e.setEnableFilter(true);
                toolbarBinding.f12249i.setTextColor(getResources().getColor(R.color.night_text_color_primary));
                toolbarBinding.f12245e.setColorFilter(getResources().getColor(R.color.night_text_color_primary));
            } else {
                toolbarBinding.f12245e.setEnableFilter(false);
                toolbarBinding.f12249i.setTextColor(getResources().getColor(R.color.day_text_color_primary));
                toolbarBinding.f12245e.setColorFilter(getResources().getColor(R.color.day_text_color_primary));
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.martian.mibook.mvvm.base.BaseMVVMActivity
    public void s1(@l LayoutToolbarBinding toolbarBinding) {
        super.s1(toolbarBinding);
        if (toolbarBinding != null) {
            toolbarBinding.f12249i.setText(getString(com.martian.mibook.R.string.find_similarities));
        }
        ((ActivitySimilarityBookNewBinding) a1()).viewTopBg.setAlpha(ConfigSingleton.D().A0() ? 0.0f : 1.0f);
        ((ActivitySimilarityBookNewBinding) a1()).appbarLayout.addOnOffsetChangedListener((AppBarLayout.OnOffsetChangedListener) new AppBarLayout.OnOffsetChangedListener() { // from class: sd.i
            public /* synthetic */ i() {
            }

            @Override // com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
            public final void onOffsetChanged(AppBarLayout appBarLayout, int i10) {
                SimilarityBookActivity.b2(SimilarityBookActivity.this, appBarLayout, i10);
            }
        });
    }
}
