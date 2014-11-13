/*******************************************************************************
 * Copyright (c) ${YEAR} $today.year.Dannis Zhang.All rights reserved.
 * All copyrights of this source code belongs to Dannis Zhang.
 * Anyone is free to use,modify and redistribute this source code,but must
 * in compliance with this Licence.You must attach this License to your
 * distribution,and you can add other Licenses(open source or trade) when
 * redistributing this source code.
 ******************************************************************************/

package com.dannis.wms.test;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Author: Dannis
 * Date: 2014-01-02
 * Time: 23:19
 */
public class Test {
    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\deng.zhang\\Desktop\\coordinate1113.txt");
        BufferedReader reader = new BufferedReader(new FileReader(file));
        List<String> lines = new ArrayList<String>();
        String line;
        while ((line = reader.readLine()) != null) {
            String[] temp = line.replace(" ","").split(",");
            double d1 = Double.valueOf(temp[4]) - 162661.237;
            double d2 = Double.valueOf(temp[5]) - 2382010.655;
            double d3 = Double.valueOf(temp[6]);
            if (d1 > 0 && d1 < 27563.0024 && d2 < 34574.1583 && d2 > 0) {
                lines.add(d1 + " " + d2 + " " + d3);
            }
        }
        reader.close();
        File f2 = new File("C:\\Users\\deng.zhang\\Desktop\\output.txt");
        if (!f2.exists()) {
            f2.createNewFile();
        }
        BufferedWriter writer = new BufferedWriter(new FileWriter(f2));
        for (String s : lines) {
            writer.write(s);
            writer.newLine();
        }
        writer.flush();
        writer.close();
    }
}
