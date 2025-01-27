package com.martian.mibook.mvvm.yuewen.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.PopupWindow;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import androidx.viewpager.widget.ViewPager;
import com.gyf.immersionbar.d;
import com.kuaishou.weapon.p0.t;
import com.martian.libmars.common.ConfigSingleton;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.libmars.utils.tablayout.CommonNavigator;
import com.martian.libmars.utils.tablayout.LinePagerIndicator;
import com.martian.libmars.utils.tablayout.ScaleTransitionPagerTitleView;
import com.martian.mibook.R;
import com.martian.mibook.activity.book.ArchiveListActivity;
import com.martian.mibook.activity.book.txt.BookScanActivity;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.databinding.BookrackMenuBinding;
import com.martian.mibook.databinding.FragmentBookShelfMainBinding;
import com.martian.mibook.lib.account.response.IntervalBonus;
import com.martian.mibook.lib.model.data.BookWrapper;
import com.martian.mibook.mvvm.base.BaseMVVMFragment;
import com.martian.mibook.mvvm.extensions.ExtKt;
import com.martian.mibook.mvvm.net.ErrorResult;
import com.martian.mibook.mvvm.tts.NonStickyLiveData;
import com.martian.mibook.mvvm.ui.viewmodel.AppViewModel;
import com.martian.mibook.mvvm.widget.ScreenSlidePagerAdapter;
import com.martian.mibook.mvvm.yuewen.fragment.BookShelfMainFragment;
import com.martian.mibook.mvvm.yuewen.viewmodel.BookShelfViewModel;
import com.martian.rpauth.MartianRPUserManager;
import e9.c;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import l9.i0;
import l9.t0;
import m9.b;
import m9.e;
import m9.g;
import xi.k;
import xi.l;
import ya.j2;

