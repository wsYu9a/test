package com.martian.mibook.mvvm.read.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.kuaishou.weapon.p0.t;
import com.martian.libmars.R;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.data.theme.MiReadingTheme;
import com.martian.mibook.databinding.FragmentReadingBookChapterListBinding;
import com.martian.mibook.lib.model.data.abs.Book;
import com.martian.mibook.lib.model.data.abs.ChapterList;
import com.martian.mibook.mvvm.base.BaseMVVMFragment;
import com.martian.mibook.mvvm.read.adapter.ReadingBookChapterListAdapter;
import com.martian.mibook.mvvm.read.fragment.ReadingChapterListFragment;
import com.martian.mibook.mvvm.read.viewmodel.ReadingViewModel;
import com.martian.mibook.mvvm.read.widget.ReaderLoadingTip;
import com.martian.mibook.mvvm.read.widget.a;
import com.martian.mibook.mvvm.ui.viewmodel.AppViewModel;
import com.martian.mibook.mvvm.utils.coroutine.Coroutine;
import com.martian.mibook.mvvm.widget.SmartScrollLayoutManager;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Dispatchers;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 ,2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001-B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0003¢\u0006\u0004\b\u0007\u0010\u0005J\u000f\u0010\b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\b\u0010\u0005J\u000f\u0010\t\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\u0005J\u000f\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\r\u0010\u0005J\u000f\u0010\u000e\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000e\u0010\u0005J\u000f\u0010\u000f\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000f\u0010\u0005J\u000f\u0010\u0010\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0010\u0010\u0005J\u0019\u0010\u0013\u001a\u00020\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0015\u0010\u0005J\u000f\u0010\u0016\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0016\u0010\u0005J\u0015\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u0019\u0010\u001aJ\u001d\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001b¢\u0006\u0004\b\u001e\u0010\u001fR\u001b\u0010#\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010 \u001a\u0004\b!\u0010\"R\u0018\u0010'\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010+\u001a\u0004\u0018\u00010(8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b)\u0010*¨\u0006."}, d2 = {"Lcom/martian/mibook/mvvm/read/fragment/ReadingChapterListFragment;", "Lcom/martian/mibook/mvvm/base/BaseMVVMFragment;", "Lcom/martian/mibook/databinding/FragmentReadingBookChapterListBinding;", "Lcom/martian/mibook/mvvm/read/viewmodel/ReadingViewModel;", "<init>", "()V", "", "B0", "H0", "Q0", "", "y0", "()Ljava/lang/String;", "M0", "J0", "O0", "i0", "Landroid/os/Bundle;", "savedInstanceState", "q", "(Landroid/os/Bundle;)V", "k", "onResume", "", "enable", "R0", "(Z)V", "", "startIndex", "cacheIndex", "L0", "(II)V", "Lkotlin/Lazy;", "z0", "()Lcom/martian/mibook/mvvm/read/viewmodel/ReadingViewModel;", "mViewModel", "Lcom/martian/mibook/mvvm/read/adapter/ReadingBookChapterListAdapter;", t.f11204d, "Lcom/martian/mibook/mvvm/read/adapter/ReadingBookChapterListAdapter;", "chapterListAdapter", "Lcom/martian/mibook/mvvm/read/widget/a;", "A0", "()Lcom/martian/mibook/mvvm/read/widget/a;", "readMenuCallBack", "m", "a", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes3.dex */
public final class ReadingChapterListFragment extends BaseMVVMFragment<FragmentReadingBookChapterListBinding, ReadingViewModel> {

    /* renamed from: m, reason: from kotlin metadata */
    @k
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: k, reason: from kotlin metadata */
    @k
    public final Lazy mViewModel = LazyKt.lazy(new Function0<ReadingViewModel>() { // from class: com.martian.mibook.mvvm.read.fragment.ReadingChapterListFragment$mViewModel$2
        public ReadingChapterListFragment$mViewModel$2() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @k
        public final ReadingViewModel invoke() {
            ViewModelStoreOwner activity = ReadingChapterListFragment.this.getActivity();
            if (activity == null) {
                activity = ReadingChapterListFragment.this;
            }
            return (ReadingViewModel) new ViewModelProvider(activity).get(ReadingChapterListFragment.this.M());
        }
    });

