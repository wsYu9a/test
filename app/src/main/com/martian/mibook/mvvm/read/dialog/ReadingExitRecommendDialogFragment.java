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
import androidx.recyclerview.widget.GridLayoutManager;
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
import com.martian.mibook.R;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.application.ReadingInstance;
import com.martian.mibook.databinding.DialogReadingExitRecommendBinding;
import com.martian.mibook.lib.model.data.TYBookItem;
import com.martian.mibook.mvvm.base.BaseActivity;
import com.martian.mibook.mvvm.extensions.ExtKt;
import com.martian.mibook.mvvm.read.adapter.ReadingExitRecommendBookAdapter;
import com.martian.mibook.mvvm.read.dialog.ReadingExitRecommendDialogFragment;
import com.martian.mibook.mvvm.read.viewmodel.ReadingViewModel;
import com.martian.mibook.mvvm.read.widget.a;
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
import l9.t0;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 ,2\u00020\u0001:\u0001-B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0003J\u000f\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\u0003J\u000f\u0010\b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\b\u0010\u0003J!\u0010\r\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u000f\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\tH\u0017¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0016\u0010\u0003R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010!\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010\u0016R\u001b\u0010'\u001a\u00020\"8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R\u0016\u0010+\u001a\u0004\u0018\u00010(8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b)\u0010*¨\u0006."}, d2 = {"Lcom/martian/mibook/mvvm/read/dialog/ReadingExitRecommendDialogFragment;", "Lcom/martian/libmars/widget/dialog/MartianBottomSheetDialogFragment;", "<init>", "()V", "", ExifInterface.LATITUDE_SOUTH, "d0", "b0", "a0", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "p", "(Landroid/view/View;)Landroid/view/View;", "bottomSheet", "", "newState", "u", "(Landroid/view/View;I)V", "Z", "Lcom/martian/mibook/mvvm/read/adapter/ReadingExitRecommendBookAdapter;", "f", "Lcom/martian/mibook/mvvm/read/adapter/ReadingExitRecommendBookAdapter;", "bookListAdapter", "Lcom/martian/mibook/databinding/DialogReadingExitRecommendBinding;", "g", "Lcom/martian/mibook/databinding/DialogReadingExitRecommendBinding;", "binding", "", "h", "isExit", "Lcom/martian/mibook/mvvm/read/viewmodel/ReadingViewModel;", "i", "Lkotlin/Lazy;", "N", "()Lcom/martian/mibook/mvvm/read/viewmodel/ReadingViewModel;", "mViewModel", "Lcom/martian/mibook/mvvm/read/widget/a;", "O", "()Lcom/martian/mibook/mvvm/read/widget/a;", "readMenuCallBack", "j", "a", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes3.dex */
public final class ReadingExitRecommendDialogFragment extends MartianBottomSheetDialogFragment {

    /* renamed from: j, reason: from kotlin metadata */
    @k
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: k */
    @k
    public static final String f14620k = "ReadingExitRecommendDialogFragment";

    /* renamed from: f, reason: from kotlin metadata */
    @l
    public ReadingExitRecommendBookAdapter bookListAdapter;

    /* renamed from: g, reason: from kotlin metadata */
    @l
    public DialogReadingExitRecommendBinding binding;

    /* renamed from: h, reason: from kotlin metadata */
    public boolean isExit;

    /* renamed from: i, reason: from kotlin metadata */
    @k
    public final Lazy mViewModel = LazyKt.lazy(new Function0<ReadingViewModel>() { // from class: com.martian.mibook.mvvm.read.dialog.ReadingExitRecommendDialogFragment$mViewModel$2
        public ReadingExitRecommendDialogFragment$mViewModel$2() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @k
        public final ReadingViewModel invoke() {
            ViewModelStoreOwner activity = ReadingExitRecommendDialogFragment.this.getActivity();
            if (activity == null) {
                activity = ReadingExitRecommendDialogFragment.this;
            }
            return (ReadingViewModel) new ViewModelProvider(activity).get(ReadingViewModel.class);
        }
    });

    /* renamed from: com.martian.mibook.mvvm.read.dialog.ReadingExitRecommendDialogFragment$a, reason: from kotlin metadata */
    public static final class Companion {

        /* renamed from: com.martian.mibook.mvvm.read.dialog.ReadingExitRecommendDialogFragment$a$a */
        public static final class C0537a implements MartianBottomSheetDialogFragment.b {
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
        public final void a(@l Context context, @l ReadingViewModel readingViewModel) {
            if (readingViewModel != null) {
                readingViewModel.t0(b(context));
            }
        }

