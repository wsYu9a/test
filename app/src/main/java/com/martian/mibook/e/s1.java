package com.martian.mibook.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.martian.libmars.ui.theme.ThemeImageView;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public final class s1 implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final LinearLayout f12651a;

    /* renamed from: b */
    @NonNull
    public final ThemeTextView f12652b;

    /* renamed from: c */
    @NonNull
    public final ThemeImageView f12653c;

    /* renamed from: d */
    @NonNull
    public final LinearLayout f12654d;

    /* renamed from: e */
    @NonNull
    public final ThemeTextView f12655e;

    /* renamed from: f */
    @NonNull
    public final TextView f12656f;

    /* renamed from: g */
    @NonNull
    public final ThemeTextView f12657g;

    /* renamed from: h */
    @NonNull
    public final LinearLayout f12658h;

    /* renamed from: i */
    @NonNull
    public final RelativeLayout f12659i;

    private s1(@NonNull LinearLayout rootView, @NonNull ThemeTextView bsBookCategory, @NonNull ThemeImageView bsBookCover, @NonNull LinearLayout bsBookFreeView, @NonNull ThemeTextView bsBookName, @NonNull TextView bsBookScore, @NonNull ThemeTextView bsFreeBookPrice, @NonNull LinearLayout gridItemView, @NonNull RelativeLayout gridViewCover) {
        this.f12651a = rootView;
        this.f12652b = bsBookCategory;
        this.f12653c = bsBookCover;
        this.f12654d = bsBookFreeView;
        this.f12655e = bsBookName;
        this.f12656f = bsBookScore;
        this.f12657g = bsFreeBookPrice;
        this.f12658h = gridItemView;
        this.f12659i = gridViewCover;
    }

    @NonNull
    public static s1 a(@NonNull View rootView) {
        int i2 = R.id.bs_book_category;
        ThemeTextView themeTextView = (ThemeTextView) rootView.findViewById(R.id.bs_book_category);
        if (themeTextView != null) {
            i2 = R.id.bs_book_cover;
            ThemeImageView themeImageView = (ThemeImageView) rootView.findViewById(R.id.bs_book_cover);
            if (themeImageView != null) {
                i2 = R.id.bs_book_free_view;
                LinearLayout linearLayout = (LinearLayout) rootView.findViewById(R.id.bs_book_free_view);
                if (linearLayout != null) {
                    i2 = R.id.bs_book_name;
                    ThemeTextView themeTextView2 = (ThemeTextView) rootView.findViewById(R.id.bs_book_name);
                    if (themeTextView2 != null) {
                        i2 = R.id.bs_book_score;
                        TextView textView = (TextView) rootView.findViewById(R.id.bs_book_score);
                        if (textView != null) {
                            i2 = R.id.bs_free_book_price;
                            ThemeTextView themeTextView3 = (ThemeTextView) rootView.findViewById(R.id.bs_free_book_price);
                            if (themeTextView3 != null) {
                                i2 = R.id.grid_item_view;
                                LinearLayout linearLayout2 = (LinearLayout) rootView.findViewById(R.id.grid_item_view);
                                if (linearLayout2 != null) {
                                    i2 = R.id.grid_view_cover;
                                    RelativeLayout relativeLayout = (RelativeLayout) rootView.findViewById(R.id.grid_view_cover);
                                    if (relativeLayout != null) {
                                        return new s1((LinearLayout) rootView, themeTextView, themeImageView, linearLayout, themeTextView2, textView, themeTextView3, linearLayout2, relativeLayout);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i2)));
    }

    @NonNull
    public static s1 c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static s1 d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.bs_book_store_grid_item_card, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public LinearLayout getRoot() {
        return this.f12651a;
    }
}
