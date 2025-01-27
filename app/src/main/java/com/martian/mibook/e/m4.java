package com.martian.mibook.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.martian.libmars.ui.theme.ThemeLinearLayout;
import com.martian.libmars.ui.theme.ThemeRelativeLayout;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.mibook.ui.CircleImageView;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public final class m4 implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final ThemeRelativeLayout f12363a;

    /* renamed from: b */
    @NonNull
    public final ThemeLinearLayout f12364b;

    /* renamed from: c */
    @NonNull
    public final ImageView f12365c;

    /* renamed from: d */
    @NonNull
    public final CircleImageView f12366d;

    /* renamed from: e */
    @NonNull
    public final ThemeTextView f12367e;

    private m4(@NonNull ThemeRelativeLayout rootView, @NonNull ThemeLinearLayout categoryRootView, @NonNull ImageView tvPageCover, @NonNull CircleImageView tvPageIcon, @NonNull ThemeTextView tvPageName) {
        this.f12363a = rootView;
        this.f12364b = categoryRootView;
        this.f12365c = tvPageCover;
        this.f12366d = tvPageIcon;
        this.f12367e = tvPageName;
    }

    @NonNull
    public static m4 a(@NonNull View rootView) {
        int i2 = R.id.category_root_view;
        ThemeLinearLayout themeLinearLayout = (ThemeLinearLayout) rootView.findViewById(R.id.category_root_view);
        if (themeLinearLayout != null) {
            i2 = R.id.tv_page_cover;
            ImageView imageView = (ImageView) rootView.findViewById(R.id.tv_page_cover);
            if (imageView != null) {
                i2 = R.id.tv_page_icon;
                CircleImageView circleImageView = (CircleImageView) rootView.findViewById(R.id.tv_page_icon);
                if (circleImageView != null) {
                    i2 = R.id.tv_page_name;
                    ThemeTextView themeTextView = (ThemeTextView) rootView.findViewById(R.id.tv_page_name);
                    if (themeTextView != null) {
                        return new m4((ThemeRelativeLayout) rootView, themeLinearLayout, imageView, circleImageView, themeTextView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i2)));
    }

    @NonNull
    public static m4 c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static m4 d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.page_item_classification_yw, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public ThemeRelativeLayout getRoot() {
        return this.f12363a;
    }
}
