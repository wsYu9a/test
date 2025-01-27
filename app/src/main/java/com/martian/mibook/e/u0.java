package com.martian.mibook.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.martian.libmars.ui.theme.ThemeImageView;
import com.martian.libmars.ui.theme.ThemeLinearLayout;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public final class u0 implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final LinearLayout f12759a;

    /* renamed from: b */
    @NonNull
    public final ThemeImageView f12760b;

    /* renamed from: c */
    @NonNull
    public final ThemeLinearLayout f12761c;

    private u0(@NonNull LinearLayout rootView, @NonNull ThemeImageView menuIconBookImport, @NonNull ThemeLinearLayout menuReport) {
        this.f12759a = rootView;
        this.f12760b = menuIconBookImport;
        this.f12761c = menuReport;
    }

    @NonNull
    public static u0 a(@NonNull View rootView) {
        int i2 = R.id.menu_icon_book_import;
        ThemeImageView themeImageView = (ThemeImageView) rootView.findViewById(R.id.menu_icon_book_import);
        if (themeImageView != null) {
            i2 = R.id.menu_report;
            ThemeLinearLayout themeLinearLayout = (ThemeLinearLayout) rootView.findViewById(R.id.menu_report);
            if (themeLinearLayout != null) {
                return new u0((LinearLayout) rootView, themeImageView, themeLinearLayout);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i2)));
    }

    @NonNull
    public static u0 c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static u0 d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.book_info_menu, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public LinearLayout getRoot() {
        return this.f12759a;
    }
}
