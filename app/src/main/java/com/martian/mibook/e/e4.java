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
public final class e4 implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final RelativeLayout f11900a;

    /* renamed from: b */
    @NonNull
    public final TextView f11901b;

    /* renamed from: c */
    @NonNull
    public final ImageView f11902c;

    /* renamed from: d */
    @NonNull
    public final ImageView f11903d;

    /* renamed from: e */
    @NonNull
    public final ImageView f11904e;

    /* renamed from: f */
    @NonNull
    public final TextView f11905f;

    /* renamed from: g */
    @NonNull
    public final TextView f11906g;

    /* renamed from: h */
    @NonNull
    public final TextView f11907h;

    /* renamed from: i */
    @NonNull
    public final RelativeLayout f11908i;

    private e4(@NonNull RelativeLayout rootView, @NonNull TextView bookPromoteAuthor, @NonNull ImageView bookPromoteClose, @NonNull ImageView bookPromoteCover, @NonNull ImageView bookPromoteCoverBg, @NonNull TextView bookPromoteFreeTag, @NonNull TextView bookPromoteName, @NonNull TextView bookPromoteTip, @NonNull RelativeLayout bookPromoteView) {
        this.f11900a = rootView;
        this.f11901b = bookPromoteAuthor;
        this.f11902c = bookPromoteClose;
        this.f11903d = bookPromoteCover;
        this.f11904e = bookPromoteCoverBg;
        this.f11905f = bookPromoteFreeTag;
        this.f11906g = bookPromoteName;
        this.f11907h = bookPromoteTip;
        this.f11908i = bookPromoteView;
    }

    @NonNull
    public static e4 a(@NonNull View rootView) {
        int i2 = R.id.book_promote_author;
        TextView textView = (TextView) rootView.findViewById(R.id.book_promote_author);
        if (textView != null) {
            i2 = R.id.book_promote_close;
            ImageView imageView = (ImageView) rootView.findViewById(R.id.book_promote_close);
            if (imageView != null) {
                i2 = R.id.book_promote_cover;
                ImageView imageView2 = (ImageView) rootView.findViewById(R.id.book_promote_cover);
                if (imageView2 != null) {
                    i2 = R.id.book_promote_cover_bg;
                    ImageView imageView3 = (ImageView) rootView.findViewById(R.id.book_promote_cover_bg);
                    if (imageView3 != null) {
                        i2 = R.id.book_promote_free_tag;
                        TextView textView2 = (TextView) rootView.findViewById(R.id.book_promote_free_tag);
                        if (textView2 != null) {
                            i2 = R.id.book_promote_name;
                            TextView textView3 = (TextView) rootView.findViewById(R.id.book_promote_name);
                            if (textView3 != null) {
                                i2 = R.id.book_promote_tip;
                                TextView textView4 = (TextView) rootView.findViewById(R.id.book_promote_tip);
                                if (textView4 != null) {
                                    i2 = R.id.book_promote_view;
                                    RelativeLayout relativeLayout = (RelativeLayout) rootView.findViewById(R.id.book_promote_view);
                                    if (relativeLayout != null) {
                                        return new e4((RelativeLayout) rootView, textView, imageView, imageView2, imageView3, textView2, textView3, textView4, relativeLayout);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i2)));
    }

    @NonNull
    public static e4 c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static e4 d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.martian_popupwindow_book_promote, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f11900a;
    }
}
