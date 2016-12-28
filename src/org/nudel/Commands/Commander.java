package org.nudel.Commands;

/**
 * coded by Husi012 on 28.12.2016.
 */

import java.util.List;
import java.util.ArrayList;
import java.net.Socket;
import java.io.IOException;


public class Commander {

    String[] command;

    public Commander(String[] args){
        command = args;
    }

    public int exec(){
        int exitCode = 0;

        String lastArg = command[command.length-1];
        if(lastArg.equals("/?")
        || lastArg.equals("-?")
        || lastArg.equals("/help")
        || lastArg.equals("-help")){
            String help;
            switch(command[0]){ //help things
                case "echo":
                        help = "It'll print the given text";
                    break;
                case "portcheck":
                        help = "Print all opened ports of the given range on an ip:\n1.Argument = from\n2.Argument = to\n3.Argument = ip";
                    break;
            }
        }

        try {
            switch (command[0]) {
                case "echo":
                        echo(command[1]);
                    break;

                case "portcheck":
                        portcheck(toInt(command[1]),toInt(command[2]),command[3]);
                    break;
            }
        } catch(RuntimeException e){
            //Todo: Print Error: "To few Arguments"
        }

        return exitCode;
    }




    private int toInt(String str){
        return Integer.parseInt(str);
    }

    //All Functions
    private void echo(String str){
        
    }

    private void portcheck(int from, int to, String ip) {
        echo("Checking, please wait...");
        int[] openedPorts = new Portchecker().check(from,to,ip);
        if(openedPorts.length > 0)
            echo("Didn't found opened ports.");
        else{
            echo("Found the following ports:");
            for(int i=0; i<openedPorts.length; i++){
                echo(Integer.toString(openedPorts[i]));
            }
        }

    }
}
