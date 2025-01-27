package com.martian.mibook.mvvm.yuewen.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.appbar.AppBarLayout;
import com.gyf.immersionbar.d;
import com.kuaishou.weapon.p0.t;
import com.martian.libmars.common.ConfigSingleton;
import com.martian.libmars.utils.tablayout.CommonNavigator;
import com.martian.libmars.utils.tablayout.LinePagerIndicator;
import com.martian.libmars.utils.tablayout.ScaleTransitionPagerTitleView;
import com.martian.libmars.utils.tablayout.SimplePagerTitleView;
import com.martian.mibook.R;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.data.BookMallTab;
import com.martian.mibook.databinding.FragmentBookMallMainNewBinding;
import com.martian.mibook.databinding.LayoutReadingRecordBinding;
import com.martian.mibook.lib.model.data.MiReadingRecord;
import com.martian.mibook.lib.model.data.abs.Book;
import com.martian.mibook.mvvm.base.BaseMVVMFragment;
import com.martian.mibook.mvvm.extensions.ExtKt;
import com.martian.mibook.mvvm.ui.viewmodel.AppViewModel;
import com.martian.mibook.mvvm.yuewen.fragment.YWBookMallMainFragment;
import com.martian.mibook.mvvm.yuewen.viewmodel.BookMallViewModel;
import e9.c;
import h3.e;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import m9.b;
import m9.f;
import m9.g;
import xi.k;
import xi.l;
import ya.j2;

