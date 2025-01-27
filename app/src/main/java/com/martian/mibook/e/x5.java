package com.martian.mibook.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import com.martian.libmars.ui.theme.ThemeLinearLayout;
import com.martian.mibook.ui.MyGridView;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public final class x5 implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final CoordinatorLayout f12940a;

    /* renamed from: b */
    @NonNull
    public final ThemeLinearLayout f12941b;

    /* renamed from: c */
    @NonNull
    public final MyGridView f12942c;

    /* renamed from: d */
    @NonNull
    public final CoordinatorLayout f12943d;

    /* renamed from: e */
    @NonNull
    public final ThemeLinearLayout f12944e;

    private x5(@NonNull CoordinatorLayout rootView, @NonNull ThemeLinearLayout bookChapterNext, @NonNull MyGridView exitDialogBooks, @NonNull CoordinatorLayout exitDialogRootView, @NonNull ThemeLinearLayout exitDialogView) {
        this.f12940a = rootView;
        this.f12941b = bookChapterNext;
        this.f12942c = exitDialogBooks;
        this.f12943d = exitDialogRootView;
        this.f12944e = exitDialogView;
    }

    @NonNull
    public static x5 a(@NonNull View rootView) {
        int i2 = R.id.book_chapter_next;
        ThemeLinearLayout themeLinearLayout = (ThemeLinearLayout) rootView.findViewById(R.id.book_chapter_next);
        if (themeLinearLayout != null) {
            i2 = R.id.exit_dialog_books;
            MyGridView myGridView = (MyGridView) rootView.findViewById(R.id.exit_dialog_books);
            if (myGridView != null) {
                CoordinatorLayout coordinatorLayout = (CoordinatorLayout) rootView;
                i2 = R.id.exit_dialog_view;
                ThemeLinearLayout themeLinearLayout2 = (ThemeLinearLayout) rootView.findViewById(R.id.exit_dialog_view);
                if (themeLinearLayout2 != null) {
                    return new x5(coordinatorLayout, themeLinearLayout, myGridView, coordinatorLayout, themeLinearLayout2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i2)));
    }

    @NonNull
    public static x5 c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static x5 d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.reading_exit_dialog, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public CoordinatorLayout getRoot() {
        return this.f12940a;
    }
}
