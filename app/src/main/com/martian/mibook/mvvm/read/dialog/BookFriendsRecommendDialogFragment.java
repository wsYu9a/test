package com.martian.mibook.mvvm.read.dialog;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.gyf.immersionbar.BarHide;
import com.gyf.immersionbar.d;
import com.martian.libmars.common.ConfigSingleton;
import com.martian.libmars.ui.theme.ThemeImageView;
import com.martian.libmars.ui.theme.ThemeLinearLayout;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.libmars.widget.dialog.MartianBottomSheetDialogFragment;
import com.martian.libmars.widget.dialog.a;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.databinding.DialogBookFriendsRecommendBinding;
import com.martian.mibook.lib.account.R;
import com.martian.mibook.lib.model.data.TYBookItem;
import com.martian.mibook.mvvm.extensions.ExtKt;
import com.martian.mibook.mvvm.net.result.TYBookTopUser;
import com.martian.mibook.mvvm.read.adapter.BookFriendsRecommendAdapter;
import com.martian.mibook.mvvm.read.dialog.BookFriendsRecommendDialogFragment;
import com.martian.mibook.mvvm.read.viewmodel.ReadingViewModel;
import com.martian.mibook.mvvm.read.widget.a;
import com.martian.mibook.mvvm.widget.HorizontalSpaceItemDecoration;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import l9.m0;
import l9.t0;
import oe.f;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 ,2\u00020\u0001:\u0001-B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J!\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\u000f\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0019\u0010\u0011\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0017¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0004H\u0003¢\u0006\u0004\b\u0013\u0010\u0003J\u000f\u0010\u0014\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0014\u0010\u0003J\u000f\u0010\u0015\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0015\u0010\u0003R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u001b\u0010#\u001a\u00020\u001e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u0018\u0010'\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010+\u001a\u0004\u0018\u00010(8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b)\u0010*¨\u0006."}, d2 = {"Lcom/martian/mibook/mvvm/read/dialog/BookFriendsRecommendDialogFragment;", "Lcom/martian/libmars/widget/dialog/MartianBottomSheetDialogFragment;", "<init>", "()V", "", "P", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "bottomSheet", "", "newState", "u", "(Landroid/view/View;I)V", "p", "(Landroid/view/View;)Landroid/view/View;", "X", ExifInterface.LONGITUDE_WEST, "U", "Lcom/martian/mibook/databinding/DialogBookFriendsRecommendBinding;", "f", "Lcom/martian/mibook/databinding/DialogBookFriendsRecommendBinding;", "binding", "", "g", "Z", "isExit", "Lcom/martian/mibook/mvvm/read/viewmodel/ReadingViewModel;", "h", "Lkotlin/Lazy;", "M", "()Lcom/martian/mibook/mvvm/read/viewmodel/ReadingViewModel;", "mViewModel", "Lcom/martian/mibook/mvvm/read/adapter/BookFriendsRecommendAdapter;", "i", "Lcom/martian/mibook/mvvm/read/adapter/BookFriendsRecommendAdapter;", "bookFriendsRecommendAdapter", "Lcom/martian/mibook/mvvm/read/widget/a;", "N", "()Lcom/martian/mibook/mvvm/read/widget/a;", "readMenuCallBack", "j", "a", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes3.dex */
public final class BookFriendsRecommendDialogFragment extends MartianBottomSheetDialogFragment {

    /* renamed from: j, reason: from kotlin metadata */
    @k
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: k */
    @k
    public static final String f14597k = "BookFriendsRecommendDialogFragment";

    /* renamed from: f, reason: from kotlin metadata */
    @l
    public DialogBookFriendsRecommendBinding binding;

    /* renamed from: g, reason: from kotlin metadata */
    public boolean isExit;

    /* renamed from: h, reason: from kotlin metadata */
    @k
    public final Lazy mViewModel = LazyKt.lazy(new Function0<ReadingViewModel>() { // from class: com.martian.mibook.mvvm.read.dialog.BookFriendsRecommendDialogFragment$mViewModel$2
        public BookFriendsRecommendDialogFragment$mViewModel$2() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @k
        public final ReadingViewModel invoke() {
            ViewModelStoreOwner activity = BookFriendsRecommendDialogFragment.this.getActivity();
            if (activity == null) {
                activity = BookFriendsRecommendDialogFragment.this;
            }
            return (ReadingViewModel) new ViewModelProvider(activity).get(ReadingViewModel.class);
        }
    });

