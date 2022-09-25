package ryu.assign.database.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;


@Data
@AllArgsConstructor
@Builder
@Entity
//@DynamicInsert
public class User {
		
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int id;
		
		@Column(nullable = false, length = 30, unique = true)
		@NotEmpty(groups = {ValidationGroups.groupA.class})
		private String username;
		
		@Column(nullable = false, length = 100)
		@NotBlank(groups = {ValidationGroups.groupA.class})
		private String password;
		
		@Column(nullable = false, length = 50)
		@Email(groups = {ValidationGroups.groupB.class})
		private String email;
		
		@ColumnDefault("USER")
		@Enumerated(EnumType.STRING)
		private RoleType role;
		
		@CreationTimestamp
		private Timestamp createDate;
		
		public User() {
			Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			createDate = timestamp;
		}
}
