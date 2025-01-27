package com.sigmob.sdk.base.common;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import com.czhj.sdk.logger.SigmobLog;
import com.sigmob.sdk.base.common.b0;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.mta.PointEntitySigmob;
import java.util.ArrayList;

/* loaded from: classes4.dex */
public class MiMarketManager {

    /* renamed from: a */
    public static final int f17632a = 0;

    /* renamed from: b */
    public static final int f17633b = 1;

    /* renamed from: c */
    public static final int f17634c = 2;

    /* renamed from: d */
    public static final int f17635d = 3;

    public static class DirectMailStatusReceiver extends BroadcastReceiver {

        /* renamed from: b */
        public static final String f17636b = "com.xiaomi.market.DIRECT_MAIL_CHECK_RESULT";

        /* renamed from: c */
        public static final String f17637c = "com.xiaomi.market.DIRECT_MAIL_STATUS";

        /* renamed from: d */
        public static final String f17638d = "com.xiaomi.market.DIRECT_MAIL_DOWNLOAD_PROGRESS";

        /* renamed from: a */
        public BaseAdUnit f17639a;

        public class a implements b0.g {

            /* renamed from: a */
            public final /* synthetic */ String f17640a;

            public a(String str) {
                this.f17640a = str;
            }

            @Override // com.sigmob.sdk.base.common.b0.g
            public void a(Object obj) {
                if (obj instanceof PointEntitySigmob) {
                    ((PointEntitySigmob) obj).getOptions().put("packageName", this.f17640a);
                }
            }
        }

        public class b implements b0.g {

            /* renamed from: a */
            public final /* synthetic */ String f17642a;

            public b(String str) {
                this.f17642a = str;
            }

            @Override // com.sigmob.sdk.base.common.b0.g
            public void a(Object obj) {
                if (obj instanceof PointEntitySigmob) {
                    ((PointEntitySigmob) obj).getOptions().put("packageName", this.f17642a);
                }
            }
        }

        public class c implements b0.g {

            /* renamed from: a */
            public final /* synthetic */ String f17644a;

            public c(String str) {
                this.f17644a = str;
            }

            @Override // com.sigmob.sdk.base.common.b0.g
            public void a(Object obj) {
                if (obj instanceof PointEntitySigmob) {
                    ((PointEntitySigmob) obj).getOptions().put("packageName", this.f17644a);
                }
            }
        }

        public void a(Context context, BaseAdUnit baseAdUnit) {
            if (context == null) {
                return;
            }
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(f17636b);
            intentFilter.addAction(f17637c);
            intentFilter.addAction(f17638d);
            this.f17639a = baseAdUnit;
            u.a(context, this, intentFilter);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            int i10;
            String string;
            StringBuilder sb2;
            String str;
            String action = intent.getAction();
            action.hashCode();
            switch (action) {
                case "com.xiaomi.market.DIRECT_MAIL_STATUS":
                    Bundle extras = intent.getExtras();
                    int i11 = extras.getInt("statusCode");
                    String string2 = extras.getString("packageName");
                    SigmobLog.d("MiMarketManager: statusCode:" + i11 + " packageName:" + string2);
                    b0.a("mimarket_status", String.valueOf(i11), this.f17639a, new b(string2));
                    return;
                case "com.xiaomi.market.DIRECT_MAIL_DOWNLOAD_PROGRESS":
                    Bundle extras2 = intent.getExtras();
                    i10 = extras2.getInt("downloadProgress");
                    string = extras2.getString("packageName");
                    b0.a("mimarket_download_progress", String.valueOf(i10), this.f17639a, new c(string));
                    sb2 = new StringBuilder();
                    str = "MiMarketManager: downloadProgress:";
                    break;
                case "com.xiaomi.market.DIRECT_MAIL_CHECK_RESULT":
                    Bundle extras3 = intent.getExtras();
                    i10 = extras3.getInt("styleCheckResult");
                    string = extras3.getString("packageName");
                    b0.a("mimarket_check_result", i10 == 0 ? "1" : "0", this.f17639a, new a(string));
                    sb2 = new StringBuilder();
                    str = "MiMarketManager: styleResult:";
                    break;
                default:
                    return;
            }
            sb2.append(str);
            sb2.append(i10);
            sb2.append(" packageName:");
            sb2.append(string);
            SigmobLog.d(sb2.toString());
        }
    }

    public static void a(Context context, ArrayList<String> arrayList) {
        ArrayList<Bundle> parcelableArrayList;
        Bundle bundle = new Bundle();
        bundle.putStringArrayList("packageNames", arrayList);
        Bundle call = context.getContentResolver().call(Uri.parse("content://com.xiaomi.market.provider.DirectMailProvider/status"), "queryDownloadStatus", (String) null, bundle);
        if (call == null || (parcelableArrayList = call.getParcelableArrayList("packageNames")) == null || parcelableArrayList.size() <= 0) {
            return;
        }
        for (Bundle bundle2 : parcelableArrayList) {
            SigmobLog.d("packageName=" + bundle2.getString("packageName") + ",status=" + bundle2.getInt("status") + ",progress=" + bundle2.getInt("progress"));
        }
    }

    public static void b(Context context, ArrayList<String> arrayList) {
        Cursor cursor = null;
        try {
            cursor = context.getContentResolver().query(Uri.parse("content://com.xiaomi.market.provider.DirectMailProvider/referrer"), null, null, null, null);
            while (cursor != null) {
                if (!cursor.moveToFirst()) {
                    break;
                }
                cursor.getString(0);
                cursor.getString(1);
                cursor.getString(2);
                cursor.getString(3);
            }
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }
}
