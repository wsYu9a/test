package com.tencent.open;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.webkit.ConsoleMessage;
import android.webkit.WebChromeClient;
import com.tencent.open.a.f;

/* loaded from: classes4.dex */
public abstract class b extends Dialog {

    /* renamed from: a */
    protected a f25441a;

    /* renamed from: b */
    @SuppressLint({"NewApi"})
    protected final WebChromeClient f25442b;

    public b(Context context, int i2) {
        super(context, i2);
        this.f25442b = new WebChromeClient() { // from class: com.tencent.open.b.1
            AnonymousClass1() {
            }

            @Override // android.webkit.WebChromeClient
            public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
                if (consoleMessage == null) {
                    return false;
                }
                f.c("openSDK_LOG.JsDialog", "WebChromeClient onConsoleMessage" + consoleMessage.message() + " -- From  111 line " + consoleMessage.lineNumber() + " of " + consoleMessage.sourceId());
                if (Build.VERSION.SDK_INT <= 7) {
                    return true;
                }
                b.this.a(consoleMessage.message());
                return true;
            }

            @Override // android.webkit.WebChromeClient
            public void onConsoleMessage(String str, int i3, String str2) {
                f.c("openSDK_LOG.JsDialog", "WebChromeClient onConsoleMessage" + str + " -- From 222 line " + i3 + " of " + str2);
                if (Build.VERSION.SDK_INT == 7) {
                    b.this.a(str);
                }
            }
        };
    }

    protected abstract void a(String str);

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f25441a = new a();
    }

    /* renamed from: com.tencent.open.b$1 */
    class AnonymousClass1 extends WebChromeClient {
        AnonymousClass1() {
        }

        @Override // android.webkit.WebChromeClient
        public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
            if (consoleMessage == null) {
                return false;
            }
            f.c("openSDK_LOG.JsDialog", "WebChromeClient onConsoleMessage" + consoleMessage.message() + " -- From  111 line " + consoleMessage.lineNumber() + " of " + consoleMessage.sourceId());
            if (Build.VERSION.SDK_INT <= 7) {
                return true;
            }
            b.this.a(consoleMessage.message());
            return true;
        }

        @Override // android.webkit.WebChromeClient
        public void onConsoleMessage(String str, int i3, String str2) {
            f.c("openSDK_LOG.JsDialog", "WebChromeClient onConsoleMessage" + str + " -- From 222 line " + i3 + " of " + str2);
            if (Build.VERSION.SDK_INT == 7) {
                b.this.a(str);
            }
        }
    }
}
