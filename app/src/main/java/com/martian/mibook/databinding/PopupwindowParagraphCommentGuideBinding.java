package com.martian.mibook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.mibook.R;

/* loaded from: classes3.dex */
public final class PopupwindowParagraphCommentGuideBinding implements ViewBinding {

    @NonNull
    public final ThemeTextView paragraphGuideKnown;

    @NonNull
    private final RelativeLayout rootView;

    private PopupwindowParagraphCommentGuideBinding(@NonNull RelativeLayout relativeLayout, @NonNull ThemeTextView themeTextView) {
        this.rootView = relativeLayout;
        this.paragraphGuideKnown = themeTextView;
    }

    @NonNull
    public static PopupwindowParagraphCommentGuideBinding bind(@NonNull View view) {
        int i10 = R.id.paragraph_guide_known;
        ThemeTextView themeTextView = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
        if (themeTextView != null) {
            return new PopupwindowParagraphCommentGuideBinding((RelativeLayout) view, themeTextView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static PopupwindowParagraphCommentGuideBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static PopupwindowParagraphCommentGuideBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.popupwindow_paragraph_comment_guide, viewGroup, false);
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
