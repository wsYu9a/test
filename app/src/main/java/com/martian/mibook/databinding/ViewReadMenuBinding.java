package com.martian.mibook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.libmars.widget.RoundedLayout;
import com.martian.mibook.R;
import com.martian.mibook.ui.IntervalCountdownTextView;
import com.martian.mibook.ui.reader.ReaderThemeImageView;
import com.martian.mibook.ui.reader.ReaderThemeItemTextView;
import com.martian.mibook.ui.reader.ReaderThemeLinearLayout;
import com.martian.mibook.ui.reader.ReaderThemeRelativeLayout;
import com.martian.mibook.ui.reader.ReaderThemeSeekBar;
import com.martian.mibook.ui.reader.ReaderThemeTextView;

/* loaded from: classes3.dex */
public final class ViewReadMenuBinding implements ViewBinding {

    @NonNull
    public final ConstraintLayout bottomMenu;

    @NonNull
    public final ConstraintLayout clCacheMode;

    @NonNull
    public final ReaderThemeImageView ivBack;

    @NonNull
    public final ImageView ivBookFriendRecommend;

    @NonNull
    public final ReaderThemeLinearLayout llCacheMode;

    @NonNull
    public final ImageView llCacheModeVipTag;

    @NonNull
    public final LinearLayout llDir;

    @NonNull
    public final LinearLayout llNightMode;

    @NonNull
    public final LinearLayout llPageSetting;

    @NonNull
    public final ReaderThemeLinearLayout llPreviousSeek;

    @NonNull
    public final ReaderThemeLinearLayout llVipView;

    @NonNull
    public final ReaderThemeLinearLayout moreItemView;

    @NonNull
    public final ViewStub readingAddShelfView;

    @NonNull
    public final ConstraintLayout readingBottomTts;

    @NonNull
    public final ReaderThemeLinearLayout readingCacheStatus;

    @NonNull
    public final ReaderThemeLinearLayout readingChapterLine;

    @NonNull
    public final ReaderThemeTextView readingChapterNumber;

    @NonNull
    public final ReaderThemeLinearLayout readingChapterPosition;

    @NonNull
    public final ReaderThemeImageView readingChapterReturnIcon;

    @NonNull
    public final RoundedLayout readingChapterSeek;

    @NonNull
    public final ReaderThemeTextView readingChapterTitle;

    @NonNull
    public final ReaderThemeImageView readingDir;

    @NonNull
    public final ReaderThemeTextView readingExtraPageTip;

    @NonNull
    public final IntervalCountdownTextView readingHideAdCountdown;

    @NonNull
    public final ReaderThemeLinearLayout readingHideAdMore;

    @NonNull
    public final ReaderThemeTextView readingHideAdMoreText;

    @NonNull
    public final ReaderThemeTextView readingHideAdTitle;

    @NonNull
    public final ReaderThemeLinearLayout readingHideAdView;

    @NonNull
    public final ReaderThemeImageView readingLightSetting;

    @NonNull
    public final ReaderThemeTextView readingLightTitle;

    @NonNull
    public final ReaderThemeImageView readingSetting;

    @NonNull
    public final ReaderThemeRelativeLayout rlBottomView;

    @NonNull
    public final ReaderThemeLinearLayout rlTopView;

    @NonNull
    private final ConstraintLayout rootView;

    @NonNull
    public final ReaderThemeItemTextView sbChapterNext;

    @NonNull
    public final ReaderThemeItemTextView sbChapterPrevious;

    @NonNull
    public final ReaderThemeSeekBar sbChapterSeek;

    @NonNull
    public final View statusView;

    @NonNull
    public final LinearLayout topMenu;

    @NonNull
    public final FrameLayout ttsFloatView;

    @NonNull
    public final ReaderThemeImageView ttsIcon;

    @NonNull
    public final ReaderThemeTextView tvBookname;

    @NonNull
    public final ReaderThemeTextView tvCacheStatus;

    @NonNull
    public final ReaderThemeTextView tvProgress;

    @NonNull
    public final TextView tvReadingTitle;