    /* renamed from: i, reason: from kotlin metadata */
    @l
    public BookFriendsRecommendAdapter bookFriendsRecommendAdapter;

    /* renamed from: com.martian.mibook.mvvm.read.dialog.BookFriendsRecommendDialogFragment$a, reason: from kotlin metadata */
    public static final class Companion {

        /* renamed from: com.martian.mibook.mvvm.read.dialog.BookFriendsRecommendDialogFragment$a$a */
        public static final class C0534a implements MartianBottomSheetDialogFragment.b {
            @Override // com.martian.libmars.widget.dialog.MartianBottomSheetDialogFragment.b
            public void a(@k DialogFragment dialogFragment) {
                Intrinsics.checkNotNullParameter(dialogFragment, "dialogFragment");
                boolean A0 = MiConfigSingleton.b2().A0();
                d.y3(dialogFragment).W0(BarHide.FLAG_HIDE_NAVIGATION_BAR).T2(!A0).G1(!A0).v1(ConfigSingleton.D().L(), 0.0f).a1();
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @k
        public final BookFriendsRecommendDialogFragment a(@k FragmentActivity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Fragment findFragmentByTag = activity.getSupportFragmentManager().findFragmentByTag(BookFriendsRecommendDialogFragment.f14597k);
            DialogFragment dialogFragment = findFragmentByTag instanceof DialogFragment ? (DialogFragment) findFragmentByTag : null;
            if (dialogFragment != null && dialogFragment.isVisible()) {
                dialogFragment.dismiss();
            }
            a a10 = MartianBottomSheetDialogFragment.INSTANCE.a();
            BookFriendsRecommendDialogFragment bookFriendsRecommendDialogFragment = new BookFriendsRecommendDialogFragment();
            a10.k0(true).j0(true).w0(true).q0(ConfigSingleton.i(16.0f)).s0(new C0534a());
            ac.a.y(activity, "退出弹窗-展示");
            a10.c0(activity, bookFriendsRecommendDialogFragment, BookFriendsRecommendDialogFragment.f14597k, true);
            return bookFriendsRecommendDialogFragment;
        }

        public Companion() {
        }
    }

    public static final class b implements BookFriendsRecommendAdapter.a {
        public b() {
        }

        @Override // com.martian.mibook.mvvm.read.adapter.BookFriendsRecommendAdapter.a
        @SuppressLint({"NotifyDataSetChanged", "SetTextI18n"})
        public void a(@l TYBookItem tYBookItem, @k TextView tvAddBookShelf, @k BookFriendsRecommendAdapter.ViewType viewType) {
            Intrinsics.checkNotNullParameter(tvAddBookShelf, "tvAddBookShelf");
            Intrinsics.checkNotNullParameter(viewType, "viewType");
            Context context = BookFriendsRecommendDialogFragment.this.getContext();
            Activity activity = context instanceof Activity ? (Activity) context : null;
            BookFriendsRecommendDialogFragment bookFriendsRecommendDialogFragment = BookFriendsRecommendDialogFragment.this;
            ac.a.y(bookFriendsRecommendDialogFragment.getActivity(), "退出弹窗-加书架");
            MiConfigSingleton.b2().M1().g(activity, tYBookItem);
            if (tYBookItem != null) {
                tYBookItem.setInBookStore(true);
            }
            t0.b(bookFriendsRecommendDialogFragment.getContext(), "已加入书架");
            if (viewType == BookFriendsRecommendAdapter.ViewType.TYPE_PAGE_RECOMMEND) {
                tvAddBookShelf.setVisibility(8);
            } else {
                tvAddBookShelf.setText(ExtKt.c("已在书架"));
            }
        }
    }

    private final ReadingViewModel M() {
        return (ReadingViewModel) this.mViewModel.getValue();
    }

