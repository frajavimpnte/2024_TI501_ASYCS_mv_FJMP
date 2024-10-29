package com.fjmp.domainBean;

import com.fjmp.pojo.ComplexNumber;
import jakarta.inject.Named;
import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import java.util.ArrayList;
import java.util.List;

@Named
public class ComplexNumberBean {
    private List<ComplexNumber> cn = new ArrayList<>();

    public ComplexNumberBean() {
        cn.add( new ComplexNumber(1,1) );
        cn.add( new ComplexNumber(1,-1) );
        cn.add( new ComplexNumber(-1,-1) );
        cn.add( new ComplexNumber(-1,1) );
    }

    public List<ComplexNumber> getCn() {
        return cn;
    }

    public void setCn(List<ComplexNumber> cn) {
        this.cn = cn;
    }
    
    public String toJsonb() {
        Jsonb jb = JsonbBuilder.create();
        return  jb.toJson(cn);
    }
}
