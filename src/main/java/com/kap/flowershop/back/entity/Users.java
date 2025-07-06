package com.kap.flowershop.back.entity;

import com.kap.flowershop.back.entity_props.UserProperties;
import com.kap.flowershop.front.enums.Role;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement
@Entity
@Table(name = "users")
@TypeDefs({
		@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
})
public class Users implements Serializable {
	private static final long serialVersionUID = 436648180823422558L;

	@Id
	@GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "users_seq")
	@SequenceGenerator(name="users_seq", sequenceName="user_sequence")
	@Column(name = "userid")
	private Long userId;

	@Column(name = "username")
	private String userName;

	@Column(name = "password")
	private String password;

	@Enumerated(EnumType.STRING)
	@Column(name = "role")
	private Role role;

	@Column(name = "prop", columnDefinition = "jsonb")
	@Type(type = "jsonb")
	private UserProperties userProperties = new UserProperties();
}
