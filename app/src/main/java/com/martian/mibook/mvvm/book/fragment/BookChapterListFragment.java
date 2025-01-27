package com.martian.mibook.mvvm.book.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ba.m;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.gyf.immersionbar.d;
import com.martian.libmars.R;
import com.martian.libmars.common.ConfigSingleton;
import com.martian.libmars.ui.theme.ThemeImageView;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.libmars.widget.dialog.MartianBottomSheetDialogFragment;
import com.martian.libmars.widget.dialog.a;
import com.martian.libmars.widget.recyclerview.LoadingTip;
import com.martian.libmars.widget.scroller.FastScrollRecyclerView;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.databinding.DialogBookChapterListBinding;
import com.martian.mibook.lib.model.data.abs.ChapterList;
import com.martian.mibook.mvvm.book.adapter.BookChapterListAdapter;
import com.martian.mibook.mvvm.book.fragment.BookChapterListFragment;
import com.martian.mibook.mvvm.book.viewmodel.BookViewModel;
import com.martian.mibook.mvvm.ui.viewmodel.AppViewModel;
import com.martian.mibook.mvvm.widget.SmartScrollLayoutManager;
import java.util.ArrayList;
import je.i;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import lc.b;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 &2\u00020\u0001:\u0001'B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0003J\u000f\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\u0003J\u0019\u0010\n\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\bH\u0017¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\u000e\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0010\u0010\u0003J\u000f\u0010\u0011\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0011\u0010\u0003J\u000f\u0010\u0012\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0012\u0010\u0003R\u001b\u0010\u0018\u001a\u00020\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001d\u0010\u001d\u001a\u0004\u0018\u00010\u00198BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u0015\u001a\u0004\b\u001b\u0010\u001cR\u0018\u0010!\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0018\u0010%\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010$¨\u0006("}, d2 = {"Lcom/martian/mibook/mvvm/book/fragment/BookChapterListFragment;", "Lcom/martian/libmars/widget/dialog/MartianBottomSheetDialogFragment;", "<init>", "()V", "", ExifInterface.GPS_DIRECTION_TRUE, "a0", ExifInterface.LATITUDE_SOUTH, "Landroid/view/View;", "view", "p", "(Landroid/view/View;)Landroid/view/View;", "Lcom/martian/mibook/lib/model/data/abs/ChapterList;", "chapterList", "f0", "(Lcom/martian/mibook/lib/model/data/abs/ChapterList;)V", "b0", "g0", "d0", "Lcom/martian/mibook/mvvm/book/viewmodel/BookViewModel;", "f", "Lkotlin/Lazy;", "R", "()Lcom/martian/mibook/mvvm/book/viewmodel/BookViewModel;", "mViewModel", "Lcom/martian/mibook/mvvm/ui/viewmodel/AppViewModel;", "g", "Q", "()Lcom/martian/mibook/mvvm/ui/viewmodel/AppViewModel;", "appViewModel", "Lcom/martian/mibook/databinding/DialogBookChapterListBinding;", "h", "Lcom/martian/mibook/databinding/DialogBookChapterListBinding;", "binding", "Lcom/martian/mibook/mvvm/book/adapter/BookChapterListAdapter;", "i", "Lcom/martian/mibook/mvvm/book/adapter/BookChapterListAdapter;", "chapterListAdapter", "j", "a", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes3.dex */
public final class BookChapterListFragment extends MartianBottomSheetDialogFragment {

    /* renamed from: j, reason: from kotlin metadata */
    @k
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: k */
    @k
    public static final String f14133k = "BookChapterListFragment";

    /* renamed from: f, reason: from kotlin metadata */
    @k
    public final Lazy mViewModel = LazyKt.lazy(new Function0<BookViewModel>() { // from class: com.martian.mibook.mvvm.book.fragment.BookChapterListFragment$mViewModel$2
        public BookChapterListFragment$mViewModel$2() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @k
        public final BookViewModel invoke() {
            ViewModelStoreOwner activity = BookChapterListFragment.this.getActivity();
            if (activity == null) {
                activity = BookChapterListFragment.this;
            }
            return (BookViewModel) new ViewModelProvider(activity).get(BookViewModel.class);
        }
    });

