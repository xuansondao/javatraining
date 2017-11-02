package com.xuansondao.lab2;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ThrowableExample {
    private final static Logger LOGGER = Logger.getLogger(ThrowableExample.class.getName());

    static int toNumber(String value) throws SaiSoException {
        try {
            Integer integer = Integer.parseInt(value);
            return integer.intValue();
        } catch (NumberFormatException e) {
            throw new SaiSoException(value);
        }
    }

    public static void main(String[] args) {
        try {
            System.out.println("number = " + toNumber(args[0]));
        } catch (SaiSoException e) {
            //System.err.println(e.getMessage());
            LOGGER.log(Level.WARNING, e.getMessage());
        }
    }


}