@Metadata(d1 = {"\u0000]\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0005*\u0001(\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\u0005J\u000f\u0010\b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\b\u0010\u0005J\u000f\u0010\t\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\u0005J\u0015\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0006H\u0003¢\u0006\u0004\b\u0013\u0010\u0005J\u000f\u0010\u0014\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0014\u0010\u0005J\u000f\u0010\u0015\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0015\u0010\u0005J\u0019\u0010\u0018\u001a\u00020\u00062\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001a\u0010\u0005J\u000f\u0010\u001b\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001b\u0010\u0005J\u000f\u0010\u001c\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001c\u0010\u0005R\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001eR\u001c\u0010#\u001a\b\u0012\u0004\u0012\u00020\u000b0 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R\u0018\u0010'\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010&R\u0014\u0010+\u001a\u00020(8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010*¨\u0006,"}, d2 = {"Lcom/martian/mibook/mvvm/yuewen/fragment/BookShelfMainFragment;", "Lcom/martian/mibook/mvvm/base/BaseMVVMFragment;", "Lcom/martian/mibook/databinding/FragmentBookShelfMainBinding;", "Lcom/martian/mibook/mvvm/yuewen/viewmodel/BookShelfViewModel;", "<init>", "()V", "", "I0", "F0", "O0", "", "Landroidx/fragment/app/Fragment;", "D0", "()Ljava/util/List;", "", "index", "", "E0", "(I)Ljava/lang/String;", "P0", "Y0", "B0", "Landroid/os/Bundle;", "savedInstanceState", "q", "(Landroid/os/Bundle;)V", "i0", "k", "onDestroyView", "Lcom/martian/mibook/mvvm/widget/ScreenSlidePagerAdapter;", "Lcom/martian/mibook/mvvm/widget/ScreenSlidePagerAdapter;", "viewPagerAdapter", "", t.f11204d, "Ljava/util/List;", "fragmentList", "Le9/c;", "m", "Le9/c;", "rxManager", "com/martian/mibook/mvvm/yuewen/fragment/BookShelfMainFragment$onPageChangeCallback$1", "n", "Lcom/martian/mibook/mvvm/yuewen/fragment/BookShelfMainFragment$onPageChangeCallback$1;", "onPageChangeCallback", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes3.dex */
public final class BookShelfMainFragment extends BaseMVVMFragment<FragmentBookShelfMainBinding, BookShelfViewModel> {

    /* renamed from: k, reason: from kotlin metadata */
    @l
    public ScreenSlidePagerAdapter viewPagerAdapter;

    /* renamed from: m, reason: from kotlin metadata */
    @l
    public c rxManager;

    /* renamed from: l */
    @k
    public List<Fragment> fragmentList = new ArrayList();

    /* renamed from: n, reason: from kotlin metadata */
    @k
    public final BookShelfMainFragment$onPageChangeCallback$1 onPageChangeCallback = new ViewPager.OnPageChangeListener() { // from class: com.martian.mibook.mvvm.yuewen.fragment.BookShelfMainFragment$onPageChangeCallback$1
        public BookShelfMainFragment$onPageChangeCallback$1() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int state) {
            BookShelfMainFragment.x0(BookShelfMainFragment.this).bookrackMagicIndicator.a(state);
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int r22, float positionOffset, int positionOffsetPixels) {
            BookShelfMainFragment.x0(BookShelfMainFragment.this).bookrackMagicIndicator.b(r22, positionOffset, positionOffsetPixels);
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int r22) {
            BookShelfMainFragment.x0(BookShelfMainFragment.this).bookrackMagicIndicator.c(r22);
        }
    };

    public static final class a extends b {
        public a() {
        }

        public static final void j(BookShelfMainFragment this$0, int i10, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            BookShelfMainFragment.x0(this$0).viewpager.setCurrentItem(i10);
        }

        @Override // m9.b
        public int a() {
            return BookShelfMainFragment.this.fragmentList.size();
        }

        @Override // m9.b
        @k
        public e b(@k Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            LinePagerIndicator linePagerIndicator = new LinePagerIndicator(context);
            linePagerIndicator.i(2).l(ConfigSingleton.i(5.0f)).f(ConfigSingleton.i(2.0f)).g(ConfigSingleton.i(16.0f)).j(ConfigSingleton.i(2.0f)).k(new AccelerateInterpolator()).e(new DecelerateInterpolator(2.0f)).d(Integer.valueOf(ContextCompat.getColor(context, R.color.theme_default)));
            return linePagerIndicator;
        }

        @Override // m9.b
        @k
        public g c(@k Context context, int i10) {
            Intrinsics.checkNotNullParameter(context, "context");
            ScaleTransitionPagerTitleView scaleTransitionPagerTitleView = new ScaleTransitionPagerTitleView(context, false);
            scaleTransitionPagerTitleView.setText(ExtKt.c(BookShelfMainFragment.this.E0(i10)));
            scaleTransitionPagerTitleView.setTextSize(16.0f);
            scaleTransitionPagerTitleView.setMaxScale(1.25f);
            scaleTransitionPagerTitleView.setNormalColor(ConfigSingleton.D().j0());
            scaleTransitionPagerTitleView.setSelectedColor(ContextCompat.getColor(context, R.color.theme_default));
            scaleTransitionPagerTitleView.setOnClickListener(new View.OnClickListener() { // from class: vd.u1

                /* renamed from: c */
                public final /* synthetic */ int f31435c;

                public /* synthetic */ u1(int i102) {
                    i10 = i102;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    BookShelfMainFragment.a.j(BookShelfMainFragment.this, i10, view);
                }
            });
            return scaleTransitionPagerTitleView;
        }
    }

    private final void B0() {
        if (this.rxManager == null) {
            this.rxManager = new c();
        }
        c cVar = this.rxManager;
        if (cVar != null) {
            cVar.c(j2.f33266g, new wj.b() { // from class: vd.t1
                public /* synthetic */ t1() {
                }

                @Override // wj.b
                public final void call(Object obj) {
                    BookShelfMainFragment.C0(BookShelfMainFragment.this, (Integer) obj);
                }
            });
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x001d, code lost:
    
        if (r3.intValue() != ya.j2.B) goto L23;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void C0(com.martian.mibook.mvvm.yuewen.fragment.BookShelfMainFragment r2, java.lang.Integer r3) {
        /*
            java.lang.String r0 = "this$0"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            androidx.viewbinding.ViewBinding r2 = r2.n()
            com.martian.mibook.databinding.FragmentBookShelfMainBinding r2 = (com.martian.mibook.databinding.FragmentBookShelfMainBinding) r2
            com.martian.mibook.ui.LockableViewPager r2 = r2.viewpager
            if (r3 == 0) goto L22
            int r0 = ya.j2.f33282w
            int r1 = r3.intValue()
            if (r1 == r0) goto L20
            int r0 = ya.j2.B
            int r3 = r3.intValue()
            if (r3 == r0) goto L20
            goto L22
        L20:
            r3 = 0
            goto L23
        L22:
            r3 = 1
        L23:
            r2.setScrollable(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.martian.mibook.mvvm.yuewen.fragment.BookShelfMainFragment.C0(com.martian.mibook.mvvm.yuewen.fragment.BookShelfMainFragment, java.lang.Integer):void");
    }

    private final List<Fragment> D0() {
        this.fragmentList.clear();
        this.fragmentList.add(BookShelfFragment.INSTANCE.a());
        this.fragmentList.add(ReadingRecordFragment.INSTANCE.a(false));
        return this.fragmentList;
    }

    public static final void G0(BookShelfMainFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.P0();
    }

    public static final void H0(BookShelfMainFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (MiConfigSingleton.b2().G1().g(this$0.getActivity(), 1003)) {
            if (MiConfigSingleton.b2().p2() == null) {
                t0.b(this$0.getContext(), this$0.getString(R.string.account_not_generated_retry));
                return;
            }
            if (MiConfigSingleton.b2().e2().C() > MartianRPUserManager.a()) {
                ac.a.x(this$0.getContext(), "时段奖励-倒计时-点击");
                i0.F0(this$0.getActivity(), this$0.getString(R.string.tips), this$0.getString(R.string.countdown_ends_to_claim_rewards), this$0.getString(R.string.i_know), null, null);
                return;
            }
            ac.a.x(this$0.getContext(), "时段奖励-红包-点击");
            AppViewModel G = this$0.G();
            if (G != null) {
                G.I();
            }
        }
    }

    private final void I0() {
        NonStickyLiveData<IntervalBonus> W;
        NonStickyLiveData<ErrorResult> N;
        NonStickyLiveData<IntervalBonus> O;
        AppViewModel G = G();
        if (G != null && (O = G.O()) != null) {
            O.observe(this, new Observer() { // from class: vd.i1
                public /* synthetic */ i1() {
                }

                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    BookShelfMainFragment.J0(Function1.this, obj);
                }
            });
        }
        AppViewModel G2 = G();
        if (G2 != null && (N = G2.N()) != null) {
            N.observe(this, new Observer() { // from class: vd.j1
                public /* synthetic */ j1() {
                }

                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    BookShelfMainFragment.L0(Function1.this, obj);
                }
            });
        }
        AppViewModel G3 = G();
        if (G3 == null || (W = G3.W()) == null) {
            return;
        }
        W.observe(this, new Observer() { // from class: vd.k1
            public /* synthetic */ k1() {
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                BookShelfMainFragment.M0(Function1.this, obj);
            }
        });
    }

    public static final void J0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void L0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void M0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void O0() {
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
        this.viewPagerAdapter = new ScreenSlidePagerAdapter(childFragmentManager, D0(), null, 4, null);
        ((FragmentBookShelfMainBinding) n()).viewpager.setOffscreenPageLimit(this.fragmentList.size());
        ((FragmentBookShelfMainBinding) n()).viewpager.setAdapter(this.viewPagerAdapter);
        CommonNavigator commonNavigator = new CommonNavigator(getContext());
        commonNavigator.setLeftPadding(ConfigSingleton.i(4.0f));
        commonNavigator.setAdapter(new a());
        ((FragmentBookShelfMainBinding) n()).bookrackMagicIndicator.setNavigator(commonNavigator);
        ((FragmentBookShelfMainBinding) n()).viewpager.addOnPageChangeListener(this.onPageChangeCallback);
        ((FragmentBookShelfMainBinding) n()).viewpager.setCurrentItem(0);
    }

    public static final void Q0(BookShelfMainFragment this$0, boolean z10, PopupWindow menuPopupWindow, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(menuPopupWindow, "$menuPopupWindow");
        ac.a.x(this$0.getContext(), "批量管理");
        c cVar = this$0.rxManager;
        if (cVar != null) {
            cVar.d(z10 ? j2.f33277r : j2.A, Integer.valueOf(z10 ? j2.f33282w : j2.B));
        }
        menuPopupWindow.dismiss();
    }

    public static final void R0(BookShelfMainFragment this$0, PopupWindow menuPopupWindow, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(menuPopupWindow, "$menuPopupWindow");
        List<BookWrapper> C = MiConfigSingleton.b2().M1().C(false);
        if (C == null || C.size() <= 0) {
            t0.b(this$0.getContext(), this$0.getString(R.string.none_book));
        } else {
            ac.a.x(this$0.getContext(), "智能找书");
            kc.b.y();
        }
        menuPopupWindow.dismiss();
    }

    public static final void T0(BookShelfMainFragment this$0, PopupWindow menuPopupWindow, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(menuPopupWindow, "$menuPopupWindow");
        ac.a.x(this$0.getContext(), "导入图书");
        this$0.startActivity(new Intent(this$0.getContext(), (Class<?>) BookScanActivity.class));
        menuPopupWindow.dismiss();
    }

    public static final void U0(BookShelfMainFragment this$0, PopupWindow menuPopupWindow, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(menuPopupWindow, "$menuPopupWindow");
        if (MiConfigSingleton.b2().O1() == 1) {
            MiConfigSingleton.b2().X2(0);
            ac.a.x(this$0.getContext(), "列表视图");
        } else {
            MiConfigSingleton.b2().X2(1);
            ac.a.x(this$0.getContext(), "封面视图");
        }
        c cVar = this$0.rxManager;
        if (cVar != null) {
            cVar.d(j2.f33277r, Integer.valueOf(j2.f33279t));
        }
        menuPopupWindow.dismiss();
    }

    public static final void V0(BookShelfMainFragment this$0, PopupWindow menuPopupWindow, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(menuPopupWindow, "$menuPopupWindow");
        ac.a.x(this$0.getContext(), "搜索书架");
        c cVar = this$0.rxManager;
        if (cVar != null) {
            cVar.d(j2.f33277r, Integer.valueOf(j2.f33280u));
        }
        menuPopupWindow.dismiss();
    }

    public static final void W0(BookShelfMainFragment this$0, PopupWindow menuPopupWindow, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(menuPopupWindow, "$menuPopupWindow");
        ac.a.x(this$0.getContext(), "云同步");
        c cVar = this$0.rxManager;
        if (cVar != null) {
            cVar.d(j2.f33277r, Integer.valueOf(j2.f33281v));
        }
        menuPopupWindow.dismiss();
    }

    public static final void X0(BookShelfMainFragment this$0, PopupWindow menuPopupWindow, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(menuPopupWindow, "$menuPopupWindow");
        ac.a.x(this$0.getContext(), "归档图书");
        this$0.startActivity(new Intent(this$0.getContext(), (Class<?>) ArchiveListActivity.class));
        menuPopupWindow.dismiss();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ FragmentBookShelfMainBinding x0(BookShelfMainFragment bookShelfMainFragment) {
        return (FragmentBookShelfMainBinding) bookShelfMainFragment.n();
    }

    public final String E0(int index) {
        String string = getString(index == 0 ? R.string.book_store : R.string.novel_history);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return string;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void F0() {
        d.B2(this, ((FragmentBookShelfMainBinding) n()).bookrackHeaderView);
        ((FragmentBookShelfMainBinding) n()).bookrackSearch.setVisibility(MiConfigSingleton.b2().c2().getEnableSearch() ? 0 : 8);
        ((FragmentBookShelfMainBinding) n()).bookrackMoreOptions.setOnClickListener(new View.OnClickListener() { // from class: vd.h1
            public /* synthetic */ h1() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BookShelfMainFragment.G0(BookShelfMainFragment.this, view);
            }
        });
        ((FragmentBookShelfMainBinding) n()).bookrackIntervalView.setVisibility(MiConfigSingleton.b2().C2() ? 8 : 0);
        ((FragmentBookShelfMainBinding) n()).bookrackIntervalView.setOnClickListener(new View.OnClickListener() { // from class: vd.l1
            public /* synthetic */ l1() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BookShelfMainFragment.H0(BookShelfMainFragment.this, view);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SuppressLint({"InflateParams"})
    public final void P0() {
        c cVar;
        boolean z10 = ((FragmentBookShelfMainBinding) n()).viewpager.getCurrentItem() == 0;
        if (z10 && (cVar = this.rxManager) != null) {
            cVar.d(j2.f33277r, Integer.valueOf(j2.f33278s));
        }
        View inflate = getLayoutInflater().inflate(R.layout.bookrack_menu, (ViewGroup) null);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        BookrackMenuBinding bind = BookrackMenuBinding.bind(inflate);
        Intrinsics.checkNotNullExpressionValue(bind, "bind(...)");
        PopupWindow popupWindow = new PopupWindow(inflate, -2, -2);
        popupWindow.setBackgroundDrawable(new BitmapDrawable(getResources(), (Bitmap) null));
        popupWindow.setOutsideTouchable(true);
        popupWindow.setFocusable(true);
        popupWindow.showAsDropDown(((FragmentBookShelfMainBinding) n()).bookrackMoreOptions, 0, 0);
        ac.a.x(getContext(), z10 ? "书架-更多" : "阅读记录-更多");
        bind.brMenuBookImport.setVisibility(z10 ? 0 : 8);
        bind.brMenuBookImportLine.setVisibility(z10 ? 0 : 8);
        bind.brMenuCoverMode.setVisibility(z10 ? 0 : 8);
        bind.brMenuCoverModeLine.setVisibility(z10 ? 0 : 8);
        bind.brMenuSearch.setVisibility(z10 ? 0 : 8);
        bind.brMenuSearchLine.setVisibility(z10 ? 0 : 8);
        bind.brMenuBookSync.setVisibility(z10 ? 0 : 8);
        boolean z11 = z10 && MiConfigSingleton.b2().M1().H0();
        bind.brMenuArchive.setVisibility(z11 ? 0 : 8);
        bind.brMenuBookSyncLine.setVisibility(z11 ? 0 : 8);
        if (z10) {
            bind.brMenuBookImport.setOnClickListener(new View.OnClickListener() { // from class: vd.m1

                /* renamed from: c */
                public final /* synthetic */ PopupWindow f31383c;

                public /* synthetic */ m1(PopupWindow popupWindow2) {
                    popupWindow = popupWindow2;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    BookShelfMainFragment.T0(BookShelfMainFragment.this, popupWindow, view);
                }
            });
            if (MiConfigSingleton.b2().O1() == 1) {
                bind.menuCoverMode.setImageResource(R.drawable.menu_icon_list_cover);
                ThemeTextView themeTextView = bind.menuCoverModeTitle;
                Context context = getContext();
                themeTextView.setText(context != null ? context.getString(R.string.listview) : null);
            } else {
                bind.menuCoverMode.setImageResource(R.drawable.menu_icon_grid_cover);
                ThemeTextView themeTextView2 = bind.menuCoverModeTitle;
                Context context2 = getContext();
                themeTextView2.setText(context2 != null ? context2.getString(R.string.cover_view) : null);
            }
            bind.brMenuCoverMode.setOnClickListener(new View.OnClickListener() { // from class: vd.n1

                /* renamed from: c */
                public final /* synthetic */ PopupWindow f31390c;

                public /* synthetic */ n1(PopupWindow popupWindow2) {
                    popupWindow = popupWindow2;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    BookShelfMainFragment.U0(BookShelfMainFragment.this, popupWindow, view);
                }
            });
            bind.brMenuSearch.setOnClickListener(new View.OnClickListener() { // from class: vd.o1

                /* renamed from: c */
                public final /* synthetic */ PopupWindow f31398c;

                public /* synthetic */ o1(PopupWindow popupWindow2) {
                    popupWindow = popupWindow2;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    BookShelfMainFragment.V0(BookShelfMainFragment.this, popupWindow, view);
                }
            });
            bind.brMenuBookSync.setOnClickListener(new View.OnClickListener() { // from class: vd.p1

                /* renamed from: c */
                public final /* synthetic */ PopupWindow f31405c;

                public /* synthetic */ p1(PopupWindow popupWindow2) {
                    popupWindow = popupWindow2;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    BookShelfMainFragment.W0(BookShelfMainFragment.this, popupWindow, view);
                }
            });
            bind.brMenuArchive.setOnClickListener(new View.OnClickListener() { // from class: vd.q1

                /* renamed from: c */
                public final /* synthetic */ PopupWindow f31411c;

                public /* synthetic */ q1(PopupWindow popupWindow2) {
                    popupWindow = popupWindow2;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    BookShelfMainFragment.X0(BookShelfMainFragment.this, popupWindow, view);
                }
            });
        }
        bind.brMenuBatchProcess.setOnClickListener(new View.OnClickListener() { // from class: vd.r1

            /* renamed from: c */
            public final /* synthetic */ boolean f31417c;

            /* renamed from: d */
            public final /* synthetic */ PopupWindow f31418d;

            public /* synthetic */ r1(boolean z102, PopupWindow popupWindow2) {
                z10 = z102;
                popupWindow = popupWindow2;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BookShelfMainFragment.Q0(BookShelfMainFragment.this, z10, popupWindow, view);
            }
        });
        bind.findSimilarBookCover.setOnClickListener(new View.OnClickListener() { // from class: vd.s1

            /* renamed from: c */
            public final /* synthetic */ PopupWindow f31424c;

            public /* synthetic */ s1(PopupWindow popupWindow2) {
                popupWindow = popupWindow2;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BookShelfMainFragment.R0(BookShelfMainFragment.this, popupWindow, view);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void Y0() {
        long C = MiConfigSingleton.b2().e2().C();
        boolean z10 = C > MartianRPUserManager.a();
        ((FragmentBookShelfMainBinding) n()).bookrackIntervalCountdown.setVisibility(z10 ? 0 : 8);
        ((FragmentBookShelfMainBinding) n()).bookrackIntervalGrab.setVisibility(z10 ? 8 : 0);
        if (z10) {
            ((FragmentBookShelfMainBinding) n()).bookrackIntervalCountdown.n(C, getString(R.string.grab_bonus_imm));
        }
    }

    @Override // com.martian.mibook.mvvm.base.BaseMVVMFragment
    public void i0() {
    }

    @Override // com.martian.mibook.mvvm.base.LazyFragment
    public void k() {
        super.k();
        B0();
        O0();
        AppViewModel G = G();
        if (G != null) {
            G.J0();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        c cVar = this.rxManager;
        if (cVar != null) {
            cVar.b();
        }
    }

    @Override // com.martian.mibook.mvvm.base.BaseFragment
    public void q(@l Bundle savedInstanceState) {
        F0();
        I0();
    }
}
