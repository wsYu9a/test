package com.martian.mibook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.libmars.ui.theme.ThemeImageView;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.mibook.R;

/* loaded from: classes3.dex */
public final class ItemBookChapterBinding implements ViewBinding {

    @NonNull
    public final ThemeImageView ivChapterPosition;

    @NonNull
    private final LinearLayout rootView;

    @NonNull
    public final ThemeTextView tvChapterStatus;

    @NonNull
    public final ThemeTextView tvChapterTitle;

    @NonNull
    public final LinearLayout tvChapterView;

    private ItemBookChapterBinding(@NonNull LinearLayout linearLayout, @NonNull ThemeImageView themeImageView, @NonNull ThemeTextView themeTextView, @NonNull ThemeTextView themeTextView2, @NonNull LinearLayout linearLayout2) {
        this.rootView = linearLayout;
        this.ivChapterPosition = themeImageView;
        this.tvChapterStatus = themeTextView;
        this.tvChapterTitle = themeTextView2;
        this.tvChapterView = linearLayout2;
    }

    @NonNull
    public static ItemBookChapterBinding bind(@NonNull View view) {
        int i10 = R.id.iv_chapter_position;
        ThemeImageView themeImageView = (ThemeImageView) ViewBindings.findChildViewById(view, i10);
        if (themeImageView != null) {
            i10 = R.id.tv_chapter_status;
            ThemeTextView themeTextView = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
            if (themeTextView != null) {
                i10 = R.id.tv_chapter_title;
                ThemeTextView themeTextView2 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                if (themeTextView2 != null) {
                    LinearLayout linearLayout = (LinearLayout) view;
                    return new ItemBookChapterBinding(linearLayout, themeImageView, themeTextView, themeTextView2, linearLayout);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static ItemBookChapterBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ItemBookChapterBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.item_book_chapter, viewGroup, false);
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
