package com.martian.mibook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.libmars.ui.theme.ThemeLinearLayout;
import com.martian.mibook.R;

/* loaded from: classes3.dex */
public final class PageItemClassificationHotBinding implements ViewBinding {

    @NonNull
    public final LinearLayout categoryHotView;

    @NonNull
    private final ThemeLinearLayout rootView;

    @NonNull
    public final ImageView tvPageCover;

    @NonNull
    public final TextView tvPageDesc;

    @NonNull
    public final LinearLayout tvPageDescView;

    @NonNull
    public final TextView tvPageName;

    private PageItemClassificationHotBinding(@NonNull ThemeLinearLayout themeLinearLayout, @NonNull LinearLayout linearLayout, @NonNull ImageView imageView, @NonNull TextView textView, @NonNull LinearLayout linearLayout2, @NonNull TextView textView2) {
        this.rootView = themeLinearLayout;
        this.categoryHotView = linearLayout;
        this.tvPageCover = imageView;
        this.tvPageDesc = textView;
        this.tvPageDescView = linearLayout2;
        this.tvPageName = textView2;
    }

    @NonNull
    public static PageItemClassificationHotBinding bind(@NonNull View view) {
        int i10 = R.id.category_hot_view;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i10);
        if (linearLayout != null) {
            i10 = R.id.tv_page_cover;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i10);
            if (imageView != null) {
                i10 = R.id.tv_page_desc;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i10);
                if (textView != null) {
                    i10 = R.id.tv_page_desc_view;
                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i10);
                    if (linearLayout2 != null) {
                        i10 = R.id.tv_page_name;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i10);
                        if (textView2 != null) {
                            return new PageItemClassificationHotBinding((ThemeLinearLayout) view, linearLayout, imageView, textView, linearLayout2, textView2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static PageItemClassificationHotBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static PageItemClassificationHotBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.page_item_classification_hot, viewGroup, false);
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
