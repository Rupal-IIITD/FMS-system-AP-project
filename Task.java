package com.company;

public class Task {
    int task_id;
    String task_name;
    String supervisor;
    String task_despription;
    String equipment;
    String status;
    String deadline;

    public Task(int task_id, String task_name, String supervisor, String task_despription, String equipment, String status, String deadline) {
        this.task_id = task_id;
        this.task_name = task_name;
        this.supervisor = supervisor;
        this.task_despription = task_despription;
        this.equipment = equipment;
        this.status = status;
        this.deadline = deadline;
    }

    public int getTask_id() {
        return task_id;
    }

    public void setTask_id(int task_id) {
        this.task_id = task_id;
    }

    public String getTask_name() {
        return task_name;
    }

    public void setTask_name(String task_name) {
        this.task_name = task_name;
    }

    public String getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(String supervisor) {
        this.supervisor = supervisor;
    }

    public String getTask_despription() {
        return task_despription;
    }

    public void setTask_despription(String task_despription) {
        this.task_despription = task_despription;
    }

    public String getEquipment() {
        return equipment;
    }

    public void setEquipment(String equipment) {
        this.equipment = equipment;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }
}