        @JvmStatic
        public final int b(@l Context context) {
            return (context == null || ReadingInstance.z().O(context)) ? 3 : 6;
        }

        @JvmStatic
        @k
        public final ReadingExitRecommendDialogFragment c(@k FragmentActivity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Fragment findFragmentByTag = activity.getSupportFragmentManager().findFragmentByTag(ReadingExitRecommendDialogFragment.f14620k);
            DialogFragment dialogFragment = findFragmentByTag instanceof DialogFragment ? (DialogFragment) findFragmentByTag : null;
            if (dialogFragment != null && dialogFragment.isVisible()) {
                dialogFragment.dismiss();
            }
            a a10 = MartianBottomSheetDialogFragment.INSTANCE.a();
            ReadingExitRecommendDialogFragment readingExitRecommendDialogFragment = new ReadingExitRecommendDialogFragment();
            a10.k0(true).j0(true).w0(true).q0(ConfigSingleton.i(16.0f)).s0(new C0537a());
            ac.a.y(activity, "退出弹窗-推荐-展示");
            a10.c0(activity, readingExitRecommendDialogFragment, ReadingExitRecommendDialogFragment.f14620k, true);
            return readingExitRecommendDialogFragment;
        }

        public Companion() {
        }
    }

    public static final class b implements ReadingExitRecommendBookAdapter.a {
        public b() {
        }

        @Override // com.martian.mibook.mvvm.read.adapter.ReadingExitRecommendBookAdapter.a
        @SuppressLint({"SetTextI18n"})
        public void a(@l TYBookItem tYBookItem, @k TextView tvAddBookShelf) {
            Intrinsics.checkNotNullParameter(tvAddBookShelf, "tvAddBookShelf");
            Context context = ReadingExitRecommendDialogFragment.this.getContext();
            Activity activity = context instanceof Activity ? (Activity) context : null;
            ReadingExitRecommendDialogFragment readingExitRecommendDialogFragment = ReadingExitRecommendDialogFragment.this;
            MiConfigSingleton.b2().V1().g(3, tYBookItem != null ? tYBookItem.getSourceName() : null, tYBookItem != null ? tYBookItem.getSourceId() : null, tYBookItem != null ? tYBookItem.getRecommendId() : null, tYBookItem != null ? tYBookItem.getRecommend() : null, "退出阅读加书架");
            MiConfigSingleton.b2().M1().g(activity, tYBookItem);
            if (tYBookItem != null) {
                tYBookItem.setInBookStore(true);
            }
            t0.b(readingExitRecommendDialogFragment.getContext(), "已加入书架");
            tvAddBookShelf.setText(ExtKt.c("已在书架"));
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
        INSTANCE.a(context, readingViewModel);
    }

    @JvmStatic
    public static final int Q(@l Context context) {
        return INSTANCE.b(context);
    }

