package com.martian.mibook.mvvm.read.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.viewpager.widget.ViewPager;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.kuaishou.weapon.p0.t;
import com.kwad.sdk.m.e;
import com.martian.libmars.common.ConfigSingleton;
import com.martian.libmars.utils.tablayout.ColorTransitionPagerTitleView;
import com.martian.libmars.utils.tablayout.CommonNavigator;
import com.martian.libmars.widget.DownLoadButton;
import com.martian.mibook.application.MiBookManager;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.databinding.ReaderDirLayoutBinding;
import com.martian.mibook.lib.model.data.abs.Book;
import com.martian.mibook.mvvm.base.BaseMVVMActivity;
import com.martian.mibook.mvvm.base.BaseViewModel;
import com.martian.mibook.mvvm.extensions.ExtKt;
import com.martian.mibook.mvvm.read.fragment.ReadingBookInfoFragment;
import com.martian.mibook.mvvm.read.fragment.ReadingBookMarkFragment;
import com.martian.mibook.mvvm.read.fragment.ReadingChapterListFragment;
import com.martian.mibook.mvvm.read.viewmodel.ReadingViewModel;
import com.martian.mibook.mvvm.read.widget.ReadingDirectoryLayout;
import com.martian.mibook.mvvm.ui.viewmodel.AppViewModel;
import com.martian.mibook.mvvm.widget.ScreenSlidePagerAdapter;
import com.umeng.analytics.pro.bt;
import com.umeng.analytics.pro.f;
import id.c;
import java.util.ArrayList;
import java.util.List;
import je.i;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import m9.g;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u00012B\u001d\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\t\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\nJ\u000f\u0010\f\u001a\u00020\bH\u0002¢\u0006\u0004\b\f\u0010\nJ\u000f\u0010\r\u001a\u00020\bH\u0002¢\u0006\u0004\b\r\u0010\nJ\u000f\u0010\u000e\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000e\u0010\nJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0016\u0010\nJ\u0017\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u0017H\u0002¢\u0006\u0004\b\u0019\u0010\u001aR\u001d\u0010 \u001a\u0004\u0018\u00010\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001d\u0010%\u001a\u0004\u0018\u00010!8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010\u001d\u001a\u0004\b#\u0010$R\u0014\u0010)\u001a\u00020&8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u001c\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00130*8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010,R\u0016\u00101\u001a\u0004\u0018\u00010.8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b/\u00100¨\u00063"}, d2 = {"Lcom/martian/mibook/mvvm/read/widget/ReadingDirectoryLayout;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", f.X, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", IAdInterListener.AdReqParam.WIDTH, "()V", "m", "n", "x", bt.aO, "", "v", "()Z", "", "Landroidx/fragment/app/Fragment;", "k", "()Ljava/util/List;", "u", "", c.f26972i, t.f11204d, "(I)V", "Lcom/martian/mibook/mvvm/read/viewmodel/ReadingViewModel;", "b", "Lkotlin/Lazy;", "getMViewModel", "()Lcom/martian/mibook/mvvm/read/viewmodel/ReadingViewModel;", "mViewModel", "Landroidx/fragment/app/FragmentActivity;", "c", "getActivity", "()Landroidx/fragment/app/FragmentActivity;", TTDownloadField.TT_ACTIVITY, "Lcom/martian/mibook/databinding/ReaderDirLayoutBinding;", "d", "Lcom/martian/mibook/databinding/ReaderDirLayoutBinding;", "mViewBinding", "", e.TAG, "Ljava/util/List;", "fragmentList", "Lcom/martian/mibook/mvvm/read/widget/a;", "getReadMenuCallBack", "()Lcom/martian/mibook/mvvm/read/widget/a;", "readMenuCallBack", "a", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nReadingDirectoryLayout.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ReadingDirectoryLayout.kt\ncom/martian/mibook/mvvm/read/widget/ReadingDirectoryLayout\n+ 2 Ext.kt\ncom/martian/mibook/mvvm/extensions/ExtKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,294:1\n26#2:295\n1855#3,2:296\n*S KotlinDebug\n*F\n+ 1 ReadingDirectoryLayout.kt\ncom/martian/mibook/mvvm/read/widget/ReadingDirectoryLayout\n*L\n38#1:295\n233#1:296,2\n*E\n"})
/* loaded from: classes3.dex */
public final class ReadingDirectoryLayout extends FrameLayout {

    /* renamed from: b, reason: from kotlin metadata */
    @k
    public final Lazy mViewModel;

    /* renamed from: c, reason: from kotlin metadata */
    @k
    public final Lazy com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_ACTIVITY java.lang.String;

