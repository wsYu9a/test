package com.martian.mibook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.mibook.R;
import com.martian.mibook.ui.reader.ReaderThemeImageView;
import com.martian.mibook.ui.reader.ReaderThemeTextView;

/* loaded from: classes3.dex */
public final class ReadingLayoutBinding implements ViewBinding {

    @NonNull
    public final ViewStub bookActiveViewStub;

    @NonNull
    public final ViewStub bookCoverViewStub;

    @NonNull
    public final ViewStub chapterCommentViewStub;

    @NonNull
    public final ViewStub chapterPurchaseViewStub;

    @NonNull
    public final ReaderThemeImageView ivMark;

    @NonNull
    public final ReadingContentLayoutBinding llReadingContent;

    @NonNull
    public final ViewStub loadFailViewStub;

    @NonNull
    public final ReadingBottomStatusBinding lyReadingBottomStatus;

    @NonNull
    public final ReaderThemeTextView pbContentLoading;

    @NonNull
    public final ViewStub readingAdsViewStub;

    @NonNull
    public final ViewStub readingLastPageViewStub;

    @NonNull
    public final ViewStub readingLinkAdViewStub;

    @NonNull
    private final LinearLayout rootView;

    private ReadingLayoutBinding(@NonNull LinearLayout linearLayout, @NonNull ViewStub viewStub, @NonNull ViewStub viewStub2, @NonNull ViewStub viewStub3, @NonNull ViewStub viewStub4, @NonNull ReaderThemeImageView readerThemeImageView, @NonNull ReadingContentLayoutBinding readingContentLayoutBinding, @NonNull ViewStub viewStub5, @NonNull ReadingBottomStatusBinding readingBottomStatusBinding, @NonNull ReaderThemeTextView readerThemeTextView, @NonNull ViewStub viewStub6, @NonNull ViewStub viewStub7, @NonNull ViewStub viewStub8) {
        this.rootView = linearLayout;
        this.bookActiveViewStub = viewStub;
        this.bookCoverViewStub = viewStub2;
        this.chapterCommentViewStub = viewStub3;
        this.chapterPurchaseViewStub = viewStub4;
        this.ivMark = readerThemeImageView;
        this.llReadingContent = readingContentLayoutBinding;
        this.loadFailViewStub = viewStub5;
        this.lyReadingBottomStatus = readingBottomStatusBinding;
        this.pbContentLoading = readerThemeTextView;
        this.readingAdsViewStub = viewStub6;
        this.readingLastPageViewStub = viewStub7;
        this.readingLinkAdViewStub = viewStub8;
    }

    @NonNull
    public static ReadingLayoutBinding bind(@NonNull View view) {
        View findChildViewById;
        View findChildViewById2;
        int i10 = R.id.book_active_view_stub;
        ViewStub viewStub = (ViewStub) ViewBindings.findChildViewById(view, i10);
        if (viewStub != null) {
            i10 = R.id.book_cover_view_stub;
            ViewStub viewStub2 = (ViewStub) ViewBindings.findChildViewById(view, i10);
            if (viewStub2 != null) {
                i10 = R.id.chapter_comment_view_stub;
                ViewStub viewStub3 = (ViewStub) ViewBindings.findChildViewById(view, i10);
                if (viewStub3 != null) {
                    i10 = R.id.chapter_purchase_view_stub;
                    ViewStub viewStub4 = (ViewStub) ViewBindings.findChildViewById(view, i10);
                    if (viewStub4 != null) {
                        i10 = R.id.iv_mark;
                        ReaderThemeImageView readerThemeImageView = (ReaderThemeImageView) ViewBindings.findChildViewById(view, i10);
                        if (readerThemeImageView != null && (findChildViewById = ViewBindings.findChildViewById(view, (i10 = R.id.ll_reading_content))) != null) {
                            ReadingContentLayoutBinding bind = ReadingContentLayoutBinding.bind(findChildViewById);
                            i10 = R.id.load_fail_view_stub;
                            ViewStub viewStub5 = (ViewStub) ViewBindings.findChildViewById(view, i10);
                            if (viewStub5 != null && (findChildViewById2 = ViewBindings.findChildViewById(view, (i10 = R.id.ly_reading_bottom_status))) != null) {
                                ReadingBottomStatusBinding bind2 = ReadingBottomStatusBinding.bind(findChildViewById2);
                                i10 = R.id.pb_content_loading;
                                ReaderThemeTextView readerThemeTextView = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
                                if (readerThemeTextView != null) {
                                    i10 = R.id.reading_ads_view_stub;
                                    ViewStub viewStub6 = (ViewStub) ViewBindings.findChildViewById(view, i10);
                                    if (viewStub6 != null) {
                                        i10 = R.id.reading_last_page_view_stub;
                                        ViewStub viewStub7 = (ViewStub) ViewBindings.findChildViewById(view, i10);
                                        if (viewStub7 != null) {
                                            i10 = R.id.reading_link_ad_view_stub;
                                            ViewStub viewStub8 = (ViewStub) ViewBindings.findChildViewById(view, i10);
                                            if (viewStub8 != null) {
                                                return new ReadingLayoutBinding((LinearLayout) view, viewStub, viewStub2, viewStub3, viewStub4, readerThemeImageView, bind, viewStub5, bind2, readerThemeTextView, viewStub6, viewStub7, viewStub8);
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
    public static ReadingLayoutBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ReadingLayoutBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.reading_layout, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.rootView;
    }
}
