package org.javaboy.vhr.controller.housekeeper.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HousekeeperQueryRequest implements Serializable {

    private static final long serialVersionUID = -3254896982703977571L;

    private Long id;

}
