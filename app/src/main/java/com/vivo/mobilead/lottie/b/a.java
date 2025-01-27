package com.vivo.mobilead.lottie.b;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.vivo.mobilead.lottie.FontAssetDelegate;
import com.vivo.mobilead.lottie.c.i;
import com.vivo.mobilead.lottie.f.d;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes4.dex */
public class a {

    /* renamed from: d */
    private final AssetManager f29121d;

    /* renamed from: e */
    private FontAssetDelegate f29122e;

    /* renamed from: a */
    private final i<String> f29118a = new i<>();

    /* renamed from: b */
    private final Map<i<String>, Typeface> f29119b = new HashMap();

    /* renamed from: c */
    private final Map<String, Typeface> f29120c = new HashMap();

    /* renamed from: f */
    private String f29123f = ".ttf";

    public a(Drawable.Callback callback, FontAssetDelegate fontAssetDelegate) {
        AssetManager assets;
        this.f29122e = fontAssetDelegate;
        if (callback instanceof View) {
            assets = ((View) callback).getContext().getAssets();
        } else {
            d.b("LottieDrawable must be inside of a view for images to work.");
            assets = null;
        }
        this.f29121d = assets;
    }

    private Typeface a(Typeface typeface, String str) {
        boolean contains = str.contains("Italic");
        boolean contains2 = str.contains("Bold");
        int i2 = (contains && contains2) ? 3 : contains ? 2 : contains2 ? 1 : 0;
        return typeface.getStyle() == i2 ? typeface : Typeface.create(typeface, i2);
    }

    private Typeface a(String str) {
        String fontPath;
        Typeface typeface = this.f29120c.get(str);
        if (typeface != null) {
            return typeface;
        }
        FontAssetDelegate fontAssetDelegate = this.f29122e;
        Typeface fetchFont = fontAssetDelegate != null ? fontAssetDelegate.fetchFont(str) : null;
        FontAssetDelegate fontAssetDelegate2 = this.f29122e;
        if (fontAssetDelegate2 != null && fetchFont == null && (fontPath = fontAssetDelegate2.getFontPath(str)) != null) {
            fetchFont = Typeface.createFromAsset(this.f29121d, fontPath);
        }
        if (fetchFont == null) {
            fetchFont = Typeface.createFromAsset(this.f29121d, "fonts/" + str + this.f29123f);
        }
        this.f29120c.put(str, fetchFont);
        return fetchFont;
    }

    public Typeface a(String str, String str2) {
        this.f29118a.a(str, str2);
        Typeface typeface = this.f29119b.get(this.f29118a);
        if (typeface != null) {
            return typeface;
        }
        Typeface a2 = a(a(str), str2);
        this.f29119b.put(this.f29118a, a2);
        return a2;
    }

    public void a(FontAssetDelegate fontAssetDelegate) {
        this.f29122e = fontAssetDelegate;
    }
}
