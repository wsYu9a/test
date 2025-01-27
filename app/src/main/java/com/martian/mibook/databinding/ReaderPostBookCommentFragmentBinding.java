package com.martian.mibook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.libmars.widget.RoundedLayout;
import com.martian.mibook.R;
import com.martian.mibook.ui.reader.ReaderThemeEditText;
import com.martian.mibook.ui.reader.ReaderThemeImageView;
import com.martian.mibook.ui.reader.ReaderThemeItemTextView;
import com.martian.mibook.ui.reader.ReaderThemeLinearLayout;
import com.martian.mibook.ui.reader.ReaderThemeTextView;

/* loaded from: classes3.dex */
public final class ReaderPostBookCommentFragmentBinding implements ViewBinding {

    @NonNull
    public final ReaderThemeEditText bdEditComment;

    @NonNull
    public final ReaderThemeLinearLayout bdInputView;

    @NonNull
    public final ImageView bdVote1;

    @NonNull
    public final ImageView bdVote2;

    @NonNull
    public final ImageView bdVote3;

    @NonNull
    public final ImageView bdVote4;

    @NonNull
    public final ImageView bdVote5;

    @NonNull
    public final ReaderThemeItemTextView postCommentButton;

    @NonNull
    public final ReaderThemeImageView postCommentClose;

    @NonNull
    public final LinearLayout postCommentStars;

    @NonNull
    public final ReaderThemeTextView postCommentStatus;

    @NonNull
    public final ReaderThemeTextView postCommentTitle;

    @NonNull
    public final ReaderThemeLinearLayout postCommentView;

    @NonNull
    private final RoundedLayout rootView;

    private ReaderPostBookCommentFragmentBinding(@NonNull RoundedLayout roundedLayout, @NonNull ReaderThemeEditText readerThemeEditText, @NonNull ReaderThemeLinearLayout readerThemeLinearLayout, @NonNull ImageView imageView, @NonNull ImageView imageView2, @NonNull ImageView imageView3, @NonNull ImageView imageView4, @NonNull ImageView imageView5, @NonNull ReaderThemeItemTextView readerThemeItemTextView, @NonNull ReaderThemeImageView readerThemeImageView, @NonNull LinearLayout linearLayout, @NonNull ReaderThemeTextView readerThemeTextView, @NonNull ReaderThemeTextView readerThemeTextView2, @NonNull ReaderThemeLinearLayout readerThemeLinearLayout2) {
        this.rootView = roundedLayout;
        this.bdEditComment = readerThemeEditText;
        this.bdInputView = readerThemeLinearLayout;
        this.bdVote1 = imageView;
        this.bdVote2 = imageView2;
        this.bdVote3 = imageView3;
        this.bdVote4 = imageView4;
        this.bdVote5 = imageView5;
        this.postCommentButton = readerThemeItemTextView;
        this.postCommentClose = readerThemeImageView;
        this.postCommentStars = linearLayout;
        this.postCommentStatus = readerThemeTextView;
        this.postCommentTitle = readerThemeTextView2;
        this.postCommentView = readerThemeLinearLayout2;
    }

    @NonNull
    public static ReaderPostBookCommentFragmentBinding bind(@NonNull View view) {
        int i10 = R.id.bd_edit_comment;
        ReaderThemeEditText readerThemeEditText = (ReaderThemeEditText) ViewBindings.findChildViewById(view, i10);
        if (readerThemeEditText != null) {
            i10 = R.id.bd_input_view;
            ReaderThemeLinearLayout readerThemeLinearLayout = (ReaderThemeLinearLayout) ViewBindings.findChildViewById(view, i10);
            if (readerThemeLinearLayout != null) {
                i10 = R.id.bd_vote_1;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i10);
                if (imageView != null) {
                    i10 = R.id.bd_vote_2;
                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i10);
                    if (imageView2 != null) {
                        i10 = R.id.bd_vote_3;
                        ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i10);
                        if (imageView3 != null) {
                            i10 = R.id.bd_vote_4;
                            ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, i10);
                            if (imageView4 != null) {
                                i10 = R.id.bd_vote_5;
                                ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(view, i10);
                                if (imageView5 != null) {
                                    i10 = R.id.post_comment_button;
                                    ReaderThemeItemTextView readerThemeItemTextView = (ReaderThemeItemTextView) ViewBindings.findChildViewById(view, i10);
                                    if (readerThemeItemTextView != null) {
                                        i10 = R.id.post_comment_close;
                                        ReaderThemeImageView readerThemeImageView = (ReaderThemeImageView) ViewBindings.findChildViewById(view, i10);
                                        if (readerThemeImageView != null) {
                                            i10 = R.id.post_comment_stars;
                                            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i10);
                                            if (linearLayout != null) {
                                                i10 = R.id.post_comment_status;
                                                ReaderThemeTextView readerThemeTextView = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
                                                if (readerThemeTextView != null) {
                                                    i10 = R.id.post_comment_title;
                                                    ReaderThemeTextView readerThemeTextView2 = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
                                                    if (readerThemeTextView2 != null) {
                                                        i10 = R.id.post_comment_view;
                                                        ReaderThemeLinearLayout readerThemeLinearLayout2 = (ReaderThemeLinearLayout) ViewBindings.findChildViewById(view, i10);
                                                        if (readerThemeLinearLayout2 != null) {
                                                            return new ReaderPostBookCommentFragmentBinding((RoundedLayout) view, readerThemeEditText, readerThemeLinearLayout, imageView, imageView2, imageView3, imageView4, imageView5, readerThemeItemTextView, readerThemeImageView, linearLayout, readerThemeTextView, readerThemeTextView2, readerThemeLinearLayout2);
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
    public static ReaderPostBookCommentFragmentBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ReaderPostBookCommentFragmentBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.reader_post_book_comment_fragment, viewGroup, false);
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
