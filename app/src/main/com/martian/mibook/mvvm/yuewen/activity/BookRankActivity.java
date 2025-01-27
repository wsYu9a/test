package com.martian.mibook.mvvm.yuewen.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import androidx.viewpager.widget.ViewPager;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.martian.libmars.common.ConfigSingleton;
import com.martian.libmars.databinding.LayoutToolbarBinding;
import com.martian.libmars.ui.theme.ThemeLinearLayout;
import com.martian.libmars.utils.tablayout.CommonNavigator;
import com.martian.libmars.utils.tablayout.MagicIndicator;
import com.martian.libmars.utils.tablayout.ScaleTransitionPagerTitleView;
import com.martian.mibook.R;
import com.martian.mibook.databinding.ActivityBookRankBinding;
import com.martian.mibook.lib.yuewen.response.YWCategory;
import com.martian.mibook.mvvm.base.BaseMVVMActivity;
import com.martian.mibook.mvvm.extensions.ExtKt;
import com.martian.mibook.mvvm.widget.ScreenSlidePagerAdapter;
import com.martian.mibook.mvvm.yuewen.activity.BookRankActivity;
import com.martian.mibook.mvvm.yuewen.fragment.BookRankFragment;
import com.martian.mibook.mvvm.yuewen.viewmodel.BookRankViewModel;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import m9.b;
import m9.e;
import m9.g;
import xi.k;
import xi.l;

@Route(path = kc.a.f27749e)
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\u0005J\u000f\u0010\b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\b\u0010\u0005J\u0019\u0010\u000b\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\u000f\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0011\u0010\u0005J\u000f\u0010\u0012\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0012\u0010\u0005J\u001f\u0010\u0016\u001a\u00020\u00062\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013H\u0002¢\u0006\u0004\b\u0016\u0010\u0017R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u001c\u0010#\u001a\b\u0012\u0004\u0012\u00020 0\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R$\u0010)\u001a\u0012\u0012\u0004\u0012\u00020%0$j\b\u0012\u0004\u0012\u00020%`&8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010(¨\u0006*"}, d2 = {"Lcom/martian/mibook/mvvm/yuewen/activity/BookRankActivity;", "Lcom/martian/mibook/mvvm/base/BaseMVVMActivity;", "Lcom/martian/mibook/databinding/ActivityBookRankBinding;", "Lcom/martian/mibook/mvvm/yuewen/viewmodel/BookRankViewModel;", "<init>", "()V", "", "U1", "V1", "Lcom/martian/libmars/databinding/LayoutToolbarBinding;", "toolbarBinding", "s1", "(Lcom/martian/libmars/databinding/LayoutToolbarBinding;)V", "Landroid/os/Bundle;", "savedInstanceState", "c1", "(Landroid/os/Bundle;)V", "k1", "S1", "", "Lcom/martian/mibook/lib/yuewen/response/YWCategory;", "categoryList", "T1", "(Ljava/util/List;)V", "Lcom/martian/libmars/ui/theme/ThemeLinearLayout;", "h", "Lcom/martian/libmars/ui/theme/ThemeLinearLayout;", "llTab", "Lcom/martian/libmars/utils/tablayout/MagicIndicator;", "i", "Lcom/martian/libmars/utils/tablayout/MagicIndicator;", "magicIndicator", "Landroidx/fragment/app/Fragment;", "j", "Ljava/util/List;", "fragmentList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "k", "Ljava/util/ArrayList;", "categoryTitleList", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nBookRankActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BookRankActivity.kt\ncom/martian/mibook/mvvm/yuewen/activity/BookRankActivity\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,193:1\n1#2:194\n1864#3,3:195\n1855#3,2:198\n*S KotlinDebug\n*F\n+ 1 BookRankActivity.kt\ncom/martian/mibook/mvvm/yuewen/activity/BookRankActivity\n*L\n125#1:195,3\n140#1:198,2\n*E\n"})
/* loaded from: classes3.dex */
public final class BookRankActivity extends BaseMVVMActivity<ActivityBookRankBinding, BookRankViewModel> {

