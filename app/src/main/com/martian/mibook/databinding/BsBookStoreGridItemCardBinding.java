package com.martian.mibook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.libmars.ui.theme.ThemeImageView;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.mibook.R;

/* loaded from: classes3.dex */
public final class BsBookStoreGridItemCardBinding implements ViewBinding {

    @NonNull
    public final ThemeTextView bsBookCategory;

    @NonNull
    public final ThemeImageView bsBookCover;

    @NonNull
    public final LinearLayout bsBookFreeView;

    @NonNull
    public final ThemeTextView bsBookName;

    @NonNull
    public final TextView bsBookScore;

    @NonNull
    public final ThemeTextView bsFreeBookPrice;

    @NonNull
    public final LinearLayout gridItemView;

    @NonNull
    public final RelativeLayout gridViewCover;

    @NonNull
    private final LinearLayout rootView;

    private BsBookStoreGridItemCardBinding(@NonNull LinearLayout linearLayout, @NonNull ThemeTextView themeTextView, @NonNull ThemeImageView themeImageView, @NonNull LinearLayout linearLayout2, @NonNull ThemeTextView themeTextView2, @NonNull TextView textView, @NonNull ThemeTextView themeTextView3, @NonNull LinearLayout linearLayout3, @NonNull RelativeLayout relativeLayout) {
        this.rootView = linearLayout;
        this.bsBookCategory = themeTextView;
        this.bsBookCover = themeImageView;
        this.bsBookFreeView = linearLayout2;
        this.bsBookName = themeTextView2;
        this.bsBookScore = textView;
        this.bsFreeBookPrice = themeTextView3;
        this.gridItemView = linearLayout3;
        this.gridViewCover = relativeLayout;
    }

    @NonNull
    public static BsBookStoreGridItemCardBinding bind(@NonNull View view) {
        int i10 = R.id.bs_book_category;
        ThemeTextView themeTextView = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
        if (themeTextView != null) {
            i10 = R.id.bs_book_cover;
            ThemeImageView themeImageView = (ThemeImageView) ViewBindings.findChildViewById(view, i10);
            if (themeImageView != null) {
                i10 = R.id.bs_book_free_view;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i10);
                if (linearLayout != null) {
                    i10 = R.id.bs_book_name;
                    ThemeTextView themeTextView2 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                    if (themeTextView2 != null) {
                        i10 = R.id.bs_book_score;
                        TextView textView = (TextView) ViewBindings.findChildViewById(view, i10);
                        if (textView != null) {
                            i10 = R.id.bs_free_book_price;
                            ThemeTextView themeTextView3 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                            if (themeTextView3 != null) {
                                i10 = R.id.grid_item_view;
                                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i10);
                                if (linearLayout2 != null) {
                                    i10 = R.id.grid_view_cover;
                                    RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i10);
                                    if (relativeLayout != null) {
                                        return new BsBookStoreGridItemCardBinding((LinearLayout) view, themeTextView, themeImageView, linearLayout, themeTextView2, textView, themeTextView3, linearLayout2, relativeLayout);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static BsBookStoreGridItemCardBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static BsBookStoreGridItemCardBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.bs_book_store_grid_item_card, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.rootView;
    }
}
