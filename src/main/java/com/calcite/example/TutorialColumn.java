package com.calcite.example;

import java.io.Serializable;

/**
 * @author zhangap
 * @version 1.0, 2021/1/22
 */
public class TutorialColumn implements Serializable {
    private static final long serialVersionUID = -2735793962139700695L;

    private final String name;
    private final String type;

    public TutorialColumn(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }


    public String getType() {
        return type;
    }

}
