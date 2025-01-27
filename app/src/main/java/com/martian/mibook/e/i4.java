package com.martian.mibook.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.mibook.ui.IntervalCountdownTextView;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public final class i4 implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final LinearLayout f12116a;

    /* renamed from: b */
    @NonNull
    public final ImageView f12117b;

    /* renamed from: c */
    @NonNull
    public final LinearLayout f12118c;

    /* renamed from: d */
    @NonNull
    public final ThemeTextView f12119d;

    /* renamed from: e */
    @NonNull
    public final ThemeTextView f12120e;

    /* renamed from: f */
    @NonNull
    public final TextView f12121f;

    /* renamed from: g */
    @NonNull
    public final ImageView f12122g;

    /* renamed from: h */
    @NonNull
    public final IntervalCountdownTextView f12123h;

    /* renamed from: i */
    @NonNull
    public final ThemeTextView f12124i;

    /* renamed from: j */
    @NonNull
    public final LinearLayout f12125j;

    private i4(@NonNull LinearLayout rootView, @NonNull ImageView mcBonusTag, @NonNull LinearLayout mcBonusTagView, @NonNull ThemeTextView mcItemButton, @NonNull ThemeTextView mcItemHintDesc, @NonNull TextView mcItemHintGrab, @NonNull ImageView mcItemIcon, @NonNull IntervalCountdownTextView mcItemIntervalCountdown, @NonNull ThemeTextView mcItemTitle, @NonNull LinearLayout mcItemView) {
        this.f12116a = rootView;
        this.f12117b = mcBonusTag;
        this.f12118c = mcBonusTagView;
        this.f12119d = mcItemButton;
        this.f12120e = mcItemHintDesc;
        this.f12121f = mcItemHintGrab;
        this.f12122g = mcItemIcon;
        this.f12123h = mcItemIntervalCountdown;
        this.f12124i = mcItemTitle;
        this.f12125j = mcItemView;
    }

    @NonNull
    public static i4 a(@NonNull View rootView) {
        int i2 = R.id.mc_bonus_tag;
        ImageView imageView = (ImageView) rootView.findViewById(R.id.mc_bonus_tag);
        if (imageView != null) {
            i2 = R.id.mc_bonus_tag_view;
            LinearLayout linearLayout = (LinearLayout) rootView.findViewById(R.id.mc_bonus_tag_view);
            if (linearLayout != null) {
                i2 = R.id.mc_item_button;
                ThemeTextView themeTextView = (ThemeTextView) rootView.findViewById(R.id.mc_item_button);
                if (themeTextView != null) {
                    i2 = R.id.mc_item_hint_desc;
                    ThemeTextView themeTextView2 = (ThemeTextView) rootView.findViewById(R.id.mc_item_hint_desc);
                    if (themeTextView2 != null) {
                        i2 = R.id.mc_item_hint_grab;
                        TextView textView = (TextView) rootView.findViewById(R.id.mc_item_hint_grab);
                        if (textView != null) {
                            i2 = R.id.mc_item_icon;
                            ImageView imageView2 = (ImageView) rootView.findViewById(R.id.mc_item_icon);
                            if (imageView2 != null) {
                                i2 = R.id.mc_item_interval_countdown;
                                IntervalCountdownTextView intervalCountdownTextView = (IntervalCountdownTextView) rootView.findViewById(R.id.mc_item_interval_countdown);
                                if (intervalCountdownTextView != null) {
                                    i2 = R.id.mc_item_title;
                                    ThemeTextView themeTextView3 = (ThemeTextView) rootView.findViewById(R.id.mc_item_title);
                                    if (themeTextView3 != null) {
                                        i2 = R.id.mc_item_view;
                                        LinearLayout linearLayout2 = (LinearLayout) rootView.findViewById(R.id.mc_item_view);
                                        if (linearLayout2 != null) {
                                            return new i4((LinearLayout) rootView, imageView, linearLayout, themeTextView, themeTextView2, textView, imageView2, intervalCountdownTextView, themeTextView3, linearLayout2);
                                        }
                                    }
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
    public static i4 c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static i4 d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.mission_item, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public LinearLayout getRoot() {
        return this.f12116a;
    }
}
