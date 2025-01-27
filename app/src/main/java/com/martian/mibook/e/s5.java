package com.martian.mibook.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.martian.mibook.ui.reader.ReaderThemeImageView;
import com.martian.mibook.ui.reader.ReaderThemeItemTextView;
import com.martian.mibook.ui.reader.ReaderThemeLinearLayout;
import com.martian.mibook.ui.reader.ReaderThemeTextView;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public final class s5 implements ViewBinding {

    @Nullable
    public final ReaderThemeItemTextView A;

    @NonNull
    public final ReaderThemeTextView B;

    /* renamed from: a */
    @NonNull
    private final RelativeLayout f12682a;

    /* renamed from: b */
    @NonNull
    public final ReaderThemeImageView f12683b;

    /* renamed from: c */
    @Nullable
    public final ReaderThemeLinearLayout f12684c;

    /* renamed from: d */
    @Nullable
    public final TextView f12685d;

    /* renamed from: e */
    @NonNull
    public final ReaderThemeTextView f12686e;

    /* renamed from: f */
    @Nullable
    public final ReaderThemeTextView f12687f;

    /* renamed from: g */
    @Nullable
    public final ReaderThemeTextView f12688g;

    /* renamed from: h */
    @Nullable
    public final LinearLayout f12689h;

    /* renamed from: i */
    @NonNull
    public final ReaderThemeTextView f12690i;

    /* renamed from: j */
    @Nullable
    public final ScrollView f12691j;

    @Nullable
    public final ImageView k;

    @NonNull
    public final View l;

    @Nullable
    public final LinearLayout m;

    @NonNull
    public final ReaderThemeTextView n;

    @Nullable
    public final ReaderThemeTextView o;

    @Nullable
    public final ReaderThemeImageView p;

    @Nullable
    public final LinearLayout q;

    @Nullable
    public final ReaderThemeTextView r;

    @Nullable
    public final ReaderThemeTextView s;

    @Nullable
    public final ReaderThemeTextView t;

    @Nullable
    public final RelativeLayout u;

    @Nullable
    public final ReaderThemeTextView v;

    @Nullable
    public final ReaderThemeTextView w;

    @Nullable
    public final LinearLayout x;

    @Nullable
    public final ReaderThemeItemTextView y;

    @Nullable
    public final ReaderThemeItemTextView z;

    private s5(@NonNull RelativeLayout rootView, @NonNull ReaderThemeImageView bgBookCover, @Nullable ReaderThemeLinearLayout coverHeaderView, @Nullable TextView ivUpdateSign, @NonNull ReaderThemeTextView openBookAuthor, @Nullable ReaderThemeTextView openBookClickCount, @Nullable ReaderThemeTextView openBookClickCountUnit, @Nullable LinearLayout openBookClickCountView, @NonNull ReaderThemeTextView openBookCopyright, @Nullable ScrollView openBookCopyrightView, @Nullable ImageView openBookCoverShadow, @NonNull View openBookIcon, @Nullable LinearLayout openBookIntroView, @NonNull ReaderThemeTextView openBookName, @Nullable ReaderThemeTextView openBookNcomments, @Nullable ReaderThemeImageView openBookNcommentsMore, @Nullable LinearLayout openBookNcommentsView, @Nullable ReaderThemeTextView openBookReadingCount, @Nullable ReaderThemeTextView openBookReadingCountHint, @Nullable ReaderThemeTextView openBookReadingCountUnit, @Nullable RelativeLayout openBookReadingCountView, @Nullable ReaderThemeTextView openBookScore, @Nullable ReaderThemeTextView openBookScoreUnit, @Nullable LinearLayout openBookScoreView, @Nullable ReaderThemeItemTextView openBookTag1, @Nullable ReaderThemeItemTextView openBookTag2, @Nullable ReaderThemeItemTextView openBookTag3, @NonNull ReaderThemeTextView openBookWarn) {
        this.f12682a = rootView;
        this.f12683b = bgBookCover;
        this.f12684c = coverHeaderView;
        this.f12685d = ivUpdateSign;
        this.f12686e = openBookAuthor;
        this.f12687f = openBookClickCount;
        this.f12688g = openBookClickCountUnit;
        this.f12689h = openBookClickCountView;
        this.f12690i = openBookCopyright;
        this.f12691j = openBookCopyrightView;
        this.k = openBookCoverShadow;
        this.l = openBookIcon;
        this.m = openBookIntroView;
        this.n = openBookName;
        this.o = openBookNcomments;
        this.p = openBookNcommentsMore;
        this.q = openBookNcommentsView;
        this.r = openBookReadingCount;
        this.s = openBookReadingCountHint;
        this.t = openBookReadingCountUnit;
        this.u = openBookReadingCountView;
        this.v = openBookScore;
        this.w = openBookScoreUnit;
        this.x = openBookScoreView;
        this.y = openBookTag1;
        this.z = openBookTag2;
        this.A = openBookTag3;
        this.B = openBookWarn;
    }

    @NonNull
    public static s5 a(@NonNull View rootView) {
        int i2 = R.id.bg_book_cover;
        ReaderThemeImageView readerThemeImageView = (ReaderThemeImageView) rootView.findViewById(R.id.bg_book_cover);
        if (readerThemeImageView != null) {
            ReaderThemeLinearLayout readerThemeLinearLayout = (ReaderThemeLinearLayout) rootView.findViewById(R.id.cover_header_view);
            TextView textView = (TextView) rootView.findViewById(R.id.iv_update_sign);
            i2 = R.id.open_book_author;
            ReaderThemeTextView readerThemeTextView = (ReaderThemeTextView) rootView.findViewById(R.id.open_book_author);
            if (readerThemeTextView != null) {
                ReaderThemeTextView readerThemeTextView2 = (ReaderThemeTextView) rootView.findViewById(R.id.open_book_click_count);
                ReaderThemeTextView readerThemeTextView3 = (ReaderThemeTextView) rootView.findViewById(R.id.open_book_click_count_unit);
                LinearLayout linearLayout = (LinearLayout) rootView.findViewById(R.id.open_book_click_count_view);
                i2 = R.id.open_book_copyright;
                ReaderThemeTextView readerThemeTextView4 = (ReaderThemeTextView) rootView.findViewById(R.id.open_book_copyright);
                if (readerThemeTextView4 != null) {
                    ScrollView scrollView = (ScrollView) rootView.findViewById(R.id.open_book_copyright_view);
                    ImageView imageView = (ImageView) rootView.findViewById(R.id.open_book_cover_shadow);
                    i2 = R.id.open_book_icon;
                    View findViewById = rootView.findViewById(R.id.open_book_icon);
                    if (findViewById != null) {
                        LinearLayout linearLayout2 = (LinearLayout) rootView.findViewById(R.id.open_book_intro_view);
                        i2 = R.id.open_book_name;
                        ReaderThemeTextView readerThemeTextView5 = (ReaderThemeTextView) rootView.findViewById(R.id.open_book_name);
                        if (readerThemeTextView5 != null) {
                            ReaderThemeTextView readerThemeTextView6 = (ReaderThemeTextView) rootView.findViewById(R.id.open_book_ncomments);
                            ReaderThemeImageView readerThemeImageView2 = (ReaderThemeImageView) rootView.findViewById(R.id.open_book_ncomments_more);
                            LinearLayout linearLayout3 = (LinearLayout) rootView.findViewById(R.id.open_book_ncomments_view);
                            ReaderThemeTextView readerThemeTextView7 = (ReaderThemeTextView) rootView.findViewById(R.id.open_book_reading_count);
                            ReaderThemeTextView readerThemeTextView8 = (ReaderThemeTextView) rootView.findViewById(R.id.open_book_reading_count_hint);
                            ReaderThemeTextView readerThemeTextView9 = (ReaderThemeTextView) rootView.findViewById(R.id.open_book_reading_count_unit);
                            RelativeLayout relativeLayout = (RelativeLayout) rootView.findViewById(R.id.open_book_reading_count_view);
                            ReaderThemeTextView readerThemeTextView10 = (ReaderThemeTextView) rootView.findViewById(R.id.open_book_score);
                            ReaderThemeTextView readerThemeTextView11 = (ReaderThemeTextView) rootView.findViewById(R.id.open_book_score_unit);
                            LinearLayout linearLayout4 = (LinearLayout) rootView.findViewById(R.id.open_book_score_view);
                            ReaderThemeItemTextView readerThemeItemTextView = (ReaderThemeItemTextView) rootView.findViewById(R.id.open_book_tag1);
                            ReaderThemeItemTextView readerThemeItemTextView2 = (ReaderThemeItemTextView) rootView.findViewById(R.id.open_book_tag2);
                            ReaderThemeItemTextView readerThemeItemTextView3 = (ReaderThemeItemTextView) rootView.findViewById(R.id.open_book_tag3);
                            i2 = R.id.open_book_warn;
                            ReaderThemeTextView readerThemeTextView12 = (ReaderThemeTextView) rootView.findViewById(R.id.open_book_warn);
                            if (readerThemeTextView12 != null) {
                                return new s5((RelativeLayout) rootView, readerThemeImageView, readerThemeLinearLayout, textView, readerThemeTextView, readerThemeTextView2, readerThemeTextView3, linearLayout, readerThemeTextView4, scrollView, imageView, findViewById, linearLayout2, readerThemeTextView5, readerThemeTextView6, readerThemeImageView2, linearLayout3, readerThemeTextView7, readerThemeTextView8, readerThemeTextView9, relativeLayout, readerThemeTextView10, readerThemeTextView11, linearLayout4, readerThemeItemTextView, readerThemeItemTextView2, readerThemeItemTextView3, readerThemeTextView12);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i2)));
    }

    @NonNull
    public static s5 c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static s5 d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.reading_book_cover, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f12682a;
    }
}
