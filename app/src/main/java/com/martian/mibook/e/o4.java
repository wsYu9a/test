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
import com.martian.libmars.widget.RoundedLayout;
import com.martian.mibook.ui.AutoScrollView;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public final class o4 implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final RelativeLayout f12479a;

    /* renamed from: b */
    @NonNull
    public final ImageView f12480b;

    /* renamed from: c */
    @NonNull
    public final ThemeTextView f12481c;

    /* renamed from: d */
    @NonNull
    public final ImageView f12482d;

    /* renamed from: e */
    @NonNull
    public final ThemeTextView f12483e;

    /* renamed from: f */
    @NonNull
    public final ThemeTextView f12484f;

    /* renamed from: g */
    @NonNull
    public final RelativeLayout f12485g;

    /* renamed from: h */
    @NonNull
    public final ImageView f12486h;

    /* renamed from: i */
    @NonNull
    public final TextView f12487i;

    /* renamed from: j */
    @NonNull
    public final TextView f12488j;

    @NonNull
    public final AutoScrollView k;

    @NonNull
    public final RoundedLayout l;

    private o4(@NonNull RelativeLayout rootView, @NonNull ImageView popupBookAdBg, @NonNull ThemeTextView popupBookAdCardAuthor, @NonNull ImageView popupBookAdCardCover, @NonNull ThemeTextView popupBookAdCardInfo, @NonNull ThemeTextView popupBookAdCardRead, @NonNull RelativeLayout popupBookAdCardView, @NonNull ImageView popupBookAdClose, @NonNull TextView popupBookAdTextContent, @NonNull TextView popupBookAdTextTitle, @NonNull AutoScrollView popupBookAdTextView, @NonNull RoundedLayout popupBookAdView) {
        this.f12479a = rootView;
        this.f12480b = popupBookAdBg;
        this.f12481c = popupBookAdCardAuthor;
        this.f12482d = popupBookAdCardCover;
        this.f12483e = popupBookAdCardInfo;
        this.f12484f = popupBookAdCardRead;
        this.f12485g = popupBookAdCardView;
        this.f12486h = popupBookAdClose;
        this.f12487i = popupBookAdTextContent;
        this.f12488j = popupBookAdTextTitle;
        this.k = popupBookAdTextView;
        this.l = popupBookAdView;
    }

    @NonNull
    public static o4 a(@NonNull View rootView) {
        int i2 = R.id.popup_book_ad_bg;
        ImageView imageView = (ImageView) rootView.findViewById(R.id.popup_book_ad_bg);
        if (imageView != null) {
            i2 = R.id.popup_book_ad_card_author;
            ThemeTextView themeTextView = (ThemeTextView) rootView.findViewById(R.id.popup_book_ad_card_author);
            if (themeTextView != null) {
                i2 = R.id.popup_book_ad_card_cover;
                ImageView imageView2 = (ImageView) rootView.findViewById(R.id.popup_book_ad_card_cover);
                if (imageView2 != null) {
                    i2 = R.id.popup_book_ad_card_info;
                    ThemeTextView themeTextView2 = (ThemeTextView) rootView.findViewById(R.id.popup_book_ad_card_info);
                    if (themeTextView2 != null) {
                        i2 = R.id.popup_book_ad_card_read;
                        ThemeTextView themeTextView3 = (ThemeTextView) rootView.findViewById(R.id.popup_book_ad_card_read);
                        if (themeTextView3 != null) {
                            i2 = R.id.popup_book_ad_card_view;
                            RelativeLayout relativeLayout = (RelativeLayout) rootView.findViewById(R.id.popup_book_ad_card_view);
                            if (relativeLayout != null) {
                                i2 = R.id.popup_book_ad_close;
                                ImageView imageView3 = (ImageView) rootView.findViewById(R.id.popup_book_ad_close);
                                if (imageView3 != null) {
                                    i2 = R.id.popup_book_ad_text_content;
                                    TextView textView = (TextView) rootView.findViewById(R.id.popup_book_ad_text_content);
                                    if (textView != null) {
                                        i2 = R.id.popup_book_ad_text_title;
                                        TextView textView2 = (TextView) rootView.findViewById(R.id.popup_book_ad_text_title);
                                        if (textView2 != null) {
                                            i2 = R.id.popup_book_ad_text_view;
                                            AutoScrollView autoScrollView = (AutoScrollView) rootView.findViewById(R.id.popup_book_ad_text_view);
                                            if (autoScrollView != null) {
                                                i2 = R.id.popup_book_ad_view;
                                                RoundedLayout roundedLayout = (RoundedLayout) rootView.findViewById(R.id.popup_book_ad_view);
                                                if (roundedLayout != null) {
                                                    return new o4((RelativeLayout) rootView, imageView, themeTextView, imageView2, themeTextView2, themeTextView3, relativeLayout, imageView3, textView, textView2, autoScrollView, roundedLayout);
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
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i2)));
    }

    @NonNull
    public static o4 c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static o4 d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.popup_book_ad_poster, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f12479a;
    }
}
