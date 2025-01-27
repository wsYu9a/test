package com.martian.mibook.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.martian.libmars.ui.theme.ThemeEditText;
import com.martian.libmars.ui.theme.ThemeGridView;
import com.martian.libmars.ui.theme.ThemeImageView;
import com.martian.libmars.ui.theme.ThemeLinearLayout;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public final class i implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final ThemeLinearLayout f12097a;

    /* renamed from: b */
    @NonNull
    public final ThemeImageView f12098b;

    /* renamed from: c */
    @NonNull
    public final ThemeEditText f12099c;

    /* renamed from: d */
    @NonNull
    public final ThemeGridView f12100d;

    /* renamed from: e */
    @NonNull
    public final ThemeLinearLayout f12101e;

    private i(@NonNull ThemeLinearLayout rootView, @NonNull ThemeImageView btnClearSearchText, @NonNull ThemeEditText etBookName, @NonNull ThemeGridView gvCoverList, @NonNull ThemeLinearLayout searchView) {
        this.f12097a = rootView;
        this.f12098b = btnClearSearchText;
        this.f12099c = etBookName;
        this.f12100d = gvCoverList;
        this.f12101e = searchView;
    }

    @NonNull
    public static i a(@NonNull View rootView) {
        int i2 = R.id.btn_clear_search_text;
        ThemeImageView themeImageView = (ThemeImageView) rootView.findViewById(R.id.btn_clear_search_text);
        if (themeImageView != null) {
            i2 = R.id.et_book_name;
            ThemeEditText themeEditText = (ThemeEditText) rootView.findViewById(R.id.et_book_name);
            if (themeEditText != null) {
                i2 = R.id.gv_cover_list;
                ThemeGridView themeGridView = (ThemeGridView) rootView.findViewById(R.id.gv_cover_list);
                if (themeGridView != null) {
                    i2 = R.id.search_view;
                    ThemeLinearLayout themeLinearLayout = (ThemeLinearLayout) rootView.findViewById(R.id.search_view);
                    if (themeLinearLayout != null) {
                        return new i((ThemeLinearLayout) rootView, themeImageView, themeEditText, themeGridView, themeLinearLayout);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i2)));
    }

    @NonNull
    public static i c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static i d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.activity_cover_switch, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public ThemeLinearLayout getRoot() {
        return this.f12097a;
    }
}
