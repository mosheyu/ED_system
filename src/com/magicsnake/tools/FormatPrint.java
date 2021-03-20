package com.magicsnake.tools;

public interface FormatPrint {
    public static void write(int i){
        switch (i){
            case 1:
                System.out.println("----------------------------------------------");
                break;
            case 2:
                System.out.println("==============================================");
        }

    }
}
