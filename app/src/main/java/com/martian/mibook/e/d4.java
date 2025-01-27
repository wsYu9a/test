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
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public final class d4 implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final RelativeLayout f11842a;

    /* renamed from: b */
    @NonNull
    public final ImageView f11843b;

    /* renamed from: c */
    @NonNull
    public final TextView f11844c;

    /* renamed from: d */
    @NonNull
    public final ImageView f11845d;

    /* renamed from: e */
    @NonNull
    public final TextView f11846e;

    /* renamed from: f */
    @NonNull
    public final TextView f11847f;

    private d4(@NonNull RelativeLayout rootView, @NonNull ImageView baBg, @NonNull TextView baButton, @NonNull ImageView baClose, @NonNull TextView baTitle1, @NonNull TextView baTitle2) {
        this.f11842a = rootView;
        this.f11843b = baBg;
        this.f11844c = baButton;
        this.f11845d = baClose;
        this.f11846e = baTitle1;
        this.f11847f = baTitle2;
    }

    @NonNull
    public static d4 a(@NonNull View rootView) {
        int i2 = R.id.ba_bg;
        ImageView imageView = (ImageView) rootView.findViewById(R.id.ba_bg);
        if (imageView != null) {
            i2 = R.id.ba_button;
            TextView textView = (TextView) rootView.findViewById(R.id.ba_button);
            if (textView != null) {
                i2 = R.id.ba_close;
                ImageView imageView2 = (ImageView) rootView.findViewById(R.id.ba_close);
                if (imageView2 != null) {
                    i2 = R.id.ba_title1;
                    TextView textView2 = (TextView) rootView.findViewById(R.id.ba_title1);
                    if (textView2 != null) {
                        i2 = R.id.ba_title2;
                        TextView textView3 = (TextView) rootView.findViewById(R.id.ba_title2);
                        if (textView3 != null) {
                            return new d4((RelativeLayout) rootView, imageView, textView, imageView2, textView2, textView3);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i2)));
    }

    @NonNull
    public static d4 c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static d4 d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.martian_popupwindow_book_alert, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f11842a;
    }
}
