package com.martian.mibook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.libmars.ui.theme.ThemeRelativeLayout;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.mibook.R;

/* loaded from: classes3.dex */
public final class ActivityTeenagerBookmallBinding implements ViewBinding {

    @NonNull
    private final ThemeRelativeLayout rootView;

    @NonNull
    public final ImageView teenagerBookmallBg;

    @NonNull
    public final ThemeTextView teenagerBookmallButton;

    @NonNull
    public final FrameLayout teenagerBookmallContainer;

    @NonNull
    public final ThemeTextView teenagerBookmallExit;

    @NonNull
    public final LinearLayout teenagerBookmallHeader;

    @NonNull
    public final ImageView teenagerBookmallLogo;

    @NonNull
    public final ThemeTextView teenagerBookmallTitle;

    private ActivityTeenagerBookmallBinding(@NonNull ThemeRelativeLayout themeRelativeLayout, @NonNull ImageView imageView, @NonNull ThemeTextView themeTextView, @NonNull FrameLayout frameLayout, @NonNull ThemeTextView themeTextView2, @NonNull LinearLayout linearLayout, @NonNull ImageView imageView2, @NonNull ThemeTextView themeTextView3) {
        this.rootView = themeRelativeLayout;
        this.teenagerBookmallBg = imageView;
        this.teenagerBookmallButton = themeTextView;
        this.teenagerBookmallContainer = frameLayout;
        this.teenagerBookmallExit = themeTextView2;
        this.teenagerBookmallHeader = linearLayout;
        this.teenagerBookmallLogo = imageView2;
        this.teenagerBookmallTitle = themeTextView3;
    }

    @NonNull
    public static ActivityTeenagerBookmallBinding bind(@NonNull View view) {
        int i10 = R.id.teenager_bookmall_bg;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i10);
        if (imageView != null) {
            i10 = R.id.teenager_bookmall_button;
            ThemeTextView themeTextView = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
            if (themeTextView != null) {
                i10 = R.id.teenager_bookmall_container;
                FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i10);
                if (frameLayout != null) {
                    i10 = R.id.teenager_bookmall_exit;
                    ThemeTextView themeTextView2 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                    if (themeTextView2 != null) {
                        i10 = R.id.teenager_bookmall_header;
                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i10);
                        if (linearLayout != null) {
                            i10 = R.id.teenager_bookmall_logo;
                            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i10);
                            if (imageView2 != null) {
                                i10 = R.id.teenager_bookmall_title;
                                ThemeTextView themeTextView3 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                                if (themeTextView3 != null) {
                                    return new ActivityTeenagerBookmallBinding((ThemeRelativeLayout) view, imageView, themeTextView, frameLayout, themeTextView2, linearLayout, imageView2, themeTextView3);
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
    public static ActivityTeenagerBookmallBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ActivityTeenagerBookmallBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.activity_teenager_bookmall, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public ThemeRelativeLayout getRoot() {
        return this.rootView;
    }
}
