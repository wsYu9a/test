package com.martian.mibook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.libmars.ui.theme.ThemeView;
import com.martian.mibook.R;

/* loaded from: classes3.dex */
public final class ItemBookrackMissionBinding implements ViewBinding {

    @NonNull
    public final ImageView brMissionCover;

    @NonNull
    public final ThemeTextView brMissionDesc;

    @NonNull
    public final ImageView brMissionHot;

    @NonNull
    public final ThemeView brMissionShadowView;

    @NonNull
    public final ThemeTextView brMissionTitle;

    @NonNull
    public final LinearLayout brMissionView;

    @NonNull
    private final LinearLayout rootView;

    private ItemBookrackMissionBinding(@NonNull LinearLayout linearLayout, @NonNull ImageView imageView, @NonNull ThemeTextView themeTextView, @NonNull ImageView imageView2, @NonNull ThemeView themeView, @NonNull ThemeTextView themeTextView2, @NonNull LinearLayout linearLayout2) {
        this.rootView = linearLayout;
        this.brMissionCover = imageView;
        this.brMissionDesc = themeTextView;
        this.brMissionHot = imageView2;
        this.brMissionShadowView = themeView;
        this.brMissionTitle = themeTextView2;
        this.brMissionView = linearLayout2;
    }

    @NonNull
    public static ItemBookrackMissionBinding bind(@NonNull View view) {
        int i10 = R.id.br_mission_cover;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i10);
        if (imageView != null) {
            i10 = R.id.br_mission_desc;
            ThemeTextView themeTextView = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
            if (themeTextView != null) {
                i10 = R.id.br_mission_hot;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i10);
                if (imageView2 != null) {
                    i10 = R.id.br_mission_shadow_view;
                    ThemeView themeView = (ThemeView) ViewBindings.findChildViewById(view, i10);
                    if (themeView != null) {
                        i10 = R.id.br_mission_title;
                        ThemeTextView themeTextView2 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                        if (themeTextView2 != null) {
                            LinearLayout linearLayout = (LinearLayout) view;
                            return new ItemBookrackMissionBinding(linearLayout, imageView, themeTextView, imageView2, themeView, themeTextView2, linearLayout);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static ItemBookrackMissionBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ItemBookrackMissionBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.item_bookrack_mission, viewGroup, false);
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
