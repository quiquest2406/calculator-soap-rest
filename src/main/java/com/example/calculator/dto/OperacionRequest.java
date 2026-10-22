
package com.example.calculator.dto;

public class OperacionRequest {

    private Integer a;
    private Integer b;

    public Integer getA() {
        return a;
    }

    public void setA(Integer a) {
        this.a = a;
    }

    public Integer getB() {
        return b;
    }

    public void setB(Integer b) {
        this.b = b;
    }

	@Override
	public String toString() {
		return "OperacionRequest [a=" + a + ", b=" + b + "]";
	}
    
    
}