    public static final boolean R(ReadingExitRecommendDialogFragment this$0, View view, MotionEvent motionEvent) {
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

    private final void S() {
        ThemeTextView themeTextView;
        ThemeLinearLayout themeLinearLayout;
        ThemeTextView themeTextView2;
        ThemeImageView themeImageView;
        DialogReadingExitRecommendBinding dialogReadingExitRecommendBinding = this.binding;
        if (dialogReadingExitRecommendBinding != null && (themeImageView = dialogReadingExitRecommendBinding.ivClose) != null) {
            themeImageView.setOnClickListener(new View.OnClickListener() { // from class: dd.u
                public /* synthetic */ u() {
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ReadingExitRecommendDialogFragment.T(ReadingExitRecommendDialogFragment.this, view);
                }
            });
        }
        DialogReadingExitRecommendBinding dialogReadingExitRecommendBinding2 = this.binding;
        if (dialogReadingExitRecommendBinding2 != null && (themeTextView2 = dialogReadingExitRecommendBinding2.tvSwitchMoreBook) != null) {
            themeTextView2.setOnClickListener(new View.OnClickListener() { // from class: dd.v
                public /* synthetic */ v() {
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ReadingExitRecommendDialogFragment.U(ReadingExitRecommendDialogFragment.this, view);
                }
            });
        }
        DialogReadingExitRecommendBinding dialogReadingExitRecommendBinding3 = this.binding;
        if (dialogReadingExitRecommendBinding3 != null && (themeLinearLayout = dialogReadingExitRecommendBinding3.llExitReading) != null) {
            themeLinearLayout.setOnClickListener(new View.OnClickListener() { // from class: dd.w
                public /* synthetic */ w() {
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ReadingExitRecommendDialogFragment.W(ReadingExitRecommendDialogFragment.this, view);
                }
            });
        }
        DialogReadingExitRecommendBinding dialogReadingExitRecommendBinding4 = this.binding;
        if (dialogReadingExitRecommendBinding4 != null && (themeTextView = dialogReadingExitRecommendBinding4.tvReadContinue) != null) {
            themeTextView.setOnClickListener(new View.OnClickListener() { // from class: dd.x
                public /* synthetic */ x() {
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ReadingExitRecommendDialogFragment.X(ReadingExitRecommendDialogFragment.this, view);
                }
            });
        }
        N().L0().observe(this, new Observer() { // from class: dd.y
            public /* synthetic */ y() {
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ReadingExitRecommendDialogFragment.Y(Function1.this, obj);
            }
        });
    }

    public static final void T(ReadingExitRecommendDialogFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismiss();
    }

    public static final void U(ReadingExitRecommendDialogFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.b0();
    }

    public static final void W(ReadingExitRecommendDialogFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.a0();
    }

    public static final void X(ReadingExitRecommendDialogFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Z();
    }

    public static final void Y(Function1 tmp0, Object obj) {
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
        INSTANCE.a(getContext(), N());
    }

    public final void d0() {
        RecyclerView recyclerView;
        int b10 = INSTANCE.b(getContext());
        FragmentActivity activity = getActivity();
        BaseActivity baseActivity = activity instanceof BaseActivity ? (BaseActivity) activity : null;
        boolean isPortrait = baseActivity != null ? baseActivity.getIsPortrait() : true;
        if (isPortrait) {
            DialogReadingExitRecommendBinding dialogReadingExitRecommendBinding = this.binding;
            RecyclerView recyclerView2 = dialogReadingExitRecommendBinding != null ? dialogReadingExitRecommendBinding.rvBooks : null;
            if (recyclerView2 != null) {
                recyclerView2.setLayoutManager(new LinearLayoutManager(getContext()));
            }
        } else {
            DialogReadingExitRecommendBinding dialogReadingExitRecommendBinding2 = this.binding;
            RecyclerView recyclerView3 = dialogReadingExitRecommendBinding2 != null ? dialogReadingExitRecommendBinding2.rvBooks : null;
            if (recyclerView3 != null) {
                recyclerView3.setLayoutManager(new GridLayoutManager(getContext(), 6));
            }
        }
        if (this.bookListAdapter == null) {
            ReadingExitRecommendBookAdapter readingExitRecommendBookAdapter = new ReadingExitRecommendBookAdapter(isPortrait);
            this.bookListAdapter = readingExitRecommendBookAdapter;
            DialogReadingExitRecommendBinding dialogReadingExitRecommendBinding3 = this.binding;
            if (dialogReadingExitRecommendBinding3 != null && (recyclerView = dialogReadingExitRecommendBinding3.rvBooks) != null) {
                recyclerView.setAdapter(readingExitRecommendBookAdapter);
            }
            ReadingExitRecommendBookAdapter readingExitRecommendBookAdapter2 = this.bookListAdapter;
            if (readingExitRecommendBookAdapter2 != null) {
                readingExitRecommendBookAdapter2.l(new b());
            }
        }
        ArrayList arrayList = new ArrayList();
        List<TYBookItem> u12 = N().u1();
        Iterator<TYBookItem> it = u12 != null ? u12.iterator() : null;
        while (it != null && it.hasNext()) {
            arrayList.add(it.next());
            it.remove();
            if (arrayList.size() >= b10) {
                break;
            }
        }
        ReadingExitRecommendBookAdapter readingExitRecommendBookAdapter3 = this.bookListAdapter;
        if (readingExitRecommendBookAdapter3 != null) {
            readingExitRecommendBookAdapter3.n(arrayList, isPortrait);
        }
    }

    @JvmStatic
    @k
    public static final ReadingExitRecommendDialogFragment e0(@k FragmentActivity fragmentActivity) {
        return INSTANCE.c(fragmentActivity);
    }

    public final void Z() {
        dismiss();
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
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.dialog_reading_exit_recommend, (ViewGroup) null);
        this.binding = DialogReadingExitRecommendBinding.bind(inflate);
        view.setOnTouchListener(new View.OnTouchListener() { // from class: dd.t
            public /* synthetic */ t() {
            }

            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view2, MotionEvent motionEvent) {
                boolean R;
                R = ReadingExitRecommendDialogFragment.R(ReadingExitRecommendDialogFragment.this, view2, motionEvent);
                return R;
            }
        });
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
