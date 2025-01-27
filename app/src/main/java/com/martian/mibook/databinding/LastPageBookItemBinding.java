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
import com.martian.mibook.R;
import com.martian.mibook.ui.reader.ReaderThemeTextView;

/* loaded from: classes3.dex */
public final class LastPageBookItemBinding implements ViewBinding {

    @NonNull
    public final ReaderThemeTextView authorBookCategory;

    @NonNull
    public final ThemeImageView authorBookCover;

    @NonNull
    public final ReaderThemeTextView authorBookName;

    @NonNull
    public final TextView authorBookScore;

    @NonNull
    public final TextView authorBookSign;

    @NonNull
    public final LinearLayout gridItemView;

    @NonNull
    public final RelativeLayout gridViewCover;

    @NonNull
    private final LinearLayout rootView;

    private LastPageBookItemBinding(@NonNull LinearLayout linearLayout, @NonNull ReaderThemeTextView readerThemeTextView, @NonNull ThemeImageView themeImageView, @NonNull ReaderThemeTextView readerThemeTextView2, @NonNull TextView textView, @NonNull TextView textView2, @NonNull LinearLayout linearLayout2, @NonNull RelativeLayout relativeLayout) {
        this.rootView = linearLayout;
        this.authorBookCategory = readerThemeTextView;
        this.authorBookCover = themeImageView;
        this.authorBookName = readerThemeTextView2;
        this.authorBookScore = textView;
        this.authorBookSign = textView2;
        this.gridItemView = linearLayout2;
        this.gridViewCover = relativeLayout;
    }

    @NonNull
    public static LastPageBookItemBinding bind(@NonNull View view) {
        int i10 = R.id.author_book_category;
        ReaderThemeTextView readerThemeTextView = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
        if (readerThemeTextView != null) {
            i10 = R.id.author_book_cover;
            ThemeImageView themeImageView = (ThemeImageView) ViewBindings.findChildViewById(view, i10);
            if (themeImageView != null) {
                i10 = R.id.author_book_name;
                ReaderThemeTextView readerThemeTextView2 = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
                if (readerThemeTextView2 != null) {
                    i10 = R.id.author_book_score;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, i10);
                    if (textView != null) {
                        i10 = R.id.author_book_sign;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i10);
                        if (textView2 != null) {
                            i10 = R.id.grid_item_view;
                            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i10);
                            if (linearLayout != null) {
                                i10 = R.id.grid_view_cover;
                                RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i10);
                                if (relativeLayout != null) {
                                    return new LastPageBookItemBinding((LinearLayout) view, readerThemeTextView, themeImageView, readerThemeTextView2, textView, textView2, linearLayout, relativeLayout);
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
    public static LastPageBookItemBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static LastPageBookItemBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.last_page_book_item, viewGroup, false);
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
