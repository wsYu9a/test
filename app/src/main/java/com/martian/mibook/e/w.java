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
import com.martian.libmars.ui.theme.ThemeRelativeLayout;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public final class w implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final ThemeRelativeLayout f12851a;

    /* renamed from: b */
    @NonNull
    public final TextView f12852b;

    /* renamed from: c */
    @NonNull
    public final ImageView f12853c;

    /* renamed from: d */
    @NonNull
    public final TextView f12854d;

    /* renamed from: e */
    @NonNull
    public final LinearLayout f12855e;

    private w(@NonNull ThemeRelativeLayout rootView, @NonNull TextView intimateCivilization, @NonNull ImageView intimateIcon, @NonNull TextView intimateLink, @NonNull LinearLayout privacyIntimate) {
        this.f12851a = rootView;
        this.f12852b = intimateCivilization;
        this.f12853c = intimateIcon;
        this.f12854d = intimateLink;
        this.f12855e = privacyIntimate;
    }

    @NonNull
    public static w a(@NonNull View rootView) {
        int i2 = R.id.intimate_civilization;
        TextView textView = (TextView) rootView.findViewById(R.id.intimate_civilization);
        if (textView != null) {
            i2 = R.id.intimate_icon;
            ImageView imageView = (ImageView) rootView.findViewById(R.id.intimate_icon);
            if (imageView != null) {
                i2 = R.id.intimate_link;
                TextView textView2 = (TextView) rootView.findViewById(R.id.intimate_link);
                if (textView2 != null) {
                    i2 = R.id.privacy_intimate;
                    LinearLayout linearLayout = (LinearLayout) rootView.findViewById(R.id.privacy_intimate);
                    if (linearLayout != null) {
                        return new w((ThemeRelativeLayout) rootView, textView, imageView, textView2, linearLayout);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i2)));
    }

    @NonNull
    public static w c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static w d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.activity_teenager_guide, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public ThemeRelativeLayout getRoot() {
        return this.f12851a;
    }
}
