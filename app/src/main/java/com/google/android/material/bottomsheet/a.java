package com.google.android.material.bottomsheet;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

/* loaded from: classes.dex */
public class a extends AppCompatDialogFragment {

    /* renamed from: a */
    private boolean f6870a;

    private class b extends BottomSheetBehavior.f {
        private b() {
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.f
        public void a(@NonNull View view, float f2) {
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.f
        public void b(@NonNull View view, int i2) {
            if (i2 == 5) {
                a.this.b();
            }
        }

        /* synthetic */ b(a aVar, C0083a c0083a) {
            this();
        }
    }

    public void b() {
        if (this.f6870a) {
            super.dismissAllowingStateLoss();
        } else {
            super.dismiss();
        }
    }

    private void c(@NonNull BottomSheetBehavior<?> bottomSheetBehavior, boolean z) {
        this.f6870a = z;
        if (bottomSheetBehavior.z() == 5) {
            b();
            return;
        }
        if (getDialog() instanceof BottomSheetDialog) {
            ((BottomSheetDialog) getDialog()).f();
        }
        bottomSheetBehavior.i(new b());
        bottomSheetBehavior.T(5);
    }

    private boolean d(boolean z) {
        Dialog dialog = getDialog();
        if (!(dialog instanceof BottomSheetDialog)) {
            return false;
        }
        BottomSheetDialog bottomSheetDialog = (BottomSheetDialog) dialog;
        BottomSheetBehavior<FrameLayout> d2 = bottomSheetDialog.d();
        if (!d2.E() || !bottomSheetDialog.e()) {
            return false;
        }
        c(d2, z);
        return true;
    }

    @Override // androidx.fragment.app.DialogFragment
    public void dismiss() {
        if (d(false)) {
            return;
        }
        super.dismiss();
    }

    @Override // androidx.fragment.app.DialogFragment
    public void dismissAllowingStateLoss() {
        if (d(true)) {
            return;
        }
        super.dismissAllowingStateLoss();
    }

    @Override // androidx.appcompat.app.AppCompatDialogFragment, androidx.fragment.app.DialogFragment
    @NonNull
    public Dialog onCreateDialog(@Nullable Bundle bundle) {
        return new BottomSheetDialog(getContext(), getTheme());
    }
}
