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
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public final class x6 implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final LinearLayout f12945a;

    /* renamed from: b */
    @NonNull
    public final ImageView f12946b;

    /* renamed from: c */
    @NonNull
    public final ThemeTextView f12947c;

    /* renamed from: d */
    @NonNull
    public final TextView f12948d;

    /* renamed from: e */
    @NonNull
    public final ThemeTextView f12949e;

    private x6(@NonNull LinearLayout rootView, @NonNull ImageView spItemRankCover, @NonNull ThemeTextView spItemRankDesc, @NonNull TextView spItemRankIndex, @NonNull ThemeTextView spItemRankName) {
        this.f12945a = rootView;
        this.f12946b = spItemRankCover;
        this.f12947c = spItemRankDesc;
        this.f12948d = spItemRankIndex;
        this.f12949e = spItemRankName;
    }

    @NonNull
    public static x6 a(@NonNull View rootView) {
        int i2 = R.id.sp_item_rank_cover;
        ImageView imageView = (ImageView) rootView.findViewById(R.id.sp_item_rank_cover);
        if (imageView != null) {
            i2 = R.id.sp_item_rank_desc;
            ThemeTextView themeTextView = (ThemeTextView) rootView.findViewById(R.id.sp_item_rank_desc);
            if (themeTextView != null) {
                i2 = R.id.sp_item_rank_index;
                TextView textView = (TextView) rootView.findViewById(R.id.sp_item_rank_index);
                if (textView != null) {
                    i2 = R.id.sp_item_rank_name;
                    ThemeTextView themeTextView2 = (ThemeTextView) rootView.findViewById(R.id.sp_item_rank_name);
                    if (themeTextView2 != null) {
                        return new x6((LinearLayout) rootView, imageView, themeTextView, textView, themeTextView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i2)));
    }

    @NonNull
    public static x6 c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static x6 d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.search_rank_item, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public LinearLayout getRoot() {
        return this.f12945a;
    }
}