    public static final boolean O(BookFriendsRecommendDialogFragment this$0, View view, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (motionEvent.getAction() != 1) {
            return false;
        }
        this$0.dismiss();
        com.martian.mibook.mvvm.read.widget.a N = this$0.N();
        if (N == null) {
            return false;
        }
        a.C0540a.b(N, null, 1, null);
        return false;
    }

    private final void P() {
        ThemeTextView themeTextView;
        ThemeLinearLayout themeLinearLayout;
        ThemeImageView themeImageView;
        DialogBookFriendsRecommendBinding dialogBookFriendsRecommendBinding = this.binding;
        if (dialogBookFriendsRecommendBinding != null && (themeImageView = dialogBookFriendsRecommendBinding.ivClose) != null) {
            themeImageView.setOnClickListener(new View.OnClickListener() { // from class: dd.a
                public /* synthetic */ a() {
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    BookFriendsRecommendDialogFragment.Q(BookFriendsRecommendDialogFragment.this, view);
                }
            });
        }
        DialogBookFriendsRecommendBinding dialogBookFriendsRecommendBinding2 = this.binding;
        if (dialogBookFriendsRecommendBinding2 != null && (themeLinearLayout = dialogBookFriendsRecommendBinding2.llExitReading) != null) {
            themeLinearLayout.setOnClickListener(new View.OnClickListener() { // from class: dd.b
                public /* synthetic */ b() {
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    BookFriendsRecommendDialogFragment.R(BookFriendsRecommendDialogFragment.this, view);
                }
            });
        }
        DialogBookFriendsRecommendBinding dialogBookFriendsRecommendBinding3 = this.binding;
        if (dialogBookFriendsRecommendBinding3 != null && (themeTextView = dialogBookFriendsRecommendBinding3.tvSwitchBook) != null) {
            themeTextView.setOnClickListener(new View.OnClickListener() { // from class: dd.c
                public /* synthetic */ c() {
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    BookFriendsRecommendDialogFragment.S(BookFriendsRecommendDialogFragment.this, view);
                }
            });
        }
        M().K0().observe(this, new Observer() { // from class: dd.d
            public /* synthetic */ d() {
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                BookFriendsRecommendDialogFragment.T(Function1.this, obj);
            }
        });
    }

    public static final void Q(BookFriendsRecommendDialogFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismiss();
    }

    public static final void R(BookFriendsRecommendDialogFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.U();
    }

    public static final void S(BookFriendsRecommendDialogFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ac.a.y(this$0.getActivity(), "退出弹窗-换一换");
        this$0.W();
    }

