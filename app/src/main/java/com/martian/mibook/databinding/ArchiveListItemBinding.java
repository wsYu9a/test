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
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.mibook.R;

/* loaded from: classes3.dex */
public final class ArchiveListItemBinding implements ViewBinding {

    @NonNull
    public final ImageView ivCover;

    @NonNull
    public final ImageView ivPopupHint;

    @NonNull
    private final ThemeLinearLayout rootView;

    @NonNull
    public final TextView tvArchiveDate;

    @NonNull
    public final TextView tvAuthor;

    @NonNull
    public final ThemeTextView tvBookname;

    @NonNull
    public final TextView tvUrlOrChapter;

    private ArchiveListItemBinding(@NonNull ThemeLinearLayout themeLinearLayout, @NonNull ImageView imageView, @NonNull ImageView imageView2, @NonNull TextView textView, @NonNull TextView textView2, @NonNull ThemeTextView themeTextView, @NonNull TextView textView3) {
        this.rootView = themeLinearLayout;
        this.ivCover = imageView;
        this.ivPopupHint = imageView2;
        this.tvArchiveDate = textView;
        this.tvAuthor = textView2;
        this.tvBookname = themeTextView;
        this.tvUrlOrChapter = textView3;
    }

    @NonNull
    public static ArchiveListItemBinding bind(@NonNull View view) {
        int i10 = R.id.iv_cover;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i10);
        if (imageView != null) {
            i10 = R.id.iv_popup_hint;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i10);
            if (imageView2 != null) {
                i10 = R.id.tv_archive_date;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i10);
                if (textView != null) {
                    i10 = R.id.tv_author;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i10);
                    if (textView2 != null) {
                        i10 = R.id.tv_bookname;
                        ThemeTextView themeTextView = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                        if (themeTextView != null) {
                            i10 = R.id.tv_url_or_chapter;
                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i10);
                            if (textView3 != null) {
                                return new ArchiveListItemBinding((ThemeLinearLayout) view, imageView, imageView2, textView, textView2, themeTextView, textView3);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static ArchiveListItemBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ArchiveListItemBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.archive_list_item, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public ThemeLinearLayout getRoot() {
        return this.rootView;
    }
}
