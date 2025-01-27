package com.martian.mibook.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.martian.mibook.ui.reader.ReaderThemeItemTextView;
import com.martian.mibook.ui.reader.ReaderThemeLinearLayout;
import com.martian.mibook.ui.reader.ReaderThemeTextView;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public final class s3 implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final ReaderThemeLinearLayout f12669a;

    /* renamed from: b */
    @NonNull
    public final ReaderThemeItemTextView f12670b;

    /* renamed from: c */
    @NonNull
    public final ImageView f12671c;

    /* renamed from: d */
    @NonNull
    public final LinearLayout f12672d;

    /* renamed from: e */
    @NonNull
    public final ImageView f12673e;

    /* renamed from: f */
    @NonNull
    public final ReaderThemeTextView f12674f;

    /* renamed from: g */
    @NonNull
    public final ReaderThemeTextView f12675g;

    private s3(@NonNull ReaderThemeLinearLayout rootView, @NonNull ReaderThemeItemTextView btOperate, @NonNull ImageView imgTipLogo, @NonNull LinearLayout tvLoading, @NonNull ImageView tvLoadingIcon, @NonNull ReaderThemeTextView tvTips, @NonNull ReaderThemeTextView tvTipsRetryHint) {
        this.f12669a = rootView;
        this.f12670b = btOperate;
        this.f12671c = imgTipLogo;
        this.f12672d = tvLoading;
        this.f12673e = tvLoadingIcon;
        this.f12674f = tvTips;
        this.f12675g = tvTipsRetryHint;
    }

    @NonNull
    public static s3 a(@NonNull View rootView) {
        int i2 = R.id.bt_operate;
        ReaderThemeItemTextView readerThemeItemTextView = (ReaderThemeItemTextView) rootView.findViewById(R.id.bt_operate);
        if (readerThemeItemTextView != null) {
            i2 = R.id.img_tip_logo;
            ImageView imageView = (ImageView) rootView.findViewById(R.id.img_tip_logo);
            if (imageView != null) {
                i2 = R.id.tv_loading;
                LinearLayout linearLayout = (LinearLayout) rootView.findViewById(R.id.tv_loading);
                if (linearLayout != null) {
                    i2 = R.id.tv_loading_icon;
                    ImageView imageView2 = (ImageView) rootView.findViewById(R.id.tv_loading_icon);
                    if (imageView2 != null) {
                        i2 = R.id.tv_tips;
                        ReaderThemeTextView readerThemeTextView = (ReaderThemeTextView) rootView.findViewById(R.id.tv_tips);
                        if (readerThemeTextView != null) {
                            i2 = R.id.tv_tips_retry_hint;
                            ReaderThemeTextView readerThemeTextView2 = (ReaderThemeTextView) rootView.findViewById(R.id.tv_tips_retry_hint);
                            if (readerThemeTextView2 != null) {
                                return new s3((ReaderThemeLinearLayout) rootView, readerThemeItemTextView, imageView, linearLayout, imageView2, readerThemeTextView, readerThemeTextView2);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i2)));
    }

    @NonNull
    public static s3 c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static s3 d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.layout_reader_loading_tip, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public ReaderThemeLinearLayout getRoot() {
        return this.f12669a;
    }
}
