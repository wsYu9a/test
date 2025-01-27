package b.g.a.b;

import java.io.File;

/* loaded from: classes4.dex */
public final class a {
    private a() {
    }

    public static File a(String str, b.g.a.a.a.b bVar) {
        File file = bVar.get(str);
        if (file == null || !file.exists()) {
            return null;
        }
        return file;
    }

    public static boolean b(String str, b.g.a.a.a.b bVar) {
        File file = bVar.get(str);
        return file != null && file.exists() && file.delete();
    }
}
