package com.martian.mibook.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.martian.mibook.ui.reader.ReaderRoundColorView;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public final class m6 implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final FrameLayout f12378a;

    /* renamed from: b */
    @NonNull
    public final ReaderRoundColorView f12379b;

    /* renamed from: c */
    @NonNull
    public final FrameLayout f12380c;

    /* renamed from: d */
    @NonNull
    public final LinearLayout f12381d;

    /* renamed from: e */
    @NonNull
    public final TextView f12382e;

    private m6(@NonNull FrameLayout rootView, @NonNull ReaderRoundColorView ccvCircle, @NonNull FrameLayout ccvThemeView, @NonNull LinearLayout llThemeCircle, @NonNull TextView tvThemeViewText) {
        this.f12378a = rootView;
        this.f12379b = ccvCircle;
        this.f12380c = ccvThemeView;
        this.f12381d = llThemeCircle;
        this.f12382e = tvThemeViewText;
    }

    @NonNull
    public static m6 a(@NonNull View rootView) {
        int i2 = R.id.ccv_circle;
        ReaderRoundColorView readerRoundColorView = (ReaderRoundColorView) rootView.findViewById(R.id.ccv_circle);
        if (readerRoundColorView != null) {
            FrameLayout frameLayout = (FrameLayout) rootView;
            i2 = R.id.ll_theme_circle;
            LinearLayout linearLayout = (LinearLayout) rootView.findViewById(R.id.ll_theme_circle);
            if (linearLayout != null) {
                i2 = R.id.tv_theme_view_text;
                TextView textView = (TextView) rootView.findViewById(R.id.tv_theme_view_text);
                if (textView != null) {
                    return new m6(frameLayout, readerRoundColorView, frameLayout, linearLayout, textView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i2)));
    }

    @NonNull
    public static m6 c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static m6 d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.reading_theme_view, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public FrameLayout getRoot() {
        return this.f12378a;
    }
}
