package org.mapstruct.example.dto.list;

import lombok.Data;

import java.util.List;

/**
 * @Author: 苏小城
 * @Description:
 * @Date: Created in 18:48 2018/3/27
 */
@Data
public class Customer {

    private Long id;
    private String name;
    private List<OrderItem> orderItems;

}
