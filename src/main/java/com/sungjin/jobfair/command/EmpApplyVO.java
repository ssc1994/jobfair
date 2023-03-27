package com.sungjin.jobfair.command;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmpApplyVO {

    //지원 현황 리스트
    private String user_id;
    private String com_name;
    private String jpl_title;
    private String jpl_workPosition;
    private String al_state;  //열람, 미열람
    private String jpl_num;

}
