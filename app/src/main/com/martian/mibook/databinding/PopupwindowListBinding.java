package com.martian.mibook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.libmars.ui.theme.ThemeLinearLayout;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.mibook.R;

/* loaded from: classes3.dex */
public final class PopupwindowListBinding implements ViewBinding {

    @NonNull
    public final LinearLayout popupwindowLinear;

    @NonNull
    public final View popupwindowShadeView;

    @NonNull
    public final ThemeTextView popupwindowTitle;

    @NonNull
    public final ThemeLinearLayout popupwindowView;

    @NonNull
    public final View popupwindowViewTop;

    @NonNull
    private final RelativeLayout rootView;

    private PopupwindowListBinding(@NonNull RelativeLayout relativeLayout, @NonNull LinearLayout linearLayout, @NonNull View view, @NonNull ThemeTextView themeTextView, @NonNull ThemeLinearLayout themeLinearLayout, @NonNull View view2) {
        this.rootView = relativeLayout;
        this.popupwindowLinear = linearLayout;
        this.popupwindowShadeView = view;
        this.popupwindowTitle = themeTextView;
        this.popupwindowView = themeLinearLayout;
        this.popupwindowViewTop = view2;
    }

    @NonNull
    public static PopupwindowListBinding bind(@NonNull View view) {
        View findChildViewById;
        View findChildViewById2;
        int i10 = R.id.popupwindow_linear;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i10);
        if (linearLayout != null && (findChildViewById = ViewBindings.findChildViewById(view, (i10 = R.id.popupwindow_shade_view))) != null) {
            i10 = R.id.popupwindow_title;
            ThemeTextView themeTextView = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
            if (themeTextView != null) {
                i10 = R.id.popupwindow_view;
                ThemeLinearLayout themeLinearLayout = (ThemeLinearLayout) ViewBindings.findChildViewById(view, i10);
                if (themeLinearLayout != null && (findChildViewById2 = ViewBindings.findChildViewById(view, (i10 = R.id.popupwindow_view_top))) != null) {
                    return new PopupwindowListBinding((RelativeLayout) view, linearLayout, findChildViewById, themeTextView, themeLinearLayout, findChildViewById2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static PopupwindowListBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static PopupwindowListBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.popupwindow_list, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public RelativeLayout getRoot() {
        return this.rootView;
    }
}