    /* renamed from: l */
    @l
    public ReadingBookChapterListAdapter chapterListAdapter;

    /* renamed from: com.martian.mibook.mvvm.read.fragment.ReadingChapterListFragment$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @k
        public final ReadingChapterListFragment a() {
            return new ReadingChapterListFragment();
        }

        public Companion() {
        }
    }

    public final a A0() {
        Object context = getContext();
        if (context instanceof a) {
            return (a) context;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SuppressLint({"ClickableViewAccessibility", "UseCompatLoadingForDrawables"})
    public final void B0() {
        MutableLiveData<Unit> i02;
        ((FragmentReadingBookChapterListBinding) n()).rvChapterList.setNestedScrollingEnabled(true);
        ((FragmentReadingBookChapterListBinding) n()).rvChapterList.setHandleDrawable(R.drawable.icon_fastscroll_day);
        ((FragmentReadingBookChapterListBinding) n()).rvChapterList.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.martian.mibook.mvvm.read.fragment.ReadingChapterListFragment$initListener$1
            public ReadingChapterListFragment$initListener$1() {
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(@k RecyclerView recyclerView, int newState) {
                ReadingBookChapterListAdapter readingBookChapterListAdapter;
                Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
                super.onScrollStateChanged(recyclerView, newState);
                if (newState != 0) {
                    if (newState == 1 || newState == 2) {
                        ReadingChapterListFragment.r0(ReadingChapterListFragment.this).floatingAction.setAlpha(0.4f);
                        return;
                    }
                    return;
                }
                ReadingChapterListFragment.r0(ReadingChapterListFragment.this).floatingAction.setAlpha(1.0f);
                readingBookChapterListAdapter = ReadingChapterListFragment.this.chapterListAdapter;
                if (readingBookChapterListAdapter != null) {
                    ReadingBookChapterListAdapter.s(readingBookChapterListAdapter, recyclerView, 0L, 2, null);
                }
            }
        });
        ((FragmentReadingBookChapterListBinding) n()).floatingAction.setOnClickListener(new View.OnClickListener() { // from class: ed.s0
            public /* synthetic */ s0() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ReadingChapterListFragment.C0(ReadingChapterListFragment.this, view);
            }
        });
        ReadingBookChapterListAdapter readingBookChapterListAdapter = this.chapterListAdapter;
        if (readingBookChapterListAdapter != null) {
            readingBookChapterListAdapter.E(new ReadingBookChapterListAdapter.b() { // from class: com.martian.mibook.mvvm.read.fragment.ReadingChapterListFragment$initListener$3
                public ReadingChapterListFragment$initListener$3() {
                }

                @Override // com.martian.mibook.mvvm.read.adapter.ReadingBookChapterListAdapter.b
                public void a(int i10) {
                    ReadingBookChapterListAdapter readingBookChapterListAdapter2;
                    a A0;
                    readingBookChapterListAdapter2 = ReadingChapterListFragment.this.chapterListAdapter;
                    if (readingBookChapterListAdapter2 != null) {
                        readingBookChapterListAdapter2.D(i10);
                    }
                    A0 = ReadingChapterListFragment.this.A0();
                    if (A0 != null) {
                        A0.O(new Function0<Unit>() { // from class: com.martian.mibook.mvvm.read.fragment.ReadingChapterListFragment$initListener$3$onClick$1
                            final /* synthetic */ int $chapterIndex;

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            public ReadingChapterListFragment$initListener$3$onClick$1(int i102) {
                                super(0);
                                i10 = i102;
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Unit invoke() {
                                invoke2();
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke */
                            public final void invoke2() {
                                a A02;
                                A02 = ReadingChapterListFragment.this.A0();
                                if (A02 != null) {
                                    A02.t0(i10, 0, 0);
                                }
                            }
                        });
                    }
                }
            });
        }
        ((FragmentReadingBookChapterListBinding) n()).dirCategoryView.setOnClickListener(new View.OnClickListener() { // from class: ed.t0
            public /* synthetic */ t0() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ReadingChapterListFragment.D0(ReadingChapterListFragment.this, view);
            }
        });
        I().Y0().observe(this, new Observer() { // from class: ed.u0
            public /* synthetic */ u0() {
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ReadingChapterListFragment.E0(Function1.this, obj);
            }
        });
        I().I0().observe(this, new Observer() { // from class: ed.v0
            public /* synthetic */ v0() {
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ReadingChapterListFragment.F0(Function1.this, obj);
            }
        });
        AppViewModel G = G();
        if (G == null || (i02 = G.i0()) == null) {
            return;
        }
        i02.observe(this, new Observer() { // from class: ed.w0
            public /* synthetic */ w0() {
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ReadingChapterListFragment.G0(Function1.this, obj);
            }
        });
    }

    public static final void C0(ReadingChapterListFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.O0();
    }

    public static final void D0(ReadingChapterListFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.M0();
    }

    public static final void E0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void F0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void G0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void H0() {
        Context context = getContext();
        if (context != null) {
            ac.a.L(getContext(), "目录-目录");
            ((FragmentReadingBookChapterListBinding) n()).loadedTip.setLoadingTip(ReaderLoadingTip.LoadStatus.loading);
            ((FragmentReadingBookChapterListBinding) n()).rvChapterList.setLayoutManager(new SmartScrollLayoutManager(context, 0, false, 6, null));
            this.chapterListAdapter = new ReadingBookChapterListAdapter();
            ((FragmentReadingBookChapterListBinding) n()).rvChapterList.setAdapter(this.chapterListAdapter);
            Q0();
        }
    }

    @JvmStatic
    @k
    public static final ReadingChapterListFragment I0() {
        return INSTANCE.a();
    }

    public final void J0() {
        Coroutine.onError$default(Coroutine.onSuccess$default(Coroutine.onStart$default(Coroutine.Companion.async$default(Coroutine.INSTANCE, null, null, null, null, new ReadingChapterListFragment$refreshChapterList$1(this, null), 15, null), null, new ReadingChapterListFragment$refreshChapterList$2(this, null), 1, null), null, new ReadingChapterListFragment$refreshChapterList$3(this, null), 1, null), null, new ReadingChapterListFragment$refreshChapterList$4(this, null), 1, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void M0() {
        RecyclerView.LayoutManager layoutManager = ((FragmentReadingBookChapterListBinding) n()).rvChapterList.getLayoutManager();
        Intrinsics.checkNotNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
        ReadingBookChapterListAdapter readingBookChapterListAdapter = this.chapterListAdapter;
        if (readingBookChapterListAdapter == null || !readingBookChapterListAdapter.getIsReverseOrder()) {
            ((FragmentReadingBookChapterListBinding) n()).dirCategory.setText(getString(com.martian.mibook.R.string.sequence_positive));
            ((FragmentReadingBookChapterListBinding) n()).dirCategoryIconLeft.setImageResource(com.martian.mibook.R.drawable.reader_icon_order_up);
            ReadingBookChapterListAdapter readingBookChapterListAdapter2 = this.chapterListAdapter;
            if (readingBookChapterListAdapter2 != null) {
                readingBookChapterListAdapter2.F(true);
            }
            linearLayoutManager.setReverseLayout(true);
            linearLayoutManager.setStackFromEnd(true);
        } else {
            ((FragmentReadingBookChapterListBinding) n()).dirCategory.setText(getString(com.martian.mibook.R.string.sequence_negative));
            ((FragmentReadingBookChapterListBinding) n()).dirCategoryIconLeft.setImageResource(com.martian.mibook.R.drawable.reader_icon_order_down);
            ReadingBookChapterListAdapter readingBookChapterListAdapter3 = this.chapterListAdapter;
            if (readingBookChapterListAdapter3 != null) {
                readingBookChapterListAdapter3.F(false);
            }
            linearLayoutManager.setReverseLayout(false);
            linearLayoutManager.setStackFromEnd(false);
        }
        ((FragmentReadingBookChapterListBinding) n()).rvChapterList.requestLayout();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void O0() {
        if (this.chapterListAdapter != null) {
            ((FragmentReadingBookChapterListBinding) n()).rvChapterList.post(new Runnable() { // from class: ed.x0
                public /* synthetic */ x0() {
                }

                @Override // java.lang.Runnable
                public final void run() {
                    ReadingChapterListFragment.P0(ReadingChapterListFragment.this);
                }
            });
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void P0(ReadingChapterListFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ReadingBookChapterListAdapter readingBookChapterListAdapter = this$0.chapterListAdapter;
        ((FragmentReadingBookChapterListBinding) this$0.n()).rvChapterList.smoothScrollToPosition(readingBookChapterListAdapter != null ? readingBookChapterListAdapter.u(this$0.I().getCom.martian.mibook.mvvm.tts.service.BaseReadAloudService.x java.lang.String()) : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void Q0() {
        MiReadingTheme k10 = MiConfigSingleton.b2().h2().k();
        ((FragmentReadingBookChapterListBinding) n()).floatingAction.setBackgroundTintList(ColorStateList.valueOf(Color.argb(128, Color.red(k10.getBackgroundColor()), Color.green(k10.getBackgroundColor()), Color.blue(k10.getBackgroundColor()))));
        Drawable drawable = ((FragmentReadingBookChapterListBinding) n()).floatingAction.getDrawable();
        if (drawable == null) {
            return;
        }
        drawable.setColorFilter(new PorterDuffColorFilter(k10.getTextColorPrimary(), PorterDuff.Mode.SRC_ATOP));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ FragmentReadingBookChapterListBinding r0(ReadingChapterListFragment readingChapterListFragment) {
        return (FragmentReadingBookChapterListBinding) readingChapterListFragment.n();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void L0(int startIndex, int cacheIndex) {
        ReadingBookChapterListAdapter readingBookChapterListAdapter = this.chapterListAdapter;
        if (readingBookChapterListAdapter != null) {
            readingBookChapterListAdapter.t(startIndex, cacheIndex);
        }
        ReadingBookChapterListAdapter readingBookChapterListAdapter2 = this.chapterListAdapter;
        if (readingBookChapterListAdapter2 != null) {
            readingBookChapterListAdapter2.r(((FragmentReadingBookChapterListBinding) n()).rvChapterList, 500L);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void R0(boolean enable) {
        ((FragmentReadingBookChapterListBinding) n()).rvChapterList.setNestedScrollingEnabled(enable);
    }

    @Override // com.martian.mibook.mvvm.base.BaseMVVMFragment
    public void i0() {
    }

    @Override // com.martian.mibook.mvvm.base.LazyFragment
    public void k() {
        super.k();
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getDefault(), null, new ReadingChapterListFragment$lazyLoad$1(this, null), 2, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.martian.mibook.mvvm.base.LazyFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        O0();
        ReadingBookChapterListAdapter readingBookChapterListAdapter = this.chapterListAdapter;
        if (readingBookChapterListAdapter != null) {
            readingBookChapterListAdapter.r(((FragmentReadingBookChapterListBinding) n()).rvChapterList, 500L);
        }
    }

    @Override // com.martian.mibook.mvvm.base.BaseFragment
    public void q(@l Bundle savedInstanceState) {
    }

    public final String y0() {
        if (I().getBook() == null || I().getChapterList() == null) {
            return "";
        }
        Book book = I().getBook();
        if (!ba.l.q(book != null ? book.getStatus() : null)) {
            Book book2 = I().getBook();
            String status = book2 != null ? book2.getStatus() : null;
            Intrinsics.checkNotNull(status);
            if (!StringsKt.contains$default((CharSequence) status, (CharSequence) Book.STATUS_FINISHED, false, 2, (Object) null)) {
                ChapterList chapterList = I().getChapterList();
                return "连载至" + (chapterList != null ? Integer.valueOf(chapterList.getCount()) : null) + "章";
            }
        }
        ChapterList chapterList2 = I().getChapterList();
        return "完结 共" + (chapterList2 != null ? Integer.valueOf(chapterList2.getCount()) : null) + "章";
    }

    @Override // com.martian.mibook.mvvm.base.BaseMVVMFragment
    @k
    /* renamed from: z0 */
    public ReadingViewModel I() {
        return (ReadingViewModel) this.mViewModel.getValue();
    }
}
