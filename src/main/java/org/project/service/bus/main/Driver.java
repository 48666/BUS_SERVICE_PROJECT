package org.project.service.bus.main;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Driver {
    @Id
    @GeneratedValue
    private int driver_id;

    @Column(nullable = false)
    private String driver_name;

    @Column(nullable = false)
    private String driver_last_name;

    @Column(nullable = false)
    private Long driver_number;

    public Driver() {
    }

    public Driver(String driver_name, String driver_last_name, Long driver_number) {
        this.driver_name = driver_name;
        this.driver_last_name = driver_last_name;
        this.driver_number = driver_number;
    }

    public int getDriver_id() {
        return driver_id;
    }

    public void setDriver_id(int driver_id) {
        this.driver_id = driver_id;
    }

    public String getDriver_name() {
        return driver_name;
    }

    public void setDriver_name(String driver_name) {
        this.driver_name = driver_name;
    }

    public String getDriver_last_name() {
        return driver_last_name;
    }

    public void setDriver_last_name(String driver_last_name) {
        this.driver_last_name = driver_last_name;
    }

    public Long getDriver_number() {
        return driver_number;
    }

    public void setDriver_number(Long driver_number) {
        this.driver_number = driver_number;
    }

    @Override
    public String toString() {
        return "Driver{" +
                "driver_id=" + driver_id +
                ", driver_name='" + driver_name + '\'' +
                ", driver_last_name='" + driver_last_name + '\'' +
                ", driver_number='" + driver_number + '\'' +
                '}';
    }


}
