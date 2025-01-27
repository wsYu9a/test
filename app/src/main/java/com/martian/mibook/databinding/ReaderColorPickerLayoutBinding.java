package com.martian.mibook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.libmars.utils.tablayout.MagicIndicator;
import com.martian.libmars.widget.RoundedLayout;
import com.martian.mibook.R;
import com.martian.mibook.ui.colorpicker.LineColorPicker;
import com.martian.mibook.ui.reader.ReaderThemeImageView;
import com.martian.mibook.ui.reader.ReaderThemeLinearLayout;
import com.martian.mibook.ui.reader.ReaderThemeTextView;

/* loaded from: classes3.dex */
public final class ReaderColorPickerLayoutBinding implements ViewBinding {

    @NonNull
    public final LineColorPicker colorPickerPrimary;

    @NonNull
    public final LineColorPicker colorPickerPrimary2;

    @NonNull
    public final LineColorPicker colorPickerSecondary;

    @NonNull
    public final LineColorPicker colorPickerSecondary2;

    @NonNull
    public final ReaderThemeImageView ivImport;

    @NonNull
    public final ImageView ivPicture;

    @NonNull
    public final ImageView ivVip;

    @NonNull
    public final LinearLayout llConfirm;

    @NonNull
    public final LinearLayout llItemBackgroundPicture;

    @NonNull
    public final ReaderThemeLinearLayout llPicture;

    @NonNull
    public final LinearLayout llSelectedPicture;

    @NonNull
    public final ReaderThemeLinearLayout llUploadPicture;

    @NonNull
    public final LinearLayout llWaitSelect;

    @NonNull
    public final MagicIndicator magicIndicator;

    @NonNull
    private final RoundedLayout rootView;

    @NonNull
    public final ReaderThemeTextView tvCancel;

    @NonNull
    public final ReaderThemeTextView tvConfirm;

    @NonNull
    public final ReaderThemeTextView tvImportText;

    @NonNull
    public final ReaderThemeTextView tvPictureName;

    @NonNull
    public final ReaderThemeTextView tvPrimary;

    @NonNull
    public final ReaderThemeTextView tvPrimary2;

    @NonNull
    public final ReaderThemeTextView tvSecondary;

    @NonNull
    public final ReaderThemeTextView tvSecondary2;

    @NonNull
    public final TextView tvStar;

    @NonNull
    public final TextView tvUploadPictureTips;

    private ReaderColorPickerLayoutBinding(@NonNull RoundedLayout roundedLayout, @NonNull LineColorPicker lineColorPicker, @NonNull LineColorPicker lineColorPicker2, @NonNull LineColorPicker lineColorPicker3, @NonNull LineColorPicker lineColorPicker4, @NonNull ReaderThemeImageView readerThemeImageView, @NonNull ImageView imageView, @NonNull ImageView imageView2, @NonNull LinearLayout linearLayout, @NonNull LinearLayout linearLayout2, @NonNull ReaderThemeLinearLayout readerThemeLinearLayout, @NonNull LinearLayout linearLayout3, @NonNull ReaderThemeLinearLayout readerThemeLinearLayout2, @NonNull LinearLayout linearLayout4, @NonNull MagicIndicator magicIndicator, @NonNull ReaderThemeTextView readerThemeTextView, @NonNull ReaderThemeTextView readerThemeTextView2, @NonNull ReaderThemeTextView readerThemeTextView3, @NonNull ReaderThemeTextView readerThemeTextView4, @NonNull ReaderThemeTextView readerThemeTextView5, @NonNull ReaderThemeTextView readerThemeTextView6, @NonNull ReaderThemeTextView readerThemeTextView7, @NonNull ReaderThemeTextView readerThemeTextView8, @NonNull TextView textView, @NonNull TextView textView2) {
        this.rootView = roundedLayout;
        this.colorPickerPrimary = lineColorPicker;
        this.colorPickerPrimary2 = lineColorPicker2;
        this.colorPickerSecondary = lineColorPicker3;
        this.colorPickerSecondary2 = lineColorPicker4;
        this.ivImport = readerThemeImageView;
        this.ivPicture = imageView;
        this.ivVip = imageView2;
        this.llConfirm = linearLayout;
        this.llItemBackgroundPicture = linearLayout2;
        this.llPicture = readerThemeLinearLayout;
        this.llSelectedPicture = linearLayout3;
        this.llUploadPicture = readerThemeLinearLayout2;
        this.llWaitSelect = linearLayout4;
        this.magicIndicator = magicIndicator;
        this.tvCancel = readerThemeTextView;
        this.tvConfirm = readerThemeTextView2;
        this.tvImportText = readerThemeTextView3;
        this.tvPictureName = readerThemeTextView4;
        this.tvPrimary = readerThemeTextView5;
        this.tvPrimary2 = readerThemeTextView6;
        this.tvSecondary = readerThemeTextView7;
        this.tvSecondary2 = readerThemeTextView8;
        this.tvStar = textView;
        this.tvUploadPictureTips = textView2;
    }

