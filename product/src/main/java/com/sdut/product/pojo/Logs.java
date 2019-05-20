package com.sdut.product.pojo;

import lombok.Data;

/**
 * @ClassName Log
 * @Discription
 * @Author YinYuchen
 * @Date 2019/5/20 15:50
 **/
@Data
public class Logs {
    private String id;
    private String userName;
    private String ip;
    private String role;
    private String time;
    private String content;
}
