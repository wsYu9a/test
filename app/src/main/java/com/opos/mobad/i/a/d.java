package com.opos.mobad.i.a;

import android.content.Context;
import java.io.File;

/* loaded from: classes4.dex */
public final class d {
    public static File a(Context context, com.opos.mobad.i.a aVar) {
        if (context != null && aVar != null) {
            int i2 = aVar.f20983c;
            if (i2 == 0) {
                return new File(aVar.f20984d);
            }
            if (i2 == 1) {
                return new File(context.getFilesDir(), aVar.f20987g);
            }
            if (i2 == 2) {
                return new File(context.getDir(aVar.f20986f, aVar.f20985e), aVar.f20987g);
            }
        }
        return null;
    }

    public static File b(Context context, com.opos.mobad.i.a aVar) {
        if (context != null && aVar != null) {
            int i2 = aVar.f20983c;
            if (i2 == 0) {
                return new File(aVar.f20984d + ".tmp");
            }
            if (i2 == 1) {
                return new File(context.getFilesDir(), aVar.f20987g + ".tmp");
            }
            if (i2 == 2) {
                return new File(context.getDir(aVar.f20986f, aVar.f20985e), aVar.f20987g + ".tmp");
            }
        }
        return null;
    }

    public static File c(Context context, com.opos.mobad.i.a aVar) {
        if (context != null && aVar != null) {
            int i2 = aVar.f20983c;
            if (i2 == 0) {
                return new File(aVar.f20984d + ".pos");
            }
            if (i2 == 1) {
                return new File(context.getFilesDir(), aVar.f20987g + ".pos");
            }
            if (i2 == 2) {
                return new File(context.getDir(aVar.f20986f, aVar.f20985e), aVar.f20987g + ".pos");
            }
        }
        return null;
    }
}
