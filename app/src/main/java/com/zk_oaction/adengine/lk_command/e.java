package com.zk_oaction.adengine.lk_command;

import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: classes5.dex */
public class e extends b {
    private Intent m;
    private Runnable n;

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                e eVar = e.this;
                eVar.f34813a.G.p(eVar.m);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public e(com.zk_oaction.adengine.lk_sdk.c cVar) {
        super(cVar);
        this.n = new a();
    }

    private void h(XmlPullParser xmlPullParser) {
        String attributeValue = xmlPullParser.getAttributeValue(null, "name");
        try {
            if (attributeValue != null) {
                this.m = (Intent) Intent.parseUri(attributeValue, 0).clone();
                return;
            }
            String attributeValue2 = xmlPullParser.getAttributeValue(null, "selectIntent");
            if (attributeValue2 != null) {
                int lastIndexOf = attributeValue2.lastIndexOf("#Intent");
                Intent parseUri = Intent.parseUri(attributeValue2.substring(0, lastIndexOf - 1), 0);
                if (this.f34813a.F.getPackageManager().queryIntentActivities(parseUri, 0).isEmpty()) {
                    parseUri = Intent.parseUri(attributeValue2.substring(lastIndexOf), 0);
                }
                this.m = (Intent) parseUri.clone();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void i(XmlPullParser xmlPullParser) {
        String attributeValue = xmlPullParser.getAttributeValue(null, "action");
        if (attributeValue != null) {
            this.m.setAction(attributeValue);
        }
        String attributeValue2 = xmlPullParser.getAttributeValue(null, "uri");
        if (attributeValue2 != null) {
            this.m.setData(Uri.parse(attributeValue2));
        }
        String attributeValue3 = xmlPullParser.getAttributeValue(null, "type");
        if (attributeValue3 != null) {
            this.m.setType(attributeValue3);
        }
        String attributeValue4 = xmlPullParser.getAttributeValue(null, "category");
        if (attributeValue4 != null) {
            this.m.addCategory(attributeValue4);
        }
        String attributeValue5 = xmlPullParser.getAttributeValue(null, "package");
        String attributeValue6 = xmlPullParser.getAttributeValue(null, "class");
        if (attributeValue5 != null && attributeValue6 != null) {
            this.m.setClassName(attributeValue5, attributeValue6);
        }
        this.f34814b = new com.zk_oaction.adengine.lk_expression.a(this.f34813a, null, xmlPullParser.getAttributeValue(null, "condition"), 1.0f, null, false);
        String attributeValue7 = xmlPullParser.getAttributeValue(null, "delay");
        if (attributeValue7 != null) {
            this.f34815c = Integer.parseInt(attributeValue7);
        }
        this.f34816d = new com.zk_oaction.adengine.lk_expression.a(this.f34813a, null, xmlPullParser.getAttributeValue(null, "delayCondition"), 1.0f, null, false);
    }

    @Override // com.zk_oaction.adengine.lk_command.b
    public void b() {
        this.f34814b.a((String) null, (String) null);
        if (this.f34814b.b() != 0.0f) {
            if (this.f34816d.b() != 1.0f || this.f34815c == 0) {
                this.n.run();
            } else {
                new Handler().postDelayed(this.n, this.f34815c);
            }
        }
    }

    @Override // com.zk_oaction.adengine.lk_command.b
    public boolean d(XmlPullParser xmlPullParser, String str) {
        try {
            this.m = new Intent();
            h(xmlPullParser);
            this.m.addFlags(DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP);
            i(xmlPullParser);
            return true;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }
}
