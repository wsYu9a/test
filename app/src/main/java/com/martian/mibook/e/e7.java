package com.martian.mibook.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.martian.libmars.ui.theme.ThemeLinearLayout;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.mibook.ui.IntervalCountdownTextView;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public final class e7 implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final ThemeLinearLayout f11918a;

    /* renamed from: b */
    @NonNull
    public final ThemeLinearLayout f11919b;

    /* renamed from: c */
    @NonNull
    public final ThemeTextView f11920c;

    /* renamed from: d */
    @NonNull
    public final ThemeLinearLayout f11921d;

    /* renamed from: e */
    @NonNull
    public final IntervalCountdownTextView f11922e;

    /* renamed from: f */
    @NonNull
    public final TextView f11923f;

    private e7(@NonNull ThemeLinearLayout rootView, @NonNull ThemeLinearLayout contentMore, @NonNull ThemeTextView contentTitle, @NonNull ThemeLinearLayout contentTitleView, @NonNull IntervalCountdownTextView discountTime, @NonNull TextView discountType) {
        this.f11918a = rootView;
        this.f11919b = contentMore;
        this.f11920c = contentTitle;
        this.f11921d = contentTitleView;
        this.f11922e = discountTime;
        this.f11923f = discountType;
    }

    @NonNull
    public static e7 a(@NonNull View rootView) {
        int i2 = R.id.content_more;
        ThemeLinearLayout themeLinearLayout = (ThemeLinearLayout) rootView.findViewById(R.id.content_more);
        if (themeLinearLayout != null) {
            i2 = R.id.content_title;
            ThemeTextView themeTextView = (ThemeTextView) rootView.findViewById(R.id.content_title);
            if (themeTextView != null) {
                i2 = R.id.content_title_view;
                ThemeLinearLayout themeLinearLayout2 = (ThemeLinearLayout) rootView.findViewById(R.id.content_title_view);
                if (themeLinearLayout2 != null) {
                    i2 = R.id.discount_time;
                    IntervalCountdownTextView intervalCountdownTextView = (IntervalCountdownTextView) rootView.findViewById(R.id.discount_time);
                    if (intervalCountdownTextView != null) {
                        i2 = R.id.discount_type;
                        TextView textView = (TextView) rootView.findViewById(R.id.discount_type);
                        if (textView != null) {
                            return new e7((ThemeLinearLayout) rootView, themeLinearLayout, themeTextView, themeLinearLayout2, intervalCountdownTextView, textView);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i2)));
    }

    @NonNull
    public static e7 c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static e7 d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.title, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public ThemeLinearLayout getRoot() {
        return this.f11918a;
    }
}
