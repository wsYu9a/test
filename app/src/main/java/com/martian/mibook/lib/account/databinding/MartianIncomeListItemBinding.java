package com.martian.mibook.lib.account.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.libmars.ui.theme.ThemeLinearLayout;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.mibook.lib.account.R;

/* loaded from: classes3.dex */
public final class MartianIncomeListItemBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final ThemeLinearLayout f13944a;

    /* renamed from: b */
    @NonNull
    public final TextView f13945b;

    /* renamed from: c */
    @NonNull
    public final ThemeTextView f13946c;

    /* renamed from: d */
    @NonNull
    public final ThemeTextView f13947d;

    public MartianIncomeListItemBinding(@NonNull ThemeLinearLayout themeLinearLayout, @NonNull TextView textView, @NonNull ThemeTextView themeTextView, @NonNull ThemeTextView themeTextView2) {
        this.f13944a = themeLinearLayout;
        this.f13945b = textView;
        this.f13946c = themeTextView;
        this.f13947d = themeTextView2;
    }

    @NonNull
    public static MartianIncomeListItemBinding a(@NonNull View view) {
        int i10 = R.id.martian_income_num;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i10);
        if (textView != null) {
            i10 = R.id.martian_income_time;
            ThemeTextView themeTextView = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
            if (themeTextView != null) {
                i10 = R.id.martian_income_title;
                ThemeTextView themeTextView2 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                if (themeTextView2 != null) {
                    return new MartianIncomeListItemBinding((ThemeLinearLayout) view, textView, themeTextView, themeTextView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static MartianIncomeListItemBinding c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static MartianIncomeListItemBinding d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.martian_income_list_item, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public ThemeLinearLayout getRoot() {
        return this.f13944a;
    }
}
