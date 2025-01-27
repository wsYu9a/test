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
public final class PopupwindowFreshgrabedBackgroundBinding implements ViewBinding {

    @NonNull
    public final ImageView bgFresh;

    @NonNull
    public final TextView grabMoney;

    @NonNull
    public final ImageView rdClose;

    @NonNull
    public final ImageView rdGrab;

    @NonNull
    public final TextView rdHint;

    @NonNull
    public final TextView rdTitle;

    @NonNull
    private final RelativeLayout rootView;

    private PopupwindowFreshgrabedBackgroundBinding(@NonNull RelativeLayout relativeLayout, @NonNull ImageView imageView, @NonNull TextView textView, @NonNull ImageView imageView2, @NonNull ImageView imageView3, @NonNull TextView textView2, @NonNull TextView textView3) {
        this.rootView = relativeLayout;
        this.bgFresh = imageView;
        this.grabMoney = textView;
        this.rdClose = imageView2;
        this.rdGrab = imageView3;
        this.rdHint = textView2;
        this.rdTitle = textView3;
    }

    @NonNull
    public static PopupwindowFreshgrabedBackgroundBinding bind(@NonNull View view) {
        int i10 = R.id.bg_fresh;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i10);
        if (imageView != null) {
            i10 = R.id.grab_money;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i10);
            if (textView != null) {
                i10 = R.id.rd_close;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i10);
                if (imageView2 != null) {
                    i10 = R.id.rd_grab;
                    ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i10);
                    if (imageView3 != null) {
                        i10 = R.id.rd_hint;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i10);
                        if (textView2 != null) {
                            i10 = R.id.rd_title;
                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i10);
                            if (textView3 != null) {
                                return new PopupwindowFreshgrabedBackgroundBinding((RelativeLayout) view, imageView, textView, imageView2, imageView3, textView2, textView3);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static PopupwindowFreshgrabedBackgroundBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static PopupwindowFreshgrabedBackgroundBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.popupwindow_freshgrabed_background, viewGroup, false);
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
