package com.martian.mibook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.mibook.R;
import com.martian.mibook.ui.reader.ReaderThemeImageView;
import com.martian.mibook.ui.reader.ReaderThemeTextView;
import de.hdodenhof.circleimageview.CircleImageView;

/* loaded from: classes3.dex */
public final class ItemBookCoverHotCommentBinding implements ViewBinding {

    @NonNull
    public final ReaderThemeTextView hotCommentContent;

    @NonNull
    public final CircleImageView hotCommentHeader;

    @NonNull
    public final ReaderThemeTextView hotCommentNickname;

    @NonNull
    public final ReaderThemeImageView hotCommentStar1;

    @NonNull
    public final ReaderThemeImageView hotCommentStar2;

    @NonNull
    public final ReaderThemeImageView hotCommentStar3;

    @NonNull
    public final ReaderThemeImageView hotCommentStar4;

    @NonNull
    public final ReaderThemeImageView hotCommentStar5;

    @NonNull
    private final LinearLayout rootView;

    private ItemBookCoverHotCommentBinding(@NonNull LinearLayout linearLayout, @NonNull ReaderThemeTextView readerThemeTextView, @NonNull CircleImageView circleImageView, @NonNull ReaderThemeTextView readerThemeTextView2, @NonNull ReaderThemeImageView readerThemeImageView, @NonNull ReaderThemeImageView readerThemeImageView2, @NonNull ReaderThemeImageView readerThemeImageView3, @NonNull ReaderThemeImageView readerThemeImageView4, @NonNull ReaderThemeImageView readerThemeImageView5) {
        this.rootView = linearLayout;
        this.hotCommentContent = readerThemeTextView;
        this.hotCommentHeader = circleImageView;
        this.hotCommentNickname = readerThemeTextView2;
        this.hotCommentStar1 = readerThemeImageView;
        this.hotCommentStar2 = readerThemeImageView2;
        this.hotCommentStar3 = readerThemeImageView3;
        this.hotCommentStar4 = readerThemeImageView4;
        this.hotCommentStar5 = readerThemeImageView5;
    }

    @NonNull
    public static ItemBookCoverHotCommentBinding bind(@NonNull View view) {
        int i10 = R.id.hot_comment_content;
        ReaderThemeTextView readerThemeTextView = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
        if (readerThemeTextView != null) {
            i10 = R.id.hot_comment_header;
            CircleImageView circleImageView = (CircleImageView) ViewBindings.findChildViewById(view, i10);
            if (circleImageView != null) {
                i10 = R.id.hot_comment_nickname;
                ReaderThemeTextView readerThemeTextView2 = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
                if (readerThemeTextView2 != null) {
                    i10 = R.id.hot_comment_star_1;
                    ReaderThemeImageView readerThemeImageView = (ReaderThemeImageView) ViewBindings.findChildViewById(view, i10);
                    if (readerThemeImageView != null) {
                        i10 = R.id.hot_comment_star_2;
                        ReaderThemeImageView readerThemeImageView2 = (ReaderThemeImageView) ViewBindings.findChildViewById(view, i10);
                        if (readerThemeImageView2 != null) {
                            i10 = R.id.hot_comment_star_3;
                            ReaderThemeImageView readerThemeImageView3 = (ReaderThemeImageView) ViewBindings.findChildViewById(view, i10);
                            if (readerThemeImageView3 != null) {
                                i10 = R.id.hot_comment_star_4;
                                ReaderThemeImageView readerThemeImageView4 = (ReaderThemeImageView) ViewBindings.findChildViewById(view, i10);
                                if (readerThemeImageView4 != null) {
                                    i10 = R.id.hot_comment_star_5;
                                    ReaderThemeImageView readerThemeImageView5 = (ReaderThemeImageView) ViewBindings.findChildViewById(view, i10);
                                    if (readerThemeImageView5 != null) {
                                        return new ItemBookCoverHotCommentBinding((LinearLayout) view, readerThemeTextView, circleImageView, readerThemeTextView2, readerThemeImageView, readerThemeImageView2, readerThemeImageView3, readerThemeImageView4, readerThemeImageView5);
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
    public static ItemBookCoverHotCommentBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ItemBookCoverHotCommentBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.item_book_cover_hot_comment, viewGroup, false);
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
