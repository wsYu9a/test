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
import androidx.viewpager.widget.ViewPager;
import com.martian.libmars.utils.tablayout.MagicIndicator;
import com.martian.libmars.widget.BookCoverImageView;
import com.martian.libmars.widget.DownLoadButton;
import com.martian.libmars.widget.RoundedLayout;
import com.martian.mibook.R;
import com.martian.mibook.ui.reader.ReaderThemeImageView;
import com.martian.mibook.ui.reader.ReaderThemeTextView;

/* loaded from: classes3.dex */
public final class ReaderDirLayoutBinding implements ViewBinding {

    @NonNull
    public final DownLoadButton downloadBtn;

    @NonNull
    public final ImageView downloadBtnVipTag;

    @NonNull
    public final BookCoverImageView ivBookCover;

    @NonNull
    public final ReaderThemeImageView ivRight;

    @NonNull
    public final MagicIndicator magicIndicator;

    @NonNull
    public final RelativeLayout rlDownload;

    @NonNull
    private final RoundedLayout rootView;

    @NonNull
    public final ReaderThemeTextView tvBookDes;

    @NonNull
    public final ReaderThemeTextView tvBookName;

    @NonNull
    public final TextView tvCoverBookName;

    @NonNull
    public final ViewPager viewpager;

    private ReaderDirLayoutBinding(@NonNull RoundedLayout roundedLayout, @NonNull DownLoadButton downLoadButton, @NonNull ImageView imageView, @NonNull BookCoverImageView bookCoverImageView, @NonNull ReaderThemeImageView readerThemeImageView, @NonNull MagicIndicator magicIndicator, @NonNull RelativeLayout relativeLayout, @NonNull ReaderThemeTextView readerThemeTextView, @NonNull ReaderThemeTextView readerThemeTextView2, @NonNull TextView textView, @NonNull ViewPager viewPager) {
        this.rootView = roundedLayout;
        this.downloadBtn = downLoadButton;
        this.downloadBtnVipTag = imageView;
        this.ivBookCover = bookCoverImageView;
        this.ivRight = readerThemeImageView;
        this.magicIndicator = magicIndicator;
        this.rlDownload = relativeLayout;
        this.tvBookDes = readerThemeTextView;
        this.tvBookName = readerThemeTextView2;
        this.tvCoverBookName = textView;
        this.viewpager = viewPager;
    }

    @NonNull
    public static ReaderDirLayoutBinding bind(@NonNull View view) {
        int i10 = R.id.download_btn;
        DownLoadButton downLoadButton = (DownLoadButton) ViewBindings.findChildViewById(view, i10);
        if (downLoadButton != null) {
            i10 = R.id.download_btn_vip_tag;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i10);
            if (imageView != null) {
                i10 = R.id.iv_book_cover;
                BookCoverImageView bookCoverImageView = (BookCoverImageView) ViewBindings.findChildViewById(view, i10);
                if (bookCoverImageView != null) {
                    i10 = R.id.iv_right;
                    ReaderThemeImageView readerThemeImageView = (ReaderThemeImageView) ViewBindings.findChildViewById(view, i10);
                    if (readerThemeImageView != null) {
                        i10 = R.id.magic_indicator;
                        MagicIndicator magicIndicator = (MagicIndicator) ViewBindings.findChildViewById(view, i10);
                        if (magicIndicator != null) {
                            i10 = R.id.rl_download;
                            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i10);
                            if (relativeLayout != null) {
                                i10 = R.id.tv_book_des;
                                ReaderThemeTextView readerThemeTextView = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
                                if (readerThemeTextView != null) {
                                    i10 = R.id.tv_book_name;
                                    ReaderThemeTextView readerThemeTextView2 = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
                                    if (readerThemeTextView2 != null) {
                                        i10 = R.id.tv_cover_book_name;
                                        TextView textView = (TextView) ViewBindings.findChildViewById(view, i10);
                                        if (textView != null) {
                                            i10 = R.id.viewpager;
                                            ViewPager viewPager = (ViewPager) ViewBindings.findChildViewById(view, i10);
                                            if (viewPager != null) {
                                                return new ReaderDirLayoutBinding((RoundedLayout) view, downLoadButton, imageView, bookCoverImageView, readerThemeImageView, magicIndicator, relativeLayout, readerThemeTextView, readerThemeTextView2, textView, viewPager);
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
    public static ReaderDirLayoutBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ReaderDirLayoutBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.reader_dir_layout, viewGroup, false);
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