    /* renamed from: g, reason: from kotlin metadata */
    @k
    public final Lazy appViewModel = LazyKt.lazy(new Function0<AppViewModel>() { // from class: com.martian.mibook.mvvm.book.fragment.BookChapterListFragment$appViewModel$2
        public BookChapterListFragment$appViewModel$2() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @l
        public final AppViewModel invoke() {
            return b.a(BookChapterListFragment.this.getActivity());
        }
    });

    /* renamed from: h, reason: from kotlin metadata */
    @l
    public DialogBookChapterListBinding binding;

    /* renamed from: i, reason: from kotlin metadata */
    @l
    public BookChapterListAdapter chapterListAdapter;

    /* renamed from: com.martian.mibook.mvvm.book.fragment.BookChapterListFragment$a, reason: from kotlin metadata */
    public static final class Companion {

        /* renamed from: com.martian.mibook.mvvm.book.fragment.BookChapterListFragment$a$a */
        public static final class C0531a implements MartianBottomSheetDialogFragment.b {
            @Override // com.martian.libmars.widget.dialog.MartianBottomSheetDialogFragment.b
            public void a(@k DialogFragment dialogFragment) {
                Intrinsics.checkNotNullParameter(dialogFragment, "dialogFragment");
                boolean A0 = MiConfigSingleton.b2().A0();
                d.y3(dialogFragment).T2(!A0).G1(!A0).v1(ConfigSingleton.D().L(), 0.0f).a1();
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @k
        public final DialogFragment a(@k FragmentActivity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            a a10 = MartianBottomSheetDialogFragment.INSTANCE.a();
            a10.k0(true).j0(true).n0(m.h(activity) - ConfigSingleton.i(180.0f)).s0(new C0531a());
            BookChapterListFragment bookChapterListFragment = new BookChapterListFragment();
            a10.c0(activity, bookChapterListFragment, BookChapterListFragment.f14133k, true);
            return bookChapterListFragment;
        }

        public Companion() {
        }
    }

    public static final class b implements BookChapterListAdapter.a {
        public b() {
        }

        @Override // com.martian.mibook.mvvm.book.adapter.BookChapterListAdapter.a
        public void a(int i10) {
            BookChapterListAdapter bookChapterListAdapter = BookChapterListFragment.this.chapterListAdapter;
            if (bookChapterListAdapter != null) {
                bookChapterListAdapter.z(i10);
            }
            BookChapterListFragment.this.dismiss();
            i.S(BookChapterListFragment.this.getActivity(), BookChapterListFragment.this.R().getBook(), Integer.valueOf(i10), 0, 0, false);
        }
    }

    private final AppViewModel Q() {
        return (AppViewModel) this.appViewModel.getValue();
    }

    private final void S() {
        R().t();
    }

    private final void T() {
        MutableLiveData<Unit> h02;
        DialogBookChapterListBinding dialogBookChapterListBinding = this.binding;
        if (dialogBookChapterListBinding != null) {
            dialogBookChapterListBinding.ivClose.setOnClickListener(new View.OnClickListener() { // from class: oc.b
                public /* synthetic */ b() {
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    BookChapterListFragment.U(BookChapterListFragment.this, view);
                }
            });
            dialogBookChapterListBinding.rvChapterList.setNestedScrollingEnabled(true);
            dialogBookChapterListBinding.rvChapterList.setHandleDrawable(R.drawable.icon_fastscroll_day);
            dialogBookChapterListBinding.rvChapterList.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.martian.mibook.mvvm.book.fragment.BookChapterListFragment$initListener$1$2

                /* renamed from: u */
                public final /* synthetic */ BookChapterListFragment f14140u;

                public BookChapterListFragment$initListener$1$2(BookChapterListFragment this) {
                    this = this;
                }

                @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
                public void onScrollStateChanged(@k RecyclerView recyclerView, int newState) {
                    Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
                    super.onScrollStateChanged(recyclerView, newState);
                    if (newState != 0) {
                        if (newState == 1 || newState == 2) {
                            DialogBookChapterListBinding.this.floatingAction.setAlpha(0.4f);
                            return;
                        }
                        return;
                    }
                    DialogBookChapterListBinding.this.floatingAction.setAlpha(1.0f);
                    BookChapterListAdapter bookChapterListAdapter = this.chapterListAdapter;
                    if (bookChapterListAdapter != null) {
                        BookChapterListAdapter.q(bookChapterListAdapter, recyclerView, 0L, 2, null);
                    }
                }
            });
            dialogBookChapterListBinding.llOrderView.setOnClickListener(new View.OnClickListener() { // from class: oc.c
                public /* synthetic */ c() {
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    BookChapterListFragment.W(BookChapterListFragment.this, view);
                }
            });
            dialogBookChapterListBinding.floatingAction.setOnClickListener(new View.OnClickListener() { // from class: oc.d
                public /* synthetic */ d() {
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    BookChapterListFragment.X(BookChapterListFragment.this, view);
                }
            });
        }
        R().A().observe(this, new Observer() { // from class: oc.e
            public /* synthetic */ e() {
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                BookChapterListFragment.Y(Function1.this, obj);
            }
        });
        AppViewModel Q = Q();
        if (Q == null || (h02 = Q.h0()) == null) {
            return;
        }
        h02.observe(this, new Observer() { // from class: oc.f
            public /* synthetic */ f() {
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                BookChapterListFragment.Z(Function1.this, obj);
            }
        });
    }

