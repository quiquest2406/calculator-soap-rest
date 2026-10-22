
package com.example.calculator.dto;

public class OperacionResponse {

    private int result;

    public OperacionResponse() {
    }

    public OperacionResponse(int result) {
        this.result = result;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

	@Override
	public String toString() {
		return "OperacionResponse [result=" + result + "]";
	}
    
}

