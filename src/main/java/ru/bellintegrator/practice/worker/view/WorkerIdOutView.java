package ru.bellintegrator.practice.worker.view;

public class WorkerIdOutView {
    /**
     * Employee id
     */
    private String id;

    /**
     * Constructor for Jackson
     */
    public WorkerIdOutView(){

    }

    /**
     * Constructor for Service
     * @param id Employee id
     */
    public WorkerIdOutView(String id){
        setId(id);
    }

    @Override
    public String toString() {
        return "{id:" + getId() + "}";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
