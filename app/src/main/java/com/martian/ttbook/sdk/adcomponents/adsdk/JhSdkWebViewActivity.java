package com.martian.ttbook.sdk.adcomponents.adsdk;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.kuaishou.weapon.p0.g;
import com.martian.ttbook.b.a.q.a;
import com.martian.ttbook.b.a.q.h;

/* loaded from: classes4.dex */
public class JhSdkWebViewActivity extends Activity {
    private static a.InterfaceC0286a webViewStateListener = a.InterfaceC0286a.f15145a;
    private int DOWNLOAD_REQUEST_PERMISSION_CODE = 1001110;
    private boolean canSkip = true;
    private h webImpl;

    /* renamed from: com.martian.ttbook.sdk.adcomponents.adsdk.JhSdkWebViewActivity$1 */
    class AnonymousClass1 implements h.f {
        AnonymousClass1() {
        }

        @Override // com.martian.ttbook.b.a.q.h.f
        public boolean canSkip() {
            JhSdkWebViewActivity.this.canSkip = false;
            return false;
        }

        @Override // com.martian.ttbook.b.a.q.h.f
        public void onClose() {
            JhSdkWebViewActivity.this.finish();
        }

        @Override // com.martian.ttbook.b.a.q.h.f
        public void onShow() {
            JhSdkWebViewActivity.webViewStateListener.onShow();
        }
    }

    private void initView() {
        setContentView(this.webImpl.a(this));
    }

    private void loadUrl() {
        h hVar = this.webImpl;
        if (hVar != null) {
            hVar.o();
        }
    }

    public static void setWebViewStateListener(a.InterfaceC0286a interfaceC0286a) {
        if (interfaceC0286a == null) {
            interfaceC0286a = a.InterfaceC0286a.f15145a;
        }
        webViewStateListener = interfaceC0286a;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 4 && this.canSkip) {
            return true;
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.webImpl = new h(this, getIntent().getStringExtra("title"), getIntent().getStringExtra("mClickUrl"), new h.f() { // from class: com.martian.ttbook.sdk.adcomponents.adsdk.JhSdkWebViewActivity.1
            AnonymousClass1() {
            }

            @Override // com.martian.ttbook.b.a.q.h.f
            public boolean canSkip() {
                JhSdkWebViewActivity.this.canSkip = false;
                return false;
            }

            @Override // com.martian.ttbook.b.a.q.h.f
            public void onClose() {
                JhSdkWebViewActivity.this.finish();
            }

            @Override // com.martian.ttbook.b.a.q.h.f
            public void onShow() {
                JhSdkWebViewActivity.webViewStateListener.onShow();
            }
        });
        initView();
        if (ContextCompat.checkSelfPermission(this, g.f9325j) != 0) {
            ActivityCompat.requestPermissions(this, new String[]{g.f9325j}, this.DOWNLOAD_REQUEST_PERMISSION_CODE);
        } else {
            loadUrl();
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        h hVar = this.webImpl;
        if (hVar != null) {
            hVar.i();
        }
        super.onDestroy();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (i2 == 4) {
            h hVar = this.webImpl;
            if (hVar != null && hVar.k()) {
                return true;
            }
            setResult(0, new Intent());
            finish();
        }
        return super.onKeyDown(i2, keyEvent);
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        h hVar = this.webImpl;
        if (hVar != null && hVar.k()) {
            return true;
        }
        setResult(0, new Intent());
        finish();
        return true;
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        if (iArr.length <= 0 || i2 != this.DOWNLOAD_REQUEST_PERMISSION_CODE) {
            super.onRequestPermissionsResult(i2, strArr, iArr);
        } else if (iArr[0] == 0) {
            loadUrl();
        } else {
            finish();
            webViewStateListener.onShow();
        }
    }
}
