package com.czhj.sdk.common.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.czhj.sdk.common.Constants;
import com.czhj.sdk.common.utils.PlayServicesUtil;
import com.czhj.sdk.common.utils.Preconditions;
import com.czhj.sdk.logger.SigmobLog;
import java.util.Calendar;

/* loaded from: classes2.dex */
public class IdentifierManager {

    /* renamed from: h */
    public static final String f8609h = "com.Sigmob.settings.identifier";

    /* renamed from: i */
    public static final String f8610i = "privacy.identifier.ifa";

    /* renamed from: j */
    public static final String f8611j = "privacy.identifier.ifa_aes_gcm";

    /* renamed from: k */
    public static final String f8612k = "privacy.identifier.Sigmob";

    /* renamed from: l */
    public static final String f8613l = "privacy.identifier.time";

    /* renamed from: m */
    public static final String f8614m = "privacy.limit.ad.tracking";

    /* renamed from: n */
    public static final int f8615n = -1;

    /* renamed from: a */
    public long f8616a;

    /* renamed from: b */
    public AdvertisingId f8617b;

    /* renamed from: c */
    public Context f8618c;

    /* renamed from: d */
    public AdvertisingIdChangeListener f8619d;

    /* renamed from: e */
    public boolean f8620e;

    /* renamed from: f */
    public boolean f8621f;

    /* renamed from: g */
    public SdkInitializationListener f8622g;

    public interface AdvertisingIdChangeListener {
        void onIdChanged(AdvertisingId advertisingId, AdvertisingId advertisingId2);
    }

    public class RefreshAdvertisingInfoAsyncTask extends AsyncTask<Void, Void, Void> {
        public RefreshAdvertisingInfoAsyncTask() {
        }

        public /* synthetic */ RefreshAdvertisingInfoAsyncTask(IdentifierManager identifierManager, AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // android.os.AsyncTask
        public Void doInBackground(Void... voidArr) {
            IdentifierManager.this.c();
            IdentifierManager.this.f8620e = false;
            return null;
        }
    }

    public interface SdkInitializationListener {
        void onInitializationFinished();
    }

    public IdentifierManager(Context context, AdvertisingIdChangeListener advertisingIdChangeListener) {
    }

    public final boolean a() {
        return true;
    }

    public final void b() {
        if (this.f8620e) {
            return;
        }
        this.f8620e = true;
        new RefreshAdvertisingInfoAsyncTask().execute(new Void[0]);
    }

    public final void c() {
        PlayServicesUtil.AdvertisingInfo advertisingInfo;
        long timeInMillis = Calendar.getInstance().getTimeInMillis();
        if (a()) {
            try {
                advertisingInfo = PlayServicesUtil.getAdvertisingIdInfo(this.f8618c);
            } catch (Throwable unused) {
                advertisingInfo = null;
            }
            if (advertisingInfo != null) {
                AdvertisingId advertisingId = this.f8617b;
                if (advertisingInfo.limitAdTracking && advertisingId.b()) {
                    a(advertisingInfo.advertisingId, AdvertisingId.a(), advertisingInfo.limitAdTracking, timeInMillis);
                } else {
                    a(advertisingInfo.advertisingId, advertisingId.f8577b, advertisingInfo.limitAdTracking, advertisingId.f8576a.getTimeInMillis());
                }
            }
        }
    }

    public final void d() {
        SdkInitializationListener sdkInitializationListener = this.f8622g;
        if (sdkInitializationListener != null) {
            sdkInitializationListener.onInitializationFinished();
            this.f8622g = null;
        }
        this.f8621f = true;
    }

    public AdvertisingId getAdvertisingInfo() {
        AdvertisingId advertisingId = this.f8617b;
        this.f8616a = System.currentTimeMillis();
        return advertisingId;
    }

    public final void a(AdvertisingId advertisingId, AdvertisingId advertisingId2) {
        Preconditions.NoThrow.checkNotNull(advertisingId2);
        AdvertisingIdChangeListener advertisingIdChangeListener = this.f8619d;
        if (advertisingIdChangeListener != null) {
            advertisingIdChangeListener.onIdChanged(advertisingId, advertisingId2);
        }
    }

    public static synchronized AdvertisingId a(Context context) {
        synchronized (IdentifierManager.class) {
            Preconditions.NoThrow.checkNotNull(context);
            Calendar calendar = Calendar.getInstance();
            try {
                SharedPreferences sharedPreferences = SharedPreferencesUtil.getSharedPreferences(context, f8609h);
                String string = sharedPreferences.getString(f8611j, "");
                String DecryptString = !TextUtils.isEmpty(string) ? AESUtil.DecryptString(string, Constants.AESKEY) : sharedPreferences.getString(f8610i, "");
                String string2 = sharedPreferences.getString(f8612k, "");
                long j10 = sharedPreferences.getLong(f8613l, calendar.getTimeInMillis());
                boolean z10 = sharedPreferences.getBoolean(f8614m, false);
                if (!TextUtils.isEmpty(DecryptString) && !TextUtils.isEmpty(string2)) {
                    return new AdvertisingId(DecryptString, string2, z10, j10);
                }
            } catch (Throwable unused) {
                SigmobLog.e("Cannot read identifier from shared preferences");
            }
            return null;
        }
    }

    public final void a(AdvertisingId advertisingId) {
        AdvertisingId advertisingId2 = this.f8617b;
        this.f8617b = advertisingId;
        a(this.f8618c, advertisingId);
        if (!this.f8617b.equals(advertisingId2) || !this.f8621f) {
            a(advertisingId2, this.f8617b);
        }
        if (this.f8621f) {
            return;
        }
        d();
    }

    public final void a(String str, String str2, boolean z10, long j10) {
        Preconditions.NoThrow.checkNotNull(str);
        Preconditions.NoThrow.checkNotNull(str2);
        a(new AdvertisingId(str, str2, z10, j10));
    }

    public static synchronized void a(Context context, AdvertisingId advertisingId) {
        synchronized (IdentifierManager.class) {
            Preconditions.NoThrow.checkNotNull(context);
            Preconditions.NoThrow.checkNotNull(advertisingId);
            SharedPreferences.Editor edit = SharedPreferencesUtil.getSharedPreferences(context, f8609h).edit();
            edit.putBoolean(f8614m, advertisingId.mDoNotTrack);
            edit.remove(f8610i);
            edit.putString(f8611j, AESUtil.EncryptString(advertisingId.mAdvertisingId, Constants.AESKEY));
            edit.putString(f8612k, advertisingId.f8577b);
            edit.putLong(f8613l, advertisingId.f8576a.getTimeInMillis());
            edit.apply();
        }
    }
}
