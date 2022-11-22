package com.example.boluouitest2.slzhibo.library.service;

import android.app.IntentService;
import android.content.Intent;

import androidx.annotation.Nullable;

/* loaded from: classes2.dex */
public class TokenDialogService extends IntentService {
    public TokenDialogService() {
        super("TokenDialogService");
    }

    @Override // android.app.IntentService
    public void onHandleIntent(@Nullable Intent intent) {
        try {
            Thread.sleep(500L);
            sendBroadcast(new Intent("LIVE_TOKEN_INVALID_ACTION"));
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }
}
