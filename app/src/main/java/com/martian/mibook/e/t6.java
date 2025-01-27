package com.martian.mibook.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.martian.libmars.ui.theme.ThemeImageView;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public final class t6 implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final LinearLayout f12748a;

    /* renamed from: b */
    @NonNull
    public final ThemeImageView f12749b;

    /* renamed from: c */
    @NonNull
    public final LinearLayout f12750c;

    /* renamed from: d */
    @NonNull
    public final TextView f12751d;

    /* renamed from: e */
    @NonNull
    public final TextView f12752e;

    /* renamed from: f */
    @NonNull
    public final TextView f12753f;

    /* renamed from: g */
    @NonNull
    public final ThemeImageView f12754g;

    private t6(@NonNull LinearLayout rootView, @NonNull ThemeImageView ivSelection, @NonNull LinearLayout trackInfo, @NonNull TextView tvFileDate, @NonNull TextView tvFileName, @NonNull TextView tvFileSize, @NonNull ThemeImageView tvType) {
        this.f12748a = rootView;
        this.f12749b = ivSelection;
        this.f12750c = trackInfo;
        this.f12751d = tvFileDate;
        this.f12752e = tvFileName;
        this.f12753f = tvFileSize;
        this.f12754g = tvType;
    }

    @NonNull
    public static t6 a(@NonNull View rootView) {
        int i2 = R.id.iv_selection;
        ThemeImageView themeImageView = (ThemeImageView) rootView.findViewById(R.id.iv_selection);
        if (themeImageView != null) {
            i2 = R.id.track_info;
            LinearLayout linearLayout = (LinearLayout) rootView.findViewById(R.id.track_info);
            if (linearLayout != null) {
                i2 = R.id.tv_file_date;
                TextView textView = (TextView) rootView.findViewById(R.id.tv_file_date);
                if (textView != null) {
                    i2 = R.id.tv_file_name;
                    TextView textView2 = (TextView) rootView.findViewById(R.id.tv_file_name);
                    if (textView2 != null) {
                        i2 = R.id.tv_file_size;
                        TextView textView3 = (TextView) rootView.findViewById(R.id.tv_file_size);
                        if (textView3 != null) {
                            i2 = R.id.tv_type;
                            ThemeImageView themeImageView2 = (ThemeImageView) rootView.findViewById(R.id.tv_type);
                            if (themeImageView2 != null) {
                                return new t6((LinearLayout) rootView, themeImageView, linearLayout, textView, textView2, textView3, themeImageView2);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i2)));
    }

    @NonNull
    public static t6 c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static t6 d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.restore_book_store_item, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public LinearLayout getRoot() {
        return this.f12748a;
    }
}
