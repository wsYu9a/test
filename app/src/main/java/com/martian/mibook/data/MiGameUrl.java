package com.martian.mibook.data;

import android.text.TextUtils;
import java.util.List;
import java.util.Random;

/* loaded from: classes3.dex */
public class MiGameUrl {
    private boolean enabled = false;
    private List<MiApp> games;
    private String url;

    public List<MiApp> getGames() {
        return this.games;
    }

    public MiApp getRandomGame() {
        return this.games.get(new Random().nextInt(this.games.size()));
    }

    public String getUrl() {
        return this.url;
    }

    public boolean isEnabled() {
        return this.enabled;
    }

    public boolean isValid() {
        return this.enabled && !TextUtils.isEmpty(this.url);
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public void setGames(List<MiApp> games) {
        this.games = games;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
