package mg;

/* loaded from: classes4.dex */
public class b implements mg.a {

    /* renamed from: a */
    public mg.a f28697a;

    public static class a {

        /* renamed from: a */
        public static b f28698a = new b();
    }

    public static b c() {
        return a.f28698a;
    }

    @Override // mg.a
    public void a(String str, String str2, String str3) {
        sg.a.d("KeyMonitor", str, str2, str3);
        mg.a aVar = this.f28697a;
        if (aVar != null) {
            aVar.a(str, str2, str3);
        }
    }

    @Override // mg.a
    public void b(String str, String str2, String str3, String str4, String str5) {
        sg.a.d(str, str2, str3, str4, str5);
        mg.a aVar = this.f28697a;
        if (aVar != null) {
            aVar.b(str, str2, str3, str4, str5);
        }
    }

    public void d(mg.a aVar) {
        this.f28697a = aVar;
    }
}
