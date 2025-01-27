package com.martian.mibook.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.martian.libmars.ui.theme.ThemeLinearLayout;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public final class c0 implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final ThemeLinearLayout f11775a;

    /* renamed from: b */
    @NonNull
    public final LinearLayout f11776b;

    /* renamed from: c */
    @NonNull
    public final ThemeTextView f11777c;

    private c0(@NonNull ThemeLinearLayout rootView, @NonNull LinearLayout earnLimitationView, @NonNull ThemeTextView withdrawNumberLeft) {
        this.f11775a = rootView;
        this.f11776b = earnLimitationView;
        this.f11777c = withdrawNumberLeft;
    }

    @NonNull
    public static c0 a(@NonNull View rootView) {
        int i2 = R.id.earn_limitation_view;
        LinearLayout linearLayout = (LinearLayout) rootView.findViewById(R.id.earn_limitation_view);
        if (linearLayout != null) {
            i2 = R.id.withdraw_number_left;
            ThemeTextView themeTextView = (ThemeTextView) rootView.findViewById(R.id.withdraw_number_left);
            if (themeTextView != null) {
                return new c0((ThemeLinearLayout) rootView, linearLayout, themeTextView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i2)));
    }

    @NonNull
    public static c0 c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static c0 d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.activity_txs_withdraw_limitation, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public ThemeLinearLayout getRoot() {
        return this.f11775a;
    }
}
