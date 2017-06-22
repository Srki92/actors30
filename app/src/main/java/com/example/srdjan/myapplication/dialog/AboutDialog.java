package com.example.srdjan.myapplication.dialog;


import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;



/**
 * Created by srdjan on 20.6.17..
 */

public class AboutDialog extends AlertDialog.Builder {

    public AboutDialog(Context context) {
        super(context);

        setTitle("About");
        setMessage("Srdjan Radosavljevic");
        setCancelable(false);

        setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.dismiss();

            }
        });

        setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.cancel();
            }
        });
    }

    public AlertDialog prepareDialog() {
        AlertDialog dialog = create();
        dialog.setCanceledOnTouchOutside(false);


        return dialog;
    }
}
