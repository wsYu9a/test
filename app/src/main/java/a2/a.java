package a2;

/* loaded from: classes.dex */
public class a extends u3.a {
    public a(String str, String str2, long j10) {
        super(str, str2, j10);
    }

    public static a e(u3.a aVar) {
        if (aVar == null) {
            return null;
        }
        return new a(aVar.a(), aVar.b(), aVar.c());
    }
}
