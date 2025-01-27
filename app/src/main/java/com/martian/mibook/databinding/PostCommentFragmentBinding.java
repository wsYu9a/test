package com.martian.mibook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.libmars.ui.theme.ThemeEditText;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.libmars.ui.theme.ThemeView;
import com.martian.mibook.R;

/* loaded from: classes3.dex */
public final class PostCommentFragmentBinding implements ViewBinding {

    @NonNull
    public final ThemeEditText bdEditComment;

    @NonNull
    public final ThemeTextView postCommentButton;

    @NonNull
    public final ThemeTextView postCommentParagraph;

    @NonNull
    public final ThemeView postCommentParagraphLine;

    @NonNull
    public final LinearLayout postCommentParagraphView;

    @NonNull
    private final FrameLayout rootView;

    @NonNull
    public final ThemeTextView tvTextCount;

    private PostCommentFragmentBinding(@NonNull FrameLayout frameLayout, @NonNull ThemeEditText themeEditText, @NonNull ThemeTextView themeTextView, @NonNull ThemeTextView themeTextView2, @NonNull ThemeView themeView, @NonNull LinearLayout linearLayout, @NonNull ThemeTextView themeTextView3) {
        this.rootView = frameLayout;
        this.bdEditComment = themeEditText;
        this.postCommentButton = themeTextView;
        this.postCommentParagraph = themeTextView2;
        this.postCommentParagraphLine = themeView;
        this.postCommentParagraphView = linearLayout;
        this.tvTextCount = themeTextView3;
    }

    @NonNull
    public static PostCommentFragmentBinding bind(@NonNull View view) {
        int i10 = R.id.bd_edit_comment;
        ThemeEditText themeEditText = (ThemeEditText) ViewBindings.findChildViewById(view, i10);
        if (themeEditText != null) {
            i10 = R.id.post_comment_button;
            ThemeTextView themeTextView = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
            if (themeTextView != null) {
                i10 = R.id.post_comment_paragraph;
                ThemeTextView themeTextView2 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                if (themeTextView2 != null) {
                    i10 = R.id.post_comment_paragraph_line;
                    ThemeView themeView = (ThemeView) ViewBindings.findChildViewById(view, i10);
                    if (themeView != null) {
                        i10 = R.id.post_comment_paragraph_view;
                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i10);
                        if (linearLayout != null) {
                            i10 = R.id.tv_text_count;
                            ThemeTextView themeTextView3 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                            if (themeTextView3 != null) {
                                return new PostCommentFragmentBinding((FrameLayout) view, themeEditText, themeTextView, themeTextView2, themeView, linearLayout, themeTextView3);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static PostCommentFragmentBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static PostCommentFragmentBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.post_comment_fragment, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public FrameLayout getRoot() {
        return this.rootView;
    }
}
