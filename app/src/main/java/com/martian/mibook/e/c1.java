package com.martian.mibook.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.martian.libmars.ui.theme.ThemeEditText;
import com.martian.libmars.ui.theme.ThemeImageView;
import com.martian.libmars.ui.theme.ThemeLinearLayout;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public final class c1 implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final RelativeLayout f11778a;

    /* renamed from: b */
    @NonNull
    public final View f11779b;

    /* renamed from: c */
    @NonNull
    public final ThemeLinearLayout f11780c;

    /* renamed from: d */
    @NonNull
    public final ThemeImageView f11781d;

    /* renamed from: e */
    @NonNull
    public final ThemeEditText f11782e;

    private c1(@NonNull RelativeLayout rootView, @NonNull View bookrackStoreHeaderShade, @NonNull ThemeLinearLayout brSearch, @NonNull ThemeImageView btnClearSearchText, @NonNull ThemeEditText etSearch) {
        this.f11778a = rootView;
        this.f11779b = bookrackStoreHeaderShade;
        this.f11780c = brSearch;
        this.f11781d = btnClearSearchText;
        this.f11782e = etSearch;
    }

    @NonNull
    public static c1 a(@NonNull View rootView) {
        int i2 = R.id.bookrack_store_header_shade;
        View findViewById = rootView.findViewById(R.id.bookrack_store_header_shade);
        if (findViewById != null) {
            i2 = R.id.br_search;
            ThemeLinearLayout themeLinearLayout = (ThemeLinearLayout) rootView.findViewById(R.id.br_search);
            if (themeLinearLayout != null) {
                i2 = R.id.btn_clear_search_text;
                ThemeImageView themeImageView = (ThemeImageView) rootView.findViewById(R.id.btn_clear_search_text);
                if (themeImageView != null) {
                    i2 = R.id.et_search;
                    ThemeEditText themeEditText = (ThemeEditText) rootView.findViewById(R.id.et_search);
                    if (themeEditText != null) {
                        return new c1((RelativeLayout) rootView, findViewById, themeLinearLayout, themeImageView, themeEditText);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i2)));
    }

    @NonNull
    public static c1 c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static c1 d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.book_store_header, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f11778a;
    }
}
