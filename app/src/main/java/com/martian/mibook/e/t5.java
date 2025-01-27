package com.martian.mibook.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.libmars.widget.RoundedLayout;
import com.martian.mibook.ui.IntervalCountdownTextView;
import com.martian.mibook.ui.reader.ReaderThemeImageView;
import com.martian.mibook.ui.reader.ReaderThemeItemTextView;
import com.martian.mibook.ui.reader.ReaderThemeLinearLayout;
import com.martian.mibook.ui.reader.ReaderThemeSeekBar;
import com.martian.mibook.ui.reader.ReaderThemeTextView;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public final class t5 implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final LinearLayout f12738a;

    /* renamed from: b */
    @NonNull
    public final ReaderThemeLinearLayout f12739b;

    /* renamed from: c */
    @NonNull
    public final ReaderThemeLinearLayout f12740c;

    /* renamed from: d */
    @NonNull
    public final ReaderThemeTextView f12741d;

    /* renamed from: e */
    @NonNull
    public final ReaderThemeImageView f12742e;

    /* renamed from: f */
    @NonNull
    public final RoundedLayout f12743f;

    /* renamed from: g */
    @NonNull
    public final ReaderThemeTextView f12744g;

    /* renamed from: h */
    @NonNull
    public final ReaderThemeImageView f12745h;

    /* renamed from: i */
    @NonNull
    public final IntervalCountdownTextView f12746i;

    /* renamed from: j */
    @NonNull
    public final ThemeTextView f12747j;

    @NonNull
    public final ReaderThemeLinearLayout k;

    @NonNull
    public final ReaderThemeImageView l;

    @NonNull
    public final ReaderThemeTextView m;

    @NonNull
    public final ReaderThemeItemTextView n;

    @NonNull
    public final ReaderThemeItemTextView o;

    @NonNull
    public final ReaderThemeSeekBar p;

    @NonNull
    public final ViewStub q;

    @NonNull
    public final ReaderThemeTextView r;

    @NonNull
    public final ReaderThemeTextView s;

    @NonNull
    public final ReaderThemeTextView t;

    private t5(@NonNull LinearLayout rootView, @NonNull ReaderThemeLinearLayout readingCacheStatus, @NonNull ReaderThemeLinearLayout readingChapterLine, @NonNull ReaderThemeTextView readingChapterNumber, @NonNull ReaderThemeImageView readingChapterReturnIcon, @NonNull RoundedLayout readingChapterSeek, @NonNull ReaderThemeTextView readingChapterTitle, @NonNull ReaderThemeImageView readingDir, @NonNull IntervalCountdownTextView readingHideAdCountdown, @NonNull ThemeTextView readingHideAdMore, @NonNull ReaderThemeLinearLayout readingHideAdView, @NonNull ReaderThemeImageView readingLightSetting, @NonNull ReaderThemeTextView readingLightTitle, @NonNull ReaderThemeItemTextView sbChapterNext, @NonNull ReaderThemeItemTextView sbChapterPrevious, @NonNull ReaderThemeSeekBar sbChapterSeek, @NonNull ViewStub ttsFloatView, @NonNull ReaderThemeTextView tvBookname, @NonNull ReaderThemeTextView tvCacheStatus, @NonNull ReaderThemeTextView tvProgress) {
        this.f12738a = rootView;
        this.f12739b = readingCacheStatus;
        this.f12740c = readingChapterLine;
        this.f12741d = readingChapterNumber;
        this.f12742e = readingChapterReturnIcon;
        this.f12743f = readingChapterSeek;
        this.f12744g = readingChapterTitle;
        this.f12745h = readingDir;
        this.f12746i = readingHideAdCountdown;
        this.f12747j = readingHideAdMore;
        this.k = readingHideAdView;
        this.l = readingLightSetting;
        this.m = readingLightTitle;
        this.n = sbChapterNext;
        this.o = sbChapterPrevious;
        this.p = sbChapterSeek;
        this.q = ttsFloatView;
        this.r = tvBookname;
        this.s = tvCacheStatus;
        this.t = tvProgress;
    }

    @NonNull
    public static t5 a(@NonNull View rootView) {
        int i2 = R.id.reading_cache_status;
        ReaderThemeLinearLayout readerThemeLinearLayout = (ReaderThemeLinearLayout) rootView.findViewById(R.id.reading_cache_status);
        if (readerThemeLinearLayout != null) {
            i2 = R.id.reading_chapter_line;
            ReaderThemeLinearLayout readerThemeLinearLayout2 = (ReaderThemeLinearLayout) rootView.findViewById(R.id.reading_chapter_line);
            if (readerThemeLinearLayout2 != null) {
                i2 = R.id.reading_chapter_number;
                ReaderThemeTextView readerThemeTextView = (ReaderThemeTextView) rootView.findViewById(R.id.reading_chapter_number);
                if (readerThemeTextView != null) {
                    i2 = R.id.reading_chapter_return_icon;
                    ReaderThemeImageView readerThemeImageView = (ReaderThemeImageView) rootView.findViewById(R.id.reading_chapter_return_icon);
                    if (readerThemeImageView != null) {
                        i2 = R.id.reading_chapter_seek;
                        RoundedLayout roundedLayout = (RoundedLayout) rootView.findViewById(R.id.reading_chapter_seek);
                        if (roundedLayout != null) {
                            i2 = R.id.reading_chapter_title;
                            ReaderThemeTextView readerThemeTextView2 = (ReaderThemeTextView) rootView.findViewById(R.id.reading_chapter_title);
                            if (readerThemeTextView2 != null) {
                                i2 = R.id.reading_dir;
                                ReaderThemeImageView readerThemeImageView2 = (ReaderThemeImageView) rootView.findViewById(R.id.reading_dir);
                                if (readerThemeImageView2 != null) {
                                    i2 = R.id.reading_hide_ad_countdown;
                                    IntervalCountdownTextView intervalCountdownTextView = (IntervalCountdownTextView) rootView.findViewById(R.id.reading_hide_ad_countdown);
                                    if (intervalCountdownTextView != null) {
                                        i2 = R.id.reading_hide_ad_more;
                                        ThemeTextView themeTextView = (ThemeTextView) rootView.findViewById(R.id.reading_hide_ad_more);
                                        if (themeTextView != null) {
                                            i2 = R.id.reading_hide_ad_view;
                                            ReaderThemeLinearLayout readerThemeLinearLayout3 = (ReaderThemeLinearLayout) rootView.findViewById(R.id.reading_hide_ad_view);
                                            if (readerThemeLinearLayout3 != null) {
                                                i2 = R.id.reading_light_setting;
                                                ReaderThemeImageView readerThemeImageView3 = (ReaderThemeImageView) rootView.findViewById(R.id.reading_light_setting);
                                                if (readerThemeImageView3 != null) {
                                                    i2 = R.id.reading_light_title;
                                                    ReaderThemeTextView readerThemeTextView3 = (ReaderThemeTextView) rootView.findViewById(R.id.reading_light_title);
                                                    if (readerThemeTextView3 != null) {
                                                        i2 = R.id.sb_chapter_next;
                                                        ReaderThemeItemTextView readerThemeItemTextView = (ReaderThemeItemTextView) rootView.findViewById(R.id.sb_chapter_next);
                                                        if (readerThemeItemTextView != null) {
                                                            i2 = R.id.sb_chapter_previous;
                                                            ReaderThemeItemTextView readerThemeItemTextView2 = (ReaderThemeItemTextView) rootView.findViewById(R.id.sb_chapter_previous);
                                                            if (readerThemeItemTextView2 != null) {
                                                                i2 = R.id.sb_chapter_seek;
                                                                ReaderThemeSeekBar readerThemeSeekBar = (ReaderThemeSeekBar) rootView.findViewById(R.id.sb_chapter_seek);
                                                                if (readerThemeSeekBar != null) {
                                                                    i2 = R.id.tts_float_view;
                                                                    ViewStub viewStub = (ViewStub) rootView.findViewById(R.id.tts_float_view);
                                                                    if (viewStub != null) {
                                                                        i2 = R.id.tv_bookname;
                                                                        ReaderThemeTextView readerThemeTextView4 = (ReaderThemeTextView) rootView.findViewById(R.id.tv_bookname);
                                                                        if (readerThemeTextView4 != null) {
                                                                            i2 = R.id.tv_cache_status;
                                                                            ReaderThemeTextView readerThemeTextView5 = (ReaderThemeTextView) rootView.findViewById(R.id.tv_cache_status);
                                                                            if (readerThemeTextView5 != null) {
                                                                                i2 = R.id.tv_progress;
                                                                                ReaderThemeTextView readerThemeTextView6 = (ReaderThemeTextView) rootView.findViewById(R.id.tv_progress);
                                                                                if (readerThemeTextView6 != null) {
                                                                                    return new t5((LinearLayout) rootView, readerThemeLinearLayout, readerThemeLinearLayout2, readerThemeTextView, readerThemeImageView, roundedLayout, readerThemeTextView2, readerThemeImageView2, intervalCountdownTextView, themeTextView, readerThemeLinearLayout3, readerThemeImageView3, readerThemeTextView3, readerThemeItemTextView, readerThemeItemTextView2, readerThemeSeekBar, viewStub, readerThemeTextView4, readerThemeTextView5, readerThemeTextView6);
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
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i2)));
    }

    @NonNull
    public static t5 c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static t5 d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.reading_bottom_bar, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public LinearLayout getRoot() {
        return this.f12738a;
    }
}
