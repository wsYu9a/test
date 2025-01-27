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
import com.martian.mibook.ui.reader.ReaderThemeTextView;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public final class m3 implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final LinearLayout f12355a;

    /* renamed from: b */
    @NonNull
    public final ReaderThemeTextView f12356b;

    /* renamed from: c */
    @NonNull
    public final ThemeImageView f12357c;

    /* renamed from: d */
    @NonNull
    public final ReaderThemeTextView f12358d;

    /* renamed from: e */
    @NonNull
    public final TextView f12359e;

    /* renamed from: f */
    @NonNull
    public final TextView f12360f;

    /* renamed from: g */
    @NonNull
    public final LinearLayout f12361g;

    /* renamed from: h */
    @NonNull
    public final RelativeLayout f12362h;

    private m3(@NonNull LinearLayout rootView, @NonNull ReaderThemeTextView authorBookCategory, @NonNull ThemeImageView authorBookCover, @NonNull ReaderThemeTextView authorBookName, @NonNull TextView authorBookScore, @NonNull TextView authorBookSign, @NonNull LinearLayout gridItemView, @NonNull RelativeLayout gridViewCover) {
        this.f12355a = rootView;
        this.f12356b = authorBookCategory;
        this.f12357c = authorBookCover;
        this.f12358d = authorBookName;
        this.f12359e = authorBookScore;
        this.f12360f = authorBookSign;
        this.f12361g = gridItemView;
        this.f12362h = gridViewCover;
    }

    @NonNull
    public static m3 a(@NonNull View rootView) {
        int i2 = R.id.author_book_category;
        ReaderThemeTextView readerThemeTextView = (ReaderThemeTextView) rootView.findViewById(R.id.author_book_category);
        if (readerThemeTextView != null) {
            i2 = R.id.author_book_cover;
            ThemeImageView themeImageView = (ThemeImageView) rootView.findViewById(R.id.author_book_cover);
            if (themeImageView != null) {
                i2 = R.id.author_book_name;
                ReaderThemeTextView readerThemeTextView2 = (ReaderThemeTextView) rootView.findViewById(R.id.author_book_name);
                if (readerThemeTextView2 != null) {
                    i2 = R.id.author_book_score;
                    TextView textView = (TextView) rootView.findViewById(R.id.author_book_score);
                    if (textView != null) {
                        i2 = R.id.author_book_sign;
                        TextView textView2 = (TextView) rootView.findViewById(R.id.author_book_sign);
                        if (textView2 != null) {
                            i2 = R.id.grid_item_view;
                            LinearLayout linearLayout = (LinearLayout) rootView.findViewById(R.id.grid_item_view);
                            if (linearLayout != null) {
                                i2 = R.id.grid_view_cover;
                                RelativeLayout relativeLayout = (RelativeLayout) rootView.findViewById(R.id.grid_view_cover);
                                if (relativeLayout != null) {
                                    return new m3((LinearLayout) rootView, readerThemeTextView, themeImageView, readerThemeTextView2, textView, textView2, linearLayout, relativeLayout);
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
    public static m3 c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static m3 d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.last_page_book_item, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public LinearLayout getRoot() {
        return this.f12355a;
    }
}
