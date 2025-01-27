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
import com.martian.libmars.ui.theme.ThemeLinearLayout;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public final class l4 implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final ThemeLinearLayout f12296a;

    /* renamed from: b */
    @NonNull
    public final LinearLayout f12297b;

    /* renamed from: c */
    @NonNull
    public final ImageView f12298c;

    /* renamed from: d */
    @NonNull
    public final TextView f12299d;

    /* renamed from: e */
    @NonNull
    public final LinearLayout f12300e;

    /* renamed from: f */
    @NonNull
    public final TextView f12301f;

    private l4(@NonNull ThemeLinearLayout rootView, @NonNull LinearLayout categoryHotView, @NonNull ImageView tvPageCover, @NonNull TextView tvPageDesc, @NonNull LinearLayout tvPageDescView, @NonNull TextView tvPageName) {
        this.f12296a = rootView;
        this.f12297b = categoryHotView;
        this.f12298c = tvPageCover;
        this.f12299d = tvPageDesc;
        this.f12300e = tvPageDescView;
        this.f12301f = tvPageName;
    }

    @NonNull
    public static l4 a(@NonNull View rootView) {
        int i2 = R.id.category_hot_view;
        LinearLayout linearLayout = (LinearLayout) rootView.findViewById(R.id.category_hot_view);
        if (linearLayout != null) {
            i2 = R.id.tv_page_cover;
            ImageView imageView = (ImageView) rootView.findViewById(R.id.tv_page_cover);
            if (imageView != null) {
                i2 = R.id.tv_page_desc;
                TextView textView = (TextView) rootView.findViewById(R.id.tv_page_desc);
                if (textView != null) {
                    i2 = R.id.tv_page_desc_view;
                    LinearLayout linearLayout2 = (LinearLayout) rootView.findViewById(R.id.tv_page_desc_view);
                    if (linearLayout2 != null) {
                        i2 = R.id.tv_page_name;
                        TextView textView2 = (TextView) rootView.findViewById(R.id.tv_page_name);
                        if (textView2 != null) {
                            return new l4((ThemeLinearLayout) rootView, linearLayout, imageView, textView, linearLayout2, textView2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i2)));
    }

    @NonNull
    public static l4 c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static l4 d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.page_item_classification_hot, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public ThemeLinearLayout getRoot() {
        return this.f12296a;
    }
}
