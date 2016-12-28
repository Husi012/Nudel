package org.nudel.Commands;

/**
 * coded by Husi012 on 02.10.2016.
 */

import java.util.List;
import java.util.ArrayList;
import java.io.IOException;
import java.net.Socket;

public class Portchecker {
    protected int from = 1;
    protected int to = 65535;
    protected int port;
    protected String ip = "localhost";
    protected int checked;

    public int[] check(){
        check(from,to,ip);
    }

    public int[] check(int from,int to, String ip){
        List<Integer> ports = new ArrayList<Integer>();
        this.from = from;
        this.to = to;
        this.ip = ip;
        checked = 0;
        port = 0;
        for(int i=0; i<65535; i++){
            new Thread(new Runnable(){
                @Override
                public void run(){
                    int pt = port++;
                    try{
                        Socket sock = new Socket(ip, pt);
                        sock.close();
                        ports.add(pt);
                        checked ++;
                    }catch(IOException ioe){checked ++;}

                }
            }).start();
        }

        while(checked < to-from){}

        int[] p = new int[ports.size()];
        for(int i=0; i<p.length; i++){
            p[i] = ports.get(i);
        }
        return p;
    }
}
