package com.martian.mibook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.mibook.R;
import com.martian.mibook.mvvm.read.widget.ReaderCircularContainerView;

/* loaded from: classes3.dex */
public final class ReadingThemeViewBinding implements ViewBinding {

    @NonNull
    public final ReaderCircularContainerView circularContainer;

    @NonNull
    private final ReaderCircularContainerView rootView;

    @NonNull
    public final TextView tvThemeViewText;

    private ReadingThemeViewBinding(@NonNull ReaderCircularContainerView readerCircularContainerView, @NonNull ReaderCircularContainerView readerCircularContainerView2, @NonNull TextView textView) {
        this.rootView = readerCircularContainerView;
        this.circularContainer = readerCircularContainerView2;
        this.tvThemeViewText = textView;
    }

    @NonNull
    public static ReadingThemeViewBinding bind(@NonNull View view) {
        ReaderCircularContainerView readerCircularContainerView = (ReaderCircularContainerView) view;
        int i10 = R.id.tv_theme_view_text;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i10);
        if (textView != null) {
            return new ReadingThemeViewBinding(readerCircularContainerView, readerCircularContainerView, textView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static ReadingThemeViewBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ReadingThemeViewBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.reading_theme_view, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public ReaderCircularContainerView getRoot() {
        return this.rootView;
    }
}
