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
import com.martian.libmars.ui.theme.ThemeShadowLayout;
import com.martian.mibook.R;
import com.martian.mibook.ui.reader.ReaderThemeEditText;
import com.martian.mibook.ui.reader.ReaderThemeItemTextView;
import com.martian.mibook.ui.reader.ReaderThemeLinearLayout;
import com.martian.mibook.ui.reader.ReaderThemeTextView;

/* loaded from: classes3.dex */
public final class ReaderPostCommentFragmentBinding implements ViewBinding {

    @NonNull
    public final ReaderThemeEditText bdEditComment;

    @NonNull
    public final ReaderThemeItemTextView postCommentButton;

    @NonNull
    public final ReaderThemeTextView postCommentParagraph;

    @NonNull
    public final ReaderThemeLinearLayout postCommentParagraphLine;

    @NonNull
    public final LinearLayout postCommentParagraphView;

    @NonNull
    private final FrameLayout rootView;

    @NonNull
    public final ThemeShadowLayout shadowLayout;

    @NonNull
    public final ReaderThemeTextView tvTextCount;

    private ReaderPostCommentFragmentBinding(@NonNull FrameLayout frameLayout, @NonNull ReaderThemeEditText readerThemeEditText, @NonNull ReaderThemeItemTextView readerThemeItemTextView, @NonNull ReaderThemeTextView readerThemeTextView, @NonNull ReaderThemeLinearLayout readerThemeLinearLayout, @NonNull LinearLayout linearLayout, @NonNull ThemeShadowLayout themeShadowLayout, @NonNull ReaderThemeTextView readerThemeTextView2) {
        this.rootView = frameLayout;
        this.bdEditComment = readerThemeEditText;
        this.postCommentButton = readerThemeItemTextView;
        this.postCommentParagraph = readerThemeTextView;
        this.postCommentParagraphLine = readerThemeLinearLayout;
        this.postCommentParagraphView = linearLayout;
        this.shadowLayout = themeShadowLayout;
        this.tvTextCount = readerThemeTextView2;
    }

    @NonNull
    public static ReaderPostCommentFragmentBinding bind(@NonNull View view) {
        int i10 = R.id.bd_edit_comment;
        ReaderThemeEditText readerThemeEditText = (ReaderThemeEditText) ViewBindings.findChildViewById(view, i10);
        if (readerThemeEditText != null) {
            i10 = R.id.post_comment_button;
            ReaderThemeItemTextView readerThemeItemTextView = (ReaderThemeItemTextView) ViewBindings.findChildViewById(view, i10);
            if (readerThemeItemTextView != null) {
                i10 = R.id.post_comment_paragraph;
                ReaderThemeTextView readerThemeTextView = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
                if (readerThemeTextView != null) {
                    i10 = R.id.post_comment_paragraph_line;
                    ReaderThemeLinearLayout readerThemeLinearLayout = (ReaderThemeLinearLayout) ViewBindings.findChildViewById(view, i10);
                    if (readerThemeLinearLayout != null) {
                        i10 = R.id.post_comment_paragraph_view;
                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i10);
                        if (linearLayout != null) {
                            i10 = R.id.shadow_layout;
                            ThemeShadowLayout themeShadowLayout = (ThemeShadowLayout) ViewBindings.findChildViewById(view, i10);
                            if (themeShadowLayout != null) {
                                i10 = R.id.tv_text_count;
                                ReaderThemeTextView readerThemeTextView2 = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
                                if (readerThemeTextView2 != null) {
                                    return new ReaderPostCommentFragmentBinding((FrameLayout) view, readerThemeEditText, readerThemeItemTextView, readerThemeTextView, readerThemeLinearLayout, linearLayout, themeShadowLayout, readerThemeTextView2);
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
    public static ReaderPostCommentFragmentBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ReaderPostCommentFragmentBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.reader_post_comment_fragment, viewGroup, false);
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
