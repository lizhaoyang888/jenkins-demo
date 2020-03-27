package com.example.jenkinsdemo.bean;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @Author: lichaoyang
 * @Date: 2020-03-27 17:13
 */
@Data
public class ParaObj {

    @NotNull
    private int id;

    private String msg;
}
