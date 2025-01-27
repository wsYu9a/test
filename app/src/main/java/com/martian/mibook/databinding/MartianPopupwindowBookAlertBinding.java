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
public final class MartianPopupwindowBookAlertBinding implements ViewBinding {

    @NonNull
    public final ImageView baBg;

    @NonNull
    public final TextView baButton;

    @NonNull
    public final ImageView baClose;

    @NonNull
    public final TextView baTitle1;

    @NonNull
    public final TextView baTitle2;

    @NonNull
    private final RelativeLayout rootView;

    private MartianPopupwindowBookAlertBinding(@NonNull RelativeLayout relativeLayout, @NonNull ImageView imageView, @NonNull TextView textView, @NonNull ImageView imageView2, @NonNull TextView textView2, @NonNull TextView textView3) {
        this.rootView = relativeLayout;
        this.baBg = imageView;
        this.baButton = textView;
        this.baClose = imageView2;
        this.baTitle1 = textView2;
        this.baTitle2 = textView3;
    }

    @NonNull
    public static MartianPopupwindowBookAlertBinding bind(@NonNull View view) {
        int i10 = R.id.ba_bg;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i10);
        if (imageView != null) {
            i10 = R.id.ba_button;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i10);
            if (textView != null) {
                i10 = R.id.ba_close;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i10);
                if (imageView2 != null) {
                    i10 = R.id.ba_title1;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i10);
                    if (textView2 != null) {
                        i10 = R.id.ba_title2;
                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i10);
                        if (textView3 != null) {
                            return new MartianPopupwindowBookAlertBinding((RelativeLayout) view, imageView, textView, imageView2, textView2, textView3);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static MartianPopupwindowBookAlertBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static MartianPopupwindowBookAlertBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.martian_popupwindow_book_alert, viewGroup, false);
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
