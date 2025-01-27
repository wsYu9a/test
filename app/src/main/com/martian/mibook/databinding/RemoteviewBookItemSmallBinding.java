package com.martian.mibook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.mibook.R;

/* loaded from: classes3.dex */
public final class RemoteviewBookItemSmallBinding implements ViewBinding {

    @NonNull
    public final TextView remoteviewChapter;

    @NonNull
    public final TextView remoteviewContent;

    @NonNull
    public final ImageView remoteviewCover;

    @NonNull
    public final LinearLayout remoteviewMainView;

    @NonNull
    public final TextView remoteviewTitle;

    @NonNull
    private final LinearLayout rootView;

    private RemoteviewBookItemSmallBinding(@NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull TextView textView2, @NonNull ImageView imageView, @NonNull LinearLayout linearLayout2, @NonNull TextView textView3) {
        this.rootView = linearLayout;
        this.remoteviewChapter = textView;
        this.remoteviewContent = textView2;
        this.remoteviewCover = imageView;
        this.remoteviewMainView = linearLayout2;
        this.remoteviewTitle = textView3;
    }

    @NonNull
    public static RemoteviewBookItemSmallBinding bind(@NonNull View view) {
        int i10 = R.id.remoteview_chapter;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i10);
        if (textView != null) {
            i10 = R.id.remoteview_content;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i10);
            if (textView2 != null) {
                i10 = R.id.remoteview_cover;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i10);
                if (imageView != null) {
                    LinearLayout linearLayout = (LinearLayout) view;
                    i10 = R.id.remoteview_title;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i10);
                    if (textView3 != null) {
                        return new RemoteviewBookItemSmallBinding(linearLayout, textView, textView2, imageView, linearLayout, textView3);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static RemoteviewBookItemSmallBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static RemoteviewBookItemSmallBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.remoteview_book_item_small, viewGroup, false);
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
