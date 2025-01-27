package com.martian.libmars.fragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import b7.d;
import com.kuaishou.weapon.p0.t;
import com.martian.libmars.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ!\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\t2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u001a\u0010\u0003R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0011\u0010\u001e\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001f¨\u0006 "}, d2 = {"Lcom/martian/libmars/fragment/ProgressDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/app/Dialog;", "onCreateDialog", "(Landroid/os/Bundle;)Landroid/app/Dialog;", "Landroid/view/View;", "view", "", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "", "newMessage", "k", "(Ljava/lang/String;)V", "", "cancel", "j", "(Z)V", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", t.f11204d, "(Landroidx/fragment/app/FragmentManager;)V", "dismiss", "c", "Ljava/lang/String;", d.f1362o, "isShowing", "()Z", "libmars_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes3.dex */
public final class ProgressDialogFragment extends DialogFragment {

    /* renamed from: c, reason: from kotlin metadata */
    @l
    public String b7.d.o java.lang.String;

    public ProgressDialogFragment() {
        Context context = getContext();
        this.b7.d.o java.lang.String = context != null ? context.getString(R.string.loading) : null;
    }

    @Override // androidx.fragment.app.DialogFragment
    public void dismiss() {
        if (isAdded() && isShowing()) {
            Dialog dialog = getDialog();
            if (dialog != null) {
                dialog.dismiss();
            }
            super.dismiss();
        }
    }

    public final boolean isShowing() {
        Dialog dialog = getDialog();
        if (dialog != null) {
            return dialog.isShowing();
        }
        return false;
    }

    public final void j(boolean cancel) {
        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.setCanceledOnTouchOutside(cancel);
        }
    }

    public final void k(@l String newMessage) {
        if (newMessage == null) {
            return;
        }
        this.b7.d.o java.lang.String = newMessage;
        if (getDialog() != null) {
            Dialog dialog = getDialog();
            Intrinsics.checkNotNull(dialog);
            if (dialog.isShowing()) {
                Dialog dialog2 = getDialog();
                TextView textView = dialog2 != null ? (TextView) dialog2.findViewById(R.id.tv_message) : null;
                if (textView == null) {
                    return;
                }
                textView.setText(newMessage);
            }
        }
    }

    public final void l(@k FragmentManager fragmentManager) {
        Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
        if (isAdded()) {
            return;
        }
        super.show(fragmentManager, "progress_dialog");
    }

    @Override // androidx.fragment.app.DialogFragment
    @k
    public Dialog onCreateDialog(@l Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        FragmentActivity activity = getActivity();
        LayoutInflater layoutInflater = activity != null ? activity.getLayoutInflater() : null;
        View inflate = layoutInflater != null ? layoutInflater.inflate(R.layout.dialog_progress, (ViewGroup) null) : null;
        ProgressBar progressBar = inflate != null ? (ProgressBar) inflate.findViewById(R.id.progressBar) : null;
        if (progressBar != null) {
            progressBar.setIndeterminate(true);
        }
        TextView textView = inflate != null ? (TextView) inflate.findViewById(R.id.tv_message) : null;
        if (textView != null) {
            textView.setText(this.b7.d.o java.lang.String);
        }
        builder.setView(inflate).setCancelable(false);
        AlertDialog create = builder.create();
        Intrinsics.checkNotNullExpressionValue(create, "create(...)");
        return create;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@k View view, @l Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.setCanceledOnTouchOutside(false);
        }
    }
}
