package com.martian.mibook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.libmars.ui.theme.ThemeLinearLayout;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.mibook.R;

/* loaded from: classes3.dex */
public final class DialogCoinsExplainBinding implements ViewBinding {

    @NonNull
    public final ThemeTextView dialogDesc;

    @NonNull
    public final ThemeTextView dialogNotarize;

    @NonNull
    public final View dialogShadeView;

    @NonNull
    public final ThemeTextView dialogTitle;

    @NonNull
    public final ThemeLinearLayout dialogView;

    @NonNull
    public final View dialogViewBottom;

    @NonNull
    public final View dialogViewTop;

    @NonNull
    private final RelativeLayout rootView;

    private DialogCoinsExplainBinding(@NonNull RelativeLayout relativeLayout, @NonNull ThemeTextView themeTextView, @NonNull ThemeTextView themeTextView2, @NonNull View view, @NonNull ThemeTextView themeTextView3, @NonNull ThemeLinearLayout themeLinearLayout, @NonNull View view2, @NonNull View view3) {
        this.rootView = relativeLayout;
        this.dialogDesc = themeTextView;
        this.dialogNotarize = themeTextView2;
        this.dialogShadeView = view;
        this.dialogTitle = themeTextView3;
        this.dialogView = themeLinearLayout;
        this.dialogViewBottom = view2;
        this.dialogViewTop = view3;
    }

    @NonNull
    public static DialogCoinsExplainBinding bind(@NonNull View view) {
        View findChildViewById;
        View findChildViewById2;
        View findChildViewById3;
        int i10 = R.id.dialog_desc;
        ThemeTextView themeTextView = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
        if (themeTextView != null) {
            i10 = R.id.dialog_notarize;
            ThemeTextView themeTextView2 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
            if (themeTextView2 != null && (findChildViewById = ViewBindings.findChildViewById(view, (i10 = R.id.dialog_shade_view))) != null) {
                i10 = R.id.dialog_title;
                ThemeTextView themeTextView3 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                if (themeTextView3 != null) {
                    i10 = R.id.dialog_view;
                    ThemeLinearLayout themeLinearLayout = (ThemeLinearLayout) ViewBindings.findChildViewById(view, i10);
                    if (themeLinearLayout != null && (findChildViewById2 = ViewBindings.findChildViewById(view, (i10 = R.id.dialog_view_bottom))) != null && (findChildViewById3 = ViewBindings.findChildViewById(view, (i10 = R.id.dialog_view_top))) != null) {
                        return new DialogCoinsExplainBinding((RelativeLayout) view, themeTextView, themeTextView2, findChildViewById, themeTextView3, themeLinearLayout, findChildViewById2, findChildViewById3);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static DialogCoinsExplainBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static DialogCoinsExplainBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.dialog_coins_explain, viewGroup, false);
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
