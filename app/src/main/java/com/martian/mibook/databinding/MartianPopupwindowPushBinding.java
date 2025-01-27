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
public final class MartianPopupwindowPushBinding implements ViewBinding {

    @NonNull
    public final ImageView rdClose;

    @NonNull
    private final RelativeLayout rootView;

    @NonNull
    public final ImageView rulesBg;

    @NonNull
    public final TextView rulesButton;

    private MartianPopupwindowPushBinding(@NonNull RelativeLayout relativeLayout, @NonNull ImageView imageView, @NonNull ImageView imageView2, @NonNull TextView textView) {
        this.rootView = relativeLayout;
        this.rdClose = imageView;
        this.rulesBg = imageView2;
        this.rulesButton = textView;
    }

    @NonNull
    public static MartianPopupwindowPushBinding bind(@NonNull View view) {
        int i10 = R.id.rd_close;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i10);
        if (imageView != null) {
            i10 = R.id.rules_bg;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i10);
            if (imageView2 != null) {
                i10 = R.id.rules_button;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i10);
                if (textView != null) {
                    return new MartianPopupwindowPushBinding((RelativeLayout) view, imageView, imageView2, textView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static MartianPopupwindowPushBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static MartianPopupwindowPushBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.martian_popupwindow_push, viewGroup, false);
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
