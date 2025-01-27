package androidx.core.net;

import android.net.Uri;
import androidx.annotation.NonNull;
import m5.d;

/* loaded from: classes.dex */
public final class UriCompat {
    private UriCompat() {
    }

    @NonNull
    public static String toSafeString(@NonNull Uri uri) {
        String scheme = uri.getScheme();
        String schemeSpecificPart = uri.getSchemeSpecificPart();
        if (scheme != null) {
            if (scheme.equalsIgnoreCase("tel") || scheme.equalsIgnoreCase("sip") || scheme.equalsIgnoreCase("sms") || scheme.equalsIgnoreCase("smsto") || scheme.equalsIgnoreCase("mailto") || scheme.equalsIgnoreCase("nfc")) {
                StringBuilder sb2 = new StringBuilder(64);
                sb2.append(scheme);
                sb2.append(d.f28378d);
                if (schemeSpecificPart != null) {
                    for (int i10 = 0; i10 < schemeSpecificPart.length(); i10++) {
                        char charAt = schemeSpecificPart.charAt(i10);
                        if (charAt == '-' || charAt == '@' || charAt == '.') {
                            sb2.append(charAt);
                        } else {
                            sb2.append('x');
                        }
                    }
                }
                return sb2.toString();
            }
            if (scheme.equalsIgnoreCase("http") || scheme.equalsIgnoreCase("https") || scheme.equalsIgnoreCase("ftp") || scheme.equalsIgnoreCase("rtsp")) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("//");
                sb3.append(uri.getHost() != null ? uri.getHost() : "");
                sb3.append(uri.getPort() != -1 ? ":" + uri.getPort() : "");
                sb3.append("/...");
                schemeSpecificPart = sb3.toString();
            }
        }
        StringBuilder sb4 = new StringBuilder(64);
        if (scheme != null) {
            sb4.append(scheme);
            sb4.append(d.f28378d);
        }
        if (schemeSpecificPart != null) {
            sb4.append(schemeSpecificPart);
        }
        return sb4.toString();
    }
}
