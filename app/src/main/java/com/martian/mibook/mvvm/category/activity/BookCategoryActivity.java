package com.martian.mibook.mvvm.category.activity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.martian.libmars.common.ConfigSingleton;
import com.martian.libmars.databinding.LayoutToolbarBinding;
import com.martian.libmars.ui.theme.ThemeLinearLayout;
import com.martian.libmars.utils.tablayout.CommonNavigator;
import com.martian.libmars.utils.tablayout.MagicIndicator;
import com.martian.libmars.utils.tablayout.ScaleTransitionPagerTitleView;
import com.martian.mibook.R;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.databinding.ActivityBookCategoryBinding;
import com.martian.mibook.mvvm.base.BaseMVVMActivity;
import com.martian.mibook.mvvm.base.DefaultViewModel;
import com.martian.mibook.mvvm.category.activity.BookCategoryActivity;
import com.martian.mibook.mvvm.category.fragment.BDCategoryFragment;
import com.martian.mibook.mvvm.extensions.ExtKt;
import com.martian.mibook.mvvm.widget.ScreenSlidePagerAdapter;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import m9.b;
import m9.e;
import m9.g;
import xi.k;
import xi.l;

@Route(path = kc.a.f27748d)
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0004\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0019\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\r\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000f\u0010\u0005J\u000f\u0010\u0010\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0010\u0010\u0005J\u0015\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u0011H\u0002¢\u0006\u0004\b\u0016\u0010\u0014R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u001c\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00120\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010!¨\u0006#"}, d2 = {"Lcom/martian/mibook/mvvm/category/activity/BookCategoryActivity;", "Lcom/martian/mibook/mvvm/base/BaseMVVMActivity;", "Lcom/martian/mibook/databinding/ActivityBookCategoryBinding;", "Lcom/martian/mibook/mvvm/base/DefaultViewModel;", "<init>", "()V", "Lcom/martian/libmars/databinding/LayoutToolbarBinding;", "toolbarBinding", "", "s1", "(Lcom/martian/libmars/databinding/LayoutToolbarBinding;)V", "Landroid/os/Bundle;", "savedInstanceState", "c1", "(Landroid/os/Bundle;)V", "k1", "J1", "", "Landroidx/fragment/app/Fragment;", "H1", "()Ljava/util/List;", "", "I1", "Lcom/martian/libmars/ui/theme/ThemeLinearLayout;", "h", "Lcom/martian/libmars/ui/theme/ThemeLinearLayout;", "llTab", "Lcom/martian/libmars/utils/tablayout/MagicIndicator;", "i", "Lcom/martian/libmars/utils/tablayout/MagicIndicator;", "magicIndicator", "", "j", "Ljava/util/List;", "fragmentList", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes3.dex */
public final class BookCategoryActivity extends BaseMVVMActivity<ActivityBookCategoryBinding, DefaultViewModel> {

    /* renamed from: h, reason: from kotlin metadata */
    @l
    public ThemeLinearLayout llTab;

    /* renamed from: i, reason: from kotlin metadata */
    @l
    public MagicIndicator magicIndicator;

    /* renamed from: j, reason: from kotlin metadata */
    @k
    public List<Fragment> fragmentList = new ArrayList();

    public static final class a extends b {

        /* renamed from: b */
        public final /* synthetic */ ScreenSlidePagerAdapter f14185b;

        /* renamed from: c */
        public final /* synthetic */ BookCategoryActivity f14186c;

        public a(ScreenSlidePagerAdapter screenSlidePagerAdapter, BookCategoryActivity bookCategoryActivity) {
            this.f14185b = screenSlidePagerAdapter;
            this.f14186c = bookCategoryActivity;
        }

        public static final void j(BookCategoryActivity this$0, int i10, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            BookCategoryActivity.F1(this$0).viewpager.setCurrentItem(i10);
        }

        @Override // m9.b
        public int a() {
            return this.f14185b.a().size();
        }

        @Override // m9.b
        @l
        public e b(@k Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return null;
        }

