package com.martian.mibook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.mibook.R;

/* loaded from: classes3.dex */
public final class MartianPopupwindowBookPromoteBinding implements ViewBinding {

    @NonNull
    public final TextView bookPromoteAuthor;

    @NonNull
    public final ImageView bookPromoteClose;

    @NonNull
    public final ImageView bookPromoteCover;

    @NonNull
    public final ImageView bookPromoteCoverBg;

    @NonNull
    public final TextView bookPromoteFreeTag;

    @NonNull
    public final TextView bookPromoteName;

    @NonNull
    public final TextView bookPromoteTip;

    @NonNull
    public final RelativeLayout bookPromoteView;

    @NonNull
    private final RelativeLayout rootView;

    private MartianPopupwindowBookPromoteBinding(@NonNull RelativeLayout relativeLayout, @NonNull TextView textView, @NonNull ImageView imageView, @NonNull ImageView imageView2, @NonNull ImageView imageView3, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull TextView textView4, @NonNull RelativeLayout relativeLayout2) {
        this.rootView = relativeLayout;
        this.bookPromoteAuthor = textView;
        this.bookPromoteClose = imageView;
        this.bookPromoteCover = imageView2;
        this.bookPromoteCoverBg = imageView3;
        this.bookPromoteFreeTag = textView2;
        this.bookPromoteName = textView3;
        this.bookPromoteTip = textView4;
        this.bookPromoteView = relativeLayout2;
    }

    @NonNull
    public static MartianPopupwindowBookPromoteBinding bind(@NonNull View view) {
        int i10 = R.id.book_promote_author;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i10);
        if (textView != null) {
            i10 = R.id.book_promote_close;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i10);
            if (imageView != null) {
                i10 = R.id.book_promote_cover;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i10);
                if (imageView2 != null) {
                    i10 = R.id.book_promote_cover_bg;
                    ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i10);
                    if (imageView3 != null) {
                        i10 = R.id.book_promote_free_tag;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i10);
                        if (textView2 != null) {
                            i10 = R.id.book_promote_name;
                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i10);
                            if (textView3 != null) {
                                i10 = R.id.book_promote_tip;
                                TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i10);
                                if (textView4 != null) {
                                    i10 = R.id.book_promote_view;
                                    RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i10);
                                    if (relativeLayout != null) {
                                        return new MartianPopupwindowBookPromoteBinding((RelativeLayout) view, textView, imageView, imageView2, imageView3, textView2, textView3, textView4, relativeLayout);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static MartianPopupwindowBookPromoteBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static MartianPopupwindowBookPromoteBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.martian_popupwindow_book_promote, viewGroup, false);
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
