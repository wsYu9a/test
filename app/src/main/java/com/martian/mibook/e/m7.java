package com.martian.mibook.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.martian.libmars.ui.theme.ThemeImageView;
import com.martian.libmars.ui.theme.ThemeLinearLayout;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public final class m7 implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final ThemeLinearLayout f12383a;

    /* renamed from: b */
    @NonNull
    public final ThemeTextView f12384b;

    /* renamed from: c */
    @NonNull
    public final ThemeImageView f12385c;

    /* renamed from: d */
    @NonNull
    public final ThemeTextView f12386d;

    /* renamed from: e */
    @NonNull
    public final ThemeLinearLayout f12387e;

    private m7(@NonNull ThemeLinearLayout rootView, @NonNull ThemeTextView gameBtn, @NonNull ThemeImageView gameIcon, @NonNull ThemeTextView gameTitle, @NonNull ThemeLinearLayout gameView) {
        this.f12383a = rootView;
        this.f12384b = gameBtn;
        this.f12385c = gameIcon;
        this.f12386d = gameTitle;
        this.f12387e = gameView;
    }

    @NonNull
    public static m7 a(@NonNull View rootView) {
        int i2 = R.id.game_btn;
        ThemeTextView themeTextView = (ThemeTextView) rootView.findViewById(R.id.game_btn);
        if (themeTextView != null) {
            i2 = R.id.game_icon;
            ThemeImageView themeImageView = (ThemeImageView) rootView.findViewById(R.id.game_icon);
            if (themeImageView != null) {
                i2 = R.id.game_title;
                ThemeTextView themeTextView2 = (ThemeTextView) rootView.findViewById(R.id.game_title);
                if (themeTextView2 != null) {
                    ThemeLinearLayout themeLinearLayout = (ThemeLinearLayout) rootView;
                    return new m7(themeLinearLayout, themeTextView, themeImageView, themeTextView2, themeLinearLayout);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i2)));
    }

    @NonNull
    public static m7 c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static m7 d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.xianwan_game_ads_item, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public ThemeLinearLayout getRoot() {
        return this.f12383a;
    }
}
