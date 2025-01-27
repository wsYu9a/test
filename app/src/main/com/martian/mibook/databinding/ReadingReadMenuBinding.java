package com.martian.mibook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.martian.mibook.R;
import com.martian.mibook.mvvm.read.widget.ReadMenu;

/* loaded from: classes3.dex */
public final class ReadingReadMenuBinding implements ViewBinding {

    @NonNull
    private final ReadMenu rootView;

    private ReadingReadMenuBinding(@NonNull ReadMenu readMenu) {
        this.rootView = readMenu;
    }

    @NonNull
    public static ReadingReadMenuBinding bind(@NonNull View view) {
        if (view != null) {
            return new ReadingReadMenuBinding((ReadMenu) view);
        }
        throw new NullPointerException("rootView");
    }

    @NonNull
    public static ReadingReadMenuBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ReadingReadMenuBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.reading_read_menu, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public ReadMenu getRoot() {
        return this.rootView;
    }
}
