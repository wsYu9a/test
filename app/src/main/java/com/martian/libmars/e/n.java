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
public final class n implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final LinearLayout f10027a;

    /* renamed from: b */
    @NonNull
    public final ThemeTextView f10028b;

    private n(@NonNull LinearLayout rootView, @NonNull ThemeTextView tvError) {
        this.f10027a = rootView;
        this.f10028b = tvError;
    }

    @NonNull
    public static n a(@NonNull View rootView) {
        int i2 = R.id.tvError;
        ThemeTextView themeTextView = (ThemeTextView) rootView.findViewById(i2);
        if (themeTextView != null) {
            return new n((LinearLayout) rootView, themeTextView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i2)));
    }

    @NonNull
    public static n c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static n d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.layout_irecyclerview_load_more_footer_error_view, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public LinearLayout getRoot() {
        return this.f10027a;
    }
}
