package org.repackage.com.vivo.identifier;

import android.database.ContentObserver;
import android.util.Log;

/* loaded from: classes4.dex */
public class IdentifierIdObserver extends ContentObserver {

    /* renamed from: a */
    private static final String f29455a = "VMS_SDK_Observer";

    /* renamed from: b */
    private String f29456b;

    /* renamed from: c */
    private int f29457c;

    /* renamed from: d */
    private IdentifierIdClient f29458d;

    public IdentifierIdObserver(IdentifierIdClient identifierIdClient, int i10, String str) {
        super(null);
        this.f29458d = identifierIdClient;
        this.f29457c = i10;
        this.f29456b = str;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z10) {
        IdentifierIdClient identifierIdClient = this.f29458d;
        if (identifierIdClient != null) {
            identifierIdClient.a(this.f29457c, this.f29456b);
        } else {
            Log.e(f29455a, "mIdentifierIdClient is null");
        }
    }
}
