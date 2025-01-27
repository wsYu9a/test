package com.martian.mibook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.libmars.widget.RoundedLayout;
import com.martian.mibook.R;
import com.martian.mibook.ui.reader.ReaderThemeProgressBar;

/* loaded from: classes3.dex */
public final class ItemReadingTypeFaceBinding implements ViewBinding {

    @NonNull
    public final ImageView ivTypefacePreview;

    @NonNull
    public final ImageView ivUseChecked;

    @NonNull
    public final ImageView ivVip;

    @NonNull
    public final ReaderThemeProgressBar rbsProgressBar;

    @NonNull
    public final RelativeLayout rlTypefaceName;

    @NonNull
    private final RelativeLayout rootView;

    @NonNull
    public final RoundedLayout roundLayout;

    @NonNull
    public final TextView tvTypefaceName;

    @NonNull
    public final TextView tvTypefaceStatus;

    private ItemReadingTypeFaceBinding(@NonNull RelativeLayout relativeLayout, @NonNull ImageView imageView, @NonNull ImageView imageView2, @NonNull ImageView imageView3, @NonNull ReaderThemeProgressBar readerThemeProgressBar, @NonNull RelativeLayout relativeLayout2, @NonNull RoundedLayout roundedLayout, @NonNull TextView textView, @NonNull TextView textView2) {
        this.rootView = relativeLayout;
        this.ivTypefacePreview = imageView;
        this.ivUseChecked = imageView2;
        this.ivVip = imageView3;
        this.rbsProgressBar = readerThemeProgressBar;
        this.rlTypefaceName = relativeLayout2;
        this.roundLayout = roundedLayout;
        this.tvTypefaceName = textView;
        this.tvTypefaceStatus = textView2;
    }

    @NonNull
    public static ItemReadingTypeFaceBinding bind(@NonNull View view) {
        int i10 = R.id.iv_typeface_preview;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i10);
        if (imageView != null) {
            i10 = R.id.iv_use_checked;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i10);
            if (imageView2 != null) {
                i10 = R.id.iv_vip;
                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i10);
                if (imageView3 != null) {
                    i10 = R.id.rbs_progress_bar;
                    ReaderThemeProgressBar readerThemeProgressBar = (ReaderThemeProgressBar) ViewBindings.findChildViewById(view, i10);
                    if (readerThemeProgressBar != null) {
                        i10 = R.id.rl_typeface_name;
                        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i10);
                        if (relativeLayout != null) {
                            i10 = R.id.round_layout;
                            RoundedLayout roundedLayout = (RoundedLayout) ViewBindings.findChildViewById(view, i10);
                            if (roundedLayout != null) {
                                i10 = R.id.tv_typeface_name;
                                TextView textView = (TextView) ViewBindings.findChildViewById(view, i10);
                                if (textView != null) {
                                    i10 = R.id.tv_typeface_status;
                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i10);
                                    if (textView2 != null) {
                                        return new ItemReadingTypeFaceBinding((RelativeLayout) view, imageView, imageView2, imageView3, readerThemeProgressBar, relativeLayout, roundedLayout, textView, textView2);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static ItemReadingTypeFaceBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ItemReadingTypeFaceBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.item_reading_type_face, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public RelativeLayout getRoot() {
        return this.rootView;
    }
}
