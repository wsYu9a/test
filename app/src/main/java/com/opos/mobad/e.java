package com.opos.mobad;

import android.app.Activity;
import android.content.Context;

/* loaded from: classes4.dex */
public class e extends f {

    /* renamed from: com.opos.mobad.e$1 */
    class AnonymousClass1 implements com.opos.mobad.activity.webview.a {
        AnonymousClass1() {
        }

        @Override // com.opos.mobad.activity.webview.a
        public com.opos.mobad.activity.webview.a.b a(Activity activity, com.opos.cmn.biz.web.c.b.c cVar, com.opos.mobad.activity.webview.b.b bVar) {
            return new com.opos.mobad.activity.webview.a.b(activity, cVar, bVar);
        }
    }

    public e(Context context, int i2) {
        super(new i(), new a(), new com.opos.mobad.activity.webview.a() { // from class: com.opos.mobad.e.1
            AnonymousClass1() {
            }

            @Override // com.opos.mobad.activity.webview.a
            public com.opos.mobad.activity.webview.a.b a(Activity activity, com.opos.cmn.biz.web.c.b.c cVar, com.opos.mobad.activity.webview.b.b bVar) {
                return new com.opos.mobad.activity.webview.a.b(activity, cVar, bVar);
            }
        }, new g());
    }
}
