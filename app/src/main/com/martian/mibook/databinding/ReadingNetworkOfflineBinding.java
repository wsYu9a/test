package com.martian.mibook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.mibook.R;
import com.martian.mibook.ui.reader.ReaderThemeRelativeLayout;

/* loaded from: classes3.dex */
public final class ReadingNetworkOfflineBinding implements ViewBinding {

    @NonNull
    public final ImageView ivNativeCloseIcon;

    @NonNull
    private final ReaderThemeRelativeLayout rootView;

    @NonNull
    public final TextView tvNetworkOffline;

    private ReadingNetworkOfflineBinding(@NonNull ReaderThemeRelativeLayout readerThemeRelativeLayout, @NonNull ImageView imageView, @NonNull TextView textView) {
        this.rootView = readerThemeRelativeLayout;
        this.ivNativeCloseIcon = imageView;
        this.tvNetworkOffline = textView;
    }

    @NonNull
    public static ReadingNetworkOfflineBinding bind(@NonNull View view) {
        int i10 = R.id.iv_native_close_icon;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i10);
        if (imageView != null) {
            i10 = R.id.tv_network_offline;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i10);
            if (textView != null) {
                return new ReadingNetworkOfflineBinding((ReaderThemeRelativeLayout) view, imageView, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static ReadingNetworkOfflineBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ReadingNetworkOfflineBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.reading_network_offline, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public ReaderThemeRelativeLayout getRoot() {
        return this.rootView;
    }
}
