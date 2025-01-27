package com.martian.mibook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.libmars.ui.theme.ThemeImageView;
import com.martian.libmars.utils.tablayout.MagicIndicator;
import com.martian.libmars.widget.RoundedLayout;
import com.martian.mibook.R;
import com.martian.mibook.ui.reader.ReaderThemeImageView;
import com.martian.mibook.ui.reader.ReaderThemeSwitchButton;
import com.martian.mibook.ui.reader.ReaderThemeTextView;

/* loaded from: classes3.dex */
public final class ReaderMoreSettingLayoutBinding implements ViewBinding {

    @NonNull
    public final ReaderThemeSwitchButton alwaysShowVirtualKeyPrefKey;

    @NonNull
    public final ThemeImageView alwaysShowVirtualKeyPrefKeyDivider;

    @NonNull
    public final ReaderThemeSwitchButton autoBuyNextChapterPrefKey;

    @NonNull
    public final ThemeImageView autoBuyNextChapterPrefKeyLine;

    @NonNull
    public final ConstraintLayout clAlwaysShowVirtualKey;

    @NonNull
    public final ConstraintLayout clAutoAddBookshelf;

    @NonNull
    public final ConstraintLayout clAutoBuyNextChapter;

    @NonNull
    public final ConstraintLayout clChapterComment;

    @NonNull
    public final ConstraintLayout clOrientation;

    @NonNull
    public final ConstraintLayout clPullDownAddBookmark;

    @NonNull
    public final ConstraintLayout clSliderCacheEnable;

    @NonNull
    public final ConstraintLayout clTraditionalChinese;

    @NonNull
    public final ConstraintLayout clVolumeSlidePage;

    @NonNull
    public final ReaderThemeImageView ivClose;

    @NonNull
    public final MagicIndicator magicIndicatorLightTimes;

    @NonNull
    public final ReaderThemeSwitchButton prefAutoAddBookshelf;

    @NonNull
    public final ThemeImageView prefAutoAddBookshelfDivider;

    @NonNull
    public final ReaderThemeSwitchButton prefChapterComment;

    @NonNull
    public final ThemeImageView prefChapterCommentDivider;

    @NonNull
    public final ReaderThemeSwitchButton prefOrientation;

    @NonNull
    public final ThemeImageView prefOrientationDivider;

    @NonNull
    public final ReaderThemeSwitchButton prefPullDownAddBookmarkEnable;

    @NonNull
    public final ReaderThemeSwitchButton prefSliderCacheEnable;

    @NonNull
    public final ThemeImageView prefSliderCacheEnableDivider;

    @NonNull
    public final ReaderThemeSwitchButton prefTraditionalChinese;

    @NonNull
    public final ThemeImageView pullDownAddBookmarkDivider;

    @NonNull
    public final LinearLayout pushNotification;

    @NonNull
    public final ThemeImageView pushNotificationDivider;

    @NonNull
    public final ReaderThemeTextView pushNotificationStatus;

    @NonNull
    private final RoundedLayout rootView;

    @NonNull
    public final ReaderThemeTextView tvAlwaysShowVirtualKey;

    @NonNull
    public final ReaderThemeTextView tvAutoAddBookshelf;

    @NonNull
    public final ReaderThemeTextView tvAutoAddBookshelfTips;

    @NonNull
    public final ReaderThemeTextView tvAutoBuyNextChapter;

    @NonNull
    public final ReaderThemeTextView tvAutoBuyNextChapterTips;

    @NonNull
    public final ReaderThemeTextView tvChapterComment;

    @NonNull
    public final ReaderThemeTextView tvLightTimes;

    @NonNull
    public final ReaderThemeTextView tvOrientation;

    @NonNull
    public final ReaderThemeTextView tvPullDownAddBookmark;

    @NonNull
    public final ReaderThemeTextView tvPullDownAddBookmarkTips;

    @NonNull
    public final ReaderThemeTextView tvSliderCacheEnable;

    @NonNull
    public final ReaderThemeTextView tvTitle;

    @NonNull
    public final ReaderThemeTextView tvTraditionalChinese;

    @NonNull
    public final ReaderThemeTextView tvVolumeSlide;

    @NonNull
    public final ReaderThemeSwitchButton volumeSlidePagePrefKey;

