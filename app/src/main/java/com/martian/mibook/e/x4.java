package com.martian.mibook.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.martian.libmars.ui.theme.ThemeEditText;
import com.martian.libmars.ui.theme.ThemeLinearLayout;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public final class x4 implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final RelativeLayout f12936a;

    /* renamed from: b */
    @NonNull
    public final ThemeEditText f12937b;

    /* renamed from: c */
    @NonNull
    public final ThemeLinearLayout f12938c;

    /* renamed from: d */
    @NonNull
    public final ThemeTextView f12939d;

    private x4(@NonNull RelativeLayout rootView, @NonNull ThemeEditText bdEditComment, @NonNull ThemeLinearLayout bottom, @NonNull ThemeTextView postCommentButton) {
        this.f12936a = rootView;
        this.f12937b = bdEditComment;
        this.f12938c = bottom;
        this.f12939d = postCommentButton;
    }

    @NonNull
    public static x4 a(@NonNull View rootView) {
        int i2 = R.id.bd_edit_comment;
        ThemeEditText themeEditText = (ThemeEditText) rootView.findViewById(R.id.bd_edit_comment);
        if (themeEditText != null) {
            i2 = R.id.bottom;
            ThemeLinearLayout themeLinearLayout = (ThemeLinearLayout) rootView.findViewById(R.id.bottom);
            if (themeLinearLayout != null) {
                i2 = R.id.post_comment_button;
                ThemeTextView themeTextView = (ThemeTextView) rootView.findViewById(R.id.post_comment_button);
                if (themeTextView != null) {
                    return new x4((RelativeLayout) rootView, themeEditText, themeLinearLayout, themeTextView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i2)));
    }

    @NonNull
    public static x4 c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static x4 d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.popupwindow_reply_comment, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f12936a;
    }
}
