package com.martian.mibook.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.martian.libmars.ui.theme.ThemeImageView;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public final class c2 implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final LinearLayout f11783a;

    /* renamed from: b */
    @NonNull
    public final ThemeTextView f11784b;

    /* renamed from: c */
    @NonNull
    public final ThemeTextView f11785c;

    /* renamed from: d */
    @NonNull
    public final TextView f11786d;

    /* renamed from: e */
    @NonNull
    public final ThemeImageView f11787e;

    private c2(@NonNull LinearLayout rootView, @NonNull ThemeTextView bsRankBookCategory, @NonNull ThemeTextView bsRankBookName, @NonNull TextView bsRankBookScore, @NonNull ThemeImageView bsRankCover) {
        this.f11783a = rootView;
        this.f11784b = bsRankBookCategory;
        this.f11785c = bsRankBookName;
        this.f11786d = bsRankBookScore;
        this.f11787e = bsRankCover;
    }

    @NonNull
    public static c2 a(@NonNull View rootView) {
        int i2 = R.id.bs_rank_book_category;
        ThemeTextView themeTextView = (ThemeTextView) rootView.findViewById(R.id.bs_rank_book_category);
        if (themeTextView != null) {
            i2 = R.id.bs_rank_book_name;
            ThemeTextView themeTextView2 = (ThemeTextView) rootView.findViewById(R.id.bs_rank_book_name);
            if (themeTextView2 != null) {
                i2 = R.id.bs_rank_book_score;
                TextView textView = (TextView) rootView.findViewById(R.id.bs_rank_book_score);
                if (textView != null) {
                    i2 = R.id.bs_rank_cover;
                    ThemeImageView themeImageView = (ThemeImageView) rootView.findViewById(R.id.bs_rank_cover);
                    if (themeImageView != null) {
                        return new c2((LinearLayout) rootView, themeTextView, themeTextView2, textView, themeImageView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i2)));
    }

    @NonNull
    public static c2 c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static c2 d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.bs_book_store_six_item, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public LinearLayout getRoot() {
        return this.f11783a;
    }
}
