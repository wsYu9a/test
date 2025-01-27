package com.martian.mibook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.mibook.R;

/* loaded from: classes3.dex */
public final class ReadingFakeLayoutBinding implements ViewBinding {

    @NonNull
    public final ReadingContentLayoutBinding llReadingContent;

    @NonNull
    public final LinearLayout lyReadingBackground;

    @NonNull
    public final ReadingBottomStatusBinding lyReadingBottomStatus;

    @NonNull
    private final LinearLayout rootView;

    private ReadingFakeLayoutBinding(@NonNull LinearLayout linearLayout, @NonNull ReadingContentLayoutBinding readingContentLayoutBinding, @NonNull LinearLayout linearLayout2, @NonNull ReadingBottomStatusBinding readingBottomStatusBinding) {
        this.rootView = linearLayout;
        this.llReadingContent = readingContentLayoutBinding;
        this.lyReadingBackground = linearLayout2;
        this.lyReadingBottomStatus = readingBottomStatusBinding;
    }

    @NonNull
    public static ReadingFakeLayoutBinding bind(@NonNull View view) {
        int i10 = R.id.ll_reading_content;
        View findChildViewById = ViewBindings.findChildViewById(view, i10);
        if (findChildViewById != null) {
            ReadingContentLayoutBinding bind = ReadingContentLayoutBinding.bind(findChildViewById);
            LinearLayout linearLayout = (LinearLayout) view;
            int i11 = R.id.ly_reading_bottom_status;
            View findChildViewById2 = ViewBindings.findChildViewById(view, i11);
            if (findChildViewById2 != null) {
                return new ReadingFakeLayoutBinding(linearLayout, bind, linearLayout, ReadingBottomStatusBinding.bind(findChildViewById2));
            }
            i10 = i11;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static ReadingFakeLayoutBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ReadingFakeLayoutBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.reading_fake_layout, viewGroup, false);
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
