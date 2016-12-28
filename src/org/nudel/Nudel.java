package org.nudel;

import org.nudel.args.ArgsParser;
import org.nudel.args.Options;

/**
 * Created by streifi on 28/12/16.
 */

public class Nudel {
    public static Options config;

    public static void main(String[] args){
         config = ArgsParser.parse(args);

    }
}
