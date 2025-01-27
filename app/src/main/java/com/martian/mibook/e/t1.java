package com.martian.mibook.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.martian.libmars.ui.theme.ThemeImageView;
import com.martian.libmars.ui.theme.ThemeLinearLayout;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public final class t1 implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final ThemeLinearLayout f12712a;

    /* renamed from: b */
    @NonNull
    public final ThemeLinearLayout f12713b;

    /* renamed from: c */
    @NonNull
    public final ThemeTextView f12714c;

    /* renamed from: d */
    @NonNull
    public final TextView f12715d;

    /* renamed from: e */
    @NonNull
    public final ThemeTextView f12716e;

    /* renamed from: f */
    @NonNull
    public final ThemeImageView f12717f;

    /* renamed from: g */
    @NonNull
    public final TextView f12718g;

    /* renamed from: h */
    @NonNull
    public final ThemeTextView f12719h;

    private t1(@NonNull ThemeLinearLayout rootView, @NonNull ThemeLinearLayout bookItemRoot, @NonNull ThemeTextView bsListAuthorName, @NonNull TextView bsListBookMark, @NonNull ThemeTextView bsListBookName, @NonNull ThemeImageView bsListCover, @NonNull TextView bsListScore, @NonNull ThemeTextView bsListShortContent) {
        this.f12712a = rootView;
        this.f12713b = bookItemRoot;
        this.f12714c = bsListAuthorName;
        this.f12715d = bsListBookMark;
        this.f12716e = bsListBookName;
        this.f12717f = bsListCover;
        this.f12718g = bsListScore;
        this.f12719h = bsListShortContent;
    }

    @NonNull
    public static t1 a(@NonNull View rootView) {
        ThemeLinearLayout themeLinearLayout = (ThemeLinearLayout) rootView;
        int i2 = R.id.bs_list_author_name;
        ThemeTextView themeTextView = (ThemeTextView) rootView.findViewById(R.id.bs_list_author_name);
        if (themeTextView != null) {
            i2 = R.id.bs_list_book_mark;
            TextView textView = (TextView) rootView.findViewById(R.id.bs_list_book_mark);
            if (textView != null) {
                i2 = R.id.bs_list_book_name;
                ThemeTextView themeTextView2 = (ThemeTextView) rootView.findViewById(R.id.bs_list_book_name);
                if (themeTextView2 != null) {
                    i2 = R.id.bs_list_cover;
                    ThemeImageView themeImageView = (ThemeImageView) rootView.findViewById(R.id.bs_list_cover);
                    if (themeImageView != null) {
                        i2 = R.id.bs_list_score;
                        TextView textView2 = (TextView) rootView.findViewById(R.id.bs_list_score);
                        if (textView2 != null) {
                            i2 = R.id.bs_list_short_content;
                            ThemeTextView themeTextView3 = (ThemeTextView) rootView.findViewById(R.id.bs_list_short_content);
                            if (themeTextView3 != null) {
                                return new t1((ThemeLinearLayout) rootView, themeLinearLayout, themeTextView, textView, themeTextView2, themeImageView, textView2, themeTextView3);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i2)));
    }

    @NonNull
    public static t1 c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static t1 d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.bs_book_store_item, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public ThemeLinearLayout getRoot() {
        return this.f12712a;
    }
}
