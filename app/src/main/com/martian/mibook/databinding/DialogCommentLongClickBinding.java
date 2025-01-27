package com.martian.mibook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.libmars.ui.theme.ThemeLinearLayout;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.libmars.widget.RoundedLayout;
import com.martian.mibook.R;

/* loaded from: classes3.dex */
public final class DialogCommentLongClickBinding implements ViewBinding {

    @NonNull
    public final ThemeLinearLayout llClose;

    @NonNull
    private final RoundedLayout rootView;

    @NonNull
    public final ThemeTextView tvCommentContent;

    @NonNull
    public final ThemeTextView tvCopy;

    @NonNull
    public final ThemeTextView tvReply;

    @NonNull
    public final ThemeTextView tvReport;

    @NonNull
    public final ThemeTextView tvVote;

    private DialogCommentLongClickBinding(@NonNull RoundedLayout roundedLayout, @NonNull ThemeLinearLayout themeLinearLayout, @NonNull ThemeTextView themeTextView, @NonNull ThemeTextView themeTextView2, @NonNull ThemeTextView themeTextView3, @NonNull ThemeTextView themeTextView4, @NonNull ThemeTextView themeTextView5) {
        this.rootView = roundedLayout;
        this.llClose = themeLinearLayout;
        this.tvCommentContent = themeTextView;
        this.tvCopy = themeTextView2;
        this.tvReply = themeTextView3;
        this.tvReport = themeTextView4;
        this.tvVote = themeTextView5;
    }

    @NonNull
    public static DialogCommentLongClickBinding bind(@NonNull View view) {
        int i10 = R.id.ll_close;
        ThemeLinearLayout themeLinearLayout = (ThemeLinearLayout) ViewBindings.findChildViewById(view, i10);
        if (themeLinearLayout != null) {
            i10 = R.id.tv_comment_content;
            ThemeTextView themeTextView = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
            if (themeTextView != null) {
                i10 = R.id.tv_copy;
                ThemeTextView themeTextView2 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                if (themeTextView2 != null) {
                    i10 = R.id.tv_reply;
                    ThemeTextView themeTextView3 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                    if (themeTextView3 != null) {
                        i10 = R.id.tv_report;
                        ThemeTextView themeTextView4 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                        if (themeTextView4 != null) {
                            i10 = R.id.tv_vote;
                            ThemeTextView themeTextView5 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                            if (themeTextView5 != null) {
                                return new DialogCommentLongClickBinding((RoundedLayout) view, themeLinearLayout, themeTextView, themeTextView2, themeTextView3, themeTextView4, themeTextView5);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static DialogCommentLongClickBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static DialogCommentLongClickBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.dialog_comment_long_click, viewGroup, false);
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
