package com.opos.cmn.func.a.a;

import android.content.Context;
import java.io.File;

/* loaded from: classes4.dex */
public final class d {
    public static File a(Context context, com.opos.cmn.func.a.a aVar) {
        if (context != null && aVar != null) {
            int i2 = aVar.f17016c;
            if (i2 == 0) {
                return new File(aVar.f17017d);
            }
            if (i2 == 1) {
                return new File(context.getFilesDir(), aVar.f17020g);
            }
            if (i2 == 2) {
                return new File(context.getDir(aVar.f17019f, aVar.f17018e), aVar.f17020g);
            }
        }
        return null;
    }

    public static File b(Context context, com.opos.cmn.func.a.a aVar) {
        if (context != null && aVar != null) {
            int i2 = aVar.f17016c;
            if (i2 == 0) {
                return new File(aVar.f17017d + ".tmp");
            }
            if (i2 == 1) {
                return new File(context.getFilesDir(), aVar.f17020g + ".tmp");
            }
            if (i2 == 2) {
                return new File(context.getDir(aVar.f17019f, aVar.f17018e), aVar.f17020g + ".tmp");
            }
        }
        return null;
    }

    public static File c(Context context, com.opos.cmn.func.a.a aVar) {
        if (context != null && aVar != null) {
            int i2 = aVar.f17016c;
            if (i2 == 0) {
                return new File(aVar.f17017d + ".pos");
            }
            if (i2 == 1) {
                return new File(context.getFilesDir(), aVar.f17020g + ".pos");
            }
            if (i2 == 2) {
                return new File(context.getDir(aVar.f17019f, aVar.f17018e), aVar.f17020g + ".pos");
            }
        }
        return null;
    }
}
