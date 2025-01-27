package com.martian.mibook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.libmars.ui.theme.ThemeImageView;
import com.martian.libmars.ui.theme.ThemeLinearLayout;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.mibook.R;

/* loaded from: classes3.dex */
public final class ActivityReadingRecordBinding implements ViewBinding {

    @NonNull
    public final ThemeImageView actionbarBack;

    @NonNull
    public final ThemeTextView actionbarTitle;

    @NonNull
    public final FrameLayout fragmentContainer;

    @NonNull
    private final ThemeLinearLayout rootView;

    @NonNull
    public final Toolbar toolbar;

    @NonNull
    public final ThemeTextView tvManage;

    private ActivityReadingRecordBinding(@NonNull ThemeLinearLayout themeLinearLayout, @NonNull ThemeImageView themeImageView, @NonNull ThemeTextView themeTextView, @NonNull FrameLayout frameLayout, @NonNull Toolbar toolbar, @NonNull ThemeTextView themeTextView2) {
        this.rootView = themeLinearLayout;
        this.actionbarBack = themeImageView;
        this.actionbarTitle = themeTextView;
        this.fragmentContainer = frameLayout;
        this.toolbar = toolbar;
        this.tvManage = themeTextView2;
    }

    @NonNull
    public static ActivityReadingRecordBinding bind(@NonNull View view) {
        int i10 = R.id.actionbar_back;
        ThemeImageView themeImageView = (ThemeImageView) ViewBindings.findChildViewById(view, i10);
        if (themeImageView != null) {
            i10 = R.id.actionbar_title;
            ThemeTextView themeTextView = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
            if (themeTextView != null) {
                i10 = R.id.fragment_container;
                FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i10);
                if (frameLayout != null) {
                    i10 = R.id.toolbar;
                    Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(view, i10);
                    if (toolbar != null) {
                        i10 = R.id.tv_manage;
                        ThemeTextView themeTextView2 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                        if (themeTextView2 != null) {
                            return new ActivityReadingRecordBinding((ThemeLinearLayout) view, themeImageView, themeTextView, frameLayout, toolbar, themeTextView2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static ActivityReadingRecordBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ActivityReadingRecordBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.activity_reading_record, viewGroup, false);
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
