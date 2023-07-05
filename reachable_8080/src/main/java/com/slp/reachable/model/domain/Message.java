package com.slp.reachable.model.domain;

import com.baomidou.mybatisplus.annotation.TableField;

import java.io.Serializable;

public class Message implements Serializable {
    private String phoneNumber;
	private String message;
    private static final long serialVersionUID = 1L;
}