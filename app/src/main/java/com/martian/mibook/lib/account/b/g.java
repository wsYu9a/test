package com.martian.mibook.lib.account.b;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.martian.libmars.ui.theme.ThemeLinearLayout;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.mibook.lib.account.R;

/* loaded from: classes3.dex */
public final class g implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final ThemeLinearLayout f13854a;

    /* renamed from: b */
    @NonNull
    public final TextView f13855b;

    /* renamed from: c */
    @NonNull
    public final ThemeTextView f13856c;

    /* renamed from: d */
    @NonNull
    public final ThemeTextView f13857d;

    private g(@NonNull ThemeLinearLayout rootView, @NonNull TextView martianIncomeNum, @NonNull ThemeTextView martianIncomeTime, @NonNull ThemeTextView martianIncomeTitle) {
        this.f13854a = rootView;
        this.f13855b = martianIncomeNum;
        this.f13856c = martianIncomeTime;
        this.f13857d = martianIncomeTitle;
    }

    @NonNull
    public static g a(@NonNull View rootView) {
        int i2 = R.id.martian_income_num;
        TextView textView = (TextView) rootView.findViewById(i2);
        if (textView != null) {
            i2 = R.id.martian_income_time;
            ThemeTextView themeTextView = (ThemeTextView) rootView.findViewById(i2);
            if (themeTextView != null) {
                i2 = R.id.martian_income_title;
                ThemeTextView themeTextView2 = (ThemeTextView) rootView.findViewById(i2);
                if (themeTextView2 != null) {
                    return new g((ThemeLinearLayout) rootView, textView, themeTextView, themeTextView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i2)));
    }

    @NonNull
    public static g c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static g d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.martian_income_list_item, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public ThemeLinearLayout getRoot() {
        return this.f13854a;
    }
}
