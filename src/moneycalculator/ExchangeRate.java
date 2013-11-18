/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package moneycalculator;

import java.util.Date;

/**
 *
 * @author Diego
 */
public class ExchangeRate {

    private Date date;
    private Currency from;
    private Currency to;
    private Number rate;

    public ExchangeRate(Date date, Currency from, Currency to, Number rate) {
        this.date = date;
        this.from = from;
        this.to = to;
        this.rate = rate;
    }
    
    
}
