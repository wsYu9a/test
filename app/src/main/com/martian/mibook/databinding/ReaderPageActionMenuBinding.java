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
import com.martian.mibook.R;

/* loaded from: classes3.dex */
public final class ReaderPageActionMenuBinding implements ViewBinding {

    @NonNull
    public final LinearLayout menuContainer;

    @NonNull
    public final TextView readerPageActionMenuComment;

    @NonNull
    public final TextView readerPageActionMenuCopy;

    @NonNull
    public final TextView readerPageActionMenuDelUnderline;

    @NonNull
    public final TextView readerPageActionMenuTts;

    @NonNull
    public final TextView readerPageActionMenuUnderline;

    @NonNull
    public final TextView readerPageActionWrongWordsFeedback;

    @NonNull
    private final LinearLayout rootView;

    private ReaderPageActionMenuBinding(@NonNull LinearLayout linearLayout, @NonNull LinearLayout linearLayout2, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull TextView textView4, @NonNull TextView textView5, @NonNull TextView textView6) {
        this.rootView = linearLayout;
        this.menuContainer = linearLayout2;
        this.readerPageActionMenuComment = textView;
        this.readerPageActionMenuCopy = textView2;
        this.readerPageActionMenuDelUnderline = textView3;
        this.readerPageActionMenuTts = textView4;
        this.readerPageActionMenuUnderline = textView5;
        this.readerPageActionWrongWordsFeedback = textView6;
    }

    @NonNull
    public static ReaderPageActionMenuBinding bind(@NonNull View view) {
        LinearLayout linearLayout = (LinearLayout) view;
        int i10 = R.id.reader_page_action_menu_comment;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i10);
        if (textView != null) {
            i10 = R.id.reader_page_action_menu_copy;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i10);
            if (textView2 != null) {
                i10 = R.id.reader_page_action_menu_del_underline;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i10);
                if (textView3 != null) {
                    i10 = R.id.reader_page_action_menu_tts;
                    TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i10);
                    if (textView4 != null) {
                        i10 = R.id.reader_page_action_menu_underline;
                        TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i10);
                        if (textView5 != null) {
                            i10 = R.id.reader_page_action_wrong_words_feedback;
                            TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i10);
                            if (textView6 != null) {
                                return new ReaderPageActionMenuBinding(linearLayout, linearLayout, textView, textView2, textView3, textView4, textView5, textView6);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static ReaderPageActionMenuBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ReaderPageActionMenuBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.reader_page_action_menu, viewGroup, false);
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
