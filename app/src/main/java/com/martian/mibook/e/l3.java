package com.martian.mibook.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.libmars.ui.theme.ThemeView;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public final class l3 implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final LinearLayout f12289a;

    /* renamed from: b */
    @NonNull
    public final ImageView f12290b;

    /* renamed from: c */
    @NonNull
    public final ThemeTextView f12291c;

    /* renamed from: d */
    @NonNull
    public final ImageView f12292d;

    /* renamed from: e */
    @NonNull
    public final ThemeView f12293e;

    /* renamed from: f */
    @NonNull
    public final ThemeTextView f12294f;

    /* renamed from: g */
    @NonNull
    public final LinearLayout f12295g;

    private l3(@NonNull LinearLayout rootView, @NonNull ImageView brMissionCover, @NonNull ThemeTextView brMissionDesc, @NonNull ImageView brMissionHot, @NonNull ThemeView brMissionShadowView, @NonNull ThemeTextView brMissionTitle, @NonNull LinearLayout brMissionView) {
        this.f12289a = rootView;
        this.f12290b = brMissionCover;
        this.f12291c = brMissionDesc;
        this.f12292d = brMissionHot;
        this.f12293e = brMissionShadowView;
        this.f12294f = brMissionTitle;
        this.f12295g = brMissionView;
    }

    @NonNull
    public static l3 a(@NonNull View rootView) {
        int i2 = R.id.br_mission_cover;
        ImageView imageView = (ImageView) rootView.findViewById(R.id.br_mission_cover);
        if (imageView != null) {
            i2 = R.id.br_mission_desc;
            ThemeTextView themeTextView = (ThemeTextView) rootView.findViewById(R.id.br_mission_desc);
            if (themeTextView != null) {
                i2 = R.id.br_mission_hot;
                ImageView imageView2 = (ImageView) rootView.findViewById(R.id.br_mission_hot);
                if (imageView2 != null) {
                    i2 = R.id.br_mission_shadow_view;
                    ThemeView themeView = (ThemeView) rootView.findViewById(R.id.br_mission_shadow_view);
                    if (themeView != null) {
                        i2 = R.id.br_mission_title;
                        ThemeTextView themeTextView2 = (ThemeTextView) rootView.findViewById(R.id.br_mission_title);
                        if (themeTextView2 != null) {
                            LinearLayout linearLayout = (LinearLayout) rootView;
                            return new l3(linearLayout, imageView, themeTextView, imageView2, themeView, themeTextView2, linearLayout);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i2)));
    }

    @NonNull
    public static l3 c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static l3 d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.item_bookrack_mission, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public LinearLayout getRoot() {
        return this.f12289a;
    }
}
