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
import com.martian.mibook.ui.AutoScrollView;
import com.martian.mibook.ui.reader.ReaderThemeTextView;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public final class f5 implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final RelativeLayout f11952a;

    /* renamed from: b */
    @NonNull
    public final TextView f11953b;

    /* renamed from: c */
    @NonNull
    public final ReaderThemeTextView f11954c;

    /* renamed from: d */
    @NonNull
    public final ReaderThemeTextView f11955d;

    /* renamed from: e */
    @NonNull
    public final AutoScrollView f11956e;

    /* renamed from: f */
    @NonNull
    public final ImageView f11957f;

    /* renamed from: g */
    @NonNull
    public final ReaderThemeTextView f11958g;

    /* renamed from: h */
    @NonNull
    public final ReaderThemeTextView f11959h;

    /* renamed from: i */
    @NonNull
    public final TextView f11960i;

    /* renamed from: j */
    @NonNull
    public final TextView f11961j;

    @NonNull
    public final TextView k;

    @NonNull
    public final LinearLayout l;

    private f5(@NonNull RelativeLayout rootView, @NonNull TextView bookAdAddBookrack, @NonNull ReaderThemeTextView bookAdAuthor, @NonNull ReaderThemeTextView bookAdContent, @NonNull AutoScrollView bookAdContentView, @NonNull ImageView bookAdCover, @NonNull ReaderThemeTextView bookAdInfo, @NonNull ReaderThemeTextView bookAdName, @NonNull TextView bookAdRank, @NonNull TextView bookAdRecommend, @NonNull TextView bookAdScore, @NonNull LinearLayout bookAdScoreView) {
        this.f11952a = rootView;
        this.f11953b = bookAdAddBookrack;
        this.f11954c = bookAdAuthor;
        this.f11955d = bookAdContent;
        this.f11956e = bookAdContentView;
        this.f11957f = bookAdCover;
        this.f11958g = bookAdInfo;
        this.f11959h = bookAdName;
        this.f11960i = bookAdRank;
        this.f11961j = bookAdRecommend;
        this.k = bookAdScore;
        this.l = bookAdScoreView;
    }

    @NonNull
    public static f5 a(@NonNull View rootView) {
        int i2 = R.id.book_ad_add_bookrack;
        TextView textView = (TextView) rootView.findViewById(R.id.book_ad_add_bookrack);
        if (textView != null) {
            i2 = R.id.book_ad_author;
            ReaderThemeTextView readerThemeTextView = (ReaderThemeTextView) rootView.findViewById(R.id.book_ad_author);
            if (readerThemeTextView != null) {
                i2 = R.id.book_ad_content;
                ReaderThemeTextView readerThemeTextView2 = (ReaderThemeTextView) rootView.findViewById(R.id.book_ad_content);
                if (readerThemeTextView2 != null) {
                    i2 = R.id.book_ad_content_view;
                    AutoScrollView autoScrollView = (AutoScrollView) rootView.findViewById(R.id.book_ad_content_view);
                    if (autoScrollView != null) {
                        i2 = R.id.book_ad_cover;
                        ImageView imageView = (ImageView) rootView.findViewById(R.id.book_ad_cover);
                        if (imageView != null) {
                            i2 = R.id.book_ad_info;
                            ReaderThemeTextView readerThemeTextView3 = (ReaderThemeTextView) rootView.findViewById(R.id.book_ad_info);
                            if (readerThemeTextView3 != null) {
                                i2 = R.id.book_ad_name;
                                ReaderThemeTextView readerThemeTextView4 = (ReaderThemeTextView) rootView.findViewById(R.id.book_ad_name);
                                if (readerThemeTextView4 != null) {
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
                                                    return new f5((RelativeLayout) rootView, textView, readerThemeTextView, readerThemeTextView2, autoScrollView, imageView, readerThemeTextView3, readerThemeTextView4, textView2, textView3, textView4, linearLayout);
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
    public static f5 c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static f5 d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.reading_ads_item_book, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f11952a;
    }
}
