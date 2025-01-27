package com.martian.mibook.databinding;

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
import com.martian.mibook.R;
import com.martian.mibook.ui.IntervalCountdownTextView;

/* loaded from: classes3.dex */
public final class TitleBinding implements ViewBinding {

    @NonNull
    public final ThemeLinearLayout contentMore;

    @NonNull
    public final ThemeTextView contentTitle;

    @NonNull
    public final ThemeLinearLayout contentTitleView;

    @NonNull
    public final IntervalCountdownTextView discountTime;

    @NonNull
    public final TextView discountType;

    @NonNull
    private final ThemeLinearLayout rootView;

    private TitleBinding(@NonNull ThemeLinearLayout themeLinearLayout, @NonNull ThemeLinearLayout themeLinearLayout2, @NonNull ThemeTextView themeTextView, @NonNull ThemeLinearLayout themeLinearLayout3, @NonNull IntervalCountdownTextView intervalCountdownTextView, @NonNull TextView textView) {
        this.rootView = themeLinearLayout;
        this.contentMore = themeLinearLayout2;
        this.contentTitle = themeTextView;
        this.contentTitleView = themeLinearLayout3;
        this.discountTime = intervalCountdownTextView;
        this.discountType = textView;
    }

    @NonNull
    public static TitleBinding bind(@NonNull View view) {
        int i10 = R.id.content_more;
        ThemeLinearLayout themeLinearLayout = (ThemeLinearLayout) ViewBindings.findChildViewById(view, i10);
        if (themeLinearLayout != null) {
            i10 = R.id.content_title;
            ThemeTextView themeTextView = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
            if (themeTextView != null) {
                i10 = R.id.content_title_view;
                ThemeLinearLayout themeLinearLayout2 = (ThemeLinearLayout) ViewBindings.findChildViewById(view, i10);
                if (themeLinearLayout2 != null) {
                    i10 = R.id.discount_time;
                    IntervalCountdownTextView intervalCountdownTextView = (IntervalCountdownTextView) ViewBindings.findChildViewById(view, i10);
                    if (intervalCountdownTextView != null) {
                        i10 = R.id.discount_type;
                        TextView textView = (TextView) ViewBindings.findChildViewById(view, i10);
                        if (textView != null) {
                            return new TitleBinding((ThemeLinearLayout) view, themeLinearLayout, themeTextView, themeLinearLayout2, intervalCountdownTextView, textView);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static TitleBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static TitleBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.title, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public ThemeLinearLayout getRoot() {
        return this.rootView;
    }
}
