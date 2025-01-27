package androidx.core.hardware.fingerprint;

import android.content.Context;
import android.hardware.fingerprint.FingerprintManager;
import android.os.Build;
import android.os.Handler;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RequiresPermission;
import androidx.core.os.CancellationSignal;
import java.security.Signature;
import javax.crypto.Cipher;
import javax.crypto.Mac;

@Deprecated
/* loaded from: classes.dex */
public class FingerprintManagerCompat {

    /* renamed from: a */
    private final Context f1806a;

    /* renamed from: androidx.core.hardware.fingerprint.FingerprintManagerCompat$1 */
    class AnonymousClass1 extends FingerprintManager.AuthenticationCallback {
        AnonymousClass1() {
        }

        @Override // android.hardware.fingerprint.FingerprintManager.AuthenticationCallback
        public void onAuthenticationError(int i2, CharSequence charSequence) {
            AuthenticationCallback.this.onAuthenticationError(i2, charSequence);
        }

        @Override // android.hardware.fingerprint.FingerprintManager.AuthenticationCallback
        public void onAuthenticationFailed() {
            AuthenticationCallback.this.onAuthenticationFailed();
        }

        @Override // android.hardware.fingerprint.FingerprintManager.AuthenticationCallback
        public void onAuthenticationHelp(int i2, CharSequence charSequence) {
            AuthenticationCallback.this.onAuthenticationHelp(i2, charSequence);
        }

        @Override // android.hardware.fingerprint.FingerprintManager.AuthenticationCallback
        public void onAuthenticationSucceeded(FingerprintManager.AuthenticationResult authenticationResult) {
            AuthenticationCallback.this.onAuthenticationSucceeded(new AuthenticationResult(FingerprintManagerCompat.b(authenticationResult.getCryptoObject())));
        }
    }

    public static abstract class AuthenticationCallback {
        public void onAuthenticationError(int i2, CharSequence charSequence) {
        }

        public void onAuthenticationFailed() {
        }

        public void onAuthenticationHelp(int i2, CharSequence charSequence) {
        }

        public void onAuthenticationSucceeded(AuthenticationResult authenticationResult) {
        }
    }

    public static final class AuthenticationResult {

        /* renamed from: a */
        private final CryptoObject f1808a;

        public AuthenticationResult(CryptoObject cryptoObject) {
            this.f1808a = cryptoObject;
        }

        public CryptoObject getCryptoObject() {
            return this.f1808a;
        }
    }

    private FingerprintManagerCompat(Context context) {
        this.f1806a = context;
    }

