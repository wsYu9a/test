package com.martian.mibook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.libmars.widget.RoundedLayout;
import com.martian.mibook.R;
import com.martian.mibook.ui.reader.ReaderThemeLinearLayout;
import com.martian.mibook.ui.reader.ReaderThemeTextView;
import de.hdodenhof.circleimageview.CircleImageView;

/* loaded from: classes3.dex */
public final class ReadingChapterCommentBinding implements ViewBinding {

    @NonNull
    public final ReaderThemeTextView chapterComment;

    @NonNull
    public final LinearLayout chapterCommentRealView;

    @NonNull
    public final ReaderThemeLinearLayout chapterEndCommentsClickView;

    @NonNull
    public final ReaderThemeTextView chapterEndCommentsContent;

    @NonNull
    public final CircleImageView chapterEndCommentsHeader;

    @NonNull
    public final ReaderThemeTextView chapterEndCommentsNickname;

    @NonNull
    public final ReaderThemeTextView chapterEndCommentsNumber;

    @NonNull
    public final ReaderThemeLinearLayout chapterEndCommentsPost;

    @NonNull
    public final RoundedLayout chapterEndCommentsView;

    @NonNull
    public final ReaderThemeLinearLayout chapterPostCommentView;

    @NonNull
    private final LinearLayout rootView;

    private ReadingChapterCommentBinding(@NonNull LinearLayout linearLayout, @NonNull ReaderThemeTextView readerThemeTextView, @NonNull LinearLayout linearLayout2, @NonNull ReaderThemeLinearLayout readerThemeLinearLayout, @NonNull ReaderThemeTextView readerThemeTextView2, @NonNull CircleImageView circleImageView, @NonNull ReaderThemeTextView readerThemeTextView3, @NonNull ReaderThemeTextView readerThemeTextView4, @NonNull ReaderThemeLinearLayout readerThemeLinearLayout2, @NonNull RoundedLayout roundedLayout, @NonNull ReaderThemeLinearLayout readerThemeLinearLayout3) {
        this.rootView = linearLayout;
        this.chapterComment = readerThemeTextView;
        this.chapterCommentRealView = linearLayout2;
        this.chapterEndCommentsClickView = readerThemeLinearLayout;
        this.chapterEndCommentsContent = readerThemeTextView2;
        this.chapterEndCommentsHeader = circleImageView;
        this.chapterEndCommentsNickname = readerThemeTextView3;
        this.chapterEndCommentsNumber = readerThemeTextView4;
        this.chapterEndCommentsPost = readerThemeLinearLayout2;
        this.chapterEndCommentsView = roundedLayout;
        this.chapterPostCommentView = readerThemeLinearLayout3;
    }

    @NonNull
    public static ReadingChapterCommentBinding bind(@NonNull View view) {
        int i10 = R.id.chapter_comment;
        ReaderThemeTextView readerThemeTextView = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
        if (readerThemeTextView != null) {
            LinearLayout linearLayout = (LinearLayout) view;
            i10 = R.id.chapter_end_comments_click_view;
            ReaderThemeLinearLayout readerThemeLinearLayout = (ReaderThemeLinearLayout) ViewBindings.findChildViewById(view, i10);
            if (readerThemeLinearLayout != null) {
                i10 = R.id.chapter_end_comments_content;
                ReaderThemeTextView readerThemeTextView2 = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
                if (readerThemeTextView2 != null) {
                    i10 = R.id.chapter_end_comments_header;
                    CircleImageView circleImageView = (CircleImageView) ViewBindings.findChildViewById(view, i10);
                    if (circleImageView != null) {
                        i10 = R.id.chapter_end_comments_nickname;
                        ReaderThemeTextView readerThemeTextView3 = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
                        if (readerThemeTextView3 != null) {
                            i10 = R.id.chapter_end_comments_number;
                            ReaderThemeTextView readerThemeTextView4 = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
                            if (readerThemeTextView4 != null) {
                                i10 = R.id.chapter_end_comments_post;
                                ReaderThemeLinearLayout readerThemeLinearLayout2 = (ReaderThemeLinearLayout) ViewBindings.findChildViewById(view, i10);
                                if (readerThemeLinearLayout2 != null) {
                                    i10 = R.id.chapter_end_comments_view;
                                    RoundedLayout roundedLayout = (RoundedLayout) ViewBindings.findChildViewById(view, i10);
                                    if (roundedLayout != null) {
                                        i10 = R.id.chapter_post_comment_view;
                                        ReaderThemeLinearLayout readerThemeLinearLayout3 = (ReaderThemeLinearLayout) ViewBindings.findChildViewById(view, i10);
                                        if (readerThemeLinearLayout3 != null) {
                                            return new ReadingChapterCommentBinding(linearLayout, readerThemeTextView, linearLayout, readerThemeLinearLayout, readerThemeTextView2, circleImageView, readerThemeTextView3, readerThemeTextView4, readerThemeLinearLayout2, roundedLayout, readerThemeLinearLayout3);
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
    public static ReadingChapterCommentBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ReadingChapterCommentBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.reading_chapter_comment, viewGroup, false);
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
