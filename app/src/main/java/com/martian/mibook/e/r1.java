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
import com.martian.libmars.ui.theme.ThemeLinearLayout;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public final class r1 implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final ThemeLinearLayout f12593a;

    /* renamed from: b */
    @NonNull
    public final ThemeTextView f12594b;

    /* renamed from: c */
    @NonNull
    public final ThemeImageView f12595c;

    /* renamed from: d */
    @NonNull
    public final LinearLayout f12596d;

    /* renamed from: e */
    @NonNull
    public final ThemeTextView f12597e;

    /* renamed from: f */
    @NonNull
    public final TextView f12598f;

    /* renamed from: g */
    @NonNull
    public final ThemeTextView f12599g;

    /* renamed from: h */
    @NonNull
    public final LinearLayout f12600h;

    /* renamed from: i */
    @NonNull
    public final RelativeLayout f12601i;

    private r1(@NonNull ThemeLinearLayout rootView, @NonNull ThemeTextView bsBookCategory, @NonNull ThemeImageView bsBookCover, @NonNull LinearLayout bsBookFreeView, @NonNull ThemeTextView bsBookName, @NonNull TextView bsBookScore, @NonNull ThemeTextView bsFreeBookPrice, @NonNull LinearLayout gridItemView, @NonNull RelativeLayout gridViewCover) {
        this.f12593a = rootView;
        this.f12594b = bsBookCategory;
        this.f12595c = bsBookCover;
        this.f12596d = bsBookFreeView;
        this.f12597e = bsBookName;
        this.f12598f = bsBookScore;
        this.f12599g = bsFreeBookPrice;
        this.f12600h = gridItemView;
        this.f12601i = gridViewCover;
    }

    @NonNull
    public static r1 a(@NonNull View rootView) {
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
                                        return new r1((ThemeLinearLayout) rootView, themeTextView, themeImageView, linearLayout, themeTextView2, textView, themeTextView3, linearLayout2, relativeLayout);
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
    public static r1 c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static r1 d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.bs_book_store_grid_item, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public ThemeLinearLayout getRoot() {
        return this.f12593a;
    }
}
