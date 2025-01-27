package com.martian.mibook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.libmars.ui.theme.ThemeLinearLayout;
import com.martian.libmars.widget.BookCoverImageView;
import com.martian.mibook.R;
import com.martian.mibook.mvvm.widget.TextSeekBar;

/* loaded from: classes3.dex */
public final class ActivityAudioBookBinding implements ViewBinding {

    @NonNull
    public final View actionbarTopView;

    @NonNull
    public final TextView audioVideo;

    @NonNull
    public final View audiobookAdPlaceholder;

    @NonNull
    public final ViewStub audiobookAdViewStub;

    @NonNull
    public final LinearLayout audiobookCoverView;

    @NonNull
    public final TextView authorBookMore;

    @NonNull
    public final ProgressBar bookMoreProgressbar;

    @NonNull
    public final FrameLayout bottomSheet;

    @NonNull
    public final ConstraintLayout clAvailableTime;

    @NonNull
    public final ImageView ivClose;

    @NonNull
    public final ImageView ivContentEnlarge;

    @NonNull
    public final BookCoverImageView ivCover;

    @NonNull
    public final ImageView ivPlayerNext;

    @NonNull
    public final ImageView ivPlayerPlay;

    @NonNull
    public final ImageView ivPlayerPrev;

    @NonNull
    public final ImageView ivRefresh;

    @NonNull
    public final LinearLayout llContent;

    @NonNull
    public final LinearLayout llRecommendRoot;

    @NonNull
    public final ProgressBar pbLoading;

    @NonNull
    public final ProgressBar progressBar;

    @NonNull
    public final ThemeLinearLayout rlBuyVip;

    @NonNull
    public final RelativeLayout rlCover;

    @NonNull
    public final RelativeLayout rlRefresh;

    @NonNull
    private final CoordinatorLayout rootView;

    @NonNull
    public final RecyclerView rvGridBooks;

    @NonNull
    public final TextSeekBar seekBar;

    @NonNull
    public final Toolbar toolbar;

    @NonNull
    public final TextView tvAvailableTime;

    @NonNull
    public final TextView tvChapter;

    @NonNull
    public final TextView tvContent;

    @NonNull
    public final TextView tvCoverBookName;

    @NonNull
    public final ThemeLinearLayout tvGoUnlock;

    @NonNull
    public final TextView tvListenBookInterrupt;

    @NonNull
    public final TextView tvPlayerAddBookshelf;

    @NonNull
    public final TextView tvPlayerChapter;

    @NonNull
    public final TextView tvPlayerListenAndRead;

    @NonNull
    public final TextView tvPlayerSoundSettings;

    @NonNull
    public final TextView tvPlayerSpeechSpeed;

    @NonNull
    public final TextView tvPlayerTimer;

    @NonNull
    public final TextView tvRefresh;

