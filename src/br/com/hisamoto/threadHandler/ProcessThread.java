package br.com.hisamoto.threadHandler;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

/**
 * @author Leandro Shindi
 * @version 1.0 12/08/15.
 */
public class ProcessThread extends Thread {

    private Handler handler;
    private boolean process;

    public ProcessThread(Handler handler) {

        this.handler = handler;
        this.process = true;
    }

    @Override
    public void run() {

        while (process) {

            Message msg = new Message();
            msg.what = 1;
            Bundle bundle = new Bundle();
            bundle.putString("nome", "Leandro");
            msg.setData(bundle);

            handler.sendMessage(msg);

            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void setProcess(boolean process) {

        this.process = process;
    }
}
