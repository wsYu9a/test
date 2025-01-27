package com.martian.mibook.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.martian.libmars.ui.theme.ThemeLinearLayout;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public final class k1 implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final ThemeLinearLayout f12229a;

    /* renamed from: b */
    @NonNull
    public final ThemeTextView f12230b;

    /* renamed from: c */
    @NonNull
    public final ThemeTextView f12231c;

    /* renamed from: d */
    @NonNull
    public final ThemeLinearLayout f12232d;

    private k1(@NonNull ThemeLinearLayout rootView, @NonNull ThemeTextView bpDone, @NonNull ThemeTextView bpSelectAll, @NonNull ThemeLinearLayout brHeaderSetting) {
        this.f12229a = rootView;
        this.f12230b = bpDone;
        this.f12231c = bpSelectAll;
        this.f12232d = brHeaderSetting;
    }

    @NonNull
    public static k1 a(@NonNull View rootView) {
        int i2 = R.id.bp_done;
        ThemeTextView themeTextView = (ThemeTextView) rootView.findViewById(R.id.bp_done);
        if (themeTextView != null) {
            i2 = R.id.bp_select_all;
            ThemeTextView themeTextView2 = (ThemeTextView) rootView.findViewById(R.id.bp_select_all);
            if (themeTextView2 != null) {
                ThemeLinearLayout themeLinearLayout = (ThemeLinearLayout) rootView;
                return new k1(themeLinearLayout, themeTextView, themeTextView2, themeLinearLayout);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i2)));
    }

    @NonNull
    public static k1 c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static k1 d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.bookrack_batch_top_view, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public ThemeLinearLayout getRoot() {
        return this.f12229a;
    }
}
