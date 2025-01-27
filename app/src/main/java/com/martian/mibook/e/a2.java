package com.martian.mibook.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.martian.libmars.ui.theme.ThemeImageView;
import com.martian.libmars.ui.theme.ThemeLinearLayout;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.libmars.utils.tablayout.MagicIndicator;
import com.martian.mibook.ui.IntervalCountdownTextView;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public final class a2 implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final RelativeLayout f11676a;

    /* renamed from: b */
    @NonNull
    public final ThemeTextView f11677b;

    /* renamed from: c */
    @NonNull
    public final ThemeImageView f11678c;

    /* renamed from: d */
    @NonNull
    public final ProgressBar f11679d;

    /* renamed from: e */
    @NonNull
    public final ThemeLinearLayout f11680e;

    /* renamed from: f */
    @NonNull
    public final ThemeTextView f11681f;

    /* renamed from: g */
    @NonNull
    public final RelativeLayout f11682g;

    /* renamed from: h */
    @NonNull
    public final MagicIndicator f11683h;

    /* renamed from: i */
    @NonNull
    public final ImageView f11684i;

    /* renamed from: j */
    @NonNull
    public final ThemeImageView f11685j;

    @NonNull
    public final IntervalCountdownTextView k;

    private a2(@NonNull RelativeLayout rootView, @NonNull ThemeTextView authorBookMore, @NonNull ThemeImageView authorBookMoreView, @NonNull ProgressBar bookMoreProgressbar, @NonNull ThemeLinearLayout contentMore, @NonNull ThemeTextView contentTitle, @NonNull RelativeLayout contentTitleView, @NonNull MagicIndicator titleMagicIndicator, @NonNull ImageView tvBg, @NonNull ThemeImageView tvClose, @NonNull IntervalCountdownTextView tvTime) {
        this.f11676a = rootView;
        this.f11677b = authorBookMore;
        this.f11678c = authorBookMoreView;
        this.f11679d = bookMoreProgressbar;
        this.f11680e = contentMore;
        this.f11681f = contentTitle;
        this.f11682g = contentTitleView;
        this.f11683h = titleMagicIndicator;
        this.f11684i = tvBg;
        this.f11685j = tvClose;
        this.k = tvTime;
    }

    @NonNull
    public static a2 a(@NonNull View rootView) {
        int i2 = R.id.author_book_more;
        ThemeTextView themeTextView = (ThemeTextView) rootView.findViewById(R.id.author_book_more);
        if (themeTextView != null) {
            i2 = R.id.author_book_more_view;
            ThemeImageView themeImageView = (ThemeImageView) rootView.findViewById(R.id.author_book_more_view);
            if (themeImageView != null) {
                i2 = R.id.book_more_progressbar;
                ProgressBar progressBar = (ProgressBar) rootView.findViewById(R.id.book_more_progressbar);
                if (progressBar != null) {
                    i2 = R.id.content_more;
                    ThemeLinearLayout themeLinearLayout = (ThemeLinearLayout) rootView.findViewById(R.id.content_more);
                    if (themeLinearLayout != null) {
                        i2 = R.id.content_title;
                        ThemeTextView themeTextView2 = (ThemeTextView) rootView.findViewById(R.id.content_title);
                        if (themeTextView2 != null) {
                            RelativeLayout relativeLayout = (RelativeLayout) rootView;
                            i2 = R.id.title_magic_indicator;
                            MagicIndicator magicIndicator = (MagicIndicator) rootView.findViewById(R.id.title_magic_indicator);
                            if (magicIndicator != null) {
                                i2 = R.id.tv_bg;
                                ImageView imageView = (ImageView) rootView.findViewById(R.id.tv_bg);
                                if (imageView != null) {
                                    i2 = R.id.tv_close;
                                    ThemeImageView themeImageView2 = (ThemeImageView) rootView.findViewById(R.id.tv_close);
                                    if (themeImageView2 != null) {
                                        i2 = R.id.tv_time;
                                        IntervalCountdownTextView intervalCountdownTextView = (IntervalCountdownTextView) rootView.findViewById(R.id.tv_time);
                                        if (intervalCountdownTextView != null) {
                                            return new a2(relativeLayout, themeTextView, themeImageView, progressBar, themeLinearLayout, themeTextView2, relativeLayout, magicIndicator, imageView, themeImageView2, intervalCountdownTextView);
                                        }
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
    public static a2 c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static a2 d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.bs_book_store_item_title, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f11676a;
    }
}
