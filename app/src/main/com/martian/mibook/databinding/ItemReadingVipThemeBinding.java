package com.martian.mibook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.libmars.ui.theme.ThemeLinearLayout;
import com.martian.libmars.widget.RoundedLayout;
import com.martian.mibook.R;
import com.martian.mibook.ui.reader.ReaderThemeTextView;

/* loaded from: classes3.dex */
public final class ItemReadingVipThemeBinding implements ViewBinding {

    @NonNull
    public final ImageView ivThemePic;

    @NonNull
    public final ThemeLinearLayout llThemeStatus;

    @NonNull
    private final RoundedLayout rootView;

    @NonNull
    public final ReaderThemeTextView tvThemeName;

    @NonNull
    public final TextView tvThemeStatus;

    private ItemReadingVipThemeBinding(@NonNull RoundedLayout roundedLayout, @NonNull ImageView imageView, @NonNull ThemeLinearLayout themeLinearLayout, @NonNull ReaderThemeTextView readerThemeTextView, @NonNull TextView textView) {
        this.rootView = roundedLayout;
        this.ivThemePic = imageView;
        this.llThemeStatus = themeLinearLayout;
        this.tvThemeName = readerThemeTextView;
        this.tvThemeStatus = textView;
    }

    @NonNull
    public static ItemReadingVipThemeBinding bind(@NonNull View view) {
        int i10 = R.id.iv_theme_pic;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i10);
        if (imageView != null) {
            i10 = R.id.ll_theme_status;
            ThemeLinearLayout themeLinearLayout = (ThemeLinearLayout) ViewBindings.findChildViewById(view, i10);
            if (themeLinearLayout != null) {
                i10 = R.id.tv_theme_name;
                ReaderThemeTextView readerThemeTextView = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
                if (readerThemeTextView != null) {
                    i10 = R.id.tv_theme_status;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, i10);
                    if (textView != null) {
                        return new ItemReadingVipThemeBinding((RoundedLayout) view, imageView, themeLinearLayout, readerThemeTextView, textView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static ItemReadingVipThemeBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ItemReadingVipThemeBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.item_reading_vip_theme, viewGroup, false);
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
