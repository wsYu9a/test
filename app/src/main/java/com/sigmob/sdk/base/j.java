package com.sigmob.sdk.base;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.czhj.sdk.common.Database.SQLiteBuider;
import com.czhj.sdk.common.models.AdStatus;
import com.czhj.sdk.logger.SigmobLog;
import com.sigmob.sdk.base.common.b0;
import com.sigmob.sdk.base.db.a;
import com.sigmob.sdk.base.models.LoadAdRequest;
import com.sigmob.sdk.base.models.SigMacroCommon;
import com.sigmob.sdk.base.models.rtb.BiddingResponse;
import com.sigmob.sdk.base.mta.PointCategory;
import com.sigmob.sdk.base.mta.PointEntitySigmobRequest;
import com.sigmob.windad.WindAdError;
import com.sigmob.windad.WindAdRequest;
import com.sigmob.windad.WindAds;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* loaded from: classes4.dex */
public abstract class j {

    /* renamed from: i */
    public static HashMap<String, e> f18155i = new HashMap<>();

    /* renamed from: a */
    public e f18156a;

    /* renamed from: c */
    public boolean f18158c;

    /* renamed from: d */
    public String f18159d;

    /* renamed from: e */
    public WindAdRequest f18160e;

    /* renamed from: g */
    public int f18162g;
    public AdStatus mADStatus = AdStatus.AdStatusNone;
    public int pIdEmpty_filters = 0;
    public int init_filters = 0;
    public int loadCount = 0;

    /* renamed from: b */
    public int f18157b = 0;

    /* renamed from: f */
    public int f18161f = 0;

    /* renamed from: h */
    public String f18163h = WindAds.CNY;

    public class a implements a.InterfaceC0569a {

        /* renamed from: a */
        public final /* synthetic */ String f18164a;

        /* renamed from: b */
        public final /* synthetic */ int f18165b;

        public a(String str, int i10) {
            this.f18164a = str;
            this.f18165b = i10;
        }

        @Override // com.sigmob.sdk.base.db.a.InterfaceC0569a
        public void onFailed(Throwable th2) {
            SigmobLog.e(this.f18164a + " insert  load error event " + this.f18165b + " onFailed: ", th2);
        }

        @Override // com.sigmob.sdk.base.db.a.InterfaceC0569a
        public void onSuccess() {
            SigmobLog.d(this.f18164a + " insert  load error event " + this.f18165b + " onSuccess: ");
        }
    }

    public class b implements b0.g {
        public b() {
        }

        @Override // com.sigmob.sdk.base.common.b0.g
        public void a(Object obj) {
            if (obj instanceof PointEntitySigmobRequest) {
                ((PointEntitySigmobRequest) obj).setAdx_id(null);
            }
        }
    }

    public class c implements b0.g {
        public c() {
        }

        @Override // com.sigmob.sdk.base.common.b0.g
        public void a(Object obj) {
            if (obj instanceof PointEntitySigmobRequest) {
                PointEntitySigmobRequest pointEntitySigmobRequest = (PointEntitySigmobRequest) obj;
                pointEntitySigmobRequest.setLoad_count(String.valueOf(j.this.f18156a.f18111b));
                pointEntitySigmobRequest.setInvalid_load_count(String.valueOf(j.this.f18156a.f18110a));
                pointEntitySigmobRequest.setGdpr_filters(String.valueOf(j.this.f18156a.f18112c));
                pointEntitySigmobRequest.setInterval_filters(String.valueOf(j.this.f18156a.f18113d));
                pointEntitySigmobRequest.setPldempty_filters(String.valueOf(j.this.pIdEmpty_filters));
                pointEntitySigmobRequest.setInit_filters(String.valueOf(j.this.f18156a.f18114e));
                pointEntitySigmobRequest.setLoading_filters(String.valueOf(j.this.f18156a.f18117h));
                pointEntitySigmobRequest.setProguard_filters(String.valueOf(j.this.f18156a.f18116g));
                if (!TextUtils.isEmpty(j.this.f18159d)) {
                    pointEntitySigmobRequest.setBid_token(j.this.f18159d);
                }
                pointEntitySigmobRequest.setAdx_id(null);
                HashMap hashMap = new HashMap();
                hashMap.put("is_minor", f.f().i() ? "0" : "1");
                hashMap.put("is_unpersonalized", f.f().j() ? "0" : "1");
                hashMap.put("personalized_filters", String.valueOf(j.this.f18156a.f18115f));
                pointEntitySigmobRequest.setOptions(hashMap);
            }
            j.this.c();
        }
    }

    public j(WindAdRequest windAdRequest, boolean z10) {
        this.f18160e = windAdRequest;
        windAdRequest.setHalfInterstitial(z10);
    }

