/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cc.altius.springflux.model;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Vivek Gajbhiye Altius Customer Service PVT. LTD.
 */
@Data
@NoArgsConstructor
public class ResponseFormat {

    private String status;
    private String failedReason;
    private int failedValue;
    private String parameter;
    /**
     * for print on console
     * @param statement 
     */
    public static void console(String statement){
        System.out.println(statement);
    }
    /**
     * for print exception on console
     * @param err 
     */
    public static void err(String err){
        System.err.println(err);
    }
}
