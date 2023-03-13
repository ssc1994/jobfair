package com.sungjin.jobfair.command;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class QnAVO {

    private int qa_num;
    private String user_id;
    private int com_num;
    private String qa_type;
    private String qa_title;
    private String qa_content;
    private Date qa_regDate;
}
