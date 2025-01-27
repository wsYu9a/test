package com.martian.mibook.mvvm.read.dialog;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import be.m;
import com.gyf.immersionbar.BarHide;
import com.gyf.immersionbar.d;
import com.martian.libmars.common.ConfigSingleton;
import com.martian.libmars.ui.theme.ThemeImageView;
import com.martian.libmars.ui.theme.ThemeLinearLayout;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.libmars.widget.dialog.MartianBottomSheetDialogFragment;
import com.martian.libmars.widget.dialog.a;
import com.martian.mibook.R;
import com.martian.mibook.application.MiBookManager;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.application.ReadingInstance;
import com.martian.mibook.databinding.DialogReadingExitAddShelfRecommendBinding;
import com.martian.mibook.lib.model.data.TYBookItem;
import com.martian.mibook.lib.model.data.abs.Book;
import com.martian.mibook.mvvm.base.BaseActivity;
import com.martian.mibook.mvvm.read.dialog.ReadingAddShelfRecommendBooksDialogFragment;
import com.martian.mibook.mvvm.read.viewmodel.ReadingViewModel;
import com.martian.mibook.mvvm.read.widget.a;
import com.martian.mibook.ui.MyGridView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 -2\u00020\u0001:\u0001.B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0003¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0003J\u000f\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\u0003J\u000f\u0010\b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\b\u0010\u0003J\u000f\u0010\t\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\t\u0010\u0003J!\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0010\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\nH\u0017¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010!R\u001b\u0010(\u001a\u00020#8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u0016\u0010,\u001a\u0004\u0018\u00010)8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b*\u0010+¨\u0006/"}, d2 = {"Lcom/martian/mibook/mvvm/read/dialog/ReadingAddShelfRecommendBooksDialogFragment;", "Lcom/martian/libmars/widget/dialog/MartianBottomSheetDialogFragment;", "<init>", "()V", "", ExifInterface.LATITUDE_SOUTH, ExifInterface.GPS_DIRECTION_TRUE, "d0", "b0", "a0", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "p", "(Landroid/view/View;)Landroid/view/View;", "bottomSheet", "", "newState", "u", "(Landroid/view/View;I)V", "Lbe/m;", "f", "Lbe/m;", "bookCoverGridAdapter", "Lcom/martian/mibook/databinding/DialogReadingExitAddShelfRecommendBinding;", "g", "Lcom/martian/mibook/databinding/DialogReadingExitAddShelfRecommendBinding;", "binding", "", "h", "Z", "isExit", "Lcom/martian/mibook/mvvm/read/viewmodel/ReadingViewModel;", "i", "Lkotlin/Lazy;", "N", "()Lcom/martian/mibook/mvvm/read/viewmodel/ReadingViewModel;", "mViewModel", "Lcom/martian/mibook/mvvm/read/widget/a;", "O", "()Lcom/martian/mibook/mvvm/read/widget/a;", "readMenuCallBack", "j", "a", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes3.dex */
public final class ReadingAddShelfRecommendBooksDialogFragment extends MartianBottomSheetDialogFragment {

    /* renamed from: j, reason: from kotlin metadata */
    @k
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: k */
    @k
    public static final String f14609k = "ReadingAddShelfRecommendBooksDialogFragment";

    /* renamed from: f, reason: from kotlin metadata */
    @l
    public m bookCoverGridAdapter;

    /* renamed from: g, reason: from kotlin metadata */
    @l
    public DialogReadingExitAddShelfRecommendBinding binding;

    /* renamed from: h, reason: from kotlin metadata */
    public boolean isExit;

    /* renamed from: i, reason: from kotlin metadata */
    @k
    public final Lazy mViewModel = LazyKt.lazy(new Function0<ReadingViewModel>() { // from class: com.martian.mibook.mvvm.read.dialog.ReadingAddShelfRecommendBooksDialogFragment$mViewModel$2
        public ReadingAddShelfRecommendBooksDialogFragment$mViewModel$2() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @k
        public final ReadingViewModel invoke() {
            ViewModelStoreOwner activity = ReadingAddShelfRecommendBooksDialogFragment.this.getActivity();
            if (activity == null) {
                activity = ReadingAddShelfRecommendBooksDialogFragment.this;
            }
            return (ReadingViewModel) new ViewModelProvider(activity).get(ReadingViewModel.class);
        }
    });

    /* renamed from: com.martian.mibook.mvvm.read.dialog.ReadingAddShelfRecommendBooksDialogFragment$a, reason: from kotlin metadata */
    public static final class Companion {

        /* renamed from: com.martian.mibook.mvvm.read.dialog.ReadingAddShelfRecommendBooksDialogFragment$a$a */
        public static final class C0535a implements MartianBottomSheetDialogFragment.b {
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
        public final void b(@l Context context, @l ReadingViewModel readingViewModel) {
            if (readingViewModel != null) {
                readingViewModel.t0(c(context));
            }
        }

        @JvmStatic
        public final int c(Context context) {
            return (context == null || ReadingInstance.z().O(context)) ? 3 : 6;
        }

        @JvmStatic
        @k
        public final ReadingAddShelfRecommendBooksDialogFragment d(@k FragmentActivity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Fragment findFragmentByTag = activity.getSupportFragmentManager().findFragmentByTag(ReadingAddShelfRecommendBooksDialogFragment.f14609k);
            DialogFragment dialogFragment = findFragmentByTag instanceof DialogFragment ? (DialogFragment) findFragmentByTag : null;
            if (dialogFragment != null && dialogFragment.isVisible()) {
                dialogFragment.dismiss();
            }
            a a10 = MartianBottomSheetDialogFragment.INSTANCE.a();
            ReadingAddShelfRecommendBooksDialogFragment readingAddShelfRecommendBooksDialogFragment = new ReadingAddShelfRecommendBooksDialogFragment();
            a10.k0(true).j0(true).w0(true).q0(ConfigSingleton.i(12.0f)).s0(new C0535a());
            a10.c0(activity, readingAddShelfRecommendBooksDialogFragment, ReadingAddShelfRecommendBooksDialogFragment.f14609k, true);
            return readingAddShelfRecommendBooksDialogFragment;
        }

        public Companion() {
        }
    }

    private final ReadingViewModel N() {
        return (ReadingViewModel) this.mViewModel.getValue();
    }

    private final com.martian.mibook.mvvm.read.widget.a O() {
        Object context = getContext();
        if (context instanceof com.martian.mibook.mvvm.read.widget.a) {
            return (com.martian.mibook.mvvm.read.widget.a) context;
        }
        return null;
    }

    @JvmStatic
    public static final void P(@l Context context, @l ReadingViewModel readingViewModel) {
        INSTANCE.b(context, readingViewModel);
    }

    @JvmStatic
    private static final int Q(Context context) {
        return INSTANCE.c(context);
    }

    public static final boolean R(ReadingAddShelfRecommendBooksDialogFragment this$0, View view, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (motionEvent.getAction() != 1) {
            return false;
        }
        this$0.dismiss();
        com.martian.mibook.mvvm.read.widget.a O = this$0.O();
        if (O == null) {
            return false;
        }
        a.C0540a.b(O, null, 1, null);
        return false;
    }

    @SuppressLint({"SetTextI18n"})
    private final void S() {
        Book book = N().getBook();
        if (book != null) {
            Context context = getContext();
            DialogReadingExitAddShelfRecommendBinding dialogReadingExitAddShelfRecommendBinding = this.binding;
            MiBookManager.s1(context, book, dialogReadingExitAddShelfRecommendBinding != null ? dialogReadingExitAddShelfRecommendBinding.ivBookCover : null);
            DialogReadingExitAddShelfRecommendBinding dialogReadingExitAddShelfRecommendBinding2 = this.binding;
            ThemeTextView themeTextView = dialogReadingExitAddShelfRecommendBinding2 != null ? dialogReadingExitAddShelfRecommendBinding2.tvBookName : null;
            if (themeTextView == null) {
                return;
            }
            themeTextView.setText("是否将《" + book.getBookName() + "》加入书架");
        }
    }

    private final void T() {
        ThemeTextView themeTextView;
        ThemeLinearLayout themeLinearLayout;
        ThemeTextView themeTextView2;
        RelativeLayout relativeLayout;
        DialogReadingExitAddShelfRecommendBinding dialogReadingExitAddShelfRecommendBinding = this.binding;
        if (dialogReadingExitAddShelfRecommendBinding != null && (relativeLayout = dialogReadingExitAddShelfRecommendBinding.rlSwitchMore) != null) {
            relativeLayout.setOnClickListener(new View.OnClickListener() { // from class: dd.k
                public /* synthetic */ k() {
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ReadingAddShelfRecommendBooksDialogFragment.U(ReadingAddShelfRecommendBooksDialogFragment.this, view);
                }
            });
        }
        DialogReadingExitAddShelfRecommendBinding dialogReadingExitAddShelfRecommendBinding2 = this.binding;
        if (dialogReadingExitAddShelfRecommendBinding2 != null && (themeTextView2 = dialogReadingExitAddShelfRecommendBinding2.tvSwitchMore) != null) {
            themeTextView2.setOnClickListener(new View.OnClickListener() { // from class: dd.l
                public /* synthetic */ l() {
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ReadingAddShelfRecommendBooksDialogFragment.W(ReadingAddShelfRecommendBooksDialogFragment.this, view);
                }
            });
        }
        DialogReadingExitAddShelfRecommendBinding dialogReadingExitAddShelfRecommendBinding3 = this.binding;
        if (dialogReadingExitAddShelfRecommendBinding3 != null && (themeLinearLayout = dialogReadingExitAddShelfRecommendBinding3.llExitReading) != null) {
            themeLinearLayout.setOnClickListener(new View.OnClickListener() { // from class: dd.m
                public /* synthetic */ m() {
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ReadingAddShelfRecommendBooksDialogFragment.X(ReadingAddShelfRecommendBooksDialogFragment.this, view);
                }
            });
        }
        DialogReadingExitAddShelfRecommendBinding dialogReadingExitAddShelfRecommendBinding4 = this.binding;
        if (dialogReadingExitAddShelfRecommendBinding4 != null && (themeTextView = dialogReadingExitAddShelfRecommendBinding4.tvAddShelf) != null) {
            themeTextView.setOnClickListener(new View.OnClickListener() { // from class: dd.n
                public /* synthetic */ n() {
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ReadingAddShelfRecommendBooksDialogFragment.Y(ReadingAddShelfRecommendBooksDialogFragment.this, view);
                }
            });
        }
        N().L0().observe(this, new Observer() { // from class: dd.o
            public /* synthetic */ o() {
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ReadingAddShelfRecommendBooksDialogFragment.Z(Function1.this, obj);
            }
        });
    }

    public static final void U(ReadingAddShelfRecommendBooksDialogFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.b0();
    }

    public static final void W(ReadingAddShelfRecommendBooksDialogFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.b0();
    }

    public static final void X(ReadingAddShelfRecommendBooksDialogFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.a0();
    }

    public static final void Y(ReadingAddShelfRecommendBooksDialogFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        String sourceString = this$0.N().getSourceString();
        if (sourceString != null) {
            com.martian.mibook.mvvm.read.widget.a O = this$0.O();
            if (O != null) {
                O.w(sourceString);
            }
            DialogReadingExitAddShelfRecommendBinding dialogReadingExitAddShelfRecommendBinding = this$0.binding;
            ThemeTextView themeTextView = dialogReadingExitAddShelfRecommendBinding != null ? dialogReadingExitAddShelfRecommendBinding.tvAddShelf : null;
            if (themeTextView != null) {
                Context context = this$0.getContext();
                themeTextView.setText(context != null ? context.getString(R.string.already_in_bookrack) : null);
            }
            DialogReadingExitAddShelfRecommendBinding dialogReadingExitAddShelfRecommendBinding2 = this$0.binding;
            ThemeTextView themeTextView2 = dialogReadingExitAddShelfRecommendBinding2 != null ? dialogReadingExitAddShelfRecommendBinding2.tvAddShelf : null;
            if (themeTextView2 != null) {
                themeTextView2.setEnabled(false);
            }
            DialogReadingExitAddShelfRecommendBinding dialogReadingExitAddShelfRecommendBinding3 = this$0.binding;
            ThemeTextView themeTextView3 = dialogReadingExitAddShelfRecommendBinding3 != null ? dialogReadingExitAddShelfRecommendBinding3.tvAddShelf : null;
            if (themeTextView3 == null) {
                return;
            }
            themeTextView3.setAlpha(0.4f);
        }
    }

    public static final void Z(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void a0() {
        this.isExit = true;
        dismiss();
        com.martian.mibook.mvvm.read.widget.a O = O();
        if (O != null) {
            O.v();
        }
    }

    private final void b0() {
        ProgressBar progressBar;
        DialogReadingExitAddShelfRecommendBinding dialogReadingExitAddShelfRecommendBinding = this.binding;
        if (dialogReadingExitAddShelfRecommendBinding == null || (progressBar = dialogReadingExitAddShelfRecommendBinding.tvSwitchMoreProgressbar) == null || progressBar.getVisibility() != 0) {
            DialogReadingExitAddShelfRecommendBinding dialogReadingExitAddShelfRecommendBinding2 = this.binding;
            ProgressBar progressBar2 = dialogReadingExitAddShelfRecommendBinding2 != null ? dialogReadingExitAddShelfRecommendBinding2.tvSwitchMoreProgressbar : null;
            if (progressBar2 != null) {
                progressBar2.setVisibility(0);
            }
            DialogReadingExitAddShelfRecommendBinding dialogReadingExitAddShelfRecommendBinding3 = this.binding;
            ThemeImageView themeImageView = dialogReadingExitAddShelfRecommendBinding3 != null ? dialogReadingExitAddShelfRecommendBinding3.tvSwitchMoreLoan : null;
            if (themeImageView != null) {
                themeImageView.setVisibility(8);
            }
            INSTANCE.b(getContext(), N());
        }
    }

    public final void d0() {
        MyGridView myGridView;
        MyGridView myGridView2;
        DialogReadingExitAddShelfRecommendBinding dialogReadingExitAddShelfRecommendBinding = this.binding;
        ProgressBar progressBar = dialogReadingExitAddShelfRecommendBinding != null ? dialogReadingExitAddShelfRecommendBinding.tvSwitchMoreProgressbar : null;
        if (progressBar != null) {
            progressBar.setVisibility(8);
        }
        DialogReadingExitAddShelfRecommendBinding dialogReadingExitAddShelfRecommendBinding2 = this.binding;
        ThemeImageView themeImageView = dialogReadingExitAddShelfRecommendBinding2 != null ? dialogReadingExitAddShelfRecommendBinding2.tvSwitchMoreLoan : null;
        if (themeImageView != null) {
            themeImageView.setVisibility(0);
        }
        int c10 = INSTANCE.c(getContext());
        FragmentActivity activity = getActivity();
        BaseActivity baseActivity = activity instanceof BaseActivity ? (BaseActivity) activity : null;
        boolean isPortrait = baseActivity != null ? baseActivity.getIsPortrait() : true;
        if (this.bookCoverGridAdapter == null) {
            m mVar = new m(getActivity());
            this.bookCoverGridAdapter = mVar;
            mVar.h(isPortrait);
            DialogReadingExitAddShelfRecommendBinding dialogReadingExitAddShelfRecommendBinding3 = this.binding;
            MyGridView myGridView3 = dialogReadingExitAddShelfRecommendBinding3 != null ? dialogReadingExitAddShelfRecommendBinding3.exitDialogBooks : null;
            if (myGridView3 != null) {
                myGridView3.setNumColumns(isPortrait ? 1 : 6);
            }
            DialogReadingExitAddShelfRecommendBinding dialogReadingExitAddShelfRecommendBinding4 = this.binding;
            if (dialogReadingExitAddShelfRecommendBinding4 != null && (myGridView2 = dialogReadingExitAddShelfRecommendBinding4.exitDialogBooks) != null) {
                myGridView2.setAdapter((ListAdapter) this.bookCoverGridAdapter);
            }
        }
        m mVar2 = this.bookCoverGridAdapter;
        if (mVar2 == null || isPortrait != mVar2.c()) {
            m mVar3 = this.bookCoverGridAdapter;
            if (mVar3 != null) {
                mVar3.h(isPortrait);
            }
            DialogReadingExitAddShelfRecommendBinding dialogReadingExitAddShelfRecommendBinding5 = this.binding;
            MyGridView myGridView4 = dialogReadingExitAddShelfRecommendBinding5 != null ? dialogReadingExitAddShelfRecommendBinding5.exitDialogBooks : null;
            if (myGridView4 != null) {
                myGridView4.setNumColumns(isPortrait ? 1 : 6);
            }
            DialogReadingExitAddShelfRecommendBinding dialogReadingExitAddShelfRecommendBinding6 = this.binding;
            if (dialogReadingExitAddShelfRecommendBinding6 != null && (myGridView = dialogReadingExitAddShelfRecommendBinding6.exitDialogBooks) != null) {
                myGridView.setAdapter((ListAdapter) this.bookCoverGridAdapter);
            }
        }
        ArrayList arrayList = new ArrayList();
        List<TYBookItem> u12 = N().u1();
        Iterator<TYBookItem> it = u12 != null ? u12.iterator() : null;
        while (it != null && it.hasNext()) {
            arrayList.add(it.next());
            it.remove();
            if (arrayList.size() >= c10) {
                break;
            }
        }
        m mVar4 = this.bookCoverGridAdapter;
        if (mVar4 != null) {
            mVar4.g(arrayList);
        }
    }

    @JvmStatic
    @k
    public static final ReadingAddShelfRecommendBooksDialogFragment e0(@k FragmentActivity fragmentActivity) {
        return INSTANCE.d(fragmentActivity);
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
        Intrinsics.checkNotNullParameter(view, "view");
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.dialog_reading_exit_add_shelf_recommend, (ViewGroup) null);
        this.binding = DialogReadingExitAddShelfRecommendBinding.bind(inflate);
        view.setOnTouchListener(new View.OnTouchListener() { // from class: dd.p
            public /* synthetic */ p() {
            }

            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view2, MotionEvent motionEvent) {
                boolean R;
                R = ReadingAddShelfRecommendBooksDialogFragment.R(ReadingAddShelfRecommendBooksDialogFragment.this, view2, motionEvent);
                return R;
            }
        });
        T();
        S();
        return inflate;
    }

    @Override // com.martian.libmars.widget.dialog.MartianBottomSheetDialogFragment
    public void u(@k View bottomSheet, int newState) {
        Intrinsics.checkNotNullParameter(bottomSheet, "bottomSheet");
        super.u(bottomSheet, newState);
        if ((newState == 4 || newState == 5) && !this.isExit) {
            ReadingViewModel.f2(N(), 0, 1, null);
        }
    }
}
