package com.freesoft.wssintegration.model.response.login;

import com.freesoft.wssintegration.utils.CustomJsonSerializable;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@ToString
@Setter(AccessLevel.PROTECTED)
public class UserDto extends CustomJsonSerializable {

    private String code;
    private Integer status;
    private String name;
    private String grp;
    private String pwd;
    private Integer pgl;
    private String ipa;
    private String lsi;
    private Integer lec;
    private Integer cst;
    private Long mxs;
    private Boolean flts;
    private String lst;
    private String com;
    private String efc;
    private String lpc;
    private String sid;
    private String prf;
    private String ref;
    private Integer uty;
    private String uti;
    private String uui;
    private String uws;
    private Integer role;
    private Boolean ckpn;
    private String pin;
    private String pet;
    private String pnet;
    private Integer hec;
    private Integer pnec;
    private Integer pec;
    private Boolean dropcpy;
}
