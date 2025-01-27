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
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.libmars.widget.RoundedLayout;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public final class i7 implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final RelativeLayout f12142a;

    /* renamed from: b */
    @NonNull
    public final RoundedLayout f12143b;

    /* renamed from: c */
    @NonNull
    public final ImageView f12144c;

    /* renamed from: d */
    @NonNull
    public final ThemeTextView f12145d;

    /* renamed from: e */
    @NonNull
    public final ThemeTextView f12146e;

    /* renamed from: f */
    @NonNull
    public final RelativeLayout f12147f;

    /* renamed from: g */
    @NonNull
    public final TextView f12148g;

    private i7(@NonNull RelativeLayout rootView, @NonNull RoundedLayout updateHome, @NonNull ImageView upgradeClose, @NonNull ThemeTextView upgradeConfirm, @NonNull ThemeTextView upgradeFeature, @NonNull RelativeLayout upgradeHeader, @NonNull TextView upgradeName) {
        this.f12142a = rootView;
        this.f12143b = updateHome;
        this.f12144c = upgradeClose;
        this.f12145d = upgradeConfirm;
        this.f12146e = upgradeFeature;
        this.f12147f = upgradeHeader;
        this.f12148g = upgradeName;
    }

    @NonNull
    public static i7 a(@NonNull View rootView) {
        int i2 = R.id.update_home;
        RoundedLayout roundedLayout = (RoundedLayout) rootView.findViewById(R.id.update_home);
        if (roundedLayout != null) {
            i2 = R.id.upgrade_close;
            ImageView imageView = (ImageView) rootView.findViewById(R.id.upgrade_close);
            if (imageView != null) {
                i2 = R.id.upgrade_confirm;
                ThemeTextView themeTextView = (ThemeTextView) rootView.findViewById(R.id.upgrade_confirm);
                if (themeTextView != null) {
                    i2 = R.id.upgrade_feature;
                    ThemeTextView themeTextView2 = (ThemeTextView) rootView.findViewById(R.id.upgrade_feature);
                    if (themeTextView2 != null) {
                        i2 = R.id.upgrade_header;
                        RelativeLayout relativeLayout = (RelativeLayout) rootView.findViewById(R.id.upgrade_header);
                        if (relativeLayout != null) {
                            i2 = R.id.upgrade_name;
                            TextView textView = (TextView) rootView.findViewById(R.id.upgrade_name);
                            if (textView != null) {
                                return new i7((RelativeLayout) rootView, roundedLayout, imageView, themeTextView, themeTextView2, relativeLayout, textView);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i2)));
    }

    @NonNull
    public static i7 c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static i7 d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.upgrade_dialog, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f12142a;
    }
}
