package com.oplus.quickgame.sdk.hall;

import com.oplus.quickgame.sdk.hall.feature.GameHallRouter;

/* loaded from: classes4.dex */
public class GameHall {

    /* renamed from: b */
    private static GameHall f16260b;

    /* renamed from: a */
    private GameHallRouter f16261a = new GameHallRouter();

    private GameHall() {
    }

    public static GameHall getInstance() {
        GameHall gameHall;
        synchronized (GameHall.class) {
            if (f16260b == null) {
                f16260b = new GameHall();
            }
            gameHall = f16260b;
        }
        return gameHall;
    }

    public GameHallRouter router() {
        return this.f16261a;
    }
}
