package com.sungjin.jobfair.command;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MenuVO {

    private String menu_id;
    private String menu_name;
    private String menu_URL;
    private String menu_upperId;
    private String menu_auth;
    private String menu_order;

}
