package com.martian.mibook.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.martian.libmars.ui.theme.ThemeImageView;
import com.martian.libmars.ui.theme.ThemeLinearLayout;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public final class r2 implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final RelativeLayout f12602a;

    /* renamed from: b */
    @NonNull
    public final ThemeTextView f12603b;

    /* renamed from: c */
    @NonNull
    public final ThemeImageView f12604c;

    /* renamed from: d */
    @NonNull
    public final LinearLayout f12605d;

    /* renamed from: e */
    @NonNull
    public final ThemeLinearLayout f12606e;

    private r2(@NonNull RelativeLayout rootView, @NonNull ThemeTextView teenageButton, @NonNull ThemeImageView teenageClose, @NonNull LinearLayout teenageOpen, @NonNull ThemeLinearLayout teenageView) {
        this.f12602a = rootView;
        this.f12603b = teenageButton;
        this.f12604c = teenageClose;
        this.f12605d = teenageOpen;
        this.f12606e = teenageView;
    }

    @NonNull
    public static r2 a(@NonNull View rootView) {
        int i2 = R.id.teenage_button;
        ThemeTextView themeTextView = (ThemeTextView) rootView.findViewById(R.id.teenage_button);
        if (themeTextView != null) {
            i2 = R.id.teenage_close;
            ThemeImageView themeImageView = (ThemeImageView) rootView.findViewById(R.id.teenage_close);
            if (themeImageView != null) {
                i2 = R.id.teenage_open;
                LinearLayout linearLayout = (LinearLayout) rootView.findViewById(R.id.teenage_open);
                if (linearLayout != null) {
                    i2 = R.id.teenage_view;
                    ThemeLinearLayout themeLinearLayout = (ThemeLinearLayout) rootView.findViewById(R.id.teenage_view);
                    if (themeLinearLayout != null) {
                        return new r2((RelativeLayout) rootView, themeTextView, themeImageView, linearLayout, themeLinearLayout);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i2)));
    }

    @NonNull
    public static r2 c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static r2 d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.dialog_teenage_guide, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f12602a;
    }
}
