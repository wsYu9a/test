package com.martian.mibook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.libmars.ui.theme.ThemeImageView;
import com.martian.libmars.ui.theme.ThemeLinearLayout;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.mibook.R;

/* loaded from: classes3.dex */
public final class DialogRechargeBinding implements ViewBinding {

    @NonNull
    public final ThemeLinearLayout dialogCheckView;

    @NonNull
    public final ThemeImageView dialogClose;

    @NonNull
    public final ThemeTextView dialogNotarize;

    @NonNull
    public final ThemeTextView dialogTitle;

    @NonNull
    public final ThemeLinearLayout dialogView;

    @NonNull
    public final View dialogViewBottom;

    @NonNull
    public final View dialogViewTop;

    @NonNull
    public final CheckBox dialogWxCheck;

    @NonNull
    public final ThemeLinearLayout dialogWxView;

    @NonNull
    public final CheckBox dialogZfbCheck;

    @NonNull
    public final ThemeLinearLayout dialogZfbView;

    @NonNull
    public final View durationConversionView;

    @NonNull
    private final RelativeLayout rootView;

    private DialogRechargeBinding(@NonNull RelativeLayout relativeLayout, @NonNull ThemeLinearLayout themeLinearLayout, @NonNull ThemeImageView themeImageView, @NonNull ThemeTextView themeTextView, @NonNull ThemeTextView themeTextView2, @NonNull ThemeLinearLayout themeLinearLayout2, @NonNull View view, @NonNull View view2, @NonNull CheckBox checkBox, @NonNull ThemeLinearLayout themeLinearLayout3, @NonNull CheckBox checkBox2, @NonNull ThemeLinearLayout themeLinearLayout4, @NonNull View view3) {
        this.rootView = relativeLayout;
        this.dialogCheckView = themeLinearLayout;
        this.dialogClose = themeImageView;
        this.dialogNotarize = themeTextView;
        this.dialogTitle = themeTextView2;
        this.dialogView = themeLinearLayout2;
        this.dialogViewBottom = view;
        this.dialogViewTop = view2;
        this.dialogWxCheck = checkBox;
        this.dialogWxView = themeLinearLayout3;
        this.dialogZfbCheck = checkBox2;
        this.dialogZfbView = themeLinearLayout4;
        this.durationConversionView = view3;
    }

    @NonNull
    public static DialogRechargeBinding bind(@NonNull View view) {
        View findChildViewById;
        View findChildViewById2;
        View findChildViewById3;
        int i10 = R.id.dialog_check_view;
        ThemeLinearLayout themeLinearLayout = (ThemeLinearLayout) ViewBindings.findChildViewById(view, i10);
        if (themeLinearLayout != null) {
            i10 = R.id.dialog_close;
            ThemeImageView themeImageView = (ThemeImageView) ViewBindings.findChildViewById(view, i10);
            if (themeImageView != null) {
                i10 = R.id.dialog_notarize;
                ThemeTextView themeTextView = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                if (themeTextView != null) {
                    i10 = R.id.dialog_title;
                    ThemeTextView themeTextView2 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                    if (themeTextView2 != null) {
                        i10 = R.id.dialog_view;
                        ThemeLinearLayout themeLinearLayout2 = (ThemeLinearLayout) ViewBindings.findChildViewById(view, i10);
                        if (themeLinearLayout2 != null && (findChildViewById = ViewBindings.findChildViewById(view, (i10 = R.id.dialog_view_bottom))) != null && (findChildViewById2 = ViewBindings.findChildViewById(view, (i10 = R.id.dialog_view_top))) != null) {
                            i10 = R.id.dialog_wx_check;
                            CheckBox checkBox = (CheckBox) ViewBindings.findChildViewById(view, i10);
                            if (checkBox != null) {
                                i10 = R.id.dialog_wx_view;
                                ThemeLinearLayout themeLinearLayout3 = (ThemeLinearLayout) ViewBindings.findChildViewById(view, i10);
                                if (themeLinearLayout3 != null) {
                                    i10 = R.id.dialog_zfb_check;
                                    CheckBox checkBox2 = (CheckBox) ViewBindings.findChildViewById(view, i10);
                                    if (checkBox2 != null) {
                                        i10 = R.id.dialog_zfb_view;
                                        ThemeLinearLayout themeLinearLayout4 = (ThemeLinearLayout) ViewBindings.findChildViewById(view, i10);
                                        if (themeLinearLayout4 != null && (findChildViewById3 = ViewBindings.findChildViewById(view, (i10 = R.id.duration_conversion_view))) != null) {
                                            return new DialogRechargeBinding((RelativeLayout) view, themeLinearLayout, themeImageView, themeTextView, themeTextView2, themeLinearLayout2, findChildViewById, findChildViewById2, checkBox, themeLinearLayout3, checkBox2, themeLinearLayout4, findChildViewById3);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static DialogRechargeBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static DialogRechargeBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.dialog_recharge, viewGroup, false);
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
