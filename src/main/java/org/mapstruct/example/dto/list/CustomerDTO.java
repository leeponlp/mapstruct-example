package org.mapstruct.example.dto.list;

import lombok.Data;

import java.util.List;

/**
 * @Author: 苏小城
 * @Description:
 * @Date: Created in 18:49 2018/3/27
 */
@Data
public class CustomerDTO {

    public Long id;
    public String customerName;
    public List<OrderItemDTO> orderItemDTOs;
}
