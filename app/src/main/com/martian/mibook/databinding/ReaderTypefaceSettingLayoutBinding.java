package com.martian.mibook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.libmars.widget.RoundedLayout;
import com.martian.mibook.R;
import com.martian.mibook.ui.reader.ReaderThemeImageView;
import com.martian.mibook.ui.reader.ReaderThemeLinearLayout;
import com.martian.mibook.ui.reader.ReaderThemeTextView;

/* loaded from: classes3.dex */
public final class ReaderTypefaceSettingLayoutBinding implements ViewBinding {

    @NonNull
    public final ReaderThemeImageView ivClose;

    @NonNull
    public final ImageView ivVip;

    @NonNull
    private final RoundedLayout rootView;

    @NonNull
    public final RecyclerView rvTf;

    @NonNull
    public final ReaderThemeTextView tvTitle;

    @NonNull
    public final ReaderThemeLinearLayout typeFaceImport;

    @NonNull
    public final RoundedLayout typeFaceRoundView;

    @NonNull
    public final ReaderThemeLinearLayout typeFaceView;

    private ReaderTypefaceSettingLayoutBinding(@NonNull RoundedLayout roundedLayout, @NonNull ReaderThemeImageView readerThemeImageView, @NonNull ImageView imageView, @NonNull RecyclerView recyclerView, @NonNull ReaderThemeTextView readerThemeTextView, @NonNull ReaderThemeLinearLayout readerThemeLinearLayout, @NonNull RoundedLayout roundedLayout2, @NonNull ReaderThemeLinearLayout readerThemeLinearLayout2) {
        this.rootView = roundedLayout;
        this.ivClose = readerThemeImageView;
        this.ivVip = imageView;
        this.rvTf = recyclerView;
        this.tvTitle = readerThemeTextView;
        this.typeFaceImport = readerThemeLinearLayout;
        this.typeFaceRoundView = roundedLayout2;
        this.typeFaceView = readerThemeLinearLayout2;
    }

    @NonNull
    public static ReaderTypefaceSettingLayoutBinding bind(@NonNull View view) {
        int i10 = R.id.iv_close;
        ReaderThemeImageView readerThemeImageView = (ReaderThemeImageView) ViewBindings.findChildViewById(view, i10);
        if (readerThemeImageView != null) {
            i10 = R.id.iv_vip;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i10);
            if (imageView != null) {
                i10 = R.id.rv_tf;
                RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i10);
                if (recyclerView != null) {
                    i10 = R.id.tv_title;
                    ReaderThemeTextView readerThemeTextView = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
                    if (readerThemeTextView != null) {
                        i10 = R.id.type_face_import;
                        ReaderThemeLinearLayout readerThemeLinearLayout = (ReaderThemeLinearLayout) ViewBindings.findChildViewById(view, i10);
                        if (readerThemeLinearLayout != null) {
                            RoundedLayout roundedLayout = (RoundedLayout) view;
                            i10 = R.id.type_face_view;
                            ReaderThemeLinearLayout readerThemeLinearLayout2 = (ReaderThemeLinearLayout) ViewBindings.findChildViewById(view, i10);
                            if (readerThemeLinearLayout2 != null) {
                                return new ReaderTypefaceSettingLayoutBinding(roundedLayout, readerThemeImageView, imageView, recyclerView, readerThemeTextView, readerThemeLinearLayout, roundedLayout, readerThemeLinearLayout2);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static ReaderTypefaceSettingLayoutBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ReaderTypefaceSettingLayoutBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.reader_typeface_setting_layout, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public RoundedLayout getRoot() {
        return this.rootView;
    }
}
