package com.martian.mibook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.mibook.R;

/* loaded from: classes3.dex */
public final class PopupwindowListItemBinding implements ViewBinding {

    @NonNull
    public final ThemeTextView popupwindowItemTitle;

    @NonNull
    private final LinearLayout rootView;

    private PopupwindowListItemBinding(@NonNull LinearLayout linearLayout, @NonNull ThemeTextView themeTextView) {
        this.rootView = linearLayout;
        this.popupwindowItemTitle = themeTextView;
    }

    @NonNull
    public static PopupwindowListItemBinding bind(@NonNull View view) {
        int i10 = R.id.popupwindow_item_title;
        ThemeTextView themeTextView = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
        if (themeTextView != null) {
            return new PopupwindowListItemBinding((LinearLayout) view, themeTextView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static PopupwindowListItemBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static PopupwindowListItemBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.popupwindow_list_item, viewGroup, false);
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
