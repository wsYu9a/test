package com.martian.mibook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.libmars.ui.theme.ThemeImageView;
import com.martian.libmars.ui.theme.ThemeLinearLayout;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.mibook.R;

/* loaded from: classes3.dex */
public final class DialogActivateVipBinding implements ViewBinding {

    @NonNull
    public final FrameLayout fragmentContainer;

    @NonNull
    public final ThemeImageView ivTopLine;

    @NonNull
    private final ThemeLinearLayout rootView;

    @NonNull
    public final ThemeImageView timingWindowClose;

    @NonNull
    public final ThemeTextView tvTitle;

    private DialogActivateVipBinding(@NonNull ThemeLinearLayout themeLinearLayout, @NonNull FrameLayout frameLayout, @NonNull ThemeImageView themeImageView, @NonNull ThemeImageView themeImageView2, @NonNull ThemeTextView themeTextView) {
        this.rootView = themeLinearLayout;
        this.fragmentContainer = frameLayout;
        this.ivTopLine = themeImageView;
        this.timingWindowClose = themeImageView2;
        this.tvTitle = themeTextView;
    }

    @NonNull
    public static DialogActivateVipBinding bind(@NonNull View view) {
        int i10 = R.id.fragment_container;
        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i10);
        if (frameLayout != null) {
            i10 = R.id.iv_top_line;
            ThemeImageView themeImageView = (ThemeImageView) ViewBindings.findChildViewById(view, i10);
            if (themeImageView != null) {
                i10 = R.id.timing_window_close;
                ThemeImageView themeImageView2 = (ThemeImageView) ViewBindings.findChildViewById(view, i10);
                if (themeImageView2 != null) {
                    i10 = R.id.tv_title;
                    ThemeTextView themeTextView = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                    if (themeTextView != null) {
                        return new DialogActivateVipBinding((ThemeLinearLayout) view, frameLayout, themeImageView, themeImageView2, themeTextView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static DialogActivateVipBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static DialogActivateVipBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.dialog_activate_vip, viewGroup, false);
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
