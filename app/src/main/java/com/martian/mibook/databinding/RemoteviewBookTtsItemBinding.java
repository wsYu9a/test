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
import com.martian.mibook.R;

/* loaded from: classes3.dex */
public final class RemoteviewBookTtsItemBinding implements ViewBinding {

    @NonNull
    public final LinearLayout remoteviewMainView;

    @NonNull
    private final LinearLayout rootView;

    @NonNull
    public final ImageView ttsClose;

    @NonNull
    public final ImageView ttsCover;

    @NonNull
    public final TextView ttsDesc;

    @NonNull
    public final TextView ttsName;

    @NonNull
    public final ImageView ttsNextChapter;

    @NonNull
    public final ImageView ttsPlay;

    @NonNull
    public final ImageView ttsPreChapter;

    private RemoteviewBookTtsItemBinding(@NonNull LinearLayout linearLayout, @NonNull LinearLayout linearLayout2, @NonNull ImageView imageView, @NonNull ImageView imageView2, @NonNull TextView textView, @NonNull TextView textView2, @NonNull ImageView imageView3, @NonNull ImageView imageView4, @NonNull ImageView imageView5) {
        this.rootView = linearLayout;
        this.remoteviewMainView = linearLayout2;
        this.ttsClose = imageView;
        this.ttsCover = imageView2;
        this.ttsDesc = textView;
        this.ttsName = textView2;
        this.ttsNextChapter = imageView3;
        this.ttsPlay = imageView4;
        this.ttsPreChapter = imageView5;
    }

    @NonNull
    public static RemoteviewBookTtsItemBinding bind(@NonNull View view) {
        LinearLayout linearLayout = (LinearLayout) view;
        int i10 = R.id.tts_close;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i10);
        if (imageView != null) {
            i10 = R.id.tts_cover;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i10);
            if (imageView2 != null) {
                i10 = R.id.tts_desc;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i10);
                if (textView != null) {
                    i10 = R.id.tts_name;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i10);
                    if (textView2 != null) {
                        i10 = R.id.tts_next_chapter;
                        ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i10);
                        if (imageView3 != null) {
                            i10 = R.id.tts_play;
                            ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, i10);
                            if (imageView4 != null) {
                                i10 = R.id.tts_pre_chapter;
                                ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(view, i10);
                                if (imageView5 != null) {
                                    return new RemoteviewBookTtsItemBinding(linearLayout, linearLayout, imageView, imageView2, textView, textView2, imageView3, imageView4, imageView5);
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
    public static RemoteviewBookTtsItemBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static RemoteviewBookTtsItemBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.remoteview_book_tts_item, viewGroup, false);
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
