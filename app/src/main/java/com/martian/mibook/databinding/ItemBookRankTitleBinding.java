package com.martian.mibook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.libmars.ui.theme.MiSwitchButton;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.mibook.R;

/* loaded from: classes3.dex */
public final class ItemBookRankTitleBinding implements ViewBinding {

    @NonNull
    private final ConstraintLayout rootView;

    @NonNull
    public final MiSwitchButton switchButton;

    @NonNull
    public final ThemeTextView tvTitle;

    private ItemBookRankTitleBinding(@NonNull ConstraintLayout constraintLayout, @NonNull MiSwitchButton miSwitchButton, @NonNull ThemeTextView themeTextView) {
        this.rootView = constraintLayout;
        this.switchButton = miSwitchButton;
        this.tvTitle = themeTextView;
    }

    @NonNull
    public static ItemBookRankTitleBinding bind(@NonNull View view) {
        int i10 = R.id.switch_button;
        MiSwitchButton miSwitchButton = (MiSwitchButton) ViewBindings.findChildViewById(view, i10);
        if (miSwitchButton != null) {
            i10 = R.id.tv_title;
            ThemeTextView themeTextView = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
            if (themeTextView != null) {
                return new ItemBookRankTitleBinding((ConstraintLayout) view, miSwitchButton, themeTextView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static ItemBookRankTitleBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ItemBookRankTitleBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.item_book_rank_title, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public ConstraintLayout getRoot() {
        return this.rootView;
    }
}
