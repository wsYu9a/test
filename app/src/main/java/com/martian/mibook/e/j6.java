package com.martian.mibook.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.martian.libsliding.SlidingLayout;
import com.martian.mibook.ui.reader.ReaderThemeImageView;
import com.martian.mibook.ui.reader.ReaderThemeProgressBar;
import com.martian.mibook.ui.reader.ReaderThemeTextView;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public final class j6 implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final RelativeLayout f12198a;

    /* renamed from: b */
    @NonNull
    public final LinearLayout f12199b;

    /* renamed from: c */
    @NonNull
    public final a6 f12200c;

    /* renamed from: d */
    @NonNull
    public final ViewStub f12201d;

    /* renamed from: e */
    @NonNull
    public final ViewStub f12202e;

    /* renamed from: f */
    @NonNull
    public final ReaderThemeImageView f12203f;

    /* renamed from: g */
    @NonNull
    public final ReaderThemeProgressBar f12204g;

    /* renamed from: h */
    @NonNull
    public final ReaderThemeTextView f12205h;

    /* renamed from: i */
    @NonNull
    public final SlidingLayout f12206i;

    /* renamed from: j */
    @NonNull
    public final ReaderThemeTextView f12207j;

    @NonNull
    public final LinearLayout k;

    @NonNull
    public final ReaderThemeTextView l;

    @NonNull
    public final LinearLayout m;

    private j6(@NonNull RelativeLayout rootView, @NonNull LinearLayout llScrollReadingContainer, @NonNull a6 lyFakeReadingLayout, @NonNull ViewStub readingBanner, @NonNull ViewStub readingTtsPosition, @NonNull ReaderThemeImageView scrollRbsIvBattery, @NonNull ReaderThemeProgressBar scrollRbsTvBattery, @NonNull ReaderThemeTextView scrollRbsTvTime, @NonNull SlidingLayout slReadingContainer, @NonNull ReaderThemeTextView tvScrollContentPage, @NonNull LinearLayout tvScrollReadingBottomStatusView, @NonNull ReaderThemeTextView tvScrollReadingTitle, @NonNull LinearLayout tvScrollReadingTitleView) {
        this.f12198a = rootView;
        this.f12199b = llScrollReadingContainer;
        this.f12200c = lyFakeReadingLayout;
        this.f12201d = readingBanner;
        this.f12202e = readingTtsPosition;
        this.f12203f = scrollRbsIvBattery;
        this.f12204g = scrollRbsTvBattery;
        this.f12205h = scrollRbsTvTime;
        this.f12206i = slReadingContainer;
        this.f12207j = tvScrollContentPage;
        this.k = tvScrollReadingBottomStatusView;
        this.l = tvScrollReadingTitle;
        this.m = tvScrollReadingTitleView;
    }

    @NonNull
    public static j6 a(@NonNull View rootView) {
        int i2 = R.id.ll_scroll_reading_container;
        LinearLayout linearLayout = (LinearLayout) rootView.findViewById(R.id.ll_scroll_reading_container);
        if (linearLayout != null) {
            i2 = R.id.ly_fake_reading_layout;
            View findViewById = rootView.findViewById(R.id.ly_fake_reading_layout);
            if (findViewById != null) {
                a6 a2 = a6.a(findViewById);
                i2 = R.id.reading_banner;
                ViewStub viewStub = (ViewStub) rootView.findViewById(R.id.reading_banner);
                if (viewStub != null) {
                    i2 = R.id.reading_tts_position;
                    ViewStub viewStub2 = (ViewStub) rootView.findViewById(R.id.reading_tts_position);
                    if (viewStub2 != null) {
                        i2 = R.id.scroll_rbs_iv_battery;
                        ReaderThemeImageView readerThemeImageView = (ReaderThemeImageView) rootView.findViewById(R.id.scroll_rbs_iv_battery);
                        if (readerThemeImageView != null) {
                            i2 = R.id.scroll_rbs_tv_battery;
                            ReaderThemeProgressBar readerThemeProgressBar = (ReaderThemeProgressBar) rootView.findViewById(R.id.scroll_rbs_tv_battery);
                            if (readerThemeProgressBar != null) {
                                i2 = R.id.scroll_rbs_tv_time;
                                ReaderThemeTextView readerThemeTextView = (ReaderThemeTextView) rootView.findViewById(R.id.scroll_rbs_tv_time);
                                if (readerThemeTextView != null) {
                                    i2 = R.id.sl_reading_container;
                                    SlidingLayout slidingLayout = (SlidingLayout) rootView.findViewById(R.id.sl_reading_container);
                                    if (slidingLayout != null) {
                                        i2 = R.id.tv_scroll_content_page;
                                        ReaderThemeTextView readerThemeTextView2 = (ReaderThemeTextView) rootView.findViewById(R.id.tv_scroll_content_page);
                                        if (readerThemeTextView2 != null) {
                                            i2 = R.id.tv_scroll_reading_bottom_status_view;
                                            LinearLayout linearLayout2 = (LinearLayout) rootView.findViewById(R.id.tv_scroll_reading_bottom_status_view);
                                            if (linearLayout2 != null) {
                                                i2 = R.id.tv_scroll_reading_title;
                                                ReaderThemeTextView readerThemeTextView3 = (ReaderThemeTextView) rootView.findViewById(R.id.tv_scroll_reading_title);
                                                if (readerThemeTextView3 != null) {
                                                    i2 = R.id.tv_scroll_reading_title_view;
                                                    LinearLayout linearLayout3 = (LinearLayout) rootView.findViewById(R.id.tv_scroll_reading_title_view);
                                                    if (linearLayout3 != null) {
                                                        return new j6((RelativeLayout) rootView, linearLayout, a2, viewStub, viewStub2, readerThemeImageView, readerThemeProgressBar, readerThemeTextView, slidingLayout, readerThemeTextView2, linearLayout2, readerThemeTextView3, linearLayout3);
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
    public static j6 c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static j6 d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.reading_scroll_container, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f12198a;
    }
}
