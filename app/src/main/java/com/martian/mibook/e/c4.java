package com.martian.mibook.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.martian.apptask.widget.CountdownNumberTextView;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public final class c4 implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final RelativeLayout f11792a;

    /* renamed from: b */
    @NonNull
    public final ImageView f11793b;

    /* renamed from: c */
    @NonNull
    public final ImageView f11794c;

    /* renamed from: d */
    @Nullable
    public final CountdownNumberTextView f11795d;

    /* renamed from: e */
    @NonNull
    public final ThemeTextView f11796e;

    /* renamed from: f */
    @NonNull
    public final TextView f11797f;

    /* renamed from: g */
    @NonNull
    public final TextView f11798g;

    /* renamed from: h */
    @NonNull
    public final TextView f11799h;

    /* renamed from: i */
    @NonNull
    public final TextView f11800i;

    private c4(@NonNull RelativeLayout rootView, @NonNull ImageView bonusBg, @NonNull ImageView bonusClose, @Nullable CountdownNumberTextView bonusCountdown, @NonNull ThemeTextView bonusGrab, @NonNull TextView bonusHint, @NonNull TextView bonusNum, @NonNull TextView bonusTitle, @NonNull TextView bonusUnit) {
        this.f11792a = rootView;
        this.f11793b = bonusBg;
        this.f11794c = bonusClose;
        this.f11795d = bonusCountdown;
        this.f11796e = bonusGrab;
        this.f11797f = bonusHint;
        this.f11798g = bonusNum;
        this.f11799h = bonusTitle;
        this.f11800i = bonusUnit;
    }

    @NonNull
    public static c4 a(@NonNull View rootView) {
        int i2 = R.id.bonus_bg;
        ImageView imageView = (ImageView) rootView.findViewById(R.id.bonus_bg);
        if (imageView != null) {
            i2 = R.id.bonus_close;
            ImageView imageView2 = (ImageView) rootView.findViewById(R.id.bonus_close);
            if (imageView2 != null) {
                CountdownNumberTextView countdownNumberTextView = (CountdownNumberTextView) rootView.findViewById(R.id.bonus_countdown);
                i2 = R.id.bonus_grab;
                ThemeTextView themeTextView = (ThemeTextView) rootView.findViewById(R.id.bonus_grab);
                if (themeTextView != null) {
                    i2 = R.id.bonus_hint;
                    TextView textView = (TextView) rootView.findViewById(R.id.bonus_hint);
                    if (textView != null) {
                        i2 = R.id.bonus_num;
                        TextView textView2 = (TextView) rootView.findViewById(R.id.bonus_num);
                        if (textView2 != null) {
                            i2 = R.id.bonus_title;
                            TextView textView3 = (TextView) rootView.findViewById(R.id.bonus_title);
                            if (textView3 != null) {
                                i2 = R.id.bonus_unit;
                                TextView textView4 = (TextView) rootView.findViewById(R.id.bonus_unit);
                                if (textView4 != null) {
                                    return new c4((RelativeLayout) rootView, imageView, imageView2, countdownNumberTextView, themeTextView, textView, textView2, textView3, textView4);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i2)));
    }

    @NonNull
    public static c4 c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static c4 d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.martian_popupwindow_author, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f11792a;
    }
}
