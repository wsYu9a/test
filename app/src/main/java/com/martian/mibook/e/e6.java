package com.martian.mibook.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.martian.mibook.ui.reader.ReaderThemeRelativeLayout;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public final class e6 implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final ReaderThemeRelativeLayout f11915a;

    /* renamed from: b */
    @NonNull
    public final ImageView f11916b;

    /* renamed from: c */
    @NonNull
    public final TextView f11917c;

    private e6(@NonNull ReaderThemeRelativeLayout rootView, @NonNull ImageView ivNativeCloseIcon, @NonNull TextView tvNetworkOffline) {
        this.f11915a = rootView;
        this.f11916b = ivNativeCloseIcon;
        this.f11917c = tvNetworkOffline;
    }

    @NonNull
    public static e6 a(@NonNull View rootView) {
        int i2 = R.id.iv_native_close_icon;
        ImageView imageView = (ImageView) rootView.findViewById(R.id.iv_native_close_icon);
        if (imageView != null) {
            i2 = R.id.tv_network_offline;
            TextView textView = (TextView) rootView.findViewById(R.id.tv_network_offline);
            if (textView != null) {
                return new e6((ReaderThemeRelativeLayout) rootView, imageView, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i2)));
    }

    @NonNull
    public static e6 c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static e6 d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.reading_network_offline, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public ReaderThemeRelativeLayout getRoot() {
        return this.f11915a;
    }
}