    @NonNull
    public static ReaderColorPickerLayoutBinding bind(@NonNull View view) {
        int i10 = R.id.color_picker_primary;
        LineColorPicker lineColorPicker = (LineColorPicker) ViewBindings.findChildViewById(view, i10);
        if (lineColorPicker != null) {
            i10 = R.id.color_picker_primary_2;
            LineColorPicker lineColorPicker2 = (LineColorPicker) ViewBindings.findChildViewById(view, i10);
            if (lineColorPicker2 != null) {
                i10 = R.id.color_picker_secondary;
                LineColorPicker lineColorPicker3 = (LineColorPicker) ViewBindings.findChildViewById(view, i10);
                if (lineColorPicker3 != null) {
                    i10 = R.id.color_picker_secondary_2;
                    LineColorPicker lineColorPicker4 = (LineColorPicker) ViewBindings.findChildViewById(view, i10);
                    if (lineColorPicker4 != null) {
                        i10 = R.id.iv_import;
                        ReaderThemeImageView readerThemeImageView = (ReaderThemeImageView) ViewBindings.findChildViewById(view, i10);
                        if (readerThemeImageView != null) {
                            i10 = R.id.iv_picture;
                            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i10);
                            if (imageView != null) {
                                i10 = R.id.iv_vip;
                                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i10);
                                if (imageView2 != null) {
                                    i10 = R.id.ll_confirm;
                                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i10);
                                    if (linearLayout != null) {
                                        i10 = R.id.ll_item_background_picture;
                                        LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i10);
                                        if (linearLayout2 != null) {
                                            i10 = R.id.ll_picture;
                                            ReaderThemeLinearLayout readerThemeLinearLayout = (ReaderThemeLinearLayout) ViewBindings.findChildViewById(view, i10);
                                            if (readerThemeLinearLayout != null) {
                                                i10 = R.id.ll_selected_picture;
                                                LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, i10);
                                                if (linearLayout3 != null) {
                                                    i10 = R.id.ll_upload_picture;
                                                    ReaderThemeLinearLayout readerThemeLinearLayout2 = (ReaderThemeLinearLayout) ViewBindings.findChildViewById(view, i10);
                                                    if (readerThemeLinearLayout2 != null) {
                                                        i10 = R.id.ll_wait_select;
                                                        LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(view, i10);
                                                        if (linearLayout4 != null) {
                                                            i10 = R.id.magic_indicator;
                                                            MagicIndicator magicIndicator = (MagicIndicator) ViewBindings.findChildViewById(view, i10);
                                                            if (magicIndicator != null) {
                                                                i10 = R.id.tv_cancel;
                                                                ReaderThemeTextView readerThemeTextView = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
                                                                if (readerThemeTextView != null) {
                                                                    i10 = R.id.tv_confirm;
                                                                    ReaderThemeTextView readerThemeTextView2 = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
                                                                    if (readerThemeTextView2 != null) {
                                                                        i10 = R.id.tv_import_text;
                                                                        ReaderThemeTextView readerThemeTextView3 = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
                                                                        if (readerThemeTextView3 != null) {
                                                                            i10 = R.id.tv_picture_name;
                                                                            ReaderThemeTextView readerThemeTextView4 = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
                                                                            if (readerThemeTextView4 != null) {
                                                                                i10 = R.id.tv_primary;
                                                                                ReaderThemeTextView readerThemeTextView5 = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
                                                                                if (readerThemeTextView5 != null) {
                                                                                    i10 = R.id.tv_primary_2;
                                                                                    ReaderThemeTextView readerThemeTextView6 = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
                                                                                    if (readerThemeTextView6 != null) {
                                                                                        i10 = R.id.tv_secondary;
                                                                                        ReaderThemeTextView readerThemeTextView7 = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
                                                                                        if (readerThemeTextView7 != null) {
                                                                                            i10 = R.id.tv_secondary_2;
                                                                                            ReaderThemeTextView readerThemeTextView8 = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
                                                                                            if (readerThemeTextView8 != null) {
                                                                                                i10 = R.id.tv_star;
                                                                                                TextView textView = (TextView) ViewBindings.findChildViewById(view, i10);
                                                                                                if (textView != null) {
                                                                                                    i10 = R.id.tv_upload_picture_tips;
                                                                                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i10);
                                                                                                    if (textView2 != null) {
                                                                                                        return new ReaderColorPickerLayoutBinding((RoundedLayout) view, lineColorPicker, lineColorPicker2, lineColorPicker3, lineColorPicker4, readerThemeImageView, imageView, imageView2, linearLayout, linearLayout2, readerThemeLinearLayout, linearLayout3, readerThemeLinearLayout2, linearLayout4, magicIndicator, readerThemeTextView, readerThemeTextView2, readerThemeTextView3, readerThemeTextView4, readerThemeTextView5, readerThemeTextView6, readerThemeTextView7, readerThemeTextView8, textView, textView2);
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
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
    public static ReaderColorPickerLayoutBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ReaderColorPickerLayoutBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.reader_color_picker_layout, viewGroup, false);
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
