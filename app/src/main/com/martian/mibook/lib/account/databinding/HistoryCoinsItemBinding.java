package com.martian.mibook.lib.account.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.mibook.lib.account.R;

/* loaded from: classes3.dex */
public final class HistoryCoinsItemBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final LinearLayout f13940a;

    /* renamed from: b */
    @NonNull
    public final TextView f13941b;

    /* renamed from: c */
    @NonNull
    public final ThemeTextView f13942c;

    /* renamed from: d */
    @NonNull
    public final ThemeTextView f13943d;

    public HistoryCoinsItemBinding(@NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull ThemeTextView themeTextView, @NonNull ThemeTextView themeTextView2) {
        this.f13940a = linearLayout;
        this.f13941b = textView;
        this.f13942c = themeTextView;
        this.f13943d = themeTextView2;
    }

    @NonNull
    public static HistoryCoinsItemBinding a(@NonNull View view) {
        int i10 = R.id.tv_coins_num;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i10);
        if (textView != null) {
            i10 = R.id.tv_coins_time;
            ThemeTextView themeTextView = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
            if (themeTextView != null) {
                i10 = R.id.tv_coins_title;
                ThemeTextView themeTextView2 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                if (themeTextView2 != null) {
                    return new HistoryCoinsItemBinding((LinearLayout) view, textView, themeTextView, themeTextView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static HistoryCoinsItemBinding c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static HistoryCoinsItemBinding d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.history_coins_item, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public LinearLayout getRoot() {
        return this.f13940a;
    }
}
