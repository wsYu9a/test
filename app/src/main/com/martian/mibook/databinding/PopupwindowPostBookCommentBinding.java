package com.martian.mibook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.libmars.ui.theme.ThemeEditText;
import com.martian.libmars.ui.theme.ThemeImageView;
import com.martian.libmars.ui.theme.ThemeLinearLayout;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.mibook.R;

/* loaded from: classes3.dex */
public final class PopupwindowPostBookCommentBinding implements ViewBinding {

    @NonNull
    public final ThemeEditText bdEditComment;

    @NonNull
    public final ThemeLinearLayout bdInputView;

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
    public final ThemeTextView postCommentButton;

    @NonNull
    public final ThemeImageView postCommentClose;

    @NonNull
    public final LinearLayout postCommentStars;

    @NonNull
    public final TextView postCommentStatus;

    @NonNull
    public final ThemeTextView postCommentTitle;

    @NonNull
    public final ThemeLinearLayout postCommentView;

    @NonNull
    private final RelativeLayout rootView;

    private PopupwindowPostBookCommentBinding(@NonNull RelativeLayout relativeLayout, @NonNull ThemeEditText themeEditText, @NonNull ThemeLinearLayout themeLinearLayout, @NonNull ImageView imageView, @NonNull ImageView imageView2, @NonNull ImageView imageView3, @NonNull ImageView imageView4, @NonNull ImageView imageView5, @NonNull ThemeTextView themeTextView, @NonNull ThemeImageView themeImageView, @NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull ThemeTextView themeTextView2, @NonNull ThemeLinearLayout themeLinearLayout2) {
        this.rootView = relativeLayout;
        this.bdEditComment = themeEditText;
        this.bdInputView = themeLinearLayout;
        this.bdVote1 = imageView;
        this.bdVote2 = imageView2;
        this.bdVote3 = imageView3;
        this.bdVote4 = imageView4;
        this.bdVote5 = imageView5;
        this.postCommentButton = themeTextView;
        this.postCommentClose = themeImageView;
        this.postCommentStars = linearLayout;
        this.postCommentStatus = textView;
        this.postCommentTitle = themeTextView2;
        this.postCommentView = themeLinearLayout2;
    }

    @NonNull
    public static PopupwindowPostBookCommentBinding bind(@NonNull View view) {
        int i10 = R.id.bd_edit_comment;
        ThemeEditText themeEditText = (ThemeEditText) ViewBindings.findChildViewById(view, i10);
        if (themeEditText != null) {
            i10 = R.id.bd_input_view;
            ThemeLinearLayout themeLinearLayout = (ThemeLinearLayout) ViewBindings.findChildViewById(view, i10);
            if (themeLinearLayout != null) {
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
                                    ThemeTextView themeTextView = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                                    if (themeTextView != null) {
                                        i10 = R.id.post_comment_close;
                                        ThemeImageView themeImageView = (ThemeImageView) ViewBindings.findChildViewById(view, i10);
                                        if (themeImageView != null) {
                                            i10 = R.id.post_comment_stars;
                                            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i10);
                                            if (linearLayout != null) {
                                                i10 = R.id.post_comment_status;
                                                TextView textView = (TextView) ViewBindings.findChildViewById(view, i10);
                                                if (textView != null) {
                                                    i10 = R.id.post_comment_title;
                                                    ThemeTextView themeTextView2 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                                                    if (themeTextView2 != null) {
                                                        i10 = R.id.post_comment_view;
                                                        ThemeLinearLayout themeLinearLayout2 = (ThemeLinearLayout) ViewBindings.findChildViewById(view, i10);
                                                        if (themeLinearLayout2 != null) {
                                                            return new PopupwindowPostBookCommentBinding((RelativeLayout) view, themeEditText, themeLinearLayout, imageView, imageView2, imageView3, imageView4, imageView5, themeTextView, themeImageView, linearLayout, textView, themeTextView2, themeLinearLayout2);
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
    public static PopupwindowPostBookCommentBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static PopupwindowPostBookCommentBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.popupwindow_post_book_comment, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public RelativeLayout getRoot() {
        return this.rootView;
    }
}