        @Override // m9.b
        @k
        public g c(@k Context context, int i10) {
            Intrinsics.checkNotNullParameter(context, "context");
            ScaleTransitionPagerTitleView scaleTransitionPagerTitleView = new ScaleTransitionPagerTitleView(context, false);
            List<String> b10 = this.f14185b.b();
            scaleTransitionPagerTitleView.setText(ExtKt.c(b10 != null ? b10.get(i10) : null));
            scaleTransitionPagerTitleView.setTextSize(16.0f);
            scaleTransitionPagerTitleView.setMaxScale(1.375f);
            scaleTransitionPagerTitleView.setNormalColor(ConfigSingleton.D().j0());
            scaleTransitionPagerTitleView.setSelectedColor(ConfigSingleton.D().h0());
            scaleTransitionPagerTitleView.setOnClickListener(new View.OnClickListener() { // from class: qc.a

                /* renamed from: c */
                public final /* synthetic */ int f29999c;

                public /* synthetic */ a(int i102) {
                    i10 = i102;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    BookCategoryActivity.a.j(BookCategoryActivity.this, i10, view);
                }
            });
            return scaleTransitionPagerTitleView;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ ActivityBookCategoryBinding F1(BookCategoryActivity bookCategoryActivity) {
        return (ActivityBookCategoryBinding) bookCategoryActivity.a1();
    }

    public final List<Fragment> H1() {
        this.fragmentList.clear();
        List<Fragment> list = this.fragmentList;
        BDCategoryFragment.Companion companion = BDCategoryFragment.INSTANCE;
        list.add(companion.a(MiConfigSingleton.b2().p(), false));
        this.fragmentList.add(companion.a(MiConfigSingleton.b2().k2(), false));
        return this.fragmentList;
    }

    public final List<String> I1() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(MiConfigSingleton.b2().p() == 2 ? getString(R.string.female) : getString(R.string.male));
        arrayList.add(MiConfigSingleton.b2().p() == 2 ? getString(R.string.male) : getString(R.string.female));
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void J1() {
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
        ScreenSlidePagerAdapter screenSlidePagerAdapter = new ScreenSlidePagerAdapter(supportFragmentManager, H1(), I1());
        ((ActivityBookCategoryBinding) a1()).viewpager.setOffscreenPageLimit(this.fragmentList.size());
        ((ActivityBookCategoryBinding) a1()).viewpager.setAdapter(screenSlidePagerAdapter);
        CommonNavigator commonNavigator = new CommonNavigator(this);
        commonNavigator.setLeftPadding(ConfigSingleton.i(4.0f));
        commonNavigator.setAdapter(new a(screenSlidePagerAdapter, this));
        MagicIndicator magicIndicator = this.magicIndicator;
        if (magicIndicator != null) {
            magicIndicator.setTextColorType(-1);
        }
        MagicIndicator magicIndicator2 = this.magicIndicator;
        if (magicIndicator2 != null) {
            magicIndicator2.setNavigator(commonNavigator);
        }
        int i10 = MiConfigSingleton.b2().p() == m1().getArg1() ? 0 : 1;
        ((ActivityBookCategoryBinding) a1()).viewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.martian.mibook.mvvm.category.activity.BookCategoryActivity$initViewPager$2
            public BookCategoryActivity$initViewPager$2() {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int state) {
                MagicIndicator magicIndicator3;
                magicIndicator3 = BookCategoryActivity.this.magicIndicator;
                if (magicIndicator3 != null) {
                    magicIndicator3.a(state);
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int r22, float positionOffset, int positionOffsetPixels) {
                MagicIndicator magicIndicator3;
                magicIndicator3 = BookCategoryActivity.this.magicIndicator;
                if (magicIndicator3 != null) {
                    magicIndicator3.b(r22, positionOffset, positionOffsetPixels);
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int r22) {
                MagicIndicator magicIndicator3;
                magicIndicator3 = BookCategoryActivity.this.magicIndicator;
                if (magicIndicator3 != null) {
                    magicIndicator3.c(r22);
                }
            }
        });
        ((ActivityBookCategoryBinding) a1()).viewpager.setCurrentItem(i10);
    }

    @Override // com.martian.mibook.mvvm.base.BaseActivity
    public void c1(@l Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            m1().q(savedInstanceState.getInt("intent_ctype", 1));
        } else {
            m1().q(getIntent().getIntExtra("intent_ctype", 1));
        }
        J1();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.martian.mibook.mvvm.base.BaseMVVMActivity
    public void k1() {
        super.k1();
        ((ActivityBookCategoryBinding) a1()).viewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.martian.mibook.mvvm.category.activity.BookCategoryActivity$addObserver$1
            public BookCategoryActivity$addObserver$1() {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int state) {
                MagicIndicator magicIndicator;
                magicIndicator = BookCategoryActivity.this.magicIndicator;
                if (magicIndicator != null) {
                    magicIndicator.a(state);
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int r22, float positionOffset, int positionOffsetPixels) {
                MagicIndicator magicIndicator;
                magicIndicator = BookCategoryActivity.this.magicIndicator;
                if (magicIndicator != null) {
                    magicIndicator.b(r22, positionOffset, positionOffsetPixels);
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int r22) {
                MagicIndicator magicIndicator;
                magicIndicator = BookCategoryActivity.this.magicIndicator;
                if (magicIndicator != null) {
                    magicIndicator.c(r22);
                }
            }
        });
    }

    @Override // com.martian.mibook.mvvm.base.BaseMVVMActivity
    public void s1(@l LayoutToolbarBinding toolbarBinding) {
        super.s1(toolbarBinding);
        if (toolbarBinding != null) {
            toolbarBinding.f12249i.setVisibility(8);
            toolbarBinding.f12246f.setLayoutResource(com.martian.libmars.R.layout.layout_xttab);
            toolbarBinding.f12246f.setVisibility(0);
            View findViewById = findViewById(com.martian.libmars.R.id.ll_tab);
            this.llTab = findViewById instanceof ThemeLinearLayout ? (ThemeLinearLayout) findViewById : null;
            View findViewById2 = findViewById(com.martian.libmars.R.id.magic_indicator);
            this.magicIndicator = findViewById2 instanceof MagicIndicator ? (MagicIndicator) findViewById2 : null;
            ThemeLinearLayout themeLinearLayout = this.llTab;
            if (themeLinearLayout != null) {
                themeLinearLayout.setBackgroundType(14);
            }
            toolbarBinding.f12248h.setBackgroundType(14);
            toolbarBinding.f12245e.setColorFilterType(2);
        }
    }
}