    /* renamed from: d, reason: from kotlin metadata */
    @k
    public final ReaderDirLayoutBinding mViewBinding;

    /* renamed from: e */
    @k
    public List<Fragment> fragmentList;

    public static final class a extends m9.b {

        /* renamed from: b */
        @k
        public final ArrayList<String> f14957b;

        /* renamed from: c */
        @l
        public InterfaceC0539a f14958c;

        /* renamed from: com.martian.mibook.mvvm.read.widget.ReadingDirectoryLayout$a$a */
        public interface InterfaceC0539a {
            void a(@k View view, int i10);
        }

        public a(@k ArrayList<String> tabTitles) {
            Intrinsics.checkNotNullParameter(tabTitles, "tabTitles");
            this.f14957b = tabTitles;
        }

        public static final void j(a this$0, int i10, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            InterfaceC0539a interfaceC0539a = this$0.f14958c;
            if (interfaceC0539a != null) {
                Intrinsics.checkNotNull(view);
                interfaceC0539a.a(view, i10);
            }
        }

        @Override // m9.b
        public int a() {
            return this.f14957b.size();
        }

        @Override // m9.b
        @l
        public m9.e b(@l Context context) {
            return null;
        }

        @Override // m9.b
        @k
        public g c(@k Context context, int i10) {
            Intrinsics.checkNotNullParameter(context, "context");
            ColorTransitionPagerTitleView colorTransitionPagerTitleView = new ColorTransitionPagerTitleView(context, false);
            colorTransitionPagerTitleView.setTypeface(MiConfigSingleton.b2().i2().g());
            colorTransitionPagerTitleView.setText(ExtKt.c(this.f14957b.get(i10)));
            colorTransitionPagerTitleView.setTextSize(16.0f);
            colorTransitionPagerTitleView.setNormalColor(MiConfigSingleton.b2().h2().q());
            colorTransitionPagerTitleView.setSelectedColor(MiConfigSingleton.b2().h2().k().getItemColorPrimary());
            colorTransitionPagerTitleView.setOnClickListener(new View.OnClickListener() { // from class: hd.g2

                /* renamed from: c */
                public final /* synthetic */ int f26584c;

                public /* synthetic */ g2(int i102) {
                    i10 = i102;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ReadingDirectoryLayout.a.j(ReadingDirectoryLayout.a.this, i10, view);
                }
            });
            return colorTransitionPagerTitleView;
        }

        public final void k(@l InterfaceC0539a interfaceC0539a) {
            this.f14958c = interfaceC0539a;
        }
    }

    public static final class b implements a.InterfaceC0539a {
        public b() {
        }