    public static final void T(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @JvmStatic
    @k
    public static final BookFriendsRecommendDialogFragment Y(@k FragmentActivity fragmentActivity) {
        return INSTANCE.a(fragmentActivity);
    }

    public final com.martian.mibook.mvvm.read.widget.a N() {
        Object context = getContext();
        if (context instanceof com.martian.mibook.mvvm.read.widget.a) {
            return (com.martian.mibook.mvvm.read.widget.a) context;
        }
        return null;
    }

    public final void U() {
        this.isExit = true;
        dismiss();
        com.martian.mibook.mvvm.read.widget.a N = N();
        if (N != null) {
            N.v();
        }
    }

    public final void W() {
        M().f0(true, true);
    }

    @SuppressLint({"SetTextI18n"})
    public final void X() {
        Integer duration;
        if (this.bookFriendsRecommendAdapter == null) {
            BookFriendsRecommendAdapter bookFriendsRecommendAdapter = new BookFriendsRecommendAdapter();
            this.bookFriendsRecommendAdapter = bookFriendsRecommendAdapter;
            DialogBookFriendsRecommendBinding dialogBookFriendsRecommendBinding = this.binding;
            RecyclerView recyclerView = dialogBookFriendsRecommendBinding != null ? dialogBookFriendsRecommendBinding.rvBooks : null;
            if (recyclerView != null) {
                recyclerView.setAdapter(bookFriendsRecommendAdapter);
            }
            BookFriendsRecommendAdapter bookFriendsRecommendAdapter2 = this.bookFriendsRecommendAdapter;
            if (bookFriendsRecommendAdapter2 != null) {
                bookFriendsRecommendAdapter2.o(new b());
            }
        }
        TYBookTopUser tyBookTopUser = M().getTyBookTopUser();
        M().q3(null);
        Context context = getContext();
        String header = tyBookTopUser != null ? tyBookTopUser.getHeader() : null;
        DialogBookFriendsRecommendBinding dialogBookFriendsRecommendBinding2 = this.binding;
        m0.l(context, header, dialogBookFriendsRecommendBinding2 != null ? dialogBookFriendsRecommendBinding2.ivAvatar : null, R.drawable.day_img_heads);
        DialogBookFriendsRecommendBinding dialogBookFriendsRecommendBinding3 = this.binding;
        ThemeTextView themeTextView = dialogBookFriendsRecommendBinding3 != null ? dialogBookFriendsRecommendBinding3.tvDes : null;
        if (themeTextView != null) {
            String nickname = tyBookTopUser != null ? tyBookTopUser.getNickname() : null;
            themeTextView.setText(ExtKt.c(nickname + "·阅读本书" + f.a((tyBookTopUser == null || (duration = tyBookTopUser.getDuration()) == null) ? 0 : duration.intValue()) + "·TA还看了"));
        }
        BookFriendsRecommendAdapter bookFriendsRecommendAdapter3 = this.bookFriendsRecommendAdapter;
        if (bookFriendsRecommendAdapter3 != null) {
            bookFriendsRecommendAdapter3.p(tyBookTopUser != null ? tyBookTopUser.getReadBooks() : null, BookFriendsRecommendAdapter.ViewType.TYPE_DIALOG_RECOMMEND);
        }
    }

    @Override // com.martian.libmars.widget.dialog.MartianBottomSheetDialogFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@k View view, @l Bundle savedInstanceState) {
        Window window;
        Intrinsics.checkNotNullParameter(view, "view");
        Dialog dialog = getDialog();
        if (dialog != null && (window = dialog.getWindow()) != null) {
            window.addFlags(512);
        }
        super.onViewCreated(view, savedInstanceState);
    }

    @Override // com.martian.libmars.widget.dialog.MartianBottomSheetDialogFragment
    @l
    @SuppressLint({"InflateParams", "ClickableViewAccessibility"})
    public View p(@k View view) {
        RecyclerView recyclerView;
        Intrinsics.checkNotNullParameter(view, "view");
        View inflate = LayoutInflater.from(getContext()).inflate(com.martian.mibook.R.layout.dialog_book_friends_recommend, (ViewGroup) null);
        this.binding = DialogBookFriendsRecommendBinding.bind(inflate);
        view.setOnTouchListener(new View.OnTouchListener() { // from class: dd.e
            public /* synthetic */ e() {
            }

            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view2, MotionEvent motionEvent) {
                boolean O;
                O = BookFriendsRecommendDialogFragment.O(BookFriendsRecommendDialogFragment.this, view2, motionEvent);
                return O;
            }
        });
        DialogBookFriendsRecommendBinding dialogBookFriendsRecommendBinding = this.binding;
        RecyclerView recyclerView2 = dialogBookFriendsRecommendBinding != null ? dialogBookFriendsRecommendBinding.rvBooks : null;
        if (recyclerView2 != null) {
            recyclerView2.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        }
        int i10 = ConfigSingleton.i(12.0f);
        DialogBookFriendsRecommendBinding dialogBookFriendsRecommendBinding2 = this.binding;
        if (dialogBookFriendsRecommendBinding2 != null && (recyclerView = dialogBookFriendsRecommendBinding2.rvBooks) != null) {
            recyclerView.addItemDecoration(new HorizontalSpaceItemDecoration(i10));
        }
        P();
        return inflate;
    }

    @Override // com.martian.libmars.widget.dialog.MartianBottomSheetDialogFragment
    public void u(@k View bottomSheet, int newState) {
        Intrinsics.checkNotNullParameter(bottomSheet, "bottomSheet");
        super.u(bottomSheet, newState);
        if ((newState == 4 || newState == 5) && !this.isExit) {
            M().e2(1);
        }
    }
}
