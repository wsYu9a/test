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
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.mibook.R;
import com.martian.mibook.ui.IntervalCountdownTextView;

/* loaded from: classes3.dex */
public final class ItemMissionTaskBinding implements ViewBinding {

    @NonNull
    public final ImageView mcBonusTag;

    @NonNull
    public final LinearLayout mcBonusTagView;

    @NonNull
    public final ThemeTextView mcItemButton;

    @NonNull
    public final ThemeTextView mcItemHintDesc;

    @NonNull
    public final TextView mcItemHintGrab;

    @NonNull
    public final ImageView mcItemIcon;

    @NonNull
    public final IntervalCountdownTextView mcItemIntervalCountdown;

    @NonNull
    public final ThemeTextView mcItemTitle;

    @NonNull
    public final LinearLayout mcItemView;

    @NonNull
    private final LinearLayout rootView;

    private ItemMissionTaskBinding(@NonNull LinearLayout linearLayout, @NonNull ImageView imageView, @NonNull LinearLayout linearLayout2, @NonNull ThemeTextView themeTextView, @NonNull ThemeTextView themeTextView2, @NonNull TextView textView, @NonNull ImageView imageView2, @NonNull IntervalCountdownTextView intervalCountdownTextView, @NonNull ThemeTextView themeTextView3, @NonNull LinearLayout linearLayout3) {
        this.rootView = linearLayout;
        this.mcBonusTag = imageView;
        this.mcBonusTagView = linearLayout2;
        this.mcItemButton = themeTextView;
        this.mcItemHintDesc = themeTextView2;
        this.mcItemHintGrab = textView;
        this.mcItemIcon = imageView2;
        this.mcItemIntervalCountdown = intervalCountdownTextView;
        this.mcItemTitle = themeTextView3;
        this.mcItemView = linearLayout3;
    }

    @NonNull
    public static ItemMissionTaskBinding bind(@NonNull View view) {
        int i10 = R.id.mc_bonus_tag;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i10);
        if (imageView != null) {
            i10 = R.id.mc_bonus_tag_view;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i10);
            if (linearLayout != null) {
                i10 = R.id.mc_item_button;
                ThemeTextView themeTextView = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                if (themeTextView != null) {
                    i10 = R.id.mc_item_hint_desc;
                    ThemeTextView themeTextView2 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                    if (themeTextView2 != null) {
                        i10 = R.id.mc_item_hint_grab;
                        TextView textView = (TextView) ViewBindings.findChildViewById(view, i10);
                        if (textView != null) {
                            i10 = R.id.mc_item_icon;
                            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i10);
                            if (imageView2 != null) {
                                i10 = R.id.mc_item_interval_countdown;
                                IntervalCountdownTextView intervalCountdownTextView = (IntervalCountdownTextView) ViewBindings.findChildViewById(view, i10);
                                if (intervalCountdownTextView != null) {
                                    i10 = R.id.mc_item_title;
                                    ThemeTextView themeTextView3 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                                    if (themeTextView3 != null) {
                                        LinearLayout linearLayout2 = (LinearLayout) view;
                                        return new ItemMissionTaskBinding(linearLayout2, imageView, linearLayout, themeTextView, themeTextView2, textView, imageView2, intervalCountdownTextView, themeTextView3, linearLayout2);
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
    public static ItemMissionTaskBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ItemMissionTaskBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.item_mission_task, viewGroup, false);
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
