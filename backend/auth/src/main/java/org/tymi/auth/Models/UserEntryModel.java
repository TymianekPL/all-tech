package org.tymi.auth.Models;

import jakarta.persistence.*;

import java.time.Instant;

@Entity
@Table(name = "userentry")
public class UserEntryModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "username")
	private String username;
	@Column(name = "displayName")
	private String displayName;
	@Column(name = "createdAt")
	private Instant createdAt;

	Long getId() {
		return id;
	}

	String getUsername() {
		return username;
	}
	void setUsername(String username) {
		this.username = username;
	}
	String getDisplayName() {
		return displayName;
	}
	void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	Instant getCreatedAt() {
		return this.createdAt;
	}
}
