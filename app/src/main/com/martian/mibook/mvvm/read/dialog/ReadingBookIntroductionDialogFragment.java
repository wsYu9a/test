package com.martian.mibook.mvvm.read.dialog;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.RelativeLayout;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import com.gyf.immersionbar.BarHide;
import com.gyf.immersionbar.d;
import com.kuaishou.weapon.p0.t;
import com.martian.libmars.common.ConfigSingleton;
import com.martian.libmars.widget.dialog.MartianBottomSheetDialogFragment;
import com.martian.libmars.widget.dialog.a;
import com.martian.mibook.R;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.databinding.DialogReadingBookIntroductionBinding;
import com.martian.mibook.mvvm.read.dialog.ReadingBookIntroductionDialogFragment;
import com.martian.mibook.ui.reader.ReaderThemeImageView;
import com.martian.mibook.ui.reader.ReaderThemeLinearLayout;
import com.martian.mibook.ui.reader.ReaderThemeTextView;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 \u00192\u00020\u0001:\u0001\u001aB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ!\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\r\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\tH\u0017¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u000f\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u001b"}, d2 = {"Lcom/martian/mibook/mvvm/read/dialog/ReadingBookIntroductionDialogFragment;", "Lcom/martian/libmars/widget/dialog/MartianBottomSheetDialogFragment;", "<init>", "()V", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "p", "(Landroid/view/View;)Landroid/view/View;", t.f11211k, "(Landroid/view/View;)V", "Lcom/martian/mibook/databinding/DialogReadingBookIntroductionBinding;", "f", "Lcom/martian/mibook/databinding/DialogReadingBookIntroductionBinding;", "binding", "", "g", "Ljava/lang/String;", "introduction", "h", "a", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes3.dex */
public final class ReadingBookIntroductionDialogFragment extends MartianBottomSheetDialogFragment {

    /* renamed from: h, reason: from kotlin metadata */
    @k
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: i */
    @k
    public static final String f14615i = "ReadingBookIntroductionDialogFragment";

    /* renamed from: j */
    @k
    public static final String f14616j = "INTENT_INTRODUCTION";

    /* renamed from: f, reason: from kotlin metadata */
    @l
    public DialogReadingBookIntroductionBinding binding;

    /* renamed from: g, reason: from kotlin metadata */
    @l
    public String introduction;

    /* renamed from: com.martian.mibook.mvvm.read.dialog.ReadingBookIntroductionDialogFragment$a, reason: from kotlin metadata */
    public static final class Companion {

        /* renamed from: com.martian.mibook.mvvm.read.dialog.ReadingBookIntroductionDialogFragment$a$a */
        public static final class C0536a implements MartianBottomSheetDialogFragment.b {
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
        public final ReadingBookIntroductionDialogFragment a(@k FragmentActivity activity, @l String str) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            a a10 = MartianBottomSheetDialogFragment.INSTANCE.a();
            ReadingBookIntroductionDialogFragment readingBookIntroductionDialogFragment = new ReadingBookIntroductionDialogFragment();
            Bundle bundle = new Bundle();
            bundle.putString(ReadingBookIntroductionDialogFragment.f14616j, str);
            readingBookIntroductionDialogFragment.setArguments(bundle);
            a10.k0(true).j0(true).w0(true).n0(ConfigSingleton.i(475.0f)).q0(ConfigSingleton.i(16.0f)).s0(new C0536a());
            a10.c0(activity, readingBookIntroductionDialogFragment, ReadingBookIntroductionDialogFragment.f14615i, true);
            return readingBookIntroductionDialogFragment;
        }

        public Companion() {
        }
    }

    public static final void H(ReadingBookIntroductionDialogFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismiss();
    }

    public static final void I(ReadingBookIntroductionDialogFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismiss();
    }

    public static final void K(ReadingBookIntroductionDialogFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismiss();
    }

    @JvmStatic
    @k
    public static final ReadingBookIntroductionDialogFragment M(@k FragmentActivity fragmentActivity, @l String str) {
        return INSTANCE.a(fragmentActivity, str);
    }

    @Override // com.martian.libmars.widget.dialog.MartianBottomSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(@l Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        this.introduction = arguments != null ? arguments.getString(f14616j) : null;
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
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.dialog_reading_book_introduction, (ViewGroup) null);
        this.binding = DialogReadingBookIntroductionBinding.bind(inflate);
        return inflate;
    }

    @Override // com.martian.libmars.widget.dialog.MartianBottomSheetDialogFragment
    public void r(@k View view) {
        ReaderThemeTextView readerThemeTextView;
        ReaderThemeLinearLayout readerThemeLinearLayout;
        RelativeLayout root;
        ReaderThemeImageView readerThemeImageView;
        Intrinsics.checkNotNullParameter(view, "view");
        super.r(view);
        DialogReadingBookIntroductionBinding dialogReadingBookIntroductionBinding = this.binding;
        if (dialogReadingBookIntroductionBinding != null && (readerThemeImageView = dialogReadingBookIntroductionBinding.ivClose) != null) {
            readerThemeImageView.setOnClickListener(new View.OnClickListener() { // from class: dd.q
                public /* synthetic */ q() {
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    ReadingBookIntroductionDialogFragment.H(ReadingBookIntroductionDialogFragment.this, view2);
                }
            });
        }
        DialogReadingBookIntroductionBinding dialogReadingBookIntroductionBinding2 = this.binding;
        if (dialogReadingBookIntroductionBinding2 != null && (root = dialogReadingBookIntroductionBinding2.getRoot()) != null) {
            root.setOnClickListener(new View.OnClickListener() { // from class: dd.r
                public /* synthetic */ r() {
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    ReadingBookIntroductionDialogFragment.I(ReadingBookIntroductionDialogFragment.this, view2);
                }
            });
        }
        DialogReadingBookIntroductionBinding dialogReadingBookIntroductionBinding3 = this.binding;
        if (dialogReadingBookIntroductionBinding3 != null && (readerThemeLinearLayout = dialogReadingBookIntroductionBinding3.rlContent) != null) {
            readerThemeLinearLayout.setOnClickListener(null);
        }
        DialogReadingBookIntroductionBinding dialogReadingBookIntroductionBinding4 = this.binding;
        if (dialogReadingBookIntroductionBinding4 != null && (readerThemeTextView = dialogReadingBookIntroductionBinding4.tvExit) != null) {
            readerThemeTextView.setOnClickListener(new View.OnClickListener() { // from class: dd.s
                public /* synthetic */ s() {
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    ReadingBookIntroductionDialogFragment.K(ReadingBookIntroductionDialogFragment.this, view2);
                }
            });
        }
        String str = this.introduction;
        String replace$default = str != null ? StringsKt.replace$default(str, "\n", "\n\n", false, 4, (Object) null) : null;
        if (replace$default != null) {
            SpannableString spannableString = new SpannableString(replace$default);
            Matcher matcher = Pattern.compile("\n\n").matcher(replace$default);
            while (matcher.find()) {
                spannableString.setSpan(new AbsoluteSizeSpan(6, true), matcher.start() + 1, matcher.end(), 33);
            }
            DialogReadingBookIntroductionBinding dialogReadingBookIntroductionBinding5 = this.binding;
            ReaderThemeTextView readerThemeTextView2 = dialogReadingBookIntroductionBinding5 != null ? dialogReadingBookIntroductionBinding5.tvIntroduction : null;
            if (readerThemeTextView2 == null) {
                return;
            }
            readerThemeTextView2.setText(spannableString);
        }
    }
}
