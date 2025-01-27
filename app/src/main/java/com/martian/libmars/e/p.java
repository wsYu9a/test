package com.martian.libmars.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.martian.libmars.R;
import com.martian.libmars.ui.theme.ThemeTextView;

/* loaded from: classes2.dex */
public final class p implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final LinearLayout f10031a;

    /* renamed from: b */
    @NonNull
    public final ThemeTextView f10032b;

    private p(@NonNull LinearLayout rootView, @NonNull ThemeTextView tvTheEnd) {
        this.f10031a = rootView;
        this.f10032b = tvTheEnd;
    }

    @NonNull
    public static p a(@NonNull View rootView) {
        int i2 = R.id.tvTheEnd;
        ThemeTextView themeTextView = (ThemeTextView) rootView.findViewById(i2);
        if (themeTextView != null) {
            return new p((LinearLayout) rootView, themeTextView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i2)));
    }

    @NonNull
    public static p c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static p d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.layout_irecyclerview_load_more_footer_the_end_view, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public LinearLayout getRoot() {
        return this.f10031a;
    }
}
