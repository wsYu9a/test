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
public final class u1 implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final LinearLayout f12762a;

    /* renamed from: b */
    @NonNull
    public final LinearLayout f12763b;

    /* renamed from: c */
    @NonNull
    public final ThemeTextView f12764c;

    /* renamed from: d */
    @NonNull
    public final ThemeTextView f12765d;

    /* renamed from: e */
    @NonNull
    public final ThemeImageView f12766e;

    /* renamed from: f */
    @NonNull
    public final TextView f12767f;

    /* renamed from: g */
    @NonNull
    public final ThemeTextView f12768g;

    private u1(@NonNull LinearLayout rootView, @NonNull LinearLayout bookItemRoot, @NonNull ThemeTextView bsListAuthorName, @NonNull ThemeTextView bsListBookName, @NonNull ThemeImageView bsListCover, @NonNull TextView bsListScore, @NonNull ThemeTextView bsListShortContent) {
        this.f12762a = rootView;
        this.f12763b = bookItemRoot;
        this.f12764c = bsListAuthorName;
        this.f12765d = bsListBookName;
        this.f12766e = bsListCover;
        this.f12767f = bsListScore;
        this.f12768g = bsListShortContent;
    }

    @NonNull
    public static u1 a(@NonNull View rootView) {
        LinearLayout linearLayout = (LinearLayout) rootView;
        int i2 = R.id.bs_list_author_name;
        ThemeTextView themeTextView = (ThemeTextView) rootView.findViewById(R.id.bs_list_author_name);
        if (themeTextView != null) {
            i2 = R.id.bs_list_book_name;
            ThemeTextView themeTextView2 = (ThemeTextView) rootView.findViewById(R.id.bs_list_book_name);
            if (themeTextView2 != null) {
                i2 = R.id.bs_list_cover;
                ThemeImageView themeImageView = (ThemeImageView) rootView.findViewById(R.id.bs_list_cover);
                if (themeImageView != null) {
                    i2 = R.id.bs_list_score;
                    TextView textView = (TextView) rootView.findViewById(R.id.bs_list_score);
                    if (textView != null) {
                        i2 = R.id.bs_list_short_content;
                        ThemeTextView themeTextView3 = (ThemeTextView) rootView.findViewById(R.id.bs_list_short_content);
                        if (themeTextView3 != null) {
                            return new u1((LinearLayout) rootView, linearLayout, themeTextView, themeTextView2, themeImageView, textView, themeTextView3);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i2)));
    }

    @NonNull
    public static u1 c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static u1 d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.bs_book_store_item_card, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public LinearLayout getRoot() {
        return this.f12762a;
    }
}
