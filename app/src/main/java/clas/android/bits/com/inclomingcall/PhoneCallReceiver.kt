package clas.android.bits.com.inclomingcall

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Context.TELEPHONY_SERVICE
import android.content.Intent
import android.content.SharedPreferences
import android.telephony.PhoneStateListener
import android.telephony.TelephonyManager
import android.util.Log
import android.widget.Toast


class PhoneCallReceiver : BroadcastReceiver() {

    public var context: Context ?= null;
    private lateinit var sharedPreferences: SharedPreferences

    override fun onReceive(context: Context?, intent: Intent?) {
        this.context = context;

        /*val telephoneManager = context?.getSystemService(TELEPHONY_SERVICE) as TelephonyManager?
        var phoneStateListener = LocalPhoneStateListener();
        telephoneManager?.listen(phoneStateListener, PhoneStateListener.LISTEN_CALL_STATE);*/

        val state = intent?.getStringExtra(TelephonyManager.EXTRA_STATE);
        val incomingNumber = intent?.getStringExtra(TelephonyManager.EXTRA_INCOMING_NUMBER)

        if(state.equals(TelephonyManager.EXTRA_STATE_RINGING)){
            Log.d("PhoneCallReceiver", "phone_number = " + incomingNumber);
            Toast.makeText(context, "Received call from number " + incomingNumber, Toast.LENGTH_LONG);
        }
    }

    inner class LocalPhoneStateListener : PhoneStateListener() {

        override fun onCallStateChanged(state: Int, phoneNumber: String?) {

            Toast.makeText(context, "Incoming Call Number = " + phoneNumber, Toast.LENGTH_LONG);
            Log.d("PhoneCallReceiver", "Incoming Call Number = " + phoneNumber);

            when(state) {
                TelephonyManager.CALL_STATE_IDLE -> {

                }
                TelephonyManager.CALL_STATE_OFFHOOK -> {

                }
                TelephonyManager.CALL_STATE_RINGING -> {
                    // Phone is ringing
                }
            }
        }

    }

}