package com.martian.mibook.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.martian.mibook.ui.reader.ReaderThemeEditText;
import com.martian.mibook.ui.reader.ReaderThemeItemTextView;
import com.martian.mibook.ui.reader.ReaderThemeLinearLayout;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public final class u4 implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final RelativeLayout f12787a;

    /* renamed from: b */
    @NonNull
    public final ReaderThemeEditText f12788b;

    /* renamed from: c */
    @NonNull
    public final ReaderThemeLinearLayout f12789c;

    /* renamed from: d */
    @NonNull
    public final ReaderThemeItemTextView f12790d;

    private u4(@NonNull RelativeLayout rootView, @NonNull ReaderThemeEditText bdEditComment, @NonNull ReaderThemeLinearLayout bottom, @NonNull ReaderThemeItemTextView postCommentButton) {
        this.f12787a = rootView;
        this.f12788b = bdEditComment;
        this.f12789c = bottom;
        this.f12790d = postCommentButton;
    }

    @NonNull
    public static u4 a(@NonNull View rootView) {
        int i2 = R.id.bd_edit_comment;
        ReaderThemeEditText readerThemeEditText = (ReaderThemeEditText) rootView.findViewById(R.id.bd_edit_comment);
        if (readerThemeEditText != null) {
            i2 = R.id.bottom;
            ReaderThemeLinearLayout readerThemeLinearLayout = (ReaderThemeLinearLayout) rootView.findViewById(R.id.bottom);
            if (readerThemeLinearLayout != null) {
                i2 = R.id.post_comment_button;
                ReaderThemeItemTextView readerThemeItemTextView = (ReaderThemeItemTextView) rootView.findViewById(R.id.post_comment_button);
                if (readerThemeItemTextView != null) {
                    return new u4((RelativeLayout) rootView, readerThemeEditText, readerThemeLinearLayout, readerThemeItemTextView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i2)));
    }

    @NonNull
    public static u4 c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static u4 d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.popupwindow_post_chapter_comment, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f12787a;
    }
}
