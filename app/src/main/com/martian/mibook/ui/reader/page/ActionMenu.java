package com.martian.mibook.ui.reader.page;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import ba.m;
import com.martian.mibook.R;

/* loaded from: classes3.dex */
public class ActionMenu extends LinearLayout {

    /* renamed from: b */
    public ImageView f16047b;

    /* renamed from: c */
    public ImageView f16048c;

    /* renamed from: d */
    public LinearLayout f16049d;

    /* renamed from: e */
    public Context f16050e;

    public enum ActionType {
        COMMENT,
        TTS,
        COPY,
        UNDERLINE,
        DEL_UNDERLINE,
        TYPO_FEEDBACK
    }

    public interface a {
        void a(ReaderPageView readerPageView);

        void b(ReaderPageView readerPageView, ActionType actionType, @Nullable b bVar, @Nullable b bVar2, int i10, int i11);
    }

    public static class b {

        /* renamed from: a */
        public String f16051a;

        /* renamed from: b */
        public int f16052b;

        /* renamed from: c */
        public int f16053c;

        public b(String str, int i10, int i11) {
            this.f16051a = str;
            this.f16052b = i10;
            this.f16053c = i11;
        }

        public int a() {
            return this.f16053c;
        }

        public int b() {
            return this.f16052b;
        }

        public String c() {
            return this.f16051a.substring(this.f16052b, this.f16053c);
        }

        public String d() {
            return this.f16051a;
        }

        public void e(int i10) {
            this.f16053c = i10;
        }

        public void f(int i10) {
            this.f16052b = i10;
        }

        public void g(String str) {
            this.f16051a = str;
        }
    }

    public ActionMenu(Context context) {
        this(context, null);
    }

    public final void a() {
        setOrientation(1);
        setGravity(1);
        ImageView imageView = new ImageView(getContext());
        this.f16048c = imageView;
        imageView.setImageResource(R.drawable.reader_page_action_menu_arrow_up);
        this.f16048c.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        addView(this.f16048c);
        LayoutInflater.from(getContext()).inflate(R.layout.reader_page_action_menu, this);
        this.f16049d = (LinearLayout) getChildAt(1);
        ImageView imageView2 = new ImageView(getContext());
        this.f16047b = imageView2;
        imageView2.setImageResource(R.drawable.reader_page_action_menu_arrow_down);
        this.f16047b.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        addView(this.f16047b);
    }

    public void b(boolean z10, int i10) {
        int a10 = m.a(getContext(), 14.0f);
        if ((this.f16049d.getWidth() / 2) - i10 < a10) {
            i10 = (this.f16049d.getWidth() / 2) - a10;
        } else if ((this.f16049d.getWidth() / 2) + i10 < a10) {
            i10 = a10 - (this.f16049d.getWidth() / 2);
        }
        if (z10) {
            this.f16047b.setVisibility(0);
            ((LinearLayout.LayoutParams) this.f16047b.getLayoutParams()).rightMargin = i10;
            this.f16048c.setVisibility(8);
        } else {
            this.f16048c.setVisibility(0);
            ((LinearLayout.LayoutParams) this.f16048c.getLayoutParams()).rightMargin = i10;
            this.f16047b.setVisibility(8);
        }
    }

    public void c(boolean z10) {
        View findViewById = this.f16049d.findViewById(R.id.reader_page_action_menu_comment);
        if (z10) {
            findViewById.setVisibility(0);
        } else {
            findViewById.setVisibility(8);
        }
    }

    public void d(boolean z10) {
        View findViewById = this.f16049d.findViewById(R.id.reader_page_action_menu_underline);
        View findViewById2 = this.f16049d.findViewById(R.id.reader_page_action_menu_del_underline);
        if (z10) {
            findViewById2.setVisibility(0);
            findViewById.setVisibility(8);
        } else {
            findViewById2.setVisibility(8);
            findViewById.setVisibility(0);
        }
    }

    public void e(boolean z10) {
        View findViewById = this.f16049d.findViewById(R.id.reader_page_action_wrong_words_feedback);
        if (z10) {
            findViewById.setVisibility(0);
        } else {
            findViewById.setVisibility(8);
        }
    }

    public void setMenuItemClickListener(View.OnClickListener onClickListener) {
        for (int i10 = 0; i10 < this.f16049d.getChildCount(); i10++) {
            this.f16049d.getChildAt(i10).setOnClickListener(onClickListener);
        }
    }

    public ActionMenu(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ActionMenu(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f16050e = context;
        a();
    }
}
