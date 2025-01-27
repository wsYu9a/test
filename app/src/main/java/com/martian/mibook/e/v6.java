package com.martian.mibook.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.martian.libmars.ui.theme.ThemeEditText;
import com.martian.libmars.ui.theme.ThemeImageView;
import com.martian.libmars.ui.theme.ThemeLinearLayout;
import com.martian.libmars.ui.theme.ThemeRelativeLayout;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public final class v6 implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final ThemeRelativeLayout f12847a;

    /* renamed from: b */
    @NonNull
    public final ThemeImageView f12848b;

    /* renamed from: c */
    @NonNull
    public final ThemeEditText f12849c;

    /* renamed from: d */
    @NonNull
    public final ThemeLinearLayout f12850d;

    private v6(@NonNull ThemeRelativeLayout rootView, @NonNull ThemeImageView btnClearSearchText, @NonNull ThemeEditText scEditText, @NonNull ThemeLinearLayout searchView) {
        this.f12847a = rootView;
        this.f12848b = btnClearSearchText;
        this.f12849c = scEditText;
        this.f12850d = searchView;
    }

    @NonNull
    public static v6 a(@NonNull View rootView) {
        int i2 = R.id.btn_clear_search_text;
        ThemeImageView themeImageView = (ThemeImageView) rootView.findViewById(R.id.btn_clear_search_text);
        if (themeImageView != null) {
            i2 = R.id.sc_edit_text;
            ThemeEditText themeEditText = (ThemeEditText) rootView.findViewById(R.id.sc_edit_text);
            if (themeEditText != null) {
                i2 = R.id.search_view;
                ThemeLinearLayout themeLinearLayout = (ThemeLinearLayout) rootView.findViewById(R.id.search_view);
                if (themeLinearLayout != null) {
                    return new v6((ThemeRelativeLayout) rootView, themeImageView, themeEditText, themeLinearLayout);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i2)));
    }

    @NonNull
    public static v6 c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static v6 d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.search_custom_view, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public ThemeRelativeLayout getRoot() {
        return this.f12847a;
    }
}
