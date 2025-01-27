package com.martian.mibook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.libmars.ui.theme.ThemeImageView;
import com.martian.mibook.R;

/* loaded from: classes3.dex */
public final class RestoreBookStoreItemBinding implements ViewBinding {

    @NonNull
    public final ThemeImageView ivSelection;

    @NonNull
    private final LinearLayout rootView;

    @NonNull
    public final LinearLayout trackInfo;

    @NonNull
    public final TextView tvFileDate;

    @NonNull
    public final TextView tvFileName;

    @NonNull
    public final TextView tvFileSize;

    @NonNull
    public final ThemeImageView tvType;

    private RestoreBookStoreItemBinding(@NonNull LinearLayout linearLayout, @NonNull ThemeImageView themeImageView, @NonNull LinearLayout linearLayout2, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull ThemeImageView themeImageView2) {
        this.rootView = linearLayout;
        this.ivSelection = themeImageView;
        this.trackInfo = linearLayout2;
        this.tvFileDate = textView;
        this.tvFileName = textView2;
        this.tvFileSize = textView3;
        this.tvType = themeImageView2;
    }

    @NonNull
    public static RestoreBookStoreItemBinding bind(@NonNull View view) {
        int i10 = R.id.iv_selection;
        ThemeImageView themeImageView = (ThemeImageView) ViewBindings.findChildViewById(view, i10);
        if (themeImageView != null) {
            i10 = R.id.track_info;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i10);
            if (linearLayout != null) {
                i10 = R.id.tv_file_date;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i10);
                if (textView != null) {
                    i10 = R.id.tv_file_name;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i10);
                    if (textView2 != null) {
                        i10 = R.id.tv_file_size;
                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i10);
                        if (textView3 != null) {
                            i10 = R.id.tv_type;
                            ThemeImageView themeImageView2 = (ThemeImageView) ViewBindings.findChildViewById(view, i10);
                            if (themeImageView2 != null) {
                                return new RestoreBookStoreItemBinding((LinearLayout) view, themeImageView, linearLayout, textView, textView2, textView3, themeImageView2);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static RestoreBookStoreItemBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static RestoreBookStoreItemBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.restore_book_store_item, viewGroup, false);
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