    @Nullable
    @RequiresApi(23)
    private static FingerprintManager a(@NonNull Context context) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 == 23) {
            return (FingerprintManager) context.getSystemService(FingerprintManager.class);
        }
        if (i2 <= 23 || !context.getPackageManager().hasSystemFeature("android.hardware.fingerprint")) {
            return null;
        }
        return (FingerprintManager) context.getSystemService(FingerprintManager.class);
    }

    @RequiresApi(23)
    static CryptoObject b(FingerprintManager.CryptoObject cryptoObject) {
        if (cryptoObject == null) {
            return null;
        }
        if (cryptoObject.getCipher() != null) {
            return new CryptoObject(cryptoObject.getCipher());
        }
        if (cryptoObject.getSignature() != null) {
            return new CryptoObject(cryptoObject.getSignature());
        }
        if (cryptoObject.getMac() != null) {
            return new CryptoObject(cryptoObject.getMac());
        }
        return null;
    }

    @RequiresApi(23)
    private static FingerprintManager.AuthenticationCallback c(AuthenticationCallback authenticationCallback) {
        return new FingerprintManager.AuthenticationCallback() { // from class: androidx.core.hardware.fingerprint.FingerprintManagerCompat.1
            AnonymousClass1() {
            }

            @Override // android.hardware.fingerprint.FingerprintManager.AuthenticationCallback
            public void onAuthenticationError(int i2, CharSequence charSequence) {
                AuthenticationCallback.this.onAuthenticationError(i2, charSequence);
            }

            @Override // android.hardware.fingerprint.FingerprintManager.AuthenticationCallback
            public void onAuthenticationFailed() {
                AuthenticationCallback.this.onAuthenticationFailed();
            }

            @Override // android.hardware.fingerprint.FingerprintManager.AuthenticationCallback
            public void onAuthenticationHelp(int i2, CharSequence charSequence) {
                AuthenticationCallback.this.onAuthenticationHelp(i2, charSequence);
            }

            @Override // android.hardware.fingerprint.FingerprintManager.AuthenticationCallback
            public void onAuthenticationSucceeded(FingerprintManager.AuthenticationResult authenticationResult) {
                AuthenticationCallback.this.onAuthenticationSucceeded(new AuthenticationResult(FingerprintManagerCompat.b(authenticationResult.getCryptoObject())));
            }
        };
    }

    @RequiresApi(23)
    private static FingerprintManager.CryptoObject d(CryptoObject cryptoObject) {
        if (cryptoObject == null) {
            return null;
        }
        if (cryptoObject.getCipher() != null) {
            return new FingerprintManager.CryptoObject(cryptoObject.getCipher());
        }
        if (cryptoObject.getSignature() != null) {
            return new FingerprintManager.CryptoObject(cryptoObject.getSignature());
        }
        if (cryptoObject.getMac() != null) {
            return new FingerprintManager.CryptoObject(cryptoObject.getMac());
        }
        return null;
    }

    @NonNull
    public static FingerprintManagerCompat from(@NonNull Context context) {
        return new FingerprintManagerCompat(context);
    }

    @RequiresPermission("android.permission.USE_FINGERPRINT")
    public void authenticate(@Nullable CryptoObject cryptoObject, int i2, @Nullable CancellationSignal cancellationSignal, @NonNull AuthenticationCallback authenticationCallback, @Nullable Handler handler) {
        FingerprintManager a2;
        if (Build.VERSION.SDK_INT < 23 || (a2 = a(this.f1806a)) == null) {
            return;
        }
        a2.authenticate(d(cryptoObject), cancellationSignal != null ? (android.os.CancellationSignal) cancellationSignal.getCancellationSignalObject() : null, i2, c(authenticationCallback), handler);
    }

    @RequiresPermission("android.permission.USE_FINGERPRINT")
    public boolean hasEnrolledFingerprints() {
        FingerprintManager a2;
        return Build.VERSION.SDK_INT >= 23 && (a2 = a(this.f1806a)) != null && a2.hasEnrolledFingerprints();
    }

    @RequiresPermission("android.permission.USE_FINGERPRINT")
    public boolean isHardwareDetected() {
        FingerprintManager a2;
        return Build.VERSION.SDK_INT >= 23 && (a2 = a(this.f1806a)) != null && a2.isHardwareDetected();
    }

    public static class CryptoObject {

        /* renamed from: a */
        private final Signature f1809a;

        /* renamed from: b */
        private final Cipher f1810b;

        /* renamed from: c */
        private final Mac f1811c;

        public CryptoObject(@NonNull Signature signature) {
            this.f1809a = signature;
            this.f1810b = null;
            this.f1811c = null;
        }

        @Nullable
        public Cipher getCipher() {
            return this.f1810b;
        }

        @Nullable
        public Mac getMac() {
            return this.f1811c;
        }

        @Nullable
        public Signature getSignature() {
            return this.f1809a;
        }

        public CryptoObject(@NonNull Cipher cipher) {
            this.f1810b = cipher;
            this.f1809a = null;
            this.f1811c = null;
        }

        public CryptoObject(@NonNull Mac mac) {
            this.f1811c = mac;
            this.f1810b = null;
            this.f1809a = null;
        }
    }
}
