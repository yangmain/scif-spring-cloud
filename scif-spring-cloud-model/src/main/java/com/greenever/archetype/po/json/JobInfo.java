package com.greenever.archetype.po.json;

import lombok.Data;

/**
 * 工作信息
 *
 * @author Jimmy.Huang
 * @date 2020-04-29
 * @since v1.0.0
 */
@Data
public class JobInfo {
    /**
     * 工作的状态
     */
    private Short jobStatus;
    /**
     * 公司的名称
     */
    private String companyName;
    /**
     * 公司的地址
     */
    private String companyAddr;
    /**
     * 行业
     */
    private Short industry;

    /**
     * 职位
     */
    private Short position;

    /**
     * 工作年限
     */
    private Short workYear;

    /**
     * 上市状态  0 - 未上市  1 - 上市
     */
    private Short listedStatus;

}