    @NonNull
    public final ReaderThemeTextView tvVip;

    @NonNull
    public final ReaderThemeImageView tvVipIcon;

    @NonNull
    public final ViewStub viewStubDir;

    @NonNull
    public final ViewStub viewStubSecondLevelLayout;

    @NonNull
    public final ViewStub viewStubSetting;

    @NonNull
    public final ReaderThemeLinearLayout withComments;

    @NonNull
    public final ReaderThemeTextView withCommentsDesc;

    @NonNull
    public final ReaderThemeImageView withCommentsIcon;

    private ViewReadMenuBinding(@NonNull ConstraintLayout constraintLayout, @NonNull ConstraintLayout constraintLayout2, @NonNull ConstraintLayout constraintLayout3, @NonNull ReaderThemeImageView readerThemeImageView, @NonNull ImageView imageView, @NonNull ReaderThemeLinearLayout readerThemeLinearLayout, @NonNull ImageView imageView2, @NonNull LinearLayout linearLayout, @NonNull LinearLayout linearLayout2, @NonNull LinearLayout linearLayout3, @NonNull ReaderThemeLinearLayout readerThemeLinearLayout2, @NonNull ReaderThemeLinearLayout readerThemeLinearLayout3, @NonNull ReaderThemeLinearLayout readerThemeLinearLayout4, @NonNull ViewStub viewStub, @NonNull ConstraintLayout constraintLayout4, @NonNull ReaderThemeLinearLayout readerThemeLinearLayout5, @NonNull ReaderThemeLinearLayout readerThemeLinearLayout6, @NonNull ReaderThemeTextView readerThemeTextView, @NonNull ReaderThemeLinearLayout readerThemeLinearLayout7, @NonNull ReaderThemeImageView readerThemeImageView2, @NonNull RoundedLayout roundedLayout, @NonNull ReaderThemeTextView readerThemeTextView2, @NonNull ReaderThemeImageView readerThemeImageView3, @NonNull ReaderThemeTextView readerThemeTextView3, @NonNull IntervalCountdownTextView intervalCountdownTextView, @NonNull ReaderThemeLinearLayout readerThemeLinearLayout8, @NonNull ReaderThemeTextView readerThemeTextView4, @NonNull ReaderThemeTextView readerThemeTextView5, @NonNull ReaderThemeLinearLayout readerThemeLinearLayout9, @NonNull ReaderThemeImageView readerThemeImageView4, @NonNull ReaderThemeTextView readerThemeTextView6, @NonNull ReaderThemeImageView readerThemeImageView5, @NonNull ReaderThemeRelativeLayout readerThemeRelativeLayout, @NonNull ReaderThemeLinearLayout readerThemeLinearLayout10, @NonNull ReaderThemeItemTextView readerThemeItemTextView, @NonNull ReaderThemeItemTextView readerThemeItemTextView2, @NonNull ReaderThemeSeekBar readerThemeSeekBar, @NonNull View view, @NonNull LinearLayout linearLayout4, @NonNull FrameLayout frameLayout, @NonNull ReaderThemeImageView readerThemeImageView6, @NonNull ReaderThemeTextView readerThemeTextView7, @NonNull ReaderThemeTextView readerThemeTextView8, @NonNull ReaderThemeTextView readerThemeTextView9, @NonNull TextView textView, @NonNull ReaderThemeTextView readerThemeTextView10, @NonNull ReaderThemeImageView readerThemeImageView7, @NonNull ViewStub viewStub2, @NonNull ViewStub viewStub3, @NonNull ViewStub viewStub4, @NonNull ReaderThemeLinearLayout readerThemeLinearLayout11, @NonNull ReaderThemeTextView readerThemeTextView11, @NonNull ReaderThemeImageView readerThemeImageView8) {
        this.rootView = constraintLayout;
        this.bottomMenu = constraintLayout2;
        this.clCacheMode = constraintLayout3;
        this.ivBack = readerThemeImageView;
        this.ivBookFriendRecommend = imageView;
        this.llCacheMode = readerThemeLinearLayout;
        this.llCacheModeVipTag = imageView2;
        this.llDir = linearLayout;
        this.llNightMode = linearLayout2;
        this.llPageSetting = linearLayout3;
        this.llPreviousSeek = readerThemeLinearLayout2;
        this.llVipView = readerThemeLinearLayout3;
        this.moreItemView = readerThemeLinearLayout4;
        this.readingAddShelfView = viewStub;
        this.readingBottomTts = constraintLayout4;
        this.readingCacheStatus = readerThemeLinearLayout5;
        this.readingChapterLine = readerThemeLinearLayout6;
        this.readingChapterNumber = readerThemeTextView;
        this.readingChapterPosition = readerThemeLinearLayout7;
        this.readingChapterReturnIcon = readerThemeImageView2;
        this.readingChapterSeek = roundedLayout;
        this.readingChapterTitle = readerThemeTextView2;
        this.readingDir = readerThemeImageView3;
        this.readingExtraPageTip = readerThemeTextView3;
        this.readingHideAdCountdown = intervalCountdownTextView;
        this.readingHideAdMore = readerThemeLinearLayout8;
        this.readingHideAdMoreText = readerThemeTextView4;
        this.readingHideAdTitle = readerThemeTextView5;
        this.readingHideAdView = readerThemeLinearLayout9;
        this.readingLightSetting = readerThemeImageView4;
        this.readingLightTitle = readerThemeTextView6;
        this.readingSetting = readerThemeImageView5;
        this.rlBottomView = readerThemeRelativeLayout;
        this.rlTopView = readerThemeLinearLayout10;
        this.sbChapterNext = readerThemeItemTextView;
        this.sbChapterPrevious = readerThemeItemTextView2;
        this.sbChapterSeek = readerThemeSeekBar;
        this.statusView = view;
        this.topMenu = linearLayout4;
        this.ttsFloatView = frameLayout;
        this.ttsIcon = readerThemeImageView6;
        this.tvBookname = readerThemeTextView7;
        this.tvCacheStatus = readerThemeTextView8;
        this.tvProgress = readerThemeTextView9;
        this.tvReadingTitle = textView;
        this.tvVip = readerThemeTextView10;
        this.tvVipIcon = readerThemeImageView7;
        this.viewStubDir = viewStub2;
        this.viewStubSecondLevelLayout = viewStub3;
        this.viewStubSetting = viewStub4;
        this.withComments = readerThemeLinearLayout11;
        this.withCommentsDesc = readerThemeTextView11;
        this.withCommentsIcon = readerThemeImageView8;
    }

