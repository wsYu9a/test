package com.martian.mibook.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public final class t4 implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final LinearLayout f12736a;

    /* renamed from: b */
    @NonNull
    public final ThemeTextView f12737b;

    private t4(@NonNull LinearLayout rootView, @NonNull ThemeTextView popupwindowItemTitle) {
        this.f12736a = rootView;
        this.f12737b = popupwindowItemTitle;
    }

    @NonNull
    public static t4 a(@NonNull View rootView) {
        ThemeTextView themeTextView = (ThemeTextView) rootView.findViewById(R.id.popupwindow_item_title);
        if (themeTextView != null) {
            return new t4((LinearLayout) rootView, themeTextView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(R.id.popupwindow_item_title)));
    }

    @NonNull
    public static t4 c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static t4 d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.popupwindow_list_item, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public LinearLayout getRoot() {
        return this.f12736a;
    }
}
