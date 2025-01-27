package com.martian.mibook.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.martian.mibook.ui.reader.ReaderThemeImageView;
import com.martian.mibook.ui.reader.ReaderThemeItemTextView;
import com.martian.mibook.ui.reader.ReaderThemeTextView;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public final class y3 implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final LinearLayout f12973a;

    /* renamed from: b */
    @NonNull
    public final LinearLayout f12974b;

    /* renamed from: c */
    @NonNull
    public final LinearLayout f12975c;

    /* renamed from: d */
    @NonNull
    public final TextView f12976d;

    /* renamed from: e */
    @NonNull
    public final ReaderThemeImageView f12977e;

    /* renamed from: f */
    @NonNull
    public final LinearLayout f12978f;

    /* renamed from: g */
    @NonNull
    public final ReaderThemeTextView f12979g;

    /* renamed from: h */
    @NonNull
    public final ReaderThemeTextView f12980h;

    /* renamed from: i */
    @NonNull
    public final ReaderThemeTextView f12981i;

    /* renamed from: j */
    @NonNull
    public final ReaderThemeTextView f12982j;

    @NonNull
    public final ReaderThemeItemTextView k;

    @NonNull
    public final ReaderThemeItemTextView l;

    @NonNull
    public final ReaderThemeTextView m;

    @NonNull
    public final LinearLayout n;

    private y3(@NonNull LinearLayout rootView, @NonNull LinearLayout accountView, @NonNull LinearLayout priceView, @NonNull TextView tvBuyAccountBookCoins, @NonNull ReaderThemeImageView tvBuyAuto, @NonNull LinearLayout tvBuyAutoView, @NonNull ReaderThemeTextView tvBuyReadingBookname, @NonNull ReaderThemeTextView tvBuyReadingContent, @NonNull ReaderThemeTextView tvBuyReadingHint, @NonNull ReaderThemeTextView tvBuyReadingPrice, @NonNull ReaderThemeItemTextView tvBuyReadingPurchase, @NonNull ReaderThemeItemTextView tvBuyReadingPurchaseVideo, @NonNull ReaderThemeTextView tvBuyReadingTitle, @NonNull LinearLayout tvBuyReadingTitleView) {
        this.f12973a = rootView;
        this.f12974b = accountView;
        this.f12975c = priceView;
        this.f12976d = tvBuyAccountBookCoins;
        this.f12977e = tvBuyAuto;
        this.f12978f = tvBuyAutoView;
        this.f12979g = tvBuyReadingBookname;
        this.f12980h = tvBuyReadingContent;
        this.f12981i = tvBuyReadingHint;
        this.f12982j = tvBuyReadingPrice;
        this.k = tvBuyReadingPurchase;
        this.l = tvBuyReadingPurchaseVideo;
        this.m = tvBuyReadingTitle;
        this.n = tvBuyReadingTitleView;
    }

    @NonNull
    public static y3 a(@NonNull View rootView) {
        int i2 = R.id.account_view;
        LinearLayout linearLayout = (LinearLayout) rootView.findViewById(R.id.account_view);
        if (linearLayout != null) {
            i2 = R.id.price_view;
            LinearLayout linearLayout2 = (LinearLayout) rootView.findViewById(R.id.price_view);
            if (linearLayout2 != null) {
                i2 = R.id.tv_buy_account_book_coins;
                TextView textView = (TextView) rootView.findViewById(R.id.tv_buy_account_book_coins);
                if (textView != null) {
                    i2 = R.id.tv_buy_auto;
                    ReaderThemeImageView readerThemeImageView = (ReaderThemeImageView) rootView.findViewById(R.id.tv_buy_auto);
                    if (readerThemeImageView != null) {
                        i2 = R.id.tv_buy_auto_view;
                        LinearLayout linearLayout3 = (LinearLayout) rootView.findViewById(R.id.tv_buy_auto_view);
                        if (linearLayout3 != null) {
                            i2 = R.id.tv_buy_reading_bookname;
                            ReaderThemeTextView readerThemeTextView = (ReaderThemeTextView) rootView.findViewById(R.id.tv_buy_reading_bookname);
                            if (readerThemeTextView != null) {
                                i2 = R.id.tv_buy_reading_content;
                                ReaderThemeTextView readerThemeTextView2 = (ReaderThemeTextView) rootView.findViewById(R.id.tv_buy_reading_content);
                                if (readerThemeTextView2 != null) {
                                    i2 = R.id.tv_buy_reading_hint;
                                    ReaderThemeTextView readerThemeTextView3 = (ReaderThemeTextView) rootView.findViewById(R.id.tv_buy_reading_hint);
                                    if (readerThemeTextView3 != null) {
                                        i2 = R.id.tv_buy_reading_price;
                                        ReaderThemeTextView readerThemeTextView4 = (ReaderThemeTextView) rootView.findViewById(R.id.tv_buy_reading_price);
                                        if (readerThemeTextView4 != null) {
                                            i2 = R.id.tv_buy_reading_purchase;
                                            ReaderThemeItemTextView readerThemeItemTextView = (ReaderThemeItemTextView) rootView.findViewById(R.id.tv_buy_reading_purchase);
                                            if (readerThemeItemTextView != null) {
                                                i2 = R.id.tv_buy_reading_purchase_video;
                                                ReaderThemeItemTextView readerThemeItemTextView2 = (ReaderThemeItemTextView) rootView.findViewById(R.id.tv_buy_reading_purchase_video);
                                                if (readerThemeItemTextView2 != null) {
                                                    i2 = R.id.tv_buy_reading_title;
                                                    ReaderThemeTextView readerThemeTextView5 = (ReaderThemeTextView) rootView.findViewById(R.id.tv_buy_reading_title);
                                                    if (readerThemeTextView5 != null) {
                                                        i2 = R.id.tv_buy_reading_title_view;
                                                        LinearLayout linearLayout4 = (LinearLayout) rootView.findViewById(R.id.tv_buy_reading_title_view);
                                                        if (linearLayout4 != null) {
                                                            return new y3((LinearLayout) rootView, linearLayout, linearLayout2, textView, readerThemeImageView, linearLayout3, readerThemeTextView, readerThemeTextView2, readerThemeTextView3, readerThemeTextView4, readerThemeItemTextView, readerThemeItemTextView2, readerThemeTextView5, linearLayout4);
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
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i2)));
    }

    @NonNull
    public static y3 c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static y3 d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.loading_purchase, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public LinearLayout getRoot() {
        return this.f12973a;
    }
}
