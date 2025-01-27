package com.martian.mibook.lib.account.b;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.mibook.lib.account.R;

/* loaded from: classes3.dex */
public final class e implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final LinearLayout f13843a;

    /* renamed from: b */
    @NonNull
    public final TextView f13844b;

    /* renamed from: c */
    @NonNull
    public final ThemeTextView f13845c;

    /* renamed from: d */
    @NonNull
    public final ThemeTextView f13846d;

    private e(@NonNull LinearLayout rootView, @NonNull TextView tvCoinsNum, @NonNull ThemeTextView tvCoinsTime, @NonNull ThemeTextView tvCoinsTitle) {
        this.f13843a = rootView;
        this.f13844b = tvCoinsNum;
        this.f13845c = tvCoinsTime;
        this.f13846d = tvCoinsTitle;
    }

    @NonNull
    public static e a(@NonNull View rootView) {
        int i2 = R.id.tv_coins_num;
        TextView textView = (TextView) rootView.findViewById(i2);
        if (textView != null) {
            i2 = R.id.tv_coins_time;
            ThemeTextView themeTextView = (ThemeTextView) rootView.findViewById(i2);
            if (themeTextView != null) {
                i2 = R.id.tv_coins_title;
                ThemeTextView themeTextView2 = (ThemeTextView) rootView.findViewById(i2);
                if (themeTextView2 != null) {
                    return new e((LinearLayout) rootView, textView, themeTextView, themeTextView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i2)));
    }

    @NonNull
    public static e c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static e d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.history_coins_item, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public LinearLayout getRoot() {
        return this.f13843a;
    }
}
