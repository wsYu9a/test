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
import com.martian.apptask.widget.CountdownNumberTextView;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.mibook.R;

/* loaded from: classes3.dex */
public final class MartianPopupwindowAuthorBinding implements ViewBinding {

    @NonNull
    public final ImageView bonusBg;

    @NonNull
    public final ImageView bonusClose;

    @Nullable
    public final CountdownNumberTextView bonusCountdown;

    @NonNull
    public final ThemeTextView bonusGrab;

    @NonNull
    public final TextView bonusHint;

    @NonNull
    public final TextView bonusNum;

    @NonNull
    public final TextView bonusTitle;

    @NonNull
    public final TextView bonusUnit;

    @NonNull
    private final RelativeLayout rootView;

    private MartianPopupwindowAuthorBinding(@NonNull RelativeLayout relativeLayout, @NonNull ImageView imageView, @NonNull ImageView imageView2, @Nullable CountdownNumberTextView countdownNumberTextView, @NonNull ThemeTextView themeTextView, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull TextView textView4) {
        this.rootView = relativeLayout;
        this.bonusBg = imageView;
        this.bonusClose = imageView2;
        this.bonusCountdown = countdownNumberTextView;
        this.bonusGrab = themeTextView;
        this.bonusHint = textView;
        this.bonusNum = textView2;
        this.bonusTitle = textView3;
        this.bonusUnit = textView4;
    }

    @NonNull
    public static MartianPopupwindowAuthorBinding bind(@NonNull View view) {
        int i10 = R.id.bonus_bg;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i10);
        if (imageView != null) {
            i10 = R.id.bonus_close;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i10);
            if (imageView2 != null) {
                CountdownNumberTextView countdownNumberTextView = (CountdownNumberTextView) ViewBindings.findChildViewById(view, R.id.bonus_countdown);
                i10 = R.id.bonus_grab;
                ThemeTextView themeTextView = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                if (themeTextView != null) {
                    i10 = R.id.bonus_hint;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, i10);
                    if (textView != null) {
                        i10 = R.id.bonus_num;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i10);
                        if (textView2 != null) {
                            i10 = R.id.bonus_title;
                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i10);
                            if (textView3 != null) {
                                i10 = R.id.bonus_unit;
                                TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i10);
                                if (textView4 != null) {
                                    return new MartianPopupwindowAuthorBinding((RelativeLayout) view, imageView, imageView2, countdownNumberTextView, themeTextView, textView, textView2, textView3, textView4);
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
    public static MartianPopupwindowAuthorBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static MartianPopupwindowAuthorBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.martian_popupwindow_author, viewGroup, false);
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
