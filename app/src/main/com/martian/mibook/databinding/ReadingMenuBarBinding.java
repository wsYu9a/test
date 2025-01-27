package com.martian.mibook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.libmars.ui.theme.ThemeImageView;
import com.martian.mibook.R;
import com.martian.mibook.ui.reader.ReaderThemeLinearLayout;

/* loaded from: classes3.dex */
public final class ReadingMenuBarBinding implements ViewBinding {

    @NonNull
    public final ReaderThemeLinearLayout bookCommentView;

    @NonNull
    public final ThemeImageView bookCommentViewDivider;

    @NonNull
    public final LinearLayout menuTopView;

    @NonNull
    private final RelativeLayout rootView;

    private ReadingMenuBarBinding(@NonNull RelativeLayout relativeLayout, @NonNull ReaderThemeLinearLayout readerThemeLinearLayout, @NonNull ThemeImageView themeImageView, @NonNull LinearLayout linearLayout) {
        this.rootView = relativeLayout;
        this.bookCommentView = readerThemeLinearLayout;
        this.bookCommentViewDivider = themeImageView;
        this.menuTopView = linearLayout;
    }

    @NonNull
    public static ReadingMenuBarBinding bind(@NonNull View view) {
        int i10 = R.id.book_comment_view;
        ReaderThemeLinearLayout readerThemeLinearLayout = (ReaderThemeLinearLayout) ViewBindings.findChildViewById(view, i10);
        if (readerThemeLinearLayout != null) {
            i10 = R.id.book_comment_view_divider;
            ThemeImageView themeImageView = (ThemeImageView) ViewBindings.findChildViewById(view, i10);
            if (themeImageView != null) {
                i10 = R.id.menu_top_view;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i10);
                if (linearLayout != null) {
                    return new ReadingMenuBarBinding((RelativeLayout) view, readerThemeLinearLayout, themeImageView, linearLayout);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static ReadingMenuBarBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ReadingMenuBarBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.reading_menu_bar, viewGroup, false);
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
