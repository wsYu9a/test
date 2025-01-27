package com.aggmoread.sdk.a.adcomm.amsdk;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.aggmoread.sdk.z.b.u.c;
import com.aggmoread.sdk.z.b.u.k;

/* loaded from: classes.dex */
public class AmCustomWebviewActivity extends Activity {
    private static c.a webViewStateListener = c.a.f5043a;
    private int DOWNLOAD_REQUEST_PERMISSION_CODE = 1001110;
    private boolean canSkip = true;
    private k webImpl;

    /* renamed from: com.aggmoread.sdk.a.adcomm.amsdk.AmCustomWebviewActivity$1 */
    public class AnonymousClass1 implements k.f {
        public AnonymousClass1() {
        }

        @Override // com.aggmoread.sdk.z.b.u.k.f
        public boolean canSkip() {
            AmCustomWebviewActivity.this.canSkip = false;
            return false;
        }

        @Override // com.aggmoread.sdk.z.b.u.k.f
        public void onClose() {
            AmCustomWebviewActivity.this.finish();
        }

        @Override // com.aggmoread.sdk.z.b.u.k.f
        public void onShow() {
            AmCustomWebviewActivity.webViewStateListener.onShow();
        }
    }

    private void initView() {
        setContentView(this.webImpl.a(this));
    }

    private void loadUrl() {
        k kVar = this.webImpl;
        if (kVar != null) {
            kVar.e();
        }
    }

    public static void setWebViewStateListener(c.a aVar) {
        if (aVar == null) {
            aVar = c.a.f5043a;
        }
        webViewStateListener = aVar;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 4 && this.canSkip) {
            return true;
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.webImpl = new k(this, getIntent().getStringExtra("title"), getIntent().getStringExtra("mClickUrl"), new k.f() { // from class: com.aggmoread.sdk.a.adcomm.amsdk.AmCustomWebviewActivity.1
            public AnonymousClass1() {
            }

            @Override // com.aggmoread.sdk.z.b.u.k.f
            public boolean canSkip() {
                AmCustomWebviewActivity.this.canSkip = false;
                return false;
            }

            @Override // com.aggmoread.sdk.z.b.u.k.f
            public void onClose() {
                AmCustomWebviewActivity.this.finish();
            }

            @Override // com.aggmoread.sdk.z.b.u.k.f
            public void onShow() {
                AmCustomWebviewActivity.webViewStateListener.onShow();
            }
        });
        initView();
        if (ContextCompat.checkSelfPermission(this, "android.permission.WRITE_EXTERNAL_STORAGE") != 0) {
            ActivityCompat.requestPermissions(this, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, this.DOWNLOAD_REQUEST_PERMISSION_CODE);
        } else {
            loadUrl();
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        k kVar = this.webImpl;
        if (kVar != null) {
            kVar.b();
        }
        super.onDestroy();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i10, KeyEvent keyEvent) {
        if (i10 == 4) {
            k kVar = this.webImpl;
            if (kVar != null && kVar.c()) {
                return true;
            }
            setResult(0, new Intent());
            finish();
        }
        return super.onKeyDown(i10, keyEvent);
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        k kVar = this.webImpl;
        if (kVar != null && kVar.c()) {
            return true;
        }
        setResult(0, new Intent());
        finish();
        return true;
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i10, String[] strArr, int[] iArr) {
        if (iArr.length <= 0 || i10 != this.DOWNLOAD_REQUEST_PERMISSION_CODE) {
            super.onRequestPermissionsResult(i10, strArr, iArr);
        } else if (iArr[0] == 0) {
            loadUrl();
        } else {
            finish();
            webViewStateListener.onShow();
        }
    }
}
