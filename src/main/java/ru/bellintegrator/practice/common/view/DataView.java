package ru.bellintegrator.practice.common.view;

public class DataView {

    private Object data;

    /**
     * Constructor for Jackson
     */
    public DataView(){

    }


    public DataView(Object data){
        setData(data);
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
