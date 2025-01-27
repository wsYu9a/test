package com.martian.mibook.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.martian.libmars.ui.theme.ThemeGridView;
import com.martian.libmars.ui.theme.ThemeLinearLayout;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.mibook.ui.TagItemLayout;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public final class k4 implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final ThemeLinearLayout f12249a;

    /* renamed from: b */
    @NonNull
    public final LinearLayout f12250b;

    /* renamed from: c */
    @NonNull
    public final ThemeGridView f12251c;

    /* renamed from: d */
    @NonNull
    public final ThemeTextView f12252d;

    /* renamed from: e */
    @NonNull
    public final ThemeLinearLayout f12253e;

    /* renamed from: f */
    @NonNull
    public final TagItemLayout f12254f;

    private k4(@NonNull ThemeLinearLayout rootView, @NonNull LinearLayout categoryHotView, @NonNull ThemeGridView categoryItem, @NonNull ThemeTextView categoryTitle, @NonNull ThemeLinearLayout gridItemRoot, @NonNull TagItemLayout hotTags) {
        this.f12249a = rootView;
        this.f12250b = categoryHotView;
        this.f12251c = categoryItem;
        this.f12252d = categoryTitle;
        this.f12253e = gridItemRoot;
        this.f12254f = hotTags;
    }

    @NonNull
    public static k4 a(@NonNull View rootView) {
        int i2 = R.id.category_hot_view;
        LinearLayout linearLayout = (LinearLayout) rootView.findViewById(R.id.category_hot_view);
        if (linearLayout != null) {
            i2 = R.id.category_item;
            ThemeGridView themeGridView = (ThemeGridView) rootView.findViewById(R.id.category_item);
            if (themeGridView != null) {
                i2 = R.id.category_title;
                ThemeTextView themeTextView = (ThemeTextView) rootView.findViewById(R.id.category_title);
                if (themeTextView != null) {
                    ThemeLinearLayout themeLinearLayout = (ThemeLinearLayout) rootView;
                    i2 = R.id.hot_tags;
                    TagItemLayout tagItemLayout = (TagItemLayout) rootView.findViewById(R.id.hot_tags);
                    if (tagItemLayout != null) {
                        return new k4(themeLinearLayout, linearLayout, themeGridView, themeTextView, themeLinearLayout, tagItemLayout);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i2)));
    }

    @NonNull
    public static k4 c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static k4 d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.page_item_category_tag, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public ThemeLinearLayout getRoot() {
        return this.f12249a;
    }
}