    @NonNull
    public static ViewReadMenuBinding bind(@NonNull View view) {
        View findChildViewById;
        int i10 = R.id.bottom_menu;
        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i10);
        if (constraintLayout != null) {
            i10 = R.id.cl_cache_mode;
            ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(view, i10);
            if (constraintLayout2 != null) {
                i10 = R.id.iv_back;
                ReaderThemeImageView readerThemeImageView = (ReaderThemeImageView) ViewBindings.findChildViewById(view, i10);
                if (readerThemeImageView != null) {
                    i10 = R.id.iv_book_friend_recommend;
                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i10);
                    if (imageView != null) {
                        i10 = R.id.ll_cache_mode;
                        ReaderThemeLinearLayout readerThemeLinearLayout = (ReaderThemeLinearLayout) ViewBindings.findChildViewById(view, i10);
                        if (readerThemeLinearLayout != null) {
                            i10 = R.id.ll_cache_mode_vip_tag;
                            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i10);
                            if (imageView2 != null) {
                                i10 = R.id.ll_dir;
                                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i10);
                                if (linearLayout != null) {
                                    i10 = R.id.ll_night_mode;
                                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i10);
                                    if (linearLayout2 != null) {
                                        i10 = R.id.ll_page_setting;
                                        LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, i10);
                                        if (linearLayout3 != null) {
                                            i10 = R.id.ll_previous_seek;
                                            ReaderThemeLinearLayout readerThemeLinearLayout2 = (ReaderThemeLinearLayout) ViewBindings.findChildViewById(view, i10);
                                            if (readerThemeLinearLayout2 != null) {
                                                i10 = R.id.ll_vip_view;
                                                ReaderThemeLinearLayout readerThemeLinearLayout3 = (ReaderThemeLinearLayout) ViewBindings.findChildViewById(view, i10);
                                                if (readerThemeLinearLayout3 != null) {
                                                    i10 = R.id.more_item_view;
                                                    ReaderThemeLinearLayout readerThemeLinearLayout4 = (ReaderThemeLinearLayout) ViewBindings.findChildViewById(view, i10);
                                                    if (readerThemeLinearLayout4 != null) {
                                                        i10 = R.id.reading_add_shelf_view;
                                                        ViewStub viewStub = (ViewStub) ViewBindings.findChildViewById(view, i10);
                                                        if (viewStub != null) {
                                                            i10 = R.id.reading_bottom_tts;
                                                            ConstraintLayout constraintLayout3 = (ConstraintLayout) ViewBindings.findChildViewById(view, i10);
                                                            if (constraintLayout3 != null) {
                                                                i10 = R.id.reading_cache_status;
                                                                ReaderThemeLinearLayout readerThemeLinearLayout5 = (ReaderThemeLinearLayout) ViewBindings.findChildViewById(view, i10);
                                                                if (readerThemeLinearLayout5 != null) {
                                                                    i10 = R.id.reading_chapter_line;
                                                                    ReaderThemeLinearLayout readerThemeLinearLayout6 = (ReaderThemeLinearLayout) ViewBindings.findChildViewById(view, i10);
                                                                    if (readerThemeLinearLayout6 != null) {
                                                                        i10 = R.id.reading_chapter_number;
                                                                        ReaderThemeTextView readerThemeTextView = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
                                                                        if (readerThemeTextView != null) {
                                                                            i10 = R.id.reading_chapter_position;
                                                                            ReaderThemeLinearLayout readerThemeLinearLayout7 = (ReaderThemeLinearLayout) ViewBindings.findChildViewById(view, i10);
                                                                            if (readerThemeLinearLayout7 != null) {
                                                                                i10 = R.id.reading_chapter_return_icon;
                                                                                ReaderThemeImageView readerThemeImageView2 = (ReaderThemeImageView) ViewBindings.findChildViewById(view, i10);
                                                                                if (readerThemeImageView2 != null) {
                                                                                    i10 = R.id.reading_chapter_seek;
                                                                                    RoundedLayout roundedLayout = (RoundedLayout) ViewBindings.findChildViewById(view, i10);
                                                                                    if (roundedLayout != null) {
                                                                                        i10 = R.id.reading_chapter_title;
                                                                                        ReaderThemeTextView readerThemeTextView2 = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
                                                                                        if (readerThemeTextView2 != null) {
                                                                                            i10 = R.id.reading_dir;
                                                                                            ReaderThemeImageView readerThemeImageView3 = (ReaderThemeImageView) ViewBindings.findChildViewById(view, i10);
                                                                                            if (readerThemeImageView3 != null) {
                                                                                                i10 = R.id.reading_extra_page_tip;
                                                                                                ReaderThemeTextView readerThemeTextView3 = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
                                                                                                if (readerThemeTextView3 != null) {
                                                                                                    i10 = R.id.reading_hide_ad_countdown;
                                                                                                    IntervalCountdownTextView intervalCountdownTextView = (IntervalCountdownTextView) ViewBindings.findChildViewById(view, i10);
                                                                                                    if (intervalCountdownTextView != null) {
                                                                                                        i10 = R.id.reading_hide_ad_more;
                                                                                                        ReaderThemeLinearLayout readerThemeLinearLayout8 = (ReaderThemeLinearLayout) ViewBindings.findChildViewById(view, i10);
                                                                                                        if (readerThemeLinearLayout8 != null) {
                                                                                                            i10 = R.id.reading_hide_ad_more_text;
                                                                                                            ReaderThemeTextView readerThemeTextView4 = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
                                                                                                            if (readerThemeTextView4 != null) {
                                                                                                                i10 = R.id.reading_hide_ad_title;
                                                                                                                ReaderThemeTextView readerThemeTextView5 = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
                                                                                                                if (readerThemeTextView5 != null) {
                                                                                                                    i10 = R.id.reading_hide_ad_view;
                                                                                                                    ReaderThemeLinearLayout readerThemeLinearLayout9 = (ReaderThemeLinearLayout) ViewBindings.findChildViewById(view, i10);
                                                                                                                    if (readerThemeLinearLayout9 != null) {
                                                                                                                        i10 = R.id.reading_light_setting;
                                                                                                                        ReaderThemeImageView readerThemeImageView4 = (ReaderThemeImageView) ViewBindings.findChildViewById(view, i10);
                                                                                                                        if (readerThemeImageView4 != null) {
                                                                                                                            i10 = R.id.reading_light_title;
                                                                                                                            ReaderThemeTextView readerThemeTextView6 = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
                                                                                                                            if (readerThemeTextView6 != null) {
                                                                                                                                i10 = R.id.reading_setting;
                                                                                                                                ReaderThemeImageView readerThemeImageView5 = (ReaderThemeImageView) ViewBindings.findChildViewById(view, i10);
                                                                                                                                if (readerThemeImageView5 != null) {
                                                                                                                                    i10 = R.id.rl_bottom_view;
                                                                                                                                    ReaderThemeRelativeLayout readerThemeRelativeLayout = (ReaderThemeRelativeLayout) ViewBindings.findChildViewById(view, i10);
                                                                                                                                    if (readerThemeRelativeLayout != null) {
                                                                                                                                        i10 = R.id.rl_top_view;
                                                                                                                                        ReaderThemeLinearLayout readerThemeLinearLayout10 = (ReaderThemeLinearLayout) ViewBindings.findChildViewById(view, i10);
                                                                                                                                        if (readerThemeLinearLayout10 != null) {
                                                                                                                                            i10 = R.id.sb_chapter_next;
                                                                                                                                            ReaderThemeItemTextView readerThemeItemTextView = (ReaderThemeItemTextView) ViewBindings.findChildViewById(view, i10);
                                                                                                                                            if (readerThemeItemTextView != null) {
                                                                                                                                                i10 = R.id.sb_chapter_previous;
                                                                                                                                                ReaderThemeItemTextView readerThemeItemTextView2 = (ReaderThemeItemTextView) ViewBindings.findChildViewById(view, i10);
                                                                                                                                                if (readerThemeItemTextView2 != null) {
                                                                                                                                                    i10 = R.id.sb_chapter_seek;
                                                                                                                                                    ReaderThemeSeekBar readerThemeSeekBar = (ReaderThemeSeekBar) ViewBindings.findChildViewById(view, i10);
                                                                                                                                                    if (readerThemeSeekBar != null && (findChildViewById = ViewBindings.findChildViewById(view, (i10 = R.id.statusView))) != null) {
                                                                                                                                                        i10 = R.id.top_menu;
                                                                                                                                                        LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(view, i10);
                                                                                                                                                        if (linearLayout4 != null) {
                                                                                                                                                            i10 = R.id.tts_float_view;
                                                                                                                                                            FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i10);
                                                                                                                                                            if (frameLayout != null) {
                                                                                                                                                                i10 = R.id.tts_icon;
                                                                                                                                                                ReaderThemeImageView readerThemeImageView6 = (ReaderThemeImageView) ViewBindings.findChildViewById(view, i10);
                                                                                                                                                                if (readerThemeImageView6 != null) {
                                                                                                                                                                    i10 = R.id.tv_bookname;
                                                                                                                                                                    ReaderThemeTextView readerThemeTextView7 = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
                                                                                                                                                                    if (readerThemeTextView7 != null) {
                                                                                                                                                                        i10 = R.id.tv_cache_status;
                                                                                                                                                                        ReaderThemeTextView readerThemeTextView8 = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
                                                                                                                                                                        if (readerThemeTextView8 != null) {
                                                                                                                                                                            i10 = R.id.tv_progress;
                                                                                                                                                                            ReaderThemeTextView readerThemeTextView9 = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
                                                                                                                                                                            if (readerThemeTextView9 != null) {
                                                                                                                                                                                i10 = R.id.tv_reading_title;
                                                                                                                                                                                TextView textView = (TextView) ViewBindings.findChildViewById(view, i10);
                                                                                                                                                                                if (textView != null) {
                                                                                                                                                                                    i10 = R.id.tv_vip;
                                                                                                                                                                                    ReaderThemeTextView readerThemeTextView10 = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
                                                                                                                                                                                    if (readerThemeTextView10 != null) {
                                                                                                                                                                                        i10 = R.id.tv_vip_icon;
                                                                                                                                                                                        ReaderThemeImageView readerThemeImageView7 = (ReaderThemeImageView) ViewBindings.findChildViewById(view, i10);
                                                                                                                                                                                        if (readerThemeImageView7 != null) {
                                                                                                                                                                                            i10 = R.id.view_stub_dir;
                                                                                                                                                                                            ViewStub viewStub2 = (ViewStub) ViewBindings.findChildViewById(view, i10);
                                                                                                                                                                                            if (viewStub2 != null) {
                                                                                                                                                                                                i10 = R.id.view_stub_second_level_layout;
                                                                                                                                                                                                ViewStub viewStub3 = (ViewStub) ViewBindings.findChildViewById(view, i10);
                                                                                                                                                                                                if (viewStub3 != null) {
                                                                                                                                                                                                    i10 = R.id.view_stub_setting;
                                                                                                                                                                                                    ViewStub viewStub4 = (ViewStub) ViewBindings.findChildViewById(view, i10);
                                                                                                                                                                                                    if (viewStub4 != null) {
                                                                                                                                                                                                        i10 = R.id.with_comments;
                                                                                                                                                                                                        ReaderThemeLinearLayout readerThemeLinearLayout11 = (ReaderThemeLinearLayout) ViewBindings.findChildViewById(view, i10);
                                                                                                                                                                                                        if (readerThemeLinearLayout11 != null) {
                                                                                                                                                                                                            i10 = R.id.with_comments_desc;
                                                                                                                                                                                                            ReaderThemeTextView readerThemeTextView11 = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
                                                                                                                                                                                                            if (readerThemeTextView11 != null) {
                                                                                                                                                                                                                i10 = R.id.with_comments_icon;
                                                                                                                                                                                                                ReaderThemeImageView readerThemeImageView8 = (ReaderThemeImageView) ViewBindings.findChildViewById(view, i10);
                                                                                                                                                                                                                if (readerThemeImageView8 != null) {
                                                                                                                                                                                                                    return new ViewReadMenuBinding((ConstraintLayout) view, constraintLayout, constraintLayout2, readerThemeImageView, imageView, readerThemeLinearLayout, imageView2, linearLayout, linearLayout2, linearLayout3, readerThemeLinearLayout2, readerThemeLinearLayout3, readerThemeLinearLayout4, viewStub, constraintLayout3, readerThemeLinearLayout5, readerThemeLinearLayout6, readerThemeTextView, readerThemeLinearLayout7, readerThemeImageView2, roundedLayout, readerThemeTextView2, readerThemeImageView3, readerThemeTextView3, intervalCountdownTextView, readerThemeLinearLayout8, readerThemeTextView4, readerThemeTextView5, readerThemeLinearLayout9, readerThemeImageView4, readerThemeTextView6, readerThemeImageView5, readerThemeRelativeLayout, readerThemeLinearLayout10, readerThemeItemTextView, readerThemeItemTextView2, readerThemeSeekBar, findChildViewById, linearLayout4, frameLayout, readerThemeImageView6, readerThemeTextView7, readerThemeTextView8, readerThemeTextView9, textView, readerThemeTextView10, readerThemeImageView7, viewStub2, viewStub3, viewStub4, readerThemeLinearLayout11, readerThemeTextView11, readerThemeImageView8);
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
    public static ViewReadMenuBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ViewReadMenuBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.view_read_menu, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public ConstraintLayout getRoot() {
        return this.rootView;
    }
}
