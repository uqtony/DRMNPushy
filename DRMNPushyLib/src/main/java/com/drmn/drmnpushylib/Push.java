package com.drmn.drmnpushylib;

import android.content.Context;

import me.pushy.sdk.Pushy;
import me.pushy.sdk.util.exceptions.PushyException;

public class Push {
    public interface PushyCallback {
         void onNotification(String title, String text);
    }

    private static final Push _inst = new Push();

    private PushyCallback pushyCallback = null;

    public static String registerAndListen(Context context) {
        String token;
        try {
            token = Pushy.register(context);
            Pushy.listen(context);
        } catch (PushyException e) {
            return null;
        }
        return token;
    }
    public static void registerCallback(PushyCallback _pushyCallback){
        _inst.pushyCallback = _pushyCallback;
    }
    public static void _onNotification(String title, String text) {
        if (_inst.pushyCallback != null){
            _inst.pushyCallback.onNotification(title, text);
        }
    }

}// end Push
