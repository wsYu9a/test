package com.martian.mibook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.mibook.R;

/* loaded from: classes3.dex */
public final class DialogEdittextBinding implements ViewBinding {

    @NonNull
    public final EditText etDialogContent;

    @NonNull
    private final LinearLayout rootView;

    private DialogEdittextBinding(@NonNull LinearLayout linearLayout, @NonNull EditText editText) {
        this.rootView = linearLayout;
        this.etDialogContent = editText;
    }

    @NonNull
    public static DialogEdittextBinding bind(@NonNull View view) {
        int i10 = R.id.et_dialog_content;
        EditText editText = (EditText) ViewBindings.findChildViewById(view, i10);
        if (editText != null) {
            return new DialogEdittextBinding((LinearLayout) view, editText);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static DialogEdittextBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static DialogEdittextBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.dialog_edittext, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.rootView;
    }
}