    private ActivityAudioBookBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, @NonNull TextView textView, @NonNull View view2, @NonNull ViewStub viewStub, @NonNull LinearLayout linearLayout, @NonNull TextView textView2, @NonNull ProgressBar progressBar, @NonNull FrameLayout frameLayout, @NonNull ConstraintLayout constraintLayout, @NonNull ImageView imageView, @NonNull ImageView imageView2, @NonNull BookCoverImageView bookCoverImageView, @NonNull ImageView imageView3, @NonNull ImageView imageView4, @NonNull ImageView imageView5, @NonNull ImageView imageView6, @NonNull LinearLayout linearLayout2, @NonNull LinearLayout linearLayout3, @NonNull ProgressBar progressBar2, @NonNull ProgressBar progressBar3, @NonNull ThemeLinearLayout themeLinearLayout, @NonNull RelativeLayout relativeLayout, @NonNull RelativeLayout relativeLayout2, @NonNull RecyclerView recyclerView, @NonNull TextSeekBar textSeekBar, @NonNull Toolbar toolbar, @NonNull TextView textView3, @NonNull TextView textView4, @NonNull TextView textView5, @NonNull TextView textView6, @NonNull ThemeLinearLayout themeLinearLayout2, @NonNull TextView textView7, @NonNull TextView textView8, @NonNull TextView textView9, @NonNull TextView textView10, @NonNull TextView textView11, @NonNull TextView textView12, @NonNull TextView textView13, @NonNull TextView textView14) {
        this.rootView = coordinatorLayout;
        this.actionbarTopView = view;
        this.audioVideo = textView;
        this.audiobookAdPlaceholder = view2;
        this.audiobookAdViewStub = viewStub;
        this.audiobookCoverView = linearLayout;
        this.authorBookMore = textView2;
        this.bookMoreProgressbar = progressBar;
        this.bottomSheet = frameLayout;
        this.clAvailableTime = constraintLayout;
        this.ivClose = imageView;
        this.ivContentEnlarge = imageView2;
        this.ivCover = bookCoverImageView;
        this.ivPlayerNext = imageView3;
        this.ivPlayerPlay = imageView4;
        this.ivPlayerPrev = imageView5;
        this.ivRefresh = imageView6;
        this.llContent = linearLayout2;
        this.llRecommendRoot = linearLayout3;
        this.pbLoading = progressBar2;
        this.progressBar = progressBar3;
        this.rlBuyVip = themeLinearLayout;
        this.rlCover = relativeLayout;
        this.rlRefresh = relativeLayout2;
        this.rvGridBooks = recyclerView;
        this.seekBar = textSeekBar;
        this.toolbar = toolbar;
        this.tvAvailableTime = textView3;
        this.tvChapter = textView4;
        this.tvContent = textView5;
        this.tvCoverBookName = textView6;
        this.tvGoUnlock = themeLinearLayout2;
        this.tvListenBookInterrupt = textView7;
        this.tvPlayerAddBookshelf = textView8;
        this.tvPlayerChapter = textView9;
        this.tvPlayerListenAndRead = textView10;
        this.tvPlayerSoundSettings = textView11;
        this.tvPlayerSpeechSpeed = textView12;
        this.tvPlayerTimer = textView13;
        this.tvRefresh = textView14;
    }

    @NonNull
    public static ActivityAudioBookBinding bind(@NonNull View view) {
        View findChildViewById;
        int i10 = R.id.actionbar_top_view;
        View findChildViewById2 = ViewBindings.findChildViewById(view, i10);
        if (findChildViewById2 != null) {
            i10 = R.id.audio_video;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i10);
            if (textView != null && (findChildViewById = ViewBindings.findChildViewById(view, (i10 = R.id.audiobook_ad_placeholder))) != null) {
                i10 = R.id.audiobook_ad_view_stub;
                ViewStub viewStub = (ViewStub) ViewBindings.findChildViewById(view, i10);
                if (viewStub != null) {
                    i10 = R.id.audiobook_cover_view;
                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i10);
                    if (linearLayout != null) {
                        i10 = R.id.author_book_more;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i10);
                        if (textView2 != null) {
                            i10 = R.id.book_more_progressbar;
                            ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, i10);
                            if (progressBar != null) {
                                i10 = R.id.bottom_sheet;
                                FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i10);
                                if (frameLayout != null) {
                                    i10 = R.id.cl_available_time;
                                    ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i10);
                                    if (constraintLayout != null) {
                                        i10 = R.id.iv_close;
                                        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i10);
                                        if (imageView != null) {
                                            i10 = R.id.iv_content_enlarge;
                                            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i10);
                                            if (imageView2 != null) {
                                                i10 = R.id.iv_cover;
                                                BookCoverImageView bookCoverImageView = (BookCoverImageView) ViewBindings.findChildViewById(view, i10);
                                                if (bookCoverImageView != null) {
                                                    i10 = R.id.iv_player_next;
                                                    ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i10);
                                                    if (imageView3 != null) {
                                                        i10 = R.id.iv_player_play;
                                                        ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, i10);
                                                        if (imageView4 != null) {
                                                            i10 = R.id.iv_player_prev;
                                                            ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(view, i10);
                                                            if (imageView5 != null) {
                                                                i10 = R.id.iv_refresh;
                                                                ImageView imageView6 = (ImageView) ViewBindings.findChildViewById(view, i10);
                                                                if (imageView6 != null) {
                                                                    i10 = R.id.ll_content;
                                                                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i10);
                                                                    if (linearLayout2 != null) {
                                                                        i10 = R.id.ll_recommend_root;
                                                                        LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, i10);
                                                                        if (linearLayout3 != null) {
                                                                            i10 = R.id.pb_loading;
                                                                            ProgressBar progressBar2 = (ProgressBar) ViewBindings.findChildViewById(view, i10);
                                                                            if (progressBar2 != null) {
                                                                                i10 = R.id.progressBar;
                                                                                ProgressBar progressBar3 = (ProgressBar) ViewBindings.findChildViewById(view, i10);
                                                                                if (progressBar3 != null) {
                                                                                    i10 = R.id.rl_buy_vip;
                                                                                    ThemeLinearLayout themeLinearLayout = (ThemeLinearLayout) ViewBindings.findChildViewById(view, i10);
                                                                                    if (themeLinearLayout != null) {
                                                                                        i10 = R.id.rl_cover;
                                                                                        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i10);
                                                                                        if (relativeLayout != null) {
                                                                                            i10 = R.id.rl_refresh;
                                                                                            RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view, i10);
                                                                                            if (relativeLayout2 != null) {
                                                                                                i10 = R.id.rv_grid_books;
                                                                                                RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i10);
                                                                                                if (recyclerView != null) {
                                                                                                    i10 = R.id.seekBar;
                                                                                                    TextSeekBar textSeekBar = (TextSeekBar) ViewBindings.findChildViewById(view, i10);
                                                                                                    if (textSeekBar != null) {
                                                                                                        i10 = R.id.toolbar;
                                                                                                        Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(view, i10);
                                                                                                        if (toolbar != null) {
                                                                                                            i10 = R.id.tv_available_time;
                                                                                                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i10);
                                                                                                            if (textView3 != null) {
                                                                                                                i10 = R.id.tv_chapter;
                                                                                                                TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i10);
                                                                                                                if (textView4 != null) {
                                                                                                                    i10 = R.id.tv_content;
                                                                                                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i10);
                                                                                                                    if (textView5 != null) {
                                                                                                                        i10 = R.id.tv_cover_book_name;
                                                                                                                        TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i10);
                                                                                                                        if (textView6 != null) {
                                                                                                                            i10 = R.id.tv_go_unlock;
                                                                                                                            ThemeLinearLayout themeLinearLayout2 = (ThemeLinearLayout) ViewBindings.findChildViewById(view, i10);
                                                                                                                            if (themeLinearLayout2 != null) {
                                                                                                                                i10 = R.id.tv_listen_book_interrupt;
                                                                                                                                TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i10);
                                                                                                                                if (textView7 != null) {
                                                                                                                                    i10 = R.id.tv_player_add_bookshelf;
                                                                                                                                    TextView textView8 = (TextView) ViewBindings.findChildViewById(view, i10);
                                                                                                                                    if (textView8 != null) {
                                                                                                                                        i10 = R.id.tv_player_chapter;
                                                                                                                                        TextView textView9 = (TextView) ViewBindings.findChildViewById(view, i10);
                                                                                                                                        if (textView9 != null) {
                                                                                                                                            i10 = R.id.tv_player_listen_and_read;
                                                                                                                                            TextView textView10 = (TextView) ViewBindings.findChildViewById(view, i10);
                                                                                                                                            if (textView10 != null) {
                                                                                                                                                i10 = R.id.tv_player_sound_settings;
                                                                                                                                                TextView textView11 = (TextView) ViewBindings.findChildViewById(view, i10);
                                                                                                                                                if (textView11 != null) {
                                                                                                                                                    i10 = R.id.tv_player_speech_speed;
                                                                                                                                                    TextView textView12 = (TextView) ViewBindings.findChildViewById(view, i10);
                                                                                                                                                    if (textView12 != null) {
                                                                                                                                                        i10 = R.id.tv_player_timer;
                                                                                                                                                        TextView textView13 = (TextView) ViewBindings.findChildViewById(view, i10);
                                                                                                                                                        if (textView13 != null) {
                                                                                                                                                            i10 = R.id.tv_refresh;
                                                                                                                                                            TextView textView14 = (TextView) ViewBindings.findChildViewById(view, i10);
                                                                                                                                                            if (textView14 != null) {
                                                                                                                                                                return new ActivityAudioBookBinding((CoordinatorLayout) view, findChildViewById2, textView, findChildViewById, viewStub, linearLayout, textView2, progressBar, frameLayout, constraintLayout, imageView, imageView2, bookCoverImageView, imageView3, imageView4, imageView5, imageView6, linearLayout2, linearLayout3, progressBar2, progressBar3, themeLinearLayout, relativeLayout, relativeLayout2, recyclerView, textSeekBar, toolbar, textView3, textView4, textView5, textView6, themeLinearLayout2, textView7, textView8, textView9, textView10, textView11, textView12, textView13, textView14);
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
    public static ActivityAudioBookBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ActivityAudioBookBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.activity_audio_book, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public CoordinatorLayout getRoot() {
        return this.rootView;
    }
}
