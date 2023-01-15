package ryu.assign.database.model;

import java.sql.Timestamp;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
public class User2 {
    private String name;
    private String email;
    private String password;
}
