package com.opos.mobad.h;

import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import com.opos.mobad.model.data.AdItemData;
import com.opos.mobad.model.data.MaterialData;

/* loaded from: classes4.dex */
public final class f {

    /* renamed from: com.opos.mobad.h.f$1 */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a */
        static final /* synthetic */ int[] f20980a;

        static {
            int[] iArr = new int[com.opos.mobad.cmn.a.b.a.values().length];
            f20980a = iArr;
            try {
                iArr[com.opos.mobad.cmn.a.b.a.NonClickBt.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f20980a[com.opos.mobad.cmn.a.b.a.ClickBt.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f20980a[com.opos.mobad.cmn.a.b.a.Video.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f20980a[com.opos.mobad.cmn.a.b.a.FloatLayerClickBt.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f20980a[com.opos.mobad.cmn.a.b.a.FloatLayerNonClickBt.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public static Bitmap a(String str, int i2, int i3) {
        if (!com.opos.cmn.an.c.a.a(str)) {
            try {
                return com.opos.cmn.an.d.c.a.a(str, i2, i3);
            } catch (Throwable th) {
                com.opos.cmn.an.f.a.a("Utils", "", th);
            }
        }
        return null;
    }

    public static boolean a(View view, View view2) {
        if (view == null || view2 == null) {
            return false;
        }
        ViewGroup viewGroup = view instanceof ViewGroup ? (ViewGroup) view : null;
        if (viewGroup == null) {
            return false;
        }
        if (viewGroup.indexOfChild(view2) < 0) {
            int childCount = viewGroup.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                if (viewGroup.getChildAt(i2) == null || !(viewGroup.getChildAt(i2) instanceof ViewGroup) || !a(viewGroup.getChildAt(i2), view2)) {
                }
            }
            return false;
        }
        return true;
    }

    public static boolean a(AdItemData adItemData, com.opos.mobad.cmn.a.b.a aVar) {
        MaterialData materialData;
        int i2;
        boolean z = false;
        if (adItemData != null && (materialData = adItemData.i().get(0)) != null && ((i2 = AnonymousClass1.f20980a[aVar.ordinal()]) == 1 ? materialData.J() != 0 : !(i2 == 2 ? materialData.e() == 0 : i2 == 3 ? materialData.K() == 0 : i2 == 4 ? materialData.V() == 0 : i2 != 5 || materialData.W() == 0))) {
            z = true;
        }
        com.opos.cmn.an.f.a.b("Utils", "isValidClickWithInteraction result =" + z);
        return z;
    }
}
