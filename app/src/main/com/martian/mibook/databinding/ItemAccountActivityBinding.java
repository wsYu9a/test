package com.martian.mibook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.mibook.R;

/* loaded from: classes3.dex */
public final class ItemAccountActivityBinding implements ViewBinding {

    @NonNull
    public final ThemeTextView activityDesc;

    @NonNull
    public final ImageView activityIcon;

    @NonNull
    public final ThemeTextView activityTitle;

    @NonNull
    public final LinearLayout llTitle;

    @NonNull
    private final ConstraintLayout rootView;

    private ItemAccountActivityBinding(@NonNull ConstraintLayout constraintLayout, @NonNull ThemeTextView themeTextView, @NonNull ImageView imageView, @NonNull ThemeTextView themeTextView2, @NonNull LinearLayout linearLayout) {
        this.rootView = constraintLayout;
        this.activityDesc = themeTextView;
        this.activityIcon = imageView;
        this.activityTitle = themeTextView2;
        this.llTitle = linearLayout;
    }

    @NonNull
    public static ItemAccountActivityBinding bind(@NonNull View view) {
        int i10 = R.id.activity_desc;
        ThemeTextView themeTextView = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
        if (themeTextView != null) {
            i10 = R.id.activity_icon;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i10);
            if (imageView != null) {
                i10 = R.id.activity_title;
                ThemeTextView themeTextView2 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                if (themeTextView2 != null) {
                    i10 = R.id.ll_title;
                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i10);
                    if (linearLayout != null) {
                        return new ItemAccountActivityBinding((ConstraintLayout) view, themeTextView, imageView, themeTextView2, linearLayout);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static ItemAccountActivityBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ItemAccountActivityBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.item_account_activity, viewGroup, false);
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