    private ReaderMoreSettingLayoutBinding(@NonNull RoundedLayout roundedLayout, @NonNull ReaderThemeSwitchButton readerThemeSwitchButton, @NonNull ThemeImageView themeImageView, @NonNull ReaderThemeSwitchButton readerThemeSwitchButton2, @NonNull ThemeImageView themeImageView2, @NonNull ConstraintLayout constraintLayout, @NonNull ConstraintLayout constraintLayout2, @NonNull ConstraintLayout constraintLayout3, @NonNull ConstraintLayout constraintLayout4, @NonNull ConstraintLayout constraintLayout5, @NonNull ConstraintLayout constraintLayout6, @NonNull ConstraintLayout constraintLayout7, @NonNull ConstraintLayout constraintLayout8, @NonNull ConstraintLayout constraintLayout9, @NonNull ReaderThemeImageView readerThemeImageView, @NonNull MagicIndicator magicIndicator, @NonNull ReaderThemeSwitchButton readerThemeSwitchButton3, @NonNull ThemeImageView themeImageView3, @NonNull ReaderThemeSwitchButton readerThemeSwitchButton4, @NonNull ThemeImageView themeImageView4, @NonNull ReaderThemeSwitchButton readerThemeSwitchButton5, @NonNull ThemeImageView themeImageView5, @NonNull ReaderThemeSwitchButton readerThemeSwitchButton6, @NonNull ReaderThemeSwitchButton readerThemeSwitchButton7, @NonNull ThemeImageView themeImageView6, @NonNull ReaderThemeSwitchButton readerThemeSwitchButton8, @NonNull ThemeImageView themeImageView7, @NonNull LinearLayout linearLayout, @NonNull ThemeImageView themeImageView8, @NonNull ReaderThemeTextView readerThemeTextView, @NonNull ReaderThemeTextView readerThemeTextView2, @NonNull ReaderThemeTextView readerThemeTextView3, @NonNull ReaderThemeTextView readerThemeTextView4, @NonNull ReaderThemeTextView readerThemeTextView5, @NonNull ReaderThemeTextView readerThemeTextView6, @NonNull ReaderThemeTextView readerThemeTextView7, @NonNull ReaderThemeTextView readerThemeTextView8, @NonNull ReaderThemeTextView readerThemeTextView9, @NonNull ReaderThemeTextView readerThemeTextView10, @NonNull ReaderThemeTextView readerThemeTextView11, @NonNull ReaderThemeTextView readerThemeTextView12, @NonNull ReaderThemeTextView readerThemeTextView13, @NonNull ReaderThemeTextView readerThemeTextView14, @NonNull ReaderThemeTextView readerThemeTextView15, @NonNull ReaderThemeSwitchButton readerThemeSwitchButton9) {
        this.rootView = roundedLayout;
        this.alwaysShowVirtualKeyPrefKey = readerThemeSwitchButton;
        this.alwaysShowVirtualKeyPrefKeyDivider = themeImageView;
        this.autoBuyNextChapterPrefKey = readerThemeSwitchButton2;
        this.autoBuyNextChapterPrefKeyLine = themeImageView2;
        this.clAlwaysShowVirtualKey = constraintLayout;
        this.clAutoAddBookshelf = constraintLayout2;
        this.clAutoBuyNextChapter = constraintLayout3;
        this.clChapterComment = constraintLayout4;
        this.clOrientation = constraintLayout5;
        this.clPullDownAddBookmark = constraintLayout6;
        this.clSliderCacheEnable = constraintLayout7;
        this.clTraditionalChinese = constraintLayout8;
        this.clVolumeSlidePage = constraintLayout9;
        this.ivClose = readerThemeImageView;
        this.magicIndicatorLightTimes = magicIndicator;
        this.prefAutoAddBookshelf = readerThemeSwitchButton3;
        this.prefAutoAddBookshelfDivider = themeImageView3;
        this.prefChapterComment = readerThemeSwitchButton4;
        this.prefChapterCommentDivider = themeImageView4;
        this.prefOrientation = readerThemeSwitchButton5;
        this.prefOrientationDivider = themeImageView5;
        this.prefPullDownAddBookmarkEnable = readerThemeSwitchButton6;
        this.prefSliderCacheEnable = readerThemeSwitchButton7;
        this.prefSliderCacheEnableDivider = themeImageView6;
        this.prefTraditionalChinese = readerThemeSwitchButton8;
        this.pullDownAddBookmarkDivider = themeImageView7;
        this.pushNotification = linearLayout;
        this.pushNotificationDivider = themeImageView8;
        this.pushNotificationStatus = readerThemeTextView;
        this.tvAlwaysShowVirtualKey = readerThemeTextView2;
        this.tvAutoAddBookshelf = readerThemeTextView3;
        this.tvAutoAddBookshelfTips = readerThemeTextView4;
        this.tvAutoBuyNextChapter = readerThemeTextView5;
        this.tvAutoBuyNextChapterTips = readerThemeTextView6;
        this.tvChapterComment = readerThemeTextView7;
        this.tvLightTimes = readerThemeTextView8;
        this.tvOrientation = readerThemeTextView9;
        this.tvPullDownAddBookmark = readerThemeTextView10;
        this.tvPullDownAddBookmarkTips = readerThemeTextView11;
        this.tvSliderCacheEnable = readerThemeTextView12;
        this.tvTitle = readerThemeTextView13;
        this.tvTraditionalChinese = readerThemeTextView14;
        this.tvVolumeSlide = readerThemeTextView15;
        this.volumeSlidePagePrefKey = readerThemeSwitchButton9;
    }

