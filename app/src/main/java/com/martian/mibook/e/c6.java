package com.martian.mibook.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.martian.libmars.ui.theme.ThemeImageView;
import com.martian.mibook.ui.reader.ReaderThemeLinearLayout;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public final class c6 implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final RelativeLayout f11803a;

    /* renamed from: b */
    @NonNull
    public final ReaderThemeLinearLayout f11804b;

    /* renamed from: c */
    @NonNull
    public final ThemeImageView f11805c;

    /* renamed from: d */
    @NonNull
    public final LinearLayout f11806d;

    private c6(@NonNull RelativeLayout rootView, @NonNull ReaderThemeLinearLayout bookCommentView, @NonNull ThemeImageView bookCommentViewDivider, @NonNull LinearLayout menuTopView) {
        this.f11803a = rootView;
        this.f11804b = bookCommentView;
        this.f11805c = bookCommentViewDivider;
        this.f11806d = menuTopView;
    }

    @NonNull
    public static c6 a(@NonNull View rootView) {
        int i2 = R.id.book_comment_view;
        ReaderThemeLinearLayout readerThemeLinearLayout = (ReaderThemeLinearLayout) rootView.findViewById(R.id.book_comment_view);
        if (readerThemeLinearLayout != null) {
            i2 = R.id.book_comment_view_divider;
            ThemeImageView themeImageView = (ThemeImageView) rootView.findViewById(R.id.book_comment_view_divider);
            if (themeImageView != null) {
                i2 = R.id.menu_top_view;
                LinearLayout linearLayout = (LinearLayout) rootView.findViewById(R.id.menu_top_view);
                if (linearLayout != null) {
                    return new c6((RelativeLayout) rootView, readerThemeLinearLayout, themeImageView, linearLayout);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i2)));
    }

    @NonNull
    public static c6 c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static c6 d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.reading_menu_bar, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f11803a;
    }
}