    public abstract Map<String, BiddingResponse> a();

    public abstract void a(WindAdError windAdError);

    public abstract void a(String str, String str2);

    public void d() {
        b0.a("request", PointCategory.INIT, this.f18160e, (LoadAdRequest) null, new c());
    }

    public int getBidFloor() {
        return this.f18162g;
    }

    public String getBid_token() {
        return this.f18159d;
    }

    public String getCurrency() {
        return this.f18163h;
    }

    public abstract String getEcpm();

    public boolean loadAd() {
        this.f18158c = false;
        this.f18159d = null;
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0110  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean loadAdFilter() {
        /*
            Method dump skipped, instructions count: 342
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sigmob.sdk.base.j.loadAdFilter():boolean");
    }

    public void sendLossNotificationWithInfo(Map<String, Object> map) {
        Set<String> keySet;
        String str;
        try {
            if (a() == null || (keySet = a().keySet()) == null || keySet.size() <= 0) {
                return;
            }
            for (String str2 : keySet) {
                BiddingResponse biddingResponse = a().get(str2);
                if (biddingResponse != null) {
                    String str3 = biddingResponse.lose_url;
                    if (!TextUtils.isEmpty(str3)) {
                        if (map != null && map.size() > 0) {
                            if (map.get(WindAds.AUCTION_PRICE) != null) {
                                a(SigMacroCommon._PUBLISHERPRICE_, String.valueOf(map.get(WindAds.AUCTION_PRICE)));
                                str3 = str3.replace("__AUCTION_PRICE__", String.valueOf(map.get(WindAds.AUCTION_PRICE)));
                            }
                            if (map.get(WindAds.CURRENCY) != null) {
                                a(SigMacroCommon._CURRENCY_, String.valueOf(map.get(WindAds.CURRENCY)));
                                str = String.valueOf(map.get(WindAds.CURRENCY));
                            } else {
                                a(SigMacroCommon._CURRENCY_, this.f18163h);
                                str = this.f18163h;
                            }
                            str3 = str3.replace("__CURRENCY__", str);
                            if (map.get(WindAds.LOSS_REASON) != null) {
                                str3 = str3.replace("_BIDLOSSCODE_", String.valueOf(map.get(WindAds.LOSS_REASON)));
                            }
                            if (map.get(WindAds.ADN_ID) != null) {
                                str3 = str3.replace("_WINADNID_", String.valueOf(map.get(WindAds.ADN_ID)));
                            }
                        }
                        com.sigmob.sdk.base.network.b.a(str3, PointCategory.LOSE, this.f18160e, str2);
                    }
                }
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public void sendWinNotificationWithInfo(Map<String, Object> map) {
        Set<String> keySet;
        String str;
        try {
            if (a() == null || (keySet = a().keySet()) == null || keySet.size() <= 0) {
                return;
            }
            for (String str2 : keySet) {
                BiddingResponse biddingResponse = a().get(str2);
                if (biddingResponse != null) {
                    String str3 = biddingResponse.win_url;
                    if (!TextUtils.isEmpty(str3)) {
                        if (map != null && map.size() > 0) {
                            if (map.get(WindAds.AUCTION_PRICE) != null) {
                                a(SigMacroCommon._PUBLISHERPRICE_, String.valueOf(map.get(WindAds.AUCTION_PRICE)));
                                str3 = str3.replace("__AUCTION_PRICE__", String.valueOf(map.get(WindAds.AUCTION_PRICE)));
                            }
                            if (map.get(WindAds.HIGHEST_LOSS_PRICE) != null) {
                                a(SigMacroCommon._HIGHESTLOSSPRICE_, String.valueOf(map.get(WindAds.HIGHEST_LOSS_PRICE)));
                                str3 = str3.replace("__HIGHEST_LOSS_PRICE__", String.valueOf(map.get(WindAds.HIGHEST_LOSS_PRICE)));
                            }
                            if (map.get(WindAds.CURRENCY) != null) {
                                a(SigMacroCommon._CURRENCY_, String.valueOf(map.get(WindAds.CURRENCY)));
                                str = String.valueOf(map.get(WindAds.CURRENCY));
                            } else {
                                a(SigMacroCommon._CURRENCY_, this.f18163h);
                                str = this.f18163h;
                            }
                            str3 = str3.replace("__CURRENCY__", str);
                        }
                        com.sigmob.sdk.base.network.b.a(str3, PointCategory.WIN, this.f18160e, str2);
                    }
                }
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public void setBidEcpm(int i10) {
        a(SigMacroCommon._PUBLISHERPRICE_, String.valueOf(i10));
    }

    public void setBidFloor(int i10) {
        this.f18162g = i10;
    }

    public void setCurrency(String str) {
        this.f18163h = str;
    }

    public final void a(String str, int i10) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            SQLiteDatabase writableDatabase = com.sigmob.sdk.base.db.a.b().getWritableDatabase();
            SQLiteBuider.Insert.Builder builder = new SQLiteBuider.Insert.Builder();
            builder.setTableName(com.sigmob.sdk.base.db.a.f18093f);
            HashMap hashMap = new HashMap();
            hashMap.put("adslot_id", str);
            hashMap.put("error_code", Integer.valueOf(i10));
            hashMap.put(o3.a.f29032k, Long.valueOf(System.currentTimeMillis()));
            builder.setColumnValues(hashMap);
            com.sigmob.sdk.base.db.a.b().a(writableDatabase, builder.build(), new a(str, i10));
        } catch (Throwable th2) {
            SigmobLog.e(th2.getMessage());
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0031, code lost:
    
        if (r1.isClosed() == false) goto L63;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.sigmob.sdk.base.e b(java.lang.String r6) {
        /*
            r5 = this;
            com.sigmob.sdk.base.e r0 = new com.sigmob.sdk.base.e
            r0.<init>()
            r1 = 0
            com.sigmob.sdk.base.db.a r2 = com.sigmob.sdk.base.db.a.b()     // Catch: java.lang.Throwable -> L34
            android.database.sqlite.SQLiteDatabase r2 = r2.getReadableDatabase()     // Catch: java.lang.Throwable -> L34
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L34
            r3.<init>()     // Catch: java.lang.Throwable -> L34
            java.lang.String r4 = "select error_code, count(*) as num from adload_event where adslot_id = '"
            r3.append(r4)     // Catch: java.lang.Throwable -> L34
            r3.append(r6)     // Catch: java.lang.Throwable -> L34
            java.lang.String r6 = "' group by adslot_id"
            r3.append(r6)     // Catch: java.lang.Throwable -> L34
            java.lang.String r6 = r3.toString()     // Catch: java.lang.Throwable -> L34
            android.database.Cursor r1 = r2.rawQuery(r6, r1)     // Catch: java.lang.Throwable -> L34
            r5.a(r0, r1)     // Catch: java.lang.Throwable -> L34
            if (r1 == 0) goto L47
            boolean r6 = r1.isClosed()
            if (r6 != 0) goto L47
            goto L44
        L34:
            r6 = move-exception
            java.lang.String r6 = r6.getMessage()     // Catch: java.lang.Throwable -> L48
            com.czhj.sdk.logger.SigmobLog.e(r6)     // Catch: java.lang.Throwable -> L48
            if (r1 == 0) goto L47
            boolean r6 = r1.isClosed()
            if (r6 != 0) goto L47
        L44:
            r1.close()
        L47:
            return r0
        L48:
            r6 = move-exception
            if (r1 == 0) goto L54
            boolean r0 = r1.isClosed()
            if (r0 != 0) goto L54
            r1.close()
        L54:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sigmob.sdk.base.j.b(java.lang.String):com.sigmob.sdk.base.e");
    }

    public final void c() {
        this.pIdEmpty_filters = 0;
        a(b());
        this.f18156a.a();
    }

    public boolean loadAd(String str) {
        this.f18158c = true;
        this.f18159d = str;
        return false;
    }

    public final void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            com.sigmob.sdk.base.db.a.b().getWritableDatabase().delete(com.sigmob.sdk.base.db.a.f18093f, "adslot_id=?", new String[]{str});
        } catch (Throwable th2) {
            SigmobLog.e(th2.getMessage());
        }
    }

    public String b() {
        WindAdRequest windAdRequest = this.f18160e;
        if (windAdRequest != null) {
            return windAdRequest.getPlacementId();
        }
        return null;
    }

    public final void a(e eVar, Cursor cursor) {
        if (cursor == null || !cursor.moveToFirst()) {
            return;
        }
        int i10 = cursor.getInt(cursor.getColumnIndexOrThrow("error_code"));
        int i11 = cursor.getInt(cursor.getColumnIndexOrThrow("num"));
        do {
            if (i10 != 0) {
                eVar.f18110a = i11;
            }
            eVar.f18111b += i11;
            switch (i10) {
                case 600200:
                case 600201:
                case 600203:
                case 600204:
                    eVar.f18116g = i11;
                    break;
                case 600900:
                    eVar.f18114e = i11;
                    break;
                case 600905:
                    eVar.f18112c = i11;
                    break;
                case 610012:
                    eVar.f18117h = i11;
                    break;
                case 610013:
                    eVar.f18113d = i11;
                    break;
            }
        } while (cursor.moveToNext());
    }

    public void a(boolean z10) {
        this.f18158c = z10;
    }
}
