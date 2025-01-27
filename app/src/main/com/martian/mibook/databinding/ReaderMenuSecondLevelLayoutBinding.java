package com.martian.mibook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import com.martian.mibook.R;

/* loaded from: classes3.dex */
public final class ReaderMenuSecondLevelLayoutBinding implements ViewBinding {

    @NonNull
    public final CoordinatorLayout bottomMenuContainer;

    @NonNull
    private final CoordinatorLayout rootView;

    private ReaderMenuSecondLevelLayoutBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull CoordinatorLayout coordinatorLayout2) {
        this.rootView = coordinatorLayout;
        this.bottomMenuContainer = coordinatorLayout2;
    }

    @NonNull
    public static ReaderMenuSecondLevelLayoutBinding bind(@NonNull View view) {
        if (view == null) {
            throw new NullPointerException("rootView");
        }
        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) view;
        return new ReaderMenuSecondLevelLayoutBinding(coordinatorLayout, coordinatorLayout);
    }

    @NonNull
    public static ReaderMenuSecondLevelLayoutBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ReaderMenuSecondLevelLayoutBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.reader_menu_second_level_layout, viewGroup, false);
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
