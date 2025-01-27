package com.martian.mibook.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public final class i0 implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final ThemeTextView f12102a;

    /* renamed from: b */
    @NonNull
    public final ThemeTextView f12103b;

    private i0(@NonNull ThemeTextView rootView, @NonNull ThemeTextView tvTagName) {
        this.f12102a = rootView;
        this.f12103b = tvTagName;
    }

    @NonNull
    public static i0 a(@NonNull View rootView) {
        if (rootView == null) {
            throw new NullPointerException("rootView");
        }
        ThemeTextView themeTextView = (ThemeTextView) rootView;
        return new i0(themeTextView, themeTextView);
    }

    @NonNull
    public static i0 c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static i0 d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.archive_tag_item, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public ThemeTextView getRoot() {
        return this.f12102a;
    }
}
