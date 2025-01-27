package com.martian.mibook.j;

import android.graphics.Typeface;
import android.widget.TextView;
import com.martian.mibook.application.MiConfigSingleton;
import java.util.Hashtable;

/* loaded from: classes4.dex */
public class x2 {

    /* renamed from: a */
    private static final Hashtable<String, Typeface> f13700a = new Hashtable<>();

    public static void a() {
        f13700a.clear();
    }

    public static Typeface b(String name) {
        Hashtable<String, Typeface> hashtable = f13700a;
        Typeface typeface = hashtable.get(name);
        if (typeface == null) {
            try {
                typeface = Typeface.createFromFile(name);
                hashtable.put(name, typeface);
            } catch (Exception unused) {
                return null;
            }
        }
        return typeface;
    }

    public static void c(TextView textView) {
        Typeface b2;
        if (MiConfigSingleton.V3().B4().booleanValue()) {
            textView.getPaint().setTypeface(Typeface.DEFAULT);
            return;
        }
        String A4 = MiConfigSingleton.V3().A4();
        if (com.martian.libsupport.k.p(A4) || (b2 = b(A4)) == null) {
            return;
        }
        textView.getPaint().setTypeface(b2);
    }
}
