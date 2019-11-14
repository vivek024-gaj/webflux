/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cc.altius.springflux.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Vivek Gajbhiye Altius Customer Service PVT. LTD.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String name;
    private String age;
}
