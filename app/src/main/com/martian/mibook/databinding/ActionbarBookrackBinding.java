package com.martian.mibook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.libmars.ui.theme.ThemeLinearLayout;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.mibook.R;

/* loaded from: classes3.dex */
public final class ActionbarBookrackBinding implements ViewBinding {

    @NonNull
    public final LinearLayout brClass;

    @NonNull
    public final ThemeLinearLayout brHeaderSetting;

    @NonNull
    public final ThemeLinearLayout brHeaderSettingView;

    @NonNull
    public final ThemeTextView brMyClass;

    @NonNull
    public final ImageView brMyClassDot;

    @NonNull
    private final ThemeLinearLayout rootView;

    private ActionbarBookrackBinding(@NonNull ThemeLinearLayout themeLinearLayout, @NonNull LinearLayout linearLayout, @NonNull ThemeLinearLayout themeLinearLayout2, @NonNull ThemeLinearLayout themeLinearLayout3, @NonNull ThemeTextView themeTextView, @NonNull ImageView imageView) {
        this.rootView = themeLinearLayout;
        this.brClass = linearLayout;
        this.brHeaderSetting = themeLinearLayout2;
        this.brHeaderSettingView = themeLinearLayout3;
        this.brMyClass = themeTextView;
        this.brMyClassDot = imageView;
    }

    @NonNull
    public static ActionbarBookrackBinding bind(@NonNull View view) {
        int i10 = R.id.br_class;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i10);
        if (linearLayout != null) {
            i10 = R.id.br_header_setting;
            ThemeLinearLayout themeLinearLayout = (ThemeLinearLayout) ViewBindings.findChildViewById(view, i10);
            if (themeLinearLayout != null) {
                ThemeLinearLayout themeLinearLayout2 = (ThemeLinearLayout) view;
                i10 = R.id.br_my_class;
                ThemeTextView themeTextView = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                if (themeTextView != null) {
                    i10 = R.id.br_my_class_dot;
                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i10);
                    if (imageView != null) {
                        return new ActionbarBookrackBinding(themeLinearLayout2, linearLayout, themeLinearLayout, themeLinearLayout2, themeTextView, imageView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static ActionbarBookrackBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ActionbarBookrackBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.actionbar_bookrack, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public ThemeLinearLayout getRoot() {
        return this.rootView;
    }
}
