package com.example.a652k

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.provider.Settings
import android.telephony.TelephonyManager
import android.widget.Toast

class IntentCall : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {

        if (intent!!.getStringExtra(TelephonyManager.EXTRA_STATE) ==
            TelephonyManager.EXTRA_STATE_OFFHOOK
        ) {
            Toast.makeText(context, "Phone call...", Toast.LENGTH_LONG).show()
        } else if (intent.getStringExtra(TelephonyManager.EXTRA_STATE) ==
            TelephonyManager.EXTRA_STATE_IDLE
        ) {
            Toast.makeText(context, "Canceled...", Toast.LENGTH_LONG).show()

        }
        else if (intent.getStringExtra(TelephonyManager.EXTRA_STATE) ==
            TelephonyManager.EXTRA_STATE_RINGING
        ) {
            Toast.makeText(context, "Ringing...", Toast.LENGTH_LONG).show()

        }
    }


}