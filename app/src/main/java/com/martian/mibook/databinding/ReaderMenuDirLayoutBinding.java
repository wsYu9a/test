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
import com.martian.mibook.mvvm.read.widget.ReadingDirectoryLayout;

/* loaded from: classes3.dex */
public final class ReaderMenuDirLayoutBinding implements ViewBinding {

    @NonNull
    public final CoordinatorLayout bottomMenuContainer;

    @NonNull
    public final View bottomSheetBg;

    @NonNull
    public final ReadingDirectoryLayout readingDirLayout;

    @NonNull
    private final CoordinatorLayout rootView;

    private ReaderMenuDirLayoutBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull CoordinatorLayout coordinatorLayout2, @NonNull View view, @NonNull ReadingDirectoryLayout readingDirectoryLayout) {
        this.rootView = coordinatorLayout;
        this.bottomMenuContainer = coordinatorLayout2;
        this.bottomSheetBg = view;
        this.readingDirLayout = readingDirectoryLayout;
    }

    @NonNull
    public static ReaderMenuDirLayoutBinding bind(@NonNull View view) {
        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) view;
        int i10 = R.id.bottom_sheet_bg;
        View findChildViewById = ViewBindings.findChildViewById(view, i10);
        if (findChildViewById != null) {
            i10 = R.id.reading_dir_layout;
            ReadingDirectoryLayout readingDirectoryLayout = (ReadingDirectoryLayout) ViewBindings.findChildViewById(view, i10);
            if (readingDirectoryLayout != null) {
                return new ReaderMenuDirLayoutBinding(coordinatorLayout, coordinatorLayout, findChildViewById, readingDirectoryLayout);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static ReaderMenuDirLayoutBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ReaderMenuDirLayoutBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.reader_menu_dir_layout, viewGroup, false);
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
