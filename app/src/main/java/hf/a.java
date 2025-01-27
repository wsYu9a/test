package hf;

import java.io.File;

/* loaded from: classes3.dex */
public final class a {
    public static File a(String str, te.b bVar) {
        File file = bVar.get(str);
        if (file == null || !file.exists()) {
            return null;
        }
        return file;
    }

    public static boolean b(String str, te.b bVar) {
        File file = bVar.get(str);
        return file != null && file.exists() && file.delete();
    }
}
