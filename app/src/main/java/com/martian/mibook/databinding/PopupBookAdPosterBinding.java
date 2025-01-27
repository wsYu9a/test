package com.martian.mibook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.libmars.widget.RoundedLayout;
import com.martian.mibook.R;
import com.martian.mibook.ui.AutoScrollView;

/* loaded from: classes3.dex */
public final class PopupBookAdPosterBinding implements ViewBinding {

    @NonNull
    public final ImageView popupBookAdBg;

    @NonNull
    public final ThemeTextView popupBookAdCardAuthor;

    @NonNull
    public final ImageView popupBookAdCardCover;

    @NonNull
    public final ThemeTextView popupBookAdCardInfo;

    @NonNull
    public final ThemeTextView popupBookAdCardRead;

    @NonNull
    public final RelativeLayout popupBookAdCardView;

    @NonNull
    public final ImageView popupBookAdClose;

    @NonNull
    public final TextView popupBookAdTextContent;

    @NonNull
    public final TextView popupBookAdTextTitle;

    @NonNull
    public final AutoScrollView popupBookAdTextView;

    @NonNull
    public final RoundedLayout popupBookAdView;

    @NonNull
    private final RelativeLayout rootView;

    private PopupBookAdPosterBinding(@NonNull RelativeLayout relativeLayout, @NonNull ImageView imageView, @NonNull ThemeTextView themeTextView, @NonNull ImageView imageView2, @NonNull ThemeTextView themeTextView2, @NonNull ThemeTextView themeTextView3, @NonNull RelativeLayout relativeLayout2, @NonNull ImageView imageView3, @NonNull TextView textView, @NonNull TextView textView2, @NonNull AutoScrollView autoScrollView, @NonNull RoundedLayout roundedLayout) {
        this.rootView = relativeLayout;
        this.popupBookAdBg = imageView;
        this.popupBookAdCardAuthor = themeTextView;
        this.popupBookAdCardCover = imageView2;
        this.popupBookAdCardInfo = themeTextView2;
        this.popupBookAdCardRead = themeTextView3;
        this.popupBookAdCardView = relativeLayout2;
        this.popupBookAdClose = imageView3;
        this.popupBookAdTextContent = textView;
        this.popupBookAdTextTitle = textView2;
        this.popupBookAdTextView = autoScrollView;
        this.popupBookAdView = roundedLayout;
    }

    @NonNull
    public static PopupBookAdPosterBinding bind(@NonNull View view) {
        int i10 = R.id.popup_book_ad_bg;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i10);
        if (imageView != null) {
            i10 = R.id.popup_book_ad_card_author;
            ThemeTextView themeTextView = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
            if (themeTextView != null) {
                i10 = R.id.popup_book_ad_card_cover;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i10);
                if (imageView2 != null) {
                    i10 = R.id.popup_book_ad_card_info;
                    ThemeTextView themeTextView2 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                    if (themeTextView2 != null) {
                        i10 = R.id.popup_book_ad_card_read;
                        ThemeTextView themeTextView3 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                        if (themeTextView3 != null) {
                            i10 = R.id.popup_book_ad_card_view;
                            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i10);
                            if (relativeLayout != null) {
                                i10 = R.id.popup_book_ad_close;
                                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i10);
                                if (imageView3 != null) {
                                    i10 = R.id.popup_book_ad_text_content;
                                    TextView textView = (TextView) ViewBindings.findChildViewById(view, i10);
                                    if (textView != null) {
                                        i10 = R.id.popup_book_ad_text_title;
                                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i10);
                                        if (textView2 != null) {
                                            i10 = R.id.popup_book_ad_text_view;
                                            AutoScrollView autoScrollView = (AutoScrollView) ViewBindings.findChildViewById(view, i10);
                                            if (autoScrollView != null) {
                                                i10 = R.id.popup_book_ad_view;
                                                RoundedLayout roundedLayout = (RoundedLayout) ViewBindings.findChildViewById(view, i10);
                                                if (roundedLayout != null) {
                                                    return new PopupBookAdPosterBinding((RelativeLayout) view, imageView, themeTextView, imageView2, themeTextView2, themeTextView3, relativeLayout, imageView3, textView, textView2, autoScrollView, roundedLayout);
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
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static PopupBookAdPosterBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static PopupBookAdPosterBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.popup_book_ad_poster, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public RelativeLayout getRoot() {
        return this.rootView;
    }
}
