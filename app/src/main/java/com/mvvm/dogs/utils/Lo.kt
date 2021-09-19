package com.mvvm.dogs.utils

import android.util.Log
import com.mvvm.dogs.AppMain
import com.mvvm.dogs.R
import java.io.Serializable


class Lo(caller: Any, private var isShowLog: Boolean = true) : Serializable {
    private val tag: String = caller as? String ?: caller.javaClass.simpleName

    private val isLogAllowed = AppMain.logPermission && isShowLog

    private val fullTag: String
        get() = String.format(
            "%s %s",
            DEFAULT_TAG_PREFIX, tag
        )


    fun g(logString: String) {
        if (isLogAllowed) {
            Log.d(fullTag, String.format("%s", logString))
        }
    }

    fun ge(logString: String) {
        if (isLogAllowed) {
            Log.e(fullTag, String.format("%s", logString))
        }
    }

    fun g(logFormat: String, vararg args: Any) {
        if (isLogAllowed) {
            Log.d(fullTag, String.format(logFormat, *args))
        }
    }

    fun g(arg: Any) {
        if (isLogAllowed) {
            Log.d(fullTag, String.format("%s", arg))
        }
    }

    companion object {

        private val DEFAULT_TAG_PREFIX =
            AppMain.context.getString(R.string.app_name)
        private val DEFAULT_TAG = AppMain.context.getString(R.string.app_name)

        /**
         * Static log without tag
         */

        fun gg(logString: String?) {
            if (logString == null) {
                Log.d(DEFAULT_TAG, "null")
                return
            }
            Log.d(DEFAULT_TAG, logString)
        }

        fun gg(logFormat: String, vararg args: Any) {
            Log.d(DEFAULT_TAG, String.format(logFormat, *args))
        }

        fun gge(logFormat: String, vararg args: Any) {
            Log.e(DEFAULT_TAG, String.format(logFormat, *args))
        }


        fun gg(arg: Any?) {
            if (arg == null) {
                Log.d(DEFAULT_TAG, "null")
                return
            }
            Log.d(DEFAULT_TAG, arg.toString())
        }

        /**
         * Static log with tag
         */

        fun getFullTag(tag: String): String {
            return String.format(
                "%s %s",
                DEFAULT_TAG_PREFIX, tag
            )
        }

        fun gt(logTag: String, logString: String) {
            Log.d(getFullTag(logTag), logString)
        }

        fun gt(logTag: String, logFormat: String, vararg args: Any) {
            Log.d(getFullTag(logTag), String.format(logFormat, *args))
        }

        fun gt(logTag: String, arg: Any) {
            Log.d(getFullTag(logTag), String.format("%s", arg.toString()))
        }
    }
}