    @NonNull
    public static ReaderMoreSettingLayoutBinding bind(@NonNull View view) {
        int i10 = R.id.always_show_virtual_key_pref_key;
        ReaderThemeSwitchButton readerThemeSwitchButton = (ReaderThemeSwitchButton) ViewBindings.findChildViewById(view, i10);
        if (readerThemeSwitchButton != null) {
            i10 = R.id.always_show_virtual_key_pref_key_divider;
            ThemeImageView themeImageView = (ThemeImageView) ViewBindings.findChildViewById(view, i10);
            if (themeImageView != null) {
                i10 = R.id.auto_buy_next_chapter_pref_key;
                ReaderThemeSwitchButton readerThemeSwitchButton2 = (ReaderThemeSwitchButton) ViewBindings.findChildViewById(view, i10);
                if (readerThemeSwitchButton2 != null) {
                    i10 = R.id.auto_buy_next_chapter_pref_key_line;
                    ThemeImageView themeImageView2 = (ThemeImageView) ViewBindings.findChildViewById(view, i10);
                    if (themeImageView2 != null) {
                        i10 = R.id.cl_always_show_virtual_key;
                        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i10);
                        if (constraintLayout != null) {
                            i10 = R.id.cl_auto_add_bookshelf;
                            ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(view, i10);
                            if (constraintLayout2 != null) {
                                i10 = R.id.cl_auto_buy_next_chapter;
                                ConstraintLayout constraintLayout3 = (ConstraintLayout) ViewBindings.findChildViewById(view, i10);
                                if (constraintLayout3 != null) {
                                    i10 = R.id.cl_chapter_comment;
                                    ConstraintLayout constraintLayout4 = (ConstraintLayout) ViewBindings.findChildViewById(view, i10);
                                    if (constraintLayout4 != null) {
                                        i10 = R.id.cl_orientation;
                                        ConstraintLayout constraintLayout5 = (ConstraintLayout) ViewBindings.findChildViewById(view, i10);
                                        if (constraintLayout5 != null) {
                                            i10 = R.id.cl_pull_down_add_bookmark;
                                            ConstraintLayout constraintLayout6 = (ConstraintLayout) ViewBindings.findChildViewById(view, i10);
                                            if (constraintLayout6 != null) {
                                                i10 = R.id.cl_slider_cache_enable;
                                                ConstraintLayout constraintLayout7 = (ConstraintLayout) ViewBindings.findChildViewById(view, i10);
                                                if (constraintLayout7 != null) {
                                                    i10 = R.id.cl_traditional_chinese;
                                                    ConstraintLayout constraintLayout8 = (ConstraintLayout) ViewBindings.findChildViewById(view, i10);
                                                    if (constraintLayout8 != null) {
                                                        i10 = R.id.cl_volume_slide_page;
                                                        ConstraintLayout constraintLayout9 = (ConstraintLayout) ViewBindings.findChildViewById(view, i10);
                                                        if (constraintLayout9 != null) {
                                                            i10 = R.id.iv_close;
                                                            ReaderThemeImageView readerThemeImageView = (ReaderThemeImageView) ViewBindings.findChildViewById(view, i10);
                                                            if (readerThemeImageView != null) {
                                                                i10 = R.id.magic_indicator_light_times;
                                                                MagicIndicator magicIndicator = (MagicIndicator) ViewBindings.findChildViewById(view, i10);
                                                                if (magicIndicator != null) {
                                                                    i10 = R.id.pref_auto_add_bookshelf;
                                                                    ReaderThemeSwitchButton readerThemeSwitchButton3 = (ReaderThemeSwitchButton) ViewBindings.findChildViewById(view, i10);
                                                                    if (readerThemeSwitchButton3 != null) {
                                                                        i10 = R.id.pref_auto_add_bookshelf_divider;
                                                                        ThemeImageView themeImageView3 = (ThemeImageView) ViewBindings.findChildViewById(view, i10);
                                                                        if (themeImageView3 != null) {
                                                                            i10 = R.id.pref_chapter_comment;
                                                                            ReaderThemeSwitchButton readerThemeSwitchButton4 = (ReaderThemeSwitchButton) ViewBindings.findChildViewById(view, i10);
                                                                            if (readerThemeSwitchButton4 != null) {
                                                                                i10 = R.id.pref_chapter_comment_divider;
                                                                                ThemeImageView themeImageView4 = (ThemeImageView) ViewBindings.findChildViewById(view, i10);
                                                                                if (themeImageView4 != null) {
                                                                                    i10 = R.id.pref_orientation;
                                                                                    ReaderThemeSwitchButton readerThemeSwitchButton5 = (ReaderThemeSwitchButton) ViewBindings.findChildViewById(view, i10);
                                                                                    if (readerThemeSwitchButton5 != null) {
                                                                                        i10 = R.id.pref_orientation_divider;
                                                                                        ThemeImageView themeImageView5 = (ThemeImageView) ViewBindings.findChildViewById(view, i10);
                                                                                        if (themeImageView5 != null) {
                                                                                            i10 = R.id.pref_pull_down_add_bookmark_enable;
                                                                                            ReaderThemeSwitchButton readerThemeSwitchButton6 = (ReaderThemeSwitchButton) ViewBindings.findChildViewById(view, i10);
                                                                                            if (readerThemeSwitchButton6 != null) {
                                                                                                i10 = R.id.pref_slider_cache_enable;
                                                                                                ReaderThemeSwitchButton readerThemeSwitchButton7 = (ReaderThemeSwitchButton) ViewBindings.findChildViewById(view, i10);
                                                                                                if (readerThemeSwitchButton7 != null) {
                                                                                                    i10 = R.id.pref_slider_cache_enable_divider;
                                                                                                    ThemeImageView themeImageView6 = (ThemeImageView) ViewBindings.findChildViewById(view, i10);
                                                                                                    if (themeImageView6 != null) {
                                                                                                        i10 = R.id.pref_traditional_chinese;
                                                                                                        ReaderThemeSwitchButton readerThemeSwitchButton8 = (ReaderThemeSwitchButton) ViewBindings.findChildViewById(view, i10);
                                                                                                        if (readerThemeSwitchButton8 != null) {
                                                                                                            i10 = R.id.pull_down_add_bookmark_divider;
                                                                                                            ThemeImageView themeImageView7 = (ThemeImageView) ViewBindings.findChildViewById(view, i10);
                                                                                                            if (themeImageView7 != null) {
                                                                                                                i10 = R.id.push_notification;
                                                                                                                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i10);
                                                                                                                if (linearLayout != null) {
                                                                                                                    i10 = R.id.push_notification_divider;
                                                                                                                    ThemeImageView themeImageView8 = (ThemeImageView) ViewBindings.findChildViewById(view, i10);
                                                                                                                    if (themeImageView8 != null) {
                                                                                                                        i10 = R.id.push_notification_status;
                                                                                                                        ReaderThemeTextView readerThemeTextView = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
                                                                                                                        if (readerThemeTextView != null) {
                                                                                                                            i10 = R.id.tv_always_show_virtual_key;
                                                                                                                            ReaderThemeTextView readerThemeTextView2 = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
                                                                                                                            if (readerThemeTextView2 != null) {
                                                                                                                                i10 = R.id.tv_auto_add_bookshelf;
                                                                                                                                ReaderThemeTextView readerThemeTextView3 = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
                                                                                                                                if (readerThemeTextView3 != null) {
                                                                                                                                    i10 = R.id.tv_auto_add_bookshelf_tips;
                                                                                                                                    ReaderThemeTextView readerThemeTextView4 = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
                                                                                                                                    if (readerThemeTextView4 != null) {
                                                                                                                                        i10 = R.id.tv_auto_buy_next_chapter;
                                                                                                                                        ReaderThemeTextView readerThemeTextView5 = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
                                                                                                                                        if (readerThemeTextView5 != null) {
                                                                                                                                            i10 = R.id.tv_auto_buy_next_chapter_tips;
                                                                                                                                            ReaderThemeTextView readerThemeTextView6 = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
                                                                                                                                            if (readerThemeTextView6 != null) {
                                                                                                                                                i10 = R.id.tv_chapter_comment;
                                                                                                                                                ReaderThemeTextView readerThemeTextView7 = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
                                                                                                                                                if (readerThemeTextView7 != null) {
                                                                                                                                                    i10 = R.id.tv_light_times;
                                                                                                                                                    ReaderThemeTextView readerThemeTextView8 = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
                                                                                                                                                    if (readerThemeTextView8 != null) {
                                                                                                                                                        i10 = R.id.tv_orientation;
                                                                                                                                                        ReaderThemeTextView readerThemeTextView9 = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
                                                                                                                                                        if (readerThemeTextView9 != null) {
                                                                                                                                                            i10 = R.id.tv_pull_down_add_bookmark;
                                                                                                                                                            ReaderThemeTextView readerThemeTextView10 = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
                                                                                                                                                            if (readerThemeTextView10 != null) {
                                                                                                                                                                i10 = R.id.tv_pull_down_add_bookmark_tips;
                                                                                                                                                                ReaderThemeTextView readerThemeTextView11 = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
                                                                                                                                                                if (readerThemeTextView11 != null) {
                                                                                                                                                                    i10 = R.id.tv_slider_cache_enable;
                                                                                                                                                                    ReaderThemeTextView readerThemeTextView12 = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
                                                                                                                                                                    if (readerThemeTextView12 != null) {
                                                                                                                                                                        i10 = R.id.tv_title;
                                                                                                                                                                        ReaderThemeTextView readerThemeTextView13 = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
                                                                                                                                                                        if (readerThemeTextView13 != null) {
                                                                                                                                                                            i10 = R.id.tv_traditional_chinese;
                                                                                                                                                                            ReaderThemeTextView readerThemeTextView14 = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
                                                                                                                                                                            if (readerThemeTextView14 != null) {
                                                                                                                                                                                i10 = R.id.tv_volume_slide;
                                                                                                                                                                                ReaderThemeTextView readerThemeTextView15 = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
                                                                                                                                                                                if (readerThemeTextView15 != null) {
                                                                                                                                                                                    i10 = R.id.volume_slide_page_pref_key;
                                                                                                                                                                                    ReaderThemeSwitchButton readerThemeSwitchButton9 = (ReaderThemeSwitchButton) ViewBindings.findChildViewById(view, i10);
                                                                                                                                                                                    if (readerThemeSwitchButton9 != null) {
                                                                                                                                                                                        return new ReaderMoreSettingLayoutBinding((RoundedLayout) view, readerThemeSwitchButton, themeImageView, readerThemeSwitchButton2, themeImageView2, constraintLayout, constraintLayout2, constraintLayout3, constraintLayout4, constraintLayout5, constraintLayout6, constraintLayout7, constraintLayout8, constraintLayout9, readerThemeImageView, magicIndicator, readerThemeSwitchButton3, themeImageView3, readerThemeSwitchButton4, themeImageView4, readerThemeSwitchButton5, themeImageView5, readerThemeSwitchButton6, readerThemeSwitchButton7, themeImageView6, readerThemeSwitchButton8, themeImageView7, linearLayout, themeImageView8, readerThemeTextView, readerThemeTextView2, readerThemeTextView3, readerThemeTextView4, readerThemeTextView5, readerThemeTextView6, readerThemeTextView7, readerThemeTextView8, readerThemeTextView9, readerThemeTextView10, readerThemeTextView11, readerThemeTextView12, readerThemeTextView13, readerThemeTextView14, readerThemeTextView15, readerThemeSwitchButton9);
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
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static ReaderMoreSettingLayoutBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ReaderMoreSettingLayoutBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.reader_more_setting_layout, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public RoundedLayout getRoot() {
        return this.rootView;
    }
}