        @Override // com.martian.mibook.mvvm.read.widget.ReadingDirectoryLayout.a.InterfaceC0539a
        public void a(@k View view, int i10) {
            Intrinsics.checkNotNullParameter(view, "view");
            ReadingDirectoryLayout.this.mViewBinding.viewpager.setCurrentItem(i10);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ReadingDirectoryLayout(@k Context context) {
        this(context, null, 2, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final FragmentActivity getActivity() {
        return (FragmentActivity) this.com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_ACTIVITY java.lang.String.getValue();
    }

    public final ReadingViewModel getMViewModel() {
        return (ReadingViewModel) this.mViewModel.getValue();
    }

    private final com.martian.mibook.mvvm.read.widget.a getReadMenuCallBack() {
        Object context = getContext();
        if (context instanceof com.martian.mibook.mvvm.read.widget.a) {
            return (com.martian.mibook.mvvm.read.widget.a) context;
        }
        return null;
    }

    public static final void o(ReadingDirectoryLayout this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentActivity activity = this$0.getActivity();
        ReadingViewModel mViewModel = this$0.getMViewModel();
        i.E(activity, mViewModel != null ? mViewModel.getBook() : null);
    }

    public static final void p(ReadingDirectoryLayout this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentActivity activity = this$0.getActivity();
        ReadingViewModel mViewModel = this$0.getMViewModel();
        i.E(activity, mViewModel != null ? mViewModel.getBook() : null);
    }

    public static final void q(ReadingDirectoryLayout this$0, View view) {
        com.martian.mibook.mvvm.read.widget.a readMenuCallBack;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.mViewBinding.downloadBtn.getMCurrentState() != DownLoadButton.INSTANCE.a() || (readMenuCallBack = this$0.getReadMenuCallBack()) == null) {
            return;
        }
        readMenuCallBack.i0();
    }

    public static final void r(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void s(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final List<Fragment> k() {
        this.fragmentList.clear();
        if (!v()) {
            this.fragmentList.add(ReadingBookInfoFragment.INSTANCE.a());
        }
        this.fragmentList.add(ReadingChapterListFragment.INSTANCE.a());
        this.fragmentList.add(ReadingBookMarkFragment.INSTANCE.a());
        return this.fragmentList;
    }

    public final void l(int i10) {
        if (this.mViewBinding.viewpager.getChildCount() == 0) {
            return;
        }
        Fragment fragment = this.fragmentList.get(i10);
        for (Fragment fragment2 : this.fragmentList) {
            if (fragment2 instanceof ReadingBookInfoFragment) {
                ((ReadingBookInfoFragment) fragment2).e1(fragment instanceof ReadingBookInfoFragment);
            } else if (fragment2 instanceof ReadingChapterListFragment) {
                ((ReadingChapterListFragment) fragment2).R0(fragment instanceof ReadingChapterListFragment);
            } else if (fragment2 instanceof ReadingBookMarkFragment) {
                ((ReadingBookMarkFragment) fragment2).x0(fragment instanceof ReadingBookMarkFragment);
            }
        }
        Object parent = this.mViewBinding.getRoot().getParent();
        View view = parent instanceof View ? (View) parent : null;
        if (view != null) {
            view.requestLayout();
        }
    }

    public final void m() {
        this.mViewBinding.downloadBtn.setTypeFace(MiConfigSingleton.b2().i2().g());
        this.mViewBinding.downloadBtn.setThemColor(MiConfigSingleton.b2().h2().k().getItemColorPrimary());
        if (v()) {
            this.mViewBinding.rlDownload.setVisibility(8);
        } else {
            this.mViewBinding.rlDownload.setVisibility(0);
        }
    }

    public final void n() {
        MutableLiveData<Integer> b12;
        AppViewModel l12;
        MutableLiveData<Unit> i02;
        Book book;
        this.mViewBinding.getRoot().setOnClickListener(null);
        this.mViewBinding.tvBookName.setOnClickListener(new View.OnClickListener() { // from class: hd.b2
            public /* synthetic */ b2() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ReadingDirectoryLayout.o(ReadingDirectoryLayout.this, view);
            }
        });
        this.mViewBinding.ivBookCover.setOnClickListener(new View.OnClickListener() { // from class: hd.c2
            public /* synthetic */ c2() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ReadingDirectoryLayout.p(ReadingDirectoryLayout.this, view);
            }
        });
        ReadingViewModel mViewModel = getMViewModel();
        if (mViewModel != null && (book = mViewModel.getBook()) != null) {
            MiBookManager.s1(getContext(), book, this.mViewBinding.ivBookCover);
            String c10 = ExtKt.c(book.getBookName());
            this.mViewBinding.tvBookName.setText(c10);
            if (book.isLocal()) {
                this.mViewBinding.tvCoverBookName.setText(c10);
                this.mViewBinding.tvCoverBookName.setVisibility(0);
            } else {
                this.mViewBinding.tvCoverBookName.setVisibility(8);
            }
            this.mViewBinding.tvBookDes.setText(book.getBookInfo());
        }
        if (MiConfigSingleton.b2().E2()) {
            this.mViewBinding.downloadBtnVipTag.setVisibility(8);
        } else {
            this.mViewBinding.downloadBtnVipTag.setVisibility(0);
        }
        this.mViewBinding.downloadBtn.setOnClickListener(new View.OnClickListener() { // from class: hd.d2
            public /* synthetic */ d2() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ReadingDirectoryLayout.q(ReadingDirectoryLayout.this, view);
            }
        });
        FragmentActivity activity = getActivity();
        if (activity != null) {
            FragmentActivity activity2 = getActivity();
            BaseMVVMActivity baseMVVMActivity = activity2 instanceof BaseMVVMActivity ? (BaseMVVMActivity) activity2 : null;
            if (baseMVVMActivity != null && (l12 = baseMVVMActivity.l1()) != null && (i02 = l12.i0()) != null) {
                i02.observe(baseMVVMActivity, new Observer() { // from class: hd.e2
                    public /* synthetic */ e2() {
                    }

                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        ReadingDirectoryLayout.r(Function1.this, obj);
                    }
                });
            }
            ReadingViewModel mViewModel2 = getMViewModel();
            if (mViewModel2 == null || (b12 = mViewModel2.b1()) == null) {
                return;
            }
            b12.observe(activity, new Observer() { // from class: hd.f2
                public /* synthetic */ f2() {
                }

                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    ReadingDirectoryLayout.s(Function1.this, obj);
                }
            });
        }
    }

