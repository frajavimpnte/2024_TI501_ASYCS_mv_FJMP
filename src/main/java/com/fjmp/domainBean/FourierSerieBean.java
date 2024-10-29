package com.fjmp.domainBean;

import com.fjmp.pojo.ComplexNumber;
import jakarta.inject.Named;
import java.util.ArrayList;
import java.util.List;


@Named
public class FourierSerieBean {
    private String name = "Serie cuadrada";
    private List<ComplexNumber> data = new ArrayList<>();

    public FourierSerieBean() {
        name = "Serie cuadrada";
        data.add(new ComplexNumber(1,1));
        data.add(new ComplexNumber(-1,1));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ComplexNumber> getData() {
        return data;
    }

    public void setData(List<ComplexNumber> data) {
        this.data = data;
    }

    
}
