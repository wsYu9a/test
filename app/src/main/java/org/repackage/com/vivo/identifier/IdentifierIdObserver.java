package org.repackage.com.vivo.identifier;

import android.database.ContentObserver;
import android.util.Log;

/* loaded from: classes5.dex */
public class IdentifierIdObserver extends ContentObserver {

    /* renamed from: a */
    private static final String f35615a = "VMS_IDLG_SDK_Observer";

    /* renamed from: b */
    private String f35616b;

    /* renamed from: c */
    private int f35617c;

    /* renamed from: d */
    private IdentifierIdClient f35618d;

    public IdentifierIdObserver(IdentifierIdClient identifierIdClient, int i2, String str) {
        super(null);
        this.f35618d = identifierIdClient;
        this.f35617c = i2;
        this.f35616b = str;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        IdentifierIdClient identifierIdClient = this.f35618d;
        if (identifierIdClient != null) {
            identifierIdClient.a(this.f35617c, this.f35616b);
        } else {
            Log.e(f35615a, "mIdentifierIdClient is null");
        }
    }
}
