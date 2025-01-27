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
public final class t0 implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final ThemeLinearLayout f12705a;

    /* renamed from: b */
    @NonNull
    public final ThemeTextView f12706b;

    /* renamed from: c */
    @NonNull
    public final ThemeTextView f12707c;

    /* renamed from: d */
    @NonNull
    public final ThemeImageView f12708d;

    /* renamed from: e */
    @NonNull
    public final ThemeTextView f12709e;

    /* renamed from: f */
    @NonNull
    public final TextView f12710f;

    /* renamed from: g */
    @NonNull
    public final ThemeTextView f12711g;

    private t0(@NonNull ThemeLinearLayout rootView, @NonNull ThemeTextView rdBookAddBookrack, @NonNull ThemeTextView rdBookAuthorName, @NonNull ThemeImageView rdBookCover, @NonNull ThemeTextView rdBookName, @NonNull TextView rdBookScore, @NonNull ThemeTextView rdBookShortContent) {
        this.f12705a = rootView;
        this.f12706b = rdBookAddBookrack;
        this.f12707c = rdBookAuthorName;
        this.f12708d = rdBookCover;
        this.f12709e = rdBookName;
        this.f12710f = rdBookScore;
        this.f12711g = rdBookShortContent;
    }

    @NonNull
    public static t0 a(@NonNull View rootView) {
        int i2 = R.id.rd_book_add_bookrack;
        ThemeTextView themeTextView = (ThemeTextView) rootView.findViewById(R.id.rd_book_add_bookrack);
        if (themeTextView != null) {
            i2 = R.id.rd_book_author_name;
            ThemeTextView themeTextView2 = (ThemeTextView) rootView.findViewById(R.id.rd_book_author_name);
            if (themeTextView2 != null) {
                i2 = R.id.rd_book_cover;
                ThemeImageView themeImageView = (ThemeImageView) rootView.findViewById(R.id.rd_book_cover);
                if (themeImageView != null) {
                    i2 = R.id.rd_book_name;
                    ThemeTextView themeTextView3 = (ThemeTextView) rootView.findViewById(R.id.rd_book_name);
                    if (themeTextView3 != null) {
                        i2 = R.id.rd_book_score;
                        TextView textView = (TextView) rootView.findViewById(R.id.rd_book_score);
                        if (textView != null) {
                            i2 = R.id.rd_book_short_content;
                            ThemeTextView themeTextView4 = (ThemeTextView) rootView.findViewById(R.id.rd_book_short_content);
                            if (themeTextView4 != null) {
                                return new t0((ThemeLinearLayout) rootView, themeTextView, themeTextView2, themeImageView, themeTextView3, textView, themeTextView4);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i2)));
    }

    @NonNull
    public static t0 c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static t0 d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.book_cover_reading_list_item, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public ThemeLinearLayout getRoot() {
        return this.f12705a;
    }
}
