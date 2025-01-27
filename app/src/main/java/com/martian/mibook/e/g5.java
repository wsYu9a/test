package com.martian.mibook.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.martian.mibook.ui.reader.ReaderThemeTextView;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public final class g5 implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final RelativeLayout f12009a;

    /* renamed from: b */
    @NonNull
    public final TextView f12010b;

    /* renamed from: c */
    @NonNull
    public final ReaderThemeTextView f12011c;

    /* renamed from: d */
    @NonNull
    public final ImageView f12012d;

    /* renamed from: e */
    @NonNull
    public final ReaderThemeTextView f12013e;

    /* renamed from: f */
    @NonNull
    public final ReaderThemeTextView f12014f;

    /* renamed from: g */
    @NonNull
    public final TextView f12015g;

    /* renamed from: h */
    @NonNull
    public final TextView f12016h;

    /* renamed from: i */
    @NonNull
    public final TextView f12017i;

    /* renamed from: j */
    @NonNull
    public final LinearLayout f12018j;

    private g5(@NonNull RelativeLayout rootView, @NonNull TextView bookAdAddBookrack, @NonNull ReaderThemeTextView bookAdAuthor, @NonNull ImageView bookAdCover, @NonNull ReaderThemeTextView bookAdInfo, @NonNull ReaderThemeTextView bookAdName, @NonNull TextView bookAdRank, @NonNull TextView bookAdRecommend, @NonNull TextView bookAdScore, @NonNull LinearLayout bookAdScoreView) {
        this.f12009a = rootView;
        this.f12010b = bookAdAddBookrack;
        this.f12011c = bookAdAuthor;
        this.f12012d = bookAdCover;
        this.f12013e = bookAdInfo;
        this.f12014f = bookAdName;
        this.f12015g = bookAdRank;
        this.f12016h = bookAdRecommend;
        this.f12017i = bookAdScore;
        this.f12018j = bookAdScoreView;
    }

    @NonNull
    public static g5 a(@NonNull View rootView) {
        int i2 = R.id.book_ad_add_bookrack;
        TextView textView = (TextView) rootView.findViewById(R.id.book_ad_add_bookrack);
        if (textView != null) {
            i2 = R.id.book_ad_author;
            ReaderThemeTextView readerThemeTextView = (ReaderThemeTextView) rootView.findViewById(R.id.book_ad_author);
            if (readerThemeTextView != null) {
                i2 = R.id.book_ad_cover;
                ImageView imageView = (ImageView) rootView.findViewById(R.id.book_ad_cover);
                if (imageView != null) {
                    i2 = R.id.book_ad_info;
                    ReaderThemeTextView readerThemeTextView2 = (ReaderThemeTextView) rootView.findViewById(R.id.book_ad_info);
                    if (readerThemeTextView2 != null) {
                        i2 = R.id.book_ad_name;
                        ReaderThemeTextView readerThemeTextView3 = (ReaderThemeTextView) rootView.findViewById(R.id.book_ad_name);
                        if (readerThemeTextView3 != null) {
                            i2 = R.id.book_ad_rank;
                            TextView textView2 = (TextView) rootView.findViewById(R.id.book_ad_rank);
                            if (textView2 != null) {
                                i2 = R.id.book_ad_recommend;
                                TextView textView3 = (TextView) rootView.findViewById(R.id.book_ad_recommend);
                                if (textView3 != null) {
                                    i2 = R.id.book_ad_score;
                                    TextView textView4 = (TextView) rootView.findViewById(R.id.book_ad_score);
                                    if (textView4 != null) {
                                        i2 = R.id.book_ad_score_view;
                                        LinearLayout linearLayout = (LinearLayout) rootView.findViewById(R.id.book_ad_score_view);
                                        if (linearLayout != null) {
                                            return new g5((RelativeLayout) rootView, textView, readerThemeTextView, imageView, readerThemeTextView2, readerThemeTextView3, textView2, textView3, textView4, linearLayout);
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
    public static g5 c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static g5 d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.reading_ads_item_book_large, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f12009a;
    }
}
