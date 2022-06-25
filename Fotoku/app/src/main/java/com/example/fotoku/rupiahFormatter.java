package com.example.fotoku;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class rupiahFormatter {
    public static String FormatIdr (double num) {
        DecimalFormat decFormat = (DecimalFormat) DecimalFormat.getCurrencyInstance();
        DecimalFormatSymbols idrFormat = new DecimalFormatSymbols();

        idrFormat.setCurrency("Rp. ");
        idrFormat.setMonetaryDecimalSeparator(",");
        idrFormat.setGroupingSeparator(",");

        decFormat.setDecimalFormatSymbols(idrFormat);

        return decFormat.format(num);
    }
}
