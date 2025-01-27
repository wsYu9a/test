package com.martian.mibook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.libmars.ui.theme.ThemeEditText;
import com.martian.libmars.ui.theme.ThemeLinearLayout;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.mibook.R;

/* loaded from: classes3.dex */
public final class PopupwindowReplyCommentBinding implements ViewBinding {

    @NonNull
    public final ThemeEditText bdEditComment;

    @NonNull
    public final ThemeLinearLayout bottom;

    @NonNull
    public final ThemeTextView postCommentButton;

    @NonNull
    private final RelativeLayout rootView;

    private PopupwindowReplyCommentBinding(@NonNull RelativeLayout relativeLayout, @NonNull ThemeEditText themeEditText, @NonNull ThemeLinearLayout themeLinearLayout, @NonNull ThemeTextView themeTextView) {
        this.rootView = relativeLayout;
        this.bdEditComment = themeEditText;
        this.bottom = themeLinearLayout;
        this.postCommentButton = themeTextView;
    }

    @NonNull
    public static PopupwindowReplyCommentBinding bind(@NonNull View view) {
        int i10 = R.id.bd_edit_comment;
        ThemeEditText themeEditText = (ThemeEditText) ViewBindings.findChildViewById(view, i10);
        if (themeEditText != null) {
            i10 = R.id.bottom;
            ThemeLinearLayout themeLinearLayout = (ThemeLinearLayout) ViewBindings.findChildViewById(view, i10);
            if (themeLinearLayout != null) {
                i10 = R.id.post_comment_button;
                ThemeTextView themeTextView = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                if (themeTextView != null) {
                    return new PopupwindowReplyCommentBinding((RelativeLayout) view, themeEditText, themeLinearLayout, themeTextView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static PopupwindowReplyCommentBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static PopupwindowReplyCommentBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.popupwindow_reply_comment, viewGroup, false);
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
