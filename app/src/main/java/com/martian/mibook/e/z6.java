package com.martian.mibook.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.martian.libmars.ui.theme.ThemeImageView;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public final class z6 implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final LinearLayout f13031a;

    /* renamed from: b */
    @NonNull
    public final ThemeImageView f13032b;

    /* renamed from: c */
    @NonNull
    public final ThemeTextView f13033c;

    private z6(@NonNull LinearLayout rootView, @NonNull ThemeImageView scRcLogo, @NonNull ThemeTextView scRcTitle) {
        this.f13031a = rootView;
        this.f13032b = scRcLogo;
        this.f13033c = scRcTitle;
    }

    @NonNull
    public static z6 a(@NonNull View rootView) {
        int i2 = R.id.sc_rc_logo;
        ThemeImageView themeImageView = (ThemeImageView) rootView.findViewById(R.id.sc_rc_logo);
        if (themeImageView != null) {
            i2 = R.id.sc_rc_title;
            ThemeTextView themeTextView = (ThemeTextView) rootView.findViewById(R.id.sc_rc_title);
            if (themeTextView != null) {
                return new z6((LinearLayout) rootView, themeImageView, themeTextView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i2)));
    }

    @NonNull
    public static z6 c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static z6 d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.search_recommend_item, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public LinearLayout getRoot() {
        return this.f13031a;
    }
}
