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
public final class MartianPopupwindowCheckinedBinding implements ViewBinding {

    @NonNull
    public final RelativeLayout checkinedBg;

    @NonNull
    public final ImageView checkinedClose;

    @NonNull
    public final TextView checkinedCoins;

    @NonNull
    public final TextView checkinedVideoBonus;

    @NonNull
    private final RelativeLayout rootView;

    private MartianPopupwindowCheckinedBinding(@NonNull RelativeLayout relativeLayout, @NonNull RelativeLayout relativeLayout2, @NonNull ImageView imageView, @NonNull TextView textView, @NonNull TextView textView2) {
        this.rootView = relativeLayout;
        this.checkinedBg = relativeLayout2;
        this.checkinedClose = imageView;
        this.checkinedCoins = textView;
        this.checkinedVideoBonus = textView2;
    }

    @NonNull
    public static MartianPopupwindowCheckinedBinding bind(@NonNull View view) {
        int i10 = R.id.checkined_bg;
        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i10);
        if (relativeLayout != null) {
            i10 = R.id.checkined_close;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i10);
            if (imageView != null) {
                i10 = R.id.checkined_coins;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i10);
                if (textView != null) {
                    i10 = R.id.checkined_video_bonus;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i10);
                    if (textView2 != null) {
                        return new MartianPopupwindowCheckinedBinding((RelativeLayout) view, relativeLayout, imageView, textView, textView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static MartianPopupwindowCheckinedBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static MartianPopupwindowCheckinedBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.martian_popupwindow_checkined, viewGroup, false);
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