    /* renamed from: h, reason: from kotlin metadata */
    @l
    public ThemeLinearLayout llTab;

    /* renamed from: i, reason: from kotlin metadata */
    @l
    public MagicIndicator magicIndicator;

    /* renamed from: j, reason: from kotlin metadata */
    @k
    public List<Fragment> fragmentList = new ArrayList();

    /* renamed from: k, reason: from kotlin metadata */
    @k
    public final ArrayList<String> categoryTitleList = new ArrayList<>();

    public static final class a extends b {

        /* renamed from: b */
        public final /* synthetic */ ScreenSlidePagerAdapter f15379b;

        /* renamed from: c */
        public final /* synthetic */ BookRankActivity f15380c;

        public a(ScreenSlidePagerAdapter screenSlidePagerAdapter, BookRankActivity bookRankActivity) {
            this.f15379b = screenSlidePagerAdapter;
            this.f15380c = bookRankActivity;
        }

        public static final void j(BookRankActivity this$0, int i10, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            BookRankActivity.K1(this$0).viewpager.setCurrentItem(i10, Math.abs(i10 - BookRankActivity.K1(this$0).viewpager.getCurrentItem()) <= 2);
        }

        @Override // m9.b
        public int a() {
            return this.f15379b.a().size();
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
            List<String> b10 = this.f15379b.b();
            scaleTransitionPagerTitleView.setText(ExtKt.c(b10 != null ? b10.get(i10) : null));
            scaleTransitionPagerTitleView.setTextSize(16.0f);
            scaleTransitionPagerTitleView.setMaxScale(1.375f);
            scaleTransitionPagerTitleView.setNormalColor(ConfigSingleton.D().j0());
            scaleTransitionPagerTitleView.setSelectedColor(ConfigSingleton.D().h0());
            scaleTransitionPagerTitleView.setOnClickListener(new View.OnClickListener() { // from class: sd.d

                /* renamed from: c */
                public final /* synthetic */ int f30657c;

                public /* synthetic */ d(int i102) {
                    i10 = i102;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    BookRankActivity.a.j(BookRankActivity.this, i10, view);
                }
            });
            return scaleTransitionPagerTitleView;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ ActivityBookRankBinding K1(BookRankActivity bookRankActivity) {
        return (ActivityBookRankBinding) bookRankActivity.a1();
    }

    public static final void P1(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void Q1(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void R1(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final void U1() {
        m1().n();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void V1() {
        int indexOf;
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
        ScreenSlidePagerAdapter screenSlidePagerAdapter = new ScreenSlidePagerAdapter(supportFragmentManager, this.fragmentList, this.categoryTitleList);
        ((ActivityBookRankBinding) a1()).viewpager.setOffscreenPageLimit(this.fragmentList.size());
        ((ActivityBookRankBinding) a1()).viewpager.setAdapter(screenSlidePagerAdapter);
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
        ViewPager viewPager = ((ActivityBookRankBinding) a1()).viewpager;
        int i10 = 0;
        if (!TextUtils.isEmpty(m1().getCategory()) && (indexOf = CollectionsKt.indexOf((List<? extends String>) this.categoryTitleList, m1().getCategory())) >= 0) {
            i10 = indexOf;
        }
        viewPager.setCurrentItem(i10);
    }

    public final void S1() {
        this.fragmentList.clear();
        int i10 = 0;
        for (Object obj : this.categoryTitleList) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            String str = (String) obj;
            List<Fragment> list = this.fragmentList;
            BookRankFragment.Companion companion = BookRankFragment.INSTANCE;
            int cType = m1().getCType();
            if (i10 == 0) {
                str = null;
            }
            list.add(companion.a(cType, str, m1().getBrtype(), m1().getSource()));
            i10 = i11;
        }
    }

    public final void T1(List<YWCategory> categoryList) {
        this.categoryTitleList.clear();
        this.categoryTitleList.add(getString(R.string.withdraw_money_all));
        if (categoryList != null) {
            for (YWCategory yWCategory : categoryList) {
                if (!ba.l.q(yWCategory.getCategoryName())) {
                    this.categoryTitleList.add(yWCategory.getCategoryName());
                }
            }
        }
    }

    @Override // com.martian.mibook.mvvm.base.BaseActivity
    public void c1(@l Bundle savedInstanceState) {
        Intent intent = getIntent();
        if (intent != null) {
            m1().C(intent.getIntExtra("intent_ctype", 1));
            int intExtra = intent.getIntExtra("intent_brtype", -1);
            m1().A(intExtra == -1 ? null : Integer.valueOf(intExtra));
            m1().D(intent.getStringExtra("intent_category"));
            m1().F(intent.getStringExtra("intent_source"));
        }
        U1();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.martian.mibook.mvvm.base.BaseMVVMActivity
    public void k1() {
        ((ActivityBookRankBinding) a1()).viewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.martian.mibook.mvvm.yuewen.activity.BookRankActivity$addObserver$1
            public BookRankActivity$addObserver$1() {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int state) {
                MagicIndicator magicIndicator;
                magicIndicator = BookRankActivity.this.magicIndicator;
                if (magicIndicator != null) {
                    magicIndicator.a(state);
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int r22, float positionOffset, int positionOffsetPixels) {
                MagicIndicator magicIndicator;
                magicIndicator = BookRankActivity.this.magicIndicator;
                if (magicIndicator != null) {
                    magicIndicator.b(r22, positionOffset, positionOffsetPixels);
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int r22) {
                MagicIndicator magicIndicator;
                magicIndicator = BookRankActivity.this.magicIndicator;
                if (magicIndicator != null) {
                    magicIndicator.c(r22);
                }
            }
        });
        m1().u().observe(this, new Observer() { // from class: sd.a
            public /* synthetic */ a() {
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                BookRankActivity.P1(Function1.this, obj);
            }
        });
        m1().h().observe(this, new Observer() { // from class: sd.b
            public /* synthetic */ b() {
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                BookRankActivity.Q1(Function1.this, obj);
            }
        });
        m1().g().observe(this, new Observer() { // from class: sd.c
            public /* synthetic */ c() {
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                BookRankActivity.R1(Function1.this, obj);
            }
        });
        ((ActivityBookRankBinding) a1()).rlLoadedTip.setOnReloadListener(new Function0<Unit>() { // from class: com.martian.mibook.mvvm.yuewen.activity.BookRankActivity$addObserver$5
            public BookRankActivity$addObserver$5() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke */
            public final void invoke2() {
                BookRankActivity.this.U1();
            }
        });
    }

    @Override // com.martian.mibook.mvvm.base.BaseMVVMActivity
    public void s1(@l LayoutToolbarBinding toolbarBinding) {
        super.s1(toolbarBinding);
        if (toolbarBinding != null) {
            toolbarBinding.f12249i.setVisibility(8);
            toolbarBinding.f12243c.setVisibility(8);
            toolbarBinding.f12246f.setLayoutResource(com.martian.libmars.R.layout.layout_xttab);
            toolbarBinding.f12246f.setVisibility(0);
            View findViewById = findViewById(com.martian.libmars.R.id.ll_tab);
            this.llTab = findViewById instanceof ThemeLinearLayout ? (ThemeLinearLayout) findViewById : null;
            View findViewById2 = findViewById(com.martian.libmars.R.id.magic_indicator);
            this.magicIndicator = findViewById2 instanceof MagicIndicator ? (MagicIndicator) findViewById2 : null;
            toolbarBinding.f12248h.setBackgroundType(14);
            toolbarBinding.f12245e.setColorFilterType(2);
            ThemeLinearLayout themeLinearLayout = this.llTab;
            if (themeLinearLayout != null) {
                themeLinearLayout.setBackgroundType(14);
            }
        }
    }
}
