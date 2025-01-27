package com.sigmob.sdk.base.views;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.czhj.sdk.common.utils.Dips;

/* loaded from: classes4.dex */
public class d extends RelativeLayout {

    /* renamed from: a */
    public final int f18497a;

    /* renamed from: b */
    public final int f18498b;

    /* renamed from: c */
    public final int f18499c;

    /* renamed from: d */
    public final int f18500d;

    /* renamed from: e */
    public final int f18501e;

    /* renamed from: f */
    public final int f18502f;

    /* renamed from: g */
    public final int f18503g;

    /* renamed from: h */
    public final int f18504h;

    /* renamed from: i */
    public Button f18505i;

    /* renamed from: j */
    public Button f18506j;

    /* renamed from: k */
    public int f18507k;

    /* renamed from: l */
    public TextView f18508l;

    /* renamed from: m */
    public com.sigmob.sdk.videoAd.e f18509m;

    public class a implements View.OnClickListener {

        /* renamed from: a */
        public final /* synthetic */ c f18510a;

        public a(c cVar) {
            this.f18510a = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f18510a.onCancel();
        }
    }

    public class b implements View.OnClickListener {

        /* renamed from: a */
        public final /* synthetic */ c f18512a;

        public b(c cVar) {
            this.f18512a = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f18512a.a();
        }
    }

    public interface c {
        void a();

        void onCancel();
    }

    public d(Context context, com.sigmob.sdk.videoAd.e eVar) {
        super(context);
        this.f18509m = eVar;
        this.f18497a = Dips.dipsToIntPixels(10.0f, context);
        int dipsToIntPixels = Dips.dipsToIntPixels(16.0f, context);
        this.f18498b = dipsToIntPixels;
        this.f18499c = Dips.dipsToIntPixels(227.0f, context);
        this.f18502f = (int) ((r1 * 16.0f) / 9.0d);
        int dipsToIntPixels2 = Dips.dipsToIntPixels(25.0f, context);
        this.f18500d = dipsToIntPixels2;
        this.f18504h = Dips.dipsToIntPixels(25.0f, context);
        this.f18501e = Dips.dipsToIntPixels(100.0f, context);
        this.f18503g = dipsToIntPixels2 + dipsToIntPixels;
        setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        c(context);
    }

    public final Button a(Context context) {
        Button button = new Button(context);
        button.setText(this.f18509m.a());
        button.setTextColor(Color.parseColor("#ff999999"));
        button.setBackgroundColor(0);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, this.f18498b / 2, 0, 0);
        button.setGravity(17);
        button.setTextSize(2, 14.0f);
        button.setLayoutParams(layoutParams);
        return button;
    }

    public final Button b(Context context) {
        Button button = new Button(context);
        button.setText(this.f18509m.b());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, this.f18503g);
        int i10 = this.f18497a;
        int i11 = i10 * 5;
        layoutParams.setMargins(i11, i10 * 2, i11, 0);
        button.setLayoutParams(layoutParams);
        button.setTextColor(-1);
        button.setBackgroundColor(0);
        button.setTextSize(2, 16.0f);
        b0.a(button, r.f18863a, this.f18503g / 2, Color.parseColor("#66000000"), 0, 0, 0);
        return button;
    }

    public final void c(Context context) {
        RelativeLayout relativeLayout = new RelativeLayout(context);
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.f18500d);
        int i10 = this.f18498b;
        layoutParams.setMargins(i10, this.f18497a * 2, i10, 0);
        linearLayout.addView(e(context), layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, this.f18504h);
        int i11 = this.f18498b;
        layoutParams2.setMargins(i11, this.f18497a, i11, 0);
        linearLayout.addView(d(context), layoutParams2);
        b0.a(linearLayout, Color.parseColor("#FFFFFF"), this.f18497a, Color.parseColor("#66000000"), 0, 0, 0);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(this.f18502f, this.f18499c);
        int i12 = this.f18498b;
        layoutParams3.setMargins(i12, 0, i12, 0);
        layoutParams3.addRule(13);
        relativeLayout.setLayoutParams(layoutParams3);
        relativeLayout.addView(linearLayout, new RelativeLayout.LayoutParams(-1, -1));
        Button b10 = b(context);
        this.f18506j = b10;
        linearLayout.addView(b10);
        Button a10 = a(context);
        this.f18505i = a10;
        linearLayout.addView(a10);
        linearLayout.setGravity(17);
        addView(relativeLayout);
    }

    public final TextView d(Context context) {
        TextView textView = new TextView(context);
        this.f18508l = textView;
        textView.setTextColor(-16777216);
        this.f18508l.setTextSize(2, 14.0f);
        this.f18508l.setGravity(17);
        return this.f18508l;
    }

    public final TextView e(Context context) {
        TextView textView = new TextView(context);
        textView.setText(this.f18509m.d());
        textView.setTextColor(-16777216);
        textView.setTextSize(2, 18.0f);
        textView.setGravity(17);
        return textView;
    }

    public void setDialogListener(c cVar) {
        Button button = this.f18505i;
        if (button != null) {
            button.setOnClickListener(new a(cVar));
        }
        Button button2 = this.f18506j;
        if (button2 != null) {
            button2.setOnClickListener(new b(cVar));
        }
    }

    @Override // android.view.View
    public void setVisibility(int i10) {
        super.setVisibility(i10);
    }

    public void setduration(int i10) {
        this.f18507k = i10;
        TextView textView = this.f18508l;
        if (textView != null) {
            textView.setText(this.f18509m.c().replace("_SEC_", String.valueOf(this.f18507k)));
        }
    }
}
