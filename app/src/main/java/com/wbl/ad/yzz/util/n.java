package com.wbl.ad.yzz.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.Html;
import android.widget.TextView;
import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import com.wbl.ad.yzz.util.o;

/* loaded from: classes5.dex */
public class n implements Html.ImageGetter {

    /* renamed from: a */
    public b f34361a = null;

    /* renamed from: b */
    public TextView f34362b;

    /* renamed from: c */
    public Context f34363c;

    public class a implements o.a {
        public a() {
        }

        @Override // com.wbl.ad.yzz.util.o.a
        public void a(Bitmap bitmap) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8353, this, bitmap);
        }
    }

    public class b extends BitmapDrawable {

        /* renamed from: a */
        public Bitmap f34365a;

        public b(n nVar) {
        }

        @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8356, this, canvas);
        }
    }

    public n(Context context, TextView textView) {
        this.f34362b = textView;
        this.f34363c = context;
    }

    public static /* synthetic */ Context a(n nVar) {
        return (Context) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-8355, null, nVar);
    }

    public static /* synthetic */ Bitmap a(n nVar, Bitmap bitmap) {
        return (Bitmap) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-8382, null, nVar, bitmap);
    }

    public static /* synthetic */ b b(n nVar) {
        return (b) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-8381, null, nVar);
    }

    public static /* synthetic */ TextView c(n nVar) {
        return (TextView) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-8384, null, nVar);
    }

    public final Bitmap a(Bitmap bitmap) {
        return (Bitmap) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-8383, this, bitmap);
    }

    @Override // android.text.Html.ImageGetter
    public Drawable getDrawable(String str) {
        return (Drawable) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-8378, this, str);
    }
}
