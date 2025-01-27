package com.martian.libmars.widget.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.ViewModelProvider;
import com.kuaishou.weapon.p0.t;
import com.kwad.sdk.m.e;
import com.martian.libmars.R;
import com.martian.libmars.common.ConfigSingleton;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0016\u0018\u0000 12\u00020\u0001:\u000223B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u0019\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\f\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000e\u0010\u0003J-\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J!\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00122\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0011\u0010\u0018\u001a\u0004\u0018\u00010\u0012H\u0014¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u0019\u0010\u001d\u001a\u00020\u001c2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001f\u0010\u0003J\u000f\u0010 \u001a\u00020\u0004H\u0016¢\u0006\u0004\b \u0010\u0003R\"\u0010(\u001a\u00020!8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R$\u00100\u001a\u0004\u0018\u00010)8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/¨\u00064"}, d2 = {"Lcom/martian/libmars/widget/dialog/MartianDialogFragment;", "Landroidx/appcompat/app/AppCompatDialogFragment;", "<init>", "()V", "", "o", "Landroid/view/ViewGroup;", "viewGroup", t.f11211k, "(Landroid/view/ViewGroup;)V", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "dismiss", "Landroid/view/LayoutInflater;", "inflater", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "k", "()Landroid/view/View;", "n", "(Landroid/view/View;)V", "Landroid/app/Dialog;", "onCreateDialog", "(Landroid/os/Bundle;)Landroid/app/Dialog;", "onStart", "onDestroyView", "Lcom/martian/libmars/widget/dialog/MartianDialogViewModel;", "c", "Lcom/martian/libmars/widget/dialog/MartianDialogViewModel;", "m", "()Lcom/martian/libmars/widget/dialog/MartianDialogViewModel;", "q", "(Lcom/martian/libmars/widget/dialog/MartianDialogViewModel;)V", "martianDialogViewModel", "Lcom/martian/libmars/widget/dialog/b;", "d", "Lcom/martian/libmars/widget/dialog/b;", t.f11204d, "()Lcom/martian/libmars/widget/dialog/b;", "p", "(Lcom/martian/libmars/widget/dialog/b;)V", "mBuilder", e.TAG, "a", "b", "libmars_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes3.dex */
public class MartianDialogFragment extends AppCompatDialogFragment {

    /* renamed from: e */
    @k
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: c, reason: from kotlin metadata */
    public MartianDialogViewModel martianDialogViewModel;

    /* renamed from: d, reason: from kotlin metadata */
    @l
    public com.martian.libmars.widget.dialog.b mBuilder;

    /* renamed from: com.martian.libmars.widget.dialog.MartianDialogFragment$a */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @k
        public final com.martian.libmars.widget.dialog.b a() {
            return new com.martian.libmars.widget.dialog.b();
        }

        public Companion() {
        }
    }

    public interface b {
        void a(@k DialogFragment dialogFragment);
    }

    @JvmStatic
    @k
    public static final com.martian.libmars.widget.dialog.b j() {
        return INSTANCE.a();
    }

    private final void o() {
        if (this.mBuilder == null) {
            dismissAllowingStateLoss();
        } else {
            q((MartianDialogViewModel) new ViewModelProvider(this).get(MartianDialogViewModel.class));
            m().d(this.mBuilder);
        }
    }

    private final void r(ViewGroup viewGroup) {
        Context context = getContext();
        if (context != null) {
            FrameLayout frameLayout = viewGroup != null ? (FrameLayout) viewGroup.findViewById(R.id.night_mask) : null;
            FrameLayout frameLayout2 = frameLayout instanceof FrameLayout ? frameLayout : null;
            if (!ConfigSingleton.D().H0()) {
                if (frameLayout2 == null) {
                    return;
                }
                frameLayout2.setVisibility(8);
                return;
            }
            if (frameLayout2 == null) {
                frameLayout2 = new FrameLayout(context);
                frameLayout2.setId(R.id.night_mask);
                frameLayout2.setBackgroundColor(ContextCompat.getColor(context, R.color.semi_transparent_dark));
                if (viewGroup != null) {
                    viewGroup.addView(frameLayout2, new ViewGroup.LayoutParams(-1, -1));
                }
            }
            frameLayout2.setVisibility(0);
        }
    }

    @Override // androidx.fragment.app.DialogFragment
    public void dismiss() {
        DialogInterface.OnDismissListener d10;
        com.martian.libmars.widget.dialog.b bVar = this.mBuilder;
        if (bVar != null && (d10 = bVar.d()) != null) {
            d10.onDismiss(getDialog());
        }
        super.dismissAllowingStateLoss();
    }

    @l
    public View k() {
        WeakReference<View> n10 = m().getMDialogBuilder().n();
        if (n10 != null) {
            return n10.get();
        }
        return null;
    }

    @l
    /* renamed from: l, reason: from getter */
    public final com.martian.libmars.widget.dialog.b getMBuilder() {
        return this.mBuilder;
    }

    @k
    public final MartianDialogViewModel m() {
        MartianDialogViewModel martianDialogViewModel = this.martianDialogViewModel;
        if (martianDialogViewModel != null) {
            return martianDialogViewModel;
        }
        Intrinsics.throwUninitializedPropertyAccessException("martianDialogViewModel");
        return null;
    }

    public void n(@k View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        View k10 = k();
        if (k10 != null) {
            FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.custom_content);
            frameLayout.removeAllViews();
            frameLayout.addView(k10, new FrameLayout.LayoutParams(-1, -1));
            if (m().getMDialogBuilder().l()) {
                frameLayout.setPadding(m().getMDialogBuilder().j(), m().getMDialogBuilder().m(), m().getMDialogBuilder().k(), m().getMDialogBuilder().i());
            }
            r((ViewGroup) view);
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(@l Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        o();
    }

    @Override // androidx.appcompat.app.AppCompatDialogFragment, androidx.fragment.app.DialogFragment
    @k
    public Dialog onCreateDialog(@l Bundle savedInstanceState) {
        Dialog dialog = new Dialog(requireContext(), m().getMDialogBuilder().h());
        Window window = dialog.getWindow();
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
        }
        return dialog;
    }

    @Override // androidx.fragment.app.Fragment
    @l
    public View onCreateView(@k LayoutInflater inflater, @l ViewGroup container, @l Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        return inflater.inflate(R.layout.dialog_custom_layout, container, false);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        Dialog dialog;
        if (getRetainInstance() && (dialog = getDialog()) != null) {
            dialog.setDismissMessage(null);
        }
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.mBuilder == null) {
            dismiss();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@k View view, @l Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        b g10 = m().getMDialogBuilder().g();
        if (g10 != null) {
            g10.a(this);
        }
        com.martian.libmars.widget.dialog.b mDialogBuilder = m().getMDialogBuilder();
        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.setCanceledOnTouchOutside(mDialogBuilder.b());
        }
        Dialog dialog2 = getDialog();
        if (dialog2 != null) {
            dialog2.setCancelable(mDialogBuilder.a());
        }
        Dialog dialog3 = getDialog();
        if (dialog3 != null) {
            dialog3.setOnShowListener(mDialogBuilder.f());
        }
        Dialog dialog4 = getDialog();
        if (dialog4 != null) {
            dialog4.setOnKeyListener(mDialogBuilder.e());
        }
        Dialog dialog5 = getDialog();
        if (dialog5 != null) {
            dialog5.setOnCancelListener(mDialogBuilder.c());
        }
        Dialog dialog6 = getDialog();
        if (dialog6 != null) {
            dialog6.setOnDismissListener(mDialogBuilder.d());
        }
        n(view);
    }

    public final void p(@l com.martian.libmars.widget.dialog.b bVar) {
        this.mBuilder = bVar;
    }

    public final void q(@k MartianDialogViewModel martianDialogViewModel) {
        Intrinsics.checkNotNullParameter(martianDialogViewModel, "<set-?>");
        this.martianDialogViewModel = martianDialogViewModel;
    }
}
