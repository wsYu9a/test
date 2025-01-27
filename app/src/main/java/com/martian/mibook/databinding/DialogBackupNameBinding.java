package com.martian.mibook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.mibook.R;

/* loaded from: classes3.dex */
public final class DialogBackupNameBinding implements ViewBinding {

    @NonNull
    public final EditText etBackupName;

    @NonNull
    private final LinearLayout rootView;

    @NonNull
    public final TextView tvBackupSuffix;

    private DialogBackupNameBinding(@NonNull LinearLayout linearLayout, @NonNull EditText editText, @NonNull TextView textView) {
        this.rootView = linearLayout;
        this.etBackupName = editText;
        this.tvBackupSuffix = textView;
    }

    @NonNull
    public static DialogBackupNameBinding bind(@NonNull View view) {
        int i10 = R.id.et_backup_name;
        EditText editText = (EditText) ViewBindings.findChildViewById(view, i10);
        if (editText != null) {
            i10 = R.id.tv_backup_suffix;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i10);
            if (textView != null) {
                return new DialogBackupNameBinding((LinearLayout) view, editText, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static DialogBackupNameBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static DialogBackupNameBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.dialog_backup_name, viewGroup, false);
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
