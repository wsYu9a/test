package com.martian.mibook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.libmars.ui.theme.ThemeImageView;
import com.martian.libmars.ui.theme.ThemeLinearLayout;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.mibook.R;

/* loaded from: classes3.dex */
public final class ItemBookMallTypeGenderBinding implements ViewBinding {

    @NonNull
    public final ThemeTextView contentTitle;

    @NonNull
    private final ThemeLinearLayout rootView;

    @NonNull
    public final ThemeImageView tvClose;

    @NonNull
    public final ThemeImageView tvGenderFemale;

    @NonNull
    public final ThemeLinearLayout tvGenderItemRoot;

    @NonNull
    public final ThemeImageView tvGenderMale;

    private ItemBookMallTypeGenderBinding(@NonNull ThemeLinearLayout themeLinearLayout, @NonNull ThemeTextView themeTextView, @NonNull ThemeImageView themeImageView, @NonNull ThemeImageView themeImageView2, @NonNull ThemeLinearLayout themeLinearLayout2, @NonNull ThemeImageView themeImageView3) {
        this.rootView = themeLinearLayout;
        this.contentTitle = themeTextView;
        this.tvClose = themeImageView;
        this.tvGenderFemale = themeImageView2;
        this.tvGenderItemRoot = themeLinearLayout2;
        this.tvGenderMale = themeImageView3;
    }

    @NonNull
    public static ItemBookMallTypeGenderBinding bind(@NonNull View view) {
        int i10 = R.id.content_title;
        ThemeTextView themeTextView = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
        if (themeTextView != null) {
            i10 = R.id.tv_close;
            ThemeImageView themeImageView = (ThemeImageView) ViewBindings.findChildViewById(view, i10);
            if (themeImageView != null) {
                i10 = R.id.tv_gender_female;
                ThemeImageView themeImageView2 = (ThemeImageView) ViewBindings.findChildViewById(view, i10);
                if (themeImageView2 != null) {
                    ThemeLinearLayout themeLinearLayout = (ThemeLinearLayout) view;
                    i10 = R.id.tv_gender_male;
                    ThemeImageView themeImageView3 = (ThemeImageView) ViewBindings.findChildViewById(view, i10);
                    if (themeImageView3 != null) {
                        return new ItemBookMallTypeGenderBinding(themeLinearLayout, themeTextView, themeImageView, themeImageView2, themeLinearLayout, themeImageView3);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static ItemBookMallTypeGenderBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ItemBookMallTypeGenderBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.item_book_mall_type_gender, viewGroup, false);
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
