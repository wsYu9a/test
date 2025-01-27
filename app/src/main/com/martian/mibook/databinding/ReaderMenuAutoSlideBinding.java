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
import com.martian.mibook.mvvm.read.widget.ReadingAutoSlideLayout;

/* loaded from: classes3.dex */
public final class ReaderMenuAutoSlideBinding implements ViewBinding {

    @NonNull
    public final CoordinatorLayout bottomMenuContainer;

    @NonNull
    public final ReadingAutoSlideLayout readingAutoSlideLayout;

    @NonNull
    private final CoordinatorLayout rootView;

    private ReaderMenuAutoSlideBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull CoordinatorLayout coordinatorLayout2, @NonNull ReadingAutoSlideLayout readingAutoSlideLayout) {
        this.rootView = coordinatorLayout;
        this.bottomMenuContainer = coordinatorLayout2;
        this.readingAutoSlideLayout = readingAutoSlideLayout;
    }

    @NonNull
    public static ReaderMenuAutoSlideBinding bind(@NonNull View view) {
        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) view;
        int i10 = R.id.reading_auto_slide_layout;
        ReadingAutoSlideLayout readingAutoSlideLayout = (ReadingAutoSlideLayout) ViewBindings.findChildViewById(view, i10);
        if (readingAutoSlideLayout != null) {
            return new ReaderMenuAutoSlideBinding(coordinatorLayout, coordinatorLayout, readingAutoSlideLayout);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static ReaderMenuAutoSlideBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ReaderMenuAutoSlideBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.reader_menu_auto_slide, viewGroup, false);
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
