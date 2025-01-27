package com.martian.mibook.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import com.martian.libmars.ui.theme.ThemeImageView;
import com.martian.libmars.widget.RoundedLayout;
import com.martian.mibook.ui.reader.ReaderThemeLinearLayout;
import com.martian.mibook.ui.reader.ReaderThemeSwitchButton;
import com.martian.mibook.ui.reader.ReaderThemeTextView;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public final class d6 implements ViewBinding {

    @NonNull
    public final ThemeImageView A;

    @NonNull
    public final ReaderThemeSwitchButton B;

    @NonNull
    public final ThemeImageView C;

    @NonNull
    public final ReaderThemeSwitchButton D;

    @NonNull
    public final ReaderThemeSwitchButton E;

    @NonNull
    public final ReaderThemeSwitchButton F;

    @NonNull
    public final ThemeImageView G;

    @NonNull
    public final ThemeImageView H;

    @NonNull
    public final ReaderThemeSwitchButton I;

    @NonNull
    public final ReaderThemeSwitchButton J;

    @NonNull
    public final ReaderThemeLinearLayout K;

    @NonNull
    public final ThemeImageView L;

    @NonNull
    public final ReaderThemeTextView M;

    @NonNull
    public final ReaderThemeSwitchButton N;

    /* renamed from: a */
    @NonNull
    private final CoordinatorLayout f11858a;

    /* renamed from: b */
    @NonNull
    public final ReaderThemeSwitchButton f11859b;

    /* renamed from: c */
    @NonNull
    public final ThemeImageView f11860c;

    /* renamed from: d */
    @NonNull
    public final ReaderThemeSwitchButton f11861d;

    /* renamed from: e */
    @NonNull
    public final ThemeImageView f11862e;

    /* renamed from: f */
    @NonNull
    public final ReaderThemeSwitchButton f11863f;

    /* renamed from: g */
    @NonNull
    public final ImageView f11864g;

    /* renamed from: h */
    @NonNull
    public final LinearLayout f11865h;

    /* renamed from: i */
    @NonNull
    public final ImageView f11866i;

    /* renamed from: j */
    @NonNull
    public final LinearLayout f11867j;

    @NonNull
    public final ImageView k;

    @NonNull
    public final LinearLayout l;

    @NonNull
    public final LinearLayout m;

    @NonNull
    public final TextView n;

    @NonNull
    public final LinearLayout o;

    @NonNull
    public final TextView p;

    @NonNull
    public final LinearLayout q;

    @NonNull
    public final TextView r;

    @NonNull
    public final LinearLayout s;

    @NonNull
    public final TextView t;

    @NonNull
    public final LinearLayout u;

    @NonNull
    public final LinearLayout v;

    @NonNull
    public final TextView w;

    @NonNull
    public final CoordinatorLayout x;

    @NonNull
    public final RoundedLayout y;

    @NonNull
    public final ReaderThemeSwitchButton z;

    private d6(@NonNull CoordinatorLayout rootView, @NonNull ReaderThemeSwitchButton alwaysShowVirtualKeyPrefKey, @NonNull ThemeImageView alwaysShowVirtualKeyPrefKeyDivider, @NonNull ReaderThemeSwitchButton autoBuyNextChapterPrefKey, @NonNull ThemeImageView autoBuyNextChapterPrefKeyLine, @NonNull ReaderThemeSwitchButton globalSlideNextPrefKey, @NonNull ImageView ivTextLooseSpace, @NonNull LinearLayout ivTextLooseSpaceBg, @NonNull ImageView ivTextNormalSpace, @NonNull LinearLayout ivTextNormalSpaceBg, @NonNull ImageView ivTextTightSpace, @NonNull LinearLayout ivTextTightSpaceBg, @NonNull LinearLayout lightAlways, @NonNull TextView lightAlwaysText, @NonNull LinearLayout lightFifteenMinutes, @NonNull TextView lightFifteenMinutesText, @NonNull LinearLayout lightFiveMinutes, @NonNull TextView lightFiveMinutesText, @NonNull LinearLayout lightTenMinutes, @NonNull TextView lightTenMinutesText, @NonNull LinearLayout lightTimesView, @NonNull LinearLayout lightTwoMinutes, @NonNull TextView lightTwoMinutesText, @NonNull CoordinatorLayout moreSettingRootView, @NonNull RoundedLayout moreSettingView, @NonNull ReaderThemeSwitchButton prefChapterComment, @NonNull ThemeImageView prefChapterCommentDivider, @NonNull ReaderThemeSwitchButton prefOrientation, @NonNull ThemeImageView prefOrientationDivider, @NonNull ReaderThemeSwitchButton prefShowBonus, @NonNull ReaderThemeSwitchButton prefShowMenu, @NonNull ReaderThemeSwitchButton prefSliderCacheEnable, @NonNull ThemeImageView prefSliderCacheEnableDivider, @NonNull ThemeImageView prefSliderClickScrollDivider, @NonNull ReaderThemeSwitchButton prefSliderClickScrollEnable, @NonNull ReaderThemeSwitchButton prefTraditionalChinese, @NonNull ReaderThemeLinearLayout pushNotification, @NonNull ThemeImageView pushNotificationDivider, @NonNull ReaderThemeTextView pushNotificationStatus, @NonNull ReaderThemeSwitchButton volumeSlidePagePrefKey) {
        this.f11858a = rootView;
        this.f11859b = alwaysShowVirtualKeyPrefKey;
        this.f11860c = alwaysShowVirtualKeyPrefKeyDivider;
        this.f11861d = autoBuyNextChapterPrefKey;
        this.f11862e = autoBuyNextChapterPrefKeyLine;
        this.f11863f = globalSlideNextPrefKey;
        this.f11864g = ivTextLooseSpace;
        this.f11865h = ivTextLooseSpaceBg;
        this.f11866i = ivTextNormalSpace;
        this.f11867j = ivTextNormalSpaceBg;
        this.k = ivTextTightSpace;
        this.l = ivTextTightSpaceBg;
        this.m = lightAlways;
        this.n = lightAlwaysText;
        this.o = lightFifteenMinutes;
        this.p = lightFifteenMinutesText;
        this.q = lightFiveMinutes;
        this.r = lightFiveMinutesText;
        this.s = lightTenMinutes;
        this.t = lightTenMinutesText;
        this.u = lightTimesView;
        this.v = lightTwoMinutes;
        this.w = lightTwoMinutesText;
        this.x = moreSettingRootView;
        this.y = moreSettingView;
        this.z = prefChapterComment;
        this.A = prefChapterCommentDivider;
        this.B = prefOrientation;
        this.C = prefOrientationDivider;
        this.D = prefShowBonus;
        this.E = prefShowMenu;
        this.F = prefSliderCacheEnable;
        this.G = prefSliderCacheEnableDivider;
        this.H = prefSliderClickScrollDivider;
        this.I = prefSliderClickScrollEnable;
        this.J = prefTraditionalChinese;
        this.K = pushNotification;
        this.L = pushNotificationDivider;
        this.M = pushNotificationStatus;
        this.N = volumeSlidePagePrefKey;
    }

    @NonNull
    public static d6 a(@NonNull View rootView) {
        int i2 = R.id.always_show_virtual_key_pref_key;
        ReaderThemeSwitchButton readerThemeSwitchButton = (ReaderThemeSwitchButton) rootView.findViewById(R.id.always_show_virtual_key_pref_key);
        if (readerThemeSwitchButton != null) {
            i2 = R.id.always_show_virtual_key_pref_key_divider;
            ThemeImageView themeImageView = (ThemeImageView) rootView.findViewById(R.id.always_show_virtual_key_pref_key_divider);
            if (themeImageView != null) {
                i2 = R.id.auto_buy_next_chapter_pref_key;
                ReaderThemeSwitchButton readerThemeSwitchButton2 = (ReaderThemeSwitchButton) rootView.findViewById(R.id.auto_buy_next_chapter_pref_key);
                if (readerThemeSwitchButton2 != null) {
                    i2 = R.id.auto_buy_next_chapter_pref_key_line;
                    ThemeImageView themeImageView2 = (ThemeImageView) rootView.findViewById(R.id.auto_buy_next_chapter_pref_key_line);
                    if (themeImageView2 != null) {
                        i2 = R.id.global_slide_next_pref_key;
                        ReaderThemeSwitchButton readerThemeSwitchButton3 = (ReaderThemeSwitchButton) rootView.findViewById(R.id.global_slide_next_pref_key);
                        if (readerThemeSwitchButton3 != null) {
                            i2 = R.id.iv_text_loose_space;
                            ImageView imageView = (ImageView) rootView.findViewById(R.id.iv_text_loose_space);
                            if (imageView != null) {
                                i2 = R.id.iv_text_loose_space_bg;
                                LinearLayout linearLayout = (LinearLayout) rootView.findViewById(R.id.iv_text_loose_space_bg);
                                if (linearLayout != null) {
                                    i2 = R.id.iv_text_normal_space;
                                    ImageView imageView2 = (ImageView) rootView.findViewById(R.id.iv_text_normal_space);
                                    if (imageView2 != null) {
                                        i2 = R.id.iv_text_normal_space_bg;
                                        LinearLayout linearLayout2 = (LinearLayout) rootView.findViewById(R.id.iv_text_normal_space_bg);
                                        if (linearLayout2 != null) {
                                            i2 = R.id.iv_text_tight_space;
                                            ImageView imageView3 = (ImageView) rootView.findViewById(R.id.iv_text_tight_space);
                                            if (imageView3 != null) {
                                                i2 = R.id.iv_text_tight_space_bg;
                                                LinearLayout linearLayout3 = (LinearLayout) rootView.findViewById(R.id.iv_text_tight_space_bg);
                                                if (linearLayout3 != null) {
                                                    i2 = R.id.light_always;
                                                    LinearLayout linearLayout4 = (LinearLayout) rootView.findViewById(R.id.light_always);
                                                    if (linearLayout4 != null) {
                                                        i2 = R.id.light_always_text;
                                                        TextView textView = (TextView) rootView.findViewById(R.id.light_always_text);
                                                        if (textView != null) {
                                                            i2 = R.id.light_fifteen_minutes;
                                                            LinearLayout linearLayout5 = (LinearLayout) rootView.findViewById(R.id.light_fifteen_minutes);
                                                            if (linearLayout5 != null) {
                                                                i2 = R.id.light_fifteen_minutes_text;
                                                                TextView textView2 = (TextView) rootView.findViewById(R.id.light_fifteen_minutes_text);
                                                                if (textView2 != null) {
                                                                    i2 = R.id.light_five_minutes;
                                                                    LinearLayout linearLayout6 = (LinearLayout) rootView.findViewById(R.id.light_five_minutes);
                                                                    if (linearLayout6 != null) {
                                                                        i2 = R.id.light_five_minutes_text;
                                                                        TextView textView3 = (TextView) rootView.findViewById(R.id.light_five_minutes_text);
                                                                        if (textView3 != null) {
                                                                            i2 = R.id.light_ten_minutes;
                                                                            LinearLayout linearLayout7 = (LinearLayout) rootView.findViewById(R.id.light_ten_minutes);
                                                                            if (linearLayout7 != null) {
                                                                                i2 = R.id.light_ten_minutes_text;
                                                                                TextView textView4 = (TextView) rootView.findViewById(R.id.light_ten_minutes_text);
                                                                                if (textView4 != null) {
                                                                                    i2 = R.id.light_times_view;
                                                                                    LinearLayout linearLayout8 = (LinearLayout) rootView.findViewById(R.id.light_times_view);
                                                                                    if (linearLayout8 != null) {
                                                                                        i2 = R.id.light_two_minutes;
                                                                                        LinearLayout linearLayout9 = (LinearLayout) rootView.findViewById(R.id.light_two_minutes);
                                                                                        if (linearLayout9 != null) {
                                                                                            i2 = R.id.light_two_minutes_text;
                                                                                            TextView textView5 = (TextView) rootView.findViewById(R.id.light_two_minutes_text);
                                                                                            if (textView5 != null) {
                                                                                                CoordinatorLayout coordinatorLayout = (CoordinatorLayout) rootView;
                                                                                                i2 = R.id.more_setting_view;
                                                                                                RoundedLayout roundedLayout = (RoundedLayout) rootView.findViewById(R.id.more_setting_view);
                                                                                                if (roundedLayout != null) {
                                                                                                    i2 = R.id.pref_chapter_comment;
                                                                                                    ReaderThemeSwitchButton readerThemeSwitchButton4 = (ReaderThemeSwitchButton) rootView.findViewById(R.id.pref_chapter_comment);
                                                                                                    if (readerThemeSwitchButton4 != null) {
                                                                                                        i2 = R.id.pref_chapter_comment_divider;
                                                                                                        ThemeImageView themeImageView3 = (ThemeImageView) rootView.findViewById(R.id.pref_chapter_comment_divider);
                                                                                                        if (themeImageView3 != null) {
                                                                                                            i2 = R.id.pref_orientation;
                                                                                                            ReaderThemeSwitchButton readerThemeSwitchButton5 = (ReaderThemeSwitchButton) rootView.findViewById(R.id.pref_orientation);
                                                                                                            if (readerThemeSwitchButton5 != null) {
                                                                                                                i2 = R.id.pref_orientation_divider;
                                                                                                                ThemeImageView themeImageView4 = (ThemeImageView) rootView.findViewById(R.id.pref_orientation_divider);
                                                                                                                if (themeImageView4 != null) {
                                                                                                                    i2 = R.id.pref_show_bonus;
                                                                                                                    ReaderThemeSwitchButton readerThemeSwitchButton6 = (ReaderThemeSwitchButton) rootView.findViewById(R.id.pref_show_bonus);
                                                                                                                    if (readerThemeSwitchButton6 != null) {
                                                                                                                        i2 = R.id.pref_show_menu;
                                                                                                                        ReaderThemeSwitchButton readerThemeSwitchButton7 = (ReaderThemeSwitchButton) rootView.findViewById(R.id.pref_show_menu);
                                                                                                                        if (readerThemeSwitchButton7 != null) {
                                                                                                                            i2 = R.id.pref_slider_cache_enable;
                                                                                                                            ReaderThemeSwitchButton readerThemeSwitchButton8 = (ReaderThemeSwitchButton) rootView.findViewById(R.id.pref_slider_cache_enable);
                                                                                                                            if (readerThemeSwitchButton8 != null) {
                                                                                                                                i2 = R.id.pref_slider_cache_enable_divider;
                                                                                                                                ThemeImageView themeImageView5 = (ThemeImageView) rootView.findViewById(R.id.pref_slider_cache_enable_divider);
                                                                                                                                if (themeImageView5 != null) {
                                                                                                                                    i2 = R.id.pref_slider_click_scroll_divider;
                                                                                                                                    ThemeImageView themeImageView6 = (ThemeImageView) rootView.findViewById(R.id.pref_slider_click_scroll_divider);
                                                                                                                                    if (themeImageView6 != null) {
                                                                                                                                        i2 = R.id.pref_slider_click_scroll_enable;
                                                                                                                                        ReaderThemeSwitchButton readerThemeSwitchButton9 = (ReaderThemeSwitchButton) rootView.findViewById(R.id.pref_slider_click_scroll_enable);
                                                                                                                                        if (readerThemeSwitchButton9 != null) {
                                                                                                                                            i2 = R.id.pref_traditional_chinese;
                                                                                                                                            ReaderThemeSwitchButton readerThemeSwitchButton10 = (ReaderThemeSwitchButton) rootView.findViewById(R.id.pref_traditional_chinese);
                                                                                                                                            if (readerThemeSwitchButton10 != null) {
                                                                                                                                                i2 = R.id.push_notification;
                                                                                                                                                ReaderThemeLinearLayout readerThemeLinearLayout = (ReaderThemeLinearLayout) rootView.findViewById(R.id.push_notification);
                                                                                                                                                if (readerThemeLinearLayout != null) {
                                                                                                                                                    i2 = R.id.push_notification_divider;
                                                                                                                                                    ThemeImageView themeImageView7 = (ThemeImageView) rootView.findViewById(R.id.push_notification_divider);
                                                                                                                                                    if (themeImageView7 != null) {
                                                                                                                                                        i2 = R.id.push_notification_status;
                                                                                                                                                        ReaderThemeTextView readerThemeTextView = (ReaderThemeTextView) rootView.findViewById(R.id.push_notification_status);
                                                                                                                                                        if (readerThemeTextView != null) {
                                                                                                                                                            i2 = R.id.volume_slide_page_pref_key;
                                                                                                                                                            ReaderThemeSwitchButton readerThemeSwitchButton11 = (ReaderThemeSwitchButton) rootView.findViewById(R.id.volume_slide_page_pref_key);
                                                                                                                                                            if (readerThemeSwitchButton11 != null) {
                                                                                                                                                                return new d6(coordinatorLayout, readerThemeSwitchButton, themeImageView, readerThemeSwitchButton2, themeImageView2, readerThemeSwitchButton3, imageView, linearLayout, imageView2, linearLayout2, imageView3, linearLayout3, linearLayout4, textView, linearLayout5, textView2, linearLayout6, textView3, linearLayout7, textView4, linearLayout8, linearLayout9, textView5, coordinatorLayout, roundedLayout, readerThemeSwitchButton4, themeImageView3, readerThemeSwitchButton5, themeImageView4, readerThemeSwitchButton6, readerThemeSwitchButton7, readerThemeSwitchButton8, themeImageView5, themeImageView6, readerThemeSwitchButton9, readerThemeSwitchButton10, readerThemeLinearLayout, themeImageView7, readerThemeTextView, readerThemeSwitchButton11);
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
    public static d6 c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static d6 d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.reading_more_setting, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public CoordinatorLayout getRoot() {
        return this.f11858a;
    }
}