@Metadata(d1 = {"\u0000w\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\b\u0005*\u00016\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u00019B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000b\u0010\u0005J\u000f\u0010\f\u001a\u00020\nH\u0002¢\u0006\u0004\b\f\u0010\u0005J\u000f\u0010\r\u001a\u00020\nH\u0002¢\u0006\u0004\b\r\u0010\u0005J\u0019\u0010\u0010\u001a\u00020\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0017¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0012\u0010\u0005J\u000f\u0010\u0013\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0013\u0010\u0005J\u000f\u0010\u0014\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0014\u0010\u0005J)\u0010\u001a\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00152\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\nH\u0016¢\u0006\u0004\b\u001c\u0010\u0005J\u000f\u0010\u001d\u001a\u00020\nH\u0002¢\u0006\u0004\b\u001d\u0010\u0005J\u000f\u0010\u001e\u001a\u00020\nH\u0002¢\u0006\u0004\b\u001e\u0010\u0005J\u000f\u0010\u001f\u001a\u00020\nH\u0002¢\u0006\u0004\b\u001f\u0010\u0005R\u001c\u0010\"\u001a\b\u0018\u00010 R\u00020\u00008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010!R\u001e\u0010&\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010%R\u001c\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00070'8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010%R\u0018\u0010-\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010,R\u0018\u00101\u001a\u0004\u0018\u00010.8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u00100R\u0014\u00105\u001a\u0002028\u0002X\u0082D¢\u0006\u0006\n\u0004\b3\u00104R\u0014\u00108\u001a\u0002068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u00107¨\u0006:"}, d2 = {"Lcom/martian/mibook/mvvm/yuewen/fragment/YWBookMallMainFragment;", "Lcom/martian/mibook/mvvm/base/BaseMVVMFragment;", "Lcom/martian/mibook/databinding/FragmentBookMallMainNewBinding;", "Lcom/martian/mibook/mvvm/yuewen/viewmodel/BookMallViewModel;", "<init>", "()V", "", "Landroidx/fragment/app/Fragment;", "y0", "()Ljava/util/List;", "", "z0", "t0", "F0", "Landroid/os/Bundle;", "savedInstanceState", "q", "(Landroid/os/Bundle;)V", "onResume", "i0", "k", "", "requestCode", "resultCode", "Landroid/content/Intent;", e.f26408m, "onActivityResult", "(IILandroid/content/Intent;)V", "onDestroyView", "D0", "E0", "x0", "Lcom/martian/mibook/mvvm/yuewen/fragment/YWBookMallMainFragment$ViewPager2Adapter;", "Lcom/martian/mibook/mvvm/yuewen/fragment/YWBookMallMainFragment$ViewPager2Adapter;", "viewPagerAdapter", "Lcom/martian/mibook/data/BookMallTab;", t.f11204d, "Ljava/util/List;", "bookMallTabs", "", "m", "fragmentList", "Le9/c;", "n", "Le9/c;", "rxManager", "Lcom/martian/mibook/databinding/LayoutReadingRecordBinding;", "o", "Lcom/martian/mibook/databinding/LayoutReadingRecordBinding;", "readingRecordBinding", "", "p", "Z", "isHideTopSearch", "com/martian/mibook/mvvm/yuewen/fragment/YWBookMallMainFragment$onPageChangeCallback$1", "Lcom/martian/mibook/mvvm/yuewen/fragment/YWBookMallMainFragment$onPageChangeCallback$1;", "onPageChangeCallback", "ViewPager2Adapter", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nYWBookMallMainFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 YWBookMallMainFragment.kt\ncom/martian/mibook/mvvm/yuewen/fragment/YWBookMallMainFragment\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 ViewGroup.kt\nandroidx/core/view/ViewGroupKt\n*L\n1#1,314:1\n1864#2,3:315\n1864#2,3:318\n1864#2,3:325\n62#3,4:321\n*S KotlinDebug\n*F\n+ 1 YWBookMallMainFragment.kt\ncom/martian/mibook/mvvm/yuewen/fragment/YWBookMallMainFragment\n*L\n108#1:315,3\n196#1:318,3\n215#1:325,3\n210#1:321,4\n*E\n"})
/* loaded from: classes3.dex */
public final class YWBookMallMainFragment extends BaseMVVMFragment<FragmentBookMallMainNewBinding, BookMallViewModel> {

    /* renamed from: k, reason: from kotlin metadata */
    @l
    public ViewPager2Adapter viewPagerAdapter;

    /* renamed from: l */
    @l
    public List<? extends BookMallTab> bookMallTabs;

    /* renamed from: n, reason: from kotlin metadata */
    @l
    public c rxManager;

    /* renamed from: o, reason: from kotlin metadata */
    @l
    public LayoutReadingRecordBinding readingRecordBinding;

    /* renamed from: p, reason: from kotlin metadata */
    public final boolean isHideTopSearch;

    /* renamed from: m, reason: from kotlin metadata */
    @k
    public List<Fragment> fragmentList = new ArrayList();

    /* renamed from: q, reason: from kotlin metadata */
    @k
    public final YWBookMallMainFragment$onPageChangeCallback$1 onPageChangeCallback = new ViewPager2.OnPageChangeCallback() { // from class: com.martian.mibook.mvvm.yuewen.fragment.YWBookMallMainFragment$onPageChangeCallback$1
        public YWBookMallMainFragment$onPageChangeCallback$1() {
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrollStateChanged(int state) {
            super.onPageScrollStateChanged(state);
            YWBookMallMainFragment.q0(YWBookMallMainFragment.this).bookMallMagicIndicator.a(state);
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrolled(int r22, float positionOffset, int positionOffsetPixels) {
            super.onPageScrolled(r22, positionOffset, positionOffsetPixels);
            YWBookMallMainFragment.q0(YWBookMallMainFragment.this).bookMallMagicIndicator.b(r22, positionOffset, positionOffsetPixels);
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(int r22) {
            super.onPageSelected(r22);
            YWBookMallMainFragment.q0(YWBookMallMainFragment.this).bookMallMagicIndicator.c(r22);
        }
    };

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0004\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\bH\u0016¢\u0006\u0004\b\f\u0010\rR\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/martian/mibook/mvvm/yuewen/fragment/YWBookMallMainFragment$ViewPager2Adapter;", "Landroidx/viewpager2/adapter/FragmentStateAdapter;", "Landroidx/fragment/app/Fragment;", "fragment", "", "fragments", "<init>", "(Lcom/martian/mibook/mvvm/yuewen/fragment/YWBookMallMainFragment;Landroidx/fragment/app/Fragment;Ljava/util/List;)V", "", "getItemCount", "()I", id.c.f26972i, "createFragment", "(I)Landroidx/fragment/app/Fragment;", "c", "Ljava/util/List;", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
    public final class ViewPager2Adapter extends FragmentStateAdapter {

        /* renamed from: c, reason: from kotlin metadata */
        @k
        public final List<Fragment> fragments;

        /* renamed from: d */
        public final /* synthetic */ YWBookMallMainFragment f15686d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public ViewPager2Adapter(@k YWBookMallMainFragment yWBookMallMainFragment, @k Fragment fragment, List<? extends Fragment> fragments) {
            super(fragment);
            Intrinsics.checkNotNullParameter(fragment, "fragment");
            Intrinsics.checkNotNullParameter(fragments, "fragments");
            this.f15686d = yWBookMallMainFragment;
            this.fragments = fragments;
        }

        @Override // androidx.viewpager2.adapter.FragmentStateAdapter
        @k
        public Fragment createFragment(int r22) {
            return this.fragments.get(r22);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: getItemCount */
        public int getPageSize() {
            return this.fragments.size();
        }
    }

    public static final class a extends b {
        public a() {
        }

        public static final void j(YWBookMallMainFragment this$0, int i10, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            YWBookMallMainFragment.q0(this$0).viewpager2.setCurrentItem(i10);
        }

        @Override // m9.b
        public int a() {
            List list = YWBookMallMainFragment.this.bookMallTabs;
            if (list != null) {
                return list.size();
            }
            return 0;
        }

        @Override // m9.b
        @l
        public m9.e b(@k Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            LinePagerIndicator linePagerIndicator = new LinePagerIndicator(context);
            linePagerIndicator.i(2).l(ConfigSingleton.i(5.0f)).f(ConfigSingleton.i(2.0f)).g(ConfigSingleton.i(16.0f)).j(ConfigSingleton.i(2.0f)).k(new AccelerateInterpolator()).e(new DecelerateInterpolator(2.0f)).d(Integer.valueOf(ContextCompat.getColor(context, R.color.theme_default)));
            return linePagerIndicator;
        }

        @Override // m9.b
        @k
        public g c(@k Context context, int i10) {
            BookMallTab bookMallTab;
            String name;
            Intrinsics.checkNotNullParameter(context, "context");
            ScaleTransitionPagerTitleView scaleTransitionPagerTitleView = new ScaleTransitionPagerTitleView(context, false);
            List list = YWBookMallMainFragment.this.bookMallTabs;
            scaleTransitionPagerTitleView.setText((list == null || (bookMallTab = (BookMallTab) list.get(i10)) == null || (name = bookMallTab.getName()) == null) ? null : ExtKt.c(name));
            scaleTransitionPagerTitleView.setTextSize(16.0f);
            scaleTransitionPagerTitleView.setMaxScale(1.25f);
            scaleTransitionPagerTitleView.setNormalColor(ConfigSingleton.D().j0());
            scaleTransitionPagerTitleView.setSelectedColor(ContextCompat.getColor(context, R.color.theme_default));
            scaleTransitionPagerTitleView.setOnClickListener(new View.OnClickListener() { // from class: vd.f4

                /* renamed from: c */
                public final /* synthetic */ int f31341c;

                public /* synthetic */ f4(int i102) {
                    i10 = i102;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    YWBookMallMainFragment.a.j(YWBookMallMainFragment.this, i10, view);
                }
            });
            return scaleTransitionPagerTitleView;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void A0(YWBookMallMainFragment this$0, AppBarLayout appBarLayout, int i10) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ((FragmentBookMallMainNewBinding) this$0.n()).searchView.setAlpha(RangesKt.coerceIn(1 - (Math.abs(i10) / ((FragmentBookMallMainNewBinding) this$0.n()).rlSearch.getHeight()), 0.0f, 1.0f));
    }

    public static final void B0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void C0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void F0() {
        if (ConfigSingleton.D().A0()) {
            ((FragmentBookMallMainNewBinding) n()).ivBookMallTopBg.setAlpha(0.0f);
        } else {
            ((FragmentBookMallMainNewBinding) n()).ivBookMallTopBg.setAlpha(1.0f);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ FragmentBookMallMainNewBinding q0(YWBookMallMainFragment yWBookMallMainFragment) {
        return (FragmentBookMallMainNewBinding) yWBookMallMainFragment.n();
    }

    private final void t0() {
        c cVar = new c();
        this.rxManager = cVar;
        cVar.c(j2.f33269j, new wj.b() { // from class: vd.c4
            public /* synthetic */ c4() {
            }

            @Override // wj.b
            public final void call(Object obj) {
                YWBookMallMainFragment.v0(YWBookMallMainFragment.this, (Boolean) obj);
            }
        });
        c cVar2 = this.rxManager;
        if (cVar2 != null) {
            cVar2.c(j2.f33268i, new wj.b() { // from class: vd.d4
                public /* synthetic */ d4() {
                }

                @Override // wj.b
                public final void call(Object obj) {
                    YWBookMallMainFragment.w0(YWBookMallMainFragment.this, (Integer) obj);
                }
            });
        }
        c cVar3 = this.rxManager;
        if (cVar3 != null) {
            cVar3.c(j2.D, new wj.b() { // from class: vd.e4
                public /* synthetic */ e4() {
                }

                @Override // wj.b
                public final void call(Object obj) {
                    YWBookMallMainFragment.u0(YWBookMallMainFragment.this, (Integer) obj);
                }
            });
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void u0(YWBookMallMainFragment this$0, Integer num) {
        LinearLayout titleContainer;
        BookMallTab bookMallTab;
        String name;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (num == null) {
            return;
        }
        int intValue = num.intValue();
        if (intValue != j2.G) {
            if (intValue == j2.J) {
                ((FragmentBookMallMainNewBinding) this$0.n()).appbarLayout.setExpanded(true);
                return;
            }
            if (intValue == j2.K) {
                this$0.x0();
                return;
            }
            if (intValue == j2.L) {
                LayoutReadingRecordBinding layoutReadingRecordBinding = this$0.readingRecordBinding;
                RelativeLayout root = layoutReadingRecordBinding != null ? layoutReadingRecordBinding.getRoot() : null;
                if (root == null) {
                    return;
                }
                root.setVisibility(8);
                return;
            }
            return;
        }
        this$0.bookMallTabs = MiConfigSingleton.b2().f2().h();
        f navigator = ((FragmentBookMallMainNewBinding) this$0.n()).bookMallMagicIndicator.getNavigator();
        Intrinsics.checkNotNullExpressionValue(navigator, "getNavigator(...)");
        int i10 = 0;
        if ((navigator instanceof CommonNavigator) && (titleContainer = ((CommonNavigator) navigator).getTitleContainer()) != null) {
            int childCount = titleContainer.getChildCount();
            for (int i11 = 0; i11 < childCount; i11++) {
                View childAt = titleContainer.getChildAt(i11);
                Intrinsics.checkNotNullExpressionValue(childAt, "getChildAt(index)");
                Intrinsics.checkNotNull(childAt, "null cannot be cast to non-null type com.martian.libmars.utils.tablayout.SimplePagerTitleView");
                SimplePagerTitleView simplePagerTitleView = (SimplePagerTitleView) childAt;
                List<? extends BookMallTab> list = this$0.bookMallTabs;
                simplePagerTitleView.setText((list == null || (bookMallTab = list.get(i11)) == null || (name = bookMallTab.getName()) == null) ? null : ExtKt.c(name));
            }
        }
        List<? extends BookMallTab> list2 = this$0.bookMallTabs;
        if (list2 != null) {
            for (Object obj : list2) {
                int i12 = i10 + 1;
                if (i10 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                BookMallTab bookMallTab2 = (BookMallTab) obj;
                if (i10 < this$0.fragmentList.size() && i10 >= 0) {
                    Fragment fragment = this$0.fragmentList.get(i10);
                    YWBookMallFragment yWBookMallFragment = fragment instanceof YWBookMallFragment ? (YWBookMallFragment) fragment : null;
                    if (yWBookMallFragment != null) {
                        yWBookMallFragment.I().M(bookMallTab2.getTid());
                        if (yWBookMallFragment.I().getTid() == 1 || yWBookMallFragment.I().getTid() == 2) {
                            yWBookMallFragment.R0();
                        }
                    }
                }
                i10 = i12;
            }
        }
        AppViewModel G = this$0.G();
        if (G != null) {
            G.q0();
        }
        this$0.E0();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void v0(YWBookMallMainFragment this$0, Boolean bool) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ViewPager2 viewPager2 = ((FragmentBookMallMainNewBinding) this$0.n()).viewpager2;
        Intrinsics.checkNotNull(bool);
        viewPager2.requestDisallowInterceptTouchEvent(bool.booleanValue());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void w0(YWBookMallMainFragment this$0, Integer num) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (num != null) {
            if (this$0.viewPagerAdapter == null) {
                this$0.z0();
            }
            List<? extends BookMallTab> list = this$0.bookMallTabs;
            if (list != null) {
                int i10 = 0;
                for (Object obj : list) {
                    int i11 = i10 + 1;
                    if (i10 < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    if (num.intValue() == ((BookMallTab) obj).getTid()) {
                        ((FragmentBookMallMainNewBinding) this$0.n()).viewpager2.setCurrentItem(i10);
                    }
                    i10 = i11;
                }
            }
        }
    }

    private final List<Fragment> y0() {
        this.fragmentList.clear();
        List<? extends BookMallTab> list = this.bookMallTabs;
        if (list != null) {
            int i10 = 0;
            for (Object obj : list) {
                int i11 = i10 + 1;
                if (i10 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                this.fragmentList.add(YWBookMallFragment.INSTANCE.a(((BookMallTab) obj).getTid(), true));
                i10 = i11;
            }
        }
        return this.fragmentList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void z0() {
        this.bookMallTabs = MiConfigSingleton.b2().f2().h();
        this.viewPagerAdapter = new ViewPager2Adapter(this, this, y0());
        ((FragmentBookMallMainNewBinding) n()).viewpager2.setOffscreenPageLimit(this.fragmentList.size());
        ((FragmentBookMallMainNewBinding) n()).viewpager2.setAdapter(this.viewPagerAdapter);
        CommonNavigator commonNavigator = new CommonNavigator(getContext());
        commonNavigator.setLeftPadding(ConfigSingleton.i(4.0f));
        commonNavigator.setAdapter(new a());
        ((FragmentBookMallMainNewBinding) n()).bookMallMagicIndicator.setNavigator(commonNavigator);
        ((FragmentBookMallMainNewBinding) n()).viewpager2.registerOnPageChangeCallback(this.onPageChangeCallback);
        E0();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void D0() {
        String p02;
        AppViewModel G = G();
        String str = null;
        if (G != null && (p02 = AppViewModel.p0(G, false, 1, null)) != null) {
            str = ExtKt.c(p02);
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        ((FragmentBookMallMainNewBinding) n()).scEditText.setHint(str);
        ((FragmentBookMallMainNewBinding) n()).scEditText.setTag(str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void E0() {
        ((FragmentBookMallMainNewBinding) n()).viewpager2.setCurrentItem(MiConfigSingleton.b2().W2() ? 1 : 0);
    }

    @Override // com.martian.mibook.mvvm.base.BaseMVVMFragment
    public void i0() {
        F0();
    }

    @Override // com.martian.mibook.mvvm.base.LazyFragment
    public void k() {
        super.k();
        x0();
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, @l Intent r52) {
        int intValue;
        super.onActivityResult(requestCode, resultCode, r52);
        MiReadingRecord a22 = MiConfigSingleton.b2().a2();
        if (a22 != null) {
            MiReadingRecord J = MiConfigSingleton.b2().M1().J(a22.getSourceString());
            if (J != null) {
                Intrinsics.checkNotNull(J);
            } else {
                J = a22;
            }
            if (J.isAudiobook()) {
                Book H = MiConfigSingleton.b2().M1().H(a22.getSourceString());
                int chapterIndex = J.getChapterIndex();
                Integer contentPos = J.getContentPos();
                if (contentPos == null) {
                    intValue = 0;
                } else {
                    Intrinsics.checkNotNull(contentPos);
                    intValue = contentPos.intValue();
                }
                kc.b.e(H, chapterIndex, intValue, true, a22.getSourceString());
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        ((FragmentBookMallMainNewBinding) n()).viewpager2.unregisterOnPageChangeCallback(this.onPageChangeCallback);
        c cVar = this.rxManager;
        if (cVar != null) {
            cVar.b();
        }
        this.viewPagerAdapter = null;
    }

    @Override // com.martian.mibook.mvvm.base.LazyFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        D0();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.martian.mibook.mvvm.base.BaseFragment
    @SuppressLint({"ClickableViewAccessibility"})
    public void q(@l Bundle savedInstanceState) {
        MutableLiveData<List<String>> d02;
        MutableLiveData<Boolean> V;
        if (MiConfigSingleton.b2().c2().getEnableSearch()) {
            ((FragmentBookMallMainNewBinding) n()).rlSearch.setVisibility(this.isHideTopSearch ? 8 : 0);
            ((FragmentBookMallMainNewBinding) n()).bookMallMainSearchIcon.setVisibility(this.isHideTopSearch ? 0 : 8);
        } else {
            ((FragmentBookMallMainNewBinding) n()).bookMallMainSearchIcon.setVisibility(8);
            ((FragmentBookMallMainNewBinding) n()).rlSearch.setVisibility(8);
        }
        d.B2(this, ((FragmentBookMallMainNewBinding) n()).appbarLayout);
        ((FragmentBookMallMainNewBinding) n()).viewpager2.setPadding(0, 0, 0, d.K0(this));
        ((FragmentBookMallMainNewBinding) n()).appbarLayout.addOnOffsetChangedListener((AppBarLayout.OnOffsetChangedListener) new AppBarLayout.OnOffsetChangedListener() { // from class: vd.z3
            public /* synthetic */ z3() {
            }

            @Override // com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
            public final void onOffsetChanged(AppBarLayout appBarLayout, int i10) {
                YWBookMallMainFragment.A0(YWBookMallMainFragment.this, appBarLayout, i10);
            }
        });
        z0();
        t0();
        AppViewModel G = G();
        if (G != null) {
            G.t0(getActivity());
        }
        AppViewModel G2 = G();
        if (G2 != null && (V = G2.V()) != null) {
            V.observe(this, new Observer() { // from class: vd.a4
                public /* synthetic */ a4() {
                }

                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    YWBookMallMainFragment.B0(Function1.this, obj);
                }
            });
        }
        AppViewModel G3 = G();
        if (G3 != null) {
            G3.q0();
        }
        AppViewModel G4 = G();
        if (G4 == null || (d02 = G4.d0()) == null) {
            return;
        }
        d02.observe(this, new Observer() { // from class: vd.b4
            public /* synthetic */ b4() {
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                YWBookMallMainFragment.C0(Function1.this, obj);
            }
        });
    }

    public final void x0() {
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new YWBookMallMainFragment$checkLastReadingRecordBookUpdate$1(this, null), 3, null);
    }
}
