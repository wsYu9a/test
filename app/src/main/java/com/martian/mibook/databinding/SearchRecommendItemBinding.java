package com.martian.mibook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.libmars.ui.theme.ThemeImageView;
import com.martian.libmars.ui.theme.ThemeLinearLayout;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.mibook.R;

/* loaded from: classes3.dex */
public final class SearchRecommendItemBinding implements ViewBinding {

    @NonNull
    private final ThemeLinearLayout rootView;

    @NonNull
    public final ThemeImageView scRcLogo;

    @NonNull
    public final ThemeTextView scRcTitle;

    @NonNull
    public final TextView tvTagType;

    private SearchRecommendItemBinding(@NonNull ThemeLinearLayout themeLinearLayout, @NonNull ThemeImageView themeImageView, @NonNull ThemeTextView themeTextView, @NonNull TextView textView) {
        this.rootView = themeLinearLayout;
        this.scRcLogo = themeImageView;
        this.scRcTitle = themeTextView;
        this.tvTagType = textView;
    }

    @NonNull
    public static SearchRecommendItemBinding bind(@NonNull View view) {
        int i10 = R.id.sc_rc_logo;
        ThemeImageView themeImageView = (ThemeImageView) ViewBindings.findChildViewById(view, i10);
        if (themeImageView != null) {
            i10 = R.id.sc_rc_title;
            ThemeTextView themeTextView = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
            if (themeTextView != null) {
                i10 = R.id.tv_tag_type;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i10);
                if (textView != null) {
                    return new SearchRecommendItemBinding((ThemeLinearLayout) view, themeImageView, themeTextView, textView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static SearchRecommendItemBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static SearchRecommendItemBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.search_recommend_item, viewGroup, false);
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
