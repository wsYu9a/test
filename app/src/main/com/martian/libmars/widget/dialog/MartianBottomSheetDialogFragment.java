package com.martian.libmars.widget.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import androidx.core.content.ContextCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.ViewModelProvider;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.kuaishou.weapon.p0.t;
import com.kwad.sdk.m.e;
import com.martian.libmars.R;
import com.martian.libmars.common.ConfigSingleton;
import com.martian.libmars.widget.dialog.MartianBottomSheetDialogFragment;
import com.umeng.analytics.pro.bt;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0016\u0018\u0000 H2\u00020\u0001:\u0002IJB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ)\u0010\u000e\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0011\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0014¢\u0006\u0004\b\u0011\u0010\u0012J-\u0010\u0018\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0014\u001a\u00020\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0019\u0010\u001a\u001a\u00020\u00062\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ!\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u00102\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u0019\u0010\u001f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u001c\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\u0006H\u0016¢\u0006\u0004\b!\u0010\u0003J\u000f\u0010\"\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\"\u0010\u0003J\u0017\u0010#\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u0010H\u0016¢\u0006\u0004\b#\u0010$J\u0019\u0010&\u001a\u00020%2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016¢\u0006\u0004\b&\u0010'J\u001f\u0010*\u001a\u00020\u00062\u000e\u0010)\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010(H\u0016¢\u0006\u0004\b*\u0010+J\u001f\u0010.\u001a\u00020\u00062\u0006\u0010,\u001a\u00020\u00102\u0006\u0010-\u001a\u00020\u000bH\u0016¢\u0006\u0004\b.\u0010/J\u000f\u00100\u001a\u00020\u0006H\u0016¢\u0006\u0004\b0\u0010\u0003J\u000f\u00101\u001a\u00020\u0006H\u0016¢\u0006\u0004\b1\u0010\u0003J\u000f\u00102\u001a\u00020\u0006H\u0002¢\u0006\u0004\b2\u0010\u0003J\u000f\u00103\u001a\u00020\u0006H\u0002¢\u0006\u0004\b3\u0010\u0003J\u0017\u00106\u001a\u00020\u00062\u0006\u00105\u001a\u000204H\u0002¢\u0006\u0004\b6\u00107R\"\u0010?\u001a\u0002088\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R$\u0010G\u001a\u0004\u0018\u00010@8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bA\u0010B\u001a\u0004\bC\u0010D\"\u0004\bE\u0010F¨\u0006K"}, d2 = {"Lcom/martian/libmars/widget/dialog/MartianBottomSheetDialogFragment;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "<init>", "()V", "Landroid/view/ViewGroup;", "viewGroup", "", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(Landroid/view/ViewGroup;)V", "Landroid/widget/FrameLayout;", "nightMask", "", "backgroundColor", "topCornerRadius", "y", "(Landroid/widget/FrameLayout;II)V", "Landroid/view/View;", "m", "()Landroid/view/View;", "Landroid/view/LayoutInflater;", "inflater", "container", "Landroid/os/Bundle;", "savedInstanceState", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "onCreate", "(Landroid/os/Bundle;)V", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "p", "(Landroid/view/View;)Landroid/view/View;", "dismiss", "onStart", t.f11211k, "(Landroid/view/View;)V", "Landroid/app/Dialog;", "onCreateDialog", "(Landroid/os/Bundle;)Landroid/app/Dialog;", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "behavior", t.f11204d, "(Lcom/google/android/material/bottomsheet/BottomSheetBehavior;)V", "bottomSheet", "newState", "u", "(Landroid/view/View;I)V", "onStop", "onDestroyView", bt.aO, "q", "", "dimAmount", "v", "(F)V", "Lcom/martian/libmars/widget/dialog/MartianDialogViewModel;", "c", "Lcom/martian/libmars/widget/dialog/MartianDialogViewModel;", "o", "()Lcom/martian/libmars/widget/dialog/MartianDialogViewModel;", "x", "(Lcom/martian/libmars/widget/dialog/MartianDialogViewModel;)V", "martianDialogViewModel", "Lcom/martian/libmars/widget/dialog/a;", "d", "Lcom/martian/libmars/widget/dialog/a;", "n", "()Lcom/martian/libmars/widget/dialog/a;", IAdInterListener.AdReqParam.WIDTH, "(Lcom/martian/libmars/widget/dialog/a;)V", "mBuilder", e.TAG, "a", "b", "libmars_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes3.dex */
public class MartianBottomSheetDialogFragment extends BottomSheetDialogFragment {

    /* renamed from: e */
    @k
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: c, reason: from kotlin metadata */
    public MartianDialogViewModel martianDialogViewModel;

    /* renamed from: d, reason: from kotlin metadata */
    @l
    public a mBuilder;

    /* renamed from: com.martian.libmars.widget.dialog.MartianBottomSheetDialogFragment$a */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @k
        public final a a() {
            return new a();
        }

        public Companion() {
        }
    }

    public interface b {
        void a(@k DialogFragment dialogFragment);
    }

    public static final class c extends BottomSheetBehavior.BottomSheetCallback {

        /* renamed from: b */
        public final /* synthetic */ float f12705b;

        public c(float f10) {
            this.f12705b = f10;
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
        public void onSlide(@k View bottomSheet, float f10) {
            Intrinsics.checkNotNullParameter(bottomSheet, "bottomSheet");
            MartianBottomSheetDialogFragment.this.v(((1 + f10) * this.f12705b) / 2.0f);
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
        public void onStateChanged(@k View bottomSheet, int i10) {
            Intrinsics.checkNotNullParameter(bottomSheet, "bottomSheet");
            MartianBottomSheetDialogFragment.this.u(bottomSheet, i10);
        }
    }

    public static final class d implements DialogInterface.OnKeyListener {

        /* renamed from: b */
        public final /* synthetic */ a f12706b;

        /* renamed from: c */
        public final /* synthetic */ MartianBottomSheetDialogFragment f12707c;

        public d(a aVar, MartianBottomSheetDialogFragment martianBottomSheetDialogFragment) {
            this.f12706b = aVar;
            this.f12707c = martianBottomSheetDialogFragment;
        }

        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(@l DialogInterface dialogInterface, int i10, @l KeyEvent keyEvent) {
            if (!this.f12706b.c() || i10 != 4 || keyEvent == null || keyEvent.getAction() != 1) {
                return false;
            }
            this.f12707c.dismiss();
            return true;
        }
    }

    private final void A(ViewGroup viewGroup) {
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
                y(frameLayout2, ContextCompat.getColor(context, R.color.semi_transparent_dark), o().getMBottomSheetDialogBuilder().m());
                ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-1, -1);
                marginLayoutParams.topMargin = o().getMBottomSheetDialogBuilder().l();
                if (viewGroup != null) {
                    viewGroup.addView(frameLayout2, marginLayoutParams);
                }
            }
            frameLayout2.setVisibility(0);
        }
    }

    public static final void s(MartianBottomSheetDialogFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.o().getMBottomSheetDialogBuilder().d()) {
            this$0.dismiss();
        }
    }

    private final void y(FrameLayout nightMask, int backgroundColor, int topCornerRadius) {
        if (topCornerRadius == 0) {
            nightMask.setBackgroundColor(backgroundColor);
            return;
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        float f10 = topCornerRadius;
        gradientDrawable.setCornerRadii(new float[]{f10, f10, f10, f10, 0.0f, 0.0f, 0.0f, 0.0f});
        gradientDrawable.setColor(backgroundColor);
        nightMask.setBackground(gradientDrawable);
    }

    public static /* synthetic */ void z(MartianBottomSheetDialogFragment martianBottomSheetDialogFragment, FrameLayout frameLayout, int i10, int i11, int i12, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setNightMaskTopCornerRadius");
        }
        if ((i12 & 4) != 0) {
            i11 = 0;
        }
        martianBottomSheetDialogFragment.y(frameLayout, i10, i11);
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetDialogFragment, androidx.fragment.app.DialogFragment
    public void dismiss() {
        super.dismissAllowingStateLoss();
    }

    public void l(@l BottomSheetBehavior<FrameLayout> bottomSheetBehavior) {
        Window window;
        WindowManager.LayoutParams attributes;
        Dialog dialog = getDialog();
        float f10 = (dialog == null || (window = dialog.getWindow()) == null || (attributes = window.getAttributes()) == null) ? 0.5f : attributes.dimAmount;
        if (bottomSheetBehavior != null) {
            bottomSheetBehavior.addBottomSheetCallback(new c(f10));
        }
    }

    @l
    public View m() {
        WeakReference<View> v10 = o().getMBottomSheetDialogBuilder().v();
        if (v10 != null) {
            return v10.get();
        }
        return null;
    }

    @l
    /* renamed from: n, reason: from getter */
    public final a getMBuilder() {
        return this.mBuilder;
    }

    @k
    public final MartianDialogViewModel o() {
        MartianDialogViewModel martianDialogViewModel = this.martianDialogViewModel;
        if (martianDialogViewModel != null) {
            return martianDialogViewModel;
        }
        Intrinsics.throwUninitializedPropertyAccessException("martianDialogViewModel");
        return null;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(@l Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        t();
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetDialogFragment, androidx.appcompat.app.AppCompatDialogFragment, androidx.fragment.app.DialogFragment
    @k
    public Dialog onCreateDialog(@l Bundle savedInstanceState) {
        Context context = getContext();
        if (context == null) {
            Dialog onCreateDialog = super.onCreateDialog(savedInstanceState);
            Intrinsics.checkNotNullExpressionValue(onCreateDialog, "onCreateDialog(...)");
            return onCreateDialog;
        }
        a mBottomSheetDialogBuilder = o().getMBottomSheetDialogBuilder();
        BottomSheetDialog bottomSheetDialog = mBottomSheetDialogBuilder.p() > 0 ? new BottomSheetDialog(context, mBottomSheetDialogBuilder.p()) : new BottomSheetDialog(context);
        bottomSheetDialog.setCanceledOnTouchOutside(mBottomSheetDialogBuilder.d());
        bottomSheetDialog.setCancelable(mBottomSheetDialogBuilder.c());
        bottomSheetDialog.setDismissWithAnimation(mBottomSheetDialogBuilder.e());
        Window window = bottomSheetDialog.getWindow();
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
            if (mBottomSheetDialogBuilder.w()) {
                window.clearFlags(2);
            }
            if (mBottomSheetDialogBuilder.a() > -1.0f) {
                window.setDimAmount(mBottomSheetDialogBuilder.a());
            }
        }
        bottomSheetDialog.setOnShowListener(mBottomSheetDialogBuilder.k());
        if (mBottomSheetDialogBuilder.j() != null) {
            bottomSheetDialog.setOnKeyListener(mBottomSheetDialogBuilder.j());
        } else {
            bottomSheetDialog.setOnKeyListener(new d(mBottomSheetDialogBuilder, this));
        }
        bottomSheetDialog.setOnCancelListener(mBottomSheetDialogBuilder.h());
        bottomSheetDialog.setOnDismissListener(mBottomSheetDialogBuilder.i());
        return bottomSheetDialog;
    }

    @Override // androidx.fragment.app.Fragment
    @l
    public View onCreateView(@k LayoutInflater inflater, @l ViewGroup container, @l Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        return inflater.inflate(R.layout.dialog_bottom_custom_layout, container, false);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.setDismissMessage(null);
        }
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        q();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStop() {
        Dialog dialog;
        Window window;
        super.onStop();
        if (Build.VERSION.SDK_INT < 28 || (dialog = getDialog()) == null || (window = dialog.getWindow()) == null) {
            return;
        }
        window.setWindowAnimations(-1);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@k View view, @l Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        b n10 = o().getMBottomSheetDialogBuilder().n();
        if (n10 != null) {
            n10.a(this);
        }
        View p10 = p(view);
        if (p10 != null) {
            o().getMBottomSheetDialogBuilder().X(new WeakReference<>(p10));
        }
        r(view);
    }

    @l
    public View p(@k View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        return null;
    }

    public final void q() {
        BottomSheetDialog bottomSheetDialog = (BottomSheetDialog) getDialog();
        if (bottomSheetDialog == null) {
            return;
        }
        ColorDrawable colorDrawable = new ColorDrawable();
        colorDrawable.setColor(0);
        FrameLayout frameLayout = (FrameLayout) bottomSheetDialog.getDelegate().findViewById(com.google.android.material.R.id.design_bottom_sheet);
        if (frameLayout != null) {
            frameLayout.setBackground(colorDrawable);
            BottomSheetBehavior<FrameLayout> from = BottomSheetBehavior.from(frameLayout);
            Intrinsics.checkNotNullExpressionValue(from, "from(...)");
            from.setHideable(o().getMBottomSheetDialogBuilder().x());
            if (o().getMBottomSheetDialogBuilder().o() > 0) {
                from.setPeekHeight(o().getMBottomSheetDialogBuilder().o());
            }
            from.setState(o().getMBottomSheetDialogBuilder().b());
            from.setSkipCollapsed(o().getMBottomSheetDialogBuilder().y());
            from.setDraggable(o().getMBottomSheetDialogBuilder().f());
            l(from);
        }
    }

    public void r(@k View view) {
        View view2;
        Intrinsics.checkNotNullParameter(view, "view");
        FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.custom_content);
        if (o().getMBottomSheetDialogBuilder().g() > 0) {
            frameLayout.getLayoutParams().height = o().getMBottomSheetDialogBuilder().g();
        }
        frameLayout.setOnClickListener(null);
        view.setOnClickListener(new View.OnClickListener() { // from class: o9.a
            public /* synthetic */ a() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                MartianBottomSheetDialogFragment.s(MartianBottomSheetDialogFragment.this, view3);
            }
        });
        WeakReference<View> v10 = o().getMBottomSheetDialogBuilder().v();
        if (v10 == null || (view2 = v10.get()) == null) {
            return;
        }
        frameLayout.removeAllViews();
        frameLayout.addView(view2, new FrameLayout.LayoutParams(-1, -1));
        if (o().getMBottomSheetDialogBuilder().t()) {
            frameLayout.setPadding(o().getMBottomSheetDialogBuilder().r(), o().getMBottomSheetDialogBuilder().u(), o().getMBottomSheetDialogBuilder().s(), o().getMBottomSheetDialogBuilder().q());
        }
        A(frameLayout);
    }

    public final void t() {
        if (this.mBuilder == null) {
            dismissAllowingStateLoss();
        } else {
            x((MartianDialogViewModel) new ViewModelProvider(this).get(MartianDialogViewModel.class));
            o().c(this.mBuilder);
        }
    }

    public void u(@k View bottomSheet, int newState) {
        Intrinsics.checkNotNullParameter(bottomSheet, "bottomSheet");
    }

    public final void v(float dimAmount) {
        Window window;
        Dialog dialog = getDialog();
        if (dialog == null || (window = dialog.getWindow()) == null) {
            return;
        }
        window.setDimAmount(dimAmount);
    }

    public final void w(@l a aVar) {
        this.mBuilder = aVar;
    }

    public final void x(@k MartianDialogViewModel martianDialogViewModel) {
        Intrinsics.checkNotNullParameter(martianDialogViewModel, "<set-?>");
        this.martianDialogViewModel = martianDialogViewModel;
    }
}
