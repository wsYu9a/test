package com.martian.mibook.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public final class x implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final ScrollView f12909a;

    /* renamed from: b */
    @NonNull
    public final ThemeTextView f12910b;

    private x(@NonNull ScrollView rootView, @NonNull ThemeTextView textId1) {
        this.f12909a = rootView;
        this.f12910b = textId1;
    }

    @NonNull
    public static x a(@NonNull View rootView) {
        ThemeTextView themeTextView = (ThemeTextView) rootView.findViewById(R.id.text_id_1);
        if (themeTextView != null) {
            return new x((ScrollView) rootView, themeTextView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(R.id.text_id_1)));
    }

    @NonNull
    public static x c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static x d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.activity_text_test, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public ScrollView getRoot() {
        return this.f12909a;
    }
}