    public final void t() {
        a aVar = new a(!v() ? CollectionsKt.arrayListOf("详情", "目录", "书签") : CollectionsKt.arrayListOf("目录", "书签"));
        aVar.k(new b());
        CommonNavigator commonNavigator = new CommonNavigator(getContext());
        commonNavigator.setMarginHorizontal(ConfigSingleton.i(16.0f));
        commonNavigator.setAdapter(aVar);
        this.mViewBinding.magicIndicator.setNavigator(commonNavigator);
    }

    public final void u() {
        if (this.mViewBinding.viewpager.getAdapter() != null) {
            return;
        }
        FragmentActivity activity = getActivity();
        Intrinsics.checkNotNull(activity);
        FragmentManager supportFragmentManager = activity.getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
        ScreenSlidePagerAdapter screenSlidePagerAdapter = new ScreenSlidePagerAdapter(supportFragmentManager, k(), null, 4, null);
        this.mViewBinding.viewpager.setOffscreenPageLimit(this.fragmentList.size());
        this.mViewBinding.viewpager.setAdapter(screenSlidePagerAdapter);
        this.mViewBinding.viewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.martian.mibook.mvvm.read.widget.ReadingDirectoryLayout$initViewPager$1
            public ReadingDirectoryLayout$initViewPager$1() {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int state) {
                ReadingDirectoryLayout.this.mViewBinding.magicIndicator.a(state);
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int r22, float positionOffset, int positionOffsetPixels) {
                ReadingDirectoryLayout.this.mViewBinding.magicIndicator.b(r22, positionOffset, positionOffsetPixels);
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int r22) {
                ReadingDirectoryLayout.this.mViewBinding.magicIndicator.c(r22);
                ReadingDirectoryLayout.this.l(r22);
            }
        });
        this.mViewBinding.viewpager.setCurrentItem(this.fragmentList.size() > 2 ? 1 : 0);
    }

    public final boolean v() {
        Book book;
        ReadingViewModel mViewModel = getMViewModel();
        boolean z10 = false;
        if (mViewModel != null && (book = mViewModel.getBook()) != null && !book.isLocal()) {
            z10 = true;
        }
        return !z10;
    }

    public final void w() {
        if (!(!this.fragmentList.isEmpty())) {
            u();
            return;
        }
        int currentItem = this.mViewBinding.viewpager.getCurrentItem();
        if (this.fragmentList.size() > currentItem) {
            Fragment fragment = this.fragmentList.get(currentItem);
            if (fragment.getView() == null || !fragment.isResumed()) {
                return;
            }
            fragment.onResume();
        }
    }

    public final void x() {
        m();
    }

    public /* synthetic */ ReadingDirectoryLayout(Context context, AttributeSet attributeSet, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i10 & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ReadingDirectoryLayout(@k Context context, @l AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mViewModel = LazyKt.lazy(new Function0<ReadingViewModel>() { // from class: com.martian.mibook.mvvm.read.widget.ReadingDirectoryLayout$special$$inlined$activityViewModel$1
            final /* synthetic */ View $this_activityViewModel;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ReadingDirectoryLayout$special$$inlined$activityViewModel$1(View this) {
                super(0);
                this = this;
            }

            @Override // kotlin.jvm.functions.Function0
            @l
            public final ReadingViewModel invoke() {
                Context context2 = this.getContext();
                FragmentActivity fragmentActivity = context2 instanceof FragmentActivity ? (FragmentActivity) context2 : null;
                if (fragmentActivity == null || !(fragmentActivity instanceof BaseMVVMActivity)) {
                    return null;
                }
                BaseViewModel m12 = ((BaseMVVMActivity) fragmentActivity).m1();
                return (ReadingViewModel) (m12 instanceof ReadingViewModel ? m12 : null);
            }
        });
        this.com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_ACTIVITY java.lang.String = LazyKt.lazy(new Function0<FragmentActivity>() { // from class: com.martian.mibook.mvvm.read.widget.ReadingDirectoryLayout$activity$2
            final /* synthetic */ Context $context;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ReadingDirectoryLayout$activity$2(Context context2) {
                super(0);
                context = context2;
            }

            @Override // kotlin.jvm.functions.Function0
            @l
            public final FragmentActivity invoke() {
                Context context2 = context;
                if (context2 instanceof FragmentActivity) {
                    return (FragmentActivity) context2;
                }
                return null;
            }
        });
        ReaderDirLayoutBinding inflate = ReaderDirLayoutBinding.inflate(LayoutInflater.from(context2), this, true);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        this.mViewBinding = inflate;
        this.fragmentList = new ArrayList();
        n();
        m();
        t();
        u();
    }
}
