package tf;

import android.graphics.PointF;
import android.view.View;
import sf.j;

/* loaded from: classes3.dex */
public class a implements j {

    /* renamed from: a */
    public PointF f30862a;

    /* renamed from: b */
    public j f30863b;

    /* renamed from: c */
    public boolean f30864c = true;

    @Override // sf.j
    public boolean a(View view) {
        j jVar = this.f30863b;
        return jVar != null ? jVar.a(view) : uf.c.b(view, this.f30862a);
    }

    @Override // sf.j
    public boolean b(View view) {
        j jVar = this.f30863b;
        return jVar != null ? jVar.b(view) : uf.c.a(view, this.f30862a, this.f30864c);
    }
}
