package com.martian.mibook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.mibook.R;
import com.martian.mibook.mvvm.read.widget.ReadingSettingLayout;

/* loaded from: classes3.dex */
public final class ReaderMenuSettingLayoutBinding implements ViewBinding {

    @NonNull
    public final CoordinatorLayout bottomMenuContainer;

    @NonNull
    public final ReadingSettingLayout readingSettingLayout;

    @NonNull
    private final CoordinatorLayout rootView;

    private ReaderMenuSettingLayoutBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull CoordinatorLayout coordinatorLayout2, @NonNull ReadingSettingLayout readingSettingLayout) {
        this.rootView = coordinatorLayout;
        this.bottomMenuContainer = coordinatorLayout2;
        this.readingSettingLayout = readingSettingLayout;
    }

    @NonNull
    public static ReaderMenuSettingLayoutBinding bind(@NonNull View view) {
        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) view;
        int i10 = R.id.reading_setting_layout;
        ReadingSettingLayout readingSettingLayout = (ReadingSettingLayout) ViewBindings.findChildViewById(view, i10);
        if (readingSettingLayout != null) {
            return new ReaderMenuSettingLayoutBinding(coordinatorLayout, coordinatorLayout, readingSettingLayout);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static ReaderMenuSettingLayoutBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ReaderMenuSettingLayoutBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.reader_menu_setting_layout, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public CoordinatorLayout getRoot() {
        return this.rootView;
    }
}
