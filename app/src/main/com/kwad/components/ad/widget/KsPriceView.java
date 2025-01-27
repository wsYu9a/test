package com.kwad.components.ad.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StrikethroughSpan;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.kwad.components.core.widget.d;
import com.kwad.components.core.widget.e;
import com.kwad.sdk.R;
import com.kwad.sdk.core.d.c;

@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes2.dex */
public class KsPriceView extends TextView implements d {
    private static String Kf = "¥%s 到手约 ¥%s";
    private static String Kg = "¥%s  ¥%s";
    private static String Kh = "¥%s";
    private a Ke;
    private String Ki;
    private String Kj;
    private boolean Kk;

    public static class a {
        private int Kl;
        private int Km;
        private int Kn;
        private int Ko;
        private int Kp;
        private int Kq;

        public final a af(int i10) {
            this.Km = i10;
            return this;
        }

        public final a ag(int i10) {
            this.Kp = i10;
            return this;
        }

        public final a ah(int i10) {
            this.Kq = i10;
            return this;
        }

        public final int na() {
            return this.Kn;
        }

        public final int nb() {
            return this.Kp;
        }

        public final int nc() {
            return this.Ko;
        }

        public final int nd() {
            return this.Kq;
        }

        public final int ne() {
            return this.Kl;
        }

        public final int nf() {
            return this.Km;
        }
    }

    public KsPriceView(Context context) {
        super(context);
        this.Ke = new a();
        R(context);
    }

    private void R(Context context) {
        setMaxLines(1);
        this.Ke.Kn = context.getResources().getColor(R.color.ksad_reward_main_color);
        this.Ke.Ko = context.getResources().getDimensionPixelSize(R.dimen.ksad_reward_order_price_size);
        this.Ke.Kp = context.getResources().getColor(R.color.ksad_reward_original_price);
        this.Ke.Kq = context.getResources().getDimensionPixelSize(R.dimen.ksad_reward_order_original_price_size);
        this.Ke.Kl = context.getResources().getColor(R.color.ksad_reward_main_color);
        this.Ke.Km = context.getResources().getDimensionPixelSize(R.dimen.ksad_reward_order_price_size);
    }

    @Nullable
    private static SpannableString a(String str, @Nullable String str2, boolean z10, a aVar) {
        String format;
        if (str2 == null) {
            format = String.format(Kh, str);
        } else {
            format = String.format(z10 ? Kg : Kf, str, str2);
        }
        SpannableString spannableString = new SpannableString(format);
        if (format.startsWith("¥")) {
            spannableString.setSpan(new ForegroundColorSpan(aVar.ne()), 0, 1, 17);
            spannableString.setSpan(new AbsoluteSizeSpan(aVar.nf()), 0, 1, 17);
        }
        int indexOf = format.indexOf(str);
        if (indexOf < 0) {
            return null;
        }
        int length = str.length() + indexOf;
        spannableString.setSpan(new ForegroundColorSpan(aVar.na()), indexOf, length, 18);
        spannableString.setSpan(new AbsoluteSizeSpan(aVar.nc()), indexOf, length, 18);
        if (str2 != null) {
            int lastIndexOf = format.lastIndexOf(str2) - 1;
            int length2 = str2.length() + 1 + lastIndexOf;
            spannableString.setSpan(new ForegroundColorSpan(aVar.nb()), lastIndexOf, length2, 18);
            spannableString.setSpan(new AbsoluteSizeSpan(aVar.nd()), lastIndexOf, length2, 18);
            spannableString.setSpan(new StrikethroughSpan(), lastIndexOf, length2, 18);
        }
        return spannableString;
    }

    public final void d(String str, String str2, boolean z10) {
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            return;
        }
        this.Ki = str;
        this.Kj = str2;
        this.Kk = z10;
        SpannableString spannableString = null;
        if (TextUtils.isEmpty(str2)) {
            this.Kj = null;
        }
        if (str != null && str.startsWith("¥")) {
            str = str.replaceFirst("¥", "");
        }
        setTextColor(this.Ke.na());
        try {
            spannableString = a(str, this.Kj, z10, this.Ke);
        } catch (Exception e10) {
            c.printStackTraceOnly(e10);
        }
        if (spannableString != null) {
            setText(spannableString);
        }
    }

    @NonNull
    public a getConfig() {
        return this.Ke;
    }

    public final void h(String str, String str2) {
        d(str, str2, false);
    }

    public KsPriceView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Ke = new a();
        R(context);
    }

    public KsPriceView(Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.Ke = new a();
        R(context);
    }

    @RequiresApi(api = 21)
    public KsPriceView(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        this.Ke = new a();
        R(context);
    }

    @Override // com.kwad.components.core.widget.d
    public final void a(e eVar) {
        this.Ke.Kn = eVar.uB();
        d(this.Ki, this.Kj, this.Kk);
    }
}
