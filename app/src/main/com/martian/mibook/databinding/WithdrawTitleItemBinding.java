package com.martian.mibook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.mibook.R;

/* loaded from: classes3.dex */
public final class WithdrawTitleItemBinding implements ViewBinding {

    @NonNull
    private final LinearLayout rootView;

    @NonNull
    public final View withdrawLine;

    @NonNull
    public final TextView withdrawTitle;

    private WithdrawTitleItemBinding(@NonNull LinearLayout linearLayout, @NonNull View view, @NonNull TextView textView) {
        this.rootView = linearLayout;
        this.withdrawLine = view;
        this.withdrawTitle = textView;
    }

    @NonNull
    public static WithdrawTitleItemBinding bind(@NonNull View view) {
        int i10 = R.id.withdraw_line;
        View findChildViewById = ViewBindings.findChildViewById(view, i10);
        if (findChildViewById != null) {
            i10 = R.id.withdraw_title;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i10);
            if (textView != null) {
                return new WithdrawTitleItemBinding((LinearLayout) view, findChildViewById, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static WithdrawTitleItemBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static WithdrawTitleItemBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.withdraw_title_item, viewGroup, false);
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
