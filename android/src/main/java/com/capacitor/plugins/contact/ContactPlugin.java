package com.capacitor.plugins.contact;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.provider.CallLog;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.getcapacitor.JSArray;
import com.getcapacitor.JSObject;
import com.getcapacitor.PermissionState;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;
import com.getcapacitor.annotation.PermissionCallback;

import java.util.ArrayList;
import java.util.List;

@CapacitorPlugin(name = "Contact")
public class ContactPlugin extends Plugin {
    private static final int PERMISSION_REQUEST_CODE = 1;

    private Contact implementation = new Contact();

    @PluginMethod
    public void echo(PluginCall call) {
        try {
            String value = "Echo method is working";

            JSObject ret = new JSObject();
            ret.put("value", value);
            call.resolve(ret);
        } catch (Exception e) {
            call.reject(e.toString());
        }
    }

    @PluginMethod
    public void getCallLogs(PluginCall call) {
        try {

            List<JSObject> callLogs = new ArrayList<>(); // Create a list to hold call log entries

            Cursor managedCursor = getActivity().managedQuery(CallLog.Calls.CONTENT_URI, null, null, null, null);
            while (managedCursor.moveToNext()) {
                @SuppressLint("Range") String number = managedCursor.getString(managedCursor.getColumnIndex(CallLog.Calls.NUMBER));
                @SuppressLint("Range") String type = managedCursor.getString(managedCursor.getColumnIndex(CallLog.Calls.TYPE));
                @SuppressLint("Range") String date = managedCursor.getString(managedCursor.getColumnIndex(CallLog.Calls.DATE));
                @SuppressLint("Range") String duration = managedCursor.getString(managedCursor.getColumnIndex(CallLog.Calls.DURATION));

                JSObject callLogEntry = new JSObject();
                callLogEntry.put("number", number);
                callLogEntry.put("type", type);
                callLogEntry.put("date", date);
                callLogEntry.put("duration", duration);

                callLogs.add(callLogEntry);
            }

            JSArray callLogsArray = new JSArray(callLogs); // Convert the list to a JSArray

            JSObject ret = new JSObject();
            ret.put("value", callLogsArray);

            call.resolve(ret);
        } catch (Exception e) {
            call.reject(e.toString());
        }
    }

    @PluginMethod
    public void requestPermission(PluginCall call) {
        try {
            if (ContextCompat.checkSelfPermission(getContext(), Manifest.permission.READ_CALL_LOG)
                    != PackageManager.PERMISSION_GRANTED ||
                    ContextCompat.checkSelfPermission(getContext(), Manifest.permission.WRITE_CALL_LOG)
                            != PackageManager.PERMISSION_GRANTED) {

                ActivityCompat.requestPermissions(getActivity(),
                        new String[]{Manifest.permission.READ_CALL_LOG, Manifest.permission.WRITE_CALL_LOG},
                        PERMISSION_REQUEST_CODE);
            } else {
                // Permission is already granted
                // You can call the function to read and write call logs here
                // For example: readWriteCallLogs();
                String value = "Permission Already Granted";
                JSObject ret = new JSObject();
                ret.put("value", value);
                call.resolve(ret);
            }
        } catch (Exception e) {
            call.reject(e.toString());
        }
    }

    @PermissionCallback
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == PERMISSION_REQUEST_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Permission granted
                // You can call the function to read and write call logs here
                // For example: readWriteCallLogs();
            } else {
                // Permission denied
                // Handle denied permission case, show a message or take appropriate action
            }
        }
    }

}
