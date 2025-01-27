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
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public final class o0 implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final LinearLayout f12452a;

    /* renamed from: b */
    @NonNull
    public final LinearLayout f12453b;

    /* renamed from: c */
    @NonNull
    public final ThemeTextView f12454c;

    /* renamed from: d */
    @NonNull
    public final TextView f12455d;

    /* renamed from: e */
    @NonNull
    public final ImageView f12456e;

    private o0(@NonNull LinearLayout rootView, @NonNull LinearLayout bonusItemBg, @NonNull ThemeTextView bonusSignItemDay, @NonNull TextView bonusSignItemStatus, @NonNull ImageView bonusSignLogo) {
        this.f12452a = rootView;
        this.f12453b = bonusItemBg;
        this.f12454c = bonusSignItemDay;
        this.f12455d = bonusSignItemStatus;
        this.f12456e = bonusSignLogo;
    }

    @NonNull
    public static o0 a(@NonNull View rootView) {
        int i2 = R.id.bonus_item_bg;
        LinearLayout linearLayout = (LinearLayout) rootView.findViewById(R.id.bonus_item_bg);
        if (linearLayout != null) {
            i2 = R.id.bonus_sign_item_day;
            ThemeTextView themeTextView = (ThemeTextView) rootView.findViewById(R.id.bonus_sign_item_day);
            if (themeTextView != null) {
                i2 = R.id.bonus_sign_item_status;
                TextView textView = (TextView) rootView.findViewById(R.id.bonus_sign_item_status);
                if (textView != null) {
                    i2 = R.id.bonus_sign_logo;
                    ImageView imageView = (ImageView) rootView.findViewById(R.id.bonus_sign_logo);
                    if (imageView != null) {
                        return new o0((LinearLayout) rootView, linearLayout, themeTextView, textView, imageView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i2)));
    }

    @NonNull
    public static o0 c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static o0 d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.bonus_sign_item, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public LinearLayout getRoot() {
        return this.f12452a;
    }
}
