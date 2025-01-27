package com.martian.mibook.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.martian.libmars.ui.theme.ThemeEditText;
import com.martian.libmars.ui.theme.ThemeRelativeLayout;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public final class b0 implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final ThemeRelativeLayout f11725a;

    /* renamed from: b */
    @NonNull
    public final LinearLayout f11726b;

    /* renamed from: c */
    @NonNull
    public final ThemeEditText f11727c;

    /* renamed from: d */
    @NonNull
    public final ThemeTextView f11728d;

    private b0(@NonNull ThemeRelativeLayout rootView, @NonNull LinearLayout removeBlackLoading, @NonNull ThemeEditText removeReason, @NonNull ThemeTextView withdrawLeftCount) {
        this.f11725a = rootView;
        this.f11726b = removeBlackLoading;
        this.f11727c = removeReason;
        this.f11728d = withdrawLeftCount;
    }

    @NonNull
    public static b0 a(@NonNull View rootView) {
        int i2 = R.id.remove_black_loading;
        LinearLayout linearLayout = (LinearLayout) rootView.findViewById(R.id.remove_black_loading);
        if (linearLayout != null) {
            i2 = R.id.remove_reason;
            ThemeEditText themeEditText = (ThemeEditText) rootView.findViewById(R.id.remove_reason);
            if (themeEditText != null) {
                i2 = R.id.withdraw_left_count;
                ThemeTextView themeTextView = (ThemeTextView) rootView.findViewById(R.id.withdraw_left_count);
                if (themeTextView != null) {
                    return new b0((ThemeRelativeLayout) rootView, linearLayout, themeEditText, themeTextView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i2)));
    }

    @NonNull
    public static b0 c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static b0 d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.activity_txs_request_remove_blacklist, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public ThemeRelativeLayout getRoot() {
        return this.f11725a;
    }
}
