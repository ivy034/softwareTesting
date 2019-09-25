package com.ecnu.edu.st.utils;

import java.io.*;
import java.util.List;

public class CollectionsUtil {
    public static <T> List deepcopy(List<T> src) throws IOException, ClassNotFoundException {
        ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(byteOut);
        out.writeObject(src);

        ByteArrayInputStream byteIn = new ByteArrayInputStream(byteOut
                .toByteArray());
        ObjectInputStream in = new ObjectInputStream(byteIn);
        List<T> dest = (List<T>) in.readObject();
        return dest;
    }

    public final static void clearConsole(){
            System.out.print("\033[H\033[2J");
            System.out.flush();

    }
}