    public static final void U(BookChapterListFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismiss();
    }

    public static final void W(BookChapterListFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.b0();
    }

    public static final void X(BookChapterListFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.d0();
    }

    public static final void Y(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void Z(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void a0() {
        LoadingTip loadingTip;
        DialogBookChapterListBinding dialogBookChapterListBinding = this.binding;
        ConstraintLayout constraintLayout = dialogBookChapterListBinding != null ? dialogBookChapterListBinding.clChapterList : null;
        if (constraintLayout != null) {
            constraintLayout.setVisibility(8);
        }
        DialogBookChapterListBinding dialogBookChapterListBinding2 = this.binding;
        if (dialogBookChapterListBinding2 != null && (loadingTip = dialogBookChapterListBinding2.loadedTip) != null) {
            loadingTip.setLoadingTip(LoadingTip.LoadStatus.loading);
        }
        DialogBookChapterListBinding dialogBookChapterListBinding3 = this.binding;
        FastScrollRecyclerView fastScrollRecyclerView = dialogBookChapterListBinding3 != null ? dialogBookChapterListBinding3.rvChapterList : null;
        if (fastScrollRecyclerView != null) {
            Context context = getContext();
            Intrinsics.checkNotNull(context);
            fastScrollRecyclerView.setLayoutManager(new SmartScrollLayoutManager(context, 0, false, 6, null));
        }
        BookChapterListAdapter bookChapterListAdapter = new BookChapterListAdapter();
        this.chapterListAdapter = bookChapterListAdapter;
        DialogBookChapterListBinding dialogBookChapterListBinding4 = this.binding;
        FastScrollRecyclerView fastScrollRecyclerView2 = dialogBookChapterListBinding4 != null ? dialogBookChapterListBinding4.rvChapterList : null;
        if (fastScrollRecyclerView2 != null) {
            fastScrollRecyclerView2.setAdapter(bookChapterListAdapter);
        }
        g0();
        BookChapterListAdapter bookChapterListAdapter2 = this.chapterListAdapter;
        if (bookChapterListAdapter2 != null) {
            bookChapterListAdapter2.B(new b());
        }
    }

    public static final void e0(BookChapterListFragment this$0) {
        FastScrollRecyclerView fastScrollRecyclerView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int y10 = this$0.R().y();
        DialogBookChapterListBinding dialogBookChapterListBinding = this$0.binding;
        if (dialogBookChapterListBinding == null || (fastScrollRecyclerView = dialogBookChapterListBinding.rvChapterList) == null) {
            return;
        }
        fastScrollRecyclerView.smoothScrollToPosition(y10);
    }

    @JvmStatic
    @k
    public static final DialogFragment h0(@k FragmentActivity fragmentActivity) {
        return INSTANCE.a(fragmentActivity);
    }

    public final BookViewModel R() {
        return (BookViewModel) this.mViewModel.getValue();
    }

    public final void b0() {
        ThemeTextView themeTextView;
        ThemeImageView themeImageView;
        FastScrollRecyclerView fastScrollRecyclerView;
        ThemeImageView themeImageView2;
        FastScrollRecyclerView fastScrollRecyclerView2;
        DialogBookChapterListBinding dialogBookChapterListBinding = this.binding;
        RecyclerView.LayoutManager layoutManager = (dialogBookChapterListBinding == null || (fastScrollRecyclerView2 = dialogBookChapterListBinding.rvChapterList) == null) ? null : fastScrollRecyclerView2.getLayoutManager();
        LinearLayoutManager linearLayoutManager = layoutManager instanceof LinearLayoutManager ? (LinearLayoutManager) layoutManager : null;
        BookChapterListAdapter bookChapterListAdapter = this.chapterListAdapter;
        if (bookChapterListAdapter == null || !bookChapterListAdapter.getIsReverseOrder()) {
            DialogBookChapterListBinding dialogBookChapterListBinding2 = this.binding;
            themeTextView = dialogBookChapterListBinding2 != null ? dialogBookChapterListBinding2.tvOrder : null;
            if (themeTextView != null) {
                themeTextView.setText(getString(com.martian.mibook.R.string.sequence_positive));
            }
            DialogBookChapterListBinding dialogBookChapterListBinding3 = this.binding;
            if (dialogBookChapterListBinding3 != null && (themeImageView = dialogBookChapterListBinding3.ivOrderIcon) != null) {
                themeImageView.setImageResource(com.martian.mibook.R.drawable.reader_icon_order_up);
            }
            BookChapterListAdapter bookChapterListAdapter2 = this.chapterListAdapter;
            if (bookChapterListAdapter2 != null) {
                bookChapterListAdapter2.C(true);
            }
            if (linearLayoutManager != null) {
                linearLayoutManager.setReverseLayout(true);
            }
            if (linearLayoutManager != null) {
                linearLayoutManager.setStackFromEnd(true);
            }
        } else {
            DialogBookChapterListBinding dialogBookChapterListBinding4 = this.binding;
            themeTextView = dialogBookChapterListBinding4 != null ? dialogBookChapterListBinding4.tvOrder : null;
            if (themeTextView != null) {
                themeTextView.setText(getString(com.martian.mibook.R.string.sequence_negative));
            }
            DialogBookChapterListBinding dialogBookChapterListBinding5 = this.binding;
            if (dialogBookChapterListBinding5 != null && (themeImageView2 = dialogBookChapterListBinding5.ivOrderIcon) != null) {
                themeImageView2.setImageResource(com.martian.mibook.R.drawable.reader_icon_order_down);
            }
            BookChapterListAdapter bookChapterListAdapter3 = this.chapterListAdapter;
            if (bookChapterListAdapter3 != null) {
                bookChapterListAdapter3.C(false);
            }
            if (linearLayoutManager != null) {
                linearLayoutManager.setReverseLayout(false);
            }
            if (linearLayoutManager != null) {
                linearLayoutManager.setStackFromEnd(false);
            }
        }
        DialogBookChapterListBinding dialogBookChapterListBinding6 = this.binding;
        if (dialogBookChapterListBinding6 == null || (fastScrollRecyclerView = dialogBookChapterListBinding6.rvChapterList) == null) {
            return;
        }
        fastScrollRecyclerView.requestLayout();
    }

    public final void d0() {
        DialogBookChapterListBinding dialogBookChapterListBinding;
        FastScrollRecyclerView fastScrollRecyclerView;
        if (this.chapterListAdapter == null || (dialogBookChapterListBinding = this.binding) == null || (fastScrollRecyclerView = dialogBookChapterListBinding.rvChapterList) == null) {
            return;
        }
        fastScrollRecyclerView.post(new Runnable() { // from class: oc.a
            public /* synthetic */ a() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                BookChapterListFragment.e0(BookChapterListFragment.this);
            }
        });
    }

    @SuppressLint({"SetTextI18n"})
    public final void f0(ChapterList chapterList) {
        ThemeImageView themeImageView;
        LoadingTip loadingTip;
        LoadingTip loadingTip2;
        ArrayList arrayList = new ArrayList();
        if (chapterList != null) {
            int count = chapterList.getCount();
            for (int i10 = 0; i10 < count; i10++) {
                arrayList.add(chapterList.getItem(i10));
            }
        }
        DialogBookChapterListBinding dialogBookChapterListBinding = this.binding;
        ThemeTextView themeTextView = dialogBookChapterListBinding != null ? dialogBookChapterListBinding.tvTitle : null;
        if (themeTextView != null) {
            themeTextView.setText(getString(com.martian.mibook.R.string.open_dir) + (arrayList.size() > 0 ? " · " + arrayList.size() + "章" : ""));
        }
        if (arrayList.isEmpty()) {
            DialogBookChapterListBinding dialogBookChapterListBinding2 = this.binding;
            if (dialogBookChapterListBinding2 == null || (loadingTip2 = dialogBookChapterListBinding2.loadedTip) == null) {
                return;
            }
            loadingTip2.setLoadingTip(LoadingTip.LoadStatus.empty);
            return;
        }
        DialogBookChapterListBinding dialogBookChapterListBinding3 = this.binding;
        if (dialogBookChapterListBinding3 != null && (loadingTip = dialogBookChapterListBinding3.loadedTip) != null) {
            loadingTip.setLoadingTip(LoadingTip.LoadStatus.finish);
        }
        DialogBookChapterListBinding dialogBookChapterListBinding4 = this.binding;
        ConstraintLayout constraintLayout = dialogBookChapterListBinding4 != null ? dialogBookChapterListBinding4.clChapterList : null;
        if (constraintLayout != null) {
            constraintLayout.setVisibility(0);
        }
        BookChapterListAdapter bookChapterListAdapter = this.chapterListAdapter;
        if (bookChapterListAdapter != null) {
            bookChapterListAdapter.D(arrayList, R().y(), R().getBook());
        }
        d0();
        DialogBookChapterListBinding dialogBookChapterListBinding5 = this.binding;
        ThemeTextView themeTextView2 = dialogBookChapterListBinding5 != null ? dialogBookChapterListBinding5.tvOrder : null;
        if (themeTextView2 != null) {
            themeTextView2.setText(getString(com.martian.mibook.R.string.sequence_negative));
        }
        DialogBookChapterListBinding dialogBookChapterListBinding6 = this.binding;
        if (dialogBookChapterListBinding6 != null && (themeImageView = dialogBookChapterListBinding6.ivOrderIcon) != null) {
            themeImageView.setImageResource(com.martian.mibook.R.drawable.reader_icon_order_down);
        }
        BookChapterListAdapter bookChapterListAdapter2 = this.chapterListAdapter;
        if (bookChapterListAdapter2 != null) {
            DialogBookChapterListBinding dialogBookChapterListBinding7 = this.binding;
            bookChapterListAdapter2.p(dialogBookChapterListBinding7 != null ? dialogBookChapterListBinding7.rvChapterList : null, 500L);
        }
    }

    public final void g0() {
        FloatingActionButton floatingActionButton;
        int n10 = ConfigSingleton.D().n();
        int argb = Color.argb(128, Color.red(n10), Color.green(n10), Color.blue(n10));
        DialogBookChapterListBinding dialogBookChapterListBinding = this.binding;
        Drawable drawable = null;
        FloatingActionButton floatingActionButton2 = dialogBookChapterListBinding != null ? dialogBookChapterListBinding.floatingAction : null;
        if (floatingActionButton2 != null) {
            floatingActionButton2.setBackgroundTintList(ColorStateList.valueOf(argb));
        }
        DialogBookChapterListBinding dialogBookChapterListBinding2 = this.binding;
        if (dialogBookChapterListBinding2 != null && (floatingActionButton = dialogBookChapterListBinding2.floatingAction) != null) {
            drawable = floatingActionButton.getDrawable();
        }
        if (drawable == null) {
            return;
        }
        drawable.setColorFilter(new PorterDuffColorFilter(ConfigSingleton.D().h0(), PorterDuff.Mode.SRC_ATOP));
    }

    @Override // com.martian.libmars.widget.dialog.MartianBottomSheetDialogFragment
    @l
    @SuppressLint({"InflateParams"})
    public View p(@k View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        View inflate = LayoutInflater.from(getContext()).inflate(com.martian.mibook.R.layout.dialog_book_chapter_list, (ViewGroup) null);
        this.binding = DialogBookChapterListBinding.bind(inflate);
        T();
        a0();
        S();
        return inflate;
    }
}
