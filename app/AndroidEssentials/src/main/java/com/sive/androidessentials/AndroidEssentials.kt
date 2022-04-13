/**
 *
 * @author Isaac Sichangi Wanjala
 * isaacsichangi@gmail.com
 * version 1.0.0
 * AndroidEssentials is an an android library that creates helper functions for performing common tasks in Android
 * such as managing preferences, managing files, showing alerts, showing toasts, checking user country & checking network connection of users
 */

package com.sive.androidessentials

import android.content.Context
import android.content.SharedPreferences
import android.net.ConnectivityManager
import android.telephony.TelephonyManager
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Locale;


class AndroidEssentials {


    /**
     * @param context
     * @param app_name
     * @return void
     */
    companion object {
        fun clearValues(context: Context, app_name: String) {
            val sharedPreferences: SharedPreferences = context.getSharedPreferences(app_name, Context.MODE_PRIVATE)
            val editor = sharedPreferences.edit()
            editor.clear().apply()
        }


        /**
         * @param context
         * @param key
         * @param app_name
         * @return void
         */

        fun deleteValue(context: Context, key: String?, app_name: String) {
            val sharedPreferences: SharedPreferences = context.getSharedPreferences(app_name, Context.MODE_PRIVATE)
            val editor = sharedPreferences.edit()
            editor.remove(key).apply()
        }


        /**
         * @param context
         * @param key
         * @param value
         * @param app_name
         * @return void
         */

        fun storeValueString(context: Context, key: String?, value: String?, app_name: String) {
            val sharedPref: SharedPreferences = context.getSharedPreferences(app_name, 0)
            val editor = sharedPref.edit()
            editor.putString(key, value)
            editor.apply()
        }


        /**
         * @param context
         * @param key
         * @param value
         * @param app_name
         * @return void
         */
        fun storeValueDouble(context: Context, key: String?, value: Double, app_name: String) {
            val sharedPref: SharedPreferences = context.getSharedPreferences(app_name, Context.MODE_PRIVATE)
            val editor = sharedPref.edit()
            editor.putFloat(key, value.toFloat())
            editor.apply()
        }

        /**
         * @param context
         * @param key
         * @param value
         * @param app_name
         * @return void
         */
        fun storeValueInt(context: Context, key: String?, value: Int, app_name: String) {
            val sharedPref: SharedPreferences = context.getSharedPreferences(app_name, Context.MODE_PRIVATE)
            val editor = sharedPref.edit()
            editor.putInt(key, value)
            editor.apply()
        }

        /**
         * @param context
         * @param key
         * @param value
         * @param app_name
         * @return void
         */
        fun storeValueLong(context: Context, key: String?, value: Long, app_name: String) {
            val sharedPref: SharedPreferences = context.getSharedPreferences(app_name, Context.MODE_PRIVATE)
            val editor = sharedPref.edit()
            editor.putLong(key, value)
            editor.apply()
        }

        /**
         * @param context
         * @param key
         * @param value
         * @param app_name
         * @return void
         */
        fun storeValueBoolean(context: Context, key: String?, value: Boolean, app_name: String) {
            val sharedPref: SharedPreferences = context.getSharedPreferences(app_name, Context.MODE_PRIVATE)
            val editor = sharedPref.edit()
            editor.putBoolean(key, value)
            editor.apply()
        }

        /**
         * @param context
         * @param key
         * @param app_name
         * @return Boolean
         */
        fun getValueBoolean(context: Context, key: String?, app_name: String): Boolean {
            val sharedPref: SharedPreferences = context.getSharedPreferences(app_name, Context.MODE_PRIVATE)
            return sharedPref.getBoolean(key, true)
        }

        /**
         * @param context
         * @param key
         * @param app_name
         * @return Int
         */
        fun getValueInt(context: Context, key: String?, app_name: String): Int {
            val sharedPref: SharedPreferences = context.getSharedPreferences(app_name, Context.MODE_PRIVATE)
            return sharedPref.getInt(key, 0)
        }

        /**
         * @param context
         * @param key
         * @param app_name
         * @return Double
         */
        fun getValueDouble(context: Context, key: String?, app_name: String): Double {
            val sharedPref: SharedPreferences = context.getSharedPreferences(app_name, Context.MODE_PRIVATE)
            return sharedPref.getFloat(key, 0f).toDouble()
        }

        /**
         * @param context
         * @param key
         * @param app_name
         * @return Long
         */
        fun getValueLong(context: Context, key: String?, app_name: String): Long? {
            val sharedPref: SharedPreferences = context.getSharedPreferences(app_name, Context.MODE_PRIVATE)
            return sharedPref.getLong(key, 0)
        }

        /**
         * @param context
         * @param key
         * @param app_name
         * @return String
         */
        fun getValueString(context: Context, key: String?, app_name: String): String? {
            val sharedPref: SharedPreferences = context.getSharedPreferences(app_name, Context.MODE_PRIVATE)
            return sharedPref.getString(key, "none")
        }


        /**
         * @param context
         * @param msg
         * @return void
         */
        fun showToast(context: Context?, message: String?) {
            Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
        }


        /**
         * @param activity
         * @param message
         * @return void
         */
        fun showAlert(activity: AppCompatActivity, message: String?) {
            val alert: AlertDialog.Builder = AlertDialog.Builder(activity)
            val cancel_button_message = "cancel";
            alert.setMessage(message)
            alert.setNegativeButton(cancel_button_message, { dialog, which ->
                dialog.dismiss();
            }).show();
        }


        /**
         * @param context
         * @param filename
         * @return Boolean
         */
        fun checkFileExistence(context: Context, filename: String): Boolean {
            val file = File(context.getFilesDir(), filename.trim { it <= ' ' })
            return file.exists()
        }

        /**
         * @param title
         * @param context
         * @return void
         */
        fun deleteFile(title: String, context: Context) {
            val file = File(context.getFilesDir(), title.trim { it <= ' ' })
            if (file.exists()) {
                file.delete()
            }
        }

        /**
         * @param title
         * @param contents
         * @param context
         * @throws IOException
         * @return Boolean
         */
        fun storeFile(title: String, contents: String?, context: Context): Boolean {
            var fos: FileOutputStream? = null
            val file: File
            return try {
                file = File(context.getFilesDir(), title.trim { it <= ' ' })
                file.createNewFile()
                fos = context.openFileOutput(title.trim { it <= ' ' }, Context.MODE_PRIVATE)
                // Create buffered writer
                val writer = BufferedWriter(OutputStreamWriter(fos))
                writer.write(contents)
                writer.close()
                fos.close()
                true
            } catch (e: IOException) {
                false
            }
        }

        /**
         * @param filename
         * @param context
         * @throws IOException
         * @return String
         */
        fun getFileContents(filename: String, context: Context): String? {
            var input: BufferedReader? = null
            var text: String? = null
            try {
                input =
                    BufferedReader(InputStreamReader(context.openFileInput(filename.trim { it <= ' ' })))
                var line: String
                val buffer = StringBuffer()
                while (input.readLine().also { line = it } != null) {
                    buffer.append(
                        """
                    $line
                    
                    """.trimIndent()
                    )
                }
                text = buffer.toString()
                input.close()
            } catch (e: IOException) {
                text = "none"
            }
            return text
        }

        /**
         * @param context
         * @throws Exception
         * @return String
         */
        fun getUserCountry(context: Context): String? {
            try {
                val tm = context.getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
                val simCountry = tm.simCountryIso
                if (simCountry != null && simCountry.length == 2) { // SIM country code is available
                    return simCountry.uppercase(Locale.US)
                } else if (tm.phoneType != TelephonyManager.PHONE_TYPE_CDMA) { // device is not 3G (would be unreliable)
                    val networkCountry = tm.networkCountryIso
                    if (networkCountry != null && networkCountry.length == 2) { // network country code is available
                        return networkCountry.uppercase(Locale.US)
                    }
                }
            } catch (e: Exception) {
                return e.toString()
            }
            return "KE"
        }

        /**
         * @param context
         * @return Boolean
         */
        fun checkConnection(context: Context): Boolean {
            val connMgr =
                context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val activeNetworkInfo = connMgr.activeNetworkInfo
            return if (activeNetworkInfo != null) { // connected to the internet
                if (activeNetworkInfo.type == ConnectivityManager.TYPE_WIFI) {
                    // connected to wifi
                    true
                } else if (activeNetworkInfo.type == ConnectivityManager.TYPE_MOBILE) {
                    // connected to the mobile provider's data plan
                    true
                } else if (activeNetworkInfo.type == ConnectivityManager.TYPE_ETHERNET) {
                    // connected to the mobile provider's data plan
                    true
                } else if (activeNetworkInfo.type == ConnectivityManager.TYPE_WIMAX) {
                    // connected to the mobile provider's data plan
                    true
                } else if (activeNetworkInfo.type == ConnectivityManager.TYPE_VPN) {
                    // connected to the mobile provider's data plan
                    true
                } else {
                    true
                }
            } else false
        }
    }




}