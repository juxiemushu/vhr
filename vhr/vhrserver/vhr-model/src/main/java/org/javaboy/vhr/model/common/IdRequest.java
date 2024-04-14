package org.javaboy.vhr.model.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class IdRequest implements Serializable {

    private static final long serialVersionUID = 5179343218291750455L;

    /**
     * 数据主键
     */
    private Long id;

}
