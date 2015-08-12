package br.com.hisamoto.threadHandler;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;

public class MyActivity extends Activity {

    private int contProcess;
    private static ProcessThread processThread;

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {

            callbackThread(msg);
        }
    };

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        contProcess = 1;

        processThread = new ProcessThread(handler);
        processThread.start();

        Toast.makeText(getApplicationContext(), "Não parou a aplicação. Thread UI firme e forte", Toast.LENGTH_LONG).show();
    }

    public void callbackThread(Message m) {

        Toast.makeText(getApplicationContext(), "Nome[" + contProcess + "]: " + m.getData().get("nome"),Toast.LENGTH_LONG).show();
        contProcess++;

        if(contProcess == 5) {

            Toast.makeText(getApplicationContext(), "Parando processo",Toast.LENGTH_LONG).show();
            processThread.setProcess(false);
        }


    }
}
