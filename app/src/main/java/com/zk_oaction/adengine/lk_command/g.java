package com.zk_oaction.adengine.lk_command;

import com.vivo.ic.dm.Downloads;
import java.util.ArrayList;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: classes5.dex */
public class g {

    /* renamed from: a */
    public String f34828a;

    /* renamed from: b */
    private com.zk_oaction.adengine.lk_sdk.c f34829b;

    /* renamed from: c */
    private String f34830c;

    /* renamed from: d */
    private String f34831d;

    /* renamed from: e */
    private String f34832e;

    /* renamed from: f */
    private com.zk_oaction.adengine.lk_sdk.interfaces.f f34833f;

    /* renamed from: g */
    private ArrayList<b> f34834g = new ArrayList<>();

    public g(com.zk_oaction.adengine.lk_sdk.c cVar) {
        this.f34829b = cVar;
    }

    private void b(XmlPullParser xmlPullParser) {
        String name = xmlPullParser.getName();
        b bVar = "Command".equals(name) ? new b(this.f34829b) : "SoundCommand".equals(name) ? new f(this.f34829b) : "VariableCommand".equals(name) ? new h(this.f34829b) : "ExternCommand".equals(name) ? new c(this.f34829b) : "IntentCommand".equals(name) ? new e(this.f34829b) : "VideoCommand".equals(name) ? new i(this.f34829b) : null;
        if (bVar == null || !bVar.d(xmlPullParser, "VariableCommand")) {
            return;
        }
        this.f34834g.add(bVar);
    }

    public void a() {
        String str = this.f34830c;
        if (str != null) {
            com.zk_oaction.adengine.lk_sdk.interfaces.f fVar = this.f34829b.L.get(str);
            this.f34833f = fVar;
            if (fVar != null && this.f34831d.equals(Downloads.Column.VISIBILITY)) {
                this.f34833f.a(this.f34832e);
            }
        }
        Iterator<b> it = this.f34834g.iterator();
        while (it.hasNext()) {
            it.next().b();
        }
    }

    public boolean c(XmlPullParser xmlPullParser, String str) {
        this.f34828a = xmlPullParser.getAttributeValue(null, "action");
        this.f34830c = xmlPullParser.getAttributeValue(null, "target");
        this.f34831d = xmlPullParser.getAttributeValue(null, "property");
        this.f34832e = xmlPullParser.getAttributeValue(null, Downloads.RequestHeaders.COLUMN_VALUE);
        try {
            int next = xmlPullParser.next();
            while (next != 1) {
                if (next == 2) {
                    b(xmlPullParser);
                } else if (next == 3 && xmlPullParser.getName().equals(str)) {
                    return true;
                }
                next = xmlPullParser.next();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return false;
    }
}
