package com.martian.mibook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.libmars.widget.RoundedLayout;
import com.martian.mibook.R;
import com.martian.mibook.ui.reader.ReaderThemeLinearLayout;
import com.martian.mibook.ui.reader.ReaderThemeTextView;

/* loaded from: classes3.dex */
public final class DialogReaderCommentLongClickBinding implements ViewBinding {

    @NonNull
    public final ReaderThemeLinearLayout llClose;

    @NonNull
    private final RoundedLayout rootView;

    @NonNull
    public final ReaderThemeTextView tvCommentContent;

    @NonNull
    public final ReaderThemeTextView tvCopy;

    @NonNull
    public final ReaderThemeTextView tvReply;

    @NonNull
    public final ReaderThemeTextView tvReport;

    @NonNull
    public final ReaderThemeTextView tvVote;

    private DialogReaderCommentLongClickBinding(@NonNull RoundedLayout roundedLayout, @NonNull ReaderThemeLinearLayout readerThemeLinearLayout, @NonNull ReaderThemeTextView readerThemeTextView, @NonNull ReaderThemeTextView readerThemeTextView2, @NonNull ReaderThemeTextView readerThemeTextView3, @NonNull ReaderThemeTextView readerThemeTextView4, @NonNull ReaderThemeTextView readerThemeTextView5) {
        this.rootView = roundedLayout;
        this.llClose = readerThemeLinearLayout;
        this.tvCommentContent = readerThemeTextView;
        this.tvCopy = readerThemeTextView2;
        this.tvReply = readerThemeTextView3;
        this.tvReport = readerThemeTextView4;
        this.tvVote = readerThemeTextView5;
    }

    @NonNull
    public static DialogReaderCommentLongClickBinding bind(@NonNull View view) {
        int i10 = R.id.ll_close;
        ReaderThemeLinearLayout readerThemeLinearLayout = (ReaderThemeLinearLayout) ViewBindings.findChildViewById(view, i10);
        if (readerThemeLinearLayout != null) {
            i10 = R.id.tv_comment_content;
            ReaderThemeTextView readerThemeTextView = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
            if (readerThemeTextView != null) {
                i10 = R.id.tv_copy;
                ReaderThemeTextView readerThemeTextView2 = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
                if (readerThemeTextView2 != null) {
                    i10 = R.id.tv_reply;
                    ReaderThemeTextView readerThemeTextView3 = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
                    if (readerThemeTextView3 != null) {
                        i10 = R.id.tv_report;
                        ReaderThemeTextView readerThemeTextView4 = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
                        if (readerThemeTextView4 != null) {
                            i10 = R.id.tv_vote;
                            ReaderThemeTextView readerThemeTextView5 = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
                            if (readerThemeTextView5 != null) {
                                return new DialogReaderCommentLongClickBinding((RoundedLayout) view, readerThemeLinearLayout, readerThemeTextView, readerThemeTextView2, readerThemeTextView3, readerThemeTextView4, readerThemeTextView5);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static DialogReaderCommentLongClickBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static DialogReaderCommentLongClickBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.dialog_reader_comment_long_click, viewGroup, false);
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
