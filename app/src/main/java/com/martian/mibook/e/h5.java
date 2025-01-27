package com.martian.mibook.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.mibook.ui.AutoScrollView;
import com.martian.mibook.ui.reader.ReaderThemeTextView;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public final class h5 implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final RelativeLayout f12073a;

    /* renamed from: b */
    @NonNull
    public final ImageView f12074b;

    /* renamed from: c */
    @NonNull
    public final ThemeTextView f12075c;

    /* renamed from: d */
    @NonNull
    public final ReaderThemeTextView f12076d;

    /* renamed from: e */
    @NonNull
    public final ImageView f12077e;

    /* renamed from: f */
    @NonNull
    public final ReaderThemeTextView f12078f;

    /* renamed from: g */
    @NonNull
    public final ThemeTextView f12079g;

    /* renamed from: h */
    @NonNull
    public final RelativeLayout f12080h;

    /* renamed from: i */
    @NonNull
    public final TextView f12081i;

    /* renamed from: j */
    @NonNull
    public final TextView f12082j;

    @NonNull
    public final AutoScrollView k;

    private h5(@NonNull RelativeLayout rootView, @NonNull ImageView bookAdBg, @NonNull ThemeTextView bookAdCardAddBookrack, @NonNull ReaderThemeTextView bookAdCardAuthor, @NonNull ImageView bookAdCardCover, @NonNull ReaderThemeTextView bookAdCardInfo, @NonNull ThemeTextView bookAdCardRead, @NonNull RelativeLayout bookAdCardView, @NonNull TextView bookAdTextContent, @NonNull TextView bookAdTextTitle, @NonNull AutoScrollView bookAdTextView) {
        this.f12073a = rootView;
        this.f12074b = bookAdBg;
        this.f12075c = bookAdCardAddBookrack;
        this.f12076d = bookAdCardAuthor;
        this.f12077e = bookAdCardCover;
        this.f12078f = bookAdCardInfo;
        this.f12079g = bookAdCardRead;
        this.f12080h = bookAdCardView;
        this.f12081i = bookAdTextContent;
        this.f12082j = bookAdTextTitle;
        this.k = bookAdTextView;
    }

    @NonNull
    public static h5 a(@NonNull View rootView) {
        int i2 = R.id.book_ad_bg;
        ImageView imageView = (ImageView) rootView.findViewById(R.id.book_ad_bg);
        if (imageView != null) {
            i2 = R.id.book_ad_card_add_bookrack;
            ThemeTextView themeTextView = (ThemeTextView) rootView.findViewById(R.id.book_ad_card_add_bookrack);
            if (themeTextView != null) {
                i2 = R.id.book_ad_card_author;
                ReaderThemeTextView readerThemeTextView = (ReaderThemeTextView) rootView.findViewById(R.id.book_ad_card_author);
                if (readerThemeTextView != null) {
                    i2 = R.id.book_ad_card_cover;
                    ImageView imageView2 = (ImageView) rootView.findViewById(R.id.book_ad_card_cover);
                    if (imageView2 != null) {
                        i2 = R.id.book_ad_card_info;
                        ReaderThemeTextView readerThemeTextView2 = (ReaderThemeTextView) rootView.findViewById(R.id.book_ad_card_info);
                        if (readerThemeTextView2 != null) {
                            i2 = R.id.book_ad_card_read;
                            ThemeTextView themeTextView2 = (ThemeTextView) rootView.findViewById(R.id.book_ad_card_read);
                            if (themeTextView2 != null) {
                                i2 = R.id.book_ad_card_view;
                                RelativeLayout relativeLayout = (RelativeLayout) rootView.findViewById(R.id.book_ad_card_view);
                                if (relativeLayout != null) {
                                    i2 = R.id.book_ad_text_content;
                                    TextView textView = (TextView) rootView.findViewById(R.id.book_ad_text_content);
                                    if (textView != null) {
                                        i2 = R.id.book_ad_text_title;
                                        TextView textView2 = (TextView) rootView.findViewById(R.id.book_ad_text_title);
                                        if (textView2 != null) {
                                            i2 = R.id.book_ad_text_view;
                                            AutoScrollView autoScrollView = (AutoScrollView) rootView.findViewById(R.id.book_ad_text_view);
                                            if (autoScrollView != null) {
                                                return new h5((RelativeLayout) rootView, imageView, themeTextView, readerThemeTextView, imageView2, readerThemeTextView2, themeTextView2, relativeLayout, textView, textView2, autoScrollView);
                                            }
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
    public static h5 c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static h5 d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.reading_ads_item_book_poster, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f12073a;
    }
}
